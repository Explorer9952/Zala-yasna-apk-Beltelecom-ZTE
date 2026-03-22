package net.lucode.hackware.magicindicator;

import androidx.viewpager.widget.ViewPager;

/* compiled from: ViewPagerHelper.java */
/* loaded from: classes2.dex */
public class c {

    /* compiled from: ViewPagerHelper.java */
    /* loaded from: classes2.dex */
    static class a implements ViewPager.i {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MagicIndicator f8236a;

        a(MagicIndicator magicIndicator) {
            this.f8236a = magicIndicator;
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(int i, float f, int i2) {
            this.f8236a.a(i, f, i2);
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void b(int i) {
            this.f8236a.b(i);
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(int i) {
            this.f8236a.a(i);
        }
    }

    public static void a(MagicIndicator magicIndicator, ViewPager viewPager) {
        viewPager.a(new a(magicIndicator));
    }
}
