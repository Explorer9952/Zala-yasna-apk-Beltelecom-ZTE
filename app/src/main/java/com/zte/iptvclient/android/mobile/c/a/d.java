package com.zte.iptvclient.android.mobile.c.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.zte.iptvclient.android.common.reminder.AlarmVideoBean;
import com.zte.iptvclient.android.common.reminder.VodReminderManager;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.List;

/* compiled from: VodReminderAdapter.java */
/* loaded from: classes.dex */
public class d extends RecyclerView.g {

    /* renamed from: c, reason: collision with root package name */
    private Context f5597c;

    /* renamed from: d, reason: collision with root package name */
    private LayoutInflater f5598d;
    private List<AlarmVideoBean> e;

    public d(Context context, List<AlarmVideoBean> list) {
        this.f5597c = context;
        this.f5598d = LayoutInflater.from(context);
        this.e = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int a() {
        List<AlarmVideoBean> list = this.e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.b0 b(ViewGroup viewGroup, int i) {
        View inflate = this.f5598d.inflate(R.layout.recycleritem_vod_reminder, viewGroup, false);
        f.a(inflate.findViewById(R.id.list_item_vod_programname));
        return new com.zte.iptvclient.android.mobile.booking.ui.b.c(inflate);
    }

    public void e(int i) {
        a(this.e.remove(i));
        d();
    }

    private void a(AlarmVideoBean alarmVideoBean) {
        if (alarmVideoBean == null) {
            return;
        }
        Intent intent = new Intent("com.vod.remindReceive");
        intent.putExtra(VodReminderManager.g, VodReminderManager.h);
        Bundle bundle = new Bundle();
        bundle.putSerializable("vod_reminder", alarmVideoBean);
        intent.putExtras(bundle);
        this.f5597c.sendBroadcast(intent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void b(RecyclerView.b0 b0Var, int i) {
        com.zte.iptvclient.android.mobile.booking.ui.b.c cVar = (com.zte.iptvclient.android.mobile.booking.ui.b.c) b0Var;
        cVar.t.setText(this.e.get(i).getProgramName());
        cVar.u.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.delete));
    }
}
