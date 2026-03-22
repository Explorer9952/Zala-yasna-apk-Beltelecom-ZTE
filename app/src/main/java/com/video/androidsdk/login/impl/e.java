package com.video.androidsdk.login.impl;

import android.text.TextUtils;
import com.video.androidsdk.SDKMgr;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.json.JsonObjectParser;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.bean.EPGHeartBeatRsp;
import com.video.androidsdk.login.impl.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PublicLoginMethod.java */
/* loaded from: classes.dex */
public class e implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b.c f3192a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f3193b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ b f3194c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, b.c cVar, String str) {
        this.f3194c = bVar;
        this.f3192a = cVar;
        this.f3193b = str;
    }

    private void a(int i, String str) {
        int i2;
        int i3;
        i2 = this.f3194c.f3184d;
        i3 = b.f3182b;
        if (i2 >= i3) {
            this.f3194c.b();
            this.f3192a.a(String.valueOf(i), str);
        } else {
            SDKMgr.f3018a.postDelayed(new f(this), 2000L);
        }
    }

    @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
    public void onDataReturn(String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        if (StringUtil.isEmptyString(str)) {
            str5 = b.f3181a;
            LogEx.d(str5, "HomePage http://{ipadd:port}/iptvepg/datasource/heartbeat.jsp response empty!");
            b.d(this.f3194c);
            a(ErrCode.getErrCode(IIPTVLogin.REQUESTID_HEARTBEAT, 99), "http://{ipadd:port}/iptvepg/datasource/heartbeat.jsp response empty!");
            return;
        }
        try {
            EPGHeartBeatRsp ePGHeartBeatRsp = (EPGHeartBeatRsp) JsonObjectParser.reflectBean(str, (Class<?>) EPGHeartBeatRsp.class);
            if (ePGHeartBeatRsp == null) {
                str4 = b.f3181a;
                LogEx.d(str4, "EPG heartbeat failed!" + str);
                b.d(this.f3194c);
                a(ErrCode.getErrCode(IIPTVLogin.REQUESTID_HEARTBEAT, 202), "EPG heartbeat response can not be parsed!");
                return;
            }
            int parseInt = Integer.parseInt(ePGHeartBeatRsp.getReturncode());
            if (parseInt == 0) {
                this.f3194c.f3184d = 0;
                return;
            }
            String errormsg = ePGHeartBeatRsp.getErrormsg();
            str3 = b.f3181a;
            LogEx.d(str3, "EPG heartbeat failed!" + str);
            b.d(this.f3194c);
            a(parseInt, errormsg);
        } catch (Exception unused) {
            str2 = b.f3181a;
            LogEx.d(str2, "EPG heartbeat response can not be parsed!" + str);
            b.d(this.f3194c);
            a(ErrCode.getErrCode(IIPTVLogin.REQUESTID_HEARTBEAT, 202), "EPG heartbeat response can not be parsed!");
        }
    }

    @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
    public void onFailReturn(int i, String str) {
        String str2;
        str2 = b.f3181a;
        LogEx.w(str2, "heartbeat failed");
        b.d(this.f3194c);
        if (!TextUtils.isEmpty(str)) {
            a(ErrCode.getErrCode(IIPTVLogin.REQUESTID_HEARTBEAT, 103), "Heartbeat exception!" + str);
            return;
        }
        a(ErrCode.getErrCode(IIPTVLogin.REQUESTID_HEARTBEAT, 103), "Heartbeat exception!");
    }
}
