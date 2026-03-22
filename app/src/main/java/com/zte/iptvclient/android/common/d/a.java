package com.zte.iptvclient.android.common.d;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: DatabaseHelper.java */
/* loaded from: classes.dex */
public class a extends SQLiteOpenHelper {
    public a(Context context) {
        super(context, "iptv.db", (SQLiteDatabase.CursorFactory) null, 2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE custom_column (ProgramCode varchar(32) primary key, ProgramName varchar(32), ProgramType varchar(32), ImgURL varchar(32),  ColumnCode varchar(32), Account varchar(32))");
        sQLiteDatabase.execSQL("CREATE TABLE custom_label (ColumnCode varchar(32) primary key, LabelName varchar(32), Account varchar(32))");
        sQLiteDatabase.execSQL("CREATE TABLE custom_home_magazine_all_movies (ProgramCode varchar(32), ProgramType varchar(32), ProgramName varchar(32), ProgramRating varchar(32), ImgURL varchar(32), Account varchar(32), primary key(ProgramCode, Account))");
        sQLiteDatabase.execSQL("CREATE TABLE custom_home_magazine_all_magazines (MagazineCreatedTime varchar(32) primary key,MagazineName nvarchar(32), ProgramCodes varchar(32), ProgramTypes varchar(32), ProgramNames varchar(32), ProgramRatings varchar(32), ImgURLs varchar(32), Account varchar(32), TemplateName varchar(32), ContentAbstract varchar(32))");
        sQLiteDatabase.execSQL("create table ADVERTISEMENT (id integer primary key, image BLOB, DisplayTime integer, TimeLaterShowSkip integer, LinkSource varchar(32))");
        sQLiteDatabase.execSQL("create table custom_tag_preserve (id integer primary key, tagID varchar(32), tagName varchar(32))");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i == 1) {
            sQLiteDatabase.execSQL("create table custom_tag_preserve (id integer primary key, tagID varchar(32), tagName varchar(32))");
        }
    }
}
