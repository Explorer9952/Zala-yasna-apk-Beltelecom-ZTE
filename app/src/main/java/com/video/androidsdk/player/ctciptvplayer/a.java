package com.video.androidsdk.player.ctciptvplayer;

import android.util.Log;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PlayerJsonTool.java */
/* loaded from: classes.dex */
public class a {
    public static Map<String, String> a(List<String> list, String str) {
        if (str != null && !str.isEmpty()) {
            Log.d("PlayerJsonTool", "json is " + str);
            HashMap hashMap = new HashMap();
            try {
                JSONObject jSONObject = new JSONObject(str);
                for (int i = 0; i < list.size(); i++) {
                    String str2 = list.get(i);
                    if (str2 != null && !str2.isEmpty()) {
                        String string = jSONObject.getString(str2);
                        if (string == null) {
                            string = "";
                        }
                        Log.d("PlayerJsonTool", "key: " + str2 + "; value:" + string);
                        hashMap.put(str2, string);
                    }
                    Log.e("PlayerJsonTool", "strKey is empty or null");
                }
                Log.d("PlayerJsonTool", "map size is " + hashMap.size());
                return hashMap;
            } catch (JSONException e) {
                e.printStackTrace();
                return hashMap;
            }
        }
        Log.e("PlayerJsonTool", "strJson is null or empty");
        return null;
    }
}
