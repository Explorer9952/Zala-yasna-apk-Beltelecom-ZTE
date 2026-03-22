package com.zte.iptvclient.common.uiframe;

import com.video.androidsdk.common.BaseObject;
import com.video.androidsdk.log.LogEx;
import java.util.ArrayList;

/* compiled from: ActivityMgr.java */
/* loaded from: classes2.dex */
public class b extends BaseObject {

    /* renamed from: c, reason: collision with root package name */
    private static b f7896c;

    /* renamed from: a, reason: collision with root package name */
    private int f7897a = 0;

    /* renamed from: b, reason: collision with root package name */
    private boolean f7898b = false;

    private b() {
        new ArrayList();
        b();
    }

    public static b c() {
        synchronized (b.class) {
            if (f7896c != null) {
                return f7896c;
            }
            LogEx.d("ActivityMgr", "ActivityMgr is null ,create new.");
            b bVar = new b();
            f7896c = bVar;
            return bVar;
        }
    }

    public void a(int i) {
        this.f7897a = i;
    }

    public void b() {
        if (this.f7898b) {
            return;
        }
        this.f7898b = true;
    }

    public int a() {
        return this.f7897a;
    }
}
