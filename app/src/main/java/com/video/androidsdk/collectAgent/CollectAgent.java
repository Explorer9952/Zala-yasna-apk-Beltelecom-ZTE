package com.video.androidsdk.collectAgent;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.video.androidsdk.common.ParamConst;
import com.video.androidsdk.common.json.CreateJson;
import com.video.androidsdk.log.LogEx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class CollectAgent {

    /* renamed from: a, reason: collision with root package name */
    public static Context f3071a = null;

    /* renamed from: b, reason: collision with root package name */
    private static String f3072b = null;

    /* renamed from: c, reason: collision with root package name */
    private static String f3073c = "";

    /* renamed from: d, reason: collision with root package name */
    private static int f3074d = 3;
    private static long e = 5;
    private static long f = 10000;
    private static boolean g = false;
    private static String h;
    private static t i;
    private static r j;
    private static ArrayList<HashMap<String, String>> l;
    private static ArrayList<HashMap<String, String>> m;
    private static ArrayList<HashMap<String, String>> n;
    private static ArrayList<HashMap<String, String>> o;
    private static ArrayList<HashMap<String, String>> p;
    private static ExecutorService q;
    private static HashMap<String, ArrayList<HashMap<String, String>>> r;
    private static s k = new s();
    private static Handler s = new Handler();
    private static Runnable t = new a();

    public static String appInstanceID() {
        String uuid = UUID.randomUUID().toString();
        h = uuid;
        h = uuid.replace("-", "");
        Log.d("CollectAgent", "appInstanceID is " + h);
        return h;
    }

    public static String getInstanceID() {
        return h;
    }

    public static void init(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            f3071a = context;
            f3072b = str;
            LogEx.d("CollectAgent", "init serDomain:" + str);
            i = new t();
            j = new r();
            l = new ArrayList<>();
            m = new ArrayList<>();
            p = new ArrayList<>();
            n = new ArrayList<>();
            o = new ArrayList<>();
            r = new HashMap<>();
            q = Executors.newFixedThreadPool(10);
            return;
        }
        LogEx.e("CollectAgent", "init error!");
    }

    public static void initWithMainDomain(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str)) {
            f3071a = context;
            f3072b = str;
            f3073c = str2;
            LogEx.d("CollectAgent", "init serDomain:" + str + " backup domain:" + str2);
            i = new t();
            j = new r();
            l = new ArrayList<>();
            m = new ArrayList<>();
            p = new ArrayList<>();
            n = new ArrayList<>();
            o = new ArrayList<>();
            r = new HashMap<>();
            q = Executors.newFixedThreadPool(10);
            return;
        }
        LogEx.e("CollectAgent", "init error!");
    }

    public static void logCommon(String str, HashMap<String, String> hashMap) {
        if (str == null) {
            return;
        }
        if (r.containsKey(str)) {
            r.get(str).add(hashMap);
            return;
        }
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        arrayList.add(hashMap);
        r.put(str, arrayList);
    }

    public static void logCrash(HashMap<String, String> hashMap) {
        if (hashMap != null) {
            n.add(hashMap);
        }
    }

    public static void logCustom(HashMap<String, String> hashMap) {
        if (hashMap != null) {
            l.add(hashMap);
        }
    }

    public static void logDebug(HashMap<String, String> hashMap) {
        if (hashMap != null) {
            n.add(hashMap);
        }
    }

    public static void logError(HashMap<String, String> hashMap) {
        if (hashMap != null) {
            n.add(hashMap);
        }
    }

    public static void logFreeze(HashMap<String, String> hashMap) {
        if (hashMap != null) {
            o.add(hashMap);
        }
    }

    public static void logLogin(HashMap<String, String> hashMap) {
        if (!g) {
            Log.d("CollectAgent", "analyticsCollectionEnabled is false");
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(hashMap);
        JSONArray jsonArrayFromList = CreateJson.getJsonArrayFromList(arrayList);
        if (jsonArrayFromList.length() > 0) {
            LogEx.d("CollectAgent", "start logLogin");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(ParamConst.LOGIN_75_SESSIONID, h);
                jSONObject.put("eventtype", k.f3105a);
                jSONObject.put("userdata", CreateJson.getJsonObjectFromMap(t.f3106a));
                jSONObject.put("devicedata", CreateJson.getJsonObjectFromMap(r.f3104a));
                jSONObject.put("log", jsonArrayFromList);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            u uVar = new u();
            uVar.a("E_LOGIN", jSONObject, f3072b, (int) f, new d(uVar, jSONObject));
        }
    }

    public static void logLogout(HashMap<String, String> hashMap) {
        if (!g) {
            Log.d("CollectAgent", "analyticsCollectionEnabled is false");
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(hashMap);
        JSONArray jsonArrayFromList = CreateJson.getJsonArrayFromList(arrayList);
        if (jsonArrayFromList.length() > 0) {
            LogEx.d("CollectAgent", "start logLogout");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(ParamConst.LOGIN_75_SESSIONID, h);
                jSONObject.put("eventtype", k.f3105a);
                jSONObject.put("userdata", CreateJson.getJsonObjectFromMap(t.f3106a));
                jSONObject.put("devicedata", CreateJson.getJsonObjectFromMap(r.f3104a));
                jSONObject.put("log", jsonArrayFromList);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            u uVar = new u();
            uVar.a("E_LOGIN", jSONObject, f3072b, (int) f, new e(uVar, jSONObject));
            g = false;
            resetAnalyticsData();
            q.shutdown();
        }
    }

    public static void logMedia(HashMap<String, String> hashMap) {
        if (hashMap != null) {
            m.add(hashMap);
        }
    }

    public static void logPage(HashMap<String, String> hashMap) {
        if (hashMap != null) {
            p.add(hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m() {
        if (!g) {
            Log.d("CollectAgent", "analyticsCollectionEnabled is false");
            return;
        }
        JSONArray jsonArrayFromList = CreateJson.getJsonArrayFromList(p);
        JSONArray jsonArrayFromList2 = CreateJson.getJsonArrayFromList(m);
        JSONArray jsonArrayFromList3 = CreateJson.getJsonArrayFromList(l);
        JSONArray jsonArrayFromList4 = CreateJson.getJsonArrayFromList(n);
        JSONArray jsonArrayFromList5 = CreateJson.getJsonArrayFromList(o);
        f fVar = new f(jsonArrayFromList);
        h hVar = new h(jsonArrayFromList2);
        j jVar = new j(jsonArrayFromList3);
        l lVar = new l(jsonArrayFromList4);
        n nVar = new n(jsonArrayFromList5);
        p pVar = new p();
        if (jsonArrayFromList.length() > 0) {
            q.execute(fVar);
        }
        if (jsonArrayFromList2.length() > 0) {
            q.execute(hVar);
        }
        if (jsonArrayFromList3.length() > 0) {
            q.execute(jVar);
        }
        if (jsonArrayFromList4.length() > 0) {
            q.execute(lVar);
        }
        if (jsonArrayFromList5.length() > 0) {
            q.execute(nVar);
        }
        if (r.size() > 0) {
            q.execute(pVar);
        }
    }

    public static void resetAnalyticsData() {
        n.clear();
        o.clear();
        l.clear();
        p.clear();
        m.clear();
        r.clear();
        i = new t();
        j = new r();
        h = appInstanceID();
    }

    public static void setAnalyticsCollectionEnabled(boolean z) {
        g = z;
    }

    public static void setDeviceInfo(String str, String str2) {
        if (str != null && r.f3104a.containsKey(str)) {
            Log.d("CollectAgent", "setDeviceInfo success");
            r.f3104a.put(str, str2);
        } else {
            LogEx.d("CollectAgent", "invalid name");
        }
    }

    public static void setReportInterval(long j2) {
        if (j2 <= 0) {
            LogEx.d("CollectAgent", "invalid aReportInterval");
        }
        e = j2;
    }

    public static void setSessionTimeoutInterval(long j2) {
        if (j2 <= 0) {
            LogEx.d("CollectAgent", "invalid timeoutInterval");
        }
        f = j2;
    }

    public static void setUserInfo(String str, String str2) {
        if (str != null && t.f3106a.containsKey(str)) {
            t.f3106a.put(str, str2);
            Log.d("CollectAgent", "setUserInfo success");
        } else {
            LogEx.d("CollectAgent", "invalid name: " + str);
        }
    }

    public static synchronized String toJsonString(HashMap<String, String> hashMap) {
        String sb;
        synchronized (CollectAgent.class) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("{");
            int i2 = 0;
            for (String str : hashMap.keySet()) {
                if (i2 > 0) {
                    sb2.append(",");
                }
                i2++;
                sb2.append("\"");
                sb2.append(str);
                sb2.append("\"");
                sb2.append(":");
                sb2.append("\"");
                sb2.append(hashMap.get(str));
                sb2.append("\"");
            }
            sb2.append("}");
            sb = sb2.toString();
        }
        return sb;
    }

    public static void uploodOntime() {
        if (!g) {
            LogEx.d("CollectAgent", "analyticsCollectionEnabled is false");
        } else {
            s.postDelayed(t, e * 60 * 1000);
            LogEx.d("CollectAgent", "start upload");
        }
    }

    public String getStrDomain() {
        return f3072b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, u uVar, JSONObject jSONObject) {
        int i2 = 1;
        boolean[] zArr = {false};
        while (!zArr[0] && i2 < f3074d) {
            i2++;
            try {
                Thread.sleep(i2 * 1000);
                uVar.a("E_LOGIN", jSONObject, f3072b, (int) f, new b(zArr));
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
        while (!zArr[0] && i2 < f3074d * 2) {
            i2++;
            try {
                Thread.sleep(i2 * 1000);
                uVar.a("E_LOGIN", jSONObject, f3072b, (int) f, new c(zArr));
            } catch (InterruptedException e3) {
                e3.printStackTrace();
            }
        }
    }
}
