package com.zte.iptvclient.android.common.h;

import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.service.auth.FeatureAuthAndOrderListReq;
import com.video.androidsdk.service.auth.SDKAuthMgr;

/* compiled from: TimeShiftAuthHelper.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static volatile a f4626c;

    /* renamed from: a, reason: collision with root package name */
    SDKAuthMgr f4627a = new SDKAuthMgr();

    /* renamed from: b, reason: collision with root package name */
    FeatureAuthAndOrderListReq f4628b;

    /* compiled from: TimeShiftAuthHelper.java */
    /* renamed from: com.zte.iptvclient.android.common.h.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0132a implements SDKAuthMgr.OnFeatureAuthAndOrderListReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f4629a;

        C0132a(a aVar, b bVar) {
            this.f4629a = bVar;
        }

        @Override // com.video.androidsdk.service.auth.SDKAuthMgr.OnFeatureAuthAndOrderListReturnListener
        public void onFeatureAuthAndOrderListReturn(String str, String str2, String str3) {
            char c2;
            int hashCode = str.hashCode();
            if (hashCode == 48) {
                if (str.equals("0")) {
                    c2 = 0;
                }
                c2 = 65535;
            } else if (hashCode != 53) {
                if (hashCode == 1823 && str.equals("98")) {
                    c2 = 2;
                }
                c2 = 65535;
            } else {
                if (str.equals(DownloadConstant.REPORT_MSGTYPE_ADD)) {
                    c2 = 1;
                }
                c2 = 65535;
            }
            if (c2 == 1) {
                this.f4629a.k();
            } else {
                if (c2 != 2) {
                    return;
                }
                this.f4629a.k();
            }
        }
    }

    /* compiled from: TimeShiftAuthHelper.java */
    /* loaded from: classes.dex */
    public interface b {
        void k();
    }

    private a() {
        b();
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f4626c == null) {
                f4626c = new a();
            }
            aVar = f4626c;
        }
        return aVar;
    }

    private void b() {
        FeatureAuthAndOrderListReq featureAuthAndOrderListReq = new FeatureAuthAndOrderListReq();
        this.f4628b = featureAuthAndOrderListReq;
        featureAuthAndOrderListReq.authandorderlist = "1";
        featureAuthAndOrderListReq.featurecode = "tstv";
        featureAuthAndOrderListReq.terminalflag = "2";
    }

    public void a(b bVar) {
        this.f4627a.doFeatureAuthAndOrderList(this.f4628b, new C0132a(this, bVar));
    }
}
