package com.video.androidsdk.common.json;

import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class CreateJson {
    public static JSONArray getJsonArrayFromList(List<HashMap<String, String>> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).size() > 0) {
                    jSONArray.put(new JSONObject(list.get(i)));
                }
            }
        }
        return jSONArray;
    }

    public static JSONObject getJsonObjectFromMap(HashMap<String, String> hashMap) {
        if (hashMap != null && hashMap.size() > 0) {
            return new JSONObject(hashMap);
        }
        return new JSONObject();
    }
}
