package com.video.androidsdk.login;

import android.os.Bundle;
import android.text.TextUtils;
import com.video.androidsdk.SDKMgr;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.ParamConst;
import com.video.androidsdk.common.PreferenceHelper;
import com.video.androidsdk.common.RequestUrlContants;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.http.bean.HttpRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.bean.PortalAuthIemgReq;
import com.video.androidsdk.login.impl.IIPTVLogin;
import java.net.URL;

/* compiled from: ThirdAppAuthIPTVLogin.java */
/* loaded from: classes.dex */
public class ab implements IIPTVLogin {

    /* renamed from: b, reason: collision with root package name */
    private static final String f3150b = "ab";

    /* renamed from: a, reason: collision with root package name */
    public PreferenceHelper f3151a;

    /* renamed from: c, reason: collision with root package name */
    private com.video.androidsdk.login.impl.a f3152c;

    /* renamed from: d, reason: collision with root package name */
    private Bundle f3153d;
    private URL e;
    private String f;
    private String g;
    private String h;
    private boolean i = true;
    private com.video.androidsdk.login.impl.b j;

    public ab(URL url) {
        this.f3151a = null;
        this.j = null;
        this.e = url;
        this.j = new com.video.androidsdk.login.impl.b();
        this.f3151a = new PreferenceHelper(SDKMgr.getApplicationContext(), "LoginInfo");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.video.androidsdk.login.impl.a aVar) {
        String str = m.a().get("StypeUrl");
        if (str == null) {
            return;
        }
        this.j.a("http://" + SDKLoginMgr.getInstance().getEPGHost() + ":" + SDKLoginMgr.getInstance().getEPGPort(), str, new ag(this, aVar));
    }

    @Override // com.video.androidsdk.login.impl.IIPTVLogin
    public void cancel() {
    }

    @Override // com.video.androidsdk.login.impl.IIPTVLogin
    public void cancelCallback() {
        this.f3152c = null;
    }

    @Override // com.video.androidsdk.login.impl.IIPTVLogin
    public void doHeartbeat() {
        LogEx.i(f3150b, "sendHeartBeatRequest");
        if (SDKLoginMgr.getInstance().getEPGHost() == null) {
            LogEx.w(f3150b, "getEPGIpAddr() == null");
            return;
        }
        if (this.j != null) {
            this.j.a("http://" + SDKLoginMgr.getInstance().getEPGHost() + ":" + SDKLoginMgr.getInstance().getEPGPort(), new ah(this));
            return;
        }
        LogEx.w(f3150b, "mPublicLoginMethod == null");
    }

    @Override // com.video.androidsdk.login.impl.IIPTVLogin
    public void downloadProperties() {
        d(this.f3152c);
    }

    @Override // com.video.androidsdk.login.impl.IIPTVLogin
    public void login(com.video.androidsdk.login.impl.a aVar) {
        this.f3152c = aVar;
        a(aVar);
    }

    @Override // com.video.androidsdk.login.impl.IIPTVLogin
    public void logout(com.video.androidsdk.login.impl.a aVar) {
    }

    @Override // com.video.androidsdk.login.impl.IIPTVLogin
    public void setBundle(Bundle bundle) {
        this.f3153d = bundle;
    }

    @Override // com.video.androidsdk.login.impl.IIPTVLogin
    public void setHeartInterval(int i) {
        if (i < 0) {
            i = 0;
        }
        com.video.androidsdk.login.impl.b bVar = this.j;
        if (bVar != null) {
            bVar.a(i);
        }
    }

    @Override // com.video.androidsdk.login.impl.IIPTVLogin
    public void setLoginType(int i, boolean z) {
        LogEx.d(f3150b, "iLoginType=" + i);
    }

    @Override // com.video.androidsdk.login.impl.IIPTVLogin
    public void stopHeartbeat() {
        com.video.androidsdk.login.impl.b bVar = this.j;
        if (bVar != null) {
            bVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.video.androidsdk.login.impl.a aVar) {
        String str;
        String str2 = m.a().get("ssoid");
        String str3 = "http://" + SDKLoginMgr.getInstance().getEPGHost() + ":" + SDKLoginMgr.getInstance().getEPGPort();
        this.f3151a.putString("ssoid", str2);
        String str4 = m.a().get("usertoken");
        String str5 = "";
        if (TextUtils.equals(m.a().get("iemg"), "1")) {
            str5 = m.a().get(ParamConst.LOGIN_TRUE_AUTHSTR);
            str = m.a().get(ParamConst.LOGIN_TRUE_EMGINFO);
        } else {
            str = "";
        }
        PortalAuthIemgReq portalAuthIemgReq = new PortalAuthIemgReq();
        portalAuthIemgReq.setDomain(str3);
        portalAuthIemgReq.setSTBID(this.h);
        portalAuthIemgReq.setTerminalFlag(this.g);
        portalAuthIemgReq.setTerminalOsType(this.f);
        portalAuthIemgReq.setUserID(str2);
        portalAuthIemgReq.setUserToken(str4);
        portalAuthIemgReq.setAuthStr(str5);
        portalAuthIemgReq.setEmgInfo(str);
        LogEx.d(f3150b, "start 75 request params , domain : " + str3 + ", stbid: " + this.h + ", terminaltype : " + this.g + ", terminalostype:" + this.f + ", UserID : " + str2 + ",UserToken: " + str4);
        this.j.a(portalAuthIemgReq, IIPTVLogin.REQUESTID_75, str3, new ad(this, aVar));
    }

    private String b() {
        Bundle bundle = this.f3153d;
        if (bundle == null) {
            return "";
        }
        String string = bundle.getString(IIPTVLogin.LOGIN_PARAM_ACCESSTOKEN, "");
        String string2 = this.f3153d.getString(IIPTVLogin.LOGIN_PARAM_AUTHCODE, "");
        this.g = this.f3153d.getString("terminaltype", "");
        this.f = this.f3153d.getString(IIPTVLogin.LOGIN_PARAM_TERMINALOSTYPE, "");
        String string3 = this.f3153d.getString(IIPTVLogin.LOGIN_PARAM_MAC, "");
        this.h = this.f3153d.getString(IIPTVLogin.LOGIN_PARAM_UNIQUEID, "");
        String string4 = this.f3153d.getString(IIPTVLogin.LOGIN_PARAM_DRMID, "");
        String string5 = this.f3153d.getString(IIPTVLogin.LOGIN_PARAM_THIRDSYSTYPE, "");
        String string6 = this.f3153d.getString("ssoid", "");
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append("?accesstoken=");
            stringBuffer.append(string);
            stringBuffer.append("&authcode=");
            stringBuffer.append(string2);
            stringBuffer.append("&terminaltype=");
            stringBuffer.append(Integer.valueOf(this.g));
            stringBuffer.append("&terminalostype=");
            stringBuffer.append(Integer.valueOf(this.f));
            stringBuffer.append("&stbmac=");
            stringBuffer.append(string3);
            stringBuffer.append("&stbcode=");
            stringBuffer.append(this.h);
            stringBuffer.append("&drmid=");
            stringBuffer.append(string4);
            stringBuffer.append("&thirdsystype=");
            stringBuffer.append(Integer.valueOf(string5));
            stringBuffer.append("&ssoid=");
            stringBuffer.append(string6);
            return stringBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void a(com.video.androidsdk.login.impl.a aVar) {
        Bundle bundle = this.f3153d;
        if (bundle == null) {
            a(aVar, ErrCode.getErrCode(IIPTVLogin.REQUESTID_THIRDAPP_AUTH_61, 3), "Login bundle is null.");
            return;
        }
        String string = bundle.getString(IIPTVLogin.LOGIN_PARAM_ACCESSTOKEN, "");
        String string2 = this.f3153d.getString(IIPTVLogin.LOGIN_PARAM_AUTHCODE, "");
        String string3 = this.f3153d.getString("terminaltype", "");
        String string4 = this.f3153d.getString("ssoid", "");
        this.f3151a.putString("ssoid", string4);
        LogEx.i(f3150b, "ssoid:" + string4);
        LogEx.i(f3150b, "authcode:" + string2);
        LogEx.i(f3150b, "terminaltype:" + string3);
        if (!TextUtils.equals(string3, "2") && !TextUtils.equals(string3, "8")) {
            aVar.b(String.valueOf(ErrCode.getErrCode(IIPTVLogin.REQUESTID_THIRDAPP_AUTH_61, 3)), "Third App Auth Login don't support STB or other terminal device.");
            return;
        }
        if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2)) {
            aVar.b(String.valueOf(ErrCode.getErrCode(IIPTVLogin.REQUESTID_THIRDAPP_AUTH_61, 3)), "accesstoken or authcode is invalid.");
            return;
        }
        if (this.j != null) {
            LogEx.d(f3150b, "stopHeartbeat");
            this.j.b();
        }
        b(aVar);
    }

    private void a(com.video.androidsdk.login.impl.a aVar, long j, String str) {
        if (aVar != null) {
            aVar.b(String.valueOf(j), str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (!this.i || this.j == null) {
            return;
        }
        this.j.a(new ae(this), "http://" + SDKLoginMgr.getInstance().getEPGHost() + ":" + SDKLoginMgr.getInstance().getEPGPort());
        this.j.a();
    }

    public void a(boolean z) {
        this.i = z;
    }

    private void b(com.video.androidsdk.login.impl.a aVar) {
        String b2 = b();
        if (TextUtils.isEmpty(b2)) {
            aVar.b(String.valueOf(ErrCode.getErrCode(IIPTVLogin.REQUESTID_THIRDAPP_AUTH_61, 3)), "Third app auth request body error.");
            return;
        }
        String replace = RequestUrlContants.LOGIN_TURE_63.replace("{ipadd:port}", this.e.getHost() + ":" + this.e.getPort());
        StringBuilder sb = new StringBuilder();
        sb.append(replace);
        sb.append(b2);
        String sb2 = sb.toString();
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb2, HttpRequest.METHOD_GET, new ac(this, aVar));
    }
}
