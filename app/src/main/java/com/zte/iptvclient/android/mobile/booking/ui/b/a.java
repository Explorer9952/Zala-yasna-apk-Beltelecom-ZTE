package com.zte.iptvclient.android.mobile.booking.ui.b;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;

/* compiled from: EPGVodReminderViewHolder.java */
/* loaded from: classes.dex */
public class a extends RecyclerView.b0 {
    public TextView t;
    public TextView u;
    public TextView v;
    public TextView w;
    public TextView x;
    public LinearLayout y;

    public a(View view) {
        super(view);
        this.t = (TextView) view.findViewById(R.id.txt_vod_type);
        this.u = (TextView) view.findViewById(R.id.txt_programname);
        this.v = (TextView) view.findViewById(R.id.txt_update);
        this.w = (TextView) view.findViewById(R.id.txt_description);
        this.x = (TextView) view.findViewById(R.id.item_delete);
        this.y = (LinearLayout) view.findViewById(R.id.item_layout);
        f.a(this.t);
        f.a(this.u);
        f.a(this.v);
        f.a(this.w);
    }
}
