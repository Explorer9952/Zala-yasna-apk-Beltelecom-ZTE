package com.zte.iptvclient.android.mobile.order.helper;

import android.app.ProgressDialog;
import android.content.Context;
import com.google.common.logging.nano.Vr;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.auth.SDKSubscribeMgr;
import com.video.androidsdk.service.bean.SubscribeInfo;
import com.video.androidsdk.service.bean.SubscribeReq;
import com.zte.iptvclient.android.zala.R;

/* compiled from: EPGPaymentMethod.java */
/* loaded from: classes.dex */
public class a extends d {

    /* renamed from: c, reason: collision with root package name */
    private String f6945c = "EPGPaymentMethod";

    /* renamed from: d, reason: collision with root package name */
    public String f6946d;
    public String e;
    public String f;
    private String g;
    private ProgressDialog h;
    private b i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EPGPaymentMethod.java */
    /* renamed from: com.zte.iptvclient.android.mobile.order.helper.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0324a implements SDKSubscribeMgr.OnDoSubscribeReturnListener {
        C0324a() {
        }

        @Override // com.video.androidsdk.service.auth.SDKSubscribeMgr.OnDoSubscribeReturnListener
        public void onDoSubscribeReturn(String str, String str2, SubscribeInfo subscribeInfo) {
            LogEx.d(a.this.f6945c, "onDoSubscribeReturn arg0=" + str + "arg1=" + str2);
            if (a.this.h != null) {
                a.this.h.dismiss();
            }
            int parseInt = Integer.parseInt(str);
            if (parseInt == 0) {
                if (a.this.i != null) {
                    a.this.i.a(0, str2);
                }
            } else if (parseInt == ErrCode.getErrCode(Vr.VREvent.EventType.AUDIO_PERFORMANCE_REPORT, 4)) {
                if (a.this.i != null) {
                    a.this.i.a(6, str2);
                }
            } else if (a.this.i != null) {
                a.this.i.a(1, str2);
            }
        }
    }

    public a(Context context, String str, String str2, String str3, String str4) {
        com.zte.iptvclient.android.common.i.a.a.a(R.string.pay_method_phone);
        this.f6948a = com.zte.iptvclient.android.common.i.a.a.a(R.string.pay_method_phone_des);
        LogEx.d(this.f6945c, "mDescrip " + this.f6948a);
        this.f6949b = context;
        this.f6946d = str;
        this.e = str2;
        this.f = str3;
        this.g = str4;
        ProgressDialog progressDialog = new ProgressDialog(context);
        this.h = progressDialog;
        progressDialog.setMessage(com.zte.iptvclient.android.common.i.a.a.a(R.string.play_activity_play_load_data));
        this.h.setCanceledOnTouchOutside(false);
        this.h.setCancelable(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x010e  */
    @Override // com.zte.iptvclient.android.mobile.order.helper.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(com.video.androidsdk.service.bean.Product r17, com.zte.iptvclient.android.mobile.order.helper.b r18) {
        /*
            Method dump skipped, instructions count: 279
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.mobile.order.helper.a.a(com.video.androidsdk.service.bean.Product, com.zte.iptvclient.android.mobile.order.helper.b):void");
    }

    private void a(SubscribeReq subscribeReq) {
        ProgressDialog progressDialog = this.h;
        if (progressDialog != null) {
            progressDialog.show();
        }
        new SDKSubscribeMgr().doSubscribe(subscribeReq, new C0324a());
    }
}
