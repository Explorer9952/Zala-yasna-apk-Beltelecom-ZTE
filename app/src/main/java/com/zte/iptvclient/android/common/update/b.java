package com.zte.iptvclient.android.common.update;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.video.androidsdk.common.util.FileUtil;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.view.RoundProgressBar;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.io.File;

/* compiled from: UpdateDialogNew.java */
/* loaded from: classes.dex */
public class b {
    private static String o = "UpdateDialogNew";
    private static TextView p;
    private static TextView q;
    private static RoundProgressBar r;
    private static RelativeLayout s;
    private static RelativeLayout t;
    private static TextView u;

    /* renamed from: a, reason: collision with root package name */
    private Context f5248a;

    /* renamed from: b, reason: collision with root package name */
    private int f5249b;

    /* renamed from: c, reason: collision with root package name */
    private int f5250c;

    /* renamed from: d, reason: collision with root package name */
    private int f5251d;
    private int e;
    private int f;
    private String g;
    private int h;
    private int i;
    private String j;
    private String k;
    private AlertDialog l;
    private d m;
    private RelativeLayout n;

    /* compiled from: UpdateDialogNew.java */
    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogEx.d(b.o, "jump to apk");
            File file = new File(com.zte.iptvclient.android.common.c.c.f4109b);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(268435456);
            intent.setDataAndType(Uri.parse(FileUtil.STR_TAG_LOCALIMG + file.getAbsolutePath()), "application/vnd.android.package-archive");
            b.this.f5248a.startActivity(intent);
        }
    }

    /* compiled from: UpdateDialogNew.java */
    /* renamed from: com.zte.iptvclient.android.common.update.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class ViewOnClickListenerC0163b implements View.OnClickListener {
        ViewOnClickListenerC0163b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.m != null) {
                if (".apk".contains(b.this.g)) {
                    if (b.this.n.getVisibility() != 0) {
                        b.s.setVisibility(0);
                        b.this.m.a();
                        return;
                    } else {
                        b.this.m.a();
                        b.this.l.dismiss();
                        return;
                    }
                }
                b.this.m.a();
            }
        }
    }

    /* compiled from: UpdateDialogNew.java */
    /* loaded from: classes.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.m != null) {
                b.this.l.dismiss();
                b.this.m.b();
            }
        }
    }

    /* compiled from: UpdateDialogNew.java */
    /* loaded from: classes.dex */
    public interface d {
        void a();

        void b();
    }

    public b(Context context, String str, int i, String str2, int i2, int i3, int i4, int i5, int i6, int i7, String str3, d dVar) {
        this.f5249b = 0;
        this.f5250c = 0;
        this.f5251d = 0;
        this.e = 0;
        this.f = 0;
        this.h = 0;
        this.i = 0;
        this.f5248a = context;
        this.k = str;
        this.f5249b = i;
        this.j = str2;
        this.e = i3;
        this.f = i4;
        this.f5250c = i2;
        this.f5251d = i5;
        this.h = i6;
        this.i = i7;
        this.g = str3;
        this.m = dVar;
    }

    public static void a(int i) {
        RoundProgressBar roundProgressBar = r;
        if (roundProgressBar == null || roundProgressBar.getVisibility() != 0) {
            return;
        }
        r.a(i);
        if (i == 100) {
            u.setText(BaseApp.e().getString(R.string.download_sucess));
            t.setVisibility(0);
        }
    }

    public static void a(Context context) {
        RoundProgressBar roundProgressBar = r;
        if (roundProgressBar == null || roundProgressBar.getVisibility() != 0) {
            return;
        }
        s.setVisibility(8);
        TextView textView = p;
        if (textView != null && textView.getVisibility() == 0) {
            p.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.network_error_failed_upgrade));
        }
        TextView textView2 = q;
        if (textView2 == null || textView2.getVisibility() != 0) {
            return;
        }
        q.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.retry));
    }

    public void a() {
        this.l = new AlertDialog.Builder(this.f5248a).create();
        RelativeLayout relativeLayout = (RelativeLayout) View.inflate(this.f5248a, R.layout.uptate_dialog_new_layout, null);
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.image);
        TextView textView = (TextView) relativeLayout.findViewById(R.id.message);
        p = (TextView) relativeLayout.findViewById(R.id.tv_title);
        RelativeLayout relativeLayout2 = (RelativeLayout) relativeLayout.findViewById(R.id.rl_button_ok);
        q = (TextView) relativeLayout.findViewById(R.id.text_ok);
        ImageView imageView2 = (ImageView) relativeLayout.findViewById(R.id.img_ok_left);
        this.n = (RelativeLayout) relativeLayout.findViewById(R.id.rl_button_cancel);
        TextView textView2 = (TextView) relativeLayout.findViewById(R.id.text_cancel);
        ImageView imageView3 = (ImageView) relativeLayout.findViewById(R.id.img_cancel_left);
        f.a(relativeLayout.findViewById(R.id.rl_update_view_all_layout));
        f.a(imageView);
        f.a(textView);
        f.a(p);
        f.a(relativeLayout2);
        f.a(q);
        f.a(imageView2);
        f.a(this.n);
        f.a(textView2);
        f.a(imageView3);
        s = (RelativeLayout) relativeLayout.findViewById(R.id.progreesLayout);
        r = (RoundProgressBar) relativeLayout.findViewById(R.id.roundProgress);
        u = (TextView) relativeLayout.findViewById(R.id.roundProgress_txt);
        RelativeLayout relativeLayout3 = (RelativeLayout) relativeLayout.findViewById(R.id.btn_oks_layout);
        t = relativeLayout3;
        relativeLayout3.setOnClickListener(new a());
        r.a(0);
        r.setOnClickListener(null);
        int i = this.f5249b;
        if (i == 0) {
            imageView.setVisibility(8);
        } else {
            imageView.setBackgroundResource(i);
            imageView.setVisibility(0);
        }
        LogEx.d(o, "mStrTitle  =  " + this.k);
        if (!TextUtils.isEmpty(this.k)) {
            p.setText(this.k);
            p.setVisibility(8);
        }
        LogEx.d(o, "mUpdateIfo  =  " + this.j);
        if (!TextUtils.isEmpty(this.j)) {
            textView.setVisibility(0);
            textView.setText(this.j);
        } else {
            p.setVisibility(0);
        }
        if (this.e != 0) {
            relativeLayout2.setVisibility(0);
            relativeLayout2.setBackgroundResource(this.f5250c);
            q.setText(this.e);
            if (this.f != 0) {
                imageView2.setVisibility(0);
                imageView2.setBackgroundResource(this.f);
            }
        }
        if (this.h != 0) {
            this.n.setVisibility(0);
            this.n.setBackgroundResource(this.f5251d);
            textView2.setText(this.h);
            if (this.i != 0) {
                imageView3.setVisibility(0);
                imageView3.setBackgroundResource(this.i);
            }
        }
        relativeLayout2.setOnClickListener(new ViewOnClickListenerC0163b());
        this.n.setOnClickListener(new c());
        this.l.setCancelable(false);
        this.l.show();
        Window window = this.l.getWindow();
        if (window != null) {
            window.setContentView(relativeLayout);
        }
    }

    public void a(boolean z) {
        AlertDialog alertDialog = this.l;
        if (alertDialog != null) {
            alertDialog.setCanceledOnTouchOutside(z);
        }
    }
}
