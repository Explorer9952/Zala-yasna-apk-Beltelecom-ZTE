package com.google.vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class ControllerGyroEvent extends ControllerEvent {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.google.vr.vrcore.controller.api.ControllerGyroEvent.1
        @Override // android.os.Parcelable.Creator
        public final ControllerGyroEvent createFromParcel(Parcel parcel) {
            return new ControllerGyroEvent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final ControllerGyroEvent[] newArray(int i) {
            return new ControllerGyroEvent[i];
        }
    };
    public float x;
    public float y;
    public float z;

    public ControllerGyroEvent() {
    }

    public ControllerGyroEvent(Parcel parcel) {
        readFromParcel(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.vr.vrcore.controller.api.ControllerEvent
    public void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.x = parcel.readFloat();
        this.y = parcel.readFloat();
        this.z = parcel.readFloat();
    }

    @Override // com.google.vr.vrcore.controller.api.ControllerEvent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.x);
        parcel.writeFloat(this.y);
        parcel.writeFloat(this.z);
    }
}
