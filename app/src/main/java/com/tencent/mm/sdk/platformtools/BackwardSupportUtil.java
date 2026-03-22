package com.tencent.mm.sdk.platformtools;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.ListView;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes.dex */
public class BackwardSupportUtil {

    /* loaded from: classes.dex */
    public static class AnimationHelper {

        /* loaded from: classes.dex */
        public interface IHelper {
            void cancelAnimation(View view, Animation animation);
        }

        public static void cancelAnimation(View view, Animation animation) {
            if (Build.VERSION.SDK_INT >= 8) {
                new AnimationHelperImpl22().cancelAnimation(view, animation);
            } else {
                new AnimationHelperImpl21below().cancelAnimation(view, animation);
            }
        }

        public static void overridePendingTransition(Activity activity, int i, int i2) {
            activity.overridePendingTransition(i, i2);
        }
    }

    /* loaded from: classes.dex */
    public static class BitmapFactory {
        public static Bitmap decodeFile(String str, float f) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i = (int) (f * 160.0f);
            options.inDensity = i;
            Bitmap decodeFile = android.graphics.BitmapFactory.decodeFile(str, options);
            if (decodeFile != null) {
                decodeFile.setDensity(i);
            }
            return decodeFile;
        }

        public static Bitmap decodeStream(InputStream inputStream) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inDensity = 160;
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return android.graphics.BitmapFactory.decodeStream(inputStream, null, options);
        }

        public static Bitmap decodeStream(InputStream inputStream, float f) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inDensity = (int) (f * 160.0f);
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return android.graphics.BitmapFactory.decodeStream(inputStream, null, options);
        }

        public static int fromDPToPix(Context context, float f) {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
            return Math.round((f * r0.densityDpi) / 160.0f);
        }

        public static Bitmap getBitmapFromURL(String str) {
            try {
                Log.d("MicroMsg.SDK.BackwardSupportUtil", "get bitmap from url:" + str);
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();
                InputStream inputStream = httpURLConnection.getInputStream();
                Bitmap decodeStream = decodeStream(inputStream);
                inputStream.close();
                return decodeStream;
            } catch (IOException e) {
                Log.e("MicroMsg.SDK.BackwardSupportUtil", "get bitmap from url failed");
                e.printStackTrace();
                return null;
            }
        }

        public static String getDisplayDensityType(Context context) {
            StringBuilder sb;
            String str;
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            Configuration configuration = context.getResources().getConfiguration();
            float f = displayMetrics.density;
            if (f < 1.0f) {
                sb = new StringBuilder();
                sb.append("");
                str = "LDPI";
            } else if (f >= 1.5f) {
                sb = new StringBuilder();
                sb.append("");
                str = "HDPI";
            } else {
                sb = new StringBuilder();
                sb.append("");
                str = "MDPI";
            }
            sb.append(str);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append(configuration.orientation == 2 ? "_L" : "_P");
            return sb3.toString();
        }
    }

    /* loaded from: classes.dex */
    public static class ExifHelper {
        public static int getExifOrientation(String str) {
            ExifInterface exifInterface;
            int attributeInt;
            try {
                exifInterface = new ExifInterface(str);
            } catch (IOException e) {
                Log.e("MicroMsg.SDK.BackwardSupportUtil", "cannot read exif" + e);
                exifInterface = null;
            }
            if (exifInterface != null && (attributeInt = exifInterface.getAttributeInt("Orientation", -1)) != -1) {
                if (attributeInt == 3) {
                    return 180;
                }
                if (attributeInt == 6) {
                    return 90;
                }
                if (attributeInt == 8) {
                    return 270;
                }
            }
            return 0;
        }
    }

    /* loaded from: classes.dex */
    public static class SmoothScrollFactory {

        /* loaded from: classes.dex */
        public interface IScroll {
            void doScroll(ListView listView);

            void doScroll(ListView listView, int i);
        }

        public static void scrollTo(ListView listView, int i) {
            if (Build.VERSION.SDK_INT >= 8) {
                new SmoothScrollToPosition22().doScroll(listView, i);
            } else {
                new SmoothScrollToPosition21below().doScroll(listView, i);
            }
        }

        public static void scrollToTop(ListView listView) {
            if (Build.VERSION.SDK_INT >= 8) {
                new SmoothScrollToPosition22().doScroll(listView);
            } else {
                new SmoothScrollToPosition21below().doScroll(listView);
            }
        }
    }
}
