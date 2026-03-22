package com.video.androidsdk.service.profile;

import com.video.androidsdk.common.AES;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.ErrMessage;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.license.a;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.comm.HttpUrlConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SDKProfileMgr {

    /* renamed from: a, reason: collision with root package name */
    private SDKNetHTTPRequest f3707a;

    /* loaded from: classes.dex */
    public interface OnAddProfileReturnListener {
        void onAddProfileReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnCheckProfilePwdReturnListener {
        void onCheckProfilePwdReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnDelProfileReturnListener {
        void onDelProfileReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnGetProfileInfoReturnListener {
        void onGetProfileInfoReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnGetProfileInitDataReturnListener {
        void onGetProfileInitDataReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnGetProfileListReturnListener {
        void onGetProfileListReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnModifyProfileReturnListener {
        void onModifyProfileReturn(String str, String str2);
    }

    private String a(String str) {
        try {
            return AES.aesEncryptByBase64(str.getBytes(), a.a("profilekey").getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void addProfile(AddProfileReq addProfileReq, final OnAddProfileReturnListener onAddProfileReturnListener) {
        if (onAddProfileReturnListener == null) {
            LogEx.w("SDKProfileMgr", "listener is null");
            return;
        }
        if (addProfileReq == null) {
            LogEx.w("SDKProfileMgr", "req is null");
            onAddProfileReturnListener.onAddProfileReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PROFILE_MODELCODE, 3, 2)), ErrMessage.PARAM_IS_NULL, null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.ADD_PROFILE);
        HashMap<String, String> hashMap = addProfileReq.toHashMap();
        sb.append("?");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if ("loginpwd".equals(key)) {
                value = a(String.valueOf(value));
            }
            sb.append((Object) key);
            sb.append("=");
            sb.append((Object) value);
            sb.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3707a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.profile.SDKProfileMgr.3
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onAddProfileReturnListener.onAddProfileReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    onAddProfileReturnListener.onAddProfileReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PROFILE_MODELCODE, 3, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                onAddProfileReturnListener.onAddProfileReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PROFILE_MODELCODE, 3, i % 1000)), str, null);
            }
        });
    }

    public void cancelRequest() {
        SDKNetHTTPRequest sDKNetHTTPRequest = this.f3707a;
        if (sDKNetHTTPRequest != null) {
            sDKNetHTTPRequest.cancelRequest();
        }
    }

    public void checkProfilePwd(CheckProfilePwdReq checkProfilePwdReq, final OnCheckProfilePwdReturnListener onCheckProfilePwdReturnListener) {
        if (onCheckProfilePwdReturnListener == null) {
            LogEx.w("SDKProfileMgr", "listener is null");
            return;
        }
        if (checkProfilePwdReq == null) {
            LogEx.w("SDKProfileMgr", "req is null");
            onCheckProfilePwdReturnListener.onCheckProfilePwdReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PROFILE_MODELCODE, 7, 2)), ErrMessage.PARAM_IS_NULL);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.CHECK_PWD_PROFILE);
        HashMap<String, String> hashMap = checkProfilePwdReq.toHashMap();
        sb.append("?");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if ("pwd".equals(key)) {
                value = a(value);
            }
            sb.append(key);
            sb.append("=");
            sb.append(value);
            sb.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3707a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.profile.SDKProfileMgr.7
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onCheckProfilePwdReturnListener.onCheckProfilePwdReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    onCheckProfilePwdReturnListener.onCheckProfilePwdReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PROFILE_MODELCODE, 7, 202)), "JSONException occur");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                onCheckProfilePwdReturnListener.onCheckProfilePwdReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PROFILE_MODELCODE, 6, i % 1000)), str);
            }
        });
    }

    public void delProfile(DelProfileReq delProfileReq, final OnDelProfileReturnListener onDelProfileReturnListener) {
        if (onDelProfileReturnListener == null) {
            LogEx.w("SDKProfileMgr", "listener is null");
            return;
        }
        if (delProfileReq == null) {
            LogEx.w("SDKProfileMgr", "req is null");
            onDelProfileReturnListener.onDelProfileReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PROFILE_MODELCODE, 4, 2)), ErrMessage.PARAM_IS_NULL);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.DEL_PROFILE);
        HashMap<String, String> hashMap = delProfileReq.toHashMap();
        sb.append("?");
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
        this.f3707a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.profile.SDKProfileMgr.4
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onDelProfileReturnListener.onDelProfileReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    onDelProfileReturnListener.onDelProfileReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PROFILE_MODELCODE, 4, 202)), "JSONException occur");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                onDelProfileReturnListener.onDelProfileReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PROFILE_MODELCODE, 4, i % 1000)), str);
            }
        });
    }

    public void getProfileInfo(GetProfileInfoReq getProfileInfoReq, final OnGetProfileInfoReturnListener onGetProfileInfoReturnListener) {
        if (onGetProfileInfoReturnListener == null) {
            LogEx.w("SDKProfileMgr", "listener is null");
            return;
        }
        if (getProfileInfoReq == null) {
            LogEx.w("SDKProfileMgr", "req is null");
            onGetProfileInfoReturnListener.onGetProfileInfoReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PROFILE_MODELCODE, 6, 2)), ErrMessage.PARAM_IS_NULL, null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.QUERY_PROFILE);
        HashMap<String, String> hashMap = getProfileInfoReq.toHashMap();
        sb.append("?");
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
        this.f3707a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.profile.SDKProfileMgr.6
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onGetProfileInfoReturnListener.onGetProfileInfoReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    onGetProfileInfoReturnListener.onGetProfileInfoReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PROFILE_MODELCODE, 6, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                onGetProfileInfoReturnListener.onGetProfileInfoReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PROFILE_MODELCODE, 6, i % 1000)), str, null);
            }
        });
    }

    public void getProfileInitData(final OnGetProfileInitDataReturnListener onGetProfileInitDataReturnListener) {
        if (onGetProfileInitDataReturnListener == null) {
            LogEx.w("SDKProfileMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_PROFILE_INIT_DATA);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3707a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.profile.SDKProfileMgr.1
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onGetProfileInitDataReturnListener.onGetProfileInitDataReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    onGetProfileInitDataReturnListener.onGetProfileInitDataReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PROFILE_MODELCODE, 1, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                onGetProfileInitDataReturnListener.onGetProfileInitDataReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PROFILE_MODELCODE, 1, i % 1000)), str, null);
            }
        });
    }

    public void getProfileList(final OnGetProfileListReturnListener onGetProfileListReturnListener) {
        if (onGetProfileListReturnListener == null) {
            LogEx.w("SDKProfileMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_USER_PROFILE_LIST);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3707a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.profile.SDKProfileMgr.2
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onGetProfileListReturnListener.onGetProfileListReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    onGetProfileListReturnListener.onGetProfileListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PROFILE_MODELCODE, 2, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                onGetProfileListReturnListener.onGetProfileListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PROFILE_MODELCODE, 2, i % 1000)), str, null);
            }
        });
    }

    public void modifyProfile(ModifyProfileReq modifyProfileReq, final OnModifyProfileReturnListener onModifyProfileReturnListener) {
        if (onModifyProfileReturnListener == null) {
            LogEx.w("SDKProfileMgr", "listener is null");
            return;
        }
        if (modifyProfileReq == null) {
            LogEx.w("SDKProfileMgr", "req is null");
            onModifyProfileReturnListener.onModifyProfileReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PROFILE_MODELCODE, 5, 2)), ErrMessage.PARAM_IS_NULL);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.MODIFY_PROFILE);
        HashMap<String, String> hashMap = modifyProfileReq.toHashMap();
        sb.append("?");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if ("loginpwd".equals(key)) {
                value = a(String.valueOf(value));
            }
            sb.append((Object) key);
            sb.append("=");
            sb.append((Object) value);
            sb.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3707a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.profile.SDKProfileMgr.5
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onModifyProfileReturnListener.onModifyProfileReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    onModifyProfileReturnListener.onModifyProfileReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PROFILE_MODELCODE, 5, 202)), "JSONException occur");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                onModifyProfileReturnListener.onModifyProfileReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_PROFILE_MODELCODE, 5, i % 1000)), str);
            }
        });
    }
}
