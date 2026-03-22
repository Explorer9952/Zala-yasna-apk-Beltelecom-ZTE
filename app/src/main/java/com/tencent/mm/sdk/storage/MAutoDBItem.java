package com.tencent.mm.sdk.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;

/* loaded from: classes.dex */
public abstract class MAutoDBItem implements MDBItem {
    public static final String SYSTEM_ROWID_FIELD = "rowid";
    public long systemRowid = -1;

    public static boolean checkIOEqual(ContentValues contentValues, Cursor cursor) {
        if (contentValues == null) {
            return cursor == null;
        }
        if (cursor != null && cursor.getCount() == 1) {
            cursor.moveToFirst();
            int columnCount = cursor.getColumnCount();
            int size = contentValues.size();
            if (contentValues.containsKey(SYSTEM_ROWID_FIELD)) {
                size--;
            }
            if (cursor.getColumnIndex(SYSTEM_ROWID_FIELD) != -1) {
                columnCount--;
            }
            if (size != columnCount) {
                return false;
            }
            try {
                Iterator<Map.Entry<String, Object>> it2 = contentValues.valueSet().iterator();
                while (it2.hasNext()) {
                    String key = it2.next().getKey();
                    if (!key.equals(SYSTEM_ROWID_FIELD)) {
                        int columnIndex = cursor.getColumnIndex(key);
                        if (columnIndex == -1) {
                            return false;
                        }
                        if (contentValues.get(key) instanceof byte[]) {
                            byte[] bArr = (byte[]) contentValues.get(key);
                            byte[] blob = cursor.getBlob(columnIndex);
                            if (bArr.length != blob.length) {
                                return false;
                            }
                            for (int i = 0; i < bArr.length; i++) {
                                if (bArr[i] != blob[i]) {
                                    return false;
                                }
                            }
                        } else if ((cursor.getString(columnIndex) == null && contentValues.get(key) != null) || contentValues.get(key) == null || !contentValues.get(key).toString().equals(cursor.getString(columnIndex))) {
                            return false;
                        }
                    }
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static Cursor getCursorForProjection(ContentValues contentValues, String[] strArr) {
        int length = strArr.length;
        Object[] objArr = new Object[length];
        for (int i = 0; i < length; i++) {
            objArr[i] = contentValues.get(strArr[i]);
        }
        MatrixCursor matrixCursor = new MatrixCursor(strArr);
        matrixCursor.addRow(objArr);
        return matrixCursor;
    }

    public static String[] getFullColumns(Field[] fieldArr) {
        String[] strArr = new String[fieldArr.length + 1];
        for (int i = 0; i < fieldArr.length; i++) {
            strArr[i] = fieldArr[i].getName().substring(6);
        }
        strArr[fieldArr.length] = SYSTEM_ROWID_FIELD;
        return strArr;
    }

    public static Field[] getValidFields(Class<?> cls) {
        LinkedList linkedList = new LinkedList();
        for (Field field : cls.getDeclaredFields()) {
            int modifiers = field.getModifiers();
            String name = field.getName();
            if (name != null && name.startsWith("field_") && Modifier.isPublic(modifiers) && !Modifier.isFinal(modifiers)) {
                if (name.endsWith("field_rowid")) {
                    Assert.assertTrue("field_rowid reserved by MAutoDBItem, change now!", false);
                }
                linkedList.add(field);
            }
        }
        return (Field[]) linkedList.toArray(new Field[0]);
    }

    public static Map<String, String> identify(Field[] fieldArr, StringBuilder sb, String str) {
        HashMap hashMap = new HashMap();
        int i = 0;
        while (i < fieldArr.length) {
            String type = CursorFieldHelper.type(fieldArr[i].getType());
            if (type == null) {
                Log.e("MicroMsg.SDK.MAutoDBItem", "failed identify on column: " + fieldArr[i].getName() + ", skipped");
            } else {
                String substring = fieldArr[i].getName().substring(6);
                if (sb != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(substring);
                    sb2.append(" ");
                    sb2.append(type);
                    sb2.append(substring.equals(str) ? " PRIMARY KEY " : "");
                    sb.append(sb2.toString());
                    sb.append(i != fieldArr.length + (-1) ? ", " : "");
                }
                hashMap.put(substring, type);
            }
            i++;
        }
        return hashMap;
    }

    @Override // com.tencent.mm.sdk.storage.MDBItem
    public void convertFrom(Cursor cursor) {
        int i;
        Field[] fields = fields();
        int length = fields.length;
        int i2 = 0;
        while (true) {
            i = -1;
            if (i2 < length) {
                Field field = fields[i2];
                try {
                    int columnIndexOrThrow = cursor.getColumnIndexOrThrow(field.getName().substring(6));
                    if (columnIndexOrThrow != -1) {
                        try {
                            Method method = CursorFieldHelper.get(field.getType(), false);
                            if (method != null) {
                                method.invoke(null, field, this, cursor, Integer.valueOf(columnIndexOrThrow));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception unused) {
                }
                i2++;
            } else {
                try {
                    break;
                } catch (Exception unused2) {
                }
            }
        }
        i = cursor.getColumnIndexOrThrow(SYSTEM_ROWID_FIELD);
        if (i > 0) {
            this.systemRowid = cursor.getLong(i);
        }
    }

    @Override // com.tencent.mm.sdk.storage.MDBItem
    public ContentValues convertTo() {
        ContentValues contentValues = new ContentValues();
        for (Field field : fields()) {
            try {
                Method method = CursorFieldHelper.get(field.getType(), true);
                if (method != null) {
                    method.invoke(null, field, this, contentValues);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        long j = this.systemRowid;
        if (j > 0) {
            contentValues.put(SYSTEM_ROWID_FIELD, Long.valueOf(j));
        }
        return contentValues;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Field[] fields();
}
