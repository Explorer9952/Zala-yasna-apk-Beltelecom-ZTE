package com.zte.iptvclient.android.common.customview.viewgroup.a;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.video.androidsdk.log.LogEx;

/* compiled from: GridSpacingItemDecorationForLastWatch.java */
/* loaded from: classes.dex */
public class b extends RecyclerView.n {

    /* renamed from: d, reason: collision with root package name */
    private static String f4383d = "b";

    /* renamed from: a, reason: collision with root package name */
    private int f4384a;

    /* renamed from: b, reason: collision with root package name */
    private int f4385b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4386c;

    public b(int i, int i2, boolean z) {
        this.f4384a = i;
        this.f4385b = i2;
        this.f4386c = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.y yVar) {
        int e = recyclerView.e(view);
        com.zte.iptvclient.android.mobile.d.a.a aVar = (com.zte.iptvclient.android.mobile.d.a.a) recyclerView.s();
        int h = aVar.h();
        if (e == 0 || e == h) {
            return;
        }
        int b2 = aVar.b(e);
        if (b2 != 1 && b2 != 2) {
            int i = (e < h ? e - 1 : (e - h) - 1) % this.f4384a;
            if (this.f4386c) {
                int i2 = this.f4385b;
                int i3 = this.f4384a;
                rect.left = i2 - ((i * i2) / i3);
                rect.right = ((i + 1) * i2) / i3;
                rect.top = i2;
            } else {
                int i4 = this.f4385b;
                int i5 = this.f4384a;
                rect.left = (i * i4) / i5;
                rect.right = i4 - (((i + 1) * i4) / i5);
            }
        }
        LogEx.d(f4383d, " position = " + e + "left" + rect.left + "" + TtmlNode.RIGHT + rect.right);
    }
}
