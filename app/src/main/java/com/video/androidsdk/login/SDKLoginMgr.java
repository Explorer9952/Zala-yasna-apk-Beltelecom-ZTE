package com.video.androidsdk.login;

import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.tencent.mm.sdk.contact.RContact;
import com.video.androidsdk.SDKMgr;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.ErrMessage;
import com.video.androidsdk.common.GlobalConst;
import com.video.androidsdk.common.ParamConst;
import com.video.androidsdk.common.RequestUrlContants;
import com.video.androidsdk.common.http.HttpConstant;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.http.SessionMgr;
import com.video.androidsdk.common.http.bean.HttpRequest;
import com.video.androidsdk.common.util.SessionUtil;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.common.util.security.Base16;
import com.video.androidsdk.common.util.security.DES;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.bean.EncryTokenReq;
import com.video.androidsdk.login.bean.LoadBalanceReq;
import com.video.androidsdk.login.bean.LoginCheckReq;
import com.video.androidsdk.login.bean.PortalAuthReq;
import com.video.androidsdk.login.bean.UserTokenReq;
import com.video.androidsdk.login.impl.IIPTVLogin;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class SDKLoginMgr {
    public static final String TERMINAL_TYPE_PAD = "4";
    public static final String TERMINAL_TYPE_PC = "3";
    public static final String TERMINAL_TYPE_PHONE = "2";
    public static final String TERMINAL_TYPE_STB = "1";
    public static final int TYPE_LOGIN_AUTH_ONLY = 2;
    public static final int TYPE_LOGIN_BMS = 1;
    public static final int TYPE_LOGIN_EPG = 0;
    public static final int TYPE_LOGIN_LINKAGE = 4;
    public static final int TYPE_LOGIN_LOADBALANCE_AUTH = 5;
    public static final int TYPE_LOGIN_THIRDAPP_AUTH = 6;
    public static final int TYPE_LOGIN_TRUE = 3;

    /* renamed from: b, reason: collision with root package name */
    private static volatile SDKLoginMgr f3135b = new SDKLoginMgr();

    /* renamed from: a, reason: collision with root package name */
    com.video.androidsdk.login.impl.b f3136a;
    private URL e;
    private String f;
    private int g;
    private String h;
    private String i;
    private String j;
    private String v;
    private String x;
    private String z;

    /* renamed from: c, reason: collision with root package name */
    private ISDKLoginReturnListener f3137c = null;

    /* renamed from: d, reason: collision with root package name */
    private IIPTVLogin f3138d = null;
    private String k = null;
    private String l = null;
    private String m = null;
    private String n = null;
    private String o = null;
    private int p = 0;
    private Bundle q = null;
    private boolean r = false;
    private int s = 0;
    private boolean t = true;
    private boolean w = false;
    private String y = HttpConstant.PROTOCOL_HTTP;
    private boolean A = false;
    private ScheduledExecutorService u = new ScheduledThreadPoolExecutor(1);

    /* loaded from: classes.dex */
    public interface ISDKLoginReturnListener {
        void onHeartbeatReturn(String str, String str2);

        void onLoginReturn(String str, String str2);

        void onLogoutReturn(String str, String str2);

        void onOtherRecvReturn(int i, String str, String str2);

        void onRefreshUserTokeReturn(int i, String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface ISDKProfileLoginReturnListener {
        void onProfileLoginReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnEncryTokenReturnListener {
        void onEncryTokenReturn(String str, String str2, Map<String, String> map);
    }

    /* loaded from: classes.dex */
    public interface OnLoadBalanceReturnListener {
        void onLoadBalanceReturn(String str, String str2, Map<String, String> map);
    }

    /* loaded from: classes.dex */
    public interface OnLoginCheckReturnListener {
        void onLoginCheckReturn(String str, String str2, Map<String, String> map);
    }

    /* loaded from: classes.dex */
    public interface OnPortalAuthReturnListener {
        void onPortalAuthReturn(String str, String str2, Map<String, String> map);
    }

    /* loaded from: classes.dex */
    public interface OnSSOLoginReturnListener {
        void onSSOLoginReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnUserTokenReturnListener {
        void onUserTokenReturn(String str, String str2, Map<String, String> map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private String f3140b;

        public a(String str) {
            this.f3140b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            StringBuffer stringBuffer = new StringBuffer();
            if (!TextUtils.isEmpty(SDKLoginMgr.this.x)) {
                str = SDKLoginMgr.this.x;
            } else {
                str = RequestUrlContants.DEFAULT_UPDATE_USER_TOKEN.replace("{EASIP:PORT}", SDKLoginMgr.this.f + ":" + SDKLoginMgr.this.g);
            }
            stringBuffer.append(str);
            stringBuffer.append("?UserID=");
            stringBuffer.append(SDKLoginMgr.this.h);
            stringBuffer.append("&OldUserToken=");
            stringBuffer.append(SDKLoginMgr.this.getUserInfo("UserToken"));
            stringBuffer.append("&Action=UserTokenExpired");
            String stringBuffer2 = stringBuffer.toString();
            LogEx.d("SDKLoginMgr", "updateUserToken Url:" + stringBuffer2);
            SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
            sDKNetHTTPRequest.setHeader(IIPTVLogin.LOGIN_PARAM_CHARSET, "UTF-8");
            sDKNetHTTPRequest.startRequest(stringBuffer2, "GET", new aa(this));
        }
    }

    private SDKLoginMgr() {
        this.f3136a = null;
        this.f3136a = new com.video.androidsdk.login.impl.b();
    }

    public static SDKLoginMgr getInstance() {
        return f3135b;
    }

    public void doHeartbeat() {
        if (!com.video.androidsdk.license.a.f3129a) {
            LogEx.e("SDKLoginMgr", ErrMessage.LIC_INVALIDATE);
            return;
        }
        IIPTVLogin iIPTVLogin = this.f3138d;
        if (iIPTVLogin == null) {
            return;
        }
        iIPTVLogin.doHeartbeat();
    }

    public void doLoadBalance(LoadBalanceReq loadBalanceReq, OnLoadBalanceReturnListener onLoadBalanceReturnListener) {
        if (!com.video.androidsdk.license.a.f3129a) {
            LogEx.e("SDKLoginMgr", ErrMessage.LIC_INVALIDATE);
            return;
        }
        if (loadBalanceReq == null) {
            LogEx.w("SDKLoginMgr", "encryTokenReq is null");
            if (onLoadBalanceReturnListener != null) {
                onLoadBalanceReturnListener.onLoadBalanceReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGIN_MODELCODE, 2)), ErrMessage.PARAM_IS_NULL, null);
                return;
            }
            return;
        }
        this.f3136a.a(loadBalanceReq, IIPTVLogin.REQUESTID_80, loadBalanceReq.getDomain(), new z(this, onLoadBalanceReturnListener));
    }

    public void doLoginCheck(LoginCheckReq loginCheckReq, OnLoginCheckReturnListener onLoginCheckReturnListener) {
        if (!com.video.androidsdk.license.a.f3129a) {
            LogEx.e("SDKLoginMgr", ErrMessage.LIC_INVALIDATE);
            return;
        }
        if (loginCheckReq == null) {
            LogEx.w("SDKLoginMgr", "loginCheckReq is null");
            if (onLoginCheckReturnListener != null) {
                onLoginCheckReturnListener.onLoginCheckReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGIN_MODELCODE, 2)), ErrMessage.PARAM_IS_NULL, null);
                return;
            }
            return;
        }
        this.f3136a.a(loginCheckReq, IIPTVLogin.REQUESTID_60, loginCheckReq.getDomain(), new u(this, onLoginCheckReturnListener));
    }

    public void doPortalAuth(PortalAuthReq portalAuthReq, OnPortalAuthReturnListener onPortalAuthReturnListener) {
        if (!com.video.androidsdk.license.a.f3129a) {
            LogEx.e("SDKLoginMgr", ErrMessage.LIC_INVALIDATE);
            return;
        }
        if (portalAuthReq == null) {
            LogEx.w("SDKLoginMgr", "encryTokenReq is null");
            if (onPortalAuthReturnListener != null) {
                onPortalAuthReturnListener.onPortalAuthReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGIN_MODELCODE, 2)), ErrMessage.PARAM_IS_NULL, null);
                return;
            }
            return;
        }
        this.f3136a.a(new x(this), portalAuthReq.getDomain());
        this.f3136a.a(portalAuthReq, IIPTVLogin.REQUESTID_75, portalAuthReq.getDomain(), new y(this, onPortalAuthReturnListener, portalAuthReq));
    }

    public String getAuthenticator(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(RContact.FAVOUR_CONTACT_SHOW_HEAD_CHAR);
        sb.append(this.k);
        sb.append(RContact.FAVOUR_CONTACT_SHOW_HEAD_CHAR);
        sb.append(this.n);
        sb.append(RContact.FAVOUR_CONTACT_SHOW_HEAD_CHAR);
        sb.append(str2);
        sb.append(RContact.FAVOUR_CONTACT_SHOW_HEAD_CHAR);
        sb.append(RContact.FAVOUR_CONTACT_SHOW_HEAD_CHAR);
        sb.append("CTC");
        LogEx.d("SDKLoginMgr", "EncodeKey: " + ((Object) sb));
        StringBuilder sb2 = new StringBuilder(str2);
        while (sb2.length() < 24) {
            sb2.append("0");
        }
        byte[] bArr = null;
        try {
            bArr = DES.encrypt(sb2.toString().getBytes("ASCII"), sb.toString().getBytes(), DES.ALGORITHM_TRIPLE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return bArr == null ? "" : Base16.encode(bArr);
    }

    public String getEASHost() {
        if (!com.video.androidsdk.license.a.f3129a) {
            LogEx.e("SDKLoginMgr", ErrMessage.LIC_INVALIDATE);
            return "";
        }
        return this.f;
    }

    public int getEASPort() {
        if (!com.video.androidsdk.license.a.f3129a) {
            LogEx.e("SDKLoginMgr", ErrMessage.LIC_INVALIDATE);
            return -1;
        }
        return this.g;
    }

    public String getEPGHome() {
        if (!com.video.androidsdk.license.a.f3129a) {
            LogEx.e("SDKLoginMgr", ErrMessage.LIC_INVALIDATE);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.y + "://");
        if (TextUtils.isEmpty(getEPGHost())) {
            LogEx.d("SDKLoginMgr", "epg host is null");
            return "";
        }
        sb.append(getEPGHost());
        sb.append(":");
        sb.append(getEPGPort());
        sb.append("/iptvepg/");
        LogEx.d("SDKLoginMgr", "getEPGHome is: " + sb.toString());
        return sb.toString();
    }

    public String getEPGHost() {
        if (!com.video.androidsdk.license.a.f3129a) {
            LogEx.e("SDKLoginMgr", ErrMessage.LIC_INVALIDATE);
            return "";
        }
        String str = TextUtils.equals(this.y, HttpConstant.PROTOCOL_HTTPS) ? m.a().get(ParamConst.LOGIN_SERDOMAIN) : "";
        if (TextUtils.isEmpty(str)) {
            String str2 = m.a().get("SerIpAddress");
            if (TextUtils.isEmpty(str2)) {
                str2 = m.a().get("seripaddress");
            }
            str = str2;
            if (TextUtils.isEmpty(str)) {
                str = m.a().get(ParamConst.LOGIN_TRUE_EPGIP);
            }
        }
        if (str != null && str.contains(":")) {
            this.z = str.substring(str.indexOf(":") + 1);
            str = str.substring(0, str.indexOf(":"));
        }
        if (TextUtils.isEmpty(str)) {
            this.A = false;
            str = com.video.androidsdk.a.d.b(IIPTVLogin.LOGIN_EXTRAPARAM_EPGHOST);
        } else {
            this.A = true;
        }
        LogEx.d("SDKLoginMgr", "EPGHost is " + str);
        return str;
    }

    public String getEPGPort() {
        if (!com.video.androidsdk.license.a.f3129a) {
            LogEx.e("SDKLoginMgr", ErrMessage.LIC_INVALIDATE);
            return "";
        }
        if (!this.A) {
            return com.video.androidsdk.a.d.b(IIPTVLogin.LOGIN_EXTRAPARAM_EPGPORT);
        }
        if (TextUtils.equals(this.y, HttpConstant.PROTOCOL_HTTPS)) {
            if (TextUtils.isEmpty(m.a().get(ParamConst.LOGIN_SERHTTPSPORT))) {
                return !TextUtils.isEmpty(this.z) ? this.z : "443";
            }
            return m.a().get(ParamConst.LOGIN_SERHTTPSPORT);
        }
        if (!TextUtils.isEmpty(m.a().get("SerPort"))) {
            return m.a().get("SerPort");
        }
        if (!TextUtils.isEmpty(m.a().get("serport"))) {
            return m.a().get("serport");
        }
        if (TextUtils.isEmpty(m.a().get(ParamConst.LOGIN_TRUE_EPGPORT))) {
            return !TextUtils.isEmpty(this.z) ? this.z : "8080";
        }
        return m.a().get(ParamConst.LOGIN_TRUE_EPGPORT);
    }

    public void getEncrytToken(EncryTokenReq encryTokenReq, OnEncryTokenReturnListener onEncryTokenReturnListener) {
        if (!com.video.androidsdk.license.a.f3129a) {
            LogEx.e("SDKLoginMgr", ErrMessage.LIC_INVALIDATE);
            return;
        }
        if (encryTokenReq == null) {
            LogEx.w("SDKLoginMgr", "encryTokenReq is null");
            if (onEncryTokenReturnListener != null) {
                onEncryTokenReturnListener.onEncryTokenReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGIN_MODELCODE, 2)), ErrMessage.PARAM_IS_NULL, null);
                return;
            }
            return;
        }
        this.f3136a.a(encryTokenReq, IIPTVLogin.REQUESTID_61, encryTokenReq.getDomain(), new v(this, onEncryTokenReturnListener));
    }

    public String getEpgIPAddress() {
        if (!com.video.androidsdk.license.a.f3129a) {
            LogEx.e("SDKLoginMgr", ErrMessage.LIC_INVALIDATE);
            return "";
        }
        String str = m.a().get("SerIpAddress");
        if (TextUtils.isEmpty(str)) {
            str = m.a().get("seripaddress");
        }
        return TextUtils.isEmpty(str) ? m.a().get(ParamConst.LOGIN_TRUE_EPGIP) : str;
    }

    public String getEpgIPPort() {
        if (!com.video.androidsdk.license.a.f3129a) {
            LogEx.e("SDKLoginMgr", ErrMessage.LIC_INVALIDATE);
            return "";
        }
        return m.a().get("serport");
    }

    public String getFrameHome() {
        if (!com.video.androidsdk.license.a.f3129a) {
            LogEx.e("SDKLoginMgr", ErrMessage.LIC_INVALIDATE);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.y + "://");
        sb.append(getEPGHost());
        sb.append(":");
        sb.append(getEPGPort());
        sb.append("/iptvepg/");
        sb.append(m.a().get("StypeUrl"));
        sb.append("/");
        String sb2 = sb.toString();
        LogEx.d("SDKLoginMgr", "getFrameHome is: " + sb2);
        return !this.A ? com.video.androidsdk.a.d.b("FrameHome") : sb2;
    }

    public String getHTTPSessionID() {
        if (!com.video.androidsdk.license.a.f3129a) {
            LogEx.e("SDKLoginMgr", ErrMessage.LIC_INVALIDATE);
            return "";
        }
        String ePGHost = getEPGHost();
        if (ePGHost == null) {
            return "";
        }
        String ePGPort = getEPGPort();
        if (ePGPort != null && !TextUtils.equals(WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, ePGPort)) {
            ePGHost = ePGHost + ":" + ePGPort.trim();
        }
        String sessionID = SessionMgr.getInstance().getSessionID(ePGHost + "/iptvepg");
        if (!TextUtils.isEmpty(sessionID) || m.a() == null) {
            return sessionID;
        }
        LogEx.d("SDKLoginMgr", "SessionMgr.getInstance().getSessionID failed");
        String str = m.a().get(ParamConst.LOGIN_75_SESSIONID);
        LogEx.d("SDKLoginMgr", "strSessionID === " + str);
        return str;
    }

    public URL getHomePage() {
        if (!com.video.androidsdk.license.a.f3129a) {
            LogEx.e("SDKLoginMgr", ErrMessage.LIC_INVALIDATE);
            return null;
        }
        return this.e;
    }

    public String getPropertiesInfo(String str) {
        byte[] d2;
        if (!com.video.androidsdk.license.a.f3129a) {
            LogEx.e("SDKLoginMgr", ErrMessage.LIC_INVALIDATE);
            return "";
        }
        if (m.c() != null) {
            return m.c().getProperty(str);
        }
        if (com.video.androidsdk.a.d.a() && (d2 = com.video.androidsdk.a.d.d("properties")) != null && d2.length > 0) {
            Properties properties = new Properties();
            try {
                properties.load(new InputStreamReader(new ByteArrayInputStream(d2)));
            } catch (IOException unused) {
                LogEx.d("SDKLoginMgr", "get properteis cached failed! ");
            }
            m.a(properties);
            return properties.getProperty(str);
        }
        LogEx.d("SDKLoginMgr", "get property failed!");
        return "";
    }

    public String getUserID() {
        if (!com.video.androidsdk.license.a.f3129a) {
            LogEx.e("SDKLoginMgr", ErrMessage.LIC_INVALIDATE);
            return "";
        }
        return this.h;
    }

    public String getUserInfo(String str) {
        if (!com.video.androidsdk.license.a.f3129a) {
            LogEx.e("SDKLoginMgr", ErrMessage.LIC_INVALIDATE);
            return "";
        }
        if (TextUtils.equals(str, "SerIpAddress")) {
            return getEPGHost();
        }
        if (TextUtils.equals(str, "SerPort")) {
            return getEPGPort();
        }
        return m.a().get(str);
    }

    public void getUserToken(UserTokenReq userTokenReq, OnUserTokenReturnListener onUserTokenReturnListener) {
        if (!com.video.androidsdk.license.a.f3129a) {
            LogEx.e("SDKLoginMgr", ErrMessage.LIC_INVALIDATE);
            return;
        }
        if (userTokenReq == null) {
            LogEx.w("SDKLoginMgr", "encryTokenReq is null");
            if (onUserTokenReturnListener != null) {
                onUserTokenReturnListener.onUserTokenReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGIN_MODELCODE, 2)), ErrMessage.PARAM_IS_NULL, null);
                return;
            }
            return;
        }
        this.f3136a.a(userTokenReq, IIPTVLogin.REQUESTID_63, userTokenReq.getDomain(), new w(this, onUserTokenReturnListener));
    }

    public int initLogin(int i, String str, String str2, String str3, String str4, String str5, String str6, ISDKLoginReturnListener iSDKLoginReturnListener) {
        if (!com.video.androidsdk.license.a.f3129a) {
            LogEx.e("SDKLoginMgr", ErrMessage.LIC_INVALIDATE);
            return -1;
        }
        setLoginType(i);
        setHomePage(str6);
        setLoginReturnListener(iSDKLoginReturnListener);
        return initLogin(str, str2, str3, str4, str5);
    }

    public void initLoginCheck(Boolean bool, String str) {
        this.r = bool.booleanValue();
        this.j = str;
    }

    public void initUserTokenRefresh(Boolean bool, String str) {
        this.x = str;
        this.w = bool.booleanValue();
    }

    public void reLogin() {
        if (TextUtils.isEmpty(this.h) && TextUtils.isEmpty(this.i)) {
            LogEx.w("SDKLoginMgr", "relogin fail, id and password is null");
        } else {
            startLogin(this.h, this.i);
        }
    }

    public void refreshProperties() {
        if (!com.video.androidsdk.license.a.f3129a) {
            LogEx.e("SDKLoginMgr", ErrMessage.LIC_INVALIDATE);
            return;
        }
        IIPTVLogin iIPTVLogin = this.f3138d;
        if (iIPTVLogin == null) {
            return;
        }
        iIPTVLogin.downloadProperties();
    }

    public void refreshUserToken(String str, String str2, String str3, String str4, ISDKLoginReturnListener iSDKLoginReturnListener) {
        String str5;
        if (!com.video.androidsdk.license.a.f3129a) {
            LogEx.e("SDKLoginMgr", ErrMessage.LIC_INVALIDATE);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (TextUtils.isEmpty(this.x)) {
            str5 = RequestUrlContants.DEFAULT_UPDATE_USER_TOKEN.replace("{EASIP:PORT}", this.f + ":" + this.g);
        } else {
            str5 = this.x;
        }
        stringBuffer.append(str5);
        stringBuffer.append("?UserID=");
        stringBuffer.append(str3);
        stringBuffer.append("&OldUserToken=");
        stringBuffer.append(str4);
        stringBuffer.append("&Action=UserTokenExpired");
        stringBuffer.append("&SPID=");
        stringBuffer.append(str2);
        stringBuffer.append("&transactionID=");
        stringBuffer.append(str);
        String stringBuffer2 = stringBuffer.toString();
        LogEx.d("SDKLoginMgr", "updateUserToken Url:" + stringBuffer2);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader(IIPTVLogin.LOGIN_PARAM_CHARSET, "UTF-8");
        sDKNetHTTPRequest.startRequest(stringBuffer2, HttpRequest.METHOD_GET, new t(this, iSDKLoginReturnListener));
    }

    public void setExtraParams(Bundle bundle) {
        if (!com.video.androidsdk.license.a.f3129a) {
            LogEx.e("SDKLoginMgr", ErrMessage.LIC_INVALIDATE);
            return;
        }
        this.q = bundle;
        if (bundle != null) {
            String string = bundle.getString("SessionID");
            if (!TextUtils.isEmpty(string)) {
                m.a().put(ParamConst.LOGIN_75_SESSIONID, string);
            }
            String string2 = bundle.getString(IIPTVLogin.LOGIN_EXTRAPARAM_EPGHOST);
            if (!TextUtils.isEmpty(string2)) {
                this.y = string2.substring(0, string2.indexOf(":"));
                String substring = string2.substring(string2.lastIndexOf("/") + 1);
                m.a().put(ParamConst.LOGIN_SERDOMAIN, substring);
                m.a().put("SerIpAddress", substring);
                m.a().put("seripaddress", substring);
            }
            String string3 = bundle.getString(IIPTVLogin.LOGIN_EXTRAPARAM_EPGPORT);
            if (!TextUtils.isEmpty(string3)) {
                m.a().put("SerPort", string3);
                m.a().put("serport", string3);
            }
            String string4 = bundle.getString("StypeUrl");
            if (!TextUtils.isEmpty(string4)) {
                m.a().put("StypeUrl", string4);
            }
            String string5 = bundle.getString("UserToken");
            if (!TextUtils.isEmpty(string5)) {
                m.a().put("UserToken", string5);
            }
            String string6 = bundle.getString("UserID");
            if (TextUtils.isEmpty(string6)) {
                return;
            }
            m.a().put("UserID", string6);
        }
    }

    public void setHeartBeatFlag(boolean z) {
        this.t = z;
    }

    public void setHeartInterval(int i) {
        if (i <= 0) {
            return;
        }
        this.s = i;
    }

    public void setHomePage(String str) {
        try {
            URL url = new URL(str);
            this.e = url;
            this.y = url.getProtocol();
            LogEx.d("SDKLoginMgr", "protocol:" + this.y);
            this.f = this.e.getHost();
            int port = this.e.getPort();
            this.g = port;
            if (port == -1) {
                if (TextUtils.equals(HttpConstant.PROTOCOL_HTTPS, this.y)) {
                    this.g = 443;
                } else {
                    this.g = 80;
                }
            }
        } catch (MalformedURLException unused) {
            LogEx.w("SDKLoginMgr", "HomePage configuration invalid!Please check iptvclientsys.ini");
        }
    }

    public void setLoginReturnListener(ISDKLoginReturnListener iSDKLoginReturnListener) {
        this.f3137c = iSDKLoginReturnListener;
    }

    public void setLoginType(int i) {
        this.p = i;
    }

    public void startLogin(String str, String str2) {
        if (!com.video.androidsdk.license.a.f3129a) {
            LogEx.e("SDKLoginMgr", ErrMessage.LIC_INVALIDATE);
            return;
        }
        m.b();
        this.h = str;
        this.i = str2;
        m.a().put("UserID", this.h);
        if (this.p == 4 && (this.q.getBoolean(IIPTVLogin.LOGIN_PARAM_ISMSMMODE) || this.q.getBoolean(IIPTVLogin.LOGIN_PARAM_ISONEKEYMODE))) {
            if (StringUtil.isEmptyString(str)) {
                LogEx.e("SDKLoginMgr", "input param is null");
                ISDKLoginReturnListener iSDKLoginReturnListener = this.f3137c;
                if (iSDKLoginReturnListener != null) {
                    iSDKLoginReturnListener.onLoginReturn(Integer.toString(ErrCode.getErrCode(ErrCode.ERRCODE_LOGIN_MODELCODE, 2)), "input param is null");
                    return;
                }
            }
        } else {
            Bundle bundle = this.q;
            if ((bundle == null || !TextUtils.equals("1", bundle.getString(IIPTVLogin.LOGIN_PARAM_ISCELLC))) && StringUtil.isEmptyString(str)) {
                LogEx.w("SDKLoginMgr", "null == userid");
                ISDKLoginReturnListener iSDKLoginReturnListener2 = this.f3137c;
                if (iSDKLoginReturnListener2 != null) {
                    iSDKLoginReturnListener2.onLoginReturn(Integer.toString(ErrCode.getErrCode(ErrCode.ERRCODE_LOGIN_MODELCODE, 2)), "input param is null");
                    return;
                }
            }
            if (StringUtil.isEmptyString(str2)) {
                LogEx.e("SDKLoginMgr", "input param is null");
                ISDKLoginReturnListener iSDKLoginReturnListener3 = this.f3137c;
                if (iSDKLoginReturnListener3 != null) {
                    iSDKLoginReturnListener3.onLoginReturn(Integer.toString(ErrCode.getErrCode(ErrCode.ERRCODE_LOGIN_MODELCODE, 2)), "input param is null");
                    return;
                }
            }
        }
        IIPTVLogin iIPTVLogin = this.f3138d;
        if (iIPTVLogin != null) {
            iIPTVLogin.cancelCallback();
            this.f3138d.stopHeartbeat();
        }
        if (this.q == null) {
            this.q = new Bundle();
        }
        this.q.putString(IIPTVLogin.LOGIN_PARAM_TERMINALFLAG, this.l);
        this.q.putString(IIPTVLogin.LOGIN_PARAM_UNIQUEID, this.k);
        this.q.putString(IIPTVLogin.LOGIN_PARAM_IP, this.m);
        this.q.putString(IIPTVLogin.LOGIN_PARAM_MAC, this.n);
        this.q.putString("UserID", str);
        this.q.putString("Password", str2);
        this.q.putString(IIPTVLogin.LOGIN_PARAM_DRMID, this.o);
        this.q.putString("3DESKey", this.j);
        if (!TextUtils.isEmpty(SDKMgr.getEPGCharset())) {
            this.q.putString(IIPTVLogin.LOGIN_PARAM_CHARSET, SDKMgr.getEPGCharset());
        }
        if (this.p == 6) {
            LogEx.d("SDKLoginMgr", "LoginType THIRDAPP AUTH");
            ab abVar = new ab(this.e);
            this.f3138d = abVar;
            abVar.a(this.t);
        } else {
            LogEx.d("SDKLoginMgr", "LoginType IPTV");
            com.video.androidsdk.login.a aVar = new com.video.androidsdk.login.a(this.e);
            this.f3138d = aVar;
            aVar.a(this.t);
            int i = this.s;
            if (i > 0) {
                this.f3138d.setHeartInterval(i);
            }
        }
        this.f3138d.setLoginType(this.p, this.r);
        this.f3138d.setBundle(this.q);
        SessionMgr.getInstance().clearSessionCache();
        this.f3138d.login(new n(this, str));
    }

    public void startLogout() {
        if (!com.video.androidsdk.license.a.f3129a) {
            LogEx.e("SDKLoginMgr", ErrMessage.LIC_INVALIDATE);
            return;
        }
        IIPTVLogin iIPTVLogin = this.f3138d;
        if (iIPTVLogin == null) {
            return;
        }
        iIPTVLogin.logout(new s(this));
    }

    public void startProfileLogin(String str, String str2, String str3, ISDKProfileLoginReturnListener iSDKProfileLoginReturnListener) {
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + getInstance().getHTTPSessionID());
        StringBuilder sb = new StringBuilder();
        sb.append(getInstance().getEPGHome());
        sb.append("datasource/profilelogin.jsp");
        sb.append("?profilecode=" + str);
        sb.append("&terminalflag=" + this.l);
        sb.append("&terminalostype=8");
        String authenticator = getAuthenticator(str, str2);
        LogEx.d("SDKLoginMgr", "authenticator: " + authenticator);
        sb.append("&authenticator=" + authenticator);
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new p(this, iSDKProfileLoginReturnListener, str3));
    }

    public void startSSOLogin(String str, String str2, String str3, OnSSOLoginReturnListener onSSOLoginReturnListener) {
        LogEx.d("SDKLoginMgr", "start SSOLogin");
        if (onSSOLoginReturnListener == null) {
            LogEx.w("SDKLoginMgr", "listener is null");
            return;
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(str + "?" + IIPTVLogin.LOGIN_PARAM_LOGINACCOUNT + "=" + str2 + "&loginpwd=" + str3, "GET", new r(this, onSSOLoginReturnListener));
    }

    public void stopRefreshUserToken() {
        LogEx.d("SDKLoginMgr", "stopRefreshUserToken");
        this.v = null;
    }

    public void updatePlayInfo(HashMap<String, String> hashMap) {
        ((com.video.androidsdk.login.a) this.f3138d).a(hashMap);
    }

    public void updateUserToken(long j) {
        if (!com.video.androidsdk.license.a.f3129a) {
            LogEx.e("SDKLoginMgr", ErrMessage.LIC_INVALIDATE);
            return;
        }
        if (this.w) {
            LogEx.d("SDKLoginMgr", "updateUserToken after time:" + j);
            String genSessionID = SessionUtil.genSessionID();
            this.v = genSessionID;
            a(genSessionID, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(OnPortalAuthReturnListener onPortalAuthReturnListener, String str) {
        String str2 = m.a().get("StypeUrl");
        if (str2 == null) {
            return;
        }
        this.f3136a.a(str, str2, new o(this, onPortalAuthReturnListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(String str, long j) {
        LogEx.d("SDKLoginMgr", "updateUserTokenWithSessionId:" + str);
        if (str != null && str.equals(this.v)) {
            this.u.schedule(new a(str), j, TimeUnit.MILLISECONDS);
        }
    }

    public int initLogin(String str, String str2, String str3, String str4, String str5) {
        if (!com.video.androidsdk.license.a.f3129a) {
            LogEx.e("SDKLoginMgr", ErrMessage.LIC_INVALIDATE);
            return -1;
        }
        LogEx.d("SDKLoginMgr", "strClientType=" + str + ", strIpAddr=" + str2 + ", strMacAddr=" + str3 + ", strAndroidID" + str4 + ", strDRMID" + str5);
        if (!StringUtil.isEmptyString(str) && !StringUtil.isEmptyString(str2) && !StringUtil.isEmptyString(str3) && !StringUtil.isEmptyString(str4)) {
            Bundle bundle = this.q;
            if (bundle != null) {
                bundle.clear();
            }
            this.l = str;
            if ("2".equals(str)) {
                GlobalConst.TERMINAL_TYPE = ParamConst.LOG_TERMINAL_TYPE_APHONE;
            } else if ("8".equals(this.l)) {
                GlobalConst.TERMINAL_TYPE = ParamConst.LOG_TERMINAL_TYPE_APAD;
            }
            this.m = str2;
            this.n = str3;
            this.k = str4;
            this.o = str5;
            return 0;
        }
        LogEx.e("SDKLoginMgr", "input param is null");
        return ErrCode.getErrCode(ErrCode.ERRCODE_LOGIN_MODELCODE, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ISDKProfileLoginReturnListener iSDKProfileLoginReturnListener, String str) {
        LogEx.d("SDKLoginMgr", "start downloadProperties");
        if (TextUtils.isEmpty(str)) {
            if (iSDKProfileLoginReturnListener != null) {
                iSDKProfileLoginReturnListener.onProfileLoginReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGIN_MODELCODE, 2)), "stypeurl is null");
                return;
            }
            return;
        }
        this.f3136a.a(this.y + "://" + getInstance().getEPGHost() + ":" + getInstance().getEPGPort(), str, new q(this, str, iSDKProfileLoginReturnListener));
    }

    public int initLogin(String str, LoginReq loginReq, ISDKLoginReturnListener iSDKLoginReturnListener) {
        if (!com.video.androidsdk.license.a.f3129a) {
            LogEx.e("SDKLoginMgr", ErrMessage.LIC_INVALIDATE);
            return -1;
        }
        setLoginType(loginReq.logintype);
        setHomePage(str);
        setLoginReturnListener(iSDKLoginReturnListener);
        if (!StringUtil.isEmptyString(loginReq.terminalflag) && !StringUtil.isEmptyString(loginReq.ipaddr) && !StringUtil.isEmptyString(loginReq.macaddr) && !StringUtil.isEmptyString(loginReq.androidid)) {
            Bundle bundle = this.q;
            if (bundle != null) {
                bundle.clear();
            }
            String str2 = loginReq.terminalflag;
            this.l = str2;
            if ("2".equals(str2)) {
                GlobalConst.TERMINAL_TYPE = ParamConst.LOG_TERMINAL_TYPE_APHONE;
            } else if ("8".equals(this.l)) {
                GlobalConst.TERMINAL_TYPE = ParamConst.LOG_TERMINAL_TYPE_APAD;
            }
            if (!TextUtils.isDigitsOnly(loginReq.terminalostype)) {
                GlobalConst.STR_TERMINAL_OSTYPE = loginReq.terminalostype;
            }
            this.m = loginReq.ipaddr;
            this.n = loginReq.macaddr;
            this.k = loginReq.androidid;
            this.o = loginReq.drmid;
            return 0;
        }
        LogEx.e("SDKLoginMgr", "input param is null");
        return ErrCode.getErrCode(ErrCode.ERRCODE_LOGIN_MODELCODE, 2);
    }
}
