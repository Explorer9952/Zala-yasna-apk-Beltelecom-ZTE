package com.picovr.picovrlib.service;

import android.app.Instrumentation;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.zte.ucs.tvcall.Commons;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class LarkManager {
    private static final String TAG = "LarkManager";
    private SPPConnectServer connectServer;
    BluetoothDevice hfpBT;
    public byte[] phone_mac;
    Service service;
    ThreadSendKeyCode thread;
    private BluetoothAdapter BTAdapter = BluetoothAdapter.getDefaultAdapter();
    private BluetoothProfile mBluetoothProxy = null;
    public int retryCount = 0;
    public final int retryMax = 3;
    public String bt_mac = "";
    BluetoothProfile.ServiceListener hfpListener = new BluetoothProfile.ServiceListener() { // from class: com.picovr.picovrlib.service.LarkManager.1
        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
            Log.d(LarkManager.TAG, "onServiceConnected profile = " + i);
            LarkManager.this.mBluetoothProxy = bluetoothProfile;
            Log.d(LarkManager.TAG, "mBluetoothProxy: " + LarkManager.this.mBluetoothProxy.toString());
            List<BluetoothDevice> connectedDevices = bluetoothProfile.getConnectedDevices();
            if (connectedDevices == null) {
                Log.d(LarkManager.TAG, "onServiceConnected mDevices == null");
            }
            if (connectedDevices != null && connectedDevices.size() == 0) {
                Log.d(LarkManager.TAG, "mDevices = " + connectedDevices.toString());
                Log.d(LarkManager.TAG, "onServiceConnected mDevices.size() == 0");
            }
            LarkManager.this.hfpBT = null;
            if (connectedDevices != null && connectedDevices.size() > 0) {
                Log.d(LarkManager.TAG, "mDevices = " + connectedDevices.toString());
                Iterator<BluetoothDevice> it2 = connectedDevices.iterator();
                while (true) {
                    boolean z = false;
                    if (!it2.hasNext()) {
                        break;
                    }
                    BluetoothDevice next = it2.next();
                    Log.d(LarkManager.TAG, "device name is " + next.getName());
                    Log.d(LarkManager.TAG, "device mac is " + next.getAddress());
                    String name = next.getName();
                    if (name != null) {
                        if (name.toUpperCase(Locale.US).contains("PICO") && !name.toUpperCase(Locale.US).contains("HID")) {
                            z = true;
                        }
                        if (z) {
                            LarkManager.this.hfpBT = next;
                        }
                    }
                }
                if (LarkStatus.connectStatus != 1) {
                    Log.d(LarkManager.TAG, "hfplistener LarkStatus != CONNECTING");
                    LarkManager larkManager = LarkManager.this;
                    larkManager.retryCount = 0;
                    LarkStatus.connectStatus = 1;
                    larkManager.larkHandler.sendEmptyMessage(0);
                    return;
                }
                return;
            }
            Log.d(LarkManager.TAG, "no device");
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int i) {
            Log.d(LarkManager.TAG, "onServiceDisconnected");
        }
    };
    public Handler larkHandler = new Handler() { // from class: com.picovr.picovrlib.service.LarkManager.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == -99) {
                if (LarkStatus.connectStatus == 0) {
                    if (LarkManager.this.BTAdapter == null) {
                        LarkManager.this.BTAdapter = BluetoothAdapter.getDefaultAdapter();
                    }
                    LarkManager.this.refreshBTList();
                    return;
                }
                Log.d(LarkManager.TAG, "MSG_LARK_CONNECT_REQUEST return");
                return;
            }
            if (i == -50) {
                Log.d(LarkManager.TAG, "hid MSG_LARK_HID_QUERY_ADDR");
                if (LarkManager.this.connectServer != null) {
                    LarkManager larkManager = LarkManager.this;
                    byte[] bArr = larkManager.phone_mac;
                    larkManager.connectServer.write(new byte[]{83, 0, bArr[0], bArr[1], bArr[2], bArr[3], bArr[4], bArr[5]});
                    return;
                }
                return;
            }
            if (i == 10) {
                byte[] bArr2 = (byte[]) message.obj;
                LarkManager.this.logByte(bArr2);
                LarkAction action = LarkActionAnalyse.getAction(bArr2);
                if (action != null) {
                    LarkManager.this.DoAction(action);
                    return;
                }
                return;
            }
            if (i == 20) {
                if (LarkManager.this.connectServer != null) {
                    byte[] bArr3 = new byte[8];
                    bArr3[0] = 80;
                    LarkManager.this.connectServer.write(bArr3);
                    return;
                }
                return;
            }
            if (i == 30) {
                Log.d(LarkManager.TAG, "spp MSG_LARK_COMMAND_QUERY_VERSION");
                if (LarkManager.this.connectServer != null) {
                    byte[] bArr4 = new byte[8];
                    bArr4[0] = 82;
                    LarkManager.this.connectServer.write(bArr4);
                    return;
                }
                return;
            }
            if (i == -1) {
                if (LarkStatus.connectStatus != 0) {
                    Log.d(LarkManager.TAG, "MSG_LARK_SPP_REFRESH return");
                    return;
                }
                LarkManager larkManager2 = LarkManager.this;
                larkManager2.retryCount = 3;
                if (larkManager2.hfpBT != null) {
                    larkManager2.connectServer.stop();
                    LarkManager.this.connectServer.connect(LarkManager.this.hfpBT);
                    return;
                }
                return;
            }
            if (i == 0) {
                Log.d(LarkManager.TAG, "MSG_LARK_CONNECT hfpBT = " + LarkManager.this.hfpBT);
                LarkManager larkManager3 = LarkManager.this;
                if (larkManager3.hfpBT != null) {
                    larkManager3.connectServer.stop();
                    LarkManager.this.connectServer.connect(LarkManager.this.hfpBT);
                    return;
                } else {
                    larkManager3.larkHandler.sendEmptyMessage(2);
                    return;
                }
            }
            if (i == 1) {
                LarkStatus.connectStatus = 2;
                Log.d(LarkManager.TAG, "MSG_LARK_CONNECT_SUCCESS");
                LarkManager.this.larkHandler.sendEmptyMessage(20);
                LarkManager.this.larkHandler.sendEmptyMessage(30);
                LarkManager.this.larkHandler.sendEmptyMessage(-50);
                return;
            }
            if (i == 2) {
                LarkManager.this.larkHandler.sendEmptyMessage(3);
                return;
            }
            if (i != 3) {
                return;
            }
            Log.i(LarkManager.TAG, "MSG_LARK_CONNECT_ALL_FAILURE");
            if (LarkManager.this.retryCount < 3) {
                Log.d(LarkManager.TAG, "MSG_LARK_CONNECT_ALL_FAILURE retry " + LarkManager.this.retryCount);
                LarkManager larkManager4 = LarkManager.this;
                larkManager4.retryCount = larkManager4.retryCount + 1;
                LarkStatus.connectStatus = 1;
                larkManager4.larkHandler.sendEmptyMessage(0);
                return;
            }
            LarkStatus.connectStatus = 0;
            Log.d(LarkManager.TAG, "MSG_LARK_CONNECT_ALL_FAILURE");
        }
    };

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
                Log.d(LarkManager.TAG, "ThreadSendKeyCode: " + this.mKeyCode);
                new Instrumentation().sendKeyDownUpSync(this.mKeyCode);
            } catch (Exception e) {
                Log.e("Exception when sendPointerSync", e.toString());
            }
            super.run();
        }
    }

    public LarkManager(Service service) {
        this.phone_mac = new byte[6];
        Log.d(TAG, "LarkManager constructed.");
        this.service = service;
        SPPConnectServer shareCommandServer = SPPConnectServer.shareCommandServer();
        this.connectServer = shareCommandServer;
        shareCommandServer.setConnectHandler(this.larkHandler);
        this.phone_mac = MacFormat.String2byte(this.BTAdapter.getAddress());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logByte(byte[] bArr) {
        Log.d(TAG, "logByte");
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            stringBuffer.append(String.valueOf(Integer.toHexString(b2 & 255)) + " ");
        }
        Log.i(TAG, "bytes : " + stringBuffer.toString());
    }

    public void DoAction(LarkAction larkAction) {
        Log.d(TAG, "DoAction = " + larkAction.action);
        Intent intent = new Intent();
        int i = larkAction.action;
        if (i == 30) {
            LarkStatus.hfpVolume = larkAction.data;
            LarkStatus.a2dpVolume = larkAction.extra;
            intent.setAction(LarkDefine.INTENT_ACTION_VOLUME);
            intent.putExtra("hfpVolume", LarkStatus.hfpVolume);
            intent.putExtra("a2dpVolume", LarkStatus.a2dpVolume);
            this.service.sendBroadcast(intent);
            return;
        }
        if (i == 40) {
            ThreadSendKeyCode threadSendKeyCode = new ThreadSendKeyCode(146);
            this.thread = threadSendKeyCode;
            threadSendKeyCode.start();
            return;
        }
        if (i == 70) {
            Log.d(TAG, "action ACTION_LARK_VERSION_REC");
            LarkStatus.version = larkAction.version;
            Log.d(TAG, "LARK_VERSION = " + LarkStatus.version);
            return;
        }
        if (i == 50) {
            if (LarkStatus.headsetStatus != 0) {
                LarkStatus.headsetStatus = 0;
                ThreadSendKeyCode threadSendKeyCode2 = new ThreadSendKeyCode(147);
                this.thread = threadSendKeyCode2;
                threadSendKeyCode2.start();
                return;
            }
            return;
        }
        if (i != 51) {
            switch (i) {
                case 10:
                    if (LarkStatus.psensorStatus != 0) {
                        LarkStatus.psensorStatus = 0;
                        ThreadSendKeyCode threadSendKeyCode3 = new ThreadSendKeyCode(151);
                        this.thread = threadSendKeyCode3;
                        threadSendKeyCode3.start();
                        return;
                    }
                    return;
                case 11:
                    if (LarkStatus.psensorStatus != 1) {
                        LarkStatus.psensorStatus = 1;
                        ThreadSendKeyCode threadSendKeyCode4 = new ThreadSendKeyCode(152);
                        this.thread = threadSendKeyCode4;
                        threadSendKeyCode4.start();
                        return;
                    }
                    return;
                case 12:
                    if (LarkStatus.psensorStatus != 9) {
                        LarkStatus.psensorStatus = 9;
                        ThreadSendKeyCode threadSendKeyCode5 = new ThreadSendKeyCode(153);
                        this.thread = threadSendKeyCode5;
                        threadSendKeyCode5.start();
                        return;
                    }
                    return;
                default:
                    switch (i) {
                        case 20:
                            ThreadSendKeyCode threadSendKeyCode6 = new ThreadSendKeyCode(96);
                            this.thread = threadSendKeyCode6;
                            threadSendKeyCode6.start();
                            return;
                        case 21:
                            ThreadSendKeyCode threadSendKeyCode7 = new ThreadSendKeyCode(19);
                            this.thread = threadSendKeyCode7;
                            threadSendKeyCode7.start();
                            return;
                        case 22:
                            ThreadSendKeyCode threadSendKeyCode8 = new ThreadSendKeyCode(20);
                            this.thread = threadSendKeyCode8;
                            threadSendKeyCode8.start();
                            return;
                        case 23:
                            ThreadSendKeyCode threadSendKeyCode9 = new ThreadSendKeyCode(21);
                            this.thread = threadSendKeyCode9;
                            threadSendKeyCode9.start();
                            return;
                        case 24:
                            ThreadSendKeyCode threadSendKeyCode10 = new ThreadSendKeyCode(22);
                            this.thread = threadSendKeyCode10;
                            threadSendKeyCode10.start();
                            return;
                        case 25:
                            ThreadSendKeyCode threadSendKeyCode11 = new ThreadSendKeyCode(Commons.CONTACT_REFRESH_AFTER_EDIT);
                            this.thread = threadSendKeyCode11;
                            threadSendKeyCode11.start();
                            return;
                        case 26:
                            ThreadSendKeyCode threadSendKeyCode12 = new ThreadSendKeyCode(Commons.CONTACT_REFRESH_AFTER_ADD);
                            this.thread = threadSendKeyCode12;
                            threadSendKeyCode12.start();
                            return;
                        case 27:
                            ThreadSendKeyCode threadSendKeyCode13 = new ThreadSendKeyCode(4);
                            this.thread = threadSendKeyCode13;
                            threadSendKeyCode13.start();
                            return;
                        case 28:
                            ThreadSendKeyCode threadSendKeyCode14 = new ThreadSendKeyCode(82);
                            this.thread = threadSendKeyCode14;
                            threadSendKeyCode14.start();
                            return;
                        default:
                            return;
                    }
            }
        }
        if (LarkStatus.headsetStatus != 1) {
            LarkStatus.headsetStatus = 1;
            ThreadSendKeyCode threadSendKeyCode15 = new ThreadSendKeyCode(148);
            this.thread = threadSendKeyCode15;
            threadSendKeyCode15.start();
        }
    }

    public void cancel() {
        Log.d(TAG, "cancel");
        this.BTAdapter.closeProfileProxy(1, this.mBluetoothProxy);
        this.connectServer.stop();
    }

    public void connect() {
        Log.d(TAG, "connect, and LarkConnectStatus = " + LarkStatus.connectStatus);
        if (LarkStatus.connectStatus != 0) {
            return;
        }
        this.larkHandler.sendEmptyMessage(-99);
    }

    public BluetoothAdapter getBTAdapter() {
        return this.BTAdapter;
    }

    public BluetoothProfile getBTProfile() {
        return this.mBluetoothProxy;
    }

    public SPPConnectServer getSPPConnectServer() {
        return this.connectServer;
    }

    public void queryStatus() {
        Log.d(TAG, "queryStatus");
        this.larkHandler.sendEmptyMessage(20);
    }

    public void refreshBTList() {
        Log.d(TAG, "refreshBTList");
        this.hfpBT = null;
        BluetoothAdapter bluetoothAdapter = this.BTAdapter;
        if (bluetoothAdapter == null) {
            return;
        }
        bluetoothAdapter.getProfileProxy(this.service, this.hfpListener, 1);
    }

    public void setBTAdapter() {
        this.BTAdapter = BluetoothAdapter.getDefaultAdapter();
    }
}
