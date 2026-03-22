package com.zte.iptvclient.android.mobile.m.a;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.zte.iptvclient.android.mobile.launcher.activity.LauncherPageActivity;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;

/* compiled from: LauncherPageTwoFragment.java */
/* loaded from: classes.dex */
public class c extends com.zte.fragmentlib.b {
    private ImageView p;
    private Button q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LauncherPageTwoFragment.java */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((LauncherPageActivity) c.this.getActivity()).b(2);
        }
    }

    private void I() {
        this.q.setOnClickListener(new a());
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_launcher_page_two, (ViewGroup) null);
        this.p = (ImageView) inflate.findViewById(R.id.imgvew_bg);
        Button button = (Button) inflate.findViewById(R.id.btn_i_know);
        this.q = button;
        f.a(button);
        f.a(this.p);
        I();
        this.q.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.i_know));
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }
}
