package com.zte.iptvclient.android.common.f.b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.facebook.internal.ServerProtocol;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.SDKUpgradeMgr;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.update.UpdateService;
import com.zte.iptvclient.android.common.update.b;
import com.zte.iptvclient.android.zala.R;

/* compiled from: VersionUpgradeMgr.java */
/* loaded from: classes.dex */
public class n {
    private static n f = null;
    private static String g = null;
    private static String h = null;
    private static String i = "";

    /* renamed from: a, reason: collision with root package name */
    private Context f4582a;

    /* renamed from: b, reason: collision with root package name */
    private com.zte.iptvclient.android.common.j.h f4583b;

    /* renamed from: c, reason: collision with root package name */
    private String f4584c = "";

    /* renamed from: d, reason: collision with root package name */
    private String f4585d = "";
    private int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VersionUpgradeMgr.java */
    /* loaded from: classes.dex */
    public class a implements SDKUpgradeMgr.OnUpgradeInfoReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f4586a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ SDKUpgradeMgr f4587b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f4588c;

        a(int i, SDKUpgradeMgr sDKUpgradeMgr, String str) {
            this.f4586a = i;
            this.f4587b = sDKUpgradeMgr;
            this.f4588c = str;
        }

        @Override // com.video.androidsdk.service.SDKUpgradeMgr.OnUpgradeInfoReturnListener
        public void onUpgradeInfoReturn(String str, String str2, int i) {
            LogEx.d("VersionUpgradeMgr", "@@@@@@@strErrorCode : " + str + ",strErrorMsg : " + str2 + ",upgradeType :\u3000" + i + " , current versioncode : " + this.f4586a);
            if (str.equals("0")) {
                String unused = n.i = this.f4587b.getURL(this.f4588c);
                LogEx.d("VersionUpgradeMgr", "mstrUrl " + n.i);
                String unused2 = n.g = this.f4587b.getHint(this.f4588c, com.zte.iptvclient.android.common.i.a.a.a(R.string.upgrade_set_language));
                LogEx.d("VersionUpgradeMgr", "mstrUpdateHint " + n.g);
                String unused3 = n.h = this.f4587b.getDiyInfo(this.f4588c, com.zte.iptvclient.android.common.i.a.a.a(R.string.upgrade_set_language), "latesttime");
                LogEx.d("VersionUpgradeMgr", "mstrLatestPublishTime " + n.h);
                n.this.f4585d = this.f4587b.getDiyInfo(this.f4588c, com.zte.iptvclient.android.common.i.a.a.a(R.string.upgrade_set_language), "latestversion");
                LogEx.d("VersionUpgradeMgr", "mUpdateVersionIfo " + n.this.f4585d);
                n.this.f4583b.L(n.this.f4585d);
                n.this.f4583b.M(n.h);
                n.this.f4583b.N(n.i);
                LogEx.d("VersionUpgradeMgr", "@@@@@@@mUpdateVersionIfo : " + n.this.f4585d + ",mstrLatestPublishTime : " + n.h + ",mstrUpdateHint :\u3000" + n.g + " , current mstrUrl : " + n.i);
                if (i == 1) {
                    BaseApp.e().a(i);
                    n.this.f4583b.h(true);
                    return;
                } else if (i != 2) {
                    n.this.f4583b.h(false);
                    return;
                } else {
                    BaseApp.e().a(i);
                    n.this.f4583b.h(true);
                    return;
                }
            }
            n.this.f4583b.h(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VersionUpgradeMgr.java */
    /* loaded from: classes.dex */
    public class b implements b.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f4590a;

        b(Context context) {
            this.f4590a = context;
        }

        @Override // com.zte.iptvclient.android.common.update.b.d
        public void a() {
            if (".apk".contains(n.i)) {
                Intent intent = new Intent(n.this.f4582a, (Class<?>) UpdateService.class);
                n.this.f4582a.stopService(intent);
                intent.putExtra("apkUrl", n.i);
                intent.putExtra("Force", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                n.this.f4582a.startService(intent);
                return;
            }
            Intent intent2 = new Intent();
            intent2.setAction("android.intent.action.VIEW");
            intent2.setData(Uri.parse(n.i));
            this.f4590a.startActivity(intent2);
        }

        @Override // com.zte.iptvclient.android.common.update.b.d
        public void b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VersionUpgradeMgr.java */
    /* loaded from: classes.dex */
    public class c implements b.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f4592a;

        c(Context context) {
            this.f4592a = context;
        }

        @Override // com.zte.iptvclient.android.common.update.b.d
        public void a() {
            Intent intent = new Intent(n.this.f4582a, (Class<?>) UpdateService.class);
            n.this.f4582a.stopService(intent);
            intent.putExtra("apkUrl", n.i);
            intent.putExtra("Force", "false");
            if (".apk".contains(n.i)) {
                n.this.f4582a.startService(intent);
                return;
            }
            Intent intent2 = new Intent();
            intent2.setAction("android.intent.action.VIEW");
            intent2.setData(Uri.parse(n.i));
            this.f4592a.startActivity(intent2);
        }

        @Override // com.zte.iptvclient.android.common.update.b.d
        public void b() {
            n.this.e = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VersionUpgradeMgr.java */
    /* loaded from: classes.dex */
    public class d implements b.d {
        d() {
        }

        @Override // com.zte.iptvclient.android.common.update.b.d
        public void a() {
            Intent intent = new Intent(n.this.f4582a, (Class<?>) UpdateService.class);
            n.this.f4582a.stopService(intent);
            intent.putExtra("apkUrl", n.i);
            intent.putExtra("Force", "false");
            n.this.f4582a.startService(intent);
        }

        @Override // com.zte.iptvclient.android.common.update.b.d
        public void b() {
            n.this.e = 0;
        }
    }

    private n() {
    }

    public static n d() {
        if (f == null) {
            f = new n();
        }
        return f;
    }

    public void b(Context context) {
        LogEx.d("VersionUpgradeMgr", "showForcibleUpgradeMessageNew  ");
        String str = com.zte.iptvclient.android.common.i.a.a.a(R.string.new_version_tip) + this.f4585d;
        if (TextUtils.isEmpty(i)) {
            Toast.makeText(this.f4582a, "download url is null", 0).show();
            return;
        }
        String str2 = g;
        this.f4584c = str2;
        if (context == null) {
            LogEx.d("VersionUpgradeMgr", "showForcibleUpgradeMessageNew return ");
            return;
        }
        com.zte.iptvclient.android.common.update.b bVar = new com.zte.iptvclient.android.common.update.b(context, str, R.drawable.popup_update, str2, R.drawable.lock_btn_buttom_bg, R.string.update_version, 0, 0, 0, 0, i, new b(context));
        bVar.a();
        LogEx.d("VersionUpgradeMgr", "showForcibleUpgradeMessageNew show ");
        bVar.a(false);
    }

    public void c(Context context) {
        if (TextUtils.isEmpty(i)) {
            Toast.makeText(this.f4582a, "download url is null", 0).show();
            return;
        }
        String str = g;
        this.f4584c = str;
        if (context == null) {
            return;
        }
        com.zte.iptvclient.android.common.update.b bVar = new com.zte.iptvclient.android.common.update.b(context, "网络异常升级失败", R.drawable.popup_update, str, R.drawable.lock_dialog_content_bg, R.string.retry, 0, R.drawable.lock_btn_buttom_bg, R.string.update_cancel, 0, i, new d());
        bVar.a();
        bVar.a(false);
    }

    public void d(Context context) {
        LogEx.d("VersionUpgradeMgr", "showUpgradeMessageNew = " + context);
        String a2 = com.zte.iptvclient.android.common.i.a.a.a(R.string.new_version_tip);
        String str = g;
        this.f4584c = str;
        if (TextUtils.isEmpty(i)) {
            Toast.makeText(this.f4582a, "download url is null", 0).show();
            return;
        }
        if (context == null) {
            LogEx.d("VersionUpgradeMgr", "showUpgradeMessageNew return " + context);
            return;
        }
        com.zte.iptvclient.android.common.update.b bVar = new com.zte.iptvclient.android.common.update.b(context, a2, R.drawable.popup_update, str, R.drawable.lock_dialog_content_bg, R.string.update_version, 0, R.drawable.lock_btn_buttom_bg, R.string.update_cancel, 0, i, new c(context));
        bVar.a();
        LogEx.d("VersionUpgradeMgr", "showUpgradeMessageNew show ");
        bVar.a(false);
    }

    public void a(Context context) {
        this.f4582a = context;
        if (this.f4583b == null) {
            this.f4583b = new com.zte.iptvclient.android.common.j.h(this.f4582a);
        }
        String S = this.f4583b.S();
        if (TextUtils.isEmpty(S)) {
            S = ConfigMgr.readPropertie("UpgradeServerIpPort");
            if (!TextUtils.isEmpty(S)) {
                this.f4583b.I(S);
            }
        }
        LogEx.d("VersionUpgradeMgr", "m_strUpdateUrl=" + S);
        try {
            String packageName = this.f4582a.getPackageName();
            LogEx.d("VersionUpgradeMgr", "pkName " + packageName);
            int i2 = this.f4582a.getPackageManager().getPackageInfo(packageName, 0).versionCode;
            LogEx.d("VersionUpgradeMgr", "versionCode " + i2);
            SDKUpgradeMgr createInstance = SDKUpgradeMgr.createInstance();
            createInstance.checkUpgrade(packageName, i2, S, new a(i2, createInstance, packageName));
        } catch (Exception e) {
            e.printStackTrace();
            this.f4583b.h(false);
        }
    }
}
