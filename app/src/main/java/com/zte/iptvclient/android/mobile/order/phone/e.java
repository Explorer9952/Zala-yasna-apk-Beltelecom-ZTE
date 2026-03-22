package com.zte.iptvclient.android.mobile.order.phone;

import com.video.androidsdk.login.SDKLoginMgr;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: OrderReqBean.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public String f6999a = SDKLoginMgr.getInstance().getUserID();

    /* renamed from: b, reason: collision with root package name */
    public String f7000b = SDKLoginMgr.getInstance().getUserInfo("UserToken");

    /* renamed from: c, reason: collision with root package name */
    public String f7001c;

    /* renamed from: d, reason: collision with root package name */
    public String f7002d;
    public String e;

    public void a(String str) {
        this.e = a.a(this.f6999a, str);
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("usercode", this.f6999a);
            jSONObject.put("usertoken", this.f7000b);
            jSONObject.put("out_trade_no", this.f7001c);
            jSONObject.put("phoneno", this.f7002d);
            jSONObject.put("authinfo", this.e);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
