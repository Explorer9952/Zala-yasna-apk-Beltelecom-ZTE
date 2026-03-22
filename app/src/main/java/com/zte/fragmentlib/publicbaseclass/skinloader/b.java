package com.zte.fragmentlib.publicbaseclass.skinloader;

import android.content.Context;
import com.video.androidsdk.log.LogEx;
import java.io.File;
import java.io.IOException;

/* compiled from: SkinLoaderUtil.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static String f4074a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f4075b = "";

    public static void a(Context context) {
        try {
            String[] list = context.getAssets().list("skin");
            for (int i = 0; i < list.length; i++) {
                LogEx.d("SkinLoaderUtil", "skinfile name:" + list[i]);
                if (d(context, list[i])) {
                    LogEx.d("SkinLoaderUtil", "skinfile exists no need copy");
                } else {
                    LogEx.d("SkinLoaderUtil", "copy skinfile to local");
                    a(context, list[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean b(Context context, String str) {
        LogEx.d("SkinLoaderUtil", "whether in ExternalFilesDir");
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir != null && externalFilesDir.exists()) {
            LogEx.d("SkinLoaderUtil", "ExternalFilesDir exit");
            if (new File(externalFilesDir.getAbsolutePath() + File.separator + str).exists()) {
                LogEx.d("SkinLoaderUtil", "skin file in ExternalFilesDir");
                f4074a = externalFilesDir.getAbsolutePath();
                return true;
            }
            LogEx.d("SkinLoaderUtil", "skin file not in ExternalFilesDir");
            return false;
        }
        LogEx.d("SkinLoaderUtil", "ExternalFilesDir not exit");
        return false;
    }

    private static boolean c(Context context, String str) {
        LogEx.d("SkinLoaderUtil", "whether in FilesDir");
        if (new File(context.getFilesDir().getAbsolutePath() + File.separator + str).exists()) {
            LogEx.d("SkinLoaderUtil", "skin file in FilesDir");
            f4074a = context.getFilesDir().getAbsolutePath();
            return true;
        }
        LogEx.d("SkinLoaderUtil", "skin file not in FilesDir");
        return false;
    }

    private static boolean d(Context context, String str) {
        LogEx.d("SkinLoaderUtil", "whether in sdcard");
        return b(context, str) || c(context, str);
    }

    private static void a(Context context, String str) {
        File externalFilesDir = context.getExternalFilesDir(null);
        if (externalFilesDir != null && externalFilesDir.exists()) {
            LogEx.d("SkinLoaderUtil", "copy skin file to ExternalFilesDir,fileName:" + str);
            a(context, str, externalFilesDir.getAbsolutePath());
            f4074a = externalFilesDir.getAbsolutePath();
            return;
        }
        LogEx.d("SkinLoaderUtil", "copy skin file to FilesDir,fileName:" + str);
        a(context, str, context.getFilesDir().getAbsolutePath());
        f4074a = context.getFilesDir().getAbsolutePath();
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00b2 A[Catch: IOException -> 0x00ae, TRY_LEAVE, TryCatch #10 {IOException -> 0x00ae, blocks: (B:61:0x00aa, B:48:0x00b2), top: B:60:0x00aa }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(android.content.Context r4, java.lang.String r5, java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 198
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.fragmentlib.publicbaseclass.skinloader.b.a(android.content.Context, java.lang.String, java.lang.String):void");
    }
}
