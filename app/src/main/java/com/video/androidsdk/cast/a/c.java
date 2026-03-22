package com.video.androidsdk.cast.a;

import com.video.androidsdk.cast.DlnaNativeSDK;
import com.video.androidsdk.cast.SDKCastMgr;
import com.video.androidsdk.cast.bean.DLNAEvent;
import com.video.androidsdk.common.GlobalConst;
import com.video.androidsdk.log.LogEx;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DLNASoImpl.java */
/* loaded from: classes.dex */
public class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f3054a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.f3054a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        LinkedList linkedList;
        LinkedList linkedList2;
        LinkedList linkedList3;
        LinkedList linkedList4;
        Vector vector;
        String str;
        String str2;
        int i;
        String str3;
        String str4;
        int i2;
        boolean z;
        boolean z2;
        String str5;
        Vector vector2;
        Vector vector3;
        linkedList = this.f3054a.q;
        synchronized (linkedList) {
            linkedList2 = this.f3054a.q;
            if (linkedList2.isEmpty()) {
                return;
            }
            linkedList3 = this.f3054a.q;
            if (((Boolean) linkedList3.peek()).booleanValue()) {
                linkedList4 = this.f3054a.q;
                linkedList4.poll();
                LogEx.d(GlobalConst.MODULE_NAME_COMMON, "UPNP init preparing");
                try {
                    str = this.f3054a.f3052d;
                    str2 = this.f3054a.f;
                    i = this.f3054a.g;
                    str3 = this.f3054a.h;
                    str4 = this.f3054a.i;
                    String str6 = SDKCastMgr.mRequestConfigFilePath;
                    i2 = this.f3054a.j;
                    z = this.f3054a.k;
                    z2 = this.f3054a.l;
                    str5 = this.f3054a.e;
                    int JNI_DlnaInit = DlnaNativeSDK.JNI_DlnaInit(str, 0, str2, i, str3, str4, str6, i2, z, z2, str5);
                    if (JNI_DlnaInit == 0) {
                        this.f3054a.m = true;
                        LogEx.e(GlobalConst.MODULE_NAME_COMMON, "UPNP init success");
                        DLNAEvent dLNAEvent = new DLNAEvent(DLNAEvent.EVENT_INIT_COMPLETE, "0", "", null);
                        vector3 = this.f3054a.o;
                        Iterator it2 = vector3.iterator();
                        while (it2.hasNext()) {
                            ((com.video.androidsdk.cast.c) it2.next()).a(dLNAEvent);
                        }
                        return;
                    }
                    LogEx.e(GlobalConst.MODULE_NAME_COMMON, "UPNP init failed");
                    DLNAEvent dLNAEvent2 = new DLNAEvent(DLNAEvent.EVENT_INIT_FAILED, Integer.toString(JNI_DlnaInit), "UPNP init failed!", null);
                    vector2 = this.f3054a.o;
                    Iterator it3 = vector2.iterator();
                    while (it3.hasNext()) {
                        ((com.video.androidsdk.cast.c) it3.next()).a(dLNAEvent2);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    LogEx.e(GlobalConst.MODULE_NAME_COMMON, "UPNP init failed");
                    DLNAEvent dLNAEvent3 = new DLNAEvent(DLNAEvent.EVENT_INIT_FAILED, DLNAEvent.EVENT_UNKNOWN, "UPNP init failed!" + e.getMessage(), null);
                    vector = this.f3054a.o;
                    Iterator it4 = vector.iterator();
                    while (it4.hasNext()) {
                        ((com.video.androidsdk.cast.c) it4.next()).a(dLNAEvent3);
                    }
                }
            }
        }
    }
}
