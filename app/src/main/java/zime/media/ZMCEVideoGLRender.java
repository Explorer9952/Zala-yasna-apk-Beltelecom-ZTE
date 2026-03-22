package zime.media;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import d.e.b.n.d;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes2.dex */
public class ZMCEVideoGLRender implements GLSurfaceView.Renderer {
    private static final int FLOAT_SIZE_BYTES = 4;
    private static final String FRAGMENT_SHADER_SOURCE_420P = "precision mediump float;varying vec2 vTextureCoord;uniform sampler2D SamplerY; uniform sampler2D SamplerU;uniform sampler2D SamplerV;const mat3 yuv2rgb = mat3(1, 0, 1.2802,1, -0.214821, -0.380589,1, 2.127982, 0);void main() {        vec3 yuv = vec3(1.1643 * (texture2D(SamplerY, vTextureCoord).r - 0.0625),                    texture2D(SamplerU, vTextureCoord).r - 0.5,                    texture2D(SamplerV, vTextureCoord).r - 0.5);    vec3 rgb = yuv * yuv2rgb;        gl_FragColor = vec4(rgb, 1.0);} ";
    private static final String FRAGMENT_SHADER_SOURCE_420SP = "precision mediump float;varying vec2 vTextureCoord;uniform sampler2D SamplerY; uniform sampler2D SamplerUV;const mat3 yuv2rgb = mat3(1, 0, 1.2802,1, -0.214821, -0.380589,1, 2.127982, 0);void main() {        vec3 yuv = vec3(1.1643 * (texture2D(SamplerY, vTextureCoord).r - 0.0625),                    texture2D(SamplerUV, vTextureCoord).a - 0.5,                    texture2D(SamplerUV, vTextureCoord).r - 0.5);    vec3 rgb = yuv * yuv2rgb;        gl_FragColor = vec4(rgb, 1.0);} ";
    private static final int SHORT_SIZE_BYTES = 2;
    private static final String VERTEX_SHADER_SOURCE = "uniform mat4 u_MVPMatrix;\nattribute vec4 aPosition;\nattribute vec2 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = u_MVPMatrix*aPosition;\n  vTextureCoord = aTextureCoord;\n}\n";
    private int mBufferPositionU;
    private int mBufferPositionUV;
    private int mBufferPositionV;
    private int mBufferPositionY;
    private Context mContext;
    private FloatBuffer mCoordsArray;
    private ShortBuffer mIndices;
    private int mMVPMatrixHandle;
    private int mProgram;
    private FloatBuffer mTriangleVertices;
    private FloatBuffer mVertexArray;
    private int mWidthStrideUV;
    private int mWidthStrideY;
    private int maPositionHandle;
    private int maTextureHandle;
    private int muSamplerUHandle;
    private int muSamplerUVHandle;
    private int muSamplerVHandle;
    private int muSamplerYHandle;
    private static final String TAG = ZMCEVideoGLRender.class.getCanonicalName();
    private static final float[] TRIANFLE_VERTICES_DATA = {1.0f, -1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 0.0f, 1.0f};
    private static final short[] INDICES_DATA = {0, 1, 2, 2, 3, 0};
    private static float[] vertexPositions = {1.0f, -1.0f, 0.0f, 1.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, -1.0f, -1.0f, 0.0f};
    private static float[] textureCoords = {1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private float[] mRotationMatrix = new float[16];
    private float mRotateDegree = 0.0f;
    private GLSurfaceView mGlSurfaceView = null;
    private boolean mYUV420P = true;
    private boolean mSetupOpengl = false;
    private int initCnt = 0;
    private boolean mAmlogicEnable = false;
    private boolean mUserMediaCodec = false;
    private int mYUVType = 0;
    private int[] mTextureY = new int[1];
    private int[] mTextureU = new int[1];
    private int[] mTextureV = new int[1];
    private int[] mTextureUV = new int[1];
    private int mViewWidth = 320;
    private int mViewHeight = PsExtractor.VIDEO_STREAM_MASK;
    private int mViewX = 0;
    private int mViewY = 0;
    private int mBufferWidthY = 320;
    private int mBufferHeightY = PsExtractor.VIDEO_STREAM_MASK;
    private int mBufferHeightUV = 120;
    ByteBuffer mBuffer = null;

    public ZMCEVideoGLRender() {
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(TRIANFLE_VERTICES_DATA.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mTriangleVertices = asFloatBuffer;
        asFloatBuffer.put(TRIANFLE_VERTICES_DATA).position(0);
        this.mVertexArray = ByteBuffer.allocateDirect(vertexPositions.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mCoordsArray = ByteBuffer.allocateDirect(textureCoords.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        ShortBuffer asShortBuffer = ByteBuffer.allocateDirect(INDICES_DATA.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer();
        this.mIndices = asShortBuffer;
        asShortBuffer.put(INDICES_DATA).position(0);
    }

    private void checkGlError(String str) {
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError == 0) {
                return;
            }
            d.d(TAG, str + "ZMCEVideoGLPreview---Error: glError " + glGetError);
        }
    }

    private int createProgram(String str, String str2) {
        int loadShader;
        int loadShader2 = loadShader(35633, str);
        if (loadShader2 == 0 || (loadShader = loadShader(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, loadShader2);
            checkGlError("glAttachShader");
            GLES20.glAttachShader(glCreateProgram, loadShader);
            checkGlError("glAttachShader");
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                d.d(TAG, "Could not link program: ");
                d.d(TAG, GLES20.glGetProgramInfoLog(glCreateProgram));
                GLES20.glDeleteProgram(glCreateProgram);
                return 0;
            }
        }
        return glCreateProgram;
    }

    private int loadShader(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        if (glCreateShader == 0) {
            return glCreateShader;
        }
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        d.d(TAG, "Could not compile shader " + i + ":");
        d.d(TAG, GLES20.glGetShaderInfoLog(glCreateShader));
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }

    private void setViewport() {
        float f;
        float f2;
        synchronized (this) {
            int i = this.mBufferWidthY;
            int i2 = this.mBufferHeightY;
            if (this.mRotateDegree % 180.0f != 0.0f) {
                i2 = i;
                i = i2;
            }
            f = i / i2;
            f2 = (this.mBufferWidthY / this.mWidthStrideY) * 0.998f;
        }
        int width = this.mGlSurfaceView.getWidth();
        int height = this.mGlSurfaceView.getHeight();
        int i3 = (int) (width / f);
        this.mViewWidth = i3 > height ? (int) (height * f) : width;
        if (i3 > height) {
            i3 = height;
        }
        this.mViewHeight = i3;
        this.mViewX = (width - this.mViewWidth) >> 1;
        this.mViewY = (height - i3) >> 1;
        float[] fArr = textureCoords;
        fArr[2] = f2;
        fArr[0] = f2;
        this.mVertexArray.put(vertexPositions);
        this.mCoordsArray.put(textureCoords);
        this.mVertexArray.position(0);
        GLES20.glVertexAttribPointer(this.maPositionHandle, 3, 5126, false, 12, (Buffer) this.mVertexArray);
        this.mCoordsArray.position(0);
        GLES20.glVertexAttribPointer(this.maTextureHandle, 2, 5126, false, 8, (Buffer) this.mCoordsArray);
    }

    private void setupOpengl(boolean z) {
        int i;
        if (this.mYUV420P == z && this.mSetupOpengl && this.initCnt >= 3) {
            this.initCnt = 0;
            return;
        }
        this.initCnt++;
        this.mYUV420P = z;
        GLES20.glEnable(3042);
        GLES20.glDisable(2929);
        GLES20.glDisable(3024);
        GLES20.glDisable(2960);
        GLES20.glDisable(3024);
        this.mProgram = createProgram(VERTEX_SHADER_SOURCE, this.mYUV420P ? FRAGMENT_SHADER_SOURCE_420P : FRAGMENT_SHADER_SOURCE_420SP);
        int i2 = this.mProgram;
        if (i2 == 0) {
            return;
        }
        this.maPositionHandle = GLES20.glGetAttribLocation(i2, "aPosition");
        checkGlError("glGetAttribLocation aPosition");
        if (this.maPositionHandle == -1) {
            d.d(TAG, "Could not get attrib location for aPosition");
        }
        this.maTextureHandle = GLES20.glGetAttribLocation(this.mProgram, "aTextureCoord");
        checkGlError("glGetAttribLocation aTextureCoord");
        if (this.maTextureHandle == -1) {
            d.d(TAG, "Could not get attrib location for aTextureCoord");
        }
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.mProgram, "SamplerY");
        this.muSamplerYHandle = glGetUniformLocation;
        if (glGetUniformLocation == -1) {
            d.d(TAG, "Could not get uniform location for SamplerY");
        }
        if (this.mYUV420P) {
            int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.mProgram, "SamplerU");
            this.muSamplerUHandle = glGetUniformLocation2;
            if (glGetUniformLocation2 == -1) {
                d.d(TAG, "Could not get uniform location for SamplerU");
            }
            int glGetUniformLocation3 = GLES20.glGetUniformLocation(this.mProgram, "SamplerV");
            this.muSamplerVHandle = glGetUniformLocation3;
            if (glGetUniformLocation3 == -1) {
                d.d(TAG, "Could not get uniform location for SamplerV");
            }
        } else {
            int glGetUniformLocation4 = GLES20.glGetUniformLocation(this.mProgram, "SamplerUV");
            this.muSamplerUVHandle = glGetUniformLocation4;
            if (glGetUniformLocation4 == -1) {
                d.d(TAG, "Could not get uniform location for SamplerUV 2");
            }
        }
        int glGetUniformLocation5 = GLES20.glGetUniformLocation(this.mProgram, "u_MVPMatrix");
        this.mMVPMatrixHandle = glGetUniformLocation5;
        if (glGetUniformLocation5 == -1) {
            throw new RuntimeException("Could not get uniform location for SamplerV");
        }
        GLES20.glEnableVertexAttribArray(this.maPositionHandle);
        checkGlError("glEnableVertexAttribArray maPositionHandle");
        GLES20.glEnableVertexAttribArray(this.maTextureHandle);
        checkGlError("glEnableVertexAttribArray maTextureHandle");
        GLES20.glGenTextures(1, this.mTextureY, 0);
        GLES20.glBindTexture(3553, this.mTextureY[0]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        if (this.mYUV420P) {
            GLES20.glGenTextures(1, this.mTextureU, 0);
            GLES20.glBindTexture(3553, this.mTextureU[0]);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLES20.glGenTextures(1, this.mTextureV, 0);
            i = this.mTextureV[0];
        } else {
            GLES20.glGenTextures(1, this.mTextureUV, 0);
            i = this.mTextureUV[0];
        }
        GLES20.glBindTexture(3553, i);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
    }

    public void copyTheRenderData(byte[] bArr, int i) {
        synchronized (this) {
            if (this.mBuffer == null) {
                this.mBuffer = ByteBuffer.allocateDirect(i);
            }
            this.mBuffer.clear();
            this.mBuffer.put(bArr, 0, i);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x001d, code lost:
    
        if (r12.mYUV420P == false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x001f, code lost:
    
        android.opengl.GLES20.glDeleteProgram(r12.mProgram);
        setupOpengl(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0041, code lost:
    
        if (r12.mYUV420P == false) goto L13;
     */
    @Override // android.opengl.GLSurfaceView.Renderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onDrawFrame(javax.microedition.khronos.opengles.GL10 r13) {
        /*
            Method dump skipped, instructions count: 316
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: zime.media.ZMCEVideoGLRender.onDrawFrame(javax.microedition.khronos.opengles.GL10):void");
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        this.initCnt = 0;
        this.mSetupOpengl = false;
        setViewport();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        setupOpengl(this.mYUV420P);
        this.mSetupOpengl = true;
    }

    public void requestRender() {
        this.mGlSurfaceView.requestRender();
    }

    public void setAmlogicEnable(boolean z) {
        this.mAmlogicEnable = z;
    }

    public void setBuffer(int i, int i2, int i3, int i4) {
        synchronized (this) {
            if (i3 == this.mWidthStrideY && i4 == this.mWidthStrideUV) {
                return;
            }
            if (this.mBuffer != null) {
                this.mBuffer.clear();
                this.mBuffer = null;
            }
            this.mWidthStrideY = i3;
            this.mWidthStrideUV = i4;
            this.mBufferWidthY = i;
            this.mBufferHeightY = i2;
            int i5 = i2 >> 1;
            this.mBufferHeightUV = i5;
            this.mBufferPositionY = 0;
            int i6 = i3 * i2;
            this.mBufferPositionU = i6;
            this.mBufferPositionV = i6 + (i4 * i5);
            this.mBufferPositionUV = i3 * i2;
            setViewport();
        }
    }

    public void setGLSurface(GLSurfaceView gLSurfaceView) {
        this.mGlSurfaceView = gLSurfaceView;
        gLSurfaceView.setEGLContextClientVersion(2);
        this.mGlSurfaceView.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        this.mGlSurfaceView.setRenderer(this);
        this.mGlSurfaceView.getHolder().setFormat(-3);
        this.mGlSurfaceView.getHolder().setType(2);
        this.mGlSurfaceView.setRenderMode(0);
    }

    public void setRotateDegree(float f) {
        if (((int) this.mRotateDegree) != f) {
            this.mRotateDegree = f;
            setViewport();
        }
    }

    public void useMediaCodecInfo(boolean z, int i) {
        this.mUserMediaCodec = z;
        this.mYUVType = i;
    }
}
