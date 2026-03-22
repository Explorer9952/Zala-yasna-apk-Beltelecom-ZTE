package com.video.androidsdk.player.agama;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import tv.agama.emp.client.Definitions$DeviceMetadata;
import tv.agama.emp.client.EMPClient;

/* compiled from: AgamaIntegration.java */
/* loaded from: classes.dex */
class a extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AgamaIntegration f3328a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AgamaIntegration agamaIntegration) {
        this.f3328a = agamaIntegration;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        EMPClient eMPClient;
        eMPClient = AgamaIntegration.f3319d;
        eMPClient.a(Definitions$DeviceMetadata.DATA_CONNECTION_TYPE, Utils.b(context));
    }
}
