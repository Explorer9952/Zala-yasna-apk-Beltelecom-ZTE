package com.zte.iptvclient.android.mobile.i.b;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.video.androidsdk.common.GlobalConst;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.util.TimeUtil;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.download.Linstener.DownloadListReturnListener;
import com.video.androidsdk.download.Linstener.OnTaskOperReturnListener;
import com.video.androidsdk.download.SDKDownloadMgr;
import com.video.androidsdk.download.bean.DownloadTask;
import com.video.androidsdk.download.bean.DownloadTaskReq;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.javabean.models.VideoDetailBean;
import com.zte.iptvclient.android.common.k.x;
import com.zte.iptvclient.android.mobile.download.service.DownloadNotifyService;
import com.zte.iptvclient.android.zala.R;
import com.zte.servicesdk.util.PortalConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.greenrobot.eventbus.EventBus;

/* compiled from: VideoDetailDownloadFragment.java */
/* loaded from: classes.dex */
public class i extends com.zte.fragmentlib.b {
    private TextView A;
    private String B;
    private String C;
    private VideoDetailBean D;
    private LayoutInflater E;
    private com.zte.iptvclient.android.common.j.h P;
    private ArrayList<String> p;
    private LinearLayout r;
    private RelativeLayout s;
    private HashMap<String, String> t;
    private View u;
    private ImageView v;
    private RelativeLayout w;
    private ImageView x;
    private ImageView y;
    private TextView z;
    private String q = "";
    private long F = 0;
    private int G = 0;
    private Boolean J = false;
    private int K = 1;
    private String L = "";
    private String[] M = new String[0];
    private String N = "";
    private String[] O = new String[0];
    private OnTaskOperReturnListener Q = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoDetailDownloadFragment.java */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.this.F();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoDetailDownloadFragment.java */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (i.this.M()) {
                return;
            }
            if (i.this.J.booleanValue()) {
                i.this.P();
            } else {
                i.this.Q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoDetailDownloadFragment.java */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {

        /* compiled from: VideoDetailDownloadFragment.java */
        /* loaded from: classes.dex */
        class a implements DialogInterface.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ EditText f6576a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.zte.iptvclient.android.common.customview.a.a.a.b f6577b;

            a(EditText editText, com.zte.iptvclient.android.common.customview.a.a.a.b bVar) {
                this.f6576a = editText;
                this.f6577b = bVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (this.f6576a.getText().toString().equals(i.this.P.u())) {
                    i.this.J();
                    i.this.A();
                    this.f6577b.dismiss();
                } else {
                    this.f6576a.setText("");
                    this.f6577b.a(com.zte.iptvclient.android.common.i.a.a.a(R.string.limitpwd_is_wrong));
                }
            }
        }

        /* compiled from: VideoDetailDownloadFragment.java */
        /* loaded from: classes.dex */
        class b implements DialogInterface.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.zte.iptvclient.android.common.customview.a.a.a.b f6579a;

            b(com.zte.iptvclient.android.common.customview.a.a.a.b bVar) {
                this.f6579a = bVar;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                this.f6579a.dismiss();
                i.this.A();
            }
        }

        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (i.this.D == null || i.this.t == null) {
                return;
            }
            if (!TextUtils.equals("1", ConfigMgr.readPropertie("IsShowChildLock")) || i.this.P == null || !i.this.P.C() || !com.zte.iptvclient.android.mobile.f.b.a.b(i.this.D.getRatingid(), ((com.zte.fragmentlib.b) i.this).h)) {
                i.this.J();
                return;
            }
            com.zte.iptvclient.android.common.customview.a.a.a.b bVar = new com.zte.iptvclient.android.common.customview.a.a.a.b(((com.zte.fragmentlib.b) i.this).h);
            bVar.setTitle(R.string.enter_passsword_check);
            bVar.b(R.string.common_ok, new a(bVar.a(), bVar));
            bVar.a(R.string.common_cancel, new b(bVar));
            bVar.setCancelable(true);
            bVar.setCanceledOnTouchOutside(false);
            bVar.show();
        }
    }

    /* compiled from: VideoDetailDownloadFragment.java */
    /* loaded from: classes.dex */
    class d implements OnTaskOperReturnListener {
        d() {
        }

        @Override // com.video.androidsdk.download.Linstener.OnTaskOperReturnListener
        public void onTaskOperReturn(String str, String str2, String str3) {
            LogEx.d("VideoDetailDownloadFragment", " strErrorCode = " + str + " strErrorMsg = " + str2 + " strResposeInfo = " + str3);
            if (i.this.K == 1) {
                if ("0".equals(str)) {
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.joined_download_sequence));
                } else {
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.task_added_error_msg));
                }
                i.i(i.this);
            }
            i.this.R();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoDetailDownloadFragment.java */
    /* loaded from: classes.dex */
    public class e implements DownloadListReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f6582a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean[] f6583b;

        e(i iVar, String str, boolean[] zArr) {
            this.f6582a = str;
            this.f6583b = zArr;
        }

        @Override // com.video.androidsdk.download.Linstener.DownloadListReturnListener
        public void returnDownloadTaskList(String str, int i, String str2, ArrayList<DownloadTask> arrayList) {
            if (i == 0) {
                Iterator<DownloadTask> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    if (this.f6582a.equals(it2.next().videoInfo.get("taskID"))) {
                        this.f6583b[0] = true;
                        return;
                    }
                }
                return;
            }
            this.f6583b[0] = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoDetailDownloadFragment.java */
    /* loaded from: classes.dex */
    public class f implements DownloadListReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f6584a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean[] f6585b;

        f(i iVar, String str, boolean[] zArr) {
            this.f6584a = str;
            this.f6585b = zArr;
        }

        @Override // com.video.androidsdk.download.Linstener.DownloadListReturnListener
        public void returnDownloadTaskList(String str, int i, String str2, ArrayList<DownloadTask> arrayList) {
            if (i == 0) {
                Iterator<DownloadTask> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    if (this.f6584a.equals(it2.next().videoInfo.get("taskID"))) {
                        this.f6585b[0] = true;
                        return;
                    }
                }
                return;
            }
            this.f6585b[0] = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VideoDetailDownloadFragment.java */
    /* loaded from: classes.dex */
    public class g implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        private int f6586a;

        public g(int i) {
            this.f6586a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (i.this.M()) {
                return;
            }
            i.this.G = this.f6586a;
            if (i.this.p.size() > i.this.G) {
                String str = (String) i.this.p.get(i.this.G);
                i.this.p.remove(i.this.G);
                i.this.p.add(0, str);
                ArrayList arrayList = new ArrayList();
                arrayList.add(i.this.p.get(0));
                for (int i = 1; i < i.this.p.size(); i++) {
                    if (((String) i.this.p.get(i)).equals(i.this.u("1"))) {
                        arrayList.add(i.this.p.get(i));
                        LogEx.d("VideoDetailDownloadFragment", "mDefinitionNameList.add = " + ((String) i.this.p.get(i)));
                    }
                }
                for (int i2 = 1; i2 < i.this.p.size(); i2++) {
                    if (((String) i.this.p.get(i2)).equals(i.this.u("2"))) {
                        arrayList.add(i.this.p.get(i2));
                        LogEx.d("VideoDetailDownloadFragment", "mDefinitionNameList.add = " + ((String) i.this.p.get(i2)));
                    }
                }
                for (int i3 = 1; i3 < i.this.p.size(); i3++) {
                    if (((String) i.this.p.get(i3)).equals(i.this.u("4"))) {
                        arrayList.add(i.this.p.get(i3));
                        LogEx.d("VideoDetailDownloadFragment", "mDefinitionNameList.add = " + ((String) i.this.p.get(i3)));
                    }
                }
                for (int i4 = 1; i4 < i.this.p.size(); i4++) {
                    if (((String) i.this.p.get(i4)).equals(i.this.u("8"))) {
                        arrayList.add(i.this.p.get(i4));
                        LogEx.d("VideoDetailDownloadFragment", "mDefinitionNameList.add = " + ((String) i.this.p.get(i4)));
                    }
                }
                for (int i5 = 1; i5 < i.this.p.size(); i5++) {
                    if (((String) i.this.p.get(i5)).equals(i.this.u(GlobalConst.WINPHONE_CLIENT))) {
                        arrayList.add(i.this.p.get(i5));
                        LogEx.d("VideoDetailDownloadFragment", "mDefinitionNameList.add = " + ((String) i.this.p.get(i5)));
                    }
                }
                for (int i6 = 1; i6 < i.this.p.size(); i6++) {
                    if (((String) i.this.p.get(i6)).equals(i.this.u(GlobalConst.ANDRIODSTB_CLIENT))) {
                        arrayList.add(i.this.p.get(i6));
                        LogEx.d("VideoDetailDownloadFragment", "mDefinitionNameList.add = " + ((String) i.this.p.get(i6)));
                    }
                }
                i.this.p = arrayList;
            }
            i.this.P();
        }
    }

    private boolean I() {
        boolean[] zArr = {true};
        if (this.D == null) {
            LogEx.d("VideoDetailDownloadFragment", "checkIsAvailableForDownload getVideo() return null");
            zArr[0] = false;
        }
        if (!com.zte.iptvclient.android.mobile.download.helper.c.c.c(this.h.getApplicationContext())) {
            b(R.string.common_notice, R.string.network_connection_failed);
            zArr[0] = false;
        }
        if (com.zte.iptvclient.android.mobile.download.helper.a.n().k() == 1 && !com.zte.iptvclient.android.mobile.download.helper.c.b.o().booleanValue()) {
            b(R.string.common_notice, R.string.storage_path_not_exist);
            zArr[0] = false;
        }
        return zArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        if (TextUtils.equals(this.q, com.zte.iptvclient.android.common.i.a.a.a(R.string.definition_fdh))) {
            this.B = DownloadConstant.REPORT_MSGTYPE_ADD;
        } else if (TextUtils.equals(this.q, u("1"))) {
            this.B = "1";
        } else if (TextUtils.equals(this.q, u("2"))) {
            this.B = "2";
        } else if (TextUtils.equals(this.q, u("4"))) {
            this.B = "4";
        } else if (TextUtils.equals(this.q, u("8"))) {
            this.B = "8";
        } else if (TextUtils.equals(this.q, u(GlobalConst.WINPHONE_CLIENT))) {
            this.B = GlobalConst.WINPHONE_CLIENT;
        } else if (TextUtils.equals(this.q, u(GlobalConst.ANDRIODSTB_CLIENT))) {
            this.B = GlobalConst.ANDRIODSTB_CLIENT;
        }
        this.s.setClickable(false);
        this.y.setBackground(c.a.a.a.d.b.d().d(R.drawable.cache_ing));
        this.h.a(this.y, "background", R.drawable.cache_ing);
        this.y.setVisibility(0);
        a(this.D, this.B);
    }

    private void K() {
        this.p = new ArrayList<>();
        if (this.D != null) {
            this.z.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.commom_download));
            String videoelapsedtime = this.D.getVideoelapsedtime();
            this.C = videoelapsedtime;
            this.A.setText(videoelapsedtime);
            this.t = this.D.getDownloadURL();
            if (DownloadConstant.REPORT_MSGTYPE_STB_RECONNECT.equals(com.zte.iptvclient.common.uiframe.a.c("Android_Player_Type"))) {
                if (this.t.containsKey(DownloadConstant.REPORT_MSGTYPE_ADD)) {
                    this.p.add(com.zte.iptvclient.android.common.i.a.a.a(R.string.definition_fdh));
                    String str = this.t.get(DownloadConstant.REPORT_MSGTYPE_ADD) + com.zte.iptvclient.android.common.k.i.a();
                    this.t.put(DownloadConstant.REPORT_MSGTYPE_ADD, str);
                    LogEx.d("downloadUrl  == ", str);
                }
                if (this.t.containsKey("1")) {
                    this.p.add(u("1"));
                    String str2 = this.t.get("1") + com.zte.iptvclient.android.common.k.i.a();
                    this.t.put("1", str2);
                    LogEx.d("downloadUrl  == ", str2);
                }
                if (this.t.containsKey("2")) {
                    this.p.add(u("2"));
                    String str3 = this.t.get("2") + com.zte.iptvclient.android.common.k.i.a();
                    this.t.put("2", str3);
                    LogEx.d("downloadUrl  == ", str3);
                }
                if (this.t.containsKey("4")) {
                    this.p.add(u("4"));
                    String str4 = this.t.get("4") + com.zte.iptvclient.android.common.k.i.a();
                    this.t.put("4", str4);
                    LogEx.d("downloadUrl  == ", str4);
                }
                if (this.t.containsKey("8")) {
                    this.p.add(u("8"));
                    String str5 = this.t.get("8") + com.zte.iptvclient.android.common.k.i.a();
                    this.t.put("8", str5);
                    LogEx.d("downloadUrl  == ", str5);
                }
                if (this.t.containsKey(GlobalConst.WINPHONE_CLIENT)) {
                    this.p.add(u(GlobalConst.WINPHONE_CLIENT));
                    String str6 = this.t.get(GlobalConst.WINPHONE_CLIENT) + com.zte.iptvclient.android.common.k.i.a();
                    this.t.put(GlobalConst.WINPHONE_CLIENT, str6);
                    LogEx.d("downloadUrl  == ", str6);
                }
                if (this.t.containsKey(GlobalConst.ANDRIODSTB_CLIENT)) {
                    this.p.add(u(GlobalConst.ANDRIODSTB_CLIENT));
                    String str7 = this.t.get(GlobalConst.ANDRIODSTB_CLIENT) + com.zte.iptvclient.android.common.k.i.a();
                    this.t.put(GlobalConst.ANDRIODSTB_CLIENT, str7);
                    LogEx.d("downloadUrl  == ", str7);
                }
            } else {
                if (this.t.containsKey(DownloadConstant.REPORT_MSGTYPE_ADD)) {
                    this.p.add(com.zte.iptvclient.android.common.i.a.a.a(R.string.definition_fdh));
                }
                if (this.t.containsKey("1")) {
                    this.p.add(u("1"));
                }
                if (this.t.containsKey("2")) {
                    this.p.add(u("2"));
                }
                if (this.t.containsKey("4")) {
                    this.p.add(u("4"));
                }
                if (this.t.containsKey("8")) {
                    this.p.add(u("8"));
                }
                if (this.t.containsKey(GlobalConst.WINPHONE_CLIENT)) {
                    this.p.add(u(GlobalConst.WINPHONE_CLIENT));
                }
                if (this.t.containsKey(GlobalConst.ANDRIODSTB_CLIENT)) {
                    this.p.add(u(GlobalConst.ANDRIODSTB_CLIENT));
                }
                LogEx.d("VideoDetailDownloadFragment", "mDefinitionNameList=" + this.p.size() + "," + this.p.toString());
            }
            LogEx.d("VideoDetailDownloadFragment", "mDefinitionNameList=" + this.p.size() + "," + this.p.toString());
        }
    }

    private void L() {
        O();
        P();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean M() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.F <= 500) {
            LogEx.w("UseeTv", "Operate limit,less than 1000(ms)!");
            return true;
        }
        this.F = currentTimeMillis;
        return false;
    }

    private void N() {
        this.w.setOnClickListener(new a());
        this.v.setOnClickListener(new b());
        this.s.setOnClickListener(new c());
    }

    private void O() {
        ArrayList<String> arrayList = this.p;
        if (arrayList != null) {
            if (arrayList.size() > 1) {
                this.v.setVisibility(0);
            } else {
                this.v.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        this.J = false;
        this.r.removeAllViews();
        this.v.setBackgroundResource(R.drawable.details_arrow_right);
        if (this.p.size() > 0) {
            this.G = 0;
            this.q = this.p.get(0);
            View inflate = this.E.inflate(R.layout.video_download_definition_title_layout, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.definition_title);
            com.zte.iptvclient.common.uiframe.f.a(textView);
            textView.setText(this.q);
            if (this.h != null) {
                textView.setTextColor(c.a.a.a.d.b.d().b(R.color.video_definitionfoucus_textcolor));
                this.h.a(textView, "textColor", R.color.video_definitionfoucus_textcolor);
            }
            this.r.addView(inflate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        this.J = true;
        this.r.removeAllViews();
        this.v.setBackgroundResource(R.drawable.details_arrow_left);
        if (this.p.size() > this.G) {
            this.q = this.p.get(0);
            for (int i = 0; i < this.p.size(); i++) {
                View inflate = this.E.inflate(R.layout.video_download_definition_title_layout, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.definition_title);
                com.zte.iptvclient.common.uiframe.f.a(textView);
                if (i == 0) {
                    textView.setText(this.q);
                    if (this.h != null) {
                        textView.setTextColor(c.a.a.a.d.b.d().b(R.color.video_definitionfoucus_textcolor));
                        this.h.a(textView, "textColor", R.color.video_definitionfoucus_textcolor);
                    }
                } else {
                    textView.setText(this.p.get(i));
                    if (this.h != null) {
                        textView.setTextColor(c.a.a.a.d.b.d().b(R.color.video_definitionnormal_textcolor));
                        this.h.a(textView, "textColor", R.color.video_definitionnormal_textcolor);
                    }
                }
                this.r.addView(inflate);
                textView.setOnClickListener(new g(i));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        VideoDetailBean videoDetailBean = this.D;
        if (videoDetailBean == null) {
            return;
        }
        if (s(videoDetailBean.getProgramcode())) {
            S();
        }
        if (t(this.D.getProgramcode())) {
            T();
        }
        if (!s(this.D.getProgramcode()) && !t(this.D.getProgramcode())) {
            this.s.setClickable(true);
        } else {
            this.s.setClickable(false);
        }
    }

    private void S() {
        if (this.h != null) {
            this.y.setBackground(c.a.a.a.d.b.d().d(R.drawable.cache_done));
            this.h.a(this.y, "background", R.drawable.cache_done);
        }
        this.y.setVisibility(0);
    }

    private void T() {
        if (this.h != null) {
            this.y.setBackground(c.a.a.a.d.b.d().d(R.drawable.cache_ing));
            this.h.a(this.y, "background", R.drawable.cache_ing);
        }
        this.y.setVisibility(0);
    }

    static /* synthetic */ int i(i iVar) {
        int i = iVar.K;
        iVar.K = i + 1;
        return i;
    }

    private boolean s(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean[] zArr = {false};
        SDKDownloadMgr.getInstance().getDownloadList("0", com.zte.iptvclient.android.mobile.download.helper.a.n().k() == 3 ? 2 : 1, new e(this, str, zArr));
        return zArr[0];
    }

    private boolean t(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean[] zArr = {false};
        SDKDownloadMgr.getInstance().getDownloadList("1", com.zte.iptvclient.android.mobile.download.helper.a.n().k() == 3 ? 2 : 1, new f(this, str, zArr));
        return zArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String u(String str) {
        String str2 = "";
        int i = 0;
        while (true) {
            String[] strArr = this.M;
            if (i >= strArr.length) {
                return str2;
            }
            if (strArr[i].equals(str)) {
                String[] strArr2 = this.O;
                if (i < strArr2.length) {
                    str2 = strArr2[i];
                }
            }
            i++;
        }
    }

    @Override // com.zte.fragmentlib.b
    public boolean D() {
        F();
        return true;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        K();
        L();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.P = new com.zte.iptvclient.android.common.j.h(this.h);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.D = (VideoDetailBean) arguments.getSerializable("VideoBean");
        }
        String c2 = com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_RATE_DEFINITION_LEVEL);
        this.L = c2;
        if (!TextUtils.isEmpty(c2)) {
            this.M = this.L.split(",");
        }
        String c3 = com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_RATE_DEFINITION_TITLE);
        this.N = c3;
        if (TextUtils.isEmpty(c3)) {
            return;
        }
        this.O = this.N.split(",");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.E = layoutInflater;
        View inflate = layoutInflater.inflate(R.layout.video_detail_download_layout, (ViewGroup) null);
        this.u = inflate;
        d(inflate);
        N();
        R();
        return this.u;
    }

    private void b(int i, int i2) {
        com.zte.iptvclient.android.common.customview.a.a.a.a aVar = new com.zte.iptvclient.android.common.customview.a.a.a.a(getActivity());
        aVar.setTitle(i);
        aVar.a(i2);
        aVar.b(R.string.common_ok, null);
        aVar.show();
    }

    private void d(View view) {
        this.r = (LinearLayout) view.findViewById(R.id.download_definition_layout);
        this.v = (ImageView) view.findViewById(R.id.arrow_definition);
        this.w = (RelativeLayout) view.findViewById(R.id.rl_colse_img);
        this.x = (ImageView) view.findViewById(R.id.back_close);
        this.s = (RelativeLayout) view.findViewById(R.id.rl_download_source);
        this.y = (ImageView) view.findViewById(R.id.img_download_state);
        this.A = (TextView) view.findViewById(R.id.txt_downlaod_player_time);
        this.z = (TextView) view.findViewById(R.id.txt_downlaod_name);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_download_definition_title));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_download_source));
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.v);
        com.zte.iptvclient.common.uiframe.f.a(this.w);
        com.zte.iptvclient.common.uiframe.f.a(this.x);
        com.zte.iptvclient.common.uiframe.f.a(this.y);
        com.zte.iptvclient.common.uiframe.f.a(this.A);
        com.zte.iptvclient.common.uiframe.f.a(this.z);
        this.v.setBackgroundResource(R.drawable.details_arrow_right);
        this.v.setVisibility(8);
        this.y.setVisibility(8);
    }

    private void a(VideoDetailBean videoDetailBean, String str) {
        String str2;
        if (!I() || t(videoDetailBean.getProgramcode()) || s(videoDetailBean.getProgramcode())) {
            return;
        }
        DownloadTaskReq downloadTaskReq = new DownloadTaskReq();
        if (com.zte.iptvclient.android.mobile.download.helper.a.n().k() == 3) {
            downloadTaskReq.downloadType = String.valueOf(2);
        } else {
            downloadTaskReq.downloadType = String.valueOf(1);
        }
        downloadTaskReq.programeCode = this.D.getProgramcode();
        downloadTaskReq.seriesProgramCode = "";
        downloadTaskReq.columnCode = this.D.getColumncode();
        downloadTaskReq.definition = str;
        HashMap<String, String> downloadURL = this.D.getDownloadURL();
        if (downloadURL != null && (str2 = downloadURL.get(str)) != null && !TextUtils.isEmpty(str2)) {
            downloadTaskReq.downloadURL = com.zte.iptvclient.android.common.k.i.a(str2);
        }
        downloadTaskReq.expiredTime = this.D.getExpiredtime();
        downloadTaskReq.pictureURL = com.zte.iptvclient.android.common.k.g.a(BaseApp.a(this.h) ? 9 : 3, this.D.getPosterfilelist());
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("taskID", downloadTaskReq.programeCode);
        hashMap.put("taskDefinition", downloadTaskReq.definition);
        hashMap.put("taskStatus", String.valueOf(2));
        hashMap.put("sizeAlreadyDownloaded", "0");
        hashMap.put("taskAddDate", x.a(TimeUtil.getNow(), "yyyy.MM.dd HH:mm:ss"));
        hashMap.put("videoName", this.D.getProgramname());
        hashMap.put("videoSize", "0");
        hashMap.put("expiredDate", downloadTaskReq.expiredTime);
        hashMap.put("coverPath", downloadTaskReq.pictureURL);
        hashMap.put("downloadURL", downloadTaskReq.downloadURL);
        hashMap.put("seriesHeadID", downloadTaskReq.seriesProgramCode);
        hashMap.put("seriesHeadName", "");
        hashMap.put("isDrm", "");
        hashMap.put("seriesIndex", "1");
        hashMap.put("columnCode", this.D.getColumncode());
        hashMap.put("contentCode", this.D.getContentcode());
        hashMap.put("programcode", this.D.getProgramcode());
        hashMap.put("programType", this.D.getProgramtype());
        hashMap.put("bookMarkPoint", "0");
        hashMap.put("downLoadType", downloadTaskReq.downloadType);
        hashMap.put("stream_url", downloadTaskReq.downloadURL);
        hashMap.put("isProtection", this.D.getIsprotection());
        hashMap.put("telecomCode", this.D.getTelecomcode());
        hashMap.put("isHandStop", "false");
        LogEx.d("VideoDetailDownloadFragment", "  taskReq.downloadType = " + downloadTaskReq.downloadType + " taskReq.programeCode = " + downloadTaskReq.programeCode + " taskReq.seriesProgramCode = " + downloadTaskReq.seriesProgramCode + " taskReq.columnCode = " + downloadTaskReq.columnCode + " taskReq.definition = " + downloadTaskReq.definition + " taskReq.downloadURL = " + downloadTaskReq.downloadURL + "  taskReq.expiredTime = " + downloadTaskReq.expiredTime + " taskReq.pictureURL = " + downloadTaskReq.pictureURL);
        getActivity().startService(new Intent(getActivity(), (Class<?>) DownloadNotifyService.class));
        this.K = 1;
        com.zte.iptvclient.android.mobile.download.bean.a aVar = new com.zte.iptvclient.android.mobile.download.bean.a();
        aVar.a(downloadTaskReq);
        aVar.a(hashMap);
        aVar.a(this.Q);
        EventBus.getDefault().postSticky(aVar);
    }
}
