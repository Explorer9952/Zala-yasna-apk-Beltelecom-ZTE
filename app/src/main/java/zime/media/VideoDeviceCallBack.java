package zime.media;

import android.app.Activity;
import android.graphics.ImageFormat;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.hardware.Camera;
import android.os.Build;
import android.view.SurfaceHolder;
import com.zte.ucs.tvcall.ocx.OcxEventCallBack;
import d.e.b.n.d;
import ijk.media.player.IjkMediaPlayer;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public class VideoDeviceCallBack {
    private static final String TAG = "VideoDeviceCallBack";
    public static final int ZIME_CAMERAOPEN_ERROR = 402;
    public static final int enumZIME_AMLOGICHARDWEAR = 5;
    public static final int enumZIME_GOTAEXTERNENCODER = 4;
    public static final int enumZIME_MTKHARDWEAR = 3;
    public static final int enumZIME_MediaCodec = 6;
    public static final int enumZIME_MstarHardwareCodec = 2;
    public static final int enumZIME_NvidiaHARDWEAR = 1;
    public static final int enumZIME_SOFTWEAR = 0;
    private static int mCodecType = 4;
    private static ZMCEVideoGLRender mRender = null;
    private static SurfaceHolder mSurfaceHolder = null;
    private static ZMCEVideoGLRender[] mVideoGLRenderArray = new ZMCEVideoGLRender[10];
    private static int sSensorOrientation = 0;
    private static Activity s_CurActivity = null;
    private static int s_CurOrientation = -1;
    private static int s_Degree = 0;
    private static int videoCurrentValue = 1;
    public static final int videoValue_multi = 2;
    public static final int videoValue_single = 1;
    public static final int videoValue_user = 3;
    private int mFrameLen;
    private byte[] mFrameYUV;
    private byte[] mRawData;
    private boolean bOnlyAudio = false;
    private Camera mCamera = null;
    private int mCameraNum = 0;
    private Camera.CameraInfo mCameraInfo = new Camera.CameraInfo();
    private boolean mCapReady = false;
    private int mPlayWidth = 0;
    private int mPlayHeight = 0;
    private int mRemoteDisplayEnable = -1;
    private boolean mUseMetaMode = false;
    private int mMetaDataLen = 0;
    private String KeyPreviewCallBackInMetaData = "preview-callback-in-metadata-enable";
    private String KeyPreviewCallBackInMetaDataLenth = "preview-callback-in-metadata-length";
    Matrix mMatrix = null;
    Paint mPaint = null;
    private int iFrameFlag = 0;

    public static void SetCodecType(int i) {
        mCodecType = i;
    }

    public static void SetCurActivity(Activity activity) {
        d.c(TAG, "========SetCurActivity begin=============");
        s_CurActivity = activity;
        s_CurOrientation = activity.getRequestedOrientation();
        try {
            a aVar = new a(s_CurActivity);
            if (aVar.canDetectOrientation()) {
                aVar.enable();
            }
        } catch (Exception e) {
            d.b(TAG, "SetCurActivity OrientationEventListener error!", e);
        }
        d.c(TAG, "========SetCurActivity done=============");
    }

    public static void SetRender(ZMCEVideoGLRender zMCEVideoGLRender) {
        d.c(TAG, "=============SetRender done================");
        mRender = zMCEVideoGLRender;
    }

    private void compareParams(Camera.Parameters parameters, Camera.Parameters parameters2) {
        if (parameters.getPreviewSize().width == parameters2.getPreviewSize().width && parameters.getPreviewSize().height == parameters2.getPreviewSize().height) {
            return;
        }
        d.d(TAG, "warning:ProducerStart userd set size:" + parameters2.getPreviewSize().width + "x" + parameters2.getPreviewSize().height + ",camera not supported and changed to:" + parameters.getPreviewSize().width + "x" + parameters.getPreviewSize().height);
    }

    public static SurfaceHolder getLSurfaceHolder() {
        return mSurfaceHolder;
    }

    public static int getNumOfVideoDevices() {
        int numberOfCameras = Camera.getNumberOfCameras();
        d.c(TAG, "Video GetNumOfVideoDevices, Num = " + numberOfCameras);
        return numberOfCameras;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getSurfaceRotation(Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        if (rotation == 0) {
            return 0;
        }
        if (rotation == 1) {
            return 90;
        }
        if (rotation != 2) {
            return rotation != 3 ? 0 : 270;
        }
        return 180;
    }

    public static int getVideoCurrentValue() {
        return videoCurrentValue;
    }

    private Camera.Parameters initCameraParameters(int i, int i2, String str) {
        String str2;
        StringBuilder sb;
        Camera.Parameters parameters;
        d.c(TAG, "========initCameraParameters begin=============");
        try {
            parameters = this.mCamera.getParameters();
            boolean z = false;
            if (parameters.get(this.KeyPreviewCallBackInMetaData) == null) {
                this.mMetaDataLen = 0;
            } else if (mCodecType == 5) {
                z = true;
                parameters.set(this.KeyPreviewCallBackInMetaData, 1);
                d.c(TAG, "mCamera set preview in meta data mode :" + parameters.get(this.KeyPreviewCallBackInMetaData));
                this.mMetaDataLen = parameters.getInt(this.KeyPreviewCallBackInMetaDataLenth);
                d.c(TAG, "mCamera meta data length :" + this.mMetaDataLen);
            } else {
                parameters.set(this.KeyPreviewCallBackInMetaData, 0);
            }
            this.mUseMetaMode = z;
            setupParameters(i, i2, str, parameters);
            try {
                this.mCamera.setParameters(parameters);
            } catch (Exception e) {
                e = e;
                str2 = TAG;
                sb = new StringBuilder("mCamera setParameters failed,Reason:");
            }
        } catch (Exception e2) {
            e = e2;
            str2 = TAG;
            sb = new StringBuilder("mCamera getParameters failed,Reason:");
        }
        try {
            Camera.Parameters parameters2 = this.mCamera.getParameters();
            compareParams(parameters2, parameters);
            return parameters2;
        } catch (Exception e3) {
            e = e3;
            str2 = TAG;
            sb = new StringBuilder("mCamera getParameters failed,Reason:");
            sb.append(e.toString());
            d.d(str2, sb.toString());
            return null;
        }
    }

    private void logCameraParams(Camera.Parameters parameters) {
        for (Camera.Size size : parameters.getSupportedPreviewSizes()) {
            d.a(TAG, "VideoProducer open-------width:" + size.width + ",height:" + size.height);
        }
        int pictureFormat = parameters.getPictureFormat();
        int previewFormat = parameters.getPreviewFormat();
        d.a(TAG, "pictureformat:" + pictureFormat + ",previewformat:" + previewFormat);
    }

    private Camera openCamera(int i) {
        d.c(TAG, "========openCamera begin=============");
        if (!validCameraId(i)) {
            return null;
        }
        try {
            Camera open = Camera.open(i);
            d.c(TAG, "========openCamera done=============");
            return open;
        } catch (Exception e) {
            d.d(TAG, "Can't open Camera[" + i + "],Reason:" + e.toString());
            OcxEventCallBack.java_DeviceRequestStatus(402);
            return null;
        }
    }

    public static void registerRender(int i, ZMCEVideoGLRender zMCEVideoGLRender) {
        d.d(TAG, "=============registerRender index:" + i + "================");
        if (i == 0) {
            mRender = zMCEVideoGLRender;
        }
        mVideoGLRenderArray[i] = zMCEVideoGLRender;
    }

    private void setCameraDisplayOrientation(Activity activity, Camera.CameraInfo cameraInfo) {
        int surfaceRotation = getSurfaceRotation(activity);
        int i = cameraInfo.facing == 1 ? 360 - ((cameraInfo.orientation + surfaceRotation) % 360) : (cameraInfo.orientation - surfaceRotation) + 360;
        d.a(TAG, "setCameraDisplayOrientation orientation=" + cameraInfo.orientation + "; surface rotation=" + surfaceRotation);
        this.mCamera.setDisplayOrientation(i % 360);
    }

    public static void setDegree(int i) {
        s_Degree = i;
    }

    public static void setLSurfaceHolder(SurfaceHolder surfaceHolder) {
        mSurfaceHolder = surfaceHolder;
    }

    private void setPreview() throws IOException {
        d.c(TAG, "========setPreview by android sdk version:" + Build.VERSION.SDK_INT);
        this.mCamera.setPreviewDisplay(mSurfaceHolder);
    }

    private int setPreviewParameters(int i) {
        d.c(TAG, "========setPreviewParameters with rawDataLen:" + i);
        this.mCamera.addCallbackBuffer(this.mRawData);
        this.mFrameYUV = new byte[i];
        this.mFrameLen = i;
        this.mCapReady = false;
        try {
            setPreview();
            this.mCamera.setPreviewCallbackWithBuffer(new b(this));
            return 0;
        } catch (Exception e) {
            d.d(TAG, "mCamera.setPreviewDisplay failed, Reason:" + e);
            return -1;
        }
    }

    public static void setVideoCurrentValue(int i) {
        videoCurrentValue = i;
    }

    private void setupParameters(int i, int i2, String str, Camera.Parameters parameters) {
        parameters.setPreviewSize(i, i2);
        d.a(TAG, "ProducerStart:used set width=" + parameters.getPreviewSize().width + ";height=" + parameters.getPreviewSize().height + ";focusModeContinuousVideo=" + str);
        List<Integer> supportedPreviewFormats = parameters.getSupportedPreviewFormats();
        int i3 = 0;
        while (true) {
            Integer valueOf = Integer.valueOf(i3);
            if (valueOf.intValue() >= supportedPreviewFormats.size()) {
                break;
            }
            d.a(TAG, "Get the camera support PreviewFormats:" + supportedPreviewFormats.get(valueOf.intValue()));
            i3 = valueOf.intValue() + 1;
        }
        d.a(TAG, "android.graphics.ImageFormat.YV12=842094169,android.graphics.ImageFormat.NV21=17");
        if (mCodecType != 5) {
            parameters.setPreviewFormat(IjkMediaPlayer.SDL_FCC_YV12);
        }
        if (parameters.getSupportedFocusModes().contains(str)) {
            d.a(TAG, "setFocusMode=continuous-video");
            parameters.setFocusMode(str);
        }
    }

    private int startCamera(int i, int i2) {
        synchronized (this) {
            if (this.mCamera != null) {
                if (s_CurActivity != null) {
                    setCameraDisplayOrientation(s_CurActivity, this.mCameraInfo);
                }
                Camera.Parameters initCameraParameters = initCameraParameters(i, i2, "continuous-video");
                if (initCameraParameters == null) {
                    d.d(TAG, "Video ProducerStart Camera params is null!");
                    return -1;
                }
                int bitsPerPixel = ((initCameraParameters.getPreviewSize().width * initCameraParameters.getPreviewSize().height) * ImageFormat.getBitsPerPixel(initCameraParameters.getPreviewFormat())) / 8;
                if (this.mUseMetaMode) {
                    bitsPerPixel = this.mMetaDataLen;
                }
                int previewParameters = setPreviewParameters(bitsPerPixel);
                if (previewParameters < 0) {
                    return previewParameters;
                }
                try {
                    this.mCamera.startPreview();
                } catch (Exception e) {
                    d.d(TAG, "mCamera.startPreview failed, Reason:" + e.toString());
                    return -1;
                }
            }
            d.c(TAG, "Video ProducerStart done.");
            return 0;
        }
    }

    private boolean validCameraId(int i) {
        d.c(TAG, "========validCameraId begin=============");
        if (this.mCameraNum <= 0) {
            this.mCameraNum = getNumOfVideoDevices();
        }
        if (this.mCameraNum > i) {
            d.c(TAG, "========validCameraId done=============");
            return true;
        }
        d.d(TAG, "CameraID [" + i + "] is wrong.ProducerOpen failed!");
        return false;
    }

    public int AddBufferCallback() {
        synchronized (this) {
            this.mCamera.addCallbackBuffer(this.mRawData);
        }
        return 0;
    }

    public int ConfigSurfaceView(int i, int i2) {
        return 0;
    }

    public int ConsumerClose() {
        d.c(TAG, "========ConsumerClose begin=============");
        if (this.bOnlyAudio) {
            d.d(TAG, "Video ConsumerClose only audio");
            return 0;
        }
        this.iFrameFlag = 0;
        d.c(TAG, "Video ConsumerClose done with iFrameFlag:" + this.iFrameFlag);
        return 0;
    }

    public int ConsumerOpen() {
        String str;
        String str2;
        if (this.bOnlyAudio) {
            str = TAG;
            str2 = "Video ConsumerOpen only audio";
        } else {
            str = TAG;
            str2 = "Video ConsumerOpen do nothing.";
        }
        d.c(str, str2);
        return 0;
    }

    public int ConsumerStart(int i, int i2, Object obj) {
        d.c(TAG, "========ConsumerStart begin=============");
        if (this.bOnlyAudio) {
            d.d(TAG, "Video ConsumerStart only audio");
            return 0;
        }
        this.mPlayWidth = i;
        this.mPlayHeight = i2;
        d.a(TAG, "ConsumerStart:width=" + this.mPlayWidth + ";height=" + this.mPlayHeight);
        this.iFrameFlag = 0;
        d.c(TAG, "Video ConsumerStart done with iFrameFlag:" + this.iFrameFlag);
        return 0;
    }

    public int ConsumerStop() {
        d.c(TAG, "========ConsumerStop begin=============");
        if (this.bOnlyAudio) {
            d.d(TAG, "Video ConsumerStop only audio");
            this.bOnlyAudio = false;
            return 0;
        }
        if (this.mMatrix != null) {
            this.mMatrix = null;
        }
        if (this.mPaint != null) {
            this.mPaint = null;
        }
        this.iFrameFlag = 0;
        d.c(TAG, "Video ConsumerStop done with iFrameFlag:" + this.iFrameFlag);
        return 0;
    }

    public int GetDegree() {
        int i;
        synchronized (this) {
            i = 0;
            if (this.mCameraInfo.facing == 1) {
                i = ((360 - (this.mCameraInfo.orientation - sSensorOrientation)) + 360) % 360;
            } else {
                int i2 = ((this.mCameraInfo.orientation + sSensorOrientation) + 360) % 360;
                if (0 - i2 < 0) {
                    i = ((360 - i2) + 360) % 360;
                }
            }
        }
        return i;
    }

    public int GetFrame(byte[] bArr, int i) {
        if (this.bOnlyAudio) {
            return 0;
        }
        if (this.mFrameLen > i) {
            d.d(TAG, "video GetFrame buffer too small : " + i);
            return -1;
        }
        synchronized (this) {
            if (this.mCamera == null) {
                d.d(TAG, "Camera not Open, GetFrame Failed. ");
                return -1;
            }
            if (!this.mCapReady) {
                return -1;
            }
            this.mCapReady = false;
            if (s_CurOrientation == 4) {
                setCameraDisplayOrientation(s_CurActivity, this.mCameraInfo);
            }
            return this.mFrameLen;
        }
    }

    public int GetLocalDegree() {
        int i;
        synchronized (this) {
            i = s_Degree;
        }
        return i;
    }

    public int GetRecvWidth() {
        return this.mPlayWidth;
    }

    public int ProducerClose() {
        d.c(TAG, "========ProducerClose begin=============");
        if (this.bOnlyAudio) {
            d.d(TAG, "Video ProducerClose only audio");
            return 0;
        }
        synchronized (this) {
            if (this.mCamera != null) {
                this.mCamera.release();
                this.mCamera = null;
            }
        }
        this.mRawData = null;
        this.mFrameYUV = null;
        this.mCameraNum = 0;
        d.c(TAG, "Video ProducerClose done.");
        return 0;
    }

    public int ProducerOpen(int i) {
        String str;
        String str2;
        d.c(TAG, "========ProducerOpen begin=============");
        if (this.bOnlyAudio) {
            str = TAG;
            str2 = "Video ProducerOpen only audio";
        } else {
            synchronized (this) {
                if (this.mCamera != null) {
                    d.d(TAG, "Camera already in use!, force release now!");
                    this.mCamera.release();
                    this.mCamera = null;
                }
                Camera openCamera = openCamera(i);
                this.mCamera = openCamera;
                if (openCamera == null) {
                    d.d(TAG, "mCamera is null!");
                    return -1;
                }
                Camera.getCameraInfo(i, this.mCameraInfo);
                try {
                    logCameraParams(this.mCamera.getParameters());
                    str = TAG;
                    str2 = "Video ProducerOpen done.";
                } catch (Exception e) {
                    d.d(TAG, "mCamera getParameters failed,Reason:" + e.toString());
                    this.mCamera.release();
                    this.mCamera = null;
                    return -1;
                }
            }
        }
        d.c(str, str2);
        return 0;
    }

    public int ProducerStart(byte[] bArr, int i, int i2, Object obj) {
        d.c(TAG, "========ProducerStart begin=============");
        if (this.bOnlyAudio) {
            d.d(TAG, "Video ProducerStart only audio");
            return 0;
        }
        if (bArr != null) {
            this.mRawData = bArr;
        }
        if (mSurfaceHolder == null) {
            d.d(TAG, "Video ProducerStart local SurfaceHolder is null!");
            return -1;
        }
        d.c(TAG, "In Video ProducerStart, mSurfaceHolder = " + mSurfaceHolder + ", getSurface = " + mSurfaceHolder.getSurface());
        d.b(TAG, "ProducerStart========set mSurfaceHolder.setFixedSize[" + i + ":" + i2 + "]");
        OcxEventCallBack.java_NotifyRealVideoFormate(i, i2);
        d.a(TAG, "Video ProducerStart startCamera Width:" + i + " Height:" + i2);
        return startCamera(i, i2);
    }

    public int ProducerStop() {
        d.c(TAG, "========ProducerStop begin=============");
        if (this.bOnlyAudio) {
            d.d(TAG, "Video ProducerStop only audio");
            this.bOnlyAudio = false;
            return 0;
        }
        synchronized (this) {
            if (this.mCamera != null) {
                this.mCamera.stopPreview();
                this.mCamera.setPreviewCallbackWithBuffer(null);
                this.mCapReady = false;
            }
        }
        this.mRawData = null;
        this.mFrameYUV = null;
        d.c(TAG, "Video ProducerStop done.");
        return 0;
    }

    public int WriteFrame(byte[] bArr, int i, int i2, int i3, int i4) {
        if (this.bOnlyAudio) {
            return 0;
        }
        if (this.iFrameFlag == 0) {
            this.iFrameFlag = 1;
            d.b(TAG, "VideoDeviceCallBackLOG========WriteFrame first frame arrive! iFrameFlag:" + this.iFrameFlag);
            OcxEventCallBack.java_FirstFrame(this.iFrameFlag);
        }
        mRender.setBuffer(this.mPlayWidth, this.mPlayHeight, i3, i4);
        mRender.copyTheRenderData(bArr, i);
        setRotateDegreeToRender(i2);
        mRender.requestRender();
        return 0;
    }

    public int demoWriteFrame(int i, int i2, int i3, int i4, int i5, int i6, byte[] bArr, int i7) {
        d.d(TAG, String.format(Locale.getDefault(), "demoWriteFrame nEngineID[%d],imgWidth[%d],imgHeight[%d],imgStrideY[%d],imgStrideUV[%d],imgRotateDegree[%d],iRenderDataLen[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7)));
        if (this.bOnlyAudio) {
            return 0;
        }
        if (this.iFrameFlag == 0) {
            this.iFrameFlag = 1;
            d.b(TAG, "VideoDeviceCallBackLOG id[" + i + "]========WriteFrame first frame arrive! iFrameFlag:" + this.iFrameFlag);
            OcxEventCallBack.java_FirstFrame(this.iFrameFlag);
        }
        ZMCEVideoGLRender[] zMCEVideoGLRenderArr = mVideoGLRenderArray;
        if (zMCEVideoGLRenderArr[i] != null) {
            zMCEVideoGLRenderArr[i].setBuffer(i2, i3, i4, i5);
            setRotateDegreeToRender(i6);
            mVideoGLRenderArray[i].copyTheRenderData(bArr, i7);
            mVideoGLRenderArray[i].requestRender();
        } else {
            d.b(TAG, "demoWriteFrame id[" + i + "] while mVideoGLRenderArray is null");
        }
        return 0;
    }

    public void doAudioTalk(boolean z) {
        this.bOnlyAudio = z;
        d.c(TAG, "Video DoAudioTalk:" + this.bOnlyAudio);
    }

    public int setRotateDegreeToRender(int i) {
        int GetLocalDegree = GetLocalDegree();
        if (this.mRemoteDisplayEnable == 0) {
            i = 0;
        }
        mRender.setRotateDegree(i + GetLocalDegree);
        return 0;
    }
}
