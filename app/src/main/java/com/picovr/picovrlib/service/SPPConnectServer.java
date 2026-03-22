package com.picovr.picovrlib.service;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

/* loaded from: classes.dex */
public class SPPConnectServer {
    public static final int STATE_CONNECTED = 3;
    public static final int STATE_CONNECTING = 2;
    public static final int STATE_NONE = 0;
    private static final String TAG = "SPPConnectServer";
    private static SPPConnectServer self;
    private Handler mConnectHandler;
    private ConnectThread mConnectThread;
    private ConnectedThread mConnectedThread;
    public int mState = 0;
    private static final UUID MY_UUID_SECURE = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private static final UUID MY_UUID_INSECURE = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ConnectThread extends Thread {
        private final BluetoothDevice larkDevice;
        private BluetoothSocket larkSocket;

        public ConnectThread(BluetoothDevice bluetoothDevice, boolean z) {
            BluetoothSocket bluetoothSocket;
            this.larkDevice = bluetoothDevice;
            try {
                bluetoothSocket = z ? bluetoothDevice.createRfcommSocketToServiceRecord(SPPConnectServer.MY_UUID_SECURE) : bluetoothDevice.createInsecureRfcommSocketToServiceRecord(SPPConnectServer.MY_UUID_INSECURE);
            } catch (Exception e) {
                Log.w(SPPConnectServer.TAG, "Socket Type: create() failed", e);
                bluetoothSocket = null;
            }
            this.larkSocket = bluetoothSocket;
        }

        public void cancel() {
            try {
                this.larkSocket.close();
            } catch (IOException e) {
                Log.w(SPPConnectServer.TAG, "close() of connect  socket failed", e);
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Log.i(SPPConnectServer.TAG, "BEGIN mConnectThread SocketType:");
            setName("ConnectThread");
            new Thread(new Runnable() { // from class: com.picovr.picovrlib.service.SPPConnectServer.ConnectThread.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ConnectThread.this.larkSocket.connect();
                        Log.i(SPPConnectServer.TAG, "successful mConnectThread SocketType:");
                        synchronized (this) {
                            SPPConnectServer.this.mConnectThread = null;
                        }
                        if (SPPConnectServer.this.mConnectHandler != null) {
                            SPPConnectServer.this.mConnectHandler.sendEmptyMessage(1);
                        }
                        Log.i(SPPConnectServer.TAG, "handler");
                        SPPConnectServer.this.connected(ConnectThread.this.larkSocket, ConnectThread.this.larkDevice);
                    } catch (IOException e) {
                        Log.w(SPPConnectServer.TAG, "connect: ", e);
                        try {
                            ConnectThread.this.larkSocket.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                            Log.w(SPPConnectServer.TAG, "unable to close()  socket during connection failure", e2);
                        }
                        SPPConnectServer.this.connectionFailed();
                    }
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ConnectedThread extends Thread {
        private final InputStream mmInStream;
        private final OutputStream mmOutStream;
        private final BluetoothSocket mmSocket;

        public ConnectedThread(BluetoothSocket bluetoothSocket) {
            InputStream inputStream;
            Log.d(SPPConnectServer.TAG, "create ConnectedThread: ");
            this.mmSocket = bluetoothSocket;
            OutputStream outputStream = null;
            try {
                inputStream = bluetoothSocket.getInputStream();
            } catch (IOException e) {
                e = e;
                inputStream = null;
            }
            try {
                outputStream = bluetoothSocket.getOutputStream();
            } catch (IOException e2) {
                e = e2;
                Log.w(SPPConnectServer.TAG, "temp sockets not created", e);
                this.mmInStream = inputStream;
                this.mmOutStream = outputStream;
            }
            this.mmInStream = inputStream;
            this.mmOutStream = outputStream;
        }

        public void cancel() {
            try {
                this.mmSocket.close();
            } catch (IOException e) {
                Log.w(SPPConnectServer.TAG, "close() of connect socket failed", e);
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Log.i(SPPConnectServer.TAG, "BEGIN mConnectedThread");
            byte[] bArr = new byte[8];
            while (true) {
                try {
                    SPPConnectServer.this.receiveCommand(bArr, this.mmInStream.read(bArr));
                } catch (IOException unused) {
                    if (SPPConnectServer.this.mConnectHandler == null || LarkStatus.psensorStatus != 0) {
                        return;
                    }
                    SPPConnectServer.this.mConnectHandler.sendEmptyMessage(-1);
                    return;
                }
            }
        }

        public void write(byte[] bArr) {
            if (bArr == null || bArr.length == 0) {
                return;
            }
            try {
                this.mmOutStream.write(bArr);
                this.mmOutStream.flush();
            } catch (IOException e) {
                Log.w(SPPConnectServer.TAG, "Exception during write", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectionFailed() {
        Handler handler = this.mConnectHandler;
        if (handler != null) {
            handler.sendEmptyMessage(2);
        }
        stop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void receiveCommand(byte[] bArr, int i) {
        Message message = new Message();
        message.what = 10;
        message.obj = bArr;
        this.mConnectHandler.sendMessage(message);
    }

    private synchronized void setState(int i) {
        this.mState = i;
    }

    public static SPPConnectServer shareCommandServer() {
        if (self == null) {
            self = new SPPConnectServer();
        }
        return self;
    }

    public synchronized void connect(BluetoothDevice bluetoothDevice) {
        if (this.mState == 2 && this.mConnectThread != null) {
            this.mConnectThread.cancel();
            this.mConnectThread = null;
        }
        if (this.mConnectedThread != null) {
            this.mConnectedThread.cancel();
            this.mConnectedThread = null;
        }
        ConnectThread connectThread = new ConnectThread(bluetoothDevice, false);
        this.mConnectThread = connectThread;
        connectThread.start();
        setState(2);
    }

    public synchronized void connected(BluetoothSocket bluetoothSocket, BluetoothDevice bluetoothDevice) {
        if (this.mConnectThread != null) {
            this.mConnectThread.cancel();
            this.mConnectThread = null;
        }
        if (this.mConnectedThread != null) {
            this.mConnectedThread.cancel();
            this.mConnectedThread = null;
        }
        ConnectedThread connectedThread = new ConnectedThread(bluetoothSocket);
        this.mConnectedThread = connectedThread;
        connectedThread.start();
        setState(3);
    }

    public int getmState() {
        return this.mState;
    }

    public void setConnectHandler(Handler handler) {
        this.mConnectHandler = handler;
    }

    public synchronized void stop() {
        if (this.mConnectThread != null) {
            Log.d(TAG, "SPPConnectServer stop. mConnectThread = " + this.mConnectThread.toString());
            this.mConnectThread.cancel();
            this.mConnectThread = null;
        }
        if (this.mConnectedThread != null) {
            Log.d(TAG, "SPPConnectServer stop. mConnectThread = " + this.mConnectedThread.toString());
            this.mConnectedThread.cancel();
            this.mConnectedThread = null;
        }
        setState(0);
    }

    public void write(byte[] bArr) {
        synchronized (this) {
            if (this.mState == 3 && this.mConnectedThread != null) {
                this.mConnectedThread.write(bArr);
            }
        }
    }
}
