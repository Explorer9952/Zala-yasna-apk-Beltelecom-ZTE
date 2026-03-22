package com.zte.iptvclient.android.common.customview.a.c;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Window;
import android.view.WindowManager;

/* compiled from: AlertOkCancel.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public Context f4315a;

    /* renamed from: b, reason: collision with root package name */
    public String f4316b = "用户昵称";

    /* renamed from: c, reason: collision with root package name */
    public String f4317c;

    /* renamed from: d, reason: collision with root package name */
    public c f4318d;

    /* compiled from: AlertOkCancel.java */
    /* renamed from: com.zte.iptvclient.android.common.customview.a.c.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class DialogInterfaceOnClickListenerC0126a implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AlertDialog f4319a;

        DialogInterfaceOnClickListenerC0126a(AlertDialog alertDialog) {
            this.f4319a = alertDialog;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.f4319a.dismiss();
            a.this.f4318d.a();
        }
    }

    /* compiled from: AlertOkCancel.java */
    /* loaded from: classes.dex */
    class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            a.this.f4318d.cancel();
        }
    }

    /* compiled from: AlertOkCancel.java */
    /* loaded from: classes.dex */
    public interface c {
        void a();

        void cancel();
    }

    public a(Context context, String str, c cVar) {
        this.f4317c = "提示信息：";
        this.f4315a = context;
        this.f4318d = cVar;
        this.f4317c = str;
    }

    public void a() {
        WindowManager.LayoutParams attributes;
        this.f4316b = com.zte.iptvclient.common.uiframe.a.d("UserName");
        AlertDialog create = new AlertDialog.Builder(this.f4315a).create();
        create.setTitle("hi, " + this.f4316b + ":");
        create.setMessage(this.f4317c);
        create.setButton(-1, "Ok", new DialogInterfaceOnClickListenerC0126a(create));
        create.setButton(-2, "Cancel", new b());
        create.show();
        Window window = create.getWindow();
        if (window == null || (attributes = window.getAttributes()) == null) {
            return;
        }
        attributes.width = 600;
        window.setAttributes(attributes);
    }
}
