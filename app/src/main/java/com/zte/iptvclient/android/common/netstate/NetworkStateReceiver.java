package com.zte.iptvclient.android.common.netstate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.netstate.NetWorkUtil;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class NetworkStateReceiver extends BroadcastReceiver {

    /* renamed from: b, reason: collision with root package name */
    private static NetWorkUtil.netType f4846b;

    /* renamed from: d, reason: collision with root package name */
    private static BroadcastReceiver f4848d;

    /* renamed from: a, reason: collision with root package name */
    private static Boolean f4845a = false;

    /* renamed from: c, reason: collision with root package name */
    private static ArrayList<a> f4847c = new ArrayList<>();

    private static BroadcastReceiver a() {
        if (f4848d == null) {
            f4848d = new NetworkStateReceiver();
        }
        return f4848d;
    }

    public static void b(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ta.android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.getApplicationContext().registerReceiver(a(), intentFilter);
    }

    private void c() {
        for (int i = 0; i < f4847c.size(); i++) {
            a aVar = f4847c.get(i);
            if (aVar != null) {
                if (b().booleanValue()) {
                    aVar.a(f4846b);
                } else {
                    aVar.a();
                }
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        f4848d = this;
        String action = intent.getAction();
        if (action == null) {
            action = "";
        }
        if (action.equalsIgnoreCase("android.net.conn.CONNECTIVITY_CHANGE") || action.equalsIgnoreCase("ta.android.net.conn.CONNECTIVITY_CHANGE")) {
            LogEx.i("NetworkStateReceiver", "网络状态改变.");
            if (!NetWorkUtil.b(context)) {
                LogEx.i("NetworkStateReceiver", "没有网络连接.");
                f4845a = false;
            } else {
                LogEx.i("NetworkStateReceiver", "网络连接成功.");
                f4846b = NetWorkUtil.a(context);
                f4845a = true;
            }
            c();
        }
    }

    public static void a(Context context) {
        Intent intent = new Intent();
        intent.setAction("ta.android.net.conn.CONNECTIVITY_CHANGE");
        context.sendBroadcast(intent);
    }

    public static Boolean b() {
        return f4845a;
    }

    public static void a(a aVar) {
        if (f4847c == null) {
            f4847c = new ArrayList<>();
        }
        f4847c.add(aVar);
    }

    public static void b(a aVar) {
        ArrayList<a> arrayList = f4847c;
        if (arrayList != null) {
            arrayList.remove(aVar);
        }
    }
}
