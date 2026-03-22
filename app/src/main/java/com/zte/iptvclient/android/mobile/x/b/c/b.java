package com.zte.iptvclient.android.mobile.x.b.c;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;

/* compiled from: VideoCaptureShareDialog.java */
/* loaded from: classes2.dex */
public class b extends PopupWindow {

    /* renamed from: a, reason: collision with root package name */
    private Activity f7773a;

    /* renamed from: b, reason: collision with root package name */
    private View f7774b;

    /* renamed from: c, reason: collision with root package name */
    private LayoutInflater f7775c;

    /* renamed from: d, reason: collision with root package name */
    private Button f7776d;
    private LinearLayout e;
    private LinearLayout f;
    private d g;
    private TextView h;
    private TextView i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoCaptureShareDialog.java */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoCaptureShareDialog.java */
    /* renamed from: com.zte.iptvclient.android.mobile.x.b.c.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class ViewOnClickListenerC0395b implements View.OnClickListener {
        ViewOnClickListenerC0395b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
            b.this.g.a(60);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoCaptureShareDialog.java */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
            b.this.g.a(30);
        }
    }

    /* compiled from: VideoCaptureShareDialog.java */
    /* loaded from: classes2.dex */
    public interface d {
        void a(int i);
    }

    public b(Activity activity, d dVar) {
        this.f7773a = activity;
        LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService("layout_inflater");
        this.f7775c = layoutInflater;
        View inflate = layoutInflater.inflate(R.layout.video_capture_share_pop_dialog, (ViewGroup) null);
        this.f7774b = inflate;
        this.g = dVar;
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
        Button button = (Button) this.f7774b.findViewById(R.id.btn_cancel);
        this.f7776d = button;
        button.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_cancel));
        this.e = (LinearLayout) this.f7774b.findViewById(R.id.ll_recordtime_half_minute);
        this.f = (LinearLayout) this.f7774b.findViewById(R.id.ll_recordtime_one_minute);
        TextView textView = (TextView) this.f7774b.findViewById(R.id.txt_half_minute);
        this.h = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.share_record_video_top_30s));
        TextView textView2 = (TextView) this.f7774b.findViewById(R.id.txt_one_minute);
        this.i = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.share_record_video_top_60s));
        f.a(this.f7776d);
        f.a(this.e);
        f.a(this.f);
        f.a(this.f7774b.findViewById(R.id.ll_filter_container));
        f.a(this.f7774b.findViewById(R.id.img_half_minute));
        f.a(this.h);
        f.a(this.f7774b.findViewById(R.id.img_one_minute));
        f.a(this.i);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        Window window;
        WindowManager.LayoutParams attributes;
        Activity activity = this.f7773a;
        if (activity != null && (window = activity.getWindow()) != null && (attributes = window.getAttributes()) != null) {
            attributes.alpha = 1.0f;
            window.setAttributes(attributes);
        }
        super.dismiss();
    }

    private void a() {
        this.f7776d.setOnClickListener(new a());
        this.f.setOnClickListener(new ViewOnClickListenerC0395b());
        this.e.setOnClickListener(new c());
    }

    public void a(View view) {
        Window window;
        WindowManager.LayoutParams attributes;
        setSoftInputMode(16);
        Activity activity = this.f7773a;
        if (activity != null && (window = activity.getWindow()) != null && (attributes = window.getAttributes()) != null) {
            attributes.alpha = 0.5f;
            window.setAttributes(attributes);
        }
        Activity activity2 = this.f7773a;
        if (activity2 != null && activity2.getResources().getConfiguration().orientation == 2) {
            this.f7774b.setSystemUiVisibility(3846);
        }
        showAtLocation(view, 80, 0, 0);
    }
}
