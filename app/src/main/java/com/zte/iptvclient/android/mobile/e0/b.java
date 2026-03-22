package com.zte.iptvclient.android.mobile.e0;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.video.androidsdk.common.config.ConfigMgr;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.k.r;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.i;
import com.zte.iptvclient.common.uiframe.j;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: VideoDetailRatingDialog.java */
/* loaded from: classes.dex */
public class b extends PopupWindow {

    /* renamed from: a, reason: collision with root package name */
    private View f5782a;

    /* renamed from: b, reason: collision with root package name */
    private Context f5783b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f5784c;

    /* renamed from: d, reason: collision with root package name */
    private RatingBar f5785d;
    private InterfaceC0216b e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoDetailRatingDialog.java */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.e != null) {
                b.this.e.a(b.this.f5785d.getRating());
            }
            b.this.dismiss();
        }
    }

    /* compiled from: VideoDetailRatingDialog.java */
    /* renamed from: com.zte.iptvclient.android.mobile.e0.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0216b {
        void a(float f);
    }

    public b(Context context, float f, InterfaceC0216b interfaceC0216b) {
        super(context);
        this.f5783b = context;
        this.e = interfaceC0216b;
        this.f5782a = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.video_detail_popup_rating, (ViewGroup) null);
        if (!BaseApp.a(context)) {
            this.f5782a.findViewById(R.id.ll_rating_star_score_container).setBackgroundColor(androidx.core.content.a.a(context, R.color.rating_dialog_confirm_textcolor));
        }
        setContentView(this.f5782a);
        setWidth(-1);
        setHeight(-2);
        setBackgroundDrawable(new BitmapDrawable());
        setOutsideTouchable(true);
        setFocusable(true);
        setAnimationStyle(R.style.mypopwindow_anim_bottom_up);
        b();
        a();
        EventBus.getDefault().register(this);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        Window window;
        WindowManager.LayoutParams attributes;
        Context context = this.f5783b;
        if ((context instanceof FragmentActivity) && (window = ((FragmentActivity) context).getWindow()) != null && (attributes = window.getAttributes()) != null) {
            attributes.alpha = 1.0f;
            window.setAttributes(attributes);
        }
        EventBus.getDefault().unregister(this);
        super.dismiss();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.mobile.e0.a aVar) {
        if (aVar.a()) {
            dismiss();
        }
    }

    private void a() {
        this.f5784c.setOnClickListener(new a());
    }

    private void b() {
        TextView textView = (TextView) this.f5782a.findViewById(R.id.tv_rating_hint);
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.rating_hint));
        TextView textView2 = (TextView) this.f5782a.findViewById(R.id.btn_ok);
        this.f5784c = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_confirm));
        if (BaseApp.a(this.f5783b)) {
            textView.setTextSize(2, 16.0f);
            int a2 = r.a(this.f5783b);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f5784c.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = a2 / 3;
                this.f5784c.setLayoutParams(layoutParams);
            }
        } else {
            textView.setTextSize(2, 14.0f);
        }
        RatingBar ratingBar = (RatingBar) this.f5782a.findViewById(R.id.ratingbar);
        this.f5785d = ratingBar;
        i.b(ratingBar, j.a(R.drawable.detail_popup_star_color), j.a(R.drawable.detail_popup_star_grey));
        this.f5785d.setRating(10.0f);
        if ("1".equals(ConfigMgr.readPropertie("isBt"))) {
            this.f5784c.setBackgroundResource(R.drawable.video_rating_bt_bg);
        }
    }

    public void a(View view) {
        Window window;
        WindowManager.LayoutParams attributes;
        showAtLocation(view, 80, 0, 0);
        Context context = this.f5783b;
        if (!(context instanceof FragmentActivity) || (window = ((FragmentActivity) context).getWindow()) == null || (attributes = window.getAttributes()) == null) {
            return;
        }
        attributes.alpha = 0.5f;
        window.setAttributes(attributes);
    }
}
