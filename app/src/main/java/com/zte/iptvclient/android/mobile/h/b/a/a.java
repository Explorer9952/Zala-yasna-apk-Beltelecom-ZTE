package com.zte.iptvclient.android.mobile.h.b.a;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.video.androidsdk.common.ParamConst;
import com.video.androidsdk.common.util.StringUtil;
import com.zte.iptvclient.android.zala.R;

/* compiled from: STBChangeNameFragment.java */
/* loaded from: classes.dex */
public class a extends Fragment {

    /* renamed from: a, reason: collision with root package name */
    private TextView f6361a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f6362b;

    /* renamed from: c, reason: collision with root package name */
    private EditText f6363c;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f6364d;
    private CharSequence e;
    private String f;
    Fragment g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: STBChangeNameFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.h.b.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0268a implements View.OnClickListener {
        ViewOnClickListenerC0268a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f6363c.setText("");
            a.this.f6363c.requestFocus();
            ((InputMethodManager) a.this.f6363c.getContext().getSystemService("input_method")).showSoftInput(a.this.f6363c, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: STBChangeNameFragment.java */
    /* loaded from: classes.dex */
    public class b implements TextView.OnEditorActionListener {
        b() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 6) {
                return false;
            }
            a.this.v();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: STBChangeNameFragment.java */
    /* loaded from: classes.dex */
    public class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.length() > 0) {
                a.this.f6364d.setVisibility(0);
            } else {
                a.this.f6364d.setVisibility(8);
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
    /* compiled from: STBChangeNameFragment.java */
    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
            if (inputMethodManager.isActive()) {
                inputMethodManager.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
            }
            a.this.getFragmentManager().F();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: STBChangeNameFragment.java */
    /* loaded from: classes.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.v();
            InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
            if (inputMethodManager.isActive()) {
                inputMethodManager.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
            }
        }
    }

    /* compiled from: STBChangeNameFragment.java */
    /* loaded from: classes.dex */
    public interface f {
        void n();
    }

    private void w() {
        this.f6363c.setText(this.e);
        if (!StringUtil.isEmptyString(this.e.toString())) {
            this.f6364d.setVisibility(0);
        } else {
            this.f6364d.setVisibility(8);
        }
    }

    private void x() {
        this.f6364d.setOnClickListener(new ViewOnClickListenerC0268a());
        this.f6363c.setOnEditorActionListener(new b());
        this.f6363c.addTextChangedListener(new c());
        this.f6361a.setOnClickListener(new d());
        this.f6362b.setOnClickListener(new e());
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        w();
        x();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.e = getArguments().getCharSequence(ParamConst.DLNA_GETLIST_RSP_STBNAME);
        this.f = getArguments().getString("STBUdn");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.stbmgr_changename_fragment, viewGroup, false);
        a(inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void setTargetFragment(Fragment fragment, int i) {
        this.g = fragment;
    }

    public Fragment u() {
        return this.g;
    }

    protected void v() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        String obj = this.f6363c.getText().toString();
        if (TextUtils.equals(obj, "")) {
            return;
        }
        String str = this.f;
        if (str != null) {
            SharedPreferences.Editor edit = activity.getSharedPreferences("stbcachefile", 0).edit();
            edit.putString(str, obj);
            edit.commit();
            if (u() instanceof f) {
                ((f) u()).n();
            }
        }
        getFragmentManager().F();
    }

    private void a(View view) {
        this.f6361a = (TextView) view.findViewById(R.id.txt_cancel);
        this.f6362b = (TextView) view.findViewById(R.id.txt_save);
        this.f6363c = (EditText) view.findViewById(R.id.stbmgr_nameedit);
        this.f6364d = (ImageView) view.findViewById(R.id.stbmgr_cleartxt);
        this.f6361a.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_cancel));
        this.f6362b.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_save));
        TextView textView = (TextView) view.findViewById(R.id.txt_nameedit_title);
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.stb_edit));
        com.zte.iptvclient.common.uiframe.f.a(this.f6361a);
        com.zte.iptvclient.common.uiframe.f.a(this.f6362b);
        com.zte.iptvclient.common.uiframe.f.a(this.f6363c);
        com.zte.iptvclient.common.uiframe.f.a(this.f6364d);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rlayout_nameedit));
        com.zte.iptvclient.common.uiframe.f.a(textView);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.img_edit_line));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_nameedit));
    }
}
