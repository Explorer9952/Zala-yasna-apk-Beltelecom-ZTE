package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.facebook.internal.NativeProtocol;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboParameters;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Utility {
    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final char[] encodes = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
    private static final byte[] decodes = new byte[256];

    /* loaded from: classes.dex */
    public static final class UploadImageUtils {
        private static void revitionImageSize(String str, int i, int i2) throws IOException {
            if (i > 0) {
                if (!Utility.doesExisted(str)) {
                    if (str == null) {
                        str = "null";
                    }
                    throw new FileNotFoundException(str);
                }
                if (BitmapHelper.verifyBitmap(str)) {
                    FileInputStream fileInputStream = new FileInputStream(str);
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeStream(fileInputStream, null, options);
                    try {
                        fileInputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    int i3 = 0;
                    while (true) {
                        if ((options.outWidth >> i3) <= i && (options.outHeight >> i3) <= i) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                    options.inSampleSize = (int) Math.pow(2.0d, i3);
                    options.inJustDecodeBounds = false;
                    Bitmap safeDecodeBimtapFile = safeDecodeBimtapFile(str, options);
                    if (safeDecodeBimtapFile != null) {
                        Utility.deleteDependon(str);
                        Utility.makesureFileExist(str);
                        FileOutputStream fileOutputStream = new FileOutputStream(str);
                        String str2 = options.outMimeType;
                        if (str2 != null && str2.contains("png")) {
                            safeDecodeBimtapFile.compress(Bitmap.CompressFormat.PNG, i2, fileOutputStream);
                        } else {
                            safeDecodeBimtapFile.compress(Bitmap.CompressFormat.JPEG, i2, fileOutputStream);
                        }
                        try {
                            fileOutputStream.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        safeDecodeBimtapFile.recycle();
                        return;
                    }
                    throw new IOException("Bitmap decode error!");
                }
                throw new IOException("");
            }
            throw new IllegalArgumentException("size must be greater than 0!");
        }

        private static void revitionImageSizeHD(String str, int i, int i2) throws IOException {
            Bitmap createBitmap;
            if (i > 0) {
                if (!Utility.doesExisted(str)) {
                    if (str == null) {
                        str = "null";
                    }
                    throw new FileNotFoundException(str);
                }
                if (BitmapHelper.verifyBitmap(str)) {
                    int i3 = i * 2;
                    FileInputStream fileInputStream = new FileInputStream(str);
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeStream(fileInputStream, null, options);
                    try {
                        fileInputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    int i4 = 0;
                    while (true) {
                        if ((options.outWidth >> i4) <= i3 && (options.outHeight >> i4) <= i3) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                    options.inSampleSize = (int) Math.pow(2.0d, i4);
                    options.inJustDecodeBounds = false;
                    Bitmap safeDecodeBimtapFile = safeDecodeBimtapFile(str, options);
                    if (safeDecodeBimtapFile != null) {
                        Utility.deleteDependon(str);
                        Utility.makesureFileExist(str);
                        float width = i / (safeDecodeBimtapFile.getWidth() > safeDecodeBimtapFile.getHeight() ? safeDecodeBimtapFile.getWidth() : safeDecodeBimtapFile.getHeight());
                        if (width < 1.0f) {
                            while (true) {
                                try {
                                    createBitmap = Bitmap.createBitmap((int) (safeDecodeBimtapFile.getWidth() * width), (int) (safeDecodeBimtapFile.getHeight() * width), Bitmap.Config.ARGB_8888);
                                    break;
                                } catch (OutOfMemoryError unused) {
                                    System.gc();
                                    double d2 = width;
                                    Double.isNaN(d2);
                                    width = (float) (d2 * 0.8d);
                                }
                            }
                            if (createBitmap == null) {
                                safeDecodeBimtapFile.recycle();
                            }
                            Canvas canvas = new Canvas(createBitmap);
                            Matrix matrix = new Matrix();
                            matrix.setScale(width, width);
                            canvas.drawBitmap(safeDecodeBimtapFile, matrix, new Paint());
                            safeDecodeBimtapFile.recycle();
                            safeDecodeBimtapFile = createBitmap;
                        }
                        FileOutputStream fileOutputStream = new FileOutputStream(str);
                        String str2 = options.outMimeType;
                        if (str2 != null && str2.contains("png")) {
                            safeDecodeBimtapFile.compress(Bitmap.CompressFormat.PNG, i2, fileOutputStream);
                        } else {
                            safeDecodeBimtapFile.compress(Bitmap.CompressFormat.JPEG, i2, fileOutputStream);
                        }
                        try {
                            fileOutputStream.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        safeDecodeBimtapFile.recycle();
                        return;
                    }
                    throw new IOException("Bitmap decode error!");
                }
                throw new IOException("");
            }
            throw new IllegalArgumentException("size must be greater than 0!");
        }

        public static boolean revitionPostImageSize(Context context, String str) {
            try {
                if (NetworkHelper.isWifiValid(context)) {
                    revitionImageSizeHD(str, 1600, 75);
                    return true;
                }
                revitionImageSize(str, Util.BYTE_OF_KB, 75);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }

        private static Bitmap safeDecodeBimtapFile(String str, BitmapFactory.Options options) {
            BitmapFactory.Options options2;
            FileInputStream fileInputStream;
            OutOfMemoryError e;
            if (options == null) {
                options2 = new BitmapFactory.Options();
                options2.inSampleSize = 1;
            } else {
                options2 = options;
            }
            int i = 0;
            FileInputStream fileInputStream2 = null;
            Bitmap bitmap = null;
            while (true) {
                if (i < 5) {
                    try {
                        try {
                            fileInputStream = new FileInputStream(str);
                            try {
                                bitmap = BitmapFactory.decodeStream(fileInputStream, null, options);
                                try {
                                    fileInputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            } catch (OutOfMemoryError e3) {
                                e = e3;
                                e.printStackTrace();
                                options2.inSampleSize *= 2;
                                try {
                                    fileInputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                                i++;
                                fileInputStream2 = fileInputStream;
                            }
                        } catch (OutOfMemoryError e5) {
                            fileInputStream = fileInputStream2;
                            e = e5;
                        }
                    } catch (FileNotFoundException unused) {
                    }
                }
                return bitmap;
                i++;
                fileInputStream2 = fileInputStream;
            }
        }
    }

    private static boolean __createNewFile(File file) {
        if (file == null) {
            return false;
        }
        makesureParentExist(file);
        if (file.exists()) {
            delete(file);
        }
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void createNewFile(File file) {
        if (file == null || __createNewFile(file)) {
            return;
        }
        throw new RuntimeException(String.valueOf(file.getAbsolutePath()) + " doesn't be created!");
    }

    public static byte[] decodeBase62(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.toCharArray().length);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < charArray.length) {
            char c2 = charArray[i];
            if (c2 == 'i') {
                i++;
                char c3 = charArray[i];
                if (c3 == 'a') {
                    c2 = 'i';
                } else if (c3 == 'b') {
                    c2 = '+';
                } else if (c3 == 'c') {
                    c2 = '/';
                } else {
                    i--;
                    c2 = charArray[i];
                }
            }
            i3 = (i3 << 6) | decodes[c2];
            i2 += 6;
            while (i2 > 7) {
                i2 -= 8;
                byteArrayOutputStream.write(i3 >> i2);
                i3 &= (1 << i2) - 1;
            }
            i++;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static Bundle decodeUrl(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=");
                try {
                    bundle.putString(URLDecoder.decode(split[0], "UTF-8"), URLDecoder.decode(split[1], "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return bundle;
    }

    private static void delete(File file) {
        if (file == null || !file.exists() || file.delete()) {
            return;
        }
        throw new RuntimeException(String.valueOf(file.getAbsolutePath()) + " doesn't be deleted!");
    }

    private static boolean deleteDependon(File file, int i) {
        int i2 = 1;
        if (i < 1) {
            i = 5;
        }
        boolean z = false;
        if (file != null) {
            while (!z && i2 <= i && file.isFile() && file.exists()) {
                z = file.delete();
                if (!z) {
                    i2++;
                }
            }
        }
        return z;
    }

    private static boolean doesExisted(File file) {
        return file != null && file.exists();
    }

    public static String encodeBase62(byte[] bArr) {
        Object obj;
        String valueOf;
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            obj = "ic";
            if (i >= bArr.length) {
                break;
            }
            i2 = (i2 << 8) | (bArr[i] & 255);
            i3 += 8;
            while (i3 > 5) {
                i3 -= 6;
                char c2 = encodes[i2 >> i3];
                if (c2 == 'i') {
                    valueOf = "ia";
                } else if (c2 == '+') {
                    valueOf = "ib";
                } else {
                    valueOf = c2 == '/' ? "ic" : Character.valueOf(c2);
                }
                stringBuffer.append(valueOf);
                i2 &= (1 << i3) - 1;
            }
            i++;
        }
        if (i3 > 0) {
            char c3 = encodes[i2 << (6 - i3)];
            if (c3 == 'i') {
                obj = "ia";
            } else if (c3 == '+') {
                obj = "ib";
            } else if (c3 != '/') {
                obj = Character.valueOf(c3);
            }
            stringBuffer.append(obj);
        }
        return stringBuffer.toString();
    }

    public static String encodeParameters(WeiboParameters weiboParameters) {
        if (weiboParameters == null || isBundleEmpty(weiboParameters)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (int i2 = 0; i2 < weiboParameters.size(); i2++) {
            String key = weiboParameters.getKey(i2);
            if (i != 0) {
                sb.append("&");
            }
            try {
                sb.append(URLEncoder.encode(key, "UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode(weiboParameters.getValue(key), "UTF-8"));
            } catch (UnsupportedEncodingException unused) {
            }
            i++;
        }
        return sb.toString();
    }

    public static String encodeUrl(WeiboParameters weiboParameters) {
        if (weiboParameters == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (int i = 0; i < weiboParameters.size(); i++) {
            if (z) {
                z = false;
            } else {
                sb.append("&");
            }
            String key = weiboParameters.getKey(i);
            if (weiboParameters.getValue(key) == null) {
                LogUtil.i("encodeUrl", "key:" + key + " 's value is null");
            } else {
                try {
                    sb.append(String.valueOf(URLEncoder.encode(weiboParameters.getKey(i), "UTF-8")) + "=" + URLEncoder.encode(weiboParameters.getValue(i), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            LogUtil.i("encodeUrl", sb.toString());
        }
        return sb.toString();
    }

    public static Bundle errorSAX(String str) {
        Bundle bundle = new Bundle();
        if (str != null && str.indexOf("{") >= 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                bundle.putString("error", jSONObject.optString("error"));
                bundle.putString("error_code", jSONObject.optString("error_code"));
                bundle.putString(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION, jSONObject.optString(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION));
            } catch (JSONException unused) {
                bundle.putString("error", "JSONExceptionerror");
            }
        }
        return bundle;
    }

    public static Bundle formBundle(Oauth2AccessToken oauth2AccessToken) {
        Bundle bundle = new Bundle();
        bundle.putString("access_token", oauth2AccessToken.getToken());
        bundle.putString("refresh_token", oauth2AccessToken.getRefreshToken());
        bundle.putString("expires_in", new StringBuilder(String.valueOf(oauth2AccessToken.getExpiresTime())).toString());
        return bundle;
    }

    public static Bundle formErrorBundle(Exception exc) {
        Bundle bundle = new Bundle();
        bundle.putString("error", exc.getMessage());
        return bundle;
    }

    public static String generateGUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String getSign(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            int i = 0;
            while (true) {
                Signature[] signatureArr = packageInfo.signatures;
                if (i >= signatureArr.length) {
                    return null;
                }
                byte[] byteArray = signatureArr[i].toByteArray();
                if (byteArray != null) {
                    return MD5.hexdigest(byteArray);
                }
                i++;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private static boolean isBundleEmpty(WeiboParameters weiboParameters) {
        return weiboParameters == null || weiboParameters.size() == 0;
    }

    public static boolean isChineseLocale(Context context) {
        try {
            Locale locale = context.getResources().getConfiguration().locale;
            if (!Locale.CHINA.equals(locale) && !Locale.CHINESE.equals(locale) && !Locale.SIMPLIFIED_CHINESE.equals(locale)) {
                if (!Locale.TAIWAN.equals(locale)) {
                    return false;
                }
            }
        } catch (Exception unused) {
        }
        return true;
    }

    public static boolean isWifi(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    private static void makesureFileExist(File file) {
        if (file == null || file.exists()) {
            return;
        }
        makesureParentExist(file);
        createNewFile(file);
    }

    private static void makesureParentExist(File file) {
        File parentFile;
        if (file == null || (parentFile = file.getParentFile()) == null || parentFile.exists()) {
            return;
        }
        mkdirs(parentFile);
    }

    private static void mkdirs(File file) {
        if (file == null || file.exists() || file.mkdirs()) {
            return;
        }
        throw new RuntimeException("fail to make " + file.getAbsolutePath());
    }

    public static String packUrl(HashMap<String, String> hashMap) {
        if (hashMap == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : hashMap.keySet()) {
            String str2 = hashMap.get(str);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (z) {
                    z = false;
                } else {
                    try {
                        sb.append("&");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                sb.append(URLEncoder.encode(str, "UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode(str2, "UTF-8"));
            }
        }
        return sb.toString();
    }

    public static Bundle parseUrl(String str) {
        try {
            URL url = new URL(str);
            Bundle decodeUrl = decodeUrl(url.getQuery());
            decodeUrl.putAll(decodeUrl(url.getRef()));
            return decodeUrl;
        } catch (MalformedURLException unused) {
            return new Bundle();
        }
    }

    public static void showToast(String str, Context context) {
        Toast.makeText(context, str, 1).show();
    }

    public static Bundle unpackUrl(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String str2 : str.split("&")) {
                String[] split = str2.split("=");
                try {
                    bundle.putString(URLDecoder.decode(split[0], "UTF-8"), URLDecoder.decode(split[1], "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean doesExisted(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return doesExisted(new File(str));
    }

    private static boolean deleteDependon(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return deleteDependon(new File(str), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void makesureFileExist(String str) {
        if (str == null) {
            return;
        }
        makesureFileExist(new File(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean deleteDependon(String str) {
        return deleteDependon(str, 0);
    }
}
