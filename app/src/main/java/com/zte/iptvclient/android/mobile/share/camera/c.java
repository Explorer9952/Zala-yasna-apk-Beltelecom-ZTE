package com.zte.iptvclient.android.mobile.share.camera;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.view.SurfaceHolder;
import java.io.IOException;

/* compiled from: CameraManager.java */
/* loaded from: classes2.dex */
public final class c {
    private static c j;
    static final int k;

    /* renamed from: a, reason: collision with root package name */
    private final b f7187a;

    /* renamed from: b, reason: collision with root package name */
    private Camera f7188b;

    /* renamed from: c, reason: collision with root package name */
    private Rect f7189c;

    /* renamed from: d, reason: collision with root package name */
    private Rect f7190d;
    private boolean e;
    private boolean f;
    private final boolean g;
    private final e h;
    private final a i;

    static {
        int i;
        try {
            i = Integer.parseInt(Build.VERSION.SDK);
        } catch (NumberFormatException unused) {
            i = 10000;
        }
        k = i;
    }

    private c(Context context) {
        this.f7187a = new b(context);
        this.g = Integer.parseInt(Build.VERSION.SDK) > 3;
        this.h = new e(this.f7187a, this.g);
        this.i = new a();
    }

    public static void a(Context context) {
        if (j == null) {
            j = new c(context);
        }
    }

    public static c f() {
        return j;
    }

    public void b(Handler handler, int i) {
        if (this.f7188b == null || !this.f) {
            return;
        }
        this.h.a(handler, i);
        if (this.g) {
            this.f7188b.setOneShotPreviewCallback(this.h);
        } else {
            this.f7188b.setPreviewCallback(this.h);
        }
    }

    public Rect c() {
        if (this.f7190d == null) {
            Rect rect = new Rect(b());
            Point a2 = this.f7187a.a();
            Point d2 = this.f7187a.d();
            int i = rect.left;
            int i2 = a2.y;
            int i3 = d2.x;
            rect.left = (i * i2) / i3;
            rect.right = (rect.right * i2) / i3;
            int i4 = rect.top;
            int i5 = a2.x;
            int i6 = d2.y;
            rect.top = (i4 * i5) / i6;
            rect.bottom = (rect.bottom * i5) / i6;
            this.f7190d = rect;
        }
        return this.f7190d;
    }

    public void d() {
        Camera camera = this.f7188b;
        if (camera == null || this.f) {
            return;
        }
        camera.startPreview();
        this.f = true;
    }

    public void e() {
        Camera camera = this.f7188b;
        if (camera == null || !this.f) {
            return;
        }
        if (!this.g) {
            camera.setPreviewCallback(null);
        }
        this.f7188b.stopPreview();
        this.h.a(null, 0);
        this.i.a(null, 0);
        this.f = false;
    }

    public void a(SurfaceHolder surfaceHolder) throws IOException {
        if (this.f7188b == null) {
            Camera open = Camera.open();
            this.f7188b = open;
            if (open != null) {
                open.setPreviewDisplay(surfaceHolder);
                if (!this.e) {
                    this.e = true;
                    this.f7187a.a(this.f7188b);
                }
                this.f7187a.b(this.f7188b);
                d.b();
                return;
            }
            throw new IOException();
        }
    }

    public Rect b() {
        Point d2 = this.f7187a.d();
        if (d2 == null) {
            return null;
        }
        if (this.f7189c == null) {
            if (this.f7188b == null) {
                return null;
            }
            int i = (d2.x * 7) / 10;
            int i2 = (d2.y * 7) / 10;
            if (i2 < i) {
                i = i2;
            }
            int i3 = (d2.x - i) / 2;
            int i4 = (d2.y - i) / 2;
            this.f7189c = new Rect(i3, i4, i3 + i, i + i4);
        }
        return this.f7189c;
    }

    public void a(Activity activity) {
        int i;
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int i2 = 0;
        Camera.getCameraInfo(0, cameraInfo);
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        if (rotation != 0) {
            if (rotation == 1) {
                i2 = 90;
            } else if (rotation == 2) {
                i2 = 180;
            } else if (rotation == 3) {
                i2 = 270;
            }
        }
        if (cameraInfo.facing == 1) {
            i = (360 - ((cameraInfo.orientation + i2) % 360)) % 360;
        } else {
            i = ((cameraInfo.orientation - i2) + 360) % 360;
        }
        this.f7188b.setDisplayOrientation(i);
    }

    public void a() {
        if (this.f7188b != null) {
            d.a();
            this.f7188b.release();
            this.f7188b = null;
        }
    }

    public void a(Handler handler, int i) {
        if (this.f7188b == null || !this.f) {
            return;
        }
        this.i.a(handler, i);
        this.f7188b.autoFocus(this.i);
    }

    public PlanarYUVLuminanceSource a(byte[] bArr, int i, int i2) {
        Rect c2 = c();
        int b2 = this.f7187a.b();
        String c3 = this.f7187a.c();
        if (b2 != 16 && b2 != 17) {
            if ("yuv420p".equals(c3)) {
                return new PlanarYUVLuminanceSource(bArr, i, i2, c2.left, c2.top, c2.width(), c2.height());
            }
            throw new IllegalArgumentException("Unsupported picture format: " + b2 + '/' + c3);
        }
        return new PlanarYUVLuminanceSource(bArr, i, i2, c2.left, c2.top, c2.width(), c2.height());
    }
}
