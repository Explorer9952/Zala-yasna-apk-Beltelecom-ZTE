package com.zte.iptvclient.android.mobile.npvr.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class CustomCatchExceptionLayoutManager extends LinearLayoutManager {
    public CustomCatchExceptionLayoutManager(Context context, int i, boolean z) {
        super(context, i, z);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void e(RecyclerView.u uVar, RecyclerView.y yVar) {
        try {
            super.e(uVar, yVar);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public CustomCatchExceptionLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
