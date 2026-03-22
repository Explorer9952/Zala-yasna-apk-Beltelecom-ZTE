package com.render.vrlib.j;

import android.graphics.Rect;
import android.opengl.GLES20;

/* compiled from: MDDrawingCache.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private int f2502a;

    /* renamed from: b, reason: collision with root package name */
    private int f2503b;

    /* renamed from: c, reason: collision with root package name */
    private int f2504c;

    /* renamed from: d, reason: collision with root package name */
    private Rect f2505d = new Rect();
    private int[] e = new int[1];

    private void b(int i, int i2) {
        if (this.f2505d.width() == i && this.f2505d.height() == i2) {
            return;
        }
        c(i, i2);
        this.f2505d.set(0, 0, i, i2);
    }

    private void c(int i, int i2) {
        int i3 = this.f2502a;
        if (i3 != 0) {
            GLES20.glDeleteTextures(1, new int[]{i3}, 0);
        }
        int i4 = this.f2504c;
        if (i4 != 0) {
            GLES20.glDeleteRenderbuffers(1, new int[]{i4}, 0);
        }
        int i5 = this.f2503b;
        if (i5 != 0) {
            GLES20.glDeleteFramebuffers(1, new int[]{i5}, 0);
        }
        GLES20.glGetIntegerv(36006, this.e, 0);
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        this.f2503b = iArr[0];
        com.render.vrlib.a.b.a("Multi Fish Eye frame buffer");
        int[] iArr2 = {0};
        GLES20.glGenRenderbuffers(1, iArr2, 0);
        GLES20.glBindRenderbuffer(36161, iArr2[0]);
        GLES20.glRenderbufferStorage(36161, 33189, i, i2);
        this.f2504c = iArr2[0];
        com.render.vrlib.a.b.a("Multi Fish Eye renderer buffer");
        int[] iArr3 = {0};
        GLES20.glGenTextures(1, iArr3, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, iArr3[0]);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, null);
        this.f2502a = iArr3[0];
        com.render.vrlib.a.b.a("Multi Fish Eye texture");
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f2502a, 0);
        GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, iArr2[0]);
        com.render.vrlib.a.b.a("Multi Fish Eye attach");
        int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
        if (glCheckFramebufferStatus != 36053) {
            String valueOf = String.valueOf(Integer.toHexString(glCheckFramebufferStatus));
            throw new RuntimeException(valueOf.length() != 0 ? "Framebuffer is not complete: ".concat(valueOf) : "Framebuffer is not complete: ");
        }
        GLES20.glBindFramebuffer(36160, this.e[0]);
        com.render.vrlib.a.b.a("Multi Fish Eye attach");
    }

    public void a(int i, int i2) {
        b(i, i2);
        GLES20.glGetIntegerv(36006, this.e, 0);
        GLES20.glBindFramebuffer(36160, this.f2503b);
    }

    public int a() {
        return this.f2502a;
    }

    public void b() {
        GLES20.glBindFramebuffer(36160, this.e[0]);
    }
}
