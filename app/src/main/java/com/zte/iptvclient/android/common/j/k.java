package com.zte.iptvclient.android.common.j;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.video.androidsdk.common.PreferenceHelper;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.http.bean.HttpRequest;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.column.SDKColumnMgr;
import com.video.androidsdk.service.comm.ParamConst;
import com.video.androidsdk.service.homepage.SDKHomePageMgr;
import com.video.androidsdk.service.vod.SDKVodMgr;
import com.video.androidsdk.sns.Constants;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.f.b.l;
import com.zte.iptvclient.android.common.javabean.column.ColumnBean;
import com.zte.iptvclient.android.common.javabean.column.DynamicColumnBean;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: VideoColumnListStorage.java */
/* loaded from: classes.dex */
public class k {
    private static String j = "k";

    /* renamed from: a, reason: collision with root package name */
    private String f4697a;

    /* renamed from: b, reason: collision with root package name */
    private String f4698b;

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<ColumnBean> f4699c;

    /* renamed from: d, reason: collision with root package name */
    private f f4700d;
    private e e;
    private PreferenceHelper f;
    private com.zte.iptvclient.android.common.j.h g;
    private ArrayList<String> h;
    i i;

    /* compiled from: VideoColumnListStorage.java */
    /* loaded from: classes.dex */
    class a implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        a() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            JSONArray optJSONArray;
            ArrayList<ColumnBean> arrayList = new ArrayList<>();
            String replace = str.replace("\r\n", "");
            LogEx.d(k.j, "PCT TabMenu onDataReturn =" + replace);
            if (replace != null) {
                try {
                    JSONObject jSONObject = new JSONObject(replace);
                    if (TextUtils.equals("0000", jSONObject.optString("code")) && (optJSONArray = jSONObject.optJSONObject("message").optJSONArray("nav")) != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            arrayList.add(ColumnBean.getColumnBeanFromPCTJSon(optJSONArray.optJSONObject(i)));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    LogEx.d(k.j, "PCT TabMenu json parse error:" + e.getMessage());
                }
            }
            k.this.b(arrayList);
            if (k.this.f4700d != null) {
                k.this.f4700d.a();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.e(k.j, "PCT TabMenu onFailReturn errorcode=" + i + " errorMsg=" + str);
            k.this.f4699c = null;
            k.this.d();
            if (k.this.f4700d != null) {
                k.this.f4700d.a();
            }
        }
    }

    /* compiled from: VideoColumnListStorage.java */
    /* loaded from: classes.dex */
    class b implements SDKHomePageMgr.OnDynamicColumnListReturnListener {
        b() {
        }

        @Override // com.video.androidsdk.service.homepage.SDKHomePageMgr.OnDynamicColumnListReturnListener
        public void onDynamicColumnListReturn(String str, String str2, String str3) {
            LogEx.d(k.j, "onDynamicColumnListReturn returncode:  " + str + ",errormsg:" + str2 + ",data:" + str3);
            if (TextUtils.equals(str, "0")) {
                ArrayList<DynamicColumnBean> arrayList = new ArrayList<>();
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    if (arrayList.size() != 0) {
                        arrayList.clear();
                    }
                    for (int i = 0; i < jSONArray.length(); i++) {
                        DynamicColumnBean a2 = DynamicColumnBean.a((JSONObject) jSONArray.get(i));
                        if (a2 != null) {
                            arrayList.add(a2);
                        }
                    }
                } catch (Exception e) {
                    LogEx.e(k.j, e.getMessage());
                }
                k.this.a(arrayList);
            }
            if (k.this.e != null) {
                k.this.e.a();
            }
        }
    }

    /* compiled from: VideoColumnListStorage.java */
    /* loaded from: classes.dex */
    class c implements SDKColumnMgr.OnColumnListReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f4703a;

        c(ArrayList arrayList) {
            this.f4703a = arrayList;
        }

        @Override // com.video.androidsdk.service.column.SDKColumnMgr.OnColumnListReturnListener
        public void onColumnListReturn(String str, String str2, String str3) {
            LogEx.d(k.j, str3);
            if ("0".equals(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    if (TextUtils.equals("0", jSONObject.optString("returncode"))) {
                        int optInt = jSONObject.optInt("totalcount");
                        JSONArray optJSONArray = jSONObject.optJSONArray("data");
                        for (int i = 0; i < optInt; i++) {
                            this.f4703a.add(ColumnBean.getColumnBeanFromJSon(optJSONArray.getJSONObject(i)));
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    LogEx.w(k.j, "get getcolumn error");
                }
                k.this.b(this.f4703a);
            }
        }
    }

    /* compiled from: VideoColumnListStorage.java */
    /* loaded from: classes.dex */
    class d implements SDKVodMgr.OnVodFilterReturnListener {
        d() {
        }

        @Override // com.video.androidsdk.service.vod.SDKVodMgr.OnVodFilterReturnListener
        public void onVodFilterReturn(String str, String str2, String str3) {
            if (TextUtils.equals(str, "0")) {
                try {
                    com.zte.iptvclient.android.common.k.h.a().a(new h(new JSONObject(str3)));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* compiled from: VideoColumnListStorage.java */
    /* loaded from: classes.dex */
    public interface e {
        void a();
    }

    /* compiled from: VideoColumnListStorage.java */
    /* loaded from: classes.dex */
    public interface f {
        void a();
    }

    /* compiled from: VideoColumnListStorage.java */
    /* loaded from: classes.dex */
    private static class g {

        /* renamed from: a, reason: collision with root package name */
        private static final k f4706a = new k(null);
    }

    /* compiled from: VideoColumnListStorage.java */
    /* loaded from: classes.dex */
    private class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private JSONObject f4707a;

        public h(JSONObject jSONObject) {
            this.f4707a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            String optString = this.f4707a.optString("genrelock");
            LogEx.d(k.j, "genrelock:" + optString);
            String optString2 = this.f4707a.optString(ParamConst.VOD_GET_GENRE_LIST_RSP_GENREID);
            LogEx.d(k.j, "genreid:" + optString2);
            String[] split = optString.split(",");
            String[] split2 = optString2.split(",");
            if (split == null || split2 == null || split.length != split2.length) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < split.length; i++) {
                if ("1".equals(split[i])) {
                    arrayList.add(split2[i]);
                }
            }
            Message obtain = Message.obtain();
            obtain.what = 43521;
            obtain.obj = arrayList;
            k.this.i.sendMessage(obtain);
        }
    }

    /* compiled from: VideoColumnListStorage.java */
    /* loaded from: classes.dex */
    private static final class i extends Handler {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<k> f4709a;

        public i(k kVar) {
            this.f4709a = new WeakReference<>(kVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            k kVar = this.f4709a.get();
            if (kVar != null && message.what == 43521) {
                ArrayList arrayList = (ArrayList) message.obj;
                kVar.h.clear();
                kVar.h.addAll(arrayList);
                LogEx.d(k.j, "VideoColumnListStorage.VideoColumnHandler.handleMessage...genrelock解析结束! " + kVar.h);
            }
        }
    }

    /* synthetic */ k(a aVar) {
        this();
    }

    private String h() {
        Context applicationContext = BaseApp.e().getApplicationContext();
        this.f = new PreferenceHelper(applicationContext.getApplicationContext(), "video_column");
        this.g = new com.zte.iptvclient.android.common.j.h(applicationContext);
        String string = this.f.getString(Constants.SINA_WEIBO_USERNAME, "");
        if (TextUtils.isEmpty(string) || !TextUtils.equals(string, this.g.V())) {
            return "";
        }
        String string2 = this.f.getString("vodColunmSort", "");
        return !TextUtils.isEmpty(string2) ? string2 : "";
    }

    public static final k i() {
        return g.f4706a;
    }

    public void a(ArrayList<DynamicColumnBean> arrayList) {
    }

    public void d() {
        LogEx.d(j, "handleColumnBeanList " + this.f4698b);
        int i2 = 0;
        boolean z = true;
        if (!TextUtils.isEmpty(this.f4698b)) {
            LogEx.d(j, "mRemoteJson ");
            String[] split = this.f4698b.split(";");
            int length = split.length;
            ArrayList<ColumnBean> arrayList = this.f4699c;
            if (arrayList == null || length != arrayList.size()) {
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            HashMap hashMap = new HashMap();
            Iterator<ColumnBean> it2 = this.f4699c.iterator();
            while (it2.hasNext()) {
                ColumnBean next = it2.next();
                hashMap.put(next.getColumnCode(), next);
            }
            int length2 = split.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length2) {
                    break;
                }
                if (!hashMap.containsKey(split[i3])) {
                    z = false;
                    break;
                }
                i3++;
            }
            if (z) {
                int length3 = split.length;
                while (i2 < length3) {
                    arrayList2.add(hashMap.get(split[i2]));
                    i2++;
                }
                this.f4699c.clear();
                this.f4699c.addAll(arrayList2);
                return;
            }
            return;
        }
        String a2 = a();
        LogEx.d(j, "mLocalColumnJson " + a2);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        String[] split2 = a2.split(";");
        int length4 = split2.length;
        ArrayList<ColumnBean> arrayList3 = this.f4699c;
        if (arrayList3 == null || length4 != arrayList3.size()) {
            return;
        }
        ArrayList arrayList4 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        Iterator<ColumnBean> it3 = this.f4699c.iterator();
        while (it3.hasNext()) {
            ColumnBean next2 = it3.next();
            hashMap2.put(next2.getColumnCode(), next2);
        }
        int length5 = split2.length;
        int i4 = 0;
        while (true) {
            if (i4 >= length5) {
                break;
            }
            if (!hashMap2.containsKey(split2[i4])) {
                z = false;
                break;
            }
            i4++;
        }
        if (z) {
            int length6 = split2.length;
            while (i2 < length6) {
                arrayList4.add(hashMap2.get(split2[i2]));
                i2++;
            }
            this.f4699c.clear();
            this.f4699c.addAll(arrayList4);
        }
    }

    public void e() {
        LogEx.d(j, "sdkQueryVideoColumnGenreLock genre锁查询");
        String propertiesInfo = SDKLoginMgr.getInstance().getPropertiesInfo("Video_Column");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("columncode", propertiesInfo);
        new SDKVodMgr().getVodFilter(hashMap, new d());
    }

    public void f() {
        String propertiesInfo = SDKLoginMgr.getInstance().getPropertiesInfo("Video_Column");
        ArrayList arrayList = new ArrayList();
        SDKColumnMgr sDKColumnMgr = new SDKColumnMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("columncode", propertiesInfo);
        hashMap.put("ordertype", DownloadConstant.REPORT_MSGTYPE_ADD);
        sDKColumnMgr.getColumnList(hashMap, new c(arrayList));
    }

    private k() {
        this.h = new ArrayList<>();
        this.i = new i(this);
    }

    public ArrayList<String> b() {
        return this.h;
    }

    public ArrayList<ColumnBean> c() {
        return this.f4699c;
    }

    public void a(String str) {
        this.f4697a = str;
        c(str);
        String readPropertie = com.zte.iptvclient.common.uiframe.h.readPropertie("Sort_control", null);
        LogEx.d(j, "mIsSortFromServer  =  " + readPropertie);
        if (!TextUtils.isEmpty(readPropertie) && readPropertie.equalsIgnoreCase("1") && com.zte.iptvclient.android.mobile.n.c.b.t()) {
            l.a(str, "VOD");
        }
    }

    public void b(ArrayList<ColumnBean> arrayList) {
        this.f4699c = arrayList;
        d();
    }

    public void c(String str) {
        Context applicationContext = BaseApp.e().getApplicationContext();
        this.f = new PreferenceHelper(applicationContext.getApplicationContext(), "video_column");
        this.g = new com.zte.iptvclient.android.common.j.h(applicationContext);
        this.f.putString("vodColunmSort", str);
        this.f.putString(Constants.SINA_WEIBO_USERNAME, this.g.V());
    }

    public void b(String str) {
        LogEx.d(j, "----  " + str);
        this.f4698b = str;
        String readPropertie = com.zte.iptvclient.common.uiframe.h.readPropertie("Sort_control", null);
        LogEx.d(j, "mIsSortFromServer  =  " + readPropertie);
        if (TextUtils.isEmpty(readPropertie) || !readPropertie.equalsIgnoreCase("1") || c().size() <= 0) {
            return;
        }
        d();
    }

    public String a() {
        if (this.f4697a == null) {
            this.f4697a = h();
        }
        return this.f4697a;
    }

    public void a(f fVar) {
        String replace;
        String replace2;
        this.f4700d = fVar;
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        if (!TextUtils.isEmpty(SDKLoginMgr.getInstance().getPropertiesInfo("Pct_Column_Menu"))) {
            replace = "http://{pcthost}:{port}/pct_interface/rest/template/templateEntry/get/{menu_id}".replace("{menu_id}", SDKLoginMgr.getInstance().getPropertiesInfo("Pct_Column_Menu"));
            LogEx.e(j, "Pct_Column_Menu is null!");
        } else {
            replace = "http://{pcthost}:{port}/pct_interface/rest/template/templateEntry/get/{menu_id}".replace("{menu_id}", "column_menu");
        }
        if (!TextUtils.isEmpty(SDKLoginMgr.getInstance().getPropertiesInfo("PCT_Server"))) {
            replace2 = replace.replace("{pcthost}:{port}", SDKLoginMgr.getInstance().getPropertiesInfo("PCT_Server"));
        } else {
            replace2 = replace.replace("{pcthost}:{port}", "10.47.222.183:8080");
        }
        LogEx.d(j, "queryVideColumnListByPctMenuInterface url=" + replace2);
        sDKNetHTTPRequest.setHeader("Cookie", com.zte.iptvclient.android.common.f.b.i.h());
        sDKNetHTTPRequest.startRequest(replace2, HttpRequest.METHOD_GET, new a());
    }

    public void a(e eVar) {
        this.e = eVar;
        SDKHomePageMgr sDKHomePageMgr = new SDKHomePageMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(ParamConst.LIMIT_LIST_RSP_POSITION, "0");
        sDKHomePageMgr.getDynamicColumnList(hashMap, new b());
    }
}
