package com.zte.iptvclient.android.common.javabean.models;

import com.video.androidsdk.common.ParamConst;
import com.video.androidsdk.log.LogEx;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ThumbNailBean.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private int f4789a = 0;

    /* renamed from: b, reason: collision with root package name */
    private String f4790b;

    public void a(int i) {
        this.f4789a = i;
    }

    public void a(ArrayList<g> arrayList) {
    }

    public String b() {
        return this.f4790b;
    }

    public void a(String str) {
        this.f4790b = str;
    }

    public int a() {
        return this.f4789a;
    }

    public static j a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        j jVar = new j();
        try {
            jVar.a(jSONObject.optInt("spritenum"));
            jVar.a(jSONObject.optString("thumbnailurl"));
            JSONArray optJSONArray = jSONObject.optJSONArray("segments");
            if (optJSONArray != null) {
                ArrayList<g> arrayList = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList.add(new g(optJSONArray.optJSONObject(i).optString("time"), optJSONArray.optJSONObject(i).optString(ParamConst.DLNA_SENDDMRGETCURRPOSITIONINFO_RSP_RELTIME)));
                }
                jVar.a(arrayList);
            }
        } catch (Exception e) {
            LogEx.e("ThumbNailBean", "paries ThumbNailBean JSONObject getException=" + e.getMessage());
        }
        return jVar;
    }
}
