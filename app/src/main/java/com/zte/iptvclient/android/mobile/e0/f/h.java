package com.zte.iptvclient.android.mobile.e0.f;

import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.BaseApp;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* compiled from: VodFilterHelper.java */
/* loaded from: classes2.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static final String f6136a = "h";

    private static final String[] a() {
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Genre_Age_Name");
        if (c2 == null) {
            return null;
        }
        LogEx.d(f6136a, c2);
        return c2.split(",");
    }

    private static final String[] b() {
        String str;
        UnsupportedEncodingException e;
        String str2;
        try {
            str = com.zte.iptvclient.common.uiframe.a.c("Genre_Age_Name_be");
        } catch (UnsupportedEncodingException e2) {
            str = null;
            e = e2;
        }
        if (str == null) {
            return null;
        }
        try {
            str2 = URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e3) {
            e = e3;
            e.printStackTrace();
            str2 = str;
            LogEx.d(f6136a, str2);
            return str2.split(",");
        }
        LogEx.d(f6136a, str2);
        return str2.split(",");
    }

    public static final String[] c() {
        int e = e();
        if (1 == e) {
            return b();
        }
        if (2 == e) {
            return d();
        }
        if (3 == e) {
            return a();
        }
        return d();
    }

    private static final String[] d() {
        String str;
        UnsupportedEncodingException e;
        String str2;
        try {
            str = com.zte.iptvclient.common.uiframe.a.c("Genre_Age_Name_ru");
        } catch (UnsupportedEncodingException e2) {
            str = null;
            e = e2;
        }
        if (str == null) {
            return null;
        }
        try {
            str2 = URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e3) {
            e = e3;
            e.printStackTrace();
            str2 = str;
            LogEx.d(f6136a, str2);
            return str2.split(",");
        }
        LogEx.d(f6136a, str2);
        return str2.split(",");
    }

    private static int e() {
        String lowerCase = BaseApp.e().getResources().getConfiguration().locale.getLanguage().toLowerCase();
        LogEx.d(f6136a, "locale:" + lowerCase);
        if ("be".equals(lowerCase)) {
            return 1;
        }
        return (!LocaleUtil.RUSSIAN.equals(lowerCase) && "en".equals(lowerCase)) ? 3 : 2;
    }
}
