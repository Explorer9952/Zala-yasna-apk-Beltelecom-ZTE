package com.zte.iptvclient.android.mobile.e0.e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.http.bean.HttpRequest;
import com.zte.iptvclient.android.common.javabean.Comment;
import com.zte.iptvclient.android.zala.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BTCommentWebFragment.java */
/* loaded from: classes2.dex */
public class b extends RecyclerView.g<C0226b> {

    /* renamed from: c, reason: collision with root package name */
    private Context f5845c;

    /* renamed from: d, reason: collision with root package name */
    private List<Comment> f5846d;
    private String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BTCommentWebFragment.java */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ C0226b f5847a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f5848b;

        /* compiled from: BTCommentWebFragment.java */
        /* renamed from: com.zte.iptvclient.android.mobile.e0.e.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0225a implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
            C0225a() {
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str) {
                b.this.f5846d.remove(a.this.f5848b);
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(b.this.f5845c.getResources().getString(R.string.delete_comment_success));
                b.this.d();
                a.this.f5847a.x.setEnabled(true);
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str) {
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(b.this.f5845c.getResources().getString(R.string.delete_comment_faiture));
                a.this.f5847a.x.setEnabled(true);
            }
        }

        a(C0226b c0226b, int i) {
            this.f5847a = c0226b;
            this.f5848b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f5847a.x.setEnabled(false);
            String str = "http://{ipadd:port}/iptvepg/{frame}/sdk_delcomments.jsp".replace("http://{ipadd:port}/iptvepg/{frame}/", com.zte.iptvclient.android.common.f.b.i.f()) + "?commentsid=" + ((Comment) b.this.f5846d.get(this.f5848b)).getCommentsid() + "&publishdate=" + ((Comment) b.this.f5846d.get(this.f5848b)).getPublishdate();
            SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
            sDKNetHTTPRequest.setHeader("Cookie", com.zte.iptvclient.android.common.f.b.i.h());
            sDKNetHTTPRequest.setCharset("gbk");
            sDKNetHTTPRequest.startRequest(str, HttpRequest.METHOD_GET, new C0225a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BTCommentWebFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.e0.e.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0226b extends RecyclerView.b0 {
        TextView t;
        TextView u;
        TextView v;
        ImageView w;
        ImageView x;

        public C0226b(View view) {
            super(view);
            this.t = (TextView) view.findViewById(R.id.tv_comment_name);
            this.u = (TextView) view.findViewById(R.id.tv_comment_content);
            this.v = (TextView) view.findViewById(R.id.comment_time);
            this.w = (ImageView) view.findViewById(R.id.iv_comment_head);
            this.x = (ImageView) view.findViewById(R.id.del_comment);
        }

        public void a(Comment comment) {
            String usercode = comment.getUsercode();
            this.t.setText(usercode);
            this.u.setText(comment.getComments());
            try {
                this.v.setText(new SimpleDateFormat("dd.MM.yyyy HH:mm").format(new SimpleDateFormat("yyyyMMddHHmmss").parse(comment.getPublishdate())));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            com.bumptech.glide.d<String> a2 = com.bumptech.glide.i.b(b.this.f5845c).a("");
            a2.b(R.drawable.profile_userpic);
            a2.a(this.w);
            if (usercode.equals(b.this.e)) {
                this.x.setVisibility(0);
            } else {
                this.x.setVisibility(8);
            }
        }
    }

    public b(Context context, List<Comment> list, String str) {
        this.f5845c = context;
        this.f5846d = list;
        this.e = str;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(C0226b c0226b, int i) {
        c0226b.a(this.f5846d.get(i));
        c0226b.x.setOnClickListener(new a(c0226b, i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int a() {
        List<Comment> list = this.f5846d;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public C0226b b(ViewGroup viewGroup, int i) {
        return new C0226b(LayoutInflater.from(this.f5845c).inflate(R.layout.comment_holder_layout, viewGroup, false));
    }
}
