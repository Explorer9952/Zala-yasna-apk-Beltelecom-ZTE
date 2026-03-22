package com.zte.iptvclient.android.mobile.order.phone;

import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.comm.ParamConst;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: GetValidateReqBean.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public String f6988a;

    /* renamed from: b, reason: collision with root package name */
    public String f6989b;

    /* renamed from: c, reason: collision with root package name */
    public String f6990c;

    /* renamed from: d, reason: collision with root package name */
    public String f6991d;
    public String e;
    public String f;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String s;
    public String g = "";
    public String h = "";
    public String r = "";

    public b(c cVar) {
        this.f6988a = "";
        this.f6989b = "";
        this.f6990c = "";
        this.f6991d = "";
        this.e = "";
        this.f = "";
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.s = "";
        this.f6988a = SDKLoginMgr.getInstance().getUserID();
        this.q = SDKLoginMgr.getInstance().getUserInfo("UserToken");
        this.f6989b = cVar.f6993b;
        this.f6990c = cVar.f6994c;
        this.f6991d = cVar.f6995d;
        this.e = cVar.e;
        this.f = "2";
        this.i = cVar.f;
        this.j = "CNY";
        this.k = "phone";
        this.l = "";
        this.m = cVar.g;
        this.n = cVar.h;
        this.o = cVar.i;
        this.s = cVar.j;
        this.p = a.a(this.f6988a);
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("usercode", this.f6988a);
            jSONObject.put("productcode", this.f6989b);
            try {
                jSONObject.put(ParamConst.AUTH_RSP_PRODUCTDESC, URLEncoder.encode(this.f6990c, "UTF-8"));
                jSONObject.put("goodsdesc", URLEncoder.encode(this.f6991d, "UTF-8"));
                jSONObject.put("contentname", URLEncoder.encode(this.o, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            jSONObject.put("programcode", this.e);
            jSONObject.put("terminalflag", this.f);
            jSONObject.put("deviceid", this.g);
            jSONObject.put("terminalip", this.h);
            jSONObject.put("totalfee", this.i);
            jSONObject.put("feetype", this.j);
            jSONObject.put("paytype", this.k);
            jSONObject.put("platformid", this.l);
            jSONObject.put("purchasetype", this.m);
            jSONObject.put("contenttype", this.n);
            jSONObject.put("authinfo", this.p);
            jSONObject.put("usertoken", this.q);
            jSONObject.put("phoneno", this.r);
            jSONObject.put("ordercontinue", this.s);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }
}
