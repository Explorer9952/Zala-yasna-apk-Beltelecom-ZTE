package com.zte.iptvclient.android.mobile.ppv.fragment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;

/* loaded from: classes.dex */
public class DataEmptyView extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private RelativeLayout f7018a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f7019b;

    public DataEmptyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(Context context) {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.empty_pull_refresh_view, this).findViewById(R.id.rl_empty);
        this.f7018a = relativeLayout;
        this.f7019b = (TextView) relativeLayout.findViewById(R.id.txt_pullrefresh);
        f.a(this.f7018a.findViewById(R.id.ll_pullrefresh));
        f.a(this.f7018a.findViewById(R.id.img_pullrefresh_icon));
        f.a(this.f7019b);
        f.a(this.f7018a.findViewById(R.id.refresh_image));
    }

    public DataEmptyView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet);
    }
}
