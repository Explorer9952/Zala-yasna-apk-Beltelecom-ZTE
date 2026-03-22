package com.video.androidsdk.login.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.sdk.contact.RContact;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.ErrMessage;
import com.video.androidsdk.common.RequestUrlContants;
import com.video.androidsdk.common.Security;
import com.video.androidsdk.common.ServerDate;
import com.video.androidsdk.common.TimerMgr;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.common.util.TimeUtil;
import com.video.androidsdk.common.util.security.Base16;
import com.video.androidsdk.common.util.security.DES;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.login.bean.BaseReq;
import com.video.androidsdk.mes.BuildConfig;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: PublicLoginMethod.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3181a = "b";

    /* renamed from: b, reason: collision with root package name */
    private static int f3182b = 3;

    /* renamed from: c, reason: collision with root package name */
    private static int f3183c = 900;

    /* renamed from: d, reason: collision with root package name */
    private int f3184d;
    private String e;
    private TimerMgr.ITimerMgr g;
    private String h = "";
    private Bundle i = null;
    private boolean j = false;
    private HashMap<String, String> k = new HashMap<>();
    private int f = f3183c;

    /* compiled from: PublicLoginMethod.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(String str, String str2, HashMap<String, String> hashMap);
    }

    /* compiled from: PublicLoginMethod.java */
    /* renamed from: com.video.androidsdk.login.impl.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0095b {
        void a(String str, String str2, Properties properties);
    }

    /* compiled from: PublicLoginMethod.java */
    /* loaded from: classes.dex */
    public interface c {
        void a(String str, String str2);
    }

    public b() {
        this.f3184d = 0;
        this.f3184d = 0;
    }

    private String b(int i) {
        switch (i) {
            case IIPTVLogin.REQUESTID_57 /* 1057 */:
                return RequestUrlContants.LOGIN_57;
            case IIPTVLogin.REQUESTID_60 /* 1060 */:
                return RequestUrlContants.LOGIN_60;
            case IIPTVLogin.REQUESTID_61 /* 1061 */:
                return RequestUrlContants.LOGIN_61;
            case IIPTVLogin.REQUESTID_63 /* 1063 */:
                return RequestUrlContants.LOGIN_63;
            case IIPTVLogin.REQUESTID_75 /* 1075 */:
                return RequestUrlContants.LOGIN_75;
            case IIPTVLogin.REQUESTID_80 /* 1080 */:
                return RequestUrlContants.LOGIN_80;
            case IIPTVLogin.REQUESTID_TRUE_61 /* 1161 */:
                return RequestUrlContants.LOGIN_TURE_61;
            case IIPTVLogin.REQUESTID_TRUE_63 /* 1163 */:
                return RequestUrlContants.LOGIN_TURE_63;
            case IIPTVLogin.REQUESTID_TRUE_75 /* 1175 */:
                return RequestUrlContants.LOGIN_TURE_75;
            case IIPTVLogin.REQUESTID_LINKAGE_USERTOKEN /* 1214 */:
                return RequestUrlContants.LOGIN_LINKAGE_SMS_USERTOKEN;
            case IIPTVLogin.REQUESTID_LINKAGE_ONEKEY /* 1215 */:
                return RequestUrlContants.LOGIN_LINKAGE_ONEKEY_USERTOKEN;
            case IIPTVLogin.REQUESTID_LINKAGE_61 /* 1261 */:
                return RequestUrlContants.LOGIN_LINKAGE_61;
            case IIPTVLogin.REQUESTID_LINKAGE_63 /* 1263 */:
                return RequestUrlContants.LOGIN_LINKAGE_63;
            case IIPTVLogin.REQUESTID_BMS_61 /* 1361 */:
                return RequestUrlContants.LOGIN_BMS_61;
            case IIPTVLogin.REQUESTID_BMS_63 /* 1363 */:
                return RequestUrlContants.LOGIN_BMS_63;
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int d(b bVar) {
        int i = bVar.f3184d;
        bVar.f3184d = i + 1;
        return i;
    }

    private String f() {
        LogEx.d(f3181a, "startTime: " + this.k.get("starttime"));
        Date stringToDate = TimeUtil.stringToDate(this.k.get("starttime"), TimeUtil.STR_FORMAT_YMDHMS);
        LogEx.d(f3181a, "start date : " + stringToDate);
        String str = this.k.get("endtime");
        Date epgTime = ServerDate.getEpgTime();
        if (!TextUtils.isEmpty(str)) {
            epgTime = TimeUtil.stringToDate(str, TimeUtil.STR_FORMAT_YMDHMS);
            this.k.clear();
        }
        return (epgTime == null || stringToDate == null) ? "" : String.valueOf(TimeUtil.calcOffset(epgTime, stringToDate) / 1000);
    }

    private String g() {
        String str = this.k.get("endtime");
        return TextUtils.isEmpty(str) ? TimeUtil.format(ServerDate.getEpgTime(), TimeUtil.STR_FORMAT_YMDHMS) : str;
    }

    public void b() {
        LogEx.d(f3181a, "stopHeartbeat");
        TimerMgr.getInstance().stop(this.e);
    }

    public String c() {
        String string = this.i.getString("logindataversion");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        char c2 = 65535;
        int hashCode = string.hashCode();
        if (hashCode != 48563) {
            if (hashCode != 49524) {
                if (hashCode == 50485 && string.equals("3.0")) {
                    c2 = 2;
                }
            } else if (string.equals("2.0")) {
                c2 = 1;
            }
        } else if (string.equals(BuildConfig.VERSION_NAME)) {
            c2 = 0;
        }
        return c2 != 0 ? c2 != 1 ? c2 != 2 ? "" : "3.0_login" : "2.0_login" : "1.0_login";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        boolean z;
        boolean z2;
        if (str == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            new JSONObject(str);
            z = true;
        } catch (Exception unused) {
            z = false;
        }
        try {
            new JSONArray(str);
            z2 = true;
        } catch (Exception unused2) {
            z2 = false;
        }
        return z2 || z;
    }

    public void a(Bundle bundle) {
        this.i = bundle;
    }

    public void a(Object obj, int i, String str, a aVar) {
        a(obj, i, str, false, aVar);
    }

    public void a(Object obj, int i, String str, boolean z, a aVar) {
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        if (obj == null) {
            LogEx.w(f3181a, "loginReq is null");
            if (aVar != null) {
                aVar.a(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGIN_MODELCODE, 2)), ErrMessage.PARAM_IS_NULL, null);
            }
        }
        String b2 = b(i);
        LogEx.d(f3181a, "is logout request:" + z);
        if (z) {
            b2 = b2.replace("mobilelogin.jsp", "stblogin.jsp");
            LogEx.d(f3181a, "logout request url:" + b2);
            sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        }
        if (StringUtil.isEmptyString(b2)) {
            LogEx.w(f3181a, "request is  null");
            if (aVar != null) {
                aVar.a(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGIN_MODELCODE, 2)), ErrMessage.PARAM_IS_NULL, null);
            }
        }
        if (b2.contains("http://{ipadd:port}")) {
            b2 = b2.replace("http://{ipadd:port}", str);
        }
        LogEx.d(f3181a, "request is  " + b2);
        if (!StringUtil.isEmptyString(this.h)) {
            sDKNetHTTPRequest.setHeader(IIPTVLogin.LOGIN_PARAM_CHARSET, this.h);
        }
        if (obj != null) {
            for (Map.Entry<String, String> entry : ((BaseReq) obj).toHashMap().entrySet()) {
                sDKNetHTTPRequest.setParam(entry.getKey(), entry.getValue());
            }
        }
        Bundle bundle = this.i;
        if (bundle != null && TextUtils.equals(bundle.getString("logindatatype"), "99")) {
            sDKNetHTTPRequest.setHeader("logindatatype", this.i.getString("logindatatype"));
            sDKNetHTTPRequest.setHeader("logindataversion", this.i.getString("logindataversion"));
            this.j = true;
        }
        sDKNetHTTPRequest.startRequest(b2, "POST", new com.video.androidsdk.login.impl.c(this, b2, aVar, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a1 A[Catch: Exception -> 0x00a5, TRY_LEAVE, TryCatch #0 {Exception -> 0x00a5, blocks: (B:3:0x0008, B:5:0x000e, B:7:0x002e, B:11:0x0049, B:14:0x0059, B:15:0x005f, B:29:0x00a1, B:32:0x0080, B:33:0x0091), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(java.lang.String r10, int r11, com.video.androidsdk.login.impl.b.a r12) {
        /*
            r9 = this;
            java.lang.String r0 = " response can not be parsed!"
            r1 = 0
            r2 = 202(0xca, float:2.83E-43)
            r3 = 17100000(0x104ece0, float:2.441452E-38)
            java.util.HashMap r4 = com.video.androidsdk.common.util.AndroidUtils.toHashMap(r10)     // Catch: java.lang.Exception -> La5
            if (r4 != 0) goto L49
            java.lang.String r4 = com.video.androidsdk.login.impl.b.f3181a     // Catch: java.lang.Exception -> La5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La5
            r5.<init>()     // Catch: java.lang.Exception -> La5
            java.lang.String r6 = "response "
            r5.append(r6)     // Catch: java.lang.Exception -> La5
            r5.append(r11)     // Catch: java.lang.Exception -> La5
            java.lang.String r6 = " failed!"
            r5.append(r6)     // Catch: java.lang.Exception -> La5
            r5.append(r10)     // Catch: java.lang.Exception -> La5
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> La5
            com.video.androidsdk.log.LogEx.w(r4, r5)     // Catch: java.lang.Exception -> La5
            if (r12 == 0) goto L48
            int r4 = com.video.androidsdk.common.ErrCode.getErrCode(r3, r2)     // Catch: java.lang.Exception -> La5
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch: java.lang.Exception -> La5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La5
            r5.<init>()     // Catch: java.lang.Exception -> La5
            r5.append(r11)     // Catch: java.lang.Exception -> La5
            r5.append(r0)     // Catch: java.lang.Exception -> La5
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> La5
            r12.a(r4, r5, r1)     // Catch: java.lang.Exception -> La5
        L48:
            return
        L49:
            java.lang.String r5 = "ReturnCode"
            java.lang.Object r5 = r4.get(r5)     // Catch: java.lang.Exception -> La5
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Exception -> La5
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Exception -> La5
            java.lang.String r7 = "returncode"
            if (r6 == 0) goto L5f
            java.lang.Object r5 = r4.get(r7)     // Catch: java.lang.Exception -> La5
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Exception -> La5
        L5f:
            java.lang.String r6 = "ErrorMsg"
            java.lang.Object r6 = r4.get(r6)     // Catch: java.lang.Exception -> La5
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Exception -> La5
            r8 = 1080(0x438, float:1.513E-42)
            if (r11 == r8) goto L91
            r8 = 1057(0x421, float:1.481E-42)
            if (r11 != r8) goto L70
            goto L91
        L70:
            r7 = 1261(0x4ed, float:1.767E-42)
            if (r11 == r7) goto L80
            r7 = 1263(0x4ef, float:1.77E-42)
            if (r11 == r7) goto L80
            r7 = 1214(0x4be, float:1.701E-42)
            if (r11 == r7) goto L80
            r7 = 1215(0x4bf, float:1.703E-42)
            if (r11 != r7) goto L9f
        L80:
            java.lang.String r5 = "result"
            java.lang.Object r5 = r4.get(r5)     // Catch: java.lang.Exception -> La5
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Exception -> La5
            java.lang.String r6 = "description"
            java.lang.Object r6 = r4.get(r6)     // Catch: java.lang.Exception -> La5
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Exception -> La5
            goto L9f
        L91:
            java.lang.Object r5 = r4.get(r7)     // Catch: java.lang.Exception -> La5
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Exception -> La5
            java.lang.String r6 = "errormsg"
            java.lang.Object r6 = r4.get(r6)     // Catch: java.lang.Exception -> La5
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Exception -> La5
        L9f:
            if (r12 == 0) goto Ldc
            r12.a(r5, r6, r4)     // Catch: java.lang.Exception -> La5
            goto Ldc
        La5:
            r4 = move-exception
            r4.printStackTrace()
            java.lang.String r4 = com.video.androidsdk.login.impl.b.f3181a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r11)
            r5.append(r0)
            r5.append(r10)
            java.lang.String r10 = r5.toString()
            com.video.androidsdk.log.LogEx.d(r4, r10)
            if (r12 == 0) goto Ldc
            int r10 = com.video.androidsdk.common.ErrCode.getErrCode(r3, r2)
            java.lang.String r10 = java.lang.String.valueOf(r10)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r11)
            r2.append(r0)
            java.lang.String r11 = r2.toString()
            r12.a(r10, r11, r1)
        Ldc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.video.androidsdk.login.impl.b.a(java.lang.String, int, com.video.androidsdk.login.impl.b$a):void");
    }

    public void a(c cVar, String str) {
        this.g = new d(this, str, cVar);
    }

    public void a(String str, c cVar) {
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        String replace = RequestUrlContants.LOGIN_BEAT_HEART.replace("http://{ipadd:port}", str);
        LogEx.d(f3181a, "sendHeartBeatRequest,  " + replace);
        HashMap<String, String> hashMap = this.k;
        if (hashMap != null && TextUtils.equals(hashMap.get(IIPTVLogin.STR_PLAY_THIRDCDNFLAG), "1")) {
            sDKNetHTTPRequest.setParam("playingigmp", "1");
            sDKNetHTTPRequest.setParam("endtime", g());
            sDKNetHTTPRequest.setParam("time", f());
        }
        sDKNetHTTPRequest.startRequest(replace, "POST", new e(this, cVar, str));
    }

    public void a() {
        this.f3184d = 0;
        TimerMgr timerMgr = TimerMgr.getInstance();
        int i = this.f;
        this.e = timerMgr.start(i * 1000, i * 1000, this.g);
        LogEx.i(f3181a, "startHeartbeat! mHeartbeatID =" + this.e);
    }

    public void a(int i) {
        if (i < 0) {
            i = 0;
        }
        this.f = i;
    }

    public void a(String str, String str2, InterfaceC0095b interfaceC0095b) {
        HashMap hashMap = new HashMap();
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        Bundle bundle = this.i;
        String str3 = RequestUrlContants.LOGIN_PROPERTY_DOWNLOAD;
        if (bundle != null && !TextUtils.isEmpty(bundle.getString("logindatatype"))) {
            str3 = RequestUrlContants.LOGIN_PROPERTY_DOWNLOAD.replace("portal.properties", "sdk_getconfig.jsp");
            String upperCase = Security.encrypt(this.i.getString("logindatatype"), "SHA-256").toUpperCase();
            String upperCase2 = Security.encrypt(this.i.getString("logindataversion"), "SHA-256").toUpperCase();
            hashMap.put("code", str2);
            hashMap.put("logindatatype", upperCase);
            hashMap.put("logindataversion", upperCase2);
            sDKNetHTTPRequest.setHeader("logindatatype", (String) hashMap.get("logindatatype"));
            sDKNetHTTPRequest.setHeader("logindataversion", (String) hashMap.get("logindataversion"));
        }
        if (str3.contains("http://{ipadd:port}")) {
            str3 = str3.replace("http://{ipadd:port}", str);
        }
        if (str3.contains("{frame}")) {
            str3 = str3.replace("{frame}", str2);
        }
        if (!StringUtil.isEmptyString(this.h)) {
            sDKNetHTTPRequest.setHeader(IIPTVLogin.LOGIN_PARAM_CHARSET, this.h);
        }
        sDKNetHTTPRequest.startRequest(str3, "POST", new g(this, interfaceC0095b));
    }

    public String a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        byte[] bArr;
        StringBuilder sb = new StringBuilder();
        sb.append(new SecureRandom().nextInt(100000000));
        sb.append(RContact.FAVOUR_CONTACT_SHOW_HEAD_CHAR);
        sb.append(str);
        sb.append(RContact.FAVOUR_CONTACT_SHOW_HEAD_CHAR);
        sb.append(str2);
        sb.append(RContact.FAVOUR_CONTACT_SHOW_HEAD_CHAR);
        sb.append(str3);
        sb.append(RContact.FAVOUR_CONTACT_SHOW_HEAD_CHAR);
        sb.append(str4);
        sb.append(RContact.FAVOUR_CONTACT_SHOW_HEAD_CHAR);
        sb.append(str5);
        sb.append(RContact.FAVOUR_CONTACT_SHOW_HEAD_CHAR);
        sb.append(RContact.FAVOUR_CONTACT_SHOW_HEAD_CHAR);
        sb.append(str3);
        sb.append(RContact.FAVOUR_CONTACT_SHOW_HEAD_CHAR);
        sb.append(str7);
        sb.append("<#~" + str6);
        sb.append("$CTC");
        LogEx.d(f3181a, "EncodeKey: " + ((Object) sb));
        StringBuilder sb2 = new StringBuilder(str6);
        while (sb2.length() < 24) {
            sb2.append("0");
        }
        try {
            bArr = DES.encrypt(sb2.toString().getBytes("ASCII"), sb.toString().getBytes(), DES.ALGORITHM_TRIPLE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        return Base16.encode(bArr);
    }

    public void a(String str) {
        this.h = str;
    }

    public void a(HashMap<String, String> hashMap) {
        if (hashMap != null) {
            String str = hashMap.get(IIPTVLogin.STR_PLAY_THIRDCDNFLAG);
            LogEx.d(f3181a, "thirdcdnflag : " + str);
            if (!TextUtils.isEmpty(str)) {
                this.k.put(IIPTVLogin.STR_PLAY_THIRDCDNFLAG, hashMap.get(IIPTVLogin.STR_PLAY_THIRDCDNFLAG));
            }
            String str2 = hashMap.get("starttime");
            LogEx.d(f3181a, "starttime : " + str2);
            if (!TextUtils.isEmpty(str2)) {
                this.k.put("starttime", str2);
            }
            String str3 = hashMap.get("endtime");
            LogEx.d(f3181a, "endtime : " + str3);
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            this.k.put("endtime", str3);
        }
    }
}
