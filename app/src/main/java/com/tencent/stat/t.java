package com.tencent.stat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteException;
import android.os.Handler;
import android.os.HandlerThread;
import com.facebook.internal.ServerProtocol;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class t {
    private static com.tencent.stat.i.b f = com.tencent.stat.i.m.b();
    private static t g = null;

    /* renamed from: a, reason: collision with root package name */
    private c0 f2910a;

    /* renamed from: b, reason: collision with root package name */
    Handler f2911b;

    /* renamed from: c, reason: collision with root package name */
    volatile int f2912c = 0;

    /* renamed from: d, reason: collision with root package name */
    a f2913d = null;
    private HashMap<String, String> e = new HashMap<>();

    private t(Context context) {
        this.f2911b = null;
        try {
            HandlerThread handlerThread = new HandlerThread("StatStore");
            handlerThread.start();
            f.g("Launch store thread:" + handlerThread);
            this.f2911b = new Handler(handlerThread.getLooper());
            Context applicationContext = context.getApplicationContext();
            c0 c0Var = new c0(applicationContext);
            this.f2910a = c0Var;
            c0Var.getWritableDatabase();
            this.f2910a.getReadableDatabase();
            a(applicationContext);
            b();
            f();
            this.f2911b.post(new u(this));
        } catch (Throwable th) {
            f.c(th);
        }
    }

    public static synchronized t b(Context context) {
        t tVar;
        synchronized (t.class) {
            if (g == null) {
                g = new t(context);
            }
            tVar = g;
        }
        return tVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(int i) {
        try {
        } finally {
        }
        if (this.f2912c > 0 && i > 0) {
            f.e("Load " + Integer.toString(this.f2912c) + " unsent events");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (i == -1 || i > c.a()) {
                i = c.a();
            }
            this.f2912c -= i;
            c(arrayList2, i);
            f.e("Peek " + Integer.toString(arrayList2.size()) + " unsent events.");
            if (!arrayList2.isEmpty()) {
                b(arrayList2, 2);
                Iterator<d0> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    arrayList.add(it2.next().f2853b);
                }
                j.b().b(arrayList, new a0(this, arrayList2, i));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(com.tencent.stat.a.b bVar, h hVar) {
        c0 c0Var;
        if (c.m() <= 0) {
            return;
        }
        try {
            this.f2910a.getWritableDatabase().beginTransaction();
            if (this.f2912c > c.m()) {
                f.h("Too many events stored in db.");
                this.f2912c -= this.f2910a.getWritableDatabase().delete("events", "event_id in (select event_id from events where timestamp in (select min(timestamp) from events) limit 1)", null);
            }
            ContentValues contentValues = new ContentValues();
            String c2 = com.tencent.stat.i.m.c(bVar.d());
            contentValues.put("content", c2);
            contentValues.put("send_count", "0");
            contentValues.put("status", Integer.toString(1));
            contentValues.put("timestamp", Long.valueOf(bVar.b()));
            if (this.f2910a.getWritableDatabase().insert("events", null, contentValues) == -1) {
                f.d("Failed to store event:" + c2);
            } else {
                this.f2912c++;
                this.f2910a.getWritableDatabase().setTransactionSuccessful();
                if (hVar != null) {
                    hVar.a();
                }
            }
            c0Var = this.f2910a;
        } catch (Throwable th) {
            try {
                f.c(th);
                c0Var = this.f2910a;
            } catch (Throwable th2) {
                try {
                    this.f2910a.getWritableDatabase().endTransaction();
                } catch (Throwable unused) {
                }
                throw th2;
            }
        }
        c0Var.getWritableDatabase().endTransaction();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(g gVar) {
        boolean z;
        long insert;
        Cursor cursor = null;
        try {
            String a2 = gVar.a();
            String a3 = com.tencent.stat.i.m.a(a2);
            ContentValues contentValues = new ContentValues();
            contentValues.put("content", gVar.f2864b.toString());
            contentValues.put("md5sum", a3);
            gVar.f2865c = a3;
            contentValues.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, Integer.valueOf(gVar.f2866d));
            Cursor query = this.f2910a.getReadableDatabase().query("config", null, null, null, null, null, null);
            while (true) {
                try {
                    if (!query.moveToNext()) {
                        z = false;
                        break;
                    } else if (query.getInt(0) == gVar.f2863a) {
                        z = true;
                        break;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    try {
                        f.c(th);
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
            }
            if (true == z) {
                insert = this.f2910a.getWritableDatabase().update("config", contentValues, "type=?", new String[]{Integer.toString(gVar.f2863a)});
            } else {
                contentValues.put("type", Integer.valueOf(gVar.f2863a));
                insert = this.f2910a.getWritableDatabase().insert("config", null, contentValues);
            }
            if (insert == -1) {
                f.c("Failed to store cfg:" + a2);
            } else {
                f.a("Sucessed to store cfg:" + a2);
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(List<d0> list) {
        com.tencent.stat.i.b bVar;
        f.e("Delete " + list.size() + " sent events in thread:" + Thread.currentThread());
        try {
            this.f2910a.getWritableDatabase().beginTransaction();
            Iterator<d0> it2 = list.iterator();
            while (it2.hasNext()) {
                this.f2912c -= this.f2910a.getWritableDatabase().delete("events", "event_id = ?", new String[]{Long.toString(it2.next().f2852a)});
            }
            this.f2910a.getWritableDatabase().setTransactionSuccessful();
            this.f2912c = (int) DatabaseUtils.queryNumEntries(this.f2910a.getReadableDatabase(), "events");
        } catch (Throwable th) {
            try {
                f.c(th);
                try {
                    this.f2910a.getWritableDatabase().endTransaction();
                } catch (SQLiteException e) {
                    e = e;
                    bVar = f;
                    bVar.a((Exception) e);
                }
            } finally {
            }
        }
        try {
            this.f2910a.getWritableDatabase().endTransaction();
        } catch (SQLiteException e2) {
            e = e2;
            bVar = f;
            bVar.a((Exception) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(List<d0> list, int i) {
        com.tencent.stat.i.b bVar;
        f.e("Update " + list.size() + " sending events to status:" + i + " in thread:" + Thread.currentThread());
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", Integer.toString(i));
            this.f2910a.getWritableDatabase().beginTransaction();
            for (d0 d0Var : list) {
                if (d0Var.f2854c + 1 > c.k()) {
                    this.f2912c -= this.f2910a.getWritableDatabase().delete("events", "event_id=?", new String[]{Long.toString(d0Var.f2852a)});
                } else {
                    contentValues.put("send_count", Integer.valueOf(d0Var.f2854c + 1));
                    f.e("Update event:" + d0Var.f2852a + " for content:" + contentValues);
                    int update = this.f2910a.getWritableDatabase().update("events", contentValues, "event_id=?", new String[]{Long.toString(d0Var.f2852a)});
                    if (update <= 0) {
                        f.c("Failed to update db, error code:" + Integer.toString(update));
                    }
                }
            }
            this.f2910a.getWritableDatabase().setTransactionSuccessful();
            this.f2912c = (int) DatabaseUtils.queryNumEntries(this.f2910a.getReadableDatabase(), "events");
            try {
                this.f2910a.getWritableDatabase().endTransaction();
            } catch (SQLiteException e) {
                e = e;
                bVar = f;
                bVar.a((Exception) e);
            }
        } catch (Throwable th) {
            try {
                f.c(th);
                try {
                    this.f2910a.getWritableDatabase().endTransaction();
                } catch (SQLiteException e2) {
                    e = e2;
                    bVar = f;
                    bVar.a((Exception) e);
                }
            } finally {
            }
        }
    }

    public static t c() {
        return g;
    }

    private void c(List<d0> list, int i) {
        Cursor cursor = null;
        try {
            cursor = this.f2910a.getReadableDatabase().query("events", null, "status=?", new String[]{Integer.toString(1)}, null, null, "event_id", Integer.toString(i));
            while (cursor.moveToNext()) {
                list.add(new d0(cursor.getLong(0), com.tencent.stat.i.m.d(cursor.getString(1)), cursor.getInt(2), cursor.getInt(3)));
            }
            if (cursor == null) {
            }
        } catch (Throwable th) {
            try {
                f.c(th);
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("status", (Integer) 1);
            this.f2910a.getWritableDatabase().update("events", contentValues, "status=?", new String[]{Long.toString(2L)});
            this.f2912c = (int) DatabaseUtils.queryNumEntries(this.f2910a.getReadableDatabase(), "events");
            f.e("Total " + this.f2912c + " unsent events.");
        } catch (Throwable th) {
            f.c(th);
        }
    }

    private void f() {
        Cursor cursor = null;
        try {
            cursor = this.f2910a.getReadableDatabase().query("keyvalues", null, null, null, null, null, null);
            while (cursor.moveToNext()) {
                this.e.put(cursor.getString(0), cursor.getString(1));
            }
            if (cursor == null) {
            }
        } catch (Throwable th) {
            try {
                f.c(th);
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }

    public int a() {
        return this.f2912c;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0099 A[Catch: all -> 0x01a2, TryCatch #0 {all -> 0x01a2, blocks: (B:13:0x001f, B:15:0x0029, B:17:0x0046, B:20:0x005b, B:22:0x0065, B:23:0x0067, B:25:0x006f, B:27:0x0072, B:29:0x0076, B:34:0x0099, B:36:0x009c, B:37:0x00d4, B:39:0x0109, B:41:0x011e, B:43:0x012f, B:45:0x0139, B:47:0x013f, B:48:0x0155, B:56:0x00b3, B:58:0x00b9, B:60:0x00bf, B:61:0x0081, B:63:0x0087, B:67:0x0091), top: B:12:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0109 A[Catch: all -> 0x01a2, TryCatch #0 {all -> 0x01a2, blocks: (B:13:0x001f, B:15:0x0029, B:17:0x0046, B:20:0x005b, B:22:0x0065, B:23:0x0067, B:25:0x006f, B:27:0x0072, B:29:0x0076, B:34:0x0099, B:36:0x009c, B:37:0x00d4, B:39:0x0109, B:41:0x011e, B:43:0x012f, B:45:0x0139, B:47:0x013f, B:48:0x0155, B:56:0x00b3, B:58:0x00b9, B:60:0x00bf, B:61:0x0081, B:63:0x0087, B:67:0x0091), top: B:12:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x011e A[Catch: all -> 0x01a2, TryCatch #0 {all -> 0x01a2, blocks: (B:13:0x001f, B:15:0x0029, B:17:0x0046, B:20:0x005b, B:22:0x0065, B:23:0x0067, B:25:0x006f, B:27:0x0072, B:29:0x0076, B:34:0x0099, B:36:0x009c, B:37:0x00d4, B:39:0x0109, B:41:0x011e, B:43:0x012f, B:45:0x0139, B:47:0x013f, B:48:0x0155, B:56:0x00b3, B:58:0x00b9, B:60:0x00bf, B:61:0x0081, B:63:0x0087, B:67:0x0091), top: B:12:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b9 A[Catch: all -> 0x01a2, TryCatch #0 {all -> 0x01a2, blocks: (B:13:0x001f, B:15:0x0029, B:17:0x0046, B:20:0x005b, B:22:0x0065, B:23:0x0067, B:25:0x006f, B:27:0x0072, B:29:0x0076, B:34:0x0099, B:36:0x009c, B:37:0x00d4, B:39:0x0109, B:41:0x011e, B:43:0x012f, B:45:0x0139, B:47:0x013f, B:48:0x0155, B:56:0x00b3, B:58:0x00b9, B:60:0x00bf, B:61:0x0081, B:63:0x0087, B:67:0x0091), top: B:12:0x001f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized com.tencent.stat.a a(android.content.Context r19) {
        /*
            Method dump skipped, instructions count: 450
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.t.a(android.content.Context):com.tencent.stat.a");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.f2911b.post(new b0(this, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.tencent.stat.a.b bVar, h hVar) {
        if (c.u()) {
            try {
                if (Thread.currentThread().getId() == this.f2911b.getLooper().getThread().getId()) {
                    b(bVar, hVar);
                } else {
                    this.f2911b.post(new x(this, bVar, hVar));
                }
            } catch (Throwable th) {
                f.c(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(g gVar) {
        if (gVar == null) {
            return;
        }
        this.f2911b.post(new y(this, gVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(List<d0> list) {
        try {
            if (Thread.currentThread().getId() == this.f2911b.getLooper().getThread().getId()) {
                b(list);
            } else {
                this.f2911b.post(new w(this, list));
            }
        } catch (SQLiteException e) {
            f.a((Exception) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(List<d0> list, int i) {
        try {
            if (Thread.currentThread().getId() == this.f2911b.getLooper().getThread().getId()) {
                b(list, i);
            } else {
                this.f2911b.post(new v(this, list, i));
            }
        } catch (Throwable th) {
            f.c(th);
        }
    }

    void b() {
        this.f2911b.post(new z(this));
    }
}
