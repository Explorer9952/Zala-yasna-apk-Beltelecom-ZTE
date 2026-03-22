package com.tencent.stat.i;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new o()).length;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b() {
        b bVar;
        int i = 0;
        try {
            String str = "";
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq").start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
            String trim = str.trim();
            if (trim.length() > 0) {
                i = Integer.valueOf(trim).intValue();
            }
        } catch (Exception e) {
            bVar = m.e;
            bVar.a(e);
        }
        return i * 1000;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c() {
        b bVar;
        int i = 0;
        try {
            String str = "";
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq").start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
            String trim = str.trim();
            if (trim.length() > 0) {
                i = Integer.valueOf(trim).intValue();
            }
        } catch (IOException e) {
            bVar = m.e;
            bVar.a((Exception) e);
        }
        return i * 1000;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d() {
        b bVar;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"));
            String[] split = bufferedReader.readLine().split(":\\s+", 2);
            for (int i = 0; i < split.length; i++) {
            }
            bufferedReader.close();
            return split[1];
        } catch (Throwable th) {
            bVar = m.e;
            bVar.c(th);
            return "";
        }
    }
}
