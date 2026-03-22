package com.zte.iptvclient.android.mobile.order.helper.f;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.zte.iptvclient.android.zala.R;

/* compiled from: PayTimeoutDialog.java */
/* loaded from: classes.dex */
public class c extends PopupWindow {

    /* renamed from: a, reason: collision with root package name */
    private View f6973a;

    /* renamed from: b, reason: collision with root package name */
    private Context f6974b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f6975c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f6976d;
    private InterfaceC0328c e;
    private TextView f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PayTimeoutDialog.java */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PayTimeoutDialog.java */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.e != null) {
                c.this.e.a();
            }
            c.this.dismiss();
        }
    }

    /* compiled from: PayTimeoutDialog.java */
    /* renamed from: com.zte.iptvclient.android.mobile.order.helper.f.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0328c {
        void a();
    }

    public c(Context context, InterfaceC0328c interfaceC0328c) {
        super(context);
        this.f6974b = context;
        this.e = interfaceC0328c;
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.pay_timeout_try_again, (ViewGroup) null);
        this.f6973a = inflate;
        setContentView(inflate);
        setWidth(-1);
        setHeight(-2);
        setBackgroundDrawable(new BitmapDrawable());
        setOutsideTouchable(true);
        setFocusable(true);
        setAnimationStyle(R.style.mypopwindow_anim_bottom_up);
        b();
        a();
    }

    private void b() {
        this.f = (TextView) this.f6973a.findViewById(R.id.txt_pay_timeout);
        this.f6975c = (TextView) this.f6973a.findViewById(R.id.txtview_confirm);
        this.f6976d = (TextView) this.f6973a.findViewById(R.id.txtview_cancel);
        this.f.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.pay_timeout));
        this.f6975c.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_confirm));
        this.f6976d.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_cancel));
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        Window window;
        WindowManager.LayoutParams attributes;
        Context context = this.f6974b;
        if ((context instanceof FragmentActivity) && (window = ((FragmentActivity) context).getWindow()) != null && (attributes = window.getAttributes()) != null) {
            attributes.alpha = 1.0f;
            window.setAttributes(attributes);
        }
        super.dismiss();
    }

    private void a() {
        this.f6976d.setOnClickListener(new a());
        this.f6975c.setOnClickListener(new b());
    }

    public void a(View view) {
        Window window;
        WindowManager.LayoutParams attributes;
        showAtLocation(view, 80, 0, 0);
        Context context = this.f6974b;
        if (!(context instanceof FragmentActivity) || (window = ((FragmentActivity) context).getWindow()) == null || (attributes = window.getAttributes()) == null) {
            return;
        }
        attributes.alpha = 0.5f;
        window.setAttributes(attributes);
    }
}
