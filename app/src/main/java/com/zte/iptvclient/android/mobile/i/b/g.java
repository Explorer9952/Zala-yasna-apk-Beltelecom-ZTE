package com.zte.iptvclient.android.mobile.i.b;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.internal.ServerProtocol;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.video.androidsdk.download.Linstener.DownloadListReturnListener;
import com.video.androidsdk.download.Linstener.OnTaskOperReturnListener;
import com.video.androidsdk.download.SDKDownloadMgr;
import com.video.androidsdk.download.bean.DownloadTask;
import com.video.androidsdk.log.LogEx;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshFooter;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshHeader;
import com.zte.iptvclient.android.common.k.t;
import com.zte.iptvclient.android.mobile.download.service.DownloadNotifyService;
import com.zte.iptvclient.android.mobile.i.a.d;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: DownloadingFragment.java */
/* loaded from: classes.dex */
public class g extends com.zte.iptvclient.android.mobile.i.b.b implements d.b {
    private ListView p;
    private com.zte.iptvclient.android.mobile.i.b.c q;
    private ArrayList<DownloadTask> s;
    private com.zte.iptvclient.android.mobile.i.a.d t;
    private SmartRefreshLayout u;
    private RelativeLayout v;
    private TextView w;
    private ArrayList<DownloadTask> r = new ArrayList<>();
    private boolean x = false;
    private boolean y = true;
    private Handler z = new a();
    private DownloadListReturnListener A = new c();
    private OnTaskOperReturnListener B = new e();

    /* compiled from: DownloadingFragment.java */
    /* loaded from: classes.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 11) {
                g.this.P();
                return;
            }
            if (i == 12) {
                g.this.t.b();
                g.this.P();
            } else {
                if (i != 15) {
                    return;
                }
                g gVar = g.this;
                gVar.b((ArrayList<DownloadTask>) gVar.s);
            }
        }
    }

    /* compiled from: DownloadingFragment.java */
    /* loaded from: classes.dex */
    class b implements com.scwang.smartrefresh.layout.d.c {
        b() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(com.scwang.smartrefresh.layout.a.h hVar) {
            if (!((com.zte.iptvclient.android.mobile.i.b.c) g.this.getParentFragment()).W) {
                g.this.z.sendEmptyMessage(11);
            } else {
                hVar.c(2000);
            }
        }
    }

    /* compiled from: DownloadingFragment.java */
    /* loaded from: classes.dex */
    class c implements DownloadListReturnListener {
        c() {
        }

        @Override // com.video.androidsdk.download.Linstener.DownloadListReturnListener
        public void returnDownloadTaskList(String str, int i, String str2, ArrayList<DownloadTask> arrayList) {
            LogEx.d("DownloadingFragment", "status = " + str + ", errorCode = " + i + ", errorMsg = " + str2 + ", arraylist = " + arrayList);
            g.this.s = arrayList;
            g.this.z.sendEmptyMessage(15);
        }
    }

    /* compiled from: DownloadingFragment.java */
    /* loaded from: classes.dex */
    class d implements t.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ArrayList f6543a;

        d(ArrayList arrayList) {
            this.f6543a = arrayList;
        }

        @Override // com.zte.iptvclient.android.common.k.t.e
        public void a() {
        }

        @Override // com.zte.iptvclient.android.common.k.t.e
        public void b() {
            g.this.c((ArrayList<DownloadTask>) this.f6543a);
        }
    }

    /* compiled from: DownloadingFragment.java */
    /* loaded from: classes.dex */
    class e implements OnTaskOperReturnListener {
        e() {
        }

        @Override // com.video.androidsdk.download.Linstener.OnTaskOperReturnListener
        public void onTaskOperReturn(String str, String str2, String str3) {
            ((com.zte.fragmentlib.b) g.this).h.startService(new Intent(g.this.getActivity(), (Class<?>) DownloadNotifyService.class));
            g.this.z.sendEmptyMessage(11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadingFragment.java */
    /* loaded from: classes.dex */
    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f6546a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f6547b;

        f(String str, String str2) {
            this.f6546a = str;
            this.f6547b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.zte.iptvclient.android.common.customview.a.a.a.a aVar = new com.zte.iptvclient.android.common.customview.a.a.a.a(((com.zte.fragmentlib.b) g.this).h);
            aVar.setTitle(this.f6546a);
            aVar.a(this.f6547b);
            aVar.b(R.string.common_ok, null);
            aVar.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        if (!this.y) {
            SDKDownloadMgr.getInstance().getDownloadList("1", 2, this.A);
        } else {
            SDKDownloadMgr.getInstance().getDownloadList("1", 1, this.A);
        }
    }

    private void Q() {
        com.zte.iptvclient.android.mobile.i.a.d dVar = new com.zte.iptvclient.android.mobile.i.a.d(this.h, this, this.r);
        this.t = dVar;
        this.p.setAdapter((ListAdapter) dVar);
    }

    @Override // com.zte.iptvclient.android.mobile.i.b.b
    public void I() {
        this.t.a();
    }

    @Override // com.zte.iptvclient.android.mobile.i.b.b
    public boolean J() {
        return this.x;
    }

    @Override // com.zte.iptvclient.android.mobile.i.b.b
    public ArrayList<DownloadTask> K() {
        return this.t.c();
    }

    @Override // com.zte.iptvclient.android.mobile.i.b.b
    public ArrayList<DownloadTask> L() {
        return this.r;
    }

    @Override // com.zte.iptvclient.android.mobile.i.b.b
    public void M() {
        this.t.d();
    }

    @Override // com.zte.iptvclient.android.mobile.i.b.b
    public void N() {
        this.t.e();
    }

    public boolean O() {
        return this.r.size() == 0;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (com.zte.iptvclient.android.mobile.download.helper.a.n().k() == 3) {
            this.y = false;
        } else {
            this.y = true;
        }
        Q();
        P();
    }

    @Override // com.zte.fragmentlib.publicbaseclass.skinloader.a, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.download_list_fragment, (ViewGroup) null);
        this.u = (SmartRefreshLayout) inflate.findViewById(R.id.refreshLayout);
        this.p = (ListView) inflate.findViewById(R.id.list);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.rl_empty);
        this.v = relativeLayout;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout.findViewById(R.id.ll_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.v.findViewById(R.id.img_pullrefresh_icon));
        com.zte.iptvclient.common.uiframe.f.a(this.v.findViewById(R.id.txt_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.v.findViewById(R.id.refresh_image));
        this.v.setVisibility(8);
        TextView textView = (TextView) this.v.findViewById(R.id.txt_pullrefresh);
        this.w = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.no_video_has_been_cached_yet));
        this.u.a(new DefaultRefreshHeader(this.h));
        this.u.a(new DefaultRefreshFooter(this.h));
        SmartRefreshLayout smartRefreshLayout = this.u;
        SupportActivity supportActivity = this.h;
        smartRefreshLayout.e(com.zte.iptvclient.android.common.k.g.a(supportActivity, supportActivity.getResources().getDimension(R.dimen.refresh_footer_height)));
        SmartRefreshLayout smartRefreshLayout2 = this.u;
        SupportActivity supportActivity2 = this.h;
        smartRefreshLayout2.f(com.zte.iptvclient.android.common.k.g.a(supportActivity2, supportActivity2.getResources().getDimension(R.dimen.refresh_header_height)));
        this.u.a(true);
        this.u.a(new b());
        return inflate;
    }

    @Override // com.zte.iptvclient.android.mobile.i.b.b
    public void d(boolean z) {
        this.x = z;
    }

    @Override // com.zte.iptvclient.android.mobile.i.b.b
    public void e(boolean z) {
        this.t.a(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ArrayList<DownloadTask> arrayList) {
        this.r.clear();
        if (arrayList != null && !arrayList.isEmpty()) {
            this.r.addAll(arrayList);
        }
        com.zte.iptvclient.android.mobile.i.a.d dVar = this.t;
        if (dVar != null) {
            dVar.a(this.r);
            this.t.notifyDataSetChanged();
        }
        this.u.a();
        if (this.r.size() == 0) {
            this.v.setVisibility(0);
            this.p.setVisibility(8);
        } else {
            this.v.setVisibility(8);
            this.p.setVisibility(0);
        }
        com.zte.iptvclient.android.mobile.i.b.c cVar = this.q;
        if (cVar != null) {
            cVar.d(1);
        }
    }

    public void a(com.zte.iptvclient.android.mobile.i.b.c cVar) {
        this.q = cVar;
    }

    @Override // com.zte.iptvclient.android.mobile.i.b.b
    public void c(boolean z) {
        this.y = z;
        if (!z) {
            SDKDownloadMgr.getInstance().getDownloadList("1", 2, this.A);
        } else {
            SDKDownloadMgr.getInstance().getDownloadList("1", 1, this.A);
        }
    }

    @Override // com.zte.iptvclient.android.mobile.i.b.b
    public void d(int i) {
        this.z.sendEmptyMessage(i);
    }

    @Override // com.zte.iptvclient.android.mobile.i.b.b
    public void e(int i) {
        ((com.zte.iptvclient.android.mobile.i.b.c) getParentFragment()).f(i);
    }

    private void e(String str, String str2) {
        this.h.runOnUiThread(new f(str, str2));
    }

    public void a(List<Map<String, String>> list) {
        com.zte.iptvclient.android.mobile.i.a.d dVar = this.t;
        if (dVar != null) {
            dVar.a(list);
            this.t.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ArrayList<DownloadTask> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            if (!com.zte.iptvclient.android.mobile.download.helper.c.c.c(this.h.getApplicationContext())) {
                e(com.zte.iptvclient.android.common.i.a.a.a(R.string.commom_notice), com.zte.iptvclient.android.common.i.a.a.a(R.string.network_connection_failed));
                return;
            }
            if (com.zte.iptvclient.android.mobile.download.helper.a.n().k() == 1 && !com.zte.iptvclient.android.mobile.download.helper.c.b.o().booleanValue()) {
                e(com.zte.iptvclient.android.common.i.a.a.a(R.string.commom_notice), com.zte.iptvclient.android.common.i.a.a.a(R.string.storage_path_not_exist));
                return;
            }
            if (String.valueOf(1).equals(arrayList.get(0).videoInfo.get("downLoadType"))) {
                SDKDownloadMgr.getInstance().startDownload(arrayList, 1, this.B);
                arrayList.get(0).videoInfo.put("taskStatus", String.valueOf(2));
                arrayList.get(0).videoInfo.put("isHandStop", "false");
                SDKDownloadMgr.getInstance().updateTask(1, arrayList.get(0));
                return;
            }
            SDKDownloadMgr.getInstance().startDownload(arrayList, 2, this.B);
            return;
        }
        LogEx.w("DownloadingFragment", "task is null or empty.");
    }

    @Override // com.zte.iptvclient.android.mobile.i.b.b
    public void b(boolean z) {
        ((com.zte.iptvclient.android.mobile.i.b.c) getParentFragment()).b(z);
        this.x = z;
    }

    @Override // com.zte.iptvclient.android.mobile.i.a.d.b
    public void c(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        int intValue = Integer.valueOf(downloadTask.status).intValue();
        ArrayList<DownloadTask> arrayList = new ArrayList<>();
        arrayList.add(downloadTask);
        if (intValue != 1 && intValue != 2) {
            if (com.zte.iptvclient.android.mobile.download.helper.a.n().l().booleanValue()) {
                LogEx.d("DownloadingFragment", "In Offline Mode, can not resume download");
                e(com.zte.iptvclient.android.common.i.a.a.a(R.string.commom_notice), com.zte.iptvclient.android.common.i.a.a.a(R.string.offline_mode_login_to_continue));
                return;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.h.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                String typeName = activeNetworkInfo.getTypeName();
                if (typeName.equalsIgnoreCase("mobile")) {
                    t.a(this.h, com.zte.iptvclient.android.common.i.a.a.a(R.string.permit_2G_3G_network_download_confirm), new d(arrayList));
                    return;
                } else {
                    if (typeName.equalsIgnoreCase("WIFI")) {
                        c(arrayList);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (String.valueOf(1).equals(downloadTask.videoInfo.get("downLoadType"))) {
            SDKDownloadMgr.getInstance().pauseDownload(arrayList, 1, this.B);
            downloadTask.videoInfo.put("taskStatus", String.valueOf(-1));
            downloadTask.videoInfo.put("isHandStop", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            SDKDownloadMgr.getInstance().updateTask(1, downloadTask);
            return;
        }
        SDKDownloadMgr.getInstance().pauseDownload(arrayList, 2, this.B);
    }
}
