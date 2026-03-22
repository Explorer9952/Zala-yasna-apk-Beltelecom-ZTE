package com.video.androidsdk.service.clouddvr;

import com.video.androidsdk.common.util.XML2Json;
import com.video.androidsdk.log.LogEx;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ParseRecordModXML {
    public static String xml2json(String str) throws JSONException {
        LogEx.d("ParseRecordModXML", "xmlResult:" + str);
        JSONObject jSONObject = XML2Json.toJSONObject(str);
        if (jSONObject != null) {
            LogEx.d("ParseRecordModXML", "jsonResult is:" + jSONObject.toString());
            JSONObject jSONObject2 = jSONObject.getJSONObject("schedulemodrsp");
            if (jSONObject2 == null) {
                return "";
            }
            jSONObject2.put("errormsg", jSONObject2.getString("description"));
            jSONObject2.remove("description");
            String jSONObject3 = jSONObject2.toString();
            LogEx.d("ParseRecordModXML", "final jsonResult is:" + jSONObject3);
            return jSONObject3;
        }
        LogEx.d("ParseRecordModXML", "jsonResult is null");
        return null;
    }
}
