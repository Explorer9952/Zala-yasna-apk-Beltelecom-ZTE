package com.zte.iptvclient.android.mobile.e0;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.mobile.e0.d.g;

/* compiled from: VodListGridViewItemSpacingDecoration.java */
/* loaded from: classes2.dex */
public class c extends RecyclerView.n {
    private static String e = "VodListGridViewItemSpacingDecoration";

    /* renamed from: a, reason: collision with root package name */
    private int f5787a;

    /* renamed from: b, reason: collision with root package name */
    private int f5788b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f5789c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f5790d;

    public c(int i, int i2, boolean z, String str) {
        this.f5787a = i;
        this.f5788b = i2;
        this.f5789c = z;
        this.f5790d = "1".equals(str);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.y yVar) {
        int e2 = recyclerView.e(view);
        if (!this.f5790d) {
            int i = this.f5787a;
            int i2 = e2 % i;
            if (this.f5789c) {
                int i3 = this.f5788b;
                rect.left = i3 - ((i2 * i3) / i);
                rect.right = ((i2 + 1) * i3) / i;
                rect.top = i3;
            } else {
                int i4 = this.f5788b;
                rect.left = (i2 * i4) / i;
                rect.right = i4 - (((i2 + 1) * i4) / i);
            }
        } else {
            RecyclerView.g s = recyclerView.s();
            if (s instanceof g) {
                int e3 = ((g) s).e(e2);
                if (e3 < 0) {
                    if (this.f5789c) {
                        int i5 = this.f5788b;
                        rect.left = i5;
                        rect.right = i5;
                        rect.top = i5;
                    } else {
                        rect.left = 0;
                        rect.right = 0;
                    }
                } else {
                    int i6 = this.f5787a;
                    int i7 = e3 % i6;
                    if (this.f5789c) {
                        int i8 = this.f5788b;
                        rect.left = i8 - ((i7 * i8) / i6);
                        rect.right = ((i7 + 1) * i8) / i6;
                        rect.top = i8;
                    } else {
                        int i9 = this.f5788b;
                        rect.left = (i7 * i9) / i6;
                        rect.right = i9 - (((i7 + 1) * i9) / i6);
                    }
                }
            }
        }
        LogEx.d(e, " position = " + e2);
    }
}
