package com.unity3d.player;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.codeless.internal.Constants;
import com.video.androidsdk.common.util.IoUtils;
import com.zte.ucs.tvcall.Commons;

/* loaded from: classes.dex */
public final class f extends Dialog implements TextWatcher, View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    private static int f3002c = 1627389952;

    /* renamed from: d, reason: collision with root package name */
    private static int f3003d = -1;

    /* renamed from: a, reason: collision with root package name */
    private Context f3004a;

    /* renamed from: b, reason: collision with root package name */
    private UnityPlayer f3005b;

    public f(Context context, UnityPlayer unityPlayer, String str, int i, boolean z, boolean z2, boolean z3, String str2) {
        super(context);
        this.f3004a = null;
        this.f3005b = null;
        this.f3004a = context;
        this.f3005b = unityPlayer;
        getWindow().setGravity(80);
        getWindow().requestFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setContentView(createSoftInputView());
        getWindow().setLayout(-1, -2);
        getWindow().clearFlags(2);
        EditText editText = (EditText) findViewById(1057292289);
        Button button = (Button) findViewById(1057292290);
        a(editText, str, i, z, z2, z3, str2);
        button.setOnClickListener(this);
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.unity3d.player.f.1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z4) {
                if (z4) {
                    f.this.getWindow().setSoftInputMode(5);
                }
            }
        });
    }

    private static int a(int i, boolean z, boolean z2, boolean z3) {
        int i2 = (z ? IoUtils.DEFAULT_BUFFER_SIZE : 0) | (z2 ? 131072 : 0) | (z3 ? Commons.MSG_MCSP_INIT_SUCCESS : 0);
        return (i < 0 || i > 7) ? i2 : new int[]{1, 16385, 12290, 17, 2, 3, 97, 33}[i] | i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a() {
        EditText editText = (EditText) findViewById(1057292289);
        if (editText == null) {
            return null;
        }
        return editText.getText().toString().trim();
    }

    private void a(EditText editText, String str, int i, boolean z, boolean z2, boolean z3, String str2) {
        editText.setImeOptions(6);
        editText.setText(str);
        editText.setHint(str2);
        editText.setHintTextColor(f3002c);
        editText.setInputType(a(i, z, z2, z3));
        editText.addTextChangedListener(this);
        editText.setClickable(true);
        if (z2) {
            return;
        }
        editText.selectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z) {
        Selection.removeSelection(((EditText) findViewById(1057292289)).getEditableText());
        this.f3005b.reportSoftInputStr(str, 1, z);
    }

    public final void a(String str) {
        EditText editText = (EditText) findViewById(1057292289);
        if (editText != null) {
            editText.setText(str);
            editText.setSelection(str.length());
        }
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        this.f3005b.reportSoftInputStr(editable.toString(), 0, false);
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    protected final View createSoftInputView() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f3004a);
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        relativeLayout.setBackgroundColor(f3003d);
        EditText editText = new EditText(this.f3004a) { // from class: com.unity3d.player.f.2
            @Override // android.widget.TextView, android.view.View
            public final boolean onKeyPreIme(int i, KeyEvent keyEvent) {
                if (i == 4) {
                    f fVar = f.this;
                    fVar.a(fVar.a(), true);
                    return true;
                }
                if (i == 84) {
                    return true;
                }
                return super.onKeyPreIme(i, keyEvent);
            }

            @Override // android.widget.TextView, android.view.View
            public final void onWindowFocusChanged(boolean z) {
                super.onWindowFocusChanged(z);
                if (z) {
                    ((InputMethodManager) f.this.f3004a.getSystemService("input_method")).showSoftInput(this, 0);
                }
            }
        };
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(0, 1057292290);
        editText.setLayoutParams(layoutParams);
        editText.setId(1057292289);
        relativeLayout.addView(editText);
        Button button = new Button(this.f3004a);
        button.setText(this.f3004a.getResources().getIdentifier("ok", "string", Constants.PLATFORM));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(11);
        button.setLayoutParams(layoutParams2);
        button.setId(1057292290);
        button.setBackgroundColor(0);
        relativeLayout.addView(button);
        ((EditText) relativeLayout.findViewById(1057292289)).setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.unity3d.player.f.3
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6) {
                    f fVar = f.this;
                    fVar.a(fVar.a(), false);
                }
                return false;
            }
        });
        relativeLayout.setPadding(16, 16, 16, 16);
        return relativeLayout;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        a(a(), true);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        a(a(), false);
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
