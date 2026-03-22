package com.zte.iptvclient.common.uiframe;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* compiled from: ResMgr.java */
/* loaded from: classes2.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static Resources f7918a;

    public static Drawable a(int i) {
        Resources resources = f7918a;
        if (resources == null) {
            return null;
        }
        try {
            return resources.getDrawable(i);
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }
}
