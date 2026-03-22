package com.zte.iptvclient.android.common.d;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: DatabaseProxy.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private com.zte.iptvclient.android.common.d.c.a f4439a;

    public b(Context context) {
        a aVar = new a(context);
        aVar.getWritableDatabase();
        aVar.getReadableDatabase();
        a(aVar);
    }

    private int a(long j) {
        return j > -1 ? 0 : -1;
    }

    private void a(SQLiteOpenHelper sQLiteOpenHelper) {
        this.f4439a = new com.zte.iptvclient.android.common.d.c.a(sQLiteOpenHelper);
    }

    public com.zte.iptvclient.android.common.javabean.a b() {
        return this.f4439a.b();
    }

    public int a(com.zte.iptvclient.android.common.javabean.a aVar) {
        return a(this.f4439a.a(aVar));
    }

    public int a() {
        return this.f4439a.a();
    }
}
