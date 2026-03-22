package com.zte.iptvclient.common.uiframe;

import com.video.androidsdk.common.ServerDate;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.log.LogEx;
import java.text.SimpleDateFormat;

/* compiled from: GetTransactionID.java */
/* loaded from: classes2.dex */
public class g {

    /* renamed from: b, reason: collision with root package name */
    private static g f7913b;

    /* renamed from: a, reason: collision with root package name */
    private String f7914a = "";

    private g() {
    }

    public static g a() {
        if (f7913b == null) {
            f7913b = new g();
        }
        return f7913b;
    }

    public String a(int i) {
        String str;
        String readPropertie = ConfigMgr.readPropertie("TransactionSp");
        this.f7914a = new SimpleDateFormat("yyyyMMddHHmmss").format(ServerDate.getEpgTime());
        LogEx.d("GetTransactionID", "current time is : " + this.f7914a);
        String str2 = readPropertie + this.f7914a;
        String valueOf = String.valueOf(i);
        if (valueOf.length() > 18) {
            str = str2 + valueOf.substring(0, 18);
        } else {
            int length = 18 - valueOf.length();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < length; i2++) {
                stringBuffer.append("0");
            }
            str = str2 + (stringBuffer.toString() + valueOf);
        }
        LogEx.d("GetTransactionID", "mStrTransactionId is : " + str);
        return str;
    }
}
