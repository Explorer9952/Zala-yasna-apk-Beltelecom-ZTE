package ijk.media.player.render;

import android.content.Context;
import android.opengl.GLES20;
import android.util.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: AFVDrawer.java */
/* loaded from: classes2.dex */
public abstract class a {
    private static final String g = "a";

    /* renamed from: a, reason: collision with root package name */
    protected int f8118a;

    /* renamed from: b, reason: collision with root package name */
    protected int f8119b;

    /* renamed from: c, reason: collision with root package name */
    protected int f8120c;

    /* renamed from: d, reason: collision with root package name */
    protected int f8121d;
    protected Context e;
    protected int f;
    private FloatBuffer j;
    private FloatBuffer k;
    private int l;
    private int m;
    private float[] h = {-1.0f, 1.0f, 0.0f, -1.0f, -1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, -1.0f, 0.0f};
    private float[] i = {0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f};
    private float n = 0.0f;
    private float[] o = d.a();

    public a(Context context) {
        this.e = context;
        c();
    }

    public void a(float[] fArr) {
        System.arraycopy(fArr, 0, this.i, 0, 8);
    }

    public int b() {
        return this.m;
    }

    public void c() {
        FloatBuffer put = ByteBuffer.allocateDirect(this.h.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(this.h);
        this.j = put;
        put.position(0);
        FloatBuffer put2 = ByteBuffer.allocateDirect(this.i.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(this.i);
        this.k = put2;
        put2.position(0);
    }

    public void d() {
        f();
        c();
        e();
        g();
        h();
        i();
    }

    protected void e() {
        GLES20.glUseProgram(this.f);
    }

    protected void f() {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(19798);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g() {
        GLES20.glEnableVertexAttribArray(this.f8118a);
        GLES20.glVertexAttribPointer(this.f8118a, 3, 5126, false, 0, (Buffer) this.j);
        GLES20.glUniformMatrix4fv(this.f8119b, 1, false, this.o, 0);
        GLES20.glEnableVertexAttribArray(this.f8120c);
        GLES20.glVertexAttribPointer(this.f8120c, 2, 5126, false, 0, (Buffer) this.k);
        GLES20.glUniform1i(this.f8121d, 0);
    }

    protected void h() {
        GLES20.glActiveTexture(b() + 33984);
        GLES20.glBindTexture(3553, a());
        GLES20.glUniform1i(this.f8121d, b());
    }

    protected void i() {
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.f8118a);
        GLES20.glDisableVertexAttribArray(this.f8120c);
        GLES20.glBindTexture(3553, 0);
    }

    public int a() {
        return this.l;
    }

    public void b(int i) {
        this.m = i;
    }

    public void a(int i) {
        this.l = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, String str2) {
        int a2 = e.a(str, str2);
        this.f = a2;
        int glGetAttribLocation = GLES20.glGetAttribLocation(a2, "aPosition");
        this.f8118a = glGetAttribLocation;
        if (glGetAttribLocation == -1) {
            Log.e(g, " GLES20.glGetUniformLocation mPositionHandler failed");
        }
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.f, "uMatrix");
        this.f8119b = glGetUniformLocation;
        if (glGetUniformLocation == -1) {
            Log.e(g, " GLES20.glGetUniformLocation mMatrixHandler failed");
        }
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.f, "aTexCoord");
        this.f8120c = glGetAttribLocation2;
        if (glGetAttribLocation2 == -1) {
            Log.e(g, " GLES20.glGetUniformLocation mCoordHandler failed");
        }
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.f, "uTexture");
        this.f8121d = glGetUniformLocation2;
        if (glGetUniformLocation2 == -1) {
            Log.e(g, " GLES20.glGetUniformLocation mTextureHandler failed");
        }
    }
}
