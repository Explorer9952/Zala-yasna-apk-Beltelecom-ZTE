package com.video.androidsdk.download;

import android.text.TextUtils;
import com.homecloud.HomeCloudInterface;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.ErrMessage;
import com.video.androidsdk.common.util.SessionUtil;
import com.video.androidsdk.download.Linstener.DownloadListReturnListener;
import com.video.androidsdk.download.Linstener.IDownloadListener;
import com.video.androidsdk.download.Linstener.OnSpaceReturnListener;
import com.video.androidsdk.download.Linstener.OnTaskOperReturnListener;
import com.video.androidsdk.download.Linstener.SDKDownloadReportListener;
import com.video.androidsdk.download.bean.DownloadTask;
import com.video.androidsdk.download.bean.DownloadTaskReq;
import com.video.androidsdk.log.LogEx;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RemoteDownloadMsgCenter.java */
/* loaded from: classes.dex */
public class b implements HomeCloudInterface.a {

    /* renamed from: c, reason: collision with root package name */
    private static HashMap<String, WeakReference<IDownloadListener>> f3115c;

    /* renamed from: d, reason: collision with root package name */
    private SDKDownloadReportListener f3118d;
    private int e;
    private String h;
    private int i;

    /* renamed from: a, reason: collision with root package name */
    boolean f3116a = false;
    private int g = 0;
    private Timer f = new Timer();

    /* renamed from: b, reason: collision with root package name */
    private HomeCloudInterface f3117b = new HomeCloudInterface();

    public b() {
        f3115c = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.f3117b.LoginByAddr(this.h, this.i) == 0) {
            this.g = 0;
            this.f3116a = true;
            this.f3118d.onDownloadReport(DownloadConstant.REPORT_MSGTYPE_STB_RECONNECT, String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DOWNLOAD_MODELCODE, 16)), ErrMessage.STB_RECONNECT, String.valueOf(2), null);
        } else {
            this.f3116a = false;
            Timer timer = this.f;
            d dVar = new d(this);
            int i = this.g;
            this.g = i + 1;
            timer.schedule(dVar, ((long) Math.pow(2.0d, i)) * 1000);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0055. Please report as an issue. */
    @Override // com.homecloud.HomeCloudInterface.a
    public void CallBackInfo(int i, String str) {
        WeakReference<IDownloadListener> remove;
        OnTaskOperReturnListener onTaskOperReturnListener;
        WeakReference<IDownloadListener> remove2;
        OnTaskOperReturnListener onTaskOperReturnListener2;
        WeakReference<IDownloadListener> remove3;
        DownloadListReturnListener downloadListReturnListener;
        WeakReference<IDownloadListener> remove4;
        OnSpaceReturnListener onSpaceReturnListener;
        JSONObject jSONObject;
        String optString;
        String optString2;
        String optString3;
        String str2;
        JSONArray jSONArray;
        String str3;
        String str4;
        String str5;
        String str6;
        JSONArray jSONArray2;
        JSONArray jSONArray3;
        String str7;
        String str8;
        JSONArray jSONArray4;
        String str9;
        Object obj = "RemoteDownloadMsgCenter";
        LogEx.d("RemoteDownloadMsgCenter", "SDKDownloadMgr CallBackInfo:" + i + ":" + str);
        HashMap<String, String> a2 = a.a(str);
        String str10 = a2.get("seq");
        String str11 = "sdkcolumncode";
        String str12 = "sdkdefinition";
        switch (i) {
            case DownloadConstant.MSGID_PROXY_CONNECT_EPORT /* 11001 */:
                this.f3116a = false;
                this.f3118d.onDownloadReport("8", String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DOWNLOAD_MODELCODE, 15)), ErrMessage.STB_DISCONNECT, String.valueOf(2), null);
                Timer timer = this.f;
                c cVar = new c(this);
                int i2 = this.g;
                this.g = i2 + 1;
                timer.schedule(cVar, ((long) Math.pow(2.0d, i2)) * 1000);
                return;
            case DownloadConstant.MSGID_PROXY_DOWNLOAD_VIDEO /* 50001 */:
                String str13 = a2.get("returncode");
                String str14 = a2.get("state");
                if (TextUtils.equals(str13, "0") && TextUtils.equals(str14, String.valueOf(3))) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(a2.get("videoinfo"));
                        SDKDownloadMgr.getInstance().a(2, a2.get("videoid"), jSONObject2.optString("sdkcolumncode"), jSONObject2.optString("sdkprogramcode"), jSONObject2.optString("sdkseriesprogramcode"), jSONObject2.optString(str12), "", "", null);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                if (TextUtils.isEmpty(str10) || (remove = f3115c.remove(str10)) == null || (onTaskOperReturnListener = (OnTaskOperReturnListener) remove.get()) == null) {
                    return;
                }
                onTaskOperReturnListener.onTaskOperReturn(a2.get("returncode"), a2.get("errormsg"), str);
                return;
            case DownloadConstant.MSGID_PROXY_UPDATEURL /* 50002 */:
            case DownloadConstant.MSGID_PROXY_STOPDOWNLOAD /* 50004 */:
            case DownloadConstant.MSGID_PROXY_DELETEFILE /* 50021 */:
            case DownloadConstant.MSGID_PROXY_CLEAREXPIREDDATA /* 50022 */:
            case DownloadConstant.MSGID_PROXY_SETSPACETHREASHOLD /* 50042 */:
            case DownloadConstant.MSGID_PROXY_STOPHTTPPROXYSERVER /* 50043 */:
            case DownloadConstant.MSGID_PROXY_UNINITPROXYSERVER /* 50044 */:
            case DownloadConstant.MSGID_PROXY_UPDATEKEY /* 50046 */:
            case DownloadConstant.MSGID_PROXY_INITDRM /* 50047 */:
                obj = this;
                if (!TextUtils.isEmpty(str10) && (remove2 = f3115c.remove(str10)) != null && (onTaskOperReturnListener2 = (OnTaskOperReturnListener) remove2.get()) != null) {
                    onTaskOperReturnListener2.onTaskOperReturn(a2.get("returncode"), a2.get("errormsg"), str);
                }
                return;
            case DownloadConstant.MSGID_PROXY_REPORTALLDOWNLOADINFO /* 50031 */:
                obj = this;
                if (!TextUtils.isEmpty(str10) && (remove3 = f3115c.remove(str10)) != null && (downloadListReturnListener = (DownloadListReturnListener) remove3.get()) != null) {
                    try {
                        ArrayList<DownloadTask> arrayList = new ArrayList<>();
                        JSONObject jSONObject3 = new JSONObject(str);
                        JSONArray jSONArray5 = jSONObject3.getJSONArray("videoid");
                        JSONArray jSONArray6 = jSONObject3.getJSONArray("totalsize");
                        JSONArray jSONArray7 = jSONObject3.getJSONArray("downloadsize");
                        JSONArray jSONArray8 = jSONObject3.getJSONArray("state");
                        JSONArray jSONArray9 = jSONObject3.getJSONArray("contenttype");
                        JSONArray jSONArray10 = jSONObject3.getJSONArray("videohead");
                        JSONArray jSONArray11 = jSONObject3.getJSONArray("videoinfo");
                        int i3 = 0;
                        for (int i4 = jSONObject3.getInt("totalcount"); i3 < i4; i4 = i4) {
                            DownloadTask downloadTask = new DownloadTask();
                            downloadTask.videoId = jSONArray5.getString(i3);
                            downloadTask.downloadSize = jSONArray7.getString(i3);
                            downloadTask.videoSize = jSONArray6.getString(i3);
                            downloadTask.status = jSONArray8.getString(i3);
                            downloadTask.seriesProgramCode = jSONArray10.getString(i3);
                            downloadTask.contentType = jSONArray9.getString(i3);
                            downloadTask.videoInfo = a.b(jSONArray11.optString(i3));
                            arrayList.add(downloadTask);
                            i3++;
                        }
                        downloadListReturnListener.returnDownloadTaskList(a2.get("type"), 0, "ReportAllDownloadInfo ok!" + a2.get("returncode"), arrayList);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        downloadListReturnListener.returnDownloadTaskList(a2.get("type"), 1, "ReportAllDownloadInfo result jsonException!", null);
                    }
                }
                return;
            case DownloadConstant.MSGID_PROXY_GETSPACE /* 50039 */:
                obj = this;
                if (!TextUtils.isEmpty(str10) && (remove4 = f3115c.remove(str10)) != null && (onSpaceReturnListener = (OnSpaceReturnListener) remove4.get()) != null) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put(DownloadConstant.GETSPACE_RESULT_MAP_KEY_TOTALSPACE, a2.get("totalsize"));
                    hashMap.put(DownloadConstant.GETSPACE_RESULT_MAP_KEY_FREESPACE, a2.get("freesize"));
                    hashMap.put(DownloadConstant.GETSPACE_RESULT_MAP_KEY_AVAILABLESPACE, a2.get("availablesize"));
                    onSpaceReturnListener.onSpaceReturn(a2.get("returncode"), a2.get("errormsg"), hashMap);
                }
                return;
            case DownloadConstant.MSGID_PROXY_SELFREPORT /* 50051 */:
                if (this.f3118d != null) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        try {
                            sb.append("SELFREPORT:");
                            sb.append(str);
                            LogEx.d("RemoteDownloadMsgCenter", sb.toString());
                            jSONObject = new JSONObject(str);
                            optString = jSONObject.optString("type");
                            optString2 = jSONObject.optString("returncode");
                            optString3 = jSONObject.optString("errormsg");
                            try {
                            } catch (JSONException e3) {
                                e = e3;
                                e.printStackTrace();
                                return;
                            }
                        } catch (JSONException e4) {
                            e = e4;
                            obj = this;
                        }
                    } catch (JSONException e5) {
                        e = e5;
                        obj = this;
                    }
                    if ("3".equals(optString)) {
                        int optInt = jSONObject.optInt("totalcount");
                        JSONArray optJSONArray = jSONObject.optJSONArray("videoid");
                        JSONArray optJSONArray2 = jSONObject.optJSONArray("progress");
                        JSONArray optJSONArray3 = jSONObject.optJSONArray("totalsize");
                        JSONArray optJSONArray4 = jSONObject.optJSONArray("downloadsize");
                        JSONArray optJSONArray5 = jSONObject.optJSONArray("state");
                        JSONArray optJSONArray6 = jSONObject.optJSONArray("videoinfo");
                        String str15 = "sdkseriesprogramcode";
                        ArrayList arrayList2 = new ArrayList();
                        String str16 = "sdkprogramcode";
                        int i5 = 0;
                        while (i5 < optInt) {
                            int i6 = optInt;
                            HashMap hashMap2 = new HashMap();
                            if (optJSONArray != null) {
                                str5 = str11;
                                if (i5 < optJSONArray.length()) {
                                    hashMap2.put("videoid", optJSONArray.optString(i5));
                                }
                            } else {
                                str5 = str11;
                            }
                            if (optJSONArray2 != null && i5 < optJSONArray2.length()) {
                                hashMap2.put("progress", optJSONArray2.optString(i5));
                            }
                            if (optJSONArray3 != null && i5 < optJSONArray3.length()) {
                                hashMap2.put("totalsize", optJSONArray3.optString(i5));
                            }
                            if (optJSONArray4 != null && i5 < optJSONArray4.length()) {
                                hashMap2.put("downloadsize", optJSONArray4.optString(i5));
                            }
                            if (optJSONArray5 != null && i5 < optJSONArray5.length()) {
                                hashMap2.put("state", optJSONArray5.optString(i5));
                            }
                            if (optJSONArray6 == null || i5 >= optJSONArray6.length()) {
                                str6 = null;
                            } else {
                                str6 = optJSONArray6.optString(i5);
                                hashMap2.put("videoinfo", str6);
                            }
                            if (optJSONArray != null && !TextUtils.isEmpty(optJSONArray.optString(i5))) {
                                arrayList2.add(hashMap2);
                            }
                            if (optJSONArray5 != null) {
                                jSONArray2 = optJSONArray6;
                                if (3 == optJSONArray5.optInt(i5) && !TextUtils.isEmpty(str6)) {
                                    JSONObject jSONObject4 = new JSONObject(str6);
                                    str11 = str5;
                                    String optString4 = jSONObject4.optString(str11);
                                    str8 = str16;
                                    String optString5 = jSONObject4.optString(str8);
                                    jSONArray3 = optJSONArray5;
                                    str7 = str15;
                                    String optString6 = jSONObject4.optString(str7);
                                    jSONArray4 = optJSONArray3;
                                    str9 = str12;
                                    String optString7 = jSONObject4.optString(str9);
                                    if (optJSONArray != null) {
                                        SDKDownloadMgr.getInstance().a(2, optJSONArray.optString(i5), optString4, optString5, optString6, optString7, "", "", null);
                                    }
                                    i5++;
                                    str16 = str8;
                                    str12 = str9;
                                    optJSONArray6 = jSONArray2;
                                    optJSONArray3 = jSONArray4;
                                    optInt = i6;
                                    str15 = str7;
                                    optJSONArray5 = jSONArray3;
                                }
                            } else {
                                jSONArray2 = optJSONArray6;
                            }
                            jSONArray3 = optJSONArray5;
                            str7 = str15;
                            str8 = str16;
                            str11 = str5;
                            jSONArray4 = optJSONArray3;
                            str9 = str12;
                            i5++;
                            str16 = str8;
                            str12 = str9;
                            optJSONArray6 = jSONArray2;
                            optJSONArray3 = jSONArray4;
                            optInt = i6;
                            str15 = str7;
                            optJSONArray5 = jSONArray3;
                        }
                        if (arrayList2.size() > 0) {
                            b bVar = this;
                            bVar.f3118d.onDownloadReport(optString, optString2, optString3, String.valueOf(2), arrayList2);
                            obj = bVar;
                            return;
                        }
                        obj = this;
                        return;
                    }
                    String str17 = "sdkprogramcode";
                    if (DownloadConstant.REPORT_MSGTYPE_URL_NULL.equals(optString)) {
                        int optInt2 = jSONObject.optInt("totalcount");
                        JSONArray optJSONArray7 = jSONObject.optJSONArray("videoid");
                        JSONArray optJSONArray8 = jSONObject.optJSONArray("progress");
                        JSONArray optJSONArray9 = jSONObject.optJSONArray("totalsize");
                        JSONArray optJSONArray10 = jSONObject.optJSONArray("downloadsize");
                        String str18 = str12;
                        JSONArray optJSONArray11 = jSONObject.optJSONArray("state");
                        JSONArray optJSONArray12 = jSONObject.optJSONArray("videoinfo");
                        String str19 = "sdkseriesprogramcode";
                        int i7 = 0;
                        while (i7 < optInt2) {
                            int i8 = optInt2;
                            HashMap hashMap3 = new HashMap();
                            String str20 = str17;
                            if (i7 < optJSONArray7.length()) {
                                hashMap3.put("videoid", optJSONArray7.optString(i7));
                            }
                            if (i7 < optJSONArray8.length()) {
                                hashMap3.put("progress", optJSONArray8.optString(i7));
                            }
                            if (i7 < optJSONArray9.length()) {
                                hashMap3.put("totalsize", optJSONArray9.optString(i7));
                            }
                            if (i7 < optJSONArray10.length()) {
                                hashMap3.put("downloadsize", optJSONArray10.optString(i7));
                            }
                            if (i7 < optJSONArray11.length()) {
                                hashMap3.put("state", optJSONArray11.optString(i7));
                            }
                            if (i7 < optJSONArray12.length()) {
                                str2 = optJSONArray12.optString(i7);
                                hashMap3.put("videoinfo", str2);
                            } else {
                                str2 = null;
                            }
                            JSONArray jSONArray12 = optJSONArray12;
                            if (3 != optJSONArray11.optInt(i7) || TextUtils.isEmpty(str2)) {
                                jSONArray = optJSONArray10;
                                str3 = str18;
                                str4 = str19;
                                str17 = str20;
                            } else {
                                JSONObject jSONObject5 = new JSONObject(str2);
                                str17 = str20;
                                str4 = str19;
                                jSONArray = optJSONArray10;
                                str3 = str18;
                                SDKDownloadMgr.getInstance().a(2, optJSONArray7.optString(i7), jSONObject5.optString("sdkcolumncode"), jSONObject5.optString(str17), jSONObject5.optString(str4), jSONObject5.optString(str3), "", "", null);
                            }
                            i7++;
                            optJSONArray12 = jSONArray12;
                            str18 = str3;
                            str19 = str4;
                            optJSONArray10 = jSONArray;
                            optInt2 = i8;
                        }
                        obj = this;
                        return;
                    }
                    ArrayList arrayList3 = new ArrayList();
                    HashMap hashMap4 = new HashMap();
                    hashMap4.put("videoid", jSONObject.optString("videoid"));
                    hashMap4.put("state", jSONObject.optString("state"));
                    arrayList3.add(hashMap4);
                    b bVar2 = this;
                    bVar2.f3118d.onDownloadReport(optString, optString2, optString3, String.valueOf(2), arrayList3);
                    obj = bVar2;
                    return;
                }
                break;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f3117b.setCallBackObject(null);
        HashMap<String, WeakReference<IDownloadListener>> hashMap = f3115c;
        if (hashMap != null) {
            hashMap.clear();
            f3115c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f3117b.setCallBackObject(this);
        this.f3117b.HCEnvInit("", "", "", "", "", 3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(String str, int i) {
        int i2;
        this.g = 0;
        this.h = str;
        this.i = i;
        int LoginByAddr = this.f3117b.LoginByAddr(str, i);
        if (LoginByAddr == 0) {
            this.f3116a = true;
        } else {
            this.f3116a = false;
        }
        if (LoginByAddr == 0 && (i2 = this.e) > 0) {
            c(String.valueOf(i2), null);
        }
        return LoginByAddr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str, OnTaskOperReturnListener onTaskOperReturnListener) {
        JSONObject jSONObject = new JSONObject();
        String genSessionID = SessionUtil.genSessionID();
        try {
            jSONObject.put("cmd", "stopvideodownload");
            jSONObject.put("seq", genSessionID);
            jSONObject.put("videoid", str);
            if (onTaskOperReturnListener != null && !TextUtils.isEmpty(genSessionID)) {
                f3115c.put(genSessionID, new WeakReference<>(onTaskOperReturnListener));
            }
            a(DownloadConstant.MSGID_PROXY_STOPDOWNLOAD, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
            if (onTaskOperReturnListener != null) {
                onTaskOperReturnListener.onTaskOperReturn(String.valueOf(1), "stopVideoDownload for remote jsonError", null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SDKDownloadReportListener sDKDownloadReportListener) {
        this.f3118d = sDKDownloadReportListener;
    }

    private void c(String str, OnTaskOperReturnListener onTaskOperReturnListener) {
        JSONObject jSONObject = new JSONObject();
        String genSessionID = SessionUtil.genSessionID();
        try {
            jSONObject.put("cmd", "setspacethreashold");
            jSONObject.put("seq", genSessionID);
            jSONObject.put("spacesize", str);
            if (onTaskOperReturnListener != null && !TextUtils.isEmpty(genSessionID)) {
                f3115c.put(genSessionID, new WeakReference<>(onTaskOperReturnListener));
            }
            a(DownloadConstant.MSGID_PROXY_SETSPACETHREASHOLD, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
            if (onTaskOperReturnListener != null) {
                onTaskOperReturnListener.onTaskOperReturn(String.valueOf(1), "setSpaceThreashold for remote jsonError", null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(DownloadTaskReq downloadTaskReq, HashMap<String, String> hashMap, OnTaskOperReturnListener onTaskOperReturnListener) {
        JSONObject jSONObject = new JSONObject();
        String genSessionID = SessionUtil.genSessionID();
        try {
            jSONObject.put("cmd", "downloadvideo");
            jSONObject.put("seq", genSessionID);
            jSONObject.put("downloadurl", downloadTaskReq.downloadURL);
            jSONObject.put("videoheadid", downloadTaskReq.seriesProgramCode);
            jSONObject.put("videoinfo", a.a(hashMap));
            jSONObject.put("expiredtime", downloadTaskReq.expiredTime);
            jSONObject.put("pictureurl", downloadTaskReq.pictureURL);
            if (TextUtils.isEmpty(downloadTaskReq.seriesProgramCode)) {
                jSONObject.put("videoid", downloadTaskReq.programeCode + downloadTaskReq.definition);
                jSONObject.put("type", "0");
            } else {
                jSONObject.put("videoid", downloadTaskReq.seriesProgramCode + downloadTaskReq.programeCode + downloadTaskReq.definition);
                jSONObject.put("type", "1");
            }
            f3115c.put(genSessionID, new WeakReference<>(onTaskOperReturnListener));
            a(DownloadConstant.MSGID_PROXY_DOWNLOAD_VIDEO, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
            if (onTaskOperReturnListener != null) {
                onTaskOperReturnListener.onTaskOperReturn(String.valueOf(1), "addDownloadTask for remote jsonError", null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, OnTaskOperReturnListener onTaskOperReturnListener) {
        JSONObject jSONObject = new JSONObject();
        String genSessionID = SessionUtil.genSessionID();
        try {
            jSONObject.put("cmd", "deletefile");
            jSONObject.put("seq", genSessionID);
            jSONObject.put("videoid", str);
            jSONObject.put("videoheadid", str2);
            if (onTaskOperReturnListener != null && !TextUtils.isEmpty(genSessionID)) {
                f3115c.put(genSessionID, new WeakReference<>(onTaskOperReturnListener));
            }
            a(DownloadConstant.MSGID_PROXY_DELETEFILE, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
            if (onTaskOperReturnListener != null) {
                onTaskOperReturnListener.onTaskOperReturn(String.valueOf(1), "deleteDownloadTask for remote jsonError", null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, OnTaskOperReturnListener onTaskOperReturnListener) {
        JSONObject jSONObject = new JSONObject();
        String genSessionID = SessionUtil.genSessionID();
        try {
            jSONObject.put("cmd", "deletefile");
            jSONObject.put("seq", genSessionID);
            jSONObject.put("deletetype", i);
            if (onTaskOperReturnListener != null && !TextUtils.isEmpty(genSessionID)) {
                f3115c.put(genSessionID, new WeakReference<>(onTaskOperReturnListener));
            }
            a(DownloadConstant.MSGID_PROXY_DELETEFILE, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
            if (onTaskOperReturnListener != null) {
                onTaskOperReturnListener.onTaskOperReturn(String.valueOf(1), "deleteDownloadTask for remote jsonError", null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, OnTaskOperReturnListener onTaskOperReturnListener) {
        JSONObject jSONObject = new JSONObject();
        String genSessionID = SessionUtil.genSessionID();
        try {
            jSONObject.put("cmd", "downloadvideo");
            jSONObject.put("seq", genSessionID);
            jSONObject.put("type", "2");
            jSONObject.put("downloadurl", "");
            jSONObject.put("videoid", str);
            jSONObject.put("videoheadid", "");
            jSONObject.put("videoinfo", "");
            jSONObject.put("expiredtime", "");
            jSONObject.put("pictureurl", "");
            f3115c.put(genSessionID, new WeakReference<>(onTaskOperReturnListener));
            a(DownloadConstant.MSGID_PROXY_DOWNLOAD_VIDEO, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
            if (onTaskOperReturnListener != null) {
                onTaskOperReturnListener.onTaskOperReturn(String.valueOf(1), "startDownloadTask for remote jsonError", null);
            }
        }
    }

    public void a(String str, String str2, DownloadListReturnListener downloadListReturnListener) {
        JSONObject jSONObject = new JSONObject();
        String genSessionID = SessionUtil.genSessionID();
        try {
            jSONObject.put("cmd", "reportalldownloadinfo");
            jSONObject.put("seq", genSessionID);
            jSONObject.put("type", str);
            jSONObject.put("videoheadid", str2);
            if (downloadListReturnListener != null && !TextUtils.isEmpty(genSessionID)) {
                f3115c.put(genSessionID, new WeakReference<>(downloadListReturnListener));
            }
            a(DownloadConstant.MSGID_PROXY_REPORTALLDOWNLOADINFO, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
            if (downloadListReturnListener != null) {
                downloadListReturnListener.returnDownloadTaskList(str, 1, "reportAllDownloadInfo for remote jsonError", null);
            }
        }
    }

    public void a(DownloadTask downloadTask) {
        JSONObject jSONObject = new JSONObject();
        String genSessionID = SessionUtil.genSessionID();
        try {
            jSONObject.put("cmd", "updatevideoinfo");
            jSONObject.put("seq", genSessionID);
            jSONObject.put("videoid", downloadTask.videoId);
            jSONObject.put("videoinfo", a.a(downloadTask.videoInfo));
            a(DownloadConstant.MSGID_PROXY_UPDATEVIDEOINFO, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void a(String str, String str2, String str3, OnTaskOperReturnListener onTaskOperReturnListener) {
        JSONObject jSONObject = new JSONObject();
        String genSessionID = SessionUtil.genSessionID();
        try {
            jSONObject.put("cmd", "updateurl");
            jSONObject.put("seq", genSessionID);
            jSONObject.put("downloadurl", str);
            jSONObject.put("videoid", str2);
            jSONObject.put("videoheadid", str3);
            if (onTaskOperReturnListener != null && !TextUtils.isEmpty(genSessionID)) {
                f3115c.put(genSessionID, new WeakReference<>(onTaskOperReturnListener));
            }
            a(DownloadConstant.MSGID_PROXY_UPDATEURL, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void a(OnSpaceReturnListener onSpaceReturnListener) {
        JSONObject jSONObject = new JSONObject();
        String genSessionID = SessionUtil.genSessionID();
        try {
            jSONObject.put("cmd", "queryspacesize");
            jSONObject.put("seq", genSessionID);
            jSONObject.put("videopath", "");
            if (onSpaceReturnListener != null && !TextUtils.isEmpty(genSessionID)) {
                f3115c.put(genSessionID, new WeakReference<>(onSpaceReturnListener));
            }
            a(DownloadConstant.MSGID_PROXY_GETSPACE, jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
            if (onSpaceReturnListener != null) {
                onSpaceReturnListener.onSpaceReturn(String.valueOf(1), "getspace jsonError", null);
            }
        }
    }

    private void a(int i, String str) {
        LogEx.d("RemoteDownloadMsgCenter", "SDKDownloadMgr sendMsg:" + i + ":" + str);
        this.f3117b.SendMessage(i, str);
    }

    public void a(int i) {
        this.e = i;
    }
}
