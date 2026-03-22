package com.zte.iptvclient.android.common.k;

import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.zte.servicesdk.util.PortalConst;

/* compiled from: FaceUtil.java */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private static String f4817a;

    /* renamed from: b, reason: collision with root package name */
    private static l f4818b = new l();

    /* compiled from: FaceUtil.java */
    /* loaded from: classes.dex */
    class a implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f4819a;

        a(l lVar, b bVar) {
            this.f4819a = bVar;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            this.f4819a.onDataReturn(str);
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            this.f4819a.onFailReturn(i, str);
        }
    }

    /* compiled from: FaceUtil.java */
    /* loaded from: classes.dex */
    public interface b {
        void onDataReturn(String str);

        void onFailReturn(int i, String str);
    }

    private l() {
    }

    public static l a() {
        f4817a = com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_APP_SERVER_URL);
        return f4818b;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(java.lang.String r12, java.lang.String r13, com.zte.iptvclient.android.common.k.l.b r14) {
        /*
            Method dump skipped, instructions count: 323
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.common.k.l.a(java.lang.String, java.lang.String, com.zte.iptvclient.android.common.k.l$b):void");
    }
}
