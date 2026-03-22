package com.zte.iptvclient.android.mobile.k.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.d;
import com.bumptech.glide.i;
import com.zte.iptvclient.android.mobile.history.entity.WatchHistoryEntity;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/* compiled from: AdapterChildWatchHistory.java */
/* loaded from: classes.dex */
public class a extends RecyclerView.g {

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<WatchHistoryEntity> f6666c;

    /* compiled from: AdapterChildWatchHistory.java */
    /* renamed from: com.zte.iptvclient.android.mobile.k.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0289a extends RecyclerView.b0 {
        public C0289a(View view) {
            super(view);
        }
    }

    /* compiled from: AdapterChildWatchHistory.java */
    /* loaded from: classes.dex */
    static class b extends RecyclerView.b0 {
        TextView A;
        LinearLayout t;
        ImageView u;
        ImageView v;
        RelativeLayout w;
        ImageView x;
        TextView y;
        TextView z;

        public b(View view) {
            super(view);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.item_layout);
            this.t = linearLayout;
            this.u = (ImageView) linearLayout.findViewById(R.id.img_poster);
            this.v = (ImageView) this.t.findViewById(R.id.ivi_logo_top);
            this.w = (RelativeLayout) view.findViewById(R.id.rl_channel_icon);
            this.x = (ImageView) view.findViewById(R.id.iv_channel_icon);
            LinearLayout linearLayout2 = (LinearLayout) this.t.findViewById(R.id.ll_content_container);
            this.y = (TextView) linearLayout2.findViewById(R.id.tv_content_name);
            this.z = (TextView) linearLayout2.findViewById(R.id.tv_play_time);
            this.A = (TextView) linearLayout2.findViewById(R.id.tv_duration);
            f.a(this.t);
            f.a(this.u);
            f.a(this.v);
            f.a(this.w);
            f.a(this.x);
            f.a(linearLayout2);
            f.a(this.y);
            f.a(this.z);
            f.a(this.A);
        }
    }

    public a(ArrayList<WatchHistoryEntity> arrayList) {
        this.f6666c = arrayList;
    }

    private String a(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        try {
            return new SimpleDateFormat("dd.MM.yyyy HH:mm").format(simpleDateFormat.parse(str));
        } catch (ParseException e) {
            e.printStackTrace();
            return str;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.b0 b(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_child_watch_history, viewGroup, false));
        }
        TextView textView = new TextView(viewGroup.getContext());
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, 300));
        return new C0289a(textView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int a() {
        ArrayList<WatchHistoryEntity> arrayList = this.f6666c;
        return (arrayList != null ? arrayList.size() : 0) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void b(RecyclerView.b0 b0Var, int i) {
        if (b(i) == 1) {
            b bVar = (b) b0Var;
            WatchHistoryEntity watchHistoryEntity = this.f6666c.get(i);
            bVar.y.setText(watchHistoryEntity.b());
            StringBuilder sb = new StringBuilder();
            sb.append(com.zte.iptvclient.android.common.i.a.a.a(R.string.child_watch_history_begin_time));
            sb.append(": ");
            sb.append(a(watchHistoryEntity.f()));
            bVar.z.setText(sb);
            sb.delete(0, sb.length());
            sb.append(com.zte.iptvclient.android.common.i.a.a.a(R.string.child_watch_history_duration));
            sb.append(": ");
            sb.append(b(watchHistoryEntity.e()));
            sb.append(" ");
            sb.append(com.zte.iptvclient.android.common.i.a.a.a(R.string.vod_detail_duration_unit_min));
            bVar.A.setText(sb);
            boolean equals = TextUtils.equals("1", watchHistoryEntity.c());
            int i2 = equals ? R.drawable.default_poster_thumb : R.drawable.default_video_thumb;
            ImageView imageView = equals ? bVar.u : bVar.x;
            d<String> a2 = i.b(b0Var.f1492a.getContext()).a(watchHistoryEntity.g());
            a2.b(i2);
            a2.a(i2);
            a2.a(imageView);
            bVar.w.setVisibility(equals ? 8 : 0);
            bVar.u.setVisibility(equals ? 0 : 8);
            if (watchHistoryEntity.d() == null) {
                bVar.v.setVisibility(8);
                return;
            }
            if (watchHistoryEntity.d().equals("ivi")) {
                bVar.v.setVisibility(0);
                bVar.v.setImageDrawable(b0Var.f1492a.getContext().getResources().getDrawable(R.drawable.ivi_logo));
            } else if (watchHistoryEntity.d().equals("Megogo")) {
                bVar.v.setVisibility(0);
                bVar.v.setImageDrawable(b0Var.f1492a.getContext().getResources().getDrawable(R.drawable.megogo_logo));
            } else {
                bVar.v.setVisibility(8);
            }
        }
    }

    private String b(String str) {
        long longValue = Long.valueOf(str).longValue() / 60;
        if (longValue < 1) {
            longValue = 1;
        }
        return String.valueOf(longValue);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int b(int i) {
        return i == a() - 1 ? 2 : 1;
    }
}
