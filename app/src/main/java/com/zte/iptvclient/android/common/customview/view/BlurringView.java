package com.zte.iptvclient.android.common.customview.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.AttributeSet;
import android.view.View;
import com.ahmobile.android.tvclient.R$styleable;
import com.zte.iptvclient.android.zala.R;

/* loaded from: classes.dex */
public class BlurringView extends View {

    /* renamed from: a, reason: collision with root package name */
    private int f4331a;

    /* renamed from: b, reason: collision with root package name */
    private int f4332b;

    /* renamed from: c, reason: collision with root package name */
    private View f4333c;

    /* renamed from: d, reason: collision with root package name */
    private int f4334d;
    private int e;
    private boolean f;
    private Bitmap g;
    private Bitmap h;
    private Canvas i;
    private RenderScript j;
    private ScriptIntrinsicBlur k;
    private Allocation l;
    private Allocation m;

    public BlurringView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Resources resources = getResources();
        int integer = resources.getInteger(R.integer.default_blur_radius);
        int integer2 = resources.getInteger(R.integer.default_downsample_factor);
        int color = resources.getColor(R.color.default_overlay_color);
        a(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PxBlurringView);
        a(obtainStyledAttributes.getInt(0, integer));
        b(obtainStyledAttributes.getInt(1, integer2));
        c(obtainStyledAttributes.getColor(2, color));
        obtainStyledAttributes.recycle();
    }

    public void a(int i) {
        this.k.setRadius(i);
    }

    public void b(int i) {
        if (i > 0) {
            if (this.f4331a != i) {
                this.f4331a = i;
                this.f = true;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Downsample factor must be greater than 0.");
    }

    public void c(int i) {
        this.f4332b = i;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        RenderScript renderScript = this.j;
        if (renderScript != null) {
            renderScript.destroy();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f4333c != null) {
            if (b()) {
                this.f4333c.draw(this.i);
                a();
                canvas.save();
                canvas.translate(this.f4333c.getX() - getX(), this.f4333c.getY() - getY());
                int i = this.f4331a;
                canvas.scale(i, i);
                canvas.drawBitmap(this.h, 0.0f, 0.0f, (Paint) null);
                canvas.restore();
            }
            canvas.drawColor(this.f4332b);
        }
    }

    private void a(Context context) {
        RenderScript create = RenderScript.create(context);
        this.j = create;
        if (create != null) {
            this.k = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
        }
    }

    protected void a() {
        this.l.copyFrom(this.g);
        this.k.setInput(this.l);
        this.k.forEach(this.m);
        this.m.copyTo(this.h);
    }

    protected boolean b() {
        int width = this.f4333c.getWidth();
        int height = this.f4333c.getHeight();
        if (this.i == null || this.f || this.f4334d != width || this.e != height) {
            this.f = false;
            this.f4334d = width;
            this.e = height;
            int i = this.f4331a;
            int i2 = width / i;
            int i3 = height / i;
            int i4 = (i2 - (i2 % 4)) + 4;
            int i5 = (i3 - (i3 % 4)) + 4;
            Bitmap bitmap = this.h;
            if (bitmap == null || bitmap.getWidth() != i4 || this.h.getHeight() != i5) {
                Bitmap createBitmap = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_8888);
                this.g = createBitmap;
                if (createBitmap == null) {
                    return false;
                }
                Bitmap createBitmap2 = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_8888);
                this.h = createBitmap2;
                if (createBitmap2 == null) {
                    return false;
                }
            }
            Canvas canvas = new Canvas(this.g);
            this.i = canvas;
            int i6 = this.f4331a;
            canvas.scale(1.0f / i6, 1.0f / i6);
            Allocation createFromBitmap = Allocation.createFromBitmap(this.j, this.g, Allocation.MipmapControl.MIPMAP_NONE, 1);
            this.l = createFromBitmap;
            this.m = Allocation.createTyped(this.j, createFromBitmap.getType());
        }
        return true;
    }
}
