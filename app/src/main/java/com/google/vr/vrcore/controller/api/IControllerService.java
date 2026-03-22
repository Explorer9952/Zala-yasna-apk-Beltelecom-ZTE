package com.google.vr.vrcore.controller.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.vr.vrcore.controller.api.IControllerListener;

/* loaded from: classes.dex */
public interface IControllerService extends IInterface {

    /* loaded from: classes.dex */
    public abstract class Stub extends Binder implements IControllerService {
        private static final String DESCRIPTOR = "com.google.vr.vrcore.controller.api.IControllerService";
        static final int TRANSACTION_initialize = 1;
        static final int TRANSACTION_recenter = 4;
        static final int TRANSACTION_registerListener = 5;
        static final int TRANSACTION_unregisterListener = 6;

        /* loaded from: classes.dex */
        class Proxy implements IControllerService {
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

            @Override // com.google.vr.vrcore.controller.api.IControllerService
            public int initialize(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.vr.vrcore.controller.api.IControllerService
            public void recenter(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.vr.vrcore.controller.api.IControllerService
            public boolean registerListener(int i, String str, IControllerListener iControllerListener) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iControllerListener != null ? iControllerListener.asBinder() : null);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.vr.vrcore.controller.api.IControllerService
            public boolean unregisterListener(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IControllerService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IControllerService)) ? new Proxy(iBinder) : (IControllerService) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                int initialize = initialize(parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(initialize);
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface(DESCRIPTOR);
                recenter(parcel.readInt());
                parcel2.writeNoException();
                return true;
            }
            if (i == 5) {
                parcel.enforceInterface(DESCRIPTOR);
                boolean registerListener = registerListener(parcel.readInt(), parcel.readString(), IControllerListener.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeInt(registerListener ? 1 : 0);
                return true;
            }
            if (i != 6) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(DESCRIPTOR);
            boolean unregisterListener = unregisterListener(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeInt(unregisterListener ? 1 : 0);
            return true;
        }
    }

    int initialize(int i);

    void recenter(int i);

    boolean registerListener(int i, String str, IControllerListener iControllerListener);

    boolean unregisterListener(String str);
}
