package com.zte.iptvclient.android.mobile.c0.b;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.r;
import com.facebook.share.widget.ShareDialog;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.j.h;
import com.zte.iptvclient.android.mobile.user.fragment.i;
import com.zte.iptvclient.android.mobile.user.fragment.n;
import com.zte.iptvclient.android.mobile.user.fragment.p;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: MyFragmentHD.java */
/* loaded from: classes.dex */
public class d extends com.zte.fragmentlib.b {
    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        View inflate = layoutInflater.inflate(R.layout.my_fragment_continer_hd, viewGroup, false);
        new h(this.h);
        f.a(inflate.findViewById(R.id.my_layout_menu));
        f.a(inflate.findViewById(R.id.my_layout_sub));
        r b2 = getChildFragmentManager().b();
        b2.a(R.id.my_layout_menu, new e(), "MyMenuFragmentHD");
        b2.a();
        if (!com.zte.iptvclient.android.mobile.n.c.b.t()) {
            a(R.id.my_layout_sub, (com.zte.fragmentlib.b) new com.zte.iptvclient.android.mobile.n.b.b(), false);
        } else {
            a(R.id.my_layout_sub, (com.zte.fragmentlib.b) new com.zte.iptvclient.android.mobile.npvr.view.b(), false);
        }
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroyView() {
        EventBus.getDefault().unregister(this);
        super.onDestroyView();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.z.b bVar) {
        Bundle a2;
        com.zte.fragmentlib.b bVar2;
        if (bVar.a() == null) {
            a2 = new Bundle();
        } else {
            a2 = bVar.a();
        }
        String b2 = bVar.b();
        char c2 = 65535;
        switch (b2.hashCode()) {
            case -2131017537:
                if (b2.equals("changerpsd")) {
                    c2 = '\r';
                    break;
                }
                break;
            case -1637929240:
                if (b2.equals("subscribe_online")) {
                    c2 = '\t';
                    break;
                }
                break;
            case -906336856:
                if (b2.equals("search")) {
                    c2 = 14;
                    break;
                }
                break;
            case -749344867:
                if (b2.equals("scan_share")) {
                    c2 = 21;
                    break;
                }
                break;
            case -339185956:
                if (b2.equals("balance")) {
                    c2 = 4;
                    break;
                }
                break;
            case -238643056:
                if (b2.equals("featurepackage")) {
                    c2 = 15;
                    break;
                }
                break;
            case 111222:
                if (b2.equals("ppv")) {
                    c2 = 3;
                    break;
                }
                break;
            case 87644705:
                if (b2.equals("at_account")) {
                    c2 = 6;
                    break;
                }
                break;
            case 103149417:
                if (b2.equals("login")) {
                    c2 = 18;
                    break;
                }
                break;
            case 106006350:
                if (b2.equals("order")) {
                    c2 = 7;
                    break;
                }
                break;
            case 109400031:
                if (b2.equals(ShareDialog.WEB_SHARE_DIALOG)) {
                    c2 = 19;
                    break;
                }
                break;
            case 514841930:
                if (b2.equals("subscribe")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 528131739:
                if (b2.equals("terminalbindingbt")) {
                    c2 = 16;
                    break;
                }
                break;
            case 735527074:
                if (b2.equals("recordings")) {
                    c2 = 17;
                    break;
                }
                break;
            case 884122723:
                if (b2.equals("changeorderpsd")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 926934164:
                if (b2.equals("history")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1050790300:
                if (b2.equals("favorite")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1234321287:
                if (b2.equals("orderpin")) {
                    c2 = 11;
                    break;
                }
                break;
            case 1414851998:
                if (b2.equals("consumption_records")) {
                    c2 = 20;
                    break;
                }
                break;
            case 1753023057:
                if (b2.equals("productnew")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 2005378358:
                if (b2.equals("bookmark")) {
                    c2 = 0;
                    break;
                }
                break;
            case 2142437458:
                if (b2.equals("channellineup")) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                if (TextUtils.equals("1", ConfigMgr.readPropertie("isShowLastWatch"))) {
                    bVar2 = new com.zte.iptvclient.android.mobile.b0.b.a();
                } else {
                    bVar2 = new com.zte.iptvclient.android.mobile.d.b.a();
                }
                bVar2.setArguments(a2);
                break;
            case 1:
                bVar2 = new com.zte.iptvclient.android.mobile.k.b.e();
                bVar2.setArguments(a2);
                break;
            case 2:
                bVar2 = new com.zte.iptvclient.android.mobile.j.b.c();
                bVar2.setArguments(a2);
                break;
            case 3:
                bVar2 = new com.zte.iptvclient.android.mobile.ppv.fragment.a();
                bVar2.setArguments(a2);
                break;
            case 4:
            default:
                bVar2 = null;
                break;
            case 5:
                bVar2 = new com.zte.iptvclient.android.mobile.e.a();
                bVar2.setArguments(a2);
                break;
            case 6:
                bVar2 = new com.zte.iptvclient.android.mobile.user.fragment.b();
                bVar2.setArguments(a2);
                break;
            case 7:
                bVar2 = new com.zte.iptvclient.android.mobile.q.c.c();
                a2.putBoolean("consumption_records", true);
                bVar2.setArguments(a2);
                break;
            case '\b':
                bVar2 = new com.zte.iptvclient.android.mobile.c.b.a();
                bVar2.setArguments(a2);
                break;
            case '\t':
                bVar2 = new com.zte.iptvclient.android.mobile.q.c.a();
                bVar2.setArguments(a2);
                break;
            case '\n':
                bVar2 = new com.zte.iptvclient.android.mobile.s.a.d();
                bVar2.setArguments(a2);
                break;
            case 11:
                bVar2 = new com.zte.iptvclient.android.mobile.f.a.f();
                bVar2.setArguments(a2);
                break;
            case '\f':
                bVar2 = new com.zte.iptvclient.android.mobile.f.a.c();
                bVar2.setArguments(a2);
                break;
            case '\r':
                bVar2 = new n();
                bVar2.setArguments(a2);
                break;
            case 14:
                bVar2 = new com.zte.iptvclient.android.mobile.v.b.a();
                bVar2.setArguments(a2);
                break;
            case 15:
                bVar2 = new i();
                bVar2.setArguments(a2);
                break;
            case 16:
                bVar2 = new p();
                bVar2.setArguments(a2);
                break;
            case 17:
                bVar2 = new com.zte.iptvclient.android.mobile.npvr.view.b();
                bVar2.setArguments(a2);
                break;
            case 18:
                bVar2 = new com.zte.iptvclient.android.mobile.n.b.b();
                bVar2.setArguments(a2);
                break;
            case 19:
                bVar2 = new com.zte.iptvclient.android.mobile.x.a.b();
                bVar2.setArguments(a2);
                break;
            case 20:
                a2.putBoolean("consumption_records", true);
                bVar2 = new com.zte.iptvclient.android.mobile.q.c.c();
                bVar2.setArguments(a2);
                break;
            case 21:
                a2.putBoolean("scan_share", true);
                bVar2 = new com.zte.iptvclient.android.mobile.x.a.a();
                bVar2.setArguments(a2);
                break;
        }
        if (bVar2 != null) {
            try {
                a(e.class, false);
            } catch (Exception e) {
                LogEx.d("---popToChild Errar", e.getMessage());
            }
            a(R.id.my_layout_sub, bVar2, false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
    }
}
