package com.video.androidsdk.common.util;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import com.video.androidsdk.log.LogEx;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class StringUtil {
    public static final String LOG_TAG = "StringUtil";
    public static final int TYPE_REMOVE_SPACE_ALL = 0;
    public static final int TYPE_REMOVE_SPACE_BOTH = 3;
    public static final int TYPE_REMOVE_SPACE_LEFT = 1;
    public static final int TYPE_REMOVE_SPACE_RIGHT = 2;

    private StringUtil() {
    }

    public static String bytesToString(byte[] bArr) {
        if (bArr == null) {
            LogEx.w(LOG_TAG, "byData is null!");
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer("");
        for (byte b2 : bArr) {
            stringBuffer.append((char) (b2 & 255));
        }
        return stringBuffer.toString();
    }

    public static boolean checkEmail(String str) {
        if (isEmptyString(str)) {
            return false;
        }
        try {
            return Pattern.compile("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$").matcher(str).matches();
        } catch (Exception e) {
            e.printStackTrace();
            LogEx.e(LOG_TAG, e.getMessage());
            return false;
        }
    }

    public static String getSplitedString(String str, String str2, int i) {
        LogEx.d(LOG_TAG, "strSrc=" + str + ",strSeperator=" + str2 + ",iPos=" + i);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String[] splitString = splitString(str, str2);
            LogEx.d(LOG_TAG, "length=" + splitString.length);
            if (i >= 0 && i < splitString.length) {
                return getStringNotNull(splitString[i]);
            }
            LogEx.w(LOG_TAG, "Pos out of range[0," + splitString.length + "]");
            return null;
        }
        LogEx.w(LOG_TAG, "strSrc is empty or strSeperator is empty!");
        return str;
    }

    public static String getString(ByteBuffer byteBuffer, String str) {
        try {
            return Charset.forName(str).newDecoder().decode(byteBuffer.asReadOnlyBuffer()).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getStringFromObject(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    public static String getStringNotNull(String str) {
        return str != null ? str : "";
    }

    public static boolean isEmptyString(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isSameString(String str, String str2) {
        if (str == null || str2 == null) {
            return str == null && str2 == null;
        }
        return str.equals(str2);
    }

    public static String removeSpace(String str) {
        return removeSpace(str, 3);
    }

    public static SpannableString setTextColor(String str, String str2, int i) {
        if (isEmptyString(str)) {
            return null;
        }
        return setTextColor(new SpannableString(str), str2, i);
    }

    public static SpannableString setTextSize(String str, String str2, int i) {
        if (isEmptyString(str)) {
            LogEx.w(LOG_TAG, "strSrc is empty!");
            return null;
        }
        return setTextSize(new SpannableString(str), str2, i);
    }

    public static String[] splitString(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (!isEmptyString(str) && !isEmptyString(str2)) {
            int i = 0;
            int indexOf = str.indexOf(str2, 0);
            if (indexOf >= 0) {
                while (indexOf >= 0) {
                    if (indexOf > i) {
                        arrayList.add(str.substring(i, indexOf));
                    } else {
                        arrayList.add("");
                    }
                    i = indexOf + 1;
                    indexOf = str.indexOf(str2, i);
                }
                if (i <= str.length() - 1) {
                    arrayList.add(str.substring(i));
                } else {
                    arrayList.add("");
                }
            } else {
                arrayList.add(str);
            }
            return (String[]) arrayList.toArray(new String[1]);
        }
        return (String[]) arrayList.toArray(new String[1]);
    }

    public static boolean startsWith(String str, String str2) {
        if (isEmptyString(str) || isEmptyString(str2)) {
            return false;
        }
        return str.startsWith(str2);
    }

    public static byte[] toLH(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)};
    }

    public static String trimContentBetweenBrackets(String str) {
        if (isEmptyString(str)) {
            LogEx.w(LOG_TAG, "strTarget is empty!");
            return "";
        }
        return str.replaceAll("\\(.*\\)", "");
    }

    public static String removeSpace(String str, int i) {
        if (isEmptyString(str)) {
            LogEx.w(LOG_TAG, "strSource is empty!");
            return "";
        }
        if (i == 0) {
            return str.replace(" ", "");
        }
        if (i != 1 && i != 2 && i != 3) {
            return str;
        }
        if (3 == i || 1 == i) {
            int length = str.length();
            int i2 = 0;
            while (i2 < length && str.charAt(i2) == ' ') {
                i2++;
            }
            str = i2 < length ? str.substring(i2) : "";
        }
        if (3 != i && 2 != i) {
            return str;
        }
        int length2 = str.length() - 1;
        while (length2 >= 0 && str.charAt(length2) == ' ') {
            length2--;
        }
        return length2 >= 0 ? str.substring(0, length2 + 1) : "";
    }

    public static SpannableString setTextColor(SpannableString spannableString, String str, int i) {
        if (spannableString == null) {
            LogEx.w(LOG_TAG, "dstSpannable is null!");
            return null;
        }
        if (isEmptyString(str)) {
            LogEx.w(LOG_TAG, "strPattern is empty!");
            return spannableString;
        }
        Matcher matcher = Pattern.compile(str).matcher(spannableString);
        while (matcher.find()) {
            spannableString.setSpan(new ForegroundColorSpan(i), matcher.start(), matcher.end(), 33);
        }
        return spannableString;
    }

    public static SpannableString setTextSize(SpannableString spannableString, String str, int i) {
        if (spannableString == null) {
            LogEx.w(LOG_TAG, "dstSpannable is null!");
            return null;
        }
        if (isEmptyString(str)) {
            return spannableString;
        }
        Matcher matcher = Pattern.compile(str).matcher(spannableString);
        while (matcher.find()) {
            spannableString.setSpan(new AbsoluteSizeSpan(i), matcher.start(), matcher.end(), 33);
        }
        return spannableString;
    }
}
