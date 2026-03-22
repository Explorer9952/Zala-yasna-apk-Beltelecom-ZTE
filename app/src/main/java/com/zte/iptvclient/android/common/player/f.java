package com.zte.iptvclient.android.common.player;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import com.google.gson.Gson;
import com.video.androidsdk.ad.SDKAdAPI;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.http.bean.HttpRequest;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.mes.SDKPushMsgMgr;
import com.video.androidsdk.service.bookmark.GetBookMarkReq;
import com.video.androidsdk.service.bookmark.SDKBookMarkMgr;
import com.video.androidsdk.service.comm.ParamConst;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.javabean.models.Feature;
import com.zte.iptvclient.android.common.k.x;
import com.zte.iptvclient.android.common.player.activity.VOPlayerActivity;
import com.zte.iptvclient.android.common.player.d;
import com.zte.iptvclient.android.mobile.ivi.DefinitionBean;
import com.zte.iptvclient.android.zala.R;
import com.zte.servicesdk.util.PortalConst;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PlayerHelper.java */
/* loaded from: classes.dex */
public class f {
    private static String g0 = "PlayerHelper";
    private static String h0 = "eng";
    private static com.zte.iptvclient.android.common.player.j.e i0;
    private static com.zte.iptvclient.android.common.player.j.e j0;
    private ArrayList<Integer> A;
    private ArrayList<Integer> B;
    private ArrayList<Integer> C;
    private ArrayList<Integer> D;
    private ArrayList<Integer> E;
    private int F;
    private int G;
    private ArrayList<Integer> H;
    private ArrayList<Integer> I;
    private ArrayList<Integer> J;
    private ArrayList<Integer> K;
    private ArrayList<String> L;
    private ArrayList<String> M;
    private ArrayList<String> N;
    private ArrayList<String> O;
    private int P;
    private int Q;
    private ArrayList<String> R;
    private ArrayList<String> S;
    private ArrayList<String> T;
    private String U;
    private List<String> V;
    private boolean W;
    private boolean X;
    private com.zte.iptvclient.android.common.j.h Y;
    private String Z;
    private SDKAdAPI a0;

    /* renamed from: b, reason: collision with root package name */
    private Context f4881b;
    private boolean b0;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<Context> f4882c;
    private SupportActivity c0;
    private boolean d0;
    private FragmentManager e;
    private boolean e0;
    private int f;
    private int f0;
    private com.zte.iptvclient.android.common.player.k.c g;
    private Bundle h;
    private String j;
    private String k;
    private String l;
    private com.zte.iptvclient.common.uiframe.a r;
    private String s;
    private ArrayList<String> t;
    private ArrayList<String> u;
    private ArrayList<String> v;
    private ArrayList<Integer> w;
    private ArrayList<Integer> x;
    private ArrayList<Integer> y;
    private ArrayList<Integer> z;

    /* renamed from: a, reason: collision with root package name */
    private boolean f4880a = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f4883d = false;
    private String i = "";
    private String m = "";
    private String n = "";
    private String o = "";
    private String p = "";
    private String q = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerHelper.java */
    /* loaded from: classes.dex */
    public class a implements SDKPushMsgMgr.OnTerminalPlayStatusReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f4884a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f4885b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.player.j.f f4886c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bundle f4887d;

        a(Context context, int i, com.zte.iptvclient.android.common.player.j.f fVar, Bundle bundle) {
            this.f4884a = context;
            this.f4885b = i;
            this.f4886c = fVar;
            this.f4887d = bundle;
        }

        @Override // com.video.androidsdk.mes.SDKPushMsgMgr.OnTerminalPlayStatusReturnListener
        public void onTerminalPlayStatusReturn(String str, String str2, String str3) {
            LogEx.d(f.g0, "onTerminalPlayStatusReturn response data::::" + str3);
            LogEx.d(f.g0, "Test the starting speed : getTerminalPlayStatus back ");
            if ("0".equals(str)) {
                try {
                    JSONArray optJSONArray = new JSONObject(str3).optJSONArray("deviceinfo");
                    int i = 0;
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        int i2 = 0;
                        while (i < optJSONArray.length()) {
                            String optString = optJSONArray.optJSONObject(i).optString("playstatus");
                            if ("1".equals(optString) || "3".equals(optString) || "4".equals(optString) || DownloadConstant.REPORT_MSGTYPE_ADD.equals(optString)) {
                                i2++;
                            }
                            i++;
                        }
                        i = i2;
                    }
                    LogEx.d(f.g0, "onTerminalPlayStatusReturn currentDevice " + i);
                    f.this.f0 = f.this.i();
                    LogEx.d(f.g0, "maxSuppoertDeviceOnline::::" + f.this.f0);
                    if (f.this.f0 <= i && com.zte.iptvclient.android.mobile.n.c.b.t()) {
                        f.this.a(this.f4884a);
                        return;
                    }
                } catch (Exception e) {
                    LogEx.e(f.g0, "onTerminalPlayStatusReturn get Exception " + e.getMessage());
                }
            }
            LogEx.d(f.g0, "progressPlay");
            f.this.a(this.f4885b, this.f4886c, this.f4887d, this.f4884a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerHelper.java */
    /* loaded from: classes.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ EditText f4888a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f4889b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.customview.a.a.a.b f4890c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f4891d;
        final /* synthetic */ com.zte.iptvclient.android.common.player.j.f e;
        final /* synthetic */ Bundle f;

        b(EditText editText, Context context, com.zte.iptvclient.android.common.customview.a.a.a.b bVar, int i, com.zte.iptvclient.android.common.player.j.f fVar, Bundle bundle) {
            this.f4888a = editText;
            this.f4889b = context;
            this.f4890c = bVar;
            this.f4891d = i;
            this.e = fVar;
            this.f = bundle;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.f4888a.getText().toString().equals(f.this.Y.u())) {
                f.this.a(this.f4888a, this.f4889b);
                this.f4890c.dismiss();
                if (f.this.g != null) {
                    f.this.g.r2();
                }
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.j.a());
                f.this.e(this.f4891d, this.e, this.f, this.f4889b);
                return;
            }
            if ("2".equals(com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_INNOVATIVE_SERVICE_FLAG))) {
                f.this.a(this.f4888a, this.f4889b);
                if (!f.this.f4883d) {
                    f.this.h();
                }
                this.f4890c.dismiss();
                if (f.this.g != null) {
                    f.this.g.r2();
                    return;
                }
                return;
            }
            if (this.f4888a.getText() != null && !TextUtils.isEmpty(this.f4888a.getText())) {
                this.f4888a.setText("");
                this.f4890c.a(com.zte.iptvclient.android.common.i.a.a.a(R.string.limitpwd_is_wrong));
            } else {
                this.f4890c.a(com.zte.iptvclient.android.common.i.a.a.a(R.string.profile_select_empty));
            }
            if (!f.this.f4883d) {
                f.this.h();
            }
            if (f.this.g != null) {
                f.this.g.r2();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerHelper.java */
    /* loaded from: classes.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.customview.a.a.a.b f4892a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ EditText f4893b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f4894c;

        c(com.zte.iptvclient.android.common.customview.a.a.a.b bVar, EditText editText, Context context) {
            this.f4892a = bVar;
            this.f4893b = editText;
            this.f4894c = context;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            this.f4892a.dismiss();
            if (!f.this.f4883d) {
                f.this.h();
            }
            f.this.a(this.f4893b, this.f4894c);
            if (f.this.g != null) {
                f.this.g.a2();
                f.this.g.E();
                f.this.g.d3();
                f.this.g.Y2();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerHelper.java */
    /* loaded from: classes.dex */
    public class d implements DialogInterface.OnDismissListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            f.this.d0 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerHelper.java */
    /* loaded from: classes.dex */
    public class e implements DialogInterface.OnShowListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            f.this.d0 = true;
            LogEx.d(f.g0, " showPasswordDialog " + f.this.d0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerHelper.java */
    /* renamed from: com.zte.iptvclient.android.common.player.f$f, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0144f implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        C0144f() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e) {
                e.printStackTrace();
                f.this.h();
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.could_not_play);
                jSONObject = null;
            }
            if ((jSONObject != null ? jSONObject.optInt("returncode") : -1) != 0) {
                f.this.h();
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.could_not_play);
                LogEx.w(f.g0, "Get ts url failed!");
                return;
            }
            String optString = jSONObject != null ? jSONObject.optString("playurl") : "";
            if (StringUtil.isEmptyString(optString)) {
                f.this.h();
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.could_not_play);
                LogEx.w(f.g0, "Get ts url failed!");
                return;
            }
            f.this.h.putString(ParamConst.UPDATE_VERSION_RSP_URL, optString);
            if ("2".equals(f.this.q)) {
                if ("1".equals(f.this.h.getString("supportTimeShift"))) {
                    f.this.k();
                    return;
                } else {
                    if (f.this.W) {
                        return;
                    }
                    f.this.y();
                    return;
                }
            }
            if (!"4".equals(f.this.q) || f.this.W) {
                return;
            }
            f.this.y();
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            f.this.h();
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.could_not_play);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerHelper.java */
    /* loaded from: classes.dex */
    public static class g implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        g() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d(f.g0, "reportAdplayerInfo result = " + str);
            try {
                com.zte.iptvclient.android.common.javabean.models.e eVar = (com.zte.iptvclient.android.common.javabean.models.e) new Gson().fromJson(str, com.zte.iptvclient.android.common.javabean.models.e.class);
                if ("0".equals(eVar.b())) {
                    LogEx.d(f.g0, "reportAdplayerInfo success");
                } else {
                    LogEx.d(f.g0, "reportAdplayerInfo fail returncode = " + eVar.b() + " errormsg = " + eVar.a());
                }
            } catch (Exception e) {
                e.printStackTrace();
                LogEx.e(f.g0, "reportAdplayerInfo Exception e = " + e.getMessage());
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.e(f.g0, "reportAdplayerInfo onFailReturn returncode = " + i + " errormsg " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerHelper.java */
    /* loaded from: classes.dex */
    public class h implements SDKAdAPI.OnVoDAdsReturnListener {
        h() {
        }

        @Override // com.video.androidsdk.ad.SDKAdAPI.OnVoDAdsReturnListener
        public void onVoDAdsReturn(int i, String str, String str2) {
            LogEx.d(f.g0, "queryVoDAds():returncode = " + i + "errorMsg = " + str + "dataXml = " + str2);
            String str3 = f.g0;
            StringBuilder sb = new StringBuilder();
            sb.append("Advertisiment onVoDAdsReturn data = ");
            sb.append(str2);
            LogEx.d(str3, sb.toString());
            if (TextUtils.isEmpty(str2)) {
                LogEx.d(f.g0, "Test the starting speed : dealAdsRsp end");
                LogEx.d(f.g0, " skipToPlayer!");
                f.this.y();
                return;
            }
            com.zte.iptvclient.android.common.player.j.e eVar = (com.zte.iptvclient.android.common.player.j.e) new com.zte.iptvclient.android.common.player.a().parseXML(str2);
            if (eVar != null) {
                LogEx.d(f.g0, "Advertisiment onVoDAdsReturn data = " + eVar.toString());
                f.this.a(eVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerHelper.java */
    /* loaded from: classes.dex */
    public class i implements SDKAdAPI.OnRChannelAdsReturnListener {
        i() {
        }

        @Override // com.video.androidsdk.ad.SDKAdAPI.OnRChannelAdsReturnListener
        public void onRChannelAdsReturn(int i, String str, String str2) {
            LogEx.d(f.g0, "Test the starting speed : queryRChannelAds back");
            LogEx.i(f.g0, "queryTvoDAds(): returncode = " + i + "errorMsg = " + str + "dataXml is " + str2);
            if (TextUtils.isEmpty(str2)) {
                LogEx.d(f.g0, " skipToPlayer!");
                f.this.y();
            } else {
                f.this.a((com.zte.iptvclient.android.common.player.j.e) new com.zte.iptvclient.android.common.player.a().parseXML(str2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerHelper.java */
    /* loaded from: classes.dex */
    public class j implements SDKAdAPI.OnChannelAdsReturnListener {
        j() {
        }

        @Override // com.video.androidsdk.ad.SDKAdAPI.OnChannelAdsReturnListener
        public void onChannelAdsReturn(int i, String str, String str2) {
            LogEx.d(f.g0, "Test the starting speed : queryChannelAds back");
            LogEx.i(f.g0, "queryTvAds(): returncode = " + i + "errorMsg = " + str + "dataXml = " + str2);
            if (TextUtils.isEmpty(str2)) {
                LogEx.d(f.g0, " skipToPlayer!");
                f.this.y();
            } else {
                f.this.a((com.zte.iptvclient.android.common.player.j.e) new com.zte.iptvclient.android.common.player.a().parseXML(str2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerHelper.java */
    /* loaded from: classes.dex */
    public class k implements SDKBookMarkMgr.OnBookMarkReturnListener {
        k() {
        }

        @Override // com.video.androidsdk.service.bookmark.SDKBookMarkMgr.OnBookMarkReturnListener
        public void onBookMarkReturn(String str, String str2, String str3) {
            LogEx.d(f.g0, "Test the starting speed : sdkQueryBookmark back");
            LogEx.i(f.g0, "PLAYBOOKMARK onBookMarkReturn == returncode" + str + " breakpoint " + str3);
            if ("0".equals(str)) {
                try {
                    String optString = new JSONObject(str3).optString("breakpoint");
                    if (!TextUtils.isEmpty(optString)) {
                        f.this.s = optString;
                    } else {
                        f.this.s = "0";
                    }
                } catch (Exception unused) {
                }
                LogEx.i(f.g0, "PLAYBOOKMARK mStrBookMarkBreakPoint == " + f.this.s);
            } else {
                f.this.s = "0";
            }
            f.this.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerHelper.java */
    /* loaded from: classes.dex */
    public class l implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        l() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d(f.g0, "Advertisiment queryAdPauseVodPlayUrl data = " + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (TextUtils.equals("0", jSONObject.optString("returncode"))) {
                    f.this.U = jSONObject.optJSONArray("url").optString(0);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            f.this.w();
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            f.this.w();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerHelper.java */
    /* loaded from: classes.dex */
    public class m implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.player.j.d f4904a;

        m(com.zte.iptvclient.android.common.player.j.d dVar) {
            this.f4904a = dVar;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d(f.g0, "Advertisiment queryAdVodPlayUrl data = " + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (TextUtils.equals("0", jSONObject.optString("returncode"))) {
                    this.f4904a.c(jSONObject.optJSONArray("url").optString(0));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            f.this.c();
            if (f.i0 == null) {
                f.this.y();
            } else if (f.this.Q == f.i0.i().size() && f.this.P == f.i0.h().size()) {
                LogEx.d(f.g0, "Test the starting speed : dealAdsRsp end");
                f.this.y();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            f.this.c();
            if (f.this.Q == f.i0.i().size() && f.this.P == f.i0.h().size()) {
                LogEx.d(f.g0, "Test the starting speed : dealAdsRsp end");
                f.this.y();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerHelper.java */
    /* loaded from: classes.dex */
    public class n implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.player.j.d f4906a;

        n(com.zte.iptvclient.android.common.player.j.d dVar) {
            this.f4906a = dVar;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d(f.g0, "Advertisiment middleAds data = " + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (TextUtils.equals("0", jSONObject.optString("returncode"))) {
                    this.f4906a.c(jSONObject.optJSONArray("url").optString(0));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            f.this.d();
            if (f.this.Q == f.i0.i().size() && f.this.P == f.i0.h().size()) {
                LogEx.d(f.g0, "mIMiddleAdVodResponedUrlNum = " + f.this.Q);
                LogEx.d(f.g0, "Test the starting speed : dealAdsRsp end");
                f.this.y();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d(f.g0, "middleAds onFailReturn");
            f.this.d();
            if (f.this.Q == f.i0.i().size() && f.this.P == f.i0.h().size()) {
                LogEx.d(f.g0, "mIMiddleAdVodResponedUrlNum = " + f.this.Q);
                LogEx.d(f.g0, "Test the starting speed : dealAdsRsp end");
                f.this.y();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerHelper.java */
    /* loaded from: classes.dex */
    public class o implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        o() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            int i = -1;
            try {
                JSONObject jSONObject = new JSONObject(str);
                i = jSONObject.optInt("returncode");
                if (i == 0) {
                    String optString = jSONObject.optString("playurl");
                    if (!StringUtil.isEmptyString(optString)) {
                        f.this.h.putString("TSURL", optString);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (i == 0 || f.this.W) {
                return;
            }
            f.this.y();
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            if (f.this.W) {
                return;
            }
            f.this.y();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayerHelper.java */
    /* loaded from: classes.dex */
    public class p implements d.e {
        p() {
        }

        @Override // com.zte.iptvclient.android.common.player.d.e
        public void a(String str, String str2, List<com.zte.iptvclient.android.common.player.j.g> list) {
            if (TextUtils.isEmpty(str2)) {
                if (f.this.g != null) {
                    f.this.g.Q2();
                }
            } else {
                f.this.a(str2, list);
                f.this.m();
            }
        }
    }

    public f() {
        this.j = "";
        this.k = "";
        this.l = "";
        com.zte.iptvclient.common.uiframe.a aVar = new com.zte.iptvclient.common.uiframe.a();
        this.r = aVar;
        this.s = "0";
        this.W = false;
        this.X = false;
        this.b0 = false;
        this.d0 = false;
        this.e0 = false;
        this.f0 = 1;
        this.k = aVar.b("UserID");
        this.j = this.r.b(ParamConst.LOGIN_PORTALAUTH_RSP_BOCODE);
        this.l = this.r.b("TeamID");
        String a2 = com.zte.iptvclient.android.common.k.o.j().a();
        LogEx.d(g0, "Advertise_Server ==== " + a2);
        if (!TextUtils.isEmpty(a2)) {
            SDKAdAPI createInstance = SDKAdAPI.createInstance();
            this.a0 = createInstance;
            createInstance.setServerDomain(a2);
        }
        ArrayList arrayList = new ArrayList();
        this.V = arrayList;
        arrayList.add("url");
        this.e0 = "1".equals(ConfigMgr.readPropertie("IsShowChildLock"));
    }

    private void u() {
        LogEx.d(g0, "PlayerFragment");
        r b2 = this.e.b();
        b2.b(this.f, this.g, "PlayerFragment");
        b2.b();
        LogEx.d(g0, "tagertID is " + this.f);
    }

    private void v() {
        if (!TextUtils.isEmpty(com.zte.iptvclient.android.common.f.b.i.c()) && !TextUtils.isEmpty(com.zte.iptvclient.android.common.f.b.i.d())) {
            SDKBookMarkMgr sDKBookMarkMgr = new SDKBookMarkMgr();
            GetBookMarkReq getBookMarkReq = new GetBookMarkReq();
            getBookMarkReq.bookmarktype = this.p;
            getBookMarkReq.columncode = this.i;
            getBookMarkReq.contentcode = this.m;
            LogEx.d(g0, "Test the starting speed : start sdkQueryBookmark ");
            sDKBookMarkMgr.getBookMark(getBookMarkReq.toHashMap(), new k());
            return;
        }
        LogEx.w(g0, "sdkQueryBookmark:epg ip or port is empty.");
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0053 A[LOOP:1: B:20:0x0050->B:22:0x0053, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0065 A[LOOP:2: B:25:0x0062->B:27:0x0065, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0077 A[LOOP:3: B:30:0x0074->B:32:0x0077, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void w() {
        /*
            Method dump skipped, instructions count: 293
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.common.player.f.w():void");
    }

    private void x() {
        Context context = this.f4881b;
        if (context == null || ((Activity) context).isFinishing()) {
            return;
        }
        this.c0.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (this.g.u2()) {
            return;
        }
        n();
        o();
        LogEx.d(g0, "videoCpCode is " + this.h.getString("cpcode"));
        if ("Megogo".equalsIgnoreCase(this.h.getString("cpcode")) && this.h.getInt(ParamConst.TV_CHANNEL_SHIFT_PLAY_REQ_AUTHID) == 0 && !this.h.getBoolean("isTrailer")) {
            new com.zte.iptvclient.android.common.player.d(this.f4881b).a(this.h.getString("price"), this.h.getString(ParamConst.VOD_DETAIL_QUERY_RSP_VIDEOTELECOMCODE), new p());
        } else {
            m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c() {
        this.P++;
    }

    private void d(String str) {
        String str2 = String.format("%s/iptvepg/datasource/getadurl.jsp", com.zte.iptvclient.android.common.f.b.i.b()) + "?videocodes=" + str;
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", com.zte.iptvclient.android.common.f.b.i.h());
        sDKNetHTTPRequest.startRequest(str2, "GET", new l());
    }

    private void e() {
        Intent intent = new Intent();
        this.h.putBoolean("willGetBookmark", this.X);
        boolean z = false;
        if (this.b0) {
            this.b0 = false;
            this.h.putBoolean("isFromShakeWatch", true);
        } else {
            this.h.putBoolean("isFromShakeWatch", false);
        }
        intent.putExtras(this.h);
        Context context = this.f4882c.get();
        if (context != null) {
            intent.setClass(context, VOPlayerActivity.class);
            ComponentName resolveActivity = intent.resolveActivity(this.f4882c.get().getPackageManager());
            if (resolveActivity != null) {
                for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) context.getSystemService("activity")).getRunningTasks(10)) {
                    if (runningTaskInfo.topActivity.equals(resolveActivity) || runningTaskInfo.baseActivity.equals(resolveActivity)) {
                        z = true;
                        break;
                    }
                }
            }
            if (z) {
                intent.putExtra("switchChannel", true);
            } else {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
            h();
        }
    }

    private void f() {
        if (this.b0) {
            this.b0 = false;
            this.h.putBoolean("isFromShakeWatch", true);
        } else {
            this.h.putBoolean("isFromShakeWatch", false);
        }
        Context context = this.f4882c.get();
        h();
        if (context != null) {
            LogEx.d(g0, "replacePlayerFragment");
            u();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.W && this.a0 != null) {
            if (TextUtils.equals("2", this.p)) {
                s();
                return;
            } else {
                t();
                return;
            }
        }
        y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Context context = this.f4881b;
        if (context == null || ((Activity) context).isFinishing()) {
            return;
        }
        this.c0.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int i() {
        ArrayList<Feature> c2 = com.zte.iptvclient.android.common.j.c.e().c();
        int i2 = 0;
        if (c2 != null) {
            int i3 = 0;
            while (i2 < c2.size()) {
                if (!TextUtils.isEmpty(c2.get(i2).getFeaturevalue())) {
                    i3 += Integer.parseInt(c2.get(i2).getFeaturevalue());
                }
                i2++;
            }
            i2 = i3;
        }
        LogEx.d(g0, "FeatureOnlinMaxDevice= " + i2);
        if (i2 <= 0) {
            String c3 = com.zte.iptvclient.common.uiframe.a.c("Play_Control_Max_Number");
            LogEx.d(g0, "strMaxDeviceProperty " + c3);
            if (!TextUtils.isEmpty(c3)) {
                i2 = Integer.parseInt(c3);
            }
        }
        this.f0 = i2;
        return i2;
    }

    private void j() {
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        if ("2".equals(this.q)) {
            sDKNetHTTPRequest.setParam("playtype", "1");
        } else if ("4".equals(this.q)) {
            sDKNetHTTPRequest.setParam("playtype", "3");
            sDKNetHTTPRequest.setParam("prevuecode", (String) this.h.get("prevuecode"));
        }
        sDKNetHTTPRequest.setParam("channelcode", this.o);
        sDKNetHTTPRequest.setParam("stbtype", "2");
        sDKNetHTTPRequest.setParam("streamlevel", "1");
        sDKNetHTTPRequest.setParam("language", "tha");
        a(sDKNetHTTPRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setParam("playtype", "2");
        sDKNetHTTPRequest.setParam("channelcode", this.o);
        sDKNetHTTPRequest.setParam("stbtype", "2");
        sDKNetHTTPRequest.setParam("streamlevel", "1");
        sDKNetHTTPRequest.setParam("language", "tha");
        sDKNetHTTPRequest.startRequest(String.format("%s/iptvepg/datasource/getplayurlforth.jsp", com.zte.iptvclient.android.common.f.b.i.b()), HttpRequest.METHOD_GET, new o());
    }

    private void l() {
        this.t = a((ArrayList<?>) this.t);
        this.u = a((ArrayList<?>) this.u);
        this.v = a((ArrayList<?>) this.v);
        this.w = a((ArrayList<?>) this.w);
        this.x = a((ArrayList<?>) this.x);
        this.y = a((ArrayList<?>) this.y);
        this.z = a((ArrayList<?>) this.z);
        this.A = a((ArrayList<?>) this.A);
        this.B = a((ArrayList<?>) this.B);
        this.C = a((ArrayList<?>) this.C);
        this.D = a((ArrayList<?>) this.D);
        this.E = a((ArrayList<?>) this.E);
        this.J = a((ArrayList<?>) this.J);
        this.I = a((ArrayList<?>) this.I);
        this.K = a((ArrayList<?>) this.K);
        this.H = a((ArrayList<?>) this.H);
        this.L = a((ArrayList<?>) this.L);
        this.M = a((ArrayList<?>) this.M);
        this.N = a((ArrayList<?>) this.N);
        this.O = a((ArrayList<?>) this.O);
        this.R = a((ArrayList<?>) this.R);
        this.S = a((ArrayList<?>) this.S);
        this.T = a((ArrayList<?>) this.T);
        this.U = "";
        List<String> list = this.V;
        if (list != null && list.size() > 0) {
            this.V.clear();
        }
        this.F = 0;
        this.G = 0;
        this.P = 0;
        this.Q = 0;
        com.zte.iptvclient.android.common.player.j.e eVar = i0;
        if (eVar != null) {
            j0 = eVar;
        }
        i0 = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.f4880a && this.g != null) {
            LogEx.d(g0, "Test the starting speed : satrt switch update  play parms ");
            this.g.h(this.h);
            return;
        }
        try {
            if (this.f4883d && this.g != null) {
                f();
            } else {
                e();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void n() {
        if (this.W) {
            p();
            q();
            this.h.putStringArrayList("BigPicURL", this.R);
            this.h.putStringArrayList("MidPicURL", this.S);
            this.h.putStringArrayList("SmallPicURL", this.T);
            this.h.putString("AdPauseVodUrl", this.U);
            ArrayList<String> arrayList = this.L;
            if (arrayList != null) {
                this.h.putSerializable("CornerPicURL", arrayList);
            }
            ArrayList<String> arrayList2 = this.M;
            if (arrayList2 != null) {
                this.h.putSerializable("CornerPicPosition", arrayList2);
            }
            ArrayList<String> arrayList3 = this.N;
            if (arrayList3 != null) {
                this.h.putSerializable("CornerPicDuration", arrayList3);
            }
            ArrayList<String> arrayList4 = this.O;
            if (arrayList4 != null) {
                this.h.putSerializable("CornerPicOffset", arrayList4);
            }
        }
    }

    private void o() {
        com.zte.iptvclient.android.common.player.k.c cVar;
        com.zte.iptvclient.android.common.player.k.c cVar2;
        if (this.q.equals("1") || this.q.equals("10")) {
            if (!this.h.getBoolean("isProjection", false) && (cVar = this.g) != null) {
                long j2 = cVar.Q8;
                if (j2 != -1) {
                    this.h.putString("bookmark_breakpoint", String.valueOf(j2 / 1000));
                    this.g.Q8 = -1L;
                } else {
                    this.h.putString("bookmark_breakpoint", this.s);
                }
            }
            this.h.putString("bookmarktype", this.p);
            this.h.putString("columncode", this.i);
            this.h.putString("bookmarktype", this.p);
            this.h.putString("contentcode", this.m);
        }
        if (this.q.equals("2")) {
            String string = this.h.getString(ParamConst.UPDATE_VERSION_RSP_URL, "");
            if ("1".equals(this.Z) && string != null) {
                String a2 = a(string, false, "0");
                if (!TextUtils.isEmpty(a2)) {
                    this.h.putString("TSURL", a2);
                }
            }
        }
        if (this.q.equals("4")) {
            if (!this.h.getBoolean("isProjection", false) && (cVar2 = this.g) != null) {
                long j3 = cVar2.Q8;
                if (j3 != -1) {
                    this.h.putString("bookmark_breakpoint", String.valueOf(j3 / 1000));
                    this.g.Q8 = -1L;
                } else {
                    this.h.putString("bookmark_breakpoint", this.s);
                }
            }
            this.h.putString("bookmarktype", this.p);
            this.h.putString("contentcode", this.m);
        }
        LogEx.d(g0, "PLAYBOOKMARK pick bundle BOOKMARKdata BREALPOINT=" + this.h.getString("bookmark_breakpoint", "0") + " mStrContentCode=" + this.m);
    }

    private void p() {
        com.zte.iptvclient.android.common.player.j.e eVar = i0;
        if (eVar != null && eVar.h() != null && !i0.h().isEmpty()) {
            this.h.putString(ParamConst.SEARCH_REQ_SHOWTIME, i0.e() + "");
            this.h.putString("CloseTime", i0.a() + "");
            int i2 = 0;
            int i3 = 0;
            for (com.zte.iptvclient.android.common.player.j.d dVar : i0.h()) {
                if (dVar.k() == 0) {
                    if (!StringUtil.isEmptyString(dVar.j())) {
                        if (dVar.i() == 0) {
                            LogEx.d(g0, "adB URL: " + dVar.j());
                            this.t.add(i2, dVar.j());
                            LogEx.d(g0, "mListContentLengthB: " + dVar.c());
                            this.z.add(i2, Integer.valueOf(dVar.c()));
                            LogEx.d(g0, "mListPlayNumB: " + dVar.h());
                            this.w.add(i2, Integer.valueOf(dVar.h()));
                            LogEx.d(g0, "mListVodStreamTypeB: " + dVar.k());
                            this.C.add(i2, Integer.valueOf(dVar.k()));
                            i2++;
                        } else if (1 == dVar.i()) {
                            LogEx.d(g0, "adE URL: " + dVar.j());
                            this.u.add(i3, dVar.j());
                            LogEx.d(g0, "mListContentLengthE: " + dVar.c());
                            this.A.add(i3, Integer.valueOf(dVar.c()));
                            LogEx.d(g0, "mListPlayNumE: " + dVar.h());
                            this.x.add(i3, Integer.valueOf(dVar.h()));
                            LogEx.d(g0, "mListVodStreamTypeE: " + dVar.k());
                            this.D.add(i3, Integer.valueOf(dVar.k()));
                            i3++;
                        }
                    }
                } else if (dVar.i() == 0) {
                    LogEx.d(g0, "adB URL: " + dVar.j());
                    this.t.add(i2, dVar.j());
                    LogEx.d(g0, "mListContentLengthB: " + dVar.c());
                    this.z.add(i2, Integer.valueOf(dVar.c()));
                    LogEx.d(g0, "mListPlayNumB: " + dVar.h());
                    this.w.add(i2, Integer.valueOf(dVar.h()));
                    LogEx.d(g0, "mListVodStreamTypeB: " + dVar.k());
                    this.C.add(i2, Integer.valueOf(dVar.k()));
                    i2++;
                } else if (1 == dVar.i()) {
                    LogEx.d(g0, "adE URL: " + dVar.j());
                    this.u.add(i3, dVar.j());
                    LogEx.d(g0, "mListContentLengthE: " + dVar.c());
                    this.A.add(i3, Integer.valueOf(dVar.c()));
                    LogEx.d(g0, "mListPlayNumE: " + dVar.h());
                    this.x.add(i3, Integer.valueOf(dVar.h()));
                    LogEx.d(g0, "mListVodStreamTypeE: " + dVar.k());
                    this.D.add(i3, Integer.valueOf(dVar.k()));
                    i3++;
                }
            }
        }
        this.h.putStringArrayList("VodListB", this.t);
        this.h.putIntegerArrayList("ContentLengthB", this.z);
        this.h.putIntegerArrayList("PlayNumB", this.w);
        this.h.putIntegerArrayList("StreamContentTypeB", this.C);
        this.h.putStringArrayList("VodListE", this.u);
        this.h.putIntegerArrayList("ContentLengthE", this.A);
        this.h.putIntegerArrayList("PlayNumE", this.x);
        this.h.putIntegerArrayList("StreamContentTypeE", this.D);
        this.h.putString("Total_ContentLengthB", String.valueOf(this.F));
        this.h.putString("Total_ContentLengthE", String.valueOf(this.G));
    }

    private void q() {
        com.zte.iptvclient.android.common.player.j.e eVar = i0;
        if (eVar != null && eVar.i() != null && !i0.i().isEmpty()) {
            int i2 = 0;
            for (com.zte.iptvclient.android.common.player.j.d dVar : i0.i()) {
                if (dVar.k() == 0) {
                    if (!StringUtil.isEmptyString(dVar.j())) {
                        LogEx.d(g0, "adM URL: " + dVar.j());
                        this.v.add(i2, dVar.j());
                        LogEx.d(g0, "mListContentLengthM: " + dVar.c());
                        this.B.add(i2, Integer.valueOf(dVar.c()));
                        LogEx.d(g0, "mListPlayNumM: " + dVar.h());
                        this.y.add(i2, Integer.valueOf(dVar.h()));
                        LogEx.d(g0, "mListMiddleAdsCloseTime: " + dVar.d());
                        this.I.add(i2, Integer.valueOf(dVar.d()));
                        LogEx.d(g0, "mListMiddleAdsOffsetTime: " + dVar.e());
                        this.J.add(i2, Integer.valueOf(dVar.e()));
                        LogEx.d(g0, "mListTotalContentLengthM: " + dVar.a());
                        this.H.add(i2, Integer.valueOf(dVar.a()));
                        LogEx.d(g0, "mListMiddleAdsShowTime: " + dVar.f());
                        this.K.add(i2, Integer.valueOf(dVar.f()));
                        LogEx.d(g0, "mListVodStreamTypeM: " + dVar.k());
                        this.E.add(i2, Integer.valueOf(dVar.k()));
                    }
                } else {
                    LogEx.d(g0, "adM URL: " + dVar.j());
                    this.v.add(i2, dVar.j());
                    LogEx.d(g0, "mListContentLengthM: " + dVar.c());
                    this.B.add(i2, Integer.valueOf(dVar.c()));
                    LogEx.d(g0, "mListPlayNumM: " + dVar.h());
                    this.y.add(i2, Integer.valueOf(dVar.h()));
                    LogEx.d(g0, "mListMiddleAdsCloseTime: " + dVar.d());
                    this.I.add(i2, Integer.valueOf(dVar.d()));
                    LogEx.d(g0, "mListMiddleAdsOffsetTime: " + dVar.e());
                    this.J.add(i2, Integer.valueOf(dVar.e()));
                    LogEx.d(g0, "mListTotalContentLengthM: " + dVar.a());
                    this.H.add(i2, Integer.valueOf(dVar.a()));
                    LogEx.d(g0, "mListMiddleAdsShowTime: " + dVar.f());
                    this.K.add(i2, Integer.valueOf(dVar.f()));
                    LogEx.d(g0, "mListVodStreamTypeM: " + dVar.k());
                    this.E.add(i2, Integer.valueOf(dVar.k()));
                }
                i2++;
            }
        }
        this.h.putStringArrayList("VodListM", this.v);
        this.h.putIntegerArrayList("ContentLengthM", this.B);
        this.h.putIntegerArrayList("PlayNumM", this.y);
        this.h.putIntegerArrayList("CloseMiddleTime", this.I);
        this.h.putIntegerArrayList("OffsetMiddleTime", this.J);
        this.h.putIntegerArrayList("Total_ContentLengthM", this.H);
        this.h.putIntegerArrayList("ShowMiddleTime", this.K);
        this.h.putIntegerArrayList("StreamContentTypeM", this.E);
    }

    private void r() {
        HashMap hashMap = new HashMap();
        hashMap.put("Channelcode", this.o);
        hashMap.put("Subjectcode", this.i);
        hashMap.put("bocode", this.j);
        hashMap.put("langtype", h0);
        String V = this.Y.V();
        this.k = V;
        hashMap.put("UserID", V);
        hashMap.put("team_id", this.l);
        hashMap.put("mediaservice", "2");
        Context context = this.f4881b;
        if (context != null) {
            if (com.zte.iptvclient.android.common.k.g.f(context)) {
                hashMap.put("terminaltype", "4");
            } else {
                hashMap.put("terminaltype", "2");
            }
        }
        LogEx.d(g0, "Test the starting speed : start queryChannelAds ");
        this.a0.queryChannelAds(hashMap, new j());
    }

    private void s() {
        HashMap hashMap = new HashMap();
        hashMap.put("Channelcode", this.o);
        hashMap.put("Subjectcode", this.i);
        hashMap.put("bocode", this.j);
        hashMap.put("langtype", h0);
        hashMap.put("UserID", this.k);
        hashMap.put("team_id", this.l);
        hashMap.put("Type", "1");
        hashMap.put("mediaservice", "2");
        Context context = this.f4881b;
        if (context != null) {
            if (com.zte.iptvclient.android.common.k.g.f(context)) {
                hashMap.put("terminaltype", "4");
            } else {
                hashMap.put("terminaltype", "2");
            }
        }
        LogEx.d(g0, "Test the starting speed : start queryRChannelAds");
        this.a0.queryRChannelAds(hashMap, new i());
    }

    private void t() {
        HashMap hashMap = new HashMap();
        hashMap.put("Contentcode", this.m);
        hashMap.put("Subjectcode", this.i);
        hashMap.put("bocode", this.j);
        hashMap.put("langtype", h0);
        hashMap.put("UserID", this.k);
        hashMap.put("team_id", this.l);
        hashMap.put("mediaservice", "2");
        Context context = this.f4881b;
        if (context != null) {
            if (BaseApp.a(context)) {
                hashMap.put("terminaltype", "4");
            } else {
                hashMap.put("terminaltype", "2");
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            LogEx.d(g0, "queryVodAds:" + ((String) entry.getKey()) + "=" + ((String) entry.getValue()));
        }
        LogEx.d(g0, "Test the starting speed : start queryVoDAds");
        this.a0.queryVoDAds(hashMap, new h());
    }

    private void c(int i2, com.zte.iptvclient.android.common.player.j.f fVar, Bundle bundle, Context context) {
        String string = bundle.getString("channelcode", "");
        String string2 = bundle.getString("ratingid", "");
        String string3 = bundle.getString("prevueratingid", "");
        String string4 = bundle.getString("systemlimitenable", "0");
        String string5 = bundle.getString("genrelock", "0");
        boolean z = bundle.getBoolean("isClick");
        LogEx.d(g0, "checkIsLocked genrelock = " + string5);
        LogEx.d(g0, "checkIsLocked ratingid = " + string2 + " prevueRatingid = " + string3);
        if (this.Y == null) {
            this.Y = new com.zte.iptvclient.android.common.j.h(context);
        }
        LogEx.d(g0, "Test the starting speed : start checkIsLocked ");
        LogEx.d(g0, "checkIsLocked mIsShowChildLock " + this.e0 + " ParentalCheck" + this.Y.C() + " systemlimitenable=" + string4);
        String str = g0;
        StringBuilder sb = new StringBuilder();
        sb.append("isClick =");
        sb.append(z);
        LogEx.d(str, sb.toString());
        if ((!this.e0 || !this.Y.C() || (!com.zte.iptvclient.android.mobile.f.b.a.b(string2, context) && !com.zte.iptvclient.android.mobile.f.b.a.b(string3, context) && !com.zte.iptvclient.android.mobile.f.b.a.c(string))) && !TextUtils.equals(string4, "1") && !TextUtils.equals(string5, "1")) {
            LogEx.d(g0, "Test the starting speed : start checkIsLocked skip");
            e(i2, fVar, bundle, context);
            return;
        }
        LogEx.d(g0, "Test the starting speed : checkIsLocked back");
        if (i2 != 1 && i2 != 2 && i2 != 0 && i2 != 4 && i2 != 3) {
            e(i2, fVar, bundle, context);
        } else {
            f(i2, fVar, bundle, context);
        }
    }

    public void b(boolean z) {
        this.X = z;
    }

    public void b(String str) {
        this.s = str;
    }

    private void b(int i2, com.zte.iptvclient.android.common.player.j.f fVar, Bundle bundle, Context context) {
        if ("1".equals(ConfigMgr.readPropertie("IsSupportConcurrencyControl"))) {
            d(i2, fVar, bundle, context);
        } else {
            a(i2, fVar, bundle, context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d() {
        this.Q++;
    }

    private void b(List<com.zte.iptvclient.android.common.player.j.d> list) {
        if (list != null && i0 != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                com.zte.iptvclient.android.common.player.j.d dVar = list.get(i2);
                if (dVar != null) {
                    if (dVar.k() == 1) {
                        d();
                        if (this.Q == i0.i().size() && this.P == i0.h().size()) {
                            LogEx.d(g0, "Advertisiment mIMiddleAdVodResponedUrlNum = " + this.Q);
                            LogEx.d(g0, "Test the starting speed : dealAdsRsp end");
                            y();
                        }
                    } else {
                        new SDKNetHTTPRequest().startRequest(String.format("%s/iptvepg/datasource/getadurl.jsp", com.zte.iptvclient.android.common.f.b.i.b()) + "?videocodes=" + dVar.b(), "GET", new n(dVar));
                    }
                }
            }
            return;
        }
        y();
    }

    private void d(int i2, com.zte.iptvclient.android.common.player.j.f fVar, Bundle bundle, Context context) {
        SDKPushMsgMgr sDKPushMsgMgr = SDKPushMsgMgr.getInstance();
        sDKPushMsgMgr.reportPlayStatus("0", bundle.getString("contentcode"));
        String e2 = com.zte.iptvclient.android.common.k.o.j().e();
        LogEx.d(g0, "strMESDomain::::" + e2);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("usercode", SDKLoginMgr.getInstance().getUserInfo("UserID"));
        LogEx.d(g0, "Test the starting speed : start getTerminalPlayStatus");
        sDKPushMsgMgr.getTerminalPlayStatus(e2, hashMap, new a(context, i2, fVar, bundle));
    }

    private void f(int i2, com.zte.iptvclient.android.common.player.j.f fVar, Bundle bundle, Context context) {
        com.zte.iptvclient.android.common.player.k.c cVar = this.g;
        if (cVar != null) {
            cVar.m0();
        }
        LogEx.d(g0, " showPasswordDialog " + this.d0);
        Context context2 = this.f4881b;
        if (context2 != null && !((Activity) context2).isFinishing() && !this.d0) {
            this.d0 = true;
            h();
            com.zte.iptvclient.android.common.customview.a.a.a.b bVar = new com.zte.iptvclient.android.common.customview.a.a.a.b(context);
            bVar.setTitle(R.string.please_enter_parental_lock_password);
            EditText a2 = bVar.a();
            bVar.b(R.string.common_ok, new b(a2, context, bVar, i2, fVar, bundle));
            bVar.a(R.string.common_cancel, new c(bVar, a2, context));
            bVar.setCancelable(true);
            bVar.setCanceledOnTouchOutside(false);
            bVar.setOnDismissListener(new d());
            bVar.setOnShowListener(new e());
            bVar.show();
            return;
        }
        LogEx.d(g0, " showPasswordDialog return" + this.d0);
    }

    public void a(boolean z) {
        this.W = z;
    }

    private ArrayList a(ArrayList<?> arrayList) {
        if (arrayList == null) {
            return new ArrayList();
        }
        arrayList.clear();
        return arrayList;
    }

    public void a(com.zte.iptvclient.android.common.player.j.l lVar, Bundle bundle, Context context) {
        this.f4883d = false;
        b(0, lVar, bundle, context);
    }

    public void a(com.zte.iptvclient.android.common.player.j.i iVar, Bundle bundle, Context context) {
        this.f4883d = false;
        bundle.putString("auth_contenttype", "2");
        b(1, iVar, bundle, context);
    }

    public static void d(Date date, Date date2, long j2) {
        List<com.zte.iptvclient.android.common.player.j.c> d2;
        LogEx.e(g0, "reportPauseAdInfo");
        com.zte.iptvclient.android.common.player.j.e eVar = i0;
        if (eVar == null) {
            if (j0 == null) {
                LogEx.e(g0, "reportPauseAdInfo AD == null");
                return;
            } else {
                LogEx.e(g0, "mRspAdVodPlayRspBefore != null");
                d2 = j0.d();
            }
        } else {
            d2 = eVar.d();
        }
        if (d2 != null && d2.size() > 0) {
            com.zte.iptvclient.android.common.player.j.c cVar = d2.get(0);
            if (cVar != null) {
                a(date, date2, cVar.a(), cVar.b(), "0", j2);
                return;
            } else {
                LogEx.e(g0, "reportPauseAdInfo AD = null!");
                return;
            }
        }
        LogEx.e(g0, "reportPauseAdInfo AD = null!");
    }

    public void a(com.zte.iptvclient.android.common.player.j.j jVar, Bundle bundle, Context context) {
        this.f4883d = false;
        bundle.putString("auth_contenttype", "4");
        b(2, jVar, bundle, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i2, com.zte.iptvclient.android.common.player.j.f fVar, Bundle bundle, Context context) {
        if (i2 == 0) {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.j.b());
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.j.d());
            try {
                this.m = ((com.zte.iptvclient.android.common.player.j.l) fVar).b();
            } catch (Exception unused) {
                LogEx.w(g0, "adRequest's type is wrong, playerType =" + i2);
            }
            if (this.m == null) {
                LogEx.w(g0, "contentCode in adRequest is null!");
                this.m = "";
            }
            this.p = "1";
            if (this.X) {
                v();
                return;
            } else {
                g();
                return;
            }
        }
        if (i2 == 1) {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.j.e());
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.j.c());
            if (this.i == null) {
                LogEx.e(g0, "mStrColumnCode in adRequest is null!");
                return;
            }
            try {
                this.o = ((com.zte.iptvclient.android.common.player.j.i) fVar).b();
            } catch (Exception unused2) {
                LogEx.w(g0, "adRequest's type is wrong, playerType =" + i2);
            }
            if (TextUtils.isEmpty(this.o)) {
                LogEx.w(g0, "channelCode in adRequest is null!");
                return;
            }
            if (!TextUtils.isEmpty(this.Z) && !"0".equals(this.Z)) {
                if (this.W && this.a0 != null) {
                    r();
                    return;
                } else {
                    y();
                    return;
                }
            }
            j();
            return;
        }
        if (i2 != 2) {
            if (i2 != 3) {
                if (i2 != 4) {
                    LogEx.w(g0, "playerType is error");
                    return;
                }
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.j.c());
                this.f4880a = true;
                h();
                y();
                return;
            }
            try {
                this.m = ((com.zte.iptvclient.android.common.player.j.k) fVar).b();
            } catch (Exception unused3) {
                LogEx.w(g0, "adRequest's type is wrong, playerType =" + i2);
            }
            if (this.m == null) {
                LogEx.w(g0, "contentCode in adRequest is null!");
                this.m = "";
            }
            g();
            return;
        }
        EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.j.c());
        if (TextUtils.isEmpty(this.m)) {
            this.m = bundle.getString("contentcode");
        }
        try {
            this.o = ((com.zte.iptvclient.android.common.player.j.j) fVar).b();
            this.n = ((com.zte.iptvclient.android.common.player.j.j) fVar).c();
        } catch (Exception unused4) {
            LogEx.w(g0, "adRequest's type is wrong, playerType =" + i2);
        }
        if (this.o != null && this.n != null) {
            if (!StringUtil.isEmptyString(this.Z) && !"0".equals(this.Z)) {
                if (StringUtil.isEmptyString(bundle.getString(ParamConst.UPDATE_VERSION_RSP_URL))) {
                    h();
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.could_not_play);
                    return;
                }
                this.p = "2";
                if (this.X) {
                    LogEx.d(g0, "sdkQueryBookmark =" + this.X);
                    v();
                    return;
                }
                LogEx.d(g0, "continueAfterBookMarkForTvod =" + this.X);
                g();
                return;
            }
            j();
            return;
        }
        LogEx.w(g0, "channelCode or reqType in adRequest is null!");
    }

    public void a(com.zte.iptvclient.android.common.player.j.j jVar, com.zte.iptvclient.android.common.player.k.c cVar, Bundle bundle, Context context) {
        this.f4883d = false;
        this.g = cVar;
        bundle.putString("auth_contenttype", "4");
        a(4, jVar, bundle, context);
    }

    public void a(com.zte.iptvclient.android.common.player.k.c cVar, Bundle bundle, Context context) {
        this.f4883d = false;
        this.f4880a = true;
        this.g = cVar;
        bundle.putString("auth_contenttype", "1");
        this.h = bundle;
        bundle.putBoolean("ToLoginTip", true);
        m();
    }

    public static void b(Date date, Date date2, long j2) {
        LogEx.d(g0, "reportForwardAdInfo");
        com.zte.iptvclient.android.common.player.j.e eVar = i0;
        if (eVar == null) {
            LogEx.e(g0, "reportForwardAdInfo AD == null");
            return;
        }
        List<com.zte.iptvclient.android.common.player.j.d> h2 = eVar.h();
        if (h2 != null && h2.size() > 0) {
            com.zte.iptvclient.android.common.player.j.d dVar = h2.get(0);
            if (dVar != null) {
                a(date, date2, dVar.b(), dVar.g(), "0", j2);
                return;
            } else {
                LogEx.e(g0, "reportForwardAdInfo AD = null!");
                return;
            }
        }
        LogEx.e(g0, "reportForwardAdInfo AD = null!");
    }

    public static void c(Date date, Date date2, long j2) {
        LogEx.d(g0, "reportMiddleAdInfo");
        com.zte.iptvclient.android.common.player.j.e eVar = i0;
        if (eVar == null) {
            LogEx.e(g0, "reportMiddleAdInfo AD == null");
            return;
        }
        List<com.zte.iptvclient.android.common.player.j.d> i2 = eVar.i();
        if (i2 != null && i2.size() > 0) {
            com.zte.iptvclient.android.common.player.j.d dVar = i2.get(0);
            if (dVar != null) {
                a(date, date2, dVar.b(), dVar.g(), "0", j2);
                return;
            } else {
                LogEx.e(g0, "reportMiddleAdInfo AD = null!");
                return;
            }
        }
        LogEx.e(g0, "reportMiddleAdInfo AD = null!");
    }

    private void a(int i2, com.zte.iptvclient.android.common.player.j.j jVar, Bundle bundle, Context context) {
        com.zte.iptvclient.android.common.player.k.c cVar;
        com.zte.iptvclient.android.common.player.k.c cVar2;
        if (c(bundle.getString("definition")) && (cVar2 = this.g) != null) {
            cVar2.d3();
            this.g.E();
            this.g.a2();
            this.g.j(0);
            return;
        }
        if (!a(bundle.getString("allownettype")) && (cVar = this.g) != null) {
            cVar.d3();
            this.g.E();
            this.g.a2();
            this.g.j(1);
            return;
        }
        com.zte.iptvclient.android.common.player.k.c cVar3 = this.g;
        if (cVar3 == null || cVar3.p0() >= 0) {
            b(i2, jVar, bundle, context);
        }
    }

    public static boolean c(String str) {
        String c2 = com.zte.iptvclient.common.uiframe.a.c(com.zte.iptvclient.android.common.c.c.g);
        LogEx.d(g0, "str4KPropertyValue=" + c2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(c2)) {
            return false;
        }
        try {
            return Integer.parseInt(str) > Integer.parseInt(c2);
        } catch (Exception e2) {
            LogEx.e(g0, " check4KDefinition getException=" + e2.getMessage());
            return false;
        }
    }

    public void a(com.zte.iptvclient.android.common.player.j.l lVar, Bundle bundle, Context context, FragmentManager fragmentManager, com.zte.iptvclient.android.common.player.k.c cVar) {
        this.f4883d = true;
        this.e = fragmentManager;
        this.f4880a = true;
        this.g = cVar;
        b(0, lVar, bundle, context);
    }

    public void a(com.zte.iptvclient.android.common.player.j.i iVar, Bundle bundle, Context context, FragmentManager fragmentManager, int i2, com.zte.iptvclient.android.common.player.k.c cVar) {
        this.f4883d = true;
        this.e = fragmentManager;
        this.f4880a = true;
        this.f = i2;
        this.g = cVar;
        bundle.putString("auth_contenttype", "2");
        b(1, iVar, bundle, context);
    }

    public void a(com.zte.iptvclient.android.common.player.j.i iVar, Bundle bundle, Context context, com.zte.iptvclient.android.common.player.k.c cVar) {
        this.f4883d = false;
        this.f4880a = true;
        this.g = cVar;
        bundle.putString("auth_contenttype", "2");
        b(1, iVar, bundle, context);
    }

    public void a(com.zte.iptvclient.android.common.player.j.j jVar, Bundle bundle, Context context, FragmentManager fragmentManager, int i2, com.zte.iptvclient.android.common.player.k.c cVar) {
        this.f4883d = true;
        this.e = fragmentManager;
        this.f = i2;
        this.g = cVar;
        this.f4880a = true;
        bundle.putString("auth_contenttype", "4");
        LogEx.d(g0, "in bundle param *****: " + bundle.toString());
        b(2, jVar, bundle, context);
    }

    public void a(com.zte.iptvclient.android.common.player.j.k kVar, Bundle bundle, Context context, FragmentManager fragmentManager, int i2, com.zte.iptvclient.android.common.player.k.c cVar) {
        this.f4883d = true;
        this.e = fragmentManager;
        this.f = i2;
        this.g = cVar;
        this.f4880a = true;
        bundle.putString("auth_contenttype", "12");
        com.zte.iptvclient.android.common.player.k.c cVar2 = this.g;
        if (cVar2 != null) {
            cVar2.a2();
            this.g.G2();
        }
        b(3, kVar, bundle, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, com.zte.iptvclient.android.common.player.j.f fVar, Bundle bundle, Context context) {
        if (fVar != null && bundle != null && context != null) {
            this.f4881b = context;
            this.c0 = (SupportActivity) context;
            this.Y = new com.zte.iptvclient.android.common.j.h(context);
            this.g.E1();
            if (!this.f4883d) {
                x();
            }
            this.q = bundle.getString("auth_contenttype");
            l();
            this.f4882c = new WeakReference<>(context);
            this.h = bundle;
            String a2 = fVar.a();
            this.i = a2;
            if (a2 == null) {
                LogEx.e(g0, "mStrColumnCode in adRequest is null!");
            }
            this.Z = new com.zte.iptvclient.common.uiframe.a().a("Get_TV_Url_By_Frame");
            if (Boolean.valueOf(bundle.getBoolean("isfromdownloaded")).booleanValue()) {
                e(i2, fVar, bundle, context);
                return;
            } else {
                c(i2, fVar, bundle, context);
                return;
            }
        }
        LogEx.w(g0, "adRequest or mPlayerBundle or context is null!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.zte.iptvclient.android.common.player.j.e eVar) {
        if (eVar == null) {
            LogEx.d(g0, " skipToPlayer!");
            LogEx.d(g0, "Test the starting speed : dealAdsRsp end");
            y();
            return;
        }
        i0 = eVar;
        this.F = eVar.f();
        this.G = i0.g();
        List<com.zte.iptvclient.android.common.player.j.c> d2 = i0.d();
        if (!com.zte.iptvclient.android.common.k.f.a(d2)) {
            d(d2.get(0).a());
        } else {
            w();
        }
    }

    private void a(List<com.zte.iptvclient.android.common.player.j.d> list) {
        if (list != null && i0 != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                com.zte.iptvclient.android.common.player.j.d dVar = list.get(i2);
                if (dVar != null) {
                    LogEx.d(g0, "ITem Ad ContentLength " + dVar.c() + " ;Position " + dVar.i() + " ;playNum " + dVar.h());
                    if (dVar.k() == 1) {
                        c();
                        if (this.Q == i0.i().size() && this.P == i0.h().size()) {
                            LogEx.d(g0, "Test the starting speed : dealAdsRsp end");
                            y();
                        }
                    } else {
                        new SDKNetHTTPRequest().startRequest(String.format("%s/iptvepg/datasource/getadurl.jsp", com.zte.iptvclient.android.common.f.b.i.b()) + "?videocodes=" + dVar.b(), "GET", new m(dVar));
                    }
                }
            }
            return;
        }
        y();
    }

    private String a(String str, boolean z, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.replace("live_hls", "tstv_hls") + "&playseek=beginning-";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        com.zte.iptvclient.android.common.player.k.c cVar = this.g;
        if (cVar != null) {
            cVar.a2();
            this.g.E();
            this.g.d3();
            this.g.P2();
            return;
        }
        Bundle bundle = this.h;
        if (bundle == null) {
            this.h = new Bundle();
            this.f4882c = new WeakReference<>(context);
        } else {
            bundle.clear();
        }
        Intent intent = new Intent();
        boolean z = false;
        if (this.b0) {
            this.b0 = false;
            this.h.putBoolean("isFromShakeWatch", true);
        } else {
            this.h.putBoolean("isFromShakeWatch", false);
        }
        this.h.putBoolean("isPlayConcurrencyMax", true);
        intent.putExtras(this.h);
        Context context2 = this.f4882c.get();
        if (context2 != null) {
            intent.setClass(context2, VOPlayerActivity.class);
            ComponentName resolveActivity = intent.resolveActivity(this.f4882c.get().getPackageManager());
            if (resolveActivity != null) {
                for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) context2.getSystemService("activity")).getRunningTasks(10)) {
                    if (runningTaskInfo.topActivity.equals(resolveActivity) || runningTaskInfo.baseActivity.equals(resolveActivity)) {
                        z = true;
                        break;
                    }
                }
            }
            if (z) {
                intent.putExtra("switchChannel", true);
            } else {
                intent.addFlags(268435456);
            }
            context2.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EditText editText, Context context) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager == null || !inputMethodManager.isActive()) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    private void a(SDKNetHTTPRequest sDKNetHTTPRequest) {
        sDKNetHTTPRequest.startRequest(String.format("%s/iptvepg/datasource/getplayurlforth.jsp", com.zte.iptvclient.android.common.f.b.i.b()), HttpRequest.METHOD_GET, new C0144f());
    }

    public static void a(long j2, long j3) {
        LogEx.d(g0, "reportInnerMiddleAdInfo begintime = " + j2 + " endtime = " + j3);
        if (j2 > j3) {
            LogEx.d(g0, "dont need report");
            return;
        }
        com.zte.iptvclient.android.common.player.j.e eVar = i0;
        if (eVar == null) {
            LogEx.e(g0, "reportMiddleAdInfo AD == null");
            return;
        }
        List<com.zte.iptvclient.android.common.player.j.d> i2 = eVar.i();
        if (i2 != null && i2.size() > 0) {
            for (com.zte.iptvclient.android.common.player.j.d dVar : i2) {
                if (dVar.k() == 1) {
                    long e2 = dVar.e();
                    long c2 = dVar.c() + e2;
                    LogEx.d(g0, "adbegintime = " + e2 + " adendtime = " + c2);
                    if (e2 <= j3 && c2 >= j2) {
                        a((Date) null, (Date) null, dVar.b(), dVar.g(), "0", dVar.c() * 1000);
                    } else {
                        LogEx.d(g0, "time error dont need report");
                    }
                }
            }
            return;
        }
        LogEx.e(g0, "reportInnerMiddleAdInfo AD = null!");
    }

    public static void a(Date date, Date date2, long j2) {
        LogEx.d(g0, "reportEndAdInfo");
        com.zte.iptvclient.android.common.player.j.e eVar = i0;
        if (eVar == null) {
            LogEx.e(g0, "reportEndAdInfo AD == null");
            return;
        }
        List<com.zte.iptvclient.android.common.player.j.d> h2 = eVar.h();
        if (h2 != null && h2.size() > 0) {
            com.zte.iptvclient.android.common.player.j.d dVar = h2.get(0);
            if (dVar != null) {
                a(date, date2, dVar.b(), dVar.g(), "0", j2);
                return;
            } else {
                LogEx.e(g0, "reportEndAdInfo AD = null!");
                return;
            }
        }
        LogEx.e(g0, "reportEndAdInfo AD = null!");
    }

    public static void a(Date date, Date date2, String str, String str2, String str3, long j2) {
        String str4;
        long j3 = j2 / 1000;
        if (j3 > 0 && j3 < 86400) {
            String replace = "http://{ipadd:port}/iptvepg/{frame}/sdk_reportadplayinfo.jsp".replace("http://{ipadd:port}/iptvepg/{frame}/", com.zte.iptvclient.android.common.f.b.i.f());
            if (date != null && date2 != null) {
                str4 = replace + "?contentcode=" + str + "&ordercode=" + str2 + "&srcflag=" + str3 + "&begintime=" + x.a("yyyyMMddHHmmss", date) + "&endtime=" + x.a("yyyyMMddHHmmss", date2) + "&timelen=" + j3;
            } else {
                str4 = replace + "?contentcode=" + str + "&ordercode=" + str2 + "&srcflag=" + str3 + "&timelen=" + j3;
            }
            SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
            sDKNetHTTPRequest.setHeader("Cookie", com.zte.iptvclient.android.common.f.b.i.h());
            LogEx.d(g0, "reportAdplayerInfo " + str4);
            sDKNetHTTPRequest.startRequest(str4, HttpRequest.METHOD_GET, new g());
            return;
        }
        LogEx.i(g0, "timelen error = " + j2);
    }

    public boolean a(String str) {
        String d2 = com.zte.iptvclient.common.uiframe.a.d(com.zte.iptvclient.android.common.c.c.f);
        LogEx.d(g0, "strUSerNetType=" + d2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(d2)) {
            return true;
        }
        try {
            LogEx.d(g0, "checkAllowNetType strContentNetType=" + str);
            return (Integer.parseInt(str) & Integer.parseInt(d2)) != 0;
        } catch (Exception e2) {
            LogEx.e(g0, " checkAllowNetType getException=" + e2.getMessage());
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, List<com.zte.iptvclient.android.common.player.j.g> list) {
        this.h.putString(ParamConst.UPDATE_VERSION_RSP_URL, str);
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        arrayList.clear();
        if (list.size() > 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                DefinitionBean definitionBean = new DefinitionBean();
                if (TextUtils.equals(list.get(i2).a(), "240")) {
                    definitionBean.a(com.zte.iptvclient.android.common.i.a.a.a(R.string.megogo_low));
                    definitionBean.b(list.get(i2).b());
                    arrayList.add(definitionBean);
                } else if (TextUtils.equals(list.get(i2).a(), "320")) {
                    definitionBean.a(com.zte.iptvclient.android.common.i.a.a.a(R.string.megogo_medium));
                    definitionBean.b(list.get(i2).b());
                    arrayList.add(definitionBean);
                } else if (TextUtils.equals(list.get(i2).a(), "360")) {
                    definitionBean.a(com.zte.iptvclient.android.common.i.a.a.a(R.string.megogo_common));
                    definitionBean.b(list.get(i2).b());
                    arrayList.add(definitionBean);
                } else if (TextUtils.equals(list.get(i2).a(), "480")) {
                    definitionBean.a(com.zte.iptvclient.android.common.i.a.a.a(R.string.megogo_good));
                    definitionBean.b(list.get(i2).b());
                    arrayList.add(definitionBean);
                } else if (TextUtils.equals(list.get(i2).a(), "720")) {
                    definitionBean.a(com.zte.iptvclient.android.common.i.a.a.a(R.string.megogo_high));
                    definitionBean.b(list.get(i2).b());
                    arrayList.add(definitionBean);
                } else if (TextUtils.equals(list.get(i2).a(), "1080")) {
                    definitionBean.a(com.zte.iptvclient.android.common.i.a.a.a(R.string.megogo_best));
                    definitionBean.b(list.get(i2).b());
                    arrayList.add(definitionBean);
                } else if (TextUtils.equals(list.get(i2).a(), "2160")) {
                    definitionBean.a(com.zte.iptvclient.android.common.i.a.a.a(R.string.megogo_4k));
                    definitionBean.b(list.get(i2).b());
                    arrayList.add(definitionBean);
                }
            }
        }
        this.h.putParcelableArrayList("megogodefinitionList", arrayList);
    }
}
