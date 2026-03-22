package com.zte.iptvclient.android.mobile.remote.activity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.zte.fragmentlib.SupportActivity;
import com.zte.fragmentlib.b;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;

/* loaded from: classes2.dex */
public class RemoteActivity extends SupportActivity {
    private Button v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RemoteActivity.this.finish();
        }
    }

    private void r() {
        this.v.setOnClickListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zte.fragmentlib.SupportActivity, com.zte.fragmentlib.publicbaseclass.skinloader.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setFlags(512, 512);
        }
        setContentView(R.layout.remote_activity_layout);
        TextView textView = (TextView) findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        Button button = (Button) findViewById(R.id.btn_close);
        this.v = button;
        f.a(button);
        a(R.id.remote_container, (b) new com.zte.iptvclient.android.mobile.u.a.a(), false);
        r();
    }
}
