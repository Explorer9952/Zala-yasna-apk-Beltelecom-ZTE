package com.video.androidsdk.service.clouddvr;

import com.video.androidsdk.common.util.XML2Json;
import com.video.androidsdk.log.LogEx;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ParseGetUserVolumeXML {
    public static String xml2json(String str) throws JSONException {
        LogEx.d("ParseGetUserVolumeXML", "xmlResult:" + str);
        JSONObject jSONObject = XML2Json.toJSONObject(str.replace("countvolume", "usedvolume").replace("availvolume", "availablevolume"));
        if (jSONObject != null) {
            LogEx.d("ParseGetUserVolumeXML", "jsonResult is:" + jSONObject.toString());
            JSONObject jSONObject2 = jSONObject.getJSONObject("getuservolumersp");
            if (jSONObject2 == null) {
                return "";
            }
            jSONObject2.put("errormsg", jSONObject2.getString("description"));
            jSONObject2.remove("description");
            String jSONObject3 = jSONObject2.toString();
            LogEx.d("ParseGetUserVolumeXML", "final jsonResult is:" + jSONObject3);
            return jSONObject3;
        }
        LogEx.d("ParseGetUserVolumeXML", "jsonResult is null");
        return null;
    }
}
