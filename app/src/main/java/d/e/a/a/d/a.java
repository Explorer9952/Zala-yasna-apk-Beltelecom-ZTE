package d.e.a.a.d;

import com.video.androidsdk.SDKMgr;
import com.video.androidsdk.common.GlobalConst;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.util.AndroidUtils;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.log.ErrorLogReq;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.log.SDKLogMgr;
import com.video.androidsdk.login.SDKLoginMgr;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: IPTVHttpRequest.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private String f8041b = "";

    /* renamed from: a, reason: collision with root package name */
    private SDKNetHTTPRequest f8040a = new SDKNetHTTPRequest();

    /* compiled from: IPTVHttpRequest.java */
    /* renamed from: d.e.a.a.d.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0412a implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SDKNetHTTPRequest.IHTTPRequestReturnListener f8042a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f8043b;

        C0412a(SDKNetHTTPRequest.IHTTPRequestReturnListener iHTTPRequestReturnListener, String str) {
            this.f8042a = iHTTPRequestReturnListener;
            this.f8043b = str;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            String str2;
            SDKNetHTTPRequest.IHTTPRequestReturnListener iHTTPRequestReturnListener = this.f8042a;
            if (iHTTPRequestReturnListener != null) {
                iHTTPRequestReturnListener.onDataReturn(str);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String str3 = "";
                if (jSONObject.has("ReturnCode")) {
                    str2 = (String) jSONObject.get("ReturnCode");
                } else if (jSONObject.has("returncode")) {
                    str2 = (String) jSONObject.get("returncode");
                } else if (jSONObject.has("status")) {
                    str2 = (String) jSONObject.get("status");
                } else {
                    str2 = jSONObject.has("result") ? (String) jSONObject.get("result") : "";
                }
                if (jSONObject.has("ErrorMsg")) {
                    str3 = (String) jSONObject.get("ErrorMsg");
                } else if (jSONObject.has("errormsg")) {
                    str3 = (String) jSONObject.get("errormsg");
                } else if (jSONObject.has("message")) {
                    str3 = (String) jSONObject.get("message");
                } else if (jSONObject.has("description") && !(jSONObject.get("description") instanceof JSONArray)) {
                    str3 = (String) jSONObject.get("description");
                }
                LogEx.d("IPTVHttpRequest", "error log one: errCode: " + str2 + " ,errmsg: " + str3);
                if (StringUtil.isEmptyString(str2) || "0".equals(str2) || "ok".equalsIgnoreCase(str2)) {
                    return;
                }
                if (StringUtil.isEmptyString(this.f8043b) || !this.f8043b.contains("crashupload")) {
                    a.this.a(str2, str3, this.f8043b);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            SDKNetHTTPRequest.IHTTPRequestReturnListener iHTTPRequestReturnListener = this.f8042a;
            if (iHTTPRequestReturnListener != null) {
                iHTTPRequestReturnListener.onFailReturn(i, str);
            }
            LogEx.d("IPTVHttpRequest", "error log: errCode: " + i + " ,errmsg: " + str);
            if (StringUtil.isEmptyString(this.f8043b) || !this.f8043b.contains("crashupload")) {
                a.this.a(String.valueOf(i), str, this.f8043b);
            }
        }
    }

    public void b(String str) {
        this.f8040a.setCharset(str);
    }

    public void a(String str, String str2, SDKNetHTTPRequest.IHTTPRequestReturnListener iHTTPRequestReturnListener) {
        this.f8040a.startRequest(str, str2, new C0412a(iHTTPRequestReturnListener, str));
    }

    public void a(String str, String str2) {
        this.f8040a.setHeader(str, str2);
    }

    public void a(String str) {
        this.f8040a.setBody(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        String propertiesInfo = SDKLoginMgr.getInstance().getPropertiesInfo("Log_Server_Address");
        if (StringUtil.isEmptyString(propertiesInfo)) {
            propertiesInfo = ConfigMgr.readPropertie("Log_Server_Address");
        }
        if (StringUtil.isEmptyString(propertiesInfo)) {
            LogEx.d("IPTVHttpRequest", "upload log server ip is null");
            return;
        }
        String[] split = propertiesInfo.split(":");
        SDKLogMgr createInstance = SDKLogMgr.createInstance();
        if (createInstance == null) {
            LogEx.e("IPTVHttpRequest", "license fail");
            return;
        }
        if (split != null && split.length > 1) {
            createInstance.setSeverDomain("http://" + split[0] + ":" + split[1]);
        }
        String format = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis()));
        ErrorLogReq errorLogReq = new ErrorLogReq();
        HashMap<String, String> initPackageInfo = AndroidUtils.initPackageInfo(SDKMgr.getApplicationContext());
        if (initPackageInfo == null) {
            LogEx.d("IPTVHttpRequest", "reqMap is null");
            return;
        }
        errorLogReq.setAppName(initPackageInfo.get("appname"));
        errorLogReq.setAppVersion(initPackageInfo.get("appversion"));
        errorLogReq.setCreateTime(format);
        errorLogReq.setErrorCode(str);
        errorLogReq.setErrorDesc(this.f8041b + " , reurncode :" + str + " , errormsg : " + str2 + " , url :" + str3);
        errorLogReq.setTerminalType(GlobalConst.TERMINAL_TYPE);
        errorLogReq.setUserName(SDKLoginMgr.getInstance().getUserInfo("UserID"));
        createInstance.uploadErrorLog(errorLogReq, null);
    }
}
