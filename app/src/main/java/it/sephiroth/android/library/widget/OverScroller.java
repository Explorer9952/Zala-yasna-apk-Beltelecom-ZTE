package it.sephiroth.android.library.widget;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.video.androidsdk.log.LogEx;

/* loaded from: classes2.dex */
public class OverScroller {
    private static final int DEFAULT_DURATION = 250;
    private static final int FLING_MODE = 1;
    private static final int SCROLL_MODE = 0;
    private static float sViscousFluidNormalize = 1.0f / viscousFluid(1.0f);
    private static float sViscousFluidScale = 8.0f;
    private final boolean mFlywheel;
    private Interpolator mInterpolator;
    private int mMode;
    private final SplineOverScroller mScrollerX;
    private final SplineOverScroller mScrollerY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class SplineOverScroller {
        private static final int BALLISTIC = 2;
        private static final int CUBIC = 1;
        private static final float END_TENSION = 1.0f;
        private static final float GRAVITY = 2000.0f;
        private static final float INFLEXION = 0.35f;
        private static final int NB_SAMPLES = 100;
        private static final float P1 = 0.175f;
        private static final float P2 = 0.35000002f;
        private static final int SPLINE = 0;
        private static final float START_TENSION = 0.5f;
        private float mCurrVelocity;
        private int mCurrentPosition;
        private float mDeceleration;
        private int mDuration;
        private int mFinal;
        private int mOver;
        private float mPhysicalCoeff;
        private int mSplineDistance;
        private int mSplineDuration;
        private int mStart;
        private long mStartTime;
        private int mVelocity;
        private static float DECELERATION_RATE = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] SPLINE_POSITION = new float[101];
        private static final float[] SPLINE_TIME = new float[101];
        private float mFlingFriction = ViewConfiguration.getScrollFriction();
        private int mState = 0;
        private boolean mFinished = true;

        static {
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11 = 0.0f;
            float f12 = 0.0f;
            for (int i = 0; i < 100; i++) {
                float f13 = i / 100.0f;
                float f14 = END_TENSION;
                while (true) {
                    f = 2.0f;
                    f2 = ((f14 - f11) / 2.0f) + f11;
                    f3 = 3.0f;
                    f4 = END_TENSION - f2;
                    f5 = f2 * 3.0f * f4;
                    f6 = f2 * f2 * f2;
                    float f15 = (((f4 * P1) + (f2 * P2)) * f5) + f6;
                    if (Math.abs(f15 - f13) < 1.0E-5d) {
                        break;
                    } else if (f15 > f13) {
                        f14 = f2;
                    } else {
                        f11 = f2;
                    }
                }
                SPLINE_POSITION[i] = (f5 * ((f4 * START_TENSION) + f2)) + f6;
                float f16 = END_TENSION;
                while (true) {
                    f7 = ((f16 - f12) / f) + f12;
                    f8 = END_TENSION - f7;
                    f9 = f7 * f3 * f8;
                    f10 = f7 * f7 * f7;
                    float f17 = (((f8 * START_TENSION) + f7) * f9) + f10;
                    if (Math.abs(f17 - f13) < 1.0E-5d) {
                        break;
                    }
                    if (f17 > f13) {
                        f16 = f7;
                    } else {
                        f12 = f7;
                    }
                    f = 2.0f;
                    f3 = 3.0f;
                }
                SPLINE_TIME[i] = (f9 * ((f8 * P1) + (f7 * P2))) + f10;
            }
            float[] fArr = SPLINE_POSITION;
            SPLINE_TIME[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        SplineOverScroller(Context context) {
            this.mPhysicalCoeff = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        private void adjustDuration(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (abs * 100.0f);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                int i5 = i4 + 1;
                float[] fArr = SPLINE_TIME;
                float f2 = fArr[i4];
                this.mDuration = (int) (this.mDuration * (f2 + (((abs - f) / ((i5 / 100.0f) - f)) * (fArr[i5] - f2))));
            }
        }

        private void fitOnBounceCurve(int i, int i2, int i3) {
            float f = this.mDeceleration;
            float f2 = (-i3) / f;
            double abs = (((i3 * i3) / 2.0f) / Math.abs(f)) + Math.abs(i2 - i);
            Double.isNaN(abs);
            double abs2 = Math.abs(this.mDeceleration);
            Double.isNaN(abs2);
            float sqrt = (float) Math.sqrt((abs * 2.0d) / abs2);
            this.mStartTime -= (int) ((sqrt - f2) * 1000.0f);
            this.mStart = i2;
            this.mVelocity = (int) ((-this.mDeceleration) * sqrt);
        }

        private static float getDeceleration(int i) {
            if (i > 0) {
                return -2000.0f;
            }
            return GRAVITY;
        }

        private double getSplineDeceleration(int i) {
            return Math.log((Math.abs(i) * INFLEXION) / (this.mFlingFriction * this.mPhysicalCoeff));
        }

        private double getSplineFlingDistance(int i) {
            double splineDeceleration = getSplineDeceleration(i);
            float f = DECELERATION_RATE;
            double d2 = f;
            Double.isNaN(d2);
            double d3 = this.mFlingFriction * this.mPhysicalCoeff;
            double d4 = f;
            Double.isNaN(d4);
            double exp = Math.exp((d4 / (d2 - 1.0d)) * splineDeceleration);
            Double.isNaN(d3);
            return d3 * exp;
        }

        private int getSplineFlingDuration(int i) {
            double splineDeceleration = getSplineDeceleration(i);
            double d2 = DECELERATION_RATE;
            Double.isNaN(d2);
            return (int) (Math.exp(splineDeceleration / (d2 - 1.0d)) * 1000.0d);
        }

        private void onEdgeReached() {
            int i = this.mVelocity;
            float abs = (i * i) / (Math.abs(this.mDeceleration) * 2.0f);
            float signum = Math.signum(this.mVelocity);
            int i2 = this.mOver;
            if (abs > i2) {
                float f = -signum;
                int i3 = this.mVelocity;
                this.mDeceleration = ((f * i3) * i3) / (i2 * 2.0f);
                abs = i2;
            }
            this.mOver = (int) abs;
            this.mState = 2;
            int i4 = this.mStart;
            if (this.mVelocity <= 0) {
                abs = -abs;
            }
            this.mFinal = i4 + ((int) abs);
            this.mDuration = -((int) ((this.mVelocity * 1000.0f) / this.mDeceleration));
        }

        private void startAfterEdge(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                LogEx.e("OverScroller", "startAfterEdge called from a valid position");
                this.mFinished = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            if ((i - i5) * i4 >= 0) {
                startBounceAfterEdge(i, i5, i4);
            } else if (getSplineFlingDistance(i4) > Math.abs(r9)) {
                fling(i, i4, z ? i2 : i, z ? i : i3, this.mOver);
            } else {
                startSpringback(i, i5, i4);
            }
        }

        private void startBounceAfterEdge(int i, int i2, int i3) {
            this.mDeceleration = getDeceleration(i3 == 0 ? i - i2 : i3);
            fitOnBounceCurve(i, i2, i3);
            onEdgeReached();
        }

        private void startSpringback(int i, int i2, int i3) {
            this.mFinished = false;
            this.mState = 1;
            this.mStart = i;
            this.mFinal = i2;
            int i4 = i - i2;
            this.mDeceleration = getDeceleration(i4);
            this.mVelocity = -i4;
            this.mOver = Math.abs(i4);
            double d2 = i4;
            Double.isNaN(d2);
            double d3 = this.mDeceleration;
            Double.isNaN(d3);
            this.mDuration = (int) (Math.sqrt((d2 * (-2.0d)) / d3) * 1000.0d);
        }

        boolean continueWhenFinished() {
            int i = this.mState;
            if (i != 0) {
                if (i == 1) {
                    return false;
                }
                if (i == 2) {
                    this.mStartTime += this.mDuration;
                    startSpringback(this.mFinal, this.mStart, 0);
                }
            } else {
                if (this.mDuration >= this.mSplineDuration) {
                    return false;
                }
                this.mStart = this.mFinal;
                int i2 = (int) this.mCurrVelocity;
                this.mVelocity = i2;
                this.mDeceleration = getDeceleration(i2);
                this.mStartTime += this.mDuration;
                onEdgeReached();
            }
            update();
            return true;
        }

        void extendDuration(int i) {
            this.mDuration = ((int) (AnimationUtils.currentAnimationTimeMillis() - this.mStartTime)) + i;
            this.mFinished = false;
        }

        void finish() {
            this.mCurrentPosition = this.mFinal;
            this.mFinished = true;
        }

        void fling(int i, int i2, int i3, int i4, int i5) {
            this.mOver = i5;
            this.mFinished = false;
            this.mVelocity = i2;
            float f = i2;
            this.mCurrVelocity = f;
            this.mSplineDuration = 0;
            this.mDuration = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.mCurrentPosition = i;
            if (i <= i4 && i >= i3) {
                this.mState = 0;
                double d2 = 0.0d;
                if (i2 != 0) {
                    int splineFlingDuration = getSplineFlingDuration(i2);
                    this.mSplineDuration = splineFlingDuration;
                    this.mDuration = splineFlingDuration;
                    d2 = getSplineFlingDistance(i2);
                }
                double signum = Math.signum(f);
                Double.isNaN(signum);
                int i6 = (int) (d2 * signum);
                this.mSplineDistance = i6;
                int i7 = i + i6;
                this.mFinal = i7;
                if (i7 < i3) {
                    adjustDuration(this.mStart, i7, i3);
                    this.mFinal = i3;
                }
                int i8 = this.mFinal;
                if (i8 > i4) {
                    adjustDuration(this.mStart, i8, i4);
                    this.mFinal = i4;
                    return;
                }
                return;
            }
            startAfterEdge(i, i3, i4, i2);
        }

        void notifyEdgeReached(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.mOver = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                startAfterEdge(i, i2, i2, (int) this.mCurrVelocity);
            }
        }

        void setFinalPosition(int i) {
            this.mFinal = i;
            this.mFinished = false;
        }

        void setFriction(float f) {
            this.mFlingFriction = f;
        }

        boolean springback(int i, int i2, int i3) {
            this.mFinished = true;
            this.mFinal = i;
            this.mStart = i;
            this.mVelocity = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 0;
            if (i < i2) {
                startSpringback(i, i2, 0);
            } else if (i > i3) {
                startSpringback(i, i3, 0);
            }
            return !this.mFinished;
        }

        void startScroll(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.mFinal = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.mDeceleration = 0.0f;
            this.mVelocity = 0;
        }

        boolean update() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
            int i = this.mDuration;
            if (currentAnimationTimeMillis > i) {
                return false;
            }
            double d2 = 0.0d;
            int i2 = this.mState;
            if (i2 == 0) {
                float f = ((float) currentAnimationTimeMillis) / this.mSplineDuration;
                int i3 = (int) (f * 100.0f);
                float f2 = END_TENSION;
                float f3 = 0.0f;
                if (i3 < 100) {
                    float f4 = i3 / 100.0f;
                    int i4 = i3 + 1;
                    float[] fArr = SPLINE_POSITION;
                    float f5 = fArr[i3];
                    f3 = (fArr[i4] - f5) / ((i4 / 100.0f) - f4);
                    f2 = f5 + ((f - f4) * f3);
                }
                int i5 = this.mSplineDistance;
                this.mCurrVelocity = ((f3 * i5) / this.mSplineDuration) * 1000.0f;
                d2 = f2 * i5;
            } else if (i2 == 1) {
                float f6 = ((float) currentAnimationTimeMillis) / i;
                float f7 = f6 * f6;
                float signum = Math.signum(this.mVelocity);
                int i6 = this.mOver;
                this.mCurrVelocity = signum * i6 * 6.0f * ((-f6) + f7);
                d2 = i6 * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
            } else if (i2 == 2) {
                float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                int i7 = this.mVelocity;
                float f9 = this.mDeceleration;
                this.mCurrVelocity = i7 + (f9 * f8);
                d2 = (i7 * f8) + (((f9 * f8) * f8) / 2.0f);
            }
            this.mCurrentPosition = this.mStart + ((int) Math.round(d2));
            return true;
        }

        void updateScroll(float f) {
            this.mCurrentPosition = this.mStart + Math.round(f * (this.mFinal - r0));
        }
    }

    public OverScroller(Context context) {
        this(context, null);
    }

    public static float viscousFluid(float f) {
        float exp;
        float f2 = f * sViscousFluidScale;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * 0.63212055f) + 0.36787945f;
        }
        return exp * sViscousFluidNormalize;
    }

    public void abortAnimation() {
        this.mScrollerX.finish();
        this.mScrollerY.finish();
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        int i = this.mMode;
        if (i == 0) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mScrollerX.mStartTime;
            int i2 = this.mScrollerX.mDuration;
            if (currentAnimationTimeMillis < i2) {
                float f = ((float) currentAnimationTimeMillis) / i2;
                Interpolator interpolator = this.mInterpolator;
                if (interpolator == null) {
                    interpolation = viscousFluid(f);
                } else {
                    interpolation = interpolator.getInterpolation(f);
                }
                this.mScrollerX.updateScroll(interpolation);
                this.mScrollerY.updateScroll(interpolation);
            } else {
                abortAnimation();
            }
        } else if (i == 1) {
            if (!this.mScrollerX.mFinished && !this.mScrollerX.update() && !this.mScrollerX.continueWhenFinished()) {
                this.mScrollerX.finish();
            }
            if (!this.mScrollerY.mFinished && !this.mScrollerY.update() && !this.mScrollerY.continueWhenFinished()) {
                this.mScrollerY.finish();
            }
        }
        return true;
    }

    @Deprecated
    public void extendDuration(int i) {
        this.mScrollerX.extendDuration(i);
        this.mScrollerY.extendDuration(i);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public final void forceFinished(boolean z) {
        this.mScrollerX.mFinished = this.mScrollerY.mFinished = z;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.mScrollerX.mCurrVelocity * this.mScrollerX.mCurrVelocity) + (this.mScrollerY.mCurrVelocity * this.mScrollerY.mCurrVelocity));
    }

    public final int getCurrX() {
        return this.mScrollerX.mCurrentPosition;
    }

    public final int getCurrY() {
        return this.mScrollerY.mCurrentPosition;
    }

    @Deprecated
    public final int getDuration() {
        return Math.max(this.mScrollerX.mDuration, this.mScrollerY.mDuration);
    }

    public final int getFinalX() {
        return this.mScrollerX.mFinal;
    }

    public final int getFinalY() {
        return this.mScrollerY.mFinal;
    }

    public final int getStartX() {
        return this.mScrollerX.mStart;
    }

    public final int getStartY() {
        return this.mScrollerY.mStart;
    }

    public final boolean isFinished() {
        return this.mScrollerX.mFinished && this.mScrollerY.mFinished;
    }

    public boolean isOverScrolled() {
        return ((this.mScrollerX.mFinished || this.mScrollerX.mState == 0) && (this.mScrollerY.mFinished || this.mScrollerY.mState == 0)) ? false : true;
    }

    public boolean isScrollingInDirection(float f, float f2) {
        return !isFinished() && Double.doubleToLongBits((double) Math.signum(f)) == Double.doubleToLongBits((double) Math.signum((float) (this.mScrollerX.mFinal - this.mScrollerX.mStart))) && Double.doubleToLongBits((double) Math.signum(f2)) == Double.doubleToLongBits((double) Math.signum((float) (this.mScrollerY.mFinal - this.mScrollerY.mStart)));
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.mScrollerX.notifyEdgeReached(i, i2, i3);
    }

    public void notifyVerticalEdgeReached(int i, int i2, int i3) {
        this.mScrollerY.notifyEdgeReached(i, i2, i3);
    }

    @Deprecated
    public void setFinalX(int i) {
        this.mScrollerX.setFinalPosition(i);
    }

    @Deprecated
    public void setFinalY(int i) {
        this.mScrollerY.setFinalPosition(i);
    }

    public final void setFriction(float f) {
        this.mScrollerX.setFriction(f);
        this.mScrollerY.setFriction(f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.mScrollerX.springback(i, i3, i4) || this.mScrollerY.springback(i2, i5, i6);
    }

    public void startScroll(int i, int i2, int i3, int i4) {
        startScroll(i, i2, i3, i4, DEFAULT_DURATION);
    }

    public int timePassed() {
        return (int) (AnimationUtils.currentAnimationTimeMillis() - Math.min(this.mScrollerX.mStartTime, this.mScrollerY.mStartTime));
    }

    public OverScroller(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        if (!this.mFlywheel || isFinished()) {
            i11 = i3;
            i12 = i4;
        } else {
            float f = this.mScrollerX.mCurrVelocity;
            float f2 = this.mScrollerY.mCurrVelocity;
            i11 = i3;
            float f3 = i11;
            float signum = Math.signum(f3);
            float signum2 = Math.signum(f);
            i12 = i4;
            float f4 = i12;
            float signum3 = Math.signum(f4);
            float signum4 = Math.signum(f2);
            if (Double.doubleToLongBits(signum) == Double.doubleToLongBits(signum2) && Double.doubleToLongBits(signum3) == Double.doubleToLongBits(signum4)) {
                i14 = (int) (f4 + f2);
                i13 = (int) (f3 + f);
                this.mMode = 1;
                this.mScrollerX.fling(i, i13, i5, i6, i9);
                this.mScrollerY.fling(i2, i14, i7, i8, i10);
            }
        }
        i13 = i11;
        i14 = i12;
        this.mMode = 1;
        this.mScrollerX.fling(i, i13, i5, i6, i9);
        this.mScrollerY.fling(i2, i14, i7, i8, i10);
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.mScrollerX.startScroll(i, i3, i5);
        this.mScrollerY.startScroll(i2, i4, i5);
    }

    public OverScroller(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.mFlywheel = z;
        this.mScrollerX = new SplineOverScroller(context);
        this.mScrollerY = new SplineOverScroller(context);
    }

    public OverScroller(Context context, Interpolator interpolator, float f, float f2) {
        this(context, interpolator, true);
    }

    public OverScroller(Context context, Interpolator interpolator, float f, float f2, boolean z) {
        this(context, interpolator, z);
    }
}
