package com.zte.iptvclient.android.mobile.x.a;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.http.bean.HttpRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.prevue.SDKPrevueMgr;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.j.i;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.common.javabean.models.d;
import com.zte.iptvclient.android.common.k.g;
import com.zte.iptvclient.android.mobile.share.activity.CaptureActivity;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ScanShareFragmentHD.java */
/* loaded from: classes2.dex */
public class b extends com.zte.fragmentlib.b implements View.OnClickListener {
    private LinearLayout p;
    private TextView q;
    private TextView r;
    private TextView s;
    private String t;
    private View u;
    private String v;
    private String w;
    private ArrayList<Channel> x;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScanShareFragmentHD.java */
    /* loaded from: classes2.dex */
    public class a implements SDKPrevueMgr.OnPrevueDetailWithUrlReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7736a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f7737b;

        a(String str, String str2) {
            this.f7736a = str;
            this.f7737b = str2;
        }

        @Override // com.video.androidsdk.service.prevue.SDKPrevueMgr.OnPrevueDetailWithUrlReturnListener
        public void onPrevueDetailWithUrlReturn(String str, String str2, String str3) {
            String str4;
            String str5;
            if (!TextUtils.equals(str, "0")) {
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(((com.zte.fragmentlib.b) b.this).h.getString(R.string.share_program_error));
                return;
            }
            d dVar = null;
            try {
                JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                for (int i = 0; i < jSONArray.length(); i++) {
                    dVar = d.a(jSONArray.getJSONObject(i));
                }
                String str6 = "";
                if (dVar != null) {
                    str5 = dVar.m();
                    str4 = dVar.c();
                } else {
                    str4 = "";
                    str5 = str4;
                }
                b.this.x.addAll(i.d().b());
                if (TextUtils.isEmpty(str5)) {
                    for (int i2 = 0; i2 < b.this.x.size(); i2++) {
                        if (TextUtils.equals(str4, ((Channel) b.this.x.get(i2)).getChannelcode())) {
                            b.this.v = ((Channel) b.this.x.get(i2)).getChannelname();
                            b.this.w = ((Channel) b.this.x.get(i2)).getPosterimage();
                        }
                    }
                } else {
                    for (int i3 = 0; i3 < b.this.x.size(); i3++) {
                        if (TextUtils.equals(str4, ((Channel) b.this.x.get(i3)).getChannelcode())) {
                            b.this.w = ((Channel) b.this.x.get(i3)).getPosterimage();
                        }
                    }
                    b.this.v = str5;
                }
                b.this.v = com.zte.iptvclient.android.common.i.a.a.a(R.string.let_us_watch) + " " + b.this.v + " " + com.zte.iptvclient.android.common.i.a.a.a(R.string.on_app_click_link_below);
                String str7 = com.zte.iptvclient.common.uiframe.a.c("Share_Link_Address") + "?vt=" + this.f7736a + "&vc=" + this.f7737b;
                if (((com.zte.fragmentlib.b) b.this).h != null) {
                    if (!TextUtils.isEmpty(b.this.w)) {
                        String[] split = b.this.w.split("/");
                        int length = split.length;
                        for (int i4 = 0; i4 < length; i4++) {
                            str6 = split[3];
                        }
                    }
                    new com.zte.iptvclient.android.mobile.x.b.c.c(((com.zte.fragmentlib.b) b.this).h, b.this.v, str7, str6, b.this.v, null, null, this.f7737b).a(b.this.u);
                }
            } catch (Exception e) {
                e.printStackTrace();
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(((com.zte.fragmentlib.b) b.this).h.getString(R.string.share_program_error));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScanShareFragmentHD.java */
    /* renamed from: com.zte.iptvclient.android.mobile.x.a.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0390b implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7739a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f7740b;

        C0390b(String str, String str2) {
            this.f7739a = str;
            this.f7740b = str2;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("onDataReturn", "s=" + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                if ("0".equals(jSONObject.optString("returncode"))) {
                    JSONArray jSONArray = jSONObject.getJSONArray("data");
                    String str2 = "";
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        b.this.v = jSONObject2.getString("programname");
                        b.this.w = jSONObject2.getString("posterfilelist");
                        str2 = jSONObject2.getString("description");
                    }
                    b.this.v = com.zte.iptvclient.android.common.i.a.a.a(R.string.let_us_watch) + " " + b.this.v + " " + com.zte.iptvclient.android.common.i.a.a.a(R.string.on_app_click_link_below);
                    String str3 = com.zte.iptvclient.common.uiframe.a.c("Share_Link_Address") + "?vt=" + this.f7739a + "&vc=" + this.f7740b;
                    if (((com.zte.fragmentlib.b) b.this).h != null) {
                        new com.zte.iptvclient.android.mobile.x.b.c.c(((com.zte.fragmentlib.b) b.this).h, str2, str3, g.c(BaseApp.f() ? 9 : 3, b.this.w), b.this.v, null, null, this.f7740b).a(b.this.u);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("onFailReturn", "s=" + str);
        }
    }

    private void I() {
        String string = this.h.getResources().getString(R.string.scan_share_stepOne);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        Matcher matcher = Pattern.compile("xxx").matcher(string);
        while (matcher.find()) {
            spannableStringBuilder.setSpan(new ImageSpan(this.h, R.drawable.play_share), matcher.start(), matcher.end(), 33);
        }
        this.q.setText(spannableStringBuilder);
    }

    private void J() {
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Share_App_Title");
        this.t = c2;
        if (TextUtils.isEmpty(c2)) {
            this.t = getString(R.string.share_app_url);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0052 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0053  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onActivityResult(int r13, int r14, android.content.Intent r15) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.mobile.x.a.b.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.scan_share_btn) {
            return;
        }
        startActivityForResult(new Intent(getContext(), (Class<?>) CaptureActivity.class), 0);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        J();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.scan_share_fragment_hd, (ViewGroup) null);
        this.u = inflate;
        d(inflate);
        return inflate;
    }

    private void d(View view) {
        this.p = (LinearLayout) view.findViewById(R.id.scan_share_btn);
        this.q = (TextView) view.findViewById(R.id.txt_step_one);
        this.r = (TextView) view.findViewById(R.id.txt_step_two);
        this.s = (TextView) view.findViewById(R.id.txt_step_thr);
        this.p.setOnClickListener(this);
        f.a(view.findViewById(R.id.share_title));
        f.a(view.findViewById(R.id.image_stb_pic));
        f.a(view.findViewById(R.id.scan_share_text));
        f.a(view.findViewById(R.id.scan_share_step1));
        f.a(this.q);
        f.a(view.findViewById(R.id.scan_share_step2));
        f.a(this.r);
        f.a(view.findViewById(R.id.scan_share_step3));
        f.a(this.s);
        f.a(this.p);
        f.a(view.findViewById(R.id.scan_share_image));
        f.a(view.findViewById(R.id.scan_share_btn_txt));
        I();
        this.r.setText(this.h.getResources().getString(R.string.scan_share_stepTwo));
        this.s.setText(this.h.getResources().getString(R.string.scan_share_stepThr));
    }

    private void e(String str, String str2) {
        String str3 = "http://{ipadd:port}/iptvepg/{frame}/sdk_getbatchvodinfo.jsp".replace("http://{ipadd:port}/iptvepg/{frame}/", com.zte.iptvclient.android.common.f.b.i.f()) + "?programcodes=" + str;
        LogEx.d("getbatchvodinfo url = ", str3);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", com.zte.iptvclient.android.common.f.b.i.h());
        sDKNetHTTPRequest.setCharset("gbk");
        sDKNetHTTPRequest.startRequest(str3, HttpRequest.METHOD_GET, new C0390b(str2, str));
    }

    private void a(String str, String str2, String str3) {
        SDKPrevueMgr sDKPrevueMgr = new SDKPrevueMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("prevuecode", str);
        hashMap.put("recommendtype", "0");
        sDKPrevueMgr.getPrevueDetailWithUrl(hashMap, new a(str3, str2));
    }
}
