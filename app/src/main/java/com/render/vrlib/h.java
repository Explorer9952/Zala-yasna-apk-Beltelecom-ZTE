package com.render.vrlib;

import android.content.Context;
import android.opengl.GLES20;
import com.render.vrlib.MDVRLibrary;

/* compiled from: MD360Program.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private int f2475a;

    /* renamed from: b, reason: collision with root package name */
    private int f2476b;

    /* renamed from: c, reason: collision with root package name */
    private int f2477c;

    /* renamed from: d, reason: collision with root package name */
    private int f2478d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MD360Program.java */
    /* loaded from: classes.dex */
    public static class a {
        static String a(Context context, int i) {
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES u_Texture;\nvarying vec2 v_TexCoordinate;\n\nvoid main()\n{\n    gl_FragColor =  texture2D(u_Texture, v_TexCoordinate);\n}" : "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES u_Texture;\nvarying vec2 v_TexCoordinate;\nvec3 rl = vec3 ( 0.437,0.449,0.164);\nvec3 gl = vec3 ( -0.062,-0.062,-0.024);\nvec3 bl = vec3 ( -0.048,-0.05,-0.017);\nvec3 rr = vec3 ( -0.011,-0.032,-0.007);\nvec3 gr = vec3 ( 0.377,0.761,0.009);\nvec3 br = vec3 ( -0.026,-0.093,1.234);\n\nvoid main(){\n    vec2 m_CoordLeft;\n    m_CoordLeft[0] = 0.5*v_TexCoordinate[0];\n    m_CoordLeft[1] = v_TexCoordinate[1];\n    vec2 m_CoordRight;\n    m_CoordRight[0] = 0.5*v_TexCoordinate[0]+0.5;\n    m_CoordRight[1] = v_TexCoordinate[1];\n    \n    vec3 cl = texture2D(u_Texture, m_CoordLeft).rgb;\n    vec3 cr = texture2D(u_Texture, m_CoordRight).rgb;\n    gl_FragColor =  vec4 (clamp (dot (cl, rl) + dot (cr, rr), 0.0, 1.0),\n                          clamp (dot (cl, gl) + dot (cr, gr), 0.0, 1.0),\n                          clamp (dot (cl, bl) + dot (cr, br), 0.0, 1.0),\n                          1.0);\n}" : "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying   mediump vec2 v_TexCoordinate;\n  \nuniform   lowp  samplerExternalOES u_Texture;\n  \nconst mediump vec3 luminanceWeighting = vec3(0.2125, 0.7154, 0.0721);\n\nvoid main() \n{\n    // acutance\n    vec4 color = vec4(0.0);\n    \n    int coreSize = 3;\n    float texelOffset = 1.0 / 600.0;\n    \n    float kernel[9];\n    kernel[6] = 0.0; kernel[7] = -1.0; kernel[8] = 0.0;\n    kernel[3] = -1.0; kernel[4] = 4.0; kernel[5] = -1.0;\n    kernel[0] = 0.0; kernel[1] = -1.0; kernel[2] = 0.0;\n    \n    int index = 0;\n    for(int y = 0; y<coreSize; y++)\n    {\n        for(int x=0; x<coreSize; x++)\n        {\n            vec4 currentColor=texture2D(u_Texture, v_TexCoordinate+vec2(float(-1+x)*texelOffset,float(-1+y)*texelOffset));\n            color += currentColor * kernel[index++];\n        }\n     }\n     // contrast\n     vec3 irgb  = (0.08 * color + texture2D(u_Texture, v_TexCoordinate)).rgb;\n     //vec3 irgb   = texture2D(u_Texture, v_TexCoordinate).rgb;\n     vec3 target = vec3(0.0,0.0,0.0);\n     vec3 irgb_1 = mix(target,irgb,1.1);//contrast);\n     \n     // saturation\n     lowp float luminance = dot(irgb_1, luminanceWeighting);\n     lowp vec3 greyScaleColor = vec3(luminance);\n     vec3 irgb_2 = mix(greyScaleColor, irgb_1, 1.05);//saturation);\n     \n     // brightness\n vec3 irgb_3 = irgb_2 * 1.05;\n     gl_FragColor = vec4(irgb_3, 1);\n}" : "precision mediump float;\n\nvarying vec3 v_Position; // Direction vector representing a 3D texture coordinate\nuniform samplerCube u_Texture;  // Cubemap texture sampler\n\nvec3 m_TmpCoordinate;\n\nvoid main()\n{\n    // Mirror image to be shown correctly\n    m_TmpCoordinate[0] = 1. - v_Position[0];\n    m_TmpCoordinate[1] = v_Position[1];\n    m_TmpCoordinate[2] = v_Position[2];\n\n    gl_FragColor = textureCube(u_Texture, m_TmpCoordinate);\n}" : "precision mediump float;\nuniform sampler2D u_Texture;\n  \nvarying vec2 v_TexCoordinate;\n\nvoid main() \n{\n    gl_FragColor =  texture2D(u_Texture, v_TexCoordinate);\n}" : "precision mediump float;\nuniform sampler2D u_Texture;\n  \nvarying vec2 v_TexCoordinate;\nvec2 m_TmpCoordinate;\n\nvoid main()\n{\n    m_TmpCoordinate[0] = v_TexCoordinate[0];\n    m_TmpCoordinate[1] = 1. - v_TexCoordinate[1];\n    gl_FragColor =  texture2D(u_Texture, m_TmpCoordinate);\n}";
        }
    }

    /* compiled from: CompactTouchPickAdapter.java */
    /* loaded from: classes.dex */
    public class b implements MDVRLibrary.l {

        /* renamed from: a, reason: collision with root package name */
        private final MDVRLibrary.m f2479a;

        public b(MDVRLibrary.m mVar) {
            this.f2479a = mVar;
        }

        @Override // com.render.vrlib.MDVRLibrary.l
        public void a(com.render.vrlib.w.h hVar) {
            MDVRLibrary.m mVar = this.f2479a;
            if (mVar != null) {
                mVar.onHotspotHit(hVar.a(), hVar.b());
            }
        }
    }

    public h(int i) {
        this.k = i;
    }

    public void a(Context context) {
        if (this.f != 0) {
            i();
        }
        String b2 = b(context);
        String c2 = c(context);
        this.g = com.render.vrlib.a.b.a(35633, b2);
        int a2 = com.render.vrlib.a.b.a(35632, c2);
        this.h = a2;
        int a3 = com.render.vrlib.a.b.a(this.g, a2, new String[]{"a_Position", "a_TexCoordinate"});
        this.f = a3;
        this.f2475a = GLES20.glGetUniformLocation(a3, "u_MVPMatrix");
        this.f2476b = GLES20.glGetUniformLocation(this.f, "u_MVMatrix");
        this.f2477c = GLES20.glGetUniformLocation(this.f, "u_Texture");
        this.f2478d = GLES20.glGetAttribLocation(this.f, "a_Position");
        this.e = GLES20.glGetAttribLocation(this.f, "a_TexCoordinate");
        this.i = GLES20.glGetUniformLocation(this.f, "u_STMatrix");
        this.j = GLES20.glGetUniformLocation(this.f, "u_UseSTM");
        GLES20.glGetUniformLocation(this.f, "u_IsSkybox");
    }

    public int b() {
        return this.f2475a;
    }

    protected String b(Context context) {
        return "uniform mat4 u_MVPMatrix;\t\t// A constant representing the combined model/view/projection matrix.\nuniform mat4 u_MVMatrix;\t\t// A constant representing the combined model/view matrix.\nuniform mat4 u_STMatrix;\nuniform bool u_UseSTM;\nuniform bool u_IsSkybox;\n\nattribute vec4 a_Position;\t\t// Per-vertex position information we will pass in.   \t\t\t\t\nattribute vec3 a_Normal;\t\t// Per-vertex normal information we will pass in.\nattribute vec4 a_TexCoordinate; // Per-vertex texture coordinate information we will pass in.\n\nvarying vec3 v_Position;\t\t// This will be passed into the fragment shader.\n//varying vec4 v_Color;\t\t\t// This will be passed into the fragment shader.\n//varying vec3 v_Normal;\t\t\t// This will be passed into the fragment shader.\nvarying vec2 v_TexCoordinate;   // This will be passed into the fragment shader.    \t\t\n\n// The entry point for our vertex shader.  \nvoid main()\n{\n    // Transform the vertex into eye space.\n    if(!u_IsSkybox) {\n        v_Position = vec3(u_MVMatrix * a_Position);\n    } else {\n        // When using cubemap, coordinates are the same as the position\n        v_Position = vec3(a_Position);\n    }\n  // Pass through the color.\n  //v_Color = a_Color;\n  // Pass through the texture coordinate.\n  if(u_UseSTM){\n      v_TexCoordinate = (u_STMatrix * a_TexCoordinate).xy;\n  } else {\n      v_TexCoordinate = a_TexCoordinate.xy;\n  }\n  // Transform the normal's orientation into eye space.\n    //v_Normal = vec3(u_MVMatrix * vec4(a_Normal, 0.0));\n  // gl_Position is a special variable used to store the final position.\n  // Multiply the vertex by the matrix to get the final point in normalized screen coordinates.\n  gl_Position = u_MVPMatrix * a_Position;\n}";
    }

    protected String c(Context context) {
        return a.a(context, this.k);
    }

    public int d() {
        return this.f2477c;
    }

    public int e() {
        return this.f2478d;
    }

    public int f() {
        return this.i;
    }

    public int g() {
        return this.j;
    }

    public int h() {
        return this.e;
    }

    public void i() {
        GLES20.glDeleteProgram(this.f);
        GLES20.glDeleteShader(this.g);
        GLES20.glDeleteShader(this.h);
        this.f = 0;
        this.g = 0;
        this.h = 0;
    }

    public int c() {
        return this.f2476b;
    }

    public void a() {
        GLES20.glUseProgram(this.f);
    }
}
