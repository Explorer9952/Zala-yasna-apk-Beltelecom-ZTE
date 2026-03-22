package com.video.androidsdk.service.clouddvr;

import com.video.androidsdk.common.util.XML2Json;
import com.video.androidsdk.log.LogEx;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ParseRecordDelXML {
    public static String xml2json(String str) throws JSONException {
        LogEx.d("ParseRecordDelXML", "xmlResult:" + str);
        JSONObject jSONObject = XML2Json.toJSONObject(str);
        if (jSONObject != null) {
            LogEx.d("ParseRecordDelXML", "jsonResult is:" + jSONObject.toString());
            JSONObject jSONObject2 = jSONObject.getJSONObject("recorddelrsp");
            if (jSONObject2 == null) {
                return "";
            }
            jSONObject2.put("errormsg", jSONObject2.getString("description"));
            jSONObject2.remove("description");
            String jSONObject3 = jSONObject2.toString();
            LogEx.d("ParseRecordDelXML", "final jsonResult is:" + jSONObject3);
            return jSONObject3;
        }
        LogEx.d("ParseRecordDelXML", "jsonResult is null");
        return null;
    }
}
