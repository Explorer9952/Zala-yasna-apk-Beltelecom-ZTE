package com.zte.iptvclient.android.mobile.i.b;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.internal.ServerProtocol;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.video.androidsdk.download.Linstener.DownloadListReturnListener;
import com.video.androidsdk.download.SDKDownloadMgr;
import com.video.androidsdk.download.bean.DownloadTask;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.comm.ParamConst;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshFooter;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshHeader;
import com.zte.iptvclient.android.common.netstate.NetWorkUtil;
import com.zte.iptvclient.android.common.player.j.l;
import com.zte.iptvclient.android.mobile.i.a.b;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;

/* compiled from: ATDownloadedFragment.java */
/* loaded from: classes.dex */
public class a extends com.zte.iptvclient.android.mobile.i.b.b implements b.InterfaceC0274b {
    private SmartRefreshLayout C;
    private RelativeLayout D;
    private TextView E;
    private Activity p;
    private GridView q;
    private com.zte.iptvclient.android.mobile.i.b.c r;
    private ArrayList<DownloadTask> t;
    private com.zte.iptvclient.android.mobile.i.a.b u;
    private com.zte.iptvclient.android.common.j.h v;
    private DownloadTask w;
    private ArrayList<DownloadTask> s = new ArrayList<>();
    private String x = "";
    private long y = 0;
    private com.zte.iptvclient.android.common.player.f z = null;
    private boolean A = false;
    private boolean B = true;
    private Handler F = new HandlerC0277a();
    private DownloadListReturnListener G = new c();

    /* compiled from: ATDownloadedFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.i.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class HandlerC0277a extends Handler {
        HandlerC0277a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 11) {
                a.this.O();
                return;
            }
            if (i == 12) {
                a.this.u.b();
                a.this.O();
            } else {
                if (i != 15) {
                    return;
                }
                a aVar = a.this;
                aVar.b((ArrayList<DownloadTask>) aVar.t);
                if (a.this.v.b0().booleanValue()) {
                    LogEx.d("ATDownloadedFragment", "Online Mode,Begin to update order info");
                    a.this.r.J();
                }
            }
        }
    }

    /* compiled from: ATDownloadedFragment.java */
    /* loaded from: classes.dex */
    class b implements com.scwang.smartrefresh.layout.d.c {
        b() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(com.scwang.smartrefresh.layout.a.h hVar) {
            if (!((com.zte.iptvclient.android.mobile.i.b.c) a.this.getParentFragment()).W) {
                a.this.F.sendEmptyMessage(11);
            } else {
                hVar.c(2000);
            }
        }
    }

    /* compiled from: ATDownloadedFragment.java */
    /* loaded from: classes.dex */
    class c implements DownloadListReturnListener {
        c() {
        }

        @Override // com.video.androidsdk.download.Linstener.DownloadListReturnListener
        public void returnDownloadTaskList(String str, int i, String str2, ArrayList<DownloadTask> arrayList) {
            LogEx.d("ATDownloadedFragment", "status = " + str + ", errorCode = " + i + ", errorMsg = " + str2 + ", arraylist = " + arrayList);
            a.this.t = arrayList;
            a.this.F.sendEmptyMessage(15);
        }
    }

    private boolean Q() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.y <= 2000) {
            LogEx.w("ATDownloadedFragment", "Operate limit,less than 2000(ms)!");
            return true;
        }
        this.y = currentTimeMillis;
        return false;
    }

    private void R() {
        com.zte.iptvclient.android.mobile.i.a.b bVar = new com.zte.iptvclient.android.mobile.i.a.b(this.p, this, this.s);
        this.u = bVar;
        this.q.setAdapter((ListAdapter) bVar);
    }

    @Override // com.zte.iptvclient.android.mobile.i.b.b
    public void I() {
        this.u.a();
    }

    @Override // com.zte.iptvclient.android.mobile.i.b.b
    public boolean J() {
        return this.A;
    }

    @Override // com.zte.iptvclient.android.mobile.i.b.b
    public ArrayList<DownloadTask> K() {
        return this.u.c();
    }

    @Override // com.zte.iptvclient.android.mobile.i.b.b
    public ArrayList<DownloadTask> L() {
        return this.s;
    }

    @Override // com.zte.iptvclient.android.mobile.i.b.b
    public void M() {
        this.u.d();
    }

    @Override // com.zte.iptvclient.android.mobile.i.b.b
    public void N() {
        this.u.e();
    }

    public void O() {
        if (!this.B) {
            SDKDownloadMgr.getInstance().getDownloadList("0", 2, this.G);
        } else {
            SDKDownloadMgr.getInstance().getDownloadList("0", 1, this.G);
        }
    }

    public boolean P() {
        return this.s.size() == 0;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (com.zte.iptvclient.android.mobile.download.helper.a.n().k() == 3) {
            this.B = false;
        } else {
            this.B = true;
        }
        R();
        O();
    }

    @Override // com.zte.fragmentlib.publicbaseclass.skinloader.a, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.p = (Activity) context;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.v = new com.zte.iptvclient.android.common.j.h(this.p.getApplicationContext());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.at_download_list_fragment, (ViewGroup) null);
        this.C = (SmartRefreshLayout) inflate.findViewById(R.id.refreshLayout);
        this.q = (GridView) inflate.findViewById(R.id.gridview);
        if (BaseApp.a(this.h)) {
            this.q.setNumColumns(6);
        }
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.rl_empty);
        this.D = relativeLayout;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout.findViewById(R.id.ll_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.D.findViewById(R.id.img_pullrefresh_icon));
        com.zte.iptvclient.common.uiframe.f.a(this.D.findViewById(R.id.txt_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.D.findViewById(R.id.refresh_image));
        this.D.setVisibility(8);
        TextView textView = (TextView) this.D.findViewById(R.id.txt_pullrefresh);
        this.E = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.no_video_has_been_cached_yet));
        this.C.a(new DefaultRefreshHeader(this.h));
        this.C.a(new DefaultRefreshFooter(this.h));
        this.C.a(true);
        this.C.c(false);
        SmartRefreshLayout smartRefreshLayout = this.C;
        SupportActivity supportActivity = this.h;
        smartRefreshLayout.e(com.zte.iptvclient.android.common.k.g.a(supportActivity, supportActivity.getResources().getDimension(R.dimen.refresh_footer_height)));
        SmartRefreshLayout smartRefreshLayout2 = this.C;
        SupportActivity supportActivity2 = this.h;
        smartRefreshLayout2.f(com.zte.iptvclient.android.common.k.g.a(supportActivity2, supportActivity2.getResources().getDimension(R.dimen.refresh_header_height)));
        this.C.a(new b());
        return inflate;
    }

    private Boolean d(DownloadTask downloadTask) {
        return com.zte.iptvclient.android.mobile.download.helper.c.c.a(downloadTask);
    }

    private void e(DownloadTask downloadTask) {
        if (String.valueOf(1).equals(downloadTask.videoInfo.get("downLoadType"))) {
            String playURL = SDKDownloadMgr.getInstance().getPlayURL(1, downloadTask);
            LogEx.d("ATDownloadedFragment", "Prepare to Local Play,url:" + playURL);
            if (downloadTask.videoInfo.get("isDrm").equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                this.w = downloadTask;
                this.x = playURL;
                LogEx.d("ATDownloadedFragment", "DRM VALIDATED, BEGIN TO PLAY");
                a(this.x, this.w);
                return;
            }
            LogEx.d("ATDownloadedFragment", "NO DRM NEED, BEGIN TO PLAY");
            a(playURL, downloadTask);
            return;
        }
        LogEx.d("ATDownloadedFragment", "BEGIN TO HC100 PLAY");
        String playURL2 = SDKDownloadMgr.getInstance().getPlayURL(2, downloadTask);
        if (TextUtils.isEmpty(playURL2)) {
            return;
        }
        a(playURL2, downloadTask);
    }

    @Override // com.zte.iptvclient.android.mobile.i.b.b
    public void c(boolean z) {
        this.B = z;
        if (!z) {
            SDKDownloadMgr.getInstance().getDownloadList("0", 2, this.G);
        } else {
            SDKDownloadMgr.getInstance().getDownloadList("0", 1, this.G);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ArrayList<DownloadTask> arrayList) {
        this.s.clear();
        if (arrayList != null && !arrayList.isEmpty()) {
            this.s.addAll(arrayList);
        }
        com.zte.iptvclient.android.mobile.i.a.b bVar = this.u;
        if (bVar != null) {
            bVar.a(this.s);
            this.u.notifyDataSetChanged();
        }
        this.C.a();
        if (this.s.size() == 0) {
            this.D.setVisibility(0);
            this.q.setVisibility(8);
        } else {
            this.D.setVisibility(8);
            this.q.setVisibility(0);
        }
        com.zte.iptvclient.android.mobile.i.b.c cVar = this.r;
        if (cVar != null) {
            cVar.d(0);
        }
    }

    public void a(com.zte.iptvclient.android.mobile.i.b.c cVar) {
        this.r = cVar;
    }

    @Override // com.zte.iptvclient.android.mobile.i.b.b
    public void d(boolean z) {
        this.A = z;
    }

    @Override // com.zte.iptvclient.android.mobile.i.a.b.InterfaceC0274b
    public void a(DownloadTask downloadTask) {
        if (Q()) {
            return;
        }
        if (d(downloadTask).booleanValue()) {
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.sorry_order_has_expired);
        } else {
            LogEx.d("ATDownloadedFragment", "Video is not expired,prepare to play");
            e(downloadTask);
        }
    }

    @Override // com.zte.iptvclient.android.mobile.i.b.b
    public void d(int i) {
        this.F.sendEmptyMessage(i);
    }

    private void a(String str, DownloadTask downloadTask) {
        com.zte.iptvclient.android.mobile.download.helper.a.n().a((Boolean) true);
        String str2 = downloadTask.videoInfo.get("videoName");
        String str3 = downloadTask.videoInfo.get("contentCode");
        String str4 = downloadTask.videoInfo.get("columnCode");
        String str5 = downloadTask.videoInfo.get("programcode");
        LogEx.d("ATDownloadedFragment", "Now Begin to open the Player. Title:" + str2 + "url:" + str);
        Bundle bundle = new Bundle();
        bundle.putBoolean("isfromdownloaded", true);
        bundle.putString(ParamConst.UPDATE_VERSION_RSP_URL, str);
        bundle.putString("programname", str2);
        bundle.putString("programcode", str5);
        if (String.valueOf(1).equals(downloadTask.videoInfo.get("downLoadType"))) {
            bundle.putString("url_nav", str);
        } else {
            bundle.putString("url_hc", str);
        }
        String str6 = downloadTask.videoInfo.get("taskDefinition");
        String str7 = downloadTask.videoId;
        String replace = !TextUtils.isEmpty(str6) ? str7.replace(str6, "") : str7;
        bundle.putString("taskID", downloadTask.videoInfo.get("taskID"));
        bundle.putString("playuri4dlna", com.zte.iptvclient.android.mobile.h.a.b.b(str4, replace, "1", str3, str2, downloadTask.videoInfo.get("telecomCode")));
        bundle.putString("auth_contenttype", "1");
        bundle.putString("telecomcode", downloadTask.videoInfo.get("telecomCode"));
        bundle.putString("isNotNeedToSwitch", "1");
        this.z = new com.zte.iptvclient.android.common.player.f();
        l lVar = new l();
        lVar.b(str3);
        lVar.a(str4);
        if (NetWorkUtil.c(this.p)) {
            this.z.a(false);
        } else {
            this.z.a(false);
        }
        this.z.b(false);
        if (com.zte.iptvclient.android.common.f.b.b.j().e()) {
            com.zte.iptvclient.android.common.f.b.b.j().h();
        }
        this.z.a(lVar, bundle, this.p);
    }

    @Override // com.zte.iptvclient.android.mobile.i.b.b
    public void b(boolean z) {
        ((com.zte.iptvclient.android.mobile.i.b.c) getParentFragment()).b(z);
        this.A = z;
    }

    @Override // com.zte.iptvclient.android.mobile.i.b.b
    public void e(boolean z) {
        this.u.a(z);
    }

    @Override // com.zte.iptvclient.android.mobile.i.b.b
    public void e(int i) {
        ((com.zte.iptvclient.android.mobile.i.b.c) getParentFragment()).f(i);
    }

    @Override // com.zte.iptvclient.android.mobile.i.a.b.InterfaceC0274b
    public void b(DownloadTask downloadTask) {
        ((com.zte.iptvclient.android.mobile.i.b.c) getParentFragment()).d(downloadTask);
    }
}
