package com.video.androidsdk.log;

import com.google.common.logging.nano.Vr;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.login.impl.IIPTVLogin;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class UpLoadCrashExceptionLogRequest {
    private static final String LOG_TAG = "UpLoadCrashExceptionLogRequest";
    private String appname;
    private String appversion;
    private CallBack callBack;
    private String createtime;
    private String deviceid;
    private String errorcode;
    private String errordesc;
    private String filename;
    private String filetype;
    private String fileurl;
    private String manufacturer;
    private String model;
    private String osversion;
    private String serviceUrl;
    private String terminaltype;
    private String username;

    /* loaded from: classes.dex */
    public interface CallBack {
        void uploadCrashExceptionLogCallback(String str, String str2);
    }

    public UpLoadCrashExceptionLogRequest(String str) {
        this.serviceUrl = "";
        this.serviceUrl = str;
    }

    private String getJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("terminaltype", this.terminaltype);
            jSONObject.put("appname", this.appname);
            jSONObject.put("manufacturer", this.manufacturer);
            jSONObject.put("model", this.model);
            jSONObject.put("osversion", this.osversion);
            jSONObject.put("appversion", this.appversion);
            jSONObject.put("username", this.username);
            jSONObject.put("errorcode", this.errorcode);
            jSONObject.put("errordesc", this.errordesc);
            jSONObject.put("createtime", this.createtime);
            jSONObject.put("fileurl", this.fileurl);
            jSONObject.put("filename", this.filename);
            jSONObject.put("filetype", this.filetype);
            jSONObject.put("deviceid", this.deviceid);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String getAppVersion() {
        return this.appversion;
    }

    public String getAppname() {
        return this.appname;
    }

    public String getCreatetime() {
        return this.createtime;
    }

    public String getDeviceid() {
        return this.deviceid;
    }

    public String getErrorcode() {
        return this.errorcode;
    }

    public String getErrordesc() {
        return this.errordesc;
    }

    public String getFileURL() {
        return this.fileurl;
    }

    public String getFilename() {
        return this.filename;
    }

    public String getFiletype() {
        return this.filetype;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getModel() {
        return this.model;
    }

    public String getOsversion() {
        return this.osversion;
    }

    public String getTerminaltype() {
        return this.terminaltype;
    }

    public String getUsername() {
        return this.username;
    }

    public void setAppVersion(String str) {
        this.appversion = str;
    }

    public void setAppname(String str) {
        this.appname = str;
    }

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    public void setCreatetime(String str) {
        this.createtime = str;
    }

    public void setDeviceid(String str) {
        this.deviceid = str;
    }

    public void setErrorcode(String str) {
        this.errorcode = str;
    }

    public void setErrordesc(String str) {
        this.errordesc = str;
    }

    public void setFileURL(String str) {
        this.fileurl = str;
    }

    public void setFilename(String str) {
        this.filename = str;
    }

    public void setFiletype(String str) {
        this.filetype = str;
    }

    public void setManufacturer(String str) {
        this.manufacturer = str;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setOsversion(String str) {
        this.osversion = str;
    }

    public void setTerminaltype(String str) {
        this.terminaltype = str;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public void startQuery() {
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setTimeOut(Vr.VREvent.EventType.START_VR_LAUNCHER_COLD, 5000);
        sDKNetHTTPRequest.setHeader(IIPTVLogin.LOGIN_PARAM_CHARSET, "UTF-8");
        sDKNetHTTPRequest.setBody(getJsonString());
        sDKNetHTTPRequest.startRequest(this.serviceUrl, "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.log.UpLoadCrashExceptionLogRequest.1
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                String valueOf;
                if (StringUtil.isEmptyString(str)) {
                    UpLoadCrashExceptionLogRequest.this.callBack.uploadCrashExceptionLogCallback(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGCAT_MODELCODE, 5)), "");
                    LogEx.w(UpLoadCrashExceptionLogRequest.LOG_TAG, "data response is null");
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    valueOf = jSONObject.has("returncode") ? (String) jSONObject.get("returncode") : "";
                } catch (Exception e) {
                    e.printStackTrace();
                    valueOf = String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_LOGCAT_MODELCODE, 5));
                }
                if (UpLoadCrashExceptionLogRequest.this.callBack != null) {
                    UpLoadCrashExceptionLogRequest.this.callBack.uploadCrashExceptionLogCallback(valueOf, "");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                if (UpLoadCrashExceptionLogRequest.this.callBack != null) {
                    UpLoadCrashExceptionLogRequest.this.callBack.uploadCrashExceptionLogCallback(String.valueOf(i), str);
                }
            }
        });
    }
}
