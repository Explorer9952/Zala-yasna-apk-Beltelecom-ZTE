package com.tencent.stat;

import android.content.Context;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public class StatNativeCrashReport {

    /* renamed from: a, reason: collision with root package name */
    private static com.tencent.stat.i.b f2821a = com.tencent.stat.i.m.b();

    /* renamed from: b, reason: collision with root package name */
    private static String f2822b;

    static {
        new StatNativeCrashReport();
        f2822b = null;
        try {
            System.loadLibrary("MtaNativeCrash");
        } catch (Throwable th) {
            f2821a.g(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(File file) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append('\n');
            }
            bufferedReader.close();
        } catch (IOException e) {
            f2821a.a((Exception) e);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LinkedHashSet<File> a(Context context) {
        File[] listFiles;
        LinkedHashSet<File> linkedHashSet = new LinkedHashSet<>();
        String b2 = b(context);
        if (b2 != null) {
            File file = new File(b2);
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.getName().startsWith("tombstone_") && file2.isFile()) {
                        f2821a.a("get tombstone file:" + file2.getAbsolutePath().toString());
                        linkedHashSet.add(file2.getAbsoluteFile());
                    }
                }
            }
        }
        return linkedHashSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long b(File file) {
        try {
            return Long.valueOf(file.getName().replace("tombstone_", "")).longValue();
        } catch (NumberFormatException e) {
            f2821a.a((Exception) e);
            return 0L;
        }
    }

    public static String b(Context context) {
        if (f2822b == null) {
            f2822b = com.tencent.stat.i.q.a(context, "__mta_tombstone__", "");
        }
        return f2822b;
    }
}
