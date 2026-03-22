package com.video.androidsdk.service.clouddvr;

import com.video.androidsdk.common.util.XML2Json;
import com.video.androidsdk.log.LogEx;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ParseRecordListQueryXML {
    public static String xml2json(String str) throws JSONException {
        LogEx.d("ParseRecordListQueryXML", "xmlResult:" + str);
        JSONObject jSONObject = XML2Json.toJSONObject(str);
        if (jSONObject != null) {
            LogEx.d("ParseRecordListQueryXML", "jsonResult is:" + jSONObject.toString());
            JSONObject jSONObject2 = jSONObject.getJSONObject("recordlistqueryrsp");
            if (jSONObject2 == null) {
                return "";
            }
            Object obj = jSONObject2.get("recordinfos");
            if (obj != null && (obj instanceof JSONObject)) {
                Object obj2 = ((JSONObject) obj).get("recordinfo");
                if (obj2 != null && (obj2 instanceof JSONObject)) {
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(obj2);
                    jSONObject2.put("data", jSONArray);
                } else if (obj2 != null && (obj2 instanceof JSONArray)) {
                    jSONObject2.put("data", obj2);
                } else {
                    jSONObject2.put("data", obj);
                }
            } else {
                jSONObject2.put("data", obj);
            }
            jSONObject2.remove("recordinfos");
            String jSONObject3 = jSONObject2.toString();
            LogEx.d("ParseRecordListQueryXML", "final jsonResult is:" + jSONObject3);
            return jSONObject3;
        }
        LogEx.d("ParseRecordListQueryXML", "jsonResult is null");
        return null;
    }
}
