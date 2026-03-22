package com.zte.iptvclient.android.common.customview.viewgroup.layout.linearlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;

/* loaded from: classes.dex */
public class MultiPlayChannelView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private Context f4407a;

    /* renamed from: b, reason: collision with root package name */
    private LinearLayout f4408b;

    /* renamed from: c, reason: collision with root package name */
    private RelativeLayout f4409c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f4410d;
    private ImageView e;

    public MultiPlayChannelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(Context context) {
        this.f4407a = context;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.view_multi_play_channel, (ViewGroup) null);
        addView(linearLayout);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f4408b = (LinearLayout) linearLayout.findViewById(R.id.llayout_multi_play);
        this.f4409c = (RelativeLayout) linearLayout.findViewById(R.id.rlayout_multi_play_container);
        this.f4410d = (TextView) linearLayout.findViewById(R.id.txtvew_multi_play_channel_name);
        this.e = (ImageView) linearLayout.findViewById(R.id.ivew_multi_play_channel_delete);
        f.a(this.f4408b);
        f.a(this.f4409c);
        f.a(this.f4410d);
        f.a(this.e);
    }
}
