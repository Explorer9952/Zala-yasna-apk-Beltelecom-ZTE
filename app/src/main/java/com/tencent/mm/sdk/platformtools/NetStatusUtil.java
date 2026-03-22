package com.tencent.mm.sdk.platformtools;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import com.video.androidsdk.sns.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* loaded from: classes.dex */
public class NetStatusUtil {
    public static final int CMNET = 6;
    public static final int CMWAP = 5;
    public static final int CTNET = 8;
    public static final int CTWAP = 7;
    public static final int LTE = 10;
    public static final int MOBILE = 9;
    public static final int NET_3G = 4;
    public static final int NON_NETWORK = -1;
    public static final int POLICY_NONE = 0;
    public static final int POLICY_REJECT_METERED_BACKGROUND = 1;
    public static final int TBACKGROUND_DATA_LIMITED = 2;
    public static final int TBACKGROUND_NOT_LIMITED = 0;
    public static final int TBACKGROUND_PROCESS_LIMITED = 1;
    public static final int TBACKGROUND_WIFI_LIMITED = 3;
    public static final int UNINET = 1;
    public static final int UNIWAP = 2;
    public static final int WAP_3G = 3;
    public static final int WIFI = 0;

    private static Intent a(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
            if (installedPackages == null || installedPackages.size() <= 0) {
                return null;
            }
            Log.e("MicroMsg.NetStatusUtil", "package  size" + installedPackages.size());
            for (int i = 0; i < installedPackages.size(); i++) {
                try {
                    Log.e("MicroMsg.NetStatusUtil", "package " + installedPackages.get(i).packageName);
                    Intent intent = new Intent();
                    intent.setPackage(installedPackages.get(i).packageName);
                    List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
                    int size = queryIntentActivities != null ? queryIntentActivities.size() : 0;
                    if (size > 0) {
                        try {
                            Log.e("MicroMsg.NetStatusUtil", "activityName count " + size);
                            for (int i2 = 0; i2 < size; i2++) {
                                ActivityInfo activityInfo = queryIntentActivities.get(i2).activityInfo;
                                if (activityInfo.name.contains(str)) {
                                    Intent intent2 = new Intent("/");
                                    intent2.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
                                    intent2.setAction("android.intent.action.VIEW");
                                    context.startActivity(intent2);
                                    return intent2;
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        continue;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static boolean checkFromXml(int i) {
        try {
            runRootCommand();
            NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new FileInputStream(new File("/data/system/netpolicy.xml"))).getDocumentElement().getElementsByTagName("uid-policy");
            for (int i2 = 0; i2 < elementsByTagName.getLength(); i2++) {
                Element element = (Element) elementsByTagName.item(i2);
                String attribute = element.getAttribute(Constants.SINA_WEIBO_UID);
                String attribute2 = element.getAttribute("policy");
                Log.e("MicroMsg.NetStatusUtil", "uid is " + attribute + "  policy is " + attribute2);
                if (attribute.equals(Integer.toString(i))) {
                    if (Integer.parseInt(attribute2) == 1) {
                        return true;
                    }
                    if (Integer.parseInt(attribute2) == 0) {
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void dumpNetStatus(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            Log.e("MicroMsg.NetStatusUtil", "isAvailable " + activeNetworkInfo.isAvailable());
            Log.e("MicroMsg.NetStatusUtil", "isConnected " + activeNetworkInfo.isConnected());
            Log.e("MicroMsg.NetStatusUtil", "isRoaming " + activeNetworkInfo.isRoaming());
            Log.e("MicroMsg.NetStatusUtil", "isFailover " + activeNetworkInfo.isFailover());
            Log.e("MicroMsg.NetStatusUtil", "getSubtypeName " + activeNetworkInfo.getSubtypeName());
            Log.e("MicroMsg.NetStatusUtil", "getExtraInfo " + activeNetworkInfo.getExtraInfo());
            Log.e("MicroMsg.NetStatusUtil", "activeNetInfo " + activeNetworkInfo.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getBackgroundLimitType(Context context) {
        int wifiSleeepPolicy;
        if (Build.VERSION.SDK_INT >= 14) {
            try {
                Class<?> cls = Class.forName("android.app.ActivityManagerNative");
                Object invoke = cls.getMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
                if (((Integer) invoke.getClass().getMethod("getProcessLimit", new Class[0]).invoke(invoke, new Object[0])).intValue() == 0) {
                    return 1;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            wifiSleeepPolicy = getWifiSleeepPolicy(context);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (wifiSleeepPolicy == 2) {
            return 0;
        }
        return (wifiSleeepPolicy == 1 || wifiSleeepPolicy == 0) ? 3 : 0;
    }

    public static int getNetType(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return -1;
        }
        if (activeNetworkInfo.getType() == 1) {
            return 0;
        }
        Log.d("MicroMsg.NetStatusUtil", "activeNetInfo.getExtraInfo()  " + activeNetworkInfo.getExtraInfo());
        Log.d("MicroMsg.NetStatusUtil", "activeNetInfo.getType()  " + activeNetworkInfo.getType());
        if (activeNetworkInfo.getExtraInfo() == null) {
            return 9;
        }
        if (activeNetworkInfo.getExtraInfo().equals("uninet")) {
            return 1;
        }
        if (activeNetworkInfo.getExtraInfo().equals("uniwap")) {
            return 2;
        }
        if (activeNetworkInfo.getExtraInfo().equals("3gwap")) {
            return 3;
        }
        if (activeNetworkInfo.getExtraInfo().equals("3gnet")) {
            return 4;
        }
        if (activeNetworkInfo.getExtraInfo().equals("cmwap")) {
            return 5;
        }
        if (activeNetworkInfo.getExtraInfo().equals("cmnet")) {
            return 6;
        }
        if (activeNetworkInfo.getExtraInfo().equals("ctwap")) {
            return 7;
        }
        if (activeNetworkInfo.getExtraInfo().equals("ctnet")) {
            return 8;
        }
        return activeNetworkInfo.getExtraInfo().equals("LTE") ? 10 : 9;
    }

    public static String getNetTypeString(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return "NON_NETWORK";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "WIFI";
        }
        Log.d("MicroMsg.NetStatusUtil", "activeNetInfo.getExtraInfo()  " + activeNetworkInfo.getExtraInfo());
        Log.d("MicroMsg.NetStatusUtil", "activeNetInfo.getType()  " + activeNetworkInfo.getType());
        return activeNetworkInfo.getExtraInfo() != null ? activeNetworkInfo.getExtraInfo() : "MOBILE";
    }

    public static int getWifiSleeepPolicy(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "wifi_sleep_policy", 2);
    }

    public static boolean is2G(int i) {
        return i == 1 || i == 2 || i == 5 || i == 6 || i == 7 || i == 8;
    }

    public static boolean is2G(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (activeNetworkInfo.getType() == 1) {
            return false;
        }
        if (activeNetworkInfo.getSubtype() != 2) {
            if (activeNetworkInfo.getSubtype() != 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean is3G(int i) {
        return i == 3 || i == 4;
    }

    public static boolean is3G(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.getType() != 1 && activeNetworkInfo.getSubtype() >= 5) {
                if (activeNetworkInfo.getSubtype() < 13) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean is4G(int i) {
        return i == 10;
    }

    public static boolean is4G(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (activeNetworkInfo.getType() == 1) {
            return false;
        }
        return activeNetworkInfo.getSubtype() >= 13;
    }

    public static boolean isConnected(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().isConnected();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isImmediatelyDestroyActivities(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "always_finish_activities", 0) != 0;
    }

    public static boolean isLimited(int i) {
        return i == 2 || i == 1 || i == 3;
    }

    public static boolean isMobile(int i) {
        return is3G(i) || is2G(i) || is4G(i);
    }

    public static boolean isMobile(Context context) {
        int netType = getNetType(context);
        return is3G(netType) || is2G(netType) || is4G(netType);
    }

    public static boolean isRestrictBacground(Context context) {
        int intValue;
        int i = context.getApplicationInfo().uid;
        try {
            Class<?> cls = Class.forName("android.net.NetworkPolicyManager");
            Object invoke = cls.getMethod("getSystemService", Context.class).invoke(cls, context);
            Field declaredField = cls.getDeclaredField("mService");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(invoke);
            intValue = ((Integer) obj.getClass().getMethod("getUidPolicy", Integer.TYPE).invoke(obj, Integer.valueOf(i))).intValue();
            Log.e("MicroMsg.NetStatusUtil", "policy is " + intValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (intValue == 1) {
            return true;
        }
        if (intValue == 0) {
            return false;
        }
        return checkFromXml(i);
    }

    public static boolean isWap(int i) {
        return i == 2 || i == 5 || i == 7 || i == 3;
    }

    public static boolean isWap(Context context) {
        return isWap(getNetType(context));
    }

    public static boolean isWifi(int i) {
        return i == 0;
    }

    public static boolean isWifi(Context context) {
        return isWifi(getNetType(context));
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0079 A[Catch: Exception -> 0x0075, TRY_LEAVE, TryCatch #5 {Exception -> 0x0075, blocks: (B:45:0x0071, B:38:0x0079), top: B:44:0x0071 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean runRootCommand() {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3f
            java.lang.String r2 = "su"
            java.lang.Process r1 = r1.exec(r2)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3f
            java.io.DataOutputStream r2 = new java.io.DataOutputStream     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L35
            java.io.OutputStream r3 = r1.getOutputStream()     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L35
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L30 java.lang.Exception -> L35
            java.lang.String r0 = "exit\n"
            r2.writeBytes(r0)     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L6e
            r2.flush()     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L6e
            r1.waitFor()     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L6e
            r2.close()     // Catch: java.lang.Exception -> L28
            if (r1 == 0) goto L2c
            r1.destroy()     // Catch: java.lang.Exception -> L28
            goto L2c
        L28:
            r0 = move-exception
            r0.printStackTrace()
        L2c:
            r0 = 1
            return r0
        L2e:
            r0 = move-exception
            goto L43
        L30:
            r2 = move-exception
            r6 = r2
            r2 = r0
            r0 = r6
            goto L6f
        L35:
            r2 = move-exception
            r6 = r2
            r2 = r0
            r0 = r6
            goto L43
        L3a:
            r1 = move-exception
            r2 = r0
            r0 = r1
            r1 = r2
            goto L6f
        L3f:
            r1 = move-exception
            r2 = r0
            r0 = r1
            r1 = r2
        L43:
            java.lang.String r3 = "MicroMsg.NetStatusUtil"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6e
            java.lang.String r5 = "the device is not rooted， error message： "
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L6e
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L6e
            r4.append(r0)     // Catch: java.lang.Throwable -> L6e
            java.lang.String r0 = r4.toString()     // Catch: java.lang.Throwable -> L6e
            com.tencent.mm.sdk.platformtools.Log.d(r3, r0)     // Catch: java.lang.Throwable -> L6e
            if (r2 == 0) goto L63
            r2.close()     // Catch: java.lang.Exception -> L61
            goto L63
        L61:
            r0 = move-exception
            goto L69
        L63:
            if (r1 == 0) goto L6c
            r1.destroy()     // Catch: java.lang.Exception -> L61
            goto L6c
        L69:
            r0.printStackTrace()
        L6c:
            r0 = 0
            return r0
        L6e:
            r0 = move-exception
        L6f:
            if (r2 == 0) goto L77
            r2.close()     // Catch: java.lang.Exception -> L75
            goto L77
        L75:
            r1 = move-exception
            goto L7d
        L77:
            if (r1 == 0) goto L80
            r1.destroy()     // Catch: java.lang.Exception -> L75
            goto L80
        L7d:
            r1.printStackTrace()
        L80:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.NetStatusUtil.runRootCommand():boolean");
    }

    public static void startSettingItent(Context context, int i) {
        String str;
        if (i == 1) {
            try {
                Intent intent = new Intent("/");
                intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.DevelopmentSettings"));
                intent.setAction("android.intent.action.VIEW");
                context.startActivity(intent);
                return;
            } catch (Exception unused) {
                str = "DevelopmentSettings";
            }
        } else {
            if (i != 2) {
                if (i != 3) {
                    return;
                }
                try {
                    Intent intent2 = new Intent();
                    intent2.setAction("android.settings.WIFI_IP_SETTINGS");
                    context.startActivity(intent2);
                    return;
                } catch (Exception unused2) {
                    a(context, "AdvancedSettings");
                    return;
                }
            }
            try {
                try {
                    Intent intent3 = new Intent("/");
                    intent3.setComponent(new ComponentName("com.android.providers.subscribedfeeds", "com.android.settings.ManageAccountsSettings"));
                    intent3.setAction("android.intent.action.VIEW");
                    context.startActivity(intent3);
                    return;
                } catch (Exception unused3) {
                    Intent intent4 = new Intent("/");
                    intent4.setComponent(new ComponentName("com.htc.settings.accountsync", "com.htc.settings.accountsync.ManageAccountsSettings"));
                    intent4.setAction("android.intent.action.VIEW");
                    context.startActivity(intent4);
                    return;
                }
            } catch (Exception unused4) {
                str = "ManageAccountsSettings";
            }
        }
        a(context, str);
    }
}
