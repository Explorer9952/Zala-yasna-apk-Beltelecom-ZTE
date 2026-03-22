package com.zte.iptvclient.android.mobile.home.tab.helper;

import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.BaseApp;

/* compiled from: HomeNewColumnHelper.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f6426a = "b";

    public static final String a() {
        int j = j();
        if (1 == j) {
            return d();
        }
        if (2 == j) {
            return e();
        }
        if (3 == j) {
            return c();
        }
        return e();
    }

    public static final String b() {
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Home_NEW_Column");
        LogEx.d(f6426a, " newColumn: " + c2);
        return c2;
    }

    private static final String c() {
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Genre_Erotic");
        LogEx.d(f6426a, " [en] genre: " + c2);
        return c2;
    }

    private static final String d() {
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Genre_Erotic_be");
        LogEx.d(f6426a, " [be] genreBe: " + c2);
        return c2;
    }

    private static final String e() {
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Genre_Erotic_ru");
        LogEx.d(f6426a, " [ru] genreRu: " + c2);
        return c2;
    }

    private static final String f() {
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Home_NEW_Title");
        LogEx.d(f6426a, " [en] title: " + c2);
        return c2;
    }

    private static final String g() {
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Home_NEW_Title_be");
        LogEx.d(f6426a, " [be] titleBe: " + c2);
        return c2;
    }

    public static final String h() {
        int j = j();
        if (1 == j) {
            return g();
        }
        if (2 == j) {
            return i();
        }
        if (3 == j) {
            return f();
        }
        return i();
    }

    private static final String i() {
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Home_NEW_Title_ru");
        LogEx.d(f6426a, " [ru] titleRu: " + c2);
        return c2;
    }

    private static int j() {
        String lowerCase = BaseApp.e().getResources().getConfiguration().locale.getLanguage().toLowerCase();
        LogEx.d(f6426a, "locale:" + lowerCase);
        if ("be".equals(lowerCase)) {
            return 1;
        }
        return (!LocaleUtil.RUSSIAN.equals(lowerCase) && "en".equals(lowerCase)) ? 3 : 2;
    }
}
