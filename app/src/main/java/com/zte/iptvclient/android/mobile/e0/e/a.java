package com.zte.iptvclient.android.mobile.e0.e;

import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.http.bean.HttpRequest;
import com.video.androidsdk.log.LogEx;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshFooter;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshHeader;
import com.zte.iptvclient.android.common.javabean.Comment;
import com.zte.iptvclient.android.common.javabean.CommentBean;
import com.zte.iptvclient.android.common.k.s;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.zala.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BTCommentWebFragment.java */
/* loaded from: classes2.dex */
public class a extends com.zte.fragmentlib.b implements com.scwang.smartrefresh.layout.d.a, com.scwang.smartrefresh.layout.d.c {
    private TextView A;
    private String B;
    private com.zte.iptvclient.android.common.j.h C;
    private View p;
    private RecyclerView q;
    private RelativeLayout r;
    private SmartRefreshLayout s;
    private com.zte.iptvclient.android.mobile.e0.e.b t;
    private h u;
    private int v = 1;
    private String w;
    private ArrayList<Comment> x;
    private TextView y;
    private EditText z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BTCommentWebFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.e0.e.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class ViewOnClickListenerC0223a implements View.OnClickListener {
        ViewOnClickListenerC0223a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Window window = ((com.zte.fragmentlib.b) a.this).h.getWindow();
            if (window != null) {
                window.setSoftInputMode(32);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BTCommentWebFragment.java */
    /* loaded from: classes2.dex */
    public class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.length() > 500) {
                a.this.A.setVisibility(0);
                a.this.y.setEnabled(false);
                a.this.y.setBackgroundResource(R.drawable.comment_release_dark_bg);
            } else {
                a.this.A.setVisibility(8);
                a.this.y.setEnabled(true);
                a.this.y.setBackgroundResource(R.drawable.comment_release_bg);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BTCommentWebFragment.java */
    /* loaded from: classes2.dex */
    public class c implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        c() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if ("0".equals(jSONObject.optString("returncode"))) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("data");
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        a.this.x.add(Comment.parseJsonToBean(optJSONArray.getJSONObject(i)));
                    }
                    LogEx.d("BTCommentWebFragment", "mListComments size = " + a.this.x.size());
                }
                a.this.J();
            } catch (JSONException e) {
                e.printStackTrace();
                a.this.J();
                LogEx.d("BTCommentWebFragment", "e = " + e.toString());
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            a.this.J();
            LogEx.d("sdk_querycomments", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BTCommentWebFragment.java */
    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (BaseApp.a(((com.zte.fragmentlib.b) a.this).h)) {
                a.this.u.a();
                a.this.F();
            } else {
                a.this.getActivity().finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BTCommentWebFragment.java */
    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.y.setEnabled(false);
            a.this.I();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BTCommentWebFragment.java */
    /* loaded from: classes2.dex */
    public class f implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        f() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!"0".equals(jSONObject.optString("returncode"))) {
                    a.this.B = "1";
                } else {
                    a.this.B = jSONObject.optString("isenabledcomments");
                }
            } catch (JSONException e) {
                e.printStackTrace();
                a.this.B = "1";
            }
            if (a.this.B.equals("1")) {
                a.this.z.setEnabled(false);
                a.this.z.setHint(((com.zte.fragmentlib.b) a.this).h.getResources().getString(R.string.forbidden_words));
                a.this.y.setEnabled(false);
                a.this.y.setBackgroundResource(R.drawable.comment_release_dark_bg);
                return;
            }
            a.this.z.setEnabled(true);
            a.this.z.setHint("");
            a.this.y.setEnabled(true);
            a.this.y.setBackgroundResource(R.drawable.comment_release_bg);
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            a.this.B = "1";
            if (a.this.B.equals("1")) {
                a.this.z.setEnabled(false);
                a.this.z.setHint(((com.zte.fragmentlib.b) a.this).h.getResources().getString(R.string.forbidden_words));
                a.this.y.setEnabled(false);
                a.this.y.setBackgroundResource(R.drawable.comment_release_dark_bg);
                return;
            }
            a.this.z.setEnabled(true);
            a.this.z.setHint("");
            a.this.y.setEnabled(true);
            a.this.y.setBackgroundResource(R.drawable.comment_release_bg);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BTCommentWebFragment.java */
    /* loaded from: classes2.dex */
    public class g implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f5842a;

        /* compiled from: BTCommentWebFragment.java */
        /* renamed from: com.zte.iptvclient.android.mobile.e0.e.a$g$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0224a extends TimerTask {
            C0224a() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (a.this.x != null) {
                    a.this.x.clear();
                }
                a.this.v = 1;
                a.this.L();
            }
        }

        g(String str) {
            this.f5842a = str;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            a.this.y.setEnabled(true);
            try {
                if ("0".equals(new JSONObject(str).optString("returncode"))) {
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.toast_comment_s);
                    CommentBean commentBean = new CommentBean();
                    commentBean.setContent(this.f5842a);
                    commentBean.setCreatetime(new SimpleDateFormat("yyyyMMddHHmmss").format(s.b()));
                    a.this.z.setText("");
                    a.this.q.m(0);
                    new Timer().schedule(new C0224a(), 1000L);
                } else {
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.toast_comment_f);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.toast_comment_f);
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            a.this.y.setEnabled(true);
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.toast_comment_f);
        }
    }

    /* compiled from: BTCommentWebFragment.java */
    /* loaded from: classes2.dex */
    public interface h {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        String encode = Uri.encode(this.z.getText().toString());
        String str = "http://{ipadd:port}/iptvepg/{frame}/sdk_addcomments.jsp".replace("http://{ipadd:port}/iptvepg/{frame}/", com.zte.iptvclient.android.common.f.b.i.f()) + "?comments=" + encode + "&contentcode=" + this.w;
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", com.zte.iptvclient.android.common.f.b.i.h());
        sDKNetHTTPRequest.setCharset("gbk");
        sDKNetHTTPRequest.startRequest(str, HttpRequest.METHOD_GET, new g(encode));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        this.s.j();
        this.s.a();
        com.zte.iptvclient.android.mobile.e0.e.b bVar = this.t;
        if (bVar == null) {
            this.t = new com.zte.iptvclient.android.mobile.e0.e.b(this.h, this.x, this.C.V());
            this.q.a(new com.zte.iptvclient.android.common.customview.b.a.a(this.h, 0));
            this.q.a(new LinearLayoutManager(this.h));
            this.q.a(this.t);
        } else {
            bVar.d();
        }
        if (this.x.size() > 0) {
            this.r.setVisibility(8);
            this.q.setVisibility(0);
        } else {
            this.r.setVisibility(0);
            this.q.setVisibility(8);
        }
    }

    private void K() {
        this.x = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        String str = "http://{ipadd:port}/iptvepg/{frame}/sdk_querycomments.jsp".replace("http://{ipadd:port}/iptvepg/{frame}/", com.zte.iptvclient.android.common.f.b.i.f()) + "?action=0&contentcode=" + this.w + "&pageno=" + String.valueOf(this.v) + "&numperpage=10";
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", com.zte.iptvclient.android.common.f.b.i.h());
        sDKNetHTTPRequest.setCharset("gbk");
        sDKNetHTTPRequest.startRequest(str, HttpRequest.METHOD_GET, new c());
    }

    private void M() {
        this.p.setOnClickListener(new d());
        this.s.a((com.scwang.smartrefresh.layout.d.c) this);
        this.s.a((com.scwang.smartrefresh.layout.d.a) this);
        this.y.setOnClickListener(new e());
    }

    private void N() {
        String replace = "http://{ipadd:port}/iptvepg/{frame}/sdk_enabledcomments.jsp".replace("http://{ipadd:port}/iptvepg/{frame}/", com.zte.iptvclient.android.common.f.b.i.f());
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", com.zte.iptvclient.android.common.f.b.i.h());
        sDKNetHTTPRequest.setCharset("gbk");
        sDKNetHTTPRequest.startRequest(replace, HttpRequest.METHOD_GET, new f());
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        L();
        M();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        com.zte.iptvclient.android.mobile.e0.f.b.a(true);
        Window window = this.h.getWindow();
        if (window != null) {
            window.setSoftInputMode(32);
        }
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.C = new com.zte.iptvclient.android.common.j.h(this.h);
        this.w = arguments.getString("contentCode");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate;
        if (BaseApp.a(this.h)) {
            inflate = layoutInflater.inflate(R.layout.bt_fragment_comment_hd, viewGroup, false);
        } else {
            inflate = layoutInflater.inflate(R.layout.bt_fragment_comment, viewGroup, false);
        }
        d(inflate);
        N();
        K();
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.zte.iptvclient.android.mobile.e0.f.b.a(false);
    }

    private void d(View view) {
        if (!BaseApp.a(this.h)) {
            TextView textView = (TextView) view.findViewById(R.id.top);
            int a2 = v.a();
            if (a2 <= 0) {
                a2 = 60;
            }
            textView.setHeight(a2);
        }
        View findViewById = view.findViewById(R.id.btn_back);
        this.p = findViewById;
        findViewById.setVisibility(0);
        TextView textView2 = (TextView) view.findViewById(R.id.title_txt);
        textView2.setText(R.string.comment);
        textView2.setTextSize(20.0f);
        this.q = (RecyclerView) view.findViewById(R.id.comments_rv);
        this.A = (TextView) view.findViewById(R.id.error_msg);
        com.zte.iptvclient.common.uiframe.f.a(textView2);
        com.zte.iptvclient.common.uiframe.f.a(this.p);
        com.zte.iptvclient.common.uiframe.f.a(this.A);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.title_layout));
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_empty);
        this.r = relativeLayout;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout);
        com.zte.iptvclient.common.uiframe.f.a(this.r.findViewById(R.id.ll_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.r.findViewById(R.id.img_pullrefresh_icon));
        com.zte.iptvclient.common.uiframe.f.a(this.r.findViewById(R.id.txt_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.r.findViewById(R.id.refresh_image));
        this.r.setVisibility(8);
        ((TextView) this.r.findViewById(R.id.txt_pullrefresh)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.there_is_no_collection));
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) view.findViewById(R.id.refreshLayout);
        this.s = smartRefreshLayout;
        smartRefreshLayout.a(new DefaultRefreshHeader(this.h));
        this.s.a(new DefaultRefreshFooter(this.h));
        this.s.a(false);
        this.s.c(false);
        SmartRefreshLayout smartRefreshLayout2 = this.s;
        SupportActivity supportActivity = this.h;
        smartRefreshLayout2.e(com.zte.iptvclient.android.common.k.g.a(supportActivity, supportActivity.getResources().getDimension(R.dimen.refresh_footer_height)));
        SmartRefreshLayout smartRefreshLayout3 = this.s;
        SupportActivity supportActivity2 = this.h;
        smartRefreshLayout3.f(com.zte.iptvclient.android.common.k.g.a(supportActivity2, supportActivity2.getResources().getDimension(R.dimen.refresh_header_height)));
        this.y = (TextView) view.findViewById(R.id.tv_comment_content);
        EditText editText = (EditText) view.findViewById(R.id.et_comment_input);
        this.z = editText;
        editText.setOnClickListener(new ViewOnClickListenerC0223a());
        this.z.addTextChangedListener(new b());
    }

    @Override // com.scwang.smartrefresh.layout.d.a
    public void b(com.scwang.smartrefresh.layout.a.h hVar) {
        if (this.x.size() < 10) {
            J();
        } else {
            this.v++;
            L();
        }
    }

    public void a(h hVar) {
        this.u = hVar;
    }

    @Override // com.scwang.smartrefresh.layout.d.c
    public void a(com.scwang.smartrefresh.layout.a.h hVar) {
        ArrayList<Comment> arrayList = this.x;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.v = 1;
        L();
    }
}
