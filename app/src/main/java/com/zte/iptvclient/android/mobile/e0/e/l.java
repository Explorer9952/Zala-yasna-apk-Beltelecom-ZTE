package com.zte.iptvclient.android.mobile.e0.e;

import android.content.Context;
import android.net.Uri;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
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

/* compiled from: TVCommentView.java */
/* loaded from: classes2.dex */
public class l extends LinearLayout implements com.scwang.smartrefresh.layout.d.a, com.scwang.smartrefresh.layout.d.c {

    /* renamed from: a, reason: collision with root package name */
    private SupportActivity f6074a;

    /* renamed from: b, reason: collision with root package name */
    private View f6075b;

    /* renamed from: c, reason: collision with root package name */
    private RecyclerView f6076c;

    /* renamed from: d, reason: collision with root package name */
    private RelativeLayout f6077d;
    private SmartRefreshLayout e;
    private com.zte.iptvclient.android.mobile.e0.e.b f;
    private int g;
    private String h;
    private ArrayList<Comment> i;
    private TextView j;
    private EditText k;
    private TextView l;
    private String m;
    private com.zte.iptvclient.android.common.j.h n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TVCommentView.java */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Window window = l.this.f6074a.getWindow();
            if (window != null) {
                window.setSoftInputMode(32);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TVCommentView.java */
    /* loaded from: classes2.dex */
    public class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.length() > 500) {
                l.this.l.setVisibility(0);
                l.this.j.setEnabled(false);
                l.this.j.setBackgroundResource(R.drawable.comment_release_dark_bg);
            } else {
                l.this.l.setVisibility(8);
                l.this.j.setEnabled(true);
                l.this.j.setBackgroundResource(R.drawable.comment_release_bg);
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
    /* compiled from: TVCommentView.java */
    /* loaded from: classes2.dex */
    public class c implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        c() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!"0".equals(jSONObject.optString("returncode"))) {
                    l.this.m = "1";
                } else {
                    l.this.m = jSONObject.optString("isenabledcomments");
                }
            } catch (JSONException e) {
                e.printStackTrace();
                l.this.m = "1";
            }
            if (l.this.m.equals("1")) {
                l.this.k.setEnabled(false);
                l.this.k.setHint(l.this.f6074a.getResources().getString(R.string.forbidden_words));
                l.this.j.setEnabled(false);
                l.this.j.setBackgroundResource(R.drawable.comment_release_dark_bg);
                return;
            }
            l.this.k.setEnabled(true);
            l.this.k.setHint("");
            l.this.j.setEnabled(true);
            l.this.j.setBackgroundResource(R.drawable.comment_release_bg);
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            l.this.m = "1";
            if (l.this.m.equals("1")) {
                l.this.k.setEnabled(false);
                l.this.k.setHint(l.this.f6074a.getResources().getString(R.string.forbidden_words));
                l.this.j.setEnabled(false);
                l.this.j.setBackgroundResource(R.drawable.comment_release_dark_bg);
                return;
            }
            l.this.k.setEnabled(true);
            l.this.k.setHint("");
            l.this.j.setEnabled(true);
            l.this.j.setBackgroundResource(R.drawable.comment_release_bg);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TVCommentView.java */
    /* loaded from: classes2.dex */
    public class d implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        d() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if ("0".equals(jSONObject.optString("returncode"))) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("data");
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        l.this.i.add(Comment.parseJsonToBean(optJSONArray.getJSONObject(i)));
                    }
                    LogEx.d("TVCommentView", "mListComments size = " + l.this.i.size());
                }
                l.this.b();
            } catch (JSONException e) {
                e.printStackTrace();
                l.this.b();
                LogEx.d("TVCommentView", "e = " + e.toString());
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            l.this.b();
            LogEx.d("sdk_querycomments", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TVCommentView.java */
    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.this.removeAllViews();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TVCommentView.java */
    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.this.j.setEnabled(false);
            l.this.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TVCommentView.java */
    /* loaded from: classes2.dex */
    public class g implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f6084a;

        /* compiled from: TVCommentView.java */
        /* loaded from: classes2.dex */
        class a extends TimerTask {
            a() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (l.this.i != null) {
                    l.this.i.clear();
                }
                l.this.g = 1;
                l.this.d();
            }
        }

        g(String str) {
            this.f6084a = str;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            l.this.j.setEnabled(true);
            try {
                if ("0".equals(new JSONObject(str).optString("returncode"))) {
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.toast_comment_s);
                    CommentBean commentBean = new CommentBean();
                    commentBean.setContent(this.f6084a);
                    commentBean.setCreatetime(new SimpleDateFormat("yyyyMMddHHmmss").format(s.b()));
                    l.this.k.setText("");
                    l.this.f6076c.m(0);
                    new Timer().schedule(new a(), 1000L);
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
            l.this.j.setEnabled(true);
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.toast_comment_f);
        }
    }

    public l(Context context, SupportActivity supportActivity, String str) {
        super(context);
        this.g = 1;
        this.f6074a = supportActivity;
        Window window = supportActivity.getWindow();
        if (window != null) {
            window.setSoftInputMode(32);
        }
        this.n = new com.zte.iptvclient.android.common.j.h(this.f6074a);
        this.h = str;
        f();
        g();
        c();
        d();
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.e.j();
        this.e.a();
        com.zte.iptvclient.android.mobile.e0.e.b bVar = this.f;
        if (bVar == null) {
            this.f = new com.zte.iptvclient.android.mobile.e0.e.b(this.f6074a, this.i, this.n.V());
            this.f6076c.a(new com.zte.iptvclient.android.common.customview.b.a.a(this.f6074a, 0));
            this.f6076c.a(new LinearLayoutManager(this.f6074a));
            this.f6076c.a(this.f);
        } else {
            bVar.d();
        }
        if (this.i.size() > 0) {
            this.f6077d.setVisibility(8);
            this.f6076c.setVisibility(0);
        } else {
            this.f6077d.setVisibility(0);
            this.f6076c.setVisibility(8);
        }
    }

    private void c() {
        this.i = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        String str = "http://{ipadd:port}/iptvepg/{frame}/sdk_querycomments.jsp".replace("http://{ipadd:port}/iptvepg/{frame}/", com.zte.iptvclient.android.common.f.b.i.f()) + "?action=0&contentcode=" + this.h + "&pageno=" + String.valueOf(this.g) + "&numperpage=10";
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", com.zte.iptvclient.android.common.f.b.i.h());
        sDKNetHTTPRequest.setCharset("gbk");
        sDKNetHTTPRequest.startRequest(str, HttpRequest.METHOD_GET, new d());
    }

    private void e() {
        this.f6075b.setOnClickListener(new e());
        this.e.a((com.scwang.smartrefresh.layout.d.c) this);
        this.e.a((com.scwang.smartrefresh.layout.d.a) this);
        this.j.setOnClickListener(new f());
    }

    private void f() {
        View inflate = View.inflate(this.f6074a, R.layout.bt_tv_comment_hd, this);
        if (!BaseApp.a(this.f6074a)) {
            TextView textView = (TextView) inflate.findViewById(R.id.top);
            int a2 = v.a();
            if (a2 <= 0) {
                a2 = 60;
            }
            textView.setHeight(a2);
        }
        View findViewById = inflate.findViewById(R.id.btn_back);
        this.f6075b = findViewById;
        findViewById.setVisibility(0);
        TextView textView2 = (TextView) inflate.findViewById(R.id.title_txt);
        textView2.setText(R.string.comment);
        textView2.setTextSize(20.0f);
        this.f6076c = (RecyclerView) inflate.findViewById(R.id.comments_rv);
        this.l = (TextView) inflate.findViewById(R.id.error_msg);
        com.zte.iptvclient.common.uiframe.f.a(textView2);
        com.zte.iptvclient.common.uiframe.f.a(this.f6075b);
        com.zte.iptvclient.common.uiframe.f.a(this.l);
        com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.title_layout));
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.rl_empty);
        this.f6077d = relativeLayout;
        com.zte.iptvclient.common.uiframe.f.a(relativeLayout);
        com.zte.iptvclient.common.uiframe.f.a(this.f6077d.findViewById(R.id.ll_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.f6077d.findViewById(R.id.img_pullrefresh_icon));
        com.zte.iptvclient.common.uiframe.f.a(this.f6077d.findViewById(R.id.txt_pullrefresh));
        com.zte.iptvclient.common.uiframe.f.a(this.f6077d.findViewById(R.id.refresh_image));
        this.f6077d.setVisibility(8);
        ((TextView) this.f6077d.findViewById(R.id.txt_pullrefresh)).setText(this.f6074a.getResources().getString(R.string.there_is_no_collection));
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) inflate.findViewById(R.id.refreshLayout);
        this.e = smartRefreshLayout;
        smartRefreshLayout.a(new DefaultRefreshHeader(this.f6074a));
        this.e.a(new DefaultRefreshFooter(this.f6074a));
        this.e.a(false);
        this.e.c(false);
        SmartRefreshLayout smartRefreshLayout2 = this.e;
        SupportActivity supportActivity = this.f6074a;
        smartRefreshLayout2.e(com.zte.iptvclient.android.common.k.g.a(supportActivity, supportActivity.getResources().getDimension(R.dimen.refresh_footer_height)));
        SmartRefreshLayout smartRefreshLayout3 = this.e;
        SupportActivity supportActivity2 = this.f6074a;
        smartRefreshLayout3.f(com.zte.iptvclient.android.common.k.g.a(supportActivity2, supportActivity2.getResources().getDimension(R.dimen.refresh_header_height)));
        this.j = (TextView) inflate.findViewById(R.id.tv_comment_content);
        EditText editText = (EditText) inflate.findViewById(R.id.et_comment_input);
        this.k = editText;
        editText.setOnClickListener(new a());
        this.k.addTextChangedListener(new b());
    }

    private void g() {
        String replace = "http://{ipadd:port}/iptvepg/{frame}/sdk_enabledcomments.jsp".replace("http://{ipadd:port}/iptvepg/{frame}/", com.zte.iptvclient.android.common.f.b.i.f());
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", com.zte.iptvclient.android.common.f.b.i.h());
        sDKNetHTTPRequest.setCharset("gbk");
        sDKNetHTTPRequest.startRequest(replace, HttpRequest.METHOD_GET, new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        String encode = Uri.encode(this.k.getText().toString());
        String str = "http://{ipadd:port}/iptvepg/{frame}/sdk_addcomments.jsp".replace("http://{ipadd:port}/iptvepg/{frame}/", com.zte.iptvclient.android.common.f.b.i.f()) + "?comments=" + encode + "&contentcode=" + this.h;
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", com.zte.iptvclient.android.common.f.b.i.h());
        sDKNetHTTPRequest.setCharset("gbk");
        sDKNetHTTPRequest.startRequest(str, HttpRequest.METHOD_GET, new g(encode));
    }

    @Override // com.scwang.smartrefresh.layout.d.c
    public void a(com.scwang.smartrefresh.layout.a.h hVar) {
        ArrayList<Comment> arrayList = this.i;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.g = 1;
        d();
    }

    @Override // com.scwang.smartrefresh.layout.d.a
    public void b(com.scwang.smartrefresh.layout.a.h hVar) {
        if (this.i.size() < 10) {
            b();
        } else {
            this.g++;
            d();
        }
    }
}
