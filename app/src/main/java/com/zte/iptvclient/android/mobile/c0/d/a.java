package com.zte.iptvclient.android.mobile.c0.d;

import android.content.Context;
import android.text.TextUtils;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.http.bean.HttpRequest;
import com.zte.iptvclient.android.common.f.b.i;
import com.zte.iptvclient.android.common.j.h;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UserUtil.java */
/* loaded from: classes2.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UserUtil.java */
    /* renamed from: com.zte.iptvclient.android.mobile.c0.d.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0202a implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f5651a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ h f5652b;

        C0202a(b bVar, h hVar) {
            this.f5651a = bVar;
            this.f5652b = hVar;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String str2 = "";
                if ("0".equals(jSONObject.optString("returncode"))) {
                    str2 = (TextUtils.isEmpty(jSONObject.optString("balance")) || jSONObject.optString("balance").equals("null")) ? "0.00" : jSONObject.optString("balance");
                    this.f5651a.a(str2);
                } else {
                    this.f5651a.a();
                }
                this.f5652b.d(str2);
            } catch (JSONException e) {
                e.printStackTrace();
                this.f5651a.a();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            this.f5651a.a();
        }
    }

    /* compiled from: UserUtil.java */
    /* loaded from: classes2.dex */
    public interface b {
        void a();

        void a(String str);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(java.lang.String r10) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "utf-8"
            java.lang.String r2 = "IMP_Password"
            java.lang.String r2 = com.video.androidsdk.common.config.ConfigMgr.readPropertie(r2)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r10)
            java.lang.String r10 = "$$"
            r3.append(r10)
            java.lang.String r3 = r3.toString()
            java.util.Calendar r4 = java.util.Calendar.getInstance()
            r5 = 11
            r6 = 1
            r4.add(r5, r6)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            long r6 = r4.getTimeInMillis()
            r8 = 1000(0x3e8, double:4.94E-321)
            long r6 = r6 / r8
            java.lang.String r4 = java.lang.Long.toHexString(r6)
            r5.append(r4)
            r5.append(r10)
            java.lang.String r4 = r5.toString()
            boolean r5 = android.text.TextUtils.isEmpty(r2)
            if (r5 != 0) goto L57
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            r5.append(r2)
            r5.append(r10)
            java.lang.String r4 = r5.toString()
        L57:
            r10 = 10
            java.lang.String r10 = com.zte.iptvclient.android.common.k.a.a(r10)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r3)
            r2.append(r4)
            r2.append(r10)
            java.lang.String r10 = r2.toString()
            r2 = 0
            byte[] r2 = new byte[r2]
            byte[] r2 = r10.getBytes(r1)     // Catch: java.io.UnsupportedEncodingException -> L77
            goto L7b
        L77:
            r10 = move-exception
            r10.printStackTrace()
        L7b:
            java.lang.String r10 = "impkey"
            java.lang.String r10 = com.video.androidsdk.common.AES.getEncryptKey(r10)
            byte[] r10 = r10.getBytes(r1)     // Catch: java.lang.Exception -> L92
            java.lang.String r10 = com.zte.iptvclient.android.common.k.a.c(r2, r10)     // Catch: java.lang.Exception -> L92
            java.lang.String r1 = "UTF-8"
            java.lang.String r10 = java.net.URLEncoder.encode(r10, r1)     // Catch: java.lang.Exception -> L90
            goto L97
        L90:
            r1 = move-exception
            goto L94
        L92:
            r1 = move-exception
            r10 = r0
        L94:
            r1.printStackTrace()
        L97:
            if (r10 != 0) goto L9a
            goto L9b
        L9a:
            r0 = r10
        L9b:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r1 = "encriptStr: "
            r10.append(r1)
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            java.lang.String r1 = "encryptionAES"
            com.video.androidsdk.log.LogEx.d(r1, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.mobile.c0.d.a.a(java.lang.String):java.lang.String");
    }

    public static void a(b bVar, Context context) {
        h hVar = new h(context);
        String replace = "http://{ipadd:port}/iptvepg/{frame}/sdk_getbalance.jsp".replace("http://{ipadd:port}/iptvepg/{frame}/", i.f());
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", i.h());
        sDKNetHTTPRequest.setCharset("gbk");
        sDKNetHTTPRequest.startRequest(replace, HttpRequest.METHOD_GET, new C0202a(bVar, hVar));
    }
}
