package com.zte.iptvclient.android.common.customview.view;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewParent;
import android.widget.RemoteViews;
import com.ahmobile.android.tvclient.R$styleable;

@RemoteViews.RemoteView
/* loaded from: classes.dex */
public class VerticalProgressBar extends View {

    /* renamed from: a, reason: collision with root package name */
    int f4347a;

    /* renamed from: b, reason: collision with root package name */
    int f4348b;

    /* renamed from: c, reason: collision with root package name */
    int f4349c;

    /* renamed from: d, reason: collision with root package name */
    int f4350d;
    private int e;
    private int f;
    private int g;
    private Drawable h;
    private Drawable i;
    Bitmap j;
    private boolean k;
    private b l;
    private long m;
    private boolean n;
    protected int o;
    protected int p;
    protected int q;
    protected int r;
    protected int s;
    protected int t;
    protected ViewParent u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> PARCELABL_ECREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        int f4351a;

        /* renamed from: b, reason: collision with root package name */
        int f4352b;

        /* loaded from: classes.dex */
        static class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f4351a);
            parcel.writeInt(this.f4352b);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f4351a = parcel.readInt();
            this.f4352b = parcel.readInt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private int f4353a;

        /* renamed from: b, reason: collision with root package name */
        private int f4354b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f4355c;

        b(int i, int i2, boolean z) {
            this.f4353a = i;
            this.f4354b = i2;
            this.f4355c = z;
        }

        public void a(int i, int i2, boolean z) {
            this.f4353a = i;
            this.f4354b = i2;
            this.f4355c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            VerticalProgressBar.this.a(this.f4353a, this.f4354b, this.f4355c);
            VerticalProgressBar.this.l = this;
        }
    }

    public VerticalProgressBar(Context context) {
        this(context, null);
    }

    private synchronized void f() {
        this.g = 100;
        this.e = 0;
        this.f = 0;
        this.f4347a = 24;
        this.f4348b = 48;
        this.f4349c = 24;
        this.f4350d = 48;
    }

    void a(float f, boolean z) {
    }

    Shape b() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    public synchronized void c(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > this.g) {
            i = this.g;
        }
        if (i != this.f) {
            this.f = i;
            b(R.id.secondaryProgress, i, false);
        }
    }

    @ViewDebug.ExportedProperty
    public synchronized int d() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.h;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.h.setState(drawableState);
    }

    public Drawable e() {
        return this.h;
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        if (this.n) {
            return;
        }
        if (verifyDrawable(drawable)) {
            Rect bounds = drawable.getBounds();
            int i = this.o + this.q;
            int i2 = this.p + this.s;
            invalidate(bounds.left + i, bounds.top + i2, bounds.right + i, bounds.bottom + i2);
            return;
        }
        super.invalidateDrawable(drawable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable drawable = this.i;
        if (drawable != null) {
            canvas.save();
            canvas.translate(this.q, this.s);
            drawable.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        int i3;
        Drawable drawable = this.i;
        int i4 = 0;
        if (drawable != null) {
            i4 = Math.max(this.f4347a, Math.min(this.f4348b, drawable.getIntrinsicWidth()));
            i3 = Math.max(this.f4349c, Math.min(this.f4350d, drawable.getIntrinsicHeight()));
        } else {
            i3 = 0;
        }
        setMeasuredDimension(View.resolveSize(i4 + this.q + this.r, i), View.resolveSize(i3 + this.s + this.t, i2));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        b(savedState.f4351a);
        c(savedState.f4352b);
    }

    @Override // android.view.View
    public synchronized Parcelable onSaveInstanceState() {
        SavedState savedState;
        savedState = new SavedState(super.onSaveInstanceState());
        savedState.f4351a = this.e;
        savedState.f4352b = this.f;
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5 = (i - this.r) - this.q;
        int i6 = (i2 - this.t) - this.s;
        Drawable drawable = this.h;
        if (drawable != null) {
            drawable.setBounds(0, 0, i5, i6);
        }
    }

    @Override // android.view.View
    public void postInvalidate() {
        if (this.k) {
            return;
        }
        super.postInvalidate();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (getVisibility() != i) {
            super.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return drawable.equals(this.h) || super.verifyDrawable(drawable);
    }

    public VerticalProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.progressBarStyle);
    }

    public VerticalProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.m = Thread.currentThread().getId();
        f();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ProgressBar, i, 0);
        this.k = true;
        Drawable drawable = obtainStyledAttributes.getDrawable(5);
        if (drawable != null) {
            a(a(drawable, false));
        }
        this.f4347a = obtainStyledAttributes.getDimensionPixelSize(6, this.f4347a);
        this.f4348b = obtainStyledAttributes.getDimensionPixelSize(0, this.f4348b);
        this.f4349c = obtainStyledAttributes.getDimensionPixelSize(7, this.f4349c);
        this.f4350d = obtainStyledAttributes.getDimensionPixelSize(1, this.f4350d);
        a(obtainStyledAttributes.getInt(2, this.g));
        b(obtainStyledAttributes.getInt(3, this.e));
        c(obtainStyledAttributes.getInt(4, this.f));
        this.k = false;
        obtainStyledAttributes.recycle();
    }

    private Drawable a(Drawable drawable, boolean z) {
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i = 0; i < numberOfLayers; i++) {
                int id = layerDrawable.getId(i);
                drawableArr[i] = a(layerDrawable.getDrawable(i), id == 16908301 || id == 16908303);
            }
            LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                layerDrawable2.setId(i2, layerDrawable.getId(i2));
            }
            return layerDrawable2;
        }
        if (drawable instanceof StateListDrawable) {
            return new StateListDrawable();
        }
        if (!(drawable instanceof BitmapDrawable)) {
            return drawable;
        }
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        if (this.j == null) {
            this.j = bitmap;
        }
        ShapeDrawable shapeDrawable = new ShapeDrawable(b());
        return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
    }

    private void b(int i, int i2, boolean z) {
        if (this.m == Thread.currentThread().getId()) {
            a(i, i2, z);
            return;
        }
        b bVar = this.l;
        if (bVar != null) {
            this.l = null;
            bVar.a(i, i2, z);
        } else {
            bVar = new b(i, i2, z);
        }
        post(bVar);
    }

    @ViewDebug.ExportedProperty
    public synchronized int c() {
        return this.g;
    }

    public void b(int i) {
        a(i, false);
    }

    public void a(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(this);
            int minimumHeight = drawable.getMinimumHeight();
            if (this.f4350d < minimumHeight) {
                this.f4350d = minimumHeight;
                requestLayout();
            }
        }
        this.h = drawable;
        this.i = drawable;
        postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable a() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(int i, int i2, boolean z) {
        float f = this.g > 0 ? i2 / this.g : 0.0f;
        Drawable drawable = this.i;
        if (drawable != null) {
            Drawable findDrawableByLayerId = drawable instanceof LayerDrawable ? ((LayerDrawable) drawable).findDrawableByLayerId(i) : null;
            int i3 = (int) (10000.0f * f);
            if (findDrawableByLayerId != null) {
                drawable = findDrawableByLayerId;
            }
            drawable.setLevel(i3);
        } else {
            invalidate();
        }
        if (i == 16908301) {
            a(f, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(int i, boolean z) {
        if (i < 0) {
            i = 0;
        }
        if (i > this.g) {
            i = this.g;
        }
        if (i != this.e) {
            this.e = i;
            b(R.id.progress, i, z);
        }
    }

    public synchronized void a(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i != this.g) {
            this.g = i;
            postInvalidate();
            if (this.e > i) {
                this.e = i;
                b(R.id.progress, i, false);
            }
        }
    }
}
