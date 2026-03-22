package com.tencent.mm.sdk.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoDBItem;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

/* loaded from: classes.dex */
public abstract class MAutoStorage<T extends MAutoDBItem> extends MStorage {
    private ISQLiteDatabase P;
    private final String bL;
    private final String[] columns;

    public MAutoStorage(ISQLiteDatabase iSQLiteDatabase) {
        this.P = iSQLiteDatabase;
        this.bL = Util.isNullOrNil(getPrimaryKey()) ? MAutoDBItem.SYSTEM_ROWID_FIELD : getPrimaryKey();
        this.columns = getColumns();
    }

    private static StringBuilder a(ContentValues contentValues, String... strArr) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str + " = ? AND ");
            if (contentValues.get(str) == null) {
                return null;
            }
        }
        sb.append(" 1=1");
        return sb;
    }

    private boolean a(ContentValues contentValues) {
        Cursor query = this.P.query(getTableName(), this.columns, this.bL + " = ?", new String[]{Util.nullAsNil(contentValues.getAsString(this.bL))}, null, null, null);
        boolean checkIOEqual = MAutoDBItem.checkIOEqual(contentValues, query);
        query.close();
        return checkIOEqual;
    }

    private static String[] a(String[] strArr, ContentValues contentValues) {
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i = 0; i < length; i++) {
            strArr2[i] = Util.nullAsNil(contentValues.getAsString(strArr[i]));
        }
        return strArr2;
    }

    private void d(String str) {
        Log.d("MicroMsg.SDK.MAutoStorage", getTableName() + ":" + str);
    }

    private void e(String str) {
        Log.e("MicroMsg.SDK.MAutoStorage", getTableName() + ":" + str);
    }

    public static List<String> getCreateSQLs(Field[] fieldArr, String str, String str2, String... strArr) {
        LinkedList linkedList = new LinkedList();
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS " + str + " ( ");
        Map<String, String> identify = MAutoDBItem.identify(fieldArr, sb, str2);
        sb.append(");");
        linkedList.addFirst(sb.toString());
        if (strArr != null && strArr.length > 0) {
            for (String str3 : strArr) {
                if (str3 != null && str3.length() > 0) {
                    if (identify.get(str3) == null) {
                        Log.e("MicroMsg.SDK.MAutoStorage", "skipped invalid index: " + str3 + ", not found in fields");
                    }
                    linkedList.add("CREATE INDEX IF NOT EXISTS _mindex_" + str + "_" + str3 + "_ ON " + str + "(" + str3 + ");");
                }
            }
        }
        return linkedList;
    }

    public static List<String> getUpdateSQLs(Field[] fieldArr, String str, ISQLiteDatabase iSQLiteDatabase) {
        LinkedList linkedList = new LinkedList();
        HashMap hashMap = new HashMap();
        Cursor rawQuery = iSQLiteDatabase.rawQuery("PRAGMA table_info( " + str + " )", null);
        while (rawQuery.moveToNext()) {
            hashMap.put(rawQuery.getString(rawQuery.getColumnIndex("name")), rawQuery.getString(rawQuery.getColumnIndex("type")));
        }
        rawQuery.close();
        for (Map.Entry<String, String> entry : MAutoDBItem.identify(fieldArr, null, null).entrySet()) {
            String value = entry.getValue();
            String key = entry.getKey();
            if (!((value.length() <= 0) | (value == null))) {
                String str2 = (String) hashMap.get(key);
                if (str2 == null) {
                    linkedList.add("ALTER TABLE " + str + " ADD COLUMN " + key + " " + value + ";");
                } else if (!str2.equalsIgnoreCase(value)) {
                    Log.e("MicroMsg.SDK.MAutoStorage", "conflicting alter table on column: " + key + ", " + str2 + "<o-n>" + value);
                }
                hashMap.remove(key);
            }
        }
        return linkedList;
    }

    public boolean delete(long j) {
        boolean z = this.P.delete(getTableName(), "rowid = ?", new String[]{String.valueOf(j)}) > 0;
        if (z) {
            notify();
        }
        return z;
    }

    public boolean delete(T t, String... strArr) {
        String str;
        ContentValues convertTo = t.convertTo();
        if (convertTo == null || convertTo.size() <= 0) {
            str = "delete failed, value.size <= 0";
        } else {
            if (strArr == null || strArr.length <= 0) {
                d("delete with primary key");
                ISQLiteDatabase iSQLiteDatabase = this.P;
                String tableName = getTableName();
                StringBuilder sb = new StringBuilder();
                sb.append(this.bL);
                sb.append(" = ?");
                boolean z = iSQLiteDatabase.delete(tableName, sb.toString(), new String[]{Util.nullAsNil(convertTo.getAsString(this.bL))}) > 0;
                if (z) {
                    doNotify();
                }
                return z;
            }
            StringBuilder a2 = a(convertTo, strArr);
            if (a2 == null) {
                str = "delete failed, check keys failed";
            } else {
                if (this.P.delete(getTableName(), a2.toString(), a(strArr, convertTo)) > 0) {
                    doNotify(this.bL);
                    return true;
                }
                str = "delete failed";
            }
        }
        e(str);
        return false;
    }

    public boolean get(long j, T t) {
        Cursor query = this.P.query(getTableName(), this.columns, "rowid = ?", new String[]{String.valueOf(j)}, null, null, null);
        if (!query.moveToFirst()) {
            query.close();
            return false;
        }
        t.convertFrom(query);
        query.close();
        return true;
    }

    public boolean get(T t, String... strArr) {
        Cursor query;
        ContentValues convertTo = t.convertTo();
        if (convertTo == null || convertTo.size() <= 0) {
            e("get failed, value.size <= 0");
            return false;
        }
        if (strArr == null || strArr.length <= 0) {
            d("get with primary key");
            query = this.P.query(getTableName(), this.columns, this.bL + " = ?", new String[]{Util.nullAsNil(convertTo.getAsString(this.bL))}, null, null, null);
            if (!query.moveToFirst()) {
                query.close();
                return false;
            }
        } else {
            StringBuilder a2 = a(convertTo, strArr);
            if (a2 == null) {
                e("get failed, check keys failed");
                return false;
            }
            query = this.P.query(getTableName(), this.columns, a2.toString(), a(strArr, convertTo), null, null, null);
            if (!query.moveToFirst()) {
                query.close();
                d("get failed, not found");
                return false;
            }
        }
        t.convertFrom(query);
        query.close();
        return true;
    }

    public Cursor getAll() {
        return this.P.query(getTableName(), this.columns, null, null, null, null, null);
    }

    public abstract String[] getColumns();

    public int getCount() {
        Cursor rawQuery = rawQuery("select count(*) from " + getTableName(), new String[0]);
        if (rawQuery == null) {
            return 0;
        }
        rawQuery.moveToFirst();
        int i = rawQuery.getInt(0);
        rawQuery.close();
        return i;
    }

    public abstract String getPrimaryKey();

    public abstract String getTableName();

    public boolean insert(T t) {
        String str;
        ContentValues convertTo = t.convertTo();
        if (convertTo == null || convertTo.size() <= 0) {
            str = "insert failed, value.size <= 0";
        } else {
            long insert = this.P.insert(getTableName(), this.bL, t.convertTo());
            t.systemRowid = insert;
            if (insert > 0) {
                doNotify(this.bL);
                return true;
            }
            str = "insert failed";
        }
        e(str);
        return false;
    }

    public Cursor rawQuery(String str, String... strArr) {
        return this.P.rawQuery(str, strArr);
    }

    public boolean replace(T t) {
        String str;
        Assert.assertTrue("replace primaryKey == null", !Util.isNullOrNil(this.bL));
        ContentValues convertTo = t.convertTo();
        if (convertTo == null || convertTo.size() != t.fields().length + (convertTo.containsKey(MAutoDBItem.SYSTEM_ROWID_FIELD) ? 1 : 0)) {
            str = "replace failed, cv.size() != item.fields().length";
        } else {
            if (a(convertTo)) {
                d("no need replace , fields no change");
                return true;
            }
            if (this.P.replace(getTableName(), this.bL, convertTo) > 0) {
                doNotify(this.bL);
                return true;
            }
            str = "replace failed";
        }
        e(str);
        return false;
    }

    public boolean update(long j, T t) {
        ContentValues convertTo = t.convertTo();
        if (convertTo == null || convertTo.size() <= 0) {
            e("update failed, value.size <= 0");
            return false;
        }
        Cursor query = this.P.query(getTableName(), this.columns, "rowid = ?", new String[]{String.valueOf(j)}, null, null, null);
        boolean checkIOEqual = MAutoDBItem.checkIOEqual(convertTo, query);
        query.close();
        if (checkIOEqual) {
            d("no need replace , fields no change");
            return true;
        }
        boolean z = this.P.update(getTableName(), convertTo, "rowid = ?", new String[]{String.valueOf(j)}) > 0;
        if (z) {
            doNotify();
        }
        return z;
    }

    public boolean update(T t, String... strArr) {
        String str;
        ContentValues convertTo = t.convertTo();
        if (convertTo == null || convertTo.size() <= 0) {
            str = "update failed, value.size <= 0";
        } else {
            if (strArr == null || strArr.length <= 0) {
                d("update with primary key");
                if (a(convertTo)) {
                    d("no need replace , fields no change");
                    return true;
                }
                ISQLiteDatabase iSQLiteDatabase = this.P;
                String tableName = getTableName();
                StringBuilder sb = new StringBuilder();
                sb.append(this.bL);
                sb.append(" = ?");
                boolean z = iSQLiteDatabase.update(tableName, convertTo, sb.toString(), new String[]{Util.nullAsNil(convertTo.getAsString(this.bL))}) > 0;
                if (z) {
                    doNotify();
                }
                return z;
            }
            StringBuilder a2 = a(convertTo, strArr);
            if (a2 == null) {
                str = "update failed, check keys failed";
            } else {
                if (this.P.update(getTableName(), convertTo, a2.toString(), a(strArr, convertTo)) > 0) {
                    doNotify(this.bL);
                    return true;
                }
                str = "update failed";
            }
        }
        e(str);
        return false;
    }
}
