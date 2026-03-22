package com.zte.iptvclient.android.mobile.e0.f;

import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.javabean.column.ColumnBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: VodChildModeColumnHelper.java */
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static final String f6135a = "f";

    private static final List<String> a() {
        String c2 = com.zte.iptvclient.common.uiframe.a.c("ChildMode_Column_VOD_FirstColumn");
        if (c2 == null) {
            return null;
        }
        return Arrays.asList(c2.split(","));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0033 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.util.List<java.lang.String> b() {
        /*
            r0 = 0
            java.lang.String r1 = "ChildMode_Column_VOD_FirstColumn_Name_be"
            java.lang.String r1 = com.zte.iptvclient.common.uiframe.a.c(r1)     // Catch: java.lang.Exception -> L11 java.io.UnsupportedEncodingException -> L16
            if (r1 != 0) goto La
            return r0
        La:
            java.lang.String r2 = "UTF-8"
            java.lang.String r1 = java.net.URLDecoder.decode(r1, r2)     // Catch: java.lang.Exception -> L11 java.io.UnsupportedEncodingException -> L16
            goto L1b
        L11:
            r1 = move-exception
            r1.printStackTrace()
            goto L1a
        L16:
            r1 = move-exception
            r1.printStackTrace()
        L1a:
            r1 = r0
        L1b:
            java.lang.String r2 = com.zte.iptvclient.android.mobile.e0.f.f.f6135a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "columnNameBeCollection: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            com.video.androidsdk.log.LogEx.d(r2, r3)
            if (r1 != 0) goto L34
            return r0
        L34:
            java.lang.String r0 = ","
            java.lang.String[] r0 = r1.split(r0)
            java.util.List r0 = java.util.Arrays.asList(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.mobile.e0.f.f.b():java.util.List");
    }

    public static final List<String> c() {
        String c2 = com.zte.iptvclient.common.uiframe.a.c("ChildMode_Column_VOD_FirstColumn_Name");
        if (c2 == null) {
            return null;
        }
        return Arrays.asList(c2.split(","));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0033 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.util.List<java.lang.String> d() {
        /*
            r0 = 0
            java.lang.String r1 = "ChildMode_Column_VOD_FirstColumn_Name_ru"
            java.lang.String r1 = com.zte.iptvclient.common.uiframe.a.c(r1)     // Catch: java.lang.Exception -> L11 java.io.UnsupportedEncodingException -> L16
            if (r1 != 0) goto La
            return r0
        La:
            java.lang.String r2 = "UTF-8"
            java.lang.String r1 = java.net.URLDecoder.decode(r1, r2)     // Catch: java.lang.Exception -> L11 java.io.UnsupportedEncodingException -> L16
            goto L1b
        L11:
            r1 = move-exception
            r1.printStackTrace()
            goto L1a
        L16:
            r1 = move-exception
            r1.printStackTrace()
        L1a:
            r1 = r0
        L1b:
            java.lang.String r2 = com.zte.iptvclient.android.mobile.e0.f.f.f6135a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "columnNameRuCollection: "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            com.video.androidsdk.log.LogEx.d(r2, r3)
            if (r1 != 0) goto L34
            return r0
        L34:
            java.lang.String r0 = ","
            java.lang.String[] r0 = r1.split(r0)
            java.util.List r0 = java.util.Arrays.asList(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.mobile.e0.f.f.d():java.util.List");
    }

    public static final ArrayList<ColumnBean> e() {
        List<String> d2;
        int f = f();
        List<String> a2 = a();
        if (1 == f) {
            d2 = b();
        } else if (2 == f) {
            d2 = d();
        } else if (3 == f) {
            d2 = c();
        } else {
            d2 = d();
        }
        if (a2 == null || d2 == null) {
            return null;
        }
        int size = a2.size();
        int size2 = d2.size();
        if (size > size2) {
            size = size2;
        }
        ArrayList<ColumnBean> arrayList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            ColumnBean columnBean = new ColumnBean();
            columnBean.setColumnCode(a2.get(i));
            columnBean.setColumnName(d2.get(i));
            arrayList.add(columnBean);
        }
        LogEx.d(f6135a, "Column --> " + arrayList.toString());
        return arrayList;
    }

    private static int f() {
        String lowerCase = BaseApp.e().getResources().getConfiguration().locale.getLanguage().toLowerCase();
        LogEx.d(f6135a, "locale:" + lowerCase);
        if ("be".equals(lowerCase)) {
            return 1;
        }
        return (!LocaleUtil.RUSSIAN.equals(lowerCase) && "en".equals(lowerCase)) ? 3 : 2;
    }
}
