package com.video.androidsdk.service.clouddvr;

import com.video.androidsdk.common.util.XML2Json;
import com.video.androidsdk.log.LogEx;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ParseScheduleInfoQueryXML {
    public static String xml2json(String str) throws JSONException {
        LogEx.d("ParseScheduleInfoQueryXML", "xmlResult:" + str);
        JSONObject jSONObject = XML2Json.toJSONObject(str);
        if (jSONObject != null) {
            LogEx.d("ParseScheduleInfoQueryXML", "jsonResult is:" + jSONObject.toString());
            JSONObject jSONObject2 = jSONObject.getJSONObject("scheduleinfoqueryrsp");
            if (jSONObject2 == null) {
                return "";
            }
            String jSONObject3 = jSONObject2.toString();
            LogEx.d("ParseScheduleInfoQueryXML", "final jsonResult is:" + jSONObject3);
            return jSONObject3;
        }
        LogEx.d("ParseScheduleInfoQueryXML", "jsonResult is null");
        return null;
    }
}
