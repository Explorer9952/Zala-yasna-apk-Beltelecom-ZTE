package com.zte.iptvclient.android.mobile.order.phone;

import android.os.Bundle;
import com.video.androidsdk.service.comm.ParamConst;

/* compiled from: OrderBundle.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public String f6992a = "";

    /* renamed from: b, reason: collision with root package name */
    public String f6993b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f6994c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f6995d = "";
    public String e = "";
    public String f = "";
    public String g = "";
    public String h = "";
    public String i = "";
    public String j = "";

    public static final c a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        c cVar = new c();
        cVar.f6993b = bundle.getString("productcode");
        cVar.f6994c = bundle.getString(ParamConst.AUTH_RSP_PRODUCTDESC);
        cVar.f6995d = bundle.getString("goodsdesc");
        cVar.e = bundle.getString("programcode");
        bundle.getString("terminalflag");
        bundle.getString("deviceid");
        bundle.getString("terminalip");
        cVar.f = bundle.getString("totalfee");
        bundle.getString("feetype");
        bundle.getString("paytype");
        bundle.getString("platformid");
        cVar.g = bundle.getString("purchasetype");
        cVar.h = bundle.getString("contenttype");
        cVar.i = bundle.getString("contentname");
        bundle.getString("authinfo");
        bundle.getString("phoneno");
        cVar.j = bundle.getString("ordercontinue");
        return cVar;
    }
}
