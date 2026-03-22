package com.google.vr.vrcore.controller.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public interface IControllerListener extends IInterface {

    /* loaded from: classes.dex */
    public abstract class Stub extends Binder implements IControllerListener {
        private static final String DESCRIPTOR = "com.google.vr.vrcore.controller.api.IControllerListener";
        static final int TRANSACTION_deprecatedOnControllerAccelEvent = 7;
        static final int TRANSACTION_deprecatedOnControllerButtonEvent = 6;
        static final int TRANSACTION_deprecatedOnControllerButtonEventV1 = 5;
        static final int TRANSACTION_deprecatedOnControllerGyroEvent = 8;
        static final int TRANSACTION_deprecatedOnControllerOrientationEvent = 4;
        static final int TRANSACTION_deprecatedOnControllerTouchEvent = 3;
        static final int TRANSACTION_getApiVersion = 1;
        static final int TRANSACTION_getOptions = 9;
        static final int TRANSACTION_onControllerEventPacket = 10;
        static final int TRANSACTION_onControllerStateChanged = 2;

        /* loaded from: classes.dex */
        class Proxy implements IControllerListener {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.google.vr.vrcore.controller.api.IControllerListener
            public void deprecatedOnControllerAccelEvent(ControllerAccelEvent controllerAccelEvent) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (controllerAccelEvent != null) {
                        obtain.writeInt(1);
                        controllerAccelEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.vr.vrcore.controller.api.IControllerListener
            public void deprecatedOnControllerButtonEvent(ControllerButtonEvent controllerButtonEvent) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (controllerButtonEvent != null) {
                        obtain.writeInt(1);
                        controllerButtonEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.vr.vrcore.controller.api.IControllerListener
            public boolean deprecatedOnControllerButtonEventV1(ControllerButtonEvent controllerButtonEvent) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (controllerButtonEvent != null) {
                        obtain.writeInt(1);
                        controllerButtonEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.vr.vrcore.controller.api.IControllerListener
            public void deprecatedOnControllerGyroEvent(ControllerGyroEvent controllerGyroEvent) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (controllerGyroEvent != null) {
                        obtain.writeInt(1);
                        controllerGyroEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.vr.vrcore.controller.api.IControllerListener
            public void deprecatedOnControllerOrientationEvent(ControllerOrientationEvent controllerOrientationEvent) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (controllerOrientationEvent != null) {
                        obtain.writeInt(1);
                        controllerOrientationEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.vr.vrcore.controller.api.IControllerListener
            public void deprecatedOnControllerTouchEvent(ControllerTouchEvent controllerTouchEvent) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (controllerTouchEvent != null) {
                        obtain.writeInt(1);
                        controllerTouchEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.vr.vrcore.controller.api.IControllerListener
            public int getApiVersion() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.google.vr.vrcore.controller.api.IControllerListener
            public ControllerListenerOptions getOptions() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (ControllerListenerOptions) ControllerListenerOptions.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.google.vr.vrcore.controller.api.IControllerListener
            public void onControllerEventPacket(ControllerEventPacket controllerEventPacket) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (controllerEventPacket != null) {
                        obtain.writeInt(1);
                        controllerEventPacket.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(10, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.google.vr.vrcore.controller.api.IControllerListener
            public void onControllerStateChanged(int i, int i2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IControllerListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IControllerListener)) ? new Proxy(iBinder) : (IControllerListener) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    int apiVersion = getApiVersion();
                    parcel2.writeNoException();
                    parcel2.writeInt(apiVersion);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    onControllerStateChanged(parcel.readInt(), parcel.readInt());
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    deprecatedOnControllerTouchEvent(parcel.readInt() != 0 ? (ControllerTouchEvent) ControllerTouchEvent.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    deprecatedOnControllerOrientationEvent(parcel.readInt() != 0 ? (ControllerOrientationEvent) ControllerOrientationEvent.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean deprecatedOnControllerButtonEventV1 = deprecatedOnControllerButtonEventV1(parcel.readInt() != 0 ? (ControllerButtonEvent) ControllerButtonEvent.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(deprecatedOnControllerButtonEventV1 ? 1 : 0);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    deprecatedOnControllerButtonEvent(parcel.readInt() != 0 ? (ControllerButtonEvent) ControllerButtonEvent.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    deprecatedOnControllerAccelEvent(parcel.readInt() != 0 ? (ControllerAccelEvent) ControllerAccelEvent.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    deprecatedOnControllerGyroEvent(parcel.readInt() != 0 ? (ControllerGyroEvent) ControllerGyroEvent.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    ControllerListenerOptions options = getOptions();
                    parcel2.writeNoException();
                    if (options != null) {
                        parcel2.writeInt(1);
                        options.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    onControllerEventPacket(parcel.readInt() != 0 ? (ControllerEventPacket) ControllerEventPacket.CREATOR.createFromParcel(parcel) : null);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void deprecatedOnControllerAccelEvent(ControllerAccelEvent controllerAccelEvent);

    void deprecatedOnControllerButtonEvent(ControllerButtonEvent controllerButtonEvent);

    boolean deprecatedOnControllerButtonEventV1(ControllerButtonEvent controllerButtonEvent);

    void deprecatedOnControllerGyroEvent(ControllerGyroEvent controllerGyroEvent);

    void deprecatedOnControllerOrientationEvent(ControllerOrientationEvent controllerOrientationEvent);

    void deprecatedOnControllerTouchEvent(ControllerTouchEvent controllerTouchEvent);

    int getApiVersion();

    ControllerListenerOptions getOptions();

    void onControllerEventPacket(ControllerEventPacket controllerEventPacket);

    void onControllerStateChanged(int i, int i2);
}
