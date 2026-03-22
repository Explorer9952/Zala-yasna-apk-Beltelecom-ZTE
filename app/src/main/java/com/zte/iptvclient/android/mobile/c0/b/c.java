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
import com.zte.iptvclient.android.common.customview.a.a.e.j;
import com.zte.iptvclient.android.common.j.h;
import com.zte.iptvclient.android.common.javabean.models.Feature;
import com.zte.iptvclient.android.mobile.e0.e.i;
import com.zte.iptvclient.android.mobile.f.a.g;
import com.zte.iptvclient.android.mobile.user.fragment.n;
import com.zte.iptvclient.android.mobile.user.fragment.p;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.ArrayList;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: MineFragmentHD.java */
/* loaded from: classes.dex */
public class c extends com.zte.fragmentlib.b {
    private String p;
    private boolean q = false;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        View inflate = layoutInflater.inflate(R.layout.fragment_pad_mine_hd, viewGroup, false);
        new h(this.h);
        f.a(inflate.findViewById(R.id.layout_menu));
        f.a(inflate.findViewById(R.id.layout_sub));
        r b2 = getChildFragmentManager().b();
        b2.a(R.id.layout_menu, new b(), "MenuFragmentHD");
        b2.a();
        if (com.zte.iptvclient.android.mobile.n.c.b.t()) {
            if ("1".equals(ConfigMgr.readPropertie("isShowAccount"))) {
                a(R.id.layout_sub, (com.zte.fragmentlib.b) new com.zte.iptvclient.android.mobile.u.a.a(), false);
                this.p = "fragment_remote";
                ArrayList<Feature> d2 = com.zte.iptvclient.android.common.j.c.e().d();
                if (d2 == null || d2.size() <= 0) {
                    j jVar = new j(this.h, R.style.dialog_order);
                    jVar.setCanceledOnTouchOutside(false);
                    jVar.a();
                }
            } else if ("1".equals(ConfigMgr.readPropertie("isShow"))) {
                new Bundle().putBoolean("isSideMenu", false);
                a(R.id.layout_sub, (com.zte.fragmentlib.b) new com.zte.iptvclient.android.mobile.user.fragment.b(), false);
                this.p = "at_account";
            }
        } else {
            a(R.id.layout_sub, (com.zte.fragmentlib.b) new com.zte.iptvclient.android.mobile.n.b.b(), false);
            this.p = "login";
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
    public void onEventMainThread(com.zte.iptvclient.android.common.e.z.a aVar) {
        Bundle a2;
        com.zte.fragmentlib.b bVar;
        ArrayList<Feature> d2;
        if (aVar.a() == null) {
            a2 = new Bundle();
        } else {
            a2 = aVar.a();
        }
        if (this.p != aVar.b() || aVar.c()) {
            this.p = aVar.b();
            String b2 = aVar.b();
            char c2 = 65535;
            switch (b2.hashCode()) {
                case -2131017537:
                    if (b2.equals("changerpsd")) {
                        c2 = 22;
                        break;
                    }
                    break;
                case -1637929240:
                    if (b2.equals("subscribe_online")) {
                        c2 = '\f';
                        break;
                    }
                    break;
                case -1112970468:
                    if (b2.equals("messagecenter")) {
                        c2 = 16;
                        break;
                    }
                    break;
                case -906336856:
                    if (b2.equals("search")) {
                        c2 = 24;
                        break;
                    }
                    break;
                case -774645483:
                    if (b2.equals("fragment_remote")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -749344867:
                    if (b2.equals("scan_share")) {
                        c2 = 31;
                        break;
                    }
                    break;
                case -748801151:
                    if (b2.equals("moviedetail")) {
                        c2 = 17;
                        break;
                    }
                    break;
                case -346365263:
                    if (b2.equals("switchskin")) {
                        c2 = '\r';
                        break;
                    }
                    break;
                case -339185956:
                    if (b2.equals("balance")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case -238643056:
                    if (b2.equals("featurepackage")) {
                        c2 = 25;
                        break;
                    }
                    break;
                case -224712767:
                    if (b2.equals("parentcontral")) {
                        c2 = 23;
                        break;
                    }
                    break;
                case -106067058:
                    if (b2.equals("favorite_support_stb")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 111222:
                    if (b2.equals("ppv")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 3198785:
                    if (b2.equals("help")) {
                        c2 = 14;
                        break;
                    }
                    break;
                case 87644705:
                    if (b2.equals("at_account")) {
                        c2 = '\t';
                        break;
                    }
                    break;
                case 103149417:
                    if (b2.equals("login")) {
                        c2 = 28;
                        break;
                    }
                    break;
                case 106006350:
                    if (b2.equals("order")) {
                        c2 = '\n';
                        break;
                    }
                    break;
                case 109400031:
                    if (b2.equals(ShareDialog.WEB_SHARE_DIALOG)) {
                        c2 = 29;
                        break;
                    }
                    break;
                case 514841930:
                    if (b2.equals("subscribe")) {
                        c2 = 11;
                        break;
                    }
                    break;
                case 528131739:
                    if (b2.equals("terminalbindingbt")) {
                        c2 = 26;
                        break;
                    }
                    break;
                case 735527074:
                    if (b2.equals("recordings")) {
                        c2 = 27;
                        break;
                    }
                    break;
                case 884122723:
                    if (b2.equals("changeorderpsd")) {
                        c2 = 21;
                        break;
                    }
                    break;
                case 926934164:
                    if (b2.equals("history")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 997925256:
                    if (b2.equals("seriesdetail")) {
                        c2 = 18;
                        break;
                    }
                    break;
                case 1050790300:
                    if (b2.equals("favorite")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1234321287:
                    if (b2.equals("orderpin")) {
                        c2 = 20;
                        break;
                    }
                    break;
                case 1414851998:
                    if (b2.equals("consumption_records")) {
                        c2 = 30;
                        break;
                    }
                    break;
                case 1427818632:
                    if (b2.equals("download")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 1753023057:
                    if (b2.equals("productnew")) {
                        c2 = 19;
                        break;
                    }
                    break;
                case 1985941072:
                    if (b2.equals("setting")) {
                        c2 = 15;
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
                        c2 = '\b';
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    if (TextUtils.equals("1", ConfigMgr.readPropertie("isShowLastWatch"))) {
                        bVar = new com.zte.iptvclient.android.mobile.b0.b.a();
                    } else {
                        bVar = new com.zte.iptvclient.android.mobile.d.b.a();
                    }
                    bVar.setArguments(a2);
                    break;
                case 1:
                    bVar = new com.zte.iptvclient.android.mobile.k.b.e();
                    bVar.setArguments(a2);
                    break;
                case 2:
                    bVar = new com.zte.iptvclient.android.mobile.u.a.a();
                    bVar.setArguments(a2);
                    if (!this.q && ((d2 = com.zte.iptvclient.android.common.j.c.e().d()) == null || d2.size() <= 0)) {
                        j jVar = new j(this.h, R.style.dialog_order);
                        jVar.setCanceledOnTouchOutside(false);
                        jVar.a();
                        break;
                    }
                    break;
                case 3:
                    bVar = new com.zte.iptvclient.android.mobile.j.b.c();
                    bVar.setArguments(a2);
                    break;
                case 4:
                    bVar = new com.zte.iptvclient.android.mobile.j.b.a();
                    bVar.setArguments(a2);
                    break;
                case 5:
                    bVar = new com.zte.iptvclient.android.mobile.i.b.c();
                    bVar.setArguments(a2);
                    break;
                case 6:
                    bVar = new com.zte.iptvclient.android.mobile.ppv.fragment.a();
                    bVar.setArguments(a2);
                    break;
                case 7:
                default:
                    bVar = null;
                    break;
                case '\b':
                    bVar = new com.zte.iptvclient.android.mobile.e.a();
                    bVar.setArguments(a2);
                    break;
                case '\t':
                    bVar = new com.zte.iptvclient.android.mobile.user.fragment.b();
                    bVar.setArguments(a2);
                    break;
                case '\n':
                    bVar = new com.zte.iptvclient.android.mobile.q.c.d();
                    a2.putBoolean("consumption_records", true);
                    bVar.setArguments(a2);
                    break;
                case 11:
                    bVar = new com.zte.iptvclient.android.mobile.c.b.a();
                    bVar.setArguments(a2);
                    break;
                case '\f':
                    bVar = new com.zte.iptvclient.android.mobile.q.c.a();
                    bVar.setArguments(a2);
                    break;
                case '\r':
                    bVar = new com.zte.iptvclient.android.mobile.z.a();
                    bVar.setArguments(a2);
                    break;
                case 14:
                    bVar = new com.zte.iptvclient.android.mobile.user.fragment.j();
                    bVar.setArguments(a2);
                    break;
                case 15:
                    bVar = new com.zte.iptvclient.android.mobile.w.a.b();
                    bVar.setArguments(a2);
                    break;
                case 16:
                    bVar = new com.zte.iptvclient.android.mobile.o.a.a();
                    bVar.setArguments(a2);
                    break;
                case 17:
                    bVar = new com.zte.iptvclient.android.mobile.e0.e.d();
                    bVar.setArguments(a2);
                    break;
                case 18:
                    bVar = new i();
                    bVar.setArguments(a2);
                    break;
                case 19:
                    bVar = new com.zte.iptvclient.android.mobile.s.a.d();
                    bVar.setArguments(a2);
                    break;
                case 20:
                    bVar = new com.zte.iptvclient.android.mobile.f.a.f();
                    bVar.setArguments(a2);
                    break;
                case 21:
                    bVar = new com.zte.iptvclient.android.mobile.f.a.c();
                    bVar.setArguments(a2);
                    break;
                case 22:
                    bVar = new n();
                    bVar.setArguments(a2);
                    break;
                case 23:
                    bVar = new g();
                    bVar.setArguments(a2);
                    break;
                case 24:
                    bVar = new com.zte.iptvclient.android.mobile.v.b.a();
                    bVar.setArguments(a2);
                    break;
                case 25:
                    bVar = new com.zte.iptvclient.android.mobile.user.fragment.i();
                    bVar.setArguments(a2);
                    break;
                case 26:
                    bVar = new p();
                    bVar.setArguments(a2);
                    break;
                case 27:
                    if ("1".equals(ConfigMgr.readPropertie("isNPVR"))) {
                        bVar = new com.zte.iptvclient.android.mobile.npvr.view.b();
                    } else {
                        bVar = new com.zte.iptvclient.android.mobile.g.a.i.e();
                    }
                    bVar.setArguments(a2);
                    break;
                case 28:
                    bVar = new com.zte.iptvclient.android.mobile.n.b.b();
                    bVar.setArguments(a2);
                    break;
                case 29:
                    if (!com.zte.iptvclient.android.mobile.n.c.b.t()) {
                        new com.zte.iptvclient.android.mobile.n.b.b().setArguments(a2);
                    }
                    bVar = new com.zte.iptvclient.android.mobile.x.a.b();
                    bVar.setArguments(a2);
                    break;
                case 30:
                    a2.putBoolean("consumption_records", true);
                    bVar = new com.zte.iptvclient.android.mobile.q.c.d();
                    bVar.setArguments(a2);
                    break;
                case 31:
                    a2.putBoolean("scan_share", true);
                    bVar = new com.zte.iptvclient.android.mobile.x.a.a();
                    bVar.setArguments(a2);
                    break;
            }
            if (bVar != null) {
                try {
                    a(b.class, false);
                } catch (Exception e) {
                    LogEx.d("---popToChild Errar", e.getMessage());
                }
                a(R.id.layout_sub, bVar, false);
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.javabean.h hVar) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        this.q = z;
        if (!z) {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.f());
        }
        if (z || this.p != "fragment_remote") {
            return;
        }
        ArrayList<Feature> d2 = com.zte.iptvclient.android.common.j.c.e().d();
        if (d2 == null || d2.size() <= 0) {
            j jVar = new j(this.h, R.style.dialog_order);
            jVar.setCanceledOnTouchOutside(false);
            jVar.a();
        }
    }
}
