package net.lucode.hackware.magicindicator.e.c.b;

import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;

/* compiled from: CommonNavigatorAdapter.java */
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private final DataSetObservable f8242a = new DataSetObservable();

    public abstract int a();

    public abstract c a(Context context);

    public abstract d a(Context context, int i);

    public final void a(DataSetObserver dataSetObserver) {
        this.f8242a.registerObserver(dataSetObserver);
    }

    public float b(Context context, int i) {
        return 1.0f;
    }

    public final void b(DataSetObserver dataSetObserver) {
        this.f8242a.unregisterObserver(dataSetObserver);
    }

    public final void b() {
        this.f8242a.notifyChanged();
    }
}
