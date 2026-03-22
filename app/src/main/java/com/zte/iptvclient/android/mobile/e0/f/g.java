package com.zte.iptvclient.android.mobile.e0.f;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.javabean.column.ColumnBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: VodColumnHelper.java */
/* loaded from: classes2.dex */
public class g {
    public static final List<String> a() {
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Column_VOD_FirstColumn");
        if (c2 == null) {
            return null;
        }
        return Arrays.asList(c2.split(","));
    }

    public static final ArrayList<ColumnBean> b() {
        List<String> e;
        int f = f();
        List<String> a2 = a();
        if (1 == f) {
            e = c();
        } else if (2 == f) {
            e = e();
        } else if (3 == f) {
            e = d();
        } else {
            e = e();
        }
        if (a2 == null || e == null) {
            return null;
        }
        int size = a2.size();
        int size2 = e.size();
        if (size > size2) {
            size = size2;
        }
        ArrayList<ColumnBean> arrayList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            ColumnBean columnBean = new ColumnBean();
            columnBean.setColumnCode(a2.get(i));
            columnBean.setColumnName(e.get(i));
            arrayList.add(columnBean);
        }
        LogEx.d("VodColumnHelper", "Column --> " + arrayList.toString());
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0033 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.util.List<java.lang.String> c() {
        /*
            r0 = 0
            java.lang.String r1 = "Column_VOD_FirstColumn_Name_be"
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
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "columnNameBeCollection: "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "VodColumnHelper"
            com.video.androidsdk.log.LogEx.d(r3, r2)
            if (r1 != 0) goto L34
            return r0
        L34:
            java.lang.String r0 = ","
            java.lang.String[] r0 = r1.split(r0)
            java.util.List r0 = java.util.Arrays.asList(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.mobile.e0.f.g.c():java.util.List");
    }

    public static final List<String> d() {
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Column_VOD_FirstColumn_Name");
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
    public static final java.util.List<java.lang.String> e() {
        /*
            r0 = 0
            java.lang.String r1 = "Column_VOD_FirstColumn_Name_ru"
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
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "columnNameRuCollection: "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "VodColumnHelper"
            com.video.androidsdk.log.LogEx.d(r3, r2)
            if (r1 != 0) goto L34
            return r0
        L34:
            java.lang.String r0 = ","
            java.lang.String[] r0 = r1.split(r0)
            java.util.List r0 = java.util.Arrays.asList(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.mobile.e0.f.g.e():java.util.List");
    }

    private static int f() {
        String lowerCase = BaseApp.e().getResources().getConfiguration().locale.getLanguage().toLowerCase();
        LogEx.d("VodColumnHelper", "locale:" + lowerCase);
        if ("be".equals(lowerCase)) {
            return 1;
        }
        return (!LocaleUtil.RUSSIAN.equals(lowerCase) && "en".equals(lowerCase)) ? 3 : 2;
    }

    public static void a(ImageView imageView, TextView textView) {
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        if (textView != null) {
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) textView.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = 0;
            layoutParams.setMarginStart(0);
            textView.setLayoutParams(layoutParams);
        }
    }

    public static void a(TextView textView) {
        if (textView != null) {
            textView.setVisibility(8);
        }
    }
}
