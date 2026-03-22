package com.tencent.stat.a;

import android.content.Context;
import com.tencent.stat.i.m;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c extends b {
    private static String l;
    private String j;
    private String k;

    public c(Context context, int i) {
        super(context, i);
        this.j = null;
        this.k = null;
        this.j = m.w(context);
        if (l == null) {
            l = m.t(context);
        }
    }

    @Override // com.tencent.stat.a.b
    public f a() {
        return f.NETWORK_MONITOR;
    }

    public void a(String str) {
        this.k = str;
    }

    @Override // com.tencent.stat.a.b
    public boolean a(JSONObject jSONObject) {
        m.a(jSONObject, "op", l);
        m.a(jSONObject, "cn", this.j);
        jSONObject.put("sp", this.k);
        return true;
    }
}
