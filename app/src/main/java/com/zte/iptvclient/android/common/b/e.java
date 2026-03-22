package com.zte.iptvclient.android.common.b;

import android.text.TextUtils;
import com.video.androidsdk.common.AES;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.http.bean.HttpRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.login.impl.IIPTVLogin;
import com.video.androidsdk.service.comm.ParamConst;
import com.video.androidsdk.service.comm.SDKUtil4CELLC;
import com.zte.iptvclient.android.common.k.o;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AuthcodeTask.java */
/* loaded from: classes.dex */
public class e implements com.zte.iptvclient.android.common.b.b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f4096a = "com.zte.iptvclient.android.common.b.e";

    /* compiled from: AuthcodeTask.java */
    /* loaded from: classes.dex */
    class a implements SDKUtil4CELLC.OnGetEPGLocalTimeReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.b.a f4097a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f4098b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f4099c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f4100d;
        final /* synthetic */ String e;

        /* compiled from: AuthcodeTask.java */
        /* renamed from: com.zte.iptvclient.android.common.b.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0111a implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
            C0111a() {
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                LogEx.d(e.f4096a, "send authcode onDataReturn  ,result= " + str);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if ("0".equals(jSONObject.getString("returncode"))) {
                        LogEx.d(e.f4096a, "send authcode onDataReturn #send success");
                        a.this.f4097a.a((com.zte.iptvclient.android.common.b.a) jSONObject);
                    } else {
                        LogEx.d(e.f4096a, "send authcode onDataReturn #send failed: returncode = " + jSONObject.getString("returncode") + " errormsg = " + jSONObject.getString("errormsg"));
                        a.this.f4097a.b(jSONObject.getString("errormsg"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.d(e.f4096a, "send authcode onFailReturn  ,returncode= " + i + " ,errormsg=" + str);
                a.this.f4097a.b(str);
            }
        }

        a(com.zte.iptvclient.android.common.b.a aVar, String str, String str2, String str3, String str4) {
            this.f4097a = aVar;
            this.f4098b = str;
            this.f4099c = str2;
            this.f4100d = str3;
            this.e = str4;
        }

        @Override // com.video.androidsdk.service.comm.SDKUtil4CELLC.OnGetEPGLocalTimeReturnListener
        public String onGetEPGLocalTimeReturn(String str) {
            HashMap hashMap;
            String encode;
            String encode2;
            String aesEncode;
            String c2 = o.j().c();
            LogEx.e(e.f4096a, c2);
            if (TextUtils.isEmpty(c2)) {
                LogEx.e(e.f4096a, " ipPort = null");
                this.f4097a.b("getPropertiesInfo(\"appServerUrl\") = null");
                return null;
            }
            String replace = "{http://ip:port}/sendauthcode".replace("{http://ip:port}", c2);
            SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
            try {
                encode = URLEncoder.encode(this.f4098b, "UTF-8");
                encode2 = URLEncoder.encode(this.f4099c, "UTF-8");
                String str2 = this.f4100d + "$$" + str + "$$" + f.a(10);
                LogEx.d(e.f4096a, "strSrc=" + str2);
                aesEncode = AES.aesEncode(str2.getBytes(), AES.getEncryptKey("impkey").getBytes());
                hashMap = new HashMap();
            } catch (Exception e) {
                e = e;
                hashMap = null;
            }
            try {
                hashMap.put("usercode", this.f4100d);
                hashMap.put("email", this.e);
                hashMap.put(ParamConst.GET_REGISTER_REQ_MOBILENO, "");
                hashMap.put("authcodetype", "1");
                hashMap.put("subject", encode);
                hashMap.put("message", encode2);
                hashMap.put("authinfo", aesEncode);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                LogEx.d(e.f4096a, "url=" + replace);
                LogEx.d(e.f4096a, "builder=" + e.this.a(hashMap));
                sDKNetHTTPRequest.setHeader("Cookie", SDKLoginMgr.getInstance().getHTTPSessionID());
                sDKNetHTTPRequest.setHeader(IIPTVLogin.LOGIN_PARAM_CHARSET, "utf-8");
                sDKNetHTTPRequest.setBody(e.this.a(hashMap));
                sDKNetHTTPRequest.startRequest(replace, HttpRequest.METHOD_POST, new C0111a());
                return null;
            }
            LogEx.d(e.f4096a, "url=" + replace);
            LogEx.d(e.f4096a, "builder=" + e.this.a(hashMap));
            sDKNetHTTPRequest.setHeader("Cookie", SDKLoginMgr.getInstance().getHTTPSessionID());
            sDKNetHTTPRequest.setHeader(IIPTVLogin.LOGIN_PARAM_CHARSET, "utf-8");
            sDKNetHTTPRequest.setBody(e.this.a(hashMap));
            sDKNetHTTPRequest.startRequest(replace, HttpRequest.METHOD_POST, new C0111a());
            return null;
        }
    }

    /* compiled from: AuthcodeTask.java */
    /* loaded from: classes.dex */
    class b implements SDKUtil4CELLC.OnGetEPGLocalTimeReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.b.a f4102a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f4103b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f4104c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f4105d;

        /* compiled from: AuthcodeTask.java */
        /* loaded from: classes.dex */
        class a implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
            a() {
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                LogEx.d(e.f4096a, "#checkAuthCode #onDataReturn  #result= " + str);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if ("0".equals(jSONObject.getString("returncode"))) {
                        LogEx.d(e.f4096a, "#checkAuthCode #onDataReturn #Check success");
                        b.this.f4102a.b((com.zte.iptvclient.android.common.b.a) jSONObject);
                    } else {
                        LogEx.d(e.f4096a, "#checkAuthCode #onDataReturn #Check failed: returncode = " + jSONObject.getString("returncode") + " errormsg = " + jSONObject.getString("errormsg"));
                        b.this.f4102a.a(jSONObject.getString("errormsg"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.d(e.f4096a, "#checkAuthCode #onFailReturn  #returncode= " + i + " #errormsg=" + str);
                b.this.f4102a.a(str);
            }
        }

        b(com.zte.iptvclient.android.common.b.a aVar, String str, String str2, String str3) {
            this.f4102a = aVar;
            this.f4103b = str;
            this.f4104c = str2;
            this.f4105d = str3;
        }

        @Override // com.video.androidsdk.service.comm.SDKUtil4CELLC.OnGetEPGLocalTimeReturnListener
        public String onGetEPGLocalTimeReturn(String str) {
            HashMap hashMap;
            String aesEncode;
            String c2 = o.j().c();
            if (TextUtils.isEmpty(c2)) {
                LogEx.e(e.f4096a, " ipPort = null");
                this.f4102a.a("getPropertiesInfo(\"appServerUrl\") = null");
                return null;
            }
            String replace = "{http://ip:port}/checkauthcode".replace("{http://ip:port}", c2);
            SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
            try {
                String str2 = this.f4103b + "$$" + str + "$$" + f.a(10);
                LogEx.d(e.f4096a, "strSrc=" + str2);
                aesEncode = AES.aesEncode(str2.getBytes(), AES.getEncryptKey("impkey").getBytes());
                hashMap = new HashMap();
            } catch (Exception e) {
                e = e;
                hashMap = null;
            }
            try {
                hashMap.put("usercode", this.f4103b);
                hashMap.put(ParamConst.SUBSCRIBE_RES_TRANSACTIONID, this.f4104c);
                hashMap.put(IIPTVLogin.LOGIN_PARAM_AUTHCODE, this.f4105d);
                hashMap.put("authinfo", aesEncode);
                LogEx.d(e.f4096a, "builder=" + e.this.a(hashMap));
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
                sDKNetHTTPRequest.setHeader(IIPTVLogin.LOGIN_PARAM_CHARSET, "utf-8");
                sDKNetHTTPRequest.setBody(e.this.a(hashMap));
                sDKNetHTTPRequest.startRequest(replace, HttpRequest.METHOD_POST, new a());
                return null;
            }
            sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
            sDKNetHTTPRequest.setHeader(IIPTVLogin.LOGIN_PARAM_CHARSET, "utf-8");
            sDKNetHTTPRequest.setBody(e.this.a(hashMap));
            sDKNetHTTPRequest.startRequest(replace, HttpRequest.METHOD_POST, new a());
            return null;
        }
    }

    @Override // com.zte.iptvclient.android.common.b.b
    public void a(String str, String str2, int i, String str3, String str4, com.zte.iptvclient.android.common.b.a aVar) {
        new SDKUtil4CELLC().getEPGLocalTime(new a(aVar, str4, str3, str, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        if (map == null) {
            return "";
        }
        boolean z = true;
        for (String str : map.keySet()) {
            if (str != null && map.get(str) != null) {
                if (z) {
                    z = false;
                } else {
                    sb.append("&");
                }
                sb.append(str);
                sb.append("=");
                sb.append(map.get(str));
            }
        }
        return sb.toString();
    }

    @Override // com.zte.iptvclient.android.common.b.b
    public void a(String str, String str2, int i, String str3, com.zte.iptvclient.android.common.b.a aVar, String str4) {
        new SDKUtil4CELLC().getEPGLocalTime(new b(aVar, str, str4, str3));
    }
}
