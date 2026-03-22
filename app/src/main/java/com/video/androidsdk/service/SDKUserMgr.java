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
import com.video.androidsdk.login.a.c;
import com.video.androidsdk.service.bean.BindSTBReq;
import com.video.androidsdk.service.bean.GetVerifyCodeReq;
import com.video.androidsdk.service.bean.SMSCodeReq;
import com.video.androidsdk.service.bean.STBInfo;
import com.video.androidsdk.service.bean.UserLevelReq;
import com.video.androidsdk.service.bean.UserProperties;
import com.video.androidsdk.service.bean.UserRegisterReq;
import com.video.androidsdk.service.bean.UserSwitchReq;
import com.video.androidsdk.service.bean.VRbindSTBReq;
import com.video.androidsdk.service.comm.HttpUrlConstants;
import com.video.androidsdk.service.comm.ParamConst;
import com.video.androidsdk.service.comm.PasswordType;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SDKUserMgr {

    /* renamed from: a, reason: collision with root package name */
    private SDKNetHTTPRequest f3420a;

    /* renamed from: b, reason: collision with root package name */
    private SDKNetHTTPRequest f3421b;

    /* renamed from: c, reason: collision with root package name */
    private SDKNetHTTPRequest f3422c;

    /* renamed from: d, reason: collision with root package name */
    private SDKNetHTTPRequest f3423d;
    private SDKNetHTTPRequest e;
    private SDKNetHTTPRequest f;
    private SDKNetHTTPRequest g;
    private SDKNetHTTPRequest h;
    private SDKNetHTTPRequest i;
    private SDKNetHTTPRequest j;
    private SDKNetHTTPRequest k;
    private SDKNetHTTPRequest l;
    private SDKNetHTTPRequest m;

    /* loaded from: classes.dex */
    public interface OnChangePasswordReturnListener {
        void onChangePasswordReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnChangeSTBNameReturnListener {
        void onChangeSTBNameReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnChangeUserLevelReturnListener {
        void onChangeLevelReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnChangeUserSwitchReturnListener {
        void onChangeUserSwitchReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnClearUserDataReturnListener {
        void onClearUserDataReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnGetBindUserReturnListener {
        void onGetBindUserReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnGetProfileReturnListener {
        void onGetProfileReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnGetVerifyCodeReturnListener {
        void onGetVerifyCodeReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnResetUserPasswordReturnListener {
        void onResetUserPasswordReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnSMSCodeReturnListener {
        void onRegisterCodeReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnSTBListReturnListener {
        void onSTBListReturn(String str, String str2, List<STBInfo> list);
    }

    /* loaded from: classes.dex */
    public interface OnSetUserLanguageReturnListener {
        void onUserLanguageReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnSetUserMediaServicesReturnListener {
        void onUserMediaServicesReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnUpdateProfileReturnListener {
        void onUpdateProfileReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnUpdateUserInfoCommonReturnListener {
        void onUpdateUserInfoCommonReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnUserDetailCommonReturnListener {
        void onUserDetailCommonReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnUserPropertiesReturnListener {
        void onUserPropertiesReturn(String str, String str2, UserProperties userProperties);
    }

    /* loaded from: classes.dex */
    public interface OnUserRegisterReturnListener {
        void onRegisterReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnVRbindSTBReturnListener {
        void onVRbindSTBReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnbindSTBReturnListener {
        void onBindSTBReturn(String str, String str2);
    }

    public void bindSTB(String str, BindSTBReq bindSTBReq, final OnbindSTBReturnListener onbindSTBReturnListener) {
        if (onbindSTBReturnListener == null) {
            LogEx.w("SDKUserMgr", "OnbindSTBReturnListener is null.");
            return;
        }
        if (bindSTBReq == null) {
            LogEx.w("SDKUserMgr", "BindSTBReq is null.");
            return;
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f = sDKNetHTTPRequest;
        String replace = HttpUrlConstants.BIND_STB.replace("http://{ipadd:port}", str);
        String userID = SDKLoginMgr.getInstance().getUserID();
        String a2 = c.a(userID, (String) null);
        String userInfo = SDKLoginMgr.getInstance().getUserInfo("UserToken");
        sDKNetHTTPRequest.setParam(ParamConst.BIND_IPTV_REQ_IPTVUSERID, bindSTBReq.iptvuserid);
        sDKNetHTTPRequest.setParam("ottuserid", userID);
        sDKNetHTTPRequest.setParam(ParamConst.BIND_IPTV_REQ_ACTIONTYPE, bindSTBReq.actiontype);
        sDKNetHTTPRequest.setParam(ParamConst.BIND_IPTV_REQ_CHECKWORD, bindSTBReq.checkword);
        sDKNetHTTPRequest.setParam("userToken", userInfo);
        sDKNetHTTPRequest.setParam("authinfo", a2);
        sDKNetHTTPRequest.startRequest(replace, "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.SDKUserMgr.8
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str2) {
                if (TextUtils.isEmpty(str2)) {
                    LogEx.w("SDKUserMgr", "return data is empty.");
                    return;
                }
                try {
                    onbindSTBReturnListener.onBindSTBReturn(new JSONObject(str2).optString("returncode"), "errormsg");
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKUserMgr", "json parse error.");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str2) {
                onbindSTBReturnListener.onBindSTBReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 6, i % 1000)), str2);
            }
        });
    }

    public void cancelCallBack() {
        SDKNetHTTPRequest sDKNetHTTPRequest = this.f3420a;
        if (sDKNetHTTPRequest != null) {
            sDKNetHTTPRequest.cancelRequest();
        }
        SDKNetHTTPRequest sDKNetHTTPRequest2 = this.f3421b;
        if (sDKNetHTTPRequest2 != null) {
            sDKNetHTTPRequest2.cancelRequest();
        }
        SDKNetHTTPRequest sDKNetHTTPRequest3 = this.f3422c;
        if (sDKNetHTTPRequest3 != null) {
            sDKNetHTTPRequest3.cancelRequest();
        }
        SDKNetHTTPRequest sDKNetHTTPRequest4 = this.f3423d;
        if (sDKNetHTTPRequest4 != null) {
            sDKNetHTTPRequest4.cancelRequest();
        }
        SDKNetHTTPRequest sDKNetHTTPRequest5 = this.e;
        if (sDKNetHTTPRequest5 != null) {
            sDKNetHTTPRequest5.cancelRequest();
        }
        SDKNetHTTPRequest sDKNetHTTPRequest6 = this.f;
        if (sDKNetHTTPRequest6 != null) {
            sDKNetHTTPRequest6.cancelRequest();
        }
        SDKNetHTTPRequest sDKNetHTTPRequest7 = this.g;
        if (sDKNetHTTPRequest7 != null) {
            sDKNetHTTPRequest7.cancelRequest();
        }
        SDKNetHTTPRequest sDKNetHTTPRequest8 = this.h;
        if (sDKNetHTTPRequest8 != null) {
            sDKNetHTTPRequest8.cancelRequest();
        }
        SDKNetHTTPRequest sDKNetHTTPRequest9 = this.i;
        if (sDKNetHTTPRequest9 != null) {
            sDKNetHTTPRequest9.cancelRequest();
        }
        SDKNetHTTPRequest sDKNetHTTPRequest10 = this.j;
        if (sDKNetHTTPRequest10 != null) {
            sDKNetHTTPRequest10.cancelRequest();
        }
        SDKNetHTTPRequest sDKNetHTTPRequest11 = this.k;
        if (sDKNetHTTPRequest11 != null) {
            sDKNetHTTPRequest11.cancelRequest();
        }
        SDKNetHTTPRequest sDKNetHTTPRequest12 = this.l;
        if (sDKNetHTTPRequest12 != null) {
            sDKNetHTTPRequest12.cancelRequest();
        }
        SDKNetHTTPRequest sDKNetHTTPRequest13 = this.m;
        if (sDKNetHTTPRequest13 != null) {
            sDKNetHTTPRequest13.cancelRequest();
        }
    }

    public void changePassword(String str, String str2, String str3, PasswordType passwordType, final OnChangePasswordReturnListener onChangePasswordReturnListener) {
        if (onChangePasswordReturnListener == null) {
            LogEx.w("SDKUserMgr", "OnChangePasswordReturnListener is null");
            return;
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3422c = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        String str4 = SDKLoginMgr.getInstance().getEPGHome() + HttpUrlConstants.CHANGE_PWD;
        sDKNetHTTPRequest.setParam("userid", str);
        sDKNetHTTPRequest.setParam(ParamConst.USER_PWD_MODIGY_REQ_OLDPASSWORD, str2);
        sDKNetHTTPRequest.setParam(ParamConst.USER_PWD_MODIGY_REQ_NEWPASSWORD, str3);
        sDKNetHTTPRequest.setParam(ParamConst.USER_PWD_MODIGY_REQ_PASSWORDTYPE, String.valueOf(passwordType.getIntValue()));
        sDKNetHTTPRequest.startRequest(str4, "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.SDKUserMgr.3
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str5) {
                if (TextUtils.isEmpty(str5)) {
                    LogEx.w("SDKUserMgr", "return data is empty.");
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str5);
                    onChangePasswordReturnListener.onChangePasswordReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKUserMgr", "json parse error.");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str5) {
                onChangePasswordReturnListener.onChangePasswordReturn(String.valueOf(i), str5);
            }
        });
    }

    public void changePasswordByFrame(ChangePasswordReq changePasswordReq, final OnChangePasswordReturnListener onChangePasswordReturnListener) {
        if (onChangePasswordReturnListener == null) {
            LogEx.w("SDKUserMgr", "OnChangePasswordReturnListener is null");
            return;
        }
        if (changePasswordReq == null) {
            LogEx.w("SDKUserMgr", "changePasswordByFrame req is null");
            return;
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3422c = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        String str = SDKLoginMgr.getInstance().getFrameHome() + HttpUrlConstants.CHANGE_PWD_BY_FRAME;
        sDKNetHTTPRequest.setParam(ParamConst.USER_PWD_MODIGY_REQ_OLDPASSWORD, changePasswordReq.oldpwd);
        sDKNetHTTPRequest.setParam(ParamConst.USER_PWD_MODIGY_REQ_NEWPASSWORD, changePasswordReq.newpwd);
        sDKNetHTTPRequest.setParam(ParamConst.USER_PWD_MODIGY_REQ_PASSWORDTYPE, changePasswordReq.pwdtype);
        if (!TextUtils.isEmpty(changePasswordReq.userid)) {
            sDKNetHTTPRequest.setParam("userid", changePasswordReq.userid);
        }
        sDKNetHTTPRequest.startRequest(str, "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.SDKUserMgr.5
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str2) {
                if (TextUtils.isEmpty(str2)) {
                    LogEx.w("SDKUserMgr", "return data is empty.");
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    onChangePasswordReturnListener.onChangePasswordReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKUserMgr", "json parse error.");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str2) {
                onChangePasswordReturnListener.onChangePasswordReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 1, i % 1000)), str2);
            }
        });
    }

    public void changeSTBName(String str, String str2, final OnChangeSTBNameReturnListener onChangeSTBNameReturnListener) {
        if (onChangeSTBNameReturnListener == null) {
            LogEx.w("SDKUserMgr", "OnChangeSTBNameReturnListener is null.");
            return;
        }
        SDKNetHTTPRequest a2 = a();
        this.j = a2;
        a2.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        a2.startRequest((SDKLoginMgr.getInstance().getEPGHome() + HttpUrlConstants.CHANGE_STB_NAME) + "?stbname=" + str + "&stbmac=" + str2, "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.SDKUserMgr.12
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str3) {
                if (TextUtils.isEmpty(str3)) {
                    LogEx.w("SDKUserMgr", "return data is null.");
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    onChangeSTBNameReturnListener.onChangeSTBNameReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    LogEx.w("SDKUserMgr", "json parse error.");
                    e.printStackTrace();
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str3) {
                onChangeSTBNameReturnListener.onChangeSTBNameReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 10, i % 1000)), str3);
            }
        });
    }

    public void changeUserLevel(UserLevelReq userLevelReq, final OnChangeUserLevelReturnListener onChangeUserLevelReturnListener) {
        if (onChangeUserLevelReturnListener == null) {
            LogEx.w("SDKUserMgr", "OnChangeUserLevelReturnListener is null.");
            return;
        }
        if (userLevelReq == null) {
            LogEx.w("SDKUserMgr", "UserLevelReq is null.");
            return;
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.g = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.setParam("limitlevel", userLevelReq.limitlevel);
        sDKNetHTTPRequest.setParam("blocktitlelevel", userLevelReq.blocktitlelevel);
        sDKNetHTTPRequest.setParam("password", userLevelReq.password);
        sDKNetHTTPRequest.startRequest(SDKLoginMgr.getInstance().getEPGHome() + HttpUrlConstants.CHANGE_USER_LEVEL, "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.SDKUserMgr.9
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                if (TextUtils.isEmpty(str)) {
                    LogEx.w("SDKUserMgr", "return data is empty.");
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onChangeUserLevelReturnListener.onChangeLevelReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    LogEx.w("SDKUserMgr", "json parse exception.");
                    e.printStackTrace();
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                onChangeUserLevelReturnListener.onChangeLevelReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 7, i % 1000)), str);
            }
        });
    }

    public void changeUserSwitch(UserSwitchReq userSwitchReq, final OnChangeUserSwitchReturnListener onChangeUserSwitchReturnListener) {
        if (onChangeUserSwitchReturnListener == null) {
            LogEx.w("SDKUserMgr", "OnChangeUserSwitchReturnListener is null.");
            return;
        }
        if (userSwitchReq == null) {
            LogEx.w("SDKUserMgr", "UserSwitchReq is null.");
            onChangeUserSwitchReturnListener.onChangeUserSwitchReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 8, 2)), ErrMessage.PARAM_IS_NULL);
            return;
        }
        SDKNetHTTPRequest a2 = a();
        this.h = a2;
        a2.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        a(userSwitchReq, a2);
        a2.startRequest(SDKLoginMgr.getInstance().getEPGHome() + HttpUrlConstants.CHANGE_USER_SWITCH, "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.SDKUserMgr.10
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                if (TextUtils.isEmpty(str)) {
                    LogEx.w("SDKUserMgr", "return data is empty.");
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onChangeUserSwitchReturnListener.onChangeUserSwitchReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    LogEx.w("SDKUserMgr", "json parse exception.");
                    e.printStackTrace();
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                onChangeUserSwitchReturnListener.onChangeUserSwitchReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 8, i % 1000)), str);
            }
        });
    }

    public void clearUserData(ClearUserDataReq clearUserDataReq, final OnClearUserDataReturnListener onClearUserDataReturnListener) {
        if (onClearUserDataReturnListener == null) {
            LogEx.w("SDKUserMgr", "listener is null");
            return;
        }
        if (clearUserDataReq == null) {
            LogEx.w("SDKUserMgr", "ClearUserDataReq is null");
            onClearUserDataReturnListener.onClearUserDataReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 15, 2)), ErrMessage.PARAM_IS_NULL);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.CLEAR_USER_DATA);
        HashMap<String, String> hashMap = clearUserDataReq.toHashMap();
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
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.SDKUserMgr.17
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onClearUserDataReturnListener.onClearUserDataReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKUserMgr", "JSONException occur");
                    onClearUserDataReturnListener.onClearUserDataReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 15, 202)), "JSONException occur");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKUserMgr", "SDKNetHTTPRequest onFailReturn");
                onClearUserDataReturnListener.onClearUserDataReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 15, i % 1000)), str);
            }
        });
    }

    public void getBindUser(HashMap<String, String> hashMap, final OnGetBindUserReturnListener onGetBindUserReturnListener) {
        if (onGetBindUserReturnListener == null) {
            LogEx.w("SDKUserMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            LogEx.w("SDKUserMgr", "params is null");
            onGetBindUserReturnListener.onGetBindUserReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 14, 2)), ErrMessage.PARAM_IS_NULL, null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.QUERY_BIND_USER);
        sb.append("?");
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (SDKMgr.f3020c && "userid".equals(key)) {
                try {
                    value = AES.aesEncryptByBase64(String.valueOf(value).getBytes(), a.a("epgkey").getBytes());
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
        sDKNetHTTPRequest.startRequest(sDKNetHTTPRequest.replaceFrame(sb.toString()), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.SDKUserMgr.16
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString("returncode");
                    String optString2 = jSONObject.optString("errormsg");
                    if (SDKMgr.f3020c) {
                        String a2 = a.a("epgkey");
                        try {
                            JSONArray optJSONArray = jSONObject.optJSONArray(ParamConst.BIND_IPTV_RSP_BIND_USER);
                            if (optJSONArray != null) {
                                for (int i = 0; i < optJSONArray.length(); i++) {
                                    optJSONArray.put(i, AES.aesDecryptByBase64(optJSONArray.getString(i), a2.getBytes()));
                                }
                                jSONObject.remove(ParamConst.BIND_IPTV_RSP_BIND_USER);
                                jSONObject.put(ParamConst.BIND_IPTV_RSP_BIND_USER, optJSONArray);
                            }
                            JSONArray optJSONArray2 = jSONObject.optJSONArray("parentidlist");
                            if (optJSONArray2 != null) {
                                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                    optJSONArray2.put(i2, AES.aesDecryptByBase64(optJSONArray2.getString(i2), a2.getBytes()));
                                }
                                jSONObject.remove("parentidlist");
                                jSONObject.put("parentidlist", optJSONArray2);
                            }
                        } catch (UnsupportedEncodingException e2) {
                            e2.printStackTrace();
                            onGetBindUserReturnListener.onGetBindUserReturn(optString, optString2, str);
                        }
                    }
                    onGetBindUserReturnListener.onGetBindUserReturn(optString, optString2, jSONObject.toString());
                } catch (JSONException e3) {
                    e3.printStackTrace();
                    LogEx.w("SDKUserMgr", "JSONException occur");
                    onGetBindUserReturnListener.onGetBindUserReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 14, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKUserMgr", "SDKNetHTTPRequest onFailReturn");
                onGetBindUserReturnListener.onGetBindUserReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 14, i % 1000)), str, null);
            }
        });
    }

    public void getProfile(final OnGetProfileReturnListener onGetProfileReturnListener) {
        if (onGetProfileReturnListener == null) {
            LogEx.w("SDKUserMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append("sdk_getuserprofile.jsp");
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.SDKUserMgr.14
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onGetProfileReturnListener.onGetProfileReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKUserMgr", "JSONException occur");
                    onGetProfileReturnListener.onGetProfileReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 12, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKUserMgr", "SDKNetHTTPRequest onFailReturn");
                onGetProfileReturnListener.onGetProfileReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 12, i % 1000)), str, null);
            }
        });
    }

    public void getSTBList(String str, final OnSTBListReturnListener onSTBListReturnListener) {
        if (onSTBListReturnListener == null) {
            LogEx.w("SDKUserMgr", "OnSTBListReturnListener is null.");
            return;
        }
        SDKNetHTTPRequest a2 = a();
        this.i = a2;
        a2.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        a2.startRequest(HttpUrlConstants.GET_STB_LIST.replace("{ipadd:port}", SDKLoginMgr.getInstance().getEASHost() + ":" + SDKLoginMgr.getInstance().getEASPort()) + "?fatheruserid=" + str, "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.SDKUserMgr.11
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str2) {
                if (TextUtils.isEmpty(str2)) {
                    LogEx.w("SDKUserMgr", "return data is null.");
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    String optString = jSONObject.optString("returncode");
                    String optString2 = jSONObject.optString("errormsg");
                    if (optString.equals("0")) {
                        onSTBListReturnListener.onSTBListReturn(String.valueOf(optString), optString2, SDKUserMgr.this.b(str2));
                    } else {
                        onSTBListReturnListener.onSTBListReturn(optString, optString2, null);
                    }
                } catch (JSONException e) {
                    LogEx.w("SDKUserMgr", "json parse error.");
                    e.printStackTrace();
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str2) {
                onSTBListReturnListener.onSTBListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 9, i % 1000)), str2, null);
            }
        });
    }

    public void getUserDetailCommon(final OnUserDetailCommonReturnListener onUserDetailCommonReturnListener) {
        if (onUserDetailCommonReturnListener == null) {
            LogEx.w("SDKUserMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.GET_USER_DETAILCOMMON);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.SDKUserMgr.19
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
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                            onUserDetailCommonReturnListener.onUserDetailCommonReturn(optString, optString2, str);
                        }
                    }
                    onUserDetailCommonReturnListener.onUserDetailCommonReturn(optString, optString2, jSONObject.toString());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    LogEx.w("SDKUserMgr", "JSONException occur");
                    onUserDetailCommonReturnListener.onUserDetailCommonReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 17, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKUserMgr", "SDKNetHTTPRequest onFailReturn");
                onUserDetailCommonReturnListener.onUserDetailCommonReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 17, i % 1000)), str, null);
            }
        });
    }

    public void getUserProperties(final OnUserPropertiesReturnListener onUserPropertiesReturnListener) {
        if (onUserPropertiesReturnListener == null) {
            LogEx.w("SDKUserMgr", "OnUserPropertiesReturnListener is null");
            return;
        }
        SDKNetHTTPRequest a2 = a();
        this.k = a2;
        a2.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        a2.startRequest(SDKLoginMgr.getInstance().getEPGHome() + HttpUrlConstants.GET_USER_PROPERTIES, "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.SDKUserMgr.13
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                if (TextUtils.isEmpty(str)) {
                    LogEx.w("SDKUserMgr", "getUserProperties return data is empty.");
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String optString = jSONObject.optString("returncode");
                    String optString2 = jSONObject.optString("errormsg");
                    if (optString.equals("0")) {
                        onUserPropertiesReturnListener.onUserPropertiesReturn(optString, optString2, SDKUserMgr.this.a(str));
                    } else {
                        onUserPropertiesReturnListener.onUserPropertiesReturn(optString, optString2, null);
                    }
                } catch (JSONException e) {
                    LogEx.w("SDKUserMgr", "getUserProperties json parse error");
                    e.printStackTrace();
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                onUserPropertiesReturnListener.onUserPropertiesReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 11, i % 1000)), str, null);
            }
        });
    }

    public void getVerifyCode(String str, GetVerifyCodeReq getVerifyCodeReq, final OnGetVerifyCodeReturnListener onGetVerifyCodeReturnListener) {
        if (onGetVerifyCodeReturnListener == null) {
            LogEx.w("SDKUserMgr", "OnGetVerifyCodeReturnListener is null.");
            return;
        }
        if (getVerifyCodeReq == null) {
            LogEx.w("SDKUserMgr", "GetVerifyCodeReq is null.");
            return;
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.m = sDKNetHTTPRequest;
        String replace = HttpUrlConstants.GET_VERIFY_CODE.replace("http://{ipadd:port}", str);
        String a2 = c.a(getVerifyCodeReq.usercode, "");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("usercode", getVerifyCodeReq.usercode);
            jSONObject.put("deviceid", getVerifyCodeReq.deviceid);
            jSONObject.put("authinfo", a2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        sDKNetHTTPRequest.setBody(jSONObject.toString());
        sDKNetHTTPRequest.startRequest(replace, "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.SDKUserMgr.22
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str2) {
                if (TextUtils.isEmpty(str2)) {
                    LogEx.w("SDKUserMgr", "return data is empty.");
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject(str2);
                    onGetVerifyCodeReturnListener.onGetVerifyCodeReturn(jSONObject2.optString("returncode"), jSONObject2.optString("errormsg"), jSONObject2.optString(ParamConst.BIND_IPTV_REQ_VERIFYCODE));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    LogEx.w("SDKUserMgr", "json parse error.");
                    onGetVerifyCodeReturnListener.onGetVerifyCodeReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 20, 202)), "JSONException occur", "");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str2) {
                onGetVerifyCodeReturnListener.onGetVerifyCodeReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 20, i % 1000)), str2, "");
            }
        });
    }

    public void querySMSCode(String str, SMSCodeReq sMSCodeReq, final OnSMSCodeReturnListener onSMSCodeReturnListener) {
        if (onSMSCodeReturnListener == null) {
            LogEx.w("SDKUserMgr", "OnSMSCodeReturnListener is null");
            return;
        }
        if (sMSCodeReq == null) {
            LogEx.w("SDKUserMgr", "querySMSCode req is null");
            return;
        }
        String replace = HttpUrlConstants.GET_AUTHCODE_BY_PHONE.replace("http://{impip:port}", str);
        LogEx.d("SDKUserMgr", "querySMSCode url=" + replace);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3420a = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setParam("ottuserid", sMSCodeReq.getOttuserid());
        sDKNetHTTPRequest.setParam("terminalFlag", sMSCodeReq.getTerminalFlag());
        String a2 = c.a(sMSCodeReq.getOttuserid(), sMSCodeReq.getPassword());
        LogEx.d("SDKUserMgr", "querySMSCode authInfo=" + a2);
        sDKNetHTTPRequest.setParam("authinfo", a2);
        sDKNetHTTPRequest.startRequest(replace, "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.SDKUserMgr.1
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str2) {
                if (TextUtils.isEmpty(str2)) {
                    LogEx.w("SDKUserMgr", "return data is empty");
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    onSMSCodeReturnListener.onRegisterCodeReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKUserMgr", "json parse error");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str2) {
                onSMSCodeReturnListener.onRegisterCodeReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 4, i % 1000)), str2);
            }
        });
    }

    public void registerOTTUser(String str, UserRegisterReq userRegisterReq, final OnUserRegisterReturnListener onUserRegisterReturnListener) {
        if (onUserRegisterReturnListener == null) {
            LogEx.w("SDKUserMgr", "OnUserRegisterReturnListener is null");
            return;
        }
        if (userRegisterReq == null) {
            LogEx.w("SDKUserMgr", "UserRegisterReq req is null");
            return;
        }
        String replace = HttpUrlConstants.LIANGCHUANG_REG_PATH.replace("http://{impip:port}", str);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3421b = sDKNetHTTPRequest;
        String a2 = c.a(userRegisterReq.getOttuserid(), userRegisterReq.getPassword(), userRegisterReq.getCheckcode());
        sDKNetHTTPRequest.setParam("ottuserid", userRegisterReq.getOttuserid());
        sDKNetHTTPRequest.setParam(ParamConst.GET_REGISTER_REQ_CUSTERNAME, userRegisterReq.getCustomername());
        sDKNetHTTPRequest.setParam(ParamConst.GET_REGISTER_REQ_MOBILENO, userRegisterReq.getMobileno());
        if (!TextUtils.isEmpty(userRegisterReq.getEmail())) {
            sDKNetHTTPRequest.setParam("email", userRegisterReq.getEmail());
        }
        if (!TextUtils.isEmpty(userRegisterReq.getCNIC())) {
            sDKNetHTTPRequest.setParam(ParamConst.GET_REGISTER_REQ_CNIC, userRegisterReq.getCNIC());
        }
        if (!TextUtils.isEmpty(userRegisterReq.getCitycode())) {
            sDKNetHTTPRequest.setParam(ParamConst.GET_REGISTER_REQ_CITYCODE, userRegisterReq.getCitycode());
        }
        sDKNetHTTPRequest.setParam("authinfo", a2);
        sDKNetHTTPRequest.startRequest(replace, "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.SDKUserMgr.2
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str2) {
                if (TextUtils.isEmpty(str2)) {
                    LogEx.w("SDKUserMgr", "return data is empty");
                }
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    onUserRegisterReturnListener.onRegisterReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKUserMgr", "json parse error.");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str2) {
                onUserRegisterReturnListener.onRegisterReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 5, i % 1000)), str2);
            }
        });
    }

    public void resetUserPassword(ResetUserPasswordReq resetUserPasswordReq, final OnResetUserPasswordReturnListener onResetUserPasswordReturnListener) {
        if (onResetUserPasswordReturnListener == null) {
            LogEx.w("SDKUserMgr", "listener is null");
            return;
        }
        if (resetUserPasswordReq == null) {
            LogEx.w("SDKUserMgr", "req is null");
            onResetUserPasswordReturnListener.onResetUserPasswordReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 16, 2)), ErrMessage.PARAM_IS_NULL, null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.RESET_USER_PASSWORD);
        HashMap<String, String> hashMap = resetUserPasswordReq.toHashMap();
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
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.SDKUserMgr.18
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onResetUserPasswordReturnListener.onResetUserPasswordReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKUserMgr", "JSONException occur");
                    onResetUserPasswordReturnListener.onResetUserPasswordReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 16, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKUserMgr", "SDKNetHTTPRequest onFailReturn");
                onResetUserPasswordReturnListener.onResetUserPasswordReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 16, i % 1000)), str, null);
            }
        });
    }

    public void setUserLanguage(String str, final OnSetUserLanguageReturnListener onSetUserLanguageReturnListener) {
        if (onSetUserLanguageReturnListener == null) {
            LogEx.w("SDKUserMgr", "OnSetUserLanguageReturnListener is null");
            return;
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3423d = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest((SDKLoginMgr.getInstance().getEPGHome() + HttpUrlConstants.SET_USER_LANGUAGE) + "?languagetype=" + str, "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.SDKUserMgr.6
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str2) {
                if (TextUtils.isEmpty(str2)) {
                    LogEx.w("SDKUserMgr", "return data is empty.");
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    onSetUserLanguageReturnListener.onUserLanguageReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKUserMgr", "json parse error.");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str2) {
                onSetUserLanguageReturnListener.onUserLanguageReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 2, i % 1000)), str2);
            }
        });
    }

    public void setUserMediaservice(String str, final OnSetUserMediaServicesReturnListener onSetUserMediaServicesReturnListener) {
        if (onSetUserMediaServicesReturnListener == null) {
            LogEx.w("SDKUserMgr", "OnSetUserMediaServicesReturnListener is null.");
            return;
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.e = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest((SDKLoginMgr.getInstance().getEPGHome() + HttpUrlConstants.SET_USER_MEDIASERVICE) + "?mediaservices=" + str, "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.SDKUserMgr.7
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str2) {
                if (TextUtils.isEmpty(str2)) {
                    LogEx.w("SDKUserMgr", "return data is empty.");
                    return;
                }
                try {
                    onSetUserMediaServicesReturnListener.onUserMediaServicesReturn(new JSONObject(str2).optString("returncode"), "errormsg");
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKUserMgr", "json parse error.");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str2) {
                onSetUserMediaServicesReturnListener.onUserMediaServicesReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 3, i % 1000)), str2);
            }
        });
    }

    public void updateProfile(HashMap<String, String> hashMap, final OnUpdateProfileReturnListener onUpdateProfileReturnListener) {
        if (onUpdateProfileReturnListener == null) {
            LogEx.w("SDKUserMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            LogEx.w("SDKUserMgr", ErrMessage.PARAM_IS_NULL);
            onUpdateProfileReturnListener.onUpdateProfileReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 13, 2)), ErrMessage.PARAM_IS_NULL);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.UPDATE_USER_PROFILE);
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
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.SDKUserMgr.15
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onUpdateProfileReturnListener.onUpdateProfileReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKUserMgr", "JSONException occur");
                    onUpdateProfileReturnListener.onUpdateProfileReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 13, 202)), "JSONException occur");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKUserMgr", "SDKNetHTTPRequest onFailReturn");
                onUpdateProfileReturnListener.onUpdateProfileReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 13, i % 1000)), str);
            }
        });
    }

    public void updateUserInfoCommon(HashMap<String, String> hashMap, final OnUpdateUserInfoCommonReturnListener onUpdateUserInfoCommonReturnListener) {
        if (onUpdateUserInfoCommonReturnListener == null) {
            LogEx.w("SDKUserMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            LogEx.w("SDKUserMgr", ErrMessage.PARAM_IS_NULL);
            onUpdateUserInfoCommonReturnListener.onUpdateUserInfoCommonReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 18, 2)), ErrMessage.PARAM_IS_NULL, null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.UPDATE_USER_INFO);
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
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.SDKUserMgr.20
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onUpdateUserInfoCommonReturnListener.onUpdateUserInfoCommonReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    LogEx.w("SDKUserMgr", "JSONException occur");
                    onUpdateUserInfoCommonReturnListener.onUpdateUserInfoCommonReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 18, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKUserMgr", "SDKNetHTTPRequest onFailReturn");
                onUpdateUserInfoCommonReturnListener.onUpdateUserInfoCommonReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 18, i % 1000)), str, null);
            }
        });
    }

    public void vrbindSTB(String str, VRbindSTBReq vRbindSTBReq, final OnVRbindSTBReturnListener onVRbindSTBReturnListener) {
        if (onVRbindSTBReturnListener == null) {
            LogEx.w("SDKUserMgr", "OnVRbindSTBReturnListener is null.");
            return;
        }
        if (vRbindSTBReq == null) {
            LogEx.w("SDKUserMgr", "VRbindSTBReq is null.");
            return;
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.l = sDKNetHTTPRequest;
        String replace = HttpUrlConstants.VR_BIND_STB.replace("http://{ipadd:port}", str);
        String a2 = c.a(vRbindSTBReq.srcusercode, "");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ParamConst.BIND_IPTV_REQ_SRCUSERCODE, vRbindSTBReq.srcusercode);
            if (!TextUtils.isEmpty(vRbindSTBReq.opflag)) {
                jSONObject.put(ParamConst.BIND_IPTV_REQ_OPFLAG, Integer.valueOf(vRbindSTBReq.opflag));
            }
            if (!TextUtils.isEmpty(vRbindSTBReq.verifycode)) {
                jSONObject.put(ParamConst.BIND_IPTV_REQ_VERIFYCODE, Integer.valueOf(vRbindSTBReq.verifycode));
            }
            jSONObject.put("authinfo", a2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        sDKNetHTTPRequest.setBody(jSONObject.toString());
        sDKNetHTTPRequest.startRequest(replace, "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.SDKUserMgr.21
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str2) {
                if (TextUtils.isEmpty(str2)) {
                    LogEx.w("SDKUserMgr", "return data is empty.");
                    return;
                }
                try {
                    JSONObject jSONObject2 = new JSONObject(str2);
                    onVRbindSTBReturnListener.onVRbindSTBReturn(jSONObject2.optString("returncode"), jSONObject2.optString("errormsg"), jSONObject2.optString("dstusercode"));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    LogEx.w("SDKUserMgr", "json parse error.");
                    onVRbindSTBReturnListener.onVRbindSTBReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 19, 202)), "JSONException occur", "");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str2) {
                onVRbindSTBReturnListener.onVRbindSTBReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 19, i % 1000)), str2, "");
            }
        });
    }

    private void a(Object obj, SDKNetHTTPRequest sDKNetHTTPRequest) {
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                sDKNetHTTPRequest.setParam(field.getName(), "" + field.get(obj));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<STBInfo> b(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("totalcount");
        if (TextUtils.isEmpty(optString) || optString.equals("0")) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("stbname");
        JSONArray optJSONArray2 = jSONObject.optJSONArray(ParamConst.STB_LIST_RSP_STBID);
        JSONArray optJSONArray3 = jSONObject.optJSONArray("stbmac");
        JSONArray optJSONArray4 = jSONObject.optJSONArray("stbusercode");
        for (int i = 0; i < Integer.valueOf(optString).intValue(); i++) {
            STBInfo sTBInfo = new STBInfo();
            if (optJSONArray != null) {
                sTBInfo.stbname = optJSONArray.getString(i);
            }
            if (optJSONArray2 != null) {
                sTBInfo.stbid = optJSONArray2.getString(i);
            }
            if (optJSONArray3 != null) {
                sTBInfo.stbmac = optJSONArray3.getString(i);
            }
            if (optJSONArray4 != null) {
                sTBInfo.stbusercode = optJSONArray4.getString(i);
            }
            arrayList.add(sTBInfo);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UserProperties a(String str) throws JSONException {
        UserProperties userProperties = new UserProperties();
        JSONObject jSONObject = new JSONObject(str);
        userProperties.limitpwd = jSONObject.optString(ParamConst.USER_PROPERTIES_RSP_LIMITPWD);
        userProperties.adultpwd = jSONObject.optString("adultpwd");
        userProperties.orderpwd = jSONObject.optString(ParamConst.USER_PROPERTIES_RSP_ORDERPWD);
        userProperties.limitlevel = jSONObject.optString("limitlevel");
        userProperties.blocktitlelevel = jSONObject.optString("blocktitlelevel");
        userProperties.switchvalue = jSONObject.optString("switchvalue");
        userProperties.userlanguage = jSONObject.optString(ParamConst.USER_PROPERTIES_RSP_USERLANGUAGE);
        userProperties.profile = jSONObject.optString(ParamConst.USER_PROPERTIES_RSP_PROFILE);
        userProperties.servicecode = jSONObject.optString("servicecode");
        userProperties.bandwidth = jSONObject.optString("bandwidth");
        userProperties.teamid = jSONObject.optString("teamid");
        return userProperties;
    }

    public void changePassword(ChangePasswordReq changePasswordReq, final OnChangePasswordReturnListener onChangePasswordReturnListener) {
        if (onChangePasswordReturnListener == null) {
            LogEx.w("SDKUserMgr", "OnChangePasswordReturnListener is null");
            return;
        }
        if (changePasswordReq == null) {
            LogEx.w("SDKUserMgr", "changePassword req is null");
            return;
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3422c = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        String str = SDKLoginMgr.getInstance().getEPGHome() + HttpUrlConstants.CHANGE_PWD;
        if (!TextUtils.isEmpty(changePasswordReq.userid)) {
            sDKNetHTTPRequest.setParam("userid", changePasswordReq.userid);
        }
        sDKNetHTTPRequest.setParam(ParamConst.USER_PWD_MODIGY_REQ_OLDPASSWORD, changePasswordReq.oldpwd);
        sDKNetHTTPRequest.setParam(ParamConst.USER_PWD_MODIGY_REQ_NEWPASSWORD, changePasswordReq.newpwd);
        sDKNetHTTPRequest.setParam(ParamConst.USER_PWD_MODIGY_REQ_PASSWORDTYPE, changePasswordReq.pwdtype);
        sDKNetHTTPRequest.startRequest(str, "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.SDKUserMgr.4
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str2) {
                if (TextUtils.isEmpty(str2)) {
                    LogEx.w("SDKUserMgr", "return data is empty.");
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    onChangePasswordReturnListener.onChangePasswordReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKUserMgr", "json parse error.");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str2) {
                onChangePasswordReturnListener.onChangePasswordReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_USER_OPERATION_MODELCODE, 1, i % 1000)), str2);
            }
        });
    }

    private SDKNetHTTPRequest a() {
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        return sDKNetHTTPRequest;
    }
}
