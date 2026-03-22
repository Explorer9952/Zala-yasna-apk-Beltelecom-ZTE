package com.tencent.stat;

import android.content.Context;
import android.os.Environment;
import android.provider.Settings;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Iterator;

/* loaded from: classes.dex */
public class f {
    private static f e;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.stat.i.b f2859a = com.tencent.stat.i.m.b();

    /* renamed from: b, reason: collision with root package name */
    private boolean f2860b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f2861c;

    /* renamed from: d, reason: collision with root package name */
    private Context f2862d;

    private f(Context context) {
        this.f2860b = false;
        this.f2861c = false;
        this.f2862d = null;
        this.f2862d = context.getApplicationContext();
        this.f2860b = b(context);
        d(context);
        this.f2861c = c(context);
    }

    public static synchronized f a(Context context) {
        f fVar;
        synchronized (f.class) {
            if (e == null) {
                e = new f(context);
            }
            fVar = e;
        }
        return fVar;
    }

    private boolean b(Context context) {
        if (com.tencent.stat.i.m.a(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            return true;
        }
        this.f2859a.c("Check permission failed: android.permission.WRITE_EXTERNAL_STORAGE");
        return false;
    }

    private boolean c(Context context) {
        if (com.tencent.stat.i.m.a(context, "android.permission.WRITE_SETTINGS")) {
            return true;
        }
        this.f2859a.c("Check permission failed: android.permission.WRITE_SETTINGS");
        return false;
    }

    private boolean d(Context context) {
        if (com.tencent.stat.i.m.d() < 14) {
            return b(context);
        }
        return true;
    }

    public boolean a(String str, String str2) {
        com.tencent.stat.i.q.b(this.f2862d, str, str2);
        return true;
    }

    public String b(String str, String str2) {
        return com.tencent.stat.i.q.a(this.f2862d, str, str2);
    }

    public boolean c(String str, String str2) {
        if (!this.f2860b) {
            return false;
        }
        try {
            com.tencent.stat.i.f.a(Environment.getExternalStorageDirectory() + "/Tencent/mta");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(Environment.getExternalStorageDirectory(), "Tencent/mta/.mid.txt")));
            bufferedWriter.write(str + "," + str2);
            bufferedWriter.write("\n");
            bufferedWriter.close();
            return true;
        } catch (Throwable th) {
            this.f2859a.g(th);
            return false;
        }
    }

    public String d(String str, String str2) {
        if (!this.f2860b) {
            return null;
        }
        try {
            Iterator<String> it2 = com.tencent.stat.i.f.a(new File(Environment.getExternalStorageDirectory(), "Tencent/mta/.mid.txt")).iterator();
            while (it2.hasNext()) {
                String[] split = it2.next().split(",");
                if (split.length == 2 && split[0].equals(str)) {
                    return split[1];
                }
            }
        } catch (FileNotFoundException unused) {
            this.f2859a.g("Tencent/mta/.mid.txt not found.");
        } catch (Throwable th) {
            this.f2859a.g(th);
        }
        return null;
    }

    public boolean e(String str, String str2) {
        if (!this.f2861c) {
            return false;
        }
        Settings.System.putString(this.f2862d.getContentResolver(), str, str2);
        return true;
    }

    public String f(String str, String str2) {
        return !this.f2861c ? str2 : Settings.System.getString(this.f2862d.getContentResolver(), str);
    }
}
