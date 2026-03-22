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

/* compiled from: RecordingDialog.java */
/* loaded from: classes.dex */
public class d extends Dialog implements DialogInterface {

    /* renamed from: a, reason: collision with root package name */
    private Context f4157a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f4158b;

    /* renamed from: c, reason: collision with root package name */
    private ImageView f4159c;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f4160d;
    private Button e;
    private Button f;
    private LinearLayout g;
    private LinearLayout h;
    private LinearLayout i;
    private View j;

    /* compiled from: RecordingDialog.java */
    /* loaded from: classes.dex */
    class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f4161a;

        a(DialogInterface.OnClickListener onClickListener) {
            this.f4161a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DialogInterface.OnClickListener onClickListener = this.f4161a;
            if (onClickListener != null) {
                d dVar = d.this;
                onClickListener.onClick(dVar, dVar.e.getId());
            }
            d.this.dismiss();
        }
    }

    /* compiled from: RecordingDialog.java */
    /* loaded from: classes.dex */
    class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f4163a;

        b(DialogInterface.OnClickListener onClickListener) {
            this.f4163a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DialogInterface.OnClickListener onClickListener = this.f4163a;
            if (onClickListener != null) {
                d dVar = d.this;
                onClickListener.onClick(dVar, dVar.f.getId());
            }
            d.this.dismiss();
        }
    }

    public d(Context context) {
        super(context, R.style.commonDialogTheme);
        super.setContentView(R.layout.record_dialog);
        this.f4157a = context;
        a();
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        this.f4160d.removeAllViewsInLayout();
        this.f4160d.addView(LayoutInflater.from(this.f4157a).inflate(i, (ViewGroup) null));
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        this.f4158b.setText(charSequence);
        this.g.setVisibility(0);
    }

    @Override // android.app.Dialog
    public void show() {
        if (this.e.getVisibility() == 0 && this.f.getVisibility() == 0) {
            findViewById(R.id.devider_positive_negative).setVisibility(0);
        } else if (this.e.getVisibility() == 0) {
            findViewById(R.id.devider_positive_negative).setVisibility(8);
        } else if (this.f.getVisibility() == 0) {
            findViewById(R.id.devider_positive_negative).setVisibility(8);
        }
        super.show();
    }

    private void a() {
        this.i = (LinearLayout) findViewById(R.id.ll_content);
        this.j = findViewById(R.id.line);
        this.g = (LinearLayout) findViewById(R.id.comm_dialog_title_parent);
        this.h = (LinearLayout) findViewById(R.id.comm_dialog_bottom);
        this.f4158b = (TextView) findViewById(R.id.comm_dialog_title);
        this.f4159c = (ImageView) findViewById(R.id.comm_dialog_icon);
        this.f4160d = (LinearLayout) findViewById(R.id.comm_dialog_content);
        this.e = (Button) findViewById(R.id.comm_dialog_positive_button);
        this.f = (Button) findViewById(R.id.comm_dialog_negative_button);
        f.a(this.g);
        f.a(this.h);
        f.a(this.f4158b);
        f.a(this.f4160d);
        f.a(this.e);
        f.a(this.f);
        f.a(this.i);
        f.a(this.j);
    }

    public void b(int i, DialogInterface.OnClickListener onClickListener) {
        this.h.setVisibility(0);
        this.e.setVisibility(0);
        this.e.setText(i);
        this.e.setOnClickListener(new a(onClickListener));
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        this.f4160d.removeAllViewsInLayout();
        this.f4160d.addView(view);
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        this.f4158b.setText(i);
        this.g.setVisibility(0);
    }

    public void a(int i, DialogInterface.OnClickListener onClickListener) {
        this.h.setVisibility(0);
        this.f.setVisibility(0);
        this.f.setText(i);
        this.f.setOnClickListener(new b(onClickListener));
    }
}
