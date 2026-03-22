package com.zte.iptvclient.common.uiframe;

import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.widget.ListAdapter;
import java.util.List;

/* compiled from: CommonListAdapter.java */
/* loaded from: classes2.dex */
public abstract class c implements ListAdapter {

    /* renamed from: a, reason: collision with root package name */
    private final DataSetObservable f7899a = new DataSetObservable();

    /* renamed from: b, reason: collision with root package name */
    protected List<?> f7900b;

    /* renamed from: c, reason: collision with root package name */
    protected LayoutInflater f7901c;

    public c(Context context) {
        this.f7901c = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public void a() {
        this.f7899a.notifyChanged();
    }

    @Override // android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<?> list = this.f7900b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f7900b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public int getItemViewType(int i) {
        return 0;
    }

    @Override // android.widget.Adapter
    public int getViewTypeCount() {
        return 1;
    }

    @Override // android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.Adapter
    public boolean isEmpty() {
        return getCount() == 0;
    }

    @Override // android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return true;
    }

    @Override // android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.f7899a.registerObserver(dataSetObserver);
    }

    @Override // android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.f7899a.unregisterObserver(dataSetObserver);
    }

    public c(Context context, List<?> list) {
        this.f7900b = list;
        this.f7901c = (LayoutInflater) context.getSystemService("layout_inflater");
    }
}
