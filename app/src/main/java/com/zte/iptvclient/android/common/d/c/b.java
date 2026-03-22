package com.zte.iptvclient.android.common.d.c;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.video.androidsdk.log.LogEx;

/* compiled from: BaseDAO.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    protected SQLiteOpenHelper f4440a;

    /* renamed from: b, reason: collision with root package name */
    private String f4441b;

    public b(SQLiteOpenHelper sQLiteOpenHelper, String str) {
        if (sQLiteOpenHelper != null) {
            this.f4440a = sQLiteOpenHelper;
            this.f4441b = str;
            return;
        }
        throw new SQLiteException("dbHelper is null");
    }

    public int a(String str, String[] strArr) {
        try {
            return this.f4440a.getWritableDatabase().delete(this.f4441b, str, strArr);
        } catch (SQLiteException e) {
            LogEx.e(com.video.androidsdk.b.a.TAG, "Failed to mDelete data in table: " + this.f4441b);
            e.printStackTrace();
            return -1;
        }
    }

    public long a(ContentValues contentValues) {
        try {
            return this.f4440a.getWritableDatabase().insert(this.f4441b, null, contentValues);
        } catch (SQLiteException e) {
            LogEx.e(com.video.androidsdk.b.a.TAG, "Failed to insert data in table: " + this.f4441b);
            e.printStackTrace();
            return -1L;
        }
    }

    public Cursor a(String[] strArr, String str, String[] strArr2, String str2) {
        try {
            return this.f4440a.getReadableDatabase().query(this.f4441b, strArr, str, strArr2, null, null, str2);
        } catch (SQLiteException e) {
            LogEx.e(com.video.androidsdk.b.a.TAG, "Failed to query data in table: " + this.f4441b);
            e.printStackTrace();
            return null;
        }
    }
}
