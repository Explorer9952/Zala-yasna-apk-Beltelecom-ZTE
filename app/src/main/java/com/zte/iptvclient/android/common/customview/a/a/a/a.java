package com.zte.iptvclient.android.common.customview.a.a.a;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;

/* compiled from: CommonDialog.java */
/* loaded from: classes.dex */
public class a extends Dialog implements DialogInterface {

    /* renamed from: a, reason: collision with root package name */
    private Context f4133a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f4134b;

    /* renamed from: c, reason: collision with root package name */
    private ImageView f4135c;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f4136d;
    private Button e;
    private Button f;
    private LinearLayout g;
    private LinearLayout h;
    private LinearLayout i;
    private View j;

    /* compiled from: CommonDialog.java */
    /* renamed from: com.zte.iptvclient.android.common.customview.a.a.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class ViewOnClickListenerC0113a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f4137a;

        ViewOnClickListenerC0113a(DialogInterface.OnClickListener onClickListener) {
            this.f4137a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DialogInterface.OnClickListener onClickListener = this.f4137a;
            if (onClickListener != null) {
                a aVar = a.this;
                onClickListener.onClick(aVar, aVar.e.getId());
            }
            a.this.dismiss();
        }
    }

    /* compiled from: CommonDialog.java */
    /* loaded from: classes.dex */
    class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f4139a;

        b(DialogInterface.OnClickListener onClickListener) {
            this.f4139a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DialogInterface.OnClickListener onClickListener = this.f4139a;
            if (onClickListener != null) {
                a aVar = a.this;
                onClickListener.onClick(aVar, aVar.f.getId());
            }
            a.this.dismiss();
        }
    }

    public a(Context context) {
        super(context, R.style.commonDialogTheme);
        super.setContentView(R.layout.view_common_dialog);
        this.f4133a = context;
        a();
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        this.f4136d.removeAllViewsInLayout();
        this.f4136d.addView(LayoutInflater.from(this.f4133a).inflate(i, (ViewGroup) null));
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        this.f4134b.setText(charSequence);
        this.g.setVisibility(0);
    }

    @Override // android.app.Dialog
    public void show() {
        if (this.e.getVisibility() == 0 && this.f.getVisibility() == 0) {
            this.e.setBackgroundResource(R.drawable.order_dialog_rightbg);
            this.f.setBackgroundResource(R.drawable.order_dialog_leftbg);
            findViewById(R.id.devider_positive_negative).setVisibility(0);
        } else if (this.e.getVisibility() == 0) {
            this.e.setBackgroundResource(R.drawable.order_dialog_buttom_bg);
            findViewById(R.id.devider_positive_negative).setVisibility(8);
        } else if (this.f.getVisibility() == 0) {
            this.f.setBackgroundResource(R.drawable.order_dialog_buttom_bg);
            findViewById(R.id.devider_positive_negative).setVisibility(8);
        }
        super.show();
    }

    private void a() {
        this.i = (LinearLayout) findViewById(R.id.ll_content);
        this.j = findViewById(R.id.line);
        this.g = (LinearLayout) findViewById(R.id.comm_dialog_title_parent);
        this.h = (LinearLayout) findViewById(R.id.comm_dialog_bottom);
        this.f4134b = (TextView) findViewById(R.id.comm_dialog_title);
        this.f4135c = (ImageView) findViewById(R.id.comm_dialog_icon);
        this.f4136d = (LinearLayout) findViewById(R.id.comm_dialog_content);
        this.e = (Button) findViewById(R.id.comm_dialog_positive_button);
        this.f = (Button) findViewById(R.id.comm_dialog_negative_button);
        f.a(this.g);
        f.a(this.h);
        f.a(this.f4134b);
        f.a(this.f4136d);
        f.a(this.e);
        f.a(this.f);
        f.a(this.i);
        f.a(this.j);
    }

    public void b(int i, DialogInterface.OnClickListener onClickListener) {
        this.h.setVisibility(0);
        this.e.setVisibility(0);
        this.e.setText(i);
        this.e.setOnClickListener(new ViewOnClickListenerC0113a(onClickListener));
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        this.f4136d.removeAllViewsInLayout();
        this.f4136d.addView(view);
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        this.f4134b.setText(i);
        this.g.setVisibility(0);
    }

    public void a(int i, DialogInterface.OnClickListener onClickListener) {
        this.h.setVisibility(0);
        this.f.setVisibility(0);
        this.f.setText(i);
        this.f.setOnClickListener(new b(onClickListener));
    }

    public void a(CharSequence charSequence) {
        TextView textView = (TextView) LayoutInflater.from(this.f4133a).inflate(R.layout.view_common_dialog_message, (ViewGroup) null);
        textView.setText(charSequence);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        setContentView(textView);
        f.a(textView);
    }

    public void a(int i) {
        a(com.zte.iptvclient.android.common.i.a.a.a(i));
    }
}
