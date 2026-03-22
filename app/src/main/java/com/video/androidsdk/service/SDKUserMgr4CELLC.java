package com.video.androidsdk.service;

import android.text.TextUtils;
import com.video.androidsdk.SDKMgr;
import com.video.androidsdk.common.AES;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.ErrMessage;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.license.a;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.login.impl.IIPTVLogin;
import com.video.androidsdk.service.comm.HttpUrlConstants;
import com.video.androidsdk.service.comm.ParamConst;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SDKUserMgr4CELLC {

    /* loaded from: classes.dex */
    public interface OnBindDeviceListReturnListener {
        void onBindDeviceListReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnBindTerminalDeviceReturnListener {
        void onBindTerminalDeviceReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnGetPasswordByEmailReturnListener {
        void onGetPasswordByEmailReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnGetUserCodeReturnListener {
        void onGetUserCodeReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnGetUserProfileReturnListener {
        void onGetUserProfileReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnMidnightLoginReturnListener {
        void onMidnightLoginReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnUnbindTerminalDeviceReturnListener {
        void onUnbindTerminalDeviceReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnUpdateUserInfoReturnListener {
        void onUpdateUserInfoReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnUserDetailReturnListener {
        void onUserDetailReturn(String str, String str2, String str3);
    }

    public void bindTerminalDevice(HashMap<String, String> hashMap, final OnBindTerminalDeviceReturnListener onBindTerminalDeviceReturnListener) {
        if (onBindTerminalDeviceReturnListener == null) {
            LogEx.w("SDKUserMgr4CELLC", "listener is null");
            return;
        }
        if (hashMap == null) {
            LogEx.w("SDKUserMgr4CELLC", ErrMessage.PARAM_IS_NULL);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.CELLC_GET_USERPLAYBIND);
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
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.SDKUserMgr4CELLC.8
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onBindTerminalDeviceReturnListener.onBindTerminalDeviceReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKUserMgr4CELLC", "JSONException occur");
                    onBindTerminalDeviceReturnListener.onBindTerminalDeviceReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 202)), "JSONException occur");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKUserMgr4CELLC", "SDKNetHTTPRequest onFailReturn");
                onBindTerminalDeviceReturnListener.onBindTerminalDeviceReturn(String.valueOf(i), str);
            }
        });
    }

    public void getBindDeviceList(final OnBindDeviceListReturnListener onBindDeviceListReturnListener) {
        if (onBindDeviceListReturnListener == null) {
            LogEx.w("SDKUserMgr4CELLC", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.CELLC_GET_DEV_LIST);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.SDKUserMgr4CELLC.3
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onBindDeviceListReturnListener.onBindDeviceListReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKUserMgr4CELLC", "JSONException occur");
                    onBindDeviceListReturnListener.onBindDeviceListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKUserMgr4CELLC", "SDKNetHTTPRequest onFailReturn");
                onBindDeviceListReturnListener.onBindDeviceListReturn(String.valueOf(i), str, null);
            }
        });
    }

    public void getPasswordByEmail(HashMap<String, String> hashMap, final OnGetPasswordByEmailReturnListener onGetPasswordByEmailReturnListener) {
        if (onGetPasswordByEmailReturnListener == null) {
            LogEx.w("SDKUserMgr4CELLC", "listener is null");
            return;
        }
        if (hashMap == null) {
            LogEx.w("SDKUserMgr4CELLC", ErrMessage.PARAM_IS_NULL);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.CELLC_FIND_PWD);
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
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.SDKUserMgr4CELLC.5
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onGetPasswordByEmailReturnListener.onGetPasswordByEmailReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKUserMgr4CELLC", "JSONException occur");
                    onGetPasswordByEmailReturnListener.onGetPasswordByEmailReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 202)), "JSONException occur");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKUserMgr4CELLC", "SDKNetHTTPRequest onFailReturn");
                onGetPasswordByEmailReturnListener.onGetPasswordByEmailReturn(String.valueOf(i), str);
            }
        });
    }

    public void getUserCode(GetUserCodeReq getUserCodeReq, final OnGetUserCodeReturnListener onGetUserCodeReturnListener) {
        if (onGetUserCodeReturnListener == null) {
            LogEx.w("SDKUserMgr4CELLC", "listener is null");
            return;
        }
        if (getUserCodeReq == null) {
            LogEx.w("SDKUserMgr4CELLC", ErrMessage.PARAM_IS_NULL);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.CELLC_GET_USERCODE);
        HashMap<String, String> hashMap = getUserCodeReq.toHashMap();
        sb.append("?");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (SDKMgr.f3020c) {
                try {
                    if (IIPTVLogin.LOGIN_PARAM_ACCOUNTCODE.equals(key)) {
                        value = AES.aesEncryptByBase64(String.valueOf(value).getBytes(), a.a("epgkey").getBytes());
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            sb.append((Object) key);
            sb.append("=");
            sb.append((Object) value);
            sb.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.SDKUserMgr4CELLC.9
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (SDKMgr.f3020c) {
                        String a2 = a.a("epgkey");
                        try {
                            String optString = jSONObject.optString(ParamConst.GET_REGISTER_REQ_MOBILENO);
                            if (!TextUtils.isEmpty(optString)) {
                                String aesDecryptByBase64 = AES.aesDecryptByBase64(optString, a2.getBytes());
                                jSONObject.remove(ParamConst.GET_REGISTER_REQ_MOBILENO);
                                jSONObject.put(ParamConst.GET_REGISTER_REQ_MOBILENO, aesDecryptByBase64);
                            }
                            String optString2 = jSONObject.optString("usercode");
                            if (!TextUtils.isEmpty(optString2)) {
                                String aesDecryptByBase642 = AES.aesDecryptByBase64(optString2, a2.getBytes());
                                jSONObject.remove("usercode");
                                jSONObject.put("usercode", aesDecryptByBase642);
                            }
                        } catch (UnsupportedEncodingException e2) {
                            e2.printStackTrace();
                            onGetUserCodeReturnListener.onGetUserCodeReturn("0", "", str);
                        }
                    }
                    onGetUserCodeReturnListener.onGetUserCodeReturn("0", "", jSONObject.toString());
                } catch (JSONException e3) {
                    e3.printStackTrace();
                    LogEx.w("SDKUserMgr4CELLC", "JSONException occur");
                    onGetUserCodeReturnListener.onGetUserCodeReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKUserMgr4CELLC", "SDKNetHTTPRequest onFailReturn");
                onGetUserCodeReturnListener.onGetUserCodeReturn(String.valueOf(i), str, null);
            }
        });
    }

    public void getUserDetail(final OnUserDetailReturnListener onUserDetailReturnListener) {
        if (onUserDetailReturnListener == null) {
            LogEx.w("SDKUserMgr4CELLC", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.CELLC_GET_USER_INFO);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.SDKUserMgr4CELLC.1
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString("returncode");
                    String optString2 = jSONObject.optString("errormsg");
                    if (SDKMgr.f3020c) {
                        String a2 = a.a("epgkey");
                        try {
                            String optString3 = jSONObject.optString(ParamConst.GET_REGISTER_REQ_MOBILENO);
                            if (!TextUtils.isEmpty(optString3)) {
                                String aesDecryptByBase64 = AES.aesDecryptByBase64(optString3, a2.getBytes());
                                jSONObject.remove(ParamConst.GET_REGISTER_REQ_MOBILENO);
                                jSONObject.put(ParamConst.GET_REGISTER_REQ_MOBILENO, aesDecryptByBase64);
                            }
                            String optString4 = jSONObject.optString("email");
                            if (!TextUtils.isEmpty(optString4)) {
                                String aesDecryptByBase642 = AES.aesDecryptByBase64(optString4, a2.getBytes());
                                jSONObject.remove("email");
                                jSONObject.put("email", aesDecryptByBase642);
                            }
                            String optString5 = jSONObject.optString("username");
                            if (!TextUtils.isEmpty(optString5)) {
                                String aesDecryptByBase643 = AES.aesDecryptByBase64(optString5, a2.getBytes());
                                jSONObject.remove("username");
                                jSONObject.put("username", aesDecryptByBase643);
                            }
                            String optString6 = jSONObject.optString("paymobileno");
                            if (!TextUtils.isEmpty(optString6)) {
                                String aesDecryptByBase644 = AES.aesDecryptByBase64(optString6, a2.getBytes());
                                jSONObject.remove("paymobileno");
                                jSONObject.put("paymobileno", aesDecryptByBase644);
                            }
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                            onUserDetailReturnListener.onUserDetailReturn(optString, optString2, str);
                        }
                    }
                    onUserDetailReturnListener.onUserDetailReturn(optString, optString2, jSONObject.toString());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    LogEx.w("SDKUserMgr4CELLC", "JSONException occur");
                    onUserDetailReturnListener.onUserDetailReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKUserMgr4CELLC", "SDKNetHTTPRequest onFailReturn");
                onUserDetailReturnListener.onUserDetailReturn(String.valueOf(i), str, null);
            }
        });
    }

    public void getUserProfile(final OnGetUserProfileReturnListener onGetUserProfileReturnListener) {
        if (onGetUserProfileReturnListener == null) {
            LogEx.w("SDKUserMgr4CELLC", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append("sdk_getuserprofile.jsp");
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.SDKUserMgr4CELLC.7
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onGetUserProfileReturnListener.onGetUserProfileReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKUserMgr4CELLC", "JSONException occur");
                    onGetUserProfileReturnListener.onGetUserProfileReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKUserMgr4CELLC", "SDKNetHTTPRequest onFailReturn");
                onGetUserProfileReturnListener.onGetUserProfileReturn(String.valueOf(i), str, null);
            }
        });
    }

    public void midnightLogin(HashMap<String, String> hashMap, final OnMidnightLoginReturnListener onMidnightLoginReturnListener) {
        if (onMidnightLoginReturnListener == null) {
            LogEx.w("SDKUserMgr4CELLC", "listener is null");
            return;
        }
        if (hashMap == null) {
            LogEx.w("SDKUserMgr4CELLC", ErrMessage.PARAM_IS_NULL);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.CELLC_MIDNIGHT_LOGIN);
        sb.append("?");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if ("midnightpwd".equalsIgnoreCase(String.valueOf(key))) {
                try {
                    value = AES.aesEncryptByBase64(String.valueOf(value).getBytes(), a.a("cellccommonkey").getBytes());
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            sb.append((Object) key);
            sb.append("=");
            sb.append((Object) value);
            sb.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.SDKUserMgr4CELLC.6
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onMidnightLoginReturnListener.onMidnightLoginReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    LogEx.w("SDKUserMgr4CELLC", "JSONException occur");
                    onMidnightLoginReturnListener.onMidnightLoginReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 202)), "JSONException occur");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKUserMgr4CELLC", "SDKNetHTTPRequest onFailReturn");
                onMidnightLoginReturnListener.onMidnightLoginReturn(String.valueOf(i), str);
            }
        });
    }

    public void unbindTerminalDevice(HashMap<String, String> hashMap, final OnUnbindTerminalDeviceReturnListener onUnbindTerminalDeviceReturnListener) {
        if (onUnbindTerminalDeviceReturnListener == null) {
            LogEx.w("SDKUserMgr4CELLC", "listener is null");
            return;
        }
        if (hashMap == null) {
            LogEx.w("SDKUserMgr4CELLC", ErrMessage.PARAM_IS_NULL);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.CELLC_UNBIND_DEV);
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
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.SDKUserMgr4CELLC.4
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onUnbindTerminalDeviceReturnListener.onUnbindTerminalDeviceReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKUserMgr4CELLC", "JSONException occur");
                    onUnbindTerminalDeviceReturnListener.onUnbindTerminalDeviceReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 202)), "JSONException occur");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKUserMgr4CELLC", "SDKNetHTTPRequest onFailReturn");
                onUnbindTerminalDeviceReturnListener.onUnbindTerminalDeviceReturn(String.valueOf(i), str);
            }
        });
    }

    public void updateUserInfo(HashMap<String, String> hashMap, final OnUpdateUserInfoReturnListener onUpdateUserInfoReturnListener) {
        if (onUpdateUserInfoReturnListener == null) {
            LogEx.w("SDKUserMgr4CELLC", "listener is null");
            return;
        }
        if (hashMap == null) {
            LogEx.w("SDKUserMgr4CELLC", ErrMessage.PARAM_IS_NULL);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.CELLC_UPDATE_USER_INFO);
        sb.append("?");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (SDKMgr.f3020c) {
                String a2 = a.a("epgkey");
                try {
                    if (ParamConst.GET_REGISTER_REQ_MOBILENO.equals(key)) {
                        value = AES.aesEncryptByBase64(String.valueOf(value).getBytes(), a2.getBytes());
                    }
                    if ("email".equals(key)) {
                        value = AES.aesEncryptByBase64(String.valueOf(value).getBytes(), a2.getBytes());
                    }
                    if ("username".equals(key)) {
                        value = AES.aesEncryptByBase64(String.valueOf(value).getBytes(), a2.getBytes());
                    }
                    if ("paymobileno".equals(key)) {
                        value = AES.aesEncryptByBase64(String.valueOf(value).getBytes(), a2.getBytes());
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            sb.append((Object) key);
            sb.append("=");
            sb.append((Object) value);
            sb.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.SDKUserMgr4CELLC.2
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onUpdateUserInfoReturnListener.onUpdateUserInfoReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    LogEx.w("SDKUserMgr4CELLC", "JSONException occur");
                    onUpdateUserInfoReturnListener.onUpdateUserInfoReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKUserMgr4CELLC", "SDKNetHTTPRequest onFailReturn");
                onUpdateUserInfoReturnListener.onUpdateUserInfoReturn(String.valueOf(i), str, null);
            }
        });
    }
}
