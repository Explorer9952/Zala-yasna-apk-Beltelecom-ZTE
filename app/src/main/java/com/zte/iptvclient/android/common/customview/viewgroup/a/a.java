package com.zte.iptvclient.android.common.customview.viewgroup.a;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.video.androidsdk.log.LogEx;

/* compiled from: GridSpacingItemDecoration.java */
/* loaded from: classes.dex */
public class a extends RecyclerView.n {

    /* renamed from: d, reason: collision with root package name */
    private static String f4379d = "a";

    /* renamed from: a, reason: collision with root package name */
    private int f4380a;

    /* renamed from: b, reason: collision with root package name */
    private int f4381b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4382c;

    public a(int i, int i2, boolean z) {
        this.f4380a = i;
        this.f4381b = i2;
        this.f4382c = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.y yVar) {
        int e = recyclerView.e(view);
        if (recyclerView.s().b(0) != 0) {
            int i = this.f4380a;
            int i2 = e % i;
            if (this.f4382c) {
                int i3 = this.f4381b;
                rect.left = i3 - ((i2 * i3) / i);
                rect.right = ((i2 + 1) * i3) / i;
                rect.top = i3;
                return;
            }
            int i4 = this.f4381b;
            rect.left = (i2 * i4) / i;
            rect.right = i4 - (((i2 + 1) * i4) / i);
            return;
        }
        if (e == 0) {
            return;
        }
        int i5 = this.f4380a;
        int i6 = (e - 1) % i5;
        if (this.f4382c) {
            int i7 = this.f4381b;
            rect.left = i7 - ((i6 * i7) / i5);
            rect.right = ((i6 + 1) * i7) / i5;
            rect.top = i7;
        } else {
            int i8 = this.f4381b;
            rect.left = (i6 * i8) / i5;
            rect.right = i8 - (((i6 + 1) * i8) / i5);
        }
        LogEx.d(f4379d, " position = " + e + "left" + rect.left + "" + TtmlNode.RIGHT + rect.right);
    }
}
