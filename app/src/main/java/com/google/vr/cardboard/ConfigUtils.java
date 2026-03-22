package com.google.vr.cardboard;

import android.net.Uri;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.vrtoolkit.cardboard.proto.nano.CardboardDevice;
import com.google.vrtoolkit.cardboard.proto.nano.Phone;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class ConfigUtils {
    public static final String CARDBOARD_CONFIG_FOLDER = "Cardboard";
    private static final String CARDBOARD_DEVICE_PARAMS_FILE = "current_device_params";
    private static final int CARDBOARD_DEVICE_PARAMS_STREAM_SENTINEL = 894990891;
    private static final String CARDBOARD_PHONE_PARAMS_FILE = "phone_params";
    private static final int CARDBOARD_PHONE_PARAMS_STREAM_SENTINEL = 779508118;
    private static final boolean DEBUG = false;
    private static final String TAG = "ConfigUtils";
    public static final String URI_KEY_PARAMS = "p";

    private static File getConfigFile(String str) {
        File file = new File(Environment.getExternalStorageDirectory(), CARDBOARD_CONFIG_FOLDER);
        if (!file.exists()) {
            file.mkdirs();
        } else if (!file.isDirectory()) {
            String valueOf = String.valueOf(file);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 61);
            sb.append(valueOf);
            sb.append(" already exists as a file, but is expected to be a directory.");
            throw new IllegalStateException(sb.toString());
        }
        return new File(file, str);
    }

    public static CardboardDevice.DeviceParams readDeviceParamsFromExternalStorage() {
        return (CardboardDevice.DeviceParams) readFromExternalStorage(CardboardDevice.DeviceParams.class, CARDBOARD_DEVICE_PARAMS_FILE, CARDBOARD_DEVICE_PARAMS_STREAM_SENTINEL, true);
    }

    public static CardboardDevice.DeviceParams readDeviceParamsFromUri(Uri uri) {
        String queryParameter = uri.getQueryParameter("p");
        if (queryParameter == null) {
            Log.w(TAG, "No Cardboard parameters in URI.");
            return null;
        }
        try {
            return (CardboardDevice.DeviceParams) MessageNano.mergeFrom(new CardboardDevice.DeviceParams(), Base64.decode(queryParameter, 11));
        } catch (Exception e) {
            String str = TAG;
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 46);
            sb.append("Parsing cardboard parameters from URI failed: ");
            sb.append(valueOf);
            Log.w(str, sb.toString());
            return null;
        }
    }

    private static MessageNano readFromExternalStorage(Class cls, String str, int i, boolean z) {
        BufferedInputStream bufferedInputStream;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(getConfigFile(str)));
                try {
                    MessageNano readFromInputStream = readFromInputStream(cls, bufferedInputStream, i);
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused) {
                    }
                    return readFromInputStream;
                } catch (Throwable th) {
                    th = th;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    try {
                        throw th;
                    } catch (FileNotFoundException e) {
                        if (z) {
                            String str2 = TAG;
                            String valueOf = String.valueOf(e);
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 39);
                            sb.append("Parameters file not found for reading: ");
                            sb.append(valueOf);
                            Log.d(str2, sb.toString());
                        }
                        return null;
                    }
                }
            } catch (IllegalStateException e2) {
                String str3 = TAG;
                String valueOf2 = String.valueOf(e2);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 26);
                sb2.append("Error reading parameters: ");
                sb2.append(valueOf2);
                Log.w(str3, sb2.toString());
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
        }
    }

    private static MessageNano readFromInputStream(Class cls, InputStream inputStream, int i) {
        String str;
        String str2;
        String valueOf;
        String str3;
        if (inputStream == null) {
            return null;
        }
        try {
            ByteBuffer allocate = ByteBuffer.allocate(8);
            if (inputStream.read(allocate.array(), 0, allocate.array().length) == -1) {
                Log.e(TAG, "Error parsing param record: end of stream.");
                return null;
            }
            int i2 = allocate.getInt();
            int i3 = allocate.getInt();
            if (i2 != i) {
                Log.e(TAG, "Error parsing param record: incorrect sentinel.");
                return null;
            }
            byte[] bArr = new byte[i3];
            if (inputStream.read(bArr, 0, i3) != -1) {
                return MessageNano.mergeFrom((MessageNano) cls.newInstance(), bArr);
            }
            Log.e(TAG, "Error parsing param record: end of stream.");
            return null;
        } catch (InvalidProtocolBufferNanoException e) {
            str = TAG;
            str2 = "Error parsing protocol buffer: ";
            valueOf = String.valueOf(e.toString());
            if (valueOf.length() == 0) {
                str3 = new String("Error parsing protocol buffer: ");
                Log.w(str, str3);
                return null;
            }
            str3 = str2.concat(valueOf);
            Log.w(str, str3);
            return null;
        } catch (IOException e2) {
            str = TAG;
            str2 = "Error reading parameters: ";
            valueOf = String.valueOf(e2.toString());
            if (valueOf.length() == 0) {
                str3 = new String("Error reading parameters: ");
                Log.w(str, str3);
                return null;
            }
            str3 = str2.concat(valueOf);
            Log.w(str, str3);
            return null;
        } catch (IllegalAccessException e3) {
            str = TAG;
            str2 = "Error accessing parameter type: ";
            valueOf = String.valueOf(e3.toString());
            if (valueOf.length() == 0) {
                str3 = new String("Error accessing parameter type: ");
                Log.w(str, str3);
                return null;
            }
            str3 = str2.concat(valueOf);
            Log.w(str, str3);
            return null;
        } catch (InstantiationException e4) {
            str = TAG;
            str2 = "Error creating parameters: ";
            valueOf = String.valueOf(e4.toString());
            if (valueOf.length() == 0) {
                str3 = new String("Error creating parameters: ");
                Log.w(str, str3);
                return null;
            }
            str3 = str2.concat(valueOf);
            Log.w(str, str3);
            return null;
        }
    }

    public static Phone.PhoneParams readPhoneParamsFromExternalStorage() {
        return (Phone.PhoneParams) readFromExternalStorage(Phone.PhoneParams.class, "phone_params", CARDBOARD_PHONE_PARAMS_STREAM_SENTINEL, false);
    }

    public static boolean removeDeviceParamsFromExternalStorage() {
        boolean z;
        try {
            File configFile = getConfigFile(CARDBOARD_DEVICE_PARAMS_FILE);
            z = configFile.exists() ? configFile.delete() : true;
        } catch (IllegalStateException e) {
            String str = TAG;
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 34);
            sb.append("Error clearing device parameters: ");
            sb.append(valueOf);
            Log.w(str, sb.toString());
            z = false;
        }
        if (!z) {
            Log.e(TAG, "Could not clear Cardboard parameters from external storage.");
        }
        return z;
    }

    public static boolean writeDeviceParamsToExternalStorage(CardboardDevice.DeviceParams deviceParams) {
        boolean writeToExternalStorage = writeToExternalStorage(deviceParams, CARDBOARD_DEVICE_PARAMS_FILE, CARDBOARD_DEVICE_PARAMS_STREAM_SENTINEL);
        if (!writeToExternalStorage) {
            Log.e(TAG, "Could not write Cardboard parameters to external storage.");
        }
        return writeToExternalStorage;
    }

    public static boolean writePhoneParamsToExternalStorage(Phone.PhoneParams phoneParams) {
        float[] fArr = phoneParams.dEPRECATEDGyroBias;
        if (fArr != null && fArr.length == 0) {
            phoneParams = phoneParams.mo6clone();
            phoneParams.dEPRECATEDGyroBias = new float[]{0.0f, 0.0f, 0.0f};
        }
        boolean writeToExternalStorage = writeToExternalStorage(phoneParams, "phone_params", CARDBOARD_PHONE_PARAMS_STREAM_SENTINEL);
        if (!writeToExternalStorage) {
            Log.e(TAG, "Could not write Phone parameters to external storage.");
        }
        return writeToExternalStorage;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0072, code lost:
    
        if (r0 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0075, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0049, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0047, code lost:
    
        if (r0 == null) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean writeToExternalStorage(com.google.protobuf.nano.MessageNano r3, java.lang.String r4, int r5) {
        /*
            r0 = 0
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L20 java.lang.IllegalStateException -> L22 java.io.FileNotFoundException -> L4d
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L20 java.lang.IllegalStateException -> L22 java.io.FileNotFoundException -> L4d
            java.io.File r4 = getConfigFile(r4)     // Catch: java.lang.Throwable -> L20 java.lang.IllegalStateException -> L22 java.io.FileNotFoundException -> L4d
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L20 java.lang.IllegalStateException -> L22 java.io.FileNotFoundException -> L4d
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L20 java.lang.IllegalStateException -> L22 java.io.FileNotFoundException -> L4d
            boolean r3 = writeToOutputStream(r3, r1, r5)     // Catch: java.lang.Throwable -> L17 java.lang.IllegalStateException -> L1a java.io.FileNotFoundException -> L1d
            r1.close()     // Catch: java.io.IOException -> L76
            goto L76
        L17:
            r3 = move-exception
            r0 = r1
            goto L77
        L1a:
            r3 = move-exception
            r0 = r1
            goto L23
        L1d:
            r3 = move-exception
            r0 = r1
            goto L4e
        L20:
            r3 = move-exception
            goto L77
        L22:
            r3 = move-exception
        L23:
            java.lang.String r4 = com.google.vr.cardboard.ConfigUtils.TAG     // Catch: java.lang.Throwable -> L20
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> L20
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L20
            java.lang.String r1 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> L20
            int r1 = r1.length()     // Catch: java.lang.Throwable -> L20
            int r1 = r1 + 26
            r5.<init>(r1)     // Catch: java.lang.Throwable -> L20
            java.lang.String r1 = "Error writing parameters: "
            r5.append(r1)     // Catch: java.lang.Throwable -> L20
            r5.append(r3)     // Catch: java.lang.Throwable -> L20
            java.lang.String r3 = r5.toString()     // Catch: java.lang.Throwable -> L20
            android.util.Log.w(r4, r3)     // Catch: java.lang.Throwable -> L20
            if (r0 == 0) goto L75
        L49:
            r0.close()     // Catch: java.io.IOException -> L75
            goto L75
        L4d:
            r3 = move-exception
        L4e:
            java.lang.String r4 = com.google.vr.cardboard.ConfigUtils.TAG     // Catch: java.lang.Throwable -> L20
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> L20
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L20
            java.lang.String r1 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> L20
            int r1 = r1.length()     // Catch: java.lang.Throwable -> L20
            int r1 = r1 + 39
            r5.<init>(r1)     // Catch: java.lang.Throwable -> L20
            java.lang.String r1 = "Parameters file not found for writing: "
            r5.append(r1)     // Catch: java.lang.Throwable -> L20
            r5.append(r3)     // Catch: java.lang.Throwable -> L20
            java.lang.String r3 = r5.toString()     // Catch: java.lang.Throwable -> L20
            android.util.Log.e(r4, r3)     // Catch: java.lang.Throwable -> L20
            if (r0 == 0) goto L75
            goto L49
        L75:
            r3 = 0
        L76:
            return r3
        L77:
            if (r0 == 0) goto L7c
            r0.close()     // Catch: java.io.IOException -> L7c
        L7c:
            goto L7e
        L7d:
            throw r3
        L7e:
            goto L7d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.vr.cardboard.ConfigUtils.writeToExternalStorage(com.google.protobuf.nano.MessageNano, java.lang.String, int):boolean");
    }

    private static boolean writeToOutputStream(MessageNano messageNano, OutputStream outputStream, int i) {
        try {
            byte[] byteArray = MessageNano.toByteArray(messageNano);
            ByteBuffer allocate = ByteBuffer.allocate(8);
            allocate.putInt(i);
            allocate.putInt(byteArray.length);
            outputStream.write(allocate.array());
            outputStream.write(byteArray);
            return true;
        } catch (IOException e) {
            String str = TAG;
            String valueOf = String.valueOf(e.toString());
            Log.w(str, valueOf.length() != 0 ? "Error writing parameters: ".concat(valueOf) : new String("Error writing parameters: "));
            return false;
        }
    }
}
