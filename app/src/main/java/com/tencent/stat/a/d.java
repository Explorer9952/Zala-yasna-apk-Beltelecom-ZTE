package com.tencent.stat.a;

import android.content.Context;
import com.tencent.stat.i.m;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d extends b {
    Long j;
    String k;
    String l;

    public d(Context context, String str, String str2, int i, Long l) {
        super(context, i);
        this.j = null;
        this.l = str;
        this.k = str2;
        this.j = l;
    }

    @Override // com.tencent.stat.a.b
    public f a() {
        return f.PAGE_VIEW;
    }

    @Override // com.tencent.stat.a.b
    public boolean a(JSONObject jSONObject) {
        m.a(jSONObject, "pi", this.k);
        m.a(jSONObject, "rf", this.l);
        Long l = this.j;
        if (l == null) {
            return true;
        }
        jSONObject.put("du", l);
        return true;
    }
}
