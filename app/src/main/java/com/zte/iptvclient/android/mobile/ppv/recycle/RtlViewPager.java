package com.zte.iptvclient.android.mobile.ppv.recycle;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import java.util.Map;

/* loaded from: classes.dex */
public class RtlViewPager extends ViewPager {
    private final Map<ViewPager.i, d> l0;
    private DataSetObserver m0;
    private boolean n0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends DataSetObserver {

        /* renamed from: a, reason: collision with root package name */
        private final c f7031a;

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            this.f7031a.e();
        }

        private b(c cVar) {
            this.f7031a = cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends com.zte.iptvclient.android.mobile.ppv.recycle.a {

        /* renamed from: d, reason: collision with root package name */
        private int f7032d;

        public c(androidx.viewpager.widget.a aVar) {
            super(aVar);
            this.f7032d = aVar.a();
        }

        private int c(int i) {
            return (a() - i) - 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e() {
            int a2 = a();
            int i = this.f7032d;
            if (a2 != i) {
                RtlViewPager.this.h(Math.max(0, i - 1));
                this.f7032d = a2;
            }
        }

        @Override // com.zte.iptvclient.android.mobile.ppv.recycle.a, androidx.viewpager.widget.a
        public float b(int i) {
            return super.b(c(i));
        }

        @Override // com.zte.iptvclient.android.mobile.ppv.recycle.a, androidx.viewpager.widget.a
        public CharSequence a(int i) {
            return super.a(c(i));
        }

        @Override // com.zte.iptvclient.android.mobile.ppv.recycle.a, androidx.viewpager.widget.a
        public void b(ViewGroup viewGroup, int i, Object obj) {
            super.b(viewGroup, (this.f7032d - i) - 1, obj);
        }

        @Override // com.zte.iptvclient.android.mobile.ppv.recycle.a, androidx.viewpager.widget.a
        public int a(Object obj) {
            int a2 = super.a(obj);
            return a2 < 0 ? a2 : c(a2);
        }

        @Override // com.zte.iptvclient.android.mobile.ppv.recycle.a, androidx.viewpager.widget.a
        public Object a(ViewGroup viewGroup, int i) {
            return super.a(viewGroup, c(i));
        }

        @Override // com.zte.iptvclient.android.mobile.ppv.recycle.a, androidx.viewpager.widget.a
        public void a(ViewGroup viewGroup, int i, Object obj) {
            super.a(viewGroup, c(i), obj);
        }
    }

    /* loaded from: classes.dex */
    private class d implements ViewPager.i {

        /* renamed from: a, reason: collision with root package name */
        private final ViewPager.i f7033a;

        /* renamed from: b, reason: collision with root package name */
        private int f7034b;

        private int c(int i) {
            return RtlViewPager.this.b() == null ? i : (r0.a() - i) - 1;
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(int i, float f, int i2) {
            if (RtlViewPager.this.n0) {
                return;
            }
            if (Double.doubleToLongBits(f) == Double.doubleToLongBits(0.0d) && i2 == 0) {
                this.f7034b = c(i);
            } else {
                this.f7034b = c(i + 1);
            }
            ViewPager.i iVar = this.f7033a;
            int i3 = this.f7034b;
            if (f > 0.0f) {
                f = 1.0f - f;
            }
            iVar.a(i3, f, i2);
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void b(int i) {
            if (RtlViewPager.this.n0) {
                return;
            }
            this.f7033a.b(c(i));
        }

        private d(ViewPager.i iVar) {
            this.f7033a = iVar;
            this.f7034b = -1;
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(int i) {
            if (RtlViewPager.this.n0) {
                return;
            }
            this.f7033a.a(i);
        }
    }

    public RtlViewPager(Context context) {
        super(context);
        this.l0 = new ArrayMap(1);
    }

    private void b(androidx.viewpager.widget.a aVar) {
        if ((aVar instanceof c) && this.m0 == null) {
            c cVar = (c) aVar;
            b bVar = new b(cVar);
            this.m0 = bVar;
            aVar.a((DataSetObserver) bVar);
            cVar.e();
        }
    }

    private int g(int i) {
        if (i < 0 || !h()) {
            return i;
        }
        if (b() == null) {
            return 0;
        }
        return (b().a() - i) - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i) {
        this.n0 = true;
        a(i, false);
        this.n0 = false;
    }

    private void i() {
        DataSetObserver dataSetObserver;
        androidx.viewpager.widget.a b2 = super.b();
        if (!(b2 instanceof c) || (dataSetObserver = this.m0) == null) {
            return;
        }
        b2.c(dataSetObserver);
        this.m0 = null;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public int c() {
        return g(super.c());
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void d(int i) {
        super.d(g(i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b(super.b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        i();
        super.onDetachedFromWindow();
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f7028a);
        if (savedState.f7030c != h()) {
            a(savedState.f7029b, false);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), c(), h());
    }

    public RtlViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l0 = new ArrayMap(1);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void a(int i, boolean z) {
        super.a(g(i), z);
    }

    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {

        /* renamed from: a, reason: collision with root package name */
        Parcelable f7028a;

        /* renamed from: b, reason: collision with root package name */
        int f7029b;

        /* renamed from: c, reason: collision with root package name */
        boolean f7030c;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        static {
            new a();
        }

        public SavedState(Parcelable parcelable, int i, boolean z) {
            this.f7028a = parcelable;
            this.f7029b = i;
            this.f7030c = z;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f7028a, i);
            parcel.writeInt(this.f7029b);
            parcel.writeByte(this.f7030c ? (byte) 1 : (byte) 0);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            this.f7028a = parcel.readParcelable(classLoader == null ? SavedState.class.getClassLoader() : classLoader);
            this.f7029b = parcel.readInt();
            this.f7030c = parcel.readByte() != 0;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void a(androidx.viewpager.widget.a aVar) {
        i();
        boolean z = aVar != null && h();
        if (z) {
            c cVar = new c(aVar);
            b(cVar);
            aVar = cVar;
        }
        super.a(aVar);
        if (z) {
            h(0);
        }
    }

    protected boolean h() {
        return androidx.core.c.c.b(getContext().getResources().getConfiguration().locale) == 1;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public androidx.viewpager.widget.a b() {
        androidx.viewpager.widget.a b2 = super.b();
        return b2 instanceof c ? ((c) b2).d() : b2;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void b(ViewPager.i iVar) {
        if (h()) {
            iVar = this.l0.remove(iVar);
        }
        super.b(iVar);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void a(ViewPager.i iVar) {
        if (h()) {
            d dVar = new d(iVar);
            this.l0.put(iVar, dVar);
            iVar = dVar;
        }
        super.a(iVar);
    }
}
