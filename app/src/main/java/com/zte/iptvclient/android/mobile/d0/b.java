package com.zte.iptvclient.android.mobile.d0;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: SpaceItemDecoration.java */
/* loaded from: classes2.dex */
public class b extends RecyclerView.n {

    /* renamed from: a, reason: collision with root package name */
    int f5740a;

    /* renamed from: b, reason: collision with root package name */
    int f5741b;

    /* renamed from: c, reason: collision with root package name */
    int f5742c;

    public b(int i, int i2, int i3) {
        this.f5740a = i;
        this.f5741b = i2;
        this.f5742c = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.y yVar) {
        super.a(rect, view, recyclerView, yVar);
        rect.left = this.f5740a;
        rect.right = this.f5741b;
        int i = this.f5742c;
        rect.bottom = i;
        rect.top = i;
    }
}
