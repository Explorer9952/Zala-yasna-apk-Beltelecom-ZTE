package com.zte.iptvclient.android.mobile.download.helper.b.b;

import android.os.Handler;
import android.os.Message;
import com.video.androidsdk.log.LogEx;

/* compiled from: WorldToast.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static a f5764b = new a();

    /* renamed from: a, reason: collision with root package name */
    private Handler f5765a;

    private a() {
    }

    public static a a() {
        return f5764b;
    }

    public void a(Handler handler) {
        this.f5765a = handler;
    }

    public void a(String str) {
        Message message = new Message();
        message.what = 0;
        message.obj = str;
        Handler handler = this.f5765a;
        if (handler != null) {
            handler.sendMessage(message);
        }
    }

    public void a(int i) {
        Message message = new Message();
        message.what = 1;
        message.obj = Integer.valueOf(i);
        LogEx.d("worldtoast", "shwomsg:" + i);
        Handler handler = this.f5765a;
        if (handler != null) {
            handler.sendMessage(message);
        }
    }
}
