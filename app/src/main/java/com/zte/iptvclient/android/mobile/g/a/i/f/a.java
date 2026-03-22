package com.zte.iptvclient.android.mobile.g.a.i.f;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.video.androidsdk.common.GlobalConst;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.comm.ParamConst;
import com.zte.fragmentlib.b;
import com.zte.iptvclient.android.common.j.i;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.common.javabean.models.d;
import com.zte.iptvclient.android.common.k.x;
import com.zte.iptvclient.android.common.player.j.j;
import com.zte.iptvclient.android.common.player.k.a;
import com.zte.iptvclient.android.common.player.k.c;
import com.zte.iptvclient.android.mobile.g.a.f;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.video.ContentType;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/* compiled from: CloudDvrPlayerFragment.java */
/* loaded from: classes.dex */
public class a extends b implements f {
    private static final String w = a.class.getName();
    com.zte.iptvclient.android.common.f.b.b p = com.zte.iptvclient.android.common.f.b.b.j();
    private int q = 0;
    private String r = "";
    private com.zte.iptvclient.android.common.player.f s = null;
    private c t = null;
    private com.zte.iptvclient.android.mobile.g.a.h.b u;
    private RelativeLayout v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CloudDvrPlayerFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.g.a.i.f.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0263a implements a.h {
        C0263a() {
        }

        @Override // com.zte.iptvclient.android.common.player.k.a.h
        public void a() {
            if (a.this.v.getVisibility() != 0) {
                a.this.t.W0();
            }
        }
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.f
    public void i(String str) {
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.q != 0) {
            return;
        }
        this.u.a(this.r, null, null);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.s = new com.zte.iptvclient.android.common.player.f();
        this.t = new c();
        this.u = new com.zte.iptvclient.android.mobile.g.a.h.b(this, new com.zte.iptvclient.android.mobile.g.a.g.b());
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        this.q = arguments.getInt("type");
        this.r = arguments.getString("prevuecode");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_clouddvr_player_layout, viewGroup, false);
        this.v = (RelativeLayout) inflate.findViewById(R.id.fragment_clouddvr_player_container);
        return inflate;
    }

    private void b(ArrayList<d> arrayList) {
        boolean z;
        if (arrayList != null && !arrayList.isEmpty()) {
            d dVar = arrayList.get(0);
            this.s = new com.zte.iptvclient.android.common.player.f();
            Bundle bundle = new Bundle();
            Iterator<d> it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                d next = it2.next();
                String k = next.k();
                if (TextUtils.equals(next.f(), "1")) {
                    bundle.putString("url_sd", TextUtils.isEmpty(k) ? "" : k);
                    bundle.putString("physicalcontentid_url_sd", next.j());
                } else if (TextUtils.equals(next.f(), "2")) {
                    bundle.putString("url_sd_h", TextUtils.isEmpty(k) ? "" : k);
                    bundle.putString("physicalcontentid_url_sd_h", next.j());
                } else if (TextUtils.equals(next.f(), "4")) {
                    bundle.putString("url_hd", TextUtils.isEmpty(k) ? "" : k);
                    bundle.putString("physicalcontentid_url_hd", next.j());
                } else if (TextUtils.equals(next.f(), "8")) {
                    bundle.putString("url_480p", TextUtils.isEmpty(k) ? "" : k);
                    bundle.putString("physicalcontentid_url_480p", next.j());
                } else if (TextUtils.equals(next.f(), GlobalConst.WINPHONE_CLIENT)) {
                    bundle.putString("url_720p", TextUtils.isEmpty(k) ? "" : k);
                    bundle.putString("physicalcontentid_url_720p", next.j());
                } else if (TextUtils.equals(next.f(), GlobalConst.ANDRIODSTB_CLIENT)) {
                    bundle.putString("url_1280p", TextUtils.isEmpty(k) ? "" : k);
                    bundle.putString("physicalcontentid_url_1280p", next.j());
                } else {
                    bundle.putString("url_sd", "");
                }
            }
            bundle.putString("bookmark_breakpoint", "0");
            String a2 = dVar.a();
            LogEx.d(w, "channelAuthId=" + a2);
            if (!TextUtils.isEmpty(a2)) {
                bundle.putInt(ParamConst.TV_CHANNEL_SHIFT_PLAY_REQ_AUTHID, Integer.valueOf(a2).intValue());
            } else {
                bundle.putInt(ParamConst.TV_CHANNEL_SHIFT_PLAY_REQ_AUTHID, -1);
            }
            String c2 = dVar.c();
            Channel channel = null;
            ArrayList<Channel> b2 = i.d().b();
            if (b2 != null) {
                int i = 0;
                while (true) {
                    if (i < b2.size()) {
                        if (b2.get(i).getChannelcode().equals(c2) && b2.get(i).getColumncode().equals(dVar.e())) {
                            channel = b2.get(i);
                            break;
                        }
                        i++;
                    } else {
                        break;
                    }
                }
            }
            if (channel != null) {
                bundle.putString("poster_image", channel.getPosterimage());
                bundle.putString("supportTimeShift", channel.getSupporttimeshift());
                bundle.putString("tv_name", channel.getChannelname() + " " + channel.getMixno());
            }
            bundle.putString("prevue_name", dVar.m());
            bundle.putString("tv_id", dVar.c());
            bundle.putString(ParamConst.UPDATE_VERSION_RSP_URL, dVar.k());
            bundle.putString("isprotection", dVar.h());
            bundle.putString("contentcode", dVar.l());
            bundle.putString("ratingid", dVar.o());
            bundle.putString("productVIP", dVar.n());
            LogEx.d(w, "play tvod prevuecode is " + dVar.l());
            bundle.putString("cmsid", dVar.d());
            bundle.putString("physicalcontentid", dVar.j());
            String b3 = dVar.b();
            bundle.putString("prevuebegintime", b3);
            String g = dVar.g();
            bundle.putString("prevueendtime", g);
            bundle.putString(ParamConst.NPVR_QUERY_RSP_DURATION, x.c(b3, "yyyy.MM.dd HH:mm:ss", "HH:mm", 1) + "-" + x.c(g, "yyyy.MM.dd HH:mm:ss", "HH:mm", 1));
            bundle.putString("channelcode", c2);
            String p = dVar.p();
            bundle.putString("playuri4dlna", com.zte.iptvclient.android.mobile.h.a.b.a(dVar.l(), c2, p, x.c(b3, "yyyy.MM.dd HH:mm:ss", "yyyyMMddHHmmss", 1), x.c(g, "yyyy.MM.dd HH:mm:ss", "yyyyMMddHHmmss", 1)));
            bundle.putString("telecomcode", p);
            bundle.putString("auth_contenttype", String.valueOf(ContentType.TYPE_CONTENT_TVOD));
            j jVar = new j();
            jVar.b(dVar.c());
            jVar.a(dVar.e());
            jVar.c("1");
            if (channel != null && !TextUtils.isEmpty(channel.getAdContent())) {
                try {
                    this.s.a(Integer.valueOf(channel.getAdContent()).intValue() > 0);
                } catch (Exception unused) {
                    this.s.a(false);
                }
            }
            if (TextUtils.equals("1", ConfigMgr.readPropertie("SuportTvoDAddBookMark", "0"))) {
                this.s.b(true);
                z = false;
            } else {
                z = false;
                this.s.b(false);
            }
            bundle.putBoolean("IsUesMutliWindowToPlay", z);
            LogEx.d(w, "beginPlayTVInSmallScreen");
            this.t.a(new C0263a());
            bundle.putString("auth_contenttype", String.valueOf(ContentType.TYPE_CONTENT_TVOD.getIntValue()));
            if (channel != null) {
                bundle.putString("channelcode", channel.getTvCode());
                bundle.putString("ratingid", channel.getRatingid());
                bundle.putString("columncode", channel.getColumncode());
                bundle.putString("isNotNeedToSwitch", "2");
            }
            if (TextUtils.equals("1", ConfigMgr.readPropertie("SuportTvoDAddBookMark", "0"))) {
                this.s.b(true);
            } else {
                this.s.b(false);
            }
            String replace = dVar.q().replace(".", "").replace(":", "").replace(" ", "");
            String replace2 = dVar.r().replace(".", "").replace(":", "").replace(" ", "");
            Date b4 = com.zte.iptvclient.android.common.k.d.b(replace);
            Date b5 = com.zte.iptvclient.android.common.k.d.b(replace2);
            long j = 0;
            if (b4 != null && b5 != null) {
                j = b5.getTime() - b4.getTime();
            }
            if (com.zte.iptvclient.android.common.f.b.b.j().e()) {
                this.p.a(c2, b4, b5, (int) j);
            }
            this.s.a(jVar, bundle, (Context) this.h, getChildFragmentManager(), this.v.getId(), this.t);
            return;
        }
        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.no_program_available);
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.f
    public void a(ArrayList<d> arrayList) {
        b(arrayList);
    }
}
