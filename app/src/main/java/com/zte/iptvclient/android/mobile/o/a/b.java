package com.zte.iptvclient.android.mobile.o.a;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.video.androidsdk.common.util.TimeUtil;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.common.k.x;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.text.ParseException;

/* compiled from: MessageDetailInfoFragment.java */
/* loaded from: classes.dex */
public class b extends com.zte.fragmentlib.b {
    private Button p;
    private RelativeLayout q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private String w;
    private String x;
    private String y;
    private String z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MessageDetailInfoFragment.java */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.getActivity() instanceof MainActivity) {
                b.this.F();
            } else if (b.this.getActivity() instanceof HostActivity) {
                b.this.getActivity().finish();
            }
        }
    }

    private void I() {
        this.r.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.mes_msg_notice));
        if (!TextUtils.isEmpty(this.w)) {
            this.s.setText(this.w);
        }
        if (!TextUtils.isEmpty(this.x)) {
            this.t.setText(this.x);
        }
        if (!TextUtils.isEmpty(this.y)) {
            try {
                this.u.setText(TimeUtil.format(x.a(x.b(this.y, "yyyyMMddHHmmss", "yyyyMMddHHmmss"), "yyyyMMddHHmmss"), "yyyy/MM/dd"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(this.z)) {
            return;
        }
        this.v.setText(this.z);
    }

    private void d(View view) {
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        this.p = (Button) view.findViewById(R.id.btn_back);
        this.r = (TextView) view.findViewById(R.id.title_txt);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.title_rlayout);
        this.q = relativeLayout;
        f.a(relativeLayout);
        f.a(this.p);
        f.a(this.r);
        this.s = (TextView) view.findViewById(R.id.main_title);
        this.t = (TextView) view.findViewById(R.id.msg_type);
        this.u = (TextView) view.findViewById(R.id.msg_time);
        this.v = (TextView) view.findViewById(R.id.msg_desc);
        f.a(this.s);
        f.a(this.t);
        f.a(this.u);
        f.a(this.v);
        this.r.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.title));
        this.p.setOnClickListener(new a());
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.w = arguments.getString("MainTitle");
            this.x = arguments.getString("MsgType");
            this.y = arguments.getString("MsgTime");
            this.z = arguments.getString("MsgDesc");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.message_detail_info_layout, (ViewGroup) null);
        d(inflate);
        I();
        return inflate;
    }
}
