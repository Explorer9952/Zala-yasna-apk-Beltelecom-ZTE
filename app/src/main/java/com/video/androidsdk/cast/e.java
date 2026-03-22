package com.video.androidsdk.cast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import com.video.androidsdk.common.ClientNetworkInfo;
import com.video.androidsdk.log.LogEx;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SDKCastMgr.java */
/* loaded from: classes.dex */
public class e extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SDKCastMgr f3058a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SDKCastMgr sDKCastMgr) {
        this.f3058a = sDKCastMgr;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        int i;
        boolean z;
        boolean z2;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        int i2;
        boolean z3;
        boolean z4;
        String str12;
        if (context == null) {
            return;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        this.f3058a.b();
        int i3 = 0;
        if (activeNetworkInfo != null && activeNetworkInfo.getType() == 1) {
            if (activeNetworkInfo.getState().equals(NetworkInfo.State.CONNECTED)) {
                try {
                    this.f3058a.f3045c = new ClientNetworkInfo().getLocalIP((WifiManager) context.getSystemService("wifi"));
                    str7 = this.f3058a.f3045c;
                    str8 = this.f3058a.u;
                    str9 = this.f3058a.v;
                    str10 = this.f3058a.w;
                    str11 = this.f3058a.x;
                    i2 = this.f3058a.y;
                    z3 = this.f3058a.z;
                    z4 = this.f3058a.A;
                    str12 = this.f3058a.t;
                    a.a(str7, str8, str9, str10, str11, i2, z3, z4, str12);
                    return;
                } catch (Exception e) {
                    LogEx.d("SDKCastMgr", "handleMessage error :" + e.getMessage());
                    StackTraceElement[] stackTrace = e.getStackTrace();
                    int length = stackTrace.length;
                    while (i3 < length) {
                        LogEx.d("SDKCastMgr", stackTrace[i3].toString());
                        i3++;
                    }
                    return;
                }
            }
            return;
        }
        if (activeNetworkInfo != null && activeNetworkInfo.getType() == 0 && activeNetworkInfo.getState().equals(NetworkInfo.State.CONNECTED)) {
            try {
                this.f3058a.f3045c = new ClientNetworkInfo().getLocalIPAddress();
                str = this.f3058a.f3045c;
                str2 = this.f3058a.u;
                str3 = this.f3058a.v;
                str4 = this.f3058a.w;
                str5 = this.f3058a.x;
                i = this.f3058a.y;
                z = this.f3058a.z;
                z2 = this.f3058a.A;
                str6 = this.f3058a.t;
                a.a(str, str2, str3, str4, str5, i, z, z2, str6);
            } catch (Exception e2) {
                LogEx.d("SDKCastMgr", "handleMessage error :" + e2.getMessage());
                StackTraceElement[] stackTrace2 = e2.getStackTrace();
                int length2 = stackTrace2.length;
                while (i3 < length2) {
                    LogEx.d("SDKCastMgr", stackTrace2[i3].toString());
                    i3++;
                }
            }
        }
    }
}
