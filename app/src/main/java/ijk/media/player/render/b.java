package ijk.media.player.render;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;

/* compiled from: FVDrawer.java */
/* loaded from: classes2.dex */
public class b extends a {
    private byte g;
    private int h;
    private int i;
    private String j;
    private String k;
    private float[] l;
    private int m;

    public b(Context context) {
        super(context);
        this.g = Byte.MAX_VALUE;
        this.h = 1280;
        this.i = 300;
        this.j = "attribute vec4 aPosition;attribute vec2 aTexCoord;uniform mat4 uMatrix;uniform mat4 vCoordMatrix;varying vec2 vTexCoord;void main(){gl_Position = uMatrix * aPosition;vTexCoord =(vCoordMatrix * vec4(aTexCoord,0,1)).xy;}";
        this.k = "#extension GL_OES_EGL_image_external : require \r\nprecision mediump float;varying vec2 vTexCoord;uniform samplerExternalOES uTexture;void main(){gl_FragColor = texture2D(uTexture, vTexCoord);}";
        this.l = new float[16];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ijk.media.player.render.a
    public void g() {
        super.g();
        GLES20.glUniformMatrix4fv(this.m, 1, false, this.l, 0);
    }

    @Override // ijk.media.player.render.a
    protected void h() {
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, a());
        GLES20.glUniform1i(this.f8121d, 0);
    }

    @Override // ijk.media.player.render.a
    protected void i() {
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.f8118a);
        GLES20.glDisableVertexAttribArray(this.f8120c);
    }

    public void j() {
        a(this.j, this.k);
        this.m = GLES20.glGetUniformLocation(this.f, "vCoordMatrix");
        Matrix.setIdentityM(this.l, 0);
        if (this.m == -1) {
            Log.e("OesDrawer", " GLES20.glGetUniformLocation mCoordMatrixHandler failed");
        }
    }

    public void k() {
        Matrix.setIdentityM(this.l, 0);
        float[] fArr = this.l;
        fArr[5] = -1.0f;
        Matrix.translateM(fArr, 0, 0.0f, -1.0f, 0.0f);
    }
}
