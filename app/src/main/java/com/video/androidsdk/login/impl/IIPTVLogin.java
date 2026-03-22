package com.video.androidsdk.login.impl;

import android.os.Bundle;

/* loaded from: classes.dex */
public interface IIPTVLogin {
    public static final String LOGIN_3DES_KEY = "3DESKey";
    public static final String LOGIN_AUTHSTR = "authStr";
    public static final String LOGIN_EMGINFO = "emgInfo";
    public static final String LOGIN_EXTRAPARAM_EPGHOST = "EPGHost";
    public static final String LOGIN_EXTRAPARAM_EPGPORT = "EPGPort";
    public static final String LOGIN_EXTRAPARAM_SESSIONID = "SessionID";
    public static final String LOGIN_EXTRAPARAM_STYPEURL = "StypeUrl";
    public static final String LOGIN_EXTRAPARAM_USERTOKEN = "UserToken";
    public static final String LOGIN_EXTRAPARAM_UserName = "UserName";
    public static final String LOGIN_HOMEPAGE = "HomePage";
    public static final String LOGIN_NEED_60_SERVICE = "Need60Service";
    public static final String LOGIN_PARAM_3DESKEY = "3DESKey";
    public static final String LOGIN_PARAM_ACCESSTOKEN = "accesstoken";
    public static final String LOGIN_PARAM_ACCOUNTCODE = "accountcode";
    public static final String LOGIN_PARAM_ACCOUNTTYPE = "accounttype";
    public static final String LOGIN_PARAM_ACTION = "action";
    public static final String LOGIN_PARAM_ACTIONLOGIN = "Login";
    public static final String LOGIN_PARAM_ACTIONLOGOUT = "Logout";
    public static final String LOGIN_PARAM_AUTHCODE = "authcode";
    public static final String LOGIN_PARAM_CHARSET = "charset";
    public static final String LOGIN_PARAM_CLIENTID = "clientid";
    public static final String LOGIN_PARAM_CLIENTSECRET = "clientsecret";
    public static final String LOGIN_PARAM_DEVICESYSVER = "devicesysver";
    public static final String LOGIN_PARAM_DEVICETYPE = "devicetype";
    public static final String LOGIN_PARAM_DRMID = "DRMID";
    public static final String LOGIN_PARAM_ENCRYPTTOKEN = "encryptToken";
    public static final String LOGIN_PARAM_IP = "IPAddress";
    public static final String LOGIN_PARAM_ISCELLC = "iscellc";
    public static final String LOGIN_PARAM_ISMSMMODE = "isSMSMode";
    public static final String LOGIN_PARAM_ISONEKEYMODE = "isOneKeyMode";
    public static final String LOGIN_PARAM_ISSSO = "issso";
    public static final String LOGIN_PARAM_LOGINACCOUNT = "loginaccount";
    public static final String LOGIN_PARAM_MAC = "MAC";
    public static final String LOGIN_PARAM_PASSWORD = "Password";
    public static final String LOGIN_PARAM_REALUSERID = "RealUserID";
    public static final String LOGIN_PARAM_SSOID = "ssoid";
    public static final String LOGIN_PARAM_STBCODE = "stbcode";
    public static final String LOGIN_PARAM_STBMAC = "stbmac";
    public static final String LOGIN_PARAM_TERMINALFLAG = "TerminalFlag";
    public static final String LOGIN_PARAM_TERMINALOSTYPE = "terminalostype";
    public static final String LOGIN_PARAM_TERMINALTYPE = "terminaltype";
    public static final String LOGIN_PARAM_THIRDAPP_AUTH_DRMID = "drmid";
    public static final String LOGIN_PARAM_THIRDSYSTYPE = "thirdsystype";
    public static final String LOGIN_PARAM_TRANSACTIONID = "transactionID";
    public static final String LOGIN_PARAM_UNIQUEID = "UniqueId";
    public static final String LOGIN_PARAM_USERID = "UserID";
    public static final String LOGIN_PARAM_USERIP = "userIP";
    public static final String LOGIN_PARAM_USERPORT = "userPort";
    public static final String LOGIN_PARAM_USERTOKEN = "userToken";
    public static final String LOGIN_PARAM_USERTOKENEXPIREDTIME = "UserTokenExpiredTime";
    public static final String LOGIN_SERVIPADDR = "servIpAddr";
    public static final int REQUESTID_57 = 1057;
    public static final int REQUESTID_60 = 1060;
    public static final int REQUESTID_61 = 1061;
    public static final int REQUESTID_63 = 1063;
    public static final int REQUESTID_75 = 1075;
    public static final int REQUESTID_80 = 1080;
    public static final int REQUESTID_89 = 1089;
    public static final int REQUESTID_BMS_61 = 1361;
    public static final int REQUESTID_BMS_63 = 1363;
    public static final int REQUESTID_HEARTBEAT = 1050;
    public static final int REQUESTID_LINKAGE_61 = 1261;
    public static final int REQUESTID_LINKAGE_63 = 1263;
    public static final int REQUESTID_LINKAGE_ONEKEY = 1215;
    public static final int REQUESTID_LINKAGE_USERTOKEN = 1214;
    public static final int REQUESTID_PROPERTIES = 1099;
    public static final int REQUESTID_THIRDAPP_AUTH_61 = 1661;
    public static final int REQUESTID_TRUE_61 = 1161;
    public static final int REQUESTID_TRUE_63 = 1163;
    public static final int REQUESTID_TRUE_75 = 1175;
    public static final int RESPONSE_CANCEL = -1;
    public static final int RESPONSE_HEARTBEAT = 1300;
    public static final int RESPONSE_LOGIN = 1100;
    public static final int RESPONSE_LOGOUT = 1200;
    public static final String STR_PLAY_ENDTIME = "endtime";
    public static final String STR_PLAY_STARTTIME = "starttime";
    public static final String STR_PLAY_THIRDCDNFLAG = "thirdcdnflag";
    public static final int TYPE_LOGIN_AUTH_ONLY = 2;
    public static final int TYPE_LOGIN_BMS = 1;
    public static final int TYPE_LOGIN_EPG = 0;
    public static final int TYPE_LOGIN_LINKAGE = 4;
    public static final int TYPE_LOGIN_LOADBALANCE_AUTH = 5;
    public static final int TYPE_LOGIN_THIRDAPP_AUTH = 6;
    public static final int TYPE_LOGIN_TRUE = 3;

    void cancel();

    void cancelCallback();

    void doHeartbeat();

    void downloadProperties();

    void login(a aVar);

    void logout(a aVar);

    void setBundle(Bundle bundle);

    void setHeartInterval(int i);

    void setLoginType(int i, boolean z);

    void stopHeartbeat();
}
