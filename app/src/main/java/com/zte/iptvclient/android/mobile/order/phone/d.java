package com.zte.iptvclient.android.mobile.order.phone;

import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.impl.IIPTVLogin;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: OrderHttpRequest.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public String f6996a = "120.210.203.56:5080";

    /* compiled from: OrderHttpRequest.java */
    /* loaded from: classes.dex */
    class a implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC0329d f6997a;

        a(d dVar, InterfaceC0329d interfaceC0329d) {
            this.f6997a = interfaceC0329d;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("OrderHttpRequest", "getValidate onDataReturn " + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.has("returncode") ? jSONObject.optInt("returncode") : -1;
                String optString = jSONObject.has("errormsg") ? jSONObject.optString("errormsg") : "";
                String optString2 = jSONObject.has("out_trade_no") ? jSONObject.optString("out_trade_no") : "";
                if (this.f6997a != null) {
                    this.f6997a.a(optInt, optString, optString2);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                InterfaceC0329d interfaceC0329d = this.f6997a;
                if (interfaceC0329d != null) {
                    interfaceC0329d.a(-1, "", "");
                }
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("OrderHttpRequest", "getValidate onFailReturn " + i + str);
            InterfaceC0329d interfaceC0329d = this.f6997a;
            if (interfaceC0329d != null) {
                interfaceC0329d.a(-1, "", "");
            }
        }
    }

    /* compiled from: OrderHttpRequest.java */
    /* loaded from: classes.dex */
    class b implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        b(d dVar) {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("OrderHttpRequest", "reGetValidate onDataReturn " + str);
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("OrderHttpRequest", "reGetValidate onFailReturn " + i + str);
        }
    }

    /* compiled from: OrderHttpRequest.java */
    /* loaded from: classes.dex */
    class c implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f6998a;

        c(d dVar, e eVar) {
            this.f6998a = eVar;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("OrderHttpRequest", "doOrder onDataReturn " + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.has("returncode") ? jSONObject.optInt("returncode") : -1;
                String optString = jSONObject.has("errormsg") ? jSONObject.optString("errormsg") : "";
                if (this.f6998a != null) {
                    this.f6998a.a(optInt, optString);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                e eVar = this.f6998a;
                if (eVar != null) {
                    eVar.a(-1, "");
                }
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("OrderHttpRequest", "doOrder onFailReturn " + i + str);
            e eVar = this.f6998a;
            if (eVar != null) {
                eVar.a(-1, "");
            }
        }
    }

    /* compiled from: OrderHttpRequest.java */
    /* renamed from: com.zte.iptvclient.android.mobile.order.phone.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0329d {
        void a(int i, String str, String str2);
    }

    /* compiled from: OrderHttpRequest.java */
    /* loaded from: classes.dex */
    public interface e {
        void a(int i, String str);
    }

    public void a(com.zte.iptvclient.android.mobile.order.phone.b bVar, InterfaceC0329d interfaceC0329d) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("http://%s/iptvappsvr/thirdpay/phoneprepay.jsp", this.f6996a));
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader(IIPTVLogin.LOGIN_PARAM_CHARSET, "utf-8");
        LogEx.d("OrderHttpRequest", "入参" + bVar.a().toString());
        sDKNetHTTPRequest.setBody(bVar.a().toString());
        sDKNetHTTPRequest.startRequest(sb.toString(), "POST", new a(this, interfaceC0329d));
    }

    public void a(g gVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("http://%s/iptvappsvr/thirdpay/resendSMS.jsp", this.f6996a));
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader(IIPTVLogin.LOGIN_PARAM_CHARSET, "utf-8");
        LogEx.d("OrderHttpRequest", "入参" + gVar.a().toString());
        sDKNetHTTPRequest.setBody(gVar.a().toString());
        sDKNetHTTPRequest.startRequest(sb.toString(), "POST", new b(this));
    }

    public void a(com.zte.iptvclient.android.mobile.order.phone.e eVar, e eVar2) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("http://%s/iptvappsvr/thirdpay/phonepay.jsp", this.f6996a));
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader(IIPTVLogin.LOGIN_PARAM_CHARSET, "utf-8");
        LogEx.d("OrderHttpRequest", "入参" + eVar.a().toString());
        sDKNetHTTPRequest.setBody(eVar.a().toString());
        sDKNetHTTPRequest.startRequest(sb.toString(), "POST", new c(this, eVar2));
    }
}
