package com.picovr.picovrlib.ble;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import com.picovr.picovrlib.VrActivity;
import com.unity3d.player.UnityPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes.dex */
public class DeviceScan {
    private static final int REQUEST_ENABLE_BT = 1;
    private static final long SCAN_PERIOD = 10000;
    private static final String TAG = "BLE";
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothLeService mBluetoothLeService;
    private Context mContext;
    private Handler mHandler;
    private ArrayList<BluetoothDevice> mLeDevices;
    private BluetoothAdapter.LeScanCallback mLeScanCallback = new BluetoothAdapter.LeScanCallback() { // from class: com.picovr.picovrlib.ble.DeviceScan.1
        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            if (bluetoothDevice.getName() != null) {
                if (bluetoothDevice.getName().toUpperCase(Locale.US).contains("PICO") && !bluetoothDevice.getName().toUpperCase(Locale.US).contains("HID")) {
                    DeviceScan.this.addDevice(bluetoothDevice);
                }
            }
        }
    };
    private boolean mScanning;

    public DeviceScan(Context context) {
        Log.d(TAG, "Enter DeviceScan");
        this.mHandler = new Handler();
        this.mContext = context;
        if (context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            BluetoothAdapter adapter = ((BluetoothManager) context.getSystemService("bluetooth")).getAdapter();
            this.mBluetoothAdapter = adapter;
            if (adapter != null && adapter.isEnabled()) {
                this.mLeDevices = new ArrayList<>();
            }
        }
    }

    public void Destroy() {
        scanLeDevice(false);
        this.mLeDevices.clear();
        this.mLeDevices = null;
    }

    public void addDevice(BluetoothDevice bluetoothDevice) {
        if (this.mLeDevices.contains(bluetoothDevice)) {
            return;
        }
        this.mLeDevices.add(bluetoothDevice);
    }

    public String getBleDeviceMacaddr() {
        String readValueFromWing = SPUtils.readValueFromWing(this.mContext, "last_connect_device_mac");
        ArrayList<BluetoothDevice> arrayList = this.mLeDevices;
        String str = null;
        if (arrayList != null && arrayList.size() > 0) {
            Log.d(TAG, "mDevices = " + this.mLeDevices.toString());
            boolean z = true;
            Iterator<BluetoothDevice> it2 = this.mLeDevices.iterator();
            while (it2.hasNext()) {
                BluetoothDevice next = it2.next();
                Log.d(TAG, "device name is " + next.getName());
                Log.d(TAG, "device mac is " + next.getAddress());
                if (next.getName() != null) {
                    if (readValueFromWing == null || readValueFromWing.equalsIgnoreCase(next.getAddress())) {
                        String address = next.getAddress();
                        Intent intent = new Intent(BluetoothLeService.ACTION_BLE_DEVICEREADY);
                        intent.putExtra("DeviceMacAddr", address);
                        this.mContext.sendBroadcast(intent);
                        return address;
                    }
                    if (z) {
                        str = next.getAddress();
                        z = false;
                    }
                }
            }
            Intent intent2 = new Intent(BluetoothLeService.ACTION_BLE_DEVICEREADY);
            intent2.putExtra("DeviceMacAddr", str);
            this.mContext.sendBroadcast(intent2);
            Log.d(TAG, intent2.toURI());
            if (this.mScanning) {
                this.mBluetoothAdapter.stopLeScan(this.mLeScanCallback);
                this.mScanning = false;
            }
            return str;
        }
        Log.d(TAG, "no device");
        return null;
    }

    public BluetoothDevice getDevice(int i) {
        return this.mLeDevices.get(i);
    }

    public ArrayList<BluetoothDevice> getDevices() {
        return this.mLeDevices;
    }

    public void scanLeDevice(boolean z) {
        if (z) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.picovr.picovrlib.ble.DeviceScan.2
                @Override // java.lang.Runnable
                public void run() {
                    DeviceScan.this.mScanning = false;
                    DeviceScan.this.mBluetoothAdapter.stopLeScan(DeviceScan.this.mLeScanCallback);
                    if (DeviceScan.this.mLeDevices != null && DeviceScan.this.mLeDevices.size() > 0) {
                        DeviceScan.this.getBleDeviceMacaddr();
                    } else {
                        String str = VrActivity.unityObjectName;
                        if (str != null && !str.equals("")) {
                            UnityPlayer.UnitySendMessage(VrActivity.unityObjectName, "BLEStatusCallback", Integer.toString(4));
                        }
                    }
                    Intent intent = new Intent("com.picovr.picovrlib.ble.broadcast.devicelist");
                    intent.putExtra("DeviceList", DeviceScan.this.mLeDevices);
                    DeviceScan.this.mContext.sendBroadcast(intent);
                    Log.d(DeviceScan.TAG, intent.toURI());
                }
            }, SCAN_PERIOD);
            Log.d(TAG, "start scanLeDevice");
            this.mScanning = true;
            this.mBluetoothAdapter.startLeScan(this.mLeScanCallback);
            return;
        }
        this.mScanning = false;
        this.mBluetoothAdapter.stopLeScan(this.mLeScanCallback);
    }
}
