package com.zte.iptvclient.android.mobile.m.a;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;

/* compiled from: LauncherPageThreeFragment.java */
/* loaded from: classes.dex */
public class b extends com.zte.fragmentlib.b {
    private Activity p;
    private TextView q;

    /* compiled from: LauncherPageThreeFragment.java */
    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.p == null) {
                return;
            }
            LogEx.d("LauncherPageThreeFragment", "start MainActivity  else");
            Intent intent = new Intent(b.this.p, (Class<?>) MainActivity.class);
            Intent intent2 = b.this.p.getIntent();
            if (intent2 != null) {
                Bundle extras = intent2.getExtras();
                if (extras == null) {
                    extras = new Bundle();
                }
                intent.putExtras(extras);
            }
            b.this.p.startActivity(intent);
            b.this.p.finish();
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.p == null) {
            LogEx.w("LauncherPageThreeFragment", "activity is null");
        } else {
            this.q.setOnClickListener(new a());
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.p = activity;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_launcher_page_three, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.btn_i_know);
        this.q = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.experience));
        f.a(this.q);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }
}
