package com.video.androidsdk.service.clouddvr;

import android.text.TextUtils;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.login.a.c;
import com.video.androidsdk.login.impl.IIPTVLogin;
import com.video.androidsdk.service.comm.HttpUrlConstants;
import com.video.androidsdk.service.comm.ParamConst;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SDKCloudDVRMgr {

    /* renamed from: a, reason: collision with root package name */
    private String f3547a;

    /* renamed from: b, reason: collision with root package name */
    private String f3548b;

    /* renamed from: c, reason: collision with root package name */
    private SDKNetHTTPRequest f3549c;

    /* loaded from: classes.dex */
    public interface OnAddScheduleReturnListener {
        void onAddScheduleReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnDelRecordReturnListener {
        void onDelRecordReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnDelScheduleReturnListener {
        void onDelScheduleReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnGetEpisodeScheduleReturnListener {
        void onGetEpisodeScheduleReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnGetPrevueStateReturnListener {
        void onGetPrevueStateReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnGetRecordDetailReturnListener {
        void onGetRecordDetailReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnGetRecordListReturnListener {
        void onGetRecordListReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnGetScheduleInfoReturnListener {
        void onGetScheduleInfoReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnGetScheduleListReturnListener {
        void onGetScheduleListReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnGetSeriesScheduleInfoReturnListener {
        void onGetSeriesScheduleInfoReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnGetUserVolumeReturnListener {
        void onGetUserVolumeReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnModifyRecordReturnListener {
        void onModifyRecordReturn(String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnModifyScheduleReturnListener {
        void onModifyScheduleReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnOperateDVRBookMarkReturnListener {
        void onOperateDVRBookMarkReturn(String str, String str2);
    }

    private String a() {
        String userID = SDKLoginMgr.getInstance().getUserID();
        String userInfo = SDKLoginMgr.getInstance().getUserInfo("UserToken");
        return (TextUtils.isEmpty(userID) || TextUtils.isEmpty(userInfo)) ? "" : c.b(userID, userInfo);
    }

    private String b(Map<String, String> map, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(str)) {
            stringBuffer.append("<");
            stringBuffer.append(str);
            stringBuffer.append(">");
        }
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        if (entrySet != null) {
            for (Map.Entry<String, String> entry : entrySet) {
                String key = entry.getKey();
                String value = entry.getValue();
                LogEx.d("SDKCloudDVRMgr", "key === " + key);
                LogEx.d("SDKCloudDVRMgr", "value === " + value);
                stringBuffer.append("<");
                stringBuffer.append(key);
                stringBuffer.append(">");
                stringBuffer.append(value);
                stringBuffer.append("</");
                stringBuffer.append(key);
                stringBuffer.append(">");
            }
        }
        if (!TextUtils.isEmpty(str)) {
            stringBuffer.append("</");
            stringBuffer.append(str);
            stringBuffer.append(">");
        }
        LogEx.d("SDKCloudDVRMgr", "child xml === " + stringBuffer.toString());
        return stringBuffer.toString();
    }

    public void addSchedule(HashMap<String, String> hashMap, final OnAddScheduleReturnListener onAddScheduleReturnListener) {
        if (onAddScheduleReturnListener == null) {
            LogEx.w("SDKCloudDVRMgr", "listener is null");
            return;
        }
        if (TextUtils.isEmpty(this.f3547a)) {
            String userInfo = SDKLoginMgr.getInstance().getUserInfo("DVRDomain");
            this.f3547a = userInfo;
            if (TextUtils.isEmpty(userInfo)) {
                String userInfo2 = SDKLoginMgr.getInstance().getUserInfo("DVRDomainBackup");
                this.f3547a = userInfo2;
                if (TextUtils.isEmpty(userInfo2)) {
                    LogEx.d("SDKCloudDVRMgr", "ServerDomain has not set");
                    onAddScheduleReturnListener.onAddScheduleReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 6, 100)), "ServerDomain has not set", null);
                    return;
                }
            }
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3549c = sDKNetHTTPRequest;
        if (hashMap != null) {
            hashMap.put("UserID", SDKLoginMgr.getInstance().getUserID());
            hashMap.put("AuthInfo", a());
            hashMap.put(IIPTVLogin.LOGIN_PARAM_MAC, SDKLoginMgr.getInstance().getUserInfo(ParamConst.LOGIN_PORTALAUTH_RSP_STBMAC));
            a(hashMap);
            sDKNetHTTPRequest.setBody(a(hashMap, "ScheduleAddReq"));
        }
        sDKNetHTTPRequest.startRequest(this.f3547a + HttpUrlConstants.SCHEDULE_ADD, "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.clouddvr.SDKCloudDVRMgr.6
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    String xml2json = ParseScheduleAddXML.xml2json(str);
                    JSONObject jSONObject = new JSONObject(xml2json);
                    onAddScheduleReturnListener.onAddScheduleReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), xml2json);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKCloudDVRMgr", "JSONException occur");
                    onAddScheduleReturnListener.onAddScheduleReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 6, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKCloudDVRMgr", "SDKNetHTTPRequest onFailReturn");
                onAddScheduleReturnListener.onAddScheduleReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 6, i % 1000)), str, null);
            }
        });
    }

    public void cancelRequest() {
        SDKNetHTTPRequest sDKNetHTTPRequest = this.f3549c;
        if (sDKNetHTTPRequest != null) {
            sDKNetHTTPRequest.cancelRequest();
        }
    }

    public void delRecord(HashMap<String, String> hashMap, final OnDelRecordReturnListener onDelRecordReturnListener) {
        if (onDelRecordReturnListener == null) {
            LogEx.w("SDKCloudDVRMgr", "listener is null");
            return;
        }
        if (TextUtils.isEmpty(this.f3548b)) {
            String userInfo = SDKLoginMgr.getInstance().getUserInfo("RECORDDomain");
            this.f3548b = userInfo;
            if (TextUtils.isEmpty(userInfo)) {
                String userInfo2 = SDKLoginMgr.getInstance().getUserInfo("RECORDDomainBackup");
                this.f3548b = userInfo2;
                if (TextUtils.isEmpty(userInfo2)) {
                    LogEx.d("SDKCloudDVRMgr", "ServerDomain has not set");
                    onDelRecordReturnListener.onDelRecordReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 11, 100)), "ServerDomain has not set");
                    return;
                }
            }
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3549c = sDKNetHTTPRequest;
        if (hashMap != null) {
            hashMap.put("userid", SDKLoginMgr.getInstance().getUserID());
            hashMap.put(ParamConst.VOD_GET_GENRE_LIST_REQ_PARENTID, SDKLoginMgr.getInstance().getUserInfo("FatherUserID"));
            hashMap.put("authinfo", a());
            sDKNetHTTPRequest.setBody(a(hashMap, "RecordDelReq"));
        }
        sDKNetHTTPRequest.startRequest(this.f3548b + HttpUrlConstants.RECORD_DEL, "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.clouddvr.SDKCloudDVRMgr.11
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(ParseRecordDelXML.xml2json(str));
                    onDelRecordReturnListener.onDelRecordReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKCloudDVRMgr", "JSONException occur");
                    onDelRecordReturnListener.onDelRecordReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 11, 202)), "JSONException occur");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKCloudDVRMgr", "SDKNetHTTPRequest onFailReturn");
                onDelRecordReturnListener.onDelRecordReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 11, i % 1000)), str);
            }
        });
    }

    public void delSchedule(HashMap<String, String> hashMap, final OnDelScheduleReturnListener onDelScheduleReturnListener) {
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        if (onDelScheduleReturnListener == null) {
            LogEx.w("SDKCloudDVRMgr", "listener is null");
            return;
        }
        String[] strArr4 = null;
        if (TextUtils.isEmpty(this.f3547a)) {
            String userInfo = SDKLoginMgr.getInstance().getUserInfo("DVRDomain");
            this.f3547a = userInfo;
            if (TextUtils.isEmpty(userInfo)) {
                String userInfo2 = SDKLoginMgr.getInstance().getUserInfo("DVRDomainBackup");
                this.f3547a = userInfo2;
                if (TextUtils.isEmpty(userInfo2)) {
                    LogEx.d("SDKCloudDVRMgr", "ServerDomain has not set");
                    onDelScheduleReturnListener.onDelScheduleReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 7, 100)), "ServerDomain has not set", null);
                    return;
                }
            }
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3549c = sDKNetHTTPRequest;
        if (hashMap != null) {
            hashMap.put("UserID", SDKLoginMgr.getInstance().getUserID());
            hashMap.put("AuthInfo", a());
            a(hashMap);
            if (hashMap.containsKey("ScheduleID")) {
                strArr = hashMap.get("ScheduleID").split(",");
                hashMap.remove("ScheduleID");
            } else {
                strArr = null;
            }
            if (hashMap.containsKey("SeriesRec")) {
                strArr2 = hashMap.get("SeriesRec").split(",");
                hashMap.remove("SeriesRec");
            } else {
                strArr2 = null;
            }
            if (hashMap.containsKey("BeginTime")) {
                strArr3 = hashMap.get("BeginTime").split(",");
                hashMap.remove("BeginTime");
            } else {
                strArr3 = null;
            }
            if (hashMap.containsKey("Type")) {
                strArr4 = hashMap.get("Type").split(",");
                hashMap.remove("Type");
            }
            if (strArr == null || strArr.length == 0) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < strArr.length; i++) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("ScheduleID", strArr[i]);
                if (strArr2 != null && i < strArr2.length) {
                    hashMap2.put("SeriesRec", strArr2[i]);
                }
                if (strArr3 != null && i < strArr3.length) {
                    hashMap2.put("BeginTime", strArr3[i]);
                }
                if (strArr4 != null && i < strArr4.length) {
                    hashMap2.put("Type", strArr4[i]);
                }
                stringBuffer.append(b(hashMap2, "ScheduleInfo"));
            }
            hashMap.put("ScheduleList", stringBuffer.toString());
            sDKNetHTTPRequest.setBody(a(hashMap, "ScheduleDelReq"));
        }
        sDKNetHTTPRequest.startRequest(this.f3547a + HttpUrlConstants.SCHEDULE_DEL, "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.clouddvr.SDKCloudDVRMgr.7
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    String xml2json = ParseScheduleDelXML.xml2json(str);
                    JSONObject jSONObject = new JSONObject(xml2json);
                    onDelScheduleReturnListener.onDelScheduleReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), xml2json);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKCloudDVRMgr", "JSONException occur");
                    onDelScheduleReturnListener.onDelScheduleReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 7, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i2, String str) {
                LogEx.w("SDKCloudDVRMgr", "SDKNetHTTPRequest onFailReturn");
                onDelScheduleReturnListener.onDelScheduleReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 7, i2 % 1000)), str, null);
            }
        });
    }

    public void getEpisodeSchedule(HashMap<String, String> hashMap, final OnGetEpisodeScheduleReturnListener onGetEpisodeScheduleReturnListener) {
        if (onGetEpisodeScheduleReturnListener == null) {
            LogEx.w("SDKCloudDVRMgr", "listener is null");
            return;
        }
        if (TextUtils.isEmpty(this.f3547a)) {
            String userInfo = SDKLoginMgr.getInstance().getUserInfo("DVRDomain");
            this.f3547a = userInfo;
            if (TextUtils.isEmpty(userInfo)) {
                String userInfo2 = SDKLoginMgr.getInstance().getUserInfo("DVRDomainBackup");
                this.f3547a = userInfo2;
                if (TextUtils.isEmpty(userInfo2)) {
                    LogEx.d("SDKCloudDVRMgr", "ServerDomain has not set");
                    onGetEpisodeScheduleReturnListener.onGetEpisodeScheduleReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 2, 100)), "ServerDomain has not set", null);
                    return;
                }
            }
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3549c = sDKNetHTTPRequest;
        if (hashMap != null) {
            hashMap.put("UserID", SDKLoginMgr.getInstance().getUserID());
            hashMap.put("AuthInfo", a());
            a(hashMap);
            sDKNetHTTPRequest.setBody(a(hashMap, "EpisodeScheduleQueryReq"));
        }
        sDKNetHTTPRequest.startRequest(this.f3547a + HttpUrlConstants.EPISODE_SCHEDULE_QUERY, "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.clouddvr.SDKCloudDVRMgr.2
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    String xml2json = ParseEpisodeScheduleQueryXML.xml2json(str);
                    JSONObject jSONObject = new JSONObject(xml2json);
                    onGetEpisodeScheduleReturnListener.onGetEpisodeScheduleReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), xml2json);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKCloudDVRMgr", "JSONException occur");
                    onGetEpisodeScheduleReturnListener.onGetEpisodeScheduleReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 2, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKCloudDVRMgr", "SDKNetHTTPRequest onFailReturn");
                onGetEpisodeScheduleReturnListener.onGetEpisodeScheduleReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 2, i % 1000)), str, null);
            }
        });
    }

    public void getPrevueState(HashMap<String, String> hashMap, final OnGetPrevueStateReturnListener onGetPrevueStateReturnListener) {
        String[] split;
        if (onGetPrevueStateReturnListener == null) {
            LogEx.w("SDKCloudDVRMgr", "listener is null");
            return;
        }
        if (TextUtils.isEmpty(this.f3547a)) {
            String userInfo = SDKLoginMgr.getInstance().getUserInfo("DVRDomain");
            this.f3547a = userInfo;
            if (TextUtils.isEmpty(userInfo)) {
                String userInfo2 = SDKLoginMgr.getInstance().getUserInfo("DVRDomainBackup");
                this.f3547a = userInfo2;
                if (TextUtils.isEmpty(userInfo2)) {
                    LogEx.d("SDKCloudDVRMgr", "ServerDomain has not set");
                    onGetPrevueStateReturnListener.onGetPrevueStateReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 5, 100)), "ServerDomain has not set", null);
                    return;
                }
            }
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3549c = sDKNetHTTPRequest;
        if (hashMap != null) {
            hashMap.put("UserID", SDKLoginMgr.getInstance().getUserID());
            hashMap.put("AuthInfo", a());
            if (hashMap.containsKey("prevueid")) {
                String str = hashMap.get("prevueid");
                if (str != null && (split = str.split(",")) != null && split.length > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (String str2 : split) {
                        sb.append("<PrevueID>");
                        sb.append(str2.trim());
                        sb.append("</PrevueID>");
                    }
                    hashMap.put("PrevueList", sb.toString());
                }
                hashMap.remove("prevueid");
            }
            a(hashMap);
            sDKNetHTTPRequest.setBody(a(hashMap, "PrevueStateQueryReq"));
        }
        sDKNetHTTPRequest.startRequest(this.f3547a + HttpUrlConstants.PREVUE_STATE_QUERY, "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.clouddvr.SDKCloudDVRMgr.5
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str3) {
                try {
                    String xml2json = ParsePrevueStateQueryXML.xml2json(str3);
                    JSONObject jSONObject = new JSONObject(xml2json);
                    onGetPrevueStateReturnListener.onGetPrevueStateReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), xml2json);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKCloudDVRMgr", "JSONException occur");
                    onGetPrevueStateReturnListener.onGetPrevueStateReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 5, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str3) {
                LogEx.w("SDKCloudDVRMgr", "SDKNetHTTPRequest onFailReturn");
                onGetPrevueStateReturnListener.onGetPrevueStateReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 5, i % 1000)), str3, null);
            }
        });
    }

    public void getRecordDetail(HashMap<String, String> hashMap, final OnGetRecordDetailReturnListener onGetRecordDetailReturnListener) {
        if (onGetRecordDetailReturnListener == null) {
            LogEx.w("SDKCloudDVRMgr", "listener is null");
            return;
        }
        if (TextUtils.isEmpty(this.f3548b)) {
            String userInfo = SDKLoginMgr.getInstance().getUserInfo("RECORDDomain");
            this.f3548b = userInfo;
            if (TextUtils.isEmpty(userInfo)) {
                String userInfo2 = SDKLoginMgr.getInstance().getUserInfo("RECORDDomainBackup");
                this.f3548b = userInfo2;
                if (TextUtils.isEmpty(userInfo2)) {
                    LogEx.d("SDKCloudDVRMgr", "ServerDomain has not set");
                    onGetRecordDetailReturnListener.onGetRecordDetailReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 10, 100)), "ServerDomain has not set", null);
                    return;
                }
            }
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3549c = sDKNetHTTPRequest;
        if (hashMap != null) {
            hashMap.put("userid", SDKLoginMgr.getInstance().getUserID());
            hashMap.put("authinfo", a());
            sDKNetHTTPRequest.setBody(a(hashMap, "RecordDetailQueryReq"));
        }
        sDKNetHTTPRequest.startRequest(this.f3548b + HttpUrlConstants.RECORD_DETAIL_QUERY, "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.clouddvr.SDKCloudDVRMgr.10
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    String xml2json = ParseRecordDetailQueryXML.xml2json(str);
                    JSONObject jSONObject = new JSONObject(xml2json);
                    onGetRecordDetailReturnListener.onGetRecordDetailReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), xml2json);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKCloudDVRMgr", "JSONException occur");
                    onGetRecordDetailReturnListener.onGetRecordDetailReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 10, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKCloudDVRMgr", "SDKNetHTTPRequest onFailReturn");
                onGetRecordDetailReturnListener.onGetRecordDetailReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 10, i % 1000)), str, null);
            }
        });
    }

    public void getRecordList(HashMap<String, String> hashMap, final OnGetRecordListReturnListener onGetRecordListReturnListener) {
        if (onGetRecordListReturnListener == null) {
            LogEx.w("SDKCloudDVRMgr", "listener is null");
            return;
        }
        if (TextUtils.isEmpty(this.f3548b)) {
            String userInfo = SDKLoginMgr.getInstance().getUserInfo("RECORDDomain");
            this.f3548b = userInfo;
            if (TextUtils.isEmpty(userInfo)) {
                String userInfo2 = SDKLoginMgr.getInstance().getUserInfo("RECORDDomainBackup");
                this.f3548b = userInfo2;
                if (TextUtils.isEmpty(userInfo2)) {
                    LogEx.d("SDKCloudDVRMgr", "ServerDomain has not set");
                    onGetRecordListReturnListener.onGetRecordListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 9, 100)), "ServerDomain has not set", null);
                    return;
                }
            }
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3549c = sDKNetHTTPRequest;
        if (hashMap != null) {
            hashMap.put("userid", SDKLoginMgr.getInstance().getUserID());
            hashMap.put(ParamConst.VOD_GET_GENRE_LIST_REQ_PARENTID, SDKLoginMgr.getInstance().getUserInfo("FatherUserID"));
            hashMap.put("authinfo", a());
            sDKNetHTTPRequest.setBody(a(hashMap, "RecordListQueryReq"));
        }
        sDKNetHTTPRequest.startRequest(this.f3548b + HttpUrlConstants.RECORD_LIST_QUERY, "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.clouddvr.SDKCloudDVRMgr.9
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    String xml2json = ParseRecordListQueryXML.xml2json(str);
                    JSONObject jSONObject = new JSONObject(xml2json);
                    onGetRecordListReturnListener.onGetRecordListReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), xml2json);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKCloudDVRMgr", "JSONException occur");
                    onGetRecordListReturnListener.onGetRecordListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 9, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKCloudDVRMgr", "SDKNetHTTPRequest onFailReturn");
                onGetRecordListReturnListener.onGetRecordListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 9, i % 1000)), str, null);
            }
        });
    }

    public void getScheduleInfo(HashMap<String, String> hashMap, final OnGetScheduleInfoReturnListener onGetScheduleInfoReturnListener) {
        if (onGetScheduleInfoReturnListener == null) {
            LogEx.w("SDKCloudDVRMgr", "listener is null");
            return;
        }
        if (TextUtils.isEmpty(this.f3547a)) {
            String userInfo = SDKLoginMgr.getInstance().getUserInfo("DVRDomain");
            this.f3547a = userInfo;
            if (TextUtils.isEmpty(userInfo)) {
                String userInfo2 = SDKLoginMgr.getInstance().getUserInfo("DVRDomainBackup");
                this.f3547a = userInfo2;
                if (TextUtils.isEmpty(userInfo2)) {
                    LogEx.d("SDKCloudDVRMgr", "ServerDomain has not set");
                    onGetScheduleInfoReturnListener.onGetScheduleInfoReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 3, 100)), "ServerDomain has not set", null);
                    return;
                }
            }
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3549c = sDKNetHTTPRequest;
        if (hashMap != null) {
            hashMap.put("UserID", SDKLoginMgr.getInstance().getUserID());
            hashMap.put("AuthInfo", a());
            a(hashMap);
            sDKNetHTTPRequest.setBody(a(hashMap, HttpUrlConstants.SCHEDULE_INFO_QUERY));
        }
        sDKNetHTTPRequest.startRequest(this.f3547a + HttpUrlConstants.SCHEDULE_INFO_QUERY, "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.clouddvr.SDKCloudDVRMgr.3
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    String xml2json = ParseScheduleInfoQueryXML.xml2json(str);
                    JSONObject jSONObject = new JSONObject(xml2json);
                    onGetScheduleInfoReturnListener.onGetScheduleInfoReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), xml2json);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKCloudDVRMgr", "JSONException occur");
                    onGetScheduleInfoReturnListener.onGetScheduleInfoReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 3, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKCloudDVRMgr", "SDKNetHTTPRequest onFailReturn");
                onGetScheduleInfoReturnListener.onGetScheduleInfoReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 3, i % 1000)), str, null);
            }
        });
    }

    public void getScheduleList(HashMap<String, String> hashMap, final OnGetScheduleListReturnListener onGetScheduleListReturnListener) {
        if (onGetScheduleListReturnListener == null) {
            LogEx.w("SDKCloudDVRMgr", "listener is null");
            return;
        }
        if (TextUtils.isEmpty(this.f3547a)) {
            String userInfo = SDKLoginMgr.getInstance().getUserInfo("DVRDomain");
            this.f3547a = userInfo;
            if (TextUtils.isEmpty(userInfo)) {
                String userInfo2 = SDKLoginMgr.getInstance().getUserInfo("DVRDomainBackup");
                this.f3547a = userInfo2;
                if (TextUtils.isEmpty(userInfo2)) {
                    LogEx.d("SDKCloudDVRMgr", "ServerDomain has not set");
                    onGetScheduleListReturnListener.onGetScheduleListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 1, 100)), "ServerDomain has not set", null);
                    return;
                }
            }
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3549c = sDKNetHTTPRequest;
        if (hashMap != null) {
            hashMap.put("UserID", SDKLoginMgr.getInstance().getUserID());
            hashMap.put("AuthInfo", a());
            a(hashMap);
            sDKNetHTTPRequest.setBody(a(hashMap, "ScheduleListQueryReq"));
        }
        sDKNetHTTPRequest.startRequest(this.f3547a + HttpUrlConstants.SCHEDULE_LIST_QUERY, "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.clouddvr.SDKCloudDVRMgr.1
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    String xml2json = ParseScheduleListQueryXML.xml2json(str);
                    JSONObject jSONObject = new JSONObject(xml2json);
                    onGetScheduleListReturnListener.onGetScheduleListReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), xml2json);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKCloudDVRMgr", "JSONException occur");
                    onGetScheduleListReturnListener.onGetScheduleListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 1, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKCloudDVRMgr", "SDKNetHTTPRequest onFailReturn");
                onGetScheduleListReturnListener.onGetScheduleListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 1, i % 1000)), str, null);
            }
        });
    }

    public void getSeriesScheduleInfo(HashMap<String, String> hashMap, final OnGetSeriesScheduleInfoReturnListener onGetSeriesScheduleInfoReturnListener) {
        if (onGetSeriesScheduleInfoReturnListener == null) {
            LogEx.w("SDKCloudDVRMgr", "listener is null");
            return;
        }
        if (TextUtils.isEmpty(this.f3547a)) {
            String userInfo = SDKLoginMgr.getInstance().getUserInfo("DVRDomain");
            this.f3547a = userInfo;
            if (TextUtils.isEmpty(userInfo)) {
                String userInfo2 = SDKLoginMgr.getInstance().getUserInfo("DVRDomainBackup");
                this.f3547a = userInfo2;
                if (TextUtils.isEmpty(userInfo2)) {
                    LogEx.d("SDKCloudDVRMgr", "ServerDomain has not set");
                    onGetSeriesScheduleInfoReturnListener.onGetSeriesScheduleInfoReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 4, 100)), "ServerDomain has not set", null);
                    return;
                }
            }
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3549c = sDKNetHTTPRequest;
        if (hashMap != null) {
            hashMap.put("UserID", SDKLoginMgr.getInstance().getUserID());
            hashMap.put("AuthInfo", a());
            a(hashMap);
            sDKNetHTTPRequest.setBody(a(hashMap, HttpUrlConstants.SERIES_SCHEDULE_INFO_QUERY));
        }
        sDKNetHTTPRequest.startRequest(this.f3547a + HttpUrlConstants.SERIES_SCHEDULE_INFO_QUERY, "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.clouddvr.SDKCloudDVRMgr.4
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    String xml2json = ParseSeriesScheduleInfoQueryXML.xml2json(str);
                    JSONObject jSONObject = new JSONObject(xml2json);
                    onGetSeriesScheduleInfoReturnListener.onGetSeriesScheduleInfoReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), xml2json);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKCloudDVRMgr", "JSONException occur");
                    onGetSeriesScheduleInfoReturnListener.onGetSeriesScheduleInfoReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 4, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKCloudDVRMgr", "SDKNetHTTPRequest onFailReturn");
                onGetSeriesScheduleInfoReturnListener.onGetSeriesScheduleInfoReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 4, i % 1000)), str, null);
            }
        });
    }

    public void getUserVolume(final OnGetUserVolumeReturnListener onGetUserVolumeReturnListener) {
        if (onGetUserVolumeReturnListener == null) {
            LogEx.w("SDKCloudDVRMgr", "listener is null");
            return;
        }
        if (TextUtils.isEmpty(this.f3548b)) {
            String userInfo = SDKLoginMgr.getInstance().getUserInfo("RECORDDomain");
            this.f3548b = userInfo;
            if (TextUtils.isEmpty(userInfo)) {
                String userInfo2 = SDKLoginMgr.getInstance().getUserInfo("RECORDDomainBackup");
                this.f3548b = userInfo2;
                if (TextUtils.isEmpty(userInfo2)) {
                    LogEx.d("SDKCloudDVRMgr", "ServerDomain has not set");
                    onGetUserVolumeReturnListener.onGetUserVolumeReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 12, 100)), "ServerDomain has not set", null);
                    return;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3548b);
        sb.append(HttpUrlConstants.GET_USER_VOLUME);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3549c = sDKNetHTTPRequest;
        HashMap hashMap = new HashMap();
        hashMap.put("userid", SDKLoginMgr.getInstance().getUserID());
        hashMap.put(ParamConst.VOD_GET_GENRE_LIST_REQ_PARENTID, SDKLoginMgr.getInstance().getUserInfo("FatherUserID"));
        hashMap.put("AuthInfo", a());
        String a2 = a(hashMap, "GetUserVolumeReq");
        LogEx.d("SDKCloudDVRMgr", "requestxml:" + a2);
        sDKNetHTTPRequest.setBody(a2);
        sDKNetHTTPRequest.startRequest(sb.toString(), "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.clouddvr.SDKCloudDVRMgr.12
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    String xml2json = ParseGetUserVolumeXML.xml2json(str);
                    JSONObject jSONObject = new JSONObject(xml2json);
                    onGetUserVolumeReturnListener.onGetUserVolumeReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), xml2json);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKCloudDVRMgr", "JSONException occur");
                    onGetUserVolumeReturnListener.onGetUserVolumeReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 12, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKCloudDVRMgr", "SDKNetHTTPRequest onFailReturn");
                onGetUserVolumeReturnListener.onGetUserVolumeReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 12, i % 1000)), str, null);
            }
        });
    }

    public void modifyRecord(HashMap<String, String> hashMap, final OnModifyRecordReturnListener onModifyRecordReturnListener) {
        if (onModifyRecordReturnListener == null) {
            LogEx.w("SDKCloudDVRMgr", "listener is null");
            return;
        }
        if (TextUtils.isEmpty(this.f3548b)) {
            String userInfo = SDKLoginMgr.getInstance().getUserInfo("RECORDDomain");
            this.f3548b = userInfo;
            if (TextUtils.isEmpty(userInfo)) {
                String userInfo2 = SDKLoginMgr.getInstance().getUserInfo("RECORDDomainBackup");
                this.f3548b = userInfo2;
                if (TextUtils.isEmpty(userInfo2)) {
                    LogEx.d("SDKCloudDVRMgr", "ServerDomain has not set");
                    onModifyRecordReturnListener.onModifyRecordReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 14, 100)), "ServerDomain has not set");
                    return;
                }
            }
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3549c = sDKNetHTTPRequest;
        if (hashMap != null) {
            hashMap.put("userid", SDKLoginMgr.getInstance().getUserID());
            hashMap.put(ParamConst.VOD_GET_GENRE_LIST_REQ_PARENTID, SDKLoginMgr.getInstance().getUserInfo("FatherUserID"));
            hashMap.put("authinfo", a());
            sDKNetHTTPRequest.setBody(a(hashMap, "RecordModReq"));
        }
        sDKNetHTTPRequest.startRequest(this.f3548b + HttpUrlConstants.RECORD_MOD, "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.clouddvr.SDKCloudDVRMgr.14
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(ParseScheduleModXML.xml2json(str));
                    onModifyRecordReturnListener.onModifyRecordReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKCloudDVRMgr", "JSONException occur");
                    onModifyRecordReturnListener.onModifyRecordReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 14, 202)), "JSONException occur");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKCloudDVRMgr", "SDKNetHTTPRequest onFailReturn");
                onModifyRecordReturnListener.onModifyRecordReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 14, i % 1000)), str);
            }
        });
    }

    public void modifySchedule(HashMap<String, String> hashMap, final OnModifyScheduleReturnListener onModifyScheduleReturnListener) {
        if (onModifyScheduleReturnListener == null) {
            LogEx.w("SDKCloudDVRMgr", "listener is null");
            return;
        }
        if (TextUtils.isEmpty(this.f3547a)) {
            String userInfo = SDKLoginMgr.getInstance().getUserInfo("DVRDomain");
            this.f3547a = userInfo;
            if (TextUtils.isEmpty(userInfo)) {
                String userInfo2 = SDKLoginMgr.getInstance().getUserInfo("DVRDomainBackup");
                this.f3547a = userInfo2;
                if (TextUtils.isEmpty(userInfo2)) {
                    LogEx.d("SDKCloudDVRMgr", "ServerDomain has not set");
                    onModifyScheduleReturnListener.onModifyScheduleReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 8, 100)), "ServerDomain has not set", null);
                    return;
                }
            }
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3549c = sDKNetHTTPRequest;
        if (hashMap != null) {
            hashMap.put("UserID", SDKLoginMgr.getInstance().getUserID());
            hashMap.put("AuthInfo", a());
            hashMap.put(IIPTVLogin.LOGIN_PARAM_MAC, SDKLoginMgr.getInstance().getUserInfo(ParamConst.LOGIN_PORTALAUTH_RSP_STBMAC));
            a(hashMap);
            sDKNetHTTPRequest.setBody(a(hashMap, "ScheduleModReq"));
        }
        sDKNetHTTPRequest.startRequest(this.f3547a + HttpUrlConstants.SCHEDULE_MOD, "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.clouddvr.SDKCloudDVRMgr.8
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    String xml2json = ParseRecordModXML.xml2json(str);
                    JSONObject jSONObject = new JSONObject(xml2json);
                    onModifyScheduleReturnListener.onModifyScheduleReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), xml2json);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKCloudDVRMgr", "JSONException occur");
                    onModifyScheduleReturnListener.onModifyScheduleReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 8, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKCloudDVRMgr", "SDKNetHTTPRequest onFailReturn");
                onModifyScheduleReturnListener.onModifyScheduleReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 8, i % 1000)), str, null);
            }
        });
    }

    public void operateDVRBookMark(HashMap<String, String> hashMap, final OnOperateDVRBookMarkReturnListener onOperateDVRBookMarkReturnListener) {
        if (onOperateDVRBookMarkReturnListener == null) {
            LogEx.w("SDKCloudDVRMgr", "listener is null");
            return;
        }
        if (TextUtils.isEmpty(this.f3548b)) {
            String userInfo = SDKLoginMgr.getInstance().getUserInfo("RECORDDomain");
            this.f3548b = userInfo;
            if (TextUtils.isEmpty(userInfo)) {
                String userInfo2 = SDKLoginMgr.getInstance().getUserInfo("RECORDDomainBackup");
                this.f3548b = userInfo2;
                if (TextUtils.isEmpty(userInfo2)) {
                    LogEx.d("SDKCloudDVRMgr", "ServerDomain has not set");
                    onOperateDVRBookMarkReturnListener.onOperateDVRBookMarkReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 13, 100)), "ServerDomain has not set");
                    return;
                }
            }
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3549c = sDKNetHTTPRequest;
        if (hashMap != null) {
            hashMap.put("userid", SDKLoginMgr.getInstance().getUserID());
            hashMap.put(ParamConst.VOD_GET_GENRE_LIST_REQ_PARENTID, SDKLoginMgr.getInstance().getUserInfo("FatherUserID"));
            hashMap.put("authinfo", a());
            sDKNetHTTPRequest.setBody(a(hashMap, "DVRBookmarkReq"));
        }
        sDKNetHTTPRequest.startRequest(this.f3548b + HttpUrlConstants.DVR_BOOKMARK, "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.clouddvr.SDKCloudDVRMgr.13
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(ParseDVRBookmarkXML.xml2json(str));
                    onOperateDVRBookMarkReturnListener.onOperateDVRBookMarkReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKCloudDVRMgr", "JSONException occur");
                    onOperateDVRBookMarkReturnListener.onOperateDVRBookMarkReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 13, 202)), "JSONException occur");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKCloudDVRMgr", "SDKNetHTTPRequest onFailReturn");
                onOperateDVRBookMarkReturnListener.onOperateDVRBookMarkReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_CLOUDVR_MODELCODE, 13, i % 1000)), str);
            }
        });
    }

    public void setDVRSeverDomain(String str) {
        this.f3547a = str;
    }

    public void setRecordSeverDomain(String str) {
        this.f3548b = str;
    }

    private String a(Map<String, String> map, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        if (!TextUtils.isEmpty(str)) {
            stringBuffer.append("<");
            stringBuffer.append(str);
            stringBuffer.append(">");
        }
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        if (entrySet != null) {
            for (Map.Entry<String, String> entry : entrySet) {
                String key = entry.getKey();
                String value = entry.getValue();
                LogEx.d("SDKCloudDVRMgr", "key === " + key);
                LogEx.d("SDKCloudDVRMgr", "value === " + value);
                stringBuffer.append("<");
                stringBuffer.append(key);
                stringBuffer.append(">");
                stringBuffer.append(value);
                stringBuffer.append("</");
                stringBuffer.append(key);
                stringBuffer.append(">");
            }
        }
        if (!TextUtils.isEmpty(str)) {
            stringBuffer.append("</");
            stringBuffer.append(str);
            stringBuffer.append(">");
        }
        LogEx.d("SDKCloudDVRMgr", "xml === " + stringBuffer.toString());
        return stringBuffer.toString();
    }

    private Map<String, String> a(Map<String, String> map) {
        if (map.containsKey("seriesheadid")) {
            map.put("SeriesHeadID", map.get("seriesheadid"));
            map.remove("seriesheadid");
        }
        if (map.containsKey("recordstarttime")) {
            map.put("RecordStartTime", map.get("recordstarttime"));
            map.remove("recordstarttime");
        }
        if (map.containsKey("rangeday")) {
            map.put("RangeDay", map.get("rangeday"));
            map.remove("rangeday");
        }
        if (map.containsKey("type")) {
            map.put("Type", map.get("type"));
            map.remove("type");
        }
        if (map.containsKey("begintime")) {
            map.put("BeginTime", map.get("begintime"));
            map.remove("begintime");
        }
        if (map.containsKey("scheduleid")) {
            map.put("ScheduleID", map.get("scheduleid"));
            map.remove("scheduleid");
        }
        if (map.containsKey("searchdate")) {
            map.put("SearchDate", map.get("searchdate"));
            map.remove("searchdate");
        }
        if (map.containsKey("sorttype")) {
            map.put("SortType", map.get("sorttype"));
            map.remove("sorttype");
        }
        if (map.containsKey("numperpage")) {
            map.put("RecordPerPage", map.get("numperpage"));
            map.remove("numperpage");
        }
        if (map.containsKey("pageno")) {
            map.put("PageNo", map.get("pageno"));
            map.remove("pageno");
        }
        if (map.containsKey("prevueid")) {
            map.put("Prevueid", map.get("prevueid"));
            map.remove("prevueid");
        }
        if (map.containsKey("programid")) {
            map.put("ProgramID", map.get("programid"));
            map.remove("programid");
        }
        if (map.containsKey("seriesrec")) {
            map.put("SeriesRec", map.get("seriesrec"));
            map.remove("seriesrec");
        }
        if (map.containsKey("channelmode")) {
            map.put("ChannelMode", map.get("channelmode"));
            map.remove("channelmode");
        }
        if (map.containsKey("recordtype")) {
            map.put("RecordType", map.get("recordtype"));
            map.remove("recordtype");
        }
        if (map.containsKey("rectimebefore")) {
            map.put("Rectimebefore", map.get("rectimebefore"));
            map.remove("rectimebefore");
        }
        if (map.containsKey("rectimeafter")) {
            map.put("Rectimeafter", map.get("rectimeafter"));
            map.remove("rectimeafter");
        }
        if (map.containsKey("recmode")) {
            map.put("RecMode", map.get("recmode"));
            map.remove("recmode");
        }
        if (map.containsKey("keepatmost")) {
            map.put("KeepAtMost", map.get("keepatmost"));
            map.remove("keepatmost");
        }
        if (map.containsKey("episodetype")) {
            map.put("EpisodeType", map.get("episodetype"));
            map.remove("episodetype");
        }
        if (map.containsKey("starttimeutc")) {
            map.put("StartTimeUTC", map.get("starttimeutc"));
            map.remove("starttimeutc");
        }
        if (map.containsKey("endtimeutc")) {
            map.put("EndTimeUTC", map.get("endtimeutc"));
            map.remove("endtimeutc");
        }
        if (map.containsKey("channelcode")) {
            map.put(ParamConst.SEARCH_RSP_ITEM_CHANNELCODE, map.get("channelcode"));
            map.remove("channelcode");
        }
        if (map.containsKey("profilecode")) {
            map.put("ProfileCode", map.get("profilecode"));
            map.remove("profilecode");
        }
        return map;
    }
}
