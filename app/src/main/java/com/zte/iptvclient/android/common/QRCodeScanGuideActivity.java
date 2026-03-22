package com.zte.iptvclient.android.common;

import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.video.androidsdk.common.config.ConfigMgr;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;

/* loaded from: classes.dex */
public class QRCodeScanGuideActivity extends SupportActivity {
    private static String L = "QRCodeScanGuideActivity";
    private TextView A;
    private TextView B;
    private TextView C;
    private TextView D;
    private LinearLayout E;
    private Button F;
    private FrameLayout G;
    private String J;
    private TextView K;
    private TextView v;
    private TextView w;
    private ImageView x;
    private TextView y;
    private TextView z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            QRCodeScanGuideActivity.this.finish();
        }
    }

    private void r() {
        this.v = (TextView) findViewById(R.id.title_txt);
        this.w = (TextView) findViewById(R.id.txt_title);
        this.x = (ImageView) findViewById(R.id.img_help);
        this.y = (TextView) findViewById(R.id.txt_step1);
        this.z = (TextView) findViewById(R.id.txt_step1_content);
        this.A = (TextView) findViewById(R.id.txt_step2);
        this.B = (TextView) findViewById(R.id.txt_step2_content);
        this.C = (TextView) findViewById(R.id.txt_step3);
        this.D = (TextView) findViewById(R.id.txt_step3_content);
        this.E = (LinearLayout) findViewById(R.id.container_step3);
        this.F = (Button) findViewById(R.id.btn_back);
        this.G = (FrameLayout) findViewById(R.id.fl_scan);
        this.K = (TextView) findViewById(R.id.txt_scan);
        f.a(this.v);
        f.a(this.F);
        f.a(this.x);
        f.a(this.E);
        f.a(this.G);
        f.a(findViewById(R.id.title_rlayout));
        f.a(findViewById(R.id.header_bottom_line));
        f.a(findViewById(R.id.scv_qrcode));
        f.a(findViewById(R.id.container_steps));
        f.a(this.w);
        f.a(this.y);
        f.a(this.z);
        f.a(this.A);
        f.a(this.B);
        f.a(this.C);
        f.a(this.D);
        f.a(findViewById(R.id.img_scan));
        f.a(this.K);
        this.v.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.title));
        this.y.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.setp_1));
        this.z.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.qrcodescan_hint_step1));
        this.A.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.setp_2));
        this.B.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.qrcodescan_hint_step2_1));
        this.C.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.setp_3));
        this.D.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.qrcodescan_hint_step3));
        this.K.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.qrscanguide_hint_btn_sacn));
    }

    private void s() {
        if ("bindaccount".equals(this.J)) {
            this.E.setVisibility(0);
            this.v.setText(com.zte.iptvclient.android.common.i.a.a.a(com.zte.iptvclient.android.common.i.a.a.a(R.string.qrscanguide_hint_ottbind)));
            this.w.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.qrscanguide_hint_stbbind_title));
            this.z.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.qrcodescan_hint_step1));
            this.B.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.qrcodescan_hint_step2_1));
            this.D.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.qrcodescan_hint_step3));
        } else {
            this.E.setVisibility(8);
            this.v.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.qrscanguide_hint_stbbind));
            this.w.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.qrscanguide_hint_stbbind_title));
            this.z.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.qrcodescan_hint_step1));
            this.B.setText(Html.fromHtml(com.zte.iptvclient.android.common.i.a.a.a(R.string.qrcodescan_hint_step2_1) + "<font color=\"" + getResources().getColor(R.color.text_red_new) + "\">" + com.zte.iptvclient.android.common.i.a.a.a(R.string.qrcodescan_hint_step2_2) + "</font>" + com.zte.iptvclient.android.common.i.a.a.a(R.string.qrcodescan_hint_step2_3)));
        }
        if ("1".equalsIgnoreCase(ConfigMgr.readPropertie("IS_SHOW_OTT_IMG"))) {
            this.x.setImageDrawable(getResources().getDrawable(R.drawable.bind_ott_tip));
        } else {
            this.x.setImageDrawable(getResources().getDrawable(R.drawable.stb_pic));
        }
    }

    private void t() {
        this.F.setOnClickListener(new a());
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0093  */
    @Override // com.zte.fragmentlib.SupportActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onActivityResult(int r7, int r8, android.content.Intent r9) {
        /*
            r6 = this;
            java.lang.String r0 = "userid"
            java.lang.String r1 = ""
            java.lang.String r2 = "deviceid"
            super.onActivityResult(r7, r8, r9)
            if (r9 != 0) goto Ld
            return
        Ld:
            android.os.Bundle r7 = r9.getExtras()
            java.lang.String r8 = "bindaccount"
            if (r7 != 0) goto L33
            java.lang.String r7 = r6.J
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L28
            com.zte.iptvclient.android.mobile.download.helper.b.b.a r7 = com.zte.iptvclient.android.mobile.download.helper.b.b.a.a()
            r8 = 2131624537(0x7f0e0259, float:1.8876257E38)
            r7.a(r8)
            goto L32
        L28:
            com.zte.iptvclient.android.mobile.download.helper.b.b.a r7 = com.zte.iptvclient.android.mobile.download.helper.b.b.a.a()
            r8 = 2131624536(0x7f0e0258, float:1.8876254E38)
            r7.a(r8)
        L32:
            return
        L33:
            java.lang.String r9 = "result"
            java.lang.String r7 = r7.getString(r9)
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch: org.json.JSONException -> L49
            r9.<init>(r7)     // Catch: org.json.JSONException -> L49
            java.lang.String r7 = r9.getString(r0)     // Catch: org.json.JSONException -> L49
            java.lang.String r1 = r9.getString(r2)     // Catch: org.json.JSONException -> L47
            goto L65
        L47:
            r9 = move-exception
            goto L4b
        L49:
            r9 = move-exception
            r7 = r1
        L4b:
            java.lang.String r3 = com.zte.iptvclient.android.common.QRCodeScanGuideActivity.L
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "result JSONObject exception="
            r4.append(r5)
            java.lang.String r9 = r9.getMessage()
            r4.append(r9)
            java.lang.String r9 = r4.toString()
            com.video.androidsdk.log.LogEx.d(r3, r9)
        L65:
            java.lang.String r9 = r6.J
            boolean r8 = r8.equals(r9)
            r9 = 2131625830(0x7f0e0766, float:1.887888E38)
            r3 = 0
            if (r8 == 0) goto L93
            boolean r8 = com.video.androidsdk.common.util.StringUtil.isEmptyString(r7)
            if (r8 == 0) goto L7f
            com.zte.iptvclient.android.mobile.download.helper.b.b.a r7 = com.zte.iptvclient.android.mobile.download.helper.b.b.a.a()
            r7.a(r9)
            return
        L7f:
            android.content.Intent r8 = new android.content.Intent
            r8.<init>()
            java.lang.String r9 = "stbid"
            r8.putExtra(r9, r7)
            r8.putExtra(r2, r1)
            r6.setResult(r3, r8)
            r6.finish()
            goto Lc3
        L93:
            java.lang.String r8 = r6.J
            java.lang.String r4 = "bindstb"
            boolean r8 = r4.equals(r8)
            if (r8 == 0) goto Lc3
            boolean r8 = com.video.androidsdk.common.util.StringUtil.isEmptyString(r7)
            if (r8 != 0) goto Lbc
            boolean r8 = com.video.androidsdk.common.util.StringUtil.isEmptyString(r1)
            if (r8 == 0) goto Laa
            goto Lbc
        Laa:
            android.content.Intent r8 = new android.content.Intent
            r8.<init>()
            r8.putExtra(r0, r7)
            r8.putExtra(r2, r1)
            r6.setResult(r3, r8)
            r6.finish()
            goto Lc3
        Lbc:
            com.zte.iptvclient.android.mobile.download.helper.b.b.a r7 = com.zte.iptvclient.android.mobile.download.helper.b.b.a.a()
            r7.a(r9)
        Lc3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.common.QRCodeScanGuideActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // com.zte.fragmentlib.SupportActivity, com.zte.fragmentlib.publicbaseclass.skinloader.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.qrcodescanguide);
        new Handler();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.J = extras.getString("purpose");
        }
        r();
        t();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        s();
    }
}
