package com.google.vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class ControllerButtonEvent extends ControllerEvent {
    public static final int BUTTON_APP = 3;
    public static final int BUTTON_CLICK = 1;
    public static final int BUTTON_HOME = 2;
    public static final int BUTTON_NONE = 0;
    public static final int BUTTON_SYSTEM = 4;
    public static final int BUTTON_VOLUME_DOWN = 6;
    public static final int BUTTON_VOLUME_UP = 5;
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.google.vr.vrcore.controller.api.ControllerButtonEvent.1
        @Override // android.os.Parcelable.Creator
        public final ControllerButtonEvent createFromParcel(Parcel parcel) {
            return new ControllerButtonEvent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final ControllerButtonEvent[] newArray(int i) {
            return new ControllerButtonEvent[i];
        }
    };
    public int button;
    public boolean down;

    public ControllerButtonEvent() {
    }

    public ControllerButtonEvent(Parcel parcel) {
        readFromParcel(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.vr.vrcore.controller.api.ControllerEvent
    public void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.button = parcel.readInt();
        this.down = parcel.readInt() != 0;
    }

    @Override // com.google.vr.vrcore.controller.api.ControllerEvent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.button);
        parcel.writeInt(this.down ? 1 : 0);
    }
}
