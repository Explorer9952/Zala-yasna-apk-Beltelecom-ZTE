package com.zte.iptvclient.android.common.customview.a.a.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;

/* compiled from: CommonInputDialog.java */
/* loaded from: classes.dex */
public class b extends Dialog implements DialogInterface {

    /* renamed from: a, reason: collision with root package name */
    private Context f4141a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f4142b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f4143c;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f4144d;
    private LinearLayout e;
    private Button f;
    private Button g;
    private LinearLayout h;
    private LinearLayout i;
    private LinearLayout j;
    private View k;
    private View l;
    private EditText m;
    private ImageView n;
    private TextView o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CommonInputDialog.java */
    /* loaded from: classes.dex */
    public class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(b.this.m.getText().toString())) {
                b.this.n.setVisibility(8);
            } else {
                b.this.n.setVisibility(0);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CommonInputDialog.java */
    /* renamed from: com.zte.iptvclient.android.common.customview.a.a.a.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0114b implements View.OnClickListener {
        ViewOnClickListenerC0114b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.m.setText("");
            b.this.m.requestFocus();
        }
    }

    /* compiled from: CommonInputDialog.java */
    /* loaded from: classes.dex */
    class c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f4147a;

        c(DialogInterface.OnClickListener onClickListener) {
            this.f4147a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DialogInterface.OnClickListener onClickListener = this.f4147a;
            if (onClickListener != null) {
                b bVar = b.this;
                onClickListener.onClick(bVar, bVar.f.getId());
            }
        }
    }

    /* compiled from: CommonInputDialog.java */
    /* loaded from: classes.dex */
    class d implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f4149a;

        d(DialogInterface.OnClickListener onClickListener) {
            this.f4149a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DialogInterface.OnClickListener onClickListener = this.f4149a;
            if (onClickListener != null) {
                b bVar = b.this;
                onClickListener.onClick(bVar, bVar.g.getId());
            }
            b.this.dismiss();
        }
    }

    public b(Context context) {
        super(context, R.style.commonDialogTheme);
        super.setContentView(R.layout.view_common_input_dialog);
        this.f4141a = context;
        b();
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        this.e.removeAllViewsInLayout();
        this.e.addView(LayoutInflater.from(this.f4141a).inflate(i, (ViewGroup) null));
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        this.f4143c.setText(charSequence);
        this.h.setVisibility(0);
    }

    @Override // android.app.Dialog
    public void show() {
        Context context = this.f4141a;
        if (context == null || ((Activity) context).isFinishing()) {
            return;
        }
        if (this.f4141a != null) {
            if (this.f.getVisibility() == 0 && this.g.getVisibility() == 0) {
                this.l.setVisibility(0);
                this.f.setBackground(this.f4141a.getResources().getDrawable(R.drawable.lock_dialog_rightbg));
                this.g.setBackground(this.f4141a.getResources().getDrawable(R.drawable.lock_dialog_leftbg));
            } else if (this.f.getVisibility() == 0) {
                this.l.setVisibility(8);
                this.f.setBackground(this.f4141a.getResources().getDrawable(R.drawable.lock_btn_buttom_bg));
            } else if (this.g.getVisibility() == 0) {
                this.l.setVisibility(8);
                this.g.setBackground(this.f4141a.getResources().getDrawable(R.drawable.lock_btn_buttom_bg));
            }
        }
        super.show();
    }

    private void b() {
        this.j = (LinearLayout) findViewById(R.id.ll_content);
        this.k = findViewById(R.id.line);
        this.l = findViewById(R.id.line_bottom);
        this.h = (LinearLayout) findViewById(R.id.comm_dialog_title_parent);
        this.i = (LinearLayout) findViewById(R.id.comm_dialog_bottom);
        this.f4142b = (TextView) findViewById(R.id.comm_dialog_type);
        this.f4143c = (TextView) findViewById(R.id.comm_dialog_title);
        this.f4144d = (ImageView) findViewById(R.id.comm_dialog_icon);
        this.e = (LinearLayout) findViewById(R.id.comm_dialog_content);
        this.f = (Button) findViewById(R.id.comm_dialog_positive_button);
        this.g = (Button) findViewById(R.id.comm_dialog_negative_button);
        this.m = (EditText) findViewById(R.id.parental_password);
        this.n = (ImageView) findViewById(R.id.edit_clear_iv);
        this.o = (TextView) findViewById(R.id.txtvew_show_tips);
        f.a(this.h);
        f.a(this.i);
        f.a(this.f4142b);
        f.a(this.f4143c);
        f.a(this.e);
        f.a(this.f);
        f.a(this.g);
        f.a(this.j);
        f.a(this.m);
        f.a(this.n);
        f.a(this.k);
        f.a(this.l);
        f.a(this.o);
        this.m.setTypeface(Typeface.DEFAULT);
        this.m.setTransformationMethod(new PasswordTransformationMethod());
        this.m.addTextChangedListener(new a());
        this.n.setOnClickListener(new ViewOnClickListenerC0114b());
    }

    public void a(CharSequence charSequence) {
        this.f4142b.setText(charSequence);
        this.f4142b.setVisibility(0);
        this.h.setVisibility(0);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        this.e.removeAllViewsInLayout();
        this.e.addView(view);
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        this.f4143c.setText(i);
        this.h.setVisibility(0);
    }

    public void a(int i, DialogInterface.OnClickListener onClickListener) {
        this.i.setVisibility(0);
        this.g.setVisibility(0);
        this.g.setText(i);
        this.g.setOnClickListener(new d(onClickListener));
    }

    public void a(String str) {
        this.o.setVisibility(0);
        this.o.setText(str);
    }

    public EditText a() {
        return this.m;
    }

    public void b(int i, DialogInterface.OnClickListener onClickListener) {
        this.i.setVisibility(0);
        this.f.setVisibility(0);
        this.f.setText(i);
        this.f.setOnClickListener(new c(onClickListener));
    }
}
