package com.zte.iptvclient.android.mobile.f0.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.l.a;

/* compiled from: WebFragment.java */
/* loaded from: classes2.dex */
public class c extends com.zte.fragmentlib.b implements a.f {
    private String r;
    private InterfaceC0254c t;
    private a u;
    private d v;
    private b w;
    private com.zte.iptvclient.android.common.l.a p = null;
    private Context q = null;
    private String s = "";

    /* compiled from: WebFragment.java */
    /* loaded from: classes2.dex */
    public interface a {
        void onCancel();
    }

    /* compiled from: WebFragment.java */
    /* loaded from: classes2.dex */
    public interface b {
        void a(String str, String str2, String str3, String str4);
    }

    /* compiled from: WebFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.f0.a.c$c, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0254c {
        void a(String str, String str2);
    }

    /* compiled from: WebFragment.java */
    /* loaded from: classes2.dex */
    public interface d {
        void b();
    }

    public void I() {
        com.zte.iptvclient.android.common.l.a aVar = this.p;
        if (aVar == null || aVar.f4834a == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.s)) {
            this.p = new com.zte.iptvclient.android.common.l.a(this.q, this.r, this.s, this);
        } else {
            this.p.f4834a.reload();
        }
    }

    public void a(InterfaceC0254c interfaceC0254c) {
        this.t = interfaceC0254c;
    }

    @Override // com.zte.iptvclient.android.common.l.a.f
    public void b() {
        d dVar = this.v;
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.p.b();
    }

    @Override // com.zte.fragmentlib.publicbaseclass.skinloader.a, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.q = context;
    }

    @Override // com.zte.iptvclient.android.common.l.a.f
    public void onCancel() {
        this.u.onCancel();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = ((Activity) this.q).getWindow();
        if (window != null) {
            window.addFlags(16777216);
            window.setFlags(16777216, 16777216);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.p == null) {
            if (!TextUtils.isEmpty(this.s)) {
                this.p = new com.zte.iptvclient.android.common.l.a(this.q, this.r, this.s, this);
            } else {
                this.p = new com.zte.iptvclient.android.common.l.a(this.q, this.r, this);
            }
        }
        View a2 = this.p.a(layoutInflater, viewGroup);
        LogEx.w("WebFragment", this.r);
        return a2;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroyView() {
        WebView webView;
        super.onDestroyView();
        LogEx.d("WebFragment", "WebFragment  onDestroyView");
        com.zte.iptvclient.android.common.l.a aVar = this.p;
        if (aVar == null || (webView = aVar.f4834a) == null) {
            return;
        }
        webView.clearHistory();
        this.p.f4834a.clearCache(true);
        this.p.c();
    }

    public void s(String str) {
        this.r = str;
    }

    public void t(String str) {
        this.s = str;
    }

    public void a(a aVar) {
        this.u = aVar;
    }

    public void a(d dVar) {
        this.v = dVar;
    }

    public void a(b bVar) {
        this.w = bVar;
    }

    public void a(Context context) {
        this.q = context;
    }

    @Override // com.zte.iptvclient.android.common.l.a.f
    public void a(String str, String str2) {
        if (StringUtil.isEmptyString(str2)) {
            return;
        }
        this.t.a(str, str2);
    }

    @Override // com.zte.iptvclient.android.common.l.a.f
    public void a(String str, String str2, String str3, String str4) {
        b bVar = this.w;
        if (bVar != null) {
            bVar.a(str, str2, str3, str4);
        }
    }
}
