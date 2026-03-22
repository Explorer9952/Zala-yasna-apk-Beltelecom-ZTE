package com.video.androidsdk.collectAgent;

import com.video.androidsdk.common.ParamConst;
import com.video.androidsdk.common.json.CreateJson;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CollectAgent.java */
/* loaded from: classes.dex */
public final class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ JSONArray f3089a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(JSONArray jSONArray) {
        this.f3089a = jSONArray;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2;
        long j;
        ArrayList arrayList;
        JSONObject jSONObject = new JSONObject();
        try {
            str = CollectAgent.h;
            jSONObject.put(ParamConst.LOGIN_75_SESSIONID, str);
            jSONObject.put("eventtype", "E_CUSTOM");
            jSONObject.put("userdata", CreateJson.getJsonObjectFromMap(t.f3106a));
            jSONObject.put("devicedata", CreateJson.getJsonObjectFromMap(r.f3104a));
            jSONObject.put("log", this.f3089a);
            u uVar = new u();
            str2 = CollectAgent.f3072b;
            j = CollectAgent.f;
            uVar.a("E_LOGIN", jSONObject, str2, (int) j, new k(this, uVar, jSONObject));
            arrayList = CollectAgent.l;
            arrayList.clear();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
