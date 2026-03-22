package d.e.a.a;

import com.video.androidsdk.login.SDKLoginMgr;

/* compiled from: IPTVLoginMgr.java */
/* loaded from: classes2.dex */
public class c {
    public static String a() {
        String ePGHome = SDKLoginMgr.getInstance().getEPGHome();
        return ePGHome == null ? "" : ePGHome;
    }
}
