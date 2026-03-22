package com.tencent.stat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.video.androidsdk.sns.Constants;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c0 extends SQLiteOpenHelper {
    public c0(Context context) {
        super(context, com.tencent.stat.i.m.C(context), (SQLiteDatabase.CursorFactory) null, 3);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        com.tencent.stat.i.b bVar;
        Cursor cursor = null;
        String str = null;
        try {
            Cursor query = sQLiteDatabase.query("user", null, null, null, null, null, null);
            try {
                ContentValues contentValues = new ContentValues();
                if (query.moveToNext()) {
                    str = query.getString(0);
                    query.getInt(1);
                    query.getString(2);
                    query.getLong(3);
                    contentValues.put(Constants.SINA_WEIBO_UID, com.tencent.stat.i.m.c(str));
                }
                if (str != null) {
                    sQLiteDatabase.update("user", contentValues, "uid=?", new String[]{str});
                }
                if (query != null) {
                    query.close();
                }
            } catch (Throwable th) {
                th = th;
                cursor = query;
                try {
                    bVar = t.f;
                    bVar.c(th);
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        com.tencent.stat.i.b bVar;
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.query("events", null, null, null, null, null, null);
            ArrayList<d0> arrayList = new ArrayList();
            while (cursor.moveToNext()) {
                arrayList.add(new d0(cursor.getLong(0), cursor.getString(1), cursor.getInt(2), cursor.getInt(3)));
            }
            ContentValues contentValues = new ContentValues();
            for (d0 d0Var : arrayList) {
                contentValues.put("content", com.tencent.stat.i.m.c(d0Var.f2853b));
                sQLiteDatabase.update("events", contentValues, "event_id=?", new String[]{Long.toString(d0Var.f2852a)});
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

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists events(event_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, content TEXT, status INTEGER, send_count INTEGER, timestamp LONG)");
        sQLiteDatabase.execSQL("create table if not exists user(uid TEXT PRIMARY KEY, user_type INTEGER, app_ver TEXT, ts INTEGER)");
        sQLiteDatabase.execSQL("create table if not exists config(type INTEGER PRIMARY KEY NOT NULL, content TEXT, md5sum TEXT, version INTEGER)");
        sQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        com.tencent.stat.i.b bVar;
        bVar = t.f;
        bVar.b("upgrade DB from oldVersion " + i + " to newVersion " + i2);
        if (i == 1) {
            sQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
            a(sQLiteDatabase);
            b(sQLiteDatabase);
        }
        if (i == 2) {
            a(sQLiteDatabase);
            b(sQLiteDatabase);
        }
    }
}
