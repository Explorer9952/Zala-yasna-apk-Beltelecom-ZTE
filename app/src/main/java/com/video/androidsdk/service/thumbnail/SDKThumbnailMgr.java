package com.video.androidsdk.service.thumbnail;

import android.text.TextUtils;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.ParamConst;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.log.LogEx;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SDKThumbnailMgr {

    /* renamed from: a, reason: collision with root package name */
    private String f3762a;

    /* renamed from: b, reason: collision with root package name */
    private GetThumbnailsReq f3763b;

    /* renamed from: c, reason: collision with root package name */
    private OnGetThumbnailsReturnListener f3764c;

    /* renamed from: d, reason: collision with root package name */
    private SDKNetHTTPRequest f3765d;
    private SDKNetHTTPRequest e;

    /* loaded from: classes.dex */
    public interface OnGetThumbnailsReturnListener {
        void onGetThumbnailsReturn(String str, String str2, String str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.e = sDKNetHTTPRequest;
        String str2 = this.f3762a + "/" + this.f3763b.cmsid + "/2048/" + this.f3763b.physicalcontentid + "/" + str;
        LogEx.d("SDKThumbnailMgr", "child index req url:" + str2);
        sDKNetHTTPRequest.startRequest(str2, "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.thumbnail.SDKThumbnailMgr.2
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str3) {
                LogEx.d("SDKThumbnailMgr", "child index result:" + str3);
                String f = SDKThumbnailMgr.this.f(str3);
                if (TextUtils.isEmpty(f)) {
                    SDKThumbnailMgr.this.f3764c.onGetThumbnailsReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_THUMBNAIL_MODELCODE, 1, 1)), "empty response", f);
                } else {
                    SDKThumbnailMgr.this.f3764c.onGetThumbnailsReturn("0", "success", f);
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str3) {
                LogEx.w("SDKThumbnailMgr", "child index request SDKNetHTTPRequest onFailReturn");
                SDKThumbnailMgr.this.f3764c.onGetThumbnailsReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_THUMBNAIL_MODELCODE, 1, i % 1000)), str3, "");
            }
        });
    }

    private int e(String str) {
        String[] split = str.split("\\.");
        if (split == null || split.length <= 0) {
            return 0;
        }
        try {
            return Integer.valueOf(split[0]).intValue();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String f(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("ZThumbnailStream");
            if (optJSONObject == null) {
                return null;
            }
            optJSONObject.put("returncode", 0);
            optJSONObject.put("errormsg", "success");
            optJSONObject.put("timeinterval", optJSONObject.optString("maxduration"));
            optJSONObject.remove("maxduration");
            optJSONObject.put("mimetype", optJSONObject.optString("mimeType"));
            optJSONObject.remove("mimeType");
            optJSONObject.put("thumbnails", optJSONObject.optJSONArray("dpidetail"));
            optJSONObject.remove("dpidetail");
            JSONArray jSONArray = optJSONObject.getJSONArray("thumbnails");
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    jSONObject.put("thumbnailurl", g(jSONObject.optString(MessengerShareContentUtility.ATTACHMENT_TEMPLATE_TYPE)));
                    jSONObject.remove(MessengerShareContentUtility.ATTACHMENT_TEMPLATE_TYPE);
                    JSONArray optJSONArray = jSONObject.optJSONArray("segments");
                    if (optJSONArray != null) {
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                            jSONObject2.put("time", jSONObject2.optString("t"));
                            jSONObject2.remove("t");
                            jSONObject2.put(ParamConst.DLNA_SENDDMRGETCURRPOSITIONINFO_RSP_RELTIME, jSONObject2.optString("rt"));
                            jSONObject2.remove("rt");
                        }
                    }
                }
            }
            return optJSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String g(String str) {
        return this.f3762a + "/" + this.f3763b.cmsid + "/2048/" + this.f3763b.physicalcontentid + "/" + str;
    }

    public void cancelRequest() {
        SDKNetHTTPRequest sDKNetHTTPRequest = this.f3765d;
        if (sDKNetHTTPRequest != null) {
            sDKNetHTTPRequest.cancelRequest();
        }
        SDKNetHTTPRequest sDKNetHTTPRequest2 = this.e;
        if (sDKNetHTTPRequest2 != null) {
            sDKNetHTTPRequest2.cancelRequest();
        }
    }

    public void getThumbnails(GetThumbnailsReq getThumbnailsReq, OnGetThumbnailsReturnListener onGetThumbnailsReturnListener) {
        if (onGetThumbnailsReturnListener == null) {
            LogEx.e("SDKThumbnailMgr", "callback is null");
            return;
        }
        this.f3764c = onGetThumbnailsReturnListener;
        if (getThumbnailsReq == null) {
            onGetThumbnailsReturnListener.onGetThumbnailsReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_THUMBNAIL_MODELCODE, 1, 2)), "params is null", "");
            LogEx.e("SDKThumbnailMgr", "params is null");
            return;
        }
        if (TextUtils.isEmpty(this.f3762a)) {
            this.f3764c.onGetThumbnailsReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_THUMBNAIL_MODELCODE, 1, 100)), "server domain is null", "");
            LogEx.e("SDKThumbnailMgr", "server domain is null");
            return;
        }
        this.f3763b = getThumbnailsReq;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3762a);
        sb.append("/");
        sb.append(this.f3763b.cmsid);
        sb.append("/2048");
        sb.append("/");
        sb.append(this.f3763b.physicalcontentid);
        sb.append("/main.zti?virtualDomain=");
        sb.append(this.f3763b.cmsid);
        sb.append(".");
        sb.append(b(this.f3763b.playtype));
        sb.append("_hls_jpg.zte.com");
        if (TextUtils.equals("2", this.f3763b.playtype)) {
            sb.append("&programbegin=");
            sb.append(this.f3763b.programbegin);
            sb.append("&programend=");
            sb.append(this.f3763b.programend);
        }
        a(sb.toString());
    }

    public void setServerDomain(String str) {
        this.f3762a = str;
    }

    private String b(String str) {
        return TextUtils.equals("1", str) ? "live" : TextUtils.equals("2", str) ? com.video.androidsdk.service.comm.ParamConst.PLAY_CONTENTTYPE_TVOD : TextUtils.equals("3", str) ? com.video.androidsdk.service.comm.ParamConst.PLAY_CONTENTTYPE_NPVR : TextUtils.equals("4", str) ? com.video.androidsdk.service.comm.ParamConst.PLAY_CONTENTTYPE_VOD : TextUtils.equals(DownloadConstant.REPORT_MSGTYPE_ADD, str) ? "tstv" : TextUtils.equals(DownloadConstant.REPORT_MSGTYPE_URL_NULL, str) ? "nvod" : TextUtils.equals(DownloadConstant.REPORT_MSGTYPE_STB_RECONNECT, str) ? "dvr" : TextUtils.equals("8", str) ? "picture" : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(String str) {
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        int i;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("ZThumbnailStreamList") || (optJSONArray = jSONObject.optJSONArray("ZThumbnailStreamList")) == null) {
                return null;
            }
            JSONObject jSONObject2 = null;
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject jSONObject3 = optJSONArray.getJSONObject(i2);
                if (jSONObject3 != null && (optJSONArray2 = jSONObject3.optJSONArray("dpilist")) != null) {
                    while (i < optJSONArray2.length()) {
                        JSONObject jSONObject4 = optJSONArray2.getJSONObject(i);
                        if (TextUtils.equals(this.f3763b.definition, String.valueOf(e(jSONObject4.optString("url"))))) {
                            return jSONObject4.optString("url");
                        }
                        i = (jSONObject2 != null && e(jSONObject2.optString("url")) <= e(jSONObject4.optString("url"))) ? i + 1 : 0;
                        jSONObject2 = jSONObject4;
                    }
                }
            }
            if (jSONObject2 != null) {
                return jSONObject2.optString("url");
            }
            return null;
        } catch (JSONException e) {
            e.printStackTrace();
            LogEx.w("SDKThumbnailMgr", "JSONException occur");
            return null;
        }
    }

    private void a(String str) {
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        this.f3765d = sDKNetHTTPRequest;
        LogEx.d("SDKThumbnailMgr", "father index req url:" + str);
        sDKNetHTTPRequest.startRequest(str, "GET", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.thumbnail.SDKThumbnailMgr.1
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str2) {
                LogEx.d("SDKThumbnailMgr", "father index request SDKNetHTTPRequest return data:" + str2);
                String c2 = SDKThumbnailMgr.this.c(str2);
                if (!TextUtils.isEmpty(c2)) {
                    SDKThumbnailMgr.this.d(c2);
                } else {
                    LogEx.w("SDKThumbnailMgr", "father index result is error");
                    SDKThumbnailMgr.this.f3764c.onGetThumbnailsReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_THUMBNAIL_MODELCODE, 1, 3)), "father index result is error", "");
                }
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str2) {
                LogEx.w("SDKThumbnailMgr", "father index request SDKNetHTTPRequest onFailReturn" + i + str2);
                SDKThumbnailMgr.this.f3764c.onGetThumbnailsReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_THUMBNAIL_MODELCODE, 1, i % 1000)), str2, "");
            }
        });
    }
}
