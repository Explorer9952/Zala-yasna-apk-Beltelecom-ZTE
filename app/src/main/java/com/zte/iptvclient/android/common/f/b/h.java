package com.zte.iptvclient.android.common.f.b;

import android.content.Context;
import android.text.TextUtils;
import com.video.androidsdk.common.ParamConst;
import com.video.androidsdk.log.ErrorLogReq;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.log.SDKLogMgr;
import com.zte.iptvclient.android.common.k.o;
import com.zte.iptvclient.android.zala.R;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: ErrorLogMgr.java */
/* loaded from: classes.dex */
public class h {
    private static h e;

    /* renamed from: a, reason: collision with root package name */
    private Context f4562a;

    /* renamed from: b, reason: collision with root package name */
    private com.zte.iptvclient.android.common.j.h f4563b;

    /* renamed from: c, reason: collision with root package name */
    private String f4564c = "ErrorLogMgr";

    /* renamed from: d, reason: collision with root package name */
    private String f4565d = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ErrorLogMgr.java */
    /* loaded from: classes.dex */
    public class a implements SDKLogMgr.OnErrorLogUploadReturnListener {
        a() {
        }

        @Override // com.video.androidsdk.log.SDKLogMgr.OnErrorLogUploadReturnListener
        public void onErrorLogUploadReturn(String str, String str2) {
            LogEx.d(h.this.f4564c, "upload login error log result: arg0=" + str + ",arg1=" + str2);
        }
    }

    private String b() {
        try {
            return this.f4562a != null ? this.f4562a.getPackageManager().getPackageInfo(this.f4562a.getPackageName(), 0).versionName : "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static h a() {
        if (e == null) {
            e = new h();
        }
        return e;
    }

    public void a(Context context) {
        this.f4562a = context;
        this.f4563b = new com.zte.iptvclient.android.common.j.h(context);
        String d2 = o.j().d();
        this.f4565d = d2;
        if (TextUtils.isEmpty(d2)) {
            return;
        }
        LogEx.d(this.f4564c, "strLogServerAddress = " + this.f4565d);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(this.f4565d)) {
            return;
        }
        SDKLogMgr createInstance = SDKLogMgr.createInstance();
        createInstance.setSeverDomain(this.f4565d);
        String format = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis()));
        ErrorLogReq errorLogReq = new ErrorLogReq();
        errorLogReq.setTerminalType(ParamConst.LOG_TERMINAL_TYPE_APHONE);
        if (this.f4562a != null) {
            errorLogReq.setAppName(com.zte.iptvclient.android.common.i.a.a.a(R.string.app_name));
        }
        errorLogReq.setAppVersion(b());
        com.zte.iptvclient.android.common.j.h hVar = this.f4563b;
        if (hVar != null) {
            errorLogReq.setUserName(hVar.V());
        }
        errorLogReq.setErrorCode(str);
        errorLogReq.setErrorDesc(str2);
        errorLogReq.setCreateTime(format);
        LogEx.d(this.f4564c, "ErrorLogReq logServerAddress=" + this.f4565d + ",errorCode=" + str + ",errorMsg=" + str2 + ",createtime=" + format);
        createInstance.uploadErrorLog(errorLogReq, new a());
    }
}
