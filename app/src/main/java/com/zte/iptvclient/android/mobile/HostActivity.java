package com.zte.iptvclient.android.mobile;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.log.LogEx;
import com.zte.fragmentlib.SupportActivity;
import com.zte.fragmentlib.b;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.mobile.e0.e.d;
import com.zte.iptvclient.android.mobile.e0.e.e;
import com.zte.iptvclient.android.mobile.e0.e.i;
import com.zte.iptvclient.android.mobile.e0.e.j;
import com.zte.iptvclient.android.mobile.i.b.c;
import com.zte.iptvclient.android.zala.R;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class HostActivity extends SupportActivity {
    b v;

    @Override // com.zte.fragmentlib.SupportActivity
    public void l() {
        super.l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x007a, code lost:
    
        if (r1.equals("bookmark") != false) goto L240;
     */
    @Override // com.zte.fragmentlib.SupportActivity, com.zte.fragmentlib.publicbaseclass.skinloader.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onCreate(android.os.Bundle r5) {
        /*
            Method dump skipped, instructions count: 2788
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.mobile.HostActivity.onCreate(android.os.Bundle):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zte.fragmentlib.SupportActivity, com.zte.fragmentlib.publicbaseclass.skinloader.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        LogEx.d("HostActivity", "onDestroy");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LogEx.d("HostActivity", "onNewIntent");
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        extras.putBoolean("enable_title_back", true);
        String string = extras.getString("fragmenttype");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        char c2 = 65535;
        int hashCode = string.hashCode();
        if (hashCode != -748801151) {
            if (hashCode != 997925256) {
                if (hashCode == 1427818632 && string.equals("download")) {
                    c2 = 2;
                }
            } else if (string.equals("seriesdetail")) {
                c2 = 1;
            }
        } else if (string.equals("moviedetail")) {
            c2 = 0;
        }
        if (c2 == 0) {
            if ("1".equals(ConfigMgr.readPropertie("isShow")) && BaseApp.a(this)) {
                this.v = new e();
            } else {
                this.v = new d();
            }
            this.v.setArguments(extras);
            a(R.id.rlayout_host, this.v, false);
            return;
        }
        if (c2 != 1) {
            if (c2 != 2) {
                return;
            }
            c cVar = new c();
            this.v = cVar;
            cVar.setArguments(extras);
            a(R.id.rlayout_host, this.v);
            return;
        }
        if ("1".equals(ConfigMgr.readPropertie("isShow")) && BaseApp.a(this)) {
            this.v = new j();
        } else {
            this.v = new i();
        }
        this.v.setArguments(extras);
        a(R.id.rlayout_host, this.v, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zte.fragmentlib.SupportActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        LogEx.d("HostActivity", "onSaveInstanceState");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        LogEx.d("HostActivity", "onStop");
    }

    public com.zte.iptvclient.android.common.player.k.c r() {
        try {
            return (com.zte.iptvclient.android.common.player.k.c) this.v.getClass().getMethod("getPlayer", new Class[0]).invoke(this.v, new Object[0]);
        } catch (ClassCastException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return null;
        }
    }
}
