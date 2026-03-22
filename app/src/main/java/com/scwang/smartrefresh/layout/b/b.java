package com.scwang.smartrefresh.layout.b;

import android.view.View;
import android.view.ViewGroup;
import com.scwang.smartrefresh.layout.a.g;
import com.scwang.smartrefresh.layout.a.h;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;

/* compiled from: RefreshFooterWrapper.java */
/* loaded from: classes.dex */
public class b implements com.scwang.smartrefresh.layout.a.d {

    /* renamed from: a, reason: collision with root package name */
    private View f2741a;

    /* renamed from: b, reason: collision with root package name */
    private SpinnerStyle f2742b;

    public b(View view) {
        this.f2741a = view;
        view.setTag(994150968, "TAG_REFRESH_FOOTER_WRAPPER");
    }

    public static boolean a(View view) {
        return "TAG_REFRESH_FOOTER_WRAPPER".equals(view.getTag(994150968));
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public int a(h hVar, boolean z) {
        return 0;
    }

    @Override // com.scwang.smartrefresh.layout.a.d
    public void a(float f, int i, int i2, int i3) {
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

    @Override // com.scwang.smartrefresh.layout.a.d
    public boolean a(boolean z) {
        return false;
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public SpinnerStyle b() {
        SpinnerStyle spinnerStyle = this.f2742b;
        if (spinnerStyle != null) {
            return spinnerStyle;
        }
        ViewGroup.LayoutParams layoutParams = this.f2741a.getLayoutParams();
        if (layoutParams != null && layoutParams.height == 0) {
            SpinnerStyle spinnerStyle2 = SpinnerStyle.Scale;
            this.f2742b = spinnerStyle2;
            return spinnerStyle2;
        }
        SpinnerStyle spinnerStyle3 = SpinnerStyle.Translate;
        this.f2742b = spinnerStyle3;
        return spinnerStyle3;
    }

    @Override // com.scwang.smartrefresh.layout.a.d
    public void b(float f, int i, int i2, int i3) {
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public View a() {
        return this.f2741a;
    }
}
