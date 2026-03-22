package com.tencent.stat.a;

import android.content.Context;
import com.tencent.stat.i.m;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a extends b {
    private String j;
    private int k;
    private int l;

    public a(Context context, int i, int i2, Throwable th) {
        super(context, i);
        this.l = 100;
        if (th != null) {
            Throwable th2 = new Throwable(th);
            try {
                StackTraceElement[] stackTrace = th2.getStackTrace();
                if (stackTrace != null && stackTrace.length > this.l) {
                    StackTraceElement[] stackTraceElementArr = new StackTraceElement[this.l];
                    for (int i3 = 0; i3 < this.l; i3++) {
                        stackTraceElementArr[i3] = stackTrace[i3];
                    }
                    th2.setStackTrace(stackTraceElementArr);
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th2.printStackTrace(printWriter);
            this.j = stringWriter.toString();
            this.k = i2;
            printWriter.close();
        }
    }

    public a(Context context, int i, String str, int i2, int i3) {
        super(context, i);
        this.l = 100;
        if (str != null) {
            i3 = i3 <= 0 ? com.tencent.stat.c.j() : i3;
            if (str.length() <= i3) {
                this.j = str;
            } else {
                this.j = str.substring(0, i3);
            }
        }
        this.k = i2;
    }

    @Override // com.tencent.stat.a.b
    public f a() {
        return f.ERROR;
    }

    public void a(long j) {
        this.f2830b = j;
    }

    @Override // com.tencent.stat.a.b
    public boolean a(JSONObject jSONObject) {
        m.a(jSONObject, "er", this.j);
        jSONObject.put("ea", this.k);
        return true;
    }
}
