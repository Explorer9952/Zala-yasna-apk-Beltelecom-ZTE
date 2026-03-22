package com.zte.iptvclient.android.mobile.i.b;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.internal.ServerProtocol;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.download.Linstener.DownloadListReturnListener;
import com.video.androidsdk.download.Linstener.OnSpaceReturnListener;
import com.video.androidsdk.download.Linstener.OnTaskOperReturnListener;
import com.video.androidsdk.download.SDKDownloadMgr;
import com.video.androidsdk.download.bean.DownloadTask;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.comm.ParamConst;
import com.video.androidsdk.service.vod.SDKVodMgr;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.customview.a.a.e.f;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshFooter;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshHeader;
import com.zte.iptvclient.android.common.javabean.models.VideoDetailBean;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.mobile.i.a.c;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: DownloadedTVSeriesFragment.java */
/* loaded from: classes.dex */
public class f extends com.zte.iptvclient.android.mobile.i.b.b implements c.b {
    private RelativeLayout B;
    private RelativeLayout C;
    private FrameLayout D;
    private FrameLayout E;
    private FrameLayout F;
    private TextView G;
    private TextView J;
    private TextView K;
    private TextView L;
    private TextView M;
    private TextView N;
    private ImageView O;
    private ImageView P;
    private com.zte.iptvclient.android.mobile.i.a.c R;
    private ProgressBar S;
    private ProgressBar T;
    private SmartRefreshLayout U;
    private RelativeLayout V;
    private ArrayList<DownloadTask> a0;
    private Button p;
    private ListView q;
    private ArrayList<DownloadTask> s;
    private DownloadTask t;
    private Context x;
    private TextView y;
    private TextView z;
    private ArrayList<DownloadTask> r = new ArrayList<>();
    private String u = "";
    private int v = 0;
    private com.zte.iptvclient.android.common.player.f w = null;
    private String A = "";
    private boolean Q = false;
    private boolean W = false;
    private String X = "";
    private String Y = "";
    private boolean Z = false;
    private int b0 = 0;
    private boolean c0 = true;
    private Handler d0 = new e();
    private DownloadListReturnListener e0 = new a();
    private OnTaskOperReturnListener f0 = new c();

    /* compiled from: DownloadedTVSeriesFragment.java */
    /* loaded from: classes.dex */
    class a implements DownloadListReturnListener {
        a() {
        }

        @Override // com.video.androidsdk.download.Linstener.DownloadListReturnListener
        public void returnDownloadTaskList(String str, int i, String str2, ArrayList<DownloadTask> arrayList) {
            LogEx.d("DownloadedTVSeriesFragment", "status = " + str + ", errorCode = " + i + ", errorMsg = " + str2 + ", arraylist = " + arrayList);
            f.this.s = arrayList;
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    f.this.f(arrayList.get(i2));
                }
            }
            f.this.d0.sendEmptyMessage(15);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadedTVSeriesFragment.java */
    /* loaded from: classes.dex */
    public class b implements f.c {
        b() {
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
        public void a() {
            f.this.Z = true;
            f fVar = f.this;
            fVar.b((ArrayList<DownloadTask>) fVar.a0);
            f.this.R.a();
            f.this.f(false);
            f.this.d0.sendEmptyMessage(15);
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
        public void b() {
        }
    }

    /* compiled from: DownloadedTVSeriesFragment.java */
    /* loaded from: classes.dex */
    class c implements OnTaskOperReturnListener {
        c() {
        }

        @Override // com.video.androidsdk.download.Linstener.OnTaskOperReturnListener
        public void onTaskOperReturn(String str, String str2, String str3) {
            LogEx.d("DownloadedTVSeriesFragment", " strErrorCode = " + str + " strErrorMsg = " + str2 + " strResposeInfo = " + str3);
            f.this.d0.sendEmptyMessage(12);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadedTVSeriesFragment.java */
    /* loaded from: classes.dex */
    public class d implements OnSpaceReturnListener {

        /* compiled from: DownloadedTVSeriesFragment.java */
        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f6528a;

            a(String str) {
                this.f6528a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                f.this.y.setText(this.f6528a);
                f.this.z.setText(this.f6528a);
            }
        }

        d() {
        }

        @Override // com.video.androidsdk.download.Linstener.OnSpaceReturnListener
        public void onSpaceReturn(String str, String str2, HashMap<String, String> hashMap) {
            LogEx.d("DownloadedTVSeriesFragment", "s = " + str + ", s1 = " + str2 + ", map = " + hashMap);
            try {
                String str3 = hashMap.get(DownloadConstant.GETSPACE_RESULT_MAP_KEY_TOTALSPACE);
                String str4 = hashMap.get(DownloadConstant.GETSPACE_RESULT_MAP_KEY_FREESPACE);
                LogEx.d("DownloadedTVSeriesFragment", "totalSize = " + str3 + ", freeSize = " + str4);
                ((Activity) f.this.x).runOnUiThread(new a(f.this.x.getResources().getString(R.string.download_filter_stb) + "：   " + f.this.x.getResources().getString(R.string.storge_space_total) + str3 + "/" + f.this.x.getResources().getString(R.string.storge_space_left) + str4));
            } catch (Exception e) {
                LogEx.e("DownloadedTVSeriesFragment", "Get HC100 storage size error.");
                e.printStackTrace();
            }
        }
    }

    /* compiled from: DownloadedTVSeriesFragment.java */
    /* loaded from: classes.dex */
    class e extends Handler {
        e() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i != 11) {
                if (i == 12) {
                    f.this.Z = false;
                    f.this.e(0);
                    f.this.v = 0;
                    f.this.S.setProgress(f.this.v);
                    f.this.T.setProgress(f.this.v);
                    f fVar = f.this;
                    fVar.h(fVar.c0);
                    f.this.g(false);
                    f.this.R.b();
                    f.this.R();
                    return;
                }
                if (i != 15) {
                    return;
                }
            }
            f fVar2 = f.this;
            fVar2.c((ArrayList<DownloadTask>) fVar2.s);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadedTVSeriesFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.i.b.f$f, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0280f implements View.OnClickListener {
        ViewOnClickListenerC0280f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.D();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadedTVSeriesFragment.java */
    /* loaded from: classes.dex */
    public class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.g(true);
            f.this.f(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadedTVSeriesFragment.java */
    /* loaded from: classes.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.g(true);
            f.this.f(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadedTVSeriesFragment.java */
    /* loaded from: classes.dex */
    public class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.g(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadedTVSeriesFragment.java */
    /* loaded from: classes.dex */
    public class j implements View.OnClickListener {
        j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.r.size() == 0) {
                return;
            }
            if (f.this.W) {
                f.this.f(false);
                f.this.R.a();
            } else {
                f.this.f(true);
                f.this.R.d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadedTVSeriesFragment.java */
    /* loaded from: classes.dex */
    public class k implements View.OnClickListener {
        k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.Z) {
                return;
            }
            f.this.O();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadedTVSeriesFragment.java */
    /* loaded from: classes.dex */
    public class l implements com.scwang.smartrefresh.layout.d.c {
        l() {
        }

        @Override // com.scwang.smartrefresh.layout.d.c
        public void a(com.scwang.smartrefresh.layout.a.h hVar) {
            if (!f.this.Q) {
                f.this.d0.sendEmptyMessage(11);
            } else {
                hVar.c(2000);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadedTVSeriesFragment.java */
    /* loaded from: classes.dex */
    public class m implements SDKVodMgr.OnVodDetailWithUrlReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DownloadTask f6538a;

        m(f fVar, DownloadTask downloadTask) {
            this.f6538a = downloadTask;
        }

        @Override // com.video.androidsdk.service.vod.SDKVodMgr.OnVodDetailWithUrlReturnListener
        public void onVodDetailWithUrlReturn(String str, String str2, String str3) {
            LogEx.d("DownloadedTVSeriesFragment", "returncode : " + str + ", errormsg : " + str2 + ",data : " + str3);
            if (TextUtils.equals(str, "0")) {
                try {
                    if (str3.contains("},]}")) {
                        str3 = str3.replace("},]}", "}]}");
                    }
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        VideoDetailBean videoDetailBeanFromJSon = VideoDetailBean.getVideoDetailBeanFromJSon(jSONArray.getJSONObject(i));
                        if (videoDetailBeanFromJSon != null) {
                            String str4 = "1901.01.01 00:00:00";
                            if (TextUtils.equals(videoDetailBeanFromJSon.getAuth_returncode(), "0")) {
                                str4 = TextUtils.isEmpty(videoDetailBeanFromJSon.getExpiredtime()) ? "2099.12.31 00:00:00" : videoDetailBeanFromJSon.getExpiredtime();
                            }
                            this.f6538a.videoInfo.put("expiredDate", str4);
                        }
                    }
                    if (String.valueOf(1).equals(this.f6538a.videoInfo.get("downLoadType"))) {
                        SDKDownloadMgr.getInstance().updateTask(1, this.f6538a);
                    } else {
                        SDKDownloadMgr.getInstance().updateTask(2, this.f6538a);
                    }
                } catch (Exception e) {
                    LogEx.e("DownloadedTVSeriesFragment", e.getMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadedTVSeriesFragment.java */
    /* loaded from: classes.dex */
    public class n extends AsyncTask<String, String, String> {
        n() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String doInBackground(String... strArr) {
            return f.this.Q();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(String str) {
            if (f.this.x == null) {
                return;
            }
            f.this.y.setText(str);
            f.this.z.setText(str);
            f.this.S.setProgress(f.this.v);
            f.this.T.setProgress(f.this.v);
            super.onPostExecute(str);
        }
    }

    private void P() {
        if (this.x == null) {
            this.v = 0;
            this.y.setText(this.A);
            this.z.setText(this.A);
            this.S.setProgress(this.v);
            this.T.setProgress(this.v);
            return;
        }
        SDKDownloadMgr.getInstance().getSpace(2, "", new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String Q() {
        /*
            r8 = this;
            android.content.Context r0 = r8.x
            if (r0 != 0) goto L7
            java.lang.String r0 = r8.A
            return r0
        L7:
            com.zte.iptvclient.android.mobile.download.helper.a r0 = com.zte.iptvclient.android.mobile.download.helper.a.n()
            int r0 = r0.k()
            java.lang.String r1 = ""
            if (r0 == 0) goto L26
            r2 = 1
            if (r0 == r2) goto L19
            r0 = r1
            r2 = r0
            goto L35
        L19:
            java.lang.String r1 = com.zte.iptvclient.android.mobile.download.helper.c.b.l()
            java.lang.String r0 = com.zte.iptvclient.android.mobile.download.helper.c.b.m()
            java.lang.String r2 = com.zte.iptvclient.android.mobile.download.helper.c.b.n()
            goto L32
        L26:
            java.lang.String r1 = com.zte.iptvclient.android.mobile.download.helper.c.b.d()
            java.lang.String r0 = com.zte.iptvclient.android.mobile.download.helper.c.b.f()
            java.lang.String r2 = com.zte.iptvclient.android.mobile.download.helper.c.b.h()
        L32:
            r7 = r1
            r1 = r0
            r0 = r7
        L35:
            android.content.Context r3 = r8.x
            if (r3 != 0) goto L3c
            java.lang.String r0 = r8.A
            return r0
        L3c:
            boolean r3 = com.video.androidsdk.common.util.StringUtil.isEmptyString(r1)
            if (r3 != 0) goto L80
            boolean r3 = com.video.androidsdk.common.util.StringUtil.isEmptyString(r0)
            if (r3 != 0) goto L80
            int r3 = r0.length()
            int r3 = r3 + (-2)
            r4 = 0
            java.lang.String r3 = r0.substring(r4, r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            float r3 = r3.floatValue()
            r5 = 1148846080(0x447a0000, float:1000.0)
            float r3 = r3 * r5
            r6 = 1120403456(0x42c80000, float:100.0)
            float r3 = r3 * r6
            int r6 = r1.length()
            int r6 = r6 + (-2)
            java.lang.String r4 = r1.substring(r4, r6)
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            float r4 = r4.floatValue()
            float r4 = r4 * r5
            float r3 = r3 / r4
            int r3 = java.lang.Math.round(r3)
            int r3 = 100 - r3
            r8.v = r3
        L80:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r4 = 2131624969(0x7f0e0409, float:1.8877133E38)
            java.lang.String r4 = com.zte.iptvclient.android.common.i.a.a.a(r4)
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = ", "
            r3.append(r2)
            r4 = 2131625522(0x7f0e0632, float:1.8878254E38)
            java.lang.String r4 = com.zte.iptvclient.android.common.i.a.a.a(r4)
            r3.append(r4)
            r3.append(r0)
            r3.append(r2)
            r0 = 2131625524(0x7f0e0634, float:1.8878258E38)
            java.lang.String r0 = com.zte.iptvclient.android.common.i.a.a.a(r0)
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.mobile.i.b.f.Q():java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        if (!this.c0) {
            SDKDownloadMgr.getInstance().getDownloadList("0", 2, this.X, this.e0);
        } else {
            SDKDownloadMgr.getInstance().getDownloadList("0", 1, this.X, this.e0);
        }
    }

    private void S() {
        com.zte.iptvclient.android.mobile.i.a.c cVar = new com.zte.iptvclient.android.mobile.i.a.c(getActivity(), this, this.r);
        this.R = cVar;
        this.q.setAdapter((ListAdapter) cVar);
    }

    private void T() {
        this.B.setVisibility(8);
        this.C.setVisibility(0);
        this.D.setVisibility(8);
        this.E.setVisibility(8);
        e(0);
        this.R.a(true);
    }

    private void U() {
        this.B.setVisibility(0);
        this.C.setVisibility(8);
        this.D.setVisibility(0);
        this.E.setVisibility(0);
        this.F.setVisibility(8);
        this.R.a(false);
    }

    @Override // com.zte.fragmentlib.b
    public boolean D() {
        if (getActivity() instanceof MainActivity) {
            F();
            return true;
        }
        if (!(getActivity() instanceof HostActivity)) {
            return true;
        }
        getActivity().finish();
        return true;
    }

    @Override // com.zte.iptvclient.android.mobile.i.b.b
    public void I() {
    }

    @Override // com.zte.iptvclient.android.mobile.i.b.b
    public boolean J() {
        return false;
    }

    @Override // com.zte.iptvclient.android.mobile.i.b.b
    public ArrayList<DownloadTask> K() {
        return null;
    }

    @Override // com.zte.iptvclient.android.mobile.i.b.b
    public ArrayList<DownloadTask> L() {
        return null;
    }

    @Override // com.zte.iptvclient.android.mobile.i.b.b
    public void M() {
    }

    @Override // com.zte.iptvclient.android.mobile.i.b.b
    public void N() {
    }

    protected void O() {
        ArrayList<DownloadTask> c2 = this.R.c();
        this.a0 = c2;
        int size = c2.size();
        this.b0 = size;
        if (size == 0) {
            return;
        }
        new com.zte.iptvclient.android.common.customview.a.a.e.f(this.h, R.drawable.custom_dialog_login_img, R.string.confirm_delete_item, R.drawable.custom_dialog_button_blue, R.string.confirm, 0, R.drawable.custom_dialog_button_blue, R.string.common_cancel, 0, new b()).a();
    }

    @Override // com.zte.iptvclient.android.mobile.i.b.b
    public void c(boolean z) {
    }

    @Override // com.zte.iptvclient.android.mobile.i.b.b
    public void d(int i2) {
    }

    @Override // com.zte.iptvclient.android.mobile.i.b.b
    public void d(boolean z) {
    }

    @Override // com.zte.iptvclient.android.mobile.i.b.b
    public void e(boolean z) {
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        S();
        R();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.x = getActivity();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.X = arguments.getString("headId");
            this.Y = arguments.getString("headName");
            this.c0 = arguments.getBoolean("isFilterLocal", true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.downloaded_tv_series_fragment, (ViewGroup) null);
        d(inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.A = getString(R.string.download_setting_path_size_default);
        h(this.c0);
    }

    private void d(View view) {
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        this.L = (TextView) view.findViewById(R.id.edit_txt);
        this.O = (ImageView) view.findViewById(R.id.edit_ivew);
        ImageView imageView = (ImageView) view.findViewById(R.id.filter_ivew);
        this.P = imageView;
        imageView.setVisibility(8);
        this.G = (TextView) view.findViewById(R.id.txt_selected_all);
        this.J = (TextView) view.findViewById(R.id.txt_cancel);
        this.K = (TextView) view.findViewById(R.id.txt_selected_num);
        TextView textView2 = (TextView) view.findViewById(R.id.title_txt);
        this.M = textView2;
        textView2.setText(this.Y);
        this.B = (RelativeLayout) view.findViewById(R.id.title_rlayout);
        this.C = (RelativeLayout) view.findViewById(R.id.edit_rlayout);
        this.q = (ListView) view.findViewById(R.id.list);
        this.y = (TextView) view.findViewById(R.id.download_main_space);
        this.z = (TextView) view.findViewById(R.id.download_main_space_dark);
        this.S = (ProgressBar) view.findViewById(R.id.download_local_storage_progressbar);
        this.T = (ProgressBar) view.findViewById(R.id.download_local_storage_progressbar_dark);
        this.p = (Button) view.findViewById(R.id.btn_back);
        this.D = (FrameLayout) view.findViewById(R.id.download_storage_bar);
        this.E = (FrameLayout) view.findViewById(R.id.download_storage_bar_dark);
        this.F = (FrameLayout) view.findViewById(R.id.fl_delete);
        this.N = (TextView) view.findViewById(R.id.txt_delete);
        if ("1".equals(ConfigMgr.readPropertie("IsShowEditIconOrText", "0"))) {
            this.L.setVisibility(8);
            this.O.setVisibility(0);
        }
        com.zte.iptvclient.common.uiframe.f.a(this.y);
        com.zte.iptvclient.common.uiframe.f.a(this.z);
        com.zte.iptvclient.common.uiframe.f.a(this.p);
        com.zte.iptvclient.common.uiframe.f.a(this.O);
        com.zte.iptvclient.common.uiframe.f.a(this.P);
        com.zte.iptvclient.common.uiframe.f.a(this.D);
        com.zte.iptvclient.common.uiframe.f.a(this.E);
        com.zte.iptvclient.common.uiframe.f.a(this.N);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_rlayout));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_txt));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.edit_txt));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.edit_rlayout));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.txt_selected_all));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.txt_selected_num));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.txt_cancel));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_bottom_line));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.download_storage_bar));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.fl_delete));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_delete));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.img_delete));
        this.L.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.edit));
        this.G.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.favorite_select_all));
        this.K.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_select_num));
        this.J.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_cancel));
        this.y.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_setting_path_size_default));
        this.z.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_setting_path_size_default));
        this.N.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.delete));
        if (TextUtils.equals(com.zte.fragmentlib.publicbaseclass.skinloader.b.f4075b, "white.skin")) {
            this.D.setVisibility(0);
            this.E.setVisibility(8);
        } else {
            this.D.setVisibility(8);
            this.E.setVisibility(0);
        }
        this.p.setOnClickListener(new ViewOnClickListenerC0280f());
        this.L.setOnClickListener(new g());
        this.O.setOnClickListener(new h());
        this.J.setOnClickListener(new i());
        this.G.setOnClickListener(new j());
        this.F.setOnClickListener(new k());
        this.U = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_empty);
        this.V = relativeLayout;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout.findViewById(R.id.ll_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.V.findViewById(R.id.img_pullrefresh_icon));
        com.zte.iptvclient.common.uiframe.f.a(this.V.findViewById(R.id.txt_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.V.findViewById(R.id.refresh_image));
        this.V.setVisibility(8);
        this.U.a(new DefaultRefreshHeader(this.h));
        this.U.a(new DefaultRefreshFooter(this.h));
        SmartRefreshLayout smartRefreshLayout = this.U;
        SupportActivity supportActivity = this.h;
        smartRefreshLayout.e(com.zte.iptvclient.android.common.k.g.a(supportActivity, supportActivity.getResources().getDimension(R.dimen.refresh_footer_height)));
        SmartRefreshLayout smartRefreshLayout2 = this.U;
        SupportActivity supportActivity2 = this.h;
        smartRefreshLayout2.f(com.zte.iptvclient.android.common.k.g.a(supportActivity2, supportActivity2.getResources().getDimension(R.dimen.refresh_header_height)));
        this.U.a(true);
        this.U.c(false);
        this.U.a(new l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(boolean z) {
        LogEx.d("DownloadedTVSeriesFragment", "refresh storage info");
        if (z) {
            new n().execute(new String[0]);
        } else {
            P();
        }
    }

    @Override // com.zte.iptvclient.android.mobile.i.b.b
    public void e(int i2) {
        this.K.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_select_num), Integer.valueOf(i2)));
        if (i2 > 0) {
            this.F.setVisibility(0);
        } else {
            this.F.setVisibility(8);
        }
    }

    public void f(boolean z) {
        this.W = z;
        if (z) {
            this.G.setText(R.string.favorite_select_null);
        } else {
            this.G.setText(R.string.favorite_select_all);
        }
    }

    protected void g(boolean z) {
        this.Q = z;
        if (z) {
            T();
        } else {
            U();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ArrayList<DownloadTask> arrayList) {
        this.r.clear();
        if (arrayList != null && !arrayList.isEmpty()) {
            this.r.addAll(arrayList);
        }
        this.R.a(this.r);
        this.R.notifyDataSetChanged();
        this.U.a();
        if (this.r.size() == 0) {
            this.V.setVisibility(0);
            this.q.setVisibility(8);
        } else {
            this.V.setVisibility(8);
            this.q.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ArrayList<DownloadTask> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        if (this.c0) {
            SDKDownloadMgr.getInstance().removeTask(arrayList, 1, this.f0);
        } else {
            SDKDownloadMgr.getInstance().removeTask(arrayList, 2, this.f0);
        }
    }

    private void e(DownloadTask downloadTask) {
        if (String.valueOf(1).equals(downloadTask.videoInfo.get("downLoadType"))) {
            String playURL = SDKDownloadMgr.getInstance().getPlayURL(1, downloadTask);
            LogEx.d("DownloadedTVSeriesFragment", "Prepare to Local Play,url:" + playURL);
            if (downloadTask.videoInfo.get("isDrm").equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
                this.t = downloadTask;
                this.u = playURL;
                LogEx.d("DownloadedTVSeriesFragment", "DRM VALIDATED, BEGIN TO PLAY");
                a(this.u, this.t);
                return;
            }
            LogEx.d("DownloadedTVSeriesFragment", "NO DRM NEED, BEGIN TO PLAY");
            a(playURL, downloadTask);
            return;
        }
        LogEx.d("DownloadedTVSeriesFragment", "BEGIN TO HC100 PLAY");
        String playURL2 = SDKDownloadMgr.getInstance().getPlayURL(2, downloadTask);
        if (TextUtils.isEmpty(playURL2)) {
            return;
        }
        a(playURL2, downloadTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(DownloadTask downloadTask) {
        String str = downloadTask.videoInfo.get("taskID");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("programcode", str);
        new SDKVodMgr().getVodDetailWithUrl(hashMap, new m(this, downloadTask));
    }

    @Override // com.zte.iptvclient.android.mobile.i.a.c.b
    public void a(DownloadTask downloadTask) {
        if (com.zte.iptvclient.android.common.k.c.a()) {
            return;
        }
        if (d(downloadTask).booleanValue()) {
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.sorry_order_has_expired);
        } else {
            LogEx.d("DownloadedTVSeriesFragment", "Video is not expired,prepare to play");
            e(downloadTask);
        }
    }

    @Override // com.zte.iptvclient.android.mobile.i.b.b
    public void b(boolean z) {
        f(z);
    }

    private void a(String str, DownloadTask downloadTask) {
        com.zte.iptvclient.android.mobile.download.helper.a.n().a((Boolean) true);
        String str2 = downloadTask.videoInfo.get("videoName");
        String str3 = downloadTask.videoInfo.get("contentCode");
        String str4 = downloadTask.videoInfo.get("columnCode");
        LogEx.d("DownloadedTVSeriesFragment", "Now Begin to open the Player. Title:" + str2 + "url:" + str);
        StringBuilder sb = new StringBuilder();
        sb.append("task videoinfo : ");
        sb.append(downloadTask.videoInfo.toString());
        LogEx.d("DownloadedTVSeriesFragment", sb.toString());
        Bundle bundle = new Bundle();
        bundle.putString(ParamConst.UPDATE_VERSION_RSP_URL, str);
        bundle.putString("programname", str2);
        bundle.putBoolean("isfromdownloaded", true);
        bundle.putString("seriesprogramcode", downloadTask.videoInfo.get("seriesHeadID"));
        bundle.putString("programcode", downloadTask.videoInfo.get("taskID"));
        if (String.valueOf(1).equals(downloadTask.videoInfo.get("downLoadType"))) {
            bundle.putString("url_nav", str);
        } else {
            bundle.putString("url_hc", str);
        }
        String str5 = downloadTask.videoInfo.get("taskDefinition");
        String str6 = downloadTask.videoId;
        String replace = !TextUtils.isEmpty(str5) ? str6.replace(str5, "") : str6;
        bundle.putString("taskID", downloadTask.videoInfo.get("taskID"));
        bundle.putString("headId", this.X);
        bundle.putString("playuri4dlna", com.zte.iptvclient.android.mobile.h.a.b.b(str4, replace, "1", str3, str2, downloadTask.videoInfo.get("telecomCode")));
        bundle.putString("auth_contenttype", "10");
        bundle.putString("telecomcode", downloadTask.videoInfo.get("telecomCode"));
        this.w = new com.zte.iptvclient.android.common.player.f();
        com.zte.iptvclient.android.common.player.j.l lVar = new com.zte.iptvclient.android.common.player.j.l();
        lVar.b(str3);
        lVar.a(str4);
        this.w.a(false);
        this.w.b(false);
        this.w.a(lVar, bundle, getActivity());
    }

    private Boolean d(DownloadTask downloadTask) {
        return com.zte.iptvclient.android.mobile.download.helper.c.c.a(downloadTask);
    }
}
