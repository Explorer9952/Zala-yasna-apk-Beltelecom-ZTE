package com.video.androidsdk.login.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.video.androidsdk.common.AES;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.impl.b;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.Properties;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PublicLoginMethod.java */
/* loaded from: classes.dex */
public class g implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b.InterfaceC0095b f3196a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ b f3197b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, b.InterfaceC0095b interfaceC0095b) {
        this.f3197b = bVar;
        this.f3196a = interfaceC0095b;
    }

    @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
    public void onDataReturn(String str) {
        Bundle bundle;
        String str2;
        Bundle bundle2;
        String str3;
        String str4;
        Bundle bundle3;
        Bundle bundle4;
        String str5;
        String str6;
        if (TextUtils.isEmpty(str)) {
            str6 = b.f3181a;
            LogEx.d(str6, "HomePage http://{ipadd:port}/iptvepg/{frame}/portal.properties response empty!");
            b.InterfaceC0095b interfaceC0095b = this.f3196a;
            if (interfaceC0095b != null) {
                interfaceC0095b.a(String.valueOf(ErrCode.getErrCode(IIPTVLogin.REQUESTID_PROPERTIES, 99)), "http://{ipadd:port}/iptvepg/{frame}/portal.properties response empty!", null);
                return;
            }
            return;
        }
        bundle = this.f3197b.i;
        if (bundle != null) {
            bundle2 = this.f3197b.i;
            if (!TextUtils.isEmpty(bundle2.getString("logindatatype"))) {
                try {
                    str3 = new JSONObject(str).optString("data");
                } catch (JSONException e) {
                    e.printStackTrace();
                    str3 = "";
                }
                if (TextUtils.isEmpty(str3)) {
                    str5 = b.f3181a;
                    LogEx.d(str5, "HomePage http://{ipadd:port}/iptvepg/{frame}/portal.properties response empty!");
                    b.InterfaceC0095b interfaceC0095b2 = this.f3196a;
                    if (interfaceC0095b2 != null) {
                        interfaceC0095b2.a(String.valueOf(ErrCode.getErrCode(IIPTVLogin.REQUESTID_PROPERTIES, 99)), "http://{ipadd:port}/iptvepg/{frame}/portal.properties response empty!", null);
                        return;
                    }
                    return;
                }
                String a2 = com.video.androidsdk.license.a.a(this.f3197b.c());
                byte[] bytes = a2.getBytes();
                Properties properties = new Properties();
                try {
                    bundle3 = this.f3197b.i;
                    if (bundle3 != null) {
                        bundle4 = this.f3197b.i;
                        if (TextUtils.equals(bundle4.getString("logindatatype"), "99") && !TextUtils.isEmpty(a2)) {
                            str3 = URLDecoder.decode(AES.aesDecode(str3, bytes));
                        }
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        JSONObject jSONObject = new JSONObject(str3);
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            properties.setProperty(next, String.valueOf(jSONObject.get(next)));
                        }
                    }
                    b.InterfaceC0095b interfaceC0095b3 = this.f3196a;
                    if (interfaceC0095b3 != null) {
                        interfaceC0095b3.a(String.valueOf(0), "success", properties);
                        return;
                    }
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    str4 = b.f3181a;
                    LogEx.d(str4, "Load portal.properteis failed! http://{ipadd:port}/iptvepg/{frame}/portal.properties");
                    b.InterfaceC0095b interfaceC0095b4 = this.f3196a;
                    if (interfaceC0095b4 != null) {
                        interfaceC0095b4.a(String.valueOf(ErrCode.getErrCode(IIPTVLogin.REQUESTID_PROPERTIES, 103)), "http://{ipadd:port}/iptvepg/{frame}/portal.properties response error!", null);
                        return;
                    }
                    return;
                }
            }
        }
        if (com.video.androidsdk.a.d.a()) {
            com.video.androidsdk.a.d.a("properties", str.getBytes());
        }
        Properties properties2 = new Properties();
        try {
            properties2.load(new InputStreamReader(new ByteArrayInputStream(str.getBytes())));
            b.InterfaceC0095b interfaceC0095b5 = this.f3196a;
            if (interfaceC0095b5 != null) {
                interfaceC0095b5.a(String.valueOf(0), "success", properties2);
            }
        } catch (IOException unused) {
            str2 = b.f3181a;
            LogEx.d(str2, "Load portal.properteis failed! http://{ipadd:port}/iptvepg/{frame}/portal.properties");
            b.InterfaceC0095b interfaceC0095b6 = this.f3196a;
            if (interfaceC0095b6 != null) {
                interfaceC0095b6.a(String.valueOf(ErrCode.getErrCode(IIPTVLogin.REQUESTID_PROPERTIES, 103)), "http://{ipadd:port}/iptvepg/{frame}/portal.properties response error!", null);
            }
        }
    }

    @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
    public void onFailReturn(int i, String str) {
        String str2;
        str2 = b.f3181a;
        LogEx.w(str2, str);
        b.InterfaceC0095b interfaceC0095b = this.f3196a;
        if (interfaceC0095b != null) {
            interfaceC0095b.a(String.valueOf(ErrCode.getErrCode(IIPTVLogin.REQUESTID_PROPERTIES, 103)), "download protal.properteis exception!", null);
        }
    }
}
