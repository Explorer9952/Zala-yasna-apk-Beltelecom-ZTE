package com.zte.iptvclient.android.mobile.c.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zte.iptvclient.android.common.j.h;
import com.zte.iptvclient.android.common.j.i;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.common.javabean.models.PrevueBean;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: TvReminderAdapter.java */
/* loaded from: classes.dex */
public class c extends RecyclerView.g {

    /* renamed from: c, reason: collision with root package name */
    private Context f5595c;

    /* renamed from: d, reason: collision with root package name */
    private LayoutInflater f5596d;
    private List<PrevueBean> e;
    private h f;
    private ArrayList<Channel> g = i.d().b();

    public c(Context context, List<PrevueBean> list) {
        this.f5595c = context;
        this.f5596d = LayoutInflater.from(context);
        this.e = list;
        this.f = new h(this.f5595c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int a() {
        List<PrevueBean> list = this.e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.b0 b(ViewGroup viewGroup, int i) {
        return new com.zte.iptvclient.android.mobile.booking.ui.b.b(this.f5596d.inflate(R.layout.recycleritem_tv_reminder, viewGroup, false));
    }

    public void e(int i) {
        a(this.e.remove(i));
        d();
    }

    private void a(PrevueBean prevueBean) {
        if (prevueBean == null) {
            return;
        }
        Intent intent = new Intent("com.tv.remindReceive");
        intent.putExtra("reminder_operation_type", -1);
        Bundle bundle = new Bundle();
        bundle.putSerializable("tv_reminder", prevueBean);
        intent.putExtras(bundle);
        this.f5595c.sendBroadcast(intent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void b(RecyclerView.b0 b0Var, int i) {
        com.zte.iptvclient.android.mobile.booking.ui.b.b bVar = (com.zte.iptvclient.android.mobile.booking.ui.b.b) b0Var;
        bVar.v.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.delete));
        bVar.t.setText(this.e.get(i).getDuration() + "  " + this.e.get(i).getChannelname());
        bVar.u.setText(com.zte.iptvclient.android.mobile.f.b.a.a(this.e.get(i).getRatingid(), this.e.get(i).getPrevuename(), this.f5595c.getResources().getString(R.string.common_blocktitle), this.f, this.f5595c));
        String channelcode = this.e.get(i).getChannelcode();
        Iterator<Channel> it2 = this.g.iterator();
        while (it2.hasNext()) {
            Channel next = it2.next();
            if (!TextUtils.isEmpty(next.getChannelcode()) && next.getChannelcode().equals(channelcode)) {
                String posterimage = next.getPosterimage();
                if (!TextUtils.isEmpty(posterimage)) {
                    int indexOf = posterimage.indexOf("/image", 1);
                    posterimage = com.zte.iptvclient.android.common.f.b.i.g() + posterimage.substring(indexOf);
                }
                if (((Activity) this.f5595c).isFinishing()) {
                    com.bumptech.glide.d<String> a2 = com.bumptech.glide.i.b(this.f5595c).a(posterimage);
                    a2.b(R.drawable.default_video_thumb);
                    a2.a(R.drawable.default_video_thumb);
                    a2.a(DiskCacheStrategy.NONE);
                    a2.c(300);
                    a2.a(bVar.x);
                    return;
                }
                return;
            }
        }
    }
}
