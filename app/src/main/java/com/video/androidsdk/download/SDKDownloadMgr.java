package com.video.androidsdk.download;

import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.drmproxy.ProxyInterface;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.ErrMessage;
import com.video.androidsdk.common.RequestUrlContants;
import com.video.androidsdk.common.http.HttpConstant;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.http.bean.HttpRequest;
import com.video.androidsdk.download.Linstener.DownloadListReturnListener;
import com.video.androidsdk.download.Linstener.OnInitReturnListener;
import com.video.androidsdk.download.Linstener.OnSpaceReturnListener;
import com.video.androidsdk.download.Linstener.OnTaskOperReturnListener;
import com.video.androidsdk.download.Linstener.SDKDownloadLoginSTBListener;
import com.video.androidsdk.download.Linstener.SDKDownloadReportListener;
import com.video.androidsdk.download.bean.DownLoadMgrInitInfo;
import com.video.androidsdk.download.bean.DownloadTask;
import com.video.androidsdk.download.bean.DownloadTaskReq;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SDKDownloadMgr implements ProxyInterface.ClientToProxyCallBack {
    private static SDKDownloadMgr l = new SDKDownloadMgr();

    /* renamed from: a, reason: collision with root package name */
    private ProxyInterface f3109a;

    /* renamed from: b, reason: collision with root package name */
    private int f3110b;

    /* renamed from: c, reason: collision with root package name */
    private SDKDownloadReportListener f3111c;
    private b e;
    private String g;
    private String h;
    private OnTaskOperReturnListener i;

    /* renamed from: d, reason: collision with root package name */
    private int f3112d = 1;
    private int f = 4;
    private String j = HttpConstant.PROTOCOL_HTTP;
    private String k = "";

    public static SDKDownloadMgr getInstance() {
        return l;
    }

    @Override // com.drmproxy.ProxyInterface.ClientToProxyCallBack
    public void ReportDeleteFileResult(String str) {
        String str2;
        String str3;
        if (!com.video.androidsdk.license.a.g) {
            LogEx.e("SDKDownloadMgr", ErrMessage.LIC_INVALIDATE);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            str2 = jSONObject.optString("returncode");
            str3 = jSONObject.optString("errormsg");
        } catch (JSONException e) {
            e.printStackTrace();
            str2 = WeiboAuthException.DEFAULT_AUTH_ERROR_CODE;
            str3 = "jsonexception";
        }
        a(this.i, str2, str3, str);
    }

    @Override // com.drmproxy.ProxyInterface.ClientToProxyCallBack
    public void ReportDownloadInfo(String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6 = "RateLow";
        String str7 = "videoinfo";
        String str8 = "downloadsize";
        LogEx.d("SDKDownloadMgr", "ReportDownloadInfo:" + str);
        if (!com.video.androidsdk.license.a.g) {
            LogEx.e("SDKDownloadMgr", ErrMessage.LIC_INVALIDATE);
            return;
        }
        if (this.f3111c == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("returncode");
            String optString2 = jSONObject.optString("errormsg");
            if (TextUtils.isEmpty(optString)) {
                LogEx.d("SDKDownloadMgr", "ReportDownloadSpeed");
                JSONArray optJSONArray = jSONObject.optJSONArray("downloadspeed");
                if (optJSONArray != null) {
                    int optInt = jSONObject.optInt("totalcount");
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("videoid");
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < optInt; i++) {
                        HashMap hashMap = new HashMap();
                        if (i < optJSONArray2.length()) {
                            hashMap.put("videoid", optJSONArray2.optString(i));
                        }
                        if (i < optJSONArray.length()) {
                            hashMap.put("downloadspeed", optJSONArray.optString(i));
                        }
                        if (!TextUtils.isEmpty(optJSONArray2.optString(i))) {
                            arrayList.add(hashMap);
                        }
                    }
                    if (arrayList.size() <= 0 || this.f3111c == null) {
                        return;
                    }
                    this.f3111c.onDownloadReport(DownloadConstant.REPORT_MSGTYPE_SPEED, optString, optString2, String.valueOf(1), arrayList);
                    return;
                }
                return;
            }
            if (TextUtils.equals("0", optString)) {
                int optInt2 = jSONObject.optInt("totalcount");
                JSONArray optJSONArray3 = jSONObject.optJSONArray("videoid");
                JSONArray optJSONArray4 = jSONObject.optJSONArray("progress");
                JSONArray optJSONArray5 = jSONObject.optJSONArray("totalsize");
                JSONArray optJSONArray6 = jSONObject.optJSONArray("downloadsize");
                JSONArray optJSONArray7 = jSONObject.optJSONArray("state");
                JSONArray optJSONArray8 = jSONObject.optJSONArray("videoinfo");
                try {
                    ArrayList arrayList2 = new ArrayList();
                    String str9 = "RateHigh";
                    int i2 = 0;
                    while (i2 < optInt2) {
                        int i3 = optInt2;
                        HashMap hashMap2 = new HashMap();
                        String str10 = str6;
                        if (i2 < optJSONArray3.length()) {
                            hashMap2.put("videoid", optJSONArray3.optString(i2));
                        }
                        if (i2 < optJSONArray4.length()) {
                            hashMap2.put("progress", optJSONArray4.optString(i2));
                        }
                        if (i2 < optJSONArray5.length()) {
                            hashMap2.put("totalsize", optJSONArray5.optString(i2));
                        }
                        if (i2 < optJSONArray6.length()) {
                            hashMap2.put(str8, optJSONArray6.optString(i2));
                        }
                        if (i2 < optJSONArray7.length()) {
                            hashMap2.put("state", optJSONArray7.optString(i2));
                        }
                        if (i2 < optJSONArray8.length()) {
                            str2 = optJSONArray8.optString(i2);
                            hashMap2.put(str7, str2);
                        } else {
                            str2 = null;
                        }
                        if (!TextUtils.isEmpty(optJSONArray3.optString(i2))) {
                            arrayList2.add(hashMap2);
                        }
                        String str11 = str7;
                        if (3 != optJSONArray7.optInt(i2) || TextUtils.isEmpty(str2)) {
                            str3 = str8;
                            str4 = str9;
                            str5 = str10;
                        } else {
                            JSONObject jSONObject2 = new JSONObject(str2);
                            String optString3 = jSONObject2.optString("sdkcolumncode");
                            String optString4 = jSONObject2.optString("sdkprogramcode");
                            String optString5 = jSONObject2.optString("sdkseriesprogramcode");
                            String optString6 = jSONObject2.optString("sdkdefinition");
                            String str12 = "";
                            if (TextUtils.isEmpty(jSONObject2.optString(str10))) {
                                str3 = str8;
                            } else {
                                str3 = str8;
                                str12 = "&RateLow=" + jSONObject2.optString(str10);
                            }
                            str4 = str9;
                            if (TextUtils.isEmpty(jSONObject2.optString(str4))) {
                                str5 = str10;
                            } else {
                                str5 = str10;
                                str12 = str12 + "&RateHigh=" + jSONObject2.optString(str4);
                            }
                            getInstance().a(1, optJSONArray3.optString(i2), optString3, optString4, optString5, optString6, str12, jSONObject2.optString("sourceType"), null);
                        }
                        i2++;
                        optInt2 = i3;
                        str6 = str5;
                        str7 = str11;
                        str9 = str4;
                        str8 = str3;
                    }
                    if (arrayList2.size() <= 0 || this.f3111c == null) {
                        return;
                    }
                    this.f3111c.onDownloadReport("3", optString, optString2, String.valueOf(1), arrayList2);
                    return;
                } catch (JSONException e) {
                    e = e;
                    e.printStackTrace();
                    return;
                }
            }
            String str13 = optString;
            if (!TextUtils.isEmpty(jSONObject.optString("extendcode"))) {
                str13 = jSONObject.optString("extendcode");
            }
            ArrayList arrayList3 = new ArrayList();
            HashMap hashMap3 = new HashMap();
            hashMap3.put("videoid", jSONObject.optString("videoid"));
            hashMap3.put("state", jSONObject.optString("state"));
            arrayList3.add(hashMap3);
            if (this.f3111c != null) {
                this.f3111c.onDownloadReport("4", str13, optString2, String.valueOf(1), arrayList3);
            }
        } catch (JSONException e2) {
            e = e2;
        }
    }

    @Override // com.drmproxy.ProxyInterface.ClientToProxyCallBack
    public void ReportPlayError(String str) {
    }

    @Override // com.drmproxy.ProxyInterface.ClientToProxyCallBack
    public void ReportQueryResolution(String str) {
    }

    @Override // com.drmproxy.ProxyInterface.ClientToProxyCallBack
    public void ReportUpdatekeyResult(String str) {
    }

    public void addTask(DownloadTaskReq downloadTaskReq, HashMap<String, String> hashMap, OnTaskOperReturnListener onTaskOperReturnListener) {
        int i;
        String str;
        int DownLoadVideo;
        if (!com.video.androidsdk.license.a.g) {
            LogEx.e("SDKDownloadMgr", ErrMessage.LIC_INVALIDATE);
            return;
        }
        LogEx.d("SDKDownloadMgr", "add new Task");
        if (downloadTaskReq != null) {
            hashMap.put("sdkcolumncode", downloadTaskReq.columnCode);
            hashMap.put("sdkprogramcode", downloadTaskReq.programeCode);
            hashMap.put("sdkseriesprogramcode", downloadTaskReq.seriesProgramCode);
            hashMap.put("sdkdefinition", downloadTaskReq.definition);
            try {
                i = Integer.parseInt(downloadTaskReq.downloadType);
            } catch (NumberFormatException unused) {
                i = -1;
            }
            if (i != 1) {
                if (i == 2) {
                    LogEx.d("SDKDownloadMgr", "add new Task remote");
                    b bVar = this.e;
                    if (bVar != null) {
                        bVar.a(downloadTaskReq, hashMap, onTaskOperReturnListener);
                        return;
                    } else {
                        a(onTaskOperReturnListener, String.valueOf(1), "RemoteDownLoadProxy is null, Please init RemoteDownLoadProxy first", (String) null);
                        return;
                    }
                }
                a(onTaskOperReturnListener, String.valueOf(1), "unknow downloadtype", (String) null);
                return;
            }
            LogEx.d("SDKDownloadMgr", "add new Task local");
            if (this.f3109a != null) {
                if (TextUtils.isEmpty(downloadTaskReq.seriesProgramCode)) {
                    str = downloadTaskReq.programeCode + downloadTaskReq.definition;
                    DownLoadVideo = this.f3109a.DownLoadVideo(downloadTaskReq.downloadURL, str, com.video.androidsdk.download.a.a(hashMap), downloadTaskReq.expiredTime);
                } else {
                    str = downloadTaskReq.seriesProgramCode + downloadTaskReq.programeCode + downloadTaskReq.definition;
                    DownLoadVideo = this.f3109a.DownLoadVideo(downloadTaskReq.downloadURL, str, com.video.androidsdk.download.a.a(hashMap), downloadTaskReq.seriesProgramCode, downloadTaskReq.expiredTime);
                }
                LogEx.d("SDKDownloadMgr", "videoID:" + str);
                if (DownLoadVideo == 0) {
                    a(onTaskOperReturnListener, String.valueOf(0), "add new Task ok", (String) null);
                    LogEx.d("SDKDownloadMgr", "new task add successfully result:" + DownLoadVideo);
                    if (TextUtils.isEmpty(downloadTaskReq.downloadURL)) {
                        LogEx.d("SDKDownloadMgr", "new task add but url is empty");
                        String str2 = "";
                        if (hashMap.containsKey("RateLow")) {
                            str2 = "&RateLow=" + hashMap.get("RateLow");
                        }
                        if (hashMap.containsKey("RateHigh")) {
                            str2 = str2 + "&RateHigh=" + hashMap.get("RateHigh");
                        }
                        a(i, str, downloadTaskReq.columnCode, downloadTaskReq.programeCode, downloadTaskReq.seriesProgramCode, downloadTaskReq.definition, str2, hashMap.get("sourceType"), null);
                        return;
                    }
                    return;
                }
                a(onTaskOperReturnListener, String.valueOf(DownLoadVideo), "add new Task fail", (String) null);
                LogEx.d("SDKDownloadMgr", "new task add failed result:" + DownLoadVideo);
                return;
            }
            a(onTaskOperReturnListener, String.valueOf(1), "LocalDownLoadProxy is null, Please init LocalDownLoadProxy first", (String) null);
            return;
        }
        a(onTaskOperReturnListener, String.valueOf(1), "task is null", (String) null);
    }

    public String getDashRedirectUrl(String str) {
        String portalPropertyValueDirectly = getPortalPropertyValueDirectly("Android_Player_Type");
        LogEx.d("SDKDownloadMgr", "playertype is:" + portalPropertyValueDirectly);
        if (!DownloadConstant.REPORT_MSGTYPE_STB_RECONNECT.equals(portalPropertyValueDirectly) || str.contains(".mpd") || !getIsSupportDashUrl()) {
            return str;
        }
        return str + getDashUrlExtendParam();
    }

    public String getDashUrlExtendParam() {
        if (!getIsSupportDashUrl()) {
            return "";
        }
        return "&urlredirect=" + a() + "&NeedJITP=1&JITPMediaType=DASH&JITPDRMType=Widevine";
    }

    public void getDownloadList(String str, int i, DownloadListReturnListener downloadListReturnListener) {
        if (!com.video.androidsdk.license.a.g) {
            LogEx.e("SDKDownloadMgr", ErrMessage.LIC_INVALIDATE);
            return;
        }
        LogEx.d("SDKDownloadMgr", "getDownloadList:downloadStatus" + str + ",downloadType" + i);
        getDownloadList(str, i, "", downloadListReturnListener);
    }

    public boolean getIsSupportDashUrl() {
        return "1".equals(getPortalPropertyValueDirectly("HLS_To_DASH"));
    }

    public String getPlayURL(int i, DownloadTask downloadTask) {
        if (!com.video.androidsdk.license.a.g) {
            LogEx.e("SDKDownloadMgr", ErrMessage.LIC_INVALIDATE);
            return null;
        }
        LogEx.d("SDKDownloadMgr", "getPlayURL");
        if (downloadTask == null) {
            LogEx.e("SDKDownloadMgr", "task is null");
            return null;
        }
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return this.j + "://" + this.g + ":" + this.h + "/" + downloadTask.videoId + "/ZteLocalPlay/index.m3u8";
        }
        ProxyInterface proxyInterface = this.f3109a;
        if (proxyInterface != null) {
            String QueryVideoExpiration = proxyInterface.QueryVideoExpiration(downloadTask.videoId);
            if (TextUtils.isEmpty(QueryVideoExpiration) || QueryVideoExpiration.equals("600005")) {
                this.f3109a.UpdateKey(downloadTask.videoId);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.j);
        sb.append("://localhost:");
        sb.append(this.f3110b);
        sb.append("/");
        sb.append(downloadTask.videoId);
        String str = downloadTask.videoInfo.get("downloadURL");
        if (str != null) {
            if (str.contains("JITPMediaType=DASH")) {
                sb.append("/ZteLocalPlay/manifest.mpd");
            } else if (str.contains(DefaultHlsExtractorFactory.MP4_FILE_EXTENSION)) {
                sb.append("/ZteLocalPlay/single.mp4");
            } else {
                sb.append("/ZteLocalPlay/index.m3u8");
            }
        }
        return sb.toString();
    }

    public String getPortalPropertyValueDirectly(String str) {
        return SDKLoginMgr.getInstance().getPropertiesInfo(str);
    }

    public void getSpace(int i, String str, OnSpaceReturnListener onSpaceReturnListener) {
        if (!com.video.androidsdk.license.a.g) {
            LogEx.e("SDKDownloadMgr", ErrMessage.LIC_INVALIDATE);
            return;
        }
        LogEx.d("SDKDownloadMgr", "getSpace,Downloadtype:" + i);
        if (i != 1) {
            if (i == 2) {
                b bVar = this.e;
                if (bVar != null) {
                    bVar.a(onSpaceReturnListener);
                    return;
                } else {
                    if (onSpaceReturnListener != null) {
                        onSpaceReturnListener.onSpaceReturn(String.valueOf(1), "RemoteDownLoadProxy is null, Please init RemoteDownLoadProxy first", null);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (this.f3109a == null) {
            if (onSpaceReturnListener != null) {
                onSpaceReturnListener.onSpaceReturn(String.valueOf(1), "LocalDownLoadProxy is null, Please init LocalDownLoadProxy first", null);
                return;
            }
            return;
        }
        if (onSpaceReturnListener != null) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(DownloadConstant.GETSPACE_RESULT_MAP_KEY_TOTALSPACE, "" + this.f3109a.GetTotalSpace(str));
            hashMap.put(DownloadConstant.GETSPACE_RESULT_MAP_KEY_FREESPACE, "" + this.f3109a.GetFreeSpace(str));
            hashMap.put(DownloadConstant.GETSPACE_RESULT_MAP_KEY_AVAILABLESPACE, "" + this.f3109a.GetAvailableSpace(str));
            onSpaceReturnListener.onSpaceReturn(String.valueOf(0), "get space is ok", hashMap);
        }
    }

    public void init(DownLoadMgrInitInfo downLoadMgrInitInfo, OnInitReturnListener onInitReturnListener) {
        if (!com.video.androidsdk.license.a.g) {
            LogEx.e("SDKDownloadMgr", ErrMessage.LIC_INVALIDATE);
            return;
        }
        LogEx.d("SDKDownloadMgr", "SDKDownLoadMgr init");
        if (downLoadMgrInitInfo != null) {
            LogEx.d("SDKDownloadMgr", "SDKDownLoadMgr init downloadType:" + downLoadMgrInitInfo.downloadType);
            int a2 = a(downLoadMgrInitInfo.downloadType);
            if (a2 == 0 || (a2 & 1) > 0) {
                ProxyInterface proxyInterface = this.f3109a;
                if (proxyInterface == null) {
                    ProxyInterface proxyInterface2 = new ProxyInterface();
                    this.f3109a = proxyInterface2;
                    proxyInterface2.SetBuildVersion(Build.VERSION.SDK_INT);
                } else if (!proxyInterface.QueryProxyState()) {
                    this.f3109a.StopVideoDownload("");
                    this.f3109a.StopHttpProxyServer();
                    this.f3109a.UnInitProxyServer();
                }
                this.f3109a.UnInitProxyServer();
                a(downLoadMgrInitInfo, onInitReturnListener);
            }
            if ((a2 & 2) <= 0 || this.e != null) {
                return;
            }
            b bVar = new b();
            this.e = bVar;
            bVar.a();
            int i = 0;
            try {
                LogEx.d("SDKDownloadMgr", "RemoteDownload Minimun Size:" + downLoadMgrInitInfo.miniMumSpace);
                i = Integer.valueOf(downLoadMgrInitInfo.miniMumSpace).intValue();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            if (i > 0) {
                this.e.a(i);
                return;
            }
            return;
        }
        LogEx.d("SDKDownloadMgr", "DownLoadMgrInitInfo is null");
    }

    public void loginSTB(String str, int i, SDKDownloadLoginSTBListener sDKDownloadLoginSTBListener) {
        if (!com.video.androidsdk.license.a.g) {
            LogEx.e("SDKDownloadMgr", ErrMessage.LIC_INVALIDATE);
            return;
        }
        LogEx.d("SDKDownloadMgr", "loginSTB:addr:" + str + "port:" + i);
        new e(this, str, i, sDKDownloadLoginSTBListener).start();
    }

    public void pauseALL(int i, OnTaskOperReturnListener onTaskOperReturnListener) {
        if (!com.video.androidsdk.license.a.g) {
            LogEx.e("SDKDownloadMgr", ErrMessage.LIC_INVALIDATE);
            return;
        }
        LogEx.d("SDKDownloadMgr", "pause all Download");
        if (i == 1) {
            LogEx.d("SDKDownloadMgr", "pause all Download for local");
            ProxyInterface proxyInterface = this.f3109a;
            if (proxyInterface != null) {
                proxyInterface.StopVideoDownload("");
                a(onTaskOperReturnListener, String.valueOf(0), "pauseDownload ok", (String) null);
                return;
            } else {
                a(onTaskOperReturnListener, String.valueOf(1), "LocalDownLoadProxy is null, Please init LocalDownLoadProxy first", (String) null);
                return;
            }
        }
        if (i == 2) {
            LogEx.d("SDKDownloadMgr", "pause all Download for remote");
            b bVar = this.e;
            if (bVar != null) {
                bVar.b("", onTaskOperReturnListener);
                return;
            } else {
                a(onTaskOperReturnListener, String.valueOf(1), "RemoteDownLoadProxy is null, Please init RemoteDownLoadProxy first", (String) null);
                return;
            }
        }
        a(onTaskOperReturnListener, String.valueOf(1), "unknow download type", (String) null);
    }

    public void pauseDownload(List<DownloadTask> list, int i, OnTaskOperReturnListener onTaskOperReturnListener) {
        if (!com.video.androidsdk.license.a.g) {
            LogEx.e("SDKDownloadMgr", ErrMessage.LIC_INVALIDATE);
            return;
        }
        LogEx.d("SDKDownloadMgr", "pauseDownload");
        if (list != null && list.size() > 0) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (stringBuffer.length() > 0) {
                    stringBuffer.append("&");
                }
                stringBuffer.append(list.get(i2).videoId);
            }
            if (stringBuffer.length() <= 0) {
                a(onTaskOperReturnListener, String.valueOf(1), "no task found", (String) null);
                return;
            }
            if (i == 2) {
                LogEx.d("SDKDownloadMgr", "pauseDownload for remote");
                b bVar = this.e;
                if (bVar != null) {
                    bVar.b(stringBuffer.toString(), onTaskOperReturnListener);
                    return;
                } else {
                    a(onTaskOperReturnListener, String.valueOf(1), "RemoteDownLoadProxy is null, Please init RemoteDownLoadProxy first", (String) null);
                    return;
                }
            }
            LogEx.d("SDKDownloadMgr", "pauseDownload for local");
            ProxyInterface proxyInterface = this.f3109a;
            if (proxyInterface != null) {
                proxyInterface.StopVideoDownload(stringBuffer.toString());
                a(onTaskOperReturnListener, String.valueOf(0), "pauseDownload ok", (String) null);
                return;
            } else {
                a(onTaskOperReturnListener, String.valueOf(1), "LocalDownLoadProxy is null, Please init LocalDownLoadProxy first", (String) null);
                return;
            }
        }
        a(onTaskOperReturnListener, String.valueOf(1), "task is null", (String) null);
    }

    public void removeALL(int i, int i2, OnTaskOperReturnListener onTaskOperReturnListener) {
        if (!com.video.androidsdk.license.a.g) {
            LogEx.e("SDKDownloadMgr", ErrMessage.LIC_INVALIDATE);
            return;
        }
        LogEx.d("SDKDownloadMgr", "remove all Task dowlloadstatus:" + i + ",downloadType" + i2);
        this.i = onTaskOperReturnListener;
        if (i2 == 1) {
            ProxyInterface proxyInterface = this.f3109a;
            if (proxyInterface != null) {
                proxyInterface.DeleteFile(i);
                a(onTaskOperReturnListener, String.valueOf(0), "remove DownLoadVideo ok", (String) null);
                return;
            } else {
                a(onTaskOperReturnListener, String.valueOf(1), "LocalDownLoadProxy is null, Please init LocalDownLoadProxy first", (String) null);
                return;
            }
        }
        if (i2 == 2) {
            b bVar = this.e;
            if (bVar != null) {
                bVar.a(i, onTaskOperReturnListener);
                return;
            } else {
                a(onTaskOperReturnListener, String.valueOf(1), "RemoteDownLoadProxy is null, Please init RemoteDownLoadProxy first", (String) null);
                return;
            }
        }
        a(onTaskOperReturnListener, String.valueOf(1), "unknow download type", (String) null);
    }

    public void removeTask(List<DownloadTask> list, int i, OnTaskOperReturnListener onTaskOperReturnListener) {
        if (!com.video.androidsdk.license.a.g) {
            LogEx.e("SDKDownloadMgr", ErrMessage.LIC_INVALIDATE);
            return;
        }
        LogEx.d("SDKDownloadMgr", "remove Task");
        this.i = onTaskOperReturnListener;
        if (list != null && list.size() > 0) {
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (stringBuffer.length() > 0) {
                    stringBuffer.append("&");
                }
                if (stringBuffer2.length() > 0) {
                    stringBuffer2.append("&");
                }
                if (TextUtils.isEmpty(list.get(i2).videoId)) {
                    stringBuffer.append("*");
                } else {
                    stringBuffer.append(list.get(i2).videoId);
                }
                if (TextUtils.isEmpty(list.get(i2).seriesProgramCode)) {
                    stringBuffer2.append("*");
                } else {
                    stringBuffer2.append(list.get(i2).seriesProgramCode);
                }
            }
            LogEx.d("SDKDownloadMgr", "remove Task videoHeadIds:" + stringBuffer2.toString());
            LogEx.d("SDKDownloadMgr", "remove Task videoIds:" + stringBuffer.toString());
            if (stringBuffer.length() > 0) {
                if (i == 1) {
                    ProxyInterface proxyInterface = this.f3109a;
                    if (proxyInterface != null) {
                        proxyInterface.DeleteFile(stringBuffer2.toString(), stringBuffer.toString());
                        a(onTaskOperReturnListener, String.valueOf(0), "remove DownLoadVideo ok", (String) null);
                        return;
                    } else {
                        a(onTaskOperReturnListener, String.valueOf(1), "LocalDownLoadProxy is null, Please init LocalDownLoadProxy first", (String) null);
                        return;
                    }
                }
                if (i == 2) {
                    b bVar = this.e;
                    if (bVar != null) {
                        bVar.a(stringBuffer.toString(), stringBuffer2.toString(), onTaskOperReturnListener);
                        return;
                    } else {
                        a(onTaskOperReturnListener, String.valueOf(1), "RemoteDownLoadProxy is null, Please init RemoteDownLoadProxy first", (String) null);
                        return;
                    }
                }
                return;
            }
            return;
        }
        a(onTaskOperReturnListener, String.valueOf(1), "task is null", (String) null);
    }

    public int reset() {
        return 0;
    }

    public void setDownloadParam(String str) {
        ProxyInterface proxyInterface = this.f3109a;
        if (proxyInterface != null) {
            proxyInterface.SetDownloadParameter(str);
        }
    }

    public void setDownloadParameter(String str) {
        ProxyInterface proxyInterface = this.f3109a;
        if (proxyInterface != null) {
            proxyInterface.SetDownloadParameter(str);
        } else {
            LogEx.d("SDKDownloadMgr", "LocalDownLoadProxy is null");
        }
    }

    public void setDownloadPath(String str, String str2) {
        if (!com.video.androidsdk.license.a.g) {
            LogEx.e("SDKDownloadMgr", ErrMessage.LIC_INVALIDATE);
            return;
        }
        LogEx.d("SDKDownloadMgr", "setDownloadPath:" + str);
        ProxyInterface proxyInterface = this.f3109a;
        if (proxyInterface != null) {
            proxyInterface.ChangeVideoStorePath(str);
        } else {
            LogEx.e("SDKDownloadMgr", "LocalDownLoadProxy is null");
        }
    }

    public void setLogLevel(int i) {
        if (!com.video.androidsdk.license.a.g) {
            LogEx.e("SDKDownloadMgr", ErrMessage.LIC_INVALIDATE);
            return;
        }
        LogEx.d("SDKDownloadMgr", "setLogLevel:" + i);
        ProxyInterface proxyInterface = this.f3109a;
        if (proxyInterface != null) {
            proxyInterface.SetLogLevel(i);
        } else {
            LogEx.e("SDKDownloadMgr", "LocalDownLoadProxy is null");
        }
    }

    public void setRate(int i, String str) {
        if (!com.video.androidsdk.license.a.g) {
            LogEx.e("SDKDownloadMgr", ErrMessage.LIC_INVALIDATE);
            return;
        }
        LogEx.d("SDKDownloadMgr", "setRate:rate:" + i + "downloadType:" + str);
        if (a(str) == 1) {
            ProxyInterface proxyInterface = this.f3109a;
            if (proxyInterface != null) {
                proxyInterface.SetDownloadRate(i);
            } else {
                LogEx.e("SDKDownloadMgr", "LocalDownLoadProxy is null");
            }
        }
    }

    public void setSDKDownloadReportListener(SDKDownloadReportListener sDKDownloadReportListener) {
        if (!com.video.androidsdk.license.a.g) {
            LogEx.e("SDKDownloadMgr", ErrMessage.LIC_INVALIDATE);
            return;
        }
        this.f3111c = sDKDownloadReportListener;
        b bVar = this.e;
        if (bVar != null) {
            bVar.a(sDKDownloadReportListener);
        } else {
            LogEx.e("SDKDownloadMgr", "RemoteDownLoadProxy is null");
        }
    }

    public void setUrlExtendParam(String str) {
        this.k = str;
    }

    public void startALL(int i, OnTaskOperReturnListener onTaskOperReturnListener) {
        if (!com.video.androidsdk.license.a.g) {
            LogEx.e("SDKDownloadMgr", ErrMessage.LIC_INVALIDATE);
            return;
        }
        LogEx.d("SDKDownloadMgr", "start all Download");
        if (i != 1) {
            if (i == 2) {
                LogEx.d("SDKDownloadMgr", "start all Download for remote");
                b bVar = this.e;
                if (bVar != null) {
                    bVar.a("", onTaskOperReturnListener);
                    return;
                } else {
                    a(onTaskOperReturnListener, String.valueOf(1), "RemoteDownLoadProxy is null, Please init RemoteDownLoadProxy first", (String) null);
                    return;
                }
            }
            a(onTaskOperReturnListener, String.valueOf(1), "unknow download type", (String) null);
            return;
        }
        LogEx.d("SDKDownloadMgr", "start all Download for local");
        ProxyInterface proxyInterface = this.f3109a;
        if (proxyInterface != null) {
            int DownLoadVideo = proxyInterface.DownLoadVideo("");
            LogEx.d("SDKDownloadMgr", "start DownLoadVideo result:" + DownLoadVideo);
            if (DownLoadVideo == 0) {
                a(onTaskOperReturnListener, String.valueOf(0), "start DownLoadVideo ok", (String) null);
                return;
            }
            a(onTaskOperReturnListener, String.valueOf(1), "LocalDownLoadProxy.DownLoadVideo() returnCode is" + DownLoadVideo, (String) null);
            return;
        }
        a(onTaskOperReturnListener, String.valueOf(1), "LocalDownLoadProxy is null, Please init LocalDownLoadProxy first", (String) null);
    }

    public void startDownload(List<DownloadTask> list, int i, OnTaskOperReturnListener onTaskOperReturnListener) {
        if (!com.video.androidsdk.license.a.g) {
            LogEx.e("SDKDownloadMgr", ErrMessage.LIC_INVALIDATE);
            return;
        }
        LogEx.d("SDKDownloadMgr", "startDownload");
        if (list != null && list.size() > 0) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (stringBuffer.length() > 0) {
                    stringBuffer.append("&");
                }
                if (TextUtils.isEmpty(list.get(i2).videoId)) {
                    stringBuffer.append("*");
                } else {
                    stringBuffer.append(list.get(i2).videoId);
                }
            }
            if (stringBuffer.length() <= 0) {
                a(onTaskOperReturnListener, String.valueOf(1), "no task found", (String) null);
                return;
            }
            if (i == 2) {
                b bVar = this.e;
                if (bVar != null) {
                    bVar.a(stringBuffer.toString(), onTaskOperReturnListener);
                    return;
                } else {
                    a(onTaskOperReturnListener, String.valueOf(1), "RemoteDownLoadProxy is null, Please init RemoteDownLoadProxy first", (String) null);
                    return;
                }
            }
            ProxyInterface proxyInterface = this.f3109a;
            if (proxyInterface != null) {
                int DownLoadVideo = proxyInterface.DownLoadVideo(stringBuffer.toString());
                LogEx.d("SDKDownloadMgr", "start DownLoadVideo result:" + DownLoadVideo);
                if (DownLoadVideo == 0) {
                    a(onTaskOperReturnListener, String.valueOf(0), "start DownLoadVideo ok", (String) null);
                    return;
                }
                a(onTaskOperReturnListener, String.valueOf(1), "LocalDownLoadProxy.DownLoadVideo() returnCode is" + DownLoadVideo, (String) null);
                return;
            }
            a(onTaskOperReturnListener, String.valueOf(1), "LocalDownLoadProxy is null, Please init LocalDownLoadProxy first", (String) null);
            return;
        }
        a(onTaskOperReturnListener, String.valueOf(1), "task is null", (String) null);
    }

    public void uninit() {
        if (!com.video.androidsdk.license.a.g) {
            LogEx.e("SDKDownloadMgr", ErrMessage.LIC_INVALIDATE);
            return;
        }
        LogEx.d("SDKDownloadMgr", "Download Proxy begin uninit");
        ProxyInterface proxyInterface = this.f3109a;
        if (proxyInterface != null) {
            proxyInterface.StopVideoDownload("");
            this.f3109a.StopHttpProxyServer();
            this.f3109a.UnInitProxyServer();
            this.f3110b = 1;
        } else {
            LogEx.d("SDKDownloadMgr", "LocalDownLoadProxy is null");
        }
        b bVar = this.e;
        if (bVar != null) {
            bVar.b();
            this.e = null;
            this.f = 4;
        } else {
            LogEx.d("SDKDownloadMgr", "RemoteDownLoadProxy is null");
        }
        LogEx.d("SDKDownloadMgr", "Download Proxy finish uninit");
    }

    public void updateTask(int i, DownloadTask downloadTask) {
        if (!com.video.androidsdk.license.a.g) {
            LogEx.e("SDKDownloadMgr", ErrMessage.LIC_INVALIDATE);
            return;
        }
        LogEx.d("SDKDownloadMgr", "updateTaskInfo");
        if (downloadTask == null) {
            LogEx.e("SDKDownloadMgr", "task is null");
            return;
        }
        if (i == 1) {
            ProxyInterface proxyInterface = this.f3109a;
            if (proxyInterface != null) {
                proxyInterface.UpdateVideoInfo(downloadTask.videoId, com.video.androidsdk.download.a.a(downloadTask.videoInfo));
                return;
            } else {
                LogEx.d("SDKDownloadMgr", "LocalDownLoadProxy is null");
                return;
            }
        }
        if (i == 2) {
            b bVar = this.e;
            if (bVar != null) {
                bVar.a(downloadTask);
            } else {
                LogEx.d("SDKDownloadMgr", "RemoteDownLoadProxy is null");
            }
        }
    }

    public void updateTaskDownloadUrl(int i, DownloadTask downloadTask, OnTaskOperReturnListener onTaskOperReturnListener) {
        HashMap<String, String> hashMap;
        if (!com.video.androidsdk.license.a.g) {
            LogEx.e("SDKDownloadMgr", ErrMessage.LIC_INVALIDATE);
            return;
        }
        LogEx.d("SDKDownloadMgr", "update download url");
        String str = "";
        if (downloadTask != null && (hashMap = downloadTask.videoInfo) != null) {
            if (hashMap.containsKey("RateLow")) {
                str = "&RateLow=" + downloadTask.videoInfo.get("RateLow");
            }
            if (downloadTask.videoInfo.containsKey("RateHigh")) {
                str = str + "&RateHigh=" + downloadTask.videoInfo.get("RateHigh");
            }
            a(i, downloadTask.videoId, downloadTask.videoInfo.get("sdkcolumncode"), downloadTask.videoInfo.get("sdkprogramcode"), downloadTask.videoInfo.get("sdkseriesprogramcode"), downloadTask.videoInfo.get("sdkdefinition"), str, downloadTask.videoInfo.get("sourceType"), onTaskOperReturnListener);
            return;
        }
        LogEx.w("SDKDownloadMgr", "task == null || task.videoInfo == null");
        if (onTaskOperReturnListener != null) {
            onTaskOperReturnListener.onTaskOperReturn(WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, "input param is null", "");
        }
    }

    private void a(OnTaskOperReturnListener onTaskOperReturnListener, String str, String str2, String str3) {
        if (onTaskOperReturnListener != null) {
            onTaskOperReturnListener.onTaskOperReturn(str, str2, str3);
        }
    }

    public void getDownloadList(String str, int i, String str2, DownloadListReturnListener downloadListReturnListener) {
        if (!com.video.androidsdk.license.a.g) {
            LogEx.e("SDKDownloadMgr", ErrMessage.LIC_INVALIDATE);
            return;
        }
        LogEx.d("SDKDownloadMgr", "getDownloadList:downloadStatus" + str + ",downloadType" + i + ",seriesProgramCode" + str2);
        if (i == 1) {
            a(str, str2, downloadListReturnListener);
            return;
        }
        if (i == 2) {
            b bVar = this.e;
            if (bVar != null) {
                if (bVar.f3116a) {
                    bVar.a(str, str2, downloadListReturnListener);
                    return;
                } else {
                    downloadListReturnListener.returnDownloadTaskList(str, ErrCode.getErrCode(ErrCode.ERRCODE_DOWNLOAD_MODELCODE, 15), ErrMessage.STB_DISCONNECT, null);
                    return;
                }
            }
            LogEx.e("SDKDownloadMgr", "RemoteDownLoadProxy is null");
            downloadListReturnListener.returnDownloadTaskList(str, 1, "RemoteDownLoadProxy has not init!", null);
        }
    }

    private int a(String str) {
        try {
            return Integer.valueOf(str).intValue();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private void a(DownLoadMgrInitInfo downLoadMgrInitInfo, OnInitReturnListener onInitReturnListener) {
        int i;
        LogEx.d("SDKDownloadMgr", "begin to init localDownloadProxy!");
        this.f3109a.InitJavaCallBack();
        this.f3109a.setCallBackObject(this);
        this.f3109a.SetLogLevel(4);
        LogEx.d("SDKDownloadMgr", "DownloadAllPath：" + downLoadMgrInitInfo.downloadAllPath);
        if (!TextUtils.isEmpty(downLoadMgrInitInfo.downloadAllPath)) {
            for (String str : downLoadMgrInitInfo.downloadAllPath.split(";")) {
                try {
                    File file = new File(a(str, "."));
                    if (!file.exists() && !file.isDirectory()) {
                        file.mkdirs();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            this.f3109a.SetAllStorePath(downLoadMgrInitInfo.downloadAllPath);
        }
        try {
            LogEx.d("SDKDownloadMgr", "localDownload Minimun Size:" + downLoadMgrInitInfo.miniMumSpace);
            i = Integer.valueOf(downLoadMgrInitInfo.miniMumSpace).intValue();
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            i = 0;
        }
        if (i > 0) {
            this.f3109a.SetSpaceThreshold(i);
        }
        this.f3110b = this.f3109a.StartHttpProxyServer();
        Log.d("SDKDownloadMgr", "localDownload Proxy http server result: port=" + this.f3110b);
        if (this.f3110b == -1) {
            LogEx.e("SDKDownloadMgr", "localDownload Proxy http server Start failed!");
            this.f3109a.StopHttpProxyServer();
        }
        new a(onInitReturnListener).execute(downLoadMgrInitInfo.drmIp, downLoadMgrInitInfo.drmPort, downLoadMgrInitInfo.companyName, downLoadMgrInitInfo.mac, downLoadMgrInitInfo.drmStorePath, downLoadMgrInitInfo.downloadVideoPath, downLoadMgrInitInfo.connectNetwork);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends AsyncTask<String, String, String> {

        /* renamed from: b, reason: collision with root package name */
        private OnInitReturnListener f3114b;

        public a(OnInitReturnListener onInitReturnListener) {
            this.f3114b = onInitReturnListener;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(String... strArr) {
            int i;
            Log.e("SDKDownloadMgr", "LocalDownload Proxy is initing");
            SDKDownloadMgr.this.f3112d = 2;
            String str = strArr[0];
            LogEx.d("SDKDownloadMgr", "DRM IP:" + str);
            try {
                i = Integer.parseInt(strArr[1]);
            } catch (NumberFormatException unused) {
                i = 0;
            }
            LogEx.d("SDKDownloadMgr", "DRM Port:" + i);
            String str2 = strArr[2];
            LogEx.d("SDKDownloadMgr", "DRM Company:" + str2);
            String str3 = strArr[3];
            LogEx.d("SDKDownloadMgr", "MAC:" + str3);
            String str4 = strArr[4];
            LogEx.d("SDKDownloadMgr", "DrmPath:" + str4);
            String str5 = strArr[5];
            LogEx.d("SDKDownloadMgr", "DownloadPath:" + str5);
            Boolean bool = false;
            if (strArr[6].equals("1")) {
                bool = true;
            }
            LogEx.d("SDKDownloadMgr", "Network:" + bool);
            return SDKDownloadMgr.this.f3109a.InitProxyServer(str, i, str3, str2, str4, str5, bool.booleanValue()) == 0 ? "succ" : "fail";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            if (str.equals("succ")) {
                LogEx.d("SDKDownloadMgr", "LocalDownload Proxy init succ");
                SDKDownloadMgr.this.f3112d = 3;
                OnInitReturnListener onInitReturnListener = this.f3114b;
                if (onInitReturnListener != null) {
                    onInitReturnListener.onInitReturn(String.valueOf(0), "LocalDownload Proxy init succ");
                } else {
                    LogEx.d("SDKDownloadMgr", "init callback is null");
                }
            } else {
                LogEx.d("SDKDownloadMgr", "LocalDownload Proxy init fail");
                SDKDownloadMgr.this.f3112d = 1;
                OnInitReturnListener onInitReturnListener2 = this.f3114b;
                if (onInitReturnListener2 != null) {
                    onInitReturnListener2.onInitReturn(String.valueOf(1), "LocalDownload Proxy init fail");
                } else {
                    LogEx.d("SDKDownloadMgr", "init callback is null");
                }
            }
            super.onPostExecute(str);
        }
    }

    private String a(String str, String str2) throws IOException {
        String canonicalPath = new File(str).getCanonicalPath();
        if (canonicalPath.startsWith(new File(str2).getCanonicalPath())) {
            return canonicalPath;
        }
        throw new IllegalStateException("File is outside extraction target directory");
    }

    private void a(String str, String str2, DownloadListReturnListener downloadListReturnListener) {
        String str3;
        String str4;
        String str5 = str;
        if (this.f3109a != null) {
            ArrayList<DownloadTask> arrayList = new ArrayList<>();
            String ReportAllDownloadInfo = this.f3109a.ReportAllDownloadInfo(Integer.parseInt(str), str2);
            LogEx.d("SDKDownloadMgr", "queryAllDownloadTask-->taskType:" + str5 + ",allTaskInfo:" + ReportAllDownloadInfo);
            try {
                JSONObject jSONObject = new JSONObject(ReportAllDownloadInfo);
                int i = jSONObject.getInt("returncode");
                if (i != 0) {
                    downloadListReturnListener.returnDownloadTaskList(str5, 1, "ReportAllDownloadInfo returnCode is" + i, null);
                    return;
                }
                int i2 = jSONObject.getInt("totalcount");
                JSONArray optJSONArray = jSONObject.optJSONArray("videoid");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("totalsize");
                JSONArray optJSONArray3 = jSONObject.optJSONArray("downloadsize");
                JSONArray optJSONArray4 = jSONObject.optJSONArray("state");
                JSONArray optJSONArray5 = jSONObject.optJSONArray("contenttype");
                JSONArray optJSONArray6 = jSONObject.optJSONArray("videohead");
                JSONArray optJSONArray7 = jSONObject.optJSONArray("videoinfo");
                JSONArray optJSONArray8 = jSONObject.optJSONArray("fincount");
                str4 = "SDKDownloadMgr";
                try {
                    JSONArray optJSONArray9 = jSONObject.optJSONArray("seriescount");
                    str3 = ReportAllDownloadInfo;
                    try {
                        JSONArray optJSONArray10 = jSONObject.optJSONArray("progress");
                        int i3 = 0;
                        while (i3 < i2) {
                            int i4 = i2;
                            try {
                                DownloadTask downloadTask = new DownloadTask();
                                downloadTask.videoId = optJSONArray.optString(i3);
                                downloadTask.videoSize = optJSONArray2.optString(i3);
                                downloadTask.downloadSize = optJSONArray3.optString(i3);
                                downloadTask.status = optJSONArray4.optString(i3);
                                downloadTask.contentType = optJSONArray5.optString(i3);
                                downloadTask.seriesProgramCode = optJSONArray6.optString(i3);
                                downloadTask.finCount = optJSONArray8.optString(i3);
                                downloadTask.seriesCount = optJSONArray9.optString(i3);
                                downloadTask.progress = optJSONArray10.optString(i3);
                                downloadTask.videoInfo = com.video.androidsdk.download.a.b(optJSONArray7.optString(i3));
                                arrayList.add(downloadTask);
                                i3++;
                                i2 = i4;
                            } catch (JSONException e) {
                                e = e;
                                str5 = str;
                                LogEx.d(str4, "queryAllDownloadTask error" + str3);
                                downloadListReturnListener.returnDownloadTaskList(str5, 1, "ReportAllDownloadInfo result jsonException!", null);
                                e.printStackTrace();
                                return;
                            }
                        }
                        str5 = str;
                        downloadListReturnListener.returnDownloadTaskList(str5, 0, "ReportAllDownloadInfo ok!" + i, arrayList);
                    } catch (JSONException e2) {
                        e = e2;
                    }
                } catch (JSONException e3) {
                    e = e3;
                    str3 = ReportAllDownloadInfo;
                }
            } catch (JSONException e4) {
                e = e4;
                str3 = ReportAllDownloadInfo;
                str4 = "SDKDownloadMgr";
            }
        } else {
            downloadListReturnListener.returnDownloadTaskList(str5, 1, "LocalDownLoadProxy has not init!", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, OnTaskOperReturnListener onTaskOperReturnListener) {
        LogEx.d("SDKDownloadMgr", "getVideoDownloadUrl");
        if (!com.video.androidsdk.license.a.g) {
            LogEx.e("SDKDownloadMgr", ErrMessage.LIC_INVALIDATE);
            return;
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setParam("columncode", str2);
        sDKNetHTTPRequest.setParam("programcode", str3);
        sDKNetHTTPRequest.setParam("definition", str5);
        sDKNetHTTPRequest.startRequest(SDKLoginMgr.getInstance().getFrameHome() + RequestUrlContants.GET_VOD_URL, HttpRequest.METHOD_GET, new f(this, onTaskOperReturnListener, str7, str6, i, str, str4));
    }

    private String a() {
        String portalPropertyValueDirectly = getPortalPropertyValueDirectly("HLS_To_DASH");
        return !"1".equals(portalPropertyValueDirectly) ? "0" : portalPropertyValueDirectly;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, String str2, String str3) {
        LogEx.d("SDKDownloadMgr", "updateDownloadURL new url:" + str + "videoId:" + str2);
        if (i == 1) {
            ProxyInterface proxyInterface = this.f3109a;
            if (proxyInterface != null) {
                proxyInterface.UpdateUrl(str, str2, str3);
                return;
            } else {
                LogEx.d("SDKDownloadMgr", "LocalDownLoadProxy is null");
                return;
            }
        }
        if (i == 2) {
            b bVar = this.e;
            if (bVar != null) {
                bVar.a(str, str2, str3, null);
            } else {
                LogEx.d("SDKDownloadMgr", "RemoteDownLoadProxy is null");
            }
        }
    }
}
