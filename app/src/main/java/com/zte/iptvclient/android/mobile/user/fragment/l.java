package com.zte.iptvclient.android.mobile.user.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.SDKUserMgr;
import com.video.androidsdk.service.comm.ParamConst;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.zala.R;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ModifyPersonalInfoFragment.java */
/* loaded from: classes.dex */
public class l extends com.zte.fragmentlib.b implements View.OnClickListener {
    private static final String F = l.class.getName();
    private TextView A;
    private ImageView B;
    private TextView C;
    private TextView D;
    private JSONObject E;
    private TextView p;
    private Button q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private TextView w;
    private ImageView x;
    private TextView y;
    private TextView z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ModifyPersonalInfoFragment.java */
    /* loaded from: classes2.dex */
    public class a implements SDKUserMgr.OnUserDetailCommonReturnListener {
        a() {
        }

        @Override // com.video.androidsdk.service.SDKUserMgr.OnUserDetailCommonReturnListener
        public void onUserDetailCommonReturn(String str, String str2, String str3) {
            if (TextUtils.equals(str, "0")) {
                try {
                    l.this.E = new JSONObject(str3);
                    l.this.v.setText(l.this.E.getString(ParamConst.GET_REGISTER_REQ_MOBILENO));
                    l.this.z.setText(l.this.E.getString("email"));
                    l.this.t.setText(com.zte.iptvclient.common.uiframe.a.d("UserID"));
                    return;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(str2);
        }
    }

    private void I() {
        new SDKUserMgr().getUserDetailCommon(new a());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        switch (view.getId()) {
            case R.id.btn_back /* 2131296427 */:
                if (BaseApp.a(this.h)) {
                    F();
                    return;
                } else {
                    if (getActivity() instanceof HostActivity) {
                        getActivity().finish();
                        return;
                    }
                    return;
                }
            case R.id.my_acount_change /* 2131297489 */:
            case R.id.my_acount_email_change /* 2131297492 */:
                if (view.getId() == R.id.my_acount_email_change) {
                    bundle.putString("changeType", "email");
                }
                if (view.getId() == R.id.my_acount_change) {
                    bundle.putString("changeType", "phone");
                }
                try {
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (this.E == null) {
                    return;
                }
                bundle.putString("email", this.E.getString("email"));
                bundle.putString(ParamConst.GET_REGISTER_REQ_MOBILENO, this.E.getString(ParamConst.GET_REGISTER_REQ_MOBILENO));
                if (BaseApp.a(this.h)) {
                    g gVar = new g();
                    gVar.setArguments(bundle);
                    a(gVar);
                    return;
                }
                a("fragment_change_contact", bundle);
                return;
            case R.id.my_acount_rechage /* 2131297500 */:
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("isSideMenu", false);
                if (BaseApp.a(this.h)) {
                    c cVar = new c();
                    cVar.setArguments(bundle2);
                    a(cVar);
                    return;
                }
                a("at_recharge", bundle2);
                return;
            default:
                return;
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LogEx.d(F, "ModifyPersonalInfoFragment onCreate");
        EventBus.getDefault().register(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LogEx.d(F, "ModifyPersonalInfoFragment onCreateView");
        View inflate = layoutInflater.inflate(R.layout.account_modify_personal_info, (ViewGroup) null);
        d(inflate);
        I();
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(f fVar) {
        I();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    private void d(View view) {
        this.p = (TextView) view.findViewById(R.id.my_acount_top);
        this.q = (Button) view.findViewById(R.id.btn_back);
        this.r = (TextView) view.findViewById(R.id.title_txt);
        this.s = (TextView) view.findViewById(R.id.my_acount_misindn);
        this.t = (TextView) view.findViewById(R.id.my_acount_misindn_value);
        this.u = (TextView) view.findViewById(R.id.my_acount_phone);
        this.v = (TextView) view.findViewById(R.id.my_acount_phone_value);
        this.w = (TextView) view.findViewById(R.id.my_acount_change);
        this.x = (ImageView) view.findViewById(R.id.my_acount_change_img);
        this.y = (TextView) view.findViewById(R.id.my_acount_email);
        this.z = (TextView) view.findViewById(R.id.my_acount_email_value);
        this.A = (TextView) view.findViewById(R.id.my_acount_email_change);
        this.B = (ImageView) view.findViewById(R.id.my_acount_email_change_img);
        this.C = (TextView) view.findViewById(R.id.my_acount_goto);
        this.D = (TextView) view.findViewById(R.id.my_acount_rechage);
        this.s.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.myaccountmisindn));
        this.u.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.myaccount_moblie_phone));
        this.w.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.myaccount_change));
        this.y.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.myaccount_email));
        this.A.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.myaccount_change));
        this.C.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.myaccount_go_to));
        this.D.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.myaccount_rechage));
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(this.p);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.s);
        com.zte.iptvclient.common.uiframe.f.a(this.t);
        com.zte.iptvclient.common.uiframe.f.a(this.u);
        com.zte.iptvclient.common.uiframe.f.a(this.v);
        com.zte.iptvclient.common.uiframe.f.a(this.w);
        com.zte.iptvclient.common.uiframe.f.a(this.x);
        com.zte.iptvclient.common.uiframe.f.a(this.y);
        com.zte.iptvclient.common.uiframe.f.a(this.z);
        com.zte.iptvclient.common.uiframe.f.a(this.A);
        com.zte.iptvclient.common.uiframe.f.a(this.B);
        com.zte.iptvclient.common.uiframe.f.a(this.C);
        com.zte.iptvclient.common.uiframe.f.a(this.D);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        this.p.setHeight(a2);
        this.q.setVisibility(0);
        this.r.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.account_title));
        this.r.setTextColor(getResources().getColor(R.color.findpw_title_textcolor));
        this.q.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.A.setOnClickListener(this);
        this.w.setOnClickListener(this);
    }

    private void a(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        Intent intent = new Intent(getActivity(), (Class<?>) HostActivity.class);
        bundle.putString("fragmenttype", str);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
