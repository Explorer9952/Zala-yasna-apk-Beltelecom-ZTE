package com.zte.iptvclient.android.mobile.npvr.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import com.zte.iptvclient.android.zala.R;
import java.util.List;

/* compiled from: RecordingSpinnerAdapter.java */
/* loaded from: classes.dex */
public class c extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private List<String> f6917a;

    /* renamed from: b, reason: collision with root package name */
    private Context f6918b;

    /* renamed from: c, reason: collision with root package name */
    private Spinner f6919c;

    /* renamed from: d, reason: collision with root package name */
    private int f6920d;
    private int e;

    public c(Context context, Spinner spinner, List<String> list, int i, int i2) {
        this.f6918b = context;
        this.f6917a = list;
        this.f6919c = spinner;
        this.f6920d = i;
        this.e = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f6917a.size();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        View inflate = View.inflate(this.f6918b, R.layout.recording_sort_spinner_item_layout, null);
        TextView textView = (TextView) inflate.findViewById(R.id.recording_sort_spinner_item_title_txt);
        textView.setText(this.f6917a.get(i));
        Spinner spinner = this.f6919c;
        if (spinner != null && spinner.getSelectedItemPosition() == i) {
            int color = this.f6918b.getResources().getColor(R.color.recording_sort_text_select);
            this.f6920d = color;
            textView.setTextColor(color);
        } else {
            int color2 = this.f6918b.getResources().getColor(R.color.recording_sort_text_unselect);
            this.e = color2;
            textView.setTextColor(color2);
        }
        return inflate;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f6917a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = View.inflate(this.f6918b, R.layout.recording_sort_spinner_checked_text, null);
        ((TextView) inflate.findViewById(R.id.spinner_title_txt)).setText(this.f6917a.get(i));
        return inflate;
    }
}
