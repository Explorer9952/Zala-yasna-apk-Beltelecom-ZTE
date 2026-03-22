package com.zte.iptvclient.android.common.h;

import android.text.TextUtils;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.service.auth.FeatureAuthAndOrderListReq;
import com.video.androidsdk.service.auth.SDKAuthMgr;
import com.video.androidsdk.service.comm.ParamConst;
import com.zte.iptvclient.android.common.h.a;

/* compiled from: TvodAuthHelper.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    private static volatile b f4630c;

    /* renamed from: a, reason: collision with root package name */
    SDKAuthMgr f4631a = new SDKAuthMgr();

    /* renamed from: b, reason: collision with root package name */
    FeatureAuthAndOrderListReq f4632b;

    /* compiled from: TvodAuthHelper.java */
    /* loaded from: classes.dex */
    class a implements SDKAuthMgr.OnFeatureAuthAndOrderListReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a.b f4633a;

        a(b bVar, a.b bVar2) {
            this.f4633a = bVar2;
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
                this.f4633a.k();
            } else {
                if (c2 != 2) {
                    return;
                }
                this.f4633a.k();
            }
        }
    }

    private b() {
        b();
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (f4630c == null) {
                f4630c = new b();
            }
            bVar = f4630c;
        }
        return bVar;
    }

    private void b() {
        FeatureAuthAndOrderListReq featureAuthAndOrderListReq = new FeatureAuthAndOrderListReq();
        this.f4632b = featureAuthAndOrderListReq;
        featureAuthAndOrderListReq.authandorderlist = "1";
        featureAuthAndOrderListReq.featurecode = ParamConst.PLAY_CONTENTTYPE_TVOD;
        featureAuthAndOrderListReq.terminalflag = "2";
    }

    public void a(a.b bVar) {
        if (TextUtils.equals("1", ConfigMgr.readPropertie("isFeatureAuth"))) {
            this.f4631a.doFeatureAuthAndOrderList(this.f4632b, new a(this, bVar));
        }
    }
}
