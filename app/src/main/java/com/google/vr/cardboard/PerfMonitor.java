package com.google.vr.cardboard;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.vr.vrcore.base.api.VrCoreNotAvailableException;
import com.google.vr.vrcore.performance.api.IPerformanceService;
import com.google.vr.vrcore.performance.api.PerformanceServiceConsts;

/* loaded from: classes.dex */
public class PerfMonitor implements AutoCloseable {
    private static final int STATUS_CONNECTED = 2;
    private static final int STATUS_CONNECTING = 1;
    private static final int STATUS_DISCONNECTED = 0;
    private final Context context;
    private IPerformanceService perfService;
    private final Object lock = new Object();
    private int status = 1;
    private final ServiceConnection connection = new ServiceConnection() { // from class: com.google.vr.cardboard.PerfMonitor.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (PerfMonitor.this.lock) {
                PerfMonitor.this.perfService = IPerformanceService.Stub.asInterface(iBinder);
                PerfMonitor.this.status = 2;
                PerfMonitor.this.lock.notifyAll();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (PerfMonitor.this.lock) {
                PerfMonitor.this.perfService = null;
                PerfMonitor.this.status = 0;
                PerfMonitor.this.lock.notifyAll();
            }
        }
    };

    protected PerfMonitor(Context context) {
        this.context = context;
    }

    public static PerfMonitor build(Context context) {
        Intent intent = new Intent(PerformanceServiceConsts.BIND_INTENT_ACTION);
        intent.setPackage("com.google.vr.vrcore");
        PerfMonitor perfMonitor = new PerfMonitor(context);
        if (context.bindService(intent, perfMonitor.connection, 1)) {
            return perfMonitor;
        }
        return null;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.context.unbindService(this.connection);
    }

    public float queryRelativeTemperature() {
        IPerformanceService iPerformanceService;
        synchronized (this.lock) {
            iPerformanceService = this.perfService;
        }
        if (iPerformanceService == null) {
            throw new VrCoreNotAvailableException(5);
        }
        try {
            return iPerformanceService.getCurrentThrottlingRelativeTemperature();
        } catch (RemoteException unused) {
            throw new VrCoreNotAvailableException(8);
        } catch (SecurityException unused2) {
            throw new VrCoreNotAvailableException(6);
        } catch (UnsupportedOperationException unused3) {
            throw new VrCoreNotAvailableException(7);
        }
    }

    public void reportFrameDrops(long j, long j2, int i) {
        IPerformanceService iPerformanceService;
        synchronized (this.lock) {
            iPerformanceService = this.perfService;
        }
        if (iPerformanceService == null) {
            throw new VrCoreNotAvailableException(5);
        }
        try {
            iPerformanceService.reportFrameDrops(j, j2, i);
        } catch (RemoteException unused) {
            throw new VrCoreNotAvailableException(8);
        }
    }

    public void waitUntilReady(long j) {
        synchronized (this.lock) {
            if (this.status == 1) {
                this.lock.wait(j);
            }
        }
    }
}
