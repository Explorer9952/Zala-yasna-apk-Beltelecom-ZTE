package com.video.androidsdk.collectAgent;

import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.impl.IIPTVLogin;
import org.json.JSONObject;

/* compiled from: CommonHTTPRequest.java */
/* loaded from: classes.dex */
public class u {

    /* compiled from: CommonHTTPRequest.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(int i, String str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void a(String str, JSONObject jSONObject, String str2, int i, a aVar) {
        char c2;
        switch (str.hashCode()) {
            case -400738962:
                if (str.equals("E_ERROR")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -394374449:
                if (str.equals("E_LOGIN")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -393751734:
                if (str.equals("E_MEDIA")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 285225637:
                if (str.equals("E_NOTIFICATION")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case 401814309:
                if (str.equals("E_COMMON")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case 407540907:
                if (str.equals("E_CUSTOM")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 490226641:
                if (str.equals("E_FREEZE")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 2065593929:
                if (str.equals("E_PAGE")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                LogEx.d("CommonHTTPRequest", "start login report");
                break;
            case 1:
                LogEx.d("CommonHTTPRequest", "start custom report");
                break;
            case 2:
                LogEx.d("CommonHTTPRequest", "start freeze report");
                break;
            case 3:
                LogEx.d("CommonHTTPRequest", "start error report");
                break;
            case 4:
                LogEx.d("CommonHTTPRequest", "start media report");
                break;
            case 5:
                LogEx.d("CommonHTTPRequest", "start page report");
                break;
            case 6:
                LogEx.d("CommonHTTPRequest", "start common event report");
                break;
            case 7:
                LogEx.d("CommonHTTPRequest", "start notification report");
                break;
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setTimeOut(i, i);
        sDKNetHTTPRequest.setHeader(IIPTVLogin.LOGIN_PARAM_CHARSET, "utf-8");
        sDKNetHTTPRequest.setHeader("Content-Encoding", "gzip");
        sDKNetHTTPRequest.setHeader("Content-Type", "application/json");
        sDKNetHTTPRequest.setBody(jSONObject.toString());
        LogEx.d("CommonHTTPRequest", "request body:" + jSONObject.toString());
        sDKNetHTTPRequest.startRequest(str2 + "/anls/streamdata", "POST", new v(this, aVar));
    }
}
