package com.video.androidsdk.player.agama;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;

/* loaded from: classes.dex */
public class Utils {
    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean a(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String b(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null ? activeNetworkInfo.getType() == 1 ? "wlan" : activeNetworkInfo.getType() == 0 ? "mobile" : "" : "";
    }

    /* loaded from: classes.dex */
    public static class Asset {

        /* renamed from: a, reason: collision with root package name */
        private static int f3326a;

        /* renamed from: b, reason: collision with root package name */
        private int f3327b;
        public int contentDuration;
        public String contentTitle;
        public String contentType;
        public boolean isLive;
        public String name;
        public String protocol;
        public String uri;

        public Asset(String str, String str2, String str3, boolean z, String str4, String str5) {
            this(str, str2, str3, z, str4, -1);
            this.contentTitle = str5;
        }

        public Asset(String str, String str2, String str3, boolean z, String str4, int i) {
            int i2 = f3326a;
            this.f3327b = i2;
            this.uri = str;
            this.name = str3;
            this.isLive = z;
            this.protocol = str2;
            this.contentType = str4;
            this.contentTitle = str3;
            this.contentDuration = i;
            f3326a = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String a() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return "";
            }
            Iterator it2 = Collections.list(networkInterfaces).iterator();
            while (it2.hasNext()) {
                for (InetAddress inetAddress : Collections.list(((NetworkInterface) it2.next()).getInetAddresses())) {
                    if (!inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress()) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
            return "";
        } catch (Exception e) {
            Log.e("Utils", "Could not obtain Device IP address: " + e.toString());
            return "";
        }
    }

    /* loaded from: classes.dex */
    public static class AgamaConf {

        /* renamed from: a, reason: collision with root package name */
        private String f3322a;

        /* renamed from: b, reason: collision with root package name */
        private String f3323b;

        /* renamed from: c, reason: collision with root package name */
        private String f3324c;

        /* renamed from: d, reason: collision with root package name */
        private String f3325d;
        private String e;

        public AgamaConf(String str, String str2, String str3, String str4, String str5) {
            this.f3322a = str;
            this.f3323b = str2;
            this.f3324c = str3;
            this.f3325d = str4;
            this.e = str5;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public String a() {
            return "agg_server_host=" + this.f3322a + ";agg_server_port=" + this.f3323b + ";report_interval=" + this.f3325d + ";id_report_interval=" + this.e + ";operator_id=" + this.f3324c + ";";
        }

        public String getAggHost() {
            return this.f3322a;
        }

        public String getAggPort() {
            return this.f3323b;
        }

        public void setAggHost(String str) {
            this.f3322a = str;
        }

        public void setAggPort(String str) {
            this.f3323b = str;
        }

        public AgamaConf(AgamaConf agamaConf) {
            this(agamaConf.f3322a, agamaConf.f3323b, agamaConf.f3324c, agamaConf.f3325d, agamaConf.e);
        }
    }
}
