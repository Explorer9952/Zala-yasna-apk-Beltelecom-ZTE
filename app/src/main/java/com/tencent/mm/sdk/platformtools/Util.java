package com.tencent.mm.sdk.platformtools;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.os.Vibrator;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.View;
import com.tencent.mm.algorithm.MD5;
import com.tencent.mm.sdk.plugin.MMPluginProviderConstants;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.Character;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import junit.framework.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* loaded from: classes.dex */
public final class Util {
    public static final int BEGIN_TIME = 22;
    public static final int BIT_OF_KB = 10;
    public static final int BIT_OF_MB = 20;
    public static final int BYTE_OF_KB = 1024;
    public static final int BYTE_OF_MB = 1048576;
    public static final String CHINA = "zh_CN";
    public static final int DAY = 0;
    public static final int END_TIME = 8;
    public static final String ENGLISH = "en";
    public static final String HONGKONG = "zh_HK";
    public static final String LANGUAGE_DEFAULT = "language_default";
    public static final int MASK_16BIT = 65535;
    public static final int MASK_32BIT = -1;
    public static final int MASK_4BIT = 15;
    public static final int MASK_8BIT = 255;
    public static final long MAX_32BIT_VALUE = 4294967295L;
    public static final int MAX_ACCOUNT_LENGTH = 20;
    public static final int MAX_DECODE_PICTURE_SIZE = 2764800;
    public static final int MAX_PASSWORD_LENGTH = 9;
    public static final long MILLSECONDS_OF_DAY = 86400000;
    public static final long MILLSECONDS_OF_HOUR = 3600000;
    public static final long MILLSECONDS_OF_MINUTE = 60000;
    public static final long MILLSECONDS_OF_SECOND = 1000;
    public static final long MINUTE_OF_HOUR = 60;
    public static final int MIN_ACCOUNT_LENGTH = 6;
    public static final int MIN_PASSWORD_LENGTH = 4;
    public static final String PHOTO_DEFAULT_EXT = ".jpg";
    public static final long SECOND_OF_MINUTE = 60;
    public static final String TAIWAN = "zh_TW";
    private static final long[] bt = {300, 200, 300, 200};
    private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
    private static final char[] bu = {'\t', '\n', '\r'};
    private static final char[] bv = {'<', '>', '\"', '\'', '&'};
    private static final String[] bw = {"&lt;", "&gt;", "&quot;", "&apos;", "&amp;"};

    private Util() {
    }

    public static String GetHostIp() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress()) {
                        return nextElement.getHostAddress();
                    }
                }
            }
            return null;
        } catch (SocketException | Exception unused) {
            return null;
        }
    }

    public static int UnZipFolder(String str, String str2) {
        try {
            android.util.Log.v("XZip", "UnZipFolder(String, String)");
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    zipInputStream.close();
                    return 0;
                }
                String name = nextEntry.getName();
                if (nextEntry.isDirectory()) {
                    new File(str2 + File.separator + name.substring(0, name.length() - 1)).mkdirs();
                } else {
                    File file = new File(str2 + File.separator + name);
                    file.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] bArr = new byte[BYTE_OF_KB];
                    while (true) {
                        int read = zipInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                        fileOutputStream.flush();
                    }
                    fileOutputStream.close();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return -1;
        } catch (IOException e2) {
            e2.printStackTrace();
            return -2;
        }
    }

    private static int a(char[] cArr, int i, int i2) {
        if (i2 <= 0) {
            return 0;
        }
        if (cArr[i] != '#') {
            new String(cArr, i, i2);
            return 0;
        }
        if (i2 > 1) {
            int i3 = i + 1;
            if (cArr[i3] == 'x' || cArr[i3] == 'X') {
                try {
                    return Integer.parseInt(new String(cArr, i + 2, i2 - 2), 16);
                } catch (NumberFormatException unused) {
                    return 0;
                }
            }
        }
        try {
            return Integer.parseInt(new String(cArr, i + 1, i2 - 1), 10);
        } catch (NumberFormatException unused2) {
            return 0;
        }
    }

    private static void a(Map<String, String> map, String str, Node node, int i) {
        if (node.getNodeName().equals("#text") || node.getNodeName().equals("#cdata-section")) {
            map.put(str, node.getNodeValue());
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(".");
        sb.append(node.getNodeName());
        sb.append(i > 0 ? Integer.valueOf(i) : "");
        String sb2 = sb.toString();
        map.put(sb2, node.getNodeValue());
        NamedNodeMap attributes = node.getAttributes();
        if (attributes != null) {
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                Node item = attributes.item(i2);
                map.put(sb2 + ".$" + item.getNodeName(), item.getNodeValue());
            }
        }
        HashMap hashMap = new HashMap();
        NodeList childNodes = node.getChildNodes();
        for (int i3 = 0; i3 < childNodes.getLength(); i3++) {
            Node item2 = childNodes.item(i3);
            int nullAsNil = nullAsNil((Integer) hashMap.get(item2.getNodeName()));
            a(map, sb2, item2, nullAsNil);
            hashMap.put(item2.getNodeName(), Integer.valueOf(nullAsNil + 1));
        }
    }

    public static byte[] bmpToByteArray(Bitmap bitmap, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        if (z) {
            bitmap.recycle();
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return byteArray;
    }

    public static boolean checkPermission(Context context, String str) {
        Assert.assertNotNull(context);
        String packageName = context.getPackageName();
        boolean z = context.getPackageManager().checkPermission(str, packageName) == 0;
        StringBuilder sb = new StringBuilder();
        sb.append(packageName);
        sb.append(" has ");
        sb.append(z ? "permission " : "no permission ");
        sb.append(str);
        Log.d("MicroMsg.Util", sb.toString());
        return z;
    }

    public static boolean checkSDCardFull() {
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return false;
        }
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        long blockCount = statFs.getBlockCount();
        long availableBlocks = statFs.getAvailableBlocks();
        if (blockCount <= 0) {
            return false;
        }
        long j = blockCount - availableBlocks;
        if (j < 0) {
            return false;
        }
        int i = (int) ((j * 100) / blockCount);
        long blockSize = statFs.getBlockSize() * statFs.getFreeBlocks();
        Log.d("MicroMsg.Util", "checkSDCardFull per:" + i + " blockCount:" + blockCount + " availCount:" + availableBlocks + " availSize:" + blockSize);
        return 95 <= i && blockSize <= 52428800;
    }

    public static String convertStreamToString(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine + "\n");
                    } catch (Throwable th) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        throw th;
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                    inputStream.close();
                }
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
        inputStream.close();
        return sb.toString();
    }

    public static long currentDayInMills() {
        return (nowMilliSecond() / MILLSECONDS_OF_DAY) * MILLSECONDS_OF_DAY;
    }

    public static long currentMonthInMills() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), 1);
        gregorianCalendar2.setTimeZone(GMT);
        return gregorianCalendar2.getTimeInMillis();
    }

    public static long currentTicks() {
        return SystemClock.elapsedRealtime();
    }

    public static long currentWeekInMills() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
        gregorianCalendar2.setTimeZone(GMT);
        gregorianCalendar2.add(6, -(gregorianCalendar.get(7) - gregorianCalendar.getFirstDayOfWeek()));
        return gregorianCalendar2.getTimeInMillis();
    }

    public static long currentYearInMills() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(new GregorianCalendar().get(1), 1, 1);
        gregorianCalendar.setTimeZone(GMT);
        return gregorianCalendar.getTimeInMillis();
    }

    public static byte[] decodeHexString(String str) {
        if (str == null || str.length() <= 0) {
            return new byte[0];
        }
        try {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) (Integer.parseInt(str.substring(i2, i2 + 2), 16) & 255);
            }
            return bArr;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }

    public static String dumpArray(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            sb.append(obj);
            sb.append(",");
        }
        return sb.toString();
    }

    public static String dumpHex(byte[] bArr) {
        if (bArr == null) {
            return "(null)";
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        int length = bArr.length;
        char[] cArr2 = new char[(length * 3) + (length / 16)];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            byte b2 = bArr[i2];
            int i3 = i + 1;
            cArr2[i] = ' ';
            int i4 = i3 + 1;
            cArr2[i3] = cArr[(b2 >>> 4) & 15];
            int i5 = i4 + 1;
            cArr2[i4] = cArr[b2 & 15];
            if (i2 % 16 != 0 || i2 <= 0) {
                i = i5;
            } else {
                i = i5 + 1;
                cArr2[i5] = '\n';
            }
        }
        return new String(cArr2);
    }

    public static String encodeHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr != null) {
            for (byte b2 : bArr) {
                sb.append(String.format("%02x", Integer.valueOf(b2 & 255)));
            }
        }
        return sb.toString();
    }

    public static String escapeSqlValue(String str) {
        return str != null ? str.replace("\\[", "[[]").replace("%", "").replace("\\^", "").replace("'", "").replace("\\{", "").replace("\\}", "").replace("\"", "") : str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0028, code lost:
    
        if (r4 != r5[2]) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String escapeStringForXml(java.lang.String r8) {
        /*
            if (r8 != 0) goto L5
            java.lang.String r8 = ""
            return r8
        L5:
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            int r1 = r8.length()
            r2 = 0
            r3 = 0
        L10:
            if (r3 >= r1) goto L5e
            char r4 = r8.charAt(r3)
            r5 = 32
            r6 = 1
            if (r4 >= r5) goto L2a
            char[] r5 = com.tencent.mm.sdk.platformtools.Util.bu
            char r7 = r5[r2]
            if (r4 == r7) goto L2a
            char r7 = r5[r6]
            if (r4 == r7) goto L2a
            r7 = 2
            char r5 = r5[r7]
            if (r4 != r5) goto L2e
        L2a:
            r5 = 127(0x7f, float:1.78E-43)
            if (r4 <= r5) goto L40
        L2e:
            java.lang.String r5 = "&#"
            r0.append(r5)
            java.lang.String r4 = java.lang.Integer.toString(r4)
            r0.append(r4)
            r4 = 59
        L3c:
            r0.append(r4)
            goto L5b
        L40:
            char[] r5 = com.tencent.mm.sdk.platformtools.Util.bv
            int r5 = r5.length
            int r5 = r5 - r6
        L44:
            if (r5 < 0) goto L58
            char[] r7 = com.tencent.mm.sdk.platformtools.Util.bv
            char r7 = r7[r5]
            if (r7 != r4) goto L55
            java.lang.String[] r6 = com.tencent.mm.sdk.platformtools.Util.bw
            r5 = r6[r5]
            r0.append(r5)
            r6 = 0
            goto L58
        L55:
            int r5 = r5 + (-1)
            goto L44
        L58:
            if (r6 == 0) goto L5b
            goto L3c
        L5b:
            int r3 = r3 + 1
            goto L10
        L5e:
            java.lang.String r8 = r0.toString()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.Util.escapeStringForXml(java.lang.String):java.lang.String");
    }

    public static String expandEntities(String str) {
        int length = str.length();
        char[] cArr = new char[length];
        int i = 0;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            int i4 = i + 1;
            cArr[i] = charAt;
            if (charAt == '&' && i2 == -1) {
                i = i4;
                i2 = i;
            } else if (i2 == -1 || Character.isLetter(charAt) || Character.isDigit(charAt) || charAt == '#') {
                i = i4;
            } else {
                if (charAt == ';') {
                    int a2 = a(cArr, i2, (i4 - i2) - 1);
                    if (a2 > 65535) {
                        int i5 = a2 - 65536;
                        cArr[i2 - 1] = (char) ((i5 >> 10) + 55296);
                        cArr[i2] = (char) ((i5 & 1023) + 56320);
                        i2++;
                    } else if (a2 != 0) {
                        cArr[i2 - 1] = (char) a2;
                    } else {
                        i2 = i4;
                    }
                    i = i2;
                } else {
                    i = i4;
                }
                i2 = -1;
            }
        }
        return new String(cArr, 0, i);
    }

    public static String formatSecToMin(int i) {
        long j = i;
        return String.format("%d:%02d", Long.valueOf(j / 60), Long.valueOf(j % 60));
    }

    public static String formatUnixTime(long j) {
        return new SimpleDateFormat("[yy-MM-dd HH:mm:ss]").format(new Date(j * 1000));
    }

    public static void freeBitmapMap(Map<String, Bitmap> map) {
        Iterator<Map.Entry<String, Bitmap>> it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            Bitmap value = it2.next().getValue();
            if (value != null) {
                value.recycle();
            }
        }
        map.clear();
    }

    public static String getCutPasswordMD5(String str) {
        if (str == null) {
            str = "";
        }
        return str.length() <= 16 ? getFullPasswordMD5(str) : getFullPasswordMD5(str.substring(0, 16));
    }

    public static String getDeviceId(Context context) {
        String deviceId;
        if (context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null || (deviceId = telephonyManager.getDeviceId()) == null) {
                return null;
            }
            return deviceId.trim();
        } catch (SecurityException unused) {
            Log.e("MicroMsg.Util", "getDeviceId failed, security exception");
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getFullPasswordMD5(String str) {
        return MD5.getMessageDigest(str.getBytes());
    }

    public static int getHex(String str, int i) {
        if (str == null) {
            return i;
        }
        try {
            return (int) (Long.decode(str).longValue() & 4294967295L);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return i;
        }
    }

    public static BitmapFactory.Options getImageOptions(String str) {
        Assert.assertTrue((str == null || str.equals("")) ? false : true);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
            if (decodeFile != null) {
                decodeFile.recycle();
            }
        } catch (OutOfMemoryError e) {
            Log.e("MicroMsg.Util", "decode bitmap failed: " + e.getMessage());
        }
        return options;
    }

    public static Intent getInstallPackIntent(String str, Context context) {
        Assert.assertTrue((str == null || str.equals("")) ? false : true);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
        return intent;
    }

    public static int getInt(String str, int i) {
        if (str == null) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return i;
        }
    }

    public static int getIntRandom(int i, int i2) {
        Assert.assertTrue(i > i2);
        return new Random(System.currentTimeMillis()).nextInt((i - i2) + 1) + i2;
    }

    public static String getLine1Number(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (((TelephonyManager) context.getSystemService("phone")) == null) {
                Log.e("MicroMsg.Util", "get line1 number failed, null tm");
                return null;
            }
        } catch (SecurityException unused) {
            Log.e("MicroMsg.Util", "getLine1Number failed, security exception");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static long getLong(String str, long j) {
        if (str == null) {
            return j;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return j;
        }
    }

    public static Element getRootElementFromXML(byte[] bArr) {
        String str;
        try {
            DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            if (newDocumentBuilder == null) {
                str = "new Document Builder failed";
            } else {
                try {
                    Document parse = newDocumentBuilder.parse(new ByteArrayInputStream(bArr));
                    if (parse != null) {
                        return parse.getDocumentElement();
                    }
                    str = "new Document failed";
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                } catch (SAXException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            Log.e("MicroMsg.Util", str);
            return null;
        } catch (ParserConfigurationException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, boolean z, float f) {
        Assert.assertNotNull(bitmap);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setFilterBitmap(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-4144960);
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        if (z) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static String getSizeKB(long j) {
        if ((j >> 20) > 0) {
            return getSizeMB(j);
        }
        if ((j >> 9) <= 0) {
            return j + "B";
        }
        return (Math.round((((float) j) * 10.0f) / 1024.0f) / 10.0f) + "KB";
    }

    public static String getSizeMB(long j) {
        return (Math.round((((float) j) * 10.0f) / 1048576.0f) / 10.0f) + "MB";
    }

    public static String getStack() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        String str = "";
        if (stackTrace != null && stackTrace.length >= 2) {
            for (int i = 1; i < stackTrace.length && stackTrace[i].getClassName().contains(MMPluginProviderConstants.PluginIntent.APP_PACKAGE_PATTERN); i++) {
                str = str + "[" + stackTrace[i].getClassName().substring(15) + ":" + stackTrace[i].getMethodName() + "]";
            }
        }
        return str;
    }

    public static int getSystemVersion(Context context, int i) {
        return context == null ? i : Settings.System.getInt(context.getContentResolver(), "sys.settings_system_version", i);
    }

    public static String getTimeZone() {
        String timeZoneDef = getTimeZoneDef();
        int indexOf = timeZoneDef.indexOf(43);
        if (indexOf == -1) {
            indexOf = timeZoneDef.indexOf(45);
        }
        if (indexOf == -1) {
            return "";
        }
        String substring = timeZoneDef.substring(indexOf, indexOf + 3);
        if (substring.charAt(1) != '0') {
            return substring;
        }
        return substring.substring(0, 1) + substring.substring(2, 3);
    }

    public static String getTimeZoneDef() {
        char c2;
        int rawOffset = (int) (TimeZone.getDefault().getRawOffset() / 60000);
        if (rawOffset < 0) {
            c2 = '-';
            rawOffset = -rawOffset;
        } else {
            c2 = '+';
        }
        long j = rawOffset;
        return String.format("GMT%s%02d:%02d", Character.valueOf(c2), Long.valueOf(j / 60), Long.valueOf(j % 60));
    }

    public static String getTimeZoneOffset() {
        TimeZone timeZone = TimeZone.getDefault();
        double rawOffset = (timeZone.getRawOffset() * 100) / MILLSECONDS_OF_HOUR;
        Double.isNaN(rawOffset);
        double d2 = timeZone.useDaylightTime() ? 1.0d : 0.0d;
        Double.isNaN(d2);
        return String.format("%.2f", Double.valueOf((rawOffset / 100.0d) + d2));
    }

    public static String getTopActivityName(Context context) {
        try {
            return ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0).topActivity.getClassName();
        } catch (Exception e) {
            e.printStackTrace();
            return "(null)";
        }
    }

    public static int guessHttpContinueRecvLength(int i) {
        return ((((i - 1) / 1462) + 1) * 52) + 52 + i;
    }

    public static int guessHttpRecvLength(int i) {
        return ((((i - 1) / 1462) + 1) * 52) + 208 + i;
    }

    public static int guessHttpSendLength(int i) {
        return ((((i - 1) / 1462) + 1) * 52) + 224 + i;
    }

    public static int guessTcpConnectLength() {
        return 172;
    }

    public static int guessTcpDisconnectLength() {
        return 156;
    }

    public static int guessTcpRecvLength(int i) {
        return ((((i - 1) / 1462) + 1) * 52) + 40 + i;
    }

    public static int guessTcpSendLength(int i) {
        return ((((i - 1) / 1462) + 1) * 52) + 40 + i;
    }

    public static void installPack(String str, Context context) {
        context.startActivity(getInstallPackIntent(str, context));
    }

    public static boolean isAlpha(char c2) {
        if (c2 < 'a' || c2 > 'z') {
            return c2 >= 'A' && c2 <= 'Z';
        }
        return true;
    }

    public static boolean isChinese(char c2) {
        Character.UnicodeBlock of = Character.UnicodeBlock.of(c2);
        return of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || of == Character.UnicodeBlock.GENERAL_PUNCTUATION || of == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || of == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
    }

    public static boolean isDayTimeNow() {
        long j = new GregorianCalendar().get(11);
        return j >= 6 && j < 18;
    }

    public static boolean isImgFile(String str) {
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.Util", "isImgFile, invalid argument");
            return false;
        }
        if (str.length() < 3 || !new File(str).exists()) {
            return false;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return options.outWidth > 0 && options.outHeight > 0;
    }

    public static boolean isIntentAvailable(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    public static boolean isLockScreen(Context context) {
        try {
            return ((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isNightTime(int i, int i2, int i3) {
        if (i2 > i3) {
            return i >= i2 || i <= i3;
        }
        if (i2 < i3) {
            return i <= i3 && i >= i2;
        }
        return true;
    }

    public static boolean isNullOrNil(String str) {
        return str == null || str.length() <= 0;
    }

    public static boolean isNullOrNil(byte[] bArr) {
        return bArr == null || bArr.length <= 0;
    }

    public static boolean isNum(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    public static boolean isProcessRunning(Context context, String str) {
        String str2;
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo != null && (str2 = runningAppProcessInfo.processName) != null && str2.equals(str)) {
                Log.w("MicroMsg.Util", "process " + str + " is running");
                return true;
            }
        }
        Log.w("MicroMsg.Util", "process " + str + " is not running");
        return false;
    }

    public static boolean isServiceRunning(Context context, String str) {
        ComponentName componentName;
        for (ActivityManager.RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE)) {
            if (runningServiceInfo != null && (componentName = runningServiceInfo.service) != null && componentName.getClassName().toString().equals(str)) {
                Log.w("MicroMsg.Util", "service " + str + " is running");
                return true;
            }
        }
        Log.w("MicroMsg.Util", "service " + str + " is not running");
        return false;
    }

    public static boolean isTopActivity(Context context) {
        String name = context.getClass().getName();
        String topActivityName = getTopActivityName(context);
        Log.d("MicroMsg.Util", "top activity=" + topActivityName + ", context=" + name);
        return topActivityName.equalsIgnoreCase(name);
    }

    public static boolean isTopApplication(Context context) {
        try {
            String className = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0).topActivity.getClassName();
            String packageName = context.getPackageName();
            Log.d("MicroMsg.Util", "top activity=" + className + ", context=" + packageName);
            return className.contains(packageName);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isValidAccount(String str) {
        if (str == null) {
            return false;
        }
        String trim = str.trim();
        if (trim.length() < 6 || trim.length() > 20 || !isAlpha(trim.charAt(0))) {
            return false;
        }
        for (int i = 0; i < trim.length(); i++) {
            char charAt = trim.charAt(i);
            if (!isAlpha(charAt) && !isNum(charAt) && charAt != '-' && charAt != '_') {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidEmail(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.trim().matches("^[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$");
    }

    public static boolean isValidPassword(String str) {
        if (str == null || str.length() < 4) {
            return false;
        }
        if (str.length() >= 9) {
            return true;
        }
        try {
            Integer.parseInt(str);
            return false;
        } catch (NumberFormatException unused) {
            return true;
        }
    }

    public static boolean isValidQQNum(String str) {
        if (str != null && str.length() > 0) {
            try {
                long longValue = Long.valueOf(str.trim()).longValue();
                return longValue > 0 && longValue <= 4294967295L;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean jump(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        if (isIntentAvailable(context, intent)) {
            context.startActivity(intent);
            return true;
        }
        Log.e("MicroMsg.Util", "jump to url failed, " + str);
        return false;
    }

    public static String listToString(List<String> list, String str) {
        if (list == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < list.size(); i++) {
            sb.append(i == list.size() - 1 ? list.get(i).trim() : list.get(i).trim() + str);
        }
        return sb.toString();
    }

    public static String mapToXml(String str, LinkedHashMap<String, String> linkedHashMap) {
        StringBuilder sb = new StringBuilder();
        sb.append("<key>");
        for (Map.Entry<String, String> entry : linkedHashMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key == null) {
                key = "unknow";
            }
            if (value == null) {
                value = "unknow";
            }
            sb.append("<" + ((Object) key) + ">");
            sb.append((Object) value);
            sb.append("</" + ((Object) key) + ">");
        }
        sb.append("</key>");
        return sb.toString();
    }

    public static long milliSecondsToNow(long j) {
        return System.currentTimeMillis() - j;
    }

    public static long nowMilliSecond() {
        return System.currentTimeMillis();
    }

    public static long nowSecond() {
        return System.currentTimeMillis() / 1000;
    }

    public static int nullAs(Integer num, int i) {
        return num == null ? i : num.intValue();
    }

    public static long nullAs(Long l, long j) {
        return l == null ? j : l.longValue();
    }

    public static String nullAs(String str, String str2) {
        return str == null ? str2 : str;
    }

    public static boolean nullAs(Boolean bool, boolean z) {
        return bool == null ? z : bool.booleanValue();
    }

    public static boolean nullAsFalse(Boolean bool) {
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static int nullAsInt(Object obj, int i) {
        return obj == null ? i : obj instanceof Integer ? ((Integer) obj).intValue() : obj instanceof Long ? ((Long) obj).intValue() : i;
    }

    public static int nullAsNil(Integer num) {
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static long nullAsNil(Long l) {
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public static String nullAsNil(String str) {
        return str == null ? "" : str;
    }

    public static boolean nullAsTrue(Boolean bool) {
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public static Map<String, String> parseIni(String str) {
        String[] split;
        if (str == null || str.length() <= 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (String str2 : str.split("\n")) {
            if (str2 != null && str2.length() > 0 && (split = str2.trim().split("=", 2)) != null && split.length >= 2) {
                String str3 = split[0];
                String str4 = split[1];
                if (str3 != null && str3.length() > 0 && str3.matches("^[a-zA-Z0-9_]*")) {
                    hashMap.put(str3, str4);
                }
            }
        }
        return hashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0072, code lost:
    
        if (r4 != false) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Map<java.lang.String, java.lang.String> parseXml(java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            r0 = 0
            if (r7 == 0) goto Ld5
            int r1 = r7.length()
            if (r1 > 0) goto Lb
            goto Ld5
        Lb:
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            javax.xml.parsers.DocumentBuilderFactory r2 = javax.xml.parsers.DocumentBuilderFactory.newInstance()
            javax.xml.parsers.DocumentBuilder r2 = r2.newDocumentBuilder()     // Catch: javax.xml.parsers.ParserConfigurationException -> Ld1
            java.lang.String r3 = "MicroMsg.Util"
            if (r2 != 0) goto L22
            java.lang.String r7 = "new Document Builder failed"
        L1e:
            com.tencent.mm.sdk.platformtools.Log.e(r3, r7)
            return r0
        L22:
            org.xml.sax.InputSource r4 = new org.xml.sax.InputSource     // Catch: java.lang.Exception -> L42 java.io.IOException -> L47 org.xml.sax.SAXException -> L4c org.w3c.dom.DOMException -> L51
            java.io.ByteArrayInputStream r5 = new java.io.ByteArrayInputStream     // Catch: java.lang.Exception -> L42 java.io.IOException -> L47 org.xml.sax.SAXException -> L4c org.w3c.dom.DOMException -> L51
            byte[] r7 = r7.getBytes()     // Catch: java.lang.Exception -> L42 java.io.IOException -> L47 org.xml.sax.SAXException -> L4c org.w3c.dom.DOMException -> L51
            r5.<init>(r7)     // Catch: java.lang.Exception -> L42 java.io.IOException -> L47 org.xml.sax.SAXException -> L4c org.w3c.dom.DOMException -> L51
            r4.<init>(r5)     // Catch: java.lang.Exception -> L42 java.io.IOException -> L47 org.xml.sax.SAXException -> L4c org.w3c.dom.DOMException -> L51
            if (r9 == 0) goto L35
            r4.setEncoding(r9)     // Catch: java.lang.Exception -> L42 java.io.IOException -> L47 org.xml.sax.SAXException -> L4c org.w3c.dom.DOMException -> L51
        L35:
            org.w3c.dom.Document r7 = r2.parse(r4)     // Catch: java.lang.Exception -> L42 java.io.IOException -> L47 org.xml.sax.SAXException -> L4c org.w3c.dom.DOMException -> L51
            r7.normalize()     // Catch: org.w3c.dom.DOMException -> L3d java.lang.Exception -> L42 java.io.IOException -> L47 org.xml.sax.SAXException -> L4c
            goto L57
        L3d:
            r9 = move-exception
            r6 = r9
            r9 = r7
            r7 = r6
            goto L53
        L42:
            r7 = move-exception
            r7.printStackTrace()
            return r0
        L47:
            r7 = move-exception
            r7.printStackTrace()
            return r0
        L4c:
            r7 = move-exception
            r7.printStackTrace()
            return r0
        L51:
            r7 = move-exception
            r9 = r0
        L53:
            r7.printStackTrace()
            r7 = r9
        L57:
            if (r7 != 0) goto L5c
            java.lang.String r7 = "new Document failed"
            goto L1e
        L5c:
            org.w3c.dom.Element r7 = r7.getDocumentElement()
            if (r7 != 0) goto L65
            java.lang.String r7 = "getDocumentElement failed"
            goto L1e
        L65:
            java.lang.String r9 = ""
            r2 = 0
            if (r8 == 0) goto L78
            java.lang.String r4 = r7.getNodeName()
            boolean r4 = r8.equals(r4)
            if (r4 == 0) goto L78
        L74:
            a(r1, r9, r7, r2)
            goto L96
        L78:
            org.w3c.dom.NodeList r7 = r7.getElementsByTagName(r8)
            int r8 = r7.getLength()
            if (r8 > 0) goto L85
            java.lang.String r7 = "parse item null"
            goto L1e
        L85:
            int r8 = r7.getLength()
            r0 = 1
            if (r8 <= r0) goto L91
            java.lang.String r8 = "parse items more than one"
            com.tencent.mm.sdk.platformtools.Log.w(r3, r8)
        L91:
            org.w3c.dom.Node r7 = r7.item(r2)
            goto L74
        L96:
            java.util.Set r7 = r1.entrySet()
            java.util.Iterator r7 = r7.iterator()
        L9e:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto Ld0
            java.lang.Object r8 = r7.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r0 = "key="
            r9.<init>(r0)
            java.lang.Object r0 = r8.getKey()
            java.lang.String r0 = (java.lang.String) r0
            r9.append(r0)
            java.lang.String r0 = " value="
            r9.append(r0)
            java.lang.Object r8 = r8.getValue()
            java.lang.String r8 = (java.lang.String) r8
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            com.tencent.mm.sdk.platformtools.Log.v(r3, r8)
            goto L9e
        Ld0:
            return r1
        Ld1:
            r7 = move-exception
            r7.printStackTrace()
        Ld5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.Util.parseXml(java.lang.String, java.lang.String, java.lang.String):java.util.Map");
    }

    public static MediaPlayer playSound(Context context, int i, MediaPlayer.OnCompletionListener onCompletionListener) {
        try {
            AssetFileDescriptor openFd = context.getAssets().openFd(context.getString(i));
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
            openFd.close();
            mediaPlayer.prepare();
            mediaPlayer.setLooping(false);
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(onCompletionListener);
            return mediaPlayer;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void playSound(Context context, int i) {
        playSound(context, i, new MediaPlayer.OnCompletionListener() { // from class: com.tencent.mm.sdk.platformtools.Util.1
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
    }

    public static String processXml(String str) {
        return (str == null || str.length() == 0 || Build.VERSION.SDK_INT >= 8) ? str : expandEntities(str);
    }

    public static void saveBitmapToImage(Bitmap bitmap, int i, Bitmap.CompressFormat compressFormat, String str, String str2, boolean z) {
        Assert.assertTrue((str == null || str2 == null) ? false : true);
        Log.d("MicroMsg.Util", "saving to " + str + str2);
        File file = new File(str + str2);
        file.createNewFile();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(compressFormat, i, fileOutputStream);
            fileOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void saveBitmapToImage(Bitmap bitmap, int i, Bitmap.CompressFormat compressFormat, String str, boolean z) {
        FileOutputStream fileOutputStream;
        Assert.assertTrue(!isNullOrNil(str));
        Log.d("MicroMsg.Util", "saving to " + str);
        File file = new File(str);
        file.createNewFile();
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e) {
            e = e;
        }
        try {
            bitmap.compress(compressFormat, i, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            fileOutputStream2.close();
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            fileOutputStream2.close();
            throw th;
        }
    }

    public static long secondsToNow(long j) {
        return (System.currentTimeMillis() / 1000) - j;
    }

    public static void selectPicture(Context context, int i) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        ((Activity) context).startActivityForResult(Intent.createChooser(intent, null), i);
    }

    public static void shake(Context context, boolean z) {
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        if (vibrator == null) {
            return;
        }
        if (z) {
            vibrator.vibrate(bt, -1);
        } else {
            vibrator.cancel();
        }
    }

    public static int[] splitToIntArray(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(":");
        ArrayList arrayList = new ArrayList();
        for (String str2 : split) {
            if (str2 != null && str2.length() > 0) {
                try {
                    arrayList.add(Integer.valueOf(Integer.valueOf(str2).intValue()));
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("MicroMsg.Util", "invalid port num, ignore");
                }
            }
        }
        int size = arrayList.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = ((Integer) arrayList.get(i)).intValue();
        }
        return iArr;
    }

    public static List<String> stringsToList(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(str);
        }
        return arrayList;
    }

    public static long ticksToNow(long j) {
        return SystemClock.elapsedRealtime() - j;
    }

    public static void transClickToSelect(final View view, final View view2) {
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mm.sdk.platformtools.Util.2
            /* JADX WARN: Code restructure failed: missing block: B:9:0x0011, code lost:
            
                if (r2 != 4) goto L16;
             */
            @Override // android.view.View.OnTouchListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final boolean onTouch(android.view.View r2, android.view.MotionEvent r3) {
                /*
                    r1 = this;
                    int r2 = r3.getAction()
                    r3 = 0
                    r0 = 1
                    if (r2 == 0) goto L23
                    if (r2 == r0) goto L1d
                    r0 = 2
                    if (r2 == r0) goto L14
                    r0 = 3
                    if (r2 == r0) goto L1d
                    r0 = 4
                    if (r2 == r0) goto L1d
                    goto L28
                L14:
                    android.view.View r2 = r1
                    android.view.View r0 = r2
                    boolean r0 = r0.isPressed()
                    goto L25
                L1d:
                    android.view.View r2 = r1
                    r2.setSelected(r3)
                    goto L28
                L23:
                    android.view.View r2 = r1
                L25:
                    r2.setSelected(r0)
                L28:
                    return r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.Util.AnonymousClass2.onTouch(android.view.View, android.view.MotionEvent):boolean");
            }
        });
    }
}
