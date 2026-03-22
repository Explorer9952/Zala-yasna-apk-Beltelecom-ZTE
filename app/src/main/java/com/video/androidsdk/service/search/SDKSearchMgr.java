package com.video.androidsdk.service.search;

import android.text.TextUtils;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.login.impl.IIPTVLogin;
import com.video.androidsdk.service.comm.HttpUrlConstants;
import com.video.androidsdk.service.comm.ParamConst;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SDKSearchMgr {

    /* renamed from: a, reason: collision with root package name */
    private String f3737a;

    /* renamed from: b, reason: collision with root package name */
    private SDKNetHTTPRequest f3738b;

    /* loaded from: classes.dex */
    public interface OnSearchHintKeyWordListReturnListener {
        void onSearchHintKeyWordListReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnSearchHotListReturnListener {
        void onSearchHotListReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnSearchProgramListByEPGReturnListener {
        void onSearchProgramListReturn(String str, String str2, String str3);
    }

    /* loaded from: classes.dex */
    public interface OnSearchProgramListReturnListener {
        void onSearchProgramListReturn(String str, String str2, String str3);
    }

    public void cancelRequest() {
        SDKNetHTTPRequest sDKNetHTTPRequest = this.f3738b;
        if (sDKNetHTTPRequest != null) {
            sDKNetHTTPRequest.cancelRequest();
        }
    }

    public void searchHintKeyWordList(HashMap<String, String> hashMap, final OnSearchHintKeyWordListReturnListener onSearchHintKeyWordListReturnListener) {
        if (onSearchHintKeyWordListReturnListener == null) {
            LogEx.w("SDKSearchMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            onSearchHintKeyWordListReturnListener.onSearchHintKeyWordListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_SEARCH_MODELCODE, 2, 2)), "params is null", null);
            return;
        }
        if (TextUtils.isEmpty(this.f3737a)) {
            LogEx.e("SDKSearchMgr", "ServerDomain is null");
            onSearchHintKeyWordListReturnListener.onSearchHintKeyWordListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_SEARCH_MODELCODE, 2, 2)), "ServerDomain is null", null);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("UserCode", SDKLoginMgr.getInstance().getUserID());
            jSONObject.put("TeamId", SDKLoginMgr.getInstance().getUserInfo("TeamID"));
            jSONObject.put("Condition", hashMap.get("condition"));
            jSONObject.put("ConditionType", hashMap.get("conditiontype"));
            jSONObject.put("SearchType", hashMap.get("searchtype"));
            jSONObject.put("PlatformId", hashMap.get("platformid"));
            jSONObject.put("LanguageType", hashMap.get("languagetype"));
            jSONObject.put("PageNum", hashMap.get("pageno"));
            jSONObject.put("PageRows", hashMap.get("numperpage"));
            if (hashMap.containsKey("filtertype")) {
                jSONObject.put("FilterType", hashMap.get("filtertype"));
            }
            if (hashMap.containsKey("sorttype")) {
                jSONObject.put("SortType", hashMap.get("sorttype"));
            }
            if (hashMap.containsKey("operatorflag")) {
                jSONObject.put("OperatorFlag", hashMap.get("operatorflag"));
            }
            if (hashMap.containsKey("groupflag")) {
                jSONObject.put(ParamConst.SEARCH_REQ_KEYWORDSEARCH_GROUPFLAG, hashMap.get("groupflag"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3738b = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader(IIPTVLogin.LOGIN_PARAM_CHARSET, "utf-8");
        sDKNetHTTPRequest.setBody(jSONObject.toString());
        sDKNetHTTPRequest.startRequest(this.f3737a + HttpUrlConstants.SEARCH_HINTKEYWORD_LIST, "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.search.SDKSearchMgr.2
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str);
                    onSearchHintKeyWordListReturnListener.onSearchHintKeyWordListReturn(jSONObject2.optString("ErrorCode"), jSONObject2.optString("Description"), SDKSearchMgr.this.a(str));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    LogEx.w("SDKSearchMgr", "JSONException occur");
                    onSearchHintKeyWordListReturnListener.onSearchHintKeyWordListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_SEARCH_MODELCODE, 2, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKSearchMgr", "SDKNetHTTPRequest onFailReturn");
                onSearchHintKeyWordListReturnListener.onSearchHintKeyWordListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_SEARCH_MODELCODE, 2, i % 1000)), str, null);
            }
        });
    }

    public void searchHotList(HashMap<String, String> hashMap, final OnSearchHotListReturnListener onSearchHotListReturnListener) {
        if (onSearchHotListReturnListener == null) {
            LogEx.w("SDKSearchMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            onSearchHotListReturnListener.onSearchHotListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_SEARCH_MODELCODE, 3, 2)), "params is null", null);
            return;
        }
        if (TextUtils.isEmpty(this.f3737a)) {
            LogEx.e("SDKSearchMgr", "ServerDomain is null");
            onSearchHotListReturnListener.onSearchHotListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_SEARCH_MODELCODE, 3, 2)), "ServerDomain is null", null);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("UserCode", SDKLoginMgr.getInstance().getUserID());
            jSONObject.put("TeamId", SDKLoginMgr.getInstance().getUserInfo("TeamID"));
            jSONObject.put("PlatformId", hashMap.get("platformid"));
            jSONObject.put("LanguageType", hashMap.get("languagetype"));
            if (hashMap.containsKey("cpcode")) {
                jSONObject.put("CpCode", hashMap.get("cpcode"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3738b = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader(IIPTVLogin.LOGIN_PARAM_CHARSET, "utf-8");
        sDKNetHTTPRequest.setBody(jSONObject.toString());
        sDKNetHTTPRequest.startRequest(this.f3737a + HttpUrlConstants.SEARCH_HOT_LIST, "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.search.SDKSearchMgr.3
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str);
                    onSearchHotListReturnListener.onSearchHotListReturn(jSONObject2.optString("ErrorCode"), jSONObject2.optString("Description"), SDKSearchMgr.this.a(str));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    LogEx.w("SDKSearchMgr", "JSONException occur");
                    onSearchHotListReturnListener.onSearchHotListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_SEARCH_MODELCODE, 3, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKSearchMgr", "SDKNetHTTPRequest onFailReturn");
                onSearchHotListReturnListener.onSearchHotListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_SEARCH_MODELCODE, 3, i % 1000)), str, null);
            }
        });
    }

    public void searchProgramList(HashMap<String, String> hashMap, final OnSearchProgramListReturnListener onSearchProgramListReturnListener) {
        if (onSearchProgramListReturnListener == null) {
            LogEx.w("SDKSearchMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            onSearchProgramListReturnListener.onSearchProgramListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_SEARCH_MODELCODE, 1, 2)), "params is null", null);
            return;
        }
        if (TextUtils.isEmpty(this.f3737a)) {
            LogEx.e("SDKSearchMgr", "ServerDomain is null");
            onSearchProgramListReturnListener.onSearchProgramListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_SEARCH_MODELCODE, 1, 2)), "ServerDomain is null", null);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (hashMap.containsKey("usercode")) {
                jSONObject.put("UserCode", hashMap.get("usercode"));
            } else {
                jSONObject.put("UserCode", SDKLoginMgr.getInstance().getUserID());
            }
            if (hashMap.containsKey("teamid")) {
                jSONObject.put("TeamId", hashMap.get("teamid"));
            } else {
                jSONObject.put("TeamId", SDKLoginMgr.getInstance().getUserInfo("TeamID"));
            }
            jSONObject.put("Condition", hashMap.get("condition"));
            jSONObject.put("ConditionType", hashMap.get("conditiontype"));
            jSONObject.put("SearchType", hashMap.get("searchtype"));
            jSONObject.put("PlatformId", hashMap.get("platformid"));
            jSONObject.put("LanguageType", hashMap.get("languagetype"));
            jSONObject.put("PageNum", hashMap.get("pageno"));
            jSONObject.put("PageRows", hashMap.get("numperpage"));
            jSONObject.put("ContentType", hashMap.get("contenttype"));
            if (hashMap.containsKey("subtype")) {
                jSONObject.put("SubType", hashMap.get("subtype"));
            }
            if (hashMap.containsKey("filtertype")) {
                jSONObject.put("FilterType", hashMap.get("filtertype"));
            }
            if (hashMap.containsKey("genre")) {
                jSONObject.put("Genre", hashMap.get("genre"));
            }
            if (hashMap.containsKey("subgenre")) {
                jSONObject.put("SubGenre", hashMap.get("subgenre"));
            }
            if (hashMap.containsKey("keywords")) {
                jSONObject.put(ParamConst.SEARCH_REQ_KEYWORDS, hashMap.get("keywords"));
            }
            if (hashMap.containsKey("contentcode")) {
                jSONObject.put("ContentCode", hashMap.get("contentcode"));
            }
            if (hashMap.containsKey("uncontentcode")) {
                jSONObject.put("UnContentCode", hashMap.get("uncontentcode"));
            }
            if (hashMap.containsKey("showtime")) {
                jSONObject.put(ParamConst.SEARCH_REQ_SHOWTIME, hashMap.get("showtime"));
            }
            if (hashMap.containsKey("starttime")) {
                jSONObject.put("StartTime", hashMap.get("starttime"));
            }
            if (hashMap.containsKey("endtime")) {
                jSONObject.put("EndTime", hashMap.get("endtime"));
            }
            if (hashMap.containsKey("ordertype")) {
                jSONObject.put("SortType", hashMap.get("ordertype"));
            }
            jSONObject.put("MediaServices", hashMap.get("mediaservices"));
            if (hashMap.containsKey("actor")) {
                jSONObject.put("Actor", hashMap.get("actor"));
            }
            if (hashMap.containsKey("director")) {
                jSONObject.put("Director", hashMap.get("director"));
            }
            if (hashMap.containsKey("prevuecode")) {
                jSONObject.put("PrevueCode", hashMap.get("prevuecode"));
            }
            if (hashMap.containsKey("countryname")) {
                jSONObject.put("CountryName", hashMap.get("countryname"));
            }
            if (hashMap.containsKey(ParamConst.CHANNEL_PREVUE_INFO_RSP_RELEASEYEAR)) {
                jSONObject.put("ReleaseYear", hashMap.get(ParamConst.CHANNEL_PREVUE_INFO_RSP_RELEASEYEAR));
            }
            if (hashMap.containsKey("releaseyearmin")) {
                jSONObject.put(ParamConst.SEARCH_REQ_RELEASEYEARMIN, hashMap.get("releaseyearmin"));
            }
            if (hashMap.containsKey("releaseyearmax")) {
                jSONObject.put(ParamConst.SEARCH_REQ_RELEASEYEARMAX, hashMap.get("releaseyearmax"));
            }
            if (hashMap.containsKey("operatorflag")) {
                jSONObject.put("OperatorFlag", hashMap.get("operatorflag"));
            }
            if (hashMap.containsKey("ratingid")) {
                jSONObject.put("RatingId", hashMap.get("ratingid"));
            }
            if (hashMap.containsKey("seriestype")) {
                jSONObject.put("SeriesType", hashMap.get("seriestype"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3738b = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader(IIPTVLogin.LOGIN_PARAM_CHARSET, "utf-8");
        sDKNetHTTPRequest.setBody(jSONObject.toString());
        sDKNetHTTPRequest.startRequest(this.f3737a + HttpUrlConstants.SEARCH_PROGRAM_LIST, "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.search.SDKSearchMgr.1
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str);
                    onSearchProgramListReturnListener.onSearchProgramListReturn(jSONObject2.optString("ErrorCode"), jSONObject2.optString("Description"), SDKSearchMgr.this.a(str));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    LogEx.w("SDKSearchMgr", "JSONException occur");
                    onSearchProgramListReturnListener.onSearchProgramListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_SEARCH_MODELCODE, 1, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKSearchMgr", "SDKNetHTTPRequest onFailReturn");
                onSearchProgramListReturnListener.onSearchProgramListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_SEARCH_MODELCODE, 1, i % 1000)), str, null);
            }
        });
    }

    public void searchProgramListByEPG(HashMap<String, String> hashMap, final OnSearchProgramListByEPGReturnListener onSearchProgramListByEPGReturnListener) {
        if (onSearchProgramListByEPGReturnListener == null) {
            LogEx.w("SDKSearchMgr", "listener is null");
            return;
        }
        if (hashMap == null) {
            onSearchProgramListByEPGReturnListener.onSearchProgramListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_SEARCH_MODELCODE, 4, 2)), "params is null", null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getFrameHome());
        sb.append(HttpUrlConstants.SEARCH_PROGRAME_BY_EPG);
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
        this.f3738b = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.search.SDKSearchMgr.4
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onSearchProgramListByEPGReturnListener.onSearchProgramListReturn(jSONObject.optString("returncode"), jSONObject.optString("errormsg"), str);
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKSearchMgr", "JSONException occur");
                    onSearchProgramListByEPGReturnListener.onSearchProgramListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_SEARCH_MODELCODE, 4, 202)), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKSearchMgr", "SDKNetHTTPRequest onFailReturn");
                onSearchProgramListByEPGReturnListener.onSearchProgramListReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_SEARCH_MODELCODE, 4, i % 1000)), str, null);
            }
        });
    }

    public void setServerDomain(String str) {
        this.f3737a = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.put("returncode", jSONObject.optString("ErrorCode"));
            jSONObject.remove("ErrorCode");
            jSONObject.put("errormsg", jSONObject.optString("Description"));
            jSONObject.remove("Description");
            jSONObject.put("totalcount", jSONObject.optString("TotalHits"));
            jSONObject.remove("TotalHits");
            jSONObject.put("totalpages", jSONObject.optString("TotalPages"));
            jSONObject.remove("TotalPages");
            jSONObject.put("contentcode", jSONObject.optJSONArray("ContentCode"));
            jSONObject.remove("ContentCode");
            jSONObject.put("contenttype", jSONObject.optJSONArray("ContentType"));
            jSONObject.remove("ContentType");
            jSONObject.put("subtype", jSONObject.optJSONArray("SubType"));
            jSONObject.remove("SubType");
            jSONObject.put("subjectcode", jSONObject.optJSONArray("SubjectCode"));
            jSONObject.remove("SubjectCode");
            jSONObject.put("subjectname", jSONObject.optJSONArray("SubjectName"));
            jSONObject.remove("SubjectName");
            jSONObject.put("channelcode", jSONObject.optJSONArray(ParamConst.SEARCH_RSP_ITEM_CHANNELCODE));
            jSONObject.remove(ParamConst.SEARCH_RSP_ITEM_CHANNELCODE);
            jSONObject.put("programcode", jSONObject.optJSONArray("ProgramCode"));
            jSONObject.remove("ProgramCode");
            jSONObject.put("starttime", jSONObject.optJSONArray("StartTime"));
            jSONObject.remove("StartTime");
            jSONObject.put("endtime", jSONObject.optJSONArray("EndTime"));
            jSONObject.remove("EndTime");
            jSONObject.put("ratingid", jSONObject.optJSONArray("RatingId"));
            jSONObject.remove("RatingId");
            jSONObject.put("cpcode", jSONObject.optJSONArray("CpCode"));
            jSONObject.remove("CpCode");
            jSONObject.put("postfilelist", jSONObject.optJSONArray("PostFileList"));
            jSONObject.remove("PostFileList");
            jSONObject.put("seriesnum", jSONObject.optJSONArray("SeriesNum"));
            jSONObject.remove("SeriesNum");
            jSONObject.put("actor", jSONObject.optJSONArray("Actor"));
            jSONObject.remove("Actor");
            jSONObject.put("genre", jSONObject.optJSONArray("Genre"));
            jSONObject.remove("Genre");
            jSONObject.put("subgenre", jSONObject.optJSONArray("SubGenre"));
            jSONObject.remove("SubGenre");
            jSONObject.put("releasedate", jSONObject.optJSONArray("ReleaseYear"));
            jSONObject.remove("ReleaseYear");
            jSONObject.put("elapsedtime", jSONObject.optJSONArray("ElapsedTime"));
            jSONObject.remove("ElapsedTime");
            jSONObject.put("prevuecode", jSONObject.optJSONArray("PrevueCode"));
            jSONObject.remove("PrevueCode");
            jSONObject.put("countryname", jSONObject.optJSONArray("CountryName"));
            jSONObject.remove("CountryName");
            jSONObject.put("director", jSONObject.optJSONArray("Director"));
            jSONObject.remove("Director");
            jSONObject.put("itemlist", jSONObject.optJSONArray("ItemList"));
            jSONObject.remove("ItemList");
            jSONObject.put("wordtype", jSONObject.optJSONArray(ParamConst.SEARCH_RSP_KEYWORDSEARCH_WORDTYPE));
            jSONObject.remove(ParamConst.SEARCH_RSP_KEYWORDSEARCH_WORDTYPE);
            jSONObject.put("toppick", jSONObject.optJSONArray("TopPick"));
            jSONObject.remove("TopPick");
            jSONObject.put("totalgroups", jSONObject.optString("Totalgroups"));
            jSONObject.remove("Totalgroups");
            jSONObject.put("bytitle", jSONObject.optJSONArray(ParamConst.SEARCH_RSP_KEYWORDSEARCH_BYTITLE));
            jSONObject.remove(ParamConst.SEARCH_RSP_KEYWORDSEARCH_BYTITLE);
            jSONObject.put("byactor", jSONObject.optJSONArray(ParamConst.SEARCH_RSP_KEYWORDSEARCH_BYACTOR));
            jSONObject.remove(ParamConst.SEARCH_RSP_KEYWORDSEARCH_BYACTOR);
            jSONObject.put("bydirector", jSONObject.optJSONArray(ParamConst.SEARCH_RSP_KEYWORDSEARCH_BYDIRECTOR));
            jSONObject.remove(ParamConst.SEARCH_RSP_KEYWORDSEARCH_BYDIRECTOR);
            jSONObject.put("contentname", jSONObject.optJSONArray("ContentName"));
            jSONObject.remove("ContentName");
            jSONObject.put("channelname", jSONObject.optJSONArray("ChannelName"));
            jSONObject.remove("ChannelName");
            jSONObject.put("mediaservice", jSONObject.optJSONArray("MediaServices"));
            jSONObject.remove("MediaServices");
            jSONObject.put("markfilename", jSONObject.optJSONArray(ParamConst.SEARCH_RSP_ITEM_MARKFILENAME));
            jSONObject.remove(ParamConst.SEARCH_RSP_ITEM_MARKFILENAME);
            jSONObject.put("platformid", jSONObject.optJSONArray("Platformid"));
            jSONObject.remove("Platformid");
            jSONObject.put("telecomcode", jSONObject.optJSONArray("Telecomcode"));
            jSONObject.remove("Telecomcode");
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return str;
        }
    }
}
