package com.scwang.smartrefresh.layout.a;

import android.view.ViewGroup;
import androidx.core.e.m;
import androidx.core.e.q;
import com.scwang.smartrefresh.layout.constant.RefreshState;

/* compiled from: RefreshLayout.java */
/* loaded from: classes.dex */
public interface h extends q, m {
    h a(boolean z);

    boolean a(int i, float f);

    h b(int i);

    h c(int i);

    boolean c();

    boolean d();

    RefreshState getState();

    boolean isLoading();

    h j();

    boolean k();

    boolean l();

    boolean m();

    ViewGroup n();

    boolean o();

    boolean p();
}
