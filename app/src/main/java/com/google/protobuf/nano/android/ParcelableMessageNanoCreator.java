package com.google.protobuf.nano.android;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import java.lang.reflect.Array;

/* loaded from: classes.dex */
public final class ParcelableMessageNanoCreator implements Parcelable.Creator {
    private static final String TAG = "PMNCreator";
    private final Class mClazz;

    public ParcelableMessageNanoCreator(Class cls) {
        this.mClazz = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeToParcel(Class cls, MessageNano messageNano, Parcel parcel) {
        parcel.writeString(cls.getName());
        parcel.writeByteArray(MessageNano.toByteArray(messageNano));
    }

    @Override // android.os.Parcelable.Creator
    public final MessageNano createFromParcel(Parcel parcel) {
        String readString = parcel.readString();
        byte[] createByteArray = parcel.createByteArray();
        MessageNano messageNano = null;
        try {
            MessageNano messageNano2 = (MessageNano) Class.forName(readString).newInstance();
            try {
                MessageNano.mergeFrom(messageNano2, createByteArray);
                return messageNano2;
            } catch (InvalidProtocolBufferNanoException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                e = e;
                messageNano = messageNano2;
                Log.e(TAG, "Exception trying to create proto from parcel", e);
                return messageNano;
            }
        } catch (InvalidProtocolBufferNanoException e2) {
            e = e2;
        } catch (ClassNotFoundException e3) {
            e = e3;
        } catch (IllegalAccessException e4) {
            e = e4;
        } catch (InstantiationException e5) {
            e = e5;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final MessageNano[] newArray(int i) {
        return (MessageNano[]) Array.newInstance((Class<?>) this.mClazz, i);
    }
}
