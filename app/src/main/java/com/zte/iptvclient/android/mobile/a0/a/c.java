package com.zte.iptvclient.android.mobile.a0.a;

import android.os.Parcelable;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.zte.iptvclient.android.mobile.a0.b.h;
import java.util.ArrayList;

/* compiled from: AdapterTvScheduleProgramesView.java */
/* loaded from: classes2.dex */
public class c extends androidx.viewpager.widget.a {

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<h> f5318c;

    public c(ArrayList<h> arrayList) {
        this.f5318c = arrayList;
    }

    @Override // androidx.viewpager.widget.a
    public void a(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Override // androidx.viewpager.widget.a
    public void a(View view) {
    }

    public void a(ArrayList<h> arrayList) {
        this.f5318c = arrayList;
        b();
    }

    @Override // androidx.viewpager.widget.a
    public void b(View view) {
    }

    @Override // androidx.viewpager.widget.a
    public Parcelable c() {
        return null;
    }

    @Override // androidx.viewpager.widget.a
    public int a() {
        ArrayList<h> arrayList = this.f5318c;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // androidx.viewpager.widget.a
    public void a(View view, int i, Object obj) {
        if (view instanceof ViewPager) {
            ArrayList<h> arrayList = this.f5318c;
            ((ViewPager) view).removeView(arrayList.get(i % arrayList.size()));
        }
    }

    @Override // androidx.viewpager.widget.a
    public Object a(View view, int i) {
        int size = i % this.f5318c.size();
        if (view instanceof ViewPager) {
            ((ViewPager) view).addView(this.f5318c.get(size), 0);
            return this.f5318c.get(size);
        }
        super.a(view, i);
        throw null;
    }

    @Override // androidx.viewpager.widget.a
    public boolean a(View view, Object obj) {
        return view.equals(obj);
    }
}
