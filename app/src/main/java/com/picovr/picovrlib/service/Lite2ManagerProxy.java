package com.picovr.picovrlib.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public class Lite2ManagerProxy implements ILite2Manager {
    private String TAG = "Lite2Manager";
    private IBinder mRemote;

    public Lite2ManagerProxy(IBinder iBinder) {
        this.mRemote = iBinder;
    }

    private int getIntDataFromRemote(int i) {
        if (this.mRemote == null) {
            return Integer.MAX_VALUE;
        }
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            this.mRemote.transact(i, obtain, obtain2, 0);
            return obtain2.readInt();
        } catch (RemoteException e) {
            e.printStackTrace();
            return Integer.MAX_VALUE;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    private int sendCommandWithIntParams(int i, int[] iArr) {
        if (this.mRemote == null) {
            return -1;
        }
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        for (int i2 : iArr) {
            try {
                try {
                    obtain.writeInt(i2);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
        this.mRemote.transact(i, obtain, null, 0);
        obtain2.readException();
        return -1;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.mRemote;
    }

    @Override // com.picovr.picovrlib.service.ILite2Manager
    public int sendMessage(int i) {
        return sendCommandWithIntParams(3, new int[]{i});
    }

    @Override // com.picovr.picovrlib.service.ILite2Manager
    public int setThreadSchedFifo(int i, int i2) {
        return sendCommandWithIntParams(2, new int[]{i, i2});
    }
}
