package com.zte.iptvclient.android.common.player.multiplay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.fragment.app.r;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.video.androidsdk.common.GlobalConst;
import com.video.androidsdk.download.Linstener.DownloadListReturnListener;
import com.video.androidsdk.download.SDKDownloadMgr;
import com.video.androidsdk.download.bean.DownloadTask;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.channel.SDKChannelMgr;
import com.video.androidsdk.service.comm.ParamConst;
import com.video.androidsdk.service.play.SDKPlayMgr;
import com.video.androidsdk.service.prevue.SDKPrevueMgr;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.j.i;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.common.javabean.models.MultiDefinitionURLBean;
import com.zte.iptvclient.android.common.k.x;
import com.zte.iptvclient.android.common.player.activity.VOPlayerActivity;
import com.zte.iptvclient.android.common.player.j.j;
import com.zte.iptvclient.android.common.player.k.a;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: MultiPlayerQueryHelper.java */
/* loaded from: classes.dex */
public class b {
    private static final String f = "b";

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<com.zte.iptvclient.android.common.player.k.d> f5146a;

    /* renamed from: b, reason: collision with root package name */
    private com.zte.iptvclient.android.common.player.k.d f5147b;

    /* renamed from: c, reason: collision with root package name */
    private Activity f5148c;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<DownloadTask> f5149d;
    private DownloadListReturnListener e = new f();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MultiPlayerQueryHelper.java */
    /* loaded from: classes.dex */
    public class a implements a.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.player.k.d f5150a;

        a(com.zte.iptvclient.android.common.player.k.d dVar) {
            this.f5150a = dVar;
        }

        @Override // com.zte.iptvclient.android.common.player.k.a.h
        public void a() {
            if (this.f5150a.equals(b.this.f5147b)) {
                this.f5150a.b(false);
            } else {
                this.f5150a.b(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MultiPlayerQueryHelper.java */
    /* renamed from: com.zte.iptvclient.android.common.player.multiplay.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0157b implements a.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.player.k.d f5152a;

        C0157b(com.zte.iptvclient.android.common.player.k.d dVar) {
            this.f5152a = dVar;
        }

        @Override // com.zte.iptvclient.android.common.player.k.a.h
        public void a() {
            if (this.f5152a.equals(b.this.f5147b)) {
                this.f5152a.b(false);
            } else {
                this.f5152a.b(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MultiPlayerQueryHelper.java */
    /* loaded from: classes.dex */
    public class c implements SDKPlayMgr.OnMultiDefinitionUrlReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.javabean.f f5154a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.player.k.d f5155b;

        c(com.zte.iptvclient.android.common.javabean.f fVar, com.zte.iptvclient.android.common.player.k.d dVar) {
            this.f5154a = fVar;
            this.f5155b = dVar;
        }

        @Override // com.video.androidsdk.service.play.SDKPlayMgr.OnMultiDefinitionUrlReturnListener
        public void onMultiDefinitionUrlReturn(String str, String str2, String str3) {
            DownloadTask a2;
            LogEx.d(b.f, "onMultiDefinitionUrlReturn returncode=" + str + "emsg" + str2 + ",data =" + str3);
            Bundle bundle = new Bundle();
            if (TextUtils.equals(str, "0")) {
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    String str4 = "";
                    String str5 = "";
                    String str6 = str5;
                    String str7 = WeiboAuthException.DEFAULT_AUTH_ERROR_CODE;
                    String str8 = str6;
                    for (int i = 0; i < jSONArray.length(); i++) {
                        MultiDefinitionURLBean a3 = MultiDefinitionURLBean.a(jSONArray.getJSONObject(i));
                        if (a3 != null) {
                            if (TextUtils.isEmpty(str8) && !TextUtils.isEmpty(a3.i())) {
                                str8 = a3.i();
                            }
                            if ("1".equals(a3.f()) && !TextUtils.isEmpty(a3.i())) {
                                bundle.putString("url_sd", a3.i());
                            } else if ("2".equals(a3.f()) && !TextUtils.isEmpty(a3.i())) {
                                bundle.putString("url_sd_h", a3.i());
                            } else if ("4".equals(a3.f()) && !TextUtils.isEmpty(a3.i())) {
                                bundle.putString("url_hd", a3.i());
                            } else if ("8".equals(a3.f()) && !TextUtils.isEmpty(a3.i())) {
                                bundle.putString("url_480p", a3.i());
                            } else if (GlobalConst.WINPHONE_CLIENT.equals(a3.f()) && !TextUtils.isEmpty(a3.i())) {
                                bundle.putString("url_720p", a3.i());
                            } else if (GlobalConst.ANDRIODSTB_CLIENT.equals(a3.f()) && !TextUtils.isEmpty(a3.i())) {
                                bundle.putString("url_1280p", a3.i());
                            }
                            bundle.putString("bookmarktype", "1");
                            if (!TextUtils.isEmpty(a3.b())) {
                                bundle.putString("bookmark_breakpoint", a3.b());
                            }
                            if (!TextUtils.isEmpty(a3.a())) {
                                str7 = a3.a();
                            }
                            if (!TextUtils.isEmpty(a3.d())) {
                                str4 = a3.d();
                            }
                            if (!TextUtils.isEmpty(a3.e())) {
                                str5 = a3.e();
                            }
                            if (!TextUtils.isEmpty(a3.j())) {
                                str6 = a3.j();
                            }
                        }
                    }
                    bundle.putString("columncode", str4);
                    bundle.putString("contentcode", str5);
                    if (!TextUtils.isEmpty(str7)) {
                        bundle.putInt(ParamConst.TV_CHANNEL_SHIFT_PLAY_REQ_AUTHID, Integer.valueOf(str7).intValue());
                    } else {
                        bundle.putInt(ParamConst.TV_CHANNEL_SHIFT_PLAY_REQ_AUTHID, -1);
                    }
                    if (this.f5154a != null) {
                        bundle.putString("playuri4dlna", com.zte.iptvclient.android.mobile.h.a.b.b(str4, this.f5154a.d(), str6, str5, this.f5154a.e(), ""));
                        bundle.putString("programname", this.f5154a.e());
                        bundle.putString("programcode", this.f5154a.d());
                        if (!TextUtils.isEmpty(this.f5154a.b()) && !TextUtils.equals(this.f5154a.b(), "0")) {
                            bundle.putString("bookmark_breakpoint", this.f5154a.b());
                        }
                    }
                    bundle.putString("auth_contenttype", str6);
                    if (this.f5154a != null) {
                        bundle.putInt("curepisode", Integer.valueOf(this.f5154a.a()).intValue());
                    }
                    if (this.f5154a != null && b.this.f5149d != null && b.this.f5149d.size() > 0 && (a2 = b.this.a(this.f5154a.d(), (ArrayList<DownloadTask>) b.this.f5149d)) != null && !com.zte.iptvclient.android.mobile.download.helper.c.c.a(a2).booleanValue()) {
                        String playURL = SDKDownloadMgr.getInstance().getPlayURL(1, a2);
                        if (!TextUtils.isEmpty(playURL)) {
                            bundle.putString("url_nav", playURL);
                        }
                    }
                    if (this.f5155b != null) {
                        this.f5155b.e(bundle);
                    } else {
                        Intent intent = new Intent();
                        intent.putExtras(bundle);
                        intent.putExtra("fromActivityName", "MultiPlayActivity");
                        intent.setClass(b.this.f5148c, VOPlayerActivity.class);
                        intent.addFlags(268435456);
                        b.this.f5148c.startActivity(intent);
                    }
                } catch (Exception e) {
                    LogEx.e(b.f, e.getMessage());
                }
            }
            if (b.this.f5148c instanceof SupportActivity) {
                ((SupportActivity) b.this.f5148c).d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MultiPlayerQueryHelper.java */
    /* loaded from: classes.dex */
    public class d implements SDKPrevueMgr.OnPrevueDetailWithUrlReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f5157a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.player.k.d f5158b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.javabean.f f5159c;

        d(ArrayList arrayList, com.zte.iptvclient.android.common.player.k.d dVar, com.zte.iptvclient.android.common.javabean.f fVar) {
            this.f5157a = arrayList;
            this.f5158b = dVar;
            this.f5159c = fVar;
        }

        @Override // com.video.androidsdk.service.prevue.SDKPrevueMgr.OnPrevueDetailWithUrlReturnListener
        public void onPrevueDetailWithUrlReturn(String str, String str2, String str3) {
            LogEx.d(b.f, "sdkQueryTvodById:  onDataReturn,arg0= " + str3);
            if (TextUtils.equals(str, "0")) {
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        if (jSONObject != null) {
                            com.zte.iptvclient.android.common.javabean.models.d a2 = com.zte.iptvclient.android.common.javabean.models.d.a(jSONObject);
                            a2.u("0");
                            if (jSONObject.has("productList")) {
                                JSONArray jSONArray2 = jSONObject.getJSONArray("productList");
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= jSONArray2.length()) {
                                        break;
                                    }
                                    String optString = jSONArray2.getJSONObject(i2).optString("productname");
                                    if (optString != null && optString.contains("VIP")) {
                                        a2.u("1");
                                        break;
                                    }
                                    i2++;
                                }
                            }
                            this.f5157a.add(a2);
                        }
                    }
                    if (!this.f5157a.isEmpty()) {
                        b.this.b((ArrayList<com.zte.iptvclient.android.common.javabean.models.d>) this.f5157a, this.f5158b, this.f5159c);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    LogEx.e(b.f, e.getMessage());
                }
            }
            if (b.this.f5148c instanceof SupportActivity) {
                ((SupportActivity) b.this.f5148c).d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MultiPlayerQueryHelper.java */
    /* loaded from: classes.dex */
    public class e implements SDKChannelMgr.OnChannelDetailWithUrlReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f5161a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.player.k.d f5162b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.javabean.f f5163c;

        e(ArrayList arrayList, com.zte.iptvclient.android.common.player.k.d dVar, com.zte.iptvclient.android.common.javabean.f fVar) {
            this.f5161a = arrayList;
            this.f5162b = dVar;
            this.f5163c = fVar;
        }

        @Override // com.video.androidsdk.service.channel.SDKChannelMgr.OnChannelDetailWithUrlReturnListener
        public void onChannelDetailWithUrlReturn(String str, String str2, String str3) {
            LogEx.d(b.f, "returncode= " + str + "  errmsg " + str2 + "  msg " + str3);
            if ("0".equals(str)) {
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        if (jSONObject != null) {
                            com.zte.iptvclient.android.common.javabean.models.c a2 = com.zte.iptvclient.android.common.javabean.models.c.a(jSONObject);
                            a2.r("0");
                            if (jSONObject.has("productList")) {
                                JSONArray jSONArray2 = jSONObject.getJSONArray("productList");
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= jSONArray2.length()) {
                                        break;
                                    }
                                    String optString = jSONArray2.getJSONObject(i2).optString("productname");
                                    if (optString != null && optString.contains("VIP")) {
                                        a2.r("1");
                                        break;
                                    }
                                    i2++;
                                }
                            }
                            this.f5161a.add(a2);
                        }
                    }
                    if (this.f5161a.size() > 0) {
                        b.this.a((ArrayList<com.zte.iptvclient.android.common.javabean.models.c>) this.f5161a, this.f5162b, this.f5163c);
                    }
                } catch (Exception e) {
                    LogEx.e(b.f, e.getMessage());
                }
            }
            if (b.this.f5148c instanceof SupportActivity) {
                ((SupportActivity) b.this.f5148c).d();
            }
        }
    }

    /* compiled from: MultiPlayerQueryHelper.java */
    /* loaded from: classes.dex */
    class f implements DownloadListReturnListener {
        f() {
        }

        @Override // com.video.androidsdk.download.Linstener.DownloadListReturnListener
        public void returnDownloadTaskList(String str, int i, String str2, ArrayList<DownloadTask> arrayList) {
            LogEx.d(b.f, "status = " + str + ", errorCode = " + i + ", errorMsg = " + str2 + ", arraylist = " + arrayList);
            b.this.f5149d = arrayList;
        }
    }

    public void d() {
        for (int i = 0; i < this.f5146a.size(); i++) {
            this.f5146a.get(i).R();
        }
    }

    public void e(com.zte.iptvclient.android.common.player.k.d dVar) {
        this.f5147b = dVar;
        for (int i = 0; i < this.f5146a.size(); i++) {
            if (this.f5146a.get(i).equals(dVar)) {
                this.f5146a.get(i).b(false);
            } else {
                this.f5146a.get(i).b(true);
            }
        }
    }

    public void f() {
        for (int i = 0; i < this.f5146a.size(); i++) {
            this.f5146a.get(i).d(false);
            this.f5146a.get(i).w0();
        }
    }

    public void g() {
        for (int i = 0; i < this.f5146a.size(); i++) {
            this.f5146a.get(i).W1();
        }
    }

    public void c(com.zte.iptvclient.android.common.player.k.d dVar) {
        ArrayList<com.zte.iptvclient.android.common.player.k.d> arrayList = this.f5146a;
        if (arrayList != null) {
            arrayList.remove(dVar);
        }
    }

    public void b() {
        for (int i = 0; i < this.f5146a.size(); i++) {
            this.f5146a.get(i).i(false);
            this.f5146a.get(i).E();
        }
    }

    public void d(com.zte.iptvclient.android.common.player.k.d dVar) {
        this.f5147b = dVar;
    }

    public void c() {
        if (this.f5146a == null) {
            return;
        }
        for (int i = 0; i < this.f5146a.size(); i++) {
            this.f5146a.get(i).U1();
        }
    }

    public void a(com.zte.iptvclient.android.common.player.k.d dVar) {
        for (int i = 0; i < this.f5146a.size(); i++) {
            this.f5146a.get(i).i(true);
            if (this.f5146a.get(i).equals(dVar)) {
                this.f5146a.get(i).f0();
            } else {
                this.f5146a.get(i).E();
            }
        }
    }

    public void b(com.zte.iptvclient.android.common.player.k.d dVar) {
        for (int i = 0; i < this.f5146a.size(); i++) {
            if (this.f5146a.get(i).equals(dVar)) {
                this.f5146a.get(i).L1();
            } else {
                this.f5146a.get(i).U1();
            }
        }
    }

    public void e() {
        for (int i = 0; i < this.f5146a.size(); i++) {
            this.f5146a.get(i).O1();
        }
    }

    private void b(com.zte.iptvclient.android.common.javabean.f fVar, boolean z, com.zte.iptvclient.android.common.player.k.d dVar) {
        if (dVar == null) {
            Activity activity = this.f5148c;
            if (activity instanceof SupportActivity) {
                ((SupportActivity) activity).q();
            }
        }
        ArrayList arrayList = new ArrayList();
        SDKPrevueMgr sDKPrevueMgr = new SDKPrevueMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("prevuecode", fVar.d());
        hashMap.put("recommendtype", z ? "1" : "0");
        sDKPrevueMgr.getPrevueDetailWithUrl(hashMap, new d(arrayList, dVar, fVar));
    }

    public void a(Activity activity, int[] iArr) {
        SDKDownloadMgr.getInstance().getDownloadList("0", 1, this.e);
        this.f5148c = activity;
        this.f5146a = new ArrayList<>();
        ArrayList<com.zte.iptvclient.android.common.javabean.f> a2 = com.zte.iptvclient.android.common.player.multiplay.a.c().a();
        int size = a2.size();
        if (iArr.length == size) {
            for (int i = 0; i < size; i++) {
                com.zte.iptvclient.android.common.javabean.f fVar = a2.get(i);
                VDHLayout vDHLayout = (VDHLayout) activity.findViewById(R.id.multi_play_container);
                FrameLayout frameLayout = new FrameLayout(activity);
                frameLayout.setPadding(5, 5, 5, 5);
                frameLayout.setId(iArr[i]);
                frameLayout.setTag(R.id.multi_player_tag1, fVar);
                vDHLayout.addView(frameLayout);
                vDHLayout.a(frameLayout);
                String c2 = fVar.c();
                com.zte.iptvclient.android.common.player.k.d dVar = new com.zte.iptvclient.android.common.player.k.d();
                frameLayout.setTag(R.id.multi_player_tag2, dVar);
                dVar.a(fVar);
                dVar.a(new a(dVar));
                this.f5146a.add(dVar);
                r b2 = ((SupportActivity) activity).getSupportFragmentManager().b();
                b2.a(iArr[i], dVar);
                b2.b();
                if (TextUtils.equals(c2, "1")) {
                    b(fVar, false, dVar);
                } else if (TextUtils.equals(c2, "0")) {
                    a(fVar, dVar);
                } else if (TextUtils.equals(c2, "2")) {
                    if (!TextUtils.isEmpty(fVar.h())) {
                        a(fVar);
                    }
                    a(fVar, false, dVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ArrayList<com.zte.iptvclient.android.common.javabean.models.d> arrayList, com.zte.iptvclient.android.common.player.k.d dVar, com.zte.iptvclient.android.common.javabean.f fVar) {
        int i = 0;
        com.zte.iptvclient.android.common.javabean.models.d dVar2 = arrayList.get(0);
        String a2 = dVar2.a();
        LogEx.d(f, "onDataReturn: channelAuthId=" + a2);
        Bundle bundle = new Bundle();
        Iterator<com.zte.iptvclient.android.common.javabean.models.d> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            com.zte.iptvclient.android.common.javabean.models.d next = it2.next();
            String k = next.k();
            if (TextUtils.equals(next.f(), "1")) {
                if (TextUtils.isEmpty(k)) {
                    k = "";
                }
                bundle.putString("url_sd", k);
                bundle.putString("physicalcontentid_url_sd", next.j());
            } else if (TextUtils.equals(next.f(), "2")) {
                if (TextUtils.isEmpty(k)) {
                    k = "";
                }
                bundle.putString("url_sd_h", k);
                bundle.putString("physicalcontentid_url_sd_h", next.j());
            } else if (TextUtils.equals(next.f(), "4")) {
                if (TextUtils.isEmpty(k)) {
                    k = "";
                }
                bundle.putString("url_hd", k);
                bundle.putString("physicalcontentid_url_hd", next.j());
            } else if (TextUtils.equals(next.f(), "8")) {
                if (TextUtils.isEmpty(k)) {
                    k = "";
                }
                bundle.putString("url_480p", k);
                bundle.putString("physicalcontentid_url_480p", next.j());
            } else if (TextUtils.equals(next.f(), GlobalConst.WINPHONE_CLIENT)) {
                if (TextUtils.isEmpty(k)) {
                    k = "";
                }
                bundle.putString("url_720p", k);
                bundle.putString("physicalcontentid_url_720p", next.j());
            } else if (TextUtils.equals(next.f(), GlobalConst.ANDRIODSTB_CLIENT)) {
                if (TextUtils.isEmpty(k)) {
                    k = "";
                }
                bundle.putString("url_1280p", k);
                bundle.putString("physicalcontentid_url_1280p", next.j());
            } else {
                bundle.putString("url_sd", "");
            }
        }
        if (!TextUtils.isEmpty(a2)) {
            bundle.putInt(ParamConst.TV_CHANNEL_SHIFT_PLAY_REQ_AUTHID, Integer.valueOf(a2).intValue());
        } else {
            bundle.putInt(ParamConst.TV_CHANNEL_SHIFT_PLAY_REQ_AUTHID, -1);
        }
        String c2 = dVar2.c();
        Channel channel = null;
        ArrayList<Channel> b2 = i.d().b();
        int size = b2.size();
        while (true) {
            if (i < size) {
                if (b2.get(i).getChannelcode().equals(c2) && b2.get(i).getColumncode().equals(dVar2.e())) {
                    channel = b2.get(i);
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        if (channel != null) {
            bundle.putString("poster_image", channel.getPosterimage());
            bundle.putString("prevue_name", dVar2.m());
            bundle.putString("tv_name", channel.getChannelname() + " " + channel.getMixno());
            bundle.putString("tv_id", dVar2.c());
            bundle.putString("supportTimeShift", channel.getSupporttimeshift());
        }
        bundle.putString(ParamConst.UPDATE_VERSION_RSP_URL, dVar2.k());
        bundle.putString("isprotection", dVar2.h());
        bundle.putString("contentcode", dVar2.l());
        bundle.putString("ratingid", dVar2.o());
        bundle.putString("productVIP", dVar2.n());
        LogEx.d(f, "play tvod contentcode is " + dVar2.l());
        String b3 = dVar2.b();
        bundle.putString("prevuebegintime", b3);
        String g = dVar2.g();
        bundle.putString("prevueendtime", g);
        bundle.putString(ParamConst.NPVR_QUERY_RSP_DURATION, x.c(b3, "yyyy.MM.dd HH:mm:ss", "HH:mm", 1) + "-" + x.c(g, "yyyy.MM.dd HH:mm:ss", "HH:mm", 1));
        String p = dVar2.p();
        bundle.putString("playuri4dlna", com.zte.iptvclient.android.mobile.h.a.b.a(dVar2.l(), c2, p, x.c(b3, "yyyy.MM.dd HH:mm:ss", "yyyyMMddHHmmss", 1), x.c(g, "yyyy.MM.dd HH:mm:ss", "yyyyMMddHHmmss", 1)));
        bundle.putString("telecomcode", p);
        bundle.putString("auth_contenttype", "4");
        bundle.putString("cmsid", dVar2.d());
        bundle.putString("physicalcontentid", dVar2.j());
        if (fVar != null) {
            bundle.putString("programname", fVar.e());
        }
        j jVar = new j();
        jVar.b(dVar2.c());
        jVar.a(dVar2.e());
        jVar.c("1");
        if (dVar != null) {
            dVar.e(bundle);
            return;
        }
        if (fVar != null) {
            bundle.putString("bookmark_breakpoint", fVar.b());
        }
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.putExtra("fromActivityName", "MultiPlayActivity");
        intent.setClass(this.f5148c, VOPlayerActivity.class);
        intent.addFlags(268435456);
        this.f5148c.startActivity(intent);
    }

    public void a(Activity activity, int i, com.zte.iptvclient.android.common.javabean.f fVar) {
        this.f5148c = activity;
        VDHLayout vDHLayout = (VDHLayout) activity.findViewById(R.id.multi_play_container);
        FrameLayout frameLayout = new FrameLayout(activity);
        frameLayout.setPadding(5, 5, 5, 5);
        frameLayout.setId(i);
        frameLayout.setTag(R.id.multi_player_tag1, fVar);
        vDHLayout.addView(frameLayout);
        vDHLayout.a(frameLayout);
        String c2 = fVar.c();
        com.zte.iptvclient.android.common.player.k.d dVar = new com.zte.iptvclient.android.common.player.k.d();
        frameLayout.setTag(R.id.multi_player_tag2, dVar);
        dVar.a(fVar);
        dVar.a(new C0157b(dVar));
        this.f5146a.add(dVar);
        r b2 = ((SupportActivity) activity).getSupportFragmentManager().b();
        b2.a(i, dVar);
        b2.b();
        if (TextUtils.equals(c2, "1")) {
            b(fVar, false, dVar);
            return;
        }
        if (TextUtils.equals(c2, "0")) {
            a(fVar, dVar);
        } else if (TextUtils.equals(c2, "2")) {
            if (!TextUtils.isEmpty(fVar.h())) {
                a(fVar);
            }
            a(fVar, false, dVar);
        }
    }

    private void a(com.zte.iptvclient.android.common.javabean.f fVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("contentcode", fVar.g());
        hashMap.put("breakpoint", String.valueOf(fVar.a()));
        hashMap.put("columncode", fVar.f());
        hashMap.put("bookmarktype", "4");
        com.zte.iptvclient.android.common.f.b.c.c(hashMap);
    }

    public void a(com.zte.iptvclient.android.common.javabean.f fVar, boolean z, com.zte.iptvclient.android.common.player.k.d dVar) {
        if (dVar == null) {
            Activity activity = this.f5148c;
            if (activity instanceof SupportActivity) {
                ((SupportActivity) activity).q();
            }
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("programcode", fVar.d());
        if (!TextUtils.isEmpty(fVar.h())) {
            hashMap.put("programtype", "10");
            hashMap.put("seriesprogramcode", fVar.h());
            hashMap.put("authtype", "0");
        } else {
            hashMap.put("programtype", "1");
        }
        hashMap.put("recommendtype", z ? "1" : "0");
        hashMap.put("isquerybookmark", "1");
        new SDKPlayMgr().getMultiDefinitionUrl(hashMap, new c(fVar, dVar));
    }

    private void a(com.zte.iptvclient.android.common.javabean.f fVar, com.zte.iptvclient.android.common.player.k.d dVar) {
        if (dVar == null) {
            Activity activity = this.f5148c;
            if (activity instanceof SupportActivity) {
                ((SupportActivity) activity).q();
            }
        }
        ArrayList arrayList = new ArrayList();
        SDKChannelMgr sDKChannelMgr = new SDKChannelMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("channelcode", fVar.d());
        sDKChannelMgr.getChannelDetailWithURl(hashMap, new e(arrayList, dVar, fVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<com.zte.iptvclient.android.common.javabean.models.c> arrayList, com.zte.iptvclient.android.common.player.k.d dVar, com.zte.iptvclient.android.common.javabean.f fVar) {
        com.zte.iptvclient.android.mobile.download.helper.a.n().a((Boolean) true);
        Bundle bundle = new Bundle();
        com.zte.iptvclient.android.common.javabean.models.c cVar = arrayList.get(0);
        bundle.putString("tv_name", cVar.e());
        bundle.putString("programname", cVar.l());
        bundle.putString("isprotection", cVar.h());
        bundle.putString("supportTimeShift", cVar.q());
        bundle.putString(ParamConst.CHANNEL_INFO_RSP_TSAVAILABLE, cVar.r());
        bundle.putString("playuri4dlna", com.zte.iptvclient.android.mobile.h.a.b.b(cVar.i(), cVar.p(), cVar.d(), cVar.f()));
        bundle.putString("telecomcode", cVar.p());
        bundle.putString("poster_image", cVar.k());
        bundle.putInt(ParamConst.TV_CHANNEL_SHIFT_PLAY_REQ_AUTHID, !TextUtils.isEmpty(cVar.c()) ? Integer.valueOf(cVar.c()).intValue() : -1);
        bundle.putString("contentcode", cVar.d());
        bundle.putString("channelcode", cVar.d());
        bundle.putString("ratingid", cVar.n());
        bundle.putString(ParamConst.UPDATE_VERSION_RSP_URL, cVar.j());
        bundle.putString("productVIP", cVar.m());
        if (fVar != null) {
            bundle.putString("programname", fVar.e());
        }
        LogEx.d(f, "play tv contentcode is " + cVar.d());
        Iterator<com.zte.iptvclient.android.common.javabean.models.c> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            com.zte.iptvclient.android.common.javabean.models.c next = it2.next();
            String j = next.j();
            if (TextUtils.equals(next.g(), "1")) {
                if (TextUtils.isEmpty(j)) {
                    j = "";
                }
                bundle.putString("url_sd", j);
            } else if (TextUtils.equals(next.g(), "2")) {
                if (TextUtils.isEmpty(j)) {
                    j = "";
                }
                bundle.putString("url_sd_h", j);
            } else if (TextUtils.equals(next.g(), "4")) {
                if (TextUtils.isEmpty(j)) {
                    j = "";
                }
                bundle.putString("url_hd", j);
            } else if (TextUtils.equals(next.g(), "8")) {
                if (TextUtils.isEmpty(j)) {
                    j = "";
                }
                bundle.putString("url_480p", j);
            } else if (TextUtils.equals(next.g(), GlobalConst.WINPHONE_CLIENT)) {
                if (TextUtils.isEmpty(j)) {
                    j = "";
                }
                bundle.putString("url_720p", j);
            } else if (TextUtils.equals(next.g(), GlobalConst.ANDRIODSTB_CLIENT)) {
                if (TextUtils.isEmpty(j)) {
                    j = "";
                }
                bundle.putString("url_1280p", j);
            } else {
                bundle.putString("url_sd", "");
            }
        }
        bundle.putBoolean("Is_Dash_URL", com.zte.iptvclient.android.common.k.i.c());
        bundle.putString("auth_contenttype", "2");
        com.zte.iptvclient.android.common.player.j.i iVar = new com.zte.iptvclient.android.common.player.j.i();
        iVar.b(cVar.d());
        iVar.a(cVar.f());
        if (dVar != null) {
            dVar.e(bundle);
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.putExtra("fromActivityName", "MultiPlayActivity");
        intent.setClass(this.f5148c, VOPlayerActivity.class);
        intent.addFlags(268435456);
        this.f5148c.startActivity(intent);
    }

    public void b(boolean z) {
        for (int i = 0; i < this.f5146a.size(); i++) {
            if (z) {
                this.f5146a.get(i).d(false);
                this.f5146a.get(i).s0();
            } else {
                this.f5146a.get(i).W0();
                this.f5146a.get(i).d(true);
            }
        }
    }

    public com.zte.iptvclient.android.common.player.k.d a() {
        return this.f5147b;
    }

    public void a(boolean z) {
        for (int i = 0; i < this.f5146a.size(); i++) {
            if (z) {
                this.f5146a.get(i).d(false);
                if (this.f5146a.get(i).f0) {
                    this.f5146a.get(i).s0();
                } else {
                    this.f5146a.get(i).t0();
                }
            } else {
                this.f5146a.get(i).d(false);
                this.f5146a.get(i).t0();
            }
        }
    }

    public void a(com.zte.iptvclient.android.common.player.k.d dVar, int i) {
        for (int i2 = 0; i2 < this.f5146a.size(); i2++) {
            if (this.f5146a.get(i2).equals(dVar)) {
                this.f5146a.get(i2).j(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadTask a(String str, ArrayList<DownloadTask> arrayList) {
        if (arrayList != null && !TextUtils.isEmpty(str)) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).videoInfo.get("taskID").startsWith(str)) {
                    return arrayList.get(i);
                }
            }
        }
        return null;
    }

    public void a(int i) {
        com.zte.iptvclient.android.common.player.k.d dVar = (com.zte.iptvclient.android.common.player.k.d) ((VDHLayout) this.f5148c.findViewById(R.id.multi_play_container)).getChildAt(i).getTag(R.id.multi_player_tag2);
        for (int i2 = 0; i2 < this.f5146a.size(); i2++) {
            if (dVar.equals(this.f5146a.get(i2))) {
                this.f5146a.get(i2).b(false);
            } else {
                this.f5146a.get(i2).b(true);
            }
        }
    }
}
