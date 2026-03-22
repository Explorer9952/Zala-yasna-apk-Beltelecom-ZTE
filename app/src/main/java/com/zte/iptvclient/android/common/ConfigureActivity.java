package com.zte.iptvclient.android.common;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.video.androidsdk.SDKMgr;
import com.video.androidsdk.common.PreferenceHelper;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.impl.IIPTVLogin;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.k.g;
import com.zte.iptvclient.android.zala.R;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Properties;

/* loaded from: classes.dex */
public class ConfigureActivity extends SupportActivity {
    private static String O = "iptvclientsys.ini";
    private static String P = "homePagePref";
    private static String Q = "strEgpShared";
    private LinearLayout A;
    private LinearLayout B;
    private ArrayList<String> C;
    private ArrayList<String> D;
    private TextView E;
    private EditText F;
    private LayoutInflater J;
    private TextView L;
    private TextView M;
    private String v;
    private TextView w;
    private TextView x;
    private ToggleButton y;
    private EditText z;
    private int G = -1;
    private boolean K = false;
    private PreferenceHelper N = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ConfigureActivity.this.F != null) {
                if (!ConfigureActivity.this.F.getEditableText().toString().equals(ConfigureActivity.this.D.get(ConfigureActivity.this.G))) {
                    ConfigureActivity.this.D.set(ConfigureActivity.this.G, ConfigureActivity.this.F.getEditableText().toString());
                    ConfigureActivity.this.E.setText((CharSequence) ConfigureActivity.this.D.get(ConfigureActivity.this.G));
                    ConfigureActivity.this.K = true;
                }
                try {
                    ((InputMethodManager) ConfigureActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(ConfigureActivity.this.F.getWindowToken(), 2);
                } catch (Exception unused) {
                    LogEx.i("LoginActivity", "Current Focus is null");
                }
                ConfigureActivity.this.F.setVisibility(8);
                ConfigureActivity.this.F = null;
            }
            if (ConfigureActivity.this.E != null) {
                ConfigureActivity.this.E.setVisibility(0);
                ConfigureActivity.this.E = null;
            }
            if (!ConfigureActivity.this.K) {
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.not_make_config_changes);
                return;
            }
            String r = ConfigureActivity.this.r();
            ConfigureActivity configureActivity = ConfigureActivity.this;
            if (configureActivity.a(configureActivity.v, ConfigureActivity.O, r)) {
                ConfigureActivity.this.w();
                ConfigureActivity.this.v();
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.change_configure_file_successfully);
            } else {
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.change_configure_file_failed);
            }
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.restart_app_to_apply_config_changes);
            ConfigureActivity.this.K = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ConfigureActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements CompoundButton.OnCheckedChangeListener {
        c() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                SDKMgr.setLogLevel(LogEx.LogLevelType.TYPE_LOG_LEVEL_DEBUG);
                LogEx.d("ConfigureActivity", "Log level set to Debug.");
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.log_level_set_to_debug);
            } else {
                SDKMgr.setLogLevel(LogEx.LogLevelType.TYPE_LOG_LEVEL_ERROR);
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.log_level_set_to_error);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements TextWatcher {
        d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String str = "$$config" + new SimpleDateFormat("yyyyMMdd").format(new Date());
            if ("$$showversion".equalsIgnoreCase(editable.toString()) || "$$startdebug".equalsIgnoreCase(editable.toString()) || "$$stopdebug".equalsIgnoreCase(editable.toString()) || str.equalsIgnoreCase(editable.toString())) {
                try {
                    ((InputMethodManager) ConfigureActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(ConfigureActivity.this.z.getWindowToken(), 2);
                } catch (Exception unused) {
                    LogEx.i("LoginActivity", "Current Focus is null");
                }
                editable.clear();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (("$$config" + new SimpleDateFormat("yyyyMMdd").format(new Date())).equals(charSequence.toString())) {
                ConfigureActivity.this.z.setVisibility(8);
                ConfigureActivity.this.A.setVisibility(0);
                return;
            }
            if ("$$showversion".equalsIgnoreCase(charSequence.toString())) {
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a("21316254615.01.01T03\n 2131625462ZXIPTV-OTTDROIDAPPV5.01.01T03 for PHONE\n 2131625463" + ConfigureActivity.this.getPackageName());
                return;
            }
            if ("$$startdebug".equalsIgnoreCase(charSequence.toString())) {
                SDKMgr.setLogLevel(LogEx.LogLevelType.TYPE_LOG_LEVEL_DEBUG);
                LogEx.d("ConfigureActivity", "Log level set to DEBUG.");
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.log_level_set_to_debug);
            } else if ("$$stopdebug".equalsIgnoreCase(charSequence.toString())) {
                SDKMgr.setLogLevel(LogEx.LogLevelType.TYPE_LOG_LEVEL_ERROR);
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.log_level_set_to_error);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e implements TextView.OnEditorActionListener {

        /* renamed from: a, reason: collision with root package name */
        private int f4085a;

        public e(int i) {
            this.f4085a = i;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == 6) {
                if (ConfigureActivity.this.F != null) {
                    if (!ConfigureActivity.this.F.getEditableText().toString().equals(ConfigureActivity.this.D.get(this.f4085a))) {
                        ConfigureActivity.this.D.set(this.f4085a, ConfigureActivity.this.F.getEditableText().toString());
                        ConfigureActivity.this.E.setText((CharSequence) ConfigureActivity.this.D.get(this.f4085a));
                        ConfigureActivity.this.K = true;
                    }
                    ConfigureActivity.this.F.setVisibility(8);
                    ConfigureActivity.this.F = null;
                }
                if (ConfigureActivity.this.E != null) {
                    ConfigureActivity.this.E.setVisibility(0);
                    ConfigureActivity.this.E = null;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        private int f4087a;

        /* renamed from: b, reason: collision with root package name */
        private EditText f4088b;

        public f(int i, EditText editText) {
            this.f4087a = i;
            this.f4088b = editText;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ConfigureActivity.this.F != null) {
                if (!ConfigureActivity.this.F.getEditableText().toString().equals(ConfigureActivity.this.D.get(this.f4087a))) {
                    ConfigureActivity.this.D.set(ConfigureActivity.this.G, ConfigureActivity.this.F.getEditableText().toString());
                    ConfigureActivity.this.E.setText((CharSequence) ConfigureActivity.this.D.get(ConfigureActivity.this.G));
                    ConfigureActivity.this.K = true;
                }
                ConfigureActivity.this.F.setVisibility(8);
            }
            if (ConfigureActivity.this.E != null) {
                ConfigureActivity.this.E.setVisibility(0);
            }
            view.setVisibility(8);
            this.f4088b.setVisibility(0);
            InputMethodManager inputMethodManager = (InputMethodManager) ConfigureActivity.this.getSystemService("input_method");
            if (view instanceof TextView) {
                ConfigureActivity.this.E = (TextView) view;
                ConfigureActivity.this.F = this.f4088b;
                ConfigureActivity.this.G = this.f4087a;
                ConfigureActivity.this.F.requestFocus();
                if (inputMethodManager.isActive()) {
                    inputMethodManager.showSoftInput(ConfigureActivity.this.F, 0);
                }
            }
        }
    }

    private void init() {
        if (LogEx.LogLevelType.TYPE_LOG_LEVEL_DEBUG == LogEx.getLogLevel()) {
            this.y.setChecked(true);
        } else {
            this.y.setChecked(false);
        }
        this.C = new ArrayList<>();
        this.D = new ArrayList<>();
        this.J = LayoutInflater.from(this);
        this.N = new PreferenceHelper(this, P);
    }

    private void u() {
        this.w = (TextView) findViewById(R.id.txt_save);
        this.x = (TextView) findViewById(R.id.txt_cancel);
        this.y = (ToggleButton) findViewById(R.id.tg_debug);
        this.z = (EditText) findViewById(R.id.etxt_config);
        this.A = (LinearLayout) findViewById(R.id.ll_config_container);
        this.B = (LinearLayout) findViewById(R.id.ll_config);
        this.L = (TextView) findViewById(R.id.title_txt);
        this.M = (TextView) findViewById(R.id.txt_debug);
        com.zte.iptvclient.common.uiframe.f.a(this.w);
        com.zte.iptvclient.common.uiframe.f.a(this.x);
        com.zte.iptvclient.common.uiframe.f.a(this.y);
        com.zte.iptvclient.common.uiframe.f.a(this.z);
        com.zte.iptvclient.common.uiframe.f.a(this.A);
        com.zte.iptvclient.common.uiframe.f.a(this.B);
        com.zte.iptvclient.common.uiframe.f.a(this.L);
        com.zte.iptvclient.common.uiframe.f.a(this.M);
        com.zte.iptvclient.common.uiframe.f.a(findViewById(R.id.title_rlayout));
        com.zte.iptvclient.common.uiframe.f.a(findViewById(R.id.title_bottom_line));
        com.zte.iptvclient.common.uiframe.f.a(findViewById(R.id.ll_debug));
        com.zte.iptvclient.common.uiframe.f.a(findViewById(R.id.ll_btn_buttom));
        this.L.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.configure_avtivity_title));
        this.M.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.configure_mode_debug_mode));
        this.w.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_save));
        this.x.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_cancel));
        this.z.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.configure_item_guestphone));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (this.B.getChildCount() > 0) {
            this.B.removeAllViews();
        }
        for (int i = 0; i < this.C.size(); i++) {
            View inflate = this.J.inflate(R.layout.configure_item, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.txt_config_tag);
            TextView textView2 = (TextView) inflate.findViewById(R.id.txt_config);
            EditText editText = (EditText) inflate.findViewById(R.id.etxt_config);
            TextView textView3 = (TextView) inflate.findViewById(R.id.txt_colon);
            com.zte.iptvclient.common.uiframe.f.a(textView);
            com.zte.iptvclient.common.uiframe.f.a(textView2);
            com.zte.iptvclient.common.uiframe.f.a(editText);
            com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.ll_config_item));
            com.zte.iptvclient.common.uiframe.f.a(textView3);
            com.zte.iptvclient.common.uiframe.f.a(inflate.findViewById(R.id.title_bottom_line));
            textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.configure_item_guestname));
            textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.configure_item_guestphone));
            textView3.setText("   :   ");
            textView.setText(this.C.get(i));
            textView2.setText(this.D.get(i));
            editText.setText(this.D.get(i));
            textView2.setOnClickListener(new f(i, editText));
            editText.setOnEditorActionListener(new e(i));
            this.B.addView(inflate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        this.C.clear();
        this.D.clear();
        this.v = getFilesDir().getAbsolutePath();
        File file = new File(this.v + "/" + O);
        InputStream inputStream = null;
        if (file.exists()) {
            try {
                inputStream = new FileInputStream(file);
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            }
            a(inputStream);
        } else {
            try {
                inputStream = getAssets().open(O);
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            a(inputStream);
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
    }

    private void x() {
        this.w.setOnClickListener(new a());
        this.x.setOnClickListener(new b());
        this.y.setOnCheckedChangeListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zte.fragmentlib.SupportActivity, com.zte.fragmentlib.publicbaseclass.skinloader.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.configure_activity);
        u();
        init();
        x();
        s();
        w();
        v();
    }

    protected String r() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.C.size(); i++) {
            sb.append(this.C.get(i));
            sb.append("=");
            sb.append(this.D.get(i));
            sb.append("\n");
            if (this.C.get(i).equals(IIPTVLogin.LOGIN_HOMEPAGE)) {
                this.N.putString(Q, this.D.get(i));
            }
        }
        return sb.toString();
    }

    public void s() {
        this.z.addTextChangedListener(new d());
    }

    private void a(InputStream inputStream) {
        try {
            if (inputStream == null) {
                LogEx.w("ConfigureActivity", "inputStream is null");
                return;
            }
            try {
                try {
                    Properties properties = new Properties();
                    properties.load(new BufferedInputStream(inputStream));
                    for (Map.Entry entry : properties.entrySet()) {
                        this.C.add((String) entry.getKey());
                        this.D.add((String) entry.getValue());
                    }
                    inputStream.close();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Exception e2) {
                    LogEx.e("ConfigureActivity", "read property from configure file error. property name is " + e2);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.String] */
    public boolean a(String str, String str2, String str3) {
        boolean z;
        FileWriter fileWriter;
        File file = new File(str + "/" + str2);
        if (file.exists()) {
            g.b(file.getAbsolutePath(), "delete");
            file.delete();
        }
        FileWriter fileWriter2 = null;
        FileWriter fileWriter3 = null;
        try {
            try {
                fileWriter = new FileWriter(str + "/" + str2);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception unused) {
        }
        try {
            ?? r0 = "write";
            g.b(fileWriter.toString(), "write");
            fileWriter.write(str3);
            fileWriter.flush();
            fileWriter.close();
            try {
                fileWriter.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            z = true;
            fileWriter2 = r0;
        } catch (Exception unused2) {
            fileWriter3 = fileWriter;
            LogEx.e("ConfigureActivity", "write config file error. file name is " + str2);
            z = false;
            fileWriter2 = fileWriter3;
            if (fileWriter3 != null) {
                try {
                    fileWriter3.close();
                    fileWriter2 = fileWriter3;
                } catch (IOException e3) {
                    e3.printStackTrace();
                    fileWriter2 = fileWriter3;
                }
            }
            return z;
        } catch (Throwable th2) {
            th = th2;
            fileWriter2 = fileWriter;
            if (fileWriter2 != null) {
                try {
                    fileWriter2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
        return z;
    }
}
