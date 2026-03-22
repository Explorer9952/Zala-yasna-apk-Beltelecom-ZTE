package com.google.vr.cardboard;

import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.net.Uri;
import android.os.RemoteException;
import android.util.Log;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.vr.vrcore.proto.nano.Nfc;
import com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice;
import com.google.vrtoolkit.cardboard.proto.nano.Phone;

/* loaded from: classes.dex */
public class ContentProviderVrParamsProvider implements VrParamsProvider {
    private static final String TAG = "ContentProviderVrParamsProvider";
    private final ContentProviderClient client;
    private final Uri deviceParamsSettingUri;
    private final Uri nfcParamsSettingUri;
    private final Uri phoneParamsSettingUri;

    public ContentProviderVrParamsProvider(ContentProviderClient contentProviderClient, String str) {
        if (contentProviderClient == null) {
            throw new IllegalArgumentException("ContentProviderClient must not be null");
        }
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Authority key must be non-null and non-empty");
        }
        this.client = contentProviderClient;
        this.deviceParamsSettingUri = VrSettingsProviderContract.createUri(str, VrSettingsProviderContract.DEVICE_PARAMS_SETTING);
        this.phoneParamsSettingUri = VrSettingsProviderContract.createUri(str, VrSettingsProviderContract.PHONE_PARAMS_SETTING);
        this.nfcParamsSettingUri = VrSettingsProviderContract.createUri(str, VrSettingsProviderContract.NFC_PARAMS_SETTING);
    }

    private MessageNano readParams(Class cls, Uri uri) {
        try {
            Cursor query = this.client.query(uri, null, null, null, null);
            if (query != null && query.moveToFirst()) {
                byte[] blob = query.getBlob(0);
                if (blob == null) {
                    return null;
                }
                return MessageNano.mergeFrom((MessageNano) cls.newInstance(), blob);
            }
            String str = TAG;
            String valueOf = String.valueOf(uri);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 50);
            sb.append("Invalid params result from ContentProvider query: ");
            sb.append(valueOf);
            Log.e(str, sb.toString());
            return null;
        } catch (CursorIndexOutOfBoundsException | RemoteException | InvalidProtocolBufferNanoException | IllegalAccessException | IllegalArgumentException | InstantiationException e) {
            Log.e(TAG, "Error reading params from ContentProvider", e);
            return null;
        }
    }

    @Override // com.google.vr.cardboard.VrParamsProvider
    public void close() {
        this.client.release();
    }

    @Override // com.google.vr.cardboard.VrParamsProvider
    public CardboardDevice.DeviceParams readDeviceParams() {
        return (CardboardDevice.DeviceParams) readParams(CardboardDevice.DeviceParams.class, this.deviceParamsSettingUri);
    }

    @Override // com.google.vr.cardboard.VrParamsProvider
    public Nfc.NfcParams readNfcParams() {
        return (Nfc.NfcParams) readParams(Nfc.NfcParams.class, this.nfcParamsSettingUri);
    }

    @Override // com.google.vr.cardboard.VrParamsProvider
    public Phone.PhoneParams readPhoneParams() {
        return (Phone.PhoneParams) readParams(Phone.PhoneParams.class, this.phoneParamsSettingUri);
    }

    @Override // com.google.vr.cardboard.VrParamsProvider
    public boolean writeDeviceParams(CardboardDevice.DeviceParams deviceParams) {
        String str;
        String str2;
        int update;
        try {
            if (deviceParams == null) {
                update = this.client.delete(this.deviceParamsSettingUri, null, null);
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put("value", MessageNano.toByteArray(deviceParams));
                update = this.client.update(this.deviceParamsSettingUri, contentValues, null, null);
            }
            return update > 0;
        } catch (RemoteException e) {
            e = e;
            str = TAG;
            str2 = "Failed to write device params to ContentProvider";
            Log.e(str, str2, e);
            return false;
        } catch (SecurityException e2) {
            e = e2;
            str = TAG;
            str2 = "Insufficient permissions to write device params to ContentProvider";
            Log.e(str, str2, e);
            return false;
        }
    }
}
