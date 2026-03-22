package com.video.androidsdk.common.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.video.androidsdk.log.LogEx;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class BitmapUtil {
    public static final int INT_FULL_SCLAE = 0;
    public static final int INT_NO_SCLAE = 2;
    public static final int INT_ORIENTATION_HORIZONTAL = 0;
    public static final int INT_ORIENTATION_VERTICAL = 1;
    public static final int INT_UN_FULL_SCLAE = 1;
    private static final String LOG_TAG = "BitmapUtil";
    private static int m_iDefaultMaxHeight = 400;
    private static int m_iDefaultMaxWidth = 300;
    private static int m_iMaxBitmapSize = 1048576;
    private static int miScale = 2;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class FlushedInputStream extends FilterInputStream {
        public FlushedInputStream(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j) throws IOException {
            long j2 = 0;
            while (j2 < j) {
                long skip = ((FilterInputStream) this).in.skip(j - j2);
                if (skip == 0) {
                    SecurityUtil.securityCheck(((FilterInputStream) this).in.toString(), "read");
                    if (read() < 0) {
                        break;
                    }
                    skip = 1;
                }
                j2 += skip;
            }
            return j2;
        }
    }

    public static byte[] bitmap2Bytes(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (OutOfMemoryError e) {
            LogEx.w(LOG_TAG, e.getMessage());
            return null;
        }
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        int round;
        if (i == 0 || i2 == 0) {
            return 1;
        }
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i3 > i2 || i4 > i) {
            round = Math.round(i3 / i2);
            int round2 = Math.round(i4 / i);
            if (round < round2) {
                round = round2;
            }
        } else {
            round = 1;
        }
        if (round < 1) {
            return 1;
        }
        return round;
    }

    public static ThumbBitmap compressThumb(Bitmap bitmap, int i, int i2, int i3, Context context) {
        byte[] bitmap2Bytes;
        if (bitmap == null) {
            return null;
        }
        try {
            ThumbBitmap thumbBitmap = new ThumbBitmap();
            int i4 = 1;
            if (bitmap.getWidth() <= i && bitmap.getHeight() <= i2) {
                bitmap2Bytes = bitmap2Bytes(bitmap);
            } else {
                int round = Math.round(bitmap.getHeight() / i2);
                int round2 = Math.round(bitmap.getWidth() / i);
                if (round <= round2) {
                    round = round2;
                }
                bitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / round, bitmap.getHeight() / round, true);
                bitmap2Bytes = bitmap2Bytes(bitmap);
            }
            if (bitmap2Bytes != null) {
                LogEx.d(LOG_TAG, "Bitmap size :" + bitmap2Bytes.length);
                if (bitmap2Bytes.length < i3) {
                    thumbBitmap.setBitmap(bitmap);
                    thumbBitmap.setCache(bitmap2Bytes);
                    LogEx.d(LOG_TAG, "Bitmap size after: " + bitmap2Bytes.length);
                    return thumbBitmap;
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                options.inDither = true;
                options.inJustDecodeBounds = true;
                options.inPurgeable = true;
                if (context != null) {
                    options.inScreenDensity = context.getResources().getDisplayMetrics().densityDpi;
                }
                if (bitmap2Bytes.length > i3) {
                    options.inTempStorage = new byte[i3];
                }
                BitmapFactory.decodeByteArray(bitmap2Bytes, 0, bitmap2Bytes.length, options);
                int i5 = options.outHeight;
                int i6 = options.outWidth;
                if (i5 > i2 || i6 > i) {
                    int round3 = Math.round(i5 / i2);
                    int round4 = Math.round(i6 / i);
                    i4 = round3 < round4 ? round3 : round4;
                }
                options.inJustDecodeBounds = false;
                options.inSampleSize = i4;
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bitmap2Bytes, 0, bitmap2Bytes.length, options);
                byte[] bitmap2Bytes2 = bitmap2Bytes(decodeByteArray);
                thumbBitmap.setBitmap(decodeByteArray);
                thumbBitmap.setCache(bitmap2Bytes2);
                if (bitmap2Bytes2 != null) {
                    LogEx.d(LOG_TAG, "Bitmap size after: " + bitmap2Bytes2.length);
                }
            }
            return thumbBitmap;
        } catch (OutOfMemoryError e) {
            LogEx.w(LOG_TAG, e.getMessage());
            return null;
        }
    }

    public static Bitmap convertViewToBitmap(View view) {
        if (view == null) {
            LogEx.w(LOG_TAG, "view is null!");
            return null;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        return view.getDrawingCache();
    }

    public static Bitmap createReflectImages(Bitmap bitmap) {
        return createReflectImages(bitmap, 2, 0, -2130706433, 16777215);
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable == null) {
            LogEx.w(LOG_TAG, "drawable is null!");
            return null;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    public static int getDefaultMaxHeight() {
        return m_iDefaultMaxHeight;
    }

    public static int getDefaultMaxWidth() {
        return m_iDefaultMaxWidth;
    }

    public static BitmapFactory.Options initOptions() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inTempStorage = new byte[16384];
        return options;
    }

    public static Bitmap joinBitmap(Bitmap[] bitmapArr, int i) {
        int i2;
        int i3;
        if (bitmapArr == null) {
            return null;
        }
        int i4 = 0;
        try {
            if (1 == i) {
                i2 = 0;
                i3 = 0;
                for (Bitmap bitmap : bitmapArr) {
                    if (bitmap != null) {
                        i3 += bitmap.getHeight();
                        i2 = Math.max(i2, bitmap.getWidth());
                    }
                }
            } else {
                i2 = 0;
                i3 = 0;
                for (Bitmap bitmap2 : bitmapArr) {
                    if (bitmap2 != null) {
                        i2 += bitmap2.getWidth();
                        i3 = Math.max(i3, bitmap2.getHeight());
                    }
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            if (1 == i) {
                int length = bitmapArr.length;
                int i5 = 0;
                while (i4 < length) {
                    Bitmap bitmap3 = bitmapArr[i4];
                    if (bitmap3 != null) {
                        canvas.drawBitmap(bitmap3, 0.0f, i5, (Paint) null);
                        i5 += bitmap3.getHeight();
                        bitmap3.recycle();
                    }
                    i4++;
                }
            } else {
                int length2 = bitmapArr.length;
                int i6 = 0;
                while (i4 < length2) {
                    Bitmap bitmap4 = bitmapArr[i4];
                    if (bitmap4 != null) {
                        canvas.drawBitmap(bitmap4, i6, 0.0f, (Paint) null);
                        i6 += bitmap4.getWidth();
                        bitmap4.recycle();
                    }
                    i4++;
                }
            }
            return createBitmap;
        } catch (Exception e) {
            LogEx.e(LOG_TAG, e.getMessage());
            return null;
        }
    }

    public static Drawable joinDrawable(Drawable[] drawableArr, int i) {
        int i2;
        int i3;
        if (drawableArr == null) {
            return null;
        }
        int i4 = 0;
        try {
            if (1 == i) {
                i2 = 0;
                i3 = 0;
                for (Drawable drawable : drawableArr) {
                    if (drawable != null) {
                        i2 += drawable.getIntrinsicHeight();
                        i3 = Math.max(i3, drawable.getIntrinsicWidth());
                    }
                }
            } else {
                i2 = 0;
                i3 = 0;
                for (Drawable drawable2 : drawableArr) {
                    if (drawable2 != null) {
                        i3 += drawable2.getIntrinsicWidth();
                        i2 = Math.max(i2, drawable2.getIntrinsicHeight());
                    }
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(i3, i2, drawableArr[0].getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            if (1 == i) {
                int length = drawableArr.length;
                int i5 = 0;
                while (i4 < length) {
                    Drawable drawable3 = drawableArr[i4];
                    if (drawable3 != null) {
                        canvas.drawBitmap(drawableToBitmap(drawable3), 0.0f, i5, (Paint) null);
                        i5 += drawable3.getIntrinsicHeight();
                    }
                    i4++;
                }
            } else {
                int length2 = drawableArr.length;
                int i6 = 0;
                while (i4 < length2) {
                    Drawable drawable4 = drawableArr[i4];
                    if (drawable4 != null) {
                        canvas.drawBitmap(drawableToBitmap(drawable4), i6, 0.0f, (Paint) null);
                        i6 += drawable4.getIntrinsicWidth();
                    }
                    i4++;
                }
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
            bitmapDrawable.setAntiAlias(true);
            bitmapDrawable.setFilterBitmap(true);
            return bitmapDrawable;
        } catch (Exception e) {
            LogEx.e(LOG_TAG, e.getMessage());
            return null;
        }
    }

    public static Bitmap readBitMap(Context context, int i) throws Exception {
        if (context == null || i <= 0) {
            return null;
        }
        try {
            return BitmapFactory.decodeResource(context.getResources(), i, initOptions());
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            LogEx.w(LOG_TAG, e.getMessage());
            return null;
        }
    }

    public static Bitmap readBitmap(String str) {
        return readBitmap(str, (BitmapFactory.Options) null);
    }

    public static Bitmap readBitmapForFixMaxSize(String str) {
        return readBitmapForFixMaxSize(str, m_iDefaultMaxWidth, m_iDefaultMaxHeight);
    }

    public static byte[] readStream(InputStream inputStream) throws Exception {
        if (inputStream == null) {
            LogEx.w(LOG_TAG, "inStream is null!");
            return null;
        }
        int available = inputStream.available();
        if (available == 0) {
            LogEx.w(LOG_TAG, "iTotalDataCount is zero!");
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[available];
        SecurityUtil.securityCheck(inputStream.toString(), "read");
        do {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        } while (byteArrayOutputStream.size() <= m_iMaxBitmapSize);
        LogEx.w(LOG_TAG, "Exceed max bitmap size:" + byteArrayOutputStream.size() + ",max:" + m_iMaxBitmapSize + ",iTotalDataCount=" + available);
        return null;
    }

    public static Bitmap scaleBitmap(int i, int i2, Bitmap bitmap, int i3) {
        return scaleBitmap(i, i2, bitmap, i3, false);
    }

    public static void setDefaultMaxSize(int i, int i2) {
        m_iDefaultMaxWidth = i;
        m_iDefaultMaxHeight = i2;
    }

    public static void setMaxBitmapSize(int i) {
        m_iMaxBitmapSize = i;
    }

    public static void setReflectScale(int i) {
        miScale = i;
    }

    public static int sizeOfBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public static Bitmap toRoundCorner(Bitmap bitmap, int i) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        float f = i;
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        bitmap.recycle();
        return createBitmap;
    }

    public static Drawable zoomDrawable(Drawable drawable, int i, int i2) {
        if (drawable != null && i >= 0 && i2 >= 0) {
            try {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                Bitmap drawableToBitmap = drawableToBitmap(drawable);
                Matrix matrix = new Matrix();
                matrix.postScale(i > 0 ? i / intrinsicWidth : 1.0f, i2 > 0 ? i2 / intrinsicHeight : 1.0f);
                Bitmap createBitmap = Bitmap.createBitmap(drawableToBitmap, 0, 0, intrinsicWidth, intrinsicHeight, matrix, true);
                drawableToBitmap.recycle();
                BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
                bitmapDrawable.setAntiAlias(true);
                bitmapDrawable.setFilterBitmap(true);
                return bitmapDrawable;
            } catch (Exception e) {
                e.printStackTrace();
                LogEx.e(LOG_TAG, e.getMessage());
            }
        }
        return null;
    }

    public static Bitmap createReflectImages(Bitmap bitmap, int i, int i2, int i3, int i4) {
        Bitmap createBitmap;
        int i5;
        Bitmap createBitmap2;
        Bitmap bitmap2 = null;
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        try {
            Matrix matrix = new Matrix();
            matrix.preScale(1.0f, -1.0f);
            createBitmap = Bitmap.createBitmap(bitmap, 0, height - (height / i), width, height / i, matrix, false);
            i5 = height + i2;
            createBitmap2 = Bitmap.createBitmap(width, (height / i) + i5, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError e) {
            e = e;
        }
        try {
            Canvas canvas = new Canvas(createBitmap2);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            bitmap.recycle();
            if (i2 > 0) {
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setFilterBitmap(true);
                paint.setAlpha(0);
                canvas.drawRect(0.0f, height, width, i5, paint);
            }
            float f = i5;
            canvas.drawBitmap(createBitmap, 0.0f, f, (Paint) null);
            Paint paint2 = new Paint();
            paint2.setAntiAlias(true);
            paint2.setFilterBitmap(true);
            paint2.setShader(new LinearGradient(0.0f, height, 0.0f, createBitmap2.getHeight() + i2, i3, i4, Shader.TileMode.CLAMP));
            paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas.drawRect(0.0f, f, width, createBitmap2.getHeight(), paint2);
            return createBitmap2;
        } catch (OutOfMemoryError e2) {
            e = e2;
            bitmap2 = createBitmap2;
            e.printStackTrace();
            LogEx.w(LOG_TAG, e.getMessage());
            return bitmap2;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean] */
    public static Bitmap readBitmap(String str, BitmapFactory.Options options) {
        FileInputStream fileInputStream;
        ?? isEmptyString = StringUtil.isEmptyString(str);
        FileInputStream fileInputStream2 = null;
        try {
            if (isEmptyString != 0) {
                LogEx.w(LOG_TAG, "strPathName is empty!");
                return null;
            }
            try {
                fileInputStream = new FileInputStream(new File(str));
                try {
                    byte[] readStream = readStream(fileInputStream);
                    if (readStream != null) {
                        if (readStream.length != 0) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            try {
                                int length = readStream.length;
                                if (options == null) {
                                    options = initOptions();
                                }
                                return BitmapFactory.decodeByteArray(readStream, 0, length, options);
                            } catch (OutOfMemoryError e2) {
                                e2.printStackTrace();
                                LogEx.w(LOG_TAG, e2.getMessage());
                                return null;
                            }
                        }
                    }
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    return null;
                } catch (FileNotFoundException e4) {
                    e = e4;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    return null;
                } catch (Exception e6) {
                    e = e6;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (FileNotFoundException e8) {
                e = e8;
                fileInputStream = null;
            } catch (Exception e9) {
                e = e9;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = isEmptyString;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0110 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap readBitmapForFixMaxSize(java.lang.String r5, int r6, int r7) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.video.androidsdk.common.util.BitmapUtil.readBitmapForFixMaxSize(java.lang.String, int, int):android.graphics.Bitmap");
    }

    public static Bitmap scaleBitmap(int i, int i2, Bitmap bitmap, int i3, boolean z) {
        Bitmap createScaledBitmap;
        Bitmap bitmap2 = null;
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        try {
            if (i3 == 0) {
                bitmap2 = Bitmap.createScaledBitmap(bitmap, i, i2, true);
                if (z) {
                    bitmap.recycle();
                }
            } else if (i3 == 1) {
                if (width > i && height > i2) {
                    float f = width;
                    float f2 = f / i;
                    float f3 = height;
                    float f4 = f3 / i2;
                    if (f2 <= f4) {
                        f2 = f4;
                    }
                    createScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) (f / f2), (int) (f3 / f2), true);
                } else if (width <= i && height > i2) {
                    createScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) ((i2 * width) / height), i2, true);
                } else if (width > i && height <= i2) {
                    createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, (int) ((i * height) / width), true);
                } else {
                    float f5 = width;
                    float f6 = i / f5;
                    float f7 = height;
                    float f8 = i2 / f7;
                    if (f6 > f8) {
                        f6 = f8;
                    }
                    createScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) (f5 * f6), (int) (f7 * f6), true);
                }
                bitmap2 = createScaledBitmap;
                if (z) {
                    bitmap.recycle();
                }
            } else if (i3 == 2) {
                return bitmap;
            }
        } catch (OutOfMemoryError e) {
            LogEx.w(LOG_TAG, e.getMessage());
        }
        return bitmap2;
    }

    public static Bitmap readBitmap(InputStream inputStream) {
        return readBitmap(inputStream, m_iDefaultMaxWidth, m_iDefaultMaxHeight);
    }

    public static Bitmap readBitmap(InputStream inputStream, BitmapFactory.Options options) {
        if (inputStream == null) {
            return null;
        }
        if (options == null) {
            try {
                options = initOptions();
            } catch (OutOfMemoryError e) {
                LogEx.w(LOG_TAG, e.getMessage());
                return null;
            }
        }
        return BitmapFactory.decodeStream(inputStream, null, options);
    }

    public static Bitmap readBitmap(InputStream inputStream, int i, int i2) {
        Bitmap decodeStream;
        if (inputStream == null) {
            LogEx.w(LOG_TAG, "isBitmap is null!");
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeStream(inputStream, null, options);
            int calculateInSampleSize = calculateInSampleSize(options, i, i2);
            BitmapFactory.Options initOptions = initOptions();
            initOptions.inSampleSize = calculateInSampleSize;
            initOptions.inJustDecodeBounds = false;
            decodeStream = BitmapFactory.decodeStream(inputStream, null, initOptions);
        } catch (Exception e) {
            e.printStackTrace();
            LogEx.e(LOG_TAG, "Read bitmap file error!" + e.getMessage());
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            LogEx.e(LOG_TAG, e2.getMessage());
        }
        if (decodeStream != null) {
            return decodeStream;
        }
        LogEx.e(LOG_TAG, "Failed to decodeFile File!");
        return null;
    }

    public static Bitmap readBitmap(byte[] bArr, int i, int i2) {
        Bitmap decodeByteArray;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeStream(byteArrayInputStream, null, options);
            int calculateInSampleSize = calculateInSampleSize(options, i, i2);
            BitmapFactory.Options initOptions = initOptions();
            initOptions.inSampleSize = calculateInSampleSize;
            initOptions.inJustDecodeBounds = false;
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, initOptions);
        } catch (Exception e) {
            e.printStackTrace();
            LogEx.e(LOG_TAG, "Read bitmap file error!" + e.getMessage());
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            LogEx.e(LOG_TAG, e2.getMessage());
        }
        if (decodeByteArray != null) {
            return decodeByteArray;
        }
        LogEx.e(LOG_TAG, "Failed to decodeFile File!");
        return null;
    }
}
