package com.zte.iptvclient.android.mobile.m.a;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.zte.iptvclient.android.mobile.launcher.activity.LauncherPageActivity;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;

/* compiled from: LauncherPageOneFragment.java */
/* loaded from: classes.dex */
public class a extends com.zte.fragmentlib.b {
    private ImageView p;
    private Button q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LauncherPageOneFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.m.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0305a implements View.OnClickListener {
        ViewOnClickListenerC0305a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((LauncherPageActivity) a.this.getActivity()).b(1);
        }
    }

    private void I() {
        this.q.setOnClickListener(new ViewOnClickListenerC0305a());
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_launcher_page_one, (ViewGroup) null);
        this.p = (ImageView) inflate.findViewById(R.id.imgvew_bg);
        Button button = (Button) inflate.findViewById(R.id.btn_i_know);
        this.q = button;
        button.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.i_know));
        f.a(this.p);
        f.a(this.q);
        I();
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }
}
