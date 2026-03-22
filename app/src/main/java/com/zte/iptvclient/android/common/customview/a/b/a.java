package com.zte.iptvclient.android.common.customview.a.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.video.androidsdk.SDKMgr;
import com.video.androidsdk.cast.SDKCastMgr;
import com.video.androidsdk.common.ParamConst;
import com.video.androidsdk.common.PreferenceHelper;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.log.DebugLogReq;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.log.SDKLogMgr;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.login.impl.IIPTVLogin;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.BasePopupWindow;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.zip.ZipFile;

/* compiled from: ConfigurePopupWindow.java */
/* loaded from: classes.dex */
public class a {
    private static String o0 = "iptvclientsys.ini";
    private static String p0 = "homePagePref";
    private static String q0 = "strEgpShared";
    private LogEx.LogLevelType A;
    private String B;
    private BasePopupWindow D;
    private View E;
    private String F;
    private String G;
    private String H;
    private String I;
    private String J;
    private String K;
    private String L;
    private String N;
    private String O;
    private String P;
    private String R;
    private String S;
    private String T;
    private String U;
    private String V;
    private String W;
    private String X;
    private EditText Y;
    private String Z;

    /* renamed from: a, reason: collision with root package name */
    private PreferenceHelper f4291a;
    private EditText a0;

    /* renamed from: b, reason: collision with root package name */
    private Context f4292b;
    private String b0;

    /* renamed from: c, reason: collision with root package name */
    private View f4293c;
    private String c0;

    /* renamed from: d, reason: collision with root package name */
    private TextView f4294d;
    private TextView e;
    private ToggleButton e0;
    private EditText f;
    private boolean f0;
    private EditText g;
    private ToggleButton h;
    private ToggleButton i;
    private ToggleButton i0;
    private ToggleButton j;
    private RadioButton k;
    private com.zte.iptvclient.android.mobile.d0.a k0;
    private RadioButton l;
    private TextView l0;
    private RadioButton m;
    private String m0;
    private RadioButton n;
    private RadioButton o;
    private RadioButton p;
    private ToggleButton q;
    private RadioGroup r;
    private ToggleButton s;
    private ToggleButton t;
    private RadioGroup u;
    private ToggleButton v;
    private ToggleButton w;
    private ToggleButton x;
    private String y;
    private String z;
    private Map<String, String> C = null;
    private LogEx.LogLevelType M = LogEx.LogLevelType.TYPE_LOG_LEVEL_ERROR;
    private String Q = "";
    private String d0 = "";
    private SharedPreferences.Editor g0 = null;
    private SharedPreferences h0 = null;
    private boolean j0 = false;
    private Handler n0 = new k();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConfigurePopupWindow.java */
    /* renamed from: com.zte.iptvclient.android.common.customview.a.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0125a implements View.OnClickListener {
        ViewOnClickListenerC0125a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(a.this.K)) {
                return;
            }
            if (a.this.K.equals("0")) {
                a.this.X = "1";
            } else {
                a.this.X = "0";
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConfigurePopupWindow.java */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(a.this.Q)) {
                return;
            }
            if (a.this.Q == null || !"0".equals(a.this.Q)) {
                a.this.d0 = "0";
            } else {
                a.this.d0 = "1";
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConfigurePopupWindow.java */
    /* loaded from: classes.dex */
    public class c implements RadioGroup.OnCheckedChangeListener {
        c() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (i == R.id.rb_configure_sdk_log_level_debug) {
                a.this.A = LogEx.LogLevelType.TYPE_LOG_LEVEL_DEBUG;
                return;
            }
            if (i == R.id.rb_configure_sdk_log_level_error) {
                a.this.A = LogEx.LogLevelType.TYPE_LOG_LEVEL_ERROR;
            } else if (i == R.id.rb_configure_sdk_log_level_info) {
                a.this.A = LogEx.LogLevelType.TYPE_LOG_LEVEL_INFO;
            } else if (i == R.id.rb_configure_sdk_log_level_warning) {
                a.this.A = LogEx.LogLevelType.TYPE_LOG_LEVEL_WARNING;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConfigurePopupWindow.java */
    /* loaded from: classes.dex */
    public class d implements CompoundButton.OnCheckedChangeListener {
        d() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                SDKLogMgr.createInstance().startDebugLog();
                SDKCastMgr.getInstance().startWriteLog();
            } else {
                SDKLogMgr.createInstance().stopDebugLog();
                SDKCastMgr.getInstance().stopWriteLog();
                a.this.j();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConfigurePopupWindow.java */
    /* loaded from: classes.dex */
    public class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(a.this.N) || TextUtils.isEmpty(a.this.O)) {
                return;
            }
            if (a.this.O == null || a.this.N == null || !a.this.N.equals("1") || !a.this.O.equals("0")) {
                if (a.this.O == null || a.this.N == null || !a.this.N.equals("0") || !a.this.O.equals("1")) {
                    return;
                }
                a.this.c0 = "0";
                return;
            }
            a.this.c0 = "1";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConfigurePopupWindow.java */
    /* loaded from: classes.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object obj;
            LogEx.LogLevelType logLevelType;
            String str;
            String str2;
            Object obj2;
            LogEx.LogLevelType logLevelType2;
            String str3;
            a aVar = a.this;
            aVar.g0 = aVar.h0.edit();
            a.this.g0.putBoolean(" ZTEPlayerIsWriteLog", a.this.f0);
            a.this.g0.commit();
            String obj3 = a.this.f.getText().toString();
            LogEx.LogLevelType logLevelType3 = a.this.A;
            if (obj3 != null) {
                str = "m_strUseSMSLogin";
                if (a.this.y.equals(obj3)) {
                    if (a.this.H == null || a.this.L == null || a.this.I == null || a.this.P == null || a.this.Q == null) {
                        obj2 = "Msg_login";
                    } else {
                        obj2 = "Msg_login";
                        if (a.this.R.equals(a.this.F) && a.this.S.equals(a.this.G) && a.this.T.equals(a.this.H) && a.this.U.equals(a.this.I) && a.this.X.equals(a.this.K) && a.this.W.equals(a.this.J) && a.this.V.equals(a.this.L) && a.this.Q.equals(a.this.d0) && a.this.c0.equals(a.this.N)) {
                            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a("You should make some changes before you click Ok !");
                            return;
                        }
                    }
                    if (a.this.M.equals(logLevelType3)) {
                        logLevelType2 = logLevelType3;
                    } else {
                        a.this.a(logLevelType3);
                        a.this.M = LogEx.getLogLevel();
                        if (a.this.M == LogEx.LogLevelType.TYPE_LOG_LEVEL_INFO) {
                            str3 = "INFO";
                        } else if (a.this.M == LogEx.LogLevelType.TYPE_LOG_LEVEL_DEBUG) {
                            str3 = "DEBUG";
                        } else if (a.this.M == LogEx.LogLevelType.TYPE_LOG_LEVEL_WARNING) {
                            str3 = "WARNING";
                        } else {
                            str3 = a.this.M == LogEx.LogLevelType.TYPE_LOG_LEVEL_ERROR ? "ERROR" : "";
                        }
                        logLevelType2 = logLevelType3;
                        a.this.C.put("LOGLEVEL", str3);
                        LogEx.i("ConfigurePopupWindowNew", "mTypeLogLevel " + a.this.M);
                    }
                    a.this.f4291a.putString(a.q0, obj3);
                    a.this.C.put(IIPTVLogin.LOGIN_HOMEPAGE, obj3);
                    if (!a.this.y.equals(obj3)) {
                        SDKLoginMgr.getInstance().setHomePage(obj3);
                    }
                    if (a.this.s.isChecked()) {
                        a.this.J = "1";
                        a.this.C.put(ParamConst.DLNA_FlAG, a.this.J);
                        LogEx.i("ConfigurePopupWindowNew", "mStrDlnaFlag" + a.this.J);
                    } else {
                        a.this.J = "0";
                        a.this.C.put(ParamConst.DLNA_FlAG, a.this.J);
                        LogEx.i("ConfigurePopupWindowNew", "mStrDlnaFlag" + a.this.J);
                    }
                    if (a.this.w.isChecked()) {
                        a.this.P = "0";
                        a.this.C.put("EnableLogout", a.this.P);
                        LogEx.i("ConfigurePopupWindowNew", "mStrEnableLogout" + a.this.P);
                    } else {
                        a.this.P = "1";
                        a.this.C.put("EnableLogout", a.this.P);
                        LogEx.i("ConfigurePopupWindowNew", "mStrEnableLogout" + a.this.P);
                    }
                    if (a.this.t.isChecked()) {
                        a.this.K = "1";
                        a.this.C.put(ParamConst.DLNA_DEVFlAG, a.this.K);
                        LogEx.i("ConfigurePopupWindowNew", "mStrDlnaDevFlag" + a.this.K);
                    } else {
                        a.this.K = "0";
                        a.this.C.put(ParamConst.DLNA_DEVFlAG, a.this.K);
                        LogEx.i("ConfigurePopupWindowNew", "mStrDlnaDevFlag" + a.this.K);
                    }
                    if (a.this.h.isChecked()) {
                        a.this.F = "1";
                        a.this.C.put("IsDividePlat", a.this.F);
                        LogEx.i("ConfigurePopupWindowNew", "m_strIsDividePlat" + a.this.F);
                    } else {
                        a.this.F = "0";
                        a.this.C.put("IsDividePlat", a.this.F);
                        LogEx.i("ConfigurePopupWindowNew", "m_strIsDividePlat" + a.this.F);
                    }
                    if (a.this.i.isChecked()) {
                        a.this.G = "1";
                        a.this.C.put(obj2, a.this.G);
                        LogEx.i("ConfigurePopupWindowNew", str + a.this.G);
                    } else {
                        a.this.G = "0";
                        a.this.C.put(obj2, a.this.G);
                        LogEx.i("ConfigurePopupWindowNew", str + a.this.G);
                    }
                    if (a.this.j.isChecked()) {
                        a.this.H = "1";
                        a.this.C.put("EnableTask60", a.this.H);
                        LogEx.i("ConfigurePopupWindowNew", "mStrAutomaticModification" + a.this.H);
                    } else {
                        a.this.H = "0";
                        a.this.C.put("EnableTask60", a.this.H);
                        LogEx.i("ConfigurePopupWindowNew", "mStrAutomaticModification" + a.this.H);
                    }
                    if (a.this.q.isChecked()) {
                        a.this.I = "1";
                        a.this.C.put("GuestEnable", a.this.I);
                        LogEx.i("ConfigurePopupWindowNew", "mStrGuestEnable" + a.this.I);
                    } else {
                        a.this.I = "0";
                        a.this.C.put("GuestEnable", a.this.I);
                        LogEx.i("ConfigurePopupWindowNew", "mStrGuestEnable" + a.this.I);
                    }
                    if (!a.this.k.isChecked()) {
                        if (a.this.l.isChecked()) {
                            a.this.L = DownloadConstant.REPORT_MSGTYPE_ADD;
                            a.this.C.put(ParamConst.DLNA_OPFlAG, a.this.L);
                            LogEx.i("ConfigurePopupWindowNew", "mStrDlnaOpFlag" + a.this.L);
                        }
                    } else {
                        a.this.L = "2";
                        a.this.C.put(ParamConst.DLNA_OPFlAG, a.this.L);
                        LogEx.i("ConfigurePopupWindowNew", "mStrDlnaOpFlag" + a.this.L);
                    }
                    if (a.this.x.isChecked()) {
                        a.this.Q = "1";
                        a.this.C.put("IsSupportPCT", a.this.Q);
                        LogEx.i("ConfigurePopupWindowNew", "mStrHomeSupportPct" + a.this.Q);
                    } else {
                        a.this.Q = "0";
                        a.this.C.put("IsSupportPCT", a.this.Q);
                        LogEx.i("ConfigurePopupWindowNew", "mStrHomeSupportPct" + a.this.Q);
                    }
                    if (a.this.v.isChecked()) {
                        a.this.N = "1";
                        a.this.O = "0";
                        a.this.C.put("Start_Debug", a.this.N);
                        a.this.C.put("Stop_Debug", a.this.O);
                        LogEx.i("ConfigurePopupWindowNew", "mStrSDkStartWriteLog" + a.this.N + "mStrSDkStopWriteLog" + a.this.O);
                    } else {
                        a.this.N = "0";
                        a.this.O = "1";
                        a.this.C.put("Start_Debug", a.this.N);
                        a.this.C.put("Stop_Debug", a.this.O);
                        LogEx.i("ConfigurePopupWindowNew", "mStrSDkStartWriteLog" + a.this.N + "mStrSDkStopWriteLog" + a.this.O);
                    }
                    a aVar2 = a.this;
                    aVar2.Z = aVar2.Y.getText().toString();
                    a.this.C.put("TVInitialBufferingTime", a.this.Z);
                    a aVar3 = a.this;
                    aVar3.b0 = aVar3.a0.getText().toString();
                    a.this.C.put("VODInitialBufferingTime", a.this.b0);
                    a aVar4 = a.this;
                    String a2 = aVar4.a((Map<String, String>) aVar4.C);
                    LogEx.LogLevelType logLevelType4 = logLevelType2;
                    if (!a.this.M.equals(logLevelType4)) {
                        a.this.a(logLevelType4);
                    }
                    a aVar5 = a.this;
                    if (aVar5.a(aVar5.B, a.o0, a2)) {
                        a.this.f();
                        a.this.h();
                        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a("Change the configure file successfully.");
                        a.this.D.dismiss();
                    } else {
                        com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a("Failed to change the configure file, please try again.");
                    }
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a("Change the configure successfully.");
                    a.this.h();
                    a.this.D.dismiss();
                    return;
                }
                obj = "Start_Debug";
                logLevelType = logLevelType3;
            } else {
                obj = "Start_Debug";
                logLevelType = logLevelType3;
                str = "m_strUseSMSLogin";
            }
            a.this.f4291a.putString(a.q0, obj3);
            a.this.C.put(IIPTVLogin.LOGIN_HOMEPAGE, obj3);
            if (!a.this.y.equals(obj3)) {
                SDKLoginMgr.getInstance().setHomePage(obj3);
            }
            if (a.this.s.isChecked()) {
                a.this.J = "1";
                a.this.C.put(ParamConst.DLNA_FlAG, a.this.J);
                LogEx.i("ConfigurePopupWindowNew", "mStrDlnaFlag" + a.this.J);
            } else {
                a.this.J = "0";
                a.this.C.put(ParamConst.DLNA_FlAG, a.this.J);
                LogEx.i("ConfigurePopupWindowNew", "mStrDlnaFlag" + a.this.J);
            }
            if (a.this.w.isChecked()) {
                a.this.P = "0";
                a.this.C.put("EnableLogout", a.this.P);
                LogEx.i("ConfigurePopupWindowNew", "mStrEnableLogout" + a.this.P);
            } else {
                a.this.P = "1";
                a.this.C.put("EnableLogout", a.this.P);
                LogEx.i("ConfigurePopupWindowNew", "mStrEnableLogout" + a.this.P);
            }
            if (a.this.x.isChecked()) {
                a.this.Q = "1";
                a.this.C.put("IsSupportPCT", a.this.Q);
                LogEx.i("ConfigurePopupWindowNew", "mStrHomeSupportPct" + a.this.Q);
            } else {
                a.this.Q = "0";
                a.this.C.put("IsSupportPCT", a.this.Q);
                LogEx.i("ConfigurePopupWindowNew", "mStrHomeSupportPct" + a.this.Q);
            }
            if (a.this.t.isChecked()) {
                a.this.K = "1";
                a.this.C.put(ParamConst.DLNA_DEVFlAG, a.this.K);
                LogEx.i("ConfigurePopupWindowNew", "mStrDlnaDevFlag" + a.this.K);
            } else {
                a.this.K = "0";
                a.this.C.put(ParamConst.DLNA_DEVFlAG, a.this.K);
                LogEx.i("ConfigurePopupWindowNew", "mStrDlnaDevFlag" + a.this.K);
            }
            if (a.this.h.isChecked()) {
                a.this.F = "1";
                a.this.C.put("IsDividePlat", a.this.F);
                LogEx.i("ConfigurePopupWindowNew", "m_strIsDividePlat" + a.this.F);
            } else {
                a.this.F = "0";
                a.this.C.put("IsDividePlat", a.this.F);
                LogEx.i("ConfigurePopupWindowNew", "m_strIsDividePlat" + a.this.F);
            }
            if (a.this.i.isChecked()) {
                a.this.G = "1";
                a.this.C.put("Msg_login", a.this.G);
                LogEx.i("ConfigurePopupWindowNew", str + a.this.G);
            } else {
                a.this.G = "0";
                a.this.C.put("Msg_login", a.this.G);
                LogEx.i("ConfigurePopupWindowNew", str + a.this.G);
            }
            if (a.this.j.isChecked()) {
                a.this.H = "1";
                a.this.C.put("EnableTask60", a.this.H);
                LogEx.i("ConfigurePopupWindowNew", "mStrAutomaticModification" + a.this.H);
            } else {
                a.this.H = "0";
                a.this.C.put("EnableTask60", a.this.H);
                LogEx.i("ConfigurePopupWindowNew", "mStrAutomaticModification" + a.this.H);
            }
            if (a.this.q.isChecked()) {
                a.this.I = "1";
                a.this.C.put("GuestEnable", a.this.I);
                LogEx.i("ConfigurePopupWindowNew", "mStrGuestEnable" + a.this.I);
            } else {
                a.this.I = "0";
                a.this.C.put("GuestEnable", a.this.I);
                LogEx.i("ConfigurePopupWindowNew", "mStrGuestEnable" + a.this.I);
            }
            if (!a.this.k.isChecked()) {
                if (a.this.l.isChecked()) {
                    a.this.L = DownloadConstant.REPORT_MSGTYPE_ADD;
                    a.this.C.put(ParamConst.DLNA_OPFlAG, a.this.L);
                    LogEx.i("ConfigurePopupWindowNew", "mStrDlnaOpFlag" + a.this.L);
                }
            } else {
                a.this.L = "2";
                a.this.C.put(ParamConst.DLNA_OPFlAG, a.this.L);
                LogEx.i("ConfigurePopupWindowNew", "mStrDlnaOpFlag" + a.this.L);
            }
            if (a.this.v.isChecked()) {
                a.this.N = "1";
                a.this.O = "0";
                a.this.C.put(obj, a.this.N);
                a.this.C.put("Stop_Debug", a.this.O);
                LogEx.i("ConfigurePopupWindowNew", "mStrSDkStartWriteLog" + a.this.N + "mStrSDkStopWriteLog" + a.this.O);
            } else {
                a.this.N = "0";
                a.this.O = "1";
                a.this.C.put(obj, a.this.N);
                a.this.C.put("Stop_Debug", a.this.O);
                LogEx.i("ConfigurePopupWindowNew", "mStrSDkStartWriteLog" + a.this.N + "mStrSDkStopWriteLog" + a.this.O);
            }
            a aVar6 = a.this;
            aVar6.Z = aVar6.Y.getText().toString();
            a.this.C.put("TVInitialBufferingTime", a.this.Z);
            a aVar7 = a.this;
            aVar7.b0 = aVar7.a0.getText().toString();
            a.this.C.put("VODInitialBufferingTime", a.this.b0);
            a aVar8 = a.this;
            String a3 = aVar8.a((Map<String, String>) aVar8.C);
            LogEx.LogLevelType logLevelType5 = logLevelType;
            if (!a.this.M.equals(logLevelType5)) {
                a.this.a(logLevelType5);
                if (a.this.M == LogEx.LogLevelType.TYPE_LOG_LEVEL_INFO) {
                    str2 = "INFO";
                } else if (a.this.M == LogEx.LogLevelType.TYPE_LOG_LEVEL_DEBUG) {
                    str2 = "DEBUG";
                } else if (a.this.M == LogEx.LogLevelType.TYPE_LOG_LEVEL_WARNING) {
                    str2 = "WARNING";
                } else {
                    str2 = a.this.M == LogEx.LogLevelType.TYPE_LOG_LEVEL_ERROR ? "ERROR" : "";
                }
                a.this.C.put("LOGLEVEL", str2);
            }
            a aVar9 = a.this;
            if (aVar9.a(aVar9.B, a.o0, a3)) {
                a.this.f();
                a.this.h();
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a("Change the configure file successfully.");
                a.this.D.dismiss();
                return;
            }
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a("Failed to change the configure file, please try again.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConfigurePopupWindow.java */
    /* loaded from: classes.dex */
    public class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.D.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConfigurePopupWindow.java */
    /* loaded from: classes.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConfigurePopupWindow.java */
    /* loaded from: classes.dex */
    public class i implements CompoundButton.OnCheckedChangeListener {
        i() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            LogEx.d("ConfigurePopupWindowNew", "ZTEPlayer DebugLog start");
            if (z) {
                LogEx.d("ConfigurePopupWindowNew", "ZTEPlayer startWriteLog");
                a.this.f0 = true;
            } else {
                LogEx.d("ConfigurePopupWindowNew", "ZTEPlayer stopWriteLog");
                a.this.f0 = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConfigurePopupWindow.java */
    /* loaded from: classes.dex */
    public class j implements CompoundButton.OnCheckedChangeListener {
        j() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            LogEx.d("ConfigurePopupWindowNew", "LogCat  DebugLog start");
            if (z) {
                SDKMgr.setLogLevel(LogEx.LogLevelType.TYPE_LOG_LEVEL_DEBUG);
                LogEx.setLogLevel(LogEx.LogLevelType.TYPE_LOG_LEVEL_DEBUG);
                SDKLogMgr.createInstance().startDebugLog();
                a.this.j0 = true;
                a aVar = a.this;
                aVar.g0 = aVar.h0.edit();
                a.this.g0.putBoolean(" LocalLogCat", a.this.j0);
                a.this.g0.commit();
                return;
            }
            SDKMgr.setLogLevel(LogEx.LogLevelType.TYPE_LOG_LEVEL_INFO);
            LogEx.setLogLevel(LogEx.LogLevelType.TYPE_LOG_LEVEL_INFO);
            SDKLogMgr.createInstance().stopDebugLog();
            a.this.j0 = false;
            a aVar2 = a.this;
            aVar2.g0 = aVar2.h0.edit();
            a.this.g0.putBoolean(" LocalLogCat", a.this.j0);
            a.this.g0.commit();
        }
    }

    /* compiled from: ConfigurePopupWindow.java */
    /* loaded from: classes.dex */
    class k extends Handler {
        k() {
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            if (message.what == 0 && a.this.f4293c != null) {
                a.this.D.showAtLocation(a.this.f4293c, 17, 0, 0);
                a.this.h();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConfigurePopupWindow.java */
    /* loaded from: classes.dex */
    public class l implements SDKLogMgr.OnDebugLogUploadReturnListener {
        l(a aVar) {
        }

        @Override // com.video.androidsdk.log.SDKLogMgr.OnDebugLogUploadReturnListener
        public void onDebugLogUploadReturn(String str, String str2) {
            LogEx.d("ConfigurePopupWindowNew", "OnDebugLogUploadReturn:" + str + str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConfigurePopupWindow.java */
    /* loaded from: classes.dex */
    public class m implements SDKLogMgr.OnDebugLogUploadReturnListener {
        m(a aVar) {
        }

        @Override // com.video.androidsdk.log.SDKLogMgr.OnDebugLogUploadReturnListener
        public void onDebugLogUploadReturn(String str, String str2) {
            LogEx.d("ConfigurePopupWindowNew", "OnDebugLogUploadReturn:" + str + str2);
        }
    }

    /* compiled from: ConfigurePopupWindow.java */
    /* loaded from: classes.dex */
    static class n implements TextWatcher {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f4306a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ EditText f4307b;

        n(Context context, EditText editText) {
            this.f4306a = context;
            this.f4307b = editText;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String str = "zxiptv" + new SimpleDateFormat("yyyyMMdd").format(new Date());
            if ("$$showversion".equalsIgnoreCase(editable.toString()) || "$$startdebug".equalsIgnoreCase(editable.toString()) || "$$stopdebug".equalsIgnoreCase(editable.toString()) || "$$startuimode".equalsIgnoreCase(editable.toString()) || "$$stopuimode".equalsIgnoreCase(editable.toString()) || str.equalsIgnoreCase(editable.toString())) {
                editable.clear();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (("zxiptv" + new SimpleDateFormat("yyyyMMdd").format(new Date())).equals(charSequence.toString())) {
                if (new a(this.f4306a, this.f4307b).a() == 0) {
                    LogEx.d("ConfigurePopupWindowNew", "Succeed to start ConfigurePopupWindowNew!");
                    return;
                }
                return;
            }
            if ("$$startdebug".equalsIgnoreCase(charSequence.toString())) {
                LogEx.setLogLevel(LogEx.LogLevelType.TYPE_LOG_LEVEL_DEBUG);
                LogEx.d("ConfigurePopupWindowNew", "Log level set to DEBUG.");
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(this.f4306a.toString() + "Log level set to DEBUG!");
                return;
            }
            if ("$$stopdebug".equalsIgnoreCase(charSequence.toString())) {
                LogEx.setLogLevel(LogEx.LogLevelType.TYPE_LOG_LEVEL_ERROR);
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(this.f4306a.toString() + "Log level set to ERROR!");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConfigurePopupWindow.java */
    /* loaded from: classes.dex */
    public class o extends Thread {
        o() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a.this.n0.sendEmptyMessage(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConfigurePopupWindow.java */
    /* loaded from: classes.dex */
    public class p implements View.OnClickListener {
        p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(a.this.F)) {
                return;
            }
            if (a.this.F.equals("0")) {
                a.this.R = "1";
            } else {
                a.this.R = "0";
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConfigurePopupWindow.java */
    /* loaded from: classes.dex */
    public class q implements View.OnClickListener {
        q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(a.this.G)) {
                return;
            }
            if (a.this.G.equals("0")) {
                a.this.S = "1";
            } else {
                a.this.S = "0";
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConfigurePopupWindow.java */
    /* loaded from: classes.dex */
    public class r implements View.OnClickListener {
        r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(a.this.H)) {
                return;
            }
            if (a.this.H == null || !a.this.H.equals("0")) {
                a.this.T = "0";
            } else {
                a.this.T = "1";
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConfigurePopupWindow.java */
    /* loaded from: classes.dex */
    public class s implements View.OnClickListener {
        s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(a.this.I)) {
                return;
            }
            if (a.this.I == null || !a.this.I.equals("0")) {
                a.this.U = "0";
            } else {
                a.this.U = "1";
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConfigurePopupWindow.java */
    /* loaded from: classes.dex */
    public class t implements RadioGroup.OnCheckedChangeListener {
        t() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (i == R.id.rb_configure_interactive_type_two) {
                a.this.V = "2";
            } else if (i == R.id.rb_configure_interactive_type_five) {
                a.this.V = DownloadConstant.REPORT_MSGTYPE_ADD;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConfigurePopupWindow.java */
    /* loaded from: classes.dex */
    public class u implements View.OnClickListener {
        u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(a.this.J)) {
                return;
            }
            if (a.this.J.equals("0")) {
                a.this.W = "1";
            } else {
                a.this.W = "0";
            }
        }
    }

    public a(Context context, View view) {
        this.f4291a = null;
        this.f4292b = context;
        this.m0 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss ").format(new Date(a(context)));
        this.f4293c = view;
        this.f4291a = new PreferenceHelper(this.f4292b, p0);
        com.zte.iptvclient.android.mobile.d0.a a2 = com.zte.iptvclient.android.mobile.d0.a.a(this.f4292b);
        this.k0 = a2;
        a2.a("zala_logcat.log");
        e();
        d();
        f();
        h();
        i();
    }

    private void d() {
        TextView textView = (TextView) this.E.findViewById(R.id.tv_configure_cancle);
        this.f4294d = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_cancel));
        com.zte.iptvclient.common.uiframe.f.a(this.f4294d);
        TextView textView2 = (TextView) this.E.findViewById(R.id.tv_configure_done);
        this.e = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.confirm_done));
        com.zte.iptvclient.common.uiframe.f.a(this.e);
        EditText editText = (EditText) this.E.findViewById(R.id.et_configure_address_login);
        this.f = editText;
        com.zte.iptvclient.common.uiframe.f.a(editText);
        EditText editText2 = (EditText) this.E.findViewById(R.id.et_bak_address_login);
        this.g = editText2;
        com.zte.iptvclient.common.uiframe.f.a(editText2);
        ToggleButton toggleButton = (ToggleButton) this.E.findViewById(R.id.tb_configure_use_branch);
        this.h = toggleButton;
        com.zte.iptvclient.common.uiframe.f.a(toggleButton);
        ToggleButton toggleButton2 = (ToggleButton) this.E.findViewById(R.id.tb_configure_use_sms_login);
        this.i = toggleButton2;
        com.zte.iptvclient.common.uiframe.f.a(toggleButton2);
        ToggleButton toggleButton3 = (ToggleButton) this.E.findViewById(R.id.tb_configure_use_automatic_modification);
        this.j = toggleButton3;
        com.zte.iptvclient.common.uiframe.f.a(toggleButton3);
        ToggleButton toggleButton4 = (ToggleButton) this.E.findViewById(R.id.tb_configure_use_visitors_account);
        this.q = toggleButton4;
        com.zte.iptvclient.common.uiframe.f.a(toggleButton4);
        RadioButton radioButton = (RadioButton) this.E.findViewById(R.id.rb_configure_interactive_type_two);
        this.k = radioButton;
        radioButton.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.configure_combine_two));
        com.zte.iptvclient.common.uiframe.f.a(this.k);
        RadioButton radioButton2 = (RadioButton) this.E.findViewById(R.id.rb_configure_interactive_type_five);
        this.l = radioButton2;
        radioButton2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.configure_devide_five));
        com.zte.iptvclient.common.uiframe.f.a(this.l);
        ToggleButton toggleButton5 = (ToggleButton) this.E.findViewById(R.id.tb_configure_enable_dlna_switch);
        this.s = toggleButton5;
        com.zte.iptvclient.common.uiframe.f.a(toggleButton5);
        ToggleButton toggleButton6 = (ToggleButton) this.E.findViewById(R.id.tb_configure_screening_zte_stb);
        this.t = toggleButton6;
        com.zte.iptvclient.common.uiframe.f.a(toggleButton6);
        RadioGroup radioGroup = (RadioGroup) this.E.findViewById(R.id.rg_configure_sdk_log_level);
        this.u = radioGroup;
        com.zte.iptvclient.common.uiframe.f.a(radioGroup);
        RadioGroup radioGroup2 = (RadioGroup) this.E.findViewById(R.id.rg_configure_interactive_type);
        this.r = radioGroup2;
        com.zte.iptvclient.common.uiframe.f.a(radioGroup2);
        RadioButton radioButton3 = (RadioButton) this.E.findViewById(R.id.rb_configure_sdk_log_level_error);
        this.m = radioButton3;
        radioButton3.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.configure_loglevel_error));
        com.zte.iptvclient.common.uiframe.f.a(this.m);
        RadioButton radioButton4 = (RadioButton) this.E.findViewById(R.id.rb_configure_sdk_log_level_debug);
        this.n = radioButton4;
        radioButton4.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.configure_loglevel_debug));
        com.zte.iptvclient.common.uiframe.f.a(this.n);
        RadioButton radioButton5 = (RadioButton) this.E.findViewById(R.id.rb_configure_sdk_log_level_info);
        this.o = radioButton5;
        radioButton5.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.configure_loglevel_info));
        com.zte.iptvclient.common.uiframe.f.a(this.o);
        RadioButton radioButton6 = (RadioButton) this.E.findViewById(R.id.rb_configure_sdk_log_level_warning);
        this.p = radioButton6;
        radioButton6.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.configure_loglevel_warning));
        com.zte.iptvclient.common.uiframe.f.a(this.p);
        ToggleButton toggleButton7 = (ToggleButton) this.E.findViewById(R.id.tb_configure_sdk_log_write_switch);
        this.v = toggleButton7;
        com.zte.iptvclient.common.uiframe.f.a(toggleButton7);
        ToggleButton toggleButton8 = (ToggleButton) this.E.findViewById(R.id.tb_configure_enablelogout_switch);
        this.w = toggleButton8;
        com.zte.iptvclient.common.uiframe.f.a(toggleButton8);
        ToggleButton toggleButton9 = (ToggleButton) this.E.findViewById(R.id.pct_tg_configure_enablelogout_switch);
        this.x = toggleButton9;
        com.zte.iptvclient.common.uiframe.f.a(toggleButton9);
        ToggleButton toggleButton10 = (ToggleButton) this.E.findViewById(R.id.tb_configure_zteplayer_debuglog_upload);
        this.e0 = toggleButton10;
        com.zte.iptvclient.common.uiframe.f.a(toggleButton10);
        ToggleButton toggleButton11 = (ToggleButton) this.E.findViewById(R.id.tb_logcat);
        this.i0 = toggleButton11;
        com.zte.iptvclient.common.uiframe.f.a(toggleButton11);
        this.l0 = (TextView) this.E.findViewById(R.id.tv_configure_app_create_time_show);
        ((TextView) this.E.findViewById(R.id.tv_configure_title)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.configure_engineering_configuration));
        com.zte.iptvclient.common.uiframe.f.a(this.l0);
        com.zte.iptvclient.common.uiframe.f.a(this.E.findViewById(R.id.tv_configure_title));
        com.zte.iptvclient.common.uiframe.f.a(this.E.findViewById(R.id.tv_configure_login));
        com.zte.iptvclient.common.uiframe.f.a(this.E.findViewById(R.id.tv_configure_address_login));
        com.zte.iptvclient.common.uiframe.f.a(this.E.findViewById(R.id.txt_bak_address_login));
        com.zte.iptvclient.common.uiframe.f.a(this.E.findViewById(R.id.tv_configure_use_branch));
        com.zte.iptvclient.common.uiframe.f.a(this.E.findViewById(R.id.tv_configure_use_sms_login));
        com.zte.iptvclient.common.uiframe.f.a(this.E.findViewById(R.id.tv_configure_use_automatic_modification));
        com.zte.iptvclient.common.uiframe.f.a(this.E.findViewById(R.id.tv_configure_use_visitors_account));
        com.zte.iptvclient.common.uiframe.f.a(this.E.findViewById(R.id.tv_configure_interactive_configuration));
        com.zte.iptvclient.common.uiframe.f.a(this.E.findViewById(R.id.tv_configure_interactive_operation_type));
        com.zte.iptvclient.common.uiframe.f.a(this.E.findViewById(R.id.tv_configure_enable_DLNA_switch));
        com.zte.iptvclient.common.uiframe.f.a(this.E.findViewById(R.id.tv_configure_screening_zte_stb));
        com.zte.iptvclient.common.uiframe.f.a(this.E.findViewById(R.id.tv_configure_log_configuration));
        com.zte.iptvclient.common.uiframe.f.a(this.E.findViewById(R.id.tv_configure_sdk_log_level));
        com.zte.iptvclient.common.uiframe.f.a(this.E.findViewById(R.id.tv_configure_sdk_log_write_switch));
        com.zte.iptvclient.common.uiframe.f.a(this.E.findViewById(R.id.tv_configure_enablelogout_switch));
        com.zte.iptvclient.common.uiframe.f.a(this.E.findViewById(R.id.pct_configure_enablelogout_switch));
        com.zte.iptvclient.common.uiframe.f.a(this.E.findViewById(R.id.tv_configure_zteplayer_debuglog_upload));
        com.zte.iptvclient.common.uiframe.f.a(this.E.findViewById(R.id.logcat));
        com.zte.iptvclient.common.uiframe.f.a(this.E.findViewById(R.id.tv_configure_app_create_time));
        this.Y = (EditText) this.E.findViewById(R.id.et_cache_time_tv);
        this.a0 = (EditText) this.E.findViewById(R.id.et_cache_time_vod);
        com.zte.iptvclient.common.uiframe.f.a(this.E.findViewById(R.id.play_configure));
        com.zte.iptvclient.common.uiframe.f.a(this.E.findViewById(R.id.tv_cache_time_tv));
        com.zte.iptvclient.common.uiframe.f.a(this.E.findViewById(R.id.tv_cache_time_vod));
        com.zte.iptvclient.common.uiframe.f.a(this.E.findViewById(R.id.et_cache_time_tv));
        com.zte.iptvclient.common.uiframe.f.a(this.E.findViewById(R.id.et_cache_time_vod));
        ((TextView) this.E.findViewById(R.id.tv_configure_login)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.configure_login_configuration));
        ((TextView) this.E.findViewById(R.id.tv_configure_address_login)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.configure_login_address));
        ((TextView) this.E.findViewById(R.id.txt_bak_address_login)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.bak_login_address));
        ((TextView) this.E.findViewById(R.id.tv_configure_use_branch)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.configure_enable_separate));
        ((TextView) this.E.findViewById(R.id.tv_configure_use_sms_login)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.configure_use_sms_login));
        ((TextView) this.E.findViewById(R.id.tv_configure_use_automatic_modification)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.configure_use_automatic_loading));
        ((TextView) this.E.findViewById(R.id.tv_configure_use_visitors_account)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.configure_enable_guest_account));
        ((TextView) this.E.findViewById(R.id.tv_configure_enablelogout_switch)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.configure_enable_logout));
        ((TextView) this.E.findViewById(R.id.pct_configure_enablelogout_switch)).setText("Home Support PCT");
        ((TextView) this.E.findViewById(R.id.tv_configure_interactive_configuration)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.configure_interactive_configuration));
        ((TextView) this.E.findViewById(R.id.tv_configure_interactive_operation_type)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.configure_interactive_operation_type));
        ((TextView) this.E.findViewById(R.id.tv_configure_enable_DLNA_switch)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.configure_enable_dlna_switch));
        ((TextView) this.E.findViewById(R.id.tv_configure_screening_zte_stb)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.configure__screening_zte_stb));
        ((TextView) this.E.findViewById(R.id.play_configure)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.play_setting));
        ((TextView) this.E.findViewById(R.id.tv_cache_time_tv)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.tv_cache_time));
        ((TextView) this.E.findViewById(R.id.tv_cache_time_vod)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.vod_cache_time));
        ((TextView) this.E.findViewById(R.id.tv_configure_log_configuration)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.configure_log_configuration));
        ((TextView) this.E.findViewById(R.id.tv_configure_sdk_log_level)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.configure_log_level));
        ((TextView) this.E.findViewById(R.id.tv_configure_sdk_log_write_switch)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.configure_log_write_switch));
        ((TextView) this.E.findViewById(R.id.tv_configure_zteplayer_debuglog_upload)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.zteplayer_debuglog_upload));
        ((TextView) this.E.findViewById(R.id.logcat)).setText("Local storage log");
        ((TextView) this.E.findViewById(R.id.tv_configure_app_create_time)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.app_create_time));
        ((TextView) this.E.findViewById(R.id.tv_configure_title)).setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.configure_engineering_configuration));
    }

    private void e() {
        this.E = LayoutInflater.from(this.f4292b.getApplicationContext()).inflate(R.layout.popupwindow_configure_new, (ViewGroup) null);
        BasePopupWindow basePopupWindow = new BasePopupWindow(this.E, -1, -1, true);
        this.D = basePopupWindow;
        basePopupWindow.setBackgroundDrawable(new BitmapDrawable());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x02c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f() {
        /*
            Method dump skipped, instructions count: 721
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.common.customview.a.b.a.f():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.f4292b.getSystemService("input_method");
        if (inputMethodManager.isActive()) {
            inputMethodManager.hideSoftInputFromWindow(this.E.getWindowToken(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        String str;
        String str2;
        String str3 = this.y;
        if (str3 != null) {
            this.f.setText(str3);
        }
        String str4 = this.z;
        if (str4 != null) {
            this.g.setText(str4);
        }
        if (!TextUtils.isEmpty(this.I)) {
            String str5 = this.I;
            if (str5 != null && str5.equals("0")) {
                this.q.setChecked(false);
                this.U = "0";
            } else {
                String str6 = this.I;
                if (str6 != null && str6.equals("1")) {
                    this.q.setChecked(true);
                    this.U = "1";
                }
            }
        }
        if (!TextUtils.isEmpty(this.G)) {
            String str7 = this.G;
            if (str7 != null && str7.equals("0")) {
                this.i.setChecked(false);
                this.S = "0";
            } else {
                String str8 = this.G;
                if (str8 != null && str8.equals("1")) {
                    this.i.setChecked(true);
                    this.S = "1";
                }
            }
        }
        if (!TextUtils.isEmpty(this.H)) {
            String str9 = this.H;
            if (str9 != null && str9.equals("0")) {
                this.j.setChecked(false);
                this.T = "0";
            } else {
                String str10 = this.H;
                if (str10 != null && str10.equals("1")) {
                    this.j.setChecked(true);
                    this.T = "1";
                }
            }
        }
        if (!TextUtils.isEmpty(this.L)) {
            String str11 = this.L;
            if (str11 != null && str11.equals("2")) {
                this.k.setChecked(true);
                this.V = "2";
            } else {
                String str12 = this.L;
                if (str12 != null && str12.equals(DownloadConstant.REPORT_MSGTYPE_ADD)) {
                    this.l.setChecked(true);
                    this.V = DownloadConstant.REPORT_MSGTYPE_ADD;
                }
            }
        }
        this.A = this.M;
        LogEx.i("ConfigurePopupWindowNew", "mTypeLogLevel is " + this.M);
        LogEx.LogLevelType logLevelType = LogEx.LogLevelType.TYPE_LOG_LEVEL_ERROR;
        LogEx.LogLevelType logLevelType2 = this.M;
        if (logLevelType == logLevelType2) {
            this.m.setChecked(true);
        } else if (LogEx.LogLevelType.TYPE_LOG_LEVEL_DEBUG == logLevelType2) {
            this.n.setChecked(true);
        } else if (LogEx.LogLevelType.TYPE_LOG_LEVEL_INFO == logLevelType2) {
            this.o.setChecked(true);
        } else if (LogEx.LogLevelType.TYPE_LOG_LEVEL_WARNING == logLevelType2) {
            this.p.setChecked(true);
        }
        LogEx.i("ConfigurePopupWindowNew", "DlnaFLag = " + this.J);
        String str13 = this.J;
        if (str13 != null) {
            if (str13.equals("0")) {
                this.s.setChecked(false);
                this.W = "0";
            } else if (this.J.equals("1")) {
                this.s.setChecked(true);
                this.W = "1";
            }
        }
        String str14 = this.K;
        if (str14 != null) {
            if (str14.equals("0")) {
                this.t.setChecked(false);
                this.X = "0";
            } else if (this.K.equals("1")) {
                this.t.setChecked(true);
                this.X = "1";
            }
        }
        String str15 = this.F;
        if (str15 != null) {
            if (str15.equals("0")) {
                this.h.setChecked(false);
                this.R = "0";
            } else if (this.F.equals("1")) {
                this.h.setChecked(true);
                this.R = "1";
            }
        }
        if (!TextUtils.isEmpty(this.P)) {
            String str16 = this.P;
            if (str16 != null && str16.equals("0")) {
                this.w.setChecked(true);
                this.R = "0";
            } else {
                String str17 = this.P;
                if (str17 != null && str17.equals("1")) {
                    this.w.setChecked(false);
                    this.R = "1";
                }
            }
        }
        if (!TextUtils.isEmpty(this.Q)) {
            String str18 = this.Q;
            if (str18 != null && "1".equals(str18)) {
                this.x.setChecked(true);
                this.d0 = "1";
            } else {
                String str19 = this.P;
                if (str19 != null && str19.equals("0")) {
                    this.x.setChecked(false);
                    this.d0 = "0";
                }
            }
        }
        if (!TextUtils.isEmpty(this.N) && !TextUtils.isEmpty(this.O)) {
            String str20 = this.N;
            if (str20 != null && str20.equals("1") && (str2 = this.O) != null && str2.equals("0")) {
                this.v.setChecked(true);
                this.c0 = "1";
            } else if (this.O != null && (str = this.N) != null && str.equals("0") && this.O.equals("1")) {
                this.v.setChecked(false);
                this.c0 = "0";
            }
        }
        LogEx.d("ConfigurePopupWindowNew", "mZTEPlayerLogBool is " + this.f0);
        this.e0.setChecked(this.f0);
        this.i0.setChecked(this.j0);
        LogEx.d("ConfigurePopupWindowNew", "mstrAPPCreateTime is " + this.m0);
        this.l0.setText(this.m0);
        if (!TextUtils.isEmpty(this.Z)) {
            this.Y.setText(this.Z);
        }
        if (TextUtils.isEmpty(this.b0)) {
            return;
        }
        this.a0.setText(this.b0);
    }

    private void i() {
        this.h.setOnClickListener(new p());
        this.i.setOnClickListener(new q());
        this.j.setOnClickListener(new r());
        this.q.setOnClickListener(new s());
        this.r.setOnCheckedChangeListener(new t());
        this.s.setOnClickListener(new u());
        this.t.setOnClickListener(new ViewOnClickListenerC0125a());
        this.x.setOnClickListener(new b());
        this.u.setOnCheckedChangeListener(new c());
        this.v.setOnCheckedChangeListener(new d());
        this.v.setOnClickListener(new e());
        this.e.setOnClickListener(new f());
        this.f4294d.setOnClickListener(new g());
        this.E.setOnClickListener(new h());
        this.e0.setOnCheckedChangeListener(new i());
        this.i0.setOnCheckedChangeListener(new j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        LogEx.d("ConfigurePopupWindowNew", "uploadLog() run");
        this.N = "0";
        this.O = "1";
        String d2 = com.zte.iptvclient.android.common.k.o.j().d();
        if (TextUtils.isEmpty(d2)) {
            d2 = ConfigMgr.readPropertie("Log_Server_Address");
        }
        SDKLogMgr.createInstance().setSeverDomain(d2);
        DebugLogReq debugLogReq = new DebugLogReq();
        debugLogReq.setTerminalType("Android");
        try {
            PackageInfo packageInfo = this.f4292b.getPackageManager().getPackageInfo(this.f4292b.getApplicationContext().getPackageName(), 0);
            String charSequence = packageInfo.applicationInfo.loadLabel(this.f4292b.getPackageManager()).toString();
            String str = packageInfo.versionName;
            debugLogReq.setAppName(charSequence);
            debugLogReq.setAppVersion(str);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
        debugLogReq.setUserName(com.zte.iptvclient.common.uiframe.a.d("UserID"));
        SDKLogMgr.createInstance().uploadDebugLog(debugLogReq, new l(this));
        debugLogReq.setFilePath(ConfigMgr.getDlnaLogFilePath());
        SDKLogMgr.createInstance().uploadDebugLog(debugLogReq, new m(this));
    }

    public static void a(Context context, EditText editText) {
        editText.addTextChangedListener(new n(context, editText));
    }

    public int a() {
        new o().start();
        LogEx.d("ConfigurePopupWindowNew", "Init ConfigurePopwindow");
        return 0;
    }

    private long a(Context context) {
        ZipFile zipFile;
        ZipFile zipFile2 = null;
        try {
            try {
                zipFile = new ZipFile(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.sourceDir);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            long time = zipFile.getEntry("classes.dex").getTime();
            try {
                zipFile.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            return time;
        } catch (Exception e4) {
            e = e4;
            zipFile2 = zipFile;
            e.printStackTrace();
            if (zipFile2 == null) {
                return 0L;
            }
            try {
                zipFile2.close();
                return 0L;
            } catch (IOException e5) {
                e5.printStackTrace();
                return 0L;
            }
        } catch (Throwable th2) {
            th = th2;
            zipFile2 = zipFile;
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LogEx.LogLevelType logLevelType) {
        LogEx.LogLevelType logLevelType2 = LogEx.LogLevelType.TYPE_LOG_LEVEL_ERROR;
        if (logLevelType2 == logLevelType) {
            LogEx.setLogLevel(logLevelType2);
            LogEx.d("ConfigurePopupWindowNew", "Log level set to ERROR.");
            return;
        }
        LogEx.LogLevelType logLevelType3 = LogEx.LogLevelType.TYPE_LOG_LEVEL_WARNING;
        if (logLevelType3 == logLevelType) {
            LogEx.setLogLevel(logLevelType3);
            LogEx.d("ConfigurePopupWindowNew", "Log level set to WARN.");
            return;
        }
        LogEx.LogLevelType logLevelType4 = LogEx.LogLevelType.TYPE_LOG_LEVEL_DEBUG;
        if (logLevelType4 == logLevelType) {
            LogEx.setLogLevel(logLevelType4);
            LogEx.d("ConfigurePopupWindowNew", "Log level set to DEBUG.");
            return;
        }
        LogEx.LogLevelType logLevelType5 = LogEx.LogLevelType.TYPE_LOG_LEVEL_INFO;
        if (logLevelType5 == logLevelType) {
            LogEx.setLogLevel(logLevelType5);
            LogEx.d("ConfigurePopupWindowNew", "Log level set to INFO.");
        }
    }

    private Map<String, String> a(InputStream inputStream) {
        HashMap hashMap;
        String str = null;
        try {
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        if (inputStream == null) {
            LogEx.w("ConfigurePopupWindowNew", "inputStream is null");
            return null;
        }
        try {
            try {
                hashMap = new HashMap();
                try {
                    Properties properties = new Properties();
                    properties.load(new BufferedInputStream(inputStream));
                    for (String str2 : properties.keySet()) {
                        try {
                            hashMap.put(str2, (String) properties.get(str2));
                            str = str2;
                        } catch (Exception unused) {
                            str = str2;
                            LogEx.e("ConfigurePopupWindowNew", "read property from configure file error. property name is " + str);
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return hashMap;
                        }
                    }
                    inputStream.close();
                } catch (Exception unused2) {
                }
            } catch (Exception unused3) {
                hashMap = null;
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return hashMap;
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (String str : map.keySet()) {
            String str2 = map.get(str);
            sb.append(str);
            sb.append("=");
            sb.append(str2);
            sb.append("\n");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.String] */
    public boolean a(String str, String str2, String str3) {
        boolean z;
        FileWriter fileWriter;
        File file = new File(str + "/" + str2);
        if (file.exists()) {
            com.zte.iptvclient.android.common.k.g.b(file.getAbsolutePath(), "delete");
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
            com.zte.iptvclient.android.common.k.g.b(fileWriter.toString(), "write");
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
            LogEx.e("ConfigurePopupWindowNew", "write config file error. file name is " + str2);
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
