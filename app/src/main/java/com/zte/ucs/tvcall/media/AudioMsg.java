package com.zte.ucs.tvcall.media;

import com.facebook.internal.Utility;
import com.zte.ucs.tvcall.ocx.telephone.AudioDownLinkInfo;
import com.zte.ucs.tvcall.ocx.telephone.AudioUpLinkInfo;
import com.zte.ucs.tvcall.ocx.telephone.VideoDownLinkInfo;
import com.zte.ucs.tvcall.ocx.telephone.VideoUpLinkInfo;
import d.e.b.n.d;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Locale;

/* loaded from: classes2.dex */
public class AudioMsg {
    private static final String TAG = "TvCall.AudioMsg";

    public static native boolean JAVASetRecordMute(boolean z, boolean z2);

    public static native int JNI_ConnectDevice(int i, int i2);

    public static native int JNI_DisConnectDevice(int i, int i2);

    public static native void JNI_SendDTMFCode(int i, int i2);

    public static native int JNI_SetCameraNo(int i);

    public static native int JNI_SetSpeakerMode(boolean z);

    public static native void JNI_SetVideoDisplayWnd2(Object obj, Object obj2);

    public static native void bJAVAHasSetSurface();

    private static boolean cpuHasNeon() {
        boolean z = false;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/cpuinfo"), Charset.defaultCharset()), Utility.DEFAULT_STREAM_BUFFER_SIZE);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                d.a("JAVA AudioMsg", "CPUINFO------- " + readLine);
                if (readLine.toLowerCase(Locale.getDefault()).indexOf("neon") >= 0) {
                    z = true;
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException | IOException e) {
            d.b("JAVA AudioMsg", "CPUINFO error!", e);
        }
        return z;
    }

    public static native boolean jni_CliDbSetFECEnable(boolean z);

    public static native boolean jni_CliDbSetPlatformType(long j);

    public static native boolean jni_CliDbSetSupportVideoPXPara(String str);

    public static native boolean jni_CliDbSetSyncEnable(boolean z);

    public static native boolean jni_CliDbSetZimeLogPath(String str);

    public static native boolean jni_SetZIMELogLevel(int i);

    public static native boolean jni_getAudioDownLinkStat(AudioDownLinkInfo audioDownLinkInfo);

    public static native boolean jni_getAudioUpLinkStat(AudioUpLinkInfo audioUpLinkInfo);

    public static native boolean jni_getVideoDownLinkStat(VideoDownLinkInfo videoDownLinkInfo);

    public static native boolean jni_getVideoUpLinkStat(VideoUpLinkInfo videoUpLinkInfo);

    public static void loadMediaModuleLibrary() {
        boolean cpuHasNeon = cpuHasNeon();
        System.loadLibrary("CommonUtilitiesLib");
        System.loadLibrary("LightLog");
        System.loadLibrary("RTCPLib");
        System.loadLibrary("RTPPackerLib");
        System.loadLibrary("RTPParser");
        System.loadLibrary("SRTPLib");
        System.loadLibrary("AEC_ARM_ANDROID");
        if (cpuHasNeon) {
            d.a("JAVA AudioMsg", "loadLibrary  zteH264EncARMv7Android ------- ");
            System.loadLibrary("zteH264EncARMv7Android");
            System.loadLibrary("zteVideoEnhanceNEON_Android");
            System.loadLibrary("zteH264DecARMv7Android");
        } else {
            d.d("JAVA AudioMsg", "Conguratulations! Your CPU have NOT support NEON, so there is no SO. ");
        }
        System.loadLibrary("RTPFECLib");
        System.loadLibrary("yuv_static");
        System.loadLibrary("ZIMEClientSDKAndroid");
        System.loadLibrary("ZIMECodecDevCallBack");
        System.loadLibrary("MediaModule");
        setMediaEnv(1);
    }

    public static native int setMediaEnv(int i);
}
