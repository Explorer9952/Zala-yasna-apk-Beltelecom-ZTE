package com.video.androidsdk.cast.a;

import com.video.androidsdk.cast.DlnaNativeSDK;
import com.video.androidsdk.common.GlobalConst;
import com.video.androidsdk.log.LogEx;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DLNASoImpl.java */
/* loaded from: classes.dex */
public class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f3056a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.f3056a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        z = this.f3056a.m;
        if (!z) {
            LogEx.w(GlobalConst.MODULE_NAME_COMMON, "UPNP may not init! Please check log and wait next time!");
            return;
        }
        LogEx.d(GlobalConst.MODULE_NAME_COMMON, "UPNP scan preparing");
        DlnaNativeSDK.JNI_RefreshDevList();
        LogEx.d(GlobalConst.MODULE_NAME_COMMON, "UPNP scan end");
    }
}
