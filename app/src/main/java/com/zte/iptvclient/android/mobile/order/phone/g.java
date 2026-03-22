package com.zte.iptvclient.android.mobile.order.phone;

import com.video.androidsdk.login.SDKLoginMgr;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RegetValidateReqBean.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public String f7003a;

    /* renamed from: c, reason: collision with root package name */
    public String f7005c;

    /* renamed from: b, reason: collision with root package name */
    public String f7004b = "";

    /* renamed from: d, reason: collision with root package name */
    public String f7006d = "";

    public g() {
        this.f7003a = "";
        this.f7005c = "";
        String userID = SDKLoginMgr.getInstance().getUserID();
        this.f7003a = userID;
        this.f7005c = a.a(userID);
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("usercode", this.f7003a);
            jSONObject.put("out_trade_no", this.f7004b);
            jSONObject.put("phoneno", this.f7006d);
            jSONObject.put("authinfo", this.f7005c);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
