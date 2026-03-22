package com.video.androidsdk.service.recommend;

import android.text.TextUtils;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.comm.ParamConst;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SDKRecommendMgr {

    /* renamed from: a, reason: collision with root package name */
    private String f3722a;

    /* renamed from: b, reason: collision with root package name */
    private SDKNetHTTPRequest f3723b;

    /* loaded from: classes.dex */
    public interface OnCollaborateRankListReturnListener {
        void onCollaborateRankListReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnHotRankListReturnListener {
        void onHotRankListReturn(String str, String str2, String str3);
    }

    public void cancelRequest() {
        SDKNetHTTPRequest sDKNetHTTPRequest = this.f3723b;
        if (sDKNetHTTPRequest != null) {
            sDKNetHTTPRequest.cancelRequest();
        }
    }

    public void getCollaborateRankList(HashMap<String, String> hashMap, final OnCollaborateRankListReturnListener onCollaborateRankListReturnListener) {
        if (onCollaborateRankListReturnListener == null) {
            LogEx.w("SDKRecommendMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            onCollaborateRankListReturnListener.onCollaborateRankListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_RECOMMEND_MODELCODE, 1, 2)), "params is null", null);
            return;
        }
        if (TextUtils.isEmpty(this.f3722a)) {
            onCollaborateRankListReturnListener.onCollaborateRankListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_RECOMMEND_MODELCODE, 1, 2)), "ip:port is null", null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3722a);
        sb.append("/udas/submit");
        sb.append("?type=collaboraterank");
        sb.append("&teamid=" + SDKLoginMgr.getInstance().getUserInfo("TeamID"));
        if (!hashMap.containsKey("usertype")) {
            sb.append("&usertype=0");
        }
        if (!hashMap.containsKey("usercode")) {
            sb.append("&usercode=" + SDKLoginMgr.getInstance().getUserID());
        }
        sb.append("&");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append((Object) key);
            sb.append("=");
            sb.append((Object) value);
            sb.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3723b = sDKNetHTTPRequest;
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.recommend.SDKRecommendMgr.1
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onCollaborateRankListReturnListener.onCollaborateRankListReturn(jSONObject.optString("error"), jSONObject.optString("errorMsg"), SDKRecommendMgr.this.a(str));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKRecommendMgr", "JSONException occur");
                    onCollaborateRankListReturnListener.onCollaborateRankListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_RECOMMEND_MODELCODE, 1, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKRecommendMgr", "SDKNetHTTPRequest onFailReturn");
                onCollaborateRankListReturnListener.onCollaborateRankListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_RECOMMEND_MODELCODE, 1, i % 1000)), str, null);
            }
        });
    }

    public void getHotRankList(HashMap<String, String> hashMap, final OnHotRankListReturnListener onHotRankListReturnListener) {
        if (onHotRankListReturnListener == null) {
            LogEx.w("SDKRecommendMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            onHotRankListReturnListener.onHotRankListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_RECOMMEND_MODELCODE, 2, 2)), "params is null", null);
            return;
        }
        if (TextUtils.isEmpty(this.f3722a)) {
            onHotRankListReturnListener.onHotRankListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_RECOMMEND_MODELCODE, 2, 2)), "ip:port is null", null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3722a);
        sb.append("/udas/submit");
        sb.append("?type=hotrank");
        sb.append("&teamid=" + SDKLoginMgr.getInstance().getUserInfo("TeamID"));
        sb.append("&");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append((Object) key);
            sb.append("=");
            sb.append((Object) value);
            sb.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3723b = sDKNetHTTPRequest;
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.recommend.SDKRecommendMgr.2
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onHotRankListReturnListener.onHotRankListReturn(jSONObject.optString("error"), jSONObject.optString("errorMsg"), SDKRecommendMgr.this.a(str));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKRecommendMgr", "JSONException occur");
                    onHotRankListReturnListener.onHotRankListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_RECOMMEND_MODELCODE, 2, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKRecommendMgr", "SDKNetHTTPRequest onFailReturn");
                onHotRankListReturnListener.onHotRankListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_RECOMMEND_MODELCODE, 2, i % 1000)), str, null);
            }
        });
    }

    public void setServerDomain(String str) {
        this.f3722a = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        if (str.contains("errorMsg")) {
            str = str.replace("errorMsg", "errormsg");
        }
        if (str.contains("error")) {
            str = str.replace("error", "returncode");
        }
        if (str.contains("rec_num")) {
            str = str.replace("rec_num", "totalcount");
        }
        return str.contains(ParamConst.VOD_DETAIL_RECOMMEND_RES_PROGRAMINFO) ? str.replace(ParamConst.VOD_DETAIL_RECOMMEND_RES_PROGRAMINFO, "programinfo") : str;
    }
}
