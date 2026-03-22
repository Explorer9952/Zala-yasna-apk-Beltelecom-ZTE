package com.zte.iptvclient.android.common.d.c;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import com.facebook.share.internal.MessengerShareContentUtility;

/* compiled from: AdvertisementDAO.java */
/* loaded from: classes.dex */
public class a extends b {
    public a(SQLiteOpenHelper sQLiteOpenHelper) {
        super(sQLiteOpenHelper, "ADVERTISEMENT");
    }

    public long a(com.zte.iptvclient.android.common.javabean.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", (Integer) 1);
        contentValues.put(MessengerShareContentUtility.MEDIA_IMAGE, aVar.a());
        contentValues.put("DisplayTime", Integer.valueOf(aVar.b()));
        contentValues.put("TimeLaterShowSkip", Integer.valueOf(aVar.d()));
        contentValues.put("LinkSource", aVar.c());
        return a(contentValues);
    }

    public com.zte.iptvclient.android.common.javabean.a b() {
        com.zte.iptvclient.android.common.javabean.a aVar = null;
        Cursor a2 = a(null, "id = ? ", new String[]{"1"}, null);
        if (a2 != null && a2.moveToFirst()) {
            aVar = new com.zte.iptvclient.android.common.javabean.a(a2.getBlob(a2.getColumnIndex(MessengerShareContentUtility.MEDIA_IMAGE)), a2.getString(a2.getColumnIndex("LinkSource")), a2.getInt(a2.getColumnIndex("DisplayTime")), a2.getInt(a2.getColumnIndex("TimeLaterShowSkip")));
        }
        if (a2 != null) {
            a2.close();
        }
        return aVar;
    }

    public int a() {
        return a(null, null);
    }
}
