package com.google.vr.vrcore.controller.api;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class ControllerAccelEvent extends ControllerEvent {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.google.vr.vrcore.controller.api.ControllerAccelEvent.1
        @Override // android.os.Parcelable.Creator
        public final ControllerAccelEvent createFromParcel(Parcel parcel) {
            return new ControllerAccelEvent(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final ControllerAccelEvent[] newArray(int i) {
            return new ControllerAccelEvent[i];
        }
    };
    public float x;
    public float y;
    public float z;

    public ControllerAccelEvent() {
    }

    public ControllerAccelEvent(Parcel parcel) {
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
