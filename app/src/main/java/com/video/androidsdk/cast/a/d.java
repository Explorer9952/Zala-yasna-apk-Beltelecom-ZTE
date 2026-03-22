package com.video.androidsdk.cast.a;

import com.video.androidsdk.cast.DlnaNativeSDK;
import com.video.androidsdk.common.GlobalConst;
import com.video.androidsdk.log.LogEx;
import java.util.LinkedList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DLNASoImpl.java */
/* loaded from: classes.dex */
public class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f3055a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.f3055a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinkedList linkedList;
        LinkedList linkedList2;
        LinkedList linkedList3;
        LinkedList linkedList4;
        linkedList = this.f3055a.q;
        synchronized (linkedList) {
            linkedList2 = this.f3055a.q;
            if (linkedList2.isEmpty()) {
                return;
            }
            linkedList3 = this.f3055a.q;
            if (((Boolean) linkedList3.peek()).booleanValue()) {
                return;
            }
            linkedList4 = this.f3055a.q;
            linkedList4.poll();
            LogEx.d(GlobalConst.MODULE_NAME_COMMON, "UPNP stop preparing");
            try {
                DlnaNativeSDK.JNI_DlnaUninit();
                LogEx.d(GlobalConst.MODULE_NAME_COMMON, "UPNP uninit success");
            } catch (Exception unused) {
                LogEx.e(GlobalConst.MODULE_NAME_COMMON, "UPNP uninit failed");
            }
            this.f3055a.m = false;
        }
    }
}
