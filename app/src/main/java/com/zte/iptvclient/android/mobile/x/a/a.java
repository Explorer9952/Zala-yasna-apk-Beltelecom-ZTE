package com.zte.iptvclient.android.mobile.x.a;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

/* compiled from: ScanShareFragment.java */
/* loaded from: classes2.dex */
public class a extends com.zte.fragmentlib.b implements View.OnClickListener {
    private ImageView p;
    private LinearLayout q;
    private TextView r;
    private String s;
    private View t;
    private String u;
    private String v;
    private ArrayList<Channel> w;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScanShareFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.x.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0389a implements SDKPrevueMgr.OnPrevueDetailWithUrlReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7730a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f7731b;

        C0389a(String str, String str2) {
            this.f7730a = str;
            this.f7731b = str2;
        }

        @Override // com.video.androidsdk.service.prevue.SDKPrevueMgr.OnPrevueDetailWithUrlReturnListener
        public void onPrevueDetailWithUrlReturn(String str, String str2, String str3) {
            String str4;
            String str5;
            if (!TextUtils.equals(str, "0")) {
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(((com.zte.fragmentlib.b) a.this).h.getString(R.string.share_program_error));
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
                a.this.w.addAll(i.d().b());
                if (TextUtils.isEmpty(str5)) {
                    for (int i2 = 0; i2 < a.this.w.size(); i2++) {
                        if (TextUtils.equals(this.f7730a, ((Channel) a.this.w.get(i2)).getChannelcode())) {
                            a.this.u = ((Channel) a.this.w.get(i2)).getChannelname();
                            a.this.v = ((Channel) a.this.w.get(i2)).getPosterimage();
                        }
                    }
                } else {
                    for (int i3 = 0; i3 < a.this.w.size(); i3++) {
                        if (TextUtils.equals(str4, ((Channel) a.this.w.get(i3)).getChannelcode())) {
                            a.this.v = ((Channel) a.this.w.get(i3)).getPosterimage();
                        }
                    }
                    a.this.u = str5;
                }
                a.this.u = com.zte.iptvclient.android.common.i.a.a.a(R.string.let_us_watch) + " " + a.this.u + " " + com.zte.iptvclient.android.common.i.a.a.a(R.string.on_app_click_link_below);
                String str7 = com.zte.iptvclient.common.uiframe.a.c("Share_Link_Address") + "?vt=" + this.f7731b + "&vc=" + this.f7730a;
                if (((com.zte.fragmentlib.b) a.this).h != null) {
                    if (!TextUtils.isEmpty(a.this.v)) {
                        String[] split = a.this.v.split("/");
                        int length = split.length;
                        for (int i4 = 0; i4 < length; i4++) {
                            str6 = split[3];
                        }
                    }
                    new com.zte.iptvclient.android.mobile.x.b.c.c(((com.zte.fragmentlib.b) a.this).h, a.this.u, str7, str6, a.this.u, null, null, this.f7730a).a(a.this.t);
                }
            } catch (Exception e) {
                e.printStackTrace();
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(((com.zte.fragmentlib.b) a.this).h.getString(R.string.share_program_error));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScanShareFragment.java */
    /* loaded from: classes2.dex */
    public class b implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7733a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f7734b;

        b(String str, String str2) {
            this.f7733a = str;
            this.f7734b = str2;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("onDataReturn", "s=" + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                if ("0".equals(jSONObject.optString("returncode"))) {
                    JSONArray jSONArray = jSONObject.getJSONArray("data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        a.this.u = jSONObject2.getString("programname");
                        a.this.v = jSONObject2.getString("posterfilelist");
                        jSONObject2.getString("description");
                    }
                    a.this.u = com.zte.iptvclient.android.common.i.a.a.a(R.string.let_us_watch) + " " + a.this.u + " " + com.zte.iptvclient.android.common.i.a.a.a(R.string.on_app_click_link_below);
                    String str2 = com.zte.iptvclient.common.uiframe.a.c("Share_Link_Address") + "?vt=" + this.f7733a + "&vc=" + this.f7734b;
                    if (((com.zte.fragmentlib.b) a.this).h != null) {
                        new com.zte.iptvclient.android.mobile.x.b.c.c(((com.zte.fragmentlib.b) a.this).h, a.this.u, str2, g.c(BaseApp.f() ? 9 : 3, a.this.v), a.this.u, null, null, this.f7734b).a(a.this.t);
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
        this.r.setText(spannableStringBuilder);
    }

    private void J() {
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Share_App_Title");
        this.s = c2;
        if (TextUtils.isEmpty(c2)) {
            this.s = getString(R.string.share_app_url);
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
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.mobile.x.a.a.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.scan_share_btn) {
            startActivityForResult(new Intent(getContext(), (Class<?>) CaptureActivity.class), 0);
        } else {
            if (id != R.id.scan_share_imagebtn) {
                return;
            }
            getActivity().finish();
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        J();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.scan_share_fragment, (ViewGroup) null);
        this.t = inflate;
        d(inflate);
        return inflate;
    }

    private void d(View view) {
        this.q = (LinearLayout) view.findViewById(R.id.scan_share_btn);
        this.p = (ImageView) view.findViewById(R.id.scan_share_imagebtn);
        this.r = (TextView) view.findViewById(R.id.txt_step_one);
        this.p.setOnClickListener(this);
        this.q.setOnClickListener(this);
        f.a(view.findViewById(R.id.share_title));
        f.a(this.q);
        f.a(this.p);
        ImageView imageView = (ImageView) view.findViewById(R.id.img_stb_pic);
        if (!BaseApp.a(getActivity())) {
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.iphone_share_pic));
        } else {
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.stb_pic));
        }
        I();
    }

    private void e(String str, String str2) {
        String str3 = "http://{ipadd:port}/iptvepg/{frame}/sdk_getbatchvodinfo.jsp".replace("http://{ipadd:port}/iptvepg/{frame}/", com.zte.iptvclient.android.common.f.b.i.f()) + "?programcodes=" + str;
        LogEx.d("getbatchvodinfo url = ", str3);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", com.zte.iptvclient.android.common.f.b.i.h());
        sDKNetHTTPRequest.setCharset("gbk");
        sDKNetHTTPRequest.startRequest(str3, HttpRequest.METHOD_GET, new b(str2, str));
    }

    private void a(String str, String str2, String str3) {
        SDKPrevueMgr sDKPrevueMgr = new SDKPrevueMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("prevuecode", str);
        hashMap.put("recommendtype", "0");
        sDKPrevueMgr.getPrevueDetailWithUrl(hashMap, new C0389a(str2, str3));
    }
}
