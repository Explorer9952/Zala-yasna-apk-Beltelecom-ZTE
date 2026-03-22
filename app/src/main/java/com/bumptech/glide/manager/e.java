package com.bumptech.glide.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bumptech.glide.manager.c;

/* compiled from: DefaultConnectivityMonitor.java */
/* loaded from: classes.dex */
class e implements c {

    /* renamed from: a, reason: collision with root package name */
    private final Context f2251a;

    /* renamed from: b, reason: collision with root package name */
    private final c.a f2252b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f2253c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f2254d;
    private final BroadcastReceiver e = new a();

    /* compiled from: DefaultConnectivityMonitor.java */
    /* loaded from: classes.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z = e.this.f2253c;
            e eVar = e.this;
            eVar.f2253c = eVar.a(context);
            if (z != e.this.f2253c) {
                e.this.f2252b.a(e.this.f2253c);
            }
        }
    }

    public e(Context context, c.a aVar) {
        this.f2251a = context.getApplicationContext();
        this.f2252b = aVar;
    }

    private void c() {
        if (this.f2254d) {
            this.f2251a.unregisterReceiver(this.e);
            this.f2254d = false;
        }
    }

    @Override // com.bumptech.glide.manager.h
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.h
    public void onStop() {
        c();
    }

    @Override // com.bumptech.glide.manager.h
    public void b() {
        a();
    }

    private void a() {
        if (this.f2254d) {
            return;
        }
        this.f2253c = a(this.f2251a);
        this.f2251a.registerReceiver(this.e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.f2254d = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
