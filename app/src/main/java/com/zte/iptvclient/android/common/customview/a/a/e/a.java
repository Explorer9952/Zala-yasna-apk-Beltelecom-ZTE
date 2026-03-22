package com.zte.iptvclient.android.common.customview.a.a.e;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.video.androidsdk.common.http.HttpConstant;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.zala.R;

/* compiled from: AdvertisementGuideDialog.java */
/* loaded from: classes.dex */
public class a extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private LinearLayout f4217a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f4218b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f4219c;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f4220d;
    private int e;
    private int f;
    private String g;
    public boolean h;
    private Bitmap i;
    private Context j;
    private com.zte.iptvclient.android.common.javabean.a k;
    private d l;
    Handler m;

    /* compiled from: AdvertisementGuideDialog.java */
    /* renamed from: com.zte.iptvclient.android.common.customview.a.a.e.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class HandlerC0122a extends Handler {
        HandlerC0122a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                LogEx.d("AdvertisementGuideDialog", "优化 MSG_TIME current = " + a.this.e);
                if (a.this.e > 0) {
                    if (a.this.f <= 0) {
                        if (a.this.f4217a.getVisibility() == 8) {
                            a.this.f4217a.setVisibility(0);
                        }
                        a.this.f4219c.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.skip_time), Integer.valueOf(a.this.e)));
                    }
                    a.d(a.this);
                    a.b(a.this);
                    sendEmptyMessageDelayed(1, 1000L);
                    return;
                }
                if (a.this.isShowing()) {
                    a.this.dismiss();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdvertisementGuideDialog.java */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdvertisementGuideDialog.java */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (StringUtil.isEmptyString(a.this.g) || !a.this.g.startsWith(HttpConstant.PROTOCOL_HTTP)) {
                return;
            }
            a.this.dismiss();
            if (a.this.l != null) {
                a.this.l.a(a.this.g);
            }
        }
    }

    /* compiled from: AdvertisementGuideDialog.java */
    /* loaded from: classes.dex */
    public interface d {
        void a();

        void a(String str);
    }

    public a(Context context) {
        super(context, R.style.advertisement_dialog);
        this.e = 3;
        this.f = 0;
        this.g = "";
        this.h = false;
        this.m = new HandlerC0122a();
        setOwnerActivity((Activity) context);
        this.j = context;
        setCanceledOnTouchOutside(false);
        LogEx.d("AdvertisementGuideDialog", "优化AdvertisementGuideDialog()");
    }

    static /* synthetic */ int b(a aVar) {
        int i = aVar.e;
        aVar.e = i - 1;
        return i;
    }

    static /* synthetic */ int d(a aVar) {
        int i = aVar.f;
        aVar.f = i - 1;
        return i;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (getWindow() != null) {
            Bitmap bitmap = this.i;
            if (bitmap != null) {
                bitmap.recycle();
            }
            Handler handler = this.m;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.m = null;
            }
            this.h = true;
            d dVar = this.l;
            if (dVar != null) {
                dVar.a();
            }
        }
        super.dismiss();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = LayoutInflater.from(this.j).inflate(R.layout.guide_activity, (ViewGroup) null);
        setContentView(inflate);
        a(inflate);
        b();
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Splash_Advertise_Forbidden_Skip_Time");
        if (!StringUtil.isEmptyString(c2)) {
            this.f = Integer.parseInt(c2);
        }
        a();
    }

    @Override // android.app.Dialog
    public void show() {
        WindowManager.LayoutParams attributes;
        super.show();
        LogEx.d("AdvertisementGuideDialog", "优化show()");
        Window window = getWindow();
        if (window != null && (attributes = window.getAttributes()) != null) {
            attributes.gravity = 80;
            attributes.width = -1;
            attributes.height = -1;
            window.getDecorView().setPadding(0, 0, 0, 0);
            window.setAttributes(attributes);
        }
        LogEx.d("AdvertisementGuideDialog", "优化 startCountDown !");
        a(this.k);
    }

    private void a() {
        byte[] a2;
        com.zte.iptvclient.android.common.javabean.a b2 = com.zte.iptvclient.android.common.j.a.d().b();
        this.k = b2;
        if (b2 != null && b2.a() != null && (a2 = this.k.a()) != null) {
            this.i = BitmapFactory.decodeByteArray(a2, 0, a2.length);
        }
        Bitmap bitmap = this.i;
        if (bitmap == null) {
            this.f4220d.setBackground(this.j.getResources().getDrawable(R.drawable.default_advertisement));
        } else {
            this.f4220d.setImageBitmap(bitmap);
        }
    }

    private void b() {
        this.f4217a.setOnClickListener(new b());
        this.f4220d.setOnClickListener(new c());
    }

    private void a(View view) {
        this.f4220d = (ImageView) view.findViewById(R.id.img_guide);
        this.f4217a = (LinearLayout) view.findViewById(R.id.llayout_time);
        TextView textView = (TextView) view.findViewById(R.id.tv_skip);
        this.f4218b = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.skip));
        this.f4219c = (TextView) view.findViewById(R.id.tv_time);
        com.zte.iptvclient.common.uiframe.f.a(this.f4220d);
        com.zte.iptvclient.common.uiframe.f.a(this.f4217a);
        com.zte.iptvclient.common.uiframe.f.a(this.f4218b);
        com.zte.iptvclient.common.uiframe.f.a(this.f4219c);
        Window window = getWindow();
        if (window != null) {
            window.setFlags(512, 512);
        }
    }

    private void a(com.zte.iptvclient.android.common.javabean.a aVar) {
        if (aVar != null) {
            this.f = aVar.d();
            this.e = aVar.b();
            this.g = aVar.c();
        }
        LogEx.d("AdvertisementGuideDialog", "优化 getadvertisementBean total Time = " + this.e + " mTimeLaterShowSkip" + this.f);
        Handler handler = this.m;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(1, 1000L);
        }
    }

    public void a(d dVar) {
        this.l = dVar;
    }
}
