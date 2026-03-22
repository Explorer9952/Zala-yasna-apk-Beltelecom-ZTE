package com.picovr.picovrlib.ble;

import android.app.Instrumentation;
import android.app.Service;
import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.picovr.picovrlib.VrActivity;
import com.picovr.picovrlib.service.MacFormat;
import com.unity3d.player.UnityPlayer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes.dex */
public class BluetoothLeService extends Service {
    public static final String ACION_BLE_DEVICE_INFO = "com.picovr.wing.ble.broadcast.device.info";
    public static final String ACION_BLE_OTA_FAILED = "com.picovr.wing.ble.broadcast.ota.fail";
    public static final String ACION_BLE_OTA_LOW_BATTERY = "com.picovr.wing.ble.broadcast.ota.low.battery";
    public static final String ACION_BLE_OTA_NOT_RESPONSE = "com.picovr.wing.ble.broadcast.ota.notresponse";
    public static final String ACION_BLE_OTA_SUCCESS = "com.picovr.wing.ble.broadcast.ota.success";
    public static final String ACION_BLE_OTA_UPGRADE_PROGRES = "com.picovr.wing.ble.broadcast.otaupgrade.progress";
    public static final String ACION_BLE_STOP_FAILED = "com.picovr.wing.ble.broadcast.stop.a2dp.fail";
    public static final String ACION_LARK_BLE_DEVICE_VERSION = "com.picovr.wing.ble.broadcast.lark.ble.device.version";
    public static final String ACTION_BLE_CONNECTED = "com.picovr.wing.ble.broadcast.connected";
    public static final String ACTION_BLE_DEVICEREADY = "com.picovr.picovrlib.ble.broadcast.deviceready";
    public static final String ACTION_BLE_DISCONNECTED = "com.picovr.wing.ble.broadcast.disconnected";
    public static final String ACTION_BLE_TIMEOUT = "com.picovr.wing.ble.broadcast.timeout";
    public static final String ACTION_BLE_WING_DEVICE = "com.picovr.picovrlib.ble.wing.device";
    public static final int CONNECTE_FAILED = 3;
    public static final int CONNECTE_SUCCESS = 1;
    public static final int DISCONNECTE = 2;
    private static final int MSG_CONNECT_TIMEOUT = 1024;
    private static final int MSG_OTA = 111;
    private static final int MSG_OTA_NOT_RESPONSE = 112;
    private static final int MSG_RESTART_SCAN = 113;
    public static final int NO_DEVICE = 4;
    private static final String OTA_FILE_PATH = "/picovr/ota.bin";
    public static final int SERVICE_STARTED = 0;
    public static final int STATE_CONNECTED = 2;
    public static final int STATE_CONNECTING = 1;
    public static final int STATE_DISCONNECTED = 0;
    public static final int STATE_SCANING = 1;
    public static final int STATE_SCAN_STOPED = 0;
    private static final String TAG = "BLE";
    private static long currentTime = 0;
    public static boolean isBleConnected = false;
    private static long lastTime;
    public static Context mContext;
    private Handler handler;
    private BluetoothAdapter mBluetoothAdapter;
    private String mBluetoothDeviceAddress;
    private BluetoothGatt mBluetoothGatt;
    private BluetoothManager mBluetoothManager;
    private String mDeviceName;
    private DeviceScan mDeviceScan;
    private ArrayList<BluetoothDevice> mLeDevices;
    private BluetoothGattCharacteristic txCharacteristic;
    private int mConnectionState = 0;
    private int mScanState = 0;
    private String mVersion = "unknown";
    private boolean isDisconnectA2dp = false;
    private long otaStartTime = 0;
    private int fileLength = 0;
    private int fileCheckSum = 0;
    private final int SEND_TIME_INTERVAL = 30;
    private Queue<byte[]> writeQueue = new ConcurrentLinkedQueue();
    private boolean isWriting = false;
    private int reSendCnt = 0;
    private boolean isDoingOTA = false;
    private boolean isAppStart = false;
    private byte[] audioMacAddr = null;
    private final IBinder mBinder = new LocalBinder();
    private final BluetoothGattCallback mGattCallback = new BluetoothGattCallback() { // from class: com.picovr.picovrlib.ble.BluetoothLeService.1
        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            LarkAction action;
            Log.d(BluetoothLeService.TAG, "onCharacteristicChanged");
            if (!bluetoothGattCharacteristic.getUuid().equals(UUID.fromString(BleConst.UUID_RX_CHARACTERISTIC)) || (action = LarkAcionAnalyse.getAction(bluetoothGattCharacteristic.getValue())) == null) {
                return;
            }
            BluetoothLeService.this.doAction(action);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            Log.d(BluetoothLeService.TAG, "onCharacteristicRead");
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            Log.d(BluetoothLeService.TAG, "onCharacteristicWrite");
            BluetoothLeService.this.isWriting = false;
            BluetoothLeService.this.nextWrite();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            Log.d(BluetoothLeService.TAG, "onConnectionStateChange");
            BluetoothLeService.this.clearWriteQueue();
            if (i2 == 2) {
                Log.i(BluetoothLeService.TAG, "Connected to GATT server.");
                Log.d(BluetoothLeService.TAG, "connect to " + BluetoothLeService.this.mDeviceName + " " + BluetoothLeService.this.mBluetoothDeviceAddress);
                if (BluetoothLeService.this.mConnectionState != 2) {
                    BluetoothLeService.this.mConnectionState = 2;
                    BluetoothLeService.this.handler.removeMessages(1024);
                    BluetoothLeService bluetoothLeService = BluetoothLeService.this;
                    bluetoothLeService.broadCastSaveDevice(BluetoothLeService.ACTION_BLE_CONNECTED, bluetoothLeService.mBluetoothDeviceAddress);
                    BluetoothLeService.this.scanBleDevice(false);
                }
                bluetoothGatt.discoverServices();
                LarkStatus.connectStatus = 2;
                BluetoothLeService.this.updateLarkStatus("larkStatus", 2);
                return;
            }
            if (i2 == 0) {
                String str = VrActivity.unityObjectName;
                if (str != null && !str.equals("")) {
                    UnityPlayer.UnitySendMessage(VrActivity.unityObjectName, "BLEStatusCallback", Integer.toString(2));
                }
                Log.i(BluetoothLeService.TAG, "Disconnected from GATT server.");
                if (BluetoothLeService.this.mConnectionState != 0) {
                    BluetoothLeService.this.mConnectionState = 0;
                    BluetoothLeService.isBleConnected = false;
                    BluetoothLeService.this.broadCastUpdate(BluetoothLeService.ACTION_BLE_DISCONNECTED);
                }
                if (BluetoothLeService.this.isDoingOTA) {
                    BluetoothLeService.this.stopOTAProcess();
                }
                LarkStatus.connectStatus = 0;
                BluetoothLeService.this.updateLarkStatus("larkStatus", 0);
                Log.i(BluetoothLeService.TAG, "Disconnected from GATT server.");
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            Log.d(BluetoothLeService.TAG, "onDescriptorWrite");
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            Log.d(BluetoothLeService.TAG, "onServicesDiscovered");
            if (i == 0) {
                if (bluetoothGatt.getServices() == null) {
                    return;
                }
                BluetoothLeService.isBleConnected = true;
                String str = VrActivity.unityObjectName;
                if (str != null && !str.equals("")) {
                    UnityPlayer.UnitySendMessage(VrActivity.unityObjectName, "BLEStatusCallback", Integer.toString(1));
                }
                BluetoothGattService service = BluetoothLeService.this.mBluetoothGatt.getService(UUID.fromString(BleConst.UUID_NORDIC_UART_SERVICE));
                if (service != null) {
                    BluetoothGattCharacteristic characteristic = service.getCharacteristic(UUID.fromString(BleConst.UUID_RX_CHARACTERISTIC));
                    if (characteristic != null) {
                        BluetoothGattDescriptor descriptor = characteristic.getDescriptor(UUID.fromString(BleConst.UUID_RX_CHARACTERISTIC_DESCRIPTOR));
                        bluetoothGatt.setCharacteristicNotification(characteristic, true);
                        if (descriptor != null) {
                            descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                            bluetoothGatt.writeDescriptor(descriptor);
                        }
                    }
                    BluetoothLeService.this.txCharacteristic = service.getCharacteristic(UUID.fromString(BleConst.UUID_TX_CHARACTERISTIC));
                    if (BluetoothLeService.this.txCharacteristic != null) {
                        BluetoothLeService.this.handler.postDelayed(new Runnable() { // from class: com.picovr.picovrlib.ble.BluetoothLeService.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                byte[] bArr = new byte[8];
                                bArr[0] = 83;
                                bArr[1] = 17;
                                BluetoothLeService.this.writeValues(bArr);
                            }
                        }, 1000L);
                        BluetoothLeService.this.handler.postDelayed(new Runnable() { // from class: com.picovr.picovrlib.ble.BluetoothLeService.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                byte[] bArr = new byte[8];
                                bArr[0] = 80;
                                bArr[1] = 17;
                                BluetoothLeService.this.writeValues(bArr);
                            }
                        }, 2000L);
                        BluetoothLeService.this.handler.postDelayed(new Runnable() { // from class: com.picovr.picovrlib.ble.BluetoothLeService.1.3
                            @Override // java.lang.Runnable
                            public void run() {
                                byte[] bArr = new byte[8];
                                bArr[0] = 82;
                                bArr[1] = 17;
                                BluetoothLeService.this.writeValues(bArr);
                            }
                        }, 3000L);
                        return;
                    }
                    return;
                }
                return;
            }
            String str2 = VrActivity.unityObjectName;
            if (str2 != null && !str2.equals("")) {
                UnityPlayer.UnitySendMessage(VrActivity.unityObjectName, "BLEStatusCallback", Integer.toString(3));
            }
            BluetoothLeService.isBleConnected = false;
            Log.w(BluetoothLeService.TAG, "onServicesDiscovered received: " + i);
        }
    };
    private BluetoothAdapter.LeScanCallback mLeScanCallback = new BluetoothAdapter.LeScanCallback() { // from class: com.picovr.picovrlib.ble.BluetoothLeService.2
        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            if (bluetoothDevice.getName() != null) {
                if (bluetoothDevice.getName().toUpperCase(Locale.US).contains("PICO") && !bluetoothDevice.getName().toUpperCase(Locale.US).contains("HID")) {
                    Log.d(BluetoothLeService.TAG, "deviceName = " + bluetoothDevice.getName());
                    BluetoothLeService.this.broadCastDeviceInfo(bluetoothDevice.getName(), bluetoothDevice.getAddress());
                }
            }
        }
    };
    private BroadcastReceiver bluetoothReceiver = new BroadcastReceiver() { // from class: com.picovr.picovrlib.ble.BluetoothLeService.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.bluetooth.device.action.BOND_STATE_CHANGED")) {
                BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                String name = bluetoothDevice.getName();
                if (name == null || !name.toLowerCase(Locale.CHINA).contains("pico")) {
                    return;
                }
                int intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1);
                if (intExtra == 10) {
                    Log.d(BluetoothLeService.TAG, String.valueOf(name) + " UNBONDED");
                    return;
                } else {
                    if (intExtra != 12) {
                        return;
                    }
                    Log.d(BluetoothLeService.TAG, String.valueOf(name) + " BONDED");
                    BluetoothLeService.this.autoConnectA2dp(bluetoothDevice);
                    return;
                }
            }
            if (intent.getAction().equals("android.bluetooth.device.action.ACL_CONNECTED")) {
                Log.d(BluetoothLeService.TAG, "ACTION_ACL_CONNECTED");
                BluetoothDevice bluetoothDevice2 = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (bluetoothDevice2 == null || !bluetoothDevice2.getAddress().equals(MacFormat.byte2String(BluetoothLeService.this.audioMacAddr)) || BluetoothLeService.this.mConnectionState == 2 || BluetoothLeService.this.mBluetoothDeviceAddress == null) {
                    return;
                }
                Log.d(BluetoothLeService.TAG, BluetoothLeService.TAG);
                BluetoothLeService bluetoothLeService = BluetoothLeService.this;
                bluetoothLeService.connect(bluetoothLeService.mBluetoothDeviceAddress);
            }
        }
    };
    private BroadcastReceiver bleReceiver = new BroadcastReceiver() { // from class: com.picovr.picovrlib.ble.BluetoothLeService.4
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction() != null) {
                if (intent.getAction().equals(BluetoothLeService.ACTION_BLE_DEVICEREADY)) {
                    if (BluetoothLeService.this.mConnectionState != 0 || intent == null) {
                        return;
                    }
                    String stringExtra = intent.getStringExtra("DeviceMacAddr");
                    Log.d(BluetoothLeService.TAG, "DeviceMacAddr = " + stringExtra);
                    if (stringExtra == null || !BluetoothLeService.this.isAppStart) {
                        return;
                    }
                    BluetoothLeService.this.connect(stringExtra);
                    return;
                }
                if (intent.getAction().equals(BluetoothLeService.ACTION_BLE_WING_DEVICE) && BluetoothLeService.this.mConnectionState == 0 && intent != null) {
                    String stringExtra2 = intent.getStringExtra("DeviceMacAddr");
                    Log.d(BluetoothLeService.TAG, "DeviceMacAddr = " + stringExtra2);
                    if (stringExtra2 == null || BluetoothLeService.this.isAppStart) {
                        return;
                    }
                    BluetoothLeService.this.connect(stringExtra2);
                }
            }
        }
    };

    /* loaded from: classes.dex */
    public class LocalBinder extends Binder {
        public LocalBinder() {
        }

        public BluetoothLeService getService() {
            return BluetoothLeService.this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ThreadSendKeyCode extends Thread {
        int mKeyCode;

        public ThreadSendKeyCode(int i) {
            this.mKeyCode = i;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                new Instrumentation().sendKeyDownUpSync(this.mKeyCode);
            } catch (Exception e) {
                Log.e("Exception when sendPointerSync", e.toString());
            }
            super.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void autoConnectA2dp(final BluetoothDevice bluetoothDevice) {
        BluetoothAdapter.getDefaultAdapter().getProfileProxy(this, new BluetoothProfile.ServiceListener() { // from class: com.picovr.picovrlib.ble.BluetoothLeService.7
            @Override // android.bluetooth.BluetoothProfile.ServiceListener
            public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
                try {
                    Log.d(BluetoothLeService.TAG, "a2dp onServiceConnected");
                    if (((BluetoothA2dp) bluetoothProfile).getConnectionState(bluetoothDevice) == 0) {
                        BluetoothA2dp.class.getDeclaredMethod("connect", BluetoothDevice.class).invoke(bluetoothProfile, bluetoothDevice);
                        BluetoothLeService.this.autoConnectHfp(bluetoothDevice);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e2) {
                    e2.printStackTrace();
                } catch (InvocationTargetException e3) {
                    e3.printStackTrace();
                }
            }

            @Override // android.bluetooth.BluetoothProfile.ServiceListener
            public void onServiceDisconnected(int i) {
                Log.d(BluetoothLeService.TAG, "a2dp onServiceDisconnected");
            }
        }, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void autoConnectHfp(final BluetoothDevice bluetoothDevice) {
        BluetoothAdapter.getDefaultAdapter().getProfileProxy(this, new BluetoothProfile.ServiceListener() { // from class: com.picovr.picovrlib.ble.BluetoothLeService.9
            @Override // android.bluetooth.BluetoothProfile.ServiceListener
            public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
                try {
                    Log.d(BluetoothLeService.TAG, "hfp onServiceConnected");
                    BluetoothHeadset.class.getDeclaredMethod("connect", BluetoothDevice.class).invoke(bluetoothProfile, bluetoothDevice);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e2) {
                    e2.printStackTrace();
                } catch (InvocationTargetException e3) {
                    e3.printStackTrace();
                }
            }

            @Override // android.bluetooth.BluetoothProfile.ServiceListener
            public void onServiceDisconnected(int i) {
                Log.d(BluetoothLeService.TAG, "hfp onServiceDisconnected");
            }
        }, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void broadCastDeviceInfo(String str, String str2) {
        Intent intent = new Intent(ACION_BLE_DEVICE_INFO);
        intent.putExtra("DeviceName", str);
        intent.putExtra("DeviceMac", str2);
        sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void broadCastOtaUpgradeProgress(int i) {
        Intent intent = new Intent(ACION_BLE_OTA_UPGRADE_PROGRES);
        intent.putExtra("progress", i);
        sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void broadCastSaveDevice(String str, String str2) {
        Intent intent = new Intent(str);
        intent.putExtra("connected_device_mac", str2);
        sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void broadCastUpdate(String str) {
        sendBroadcast(new Intent(str));
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0047: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:45:0x0047 */
    private int[] caluclateFileInfo(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileInputStream fileInputStream3 = null;
        try {
        } catch (Throwable th) {
            th = th;
            fileInputStream3 = fileInputStream;
        }
        try {
            try {
                fileInputStream2 = new FileInputStream(file);
                int i = 0;
                int i2 = 0;
                while (true) {
                    try {
                        int read = fileInputStream2.read();
                        if (read == -1) {
                            break;
                        }
                        i++;
                        i2 += read;
                    } catch (FileNotFoundException e) {
                        e = e;
                        e.printStackTrace();
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        return null;
                    } catch (IOException unused) {
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        return null;
                    }
                }
                int[] iArr = {i, ((i2 ^ (-1)) + 1) & 255};
                try {
                    fileInputStream2.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return iArr;
            } catch (IOException e3) {
                e3.printStackTrace();
                return null;
            }
        } catch (FileNotFoundException e4) {
            e = e4;
            fileInputStream2 = null;
        } catch (IOException unused2) {
            fileInputStream2 = null;
        } catch (Throwable th2) {
            th = th2;
            if (fileInputStream3 != null) {
                try {
                    fileInputStream3.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWriteQueue() {
        this.writeQueue.clear();
        this.isWriting = false;
    }

    private void connectAudioBluetooth(byte[] bArr) {
        String byte2String;
        if (bArr == null || (byte2String = MacFormat.byte2String(bArr)) == null) {
            return;
        }
        Log.d(TAG, "audioMac = " + byte2String);
        BluetoothDevice remoteDevice = BluetoothAdapter.getDefaultAdapter().getRemoteDevice(byte2String);
        if (remoteDevice != null && remoteDevice.getBondState() == 12) {
            Log.d(TAG, "audioMac");
            autoConnectA2dp(remoteDevice);
        } else {
            Log.d(TAG, "");
            BluetoothUtils.pair(byte2String);
        }
    }

    private byte[] copyBytes(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = bArr[i];
        }
        return bArr2;
    }

    private void disConnectA2dp(final BluetoothDevice bluetoothDevice) {
        BluetoothAdapter.getDefaultAdapter().getProfileProxy(this, new BluetoothProfile.ServiceListener() { // from class: com.picovr.picovrlib.ble.BluetoothLeService.8
            @Override // android.bluetooth.BluetoothProfile.ServiceListener
            public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
                try {
                    if (((BluetoothA2dp) bluetoothProfile).getConnectionState(bluetoothDevice) == 2) {
                        BluetoothA2dp.class.getDeclaredMethod("disconnect", BluetoothDevice.class).invoke(bluetoothProfile, bluetoothDevice);
                        Log.d(BluetoothLeService.TAG, "invoke disconnect2222222222222");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e2) {
                    e2.printStackTrace();
                } catch (InvocationTargetException e3) {
                    e3.printStackTrace();
                }
            }

            @Override // android.bluetooth.BluetoothProfile.ServiceListener
            public void onServiceDisconnected(int i) {
                Log.d(BluetoothLeService.TAG, "a2dp onServiceDisconnected");
            }
        }, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doAction(LarkAction larkAction) {
        Intent intent = new Intent();
        Intent intent2 = new Intent();
        Intent intent3 = new Intent();
        Log.d(TAG, "action = " + larkAction.action);
        switch (larkAction.action) {
            case 1:
                new ThreadSendKeyCode(96).start();
                return;
            case 2:
                new ThreadSendKeyCode(19).start();
                return;
            case 3:
                new ThreadSendKeyCode(20).start();
                return;
            case 4:
                new ThreadSendKeyCode(21).start();
                return;
            case 5:
                new ThreadSendKeyCode(22).start();
                return;
            case 6:
                new ThreadSendKeyCode(4).start();
                return;
            case 7:
                new ThreadSendKeyCode(82).start();
                return;
            case 8:
                connectAudioBluetooth(larkAction.mac);
                this.audioMacAddr = larkAction.mac;
                return;
            case 9:
                LarkStatus.hfpVolume = larkAction.data;
                LarkStatus.a2dpVolume = larkAction.extra;
                intent.setAction(LarkDefine.INTENT_ACTION_VOLUME);
                intent.putExtra("hfpVolume", LarkStatus.hfpVolume);
                intent.putExtra("a2dpVolume", LarkStatus.a2dpVolume);
                sendBroadcast(intent);
                updateLarkStatus("hfpVolume", LarkStatus.hfpVolume);
                updateLarkStatus("a2dpVolume", LarkStatus.a2dpVolume);
                return;
            case 10:
                new ThreadSendKeyCode(146).start();
                return;
            case 11:
                if (LarkStatus.headsetStatus != 0) {
                    LarkStatus.headsetStatus = 0;
                    updateLarkStatus("headset", 0);
                    new ThreadSendKeyCode(147).start();
                }
                intent2.setAction(LarkDefine.INTENT_ACTION_LARK_STATUS);
                intent2.putExtra("headset", LarkStatus.headsetStatus);
                sendBroadcast(intent2);
                return;
            case 12:
                if (LarkStatus.headsetStatus != 1) {
                    LarkStatus.headsetStatus = 1;
                    updateLarkStatus("headset", 1);
                    new ThreadSendKeyCode(148).start();
                }
                intent2.setAction(LarkDefine.INTENT_ACTION_LARK_STATUS);
                intent2.putExtra("headset", LarkStatus.headsetStatus);
                sendBroadcast(intent2);
                return;
            case 13:
                if (LarkStatus.psensorStatus != 0) {
                    LarkStatus.psensorStatus = 0;
                    intent.setAction(LarkDefine.INTENT_ACTION_SENSOR);
                    intent.putExtra("status", 0);
                    sendBroadcast(intent);
                    updateLarkStatus("psensor", LarkStatus.psensorStatus);
                    new ThreadSendKeyCode(151).start();
                }
                intent3.setAction(LarkDefine.INTENT_ACTION_LARK_STATUS);
                intent3.putExtra("psensor", LarkStatus.psensorStatus);
                sendBroadcast(intent3);
                return;
            case 14:
                if (LarkStatus.psensorStatus != 1) {
                    LarkStatus.psensorStatus = 1;
                    intent.setAction(LarkDefine.INTENT_ACTION_SENSOR);
                    intent.putExtra("status", 1);
                    sendBroadcast(intent);
                    updateLarkStatus("psensor", LarkStatus.psensorStatus);
                    new ThreadSendKeyCode(152).start();
                }
                intent3.setAction(LarkDefine.INTENT_ACTION_LARK_STATUS);
                intent3.putExtra("psensor", LarkStatus.psensorStatus);
                sendBroadcast(intent3);
                return;
            case 15:
                if (LarkStatus.psensorStatus != 9) {
                    LarkStatus.psensorStatus = 9;
                    intent.setAction(LarkDefine.INTENT_ACTION_SENSOR);
                    intent.putExtra("status", 9);
                    sendBroadcast(intent);
                    updateLarkStatus("psensor", LarkStatus.psensorStatus);
                    new ThreadSendKeyCode(153).start();
                }
                intent3.setAction(LarkDefine.INTENT_ACTION_LARK_STATUS);
                intent3.putExtra("psensor", LarkStatus.psensorStatus);
                sendBroadcast(intent3);
                return;
            case 16:
                updateLarkStatus("bleVersion", larkAction.version);
                setLarkBleBleVersion(larkAction.version);
                intent2.setAction(ACION_LARK_BLE_DEVICE_VERSION);
                intent2.putExtra("lark_ble_version", larkAction.version);
                sendBroadcast(intent2);
                return;
            case 17:
            case 25:
            case 26:
            case 27:
            default:
                return;
            case 18:
                this.handler.removeMessages(112);
                if (this.isDoingOTA) {
                    return;
                }
                this.isDoingOTA = true;
                doOTA();
                return;
            case 19:
                this.handler.removeMessages(112);
                broadCastUpdate(ACION_BLE_OTA_LOW_BATTERY);
                return;
            case 20:
                int i = this.reSendCnt + 1;
                this.reSendCnt = i;
                if (i <= 3) {
                    Log.d(TAG, "浠庣\ue0c7 " + larkAction.packetNum + " 涓\ue045暟鎹\ue1bc寘寮�鍙戝彂閫�");
                    this.handler.removeMessages(111);
                    sendFromNum(larkAction.packetNum);
                    return;
                }
                stopOTAProcess();
                broadCastUpdate(ACION_BLE_OTA_FAILED);
                return;
            case 21:
                resetOTAState();
                this.handler.removeMessages(112);
                broadCastUpdate(ACION_BLE_OTA_FAILED);
                sendOTAFinishAck();
                return;
            case 22:
                resetOTAState();
                this.handler.removeMessages(112);
                System.currentTimeMillis();
                broadCastUpdate(ACION_BLE_OTA_SUCCESS);
                sendOTAFinishAck();
                return;
            case 23:
                resetOTAState();
                return;
            case 24:
                resetOTAState();
                this.handler.removeMessages(112);
                broadCastUpdate(ACION_BLE_OTA_FAILED);
                return;
            case 28:
                broadCastUpdate(ACION_BLE_STOP_FAILED);
                return;
        }
    }

    private void doWrite(byte[] bArr) {
        BluetoothGattCharacteristic bluetoothGattCharacteristic;
        if (bArr != null && this.mBluetoothGatt != null && (bluetoothGattCharacteristic = this.txCharacteristic) != null) {
            bluetoothGattCharacteristic.setValue(bArr);
            this.isWriting = true;
            if (this.mBluetoothGatt.writeCharacteristic(this.txCharacteristic)) {
                return;
            }
            Log.d(TAG, "writeCharacteristic failed");
            return;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void nextWrite() {
        if (!this.writeQueue.isEmpty() && !this.isWriting) {
            doWrite(this.writeQueue.poll());
        }
    }

    private void resetOTAState() {
        this.isDoingOTA = false;
        this.reSendCnt = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0101 -> B:16:0x0104). Please report as a decompilation issue!!! */
    private void sendFromNum(int i) {
        FileInputStream fileInputStream;
        Log.d(TAG, "sendFromNum " + i);
        File file = new File(Environment.getExternalStorageDirectory() + OTA_FILE_PATH);
        if (file.exists()) {
            Log.d(TAG, "鍗囩骇鏂囦欢璺\ue21a緞 " + file.getAbsolutePath());
            byte[] bArr = new byte[20];
            bArr[0] = 86;
            FileInputStream fileInputStream2 = null;
            FileInputStream fileInputStream3 = null;
            fileInputStream2 = null;
            try {
                try {
                    try {
                        fileInputStream = new FileInputStream(file);
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (IOException e) {
                    e = e;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                fileInputStream2 = fileInputStream2;
            }
            try {
                fileInputStream.skip(i * 16);
                int i2 = 1;
                while (true) {
                    int read = fileInputStream.read(bArr, 3, 16);
                    if (read == -1) {
                        break;
                    }
                    bArr[2] = (byte) (i & 255);
                    bArr[1] = (byte) ((i >> 8) & 255);
                    int i3 = bArr[0] + bArr[1] + bArr[2];
                    for (int i4 = 3; i4 <= read + 2; i4++) {
                        i3 += bArr[i4];
                    }
                    if (read < 16) {
                        for (int i5 = read + 3; i5 <= 18; i5++) {
                            bArr[i5] = 0;
                        }
                    }
                    bArr[19] = (byte) (((i3 ^ (-1)) + 1) & 255);
                    byte[] copyBytes = copyBytes(bArr);
                    Message obtainMessage = this.handler.obtainMessage();
                    obtainMessage.what = 111;
                    obtainMessage.arg1 = i;
                    obtainMessage.obj = copyBytes;
                    this.handler.sendMessageDelayed(obtainMessage, i2 * 30);
                    i2++;
                    i++;
                }
                byte[] bArr2 = new byte[8];
                bArr2[0] = 85;
                bArr2[1] = 34;
                bArr2[2] = (byte) this.fileCheckSum;
                Message obtainMessage2 = this.handler.obtainMessage();
                obtainMessage2.what = 111;
                obtainMessage2.obj = bArr2;
                obtainMessage2.arg1 = -100;
                long j = i2 * 30;
                this.handler.sendMessageDelayed(obtainMessage2, j);
                fileInputStream.close();
                fileInputStream2 = j;
            } catch (IOException e3) {
                e = e3;
                fileInputStream3 = fileInputStream;
                e.printStackTrace();
                fileInputStream2 = fileInputStream3;
                if (fileInputStream3 != null) {
                    fileInputStream3.close();
                    fileInputStream2 = fileInputStream3;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }

    private void sendOTAFinishAck() {
        this.handler.postDelayed(new Runnable() { // from class: com.picovr.picovrlib.ble.BluetoothLeService.6
            @Override // java.lang.Runnable
            public void run() {
                BluetoothLeService bluetoothLeService = BluetoothLeService.this;
                byte[] bArr = new byte[8];
                bArr[0] = 85;
                bArr[1] = 68;
                bluetoothLeService.writeValues(bArr);
            }
        }, 100L);
    }

    private void unPairAudioBluetooth() {
        BluetoothDevice remoteDevice;
        if (this.audioMacAddr == null || (remoteDevice = BluetoothAdapter.getDefaultAdapter().getRemoteDevice(this.audioMacAddr)) == null || remoteDevice.getBondState() != 12) {
            return;
        }
        try {
            BluetoothUtils.removeBond(remoteDevice.getClass(), remoteDevice);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void writeValues(byte[] bArr) {
        if (this.writeQueue.isEmpty() && !this.isWriting) {
            doWrite(bArr);
        } else {
            this.writeQueue.add(bArr);
        }
    }

    public void close() {
        BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
        if (bluetoothGatt == null) {
            return;
        }
        bluetoothGatt.close();
        this.mBluetoothGatt = null;
    }

    public boolean connect(String str) {
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        if (bluetoothAdapter != null && str != null) {
            BluetoothDevice remoteDevice = bluetoothAdapter.getRemoteDevice(str);
            if (remoteDevice == null) {
                Log.w(TAG, "Device not found.  Unable to connect.");
                return false;
            }
            this.handler.sendEmptyMessageDelayed(1024, 20000L);
            this.mBluetoothDeviceAddress = null;
            disconnect();
            this.mBluetoothGatt = remoteDevice.connectGatt(this, false, this.mGattCallback);
            this.mBluetoothDeviceAddress = str;
            this.mDeviceName = remoteDevice.getName();
            this.mConnectionState = 1;
            LarkStatus.connectStatus = 1;
            updateLarkStatus("larkStatus", 1);
            return true;
        }
        Log.w(TAG, "BluetoothAdapter not initialized or unspecified address.");
        return false;
    }

    public void disconnect() {
        BluetoothGatt bluetoothGatt;
        if (this.mBluetoothAdapter != null && (bluetoothGatt = this.mBluetoothGatt) != null) {
            bluetoothGatt.disconnect();
        } else {
            Log.w(TAG, "BluetoothAdapter not initialized");
        }
    }

    public void doOTA() {
        Log.d("ble", "doOTA");
        this.isDoingOTA = true;
        File file = new File(Environment.getExternalStorageDirectory() + OTA_FILE_PATH);
        if (file.exists()) {
            Log.d(TAG, "鍗囩骇鏂囦欢璺\ue21a緞 " + file.getAbsolutePath());
            int[] caluclateFileInfo = caluclateFileInfo(file);
            if (caluclateFileInfo != null && caluclateFileInfo.length == 2) {
                this.fileLength = caluclateFileInfo[0];
                this.fileCheckSum = caluclateFileInfo[1];
                sendFromNum(0);
                return;
            }
            Log.d(TAG, "鑾峰彇鏂囦欢淇℃伅澶辫触");
        }
    }

    public int getConnectionState() {
        return this.mConnectionState;
    }

    public String getLarkBleVersion() {
        return this.mVersion;
    }

    public List<BluetoothGattService> getSupportedGattServices() {
        BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
        if (bluetoothGatt == null) {
            return null;
        }
        return bluetoothGatt.getServices();
    }

    public boolean initialize() {
        if (this.mBluetoothManager == null) {
            BluetoothManager bluetoothManager = (BluetoothManager) getSystemService("bluetooth");
            this.mBluetoothManager = bluetoothManager;
            if (bluetoothManager == null) {
                Log.e(TAG, "Unable to initialize BluetoothManager.");
                return false;
            }
        }
        BluetoothAdapter adapter = this.mBluetoothManager.getAdapter();
        this.mBluetoothAdapter = adapter;
        if (adapter != null) {
            return true;
        }
        Log.e(TAG, "Unable to obtain a BluetoothAdapter.");
        return false;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "ble service onCreate");
        this.handler = new Handler(getMainLooper()) { // from class: com.picovr.picovrlib.ble.BluetoothLeService.5
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i != 1024) {
                    switch (i) {
                        case 111:
                            BluetoothLeService.this.writeValues((byte[]) message.obj);
                            int i2 = message.arg1;
                            Log.d(BluetoothLeService.TAG, "num " + i2);
                            if (i2 > 0) {
                                double d2 = i2 * 100;
                                double d3 = BluetoothLeService.this.fileLength;
                                Double.isNaN(d3);
                                double ceil = Math.ceil(d3 / 16.0d);
                                Double.isNaN(d2);
                                BluetoothLeService.this.broadCastOtaUpgradeProgress((int) (d2 / ceil));
                            }
                            if (message.arg1 == -100) {
                                BluetoothLeService.this.handler.removeMessages(112);
                                BluetoothLeService.this.handler.sendEmptyMessageDelayed(112, DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
                                return;
                            }
                            return;
                        case 112:
                            BluetoothLeService.this.stopOTAProcess();
                            BluetoothLeService.this.broadCastUpdate(BluetoothLeService.ACION_BLE_OTA_NOT_RESPONSE);
                            return;
                        case 113:
                            BluetoothLeService.this.scanBleDevice(true);
                            return;
                        default:
                            return;
                    }
                }
                BluetoothLeService.this.disconnect();
                if (BluetoothLeService.this.mConnectionState != 0) {
                    BluetoothLeService.this.mConnectionState = 0;
                    BluetoothLeService.isBleConnected = false;
                    BluetoothLeService.this.broadCastUpdate(BluetoothLeService.ACTION_BLE_TIMEOUT);
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        registerReceiver(this.bluetoothReceiver, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction(ACTION_BLE_DEVICEREADY);
        intentFilter2.addAction(ACTION_BLE_WING_DEVICE);
        registerReceiver(this.bleReceiver, intentFilter2);
        initialize();
        mContext = this;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        BroadcastReceiver broadcastReceiver = this.bluetoothReceiver;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
            this.bluetoothReceiver = null;
        }
        BroadcastReceiver broadcastReceiver2 = this.bleReceiver;
        if (broadcastReceiver2 != null) {
            unregisterReceiver(broadcastReceiver2);
            this.bleReceiver = null;
        }
        this.mDeviceScan.Destroy();
        this.mDeviceScan = null;
        mContext = null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        Log.d(TAG, "onStartCommand " + this.mConnectionState);
        if (intent != null && mContext != null) {
            boolean z = false;
            if (intent.hasExtra("app")) {
                this.isAppStart = true;
                String str = VrActivity.unityObjectName;
                if (str != null && !str.equals("")) {
                    UnityPlayer.UnitySendMessage(VrActivity.unityObjectName, "BLEStatusCallback", Integer.toString(0));
                }
                DeviceScan deviceScan = new DeviceScan(mContext);
                this.mDeviceScan = deviceScan;
                deviceScan.scanLeDevice(true);
            } else if (intent.hasExtra("ble_mac_addr")) {
                String stringExtra = intent.getStringExtra("ble_mac_addr");
                boolean z2 = (stringExtra == null || stringExtra.equals(this.mBluetoothDeviceAddress)) ? false : true;
                if (stringExtra != null && stringExtra.equals(this.mBluetoothDeviceAddress) && this.mConnectionState == 0) {
                    z = true;
                }
                if (z2 || z) {
                    connect(stringExtra);
                }
            }
        }
        return 1;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    public void readCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        BluetoothGatt bluetoothGatt;
        if (this.mBluetoothAdapter != null && (bluetoothGatt = this.mBluetoothGatt) != null) {
            bluetoothGatt.readCharacteristic(bluetoothGattCharacteristic);
        } else {
            Log.w(TAG, "BluetoothAdapter not initialized");
        }
    }

    public void scanBleDevice(boolean z) {
        if (this.mBluetoothAdapter == null) {
            Log.w(TAG, "BluetoothAdapter not initialized.");
            return;
        }
        if (z) {
            if (this.mScanState == 0) {
                Log.d(TAG, "start scanLeDevice");
                this.mBluetoothAdapter.startLeScan(this.mLeScanCallback);
                this.mScanState = 1;
                return;
            } else {
                Log.d(TAG, "reStart scanLeDevice");
                this.mBluetoothAdapter.stopLeScan(this.mLeScanCallback);
                this.mBluetoothAdapter.startLeScan(this.mLeScanCallback);
                this.mScanState = 1;
                return;
            }
        }
        if (this.mScanState == 1) {
            Log.d(TAG, "stop scanLeDevice");
            this.mBluetoothAdapter.stopLeScan(this.mLeScanCallback);
            this.mScanState = 0;
        }
    }

    public void setLarkBleBleVersion(String str) {
        this.mVersion = str;
    }

    public void startOTA() {
        Log.d(TAG, "startOTA");
        if (this.mBluetoothAdapter != null && this.mBluetoothGatt != null) {
            clearWriteQueue();
            this.otaStartTime = System.currentTimeMillis();
            byte[] bArr = new byte[8];
            bArr[0] = 85;
            bArr[1] = 17;
            writeValues(bArr);
            this.handler.removeMessages(112);
            this.handler.sendEmptyMessageDelayed(112, DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
            return;
        }
        Log.w(TAG, "BluetoothAdapter not initialized");
    }

    public void stopOTAProcess() {
        this.isDoingOTA = false;
        this.handler.removeMessages(111);
    }

    public boolean updateLarkStatus(String str, int i) {
        return false;
    }

    public boolean updateLarkStatus(String str, String str2) {
        return false;
    }
}
