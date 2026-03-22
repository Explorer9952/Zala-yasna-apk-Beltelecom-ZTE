package com.zte.iptvclient.android.mobile.l.c.a;

import android.content.Context;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.mobile.a0.b.e;
import com.zte.iptvclient.android.mobile.a0.b.f;
import com.zte.iptvclient.android.mobile.a0.b.g;
import com.zte.iptvclient.android.mobile.c0.b.c;
import com.zte.iptvclient.android.mobile.e0.e.n;
import com.zte.iptvclient.android.mobile.home.tab.helper.TabHostManager;
import com.zte.iptvclient.android.mobile.l.b.d;
import com.zte.iptvclient.android.mobile.user.fragment.k;
import com.zte.iptvclient.android.mobile.user.fragment.m;
import com.zte.iptvclient.android.zala.R;

/* compiled from: ItemFactory.java */
/* loaded from: classes.dex */
public class a {

    /* compiled from: ItemFactory.java */
    /* renamed from: com.zte.iptvclient.android.mobile.l.c.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class C0304a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6761a;

        static {
            int[] iArr = new int[TabHostManager.TabName.values().length];
            f6761a = iArr;
            try {
                iArr[TabHostManager.TabName.HOME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6761a[TabHostManager.TabName.TV.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6761a[TabHostManager.TabName.MY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6761a[TabHostManager.TabName.VOD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6761a[TabHostManager.TabName.MINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6761a[TabHostManager.TabName.RETURN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6761a[TabHostManager.TabName.TV_CHILD.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f6761a[TabHostManager.TabName.VOD_CHILD.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f6761a[TabHostManager.TabName.QUIZ_CHILD.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f6761a[TabHostManager.TabName.WATCHHISTORY_CHILD.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f6761a[TabHostManager.TabName.INTERACT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public static b a(Context context, TabHostManager.TabName tabName) {
        if (context == null) {
            return null;
        }
        b bVar = new b();
        bVar.f6762a = tabName;
        switch (C0304a.f6761a[tabName.ordinal()]) {
            case 1:
                bVar.f = com.zte.iptvclient.android.common.i.a.a.a(R.string.tab_name_home);
                bVar.f6765d = R.drawable.bottom_tab_home_selector;
                bVar.e = R.drawable.bottom_tab_home_selector;
                bVar.f6763b = d.class;
                return bVar;
            case 2:
                bVar.f = com.zte.iptvclient.android.common.i.a.a.a(R.string.tab_name_tv);
                bVar.f6765d = R.drawable.bottom_tab_tv_selector;
                bVar.e = R.drawable.menu_tv;
                if (BaseApp.a(context)) {
                    bVar.f6763b = e.class;
                } else {
                    bVar.f6763b = g.class;
                }
                return bVar;
            case 3:
                bVar.f = com.zte.iptvclient.android.common.i.a.a.a(R.string.my_txt);
                bVar.f6765d = R.drawable.bottom_tab_my_selector;
                bVar.e = R.drawable.menu_my_focus;
                if (BaseApp.a(context)) {
                    bVar.f6763b = com.zte.iptvclient.android.mobile.c0.b.d.class;
                } else {
                    bVar.f6763b = m.class;
                }
                return bVar;
            case 4:
                bVar.f = com.zte.iptvclient.android.common.i.a.a.a(R.string.tab_name_vod);
                bVar.f6765d = R.drawable.bottom_tab_vod_selector;
                bVar.e = R.drawable.menu_vod;
                bVar.f6763b = n.class;
                return bVar;
            case 5:
                bVar.f = com.zte.iptvclient.android.common.i.a.a.a(R.string.tab_mine);
                bVar.f6765d = R.drawable.menu_more_my_account_bg;
                bVar.e = R.drawable.menu_more_my_account_bg;
                if (BaseApp.a(context)) {
                    bVar.f6763b = c.class;
                } else {
                    bVar.f6763b = k.class;
                }
                return bVar;
            case 6:
                bVar.f = com.zte.iptvclient.android.common.i.a.a.a(R.string.return_txt);
                bVar.f6765d = R.drawable.bottom_tab_return_selecter;
                bVar.e = R.drawable.bottom_tab_childreturn_default;
                if (BaseApp.a(context)) {
                    bVar.f6763b = e.class;
                } else {
                    bVar.f6763b = g.class;
                }
                return bVar;
            case 7:
                bVar.f = com.zte.iptvclient.android.common.i.a.a.a(R.string.tab_name_tv);
                bVar.f6765d = R.drawable.bottom_tab_tv_selector;
                bVar.e = R.drawable.menu_tv;
                if (BaseApp.a(context)) {
                    bVar.f6763b = com.zte.iptvclient.android.mobile.a0.b.d.class;
                } else {
                    bVar.f6763b = f.class;
                }
                return bVar;
            case 8:
                bVar.f = com.zte.iptvclient.android.common.i.a.a.a(R.string.tab_name_vod);
                bVar.f6765d = R.drawable.bottom_tab_vod_selector;
                bVar.e = R.drawable.menu_vod;
                bVar.f6763b = n.class;
                return bVar;
            case 9:
                bVar.f = com.zte.iptvclient.android.common.i.a.a.a(R.string.quize_txt);
                bVar.f6765d = R.drawable.bottom_tab_quiz_selecter;
                bVar.e = R.drawable.bottom_tab_childquiz_default;
                bVar.f6763b = com.zte.iptvclient.android.mobile.t.b.class;
                return bVar;
            case 10:
                bVar.f = com.zte.iptvclient.android.common.i.a.a.a(R.string.watch_history_txt);
                bVar.f6765d = R.drawable.bottom_tab_watch_history_selecter;
                bVar.e = R.drawable.bottom_tab_childhistory_default;
                bVar.f6763b = com.zte.iptvclient.android.mobile.k.b.c.class;
                return bVar;
            case 11:
                bVar.f = "INTERACT";
                bVar.f6765d = R.drawable.icon_linktv;
                return bVar;
            default:
                return null;
        }
    }
}
