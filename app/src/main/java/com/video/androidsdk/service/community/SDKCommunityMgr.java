package com.video.androidsdk.service.community;

import android.text.TextUtils;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.login.a.c;
import com.video.androidsdk.service.comm.HttpUrlConstants;
import com.video.androidsdk.service.comm.ParamConst;
import com.video.androidsdk.sns.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SDKCommunityMgr {

    /* renamed from: a, reason: collision with root package name */
    private String f3592a;

    /* renamed from: b, reason: collision with root package name */
    private String f3593b;

    /* renamed from: c, reason: collision with root package name */
    private SDKNetHTTPRequest f3594c;

    /* loaded from: classes.dex */
    public interface OnAddCommentReturnListener {
        void onAddCommentReturn(int i, String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnAddPraiseReturnListener {
        void onAddPraiseReturn(int i, String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnAddReplyReturnListener {
        void onAddReplyReturn(int i, String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnCommentListReturnListener {
        void onCommentListReturn(int i, String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnDelCommentReturnListener {
        void onDelCommentReturn(int i, String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnDelReplyReturnListener {
        void onDelReplyReturn(int i, String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnReplyListReturnListener {
        void onReplyListReturn(int i, String str, String str2);
    }

    /* loaded from: classes.dex */
    public interface OnStarRatingReturnListener {
        void onStarRatingReturn(int i, String str);
    }

    private String a(String str) {
        String userID = SDKLoginMgr.getInstance().getUserID();
        String userInfo = SDKLoginMgr.getInstance().getUserInfo("UserToken");
        String b2 = (TextUtils.isEmpty(userID) || TextUtils.isEmpty(userInfo)) ? "" : c.b(userID, userInfo, str);
        try {
            return URLEncoder.encode(b2, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return b2;
        }
    }

    public void addComment(HashMap<String, String> hashMap, final OnAddCommentReturnListener onAddCommentReturnListener) {
        if (onAddCommentReturnListener == null) {
            LogEx.w("SDKCommunityMgr", "listener is null");
            return;
        }
        if (TextUtils.isEmpty(this.f3592a)) {
            onAddCommentReturnListener.onAddCommentReturn(ErrCode.getErrCode(ErrCode.ERRCODE_COMMUNITY_MODELCODE, 4, 100), "ServerDomain has not set", null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3592a);
        sb.append(HttpUrlConstants.ADD_COMMENT);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.SINA_WEIBO_UID, SDKLoginMgr.getInstance().getUserID());
            jSONObject.put("token", SDKLoginMgr.getInstance().getUserInfo("UserToken"));
            if (hashMap != null) {
                jSONObject.put("authinfo", a(hashMap.get(ParamConst.NPVR_ADD_REQ_CONTENTID)));
                jSONObject.put("cid", hashMap.get(ParamConst.NPVR_ADD_REQ_CONTENTID));
                jSONObject.put("content", hashMap.get("content"));
                jSONObject.put("terminalflag", hashMap.get("terminalflag"));
                jSONObject.put("platformid", hashMap.get("platformid"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3594c = sDKNetHTTPRequest;
        String str = this.f3593b;
        if (TextUtils.isEmpty(str)) {
            str = SDKLoginMgr.getInstance().getHTTPSessionID();
        }
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + str);
        sDKNetHTTPRequest.setBody(jSONObject.toString());
        sDKNetHTTPRequest.setHeader("Content-Type", "application/json; charset=UTF-8");
        sDKNetHTTPRequest.startRequest(sb.toString(), "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.community.SDKCommunityMgr.4
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str2) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str2);
                    onAddCommentReturnListener.onAddCommentReturn(jSONObject2.optInt("returncode"), jSONObject2.optString("errormsg"), str2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    LogEx.w("SDKCommunityMgr", "JSONException occur");
                    onAddCommentReturnListener.onAddCommentReturn(ErrCode.getErrCode(ErrCode.ERRCODE_COMMUNITY_MODELCODE, 4, 202), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str2) {
                LogEx.w("SDKCommunityMgr", "SDKNetHTTPRequest onFailReturn");
                onAddCommentReturnListener.onAddCommentReturn(ErrCode.getErrCode(ErrCode.ERRCODE_COMMUNITY_MODELCODE, 4, i % 1000), str2, null);
            }
        });
    }

    public void addPraise(HashMap<String, String> hashMap, final OnAddPraiseReturnListener onAddPraiseReturnListener) {
        if (onAddPraiseReturnListener == null) {
            LogEx.w("SDKCommunityMgr", "listener is null");
            return;
        }
        if (TextUtils.isEmpty(this.f3592a)) {
            onAddPraiseReturnListener.onAddPraiseReturn(ErrCode.getErrCode(ErrCode.ERRCODE_COMMUNITY_MODELCODE, 8, 100), "ServerDomain has not set", null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3592a);
        sb.append(HttpUrlConstants.ADD_PRAISE);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.SINA_WEIBO_UID, SDKLoginMgr.getInstance().getUserID());
            jSONObject.put("token", SDKLoginMgr.getInstance().getUserInfo("UserToken"));
            if (hashMap != null) {
                jSONObject.put("authinfo", a(hashMap.get(ParamConst.NPVR_ADD_REQ_CONTENTID)));
                jSONObject.put("cid", hashMap.get(ParamConst.NPVR_ADD_REQ_CONTENTID));
                jSONObject.put("commentid", hashMap.get("commentid"));
                jSONObject.put("type", hashMap.get("type"));
                jSONObject.put("terminalflag", hashMap.get("terminalflag"));
                jSONObject.put("platformid", hashMap.get("platformid"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3594c = sDKNetHTTPRequest;
        String str = this.f3593b;
        if (TextUtils.isEmpty(str)) {
            str = SDKLoginMgr.getInstance().getHTTPSessionID();
        }
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + str);
        sDKNetHTTPRequest.setBody(jSONObject.toString());
        sDKNetHTTPRequest.setHeader("Content-Type", "application/json; charset=UTF-8");
        sDKNetHTTPRequest.startRequest(sb.toString(), "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.community.SDKCommunityMgr.8
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str2) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str2);
                    onAddPraiseReturnListener.onAddPraiseReturn(jSONObject2.optInt("returncode"), jSONObject2.optString("errormsg"), str2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    LogEx.w("SDKCommunityMgr", "JSONException occur");
                    onAddPraiseReturnListener.onAddPraiseReturn(ErrCode.getErrCode(ErrCode.ERRCODE_COMMUNITY_MODELCODE, 8, 202), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str2) {
                LogEx.w("SDKCommunityMgr", "SDKNetHTTPRequest onFailReturn");
                onAddPraiseReturnListener.onAddPraiseReturn(ErrCode.getErrCode(ErrCode.ERRCODE_COMMUNITY_MODELCODE, 8, i % 1000), str2, null);
            }
        });
    }

    public void addReply(HashMap<String, String> hashMap, final OnAddReplyReturnListener onAddReplyReturnListener) {
        if (onAddReplyReturnListener == null) {
            LogEx.w("SDKCommunityMgr", "listener is null");
            return;
        }
        if (TextUtils.isEmpty(this.f3592a)) {
            onAddReplyReturnListener.onAddReplyReturn(ErrCode.getErrCode(ErrCode.ERRCODE_COMMUNITY_MODELCODE, 6, 100), "ServerDomain has not set", null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3592a);
        sb.append(HttpUrlConstants.ADD_REPLY);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.SINA_WEIBO_UID, SDKLoginMgr.getInstance().getUserID());
            jSONObject.put("token", SDKLoginMgr.getInstance().getUserInfo("UserToken"));
            if (hashMap != null) {
                jSONObject.put("authinfo", a(hashMap.get("commentid")));
                jSONObject.put("content", hashMap.get("content"));
                jSONObject.put("commentid", hashMap.get("commentid"));
                jSONObject.put("terminalflag", hashMap.get("terminalflag"));
                jSONObject.put("platformid", hashMap.get("platformid"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3594c = sDKNetHTTPRequest;
        String str = this.f3593b;
        if (TextUtils.isEmpty(str)) {
            str = SDKLoginMgr.getInstance().getHTTPSessionID();
        }
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + str);
        sDKNetHTTPRequest.setBody(jSONObject.toString());
        sDKNetHTTPRequest.setHeader("Content-Type", "application/json; charset=UTF-8");
        sDKNetHTTPRequest.startRequest(sb.toString(), "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.community.SDKCommunityMgr.6
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str2) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str2);
                    onAddReplyReturnListener.onAddReplyReturn(jSONObject2.optInt("returncode"), jSONObject2.optString("errormsg"), str2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    LogEx.w("SDKCommunityMgr", "JSONException occur");
                    onAddReplyReturnListener.onAddReplyReturn(ErrCode.getErrCode(ErrCode.ERRCODE_COMMUNITY_MODELCODE, 6, 202), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str2) {
                LogEx.w("SDKCommunityMgr", "SDKNetHTTPRequest onFailReturn");
                onAddReplyReturnListener.onAddReplyReturn(ErrCode.getErrCode(ErrCode.ERRCODE_COMMUNITY_MODELCODE, 6, i % 1000), str2, null);
            }
        });
    }

    public void cancelRequest() {
        SDKNetHTTPRequest sDKNetHTTPRequest = this.f3594c;
        if (sDKNetHTTPRequest != null) {
            sDKNetHTTPRequest.cancelRequest();
        }
    }

    public void delComment(HashMap<String, String> hashMap, final OnDelCommentReturnListener onDelCommentReturnListener) {
        if (onDelCommentReturnListener == null) {
            LogEx.w("SDKCommunityMgr", "listener is null");
            return;
        }
        if (TextUtils.isEmpty(this.f3592a)) {
            onDelCommentReturnListener.onDelCommentReturn(ErrCode.getErrCode(ErrCode.ERRCODE_COMMUNITY_MODELCODE, 5, 100), "ServerDomain has not set", null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3592a);
        sb.append(HttpUrlConstants.DEL_COMMENT);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.SINA_WEIBO_UID, SDKLoginMgr.getInstance().getUserID());
            jSONObject.put("token", SDKLoginMgr.getInstance().getUserInfo("UserToken"));
            if (hashMap != null) {
                jSONObject.put("authinfo", a(hashMap.get(ParamConst.NPVR_ADD_REQ_CONTENTID)));
                jSONObject.put("cid", hashMap.get(ParamConst.NPVR_ADD_REQ_CONTENTID));
                jSONObject.put("commentid", hashMap.get("commentid"));
                jSONObject.put("terminalflag", hashMap.get("terminalflag"));
                jSONObject.put("platformid", hashMap.get("platformid"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3594c = sDKNetHTTPRequest;
        String str = this.f3593b;
        if (TextUtils.isEmpty(str)) {
            str = SDKLoginMgr.getInstance().getHTTPSessionID();
        }
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + str);
        sDKNetHTTPRequest.setBody(jSONObject.toString());
        sDKNetHTTPRequest.setHeader("Content-Type", "application/json; charset=UTF-8");
        sDKNetHTTPRequest.startRequest(sb.toString(), "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.community.SDKCommunityMgr.5
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str2) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str2);
                    onDelCommentReturnListener.onDelCommentReturn(jSONObject2.optInt("returncode"), jSONObject2.optString("errormsg"), str2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    LogEx.w("SDKCommunityMgr", "JSONException occur");
                    onDelCommentReturnListener.onDelCommentReturn(ErrCode.getErrCode(ErrCode.ERRCODE_COMMUNITY_MODELCODE, 5, 202), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str2) {
                LogEx.w("SDKCommunityMgr", "SDKNetHTTPRequest onFailReturn");
                onDelCommentReturnListener.onDelCommentReturn(ErrCode.getErrCode(ErrCode.ERRCODE_COMMUNITY_MODELCODE, 5, i % 1000), str2, null);
            }
        });
    }

    public void delReply(HashMap<String, String> hashMap, final OnDelReplyReturnListener onDelReplyReturnListener) {
        if (onDelReplyReturnListener == null) {
            LogEx.w("SDKCommunityMgr", "listener is null");
            return;
        }
        if (TextUtils.isEmpty(this.f3592a)) {
            onDelReplyReturnListener.onDelReplyReturn(ErrCode.getErrCode(ErrCode.ERRCODE_COMMUNITY_MODELCODE, 7, 100), "ServerDomain has not set", null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3592a);
        sb.append(HttpUrlConstants.DEL_REPLY);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.SINA_WEIBO_UID, SDKLoginMgr.getInstance().getUserID());
            jSONObject.put("token", SDKLoginMgr.getInstance().getUserInfo("UserToken"));
            if (hashMap != null) {
                jSONObject.put("authinfo", a(hashMap.get("commentid")));
                jSONObject.put("replyid", hashMap.get("replyid"));
                jSONObject.put("commentid", hashMap.get("commentid"));
                jSONObject.put("terminalflag", hashMap.get("terminalflag"));
                jSONObject.put("platformid", hashMap.get("platformid"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3594c = sDKNetHTTPRequest;
        String str = this.f3593b;
        if (TextUtils.isEmpty(str)) {
            str = SDKLoginMgr.getInstance().getHTTPSessionID();
        }
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + str);
        sDKNetHTTPRequest.setBody(jSONObject.toString());
        sDKNetHTTPRequest.setHeader("Content-Type", "application/json; charset=UTF-8");
        sDKNetHTTPRequest.startRequest(sb.toString(), "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.community.SDKCommunityMgr.7
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str2) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str2);
                    onDelReplyReturnListener.onDelReplyReturn(jSONObject2.optInt("returncode"), jSONObject2.optString("errormsg"), str2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    LogEx.w("SDKCommunityMgr", "JSONException occur");
                    onDelReplyReturnListener.onDelReplyReturn(ErrCode.getErrCode(ErrCode.ERRCODE_COMMUNITY_MODELCODE, 7, 202), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str2) {
                LogEx.w("SDKCommunityMgr", "SDKNetHTTPRequest onFailReturn");
                onDelReplyReturnListener.onDelReplyReturn(ErrCode.getErrCode(ErrCode.ERRCODE_COMMUNITY_MODELCODE, 7, i % 1000), str2, null);
            }
        });
    }

    public void doStarRating(HashMap<String, String> hashMap, final OnStarRatingReturnListener onStarRatingReturnListener) {
        if (onStarRatingReturnListener == null) {
            LogEx.w("SDKCommunityMgr", "listener is null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(SDKLoginMgr.getInstance().getEPGHome());
        sb.append(HttpUrlConstants.DO_STARRATING);
        if (hashMap != null) {
            hashMap.put("usercode", SDKLoginMgr.getInstance().getUserID());
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
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3594c = sDKNetHTTPRequest;
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + SDKLoginMgr.getInstance().getHTTPSessionID());
        sDKNetHTTPRequest.startRequest(sb.toString(), "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.community.SDKCommunityMgr.1
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    onStarRatingReturnListener.onStarRatingReturn(jSONObject.optInt("returncode"), jSONObject.optString("errormsg"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w("SDKCommunityMgr", "JSONException occur");
                    onStarRatingReturnListener.onStarRatingReturn(ErrCode.getErrCode(ErrCode.ERRCODE_COMMUNITY_MODELCODE, 1, 202), "JSONException occur");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                LogEx.w("SDKCommunityMgr", "SDKNetHTTPRequest onFailReturn");
                onStarRatingReturnListener.onStarRatingReturn(ErrCode.getErrCode(ErrCode.ERRCODE_COMMUNITY_MODELCODE, 1, i % 1000), str);
            }
        });
    }

    public void getCommentList(HashMap<String, String> hashMap, final OnCommentListReturnListener onCommentListReturnListener) {
        if (onCommentListReturnListener == null) {
            LogEx.w("SDKCommunityMgr", "listener is null");
            return;
        }
        if (TextUtils.isEmpty(this.f3592a)) {
            onCommentListReturnListener.onCommentListReturn(ErrCode.getErrCode(ErrCode.ERRCODE_COMMUNITY_MODELCODE, 2, 100), "ServerDomain has not set", null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3592a);
        sb.append(HttpUrlConstants.QUERY_COMMENT_LIST);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.SINA_WEIBO_UID, SDKLoginMgr.getInstance().getUserID());
            jSONObject.put("token", SDKLoginMgr.getInstance().getUserInfo("UserToken"));
            if (hashMap != null) {
                jSONObject.put("authinfo", a(hashMap.get(ParamConst.NPVR_ADD_REQ_CONTENTID)));
                jSONObject.put("cid", hashMap.get(ParamConst.NPVR_ADD_REQ_CONTENTID));
                jSONObject.put("pageno", hashMap.get("pageno"));
                jSONObject.put("numperpage", hashMap.get("numperpage"));
                jSONObject.put("terminalflag", hashMap.get("terminalflag"));
                jSONObject.put("platformid", hashMap.get("platformid"));
                jSONObject.put("sorttype", "1");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3594c = sDKNetHTTPRequest;
        String str = this.f3593b;
        if (TextUtils.isEmpty(str)) {
            str = SDKLoginMgr.getInstance().getHTTPSessionID();
        }
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + str);
        sDKNetHTTPRequest.setBody(jSONObject.toString());
        sDKNetHTTPRequest.setHeader("Content-Type", "application/json; charset=UTF-8");
        sDKNetHTTPRequest.startRequest(sb.toString(), "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.community.SDKCommunityMgr.2
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str2) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str2);
                    onCommentListReturnListener.onCommentListReturn(jSONObject2.optInt("returncode"), jSONObject2.optString("errormsg"), str2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    LogEx.w("SDKCommunityMgr", "JSONException occur");
                    onCommentListReturnListener.onCommentListReturn(ErrCode.getErrCode(ErrCode.ERRCODE_COMMUNITY_MODELCODE, 2, 202), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str2) {
                LogEx.w("SDKCommunityMgr", "SDKNetHTTPRequest onFailReturn");
                onCommentListReturnListener.onCommentListReturn(ErrCode.getErrCode(ErrCode.ERRCODE_COMMUNITY_MODELCODE, 2, i % 1000), str2, null);
            }
        });
    }

    public void getReplyList(HashMap<String, String> hashMap, final OnReplyListReturnListener onReplyListReturnListener) {
        if (onReplyListReturnListener == null) {
            LogEx.w("SDKCommunityMgr", "listener is null");
            return;
        }
        if (TextUtils.isEmpty(this.f3592a)) {
            onReplyListReturnListener.onReplyListReturn(ErrCode.getErrCode(ErrCode.ERRCODE_COMMUNITY_MODELCODE, 3, 100), "ServerDomain has not set", null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3592a);
        sb.append(HttpUrlConstants.QUERY_REPLY_LIST);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.SINA_WEIBO_UID, SDKLoginMgr.getInstance().getUserID());
            jSONObject.put("token", SDKLoginMgr.getInstance().getUserInfo("UserToken"));
            if (hashMap != null) {
                jSONObject.put("authinfo", a(hashMap.get("commentid")));
                jSONObject.put("commentid", hashMap.get("commentid"));
                jSONObject.put("pageno", hashMap.get("pageno"));
                jSONObject.put("numperpage", hashMap.get("numperpage"));
                jSONObject.put("terminalflag", hashMap.get("terminalflag"));
                jSONObject.put("platformid", hashMap.get("platformid"));
                jSONObject.put("sorttype", "1");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3594c = sDKNetHTTPRequest;
        String str = this.f3593b;
        if (TextUtils.isEmpty(str)) {
            str = SDKLoginMgr.getInstance().getHTTPSessionID();
        }
        sDKNetHTTPRequest.setHeader("Cookie", "JSESSIONID=" + str);
        sDKNetHTTPRequest.setBody(jSONObject.toString());
        sDKNetHTTPRequest.setHeader("Content-Type", "application/json; charset=UTF-8");
        sDKNetHTTPRequest.startRequest(sb.toString(), "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.community.SDKCommunityMgr.3
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str2) {
                try {
                    JSONObject jSONObject2 = new JSONObject(str2);
                    onReplyListReturnListener.onReplyListReturn(jSONObject2.optInt("returncode"), jSONObject2.optString("errormsg"), str2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    LogEx.w("SDKCommunityMgr", "JSONException occur");
                    onReplyListReturnListener.onReplyListReturn(ErrCode.getErrCode(ErrCode.ERRCODE_COMMUNITY_MODELCODE, 3, 202), "JSONException occur", null);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str2) {
                LogEx.w("SDKCommunityMgr", "SDKNetHTTPRequest onFailReturn");
                onReplyListReturnListener.onReplyListReturn(ErrCode.getErrCode(ErrCode.ERRCODE_COMMUNITY_MODELCODE, 3, i % 1000), str2, null);
            }
        });
    }

    public void setHTTPSessionID(String str) {
        this.f3593b = str;
    }

    public void setServerDomain(String str) {
        this.f3592a = str;
    }
}
