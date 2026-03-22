package com.picovr.picovrlib.ble;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.util.Log;

/* loaded from: classes.dex */
public class BluetoothUtils {
    private static final String TAG = "BLE";

    public static boolean cancelBondProcess(Class<?> cls, BluetoothDevice bluetoothDevice) throws Exception {
        return ((Boolean) cls.getMethod("cancelBondProcess", new Class[0]).invoke(bluetoothDevice, new Object[0])).booleanValue();
    }

    public static boolean createBond(Class<?> cls, BluetoothDevice bluetoothDevice) throws Exception {
        return ((Boolean) cls.getMethod("createBond", new Class[0]).invoke(bluetoothDevice, new Object[0])).booleanValue();
    }

    public static boolean pair(String str) {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        defaultAdapter.cancelDiscovery();
        if (!defaultAdapter.isEnabled()) {
            defaultAdapter.enable();
        }
        if (!BluetoothAdapter.checkBluetoothAddress(str)) {
            Log.d("mylog", "invalid mac address");
        }
        BluetoothDevice remoteDevice = defaultAdapter.getRemoteDevice(str);
        if (remoteDevice.getBondState() != 12) {
            try {
                Log.d("mylog", "NOT BOND_BONDED");
                createBond(remoteDevice.getClass(), remoteDevice);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        Log.d("mylog", "HAS BOND_BONDED");
        return true;
    }

    public static boolean removeBond(Class<?> cls, BluetoothDevice bluetoothDevice) throws Exception {
        return ((Boolean) cls.getMethod("removeBond", new Class[0]).invoke(bluetoothDevice, new Object[0])).booleanValue();
    }
}
