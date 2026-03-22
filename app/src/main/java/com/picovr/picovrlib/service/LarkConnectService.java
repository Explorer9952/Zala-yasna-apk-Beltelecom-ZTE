package com.picovr.picovrlib.service;

import android.app.Instrumentation;
import android.app.Service;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.util.Locale;

/* loaded from: classes.dex */
public class LarkConnectService extends Service {
    private static final String TAG = "LarkConnectService";
    public static boolean isStarted = false;
    LarkManager lark;
    BondReceiver mBondReceiver;
    TelephonyManager telMgr;
    private Service service = this;
    public BroadcastReceiver eventReceiver = new BroadcastReceiver() { // from class: com.picovr.picovrlib.service.LarkConnectService.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            LarkManager larkManager;
            LarkManager larkManager2;
            Log.d(LarkConnectService.TAG, "eventReceiver onReceive " + intent.getAction());
            if (intent.getAction().equals(LarkDefine.INTENT_ACTION_QUERY)) {
                LarkManager larkManager3 = LarkConnectService.this.lark;
                if (larkManager3 != null) {
                    larkManager3.queryStatus();
                    return;
                }
                return;
            }
            if (intent.getAction().equals("android.intent.action.PHONE_STATE")) {
                TelephonyManager telephonyManager = LarkConnectService.this.telMgr;
                if (telephonyManager == null || telephonyManager.getCallState() != 1 || LarkStatus.connectStatus != 2 || LarkStatus.headsetStatus == 0) {
                    return;
                }
                Intent intent2 = new Intent();
                intent2.setAction(LarkDefine.INTENT_ACTION_LARK_NO_HEADSET);
                LarkConnectService.this.service.sendBroadcast(intent2);
                new ThreadSendKeyCode(149).start();
                return;
            }
            if (intent.getAction().equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                Log.d("LarkManager", "LarkConnectService ACTION_STATE_CHANGED");
                return;
            }
            if (intent.getAction().equals("android.bluetooth.device.action.ACL_CONNECTED")) {
                Log.d("LarkManager", "ACTION_ACL_CONNECTED");
                BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (bluetoothDevice != null) {
                    Log.d("LarkManager", "ACTION_ACL_CONNECTED is " + bluetoothDevice.getName());
                    if (bluetoothDevice.getName() == null || !bluetoothDevice.getName().toUpperCase(Locale.US).contains("PICO") || bluetoothDevice.getName().toUpperCase(Locale.US).contains("HID") || (larkManager2 = LarkConnectService.this.lark) == null || LarkStatus.connectStatus == 2) {
                        return;
                    }
                    larkManager2.connect();
                    return;
                }
                return;
            }
            if (intent.getAction().equals("android.bluetooth.device.action.ACL_DISCONNECTED")) {
                Log.d("LarkManager", "LarkConnectService ACTION_ACL_DISCONNECTED");
                BluetoothDevice bluetoothDevice2 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (bluetoothDevice2 != null) {
                    Log.d("LarkManager", "ACTION_ACL_DISCONNECTED is " + bluetoothDevice2.getName());
                    if (bluetoothDevice2.getName() == null || !bluetoothDevice2.getName().toUpperCase(Locale.US).contains("PICO") || bluetoothDevice2.getName().toUpperCase(Locale.US).contains("HID") || (larkManager = LarkConnectService.this.lark) == null || LarkStatus.connectStatus == 0) {
                        return;
                    }
                    larkManager.getClass();
                    larkManager.retryCount = 3;
                    LarkConnectService.this.lark.larkHandler.sendEmptyMessage(3);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class BondReceiver extends BroadcastReceiver {
        private BondReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if (bluetoothDevice == null) {
                return;
            }
            String address = bluetoothDevice.getAddress();
            String name = bluetoothDevice.getName();
            int intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1);
            Log.d("LarkManager", "BondReceiver get onBond state " + intExtra);
            if (intExtra != 12) {
                return;
            }
            if ((name != null) && (address != null)) {
                Log.d("LarkManager", "BondReceiver get onBond mac " + address + " and name is " + bluetoothDevice.getName());
                if (!name.toUpperCase(Locale.US).contains("PICO") || bluetoothDevice.getName().toUpperCase(Locale.US).contains("HID")) {
                    return;
                }
                Log.d("LarkManager", "We get hfp bluetooth bonded, but we don't know if it's first connect or not.");
                LarkManager larkManager = LarkConnectService.this.lark;
                if (larkManager == null || LarkStatus.connectStatus == 2) {
                    return;
                }
                larkManager.connect();
            }
        }

        /* synthetic */ BondReceiver(LarkConnectService larkConnectService, BondReceiver bondReceiver) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private class ThreadSendKeyCode extends Thread {
        int mKeyCode;

        public ThreadSendKeyCode(int i) {
            this.mKeyCode = i;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                Log.d(LarkConnectService.TAG, "ThreadSendKeyCode " + this.mKeyCode);
                new Instrumentation().sendKeyDownUpSync(this.mKeyCode);
            } catch (Exception e) {
                Log.e("Exception when sendPointerSync", e.toString());
            }
            super.run();
        }
    }

    private boolean isInputDevice(BluetoothDevice bluetoothDevice) {
        Log.d(TAG, "isInputDevice?");
        int majorDeviceClass = bluetoothDevice.getBluetoothClass().getMajorDeviceClass();
        return majorDeviceClass == 1280 || majorDeviceClass == 7936;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "LarkConnectService onCreate");
        registerEventReceiver();
        LarkManager larkManager = new LarkManager(this.service);
        this.lark = larkManager;
        if (larkManager != null) {
            if (LarkStatus.connectStatus == 2) {
                if (larkManager.getBTAdapter() == null) {
                    this.lark.setBTAdapter();
                }
                this.lark.refreshBTList();
            } else {
                larkManager.connect();
            }
        }
        this.telMgr = (TelephonyManager) this.service.getSystemService("phone");
    }

    @Override // android.app.Service
    public void onDestroy() {
        Log.d(TAG, "LarkConnectService on Destroy");
        isStarted = false;
        LarkManager larkManager = this.lark;
        if (larkManager != null) {
            larkManager.cancel();
            this.lark = null;
        }
        BondReceiver bondReceiver = this.mBondReceiver;
        if (bondReceiver != null) {
            unregisterReceiver(bondReceiver);
        }
        BroadcastReceiver broadcastReceiver = this.eventReceiver;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        Log.d(TAG, "LarkConnectService onStartCommand, intent = " + intent.toString() + ", flags = " + i + ", startId = " + i2);
        isStarted = true;
        return 3;
    }

    void registerEventReceiver() {
        Log.d(TAG, "registerEventReceiver");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PHONE_STATE");
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        registerReceiver(this.eventReceiver, intentFilter);
        this.mBondReceiver = new BondReceiver(this, null);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
        registerReceiver(this.mBondReceiver, intentFilter2);
    }
}
