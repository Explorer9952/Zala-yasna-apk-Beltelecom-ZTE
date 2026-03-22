package com.video.androidsdk.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.log.LogEx;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;

/* loaded from: classes.dex */
public class ClientNetworkInfo {
    private static final String DEFAULT_LOACL_IP = "0.0.0.0";
    private static final String LOG_TAG = "ClientNetworkInfo";

    private static String convertToMac(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            byte b2 = bArr[i];
            if (b2 >= 0 && b2 < 16) {
                sb.append("0" + Integer.toHexString(b2));
            } else if (b2 >= 16) {
                sb.append(Integer.toHexString(b2));
            } else {
                sb.append(Integer.toHexString(b2 + 256));
            }
            if (i != bArr.length - 1) {
                sb.append(":");
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
    
        r0.add(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0031, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x0009, code lost:
    
        if (r1 != null) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000f, code lost:
    
        if (r1.hasMoreElements() == false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0011, code lost:
    
        r2 = r1.nextElement().getInetAddresses();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001f, code lost:
    
        if (r2.hasMoreElements() == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0021, code lost:
    
        r3 = r2.nextElement();
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002b, code lost:
    
        if (r3.isLoopbackAddress() != false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.List<java.net.InetAddress> getLocalIPAddresses() throws java.net.SocketException {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Enumeration r1 = java.net.NetworkInterface.getNetworkInterfaces()
            if (r1 == 0) goto L31
        Lb:
            boolean r2 = r1.hasMoreElements()
            if (r2 == 0) goto L31
            java.lang.Object r2 = r1.nextElement()
            java.net.NetworkInterface r2 = (java.net.NetworkInterface) r2
            java.util.Enumeration r2 = r2.getInetAddresses()
        L1b:
            boolean r3 = r2.hasMoreElements()
            if (r3 == 0) goto Lb
            java.lang.Object r3 = r2.nextElement()
            java.net.InetAddress r3 = (java.net.InetAddress) r3
            boolean r4 = r3.isLoopbackAddress()
            if (r4 != 0) goto L1b
            r0.add(r3)
            goto L1b
        L31:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.video.androidsdk.common.ClientNetworkInfo.getLocalIPAddresses():java.util.List");
    }

    public static String getMacAddressByEthernet() {
        Enumeration<NetworkInterface> networkInterfaces;
        StringBuilder sb = new StringBuilder();
        try {
            networkInterfaces = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        if (networkInterfaces == null) {
            LogEx.w(LOG_TAG, "localEnumeration is null");
            return "";
        }
        while (true) {
            if (!networkInterfaces.hasMoreElements()) {
                break;
            }
            NetworkInterface nextElement = networkInterfaces.nextElement();
            String displayName = nextElement.getDisplayName();
            if (displayName != null && displayName.equals("eth0")) {
                sb.append(convertToMac(nextElement.getHardwareAddress()));
                if (sb.toString().startsWith("0:")) {
                    sb.insert(0, "0");
                }
            }
        }
        return sb.toString();
    }

    public static String getMacAddressByWifi(WifiManager wifiManager) {
        if (wifiManager == null) {
            LogEx.w(LOG_TAG, "WifiManager is null!");
            return "";
        }
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo == null) {
            return "";
        }
        String macAddress = connectionInfo.getMacAddress();
        if (!StringUtil.isEmptyString(macAddress) || wifiManager.isWifiEnabled()) {
            return macAddress;
        }
        wifiManager.setWifiEnabled(true);
        String macAddress2 = connectionInfo.getMacAddress();
        wifiManager.setWifiEnabled(false);
        return macAddress2;
    }

    public static Object getStaticProperty(String str, String str2) throws Exception {
        Class<?> cls = Class.forName(str);
        return cls.getField(str2).get(cls);
    }

    public static boolean isCableNetworkAvailable(ConnectivityManager connectivityManager) {
        if (connectivityManager == null) {
            LogEx.w(LOG_TAG, "ConnectivityManager is null. Cablenetwork  Unavailabel");
            return false;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo != null) {
            for (int i = 0; i < allNetworkInfo.length; i++) {
                if (allNetworkInfo[i].getState() == NetworkInfo.State.CONNECTED && (allNetworkInfo[i].getType() == 9 || isPPPOEType(allNetworkInfo[i].getType()))) {
                    LogEx.i(LOG_TAG, "Cablenetwork Available");
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isNetworkAvailable(ConnectivityManager connectivityManager) {
        if (connectivityManager == null) {
            LogEx.w(LOG_TAG, "ConnectivityManager is null. NetWork Unavailabel");
            return false;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo != null) {
            for (NetworkInfo networkInfo : allNetworkInfo) {
                if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    LogEx.i(LOG_TAG, "NetWork Available");
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isPPPOEType(int i) {
        Integer num = 15;
        try {
            num = (Integer) getStaticProperty("android.net.ConnectivityManager", "TYPE_PPPOE");
        } catch (Exception e) {
            e.printStackTrace();
            LogEx.e("getStaticProperty Exception", e.toString());
        }
        return i == num.intValue();
    }

    public static boolean isWifiNetworkAvailable(ConnectivityManager connectivityManager) {
        if (connectivityManager == null) {
            LogEx.w(LOG_TAG, "ConnectivityManager is null. NetWork Unavailabel");
            return false;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo != null) {
            for (int i = 0; i < allNetworkInfo.length; i++) {
                if (allNetworkInfo[i].getState() == NetworkInfo.State.CONNECTED && allNetworkInfo[i].getType() == 1) {
                    LogEx.i(LOG_TAG, "Wifi NetWork Available");
                    return true;
                }
            }
        }
        return false;
    }

    public int checkNetworkInfo(ConnectivityManager connectivityManager) {
        if (connectivityManager == null) {
            LogEx.d(LOG_TAG, "ConnectivityManager is null. NetWork Unavailabel");
            return -1;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    public String getLocalIP(WifiManager wifiManager) {
        if (wifiManager != null && wifiManager.isWifiEnabled()) {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            int ipAddress = connectionInfo != null ? connectionInfo.getIpAddress() : 0;
            return (ipAddress & 255) + "." + ((ipAddress >> 8) & 255) + "." + ((ipAddress >> 16) & 255) + "." + ((ipAddress >> 24) & 255);
        }
        LogEx.w(LOG_TAG, "WifiManager is null or not available");
        return DEFAULT_LOACL_IP;
    }

    public String getLocalIPAddress() throws SocketException {
        List<InetAddress> localIPAddresses = getLocalIPAddresses();
        for (InetAddress inetAddress : localIPAddresses) {
            if (inetAddress instanceof Inet4Address) {
                return inetAddress.getHostAddress();
            }
        }
        for (InetAddress inetAddress2 : localIPAddresses) {
            if (inetAddress2 instanceof Inet6Address) {
                return inetAddress2.getHostAddress();
            }
        }
        return DEFAULT_LOACL_IP;
    }

    public static String getMacAddressByWifi(Context context) {
        return getMacAddressByWifi((WifiManager) context.getSystemService("wifi"));
    }
}
