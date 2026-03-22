package com.zte.iptvclient.common.uiframe;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.video.androidsdk.log.LogEx;

/* compiled from: ConfirmDialog.java */
/* loaded from: classes2.dex */
public class e {
    private static Typeface h;

    /* renamed from: a, reason: collision with root package name */
    private TextView f7902a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f7903b;

    /* renamed from: c, reason: collision with root package name */
    private Button f7904c;

    /* renamed from: d, reason: collision with root package name */
    private Button f7905d;
    private d e;
    private Dialog f;
    private boolean g = true;

    /* compiled from: ConfirmDialog.java */
    /* loaded from: classes2.dex */
    class a implements DialogInterface.OnCancelListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f7906a;

        a(e eVar, d dVar) {
            this.f7906a = dVar;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            this.f7906a.a();
        }
    }

    /* compiled from: ConfirmDialog.java */
    /* loaded from: classes2.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.e != null) {
                if (e.this.f != null && e.this.g) {
                    e.this.f.dismiss();
                }
                e.this.e.b();
            }
        }
    }

    /* compiled from: ConfirmDialog.java */
    /* loaded from: classes2.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (e.this.e != null) {
                if (e.this.f != null) {
                    e.this.f.dismiss();
                }
                e.this.e.a();
            }
        }
    }

    /* compiled from: ConfirmDialog.java */
    /* loaded from: classes2.dex */
    public interface d {
        void a();

        void b();

        ViewGroup.LayoutParams e();
    }

    public e(Context context, int i, int i2, int i3, int i4, int i5, int i6, int i7, d dVar) {
        this.f7902a = null;
        this.f7903b = null;
        this.f7904c = null;
        this.f7905d = null;
        this.e = null;
        this.f = null;
        if (context == null) {
            LogEx.d("ConfirmDialog", "create ConfirmDialog failed, context is null");
            return;
        }
        AlertDialog create = new AlertDialog.Builder(context).create();
        create.setCanceledOnTouchOutside(false);
        create.setOnCancelListener(new a(this, dVar));
        create.show();
        Window window = create.getWindow();
        View inflate = window.getLayoutInflater().inflate(i2, (ViewGroup) null);
        f.a(inflate);
        window.setContentView(inflate);
        this.f7902a = (TextView) window.findViewById(i4);
        this.f7903b = (TextView) window.findViewById(i5);
        this.f7904c = (Button) window.findViewById(i6);
        this.f7905d = (Button) window.findViewById(i7);
        if (i3 > 0) {
            if (window.findViewById(i3) instanceof LinearLayout) {
                LinearLayout linearLayout = (LinearLayout) window.findViewById(i3);
                d dVar2 = this.e;
                if (dVar2 != null && dVar2.e() != null) {
                    linearLayout.setLayoutParams(this.e.e());
                }
                f.a(linearLayout);
            } else if (window.findViewById(i3) instanceof RelativeLayout) {
                RelativeLayout relativeLayout = (RelativeLayout) window.findViewById(i3);
                d dVar3 = this.e;
                if (dVar3 != null && dVar3.e() != null) {
                    relativeLayout.setLayoutParams(this.e.e());
                }
                f.a(relativeLayout);
            }
            f.a(this.f7902a);
            f.a(this.f7903b);
            f.a(this.f7904c);
            f.a(this.f7905d);
        }
        this.f7903b.setMovementMethod(ScrollingMovementMethod.getInstance());
        Button button = this.f7904c;
        if (button == null || this.f7905d == null) {
            return;
        }
        button.setTypeface(h);
        this.f7905d.setTypeface(h);
        this.e = dVar;
        this.f = create;
        this.f7904c.setOnClickListener(new b());
        this.f7905d.setOnClickListener(new c());
    }

    public void d(String str) {
        if (str == null) {
            this.f7902a.setVisibility(8);
        } else {
            this.f7902a.setText(str);
            this.f7902a.setVisibility(0);
        }
    }

    public void a(String str) {
        if (str == null) {
            this.f7905d.setVisibility(8);
        } else {
            this.f7905d.setText(str);
            this.f7905d.setVisibility(0);
        }
    }

    public void b(String str) {
        if (str == null) {
            this.f7903b.setVisibility(8);
        } else {
            this.f7903b.setText(str);
            this.f7903b.setVisibility(0);
        }
    }

    public void c(String str) {
        if (str == null) {
            this.f7904c.setVisibility(8);
        } else {
            this.f7904c.setText(str);
            this.f7904c.setVisibility(0);
        }
    }
}
