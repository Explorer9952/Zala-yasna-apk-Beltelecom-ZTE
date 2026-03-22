package com.zte.iptvclient.android.common.player.multiplay.e;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;

/* compiled from: ModeSelectVerPopWindow.java */
/* loaded from: classes.dex */
public class b extends PopupWindow {

    /* renamed from: a, reason: collision with root package name */
    private e f5203a;

    /* renamed from: b, reason: collision with root package name */
    private View f5204b;

    /* renamed from: c, reason: collision with root package name */
    private ImageView f5205c;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f5206d;
    private ImageView e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ModeSelectVerPopWindow.java */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ModeSelectVerPopWindow.java */
    /* renamed from: com.zte.iptvclient.android.common.player.multiplay.e.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0160b implements View.OnClickListener {
        ViewOnClickListenerC0160b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f5203a != null) {
                b.this.f5203a.a(1);
                b.this.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ModeSelectVerPopWindow.java */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f5203a != null) {
                b.this.f5203a.a(2);
                b.this.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ModeSelectVerPopWindow.java */
    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f5203a != null) {
                b.this.f5203a.a(3);
                b.this.dismiss();
            }
        }
    }

    /* compiled from: ModeSelectVerPopWindow.java */
    /* loaded from: classes.dex */
    public interface e {
        void a(int i);
    }

    public b(Activity activity, int i, e eVar) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.multiplay_mode_select_vertical_layout, (ViewGroup) null);
        this.f5204b = inflate;
        setContentView(inflate);
        this.f5203a = eVar;
        setWidth(-2);
        setHeight(-1);
        setBackgroundDrawable(new BitmapDrawable());
        setOutsideTouchable(true);
        setAnimationStyle(R.style.mypopwindow_anim_right);
        b(this.f5204b);
        a(i);
        a();
    }

    private void b(View view) {
        this.f5205c = (ImageView) view.findViewById(R.id.ver_mod1);
        this.f5206d = (ImageView) view.findViewById(R.id.ver_mod2);
        this.e = (ImageView) view.findViewById(R.id.ver_mod3);
        TextView textView = (TextView) view.findViewById(R.id.tv_multi_screen_mode_select);
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.multi_screen_mode_select));
        f.a(textView);
        f.a(view.findViewById(R.id.mod_select_vertical_layout));
        f.a(view.findViewById(R.id.ll_mode_ver_select));
        f.a(view.findViewById(R.id.ver_mod1));
        f.a(view.findViewById(R.id.ver_mod2));
        f.a(view.findViewById(R.id.ver_mod3));
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
    }

    private void a(int i) {
        switch (i) {
            case 1:
                this.f5205c.setImageResource(R.drawable.multiscreen_mode_one_selected);
                this.f5206d.setImageResource(R.drawable.multiscreen_mode_two_normal);
                this.e.setImageResource(R.drawable.multiscreen_mode_three_normal);
                return;
            case 2:
                this.f5205c.setImageResource(R.drawable.multiscreen_mode_one_normal);
                this.f5206d.setImageResource(R.drawable.multiscreen_mode_two_selected);
                this.e.setImageResource(R.drawable.multiscreen_mode_three_normal);
                return;
            case 3:
                this.f5205c.setImageResource(R.drawable.multiscreen_mode_one_normal);
                this.f5206d.setImageResource(R.drawable.multiscreen_mode_two_normal);
                this.e.setImageResource(R.drawable.multiscreen_mode_three_selected);
                return;
            case 4:
                this.f5205c.setImageResource(R.drawable.multiscreen_mode_four_selected);
                this.f5206d.setImageResource(R.drawable.multiscreen_mode_five_normal);
                this.e.setImageResource(R.drawable.multiscreen_mode_six_normal);
                return;
            case 5:
                this.f5205c.setImageResource(R.drawable.multiscreen_mode_four_normal);
                this.f5206d.setImageResource(R.drawable.multiscreen_mode_five_selected);
                this.e.setImageResource(R.drawable.multiscreen_mode_six_normal);
                return;
            case 6:
                this.f5205c.setImageResource(R.drawable.multiscreen_mode_four_normal);
                this.f5206d.setImageResource(R.drawable.multiscreen_mode_five_normal);
                this.e.setImageResource(R.drawable.multiscreen_mode_six_selected);
                return;
            case 7:
                this.f5205c.setImageResource(R.drawable.multiscreen_mode_seven_selected);
                this.f5206d.setImageResource(R.drawable.multiscreen_mode_eight_normal);
                this.e.setImageResource(R.drawable.multiscreen_mode_nine_normal);
                return;
            case 8:
                this.f5205c.setImageResource(R.drawable.multiscreen_mode_seven_normal);
                this.f5206d.setImageResource(R.drawable.multiscreen_mode_eight_selected);
                this.e.setImageResource(R.drawable.multiscreen_mode_nine_normal);
                return;
            case 9:
                this.f5205c.setImageResource(R.drawable.multiscreen_mode_seven_normal);
                this.f5206d.setImageResource(R.drawable.multiscreen_mode_eight_normal);
                this.e.setImageResource(R.drawable.multiscreen_mode_nine_selected);
                return;
            default:
                return;
        }
    }

    private void a() {
        this.f5204b.setOnClickListener(new a());
        this.f5205c.setOnClickListener(new ViewOnClickListenerC0160b());
        this.f5206d.setOnClickListener(new c());
        this.e.setOnClickListener(new d());
    }

    public void a(View view) {
        showAtLocation(view, 5, 0, 0);
    }
}
