package ijk.media.player.render;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.video.androidsdk.login.impl.IIPTVLogin;
import java.lang.reflect.Array;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes2.dex */
public class FVGlSurfaceView extends GLSurfaceView implements GLSurfaceView.Renderer {

    /* renamed from: c, reason: collision with root package name */
    private static final String f8114c = FVGlSurfaceView.class.getSimpleName();
    private int A;
    private int B;
    private int C;
    private long D;
    private long E;
    private b F;

    /* renamed from: a, reason: collision with root package name */
    int f8115a;

    /* renamed from: b, reason: collision with root package name */
    public long f8116b;

    /* renamed from: d, reason: collision with root package name */
    private int f8117d;
    private int e;
    private int f;
    private int g;
    private int[] h;
    private SurfaceTexture i;
    private a j;
    private int k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private String p;
    private float[][] q;
    private boolean r;
    private float[] s;
    private long t;
    private long u;
    private int v;
    private ijk.media.player.render.b w;
    private Surface x;
    private long y;
    private Context z;

    /* loaded from: classes2.dex */
    public interface a {
        void onSurfaceCreated(Surface surface);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(SurfaceHolder surfaceHolder);
    }

    public FVGlSurfaceView(Context context) {
        super(context);
        this.f8117d = 1920;
        this.e = IIPTVLogin.REQUESTID_80;
        this.f = 1920;
        this.g = IIPTVLogin.REQUESTID_80;
        this.h = new int[2];
        this.k = 1920;
        this.l = IIPTVLogin.REQUESTID_80;
        this.o = false;
        this.f8115a = 0;
        this.r = false;
        this.s = new float[16];
        this.t = SystemClock.elapsedRealtime();
        this.u = 0L;
        this.v = 0;
        this.y = 0L;
        this.B = 0;
        this.C = 0;
        this.D = 0L;
        this.E = 0L;
        this.f8116b = 0L;
        Log.d(f8114c, "FVGlSurfaceView: 111111111111");
        a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int b(FVGlSurfaceView fVGlSurfaceView) {
        int i = fVGlSurfaceView.v;
        fVGlSurfaceView.v = i + 1;
        return i;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        SurfaceTexture surfaceTexture = this.i;
        if (surfaceTexture != null) {
            surfaceTexture.updateTexImage();
        }
        this.w.d();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        this.m = i;
        this.n = i2;
        Log.d(f8114c, "onSurfaceChanged width: " + this.m + "; height: " + i2);
        d();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        Log.d(f8114c, "onSurfaceCreated: gl 111111111111");
        this.w.j();
        a();
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        super.surfaceCreated(surfaceHolder);
        Log.d(f8114c, "surfaceCreated");
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        super.surfaceDestroyed(surfaceHolder);
        Log.d(f8114c, "surfaceDestroyed");
        b bVar = this.F;
        if (bVar != null) {
            bVar.a(surfaceHolder);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ long a(FVGlSurfaceView fVGlSurfaceView) {
        long j = fVGlSurfaceView.u;
        fVGlSurfaceView.u = 1 + j;
        return j;
    }

    private void d() {
        int i = this.f;
        int i2 = this.g;
        int i3 = this.m;
        float f = i3 / this.n;
        float f2 = i / i2;
        if (i > i3 && f2 >= f) {
            i2 = (i2 * i3) / i;
            i = i3;
        } else {
            int i4 = this.g;
            int i5 = this.n;
            if (i4 > i5 && f2 < f) {
                i = (this.f * i5) / i4;
                i2 = i5;
            }
        }
        GLES20.glViewport((this.m - i) / 2, (this.n - i2) / 2, i, i2);
    }

    public int b() {
        return this.A;
    }

    private void a(Context context) {
        Log.d(f8114c, "initParams");
        this.z = context.getApplicationContext();
        setEGLContextClientVersion(2);
        setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        setZOrderOnTop(true);
        setZOrderMediaOverlay(true);
        setRenderer(this);
        setPreserveEGLContextOnPause(true);
        getHolder().setFormat(-2);
        setRenderMode(0);
        this.w = new ijk.media.player.render.b(getContext());
    }

    public void b(String str) {
        long j = 0;
        long j2 = 0;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        double d2 = 0.0d;
        int i3 = 1;
        int i4 = 0;
        while (i2 < str.length()) {
            if (str.charAt(i2) >= '0' && str.charAt(i2) <= '9') {
                if (j2 == j) {
                    i4 = (i4 * 10) + ((str.charAt(i2) - '0') * i3);
                } else {
                    double charAt = str.charAt(i2) - '0';
                    double d3 = j2;
                    Double.isNaN(charAt);
                    Double.isNaN(d3);
                    double d4 = i3;
                    Double.isNaN(d4);
                    d2 += (charAt / d3) * d4;
                    j2 *= 10;
                }
                z = true;
            } else if (str.charAt(i2) == '.') {
                j2 = 10;
            } else if (str.charAt(i2) == '-') {
                i3 = -1;
            } else if (z) {
                if (i == 0) {
                    this.f8115a = i4;
                    this.q = (float[][]) Array.newInstance((Class<?>) float.class, i4, 9);
                } else {
                    double d5 = i4;
                    Double.isNaN(d5);
                    double d6 = d5 + d2;
                    if (i > this.f8115a * 2 * 9) {
                        break;
                    }
                    int i5 = i - 1;
                    if (i5 % 18 < 9) {
                        this.q[i5 / 18][i5 % 9] = (float) d6;
                    }
                    j2 = 0;
                    d2 = 0.0d;
                    i3 = 1;
                }
                i++;
                z = false;
                i4 = 0;
            }
            i2++;
            j = 0;
        }
        if (i >= this.f8115a * 2 * 9) {
            this.r = true;
        }
    }

    public void a(a aVar) {
        this.j = aVar;
    }

    public void a() {
        Log.d(f8114c, "initOESTexture");
        int[] iArr = this.h;
        GLES20.glGenTextures(iArr.length, iArr, 0);
        GLES20.glActiveTexture(b() + 33984);
        GLES20.glBindTexture(36197, this.h[0]);
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, 10240, 9728.0f);
        GLES20.glTexParameterf(36197, 10242, 33071.0f);
        GLES20.glTexParameterf(36197, 10243, 33071.0f);
        this.w.a(this.h[0]);
        this.w.b(b());
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.h[0]);
        this.i = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new c(this));
        Surface surface = new Surface(this.i);
        this.x = surface;
        a aVar = this.j;
        if (aVar != null) {
            aVar.onSurfaceCreated(surface);
        }
    }

    private void b(int i) {
        if (!this.r) {
            Matrix.setIdentityM(this.s, 0);
        } else {
            float[] fArr = this.s;
            float[][] fArr2 = this.q;
            fArr[0] = fArr2[i][0];
            fArr[1] = fArr2[i][1];
            fArr[2] = fArr2[i][2];
            fArr[3] = 0.0f;
            fArr[4] = fArr2[i][3];
            fArr[5] = fArr2[i][4];
            fArr[6] = fArr2[i][5];
            fArr[7] = 0.0f;
            fArr[8] = fArr2[i][6];
            fArr[9] = fArr2[i][7];
            fArr[10] = fArr2[i][8];
            fArr[11] = 0.0f;
            fArr[12] = 0.0f;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 1.0f;
        }
        if (this.o) {
            Log.d(f8114c, "setMatrixY: matrixY:");
            for (int i2 = 0; i2 < 4; i2++) {
                String str = f8114c;
                StringBuilder sb = new StringBuilder();
                sb.append("setMatrixY: ");
                int i3 = i2 * 4;
                sb.append(this.s[i3]);
                sb.append(" ");
                sb.append(this.s[i3 + 1]);
                sb.append(" ");
                sb.append(this.s[i3 + 2]);
                sb.append(" ");
                sb.append(this.s[i3 + 3]);
                Log.d(str, sb.toString());
            }
            Log.d(f8114c, "setMatrixY: matrixY:");
            for (int i4 = 0; i4 < 4; i4++) {
                String str2 = f8114c;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("setMatrixY: ");
                int i5 = i4 * 4;
                sb2.append(this.s[i5]);
                sb2.append(" ");
                sb2.append(this.s[i5 + 1]);
                sb2.append(" ");
                sb2.append(this.s[i5 + 2]);
                sb2.append(" ");
                sb2.append(this.s[i5 + 3]);
                Log.d(str2, sb2.toString());
            }
        }
    }

    public FVGlSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8117d = 1920;
        this.e = IIPTVLogin.REQUESTID_80;
        this.f = 1920;
        this.g = IIPTVLogin.REQUESTID_80;
        this.h = new int[2];
        this.k = 1920;
        this.l = IIPTVLogin.REQUESTID_80;
        this.o = false;
        this.f8115a = 0;
        this.r = false;
        this.s = new float[16];
        this.t = SystemClock.elapsedRealtime();
        this.u = 0L;
        this.v = 0;
        this.y = 0L;
        this.B = 0;
        this.C = 0;
        this.D = 0L;
        this.E = 0L;
        this.f8116b = 0L;
        Log.d(f8114c, "FVGlSurfaceView: 22222222222");
        a(context);
    }

    public void a(String str) {
        if (str != null && str.length() != 0) {
            this.p = str;
            b(str);
        } else {
            Log.w(f8114c, "setMatrixYArray failed");
            this.w.k();
        }
    }

    public void a(int i) {
        Log.d(f8114c, "setMatrixId " + i);
        if (i < 0 || i >= this.f8115a) {
            return;
        }
        b(i);
        float[] fArr = new float[16];
        Matrix.invertM(fArr, 0, this.s, 0);
        if (this.o) {
            Log.d(f8114c, "changeCameraMatrixY: matrixYInv:");
            for (int i2 = 0; i2 < 4; i2++) {
                String str = f8114c;
                StringBuilder sb = new StringBuilder();
                sb.append("changeCameraMatrixY: ");
                int i3 = i2 * 4;
                sb.append(fArr[i3]);
                sb.append(" ");
                sb.append(fArr[i3 + 1]);
                sb.append(" ");
                sb.append(fArr[i3 + 2]);
                sb.append(" ");
                sb.append(fArr[i3 + 3]);
                Log.d(str, sb.toString());
            }
        }
        float[] fArr2 = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        float[] fArr3 = new float[16];
        for (int i4 = 0; i4 < 4; i4++) {
            int i5 = i4 * 4;
            int i6 = i4 * 2;
            fArr3[i5] = fArr2[i6] * 1920.0f;
            fArr3[i5 + 1] = fArr2[i6 + 1] * 1080.0f;
            fArr3[i5 + 2] = 1.0f;
            fArr3[i5 + 3] = 0.0f;
        }
        if (this.o) {
            Log.d(f8114c, "changeCameraMatrixY: tmp:");
            for (int i7 = 0; i7 < 4; i7++) {
                String str2 = f8114c;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("changeCameraMatrixY: ");
                int i8 = i7 * 4;
                sb2.append(fArr3[i8]);
                sb2.append(" ");
                sb2.append(fArr3[i8 + 1]);
                sb2.append(" ");
                sb2.append(fArr3[i8 + 2]);
                sb2.append(" ");
                sb2.append(fArr3[i8 + 3]);
                Log.d(str2, sb2.toString());
            }
        }
        float[] fArr4 = new float[16];
        Matrix.transposeM(fArr4, 0, fArr3, 0);
        if (this.o) {
            Log.d(f8114c, "changeCameraMatrixY: tmpTrans:");
            for (int i9 = 0; i9 < 4; i9++) {
                String str3 = f8114c;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("changeCameraMatrixY: ");
                int i10 = i9 * 4;
                sb3.append(fArr4[i10]);
                sb3.append(" ");
                sb3.append(fArr4[i10 + 1]);
                sb3.append(" ");
                sb3.append(fArr4[i10 + 2]);
                sb3.append(" ");
                sb3.append(fArr4[i10 + 3]);
                Log.d(str3, sb3.toString());
            }
        }
        float[] fArr5 = new float[16];
        Matrix.multiplyMM(fArr5, 0, fArr4, 0, fArr, 0);
        if (this.o) {
            Log.d(f8114c, "changeCameraMatrixY: res:");
            for (int i11 = 0; i11 < 4; i11++) {
                String str4 = f8114c;
                StringBuilder sb4 = new StringBuilder();
                sb4.append("changeCameraMatrixY: ");
                int i12 = i11 * 4;
                sb4.append(fArr5[i12]);
                sb4.append(" ");
                sb4.append(fArr5[i12 + 1]);
                sb4.append(" ");
                sb4.append(fArr5[i12 + 2]);
                sb4.append(" ");
                sb4.append(fArr5[i12 + 3]);
                Log.d(str4, sb4.toString());
            }
        }
        for (int i13 = 0; i13 < 4; i13++) {
            int i14 = i13 * 2;
            int i15 = i13 + 8;
            fArr2[i14] = (fArr5[i13] / fArr5[i15]) / 1920.0f;
            fArr2[i14 + 1] = (fArr5[i13 + 4] / fArr5[i15]) / 1080.0f;
        }
        this.w.a(fArr2);
    }
}
