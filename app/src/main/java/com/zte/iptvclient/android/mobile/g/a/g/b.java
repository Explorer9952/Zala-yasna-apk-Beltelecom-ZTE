package com.zte.iptvclient.android.mobile.g.a.g;

import android.text.TextUtils;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.prevue.SDKPrevueMgr;
import com.zte.iptvclient.android.mobile.g.a.d;
import com.zte.iptvclient.android.mobile.g.a.e;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: PrevueTask.java */
/* loaded from: classes.dex */
public class b implements e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f6259a = "com.zte.iptvclient.android.mobile.g.a.g.b";

    /* compiled from: PrevueTask.java */
    /* loaded from: classes.dex */
    class a implements SDKPrevueMgr.OnPrevueDetailWithUrlReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f6260a;

        a(b bVar, d dVar) {
            this.f6260a = dVar;
        }

        @Override // com.video.androidsdk.service.prevue.SDKPrevueMgr.OnPrevueDetailWithUrlReturnListener
        public void onPrevueDetailWithUrlReturn(String str, String str2, String str3) {
            LogEx.d(b.f6259a, "errorCode = " + str + " errorMsg = " + str2 + " resultJson = " + str3);
            if ("0".equals(str)) {
                ArrayList arrayList = new ArrayList();
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        com.zte.iptvclient.android.common.javabean.models.d a2 = com.zte.iptvclient.android.common.javabean.models.d.a(jSONObject);
                        if (a2 != null && !TextUtils.isEmpty(a2.k())) {
                            a2.u("0");
                            if (jSONObject.has("productList")) {
                                JSONArray jSONArray2 = jSONObject.getJSONArray("productList");
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= jSONArray2.length()) {
                                        break;
                                    }
                                    String optString = jSONArray2.getJSONObject(i2).optString("productname");
                                    if (optString != null && optString.contains("VIP")) {
                                        a2.u("1");
                                        break;
                                    }
                                    i2++;
                                }
                            }
                            arrayList.add(a2);
                        }
                    }
                    this.f6260a.a((d) arrayList);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    LogEx.e(b.f6259a, e.getMessage());
                    this.f6260a.a(str2);
                    return;
                }
            }
            this.f6260a.a(str2);
        }
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.e
    public void a(String str, String str2, String str3, d dVar) {
        SDKPrevueMgr sDKPrevueMgr = new SDKPrevueMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("prevuecode", str);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("mediaservices", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("recommendtype", str3);
        }
        LogEx.d(f6259a, "request params = " + hashMap.toString());
        sDKPrevueMgr.getPrevueDetailWithUrl(hashMap, new a(this, dVar));
    }
}
