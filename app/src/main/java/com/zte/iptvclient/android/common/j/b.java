package com.zte.iptvclient.android.common.j;

import android.content.Context;
import android.text.TextUtils;
import com.video.androidsdk.common.PreferenceHelper;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.sns.Constants;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.servicesdk.util.PortalConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: CurrentChannelsStorage.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    private static PreferenceHelper f4663d;
    private static h e;

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<Channel> f4664a;

    /* renamed from: b, reason: collision with root package name */
    private String f4665b;

    /* renamed from: c, reason: collision with root package name */
    private String f4666c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CurrentChannelsStorage.java */
    /* renamed from: com.zte.iptvclient.android.common.j.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0136b {

        /* renamed from: a, reason: collision with root package name */
        private static final b f4667a = new b();
    }

    private ArrayList<Channel> c() {
        ArrayList<Channel> b2 = i.d().b();
        ArrayList<Channel> arrayList = new ArrayList<>();
        String c2 = com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_RECORD_TV_COLUMN_ALL);
        if (b2 != null) {
            Iterator<Channel> it2 = b2.iterator();
            while (it2.hasNext()) {
                Channel next = it2.next();
                if (c2.equals(next.getColumncode())) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    private String d() {
        Context applicationContext = BaseApp.e().getApplicationContext();
        f4663d = new PreferenceHelper(applicationContext.getApplicationContext(), "tv_channels");
        e = new h(applicationContext);
        String string = f4663d.getString(Constants.SINA_WEIBO_USERNAME, "");
        if (TextUtils.isEmpty(string) || !TextUtils.equals(string, e.V())) {
            return "";
        }
        String string2 = f4663d.getString("tv_channels", "");
        return !TextUtils.isEmpty(string2) ? string2 : "";
    }

    public static final b e() {
        return C0136b.f4667a;
    }

    private void f() {
        int i = 0;
        boolean z = true;
        if (!TextUtils.isEmpty(this.f4666c)) {
            String[] split = this.f4666c.split(";");
            if (split.length == this.f4664a.size()) {
                ArrayList arrayList = new ArrayList();
                HashMap hashMap = new HashMap();
                Iterator<Channel> it2 = this.f4664a.iterator();
                while (it2.hasNext()) {
                    Channel next = it2.next();
                    hashMap.put(next.getMixno(), next);
                }
                int length = split.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (!hashMap.containsKey(split[i2])) {
                        z = false;
                        break;
                    }
                    i2++;
                }
                if (z) {
                    int length2 = split.length;
                    while (i < length2) {
                        arrayList.add(hashMap.get(split[i]));
                        i++;
                    }
                    this.f4664a.clear();
                    this.f4664a.addAll(arrayList);
                    return;
                }
                return;
            }
            return;
        }
        String b2 = b();
        if (TextUtils.isEmpty(b2)) {
            return;
        }
        String[] split2 = b2.split(";");
        if (split2.length == this.f4664a.size()) {
            ArrayList arrayList2 = new ArrayList();
            HashMap hashMap2 = new HashMap();
            Iterator<Channel> it3 = this.f4664a.iterator();
            while (it3.hasNext()) {
                Channel next2 = it3.next();
                hashMap2.put(next2.getMixno(), next2);
            }
            int length3 = split2.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length3) {
                    break;
                }
                if (!hashMap2.containsKey(split2[i3])) {
                    z = false;
                    break;
                }
                i3++;
            }
            if (z) {
                int length4 = split2.length;
                while (i < length4) {
                    arrayList2.add(hashMap2.get(split2[i]));
                    i++;
                }
                this.f4664a.clear();
                this.f4664a.addAll(arrayList2);
            }
        }
    }

    public ArrayList<Channel> a() {
        ArrayList<Channel> arrayList = this.f4664a;
        if (arrayList == null || arrayList.size() == 0) {
            ArrayList<Channel> c2 = c();
            this.f4664a = c2;
            a(c2);
        }
        return this.f4664a;
    }

    public String b() {
        if (this.f4665b == null) {
            this.f4665b = d();
        }
        return this.f4665b;
    }

    private b() {
    }

    public void b(String str) {
        this.f4666c = str;
        String readPropertie = com.zte.iptvclient.common.uiframe.h.readPropertie("Sort_control", null);
        LogEx.d("ForStroreCurrentChannels", "mIsSortFromServer  =  " + readPropertie);
        if (TextUtils.isEmpty(readPropertie) || !readPropertie.equalsIgnoreCase("1") || a().size() <= 0) {
            return;
        }
        f();
    }

    public void a(ArrayList<Channel> arrayList) {
        this.f4664a = arrayList;
        if (arrayList == null || arrayList.size() == 0) {
            this.f4664a = c();
        }
        f();
    }

    public void c(String str) {
        Context applicationContext = BaseApp.e().getApplicationContext();
        f4663d = new PreferenceHelper(applicationContext.getApplicationContext(), "tv_channels");
        e = new h(applicationContext);
        f4663d.putString("tv_channels", str);
        f4663d.putString(Constants.SINA_WEIBO_USERNAME, e.V());
    }

    public void a(String str) {
        this.f4665b = str;
        c(str);
        String readPropertie = com.zte.iptvclient.common.uiframe.h.readPropertie("Sort_control", null);
        LogEx.d("ForStroreCurrentChannels", "mIsSortFromServer  =  " + readPropertie);
        if (!TextUtils.isEmpty(readPropertie) && readPropertie.equalsIgnoreCase("1") && com.zte.iptvclient.android.mobile.n.c.b.t()) {
            com.zte.iptvclient.android.common.f.b.e.b(this.f4665b);
        }
    }
}
