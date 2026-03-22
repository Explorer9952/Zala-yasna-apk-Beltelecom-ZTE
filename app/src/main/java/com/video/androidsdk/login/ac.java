package com.video.androidsdk.login;

import android.text.TextUtils;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.impl.IIPTVLogin;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThirdAppAuthIPTVLogin.java */
/* loaded from: classes.dex */
public class ac implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.video.androidsdk.login.impl.a f3154a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ab f3155b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar, com.video.androidsdk.login.impl.a aVar) {
        this.f3155b = abVar;
        this.f3154a = aVar;
    }

    @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
    public void onDataReturn(String str) {
        String str2;
        String str3;
        str2 = ab.f3150b;
        LogEx.d(str2, "startThirdAppAuthLogin AUTH_61 return : " + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (TextUtils.equals("0", jSONObject.optString("returncode"))) {
                HashMap hashMap = new HashMap();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String valueOf = String.valueOf(keys.next());
                    String str4 = "";
                    if (jSONObject.get(valueOf) instanceof JSONArray) {
                        JSONArray jSONArray = jSONObject.getJSONArray(valueOf);
                        if (jSONArray != null && jSONArray.length() != 0) {
                            for (int i = 0; i < jSONArray.length(); i++) {
                                str4 = jSONArray.get(i) + ",";
                            }
                        }
                        if (str4.endsWith(",")) {
                            str4 = str4.substring(0, str4.length() - 1);
                        }
                    } else {
                        str4 = String.valueOf(jSONObject.get(valueOf));
                    }
                    hashMap.put(valueOf, str4);
                }
                m.a().putAll(hashMap);
                this.f3155b.c(this.f3154a);
                return;
            }
            this.f3154a.b(String.valueOf(ErrCode.getErrCode(IIPTVLogin.REQUESTID_THIRDAPP_AUTH_61, 1)), "Third app auth login return error.");
        } catch (Exception e) {
            str3 = ab.f3150b;
            LogEx.e(str3, e.getMessage());
            this.f3154a.b(String.valueOf(ErrCode.getErrCode(IIPTVLogin.REQUESTID_THIRDAPP_AUTH_61, 6)), "Third app auth login parse result error.");
        }
    }

    @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
    public void onFailReturn(int i, String str) {
        this.f3154a.b(String.valueOf(ErrCode.getErrCode(IIPTVLogin.REQUESTID_THIRDAPP_AUTH_61, 1)), "Third app auth login return error, errormsg is " + str);
    }
}
