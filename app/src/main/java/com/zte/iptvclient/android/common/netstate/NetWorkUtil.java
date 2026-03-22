package com.zte.iptvclient.android.common.netstate;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* loaded from: classes.dex */
public class NetWorkUtil {

    /* loaded from: classes.dex */
    public enum netType {
        wifi,
        CMNET,
        CMWAP,
        noneNet
    }

    public static netType a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return netType.noneNet;
        }
        int type = activeNetworkInfo.getType();
        if (type != 0) {
            if (type == 1) {
                return netType.wifi;
            }
            return netType.noneNet;
        }
        if (activeNetworkInfo.getExtraInfo() != null && activeNetworkInfo.getExtraInfo().toLowerCase().equals("cmnet")) {
            return netType.CMNET;
        }
        return netType.CMWAP;
    }

    public static boolean b(Context context) {
        NetworkInfo[] allNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getAllNetworkInfo();
        if (allNetworkInfo != null) {
            for (NetworkInfo networkInfo : allNetworkInfo) {
                if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean c(Context context) {
        NetworkInfo networkInfo;
        if (context == null || (networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1)) == null) {
            return false;
        }
        return networkInfo.isAvailable();
    }
}
