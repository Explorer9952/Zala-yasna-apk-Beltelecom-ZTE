package pl.droidsonroids.gif;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Surface;
import android.view.TextureView;
import android.widget.ImageView;
import com.ahmobile.android.tvclient.R$styleable;
import java.io.IOException;
import pl.droidsonroids.gif.InputSource;

@TargetApi(14)
/* loaded from: classes2.dex */
public class GifTextureView extends TextureView {
    private static final ImageView.ScaleType[] sScaleTypeArray;
    private boolean mFreezesAnimation;
    private InputSource mInputSource;
    private RenderThread mRenderThread;
    private ImageView.ScaleType mScaleType;
    private float mSpeedFactor;
    private final Matrix mTransform;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: pl.droidsonroids.gif.GifTextureView$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            $SwitchMap$android$widget$ImageView$ScaleType = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class RenderThread extends Thread implements TextureView.SurfaceTextureListener {
        final ConditionVariable isSurfaceValid;
        private GifInfoHandle mGifInfoHandle;
        private IOException mIOException;
        long[] mSavedState;

        RenderThread() {
            super("GifRenderThread");
            this.isSurfaceValid = new ConditionVariable();
            this.mGifInfoHandle = GifInfoHandle.NULL_INFO;
        }

        void dispose() {
            this.isSurfaceValid.close();
            GifTextureView.super.setSurfaceTextureListener(null);
            this.mGifInfoHandle.postUnbindSurface();
            GifTextureView.this.mRenderThread.interrupt();
            boolean isInterrupted = Thread.currentThread().isInterrupted();
            if (isInterrupted) {
                Thread.interrupted();
            }
            try {
                GifTextureView.this.mRenderThread.join();
                if (isInterrupted) {
                    Thread.currentThread().interrupt();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            GifTextureView.this.updateTextureViewSize(this.mGifInfoHandle);
            this.isSurfaceValid.open();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.isSurfaceValid.close();
            this.mGifInfoHandle.postUnbindSurface();
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            try {
                this.mGifInfoHandle = GifTextureView.this.mInputSource.open();
                GifTextureView.super.setSurfaceTextureListener(this);
                boolean isAvailable = GifTextureView.this.isAvailable();
                this.isSurfaceValid.set(isAvailable);
                if (isAvailable) {
                    GifTextureView.this.post(new Runnable() { // from class: pl.droidsonroids.gif.GifTextureView.RenderThread.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RenderThread renderThread = RenderThread.this;
                            GifTextureView.this.updateTextureViewSize(renderThread.mGifInfoHandle);
                        }
                    });
                }
                this.mGifInfoHandle.setSpeedFactor(GifTextureView.this.mSpeedFactor);
                while (!isInterrupted()) {
                    try {
                        this.isSurfaceValid.block();
                        SurfaceTexture surfaceTexture = GifTextureView.this.getSurfaceTexture();
                        if (surfaceTexture != null) {
                            Surface surface = new Surface(surfaceTexture);
                            try {
                                this.mGifInfoHandle.bindSurface(surface, this.mSavedState, GifTextureView.this.isOpaque());
                            } finally {
                                surface.release();
                            }
                        }
                    } catch (InterruptedException unused) {
                    }
                }
                this.mGifInfoHandle.recycle();
            } catch (IOException e) {
                this.mIOException = e;
            }
        }
    }

    static {
        System.loadLibrary("pl_droidsonroids_gif_surface");
        sScaleTypeArray = new ImageView.ScaleType[]{ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    }

    public GifTextureView(Context context) {
        super(context);
        this.mScaleType = ImageView.ScaleType.FIT_CENTER;
        this.mTransform = new Matrix();
        this.mSpeedFactor = 1.0f;
        init(null, 0, 0);
    }

    private static InputSource findSource(TypedArray typedArray) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(0, typedValue)) {
            return null;
        }
        if (typedValue.resourceId != 0) {
            String resourceTypeName = typedArray.getResources().getResourceTypeName(typedValue.resourceId);
            if (!"drawable".equals(resourceTypeName) && !"raw".equals(resourceTypeName)) {
                if (!"string".equals(resourceTypeName)) {
                    throw new IllegalArgumentException("Expected string, drawable or raw resource, type " + resourceTypeName + " cannot be converted to GIF");
                }
            } else {
                return new InputSource.ResourcesSource(typedArray.getResources(), typedValue.resourceId);
            }
        }
        return new InputSource.AssetSource(typedArray.getResources().getAssets(), typedValue.string.toString());
    }

    private void init(AttributeSet attributeSet, int i, int i2) {
        if (attributeSet != null) {
            int attributeIntValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "scaleType", -1);
            if (attributeIntValue >= 0) {
                ImageView.ScaleType[] scaleTypeArr = sScaleTypeArray;
                if (attributeIntValue < scaleTypeArr.length) {
                    this.mScaleType = scaleTypeArr[attributeIntValue];
                }
            }
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.GifTextureView, i, i2);
            this.mInputSource = findSource(obtainStyledAttributes);
            super.setOpaque(obtainStyledAttributes.getBoolean(1, false));
            obtainStyledAttributes.recycle();
            this.mFreezesAnimation = GifViewUtils.isFreezingAnimation(this, attributeSet, i, i2);
        } else {
            super.setOpaque(false);
        }
        if (isInEditMode()) {
            return;
        }
        RenderThread renderThread = new RenderThread();
        this.mRenderThread = renderThread;
        if (this.mInputSource != null) {
            renderThread.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTextureViewSize(GifInfoHandle gifInfoHandle) {
        Matrix matrix = new Matrix();
        float width = getWidth();
        float height = getHeight();
        float f = gifInfoHandle.width / width;
        float f2 = gifInfoHandle.height / height;
        RectF rectF = new RectF(0.0f, 0.0f, gifInfoHandle.width, gifInfoHandle.height);
        RectF rectF2 = new RectF(0.0f, 0.0f, width, height);
        switch (AnonymousClass1.$SwitchMap$android$widget$ImageView$ScaleType[this.mScaleType.ordinal()]) {
            case 1:
                matrix.setScale(f, f2, width / 2.0f, height / 2.0f);
                break;
            case 2:
                float min = 1.0f / Math.min(f, f2);
                matrix.setScale(f * min, min * f2, width / 2.0f, height / 2.0f);
                break;
            case 3:
                float min2 = (((float) gifInfoHandle.width) > width || ((float) gifInfoHandle.height) > height) ? Math.min(1.0f / f, 1.0f / f2) : 1.0f;
                matrix.setScale(f * min2, min2 * f2, width / 2.0f, height / 2.0f);
                break;
            case 4:
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
                matrix.preScale(f, f2);
                break;
            case 5:
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
                matrix.preScale(f, f2);
                break;
            case 6:
                matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
                matrix.preScale(f, f2);
                break;
            case 7:
                return;
            case 8:
                matrix.set(this.mTransform);
                matrix.preScale(f, f2);
                break;
        }
        super.setTransform(matrix);
    }

    public IOException getIOException() {
        return this.mRenderThread.mIOException != null ? this.mRenderThread.mIOException : GifIOException.fromCode(this.mRenderThread.mGifInfoHandle.getNativeErrorCode());
    }

    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    @Override // android.view.TextureView
    public TextureView.SurfaceTextureListener getSurfaceTextureListener() {
        return null;
    }

    @Override // android.view.TextureView
    public Matrix getTransform(Matrix matrix) {
        if (matrix == null) {
            matrix = new Matrix();
        }
        matrix.set(this.mTransform);
        return matrix;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.mRenderThread.dispose();
        super.onDetachedFromWindow();
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        GifViewSavedState gifViewSavedState = (GifViewSavedState) parcelable;
        super.onRestoreInstanceState(gifViewSavedState.getSuperState());
        this.mRenderThread.mSavedState = gifViewSavedState.mStates[0];
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        RenderThread renderThread = this.mRenderThread;
        renderThread.mSavedState = renderThread.mGifInfoHandle.getSavedState();
        return new GifViewSavedState(super.onSaveInstanceState(), this.mFreezesAnimation ? this.mRenderThread.mSavedState : null);
    }

    public void setFreezesAnimation(boolean z) {
        this.mFreezesAnimation = z;
    }

    public void setImageMatrix(Matrix matrix) {
        setTransform(matrix);
    }

    public synchronized void setInputSource(InputSource inputSource) {
        this.mRenderThread.dispose();
        this.mInputSource = inputSource;
        RenderThread renderThread = new RenderThread();
        this.mRenderThread = renderThread;
        if (inputSource != null) {
            renderThread.start();
        }
    }

    @Override // android.view.TextureView
    public void setOpaque(boolean z) {
        if (z != isOpaque()) {
            super.setOpaque(z);
            setInputSource(this.mInputSource);
        }
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.mScaleType = scaleType;
        updateTextureViewSize(this.mRenderThread.mGifInfoHandle);
    }

    public void setSpeed(float f) {
        this.mSpeedFactor = f;
        this.mRenderThread.mGifInfoHandle.setSpeedFactor(f);
    }

    @Override // android.view.TextureView
    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        throw new UnsupportedOperationException("Changing SurfaceTexture is not supported");
    }

    @Override // android.view.TextureView
    public void setSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        throw new UnsupportedOperationException("Changing SurfaceTextureListener is not supported");
    }

    @Override // android.view.TextureView
    public void setTransform(Matrix matrix) {
        this.mTransform.set(matrix);
        updateTextureViewSize(this.mRenderThread.mGifInfoHandle);
    }

    public GifTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mScaleType = ImageView.ScaleType.FIT_CENTER;
        this.mTransform = new Matrix();
        this.mSpeedFactor = 1.0f;
        init(attributeSet, 0, 0);
    }

    public GifTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mScaleType = ImageView.ScaleType.FIT_CENTER;
        this.mTransform = new Matrix();
        this.mSpeedFactor = 1.0f;
        init(attributeSet, i, 0);
    }

    public GifTextureView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.mScaleType = ImageView.ScaleType.FIT_CENTER;
        this.mTransform = new Matrix();
        this.mSpeedFactor = 1.0f;
        init(attributeSet, i, i2);
    }
}
