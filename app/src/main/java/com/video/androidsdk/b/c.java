package com.video.androidsdk.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: SDKDatabaseProxy.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: d, reason: collision with root package name */
    private static c f3038d;

    /* renamed from: a, reason: collision with root package name */
    private SQLiteDatabase f3039a;

    /* renamed from: b, reason: collision with root package name */
    private SQLiteDatabase f3040b;

    /* renamed from: c, reason: collision with root package name */
    private SQLiteOpenHelper f3041c;

    private c(Context context) {
        b bVar = new b(context);
        this.f3041c = bVar;
        this.f3039a = bVar.getWritableDatabase();
        this.f3040b = this.f3041c.getReadableDatabase();
    }

    public static c a(Context context) {
        if (f3038d == null) {
            f3038d = new c(context);
        }
        return f3038d;
    }

    public SQLiteOpenHelper a() {
        return this.f3041c;
    }
}
