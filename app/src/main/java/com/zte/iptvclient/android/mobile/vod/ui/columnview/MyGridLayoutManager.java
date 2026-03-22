package com.zte.iptvclient.android.mobile.vod.ui.columnview;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public class MyGridLayoutManager extends GridLayoutManager {
    public MyGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public boolean D() {
        return false;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int b(int i, RecyclerView.u uVar, RecyclerView.y yVar) {
        try {
            return super.b(i, uVar, yVar);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void e(RecyclerView.u uVar, RecyclerView.y yVar) {
        try {
            super.e(uVar, yVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MyGridLayoutManager(Context context, int i) {
        super(context, i);
    }
}
