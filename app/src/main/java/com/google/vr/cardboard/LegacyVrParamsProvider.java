package com.google.vr.cardboard;

import com.google.vr.vrcore.proto.nano.Nfc;
import com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice;
import com.google.vrtoolkit.cardboard.proto.nano.Phone;

/* loaded from: classes.dex */
public final class LegacyVrParamsProvider implements VrParamsProvider {
    private static final String TAG = "LegacyVrParamsProvider";

    @Override // com.google.vr.cardboard.VrParamsProvider
    public final void close() {
    }

    @Override // com.google.vr.cardboard.VrParamsProvider
    public final CardboardDevice.DeviceParams readDeviceParams() {
        return ConfigUtils.readDeviceParamsFromExternalStorage();
    }

    @Override // com.google.vr.cardboard.VrParamsProvider
    public final Nfc.NfcParams readNfcParams() {
        return null;
    }

    @Override // com.google.vr.cardboard.VrParamsProvider
    public final Phone.PhoneParams readPhoneParams() {
        Phone.PhoneParams readPhoneParamsFromExternalStorage = ConfigUtils.readPhoneParamsFromExternalStorage();
        return readPhoneParamsFromExternalStorage == null ? PhoneParams.getPpiOverride() : readPhoneParamsFromExternalStorage;
    }

    @Override // com.google.vr.cardboard.VrParamsProvider
    public final boolean writeDeviceParams(CardboardDevice.DeviceParams deviceParams) {
        return deviceParams == null ? ConfigUtils.removeDeviceParamsFromExternalStorage() : ConfigUtils.writeDeviceParamsToExternalStorage(deviceParams);
    }
}
