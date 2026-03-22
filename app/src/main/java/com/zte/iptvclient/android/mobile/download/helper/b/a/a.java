package com.zte.iptvclient.android.mobile.download.helper.b.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;

/* compiled from: DownloadFilterPopwin.java */
/* loaded from: classes.dex */
public class a extends PopupWindow {

    /* renamed from: a, reason: collision with root package name */
    private Context f5757a;

    /* renamed from: b, reason: collision with root package name */
    private View f5758b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f5759c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f5760d;
    private LinearLayout e;
    private int f;
    private d g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadFilterPopwin.java */
    /* renamed from: com.zte.iptvclient.android.mobile.download.helper.b.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0212a implements PopupWindow.OnDismissListener {
        C0212a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            a.this.a(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadFilterPopwin.java */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.g == null) {
                return;
            }
            a.this.g.a();
            a.this.dismiss();
            a.this.a(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DownloadFilterPopwin.java */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.g == null) {
                return;
            }
            a.this.g.b();
            a.this.dismiss();
            a.this.a(1.0f);
        }
    }

    /* compiled from: DownloadFilterPopwin.java */
    /* loaded from: classes.dex */
    public interface d {
        void a();

        void b();
    }

    public a(Context context) {
        super(context);
        this.f5757a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.download_filter_popwin, (ViewGroup) null);
        this.f5758b = inflate;
        inflate.measure(0, 0);
        this.f = this.f5758b.getMeasuredWidth();
        this.e = (LinearLayout) this.f5758b.findViewById(R.id.popwin_filter_llayout);
        this.f5759c = (TextView) this.f5758b.findViewById(R.id.popwin_filter_local_txtview);
        this.f5760d = (TextView) this.f5758b.findViewById(R.id.popwin_filter_stb_txtview);
        f.a(this.e);
        f.a(this.f5759c);
        f.a(this.f5760d);
        this.f5759c.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_filter_local));
        this.f5760d.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_filter_stb));
        if (com.zte.iptvclient.android.mobile.download.helper.a.n().k() == 3) {
            a();
        } else {
            b();
        }
        setContentView(this.f5758b);
        setWidth(-2);
        setHeight(-2);
        setBackgroundDrawable(new ColorDrawable(0));
        setOutsideTouchable(true);
        setFocusable(true);
        c();
    }

    private void c() {
        setOnDismissListener(new C0212a());
        this.f5759c.setOnClickListener(new b());
        this.f5760d.setOnClickListener(new c());
    }

    public void b() {
        this.f5759c.setTextColor(this.f5757a.getResources().getColor(R.color.red));
        this.f5760d.setTextColor(this.f5757a.getResources().getColor(R.color.text_grey_new3));
    }

    public void a(d dVar) {
        this.g = dVar;
    }

    public void a() {
        this.f5759c.setTextColor(this.f5757a.getResources().getColor(R.color.text_grey_new3));
        this.f5760d.setTextColor(this.f5757a.getResources().getColor(R.color.red));
    }

    public void a(View view) {
        if (!isShowing()) {
            a(0.5f);
            double d2 = this.f;
            double b2 = f.b();
            Double.isNaN(d2);
            double d3 = -(d2 * b2);
            double width = view.getWidth() / 2;
            Double.isNaN(width);
            double d4 = d3 + width;
            double a2 = f.a(12);
            Double.isNaN(a2);
            showAsDropDown(view, (int) (d4 + a2), 0);
            return;
        }
        dismiss();
        a(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f) {
        Window window;
        WindowManager.LayoutParams attributes;
        Context context = this.f5757a;
        if (context == null || (window = ((Activity) context).getWindow()) == null || (attributes = window.getAttributes()) == null) {
            return;
        }
        attributes.alpha = f;
        window.addFlags(2);
        window.setAttributes(attributes);
    }
}
