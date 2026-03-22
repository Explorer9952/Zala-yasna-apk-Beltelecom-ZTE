package com.zte.iptvclient.android.mobile.d0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.k.g;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: LogExcatHelper.java */
/* loaded from: classes2.dex */
public class a {
    private static a f;
    private static String g;

    /* renamed from: a, reason: collision with root package name */
    private String f5734a = null;

    /* renamed from: b, reason: collision with root package name */
    private File f5735b = null;

    /* renamed from: c, reason: collision with root package name */
    private String f5736c = "logcat";

    /* renamed from: d, reason: collision with root package name */
    private HandlerThread f5737d;
    private boolean e;

    /* compiled from: LogExcatHelper.java */
    /* renamed from: com.zte.iptvclient.android.mobile.d0.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class HandlerC0211a extends Handler {
        HandlerC0211a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            LogEx.i("LogcatHelper", "handleMessage =" + a.this.e);
            a.this.c();
        }
    }

    /* compiled from: LogExcatHelper.java */
    /* loaded from: classes2.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogEx.e("LogcatHelper", "mRunning is false!");
            a.this.e = false;
        }
    }

    private a(Context context) {
        this.f5737d = null;
        new Handler();
        this.e = false;
        new b();
        g = Environment.getExternalStorageDirectory().getAbsolutePath() + "/zxct/";
        LogEx.d("LogcatHelper", "mstrFilePath = " + g);
        HandlerThread handlerThread = new HandlerThread("logHandler");
        this.f5737d = handlerThread;
        handlerThread.start();
        Looper looper = this.f5737d.getLooper();
        if (looper != null) {
            new HandlerC0211a(looper);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0121 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0117 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x00c2 -> B:27:0x010e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c() {
        /*
            Method dump skipped, instructions count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.mobile.d0.a.c():void");
    }

    @SuppressLint({"SimpleDateFormat"})
    public static String b() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date(System.currentTimeMillis()));
    }

    public static a a(Context context) {
        if (f == null) {
            f = new a(context);
        }
        return f;
    }

    public void a(String str) {
        this.f5734a = str;
        LogEx.e("LogcatHelper", "strName=" + this.f5734a);
    }

    private void a() {
        File file = new File(g, this.f5734a);
        this.f5735b = file;
        if (file.exists()) {
            g.b(this.f5735b.getAbsolutePath(), "delete");
            this.f5735b.delete();
        }
    }
}
