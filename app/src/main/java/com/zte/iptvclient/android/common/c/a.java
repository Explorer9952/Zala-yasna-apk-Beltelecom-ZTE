package com.zte.iptvclient.android.common.c;

import com.zte.iptvclient.common.uiframe.k;

/* compiled from: ClientErrCode.java */
/* loaded from: classes.dex */
public class a extends k {
    /* JADX WARN: Removed duplicated region for block: B:13:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getString(java.lang.String r7, int r8) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "ErrCode"
            com.zte.iptvclient.android.common.f.b.f r2 = com.zte.iptvclient.android.common.f.b.f.b()     // Catch: java.lang.Exception -> L3e
            java.util.Map r2 = r2.a()     // Catch: java.lang.Exception -> L3e
            if (r2 == 0) goto L23
            com.zte.iptvclient.android.common.f.b.f r2 = com.zte.iptvclient.android.common.f.b.f.b()     // Catch: java.lang.Exception -> L3e
            java.util.Map r2 = r2.a()     // Catch: java.lang.Exception -> L3e
            if (r2 == 0) goto L23
            java.lang.String r3 = java.lang.String.valueOf(r8)     // Catch: java.lang.Exception -> L3e
            java.lang.Object r2 = r2.get(r3)     // Catch: java.lang.Exception -> L3e
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Exception -> L3e
            goto L24
        L23:
            r2 = r0
        L24:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L39
            r3.<init>()     // Catch: java.lang.Exception -> L39
            java.lang.String r4 = "errorCodeMessage : "
            r3.append(r4)     // Catch: java.lang.Exception -> L39
            r3.append(r2)     // Catch: java.lang.Exception -> L39
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> L39
            com.video.androidsdk.log.LogEx.d(r1, r3)     // Catch: java.lang.Exception -> L39
            goto L58
        L39:
            r3 = move-exception
            r6 = r3
            r3 = r2
            r2 = r6
            goto L40
        L3e:
            r2 = move-exception
            r3 = r0
        L40:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "errorCodeMessage exception: "
            r4.append(r5)
            r4.append(r3)
            java.lang.String r4 = r4.toString()
            com.video.androidsdk.log.LogEx.w(r1, r4)
            r2.printStackTrace()
            r2 = r3
        L58:
            boolean r3 = com.video.androidsdk.common.util.StringUtil.isEmptyString(r2)
            if (r3 == 0) goto L79
            boolean r2 = com.video.androidsdk.common.util.StringUtil.isEmptyString(r7)
            if (r2 != 0) goto L73
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = 0
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r0[r1] = r8
            java.lang.String r7 = java.lang.String.format(r7, r0)
            return r7
        L73:
            java.lang.String r7 = "strErrorDescription is null!"
            com.video.androidsdk.log.LogEx.w(r1, r7)
            return r0
        L79:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "("
            r7.append(r0)
            r7.append(r8)
            java.lang.String r8 = ")"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "error massage result : "
            r8.append(r0)
            r8.append(r2)
            r8.append(r7)
            java.lang.String r8 = r8.toString()
            com.video.androidsdk.log.LogEx.d(r1, r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r2)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.common.c.a.getString(java.lang.String, int):java.lang.String");
    }
}
