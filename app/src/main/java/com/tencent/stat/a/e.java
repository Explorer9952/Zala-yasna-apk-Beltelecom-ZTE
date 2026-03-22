package com.tencent.stat.a;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class e extends b {
    private com.tencent.stat.i.c j;
    private JSONObject k;

    public e(Context context, int i, JSONObject jSONObject) {
        super(context, i);
        this.k = null;
        this.j = new com.tencent.stat.i.c(context);
        this.k = jSONObject;
    }

    @Override // com.tencent.stat.a.b
    public f a() {
        return f.SESSION_ENV;
    }

    @Override // com.tencent.stat.a.b
    public boolean a(JSONObject jSONObject) {
        com.tencent.stat.a aVar = this.f2832d;
        if (aVar != null) {
            jSONObject.put("ut", aVar.g());
        }
        JSONObject jSONObject2 = this.k;
        if (jSONObject2 != null) {
            jSONObject.put("cfg", jSONObject2);
        }
        this.j.a(jSONObject);
        return true;
    }
}
