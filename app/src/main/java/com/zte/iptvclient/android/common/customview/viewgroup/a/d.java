package com.zte.iptvclient.android.common.customview.viewgroup.a;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: MySpacesItemDecoration.java */
/* loaded from: classes.dex */
public class d extends RecyclerView.n {

    /* renamed from: a, reason: collision with root package name */
    private int f4391a;

    /* renamed from: b, reason: collision with root package name */
    private int f4392b = 0;

    public d(int i) {
        this.f4391a = 0;
        this.f4391a = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.y yVar) {
        rect.bottom = this.f4391a;
        rect.top = this.f4392b;
    }
}
