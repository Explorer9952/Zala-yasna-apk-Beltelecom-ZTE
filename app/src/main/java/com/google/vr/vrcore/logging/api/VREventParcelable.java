package com.google.vr.vrcore.logging.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.common.logging.nano.Vr;

/* loaded from: classes.dex */
public class VREventParcelable implements Parcelable {
    private Vr.VREvent event;
    private int eventCode;
    private static final String TAG = VREventParcelable.class.getSimpleName();
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() { // from class: com.google.vr.vrcore.logging.api.VREventParcelable.1
        @Override // android.os.Parcelable.Creator
        public final VREventParcelable createFromParcel(Parcel parcel) {
            return new VREventParcelable(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final VREventParcelable[] newArray(int i) {
            return new VREventParcelable[i];
        }
    };

    public VREventParcelable(int i, Vr.VREvent vREvent) {
        this.eventCode = i;
        this.event = vREvent;
    }

    private VREventParcelable(Parcel parcel) {
        this.eventCode = parcel.readInt();
        try {
            this.event = (Vr.VREvent) Vr.VREvent.CREATOR.createFromParcel(parcel);
        } catch (Exception e) {
            String str = TAG;
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 35);
            sb.append("Logging with empty VREvent. Error: ");
            sb.append(valueOf);
            Log.i(str, sb.toString());
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Vr.VREvent getEvent() {
        return this.event;
    }

    public int getEventCode() {
        return this.eventCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.eventCode);
        Vr.VREvent vREvent = this.event;
        if (vREvent != null) {
            vREvent.writeToParcel(parcel, i);
        }
    }
}
