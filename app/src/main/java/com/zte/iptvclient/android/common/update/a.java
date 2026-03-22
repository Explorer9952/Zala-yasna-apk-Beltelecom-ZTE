package com.zte.iptvclient.android.common.update;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import com.zte.iptvclient.android.common.j.h;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;

/* compiled from: PrivacyDialog.java */
/* loaded from: classes.dex */
public class a extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private Context f5242a;

    /* renamed from: b, reason: collision with root package name */
    private String f5243b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f5244c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f5245d;
    private TextView e;
    private TextView f;
    private h g;

    /* compiled from: PrivacyDialog.java */
    /* renamed from: com.zte.iptvclient.android.common.update.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0162a extends ClickableSpan {
        C0162a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(a.this.f5243b));
            a.this.f5242a.startActivity(intent);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(true);
        }
    }

    /* compiled from: PrivacyDialog.java */
    /* loaded from: classes.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
            a.this.g.c(false);
        }
    }

    public a(Context context, int i, String str) {
        super(context, i);
        this.f5242a = context;
        this.f5243b = str;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.privacy_dialog);
        this.g = new h(this.f5242a);
        this.f5244c = (TextView) findViewById(R.id.txt_privacy_one);
        this.f5245d = (TextView) findViewById(R.id.txt_privacy_two);
        this.e = (TextView) findViewById(R.id.title);
        this.f = (TextView) findViewById(R.id.agree);
        f.a(findViewById(R.id.rl_privacy_dialog));
        f.a(findViewById(R.id.comm_dialog_bottom));
        f.a(this.f5244c);
        f.a(this.f5245d);
        f.a(this.e);
        f.a(this.f);
        String replace = (" " + this.f5242a.getResources().getString(R.string.privacy_txt_one)).replace(this.f5242a.getResources().getString(R.string.privacy_policy), this.f5242a.getResources().getString(R.string.privacy_policy));
        String string = this.f5242a.getResources().getString(R.string.privacy_policy);
        int indexOf = replace.indexOf(string);
        SpannableString spannableString = new SpannableString(replace);
        spannableString.setSpan(new C0162a(), indexOf, string.length() + indexOf, 33);
        this.f5244c.setText(spannableString);
        this.f5244c.setMovementMethod(LinkMovementMethod.getInstance());
        this.f.setOnClickListener(new b());
    }
}
