package com.google.vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class ControllerOrientationEvent extends ControllerEvent {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.google.vr.vrcore.controller.api.ControllerOrientationEvent.1
        @Override // android.os.Parcelable.Creator
        public final ControllerOrientationEvent createFromParcel(Parcel parcel) {
            return new ControllerOrientationEvent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final ControllerOrientationEvent[] newArray(int i) {
            return new ControllerOrientationEvent[i];
        }
    };
    public float qw;
    public float qx;
    public float qy;
    public float qz;

    public ControllerOrientationEvent() {
    }

    public ControllerOrientationEvent(Parcel parcel) {
        readFromParcel(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.vr.vrcore.controller.api.ControllerEvent
    public void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.qx = parcel.readFloat();
        this.qy = parcel.readFloat();
        this.qz = parcel.readFloat();
        this.qw = parcel.readFloat();
    }

    @Override // com.google.vr.vrcore.controller.api.ControllerEvent, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.qx);
        parcel.writeFloat(this.qy);
        parcel.writeFloat(this.qz);
        parcel.writeFloat(this.qw);
    }
}
