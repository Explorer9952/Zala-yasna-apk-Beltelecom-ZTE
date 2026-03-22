package com.zte.iptvclient.android.mobile.c.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.zte.iptvclient.android.zala.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/* compiled from: EPGVodReminderAdapter.java */
/* loaded from: classes.dex */
public class b extends RecyclerView.g {

    /* renamed from: c, reason: collision with root package name */
    private LayoutInflater f5593c;

    /* renamed from: d, reason: collision with root package name */
    private List<com.zte.iptvclient.android.common.reminder.a> f5594d;

    public b(Context context, List<com.zte.iptvclient.android.common.reminder.a> list) {
        this.f5593c = LayoutInflater.from(context);
        this.f5594d = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int a() {
        List<com.zte.iptvclient.android.common.reminder.a> list = this.f5594d;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.b0 b(ViewGroup viewGroup, int i) {
        return new com.zte.iptvclient.android.mobile.booking.ui.b.a(this.f5593c.inflate(R.layout.recycleritem_epg_vod_item, viewGroup, false));
    }

    private String a(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        try {
            return new SimpleDateFormat("MM/dd").format(simpleDateFormat.parse(str));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void b(RecyclerView.b0 b0Var, int i) {
        String a2;
        com.zte.iptvclient.android.mobile.booking.ui.b.a aVar = (com.zte.iptvclient.android.mobile.booking.ui.b.a) b0Var;
        TextView textView = aVar.t;
        if ("14".equals(this.f5594d.get(i).f())) {
            a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.reminder_type_series);
        } else {
            a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.reminder_type_special_column);
        }
        textView.setText(a2);
        aVar.u.setText(this.f5594d.get(i).e());
        aVar.v.setText(a(this.f5594d.get(i).g()) + " " + com.zte.iptvclient.android.common.i.a.a.a(R.string.lastest_update));
        aVar.w.setText(this.f5594d.get(i).d());
        aVar.x.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.delete));
    }
}
