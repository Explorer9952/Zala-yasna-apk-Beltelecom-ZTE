package com.zte.iptvclient.android.common.f.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.mes.bean.MsgInfo;

/* compiled from: MesMessageInfoMgr.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: d, reason: collision with root package name */
    private static j f4567d;

    /* renamed from: a, reason: collision with root package name */
    private SQLiteDatabase f4568a = null;

    /* renamed from: b, reason: collision with root package name */
    private String f4569b = "messageinfo";

    /* renamed from: c, reason: collision with root package name */
    private String f4570c = "MesMessageInfoMgr";

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0045, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
    
        if (r4 == null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean d(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            r4 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            r1.<init>()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            java.lang.String r2 = "select count(*) as c from  sqlite_master where type ='table' and name ='"
            r1.append(r2)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            java.lang.String r2 = r3.f4569b     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            java.lang.String r2 = r2.trim()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            r1.append(r2)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            java.lang.String r2 = "' "
            r1.append(r2)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            android.database.sqlite.SQLiteDatabase r2 = r3.f4568a     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            android.database.Cursor r4 = r2.rawQuery(r1, r4)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            if (r4 == 0) goto L36
            boolean r1 = r4.moveToNext()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            if (r1 == 0) goto L36
            int r1 = r4.getInt(r0)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            if (r1 <= 0) goto L36
            r0 = 1
        L36:
            if (r4 == 0) goto L45
        L38:
            r4.close()
            goto L45
        L3c:
            r0 = move-exception
            goto L46
        L3e:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L3c
            if (r4 == 0) goto L45
            goto L38
        L45:
            return r0
        L46:
            if (r4 == 0) goto L4b
            r4.close()
        L4b:
            goto L4d
        L4c:
            throw r0
        L4d:
            goto L4c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.common.f.b.j.d(java.lang.String):boolean");
    }

    public static j e() {
        if (f4567d == null) {
            f4567d = new j();
        }
        return f4567d;
    }

    public void a(Context context) {
        String packageName = context.getPackageName();
        try {
            packageName = "/data/data/" + packageName + "/MesMessage.db";
            this.f4568a = SQLiteDatabase.openOrCreateDatabase(packageName, (SQLiteDatabase.CursorFactory) null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        LogEx.d(this.f4570c, "initDB,sucessful,strFilePath=" + packageName);
        if (!d(this.f4569b)) {
            SQLiteDatabase sQLiteDatabase = this.f4568a;
            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                try {
                    this.f4568a.execSQL("CREATE TABLE messageinfo (id integer primary key autoincrement,MsgType smallint,MsgFrom varchar(40),MsgTitle varchar(256),MsgCntType smallint,MsgContent varchar(1024),Summary varchar(200),TitleIconUrl varchar(1024),SendTime varchar,ReadStatus smallint,MsgID varchar(40) UNIQUE)");
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            LogEx.d(this.f4570c, "open db is fail...");
            return;
        }
        LogEx.d(this.f4570c, "db is already exist...");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x008a, code lost:
    
        if (r1 != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0098, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0095, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0093, code lost:
    
        if (r1 == null) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<com.video.androidsdk.mes.bean.MsgInfo> b() {
        /*
            r4 = this;
            android.database.sqlite.SQLiteDatabase r0 = r4.f4568a
            r1 = 0
            if (r0 == 0) goto L9f
            boolean r0 = r0.isOpen()
            if (r0 != 0) goto Ld
            goto L9f
        Ld:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r2 = "select MsgID,MsgType,MsgFrom,MsgTitle,MsgCntType,MsgContent,Summary,TitleIconUrl,SendTime,ReadStatus from messageinfo"
            android.database.sqlite.SQLiteDatabase r3 = r4.f4568a     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            android.database.Cursor r1 = r3.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            if (r1 == 0) goto L8a
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
        L1f:
            boolean r2 = r1.isAfterLast()     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            if (r2 != 0) goto L8a
            com.video.androidsdk.mes.bean.MsgInfo r2 = new com.video.androidsdk.mes.bean.MsgInfo     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            r2.<init>()     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            r3 = 0
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            r2.msgid = r3     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            r3 = 1
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            r2.msgType = r3     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            r3 = 2
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            r2.msgFrom = r3     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            r3 = 3
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            r2.msgTitle = r3     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            r3 = 4
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            r2.msgCntType = r3     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            r3 = 5
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            r2.msgContent = r3     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            r3 = 6
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            r2.summary = r3     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            r3 = 7
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            r2.titleIconUrl = r3     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            r3 = 8
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            r2.timestamp = r3     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            r3 = 9
            int r3 = r1.getInt(r3)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            if (r3 != 0) goto L7f
            java.lang.String r3 = "0"
            r2.isRead = r3     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            goto L83
        L7f:
            java.lang.String r3 = "1"
            r2.isRead = r3     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
        L83:
            r0.add(r2)     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            r1.moveToNext()     // Catch: java.lang.Throwable -> L8d java.lang.Exception -> L8f
            goto L1f
        L8a:
            if (r1 == 0) goto L98
            goto L95
        L8d:
            r0 = move-exception
            goto L99
        L8f:
            r2 = move-exception
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L8d
            if (r1 == 0) goto L98
        L95:
            r1.close()
        L98:
            return r0
        L99:
            if (r1 == 0) goto L9e
            r1.close()
        L9e:
            throw r0
        L9f:
            java.lang.String r0 = r4.f4570c
            java.lang.String r2 = "open db is fail..."
            com.video.androidsdk.log.LogEx.d(r0, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.common.f.b.j.b():java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.video.androidsdk.mes.bean.MsgInfo c() {
        /*
            r4 = this;
            android.database.sqlite.SQLiteDatabase r0 = r4.f4568a
            r1 = 0
            if (r0 == 0) goto Lb0
            boolean r0 = r0.isOpen()
            if (r0 != 0) goto Ld
            goto Lb0
        Ld:
            java.lang.String r0 = "select MsgID,MsgType,MsgFrom,MsgTitle,MsgCntType,MsgContent,Summary,TitleIconUrl,SendTime,ReadStatus from messageinfo where  SendTime = (select max(SendTime) from messageinfo)"
            android.database.sqlite.SQLiteDatabase r2 = r4.f4568a     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L9b
            android.database.Cursor r0 = r2.rawQuery(r0, r1)     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L9b
            if (r0 != 0) goto L1d
            if (r0 == 0) goto L1c
            r0.close()
        L1c:
            return r1
        L1d:
            r0.moveToFirst()     // Catch: java.lang.Exception -> L91 java.lang.Throwable -> La9
        L20:
            boolean r2 = r0.isAfterLast()     // Catch: java.lang.Exception -> L91 java.lang.Throwable -> La9
            if (r2 != 0) goto L8b
            com.video.androidsdk.mes.bean.MsgInfo r2 = new com.video.androidsdk.mes.bean.MsgInfo     // Catch: java.lang.Exception -> L91 java.lang.Throwable -> La9
            r2.<init>()     // Catch: java.lang.Exception -> L91 java.lang.Throwable -> La9
            r1 = 0
            java.lang.String r1 = r0.getString(r1)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La9
            r2.msgid = r1     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La9
            r1 = 1
            int r1 = r0.getInt(r1)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La9
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La9
            r2.msgType = r1     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La9
            r1 = 2
            java.lang.String r1 = r0.getString(r1)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La9
            r2.msgFrom = r1     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La9
            r1 = 3
            java.lang.String r1 = r0.getString(r1)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La9
            r2.msgTitle = r1     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La9
            r1 = 4
            int r1 = r0.getInt(r1)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La9
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La9
            r2.msgCntType = r1     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La9
            r1 = 5
            java.lang.String r1 = r0.getString(r1)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La9
            r2.msgContent = r1     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La9
            r1 = 6
            java.lang.String r1 = r0.getString(r1)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La9
            r2.summary = r1     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La9
            r1 = 7
            java.lang.String r1 = r0.getString(r1)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La9
            r2.titleIconUrl = r1     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La9
            r1 = 8
            java.lang.String r1 = r0.getString(r1)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La9
            r2.timestamp = r1     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La9
            r1 = 9
            int r1 = r0.getInt(r1)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La9
            if (r1 != 0) goto L80
            java.lang.String r1 = "0"
            r2.isRead = r1     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La9
            goto L84
        L80:
            java.lang.String r1 = "1"
            r2.isRead = r1     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La9
        L84:
            r0.moveToNext()     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> La9
            r1 = r2
            goto L20
        L89:
            r1 = move-exception
            goto L9f
        L8b:
            if (r0 == 0) goto La8
            r0.close()
            goto La8
        L91:
            r2 = move-exception
            r3 = r2
            r2 = r1
            r1 = r3
            goto L9f
        L96:
            r0 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
            goto Laa
        L9b:
            r0 = move-exception
            r2 = r1
            r1 = r0
            r0 = r2
        L9f:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> La9
            if (r0 == 0) goto La7
            r0.close()
        La7:
            r1 = r2
        La8:
            return r1
        La9:
            r1 = move-exception
        Laa:
            if (r0 == 0) goto Laf
            r0.close()
        Laf:
            throw r1
        Lb0:
            java.lang.String r0 = r4.f4570c
            java.lang.String r2 = "open db is fail..."
            com.video.androidsdk.log.LogEx.d(r0, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.common.f.b.j.c():com.video.androidsdk.mes.bean.MsgInfo");
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002d, code lost:
    
        if (r0 == null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int d() {
        /*
            r4 = this;
            android.database.sqlite.SQLiteDatabase r0 = r4.f4568a
            r1 = 0
            if (r0 == 0) goto L37
            boolean r0 = r0.isOpen()
            if (r0 != 0) goto Lc
            goto L37
        Lc:
            r0 = 0
            java.lang.String r2 = "select count(*) from messageinfo where ReadStatus ='0'"
            android.database.sqlite.SQLiteDatabase r3 = r4.f4568a     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            android.database.Cursor r0 = r3.rawQuery(r2, r0)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            if (r0 == 0) goto L21
            boolean r2 = r0.moveToNext()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
            if (r2 == 0) goto L21
            int r1 = r0.getInt(r1)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
        L21:
            if (r0 == 0) goto L30
        L23:
            r0.close()
            goto L30
        L27:
            r1 = move-exception
            goto L31
        L29:
            r2 = move-exception
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L27
            if (r0 == 0) goto L30
            goto L23
        L30:
            return r1
        L31:
            if (r0 == 0) goto L36
            r0.close()
        L36:
            throw r1
        L37:
            java.lang.String r0 = r4.f4570c
            java.lang.String r2 = "open db is fail..."
            com.video.androidsdk.log.LogEx.d(r0, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.common.f.b.j.d():int");
    }

    public void a(MsgInfo msgInfo) {
        SQLiteDatabase sQLiteDatabase = this.f4568a;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            LogEx.d(this.f4570c, "open db is fail...");
            return;
        }
        if (msgInfo == null) {
            LogEx.d(this.f4570c, "msg is null");
            return;
        }
        if (a(msgInfo.msgid)) {
            return;
        }
        String str = msgInfo.msgType;
        int parseInt = (str == null || str.length() <= 0) ? 0 : Integer.parseInt(msgInfo.msgType);
        String str2 = msgInfo.msgCntType;
        try {
            this.f4568a.execSQL("insert into messageinfo values (NULL, ?,?,?,?,?,?,?,?,?,?)", new Object[]{Integer.valueOf(parseInt), msgInfo.msgFrom, msgInfo.msgTitle, Integer.valueOf((str2 == null || str2.length() <= 0) ? 0 : Integer.parseInt(msgInfo.msgCntType)), msgInfo.msgContent, msgInfo.summary, msgInfo.titleIconUrl, msgInfo.timestamp, 0, msgInfo.msgid});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b(String str) {
        SQLiteDatabase sQLiteDatabase = this.f4568a;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            try {
                this.f4568a.execSQL("delete from messageinfo  where MsgID=?", new Object[]{str});
                return;
            } catch (Exception e) {
                e.printStackTrace();
                LogEx.e(this.f4570c, "deleteMessageById=" + e.getMessage());
                return;
            }
        }
        LogEx.d(this.f4570c, "open db is fail...");
    }

    public void a() {
        SQLiteDatabase sQLiteDatabase = this.f4568a;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            try {
                this.f4568a.execSQL("delete from messageinfo");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                LogEx.e(this.f4570c, "deleteAllMessage=" + e.getMessage());
                return;
            }
        }
        LogEx.d(this.f4570c, "open db is fail...");
    }

    public void c(String str) {
        SQLiteDatabase sQLiteDatabase = this.f4568a;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            try {
                this.f4568a.execSQL("update messageinfo set ReadStatus=? where MsgID=?", new Object[]{1, str});
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        LogEx.d(this.f4570c, "open db is fail...");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0038, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
    
        if (r0 == null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(java.lang.String r5) {
        /*
            r4 = this;
            r0 = 0
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            r2.<init>()     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            java.lang.String r3 = "select count(*) from messageinfo where MsgID="
            r2.append(r3)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            r2.append(r5)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            java.lang.String r5 = r2.toString()     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            android.database.sqlite.SQLiteDatabase r2 = r4.f4568a     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            android.database.Cursor r0 = r2.rawQuery(r5, r0)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            if (r0 == 0) goto L29
            boolean r5 = r0.moveToNext()     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            if (r5 == 0) goto L29
            int r5 = r0.getInt(r1)     // Catch: java.lang.Throwable -> L2f java.lang.Exception -> L31
            if (r5 <= 0) goto L29
            r5 = 1
            r1 = 1
        L29:
            if (r0 == 0) goto L38
        L2b:
            r0.close()
            goto L38
        L2f:
            r5 = move-exception
            goto L39
        L31:
            r5 = move-exception
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L2f
            if (r0 == 0) goto L38
            goto L2b
        L38:
            return r1
        L39:
            if (r0 == 0) goto L3e
            r0.close()
        L3e:
            goto L40
        L3f:
            throw r5
        L40:
            goto L3f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.common.f.b.j.a(java.lang.String):boolean");
    }
}
