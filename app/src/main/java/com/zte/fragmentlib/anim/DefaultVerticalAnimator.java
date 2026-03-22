package com.zte.fragmentlib.anim;

import android.os.Parcel;
import android.os.Parcelable;
import com.zte.iptvclient.android.zala.R;

/* loaded from: classes.dex */
public class DefaultVerticalAnimator extends FragmentAnimator implements Parcelable {
    public static final Parcelable.Creator<DefaultVerticalAnimator> DEFAULT_VERTICAL_ANIMATOR_CREATOR = new a();

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<DefaultVerticalAnimator> {
        a() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DefaultVerticalAnimator createFromParcel(Parcel parcel) {
            return new DefaultVerticalAnimator(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DefaultVerticalAnimator[] newArray(int i) {
            return new DefaultVerticalAnimator[i];
        }
    }

    public DefaultVerticalAnimator() {
        this.f4050a = R.anim.v_fragment_enter;
        this.f4051b = R.anim.v_fragment_exit;
        this.f4052c = R.anim.v_fragment_pop_enter;
        this.f4053d = R.anim.v_fragment_pop_exit;
    }

    @Override // com.zte.fragmentlib.anim.FragmentAnimator, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.zte.fragmentlib.anim.FragmentAnimator, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    protected DefaultVerticalAnimator(Parcel parcel) {
        super(parcel);
    }
}
