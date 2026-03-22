package com.zte.iptvclient.android.mobile.c0.a;

import android.content.Context;
import com.facebook.share.widget.ShareDialog;
import com.video.androidsdk.common.config.ConfigMgr;
import com.zte.iptvclient.android.mobile.home.tab.helper.TabHostManager;
import com.zte.iptvclient.android.mobile.l.c.a.b;
import com.zte.iptvclient.android.zala.R;

/* compiled from: MenuFactory.java */
/* loaded from: classes2.dex */
public class a {

    /* compiled from: MenuFactory.java */
    /* renamed from: com.zte.iptvclient.android.mobile.c0.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class C0195a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5621a;

        static {
            int[] iArr = new int[TabHostManager.TabName.values().length];
            f5621a = iArr;
            try {
                iArr[TabHostManager.TabName.ACCOUNT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5621a[TabHostManager.TabName.ORDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5621a[TabHostManager.TabName.PACKAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5621a[TabHostManager.TabName.DOWNLOAD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5621a[TabHostManager.TabName.FAVORITE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5621a[TabHostManager.TabName.RECORDING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f5621a[TabHostManager.TabName.REMINDER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f5621a[TabHostManager.TabName.BOOKMARK.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f5621a[TabHostManager.TabName.PARENTAL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f5621a[TabHostManager.TabName.SETTING.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f5621a[TabHostManager.TabName.SHARE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f5621a[TabHostManager.TabName.HELP.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f5621a[TabHostManager.TabName.MESSAGE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f5621a[TabHostManager.TabName.PPV.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f5621a[TabHostManager.TabName.BINDING.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f5621a[TabHostManager.TabName.CONSUMPTIONRECORDS.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f5621a[TabHostManager.TabName.FEATUREPACKAGE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f5621a[TabHostManager.TabName.CHANNELLINEUP.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f5621a[TabHostManager.TabName.BALANCE.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f5621a[TabHostManager.TabName.REMOTER.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
        }
    }

    public static b a(Context context, TabHostManager.TabName tabName) {
        if (context == null) {
            return null;
        }
        b bVar = new b();
        bVar.f6762a = tabName;
        switch (C0195a.f5621a[tabName.ordinal()]) {
            case 1:
                bVar.f = "";
                bVar.e = R.drawable.mine_my_order;
                bVar.f6764c = "";
                return bVar;
            case 2:
                bVar.f = com.zte.iptvclient.android.common.i.a.a.a(R.string.tab_name_order);
                bVar.e = R.drawable.iv_mine_lately_watch;
                bVar.f6764c = "order";
                return bVar;
            case 3:
                bVar.f = com.zte.iptvclient.android.common.i.a.a.a(R.string.product_package);
                bVar.e = R.drawable.mine_my_product_package;
                bVar.f6764c = "productnew";
                return bVar;
            case 4:
                bVar.f = com.zte.iptvclient.android.common.i.a.a.a(R.string.tab_name_cache);
                bVar.e = R.drawable.mine_offline_cache;
                bVar.f6764c = "download";
                return bVar;
            case 5:
                bVar.f = com.zte.iptvclient.android.common.i.a.a.a(R.string.tab_name_favorite);
                bVar.e = R.drawable.mine_my_favourite;
                if ("1".equals(ConfigMgr.readPropertie("IsSupportSTBFavorite"))) {
                    bVar.f6764c = "favorite_support_stb";
                } else {
                    bVar.f6764c = "favorite";
                }
                return bVar;
            case 6:
                bVar.f = com.zte.iptvclient.android.common.i.a.a.a(R.string.recording_my_recording);
                bVar.e = R.drawable.icon_my_recording;
                bVar.f6764c = "recordings";
                return bVar;
            case 7:
                bVar.f = com.zte.iptvclient.android.common.i.a.a.a(R.string.my_subscribe);
                bVar.e = R.drawable.mine_my_appointment;
                if ("1".equals(ConfigMgr.readPropertie("IsSupportOnlineSubscribe"))) {
                    bVar.f6764c = "subscribe_online";
                } else {
                    bVar.f6764c = "subscribe";
                }
                return bVar;
            case 8:
                bVar.f = com.zte.iptvclient.android.common.i.a.a.a(R.string.tab_name_bookmark);
                bVar.e = R.drawable.iv_mine_lately_watch;
                if ("1".equals(ConfigMgr.readPropertie("IsTVHistory"))) {
                    bVar.f6764c = "history";
                } else {
                    bVar.f6764c = "bookmark";
                }
                return bVar;
            case 9:
                bVar.f = com.zte.iptvclient.android.common.i.a.a.a(R.string.parental_control);
                bVar.e = R.drawable.parental_control;
                bVar.f6764c = "parentcontral";
                return bVar;
            case 10:
                bVar.f = com.zte.iptvclient.android.common.i.a.a.a(R.string.setting_title);
                bVar.e = R.drawable.icon_top_navbar_setting;
                bVar.f6764c = "setting";
                return bVar;
            case 11:
                bVar.f = com.zte.iptvclient.android.common.i.a.a.a(R.string.tab_name_share);
                bVar.e = R.drawable.mine_share;
                bVar.f6764c = ShareDialog.WEB_SHARE_DIALOG;
                return bVar;
            case 12:
                bVar.f = com.zte.iptvclient.android.common.i.a.a.a(R.string.help_feedbook);
                bVar.e = R.drawable.mine_help_feedback;
                bVar.f6764c = "help";
                return bVar;
            case 13:
                bVar.f = com.zte.iptvclient.android.common.i.a.a.a(R.string.system_message);
                bVar.e = R.drawable.icon_top_navbar_message;
                bVar.f6764c = "messagecenter";
                return bVar;
            case 14:
                bVar.f = com.zte.iptvclient.android.common.i.a.a.a(R.string.ppv);
                bVar.e = R.drawable.mine_my_order;
                bVar.f6764c = "ppv";
                return bVar;
            case 15:
                bVar.f = context.getString(R.string.terminal_binding);
                bVar.e = R.drawable.icon_terminal_binding;
                bVar.f6764c = "terminalbindingbt";
                return bVar;
            case 16:
                bVar.f = context.getString(R.string.tab_name_consumption);
                bVar.e = R.drawable.mine_my_order;
                bVar.f6764c = "consumption_records";
                return bVar;
            case 17:
                bVar.f = context.getString(R.string.feature_package);
                bVar.e = R.drawable.icon_myfearurepackage;
                bVar.f6764c = "featurepackage";
                return bVar;
            case 18:
                bVar.f = context.getString(R.string.tab_name_lineup);
                bVar.e = R.drawable.mine_lineup;
                bVar.f6764c = "channellineup";
                return bVar;
            case 19:
                bVar.f = context.getString(R.string.my_balance);
                bVar.e = R.drawable.mine_balance;
                bVar.f6764c = "balance";
                return bVar;
            case 20:
                bVar.f = context.getString(R.string.remoter);
                bVar.e = R.drawable.icon_account_remote;
                bVar.f6764c = "fragment_remote";
                return bVar;
            default:
                return null;
        }
    }
}
