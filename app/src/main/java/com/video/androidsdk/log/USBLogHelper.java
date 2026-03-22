package com.video.androidsdk.log;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.storage.StorageManager;
import android.support.v4.media.session.PlaybackStateCompat;
import com.github.mjdev.libaums.UsbMassStorageDevice;
import com.github.mjdev.libaums.fs.FileSystem;
import com.github.mjdev.libaums.partition.Partition;
import com.video.androidsdk.SDKMgr;
import com.video.androidsdk.service.comm.ParamConst;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class USBLogHelper {
    private static final String FILE_NAME_DATE_FORMATE = "yyyyMMddhhmmssSSS";
    private static final String LOG_TAG = "USBLogHelper";
    public static final String PERMISSION_USB = "com.dean.promission.USB_PERMISSION";
    private HandlerThread handlerThread;
    private boolean hasBroadcast;
    private boolean isFirst;
    private WeakReference<Context> mContextWeakReference;
    private PermissionsRequestListener mListener;
    private long mLogFileSize;
    private final BroadcastReceiver mPermissionActionReceiver;
    private String mUSBFileName;
    private String mUSBLogDirName;
    private boolean mUSBRunning;
    private Handler mainHandler;
    private String mstrCmds;
    private PendingIntent pendingIntent;
    private OutputStream usbOutputStream;
    private Handler writeHandler;

    /* loaded from: classes.dex */
    private static class InnerPermissionsUtils {
        private static USBLogHelper instance = new USBLogHelper();

        private InnerPermissionsUtils() {
        }
    }

    /* loaded from: classes.dex */
    public interface PermissionsRequestListener {
        void onPermissionsReturn(String str, boolean z, String str2);
    }

    public static USBLogHelper getInstance() {
        return InnerPermissionsUtils.instance;
    }

    public static FileSystem otgGet(Context context) {
        UsbMassStorageDevice[] massStorageDevices = UsbMassStorageDevice.getMassStorageDevices(context);
        LogEx.d(LOG_TAG, "device number is " + massStorageDevices.length);
        FileSystem fileSystem = null;
        for (UsbMassStorageDevice usbMassStorageDevice : massStorageDevices) {
            if (usbMassStorageDevice != null) {
                try {
                    if (usbMassStorageDevice.getUsbDevice().getDeviceProtocol() == 0) {
                        LogEx.d(LOG_TAG, "ready to init device");
                        usbMassStorageDevice.init();
                        fileSystem = ((Partition) usbMassStorageDevice.getPartitions().get(0)).getFileSystem();
                        LogEx.e("OTG", "capacity: " + fileSystem.getCapacity());
                        LogEx.e("OTG", "used space: " + fileSystem.getOccupiedSpace());
                        LogEx.e("OTG", "remain space: " + fileSystem.getFreeSpace());
                        LogEx.e("OTG", "block number: " + fileSystem.getChunkSize());
                        if (usbMassStorageDevice != null && usbMassStorageDevice.getPartitions() != null && usbMassStorageDevice.getPartitions().get(0) != null && ((Partition) usbMassStorageDevice.getPartitions().get(0)).getFileSystem() != null) {
                            LogEx.d(LOG_TAG, "otgGet device protocol is == " + usbMassStorageDevice.getUsbDevice().getDeviceProtocol() + " device name is == " + usbMassStorageDevice.getUsbDevice().getDeviceName());
                        }
                        LogEx.d(LOG_TAG, "device error");
                        return null;
                    }
                    continue;
                } catch (Exception e) {
                    LogEx.d(LOG_TAG, "error message is " + e.getMessage());
                    return null;
                }
            }
        }
        return fileSystem;
    }

    private void returnPermissionResult(String str, boolean z, String str2) {
        PermissionsRequestListener permissionsRequestListener = this.mListener;
        if (permissionsRequestListener != null) {
            permissionsRequestListener.onPermissionsReturn(str, z, str2);
        }
    }

    public void destory() {
        if (this.mContextWeakReference.get() == null) {
            return;
        }
        this.mContextWeakReference.get().unregisterReceiver(this.mPermissionActionReceiver);
        this.mListener = null;
    }

    public String[] getVolumePaths() {
        StorageManager storageManager = (StorageManager) SDKMgr.getApplicationContext().getSystemService("storage");
        try {
            Method method = StorageManager.class.getMethod("getVolumePaths", new Class[0]);
            method.setAccessible(true);
            return (String[]) method.invoke(storageManager, new Object[0]);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public void init(Context context) {
        this.mContextWeakReference = new WeakReference<>(context);
        Looper.prepare();
        this.mainHandler = new Handler();
        Looper.loop();
    }

    public void initBroadcast() {
        if (this.hasBroadcast) {
            return;
        }
        this.hasBroadcast = true;
        LogEx.d(LOG_TAG, "init broadcast, thread id is " + Thread.currentThread().getId());
        IntentFilter intentFilter = new IntentFilter(PERMISSION_USB);
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
        intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
        intentFilter.addDataScheme(ParamConst.CHANNEL_PREVUE_INFO_RSP_FILENAME);
        SDKMgr.getApplicationContext().registerReceiver(this.mPermissionActionReceiver, intentFilter);
    }

    public void requestThePermission() {
        LogEx.d(LOG_TAG, "requestThePermission thread id is " + Thread.currentThread().getId());
        if (this.isFirst) {
            this.isFirst = false;
            WeakReference<Context> weakReference = new WeakReference<>(SDKMgr.getApplicationContext());
            this.mContextWeakReference = weakReference;
            UsbManager usbManager = (UsbManager) weakReference.get().getSystemService("usb");
            SDKMgr.getApplicationContext().registerReceiver(this.mPermissionActionReceiver, new IntentFilter(PERMISSION_USB));
            this.pendingIntent = PendingIntent.getBroadcast(this.mContextWeakReference.get(), 0, new Intent(PERMISSION_USB), 0);
            for (UsbDevice usbDevice : usbManager.getDeviceList().values()) {
                if (!usbManager.hasPermission(usbDevice) && usbDevice.getDeviceProtocol() == 0 && usbDevice.getInterface(0).getInterfaceClass() == 8) {
                    usbManager.requestPermission(usbDevice, this.pendingIntent);
                    return;
                }
            }
            return;
        }
        Message message = new Message();
        message.what = 1;
        this.writeHandler.sendMessage(message);
    }

    public void setLogFileSize(long j) {
        this.mLogFileSize = j * PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID * PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
    }

    public void setRunningStatus(boolean z) {
        this.mUSBRunning = z;
    }

    public void setusbDirName(String str) {
        this.mUSBLogDirName = str;
    }

    public void setusbFileName(String str) {
        this.mUSBFileName = str;
    }

    public void start() {
        if (this.mUSBRunning) {
            LogEx.d(LOG_TAG, "can not start USB Logcat multiple consecutive times");
            return;
        }
        this.mUSBRunning = true;
        if (this.handlerThread != null) {
            return;
        }
        HandlerThread handlerThread = new HandlerThread("USBLogThread");
        this.handlerThread = handlerThread;
        handlerThread.start();
        LogEx.d(LOG_TAG, "handler thread id is " + Thread.currentThread().getId());
        this.writeHandler = new Handler(this.handlerThread.getLooper()) { // from class: com.video.androidsdk.log.USBLogHelper.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                LogEx.d(USBLogHelper.LOG_TAG, "receive message");
                USBLogHelper.this.writelog();
            }
        };
        initBroadcast();
        requestThePermission();
    }

    public void stop() {
        if (this.handlerThread != null) {
            stopWrite();
            if (Build.VERSION.SDK_INT >= 18) {
                this.handlerThread.quitSafely();
            }
            this.handlerThread = null;
        }
    }

    public void stopWrite() {
        this.mUSBRunning = false;
        OutputStream outputStream = this.usbOutputStream;
        if (outputStream != null) {
            try {
                outputStream.flush();
                this.usbOutputStream.close();
                LogEx.d(LOG_TAG, "close out stream");
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.usbOutputStream = null;
        }
        this.mUSBFileName = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x017d, code lost:
    
        r0.destroy();
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fa A[Catch: all -> 0x019a, Exception -> 0x019d, TryCatch #12 {Exception -> 0x019d, all -> 0x019a, blocks: (B:8:0x0032, B:10:0x003a, B:11:0x006c, B:14:0x008a, B:17:0x0091, B:19:0x0094, B:22:0x00be, B:23:0x00c5, B:25:0x00c8, B:27:0x00d6, B:29:0x00db, B:32:0x00de, B:38:0x00f4, B:40:0x00fa, B:42:0x0108, B:44:0x0110), top: B:7:0x0032 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0108 A[Catch: all -> 0x019a, Exception -> 0x019d, TryCatch #12 {Exception -> 0x019d, all -> 0x019a, blocks: (B:8:0x0032, B:10:0x003a, B:11:0x006c, B:14:0x008a, B:17:0x0091, B:19:0x0094, B:22:0x00be, B:23:0x00c5, B:25:0x00c8, B:27:0x00d6, B:29:0x00db, B:32:0x00de, B:38:0x00f4, B:40:0x00fa, B:42:0x0108, B:44:0x0110), top: B:7:0x0032 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0110 A[Catch: all -> 0x019a, Exception -> 0x019d, TRY_LEAVE, TryCatch #12 {Exception -> 0x019d, all -> 0x019a, blocks: (B:8:0x0032, B:10:0x003a, B:11:0x006c, B:14:0x008a, B:17:0x0091, B:19:0x0094, B:22:0x00be, B:23:0x00c5, B:25:0x00c8, B:27:0x00d6, B:29:0x00db, B:32:0x00de, B:38:0x00f4, B:40:0x00fa, B:42:0x0108, B:44:0x0110), top: B:7:0x0032 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:97:0x01c9 -> B:60:0x01cc). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void writelog() {
        /*
            Method dump skipped, instructions count: 480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.video.androidsdk.log.USBLogHelper.writelog():void");
    }

    private USBLogHelper() {
        this.mstrCmds = "logcat -v time";
        this.mLogFileSize = 52428800L;
        this.pendingIntent = null;
        this.isFirst = true;
        this.mUSBLogDirName = "zxctLog";
        this.mUSBFileName = null;
        this.usbOutputStream = null;
        this.mUSBRunning = false;
        this.hasBroadcast = false;
        this.mPermissionActionReceiver = new BroadcastReceiver() { // from class: com.video.androidsdk.log.USBLogHelper.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                LogEx.d(USBLogHelper.LOG_TAG, "receive dynamic BroadcastReceiver, thread id is " + Thread.currentThread().getId());
                String action = intent.getAction();
                if (((action.hashCode() == 217116582 && action.equals(USBLogHelper.PERMISSION_USB)) ? (char) 0 : (char) 65535) != 0) {
                    LogEx.d(USBLogHelper.LOG_TAG, "action is " + action);
                    return;
                }
                if (USBLogHelper.this.mContextWeakReference.get() == null) {
                    return;
                }
                Message message = new Message();
                message.what = 1;
                USBLogHelper.this.writeHandler.sendMessage(message);
            }
        };
    }
}
