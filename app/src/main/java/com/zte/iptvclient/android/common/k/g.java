package com.zte.iptvclient.android.common.k;

import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.mm.sdk.contact.RContact;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.video.androidsdk.common.AES;
import com.video.androidsdk.common.Base64Encoder;
import com.video.androidsdk.common.util.TimeUtil;
import com.video.androidsdk.common.util.security.DES;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.player.common.CommonFunc;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.netstate.NetWorkUtil;
import com.zte.iptvclient.android.common.netstate.NetworkStateReceiver;
import com.zte.iptvclient.android.zala.R;
import java.io.FilePermission;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: CommUtil.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: c, reason: collision with root package name */
    private static g f4803c;

    /* renamed from: d, reason: collision with root package name */
    private static ArrayList<String> f4804d;

    /* renamed from: a, reason: collision with root package name */
    private Context f4805a = null;

    /* renamed from: b, reason: collision with root package name */
    private com.zte.iptvclient.android.common.netstate.a f4806b = new a();

    /* compiled from: CommUtil.java */
    /* loaded from: classes.dex */
    static class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f4808a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f4809b;

        b(int i, View view) {
            this.f4808a = i;
            this.f4809b = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Float f = (Float) valueAnimator.getAnimatedValue();
            if (f != null) {
                if (this.f4808a == 1) {
                    this.f4809b.setTranslationY(f.floatValue());
                } else {
                    this.f4809b.setTranslationX(f.floatValue());
                }
            }
        }
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        f4804d = arrayList;
        arrayList.add("GT-P3100,samsung");
    }

    public static g b() {
        if (f4803c == null) {
            f4803c = new g();
        }
        return f4803c;
    }

    public static String c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean d(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        boolean z = true;
        if (Build.VERSION.SDK_INT <= 20) {
            return !activityManager.getRunningTasks(1).get(0).topActivity.getPackageName().equals(context.getPackageName());
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return true;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.importance == 100) {
                for (String str : runningAppProcessInfo.pkgList) {
                    if (str.equals(context.getPackageName())) {
                        z = false;
                    }
                }
            }
        }
        return z;
    }

    public static boolean e(Context context) {
        Locale locale = context.getResources().getConfiguration().locale;
        return (locale == null || "en".equals(locale.getLanguage())) ? false : true;
    }

    public static boolean f(Context context) {
        return BaseApp.a(context);
    }

    public static int g(Context context) {
        Locale locale = context.getResources().getConfiguration().locale;
        if (locale != null) {
            String language = locale.getLanguage();
            LogEx.d("CommUtil", "language: " + language);
            if ("en".equals(language)) {
                return 1;
            }
            if (!LocaleUtil.RUSSIAN.equals(language) && "be".equals(language)) {
                return 3;
            }
        }
        return 2;
    }

    public void a(Context context) {
        this.f4805a = context;
        NetworkStateReceiver.b(this.f4806b);
        NetworkStateReceiver.a(this.f4806b);
        NetworkStateReceiver.a(context);
    }

    public static String b(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
        return runningTasks != null ? runningTasks.get(0).topActivity.toString() : "";
    }

    /* compiled from: CommUtil.java */
    /* loaded from: classes.dex */
    class a extends com.zte.iptvclient.android.common.netstate.a {
        a() {
        }

        @Override // com.zte.iptvclient.android.common.netstate.a
        public void a(NetWorkUtil.netType nettype) {
            super.a(nettype);
            if (CommonFunc.getPlayer() == null) {
                if (g.d(g.this.f4805a)) {
                    LogEx.d("CommUtil", "application is background");
                    return;
                }
                return;
            }
            LogEx.d("CommUtil", "null != CommonFunc.getPlayer()");
        }

        @Override // com.zte.iptvclient.android.common.netstate.a
        public void a() {
            super.a();
            if (g.d(g.this.f4805a)) {
                LogEx.d("CommUtil", "application is background");
            }
        }
    }

    public static String c(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.split(";");
        if (i >= split.length) {
            return "";
        }
        return split[i];
    }

    public static String a(int i) {
        if (i < 1024) {
            return String.valueOf(i) + "MB";
        }
        double d2 = i;
        Double.isNaN(d2);
        return String.format("%.2f", Float.valueOf((float) ((d2 * 1.0d) / 1024.0d))) + "GB";
    }

    public static String b(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.split(";");
        if (i >= split.length) {
            return "";
        }
        return com.zte.iptvclient.android.common.f.b.i.b() + "/iptvepg/images/prevueposter/" + split[i];
    }

    public static String a(int i, String str) {
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Poster_Update_Mode");
        String b2 = o.j().b();
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.split(";");
        if (i >= split.length) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (TextUtils.equals(c2, "1")) {
            sb.append(b2);
            sb.append("/iptvepg/images/poster/");
            sb.append(split[i]);
            return sb.toString();
        }
        if (TextUtils.equals(c2, "2")) {
            sb.append(b2);
            sb.append("/");
            sb.append(com.zte.iptvclient.android.common.f.b.i.c());
            sb.append(":");
            sb.append(com.zte.iptvclient.android.common.f.b.i.d());
            sb.append("/iptvepg/images/poster/");
            sb.append(split[i]);
            return sb.toString();
        }
        sb.append(com.zte.iptvclient.android.common.f.b.i.b());
        sb.append("/iptvepg/images/poster/");
        sb.append(split[i]);
        return sb.toString();
    }

    public static final boolean c() {
        String str = Build.MODEL;
        if (str != null) {
            str = str.toUpperCase();
        }
        String str2 = Build.MANUFACTURER;
        if (str2 != null) {
            str2 = str2.toUpperCase();
        }
        LogEx.d("CommUtil", " model: " + str + " , carrier: " + str2);
        return "COL-L29".equals(str) && "HUAWEI".equals(str2);
    }

    public static final boolean d() {
        String str = Build.MODEL;
        if (str != null) {
            str = str.toUpperCase();
        }
        String str2 = Build.MANUFACTURER;
        if (str2 != null) {
            str2 = str2.toUpperCase();
        }
        LogEx.d("CommUtil", " model: " + str + " , carrier: " + str2);
        return "VRD-W10".equals(str) && "HUAWEI".equals(str2);
    }

    public static int b(String str) {
        if ("1,1".equals(str) || "1,".equals(str)) {
            return 1;
        }
        return ("2,1".equals(str) || "2,".equals(str)) ? 2 : 0;
    }

    public static void b(String str, String str2) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new FilePermission(str, str2));
        }
    }

    public static String a(String... strArr) {
        byte[] bArr;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strArr.length; i++) {
            if (i == 0) {
                stringBuffer.append(strArr[i]);
            } else {
                stringBuffer.append(RContact.FAVOUR_CONTACT_SHOW_HEAD_CHAR);
                stringBuffer.append(strArr[i]);
            }
        }
        LogEx.d("CommUtil", "strBuffer =" + ((Object) stringBuffer));
        StringBuilder sb = new StringBuilder(AES.getEncryptKey("reminderquerykey"));
        while (sb.length() < 24) {
            sb.append("0");
        }
        try {
            bArr = DES.encrypt(sb.toString().getBytes("ASCII"), stringBuffer.toString().getBytes("UTF-8"), DES.ALGORITHM_TRIPLE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        return Base64Encoder.encode(bArr);
    }

    public static String a(boolean z, int i) {
        StringBuilder sb;
        String str = z ? "1234567890" : "1234567890abcdefghijkmnpqrstuvwxyz";
        int length = str.length();
        boolean z2 = true;
        do {
            sb = new StringBuilder("");
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                double random = Math.random();
                double d2 = length;
                Double.isNaN(d2);
                int floor = (int) Math.floor(random * d2);
                char charAt = str.charAt(floor);
                if ('0' <= charAt && charAt <= '9') {
                    i2++;
                }
                sb.append(str.charAt(floor));
            }
            if (i2 >= 2) {
                z2 = false;
            }
        } while (z2);
        return sb.toString();
    }

    public static String a() {
        return a("usercode=" + com.zte.iptvclient.common.uiframe.a.d("UserID"), "userToken=" + com.zte.iptvclient.common.uiframe.a.d("UserToken"), "timestamp=" + TimeUtil.format(TimeUtil.getNow(), "yyyyMMddHHmmss"), a(true, 10));
    }

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static boolean a(Context context, String str) {
        for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) context.getSystemService("activity")).getRunningTasks(100)) {
            if (runningTaskInfo.topActivity.getPackageName().equals(str) && runningTaskInfo.baseActivity.getPackageName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(Context context, String str, String str2) {
        Intent intent = new Intent();
        intent.setClassName(str, str2);
        return intent.resolveActivity(context.getPackageManager()) != null;
    }

    public static String a(String str) {
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        sb.append(com.zte.iptvclient.android.common.f.b.i.b() + "/");
        int indexOf = str.indexOf("frame");
        if (indexOf > -1) {
            sb.append("iptvepg/");
            sb.append(str.substring(indexOf));
            return sb.toString();
        }
        int indexOf2 = str.indexOf(MessengerShareContentUtility.MEDIA_IMAGE);
        if (indexOf2 <= -1) {
            return null;
        }
        sb.append(str.substring(indexOf2));
        LogEx.i("CommUtil", "img  url---------------" + ((Object) sb));
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long a(java.lang.String r4, java.lang.String r5) {
        /*
            r0 = 0
            if (r4 == 0) goto L3f
            java.lang.String r2 = ""
            boolean r3 = android.text.TextUtils.equals(r4, r2)
            if (r3 == 0) goto Ld
            goto L3f
        Ld:
            if (r5 == 0) goto L3f
            boolean r2 = android.text.TextUtils.equals(r5, r2)
            if (r2 == 0) goto L16
            goto L3f
        L16:
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat
            java.lang.String r3 = "yyyy-MM-dd"
            r2.<init>(r3)
            r3 = 0
            java.util.Date r4 = r2.parse(r4)     // Catch: java.lang.Exception -> L2a
            java.util.Date r3 = r2.parse(r5)     // Catch: java.lang.Exception -> L28
            goto L2f
        L28:
            r5 = move-exception
            goto L2c
        L2a:
            r5 = move-exception
            r4 = r3
        L2c:
            r5.printStackTrace()
        L2f:
            if (r3 == 0) goto L3f
            long r4 = r4.getTime()
            long r0 = r3.getTime()
            long r4 = r4 - r0
            r0 = 86400000(0x5265c00, double:4.2687272E-316)
            long r4 = r4 / r0
            return r4
        L3f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.common.k.g.a(java.lang.String, java.lang.String):long");
    }

    public static ValueAnimator a(View view, float f, float f2, int i, int i2, float f3, AnimatorListenerAdapter animatorListenerAdapter) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f2);
        ofFloat.setDuration(i2);
        ofFloat.setInterpolator(new DecelerateInterpolator(f3));
        ofFloat.setTarget(view);
        ofFloat.addListener(animatorListenerAdapter);
        ofFloat.addUpdateListener(new b(i, view));
        return ofFloat;
    }

    public static void a(ImageView imageView, Context context) {
        imageView.setBackgroundColor(context.getResources().getColor(R.color.video_separateline_color));
    }

    public static void a(Context context, View view) {
        if (context == null || BaseApp.a(context) || view == null) {
            return;
        }
        view.setVisibility(8);
    }

    public static void a(Context context, View view, int i) {
        if (view == null || context == null) {
            return;
        }
        a(context, view.findViewById(i));
    }
}
