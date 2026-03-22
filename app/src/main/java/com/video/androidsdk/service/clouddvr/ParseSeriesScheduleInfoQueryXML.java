package com.video.androidsdk.service.clouddvr;

import com.video.androidsdk.common.util.XML2Json;
import com.video.androidsdk.log.LogEx;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ParseSeriesScheduleInfoQueryXML {
    public static String xml2json(String str) throws JSONException {
        LogEx.d("ParseSeriesScheduleInfoQueryXML", "xmlResult:" + str);
        JSONObject jSONObject = XML2Json.toJSONObject(str);
        if (jSONObject != null) {
            LogEx.d("ParseSeriesScheduleInfoQueryXML", "jsonResult is:" + jSONObject.toString());
            JSONObject jSONObject2 = jSONObject.getJSONObject("seriesscheduleinfoqueryrsp");
            if (jSONObject2 == null) {
                return "";
            }
            String jSONObject3 = jSONObject2.toString();
            LogEx.d("ParseSeriesScheduleInfoQueryXML", "final jsonResult is:" + jSONObject3);
            return jSONObject3;
        }
        LogEx.d("ParseSeriesScheduleInfoQueryXML", "jsonResult is null");
        return null;
    }
}
