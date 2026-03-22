package com.zte.iptvclient.android.mobile.h.b.b;

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
import com.zte.iptvclient.common.uiframe.f;

/* compiled from: STBMgrBindSTBDialog.java */
/* loaded from: classes.dex */
public class a extends PopupWindow {

    /* renamed from: a, reason: collision with root package name */
    private c f6387a;

    /* renamed from: b, reason: collision with root package name */
    private View f6388b;

    /* renamed from: c, reason: collision with root package name */
    private Context f6389c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f6390d;
    private TextView e;
    private TextView f;
    private String g;
    private String h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: STBMgrBindSTBDialog.java */
    /* renamed from: com.zte.iptvclient.android.mobile.h.b.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0271a implements View.OnClickListener {
        ViewOnClickListenerC0271a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: STBMgrBindSTBDialog.java */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f6387a != null) {
                a.this.dismiss();
                a.this.f6387a.p(a.this.g);
            }
        }
    }

    /* compiled from: STBMgrBindSTBDialog.java */
    /* loaded from: classes.dex */
    public interface c {
        void p(String str);
    }

    public a(Context context, String str, String str2, c cVar) {
        super(context);
        this.f6387a = null;
        this.f6389c = context;
        this.g = str;
        this.h = str2;
        this.f6387a = cVar;
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.stbmgr_popup_bindstb, (ViewGroup) null);
        this.f6388b = inflate;
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

    @Override // android.widget.PopupWindow
    public void dismiss() {
        Window window;
        WindowManager.LayoutParams attributes;
        Context context = this.f6389c;
        if ((context instanceof FragmentActivity) && (window = ((FragmentActivity) context).getWindow()) != null && (attributes = window.getAttributes()) != null) {
            attributes.alpha = 1.0f;
            window.setAttributes(attributes);
        }
        super.dismiss();
    }

    private void a() {
        this.f.setOnClickListener(new ViewOnClickListenerC0271a());
        this.e.setOnClickListener(new b());
    }

    private void b() {
        TextView textView = (TextView) this.f6388b.findViewById(R.id.txt_userid);
        this.f6390d = textView;
        textView.setText(this.h);
        TextView textView2 = (TextView) this.f6388b.findViewById(R.id.txt_pair);
        this.e = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.stbmgr_popup_pair));
        TextView textView3 = (TextView) this.f6388b.findViewById(R.id.txt_cancel);
        this.f = textView3;
        textView3.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.stbmgr_popup_cancel));
        ((TextView) this.f6388b.findViewById(R.id.txt_confrim_binddevice)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.stbmgr_popup_confrim_binddevice));
        f.a(this.f6390d);
        f.a(this.e);
        f.a(this.f);
        f.a(this.f6388b.findViewById(R.id.fl_bindstb_title));
        f.a(this.f6388b.findViewById(R.id.txt_confrim_binddevice));
        f.a(this.f6388b.findViewById(R.id.line));
        f.a(this.f6388b.findViewById(R.id.ll_confirm_btn));
    }

    public void a(View view) {
        Window window;
        WindowManager.LayoutParams attributes;
        showAtLocation(view, 80, 0, 0);
        Context context = this.f6389c;
        if (!(context instanceof FragmentActivity) || (window = ((FragmentActivity) context).getWindow()) == null || (attributes = window.getAttributes()) == null) {
            return;
        }
        attributes.alpha = 0.5f;
        window.setAttributes(attributes);
    }
}
