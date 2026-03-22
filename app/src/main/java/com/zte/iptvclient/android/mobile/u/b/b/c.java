package com.zte.iptvclient.android.mobile.u.b.b;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;

/* compiled from: RemoteSendMsgLayout.java */
/* loaded from: classes2.dex */
public class c extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private com.zte.iptvclient.android.mobile.u.a.a f7396a;

    /* renamed from: b, reason: collision with root package name */
    private Context f7397b;

    /* renamed from: c, reason: collision with root package name */
    private RelativeLayout f7398c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f7399d;
    private EditText e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemoteSendMsgLayout.java */
    /* loaded from: classes2.dex */
    public class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemoteSendMsgLayout.java */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String trim = c.this.e.getText().toString().trim();
            if (trim.length() > 0) {
                if (com.zte.iptvclient.android.mobile.h.a.a.g().b() == null) {
                    c.this.f7396a.N();
                    return;
                }
                com.zte.iptvclient.android.mobile.h.a.a.g().b(trim);
                LogEx.d("RemoteSendMsgLayout", "sendContent ==" + trim);
                c.this.a();
                return;
            }
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(c.this.getResources().getString(R.string.remote_hint_inputtxt));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemoteSendMsgLayout.java */
    /* renamed from: com.zte.iptvclient.android.mobile.u.b.b.c$c, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class ViewOnClickListenerC0363c implements View.OnClickListener {
        ViewOnClickListenerC0363c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.a();
        }
    }

    public c(Context context, com.zte.iptvclient.android.mobile.u.a.a aVar) {
        super(context);
        a(context);
        this.f7397b = context;
        this.f7396a = aVar;
    }

    private void c() {
        this.e.addTextChangedListener(new a());
        this.f7399d.setOnClickListener(new b());
        this.f7398c.setOnClickListener(new ViewOnClickListenerC0363c());
    }

    private void a(Context context) {
        a(LayoutInflater.from(context).inflate(R.layout.remote_send_message_fragment, this));
        c();
    }

    public void b() {
        this.e.setBackgroundResource(R.drawable.bg_edittext);
        this.f7399d.setBackgroundResource(R.drawable.selector_send_message);
    }

    private void a(View view) {
        this.e = (EditText) view.findViewById(R.id.edttxt_send_message);
        this.f7399d = (TextView) view.findViewById(R.id.txtvew_send_message);
        this.f7398c = (RelativeLayout) view.findViewById(R.id.rl_sendmessage);
        f.a(this.e);
        f.a(this.f7399d);
        this.e.setFilters(new InputFilter[]{new InputFilter.LengthFilter(255)});
        this.f7399d.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_send));
    }

    public void a() {
        ((InputMethodManager) this.f7397b.getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
    }
}
