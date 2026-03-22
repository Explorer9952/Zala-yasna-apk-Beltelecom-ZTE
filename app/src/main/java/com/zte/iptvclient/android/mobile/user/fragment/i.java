package com.zte.iptvclient.android.mobile.user.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zte.iptvclient.android.common.k.u;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.zala.R;

/* compiled from: FeaturePackageFragment.java */
/* loaded from: classes2.dex */
public class i extends com.zte.fragmentlib.b implements View.OnClickListener {
    private String p = "FeaturePackageFragment";
    private Button q;
    private TextView r;
    private RelativeLayout s;
    private RelativeLayout t;
    private RelativeLayout u;
    private RelativeLayout v;

    private void I() {
        this.q.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.t.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.v.setOnClickListener(this);
    }

    private void c(Bundle bundle) {
        Intent intent = new Intent(this.h, (Class<?>) HostActivity.class);
        intent.putExtras(bundle);
        this.h.startActivity(intent);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.r.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.feature_package_title));
        I();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.terminal_btn_back) {
            switch (id) {
                case R.id.rl_feature_cloud_dvr_space_item /* 2131297772 */:
                    u.b(this.h);
                    return;
                case R.id.rl_feature_terminal_binding_item /* 2131297773 */:
                    Bundle bundle = new Bundle();
                    bundle.putInt("type", 3);
                    bundle.putString("fragmenttype", "terminalbindingnew");
                    c(bundle);
                    return;
                case R.id.rl_feature_terminal_online_concurrency_item /* 2131297774 */:
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("type", 2);
                    bundle2.putString("fragmenttype", "terminalconcurrency");
                    c(bundle2);
                    return;
                case R.id.rl_feature_terminal_playback_concurrency_item /* 2131297775 */:
                    Bundle bundle3 = new Bundle();
                    bundle3.putInt("type", 1);
                    bundle3.putString("fragmenttype", "terminalconcurrency");
                    c(bundle3);
                    return;
                default:
                    return;
            }
        }
        if (getActivity() instanceof MainActivity) {
            Log.d(this.p, "back button onclick MainActivity");
            F();
        } else if (getActivity() instanceof HostActivity) {
            Log.d(this.p, "back button onclick HostActivity");
            getActivity().finish();
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.feature_package, (ViewGroup) null);
        this.q = (Button) inflate.findViewById(R.id.terminal_btn_back);
        this.r = (TextView) inflate.findViewById(R.id.terminal_title_txt);
        this.s = (RelativeLayout) inflate.findViewById(R.id.rl_feature_terminal_binding_item);
        this.t = (RelativeLayout) inflate.findViewById(R.id.rl_feature_terminal_playback_concurrency_item);
        this.u = (RelativeLayout) inflate.findViewById(R.id.rl_feature_terminal_online_concurrency_item);
        this.v = (RelativeLayout) inflate.findViewById(R.id.rl_feature_cloud_dvr_space_item);
        TextView textView = (TextView) inflate.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.title_rlayout));
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        com.zte.iptvclient.common.uiframe.f.a(this.u);
        com.zte.iptvclient.common.uiframe.f.a(this.v);
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.terminal_binding_imageview));
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.terminal_online_concurrency_imageview));
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.terminal_playback_concurrency_imageview));
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.feature_cloud_dvr_space_imageview));
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.terminal_binding_textview));
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.terminal_online_concurrency_textview));
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.terminal_playback_concurrency_textview));
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.feature_cloud_dvr_space_textview));
        ((TextView) inflate.findViewById(R.id.terminal_binding_textview)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.terminal_binding));
        ((TextView) inflate.findViewById(R.id.terminal_online_concurrency_textview)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.terminal_online_concurrency));
        ((TextView) inflate.findViewById(R.id.terminal_playback_concurrency_textview)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.terminal_playback_concurrency_title));
        ((TextView) inflate.findViewById(R.id.feature_cloud_dvr_space_textview)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.cloud_dvr_space_title));
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }
}
