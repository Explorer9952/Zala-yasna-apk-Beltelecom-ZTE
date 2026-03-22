package com.video.androidsdk.common.util;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import com.video.androidsdk.log.LogEx;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/* loaded from: classes.dex */
public class NetUtils {
    private static final String DEFAULT_MAC = "00-00-00-00-00-00";
    private static final String LOG_TAG = "NetUtils";

    private static String callCmd(String str, String str2) {
        String readLine;
        InputStream inputStream = null;
        try {
            try {
                inputStream = Runtime.getRuntime().exec(str).getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                SecurityUtil.securityCheck(bufferedReader.toString(), "readLine");
                do {
                    readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                } while (!readLine.contains(str2));
                if (inputStream == null) {
                    return readLine;
                }
                try {
                    inputStream.close();
                    return readLine;
                } catch (IOException e) {
                    e.printStackTrace();
                    return readLine;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                return "";
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    private static InetAddress getLocalInetAddress() {
        InetAddress inetAddress;
        SocketException e;
        Enumeration<NetworkInterface> networkInterfaces;
        try {
            networkInterfaces = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e2) {
            inetAddress = null;
            e = e2;
        }
        if (networkInterfaces == null) {
            return null;
        }
        inetAddress = null;
        while (networkInterfaces.hasMoreElements()) {
            try {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (!inetAddresses.hasMoreElements()) {
                        break;
                    }
                    InetAddress nextElement = inetAddresses.nextElement();
                    try {
                        if (!nextElement.isLoopbackAddress() && nextElement.getHostAddress().indexOf(":") == -1) {
                            inetAddress = nextElement;
                            break;
                        }
                        inetAddress = null;
                    } catch (SocketException e3) {
                        e = e3;
                        inetAddress = nextElement;
                        e.printStackTrace();
                        return inetAddress;
                    }
                }
                if (inetAddress != null) {
                    break;
                }
            } catch (SocketException e4) {
                e = e4;
            }
        }
        return inetAddress;
    }

    public static String getMacAddress(Context context) {
        WifiInfo connectionInfo;
        String macAddressByCallCmd = getMacAddressByCallCmd();
        if (macAddressByCallCmd != null) {
            LogEx.d(LOG_TAG, "getMacAddressByCallCmd:" + macAddressByCallCmd);
            if (!TextUtils.isEmpty(macAddressByCallCmd) && macAddressByCallCmd.length() < 18) {
                LogEx.d(LOG_TAG, "return mac way1:" + macAddressByCallCmd);
                return macAddressByCallCmd;
            }
        }
        if (Build.VERSION.SDK_INT < 23) {
            LogEx.d(LOG_TAG, "under 23 call api getMacAddress");
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                String macAddress = connectionInfo.getMacAddress();
                if (!TextUtils.isEmpty(macAddress)) {
                    LogEx.d(LOG_TAG, "under 23 call api getMacAddress:" + macAddress);
                    LogEx.d(LOG_TAG, "return mac way2:" + macAddress);
                    return macAddress;
                }
            }
        }
        String macAddressByLocalIP = getMacAddressByLocalIP();
        if (!TextUtils.isEmpty(macAddressByLocalIP)) {
            LogEx.d(LOG_TAG, "getMacAddressByLocalIP:" + macAddressByLocalIP);
            LogEx.d(LOG_TAG, "return mac way3:" + macAddressByLocalIP);
            return macAddressByLocalIP;
        }
        try {
            String machineHardwareAddress = getMachineHardwareAddress();
            if (!TextUtils.isEmpty(machineHardwareAddress)) {
                LogEx.d(LOG_TAG, "getMachineHardwareAddress:" + machineHardwareAddress);
                LogEx.d(LOG_TAG, "return mac way4:" + machineHardwareAddress);
                return machineHardwareAddress;
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        LogEx.d(LOG_TAG, "return mac way5:" + DEFAULT_MAC);
        return DEFAULT_MAC;
    }

    private static String getMacAddressByCallCmd() {
        String callCmd = callCmd("busybox ifconfig", "HWaddr");
        if (callCmd == null) {
            return null;
        }
        if (callCmd.length() <= 0 || !callCmd.contains("HWaddr")) {
            return callCmd;
        }
        String substring = callCmd.substring(callCmd.indexOf("HWaddr") + 6, callCmd.length() - 1);
        return substring.length() > 1 ? substring.replaceAll(" ", "") : callCmd;
    }

    private static String getMacAddressByLocalIP() {
        try {
            byte[] hardwareAddress = NetworkInterface.getByInetAddress(getLocalInetAddress()).getHardwareAddress();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < hardwareAddress.length; i++) {
                if (i != 0) {
                    stringBuffer.append(':');
                }
                String hexString = Integer.toHexString(hardwareAddress[i] & 255);
                if (hexString.length() == 1) {
                    hexString = 0 + hexString;
                }
                stringBuffer.append(hexString);
            }
            return stringBuffer.toString().toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String getMachineHardwareAddress() throws SocketException {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        LogEx.d(LOG_TAG, "interfaceName = " + networkInterfaces);
        String str = null;
        if (networkInterfaces != null) {
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                byte[] hardwareAddress = nextElement.getHardwareAddress();
                if (hardwareAddress != null && hardwareAddress.length != 0) {
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : hardwareAddress) {
                        sb.append(String.format("%02X:", Byte.valueOf(b2)));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    String sb2 = sb.toString();
                    LogEx.d(LOG_TAG, "interfaceName=" + nextElement.getName() + ", mac=" + sb2);
                    if (nextElement.getName().equals("wlan0")) {
                        str = sb2;
                    }
                }
            }
        }
        return str;
    }
}
