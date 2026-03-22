package ijk.media.player;

import android.os.Build;
import android.util.Log;

/* loaded from: classes2.dex */
public class QcsLicJNI {
    public static a mLicenseCheckCallBack;

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i, String str);
    }

    static {
        if (Build.VERSION.SDK_INT >= 23) {
            System.loadLibrary("qcslicense_v7");
            System.loadLibrary("qcslicensejni_v7");
        } else {
            System.loadLibrary("qcslicense");
            System.loadLibrary("qcslicensejni");
        }
    }

    public static native String GetEncryptKey(String str);

    public static native int SetKeycfgFilePath(String str);

    public void LicCallback(int i, String str, String str2, String str3) {
        Log.d("QcsLicJNI", "{LicCallback:[returnCode:" + i + "][encryptinfo:" + str + "][funlist:" + str2 + "][modulepolicylist:" + str3 + "]}");
        StringBuilder sb = new StringBuilder();
        sb.append("LicCallback    ");
        sb.append(toString());
        Log.d("QcsLicJNI", sb.toString());
        if (mLicenseCheckCallBack != null) {
            mLicenseCheckCallBack.a(i, i == 0 ? "license check success" : i == 1 ? "license check failed on time" : i == 2 ? "license check failed on package name" : i == 3 ? "license check failed on MAC" : i == 4 ? "license check failed on device list" : i == 5 ? "license check failed on the decryption of the Lic file" : "");
        } else {
            Log.w("QcsLicJNI", "mLicenseCheckCallBack is NULL!");
        }
    }

    public native int LicInit(String str, String str2, String str3, String str4, String str5, String str6, String str7);

    public void setLicenseCheckCallback(a aVar) {
        Log.d("QcsLicJNI", "setLicenseCheckCallback     " + toString());
        mLicenseCheckCallBack = aVar;
    }
}
