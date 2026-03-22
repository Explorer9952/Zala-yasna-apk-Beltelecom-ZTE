package com.video.androidsdk.collectAgent;

import com.video.androidsdk.common.ParamConst;
import com.video.androidsdk.common.json.CreateJson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CollectAgent.java */
/* loaded from: classes.dex */
public final class p implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        HashMap hashMap;
        HashMap hashMap2;
        HashMap hashMap3;
        String str;
        String str2;
        long j;
        JSONObject jSONObject = new JSONObject();
        hashMap = CollectAgent.r;
        for (Map.Entry entry : hashMap.entrySet()) {
            hashMap3 = CollectAgent.r;
            JSONArray jsonArrayFromList = CreateJson.getJsonArrayFromList((List) hashMap3.get(entry.getKey()));
            try {
                str = CollectAgent.h;
                jSONObject.put(ParamConst.LOGIN_75_SESSIONID, str);
                jSONObject.put("eventtype", entry.getKey());
                jSONObject.put("userdata", CreateJson.getJsonObjectFromMap(t.f3106a));
                jSONObject.put("devicedata", CreateJson.getJsonObjectFromMap(r.f3104a));
                jSONObject.put("log", jsonArrayFromList);
                u uVar = new u();
                str2 = CollectAgent.f3072b;
                j = CollectAgent.f;
                uVar.a("E_LOGIN", jSONObject, str2, (int) j, new q(this, uVar, jSONObject));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        hashMap2 = CollectAgent.r;
        hashMap2.clear();
    }
}
