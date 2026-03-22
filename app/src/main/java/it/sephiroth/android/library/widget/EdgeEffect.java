package it.sephiroth.android.library.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.zte.iptvclient.android.zala.R;

/* loaded from: classes2.dex */
public class EdgeEffect {
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 0;
    private static final float EPSILON = 0.001f;
    private static final float HELD_EDGE_SCALE_Y = 0.5f;
    private static final float MAX_ALPHA = 1.0f;
    private static final float MAX_GLOW_HEIGHT = 4.0f;
    private static final int MIN_VELOCITY = 100;
    private static final int MIN_WIDTH = 300;
    private static final int PULL_DECAY_TIME = 1000;
    private static final float PULL_DISTANCE_ALPHA_GLOW_FACTOR = 1.1f;
    private static final int PULL_DISTANCE_EDGE_FACTOR = 7;
    private static final int PULL_DISTANCE_GLOW_FACTOR = 7;
    private static final float PULL_EDGE_BEGIN = 0.6f;
    private static final float PULL_GLOW_BEGIN = 1.0f;
    private static final int PULL_TIME = 167;
    private static final int RECEDE_TIME = 1000;
    private static final int STATE_ABSORB = 2;
    private static final int STATE_IDLE = 0;
    private static final int STATE_PULL = 1;
    private static final int STATE_PULL_DECAY = 4;
    private static final int STATE_RECEDE = 3;
    private static final String TAG = "EdgeEffect";
    private static final int VELOCITY_EDGE_FACTOR = 8;
    private static final int VELOCITY_GLOW_FACTOR = 16;
    private final int mDirection;
    private float mDuration;
    private final Drawable mEdge;
    private float mEdgeAlpha;
    private float mEdgeAlphaFinish;
    private float mEdgeAlphaStart;
    private final int mEdgeHeight;
    private float mEdgeScaleY;
    private float mEdgeScaleYFinish;
    private float mEdgeScaleYStart;
    private final Drawable mGlow;
    private float mGlowAlpha;
    private float mGlowAlphaFinish;
    private float mGlowAlphaStart;
    private final int mGlowHeight;
    private float mGlowScaleY;
    private float mGlowScaleYFinish;
    private float mGlowScaleYStart;
    private final int mGlowWidth;
    private final Interpolator mInterpolator;
    private final int mMaxEffectHeight;
    private final int mMinWidth;
    private float mPullDistance;
    private long mStartTime;
    private int mWidth;
    private int mX;
    private int mY;
    private int mState = 0;
    private final Rect mBounds = new Rect();

    public EdgeEffect(Context context, int i) {
        Resources resources = context.getResources();
        this.mEdge = resources.getDrawable(R.drawable.hlv_overscroll_edge);
        this.mGlow = resources.getDrawable(R.drawable.hlv_overscroll_glow);
        this.mDirection = i;
        this.mEdgeHeight = this.mEdge.getIntrinsicHeight();
        this.mGlowHeight = this.mGlow.getIntrinsicHeight();
        int intrinsicWidth = this.mGlow.getIntrinsicWidth();
        this.mGlowWidth = intrinsicWidth;
        int i2 = this.mGlowHeight;
        this.mMaxEffectHeight = (int) (Math.min((((i2 * MAX_GLOW_HEIGHT) * i2) / intrinsicWidth) * PULL_EDGE_BEGIN, i2 * MAX_GLOW_HEIGHT) + HELD_EDGE_SCALE_Y);
        this.mMinWidth = (int) ((resources.getDisplayMetrics().density * 300.0f) + HELD_EDGE_SCALE_Y);
        this.mInterpolator = new DecelerateInterpolator();
    }

    private void update() {
        float f;
        float min = Math.min(((float) (AnimationUtils.currentAnimationTimeMillis() - this.mStartTime)) / this.mDuration, 1.0f);
        float interpolation = this.mInterpolator.getInterpolation(min);
        float f2 = this.mEdgeAlphaStart;
        this.mEdgeAlpha = f2 + ((this.mEdgeAlphaFinish - f2) * interpolation);
        float f3 = this.mEdgeScaleYStart;
        this.mEdgeScaleY = f3 + ((this.mEdgeScaleYFinish - f3) * interpolation);
        float f4 = this.mGlowAlphaStart;
        this.mGlowAlpha = f4 + ((this.mGlowAlphaFinish - f4) * interpolation);
        float f5 = this.mGlowScaleYStart;
        float f6 = this.mGlowScaleYFinish;
        this.mGlowScaleY = f5 + ((f6 - f5) * interpolation);
        if (min >= 0.999f) {
            int i = this.mState;
            if (i == 1) {
                this.mState = 4;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                this.mDuration = 1000.0f;
                this.mEdgeAlphaStart = this.mEdgeAlpha;
                this.mEdgeScaleYStart = this.mEdgeScaleY;
                this.mGlowAlphaStart = this.mGlowAlpha;
                this.mGlowScaleYStart = this.mGlowScaleY;
                this.mEdgeAlphaFinish = 0.0f;
                this.mEdgeScaleYFinish = 0.0f;
                this.mGlowAlphaFinish = 0.0f;
                this.mGlowScaleYFinish = 0.0f;
                return;
            }
            if (i == 2) {
                this.mState = 3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                this.mDuration = 1000.0f;
                this.mEdgeAlphaStart = this.mEdgeAlpha;
                this.mEdgeScaleYStart = this.mEdgeScaleY;
                this.mGlowAlphaStart = this.mGlowAlpha;
                this.mGlowScaleYStart = this.mGlowScaleY;
                this.mEdgeAlphaFinish = 0.0f;
                this.mEdgeScaleYFinish = 0.0f;
                this.mGlowAlphaFinish = 0.0f;
                this.mGlowScaleYFinish = 0.0f;
                return;
            }
            if (i == 3) {
                this.mState = 0;
                return;
            }
            if (i != 4) {
                return;
            }
            if (Double.doubleToLongBits(f6) != Double.doubleToLongBits(0.0d)) {
                float f7 = this.mGlowScaleYFinish;
                f = 1.0f / (f7 * f7);
            } else {
                f = Float.MAX_VALUE;
            }
            float f8 = this.mEdgeScaleYStart;
            this.mEdgeScaleY = f8 + ((this.mEdgeScaleYFinish - f8) * interpolation * f);
            this.mState = 3;
        }
    }

    public boolean draw(Canvas canvas) {
        update();
        this.mGlow.setAlpha((int) (Math.max(0.0f, Math.min(this.mGlowAlpha, 1.0f)) * 255.0f));
        int i = this.mGlowHeight;
        int min = (int) Math.min((((i * this.mGlowScaleY) * i) / this.mGlowWidth) * PULL_EDGE_BEGIN, i * MAX_GLOW_HEIGHT);
        this.mGlow.setBounds(0, 0, this.mWidth, min);
        this.mGlow.draw(canvas);
        this.mEdge.setAlpha((int) (Math.max(0.0f, Math.min(this.mEdgeAlpha, 1.0f)) * 255.0f));
        int i2 = (int) (this.mEdgeHeight * this.mEdgeScaleY);
        this.mEdge.setBounds(0, 0, this.mWidth, i2);
        this.mEdge.draw(canvas);
        if (this.mState == 3 && min == 0 && i2 == 0) {
            this.mState = 0;
        }
        return this.mState != 0;
    }

    public void finish() {
        this.mState = 0;
    }

    public Rect getBounds(boolean z) {
        this.mBounds.set(0, 0, this.mWidth, this.mMaxEffectHeight);
        this.mBounds.offset(this.mX, this.mY - (z ? this.mMaxEffectHeight : 0));
        return this.mBounds;
    }

    public boolean isFinished() {
        return this.mState == 0;
    }

    public void onAbsorb(int i) {
        this.mState = 2;
        int max = Math.max(100, Math.abs(i));
        this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.mDuration = (max * 0.03f) + 0.1f;
        this.mEdgeAlphaStart = 0.0f;
        this.mEdgeScaleYStart = 0.0f;
        this.mEdgeScaleY = 0.0f;
        this.mGlowAlphaStart = HELD_EDGE_SCALE_Y;
        this.mGlowScaleYStart = 0.0f;
        this.mEdgeAlphaFinish = Math.max(0, Math.min(r0, 1));
        this.mEdgeScaleYFinish = Math.max(HELD_EDGE_SCALE_Y, Math.min(max * 8, 1.0f));
        this.mGlowScaleYFinish = Math.min(((max / 100) * max * 1.5E-4f) + 0.025f, 1.75f);
        this.mGlowAlphaFinish = Math.max(this.mGlowAlphaStart, Math.min(max * 16 * 1.0E-5f, 1.0f));
    }

    public void onPull(float f) {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.mState != 4 || ((float) (currentAnimationTimeMillis - this.mStartTime)) >= this.mDuration) {
            if (this.mState != 1) {
                this.mGlowScaleY = 1.0f;
            }
            this.mState = 1;
            this.mStartTime = currentAnimationTimeMillis;
            this.mDuration = 167.0f;
            float f2 = this.mPullDistance + f;
            this.mPullDistance = f2;
            float abs = Math.abs(f2);
            float max = Math.max(PULL_EDGE_BEGIN, Math.min(abs, 1.0f));
            this.mEdgeAlphaStart = max;
            this.mEdgeAlpha = max;
            float max2 = Math.max(HELD_EDGE_SCALE_Y, Math.min(abs * 7.0f, 1.0f));
            this.mEdgeScaleYStart = max2;
            this.mEdgeScaleY = max2;
            float min = Math.min(1.0f, this.mGlowAlpha + (Math.abs(f) * PULL_DISTANCE_ALPHA_GLOW_FACTOR));
            this.mGlowAlphaStart = min;
            this.mGlowAlpha = min;
            float abs2 = Math.abs(f);
            if (f > 0.0f && this.mPullDistance < 0.0f) {
                abs2 = -abs2;
            }
            if (Double.doubleToLongBits(this.mPullDistance) == 0) {
                this.mGlowScaleY = 0.0f;
            }
            float min2 = Math.min(MAX_GLOW_HEIGHT, Math.max(0.0f, this.mGlowScaleY + (abs2 * 7.0f)));
            this.mGlowScaleYStart = min2;
            this.mGlowScaleY = min2;
            this.mEdgeAlphaFinish = this.mEdgeAlpha;
            this.mEdgeScaleYFinish = this.mEdgeScaleY;
            this.mGlowAlphaFinish = this.mGlowAlpha;
            this.mGlowScaleYFinish = min2;
        }
    }

    public void onRelease() {
        this.mPullDistance = 0.0f;
        int i = this.mState;
        if (i == 1 || i == 4) {
            this.mState = 3;
            this.mEdgeAlphaStart = this.mEdgeAlpha;
            this.mEdgeScaleYStart = this.mEdgeScaleY;
            this.mGlowAlphaStart = this.mGlowAlpha;
            this.mGlowScaleYStart = this.mGlowScaleY;
            this.mEdgeAlphaFinish = 0.0f;
            this.mEdgeScaleYFinish = 0.0f;
            this.mGlowAlphaFinish = 0.0f;
            this.mGlowScaleYFinish = 0.0f;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 1000.0f;
        }
    }

    public void setPosition(int i, int i2) {
        this.mX = i;
        this.mY = i2;
    }

    public void setSize(int i, int i2) {
        this.mWidth = i;
    }
}
