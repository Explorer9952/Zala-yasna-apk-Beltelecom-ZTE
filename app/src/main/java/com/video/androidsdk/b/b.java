package com.video.androidsdk.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: SDKDatabaseHelper.java */
/* loaded from: classes.dex */
public class b extends SQLiteOpenHelper {
    public b(Context context) {
        super(context, "zsdk.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE push_msginfo (id integer primary key autoincrement,msg_id varchar(40) UNIQUE,msg_type smallint,msg_from varchar(40),msg_title varchar(256),msg_cnt_type smallint,msg_content varchar(1024),summary varchar(200),title_icon_url varchar(1024),time_stamp varchar,isread smallint,service_type smallint,oper_type smallint,msg_serv_type smallint,msg_bind_type smallint,msg_show_type smallint,position varchar(1024),file_url varchar(1024),show_mode smallint,serv_param varchar(1024),account varchar(24))");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
