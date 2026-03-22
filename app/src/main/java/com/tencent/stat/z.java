package com.tencent.stat;

import android.database.Cursor;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ t f2925a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(t tVar) {
        this.f2925a = tVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.stat.i.b bVar;
        c0 c0Var;
        Cursor cursor = null;
        try {
            c0Var = this.f2925a.f2910a;
            cursor = c0Var.getReadableDatabase().query("config", null, null, null, null, null, null);
            while (cursor.moveToNext()) {
                int i = cursor.getInt(0);
                String string = cursor.getString(1);
                cursor.getString(2);
                int i2 = cursor.getInt(3);
                g gVar = new g(i);
                gVar.f2863a = i;
                gVar.f2864b = new JSONObject(string);
                gVar.f2866d = i2;
                c.a(gVar);
            }
            if (cursor == null) {
            }
        } catch (Throwable th) {
            try {
                bVar = t.f;
                bVar.c(th);
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }
}
