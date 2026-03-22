package com.google.vr.vrcore.logging.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public interface IVrCoreLoggingService extends IInterface {

    /* loaded from: classes.dex */
    public abstract class Stub extends Binder implements IVrCoreLoggingService {
        private static final String DESCRIPTOR = "com.google.vr.vrcore.logging.api.IVrCoreLoggingService";
        static final int TRANSACTION_log = 3;

        /* loaded from: classes.dex */
        class Proxy implements IVrCoreLoggingService {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.google.vr.vrcore.logging.api.IVrCoreLoggingService
            public void log(VREventParcelable vREventParcelable) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (vREventParcelable != null) {
                        obtain.writeInt(1);
                        vREventParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IVrCoreLoggingService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IVrCoreLoggingService)) ? new Proxy(iBinder) : (IVrCoreLoggingService) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                log(parcel.readInt() != 0 ? (VREventParcelable) VREventParcelable.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString(DESCRIPTOR);
            return true;
        }
    }

    void log(VREventParcelable vREventParcelable);
}
