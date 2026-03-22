package com.zte.iptvclient.android.mobile.ppv.recycle;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: PagerAdapterWrapper.java */
/* loaded from: classes.dex */
class a extends androidx.viewpager.widget.a {

    /* renamed from: c, reason: collision with root package name */
    private final androidx.viewpager.widget.a f7036c;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(androidx.viewpager.widget.a aVar) {
        this.f7036c = aVar;
    }

    @Override // androidx.viewpager.widget.a
    public int a() {
        return this.f7036c.a();
    }

    @Override // androidx.viewpager.widget.a
    public float b(int i) {
        return this.f7036c.b(i);
    }

    @Override // androidx.viewpager.widget.a
    public void c(DataSetObserver dataSetObserver) {
        this.f7036c.c(dataSetObserver);
    }

    public androidx.viewpager.widget.a d() {
        return this.f7036c;
    }

    @Override // androidx.viewpager.widget.a
    public boolean a(View view, Object obj) {
        return this.f7036c.a(view, obj);
    }

    @Override // androidx.viewpager.widget.a
    public void b(ViewGroup viewGroup, int i, Object obj) {
        this.f7036c.b(viewGroup, i, obj);
    }

    @Override // androidx.viewpager.widget.a
    public Parcelable c() {
        return this.f7036c.c();
    }

    @Override // androidx.viewpager.widget.a
    public CharSequence a(int i) {
        return this.f7036c.a(i);
    }

    @Override // androidx.viewpager.widget.a
    public void b() {
        this.f7036c.b();
    }

    @Override // androidx.viewpager.widget.a
    public int a(Object obj) {
        return this.f7036c.a(obj);
    }

    @Override // androidx.viewpager.widget.a
    public void b(ViewGroup viewGroup) {
        this.f7036c.b(viewGroup);
    }

    @Override // androidx.viewpager.widget.a
    public Object a(ViewGroup viewGroup, int i) {
        return this.f7036c.a(viewGroup, i);
    }

    @Override // androidx.viewpager.widget.a
    public void a(ViewGroup viewGroup, int i, Object obj) {
        this.f7036c.a(viewGroup, i, obj);
    }

    @Override // androidx.viewpager.widget.a
    public void a(DataSetObserver dataSetObserver) {
        this.f7036c.a(dataSetObserver);
    }

    @Override // androidx.viewpager.widget.a
    public void a(Parcelable parcelable, ClassLoader classLoader) {
        this.f7036c.a(parcelable, classLoader);
    }

    @Override // androidx.viewpager.widget.a
    public void a(ViewGroup viewGroup) {
        this.f7036c.a(viewGroup);
    }
}
