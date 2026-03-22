package com.video.androidsdk.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.video.androidsdk.log.LogEx;

/* compiled from: SDKBaseDAO.java */
/* loaded from: classes.dex */
public class a {
    public static final String TAG = "BaseDAO";
    protected SQLiteOpenHelper mDBHelper;
    private String mTableName;

    public a(SQLiteOpenHelper sQLiteOpenHelper, String str) {
        if (sQLiteOpenHelper != null) {
            this.mDBHelper = sQLiteOpenHelper;
            this.mTableName = str;
            return;
        }
        throw new SQLiteException("dbHelper is null");
    }

    public static String getSelectionSQLByAnd(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strArr.length - 1; i++) {
            stringBuffer.append(strArr[i]);
            stringBuffer.append(" = ? and ");
        }
        stringBuffer.append(strArr[strArr.length - 1]);
        stringBuffer.append(" = ?");
        return stringBuffer.toString();
    }

    public static String getSelectionSQLByOr(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length - 1; i++) {
            sb.append(strArr[i]);
            sb.append(" = ? or ");
        }
        sb.append(strArr[strArr.length - 1]);
        sb.append(" = ?");
        return sb.toString();
    }

    public int delete(String str, String[] strArr) {
        try {
            return this.mDBHelper.getWritableDatabase().delete(this.mTableName, str, strArr);
        } catch (SQLiteException e) {
            LogEx.e(TAG, "Failed to delete data in table: " + this.mTableName);
            e.printStackTrace();
            return -1;
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
    }

    public long insert(ContentValues contentValues) {
        try {
            return this.mDBHelper.getWritableDatabase().insert(this.mTableName, null, contentValues);
        } catch (SQLiteException e) {
            LogEx.e(TAG, "Failed to insert data in table: " + this.mTableName);
            e.printStackTrace();
            return -1L;
        }
    }

    public Cursor query(String[] strArr, String str, String[] strArr2, String str2) {
        try {
            return this.mDBHelper.getReadableDatabase().query(this.mTableName, strArr, str, strArr2, null, null, str2);
        } catch (SQLiteException e) {
            LogEx.e(TAG, "Failed to query data in table: " + this.mTableName);
            e.printStackTrace();
            return null;
        }
    }

    public int update(ContentValues contentValues, String str, String[] strArr) {
        try {
            return this.mDBHelper.getWritableDatabase().update(this.mTableName, contentValues, str, strArr);
        } catch (SQLiteException e) {
            LogEx.e(TAG, "Failed to update data in table: " + this.mTableName);
            e.printStackTrace();
            return -1;
        }
    }

    public Cursor query(String[] strArr, String str, String[] strArr2, String str2, String str3) {
        try {
            return this.mDBHelper.getReadableDatabase().query(this.mTableName, strArr, str, strArr2, null, null, str2, str3);
        } catch (SQLiteException e) {
            LogEx.e(TAG, "Failed to query data in table: " + this.mTableName);
            e.printStackTrace();
            return null;
        }
    }

    public Cursor query(String str, String[] strArr) {
        try {
            return this.mDBHelper.getReadableDatabase().rawQuery(str, strArr);
        } catch (SQLiteException e) {
            LogEx.e(TAG, "Failed to query data.");
            e.printStackTrace();
            return null;
        }
    }
}
