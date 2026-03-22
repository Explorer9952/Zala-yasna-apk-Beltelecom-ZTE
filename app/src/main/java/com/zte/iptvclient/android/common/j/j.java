package com.zte.iptvclient.android.common.j;

import android.content.Context;
import android.text.TextUtils;
import com.video.androidsdk.common.PreferenceHelper;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.cache.SDKCacheMgr;
import com.video.androidsdk.sns.Constants;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.f.b.l;
import com.zte.iptvclient.android.common.javabean.column.ColumnBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: TvColumnListStorage.java */
/* loaded from: classes.dex */
public class j {
    private static String g = "channelcolumnlist";
    private static String h = "TvColumnListStorage";
    private static PreferenceHelper i;
    private static h j;

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<ColumnBean> f4692a;

    /* renamed from: b, reason: collision with root package name */
    private String f4693b;

    /* renamed from: c, reason: collision with root package name */
    private String f4694c;

    /* renamed from: d, reason: collision with root package name */
    private ColumnBean f4695d;
    private ColumnBean e;
    private ColumnBean f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TvColumnListStorage.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final j f4696a = new j();
    }

    private String d() {
        Context applicationContext = BaseApp.e().getApplicationContext();
        i = new PreferenceHelper(applicationContext, "tv_columns");
        j = new h(applicationContext);
        String string = i.getString(Constants.SINA_WEIBO_USERNAME, "");
        if (TextUtils.isEmpty(string) || !TextUtils.equals(string, j.V())) {
            return "";
        }
        String string2 = i.getString("channelColunmSort", "");
        return !TextUtils.isEmpty(string2) ? string2 : "";
    }

    public static final j e() {
        return b.f4696a;
    }

    public ArrayList<ColumnBean> a() {
        if (this.f4692a == null) {
            this.f4692a = (ArrayList) SDKCacheMgr.getAsObject(g);
        }
        if (this.f4692a == null) {
            this.f4692a = new ArrayList<>();
        }
        return this.f4692a;
    }

    public String b() {
        if (this.f4694c == null) {
            this.f4694c = d();
        }
        return this.f4694c;
    }

    public void c() {
        boolean z;
        int i2 = 0;
        boolean z2 = true;
        if (!TextUtils.isEmpty(this.f4693b)) {
            LogEx.d(h, "REMOTEJSON");
            String[] split = this.f4693b.split(";");
            if (split.length + 1 == this.f4692a.size()) {
                ArrayList arrayList = new ArrayList();
                HashMap hashMap = new HashMap();
                Iterator<ColumnBean> it2 = this.f4692a.iterator();
                while (it2.hasNext()) {
                    ColumnBean next = it2.next();
                    hashMap.put(next.getColumnCode(), next);
                }
                int length = split.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    if (!hashMap.containsKey(split[i3])) {
                        z2 = false;
                        break;
                    }
                    i3++;
                }
                if (z2) {
                    arrayList.add(this.f4692a.get(0));
                    int length2 = split.length;
                    while (i2 < length2) {
                        arrayList.add(hashMap.get(split[i2]));
                        i2++;
                    }
                    this.f4692a.clear();
                    this.f4692a.addAll(arrayList);
                    return;
                }
                return;
            }
            return;
        }
        LogEx.d(h, "LocalJson");
        String b2 = b();
        if (TextUtils.isEmpty(b2)) {
            return;
        }
        String[] split2 = b2.split(";");
        if (split2.length + 3 == this.f4692a.size()) {
            ArrayList arrayList2 = new ArrayList();
            HashMap hashMap2 = new HashMap();
            Iterator<ColumnBean> it3 = this.f4692a.iterator();
            while (it3.hasNext()) {
                ColumnBean next2 = it3.next();
                hashMap2.put(next2.getColumnCode(), next2);
            }
            int length3 = split2.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length3) {
                    z = true;
                    break;
                } else {
                    if (!hashMap2.containsKey(split2[i4])) {
                        z = false;
                        break;
                    }
                    i4++;
                }
            }
            if (z) {
                ColumnBean columnBean = this.f4692a.get(0);
                ColumnBean columnBean2 = this.f4692a.get(1);
                ColumnBean columnBean3 = this.f4692a.get(2);
                arrayList2.add(columnBean);
                arrayList2.add(columnBean2);
                arrayList2.add(columnBean3);
                int length4 = split2.length;
                while (i2 < length4) {
                    arrayList2.add(hashMap2.get(split2[i2]));
                    i2++;
                }
                this.f4692a.clear();
                this.f4692a.addAll(arrayList2);
            }
        }
    }

    private j() {
    }

    public void b(String str) {
        LogEx.d(h, "--- set Remote Json");
        this.f4693b = str;
        String readPropertie = com.zte.iptvclient.common.uiframe.h.readPropertie("Sort_control", null);
        LogEx.d(h, "mIsSortFromServer  =  " + readPropertie);
        if (TextUtils.isEmpty(readPropertie) || !readPropertie.equalsIgnoreCase("1") || a().size() <= 0) {
            return;
        }
        c();
    }

    public void a(ArrayList<ColumnBean> arrayList) {
        this.f4692a = arrayList;
        SDKCacheMgr.put(g, arrayList);
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        if ("1".equals(ConfigMgr.readPropertie("isShowSub"))) {
            this.e = arrayList.get(0);
            this.f4695d = arrayList.get(1);
            this.f = arrayList.get(2);
            return;
        }
        this.f4695d = arrayList.get(0);
    }

    public void a(String str) {
        this.f4694c = str;
        c(str);
        String readPropertie = com.zte.iptvclient.common.uiframe.h.readPropertie("Sort_control", null);
        LogEx.d(h, "mIsSortFromServer  =  " + readPropertie);
        if (!TextUtils.isEmpty(readPropertie) && readPropertie.equalsIgnoreCase("1") && com.zte.iptvclient.android.mobile.n.c.b.t()) {
            l.a(str, "TV");
        }
        if ("1".equals(ConfigMgr.readPropertie("isShowSub"))) {
            this.f4692a.add(0, this.e);
            this.f4692a.add(1, this.f4695d);
            this.f4692a.add(2, this.f);
            return;
        }
        this.f4692a.add(0, this.f4695d);
    }

    public void c(String str) {
        Context applicationContext = BaseApp.e().getApplicationContext();
        i = new PreferenceHelper(applicationContext.getApplicationContext(), "tv_columns");
        j = new h(applicationContext);
        i.putString("channelColunmSort", str);
        i.putString(Constants.SINA_WEIBO_USERNAME, j.V());
    }
}
