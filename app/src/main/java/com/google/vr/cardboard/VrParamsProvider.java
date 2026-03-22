package com.google.vr.cardboard;

import com.google.vr.vrcore.proto.nano.Nfc;
import com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice;
import com.google.vrtoolkit.cardboard.proto.nano.Phone;

/* loaded from: classes.dex */
public interface VrParamsProvider {
    void close();

    CardboardDevice.DeviceParams readDeviceParams();

    Nfc.NfcParams readNfcParams();

    Phone.PhoneParams readPhoneParams();

    boolean writeDeviceParams(CardboardDevice.DeviceParams deviceParams);
}
