package com.zte.iptvclient.android.common.f.b;

import android.text.TextUtils;
import com.video.androidsdk.SDKMgr;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.http.bean.HttpRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.bookmark.SDKBookMarkMgr;
import com.video.androidsdk.service.cache.SDKCacheMgr;
import com.zte.iptvclient.android.common.javabean.models.VoDBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;

/* compiled from: BookMarkMgr.java */
/* loaded from: classes.dex */
public class c {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BookMarkMgr.java */
    /* loaded from: classes.dex */
    public static class a implements SDKBookMarkMgr.OnAddBookMarkReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f4551a;

        a(Map map) {
            this.f4551a = map;
        }

        @Override // com.video.androidsdk.service.bookmark.SDKBookMarkMgr.OnAddBookMarkReturnListener
        public void onAddBookMarkReturn(String str, String str2) {
            LogEx.d("BookMarkMgr", "PLAYBOOKMARK\u3000Add bookMark result : " + str);
            LogEx.d("BookMarkMgr", "Add bookMark result" + str);
            if (TextUtils.equals("0", str)) {
                if (TextUtils.equals((CharSequence) this.f4551a.get("breakpoint"), "0")) {
                    c.d(this.f4551a);
                } else {
                    c.e(this.f4551a);
                }
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.s.b());
                return;
            }
            LogEx.e("BookMarkMgr", "PLAYBOOKMARK onAddBookMarkReturn faild returncode=" + str + " errormsg=" + str2);
        }
    }

    /* compiled from: BookMarkMgr.java */
    /* loaded from: classes.dex */
    static class b implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        b() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("BookMarkMgr", "Delete bookMark result" + str);
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("BookMarkMgr", "Delete bookMark resule" + i + "," + str);
        }
    }

    public static void c(Map<String, String> map) {
        if (map == null) {
            LogEx.e("BookMarkMgr", "null == mapParams");
            return;
        }
        LogEx.d("BookMarkMgr", "PLAYBOOKMARK\u3000Add bookMark params : mstrBookMarkContentcode" + map.get("contentcode") + " miCurrentPosition=" + map.get("breakpoint") + " mstrBookMarkType=" + map.get("bookmarktype"));
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("contentcode", map.get("contentcode"));
        hashMap.put("breakpoint", map.get("breakpoint"));
        hashMap.put("columncode", map.get("columncode"));
        hashMap.put("bookmarktype", map.get("bookmarktype"));
        if (d.e.a.a.a.c()) {
            hashMap.put("isshared", "1");
        } else {
            hashMap.put("isshared", "0");
        }
        hashMap.put("limitaction", d.e.a.a.a.a());
        new SDKBookMarkMgr().doAddBookMark(hashMap, new a(map));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Map<String, String> map) {
        com.zte.iptvclient.android.common.j.h hVar = new com.zte.iptvclient.android.common.j.h(SDKMgr.getApplicationContext());
        ArrayList arrayList = (ArrayList) SDKCacheMgr.getAsObject(com.zte.iptvclient.android.common.c.c.e + hVar.V());
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size() && TextUtils.equals(((VoDBean) arrayList.get(i)).d(), map.get("contentcode")) && TextUtils.equals(((VoDBean) arrayList.get(i)).c(), map.get("columncode")); i++) {
                arrayList.remove(i);
            }
        }
        SDKCacheMgr.put(com.zte.iptvclient.android.common.c.c.e + hVar.V(), arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(Map<String, String> map) {
        com.zte.iptvclient.android.common.j.h hVar = new com.zte.iptvclient.android.common.j.h(SDKMgr.getApplicationContext());
        ArrayList arrayList = (ArrayList) SDKCacheMgr.getAsObject(com.zte.iptvclient.android.common.c.c.e + hVar.V());
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size() && TextUtils.equals(((VoDBean) arrayList.get(i)).d(), map.get("contentcode")) && TextUtils.equals(((VoDBean) arrayList.get(i)).c(), map.get("columncode")); i++) {
                arrayList.remove(i);
            }
            VoDBean voDBean = new VoDBean();
            voDBean.e(map.get("breakpoint"));
            voDBean.f(map.get("columncode"));
            voDBean.d(map.get("bookmarktype"));
            voDBean.g(map.get("contentcode"));
            arrayList.add(voDBean);
            LogEx.d("BookMarkMgr", "PLAYBOOKMARK\u3000Add bookMark Cache" + voDBean.i() + " miCurrentPosition=" + voDBean.b() + " for" + voDBean.d());
            StringBuilder sb = new StringBuilder();
            sb.append(com.zte.iptvclient.android.common.c.c.e);
            sb.append(hVar.V());
            SDKCacheMgr.put(sb.toString(), arrayList);
        }
    }

    public static void a(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            LogEx.e("BookMarkMgr", "null == mapParams");
            return;
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setParam("columncode", hashMap.get("columncode"));
        sDKNetHTTPRequest.setParam("contentcode", hashMap.get("contentcode"));
        sDKNetHTTPRequest.setParam("bookmarktype", hashMap.get("bookmarktype"));
        sDKNetHTTPRequest.setParam("binduserid", hashMap.get("binduserid"));
        sDKNetHTTPRequest.setParam("copyright", hashMap.get("copyright"));
        sDKNetHTTPRequest.startRequest(String.format("%s/iptvepg/%s/delbookmarkbind.jsp", i.b(), SDKLoginMgr.getInstance().getUserInfo("StypeUrl")), HttpRequest.METHOD_GET, new b());
    }
}
