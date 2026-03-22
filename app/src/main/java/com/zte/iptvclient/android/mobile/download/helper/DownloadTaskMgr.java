package com.zte.iptvclient.android.mobile.download.helper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.drmproxy.ProxyInterface;
import com.facebook.internal.ServerProtocol;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.video.androidsdk.common.GlobalConst;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.download.SDKDownloadMgr;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.f.b.i;
import com.zte.iptvclient.android.mobile.download.bean.DownloadTaskBean;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class DownloadTaskMgr implements ProxyInterface.ClientToProxyCallBack {
    private static DownloadTaskMgr h;
    private e e;
    private d f;

    /* renamed from: a, reason: collision with root package name */
    private int f5746a = 1;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<DownloadTaskBean> f5747b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<DownloadTaskBean> f5748c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private ProxyInterface f5749d = new ProxyInterface();
    private int g = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DownloadTaskBean f5750a;

        a(DownloadTaskMgr downloadTaskMgr, DownloadTaskBean downloadTaskBean) {
            this.f5750a = downloadTaskBean;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String str2 = null;
                if ("0".equals(jSONObject.optString("returncode"))) {
                    JSONArray jSONArray = jSONObject.getJSONArray("vodInfo");
                    int i = 0;
                    while (true) {
                        if (i >= jSONArray.length()) {
                            break;
                        }
                        JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                        String string = jSONObject2.getString("definition");
                        if (!TextUtils.isEmpty(string) && string.equals("1")) {
                            string = "1";
                        } else if (!TextUtils.isEmpty(string) && string.equals("2")) {
                            string = "2";
                        } else if (!TextUtils.isEmpty(string) && string.equals("4")) {
                            string = "4";
                        } else if (!TextUtils.isEmpty(string) && string.equals("8")) {
                            string = "8";
                        } else if (!TextUtils.isEmpty(string) && string.equals(GlobalConst.WINPHONE_CLIENT)) {
                            string = GlobalConst.WINPHONE_CLIENT;
                        } else if (!TextUtils.isEmpty(string) && string.equals(GlobalConst.ANDRIODSTB_CLIENT)) {
                            string = GlobalConst.ANDRIODSTB_CLIENT;
                        }
                        if (this.f5750a.getTaskDefinition().equalsIgnoreCase(string)) {
                            str2 = jSONObject2.getString("playurl");
                            break;
                        }
                        i++;
                    }
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    DownloadTaskMgr.d().a(str2, this.f5750a.getTaskID(), this.f5750a.getTVSeriesHeadId());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.w("DownloadModule", "errorcode:" + i + " ,errormessage:" + str);
        }
    }

    /* loaded from: classes.dex */
    class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null && !action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                LogEx.d("DownloadModule", "mNetWorkReceiver action error,action is:" + action);
                return;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                DownloadTaskMgr.this.a(1);
                LogEx.d("DownloadModule", "NetWork Changed to:null");
                return;
            }
            String typeName = activeNetworkInfo.getTypeName();
            LogEx.d("DownloadModule", "NetWork Changed to:" + typeName);
            if (typeName.equalsIgnoreCase("mobile")) {
                DownloadTaskMgr.this.a(2);
            } else if (typeName.equals("WIFI")) {
                DownloadTaskMgr.this.a(3);
            }
            if (DownloadTaskMgr.this.g == 1) {
                DownloadTaskMgr.this.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends AsyncTask<String, String, String> {
        private c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(String... strArr) {
            DownloadTaskMgr.this.g = 2;
            LogEx.d("DownloadModule", "Drm begin to init independentedly");
            return DownloadTaskMgr.this.f5749d.InitDrm() == 0 ? "succ" : "fail";
        }

        /* synthetic */ c(DownloadTaskMgr downloadTaskMgr, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            if (str.equals("succ")) {
                LogEx.d("DownloadModule", "Drm init succ");
                DownloadTaskMgr.this.g = 3;
            } else {
                LogEx.e("DownloadModule", "Drm init fail");
                DownloadTaskMgr.this.g = 1;
            }
            super.onPostExecute(str);
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(String str);
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(int i, String str);
    }

    private DownloadTaskMgr() {
        new b();
    }

    private Boolean c() {
        for (int i = 0; i < this.f5747b.size(); i++) {
            if (this.f5747b.get(i).getTaskStatus() == 0 || this.f5747b.get(i).getTaskStatus() == 3) {
                return true;
            }
        }
        return false;
    }

    public static DownloadTaskMgr d() {
        if (h == null) {
            h = new DownloadTaskMgr();
        }
        return h;
    }

    private void e(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("videoid");
            String string2 = jSONObject.getString("state");
            b(string, jSONObject.getString("returncode"), jSONObject.getString("extendcode"));
            if (b(string)) {
                b(string, string2);
            } else {
                a(string, string2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void f() {
        int i = this.f5746a;
        if (i == 1) {
            LogEx.d("DownloadModule", "current network is none, give up start all download");
            return;
        }
        if (i == 2 && com.zte.iptvclient.android.mobile.download.helper.a.n().i() == 0) {
            LogEx.d("DownloadModule", "download in mobile network is not permitted, give up start all download");
            return;
        }
        if (this.f5747b.size() != 0) {
            LogEx.d("DownloadModule", "Start All Download");
            this.f5749d.DownLoadVideo("");
            for (int i2 = 0; i2 < this.f5747b.size(); i2++) {
                if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(this.f5747b.get(i2).getIsHandStop())) {
                    this.f5749d.StopVideoDownload(this.f5747b.get(i2).getTaskID());
                    this.f5747b.get(i2).setTaskStatus(2);
                } else {
                    this.f5747b.get(i2).setTaskStatus(3);
                }
            }
            a(0, "");
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.download_start);
        }
    }

    private void g() {
        if (this.f5747b.size() != 0) {
            LogEx.d("DownloadModule", "Stop All Download");
            this.f5749d.StopVideoDownload("");
            for (int i = 0; i < this.f5747b.size(); i++) {
                this.f5747b.get(i).setTaskStatus(1);
            }
            a(0, "");
        }
    }

    @Override // com.drmproxy.ProxyInterface.ClientToProxyCallBack
    public void ReportDeleteFileResult(String str) {
        if (str == null || TextUtils.equals(str, "")) {
            return;
        }
        LogEx.d("DownloadModule", "Receive proxy callback---ReportDeleteFileResult:" + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("returncode");
            String string = jSONObject.getString("videoid");
            if (i == 0) {
                LogEx.d("DownloadModule", "task del successfully ,id:" + string);
                a(2, string);
            } else {
                String string2 = jSONObject.getString("extendcode");
                LogEx.d("DownloadModule", "task del failed ,id:" + string + "extendCode:" + string2);
                a(3, string2);
            }
        } catch (JSONException e2) {
            LogEx.d("DownloadModule", "Receive proxy callback---Json Error");
            e2.printStackTrace();
        }
    }

    @Override // com.drmproxy.ProxyInterface.ClientToProxyCallBack
    public void ReportDownloadInfo(String str) {
        if (str == null || TextUtils.equals(str, "")) {
            return;
        }
        ArrayList<DownloadTaskBean> e2 = e();
        if (e2 != null && e2.size() > 0) {
            for (int i = 0; i < e2.size(); i++) {
                DownloadTaskBean downloadTaskBean = e2.get(i);
                a(downloadTaskBean.getTaskID(), downloadTaskBean.getProgramType(), downloadTaskBean.getTVSeriesHeadId(), downloadTaskBean.getColumeCode(), new a(this, downloadTaskBean));
            }
        }
        LogEx.d("DownloadModule", "Receive proxy callback---ReportDownloadInfo:" + str);
        try {
            if (new JSONObject(str).getInt("returncode") == 0) {
                f(str);
            } else {
                e(str);
            }
        } catch (JSONException e3) {
            LogEx.d("DownloadModule", "Receive proxy callback---Json Error");
            e3.printStackTrace();
        }
    }

    @Override // com.drmproxy.ProxyInterface.ClientToProxyCallBack
    public void ReportPlayError(String str) {
        String a2;
        LogEx.d("DownloadModule", "Receive proxy callback---ReportPlayError:" + str);
        com.zte.iptvclient.android.common.i.a.a.a(R.string.proxy_play_error);
        try {
            a2 = new JSONObject(str).getString("errormsg");
        } catch (JSONException unused) {
            a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.proxy_play_error);
        }
        if (this.f != null) {
            LogEx.d("DownloadModule", "Proxy Play error, notify player");
            this.f.a(a2);
        } else {
            LogEx.d("DownloadModule", "PlayerCallback is null, no need to callback");
        }
    }

    @Override // com.drmproxy.ProxyInterface.ClientToProxyCallBack
    public void ReportQueryResolution(String str) {
        LogEx.d("DownloadModule", "Receive proxy callback---ReportQueryResolution:" + str);
    }

    @Override // com.drmproxy.ProxyInterface.ClientToProxyCallBack
    public void ReportUpdatekeyResult(String str) {
        LogEx.d("DownloadModule", "Receive proxy callback---ReportUpdatekeyResult:" + str);
        try {
            if (new JSONObject(str).getString("returncode").equals("0")) {
                a(4, "");
            } else {
                a(5, "");
            }
        } catch (JSONException e2) {
            LogEx.d("DownloadModule", "ReportUpdatekeyResult json parse error");
            e2.printStackTrace();
        }
    }

    public void a(String str) {
        ProxyInterface proxyInterface = this.f5749d;
        if (proxyInterface != null) {
            proxyInterface.ChangeVideoStorePath(str);
        }
        LogEx.d("DownloadModule", "Download Path Changed:" + str);
    }

    public void b() {
        new c(this, null).execute(new String[0]);
    }

    private DownloadTaskBean d(String str) {
        int size = this.f5747b.size();
        for (int i = 0; i < size; i++) {
            DownloadTaskBean downloadTaskBean = this.f5747b.get(i);
            if (downloadTaskBean.getTaskID().equals(str)) {
                return downloadTaskBean;
            }
        }
        return null;
    }

    public boolean b(String str) {
        for (int i = 0; i < this.f5747b.size(); i++) {
            if (str.equals(this.f5747b.get(i).getTaskID())) {
                return true;
            }
        }
        return false;
    }

    private void a(int i, String str) {
        LogEx.d("DownloadModule", "Prepare to notify UI");
        e eVar = this.e;
        if (eVar != null) {
            eVar.a(i, str);
            LogEx.d("DownloadModule", "UI is notified, type=" + i + "msg=" + str);
            return;
        }
        LogEx.d("DownloadModule", "UI is null, no need to notify");
    }

    private int c(String str) {
        if ("0".equals(str)) {
            return 4;
        }
        if ("1".equals(str)) {
            return 0;
        }
        if (WeiboAuthException.DEFAULT_AUTH_ERROR_CODE.equals(str)) {
            return 1;
        }
        if ("2".equals(str)) {
        }
        return 3;
    }

    private void b(String str, String str2) {
        DownloadTaskBean d2 = d(str);
        if (d2 == null) {
            return;
        }
        a(str, d2.getVideoSize(), d2.getSizeAlreadyDownloaded(), str2);
    }

    private void b(String str, String str2, String str3) {
        String str4;
        DownloadTaskBean d2 = d(str);
        String videoName = d2 != null ? d2.getVideoName() : "";
        String str5 = videoName + ":" + com.zte.iptvclient.android.common.i.a.a.a(R.string.download_failed);
        if ("600006001".equals(str3)) {
            str4 = com.zte.iptvclient.android.common.i.a.a.a(R.string.storage_not_enough_prompt_msg);
            this.f5749d.StopVideoDownload("");
            SDKDownloadMgr.getInstance().pauseALL(1, null);
        } else {
            str4 = str5 + "(" + str2 + ")";
        }
        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(str4);
    }

    private ArrayList<DownloadTaskBean> e() {
        ArrayList<DownloadTaskBean> arrayList = new ArrayList<>();
        String ReportAllDownloadInfo = this.f5749d.ReportAllDownloadInfo(1, "");
        try {
            JSONObject jSONObject = new JSONObject(ReportAllDownloadInfo);
            if (jSONObject.getInt("returncode") == 0) {
                int i = jSONObject.getInt("totalcount");
                JSONArray jSONArray = jSONObject.getJSONArray("videoid");
                JSONArray jSONArray2 = jSONObject.getJSONArray("totalsize");
                JSONArray jSONArray3 = jSONObject.getJSONArray("downloadsize");
                JSONArray jSONArray4 = jSONObject.getJSONArray("state");
                JSONArray jSONArray5 = jSONObject.getJSONArray("videohead");
                for (int i2 = 0; i2 < i; i2++) {
                    if ("3".equals(jSONArray4.getString(i2))) {
                        DownloadTaskBean b2 = com.zte.iptvclient.android.mobile.download.helper.c.a.b(this.f5749d.QueryVideoInfo(jSONArray.getString(i2)));
                        if (b2 != null) {
                            b2.setSizeAlreadyDownloaded(jSONArray3.getInt(i2));
                            b2.setVideoSize(jSONArray2.getInt(i2));
                            b2.setTaskStatus(c(jSONArray4.getString(i2)));
                            b2.setTVSeriesHeadId(jSONArray5.getString(i2));
                            arrayList.add(b2);
                        }
                    }
                }
            }
        } catch (JSONException e2) {
            LogEx.d("DownloadModule", "error" + ReportAllDownloadInfo);
            e2.printStackTrace();
        }
        return arrayList;
    }

    public int a(String str, String str2, String str3) {
        ProxyInterface proxyInterface = this.f5749d;
        if (proxyInterface == null) {
            return -1;
        }
        return proxyInterface.UpdateUrl(str, str2, str3);
    }

    public void a() {
        JSONArray jSONArray;
        String str;
        String str2;
        String str3 = "videoid";
        String str4 = "returncode";
        this.f5748c.clear();
        String ReportAllDownloadInfo = this.f5749d.ReportAllDownloadInfo(0, "");
        try {
            JSONObject jSONObject = new JSONObject(ReportAllDownloadInfo);
            if (jSONObject.getInt("returncode") != 0) {
                return;
            }
            int i = jSONObject.getInt("totalcount");
            JSONArray jSONArray2 = jSONObject.getJSONArray("videoid");
            JSONArray jSONArray3 = jSONObject.getJSONArray("totalsize");
            JSONArray jSONArray4 = jSONObject.getJSONArray("downloadsize");
            JSONArray jSONArray5 = jSONObject.getJSONArray("state");
            JSONArray jSONArray6 = jSONObject.getJSONArray("contenttype");
            JSONArray jSONArray7 = jSONObject.getJSONArray("fincount");
            int i2 = 0;
            while (i2 < i) {
                String string = jSONArray2.getString(i2);
                String string2 = jSONArray6.getString(i2);
                int i3 = i;
                String string3 = jSONArray7.getString(i2);
                JSONArray jSONArray8 = jSONArray7;
                String QueryVideoInfo = this.f5749d.QueryVideoInfo(string);
                if ("10".equals(string2)) {
                    jSONArray = jSONArray2;
                    JSONObject jSONObject2 = new JSONObject(this.f5749d.ReportAllDownloadInfo(0, string));
                    if (jSONObject2.getInt(str4) != 0) {
                        str = str3;
                        str2 = str4;
                        i2++;
                        i = i3;
                        jSONArray7 = jSONArray8;
                        jSONArray2 = jSONArray;
                        str3 = str;
                        str4 = str2;
                    } else {
                        QueryVideoInfo = this.f5749d.QueryVideoInfo(jSONObject2.getJSONArray(str3).getString(0));
                    }
                } else {
                    jSONArray = jSONArray2;
                }
                DownloadTaskBean b2 = com.zte.iptvclient.android.mobile.download.helper.c.a.b(QueryVideoInfo);
                if (b2 != null) {
                    if ("10".equals(string2)) {
                        b2.setTaskID(string);
                        b2.setSeriesCount(string3);
                    }
                    b2.setSizeAlreadyDownloaded(jSONArray4.getInt(i2));
                    b2.setVideoSize(jSONArray3.getInt(i2));
                    b2.setTaskStatus(c(jSONArray5.getString(i2)));
                    b2.setContentType(jSONArray6.getString(i2));
                    int size = this.f5748c.size();
                    boolean z = true;
                    int i4 = 0;
                    while (i4 < size) {
                        DownloadTaskBean downloadTaskBean = this.f5748c.get(i4);
                        String str5 = str3;
                        String str6 = str4;
                        if (b2.getTaskID().equalsIgnoreCase(downloadTaskBean.getTaskID())) {
                            downloadTaskBean.setSizeAlreadyDownloaded(b2.getSizeAlreadyDownloaded());
                            z = false;
                        }
                        i4++;
                        str3 = str5;
                        str4 = str6;
                    }
                    str = str3;
                    str2 = str4;
                    if (z) {
                        this.f5748c.add(b2);
                    }
                } else {
                    str = str3;
                    str2 = str4;
                    if ("10".equals(jSONArray6.getString(i2))) {
                        this.f5749d.DeleteFile(string, "");
                    } else {
                        this.f5749d.DeleteFile(string);
                    }
                }
                i2++;
                i = i3;
                jSONArray7 = jSONArray8;
                jSONArray2 = jSONArray;
                str3 = str;
                str4 = str2;
            }
        } catch (JSONException e2) {
            LogEx.d("DownloadModule", "error" + ReportAllDownloadInfo);
            e2.printStackTrace();
        }
    }

    private void f(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("totalcount");
            JSONArray jSONArray = jSONObject.getJSONArray("videoid");
            JSONArray jSONArray2 = jSONObject.getJSONArray("totalsize");
            JSONArray jSONArray3 = jSONObject.getJSONArray("downloadsize");
            JSONArray jSONArray4 = jSONObject.getJSONArray("state");
            for (int i2 = 0; i2 < i; i2++) {
                String string = jSONArray.getString(i2);
                String string2 = jSONArray4.getString(i2);
                int i3 = jSONArray2.getInt(i2);
                int i4 = jSONArray3.getInt(i2);
                if (b(string)) {
                    a(string, i3, i4, string2);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private int b(int i) {
        if (i == this.f5746a) {
            return 911;
        }
        this.f5746a = i;
        return i;
    }

    private void a(String str, String str2) {
        DownloadTaskBean b2 = com.zte.iptvclient.android.mobile.download.helper.c.a.b(this.f5749d.QueryVideoInfo(str));
        if (b2 == null) {
            return;
        }
        b2.setTaskStatus(c(str2));
        a(b2, str2);
    }

    private void a(DownloadTaskBean downloadTaskBean, String str) {
        if ("0".equals(str)) {
            int size = this.f5748c.size();
            boolean z = true;
            for (int i = 0; i < size; i++) {
                DownloadTaskBean downloadTaskBean2 = this.f5748c.get(i);
                if (downloadTaskBean.getTaskID().equalsIgnoreCase(downloadTaskBean2.getTaskID())) {
                    downloadTaskBean2.setSizeAlreadyDownloaded(downloadTaskBean.getSizeAlreadyDownloaded());
                    z = false;
                }
            }
            if (z) {
                this.f5748c.add(downloadTaskBean);
            }
            LogEx.d("DownloadModule", "task add to downloaded list(succ)! id:" + downloadTaskBean.getTaskID());
            LogEx.d("DownloadModule", "task add to downloaded list(succ)! downloadsize:" + downloadTaskBean.getSizeAlreadyDownloaded());
        } else {
            this.f5747b.add(downloadTaskBean);
            LogEx.d("DownloadModule", "task add to downloading list(succ)! id:" + downloadTaskBean.getTaskID());
        }
        a(0, "");
    }

    private void a(String str, int i, int i2, String str2) {
        DownloadTaskBean d2 = d(str);
        if (d2 == null) {
            return;
        }
        a(d2, i, i2, str2);
    }

    private void a(DownloadTaskBean downloadTaskBean, int i, int i2, String str) {
        if (downloadTaskBean.getTaskStatus() != 2) {
            downloadTaskBean.setTaskStatus(c(str));
        }
        downloadTaskBean.setSizeAlreadyDownloaded(i2);
        downloadTaskBean.setVideoSize(i);
        if ("0".equals(str)) {
            downloadTaskBean.setSizeAlreadyDownloaded(i);
            this.f5747b.remove(downloadTaskBean);
            a();
        }
        a(0, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        int b2 = b(i);
        if (b2 == 1) {
            if (!c().booleanValue()) {
                LogEx.d("DownloadModule", "No Task Is Downloading, No need to do anything");
                return;
            } else {
                g();
                return;
            }
        }
        if (b2 == 2) {
            if (!c().booleanValue()) {
                LogEx.d("DownloadModule", "No Task Is Downloading, No need to do anything");
                return;
            } else {
                if (com.zte.iptvclient.android.mobile.download.helper.a.n().i() == 0) {
                    g();
                    return;
                }
                return;
            }
        }
        if (b2 != 3) {
            LogEx.d("DownloadModule", "network change ignored");
            return;
        }
        ArrayList<DownloadTaskBean> arrayList = this.f5747b;
        if (arrayList != null && arrayList.size() != 0) {
            if (com.zte.iptvclient.android.mobile.download.helper.a.n().i() == 0) {
                f();
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.file_downloading_in_wifi_network));
                return;
            }
            LogEx.d("DownloadModule", "Auto download in WIFI is off,No need to do anything");
            return;
        }
        LogEx.d("DownloadModule", "No Task In Downloading List, No need to do anything");
    }

    private void a(String str, String str2, String str3, String str4, SDKNetHTTPRequest.IHTTPRequestReturnListener iHTTPRequestReturnListener) {
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", i.h());
        sDKNetHTTPRequest.startRequest("http://{ipadd:port}/iptvepg/{frame}/getvideodefinitions.jsp".replace("http://{ipadd:port}/iptvepg/{frame}/", i.f()) + "?programcode=" + str + "&programtype=" + str2 + "&columncode=" + str4 + "&seriesprogramcode=" + str3, "get", iHTTPRequestReturnListener);
    }
}
