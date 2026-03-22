package com.video.androidsdk.download;

import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DownloadUtils.java */
/* loaded from: classes.dex */
public class a {
    public static HashMap<String, String> a(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            hashMap.put("returncode", jSONObject.optString("returncode"));
            hashMap.put("errormsg", jSONObject.optString("errormsg"));
            hashMap.put("videoid", jSONObject.optString("videoid"));
            hashMap.put("progress", jSONObject.optString("progress"));
            hashMap.put("totalsize", jSONObject.optString("totalsize"));
            hashMap.put("downloadsize", jSONObject.optString("downloadsize"));
            hashMap.put("cmd", jSONObject.optString("cmd"));
            hashMap.put("seq", jSONObject.optString("seq"));
            hashMap.put("downloadurl", jSONObject.optString("downloadurl"));
            hashMap.put("videoheadid", jSONObject.optString("videoheadid"));
            hashMap.put("videoinfo", jSONObject.optString("videoinfo"));
            hashMap.put("expiredtime", jSONObject.optString("expiredtime"));
            hashMap.put("pictureurl", jSONObject.optString("pictureurl"));
            hashMap.put("type", jSONObject.optString("type"));
            hashMap.put("videohead", jSONObject.optString("videohead"));
            hashMap.put("fincount", jSONObject.optString("fincount"));
            hashMap.put("state", jSONObject.optString("state"));
            hashMap.put("seriescount", jSONObject.optString("seriescount"));
            hashMap.put("contenttype", jSONObject.optString("contenttype"));
            hashMap.put("totalcount", jSONObject.optString("totalcount"));
            hashMap.put("currenttime", jSONObject.optString("currenttime"));
            hashMap.put("storepath", jSONObject.optString("storepath"));
            hashMap.put("totalnum", jSONObject.optString("totalnum"));
            hashMap.put("time", jSONObject.optString("time"));
            hashMap.put("videopath", jSONObject.optString("videopath"));
            hashMap.put("freesize", jSONObject.optString("freesize"));
            hashMap.put("availablesize", jSONObject.optString("availablesize"));
            hashMap.put("proxystate", jSONObject.optString("proxystate"));
            hashMap.put("sdcardpath", jSONObject.optString("sdcardpath"));
            hashMap.put("loglevel", jSONObject.optString("loglevel"));
            hashMap.put("spacesize", jSONObject.optString("spacesize"));
            hashMap.put("netstatus", jSONObject.optString("netstatus"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return hashMap;
    }

    public static HashMap<String, String> b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            HashMap<String, String> hashMap = new HashMap<>();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.optString(next));
            }
            return hashMap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String a(HashMap<String, String> hashMap) {
        return new JSONObject(hashMap).toString();
    }
}
