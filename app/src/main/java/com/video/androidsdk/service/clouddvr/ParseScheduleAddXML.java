package com.video.androidsdk.service.clouddvr;

import com.video.androidsdk.common.util.XML2Json;
import com.video.androidsdk.log.LogEx;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ParseScheduleAddXML {
    public static String xml2json(String str) throws JSONException {
        LogEx.d("ParseScheduleAddXML", "xmlResult:" + str);
        JSONObject jSONObject = XML2Json.toJSONObject(str);
        if (jSONObject != null) {
            LogEx.d("ParseScheduleAddXML", "jsonResult is:" + jSONObject.toString());
            JSONObject jSONObject2 = jSONObject.getJSONObject("scheduleaddrsp");
            if (jSONObject2 == null) {
                return "";
            }
            jSONObject2.put("errormsg", jSONObject2.getString("description"));
            jSONObject2.remove("description");
            JSONObject optJSONObject = jSONObject2.optJSONObject("conflictinfos");
            if (optJSONObject == null) {
                jSONObject2.put("data", "");
            } else {
                jSONObject2.put("data", optJSONObject.optJSONArray("conflictinfo"));
            }
            jSONObject2.remove("conflictinfos");
            String jSONObject3 = jSONObject2.toString();
            LogEx.d("ParseScheduleAddXML", "final jsonResult is:" + jSONObject3);
            return jSONObject3;
        }
        LogEx.d("ParseScheduleAddXML", "jsonResult is null");
        return null;
    }
}
