package com.zte.iptvclient.android.mobile.a0.a.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/* compiled from: AdapterTvChannel.java */
/* loaded from: classes2.dex */
public class b extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<Channel> f5331a;

    /* renamed from: b, reason: collision with root package name */
    private LayoutInflater f5332b;

    /* renamed from: d, reason: collision with root package name */
    private Context f5334d;

    /* renamed from: c, reason: collision with root package name */
    private int f5333c = 0;
    private SimpleDateFormat e = new SimpleDateFormat("HH:mm");

    /* compiled from: AdapterTvChannel.java */
    /* loaded from: classes2.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        ImageView f5335a;

        /* renamed from: b, reason: collision with root package name */
        TextView f5336b;

        /* renamed from: c, reason: collision with root package name */
        TextView f5337c;

        /* renamed from: d, reason: collision with root package name */
        TextView f5338d;

        a() {
        }
    }

    public b(Context context, ArrayList<Channel> arrayList) {
        this.f5334d = context;
        this.f5331a = arrayList;
        this.f5332b = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public void a(int i) {
        this.f5333c = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<Channel> arrayList = this.f5331a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList<Channel> arrayList = this.f5331a;
        if (arrayList == null) {
            return null;
        }
        return arrayList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x010c  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View getView(int r7, android.view.View r8, android.view.ViewGroup r9) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.mobile.a0.a.e.b.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public int a() {
        return this.f5333c;
    }
}
