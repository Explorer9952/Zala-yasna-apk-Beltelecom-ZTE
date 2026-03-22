package com.zte.fragmentlib.anim;

import android.os.Parcel;
import android.os.Parcelable;
import com.zte.iptvclient.android.zala.R;

/* loaded from: classes.dex */
public class DefaultHorizontalAnimator extends FragmentAnimator implements Parcelable {
    public static final Parcelable.Creator<DefaultHorizontalAnimator> DEFAULT_CREATOR = new a();

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<DefaultHorizontalAnimator> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DefaultHorizontalAnimator createFromParcel(Parcel parcel) {
            return new DefaultHorizontalAnimator(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DefaultHorizontalAnimator[] newArray(int i) {
            return new DefaultHorizontalAnimator[i];
        }
    }

    public DefaultHorizontalAnimator() {
        this.f4050a = R.anim.h_fragment_enter;
        this.f4051b = R.anim.h_fragment_exit;
        this.f4052c = R.anim.no_anim;
        this.f4053d = R.anim.h_fragment_pop_exit;
    }

    @Override // com.zte.fragmentlib.anim.FragmentAnimator, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.zte.fragmentlib.anim.FragmentAnimator, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    protected DefaultHorizontalAnimator(Parcel parcel) {
        super(parcel);
    }
}
