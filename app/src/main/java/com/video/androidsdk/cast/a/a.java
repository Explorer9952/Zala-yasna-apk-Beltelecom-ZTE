package com.video.androidsdk.cast.a;

import com.video.androidsdk.cast.DlnaNativeSDK;
import com.video.androidsdk.cast.bean.DLNAEvent;
import com.video.androidsdk.common.GlobalConst;
import com.video.androidsdk.log.LogEx;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: DLNASoImpl.java */
/* loaded from: classes.dex */
public class a implements com.video.androidsdk.cast.b {

    /* renamed from: c, reason: collision with root package name */
    private static a f3049c;
    private static Object r = a.class;
    private Vector<com.video.androidsdk.cast.c> o;
    private ExecutorService p;
    private LinkedList<Boolean> q;

    /* renamed from: d, reason: collision with root package name */
    private String f3052d = null;
    private String e = null;
    private String f = null;
    private int g = 0;
    private String h = null;
    private String i = null;
    private int j = 2;
    private boolean k = true;
    private boolean l = true;
    private boolean m = false;
    private boolean n = false;

    /* renamed from: a, reason: collision with root package name */
    Timer f3050a = new Timer();

    /* renamed from: b, reason: collision with root package name */
    TimerTask f3051b = new b(this);
    private Runnable s = new c(this);
    private Runnable t = new d(this);
    private Runnable u = new e(this);

    public a() {
        this.o = null;
        this.p = null;
        this.q = null;
        this.o = new Vector<>();
        this.p = Executors.newFixedThreadPool(1);
        this.q = new LinkedList<>();
    }

    public static com.video.androidsdk.cast.b d() {
        a aVar;
        LogEx.d(GlobalConst.MODULE_NAME_COMMON, "DLNASoImpl.getInstance");
        synchronized (r) {
            if (f3049c == null) {
                LogEx.d(GlobalConst.MODULE_NAME_COMMON, "New DLNA Instance");
                f3049c = new a();
            }
            aVar = f3049c;
        }
        return aVar;
    }

    @Override // com.video.androidsdk.cast.b
    public int c() {
        LogEx.d(GlobalConst.MODULE_NAME_COMMON, "DLNASoImpl.scanDevices - assign upnp scan");
        synchronized (r) {
            if (!f3049c.m) {
                this.p.submit(this.t);
                this.p.submit(this.s);
            } else {
                this.p.submit(this.u);
            }
        }
        return 0;
    }

    public void e() {
        LogEx.d(GlobalConst.MODULE_NAME_COMMON, "DLNASoImpl.initilize - assign upnp init");
        a((Boolean) true);
        this.p.submit(this.s);
    }

    private void a(Boolean bool) {
        synchronized (this.q) {
            if (!this.q.isEmpty()) {
                Boolean peek = this.q.peek();
                if (this.q.size() == 1 && peek.booleanValue() == bool.booleanValue()) {
                    return;
                }
                if (this.q.size() == 2) {
                    if (peek.booleanValue() == bool.booleanValue()) {
                        this.q.clear();
                        this.q.add(bool);
                    }
                    return;
                }
            }
            this.q.add(bool);
        }
    }

    @Override // com.video.androidsdk.cast.b
    public void b() {
        LogEx.d(GlobalConst.MODULE_NAME_COMMON, "DLNASoImpl.uninitilize - assign upnp stop");
        a((Boolean) false);
        this.p.submit(this.t);
    }

    @Override // com.video.androidsdk.cast.b
    public void b(com.video.androidsdk.cast.c cVar) {
        this.o.remove(cVar);
    }

    public static com.video.androidsdk.cast.b a(String str, String str2, int i, String str3, String str4, int i2, boolean z, boolean z2, String str5) {
        a aVar;
        LogEx.d(GlobalConst.MODULE_NAME_COMMON, "DLNASoImpl.newInstance");
        synchronized (r) {
            if (f3049c == null) {
                LogEx.d(GlobalConst.MODULE_NAME_COMMON, "New DLNA Instance");
                f3049c = new a();
            }
            f3049c.f3052d = str;
            f3049c.f = str2;
            f3049c.g = i;
            f3049c.h = str3;
            f3049c.i = str4;
            f3049c.j = i2;
            f3049c.k = z;
            f3049c.l = z2;
            f3049c.e = str5;
            f3049c.b();
            f3049c.e();
            aVar = f3049c;
        }
        return aVar;
    }

    @Override // com.video.androidsdk.cast.b
    public boolean a() {
        return this.m;
    }

    @Override // com.video.androidsdk.cast.b
    public void a(com.video.androidsdk.cast.c cVar) {
        if (this.o.contains(cVar)) {
            return;
        }
        this.o.add(cVar);
    }

    @Override // com.video.androidsdk.cast.b
    public void a(int i, String str, String str2) {
        LogEx.d(GlobalConst.MODULE_NAME_COMMON, "receive stb event: Event[" + i + "]");
        if (str2 != null) {
            LogEx.e(GlobalConst.MODULE_NAME_COMMON, "obj = " + str2);
        }
        DLNAEvent dLNAEvent = new DLNAEvent(i != -1 ? i != 0 ? i != 1 ? i != 2 ? i != 3 ? DLNAEvent.EVENT_UNKNOWN : DLNAEvent.EVENT_BROWSE_COMPLETE : DLNAEvent.EVENT_DEVICE_AUTHFAILED : DLNAEvent.EVENT_DEVICE_OFFLINE : DLNAEvent.EVENT_DEVICE_ONLINE : DLNAEvent.EVENT_INIT_COMPLETE, Integer.toString(i), str, str2);
        Iterator<com.video.androidsdk.cast.c> it2 = this.o.iterator();
        while (it2.hasNext()) {
            it2.next().a(dLNAEvent);
        }
    }

    @Override // com.video.androidsdk.cast.b
    public void a(int i, int i2, String str) {
        LogEx.d(GlobalConst.MODULE_NAME_COMMON, "Send action result :" + DlnaNativeSDK.JNI_SendAction(i, i2, str));
    }

    @Override // com.video.androidsdk.cast.b
    public void a(String str, String str2) {
        LogEx.d(GlobalConst.MODULE_NAME_COMMON, "XMPP login :" + str);
        DlnaNativeSDK.JNI_XMPPLogin(str, str2);
    }
}
