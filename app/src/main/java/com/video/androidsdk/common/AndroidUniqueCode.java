package com.video.androidsdk.common;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mm.sdk.platformtools.Util;
import com.video.androidsdk.common.util.NetUtils;
import com.video.androidsdk.common.util.SecurityUtil;
import com.video.androidsdk.log.LogEx;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

/* loaded from: classes.dex */
public final class AndroidUniqueCode {
    private static final String ANDROID_ID = "Androiduuid";
    private static final String LOG_TAG = "AndroidUniqueCode";
    private static final String MAC_ADDRESS = "AndroidMacAddress";
    private static final String OLD_ANDROID_ID = "AndroidId";
    private static final String STR_INVALID_ANDROID_ID = "9774d56d682e549c";
    private static final String STR_UUID = "uuid";
    private static final String UUID_FILENAME = "uuid.jpg";

    private static String genUUID(Context context) {
        PreferenceHelper preferenceHelper = new PreferenceHelper(context, "DeviceInfo");
        String serialNum = getSerialNum();
        LogEx.d(LOG_TAG, "get android id from serialnum,m_strAndroidid is  " + serialNum);
        if (TextUtils.isEmpty(serialNum)) {
            serialNum = getUUID();
            LogEx.d(LOG_TAG, "get android id from UUID,m_strAndroidid is  " + serialNum);
        }
        if (!TextUtils.isEmpty(serialNum)) {
            String str = null;
            try {
                str = AES.aesEncode(serialNum.getBytes(), Base64.decode("WlRFY2xpZW50ODkyMmExNw==", 2));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            LogEx.d(LOG_TAG, "put android id to file,m_strAndroidid is  " + str);
            preferenceHelper.putString(ANDROID_ID, str);
            writeUUID(context, str);
        }
        return serialNum;
    }

    public static String getANDROIDID(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        LogEx.d(LOG_TAG, "ANDROID_ID: " + string);
        return TextUtils.equals(string, STR_INVALID_ANDROID_ID) ? "" : string;
    }

    public static String getAndroidId(Context context) {
        String str = null;
        if (context == null) {
            LogEx.w(LOG_TAG, "null == ctx");
            return null;
        }
        PreferenceHelper preferenceHelper = new PreferenceHelper(context, "DeviceInfo");
        String string = preferenceHelper.getString(ANDROID_ID, "");
        if (TextUtils.isEmpty(string)) {
            string = preferenceHelper.getString(OLD_ANDROID_ID, "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    string = AES.aesEncode(string.getBytes(), Base64.decode("WlRFY2xpZW50ODkyMmExNw==", 2));
                    preferenceHelper.putString(ANDROID_ID, string);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        if (!TextUtils.isEmpty(string)) {
            LogEx.d(LOG_TAG, "get android id from internal file,androidid is  " + string);
            writeUUID(context, string);
            try {
                return AES.aesDecode(string, Base64.decode("WlRFY2xpZW50ODkyMmExNw==", 2));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return string;
            }
        }
        LogEx.d(LOG_TAG, "can not find uuid from internal file");
        String readUUID = readUUID(context);
        if (!TextUtils.isEmpty(readUUID)) {
            LogEx.d(LOG_TAG, "get android id from external file,androidid is  " + readUUID);
            preferenceHelper.putString(ANDROID_ID, readUUID);
            try {
                return AES.aesDecode(readUUID, Base64.decode("WlRFY2xpZW50ODkyMmExNw==", 2));
            } catch (UnsupportedEncodingException e3) {
                e3.printStackTrace();
                return readUUID;
            }
        }
        String str2 = Build.VERSION.RELEASE;
        if (str2.contains(".")) {
            str2 = str2.substring(0, str2.indexOf("."));
        }
        LogEx.d(LOG_TAG, "system version is:" + str2);
        if (Integer.parseInt(str2) < 11) {
            String readUUIDFromAndroiduuid = readUUIDFromAndroiduuid(context);
            if (TextUtils.isEmpty(readUUIDFromAndroiduuid)) {
                String readUUIDFromUUID = readUUIDFromUUID(context);
                if (TextUtils.isEmpty(readUUIDFromUUID)) {
                    return genUUID(context);
                }
                try {
                    str = AES.aesEncode(readUUIDFromUUID.getBytes(), Base64.decode("WlRFY2xpZW50ODkyMmExNw==", 2));
                } catch (UnsupportedEncodingException e4) {
                    e4.printStackTrace();
                }
                writeUUID(context, str);
                preferenceHelper.putString(ANDROID_ID, str);
                return readUUIDFromUUID;
            }
            writeUUID(context, readUUIDFromAndroiduuid);
            preferenceHelper.putString(ANDROID_ID, readUUIDFromAndroiduuid);
            try {
                return AES.aesDecode(readUUIDFromAndroiduuid, Base64.decode("WlRFY2xpZW50ODkyMmExNw==", 2));
            } catch (UnsupportedEncodingException e5) {
                e5.printStackTrace();
                return readUUIDFromAndroiduuid;
            }
        }
        return genUUID(context);
    }

    public static String getDeviceIMEI(Context context) {
        String str;
        if (context == null) {
            LogEx.w(LOG_TAG, "null== ctx");
            return "";
        }
        try {
            str = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (SecurityException e) {
            e.printStackTrace();
            str = null;
        }
        LogEx.d(LOG_TAG, "strDeviceId=" + str);
        return str;
    }

    public static String getDeviceMacAddress(Context context) {
        if (context == null) {
            LogEx.w(LOG_TAG, "null == ctx");
            return null;
        }
        PreferenceHelper preferenceHelper = new PreferenceHelper(context, "DeviceInfo");
        String string = preferenceHelper.getString(MAC_ADDRESS, "");
        if (!TextUtils.isEmpty(string)) {
            LogEx.d(LOG_TAG, "get mac from file,strMacAddress is" + string);
            return string;
        }
        String macAddress = NetUtils.getMacAddress(context);
        if (TextUtils.isEmpty(macAddress)) {
            return "00:00:00:00:00:00";
        }
        LogEx.d(LOG_TAG, "get mac from clientNetworkInfo or cmd,put to file,strMacAddress is" + macAddress);
        preferenceHelper.putString(MAC_ADDRESS, macAddress);
        return macAddress;
    }

    public static String getSDCardCachePath(Context context) {
        String str;
        if (hasExternalStorage()) {
            str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/zxct/";
        } else {
            str = context.getFilesDir().getAbsolutePath() + "/";
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static String getSDCardDcimPath(Context context) {
        String str;
        if (hasExternalStorage()) {
            str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/DCIM/";
        } else {
            str = context.getFilesDir().getAbsolutePath() + "/";
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static String getSerialNum() {
        int i = Build.VERSION.SDK_INT;
        if (i < 9 || i >= 26) {
            return "";
        }
        String str = Build.SERIAL;
        LogEx.d(LOG_TAG, "strSerialNum: " + str);
        return str;
    }

    public static String getUUID() {
        String replaceAll = UUID.randomUUID().toString().replaceAll("-", "");
        LogEx.d(LOG_TAG, "uuid: " + replaceAll);
        return replaceAll;
    }

    public static String getUniqueIdentifier(String str) {
        String encrypt;
        if (TextUtils.isEmpty(str) || (encrypt = Security.encrypt(str, "SHA-256")) == null) {
            return null;
        }
        return Base64.encodeToString(encrypt.getBytes(), 2);
    }

    private static boolean hasExternalStorage() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v20, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.io.Reader, java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.io.File[]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:86:0x00a4 -> B:31:0x00ee). Please report as a decompilation issue!!! */
    private static String readUUID(Context context) {
        Throwable th;
        IOException e;
        BufferedReader bufferedReader;
        FileNotFoundException e2;
        ?? file = new File(getSDCardDcimPath(context) + UUID_FILENAME);
        ?? listFiles = new File(getSDCardDcimPath(context)).listFiles();
        String str = "";
        if (listFiles == 0) {
            return "";
        }
        ?? r2 = 0;
        while (true) {
            if (r2 >= listFiles.length) {
                break;
            }
            if (listFiles[r2].getName().contains("zxctuuid_")) {
                file = listFiles[r2];
                String str2 = "find the file:" + file.getName();
                r2 = LOG_TAG;
                LogEx.d(LOG_TAG, str2);
                break;
            }
            r2++;
        }
        if (!file.exists()) {
            return "";
        }
        try {
            try {
                try {
                    r2 = new InputStreamReader(new FileInputStream((File) file), "utf-8");
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    bufferedReader = new BufferedReader(r2);
                } catch (FileNotFoundException e3) {
                    bufferedReader = null;
                    e2 = e3;
                } catch (IOException e4) {
                    bufferedReader = null;
                    e = e4;
                } catch (Throwable th3) {
                    file = 0;
                    th = th3;
                    if (r2 != 0) {
                        try {
                            r2.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    if (file == 0) {
                        throw th;
                    }
                    try {
                        file.close();
                        throw th;
                    } catch (IOException e6) {
                        e6.printStackTrace();
                        throw th;
                    }
                }
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    SecurityUtil.securityCheck(bufferedReader.toString(), "readLine");
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    }
                    str = stringBuffer.toString();
                    try {
                        r2.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                    bufferedReader.close();
                } catch (FileNotFoundException e8) {
                    e2 = e8;
                    e2.printStackTrace();
                    if (r2 != 0) {
                        try {
                            r2.close();
                        } catch (IOException e9) {
                            e9.printStackTrace();
                        }
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return str;
                } catch (IOException e10) {
                    e = e10;
                    e.printStackTrace();
                    if (r2 != 0) {
                        try {
                            r2.close();
                        } catch (IOException e11) {
                            e11.printStackTrace();
                        }
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return str;
                }
            } catch (FileNotFoundException e12) {
                r2 = 0;
                e2 = e12;
                bufferedReader = null;
            } catch (IOException e13) {
                r2 = 0;
                e = e13;
                bufferedReader = null;
            } catch (Throwable th4) {
                r2 = 0;
                th = th4;
                file = 0;
            }
        } catch (IOException e14) {
            e14.printStackTrace();
        }
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.io.Reader, java.io.InputStreamReader] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x007a -> B:21:0x00c4). Please report as a decompilation issue!!! */
    private static String readUUIDFromAndroiduuid(Context context) {
        IOException e;
        BufferedReader bufferedReader;
        FileNotFoundException e2;
        ?? file = new File(getSDCardCachePath(context) + ANDROID_ID);
        String str = "";
        if (!file.exists()) {
            return "";
        }
        String str2 = "find uuid file:" + file.getName();
        ?? r2 = LOG_TAG;
        LogEx.d(LOG_TAG, str2);
        try {
            try {
                try {
                    r2 = new InputStreamReader(new FileInputStream((File) file), "utf-8");
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            } catch (FileNotFoundException e4) {
                r2 = 0;
                e2 = e4;
                bufferedReader = null;
            } catch (IOException e5) {
                r2 = 0;
                e = e5;
                bufferedReader = null;
            } catch (Throwable th) {
                r2 = 0;
                th = th;
                file = 0;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            bufferedReader = new BufferedReader(r2);
            try {
                StringBuffer stringBuffer = new StringBuffer();
                SecurityUtil.securityCheck(bufferedReader.toString(), "readLine");
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuffer.append(readLine);
                }
                str = stringBuffer.toString();
                try {
                    r2.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
                bufferedReader.close();
            } catch (FileNotFoundException e7) {
                e2 = e7;
                e2.printStackTrace();
                if (r2 != 0) {
                    try {
                        r2.close();
                    } catch (IOException e8) {
                        e8.printStackTrace();
                    }
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return str;
            } catch (IOException e9) {
                e = e9;
                e.printStackTrace();
                if (r2 != 0) {
                    try {
                        r2.close();
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return str;
            }
        } catch (FileNotFoundException e11) {
            bufferedReader = null;
            e2 = e11;
        } catch (IOException e12) {
            bufferedReader = null;
            e = e12;
        } catch (Throwable th3) {
            file = 0;
            th = th3;
            if (r2 != 0) {
                try {
                    r2.close();
                } catch (IOException e13) {
                    e13.printStackTrace();
                }
            }
            if (file == 0) {
                throw th;
            }
            try {
                file.close();
                throw th;
            } catch (IOException e14) {
                e14.printStackTrace();
                throw th;
            }
        }
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.io.Reader, java.io.InputStreamReader] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x007b -> B:20:0x00c5). Please report as a decompilation issue!!! */
    private static String readUUIDFromUUID(Context context) {
        IOException e;
        BufferedReader bufferedReader;
        FileNotFoundException e2;
        ?? file = new File(getSDCardCachePath(context) + STR_UUID);
        String str = "";
        if (!file.exists()) {
            return "";
        }
        String str2 = "find uuid file:" + file.getName();
        ?? r2 = LOG_TAG;
        LogEx.d(LOG_TAG, str2);
        try {
            try {
                try {
                    r2 = new InputStreamReader(new FileInputStream((File) file), "utf-8");
                    try {
                        bufferedReader = new BufferedReader(r2);
                        try {
                            StringBuffer stringBuffer = new StringBuffer();
                            SecurityUtil.securityCheck(bufferedReader.toString(), "readLine");
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                stringBuffer.append(readLine);
                            }
                            str = stringBuffer.toString();
                            try {
                                r2.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                            bufferedReader.close();
                        } catch (FileNotFoundException e4) {
                            e2 = e4;
                            e2.printStackTrace();
                            if (r2 != 0) {
                                try {
                                    r2.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return str;
                        } catch (IOException e6) {
                            e = e6;
                            e.printStackTrace();
                            if (r2 != 0) {
                                try {
                                    r2.close();
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                }
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return str;
                        }
                    } catch (FileNotFoundException e8) {
                        bufferedReader = null;
                        e2 = e8;
                    } catch (IOException e9) {
                        bufferedReader = null;
                        e = e9;
                    } catch (Throwable th) {
                        file = 0;
                        th = th;
                        if (r2 != 0) {
                            try {
                                r2.close();
                            } catch (IOException e10) {
                                e10.printStackTrace();
                            }
                        }
                        if (file == 0) {
                            throw th;
                        }
                        try {
                            file.close();
                            throw th;
                        } catch (IOException e11) {
                            e11.printStackTrace();
                            throw th;
                        }
                    }
                } catch (IOException e12) {
                    e12.printStackTrace();
                }
            } catch (FileNotFoundException e13) {
                r2 = 0;
                e2 = e13;
                bufferedReader = null;
            } catch (IOException e14) {
                r2 = 0;
                e = e14;
                bufferedReader = null;
            } catch (Throwable th2) {
                r2 = 0;
                th = th2;
                file = 0;
            }
            return str;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v20, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v21, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v22, types: [java.io.ByteArrayInputStream, java.lang.Object, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:90:0x0138 -> B:29:0x013b). Please report as a decompilation issue!!! */
    private static void writeUUID(Context context, String str) {
        IOException e;
        FileOutputStream fileOutputStream;
        UnsupportedEncodingException e2;
        FileNotFoundException e3;
        File[] listFiles = new File(getSDCardDcimPath(context)).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.getName().contains("zxctuuid_")) {
                    return;
                }
            }
        }
        File file2 = new File(getSDCardDcimPath(context) + ("zxctuuid_" + AES.randomString(6) + Util.PHOTO_DEFAULT_EXT));
        ?? exists = file2.exists();
        exists = exists;
        if (exists == 0) {
            while (true) {
                try {
                    exists = file2.createNewFile();
                    if (exists != 0) {
                        break;
                    }
                    String str2 = getSDCardDcimPath(context) + ("zxctuuid_" + AES.randomString(6) + Util.PHOTO_DEFAULT_EXT);
                    file2 = new File(str2);
                    exists = str2;
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
        }
        try {
            try {
                try {
                    exists = new ByteArrayInputStream(str.getBytes("utf-8"));
                    try {
                        fileOutputStream = new FileOutputStream(file2);
                        try {
                            byte[] bArr = new byte[Util.BYTE_OF_KB];
                            SecurityUtil.securityCheck(exists.toString(), "read");
                            while (true) {
                                int read = exists.read(bArr);
                                if (read <= 0) {
                                    break;
                                } else {
                                    fileOutputStream.write(bArr, 0, read);
                                }
                            }
                            fileOutputStream.flush();
                            try {
                                exists.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                            fileOutputStream.close();
                        } catch (FileNotFoundException e6) {
                            e3 = e6;
                            e3.printStackTrace();
                            if (exists != 0) {
                                try {
                                    exists.close();
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                }
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                        } catch (UnsupportedEncodingException e8) {
                            e2 = e8;
                            e2.printStackTrace();
                            if (exists != 0) {
                                try {
                                    exists.close();
                                } catch (IOException e9) {
                                    e9.printStackTrace();
                                }
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                        } catch (IOException e10) {
                            e = e10;
                            e.printStackTrace();
                            if (exists != 0) {
                                try {
                                    exists.close();
                                } catch (IOException e11) {
                                    e11.printStackTrace();
                                }
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                        }
                    } catch (FileNotFoundException e12) {
                        fileOutputStream = null;
                        e3 = e12;
                    } catch (UnsupportedEncodingException e13) {
                        fileOutputStream = null;
                        e2 = e13;
                    } catch (IOException e14) {
                        fileOutputStream = null;
                        e = e14;
                    } catch (Throwable th) {
                        str = 0;
                        th = th;
                        if (exists != 0) {
                            try {
                                exists.close();
                            } catch (IOException e15) {
                                e15.printStackTrace();
                            }
                        }
                        if (str == 0) {
                            throw th;
                        }
                        try {
                            str.close();
                            throw th;
                        } catch (IOException e16) {
                            e16.printStackTrace();
                            throw th;
                        }
                    }
                } catch (IOException e17) {
                    e17.printStackTrace();
                }
            } catch (FileNotFoundException e18) {
                exists = 0;
                e3 = e18;
                fileOutputStream = null;
            } catch (UnsupportedEncodingException e19) {
                exists = 0;
                e2 = e19;
                fileOutputStream = null;
            } catch (IOException e20) {
                exists = 0;
                e = e20;
                fileOutputStream = null;
            } catch (Throwable th2) {
                exists = 0;
                th = th2;
                str = 0;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
