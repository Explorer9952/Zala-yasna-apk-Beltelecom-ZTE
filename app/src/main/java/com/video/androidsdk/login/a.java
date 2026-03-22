package com.video.androidsdk.login;

import android.os.Bundle;
import android.text.TextUtils;
import com.video.androidsdk.common.AES;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.ErrMessage;
import com.video.androidsdk.common.GlobalConst;
import com.video.androidsdk.common.http.HttpConstant;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.common.util.security.Base16;
import com.video.androidsdk.common.util.security.DES;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.bean.EncryTokenReq;
import com.video.androidsdk.login.bean.LoadBalanceReq;
import com.video.androidsdk.login.bean.LoginCheckReq;
import com.video.androidsdk.login.bean.PortalAuthReq;
import com.video.androidsdk.login.bean.QuaryAccountListReq;
import com.video.androidsdk.login.bean.UserTokenReq;
import com.video.androidsdk.login.impl.IIPTVLogin;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.HashMap;

/* compiled from: IPTVLogin.java */
/* loaded from: classes.dex */
public class a implements IIPTVLogin {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3141a = "a";

    /* renamed from: c, reason: collision with root package name */
    private com.video.androidsdk.login.impl.a f3143c;

    /* renamed from: d, reason: collision with root package name */
    private Bundle f3144d;
    private boolean e;
    private URL f;
    private com.video.androidsdk.login.impl.b h;
    private String i;

    /* renamed from: b, reason: collision with root package name */
    private int f3142b = 0;
    private boolean g = true;

    public a(URL url) {
        this.h = null;
        this.i = HttpConstant.PROTOCOL_HTTP;
        this.f = url;
        this.i = this.f.getProtocol() + "://";
        this.h = new com.video.androidsdk.login.impl.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.video.androidsdk.login.impl.a aVar) {
        String str;
        LogEx.d(f3141a, "startLogin80");
        if (!TextUtils.isEmpty(m.a().get("UserID"))) {
            this.f3144d.putString("UserID", m.a().get("UserID"));
        }
        if (this.f3142b == 5) {
            int port = this.f.getPort();
            if (port == -1) {
                port = TextUtils.equals(HttpConstant.PROTOCOL_HTTPS, this.f.getProtocol()) ? 443 : 80;
            }
            str = this.i + this.f.getHost() + ":" + port;
        } else {
            str = this.i + SDKLoginMgr.getInstance().getEPGHost() + ":" + SDKLoginMgr.getInstance().getEPGPort();
        }
        LoadBalanceReq loadBalanceReq = new LoadBalanceReq();
        loadBalanceReq.setAccountType("0");
        loadBalanceReq.setTerminalFlag(this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_TERMINALFLAG));
        loadBalanceReq.setUserID(this.f3144d.getString("UserID"));
        loadBalanceReq.setUserIP(this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_IP));
        loadBalanceReq.setTerminalOsType(GlobalConst.STR_TERMINAL_OSTYPE);
        this.h.a(this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_CHARSET, "UTF-8"));
        this.h.a(loadBalanceReq, IIPTVLogin.REQUESTID_80, str, new i(this, aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.video.androidsdk.login.impl.a aVar) {
        String str = m.a().get("StypeUrl");
        if (str == null) {
            return;
        }
        String str2 = this.i + SDKLoginMgr.getInstance().getEPGHost() + ":" + SDKLoginMgr.getInstance().getEPGPort();
        this.h.a(this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_CHARSET, "UTF-8"));
        this.h.a(str2, str, new j(this, aVar));
    }

    @Override // com.video.androidsdk.login.impl.IIPTVLogin
    public void cancel() {
    }

    @Override // com.video.androidsdk.login.impl.IIPTVLogin
    public void cancelCallback() {
        this.f3143c = null;
    }

    @Override // com.video.androidsdk.login.impl.IIPTVLogin
    public void doHeartbeat() {
        LogEx.i(f3141a, "sendHeartBeatRequest");
        if (TextUtils.isEmpty(SDKLoginMgr.getInstance().getEPGHost())) {
            LogEx.w(f3141a, "getEPGIpAddr() == null");
            return;
        }
        com.video.androidsdk.login.impl.b bVar = this.h;
        if (bVar != null) {
            bVar.a(this.i + SDKLoginMgr.getInstance().getEPGHost() + ":" + SDKLoginMgr.getInstance().getEPGPort(), new k(this));
            return;
        }
        LogEx.w(f3141a, "mPublicLoginMethod == null");
    }

    @Override // com.video.androidsdk.login.impl.IIPTVLogin
    public void downloadProperties() {
        g(this.f3143c);
    }

    @Override // com.video.androidsdk.login.impl.IIPTVLogin
    public void login(com.video.androidsdk.login.impl.a aVar) {
        this.f3143c = aVar;
        a(aVar);
    }

    @Override // com.video.androidsdk.login.impl.IIPTVLogin
    public void logout(com.video.androidsdk.login.impl.a aVar) {
        a(IIPTVLogin.LOGIN_PARAM_ACTIONLOGOUT, aVar);
    }

    @Override // com.video.androidsdk.login.impl.IIPTVLogin
    public void setBundle(Bundle bundle) {
        this.f3144d = bundle;
    }

    @Override // com.video.androidsdk.login.impl.IIPTVLogin
    public void setHeartInterval(int i) {
        if (i < 0) {
            i = 0;
        }
        com.video.androidsdk.login.impl.b bVar = this.h;
        if (bVar != null) {
            bVar.a(i);
        }
    }

    @Override // com.video.androidsdk.login.impl.IIPTVLogin
    public void setLoginType(int i, boolean z) {
        LogEx.d(f3141a, "iLoginType=" + i);
        this.e = z;
        if (i != 0 && i != 1 && i != 2 && i != 4 && i != 5) {
            LogEx.e(f3141a, "Unsupported login type:" + i);
            return;
        }
        this.f3142b = i;
    }

    @Override // com.video.androidsdk.login.impl.IIPTVLogin
    public void stopHeartbeat() {
        com.video.androidsdk.login.impl.b bVar = this.h;
        if (bVar != null) {
            bVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.video.androidsdk.login.impl.a aVar) {
        LogEx.d(f3141a, "startLogin75");
        if (!TextUtils.isEmpty(m.a().get("RealUserID"))) {
            this.f3144d.putString("UserID", m.a().get("RealUserID"));
        }
        PortalAuthReq portalAuthReq = new PortalAuthReq();
        String str = this.i + SDKLoginMgr.getInstance().getEPGHost() + ":" + SDKLoginMgr.getInstance().getEPGPort();
        portalAuthReq.setSTBID(this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_UNIQUEID));
        if (TextUtils.isEmpty(portalAuthReq.getSTBID())) {
            portalAuthReq.setSTBID(this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_MAC));
        }
        portalAuthReq.setTerminalFlag(this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_TERMINALFLAG));
        portalAuthReq.setUserID(this.f3144d.getString("UserID"));
        if (this.f3142b == 5) {
            portalAuthReq.setUserToken(this.f3144d.getString("usertoken"));
            if (m.a().get("iemg") != null && m.a().get("iemg").equals("1")) {
                portalAuthReq.setAuthStr(m.a().get("AuthStr"));
                portalAuthReq.setEmgInfo(m.a().get("EmgInfo"));
            }
        } else {
            portalAuthReq.setUserToken(m.a().get("UserToken"));
        }
        portalAuthReq.setTerminalOsType(GlobalConst.STR_TERMINAL_OSTYPE);
        this.h.a(this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_CHARSET, "UTF-8"));
        this.h.a(portalAuthReq, IIPTVLogin.REQUESTID_75, str, new f(this, aVar));
    }

    private void b(com.video.androidsdk.login.impl.a aVar) {
        QuaryAccountListReq quaryAccountListReq = new QuaryAccountListReq();
        this.f3144d.getString("3DESKey");
        String str = this.i + this.f.getHost();
        int port = this.f.getPort();
        if (port == -1) {
            port = TextUtils.equals(HttpConstant.PROTOCOL_HTTPS, this.f.getProtocol()) ? 443 : 80;
        }
        String str2 = str + ":" + port;
        String string = this.f3144d.getString("Password");
        String a2 = com.video.androidsdk.license.a.a(this.h.c());
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(a2)) {
            try {
                string = AES.aesEncryptByBase64(string.getBytes(), a2.getBytes());
            } catch (UnsupportedEncodingException e) {
                LogEx.w(f3141a, ErrMessage.ENCRYPT_PASSWORD_FAILED + e.getMessage());
                if (aVar != null) {
                    aVar.b(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGIN_MODELCODE, 101)), ErrMessage.ENCRYPT_PASSWORD_FAILED);
                    return;
                }
                return;
            }
        }
        if (string == null) {
            if (aVar != null) {
                aVar.b(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGIN_MODELCODE, 101)), ErrMessage.ENCRYPT_PASSWORD_FAILED);
                return;
            }
            return;
        }
        quaryAccountListReq.setStbsn(this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_MAC));
        quaryAccountListReq.setLoginpwd(string);
        quaryAccountListReq.setMobileno(this.f3144d.getString("UserID"));
        quaryAccountListReq.setLogintype(this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_ACCOUNTTYPE));
        quaryAccountListReq.setTerminalflag(this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_TERMINALFLAG));
        quaryAccountListReq.setTerminalostype(GlobalConst.STR_TERMINAL_OSTYPE);
        quaryAccountListReq.setDevicecode(this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_UNIQUEID));
        quaryAccountListReq.setAuthinfo(com.video.androidsdk.login.a.c.a(this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_MAC)));
        this.h.a(this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_CHARSET, "UTF-8"));
        this.h.a(quaryAccountListReq, IIPTVLogin.REQUESTID_57, str2, new b(this, aVar, a2));
    }

    private void c(com.video.androidsdk.login.impl.a aVar) {
        LoginCheckReq loginCheckReq = new LoginCheckReq();
        String string = this.f3144d.getString("3DESKey");
        String str = this.i + this.f.getHost();
        int port = this.f.getPort();
        if (port == -1) {
            port = TextUtils.equals(HttpConstant.PROTOCOL_HTTPS, this.f.getProtocol()) ? 443 : 80;
        }
        String str2 = str + ":" + port;
        String string2 = this.f3144d.getString("Password");
        if (!StringUtil.isEmptyString(string2)) {
            try {
                string2 = Base16.encode(DES.encrypt(string.getBytes(), string2.getBytes("ASCII"), DES.ALGORITHM_TRIPLE));
            } catch (UnsupportedEncodingException e) {
                LogEx.w(f3141a, ErrMessage.ENCRYPT_PASSWORD_FAILED + e.getMessage());
                if (aVar != null) {
                    aVar.b(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGIN_MODELCODE, 101)), ErrMessage.ENCRYPT_PASSWORD_FAILED);
                    return;
                }
                return;
            }
        }
        if (string2 == null) {
            if (aVar != null) {
                aVar.b(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGIN_MODELCODE, 101)), ErrMessage.ENCRYPT_PASSWORD_FAILED);
                return;
            }
            return;
        }
        loginCheckReq.set3DESKey(string);
        loginCheckReq.setDeviceID(this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_UNIQUEID));
        loginCheckReq.setDevmac(this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_MAC));
        loginCheckReq.setPassword(string2);
        loginCheckReq.setRealUserID(this.f3144d.getString("RealUserID"));
        loginCheckReq.setTerminalFlag(this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_TERMINALFLAG));
        loginCheckReq.setUserID(this.f3144d.getString("UserID"));
        loginCheckReq.setTerminalOsType(GlobalConst.STR_TERMINAL_OSTYPE);
        this.h.a(this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_CHARSET, "UTF-8"));
        this.h.a(loginCheckReq, IIPTVLogin.REQUESTID_60, str2, new c(this, aVar, string));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.video.androidsdk.login.impl.a aVar) {
        LogEx.d(f3141a, "startLogin63");
        if (this.f3144d == null) {
            aVar.b(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGIN_MODELCODE, ErrCode.ERRCODE_HTTP_PARAM_IS_NULL)), ErrMessage.PARAM_IS_NULL);
            return;
        }
        UserTokenReq userTokenReq = new UserTokenReq();
        if (!TextUtils.isEmpty(m.a().get("RealUserID"))) {
            this.f3144d.putString("UserID", m.a().get("RealUserID"));
        }
        if (!TextUtils.isEmpty(m.a().get("RealPassword"))) {
            this.f3144d.putString("Password", m.a().get("RealPassword"));
        }
        if ("1".equals(m.a().get("iemg"))) {
            this.f3144d.putString(IIPTVLogin.LOGIN_AUTHSTR, m.a().get("AuthStr"));
            this.f3144d.putString(IIPTVLogin.LOGIN_EMGINFO, m.a().get("EmgInfo"));
        }
        if (TextUtils.equals("1", this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_ISSSO))) {
            String str = m.a().get("userpwd");
            String str2 = m.a().get("userid");
            if (!TextUtils.isEmpty(str)) {
                this.f3144d.putString("Password", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                this.f3144d.putString("UserID", str2);
            }
            userTokenReq.setLoginaccount(this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_LOGINACCOUNT));
        }
        this.f3144d.putString(IIPTVLogin.LOGIN_PARAM_ENCRYPTTOKEN, m.a().get("EncryToken"));
        String string = this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_UNIQUEID);
        String string2 = this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_IP);
        String string3 = this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_MAC);
        if (string3 != null && string3.length() > 17) {
            string3 = string3.substring(0, 18);
        }
        String str3 = string3;
        String string4 = this.f3144d.getString("UserID");
        String string5 = this.f3144d.getString("Password");
        String string6 = this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_ENCRYPTTOKEN);
        String str4 = this.i + SDKLoginMgr.getInstance().getEPGHost() + ":" + SDKLoginMgr.getInstance().getEPGPort();
        userTokenReq.setAuthenticator(this.h.a(string6, string4, string, string2, str3, string5, this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_DRMID)));
        userTokenReq.setAuthString(this.f3144d.getString(IIPTVLogin.LOGIN_AUTHSTR));
        userTokenReq.setEmgInfo(this.f3144d.getString(IIPTVLogin.LOGIN_EMGINFO));
        userTokenReq.setTerminalFlag(this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_TERMINALFLAG));
        userTokenReq.setUserID(this.f3144d.getString("UserID"));
        userTokenReq.setTerminalOsType(GlobalConst.STR_TERMINAL_OSTYPE);
        if (!TextUtils.isEmpty(this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_DEVICETYPE))) {
            userTokenReq.setDevicetype(this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_DEVICETYPE));
        }
        if (!TextUtils.isEmpty(this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_DEVICESYSVER))) {
            userTokenReq.setDevicesysver(this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_DEVICESYSVER));
        }
        this.h.a(this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_CHARSET, "UTF-8"));
        this.h.a(userTokenReq, IIPTVLogin.REQUESTID_63, str4, new e(this, aVar));
    }

    public void a(com.video.androidsdk.login.impl.a aVar) {
        LogEx.d(f3141a, "relogin");
        Bundle bundle = this.f3144d;
        if (bundle == null) {
            LogEx.w(f3141a, "null == bundle");
            if (aVar != null) {
                aVar.b(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGIN_MODELCODE, 3)), "Login bundle is null.");
                return;
            }
            return;
        }
        String string = bundle.getString(IIPTVLogin.LOGIN_PARAM_UNIQUEID);
        String string2 = this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_TERMINALFLAG);
        String string3 = this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_IP);
        String string4 = this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_MAC);
        String string5 = this.f3144d.getString("UserID");
        String string6 = this.f3144d.getString("Password");
        com.video.androidsdk.login.impl.b bVar = this.h;
        if (bVar != null) {
            bVar.a(this.f3144d);
        }
        if (string2 != null && string2.trim().length() != 0) {
            if (string != null && string.trim().length() != 0) {
                if (string3 != null && string3.trim().length() != 0) {
                    if (string4 != null && string4.trim().length() != 0) {
                        if (this.f == null) {
                            LogEx.e(f3141a, "HomePage is null");
                            if (aVar != null) {
                                aVar.b(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGIN_MODELCODE, 101)), "HomePage is invalid!");
                                return;
                            }
                            return;
                        }
                        if (this.e) {
                            if (TextUtils.isEmpty(this.f3144d.getString("3DESKey"))) {
                                LogEx.w(f3141a, "null == deskey");
                                if (aVar != null) {
                                    aVar.b(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGIN_MODELCODE, 101)), "3DesKey required!");
                                    return;
                                }
                                return;
                            }
                            if (this.h != null) {
                                LogEx.d(f3141a, "stopHeartbeat");
                                this.h.b();
                                LogEx.d(f3141a, "startLogin60");
                                c(aVar);
                                return;
                            }
                            return;
                        }
                        if (this.f3142b == 5) {
                            if (this.h != null) {
                                f(aVar);
                                return;
                            }
                            return;
                        }
                        if (!TextUtils.equals("1", this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_ISCELLC)) && (string5 == null || string5.trim().length() == 0)) {
                            LogEx.w(f3141a, "null == userid");
                            aVar.b(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGIN_MODELCODE, 3)), "UserID required.");
                            return;
                        }
                        if (string6 != null && string6.trim().length() != 0) {
                            if (this.h != null) {
                                LogEx.d(f3141a, "stopHeartbeat");
                                this.h.b();
                                if (!TextUtils.equals("1", this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_ISSSO))) {
                                    LogEx.d(f3141a, "startLogin61");
                                    a(IIPTVLogin.LOGIN_PARAM_ACTIONLOGIN, aVar);
                                    return;
                                } else {
                                    LogEx.d(f3141a, "startLogin57");
                                    b(aVar);
                                    return;
                                }
                            }
                            return;
                        }
                        LogEx.w(f3141a, "null == password");
                        aVar.b(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGIN_MODELCODE, 3)), "Password required.");
                        return;
                    }
                    LogEx.w(f3141a, "null == mac");
                    aVar.b(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGIN_MODELCODE, 3)), "Local mac required.");
                    return;
                }
                LogEx.w(f3141a, "null == ip");
                aVar.b(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGIN_MODELCODE, 3)), "Local ip required.");
                return;
            }
            LogEx.w(f3141a, "null == uniqueid");
            aVar.b(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGIN_MODELCODE, 3)), "Unique deviceid required.");
            return;
        }
        LogEx.w(f3141a, "null == terminalflag");
        aVar.b(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGIN_MODELCODE, 3)), "TerminalFlag required.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (!this.g || this.h == null) {
            return;
        }
        this.h.a(new g(this), this.i + SDKLoginMgr.getInstance().getEPGHost() + ":" + SDKLoginMgr.getInstance().getEPGPort());
        this.h.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.video.androidsdk.login.impl.a aVar) {
        String str2;
        LogEx.d(f3141a, "startLogin61,  action is " + str);
        if (this.f3144d == null) {
            LogEx.w(f3141a, "null == bundle");
            return;
        }
        EncryTokenReq encryTokenReq = new EncryTokenReq();
        String str3 = m.a().get("RealPassword");
        String str4 = m.a().get("RealUserID");
        if (!TextUtils.isEmpty(str3)) {
            this.f3144d.putString("Password", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            this.f3144d.putString("UserID", str4);
        }
        if (TextUtils.equals("1", this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_ISSSO))) {
            String str5 = m.a().get("userpwd");
            String str6 = m.a().get("userid");
            encryTokenReq.setLoginType(Integer.parseInt(this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_ACCOUNTTYPE)));
            if (!TextUtils.isEmpty(str5)) {
                this.f3144d.putString("Password", str5);
            }
            if (!TextUtils.isEmpty(str6)) {
                this.f3144d.putString("UserID", str6);
            }
        }
        if (IIPTVLogin.LOGIN_PARAM_ACTIONLOGOUT.equalsIgnoreCase(str)) {
            str2 = this.i + SDKLoginMgr.getInstance().getEPGHost() + ":" + SDKLoginMgr.getInstance().getEPGPort();
        } else {
            int port = this.f.getPort();
            if (port == -1) {
                port = TextUtils.equals(HttpConstant.PROTOCOL_HTTPS, this.f.getProtocol()) ? 443 : 80;
            }
            str2 = this.i + this.f.getHost() + ":" + port;
        }
        LogEx.d(f3141a, "domain is " + str2);
        encryTokenReq.setAction(str);
        encryTokenReq.setUserID(this.f3144d.getString("UserID"));
        encryTokenReq.setTerminalFlag(this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_TERMINALFLAG));
        encryTokenReq.setTerminalOsType(GlobalConst.STR_TERMINAL_OSTYPE);
        if (TextUtils.equals("1", this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_ISCELLC))) {
            encryTokenReq.setAccountcode(this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_ACCOUNTCODE));
            encryTokenReq.setAccounttype(this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_ACCOUNTTYPE));
        }
        this.h.a(this.f3144d.getString(IIPTVLogin.LOGIN_PARAM_CHARSET, "UTF-8"));
        this.h.a(encryTokenReq, IIPTVLogin.REQUESTID_61, str2, IIPTVLogin.LOGIN_PARAM_ACTIONLOGOUT.equalsIgnoreCase(str), new d(this, str, aVar));
    }

    public void a(boolean z) {
        this.g = z;
    }

    public void a(HashMap<String, String> hashMap) {
        this.h.a(hashMap);
    }
}
