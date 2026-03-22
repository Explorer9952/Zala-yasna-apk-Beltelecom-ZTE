package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes.dex */
public class ResourceManager {
    private static final String DIALOG_BACKGROUND_IMAGE_NAME = "weibosdk_dialog_bg.9.png";
    public static final int DIALOG_BOTTOM_MARGIN = 10;
    private static final String DIALOG_CLOSE_BUTTON_IMAGE_NAME = "ic_com_sina_weibo_sdk_close.png";
    public static final int DIALOG_LEFT_MARGIN = 10;
    public static final int DIALOG_RIGHT_MARGIN = 10;
    public static final int DIALOG_TOP_MARGIN = 30;
    private static final String DRAWABLE = "drawable";
    private static final String DRAWABLE_HDPI = "drawable-hdpi";
    private static final String DRAWABLE_LDPI = "drawable-ldpi";
    private static final String DRAWABLE_MDPI = "drawable-mdpi";
    private static final String DRAWABLE_XHDPI = "drawable-xhdpi";
    private static final String DRAWABLE_XXHDPI = "drawable-xxhdpi";
    private static final String LOADING_EN = "Loading...";
    private static final String LOADING_ZH_CN = "加载中...";
    private static final String LOADING_ZH_TW = "載入中...";
    private static final String NETWORK_NOT_AVAILABLE_EN = "Network is not available";
    private static final String NETWORK_NOT_AVAILABLE_ZH_CN = "无法连接到网络，请检查网络配置";
    private static final String NETWORK_NOT_AVAILABLE_ZH_TW = "無法連接到網络，請檢查網络配置";
    private static final String[] PRE_INSTALL_DRAWBLE_PATHS;
    private static final String TAG = "com.sina.weibo.sdk.utils.ResourceManager";
    public static final int dimen_dialog_bottom_margin = 4;
    public static final int dimen_dialog_left_margin = 1;
    public static final int dimen_dialog_right_margin = 3;
    public static final int dimen_dialog_top_margin = 2;
    public static final int drawable_dialog_background = 1;
    public static final int drawable_dialog_close_button = 2;
    private static final SparseArray<String> sDrawableMap;
    private static final HashMap<Locale, SparseArray<String>> sLanguageMap;
    private static final SparseIntArray sLayoutMap;
    public static final int string_loading = 1;
    public static final int string_network_not_available = 2;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sLayoutMap = sparseIntArray;
        sparseIntArray.put(1, 10);
        sLayoutMap.put(2, 30);
        sLayoutMap.put(3, 10);
        sLayoutMap.put(4, 10);
        PRE_INSTALL_DRAWBLE_PATHS = new String[]{DRAWABLE_XXHDPI, DRAWABLE_XHDPI, DRAWABLE_HDPI, DRAWABLE_MDPI, DRAWABLE_LDPI, DRAWABLE};
        SparseArray<String> sparseArray = new SparseArray<>();
        sDrawableMap = sparseArray;
        sparseArray.put(1, DIALOG_BACKGROUND_IMAGE_NAME);
        sDrawableMap.put(2, DIALOG_CLOSE_BUTTON_IMAGE_NAME);
        sLanguageMap = new HashMap<>();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        sparseArray2.put(1, LOADING_ZH_CN);
        sparseArray2.put(2, NETWORK_NOT_AVAILABLE_ZH_CN);
        sLanguageMap.put(Locale.SIMPLIFIED_CHINESE, sparseArray2);
        SparseArray<String> sparseArray3 = new SparseArray<>();
        sparseArray3.put(1, LOADING_ZH_TW);
        sparseArray3.put(2, NETWORK_NOT_AVAILABLE_ZH_TW);
        sLanguageMap.put(Locale.TRADITIONAL_CHINESE, sparseArray3);
        SparseArray<String> sparseArray4 = new SparseArray<>();
        sparseArray4.put(1, LOADING_EN);
        sparseArray4.put(2, NETWORK_NOT_AVAILABLE_EN);
        sLanguageMap.put(Locale.ENGLISH, sparseArray4);
    }

    private static Drawable extractDrawable(Context context, String str) throws Exception {
        InputStream open = context.getAssets().open(str);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        TypedValue typedValue = new TypedValue();
        typedValue.density = displayMetrics.densityDpi;
        Drawable createFromResourceStream = Drawable.createFromResourceStream(context.getResources(), typedValue, open, str);
        open.close();
        return createFromResourceStream;
    }

    private static View extractView(Context context, String str, ViewGroup viewGroup) throws Exception {
        return ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(context.getAssets().openXmlResourceParser(str), viewGroup);
    }

    public static String getAppropriatePathOfDrawable(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            LogUtil.e(TAG, "id is NOT correct!");
            return null;
        }
        String currentDpiFolder = getCurrentDpiFolder(context);
        String str2 = String.valueOf(currentDpiFolder) + "/" + str;
        LogUtil.i(TAG, "Maybe the appropriate path: " + str2);
        if (isFileExisted(context, str2)) {
            return str2;
        }
        LogUtil.d(TAG, "Not the correct path, we need to find one...");
        int i = 0;
        boolean z = false;
        while (true) {
            String[] strArr = PRE_INSTALL_DRAWBLE_PATHS;
            if (i >= strArr.length) {
                LogUtil.e(TAG, "Not find the appropriate path for drawable");
                return null;
            }
            if (!z) {
                if (currentDpiFolder.equals(strArr[i])) {
                    LogUtil.i(TAG, "Have Find index: " + i + ", " + PRE_INSTALL_DRAWBLE_PATHS[i]);
                    z = true;
                }
            } else {
                String str3 = String.valueOf(strArr[i]) + "/" + str;
                if (isFileExisted(context, str3)) {
                    return str3;
                }
            }
            i++;
        }
    }

    private static String getCurrentDpiFolder(Context context) {
        int i = context.getResources().getDisplayMetrics().densityDpi;
        return i <= 120 ? DRAWABLE_LDPI : (i <= 120 || i > 160) ? (i <= 160 || i > 240) ? (i <= 240 || i > 320) ? DRAWABLE_XXHDPI : DRAWABLE_XHDPI : DRAWABLE_HDPI : DRAWABLE_MDPI;
    }

    public static int getDimensionPixelSize(int i) {
        return sLayoutMap.get(i, 0);
    }

    public static Drawable getDrawable(Context context, int i) {
        return getDrawableFromAssert(context, getAppropriatePathOfDrawable(context, sDrawableMap.get(i, "")), false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.InputStream] */
    public static Drawable getDrawableFromAssert(Context context, String str, boolean z) {
        InputStream inputStream;
        Drawable drawable = null;
        drawable = null;
        drawable = null;
        drawable = null;
        ?? r1 = 0;
        try {
        } catch (Throwable th) {
            th = th;
            r1 = str;
        }
        try {
            try {
                inputStream = context.getAssets().open(str);
                if (inputStream != null) {
                    try {
                        Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                        if (z) {
                            drawable = new NinePatchDrawable(new Resources(context.getAssets(), displayMetrics, context.getResources().getConfiguration()), decodeStream, decodeStream.getNinePatchChunk(), new Rect(0, 0, 0, 0), null);
                        } else {
                            decodeStream.setDensity(displayMetrics.densityDpi);
                            drawable = new BitmapDrawable(context.getResources(), decodeStream);
                        }
                    } catch (IOException e) {
                        e = e;
                        e.printStackTrace();
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        return drawable;
                    }
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } catch (IOException e3) {
            e = e3;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (r1 != 0) {
                try {
                    r1.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
        if (inputStream != null) {
            inputStream.close();
        }
        return drawable;
    }

    public static Locale getLanguage() {
        Locale locale = Locale.getDefault();
        return (Locale.SIMPLIFIED_CHINESE.equals(locale) || Locale.TRADITIONAL_CHINESE.equals(locale)) ? locale : Locale.ENGLISH;
    }

    public static Drawable getNinePatchDrawable(Context context, int i) {
        return getDrawableFromAssert(context, getAppropriatePathOfDrawable(context, sDrawableMap.get(i, "")), true);
    }

    public static String getString(Context context, int i) {
        return sLanguageMap.get(getLanguage()).get(i, "");
    }

    private static boolean isFileExisted(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        InputStream inputStream = null;
        try {
            try {
                inputStream = context.getAssets().open(str);
                LogUtil.d(TAG, "file [" + str + "] existed");
                if (inputStream == null) {
                    return true;
                }
                try {
                    inputStream.close();
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                    return true;
                }
            } catch (IOException unused) {
                LogUtil.d(TAG, "file [" + str + "] NOT existed");
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                return false;
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            throw th;
        }
    }
}
