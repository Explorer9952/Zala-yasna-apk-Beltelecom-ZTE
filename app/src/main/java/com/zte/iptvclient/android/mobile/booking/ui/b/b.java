package com.zte.iptvclient.android.mobile.booking.ui.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;

/* compiled from: TvReminderViewHolder.java */
/* loaded from: classes.dex */
public class b extends RecyclerView.b0 {
    public TextView t;
    public TextView u;
    public TextView v;
    public LinearLayout w;
    public ImageView x;

    public b(View view) {
        super(view);
        this.t = (TextView) view.findViewById(R.id.list_item_tv_playtime);
        this.u = (TextView) view.findViewById(R.id.list_item_tv_programname);
        this.v = (TextView) view.findViewById(R.id.item_delete);
        this.w = (LinearLayout) view.findViewById(R.id.item_layout);
        ImageView imageView = (ImageView) view.findViewById(R.id.img_poster);
        this.x = imageView;
        f.a(imageView);
        f.a(this.t);
        f.a(this.u);
        f.a(this.v);
        f.a(this.w);
    }
}
