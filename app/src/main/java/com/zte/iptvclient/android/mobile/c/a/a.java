package com.zte.iptvclient.android.mobile.c.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.zte.iptvclient.android.common.reminder.EPGServerTvReminderBean;
import com.zte.iptvclient.android.zala.R;
import java.util.List;

/* compiled from: EPGServerTvReminderAdapter.java */
/* loaded from: classes.dex */
public class a extends RecyclerView.g {

    /* renamed from: c, reason: collision with root package name */
    private LayoutInflater f5591c;

    /* renamed from: d, reason: collision with root package name */
    private List<EPGServerTvReminderBean> f5592d;

    public a(Context context, List<EPGServerTvReminderBean> list) {
        this.f5591c = LayoutInflater.from(context);
        this.f5592d = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int a() {
        List<EPGServerTvReminderBean> list = this.f5592d;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.b0 b(ViewGroup viewGroup, int i) {
        return new com.zte.iptvclient.android.mobile.booking.ui.b.b(this.f5591c.inflate(R.layout.recycleritem_tv_reminder, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void b(RecyclerView.b0 b0Var, int i) {
        com.zte.iptvclient.android.mobile.booking.ui.b.b bVar = (com.zte.iptvclient.android.mobile.booking.ui.b.b) b0Var;
        bVar.t.setText(this.f5592d.get(i).getStart_time());
        bVar.u.setText(this.f5592d.get(i).getPrevuename());
        bVar.v.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.delete));
    }
}
