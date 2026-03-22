package com.google.vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayDeque;

/* loaded from: classes.dex */
public final class ControllerEventPacket implements Parcelable {
    private static final int MAX_EVENTS = 16;
    private static final int SERIALIZED_FORMAT_VERSION = 1;
    private int accelEventCount;
    private ControllerAccelEvent[] accelEvents;
    private int buttonEventCount;
    private ControllerButtonEvent[] buttonEvents;
    private int gyroEventCount;
    private ControllerGyroEvent[] gyroEvents;
    private int orientationEventCount;
    private ControllerOrientationEvent[] orientationEvents;
    private int touchEventCount;
    private ControllerTouchEvent[] touchEvents;
    private static ArrayDeque pool = new ArrayDeque();
    private static Object poolLock = new Object();
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.google.vr.vrcore.controller.api.ControllerEventPacket.1
        @Override // android.os.Parcelable.Creator
        public final ControllerEventPacket createFromParcel(Parcel parcel) {
            ControllerEventPacket obtain = ControllerEventPacket.obtain();
            obtain.readFromParcel(parcel);
            return obtain;
        }

        @Override // android.os.Parcelable.Creator
        public final ControllerEventPacket[] newArray(int i) {
            return new ControllerEventPacket[i];
        }
    };

    public ControllerEventPacket() {
        this.accelEvents = new ControllerAccelEvent[16];
        this.buttonEvents = new ControllerButtonEvent[16];
        this.gyroEvents = new ControllerGyroEvent[16];
        this.orientationEvents = new ControllerOrientationEvent[16];
        this.touchEvents = new ControllerTouchEvent[16];
        for (int i = 0; i < 16; i++) {
            this.accelEvents[i] = new ControllerAccelEvent();
            this.buttonEvents[i] = new ControllerButtonEvent();
            this.gyroEvents[i] = new ControllerGyroEvent();
            this.orientationEvents[i] = new ControllerOrientationEvent();
            this.touchEvents[i] = new ControllerTouchEvent();
        }
        clear();
    }

    protected ControllerEventPacket(Parcel parcel) {
        this();
        readFromParcel(parcel);
    }

    private final void checkIsValidEventCount(int i) {
        if (i < 0 || i >= 16) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Invalid event count: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public static ControllerEventPacket obtain() {
        ControllerEventPacket controllerEventPacket;
        synchronized (poolLock) {
            controllerEventPacket = pool.isEmpty() ? new ControllerEventPacket() : (ControllerEventPacket) pool.remove();
        }
        return controllerEventPacket;
    }

    public final ControllerAccelEvent addAccelEvent() {
        int i = this.accelEventCount;
        if (i >= 16) {
            throw new IllegalStateException("ControllerEventPacket capacity exceeded.");
        }
        ControllerAccelEvent[] controllerAccelEventArr = this.accelEvents;
        this.accelEventCount = i + 1;
        return controllerAccelEventArr[i];
    }

    public final ControllerButtonEvent addButtonEvent() {
        int i = this.buttonEventCount;
        if (i >= 16) {
            throw new IllegalStateException("ControllerEventPacket capacity exceeded.");
        }
        ControllerButtonEvent[] controllerButtonEventArr = this.buttonEvents;
        this.buttonEventCount = i + 1;
        return controllerButtonEventArr[i];
    }

    public final ControllerGyroEvent addGyroEvent() {
        int i = this.gyroEventCount;
        if (i >= 16) {
            throw new IllegalStateException("ControllerEventPacket capacity exceeded.");
        }
        ControllerGyroEvent[] controllerGyroEventArr = this.gyroEvents;
        this.gyroEventCount = i + 1;
        return controllerGyroEventArr[i];
    }

    public final ControllerOrientationEvent addOrientationEvent() {
        int i = this.orientationEventCount;
        if (i >= 16) {
            throw new IllegalStateException("ControllerEventPacket capacity exceeded.");
        }
        ControllerOrientationEvent[] controllerOrientationEventArr = this.orientationEvents;
        this.orientationEventCount = i + 1;
        return controllerOrientationEventArr[i];
    }

    public final ControllerTouchEvent addTouchEvent() {
        int i = this.touchEventCount;
        if (i >= 16) {
            throw new IllegalStateException("ControllerEventPacket capacity exceeded.");
        }
        ControllerTouchEvent[] controllerTouchEventArr = this.touchEvents;
        this.touchEventCount = i + 1;
        return controllerTouchEventArr[i];
    }

    public final void clear() {
        this.accelEventCount = 0;
        this.buttonEventCount = 0;
        this.gyroEventCount = 0;
        this.orientationEventCount = 0;
        this.touchEventCount = 0;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final ControllerAccelEvent getAccelEvent(int i) {
        if (i < 0 || i >= this.accelEventCount) {
            throw new IndexOutOfBoundsException();
        }
        return this.accelEvents[i];
    }

    public final int getAccelEventCount() {
        return this.accelEventCount;
    }

    public final ControllerButtonEvent getButtonEvent(int i) {
        if (i < 0 || i >= this.buttonEventCount) {
            throw new IndexOutOfBoundsException();
        }
        return this.buttonEvents[i];
    }

    public final int getButtonEventCount() {
        return this.buttonEventCount;
    }

    public final ControllerGyroEvent getGyroEvent(int i) {
        if (i < 0 || i >= this.gyroEventCount) {
            throw new IndexOutOfBoundsException();
        }
        return this.gyroEvents[i];
    }

    public final int getGyroEventCount() {
        return this.gyroEventCount;
    }

    public final ControllerOrientationEvent getOrientationEvent(int i) {
        if (i < 0 || i >= this.orientationEventCount) {
            throw new IndexOutOfBoundsException();
        }
        return this.orientationEvents[i];
    }

    public final int getOrientationEventCount() {
        return this.orientationEventCount;
    }

    public final ControllerTouchEvent getTouchEvent(int i) {
        if (i < 0 || i >= this.touchEventCount) {
            throw new IndexOutOfBoundsException();
        }
        return this.touchEvents[i];
    }

    public final int getTouchEventCount() {
        return this.touchEventCount;
    }

    public final void readFromParcel(Parcel parcel) {
        parcel.readInt();
        int readInt = parcel.readInt();
        this.accelEventCount = readInt;
        checkIsValidEventCount(readInt);
        for (int i = 0; i < this.accelEventCount; i++) {
            this.accelEvents[i].readFromParcel(parcel);
        }
        int readInt2 = parcel.readInt();
        this.buttonEventCount = readInt2;
        checkIsValidEventCount(readInt2);
        for (int i2 = 0; i2 < this.buttonEventCount; i2++) {
            this.buttonEvents[i2].readFromParcel(parcel);
        }
        int readInt3 = parcel.readInt();
        this.gyroEventCount = readInt3;
        checkIsValidEventCount(readInt3);
        for (int i3 = 0; i3 < this.gyroEventCount; i3++) {
            this.gyroEvents[i3].readFromParcel(parcel);
        }
        int readInt4 = parcel.readInt();
        this.orientationEventCount = readInt4;
        checkIsValidEventCount(readInt4);
        for (int i4 = 0; i4 < this.orientationEventCount; i4++) {
            this.orientationEvents[i4].readFromParcel(parcel);
        }
        int readInt5 = parcel.readInt();
        this.touchEventCount = readInt5;
        checkIsValidEventCount(readInt5);
        for (int i5 = 0; i5 < this.touchEventCount; i5++) {
            this.touchEvents[i5].readFromParcel(parcel);
        }
    }

    public final void recycle() {
        clear();
        synchronized (poolLock) {
            if (!pool.contains(this)) {
                pool.add(this);
            }
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(1);
        parcel.writeInt(this.accelEventCount);
        for (int i2 = 0; i2 < this.accelEventCount; i2++) {
            this.accelEvents[i2].writeToParcel(parcel, i);
        }
        parcel.writeInt(this.buttonEventCount);
        for (int i3 = 0; i3 < this.buttonEventCount; i3++) {
            this.buttonEvents[i3].writeToParcel(parcel, i);
        }
        parcel.writeInt(this.gyroEventCount);
        for (int i4 = 0; i4 < this.gyroEventCount; i4++) {
            this.gyroEvents[i4].writeToParcel(parcel, i);
        }
        parcel.writeInt(this.orientationEventCount);
        for (int i5 = 0; i5 < this.orientationEventCount; i5++) {
            this.orientationEvents[i5].writeToParcel(parcel, i);
        }
        parcel.writeInt(this.touchEventCount);
        for (int i6 = 0; i6 < this.touchEventCount; i6++) {
            this.touchEvents[i6].writeToParcel(parcel, i);
        }
    }
}
