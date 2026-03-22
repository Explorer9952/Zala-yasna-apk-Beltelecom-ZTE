package com.scwang.smartrefresh.layout.b;

import android.view.View;
import android.view.ViewGroup;
import com.scwang.smartrefresh.layout.a.e;
import com.scwang.smartrefresh.layout.a.g;
import com.scwang.smartrefresh.layout.a.h;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;

/* compiled from: RefreshHeaderWrapper.java */
/* loaded from: classes.dex */
public class c implements e {

    /* renamed from: a, reason: collision with root package name */
    private View f2743a;

    /* renamed from: b, reason: collision with root package name */
    private SpinnerStyle f2744b;

    public c(View view) {
        this.f2743a = view;
        view.setTag(-203643606, "TAG_REFRESH_HEADER_WRAPPER");
    }

    public static boolean a(View view) {
        return "TAG_REFRESH_HEADER_WRAPPER".equals(view.getTag(-203643606));
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public int a(h hVar, boolean z) {
        return 0;
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public void a(g gVar, int i, int i2) {
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public void a(h hVar, int i, int i2) {
    }

    @Override // com.scwang.smartrefresh.layout.d.e
    public void a(h hVar, RefreshState refreshState, RefreshState refreshState2) {
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public void a(int... iArr) {
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public SpinnerStyle b() {
        SpinnerStyle spinnerStyle = this.f2744b;
        if (spinnerStyle != null) {
            return spinnerStyle;
        }
        ViewGroup.LayoutParams layoutParams = this.f2743a.getLayoutParams();
        if (layoutParams != null && layoutParams.height == -1) {
            SpinnerStyle spinnerStyle2 = SpinnerStyle.Scale;
            this.f2744b = spinnerStyle2;
            return spinnerStyle2;
        }
        SpinnerStyle spinnerStyle3 = SpinnerStyle.Translate;
        this.f2744b = spinnerStyle3;
        return spinnerStyle3;
    }

    @Override // com.scwang.smartrefresh.layout.a.e
    public void c(float f, int i, int i2, int i3) {
    }

    @Override // com.scwang.smartrefresh.layout.a.e
    public void d(float f, int i, int i2, int i3) {
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public View a() {
        return this.f2743a;
    }
}
