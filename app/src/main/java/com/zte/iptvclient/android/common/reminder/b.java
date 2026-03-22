package com.zte.iptvclient.android.common.reminder;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.util.TimeUtil;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.customview.viewgroup.scrollview.ScrollViewFixedHeight;
import com.zte.iptvclient.android.common.e.b0.e;
import com.zte.iptvclient.android.common.e.h;
import com.zte.iptvclient.android.common.e.x.p;
import com.zte.iptvclient.android.common.javabean.models.MovieDetailBundleBean;
import com.zte.iptvclient.android.common.javabean.models.PrevueBean;
import com.zte.iptvclient.android.common.k.x;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/* compiled from: MultiAlertsDialog.java */
/* loaded from: classes.dex */
public class b extends Dialog implements DialogInterface {
    private static String j = "MultiAlertsDialog";

    /* renamed from: a, reason: collision with root package name */
    private Context f5227a;

    /* renamed from: b, reason: collision with root package name */
    private RelativeLayout f5228b;

    /* renamed from: c, reason: collision with root package name */
    private LinearLayout f5229c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f5230d;
    private ScrollViewFixedHeight e;
    private LinearLayout f;
    private RelativeLayout g;
    private TextView h;
    private ImageView i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MultiAlertsDialog.java */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
        }
    }

    /* compiled from: MultiAlertsDialog.java */
    /* renamed from: com.zte.iptvclient.android.common.reminder.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class ViewOnClickListenerC0161b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PrevueBean f5232a;

        ViewOnClickListenerC0161b(PrevueBean prevueBean) {
            this.f5232a = prevueBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventBus.getDefault().post(new h(this.f5232a.getChannelcode(), this.f5232a.getRatingid()));
            b.this.dismiss();
            LogEx.d(b.j, "play click event");
        }
    }

    /* compiled from: MultiAlertsDialog.java */
    /* loaded from: classes.dex */
    class c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AlarmVideoBean f5234a;

        c(AlarmVideoBean alarmVideoBean) {
            this.f5234a = alarmVideoBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(this.f5234a.getProgramCode())) {
                b.this.dismiss();
                return;
            }
            String programType = this.f5234a.getProgramType();
            if (TextUtils.isEmpty(programType)) {
                return;
            }
            if (programType.equals("1")) {
                b.this.a(this.f5234a.getProgramCode(), this.f5234a.getColumnCode());
            } else if (programType.equals("14")) {
                b.this.b(this.f5234a.getProgramCode(), this.f5234a.getColumnCode());
            }
            b.this.dismiss();
        }
    }

    public b(Context context) {
        super(context, R.style.commonDialogTheme);
        if ("1".equals(ConfigMgr.readPropertie("isShow"))) {
            super.setContentView(R.layout.at_multi_alerts_dialog);
        } else {
            super.setContentView(R.layout.multi_alerts_dialog);
        }
        this.f5227a = context;
        c();
        setCanceledOnTouchOutside(false);
        EventBus.getDefault().register(this);
    }

    private void c() {
        this.f5228b = (RelativeLayout) findViewById(R.id.common_confirm_dlg_layout);
        this.f5229c = (LinearLayout) findViewById(R.id.ll_dialog_content);
        this.f5230d = (TextView) findViewById(R.id.common_confirm_dlg_title);
        this.i = (ImageView) findViewById(R.id.img_alert);
        this.e = (ScrollViewFixedHeight) findViewById(R.id.alert_scrollview);
        this.f = (LinearLayout) findViewById(R.id.ll_alert);
        this.g = (RelativeLayout) findViewById(R.id.rl_dialog_btn);
        this.h = (TextView) findViewById(R.id.txt_cancel);
        f.a(this.f5228b);
        f.a(this.f5229c);
        f.a(this.f5230d);
        f.a(this.i);
        f.a(this.e);
        f.a(this.f);
        f.a(this.g);
        f.a(this.h);
        this.g.setOnClickListener(new a());
        this.f5230d.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.reminder_live_dialog_title));
        this.h.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.cancel_button));
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        this.f.removeAllViews();
        LogEx.d(j, " dialog dismiss ");
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onEventMainThread(p pVar) {
        com.zte.iptvclient.android.common.j.h hVar = new com.zte.iptvclient.android.common.j.h(this.f5227a);
        PrevueBean a2 = pVar.a();
        if (a2 != null) {
            b();
            View inflate = LayoutInflater.from(this.f5227a).inflate(R.layout.tv_alarm_arrvied_item, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_name);
            TextView textView2 = (TextView) inflate.findViewById(R.id.tv_play_time);
            TextView textView3 = (TextView) inflate.findViewById(R.id.tv_program_name);
            View findViewById = inflate.findViewById(R.id.bottom_line);
            textView.setText(a2.getChannelname());
            if (!TextUtils.isEmpty(a2.getBegintime())) {
                textView2.setText(TimeUtil.format(x.d(a2.getBegintime()), "yyyy.MM.dd HH:mm"));
            }
            textView3.setText(com.zte.iptvclient.android.mobile.f.b.a.a(a2.getRatingid(), a2.getPrevuename(), com.zte.iptvclient.android.common.i.a.a.a(R.string.common_blocktitle), hVar, this.f5227a));
            f.a(inflate.findViewById(R.id.bottom_line));
            f.a(inflate.findViewById(R.id.ll_top));
            f.a(inflate.findViewById(R.id.tv_name));
            f.a(inflate.findViewById(R.id.tv_play_time));
            f.a(inflate.findViewById(R.id.ll_bottom));
            f.a(inflate.findViewById(R.id.tv_program_name));
            ((TextView) inflate.findViewById(R.id.tv_play)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.alert_click_to_watch));
            f.a(inflate.findViewById(R.id.tv_play));
            if (this.f.getChildCount() > 0) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
            inflate.setOnClickListener(new ViewOnClickListenerC0161b(a2));
            LogEx.d(j, "recv TvAlarmArrivedEvent event, tvName : " + a2.getPrevuename() + " , startplaytime : " + a2.getBegintime() + " , programName : " + a2.getPrevuename() + " , channel id " + a2.getChannelcode() + " , channel name : " + a2.getChannelname());
            this.f.addView(inflate);
        }
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }

    private void b() {
        TextView textView = this.f5230d;
        if (textView != null) {
            textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.alert));
        }
        TextView textView2 = this.h;
        if (textView2 != null) {
            textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_cancel));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAMS_PROGRAMCODE, str);
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAM_COLUMNCODE, str2);
        Intent intent = new Intent(this.f5227a, (Class<?>) HostActivity.class);
        bundle.putString("fragmenttype", "moviedetail");
        intent.putExtras(bundle);
        this.f5227a.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAMS_PROGRAMCODE, str);
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAM_COLUMNCODE, str2);
        Intent intent = new Intent(this.f5227a, (Class<?>) HostActivity.class);
        bundle.putString("fragmenttype", "seriesdetail");
        intent.putExtras(bundle);
        this.f5227a.startActivity(intent);
    }

    @Subscribe
    public void onEventMainThread(e eVar) {
        AlarmVideoBean a2 = eVar.a();
        if (a2 != null) {
            b();
            View inflate = LayoutInflater.from(this.f5227a).inflate(R.layout.vod_alarm_arrived_item, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.vod_play)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.alert_click_to_watch));
            TextView textView = (TextView) inflate.findViewById(R.id.vod_name);
            TextView textView2 = (TextView) inflate.findViewById(R.id.vod_public_year);
            textView.setText(a2.getProgramName());
            textView2.setText(a2.getOnLineTime());
            f.a(inflate.findViewById(R.id.ll_top));
            f.a(inflate.findViewById(R.id.vod_name));
            f.a(inflate.findViewById(R.id.ll_bottom));
            f.a(inflate.findViewById(R.id.vod_public_year));
            f.a(inflate.findViewById(R.id.vod_play));
            inflate.setOnClickListener(new c(a2));
            LogEx.d(j, "recv VodAlarmArrivedEvent event, vodName : " + a2.getProgramName() + " , startplaytime : " + a2.getOnLineTime() + " , programcodde : " + a2.getProgramCode() + " , programtype : " + a2.getProgramType() + " ,  columncode : " + a2.getProgramCode() + " , id : " + a2.getId());
            this.f.addView(inflate);
        }
    }
}
