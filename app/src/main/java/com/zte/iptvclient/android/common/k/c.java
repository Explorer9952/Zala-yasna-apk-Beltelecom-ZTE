package com.zte.iptvclient.android.common.k;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.video.androidsdk.log.LogEx;
import java.io.File;

/* compiled from: BaseCommUtil.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static long f4798a;

    public static boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f4798a <= 1000) {
            LogEx.w("BaseCommUtil", "Operate limit,less than 1000(ms)!");
            return true;
        }
        f4798a = currentTimeMillis;
        return false;
    }

    public static void a(File file) {
        if (file.isFile()) {
            g.b(file.getAbsolutePath(), "delete");
            if (!file.delete()) {
                throw new RuntimeException("delete failed");
            }
            return;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    a(file2);
                }
                g.b(file.getAbsolutePath(), "delete");
                if (!file.delete()) {
                    throw new RuntimeException("delete failed");
                }
                return;
            }
            g.b(file.getAbsolutePath(), "delete");
            if (!file.delete()) {
                throw new RuntimeException("delete failed");
            }
        }
    }

    public static boolean a(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected() && activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED;
    }
}
