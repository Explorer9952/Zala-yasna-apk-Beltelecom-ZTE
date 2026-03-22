package com.zte.iptvclient.android.mobile.booking.ui.b;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;

/* compiled from: VodReminderViewHolder.java */
/* loaded from: classes.dex */
public class c extends RecyclerView.b0 {
    public TextView t;
    public TextView u;
    public LinearLayout v;

    public c(View view) {
        super(view);
        this.t = (TextView) view.findViewById(R.id.list_item_vod_programname);
        this.u = (TextView) view.findViewById(R.id.item_delete);
        this.v = (LinearLayout) view.findViewById(R.id.item_layout);
        f.a(this.t);
    }
}
