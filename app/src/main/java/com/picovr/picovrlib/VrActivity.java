package com.picovr.picovrlib;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityGroup;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.os.picovr.PicoManager;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import com.google.android.exoplayer2.util.MimeTypes;
import com.picovr.picovrlib.ble.BluetoothLeService;
import com.picovr.picovrlib.ble.DeviceScan;
import com.picovr.picovrlib.ble.SPUtils;
import com.picovr.picovrlib.service.LarkConnectService;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.zte.ucs.tvcall.Commons;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Timer;

/* loaded from: classes.dex */
public class VrActivity extends ActivityGroup implements SurfaceHolder.Callback {
    public static final String TAG = "VrActivity";
    private static final int UnityActivity = 0;
    private static Am3dMediaPlayer amsd = null;
    private static final int appExit = 0;
    private static final int appresume = 1;
    static long downTime = 0;
    private static DeviceScan mDeviceScan = null;
    private static PicoManager mPicoManager = null;
    private static AudioManager mam = null;
    private static Timer timer = null;
    public static String unityObjectName = "";
    private static VrActivity vr;
    public long appPtr;
    SoundPool soundPool;
    List<Integer> soundPoolSoundIds;
    List<String> soundPoolSoundNames;
    Surface toastSurface;
    SurfaceTexture toastTexture;
    int[] axisState = new int[6];
    int[] axisAxis = {15, 16, 0, 1, 12, 13};
    int[] axisNegativeButton = {JoyEvent.KEYCODE_DPAD_LEFT, JoyEvent.KEYCODE_DPAD_UP, JoyEvent.KEYCODE_LSTICK_LEFT, JoyEvent.KEYCODE_LSTICK_UP, JoyEvent.KEYCODE_RSTICK_LEFT, JoyEvent.KEYCODE_RSTICK_UP};
    int[] axisPositiveButton = {JoyEvent.KEYCODE_DPAD_RIGHT, JoyEvent.KEYCODE_DPAD_DOWN, JoyEvent.KEYCODE_LSTICK_RIGHT, JoyEvent.KEYCODE_LSTICK_DOWN, JoyEvent.KEYCODE_RSTICK_RIGHT, JoyEvent.KEYCODE_RSTICK_DOWN};

    public static void DownAudio() {
        mam.adjustStreamVolume(3, -1, 4);
    }

    public static void EnableReverb() {
        setAM3DParameter(6, 3, 1);
    }

    public static void EnableSurround() {
        setAM3DParameter(6, 0, 1);
    }

    public static void UpAudio() {
        mam.adjustStreamVolume(3, 1, 4);
    }

    static void adjustVolume_unity(Activity activity, int i) {
        ((AudioManager) activity.getSystemService(MimeTypes.BASE_TYPE_AUDIO)).adjustStreamVolume(3, i, 0);
    }

    public static void changeAudio(int i) {
        int maxAudionumber = getMaxAudionumber();
        if (i < 0) {
            mam.setStreamVolume(3, 0, 4);
        } else if (i >= maxAudionumber) {
            mam.setStreamVolume(3, maxAudionumber, 4);
        } else {
            mam.setStreamVolume(3, i, 4);
        }
    }

    public static void closeEffects() {
        setAM3DParameter(16385, 0, 1);
    }

    public static void closeRoomcharacteristics() {
        setAM3DParameter(6, 13, 1);
    }

    public static boolean compare(String str, String str2) {
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        String str3 = "";
        String str4 = "";
        for (String str5 : split) {
            str4 = String.valueOf(str4) + str5;
        }
        for (String str6 : split2) {
            str3 = String.valueOf(str3) + str6;
        }
        String str7 = String.valueOf(str4) + "0";
        StringBuilder sb = new StringBuilder(String.valueOf(str3));
        sb.append("0");
        return Integer.parseInt(str7) >= Integer.parseInt(sb.toString());
    }

    public static void enableTouchPad(boolean z) {
        PicoManager picoManager = mPicoManager;
        if (picoManager == null) {
            Log.i("berton", " mPicoManager is null");
        } else {
            picoManager.enableTouchPad(z);
        }
    }

    public static void gazeEventFromNative(final float f, final float f2, final boolean z, final boolean z2, final Activity activity) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.picovr.picovrlib.VrActivity.2
            @Override // java.lang.Runnable
            public void run() {
                long uptimeMillis = SystemClock.uptimeMillis();
                if (z) {
                    VrActivity.downTime = uptimeMillis;
                }
                MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
                pointerProperties.toolType = 1;
                int i = 0;
                pointerProperties.id = 0;
                MotionEvent.PointerProperties[] pointerPropertiesArr = {pointerProperties};
                MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
                pointerCoords.x = f;
                pointerCoords.y = f2;
                MotionEvent.PointerCoords[] pointerCoordsArr = {pointerCoords};
                if (!z) {
                    i = z2 ? 1 : 2;
                }
                activity.getWindow().getDecorView().dispatchTouchEvent(MotionEvent.obtain(VrActivity.downTime, uptimeMillis, i, 1, pointerPropertiesArr, pointerCoordsArr, 0, 0, 1.0f, 1.0f, 10, 0, 4098, 0));
            }
        });
    }

    public static int getAudionumber() {
        return mam.getStreamVolume(3);
    }

    public static String getBuildModel() {
        String str = null;
        try {
            str = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.picovr.product.name").getInputStream())).readLine();
            Log.d("Jay", "ro.picovr.product.name = " + str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str != null && !str.isEmpty()) {
            Log.d("Jay", "ro.picovr.product.name is not null");
            return str;
        }
        Log.d("Jay", "ro.picovr.product.name is null");
        return Build.MODEL;
    }

    public static String getCpuTemperature() {
        String str;
        Log.d("berton", "getCpuTemperature");
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/class/thermal/thermal_zone5/temp").start().getInputStream();
            byte[] bArr = new byte[24];
            str = "";
            while (inputStream.read(bArr) != -1) {
                str = String.valueOf(str) + new String(bArr);
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            str = "N/A";
        }
        return str.trim();
    }

    public static double[] getDPIParameters(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            defaultDisplay.getRealMetrics(displayMetrics);
        } catch (NoSuchMethodError unused) {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return new double[]{displayMetrics.widthPixels, displayMetrics.heightPixels, displayMetrics.xdpi, displayMetrics.ydpi, displayMetrics.densityDpi};
    }

    public static String getDeviceProp(int i) {
        PicoManager picoManager = mPicoManager;
        if (picoManager == null) {
            Log.i("berton", " mPicoManager is null");
            return null;
        }
        return picoManager.getDeviceProp(i);
    }

    public static String getDevicePropForUser(int i) {
        String deviceProp = getDeviceProp(8);
        if (deviceProp == null || !compare(deviceProp, "1.0.1")) {
            return "0";
        }
        PicoManager picoManager = mPicoManager;
        if (picoManager == null) {
            Log.i("berton", " mPicoManager is null");
            return null;
        }
        return picoManager.getDevicePropForUser(i);
    }

    public static DistortionParameters getDistortionParameters() {
        String str;
        Log.v("shine", "enter getDistortionParameters");
        DistortionParameters distortionParameters = new DistortionParameters();
        try {
            Method method = mPicoManager.getClass().getMethod("getHmdParameters", String.class);
            if (method == null) {
                distortionParameters.setPicoManagerStutas(1);
                Log.v("shine", "getDistortionParameters method == null");
                return distortionParameters;
            }
            HashMap hashMap = (HashMap) method.invoke(mPicoManager, "");
            if (hashMap.size() <= 0 && !hashMap.containsKey("lensConfig") && !hashMap.containsKey("hmdInfo")) {
                distortionParameters.setPicoManagerStutas(1);
                Log.v("shine", "getDistortionParameters map.size() <= 0");
                return distortionParameters;
            }
            Bundle bundle = (Bundle) hashMap.get("lensConfig");
            int i = bundle.getInt("DistortionEqnType", -100);
            int i2 = bundle.getInt("MaxCoefficients", 0);
            float[] floatArray = bundle.getFloatArray("CoefficientsK");
            float f = bundle.getFloat("MaxR", 0.0f);
            float f2 = bundle.getFloat("MetersPerTanAngelAtCenter", 0.0f);
            float[] floatArray2 = bundle.getFloatArray("ChromaticAberration");
            float[] floatArray3 = bundle.getFloatArray("InvK");
            float f3 = bundle.getFloat("MaxInvR", 0.0f);
            Bundle bundle2 = (Bundle) hashMap.get("hmdInfo");
            float f4 = bundle2.getFloat("lensSeparation", 0.0f);
            float f5 = bundle2.getFloat("widthMeters", 0.0f);
            float f6 = bundle2.getFloat("heightMeters", 0.0f);
            int i3 = bundle2.getInt("widthPixels", 0);
            str = "shine";
            try {
                int i4 = bundle2.getInt("heightPixels", 0);
                float f7 = bundle2.getFloat("horizontalOffsetMeters", 0.0f);
                float f8 = bundle2.getFloat("displayRefreshRate", 0.0f);
                int[] intArray = bundle2.getIntArray("eyeTextureResolution");
                float[] floatArray4 = bundle2.getFloatArray("eyeTextureFov");
                distortionParameters.setEqn(i);
                distortionParameters.setMaxCoefficients(i2);
                distortionParameters.setK(floatArray);
                distortionParameters.setMaxR(f);
                distortionParameters.setMetersPerTanAngleAtCenter(f2);
                distortionParameters.setChromaticAberration(floatArray2);
                distortionParameters.setInvK(floatArray3);
                distortionParameters.setMaxInvR(f3);
                distortionParameters.setLensSeparation(f4);
                distortionParameters.setWidthMeters(f5);
                distortionParameters.setHeightMeters(f6);
                distortionParameters.setWidthPixels(i3);
                distortionParameters.setHeightPixels(i4);
                distortionParameters.setHorizontalOffsetMeters(f7);
                distortionParameters.setDisplayRefreshRate(f8);
                distortionParameters.setEyeTextureResolution(intArray);
                distortionParameters.setEyeTextureFov(floatArray4);
                return distortionParameters;
            } catch (Exception e) {
                e = e;
                Log.e(TAG, e.getMessage());
                distortionParameters.setPicoManagerStutas(1);
                Log.v(str, "getDistortionParameters Exception");
                return distortionParameters;
            }
        } catch (Exception e2) {
            e = e2;
            str = "shine";
        }
    }

    public static int getHidSensorUser() {
        PicoManager picoManager = mPicoManager;
        if (picoManager == null) {
            Log.i("berton", " mPicoManager is null");
            return 0;
        }
        return picoManager.getHidSensorUser();
    }

    public static int getMaxAudionumber() {
        return mam.getStreamMaxVolume(3);
    }

    public static String getRingHapticsName() {
        String str = "";
        for (String str2 : mPicoManager.getRingHapticsName()) {
            str = String.valueOf(str) + str2 + " ";
        }
        return str.substring(0, str.length() - 2);
    }

    public static String getRingHapticsValue(int i) {
        return mPicoManager.getRingHapticsValue(i);
    }

    public static String getRingHapticsValues() {
        String str = "";
        for (String str2 : mPicoManager.getRingHapticsValues()) {
            str = String.valueOf(str) + str2 + " ";
        }
        return str.substring(0, str.length() - 2);
    }

    public static DistortionParameters getScreenParams() {
        Log.v("shine", "enter getScreenParams");
        DistortionParameters distortionParameters = new DistortionParameters();
        try {
            Method method = mPicoManager.getClass().getMethod("getScreenParameters", String.class);
            if (method == null) {
                distortionParameters.setPicoManagerStutas(1);
                Log.v("shine", "getScreenParams method == null");
                return distortionParameters;
            }
            HashMap hashMap = (HashMap) method.invoke(mPicoManager, "");
            if (hashMap.size() <= 0 && !hashMap.containsKey("screenParams")) {
                distortionParameters.setPicoManagerStutas(1);
                Log.v("shine", "getScreenParams map.size() <= 0");
                return distortionParameters;
            }
            Bundle bundle = (Bundle) hashMap.get("screenParams");
            String string = bundle.getString("ScreenName", "");
            int i = bundle.getInt("ScreenWidth", 0);
            int i2 = bundle.getInt("ScreenHeight", 0);
            double d2 = bundle.getDouble("ScreenXppi", 0.0d);
            double d3 = bundle.getDouble("ScreenYppi", 0.0d);
            int i3 = bundle.getInt("ScreenSetupDirection", 0);
            int i4 = bundle.getInt("ScreenRefreshDirection", 0);
            distortionParameters.setScreenName(string);
            distortionParameters.setScreenWidth(i);
            distortionParameters.setScreenHeight(i2);
            distortionParameters.setScreenXppi(d2);
            distortionParameters.setScreenYppi(d3);
            distortionParameters.setScreenRefreshDirectoin(i4);
            distortionParameters.setScreenSetupDirection(i3);
            Log.v("shine", "screenInfo   ScreenName:" + string + ",ScreenWidth:" + i + ",ScreenHeight:" + i2 + ",ScreenXppi:" + d2 + ",ScreenYppi:" + d3 + ",ScreenSetupDirection:" + i3 + ",ScreenRefreshDirection:" + i4);
            return distortionParameters;
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            distortionParameters.setPicoManagerStutas(1);
            Log.v("shine", "getScreenParams Exception");
            return distortionParameters;
        }
    }

    public static int getScreen_Brightness(Context context) {
        Log.i("berton", "============get current birghtness==========");
        try {
            return Settings.System.getInt(context.getContentResolver(), "screen_brightness");
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int getSystemRunLevel(int i) {
        PicoManager picoManager = mPicoManager;
        if (picoManager == null) {
            Log.i("berton", " mPicoManager is null");
            return 0;
        }
        return picoManager.getSystemRunLevel(i);
    }

    public static int getThreadRunCore(int i) {
        PicoManager picoManager = mPicoManager;
        if (picoManager == null) {
            Log.i("berton", " mPicoManager is null");
            return 0;
        }
        return picoManager.getThreadRunCore(i);
    }

    public static int getTouchPadStatus() {
        PicoManager picoManager = mPicoManager;
        if (picoManager == null) {
            Log.i("berton", " mPicoManager is null");
            return 0;
        }
        return picoManager.getTouchPadStatus();
    }

    public static void initAudioDevice(Context context) {
        mam = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
    }

    public static void initFalconDevice(Context context) {
        amsd = new Am3dMediaPlayer();
        mPicoManager = (PicoManager) context.getSystemService("pico_manager");
    }

    public static boolean isBLEConnected(Context context) {
        return BluetoothLeService.isBleConnected;
    }

    public static native void nativeDestroy(long j);

    public static native SurfaceTexture nativeGetPopupSurfaceTexture(long j);

    public static native void nativeJoypadAxis(long j, float f, float f2, float f3, float f4);

    public static native void nativeKeyEvent(long j, int i, boolean z, int i2);

    public static native void nativeNewIntent(long j, String str, String str2, String str3);

    public static native void nativePause(long j);

    public static native void nativePopup(long j, int i, int i2, float f);

    public static native void nativeResume(long j);

    public static native void nativeSurfaceChanged(long j, Surface surface);

    public static native void nativeSurfaceDestroyed(long j);

    public static native void nativeTouch(long j, int i, float f, float f2);

    public static void openEffects() {
        setAM3DParameter(16385, 0, 0);
    }

    public static void openRoomcharacteristics() {
        setAM3DParameter(6, 13, 0);
    }

    public static void playEffectSeqBuff(byte[] bArr, int i, int i2) {
        if (mPicoManager == null) {
            Log.e(TAG, "Error :mPicoManager is null");
            return;
        }
        Log.e("berton", "stopPlayingEffect   " + i2);
        mPicoManager.playEffectSeqBuff(bArr, i, i2);
    }

    public static void playEffectSequence(String str, int i) {
        if (mPicoManager == null) {
            Log.e(TAG, "Error :mPicoManager is null");
            return;
        }
        Log.e("berton", "playEffectSequence  " + str + "  " + i);
        mPicoManager.playEffectSequence(str, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void playPatternRTP(float r9, float r10, final int r11, boolean r12, boolean r13, int r14, float r15, float r16) {
        /*
            r6 = r11
            java.util.Timer r0 = com.picovr.picovrlib.VrActivity.timer
            if (r0 == 0) goto L8
            r0.cancel()
        L8:
            android.os.picovr.PicoManager r0 = com.picovr.picovrlib.VrActivity.mPicoManager
            if (r0 != 0) goto L14
            java.lang.String r0 = "VrActivity"
            java.lang.String r1 = "Error :mPicoManager is null"
            android.util.Log.e(r0, r1)
            return
        L14:
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 1
            r5 = r11
            r0.playPatternRTP(r1, r2, r3, r4, r5)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "stopPlayingEffect   "
            r0.<init>(r1)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "berton"
            android.util.Log.e(r1, r0)
            r0 = 1
            r1 = 1115422720(0x427c0000, float:63.0)
            if (r12 == 0) goto L3e
            float r1 = r1 * r10
            int r1 = java.lang.Math.round(r1)
            int r1 = r1 + 64
        L3c:
            r4 = r1
            goto L50
        L3e:
            if (r13 == 0) goto L4f
            float r1 = r1 * r10
            int r3 = java.lang.Math.round(r1)
            if (r3 != 0) goto L4a
            r1 = 1
            goto L3c
        L4a:
            int r1 = java.lang.Math.round(r1)
            goto L3c
        L4f:
            r4 = 0
        L50:
            r1 = 0
            r3 = 1092616192(0x41200000, float:10.0)
            int r1 = (r16 > r1 ? 1 : (r16 == r1 ? 0 : -1))
            if (r1 <= 0) goto L5e
            int r1 = (r16 > r3 ? 1 : (r16 == r3 ? 0 : -1))
            if (r1 <= 0) goto L5c
            goto L5e
        L5c:
            r3 = r16
        L5e:
            r1 = 1148846080(0x447a0000, float:1000.0)
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r7 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r7 != 0) goto L70
            float r3 = r3 * r1
            int r3 = java.lang.Math.round(r3)
            r7 = r3
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            goto L78
        L70:
            float r3 = r9 * r1
            int r3 = java.lang.Math.round(r3)
            r7 = r3
            r3 = r9
        L78:
            float r1 = r1 * r15
            int r8 = java.lang.Math.round(r1)
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L9c
            java.util.Timer r1 = new java.util.Timer
            r1.<init>(r0)
            com.picovr.picovrlib.VrActivity.timer = r1
            com.picovr.picovrlib.VrActivity$3 r0 = new com.picovr.picovrlib.VrActivity$3
            r0.<init>()
            java.util.Timer r1 = com.picovr.picovrlib.VrActivity.timer
            r2 = 0
            int r7 = r7 + r8
            long r4 = (long) r7
            r9 = r1
            r10 = r0
            r11 = r2
            r13 = r4
            r9.schedule(r10, r11, r13)
            goto La5
        L9c:
            android.os.picovr.PicoManager r0 = com.picovr.picovrlib.VrActivity.mPicoManager
            r1 = r7
            r2 = r8
            r3 = r14
            r5 = r11
            r0.playPatternRTP(r1, r2, r3, r4, r5)
        La5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.picovr.picovrlib.VrActivity.playPatternRTP(float, float, int, boolean, boolean, int, float, float):void");
    }

    public static void playRTPSeqBuff(byte[] bArr, int i, int i2) {
        if (mPicoManager == null) {
            Log.e(TAG, "Error :mPicoManager is null");
            return;
        }
        Log.e("berton", "stopPlayingEffect   " + i2);
        mPicoManager.playRTPSeqBuff(bArr, i, i2);
    }

    public static void playRTPSequence(String str, int i) {
        if (mPicoManager == null) {
            Log.e(TAG, "Error :mPicoManager is null");
            return;
        }
        Log.e("berton", "stopPlayingEffect   " + i);
        mPicoManager.playRTPSequence(str, i);
    }

    public static void playRingHaptics(int i, int i2) {
        if (mPicoManager == null) {
            Log.e(TAG, "Error :mPicoManager is null");
            return;
        }
        Log.e("berton", "stopPlayingEffect   " + i2);
        mPicoManager.playRingHaptics(i, i2);
    }

    public static void playRingSeq(int i, int i2) {
        if (mPicoManager == null) {
            Log.e(TAG, "Error :mPicoManager is null");
            return;
        }
        Log.e("berton", "stopPlayingEffect   " + i2);
        mPicoManager.playRingSeq(i, i2);
    }

    public static void playTimedEffect(int i, int i2) {
        if (mPicoManager == null) {
            Log.e(TAG, "Error :mPicoManager is null");
            return;
        }
        Log.e("berton", "stopPlayingEffect   " + i2);
        mPicoManager.playTimedEffect(i, i2);
    }

    public static void playeffect(int i, int i2) {
        Log.e("berton", "playeffect11111111  " + i + "  " + i2);
        if (mPicoManager == null) {
            Log.e("berton", "Error :mPicoManager is null");
            return;
        }
        Log.e("berton", "playeffect  " + i + "  " + i2);
        mPicoManager.playeffect(i, i2);
    }

    public static void playeffectforce(int i, int i2) {
        if (mPicoManager == null) {
            Log.e(TAG, "Error :mPicoManager is null");
            return;
        }
        Log.e("berton", "stopPlayingEffect   " + i2);
        mPicoManager.playeffectforce(i, i2);
    }

    public static int readDeviceTypeFromWing(Context context) {
        try {
            return context.createPackageContext("com.picovr.wing", 2).getSharedPreferences("bluetooth", 5).getInt("last_connect_device_type", 0);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, e.getMessage());
            return 0;
        }
    }

    public static void releaseAudio() {
        amsd.ReleaseSound();
    }

    public static boolean requestHidSensor(int i) {
        if (mPicoManager == null) {
            Log.i("berton", " mPicoManager is null");
        }
        return false;
    }

    static void sendBroadToService(Activity activity, int i) {
        if (i == 0) {
            Intent intent = new Intent();
            intent.setAction("com.picovr.lite2app.exit");
            activity.sendBroadcast(intent);
        } else if (1 == i) {
            Intent intent2 = new Intent();
            intent2.setAction("com.picovr.lite2app.onresume");
            activity.sendBroadcast(intent2);
        }
    }

    private static void setAM3DParameter(int i, int i2, int i3) {
        amsd.setAudioType(i, i2, i3);
    }

    public static void setAudioHapticEnabled(boolean z, int i) {
        if (mPicoManager == null) {
            Log.e(TAG, "Error :mPicoManager is null");
            return;
        }
        Log.e("berton", "setAudioHapticEnabled  " + z + "  " + i);
        mPicoManager.setAudioHapticEnabled(z, i);
    }

    private void setDefaultLocale() {
        setLocale("en");
    }

    public static boolean setDeviceCpuFreqDefault() {
        PicoManager picoManager = mPicoManager;
        if (picoManager == null) {
            Log.i("colin", " mPicoManager is null");
            return false;
        }
        return picoManager.setDeviceProp(4, WeiboAuthException.DEFAULT_AUTH_ERROR_CODE);
    }

    public static boolean setDeviceProp(int i, String str) {
        PicoManager picoManager = mPicoManager;
        if (picoManager == null) {
            Log.i("berton", " mPicoManager is null");
            return false;
        }
        return picoManager.setDeviceProp(i, str);
    }

    public static boolean setDevicePropForUser(int i, String str) {
        String deviceProp = getDeviceProp(8);
        Log.i("berton", "===================" + deviceProp);
        if (deviceProp == null || !compare(deviceProp, "1.0.1")) {
            return false;
        }
        PicoManager picoManager = mPicoManager;
        if (picoManager == null) {
            Log.i("berton", " mPicoManager is null");
            return false;
        }
        return picoManager.setDevicePropForUser(i, str);
    }

    private void setLocale(String str) {
        Configuration configuration = getResources().getConfiguration();
        Locale locale = new Locale(str);
        configuration.locale = locale;
        VrLib.setCurrentLanguage(locale.getLanguage());
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        new Resources(getAssets(), displayMetrics, configuration);
    }

    public static void setScreen_Brightness(int i, Context context) {
        if (i >= 0 && i <= 255) {
            Settings.System.putInt(context.getContentResolver(), "screen_brightness", i);
        } else if (i < 0) {
            Settings.System.putInt(context.getContentResolver(), "screen_brightness", 0);
        } else if (i > 255) {
            Settings.System.putInt(context.getContentResolver(), "screen_brightness", 255);
        }
    }

    public static void setSurroundroomType(int i) {
        if (i == 1) {
            setAM3DParameter(6, 2, 1);
        } else if (i == 2) {
            setAM3DParameter(6, 2, 3);
        } else if (i == 3) {
            setAM3DParameter(6, 2, 5);
        }
    }

    public static boolean setSystemRunLevel(int i, int i2) {
        PicoManager picoManager = mPicoManager;
        if (picoManager == null) {
            Log.i("berton", " mPicoManager is null");
            return false;
        }
        return picoManager.setSystemRunLevel(i, i2);
    }

    public static boolean setThreadRunCore(int i, int i2) {
        PicoManager picoManager = mPicoManager;
        if (picoManager == null) {
            Log.i("berton", " mPicoManager is null");
            return false;
        }
        return picoManager.setThreadRunCore(i, i2);
    }

    public static void startAudioEffect(Context context, String str, boolean z) {
        Log.i("berton", "===startAudioEffect===" + str);
        amsd.PlaySound(context, str, z);
    }

    public static void startBleDeviceSearch(Context context) {
        DeviceScan deviceScan;
        Log.i(TAG, "startBleDeviceSearch");
        if (!"pico_1s".equalsIgnoreCase(SPUtils.readFromConfigFile()) || BluetoothLeService.mContext == null || (deviceScan = mDeviceScan) == null) {
            return;
        }
        deviceScan.scanLeDevice(true);
    }

    public static void startLarkConnectService(Context context, String str) {
        Log.i(TAG, "startLarkConnectService");
        int readDeviceTypeFromWing = readDeviceTypeFromWing(context);
        unityObjectName = str;
        Log.d(TAG, "screenTypeString = " + readDeviceTypeFromWing);
        if (readDeviceTypeFromWing == 2) {
            Log.i(TAG, "startSPPConnectService");
            context.startService(new Intent(context, (Class<?>) LarkConnectService.class));
        } else {
            Log.i(TAG, "startBluetoothLeService");
            Intent intent = new Intent(context, (Class<?>) BluetoothLeService.class);
            intent.putExtra("app", false);
            context.startService(intent);
        }
    }

    public static void startPeriodService(Context context) {
        Log.i("colin", "startPeriodService");
        context.startService(new Intent(context, (Class<?>) PeriodicService.class));
    }

    public static void stopAudioEffect() {
        amsd.StopSound();
    }

    public static void stopLarkConnectService(Context context) {
        Log.i(TAG, "stopLarkConnectService");
        int readDeviceTypeFromWing = readDeviceTypeFromWing(context);
        Log.d(TAG, "screenTypeString = " + readDeviceTypeFromWing);
        if (readDeviceTypeFromWing == 2) {
            Log.i(TAG, "stopSPPConnectService");
            context.stopService(new Intent(context, (Class<?>) LarkConnectService.class));
        } else {
            Log.i(TAG, "stopBluetoothLeService");
            context.stopService(new Intent(context, (Class<?>) BluetoothLeService.class));
        }
    }

    public static void stopPeriodService(Context context) {
        Log.i("colin", "stopPeriodService");
        context.stopService(new Intent(context, (Class<?>) PeriodicService.class));
    }

    public static void stopPlayingEffect(int i) {
        Timer timer2 = timer;
        if (timer2 != null) {
            timer2.cancel();
        }
        if (mPicoManager == null) {
            Log.e(TAG, "Error :mPicoManager is null");
            return;
        }
        Log.e("berton", "stopPlayingEffect   " + i);
        mPicoManager.stopPlayingEffect(i);
        mPicoManager.playPatternRTP(0, 0, 0, 1, i);
    }

    public static void switchTouchType(int i) {
        PicoManager picoManager = mPicoManager;
        if (picoManager == null) {
            Log.i("berton", " mPicoManager is null");
        } else {
            picoManager.switchTouchType(i);
        }
    }

    public static boolean updateHmdInfo(String[] strArr) {
        PicoManager picoManager = mPicoManager;
        if (picoManager == null) {
            Log.i("berton", " mPicoManager is null");
            return false;
        }
        return picoManager.updateHmdInfo(strArr);
    }

    public static boolean updateHmdPsensorStatus(int i) {
        PicoManager picoManager = mPicoManager;
        if (picoManager == null) {
            return false;
        }
        return picoManager.updateHmdPsensorStatus(i);
    }

    void adjustVolume(int i) {
        ((AudioManager) getSystemService(MimeTypes.BASE_TYPE_AUDIO)).adjustStreamVolume(3, i, 0);
    }

    int axisButtons(int i, float f, int i2, int i3, int i4) {
        int i5 = f < -0.5f ? -1 : f > 0.5f ? 1 : 0;
        if (i5 != i4) {
            if (i4 == -1) {
                buttonEvent(i, i2, false, 0);
            } else if (i4 == 1) {
                buttonEvent(i, i3, false, 0);
            }
            if (i5 == -1) {
                buttonEvent(i, i2, true, 0);
            } else if (i5 == 1) {
                buttonEvent(i, i3, true, 0);
            }
        }
        return i5;
    }

    public boolean buttonEvent(int i, int i2, boolean z, int i3) {
        KeyEvent keyEvent = new KeyEvent(0L, 0L, !z ? 1 : 0, i2, i3);
        if (z) {
            nativeKeyEvent(this.appPtr, i2, true, keyEvent.getRepeatCount());
        } else {
            nativeKeyEvent(this.appPtr, i2, false, 0);
        }
        return true;
    }

    public void clearVrToasts() {
        nativePopup(this.appPtr, 0, 0, -1.0f);
    }

    @SuppressLint({"ShowToast"})
    public void createVrToast(String str) {
        if (str == null) {
            str = "null toast text!";
        }
        if (this.toastTexture == null) {
            SurfaceTexture nativeGetPopupSurfaceTexture = nativeGetPopupSurfaceTexture(this.appPtr);
            this.toastTexture = nativeGetPopupSurfaceTexture;
            if (nativeGetPopupSurfaceTexture == null) {
                return;
            } else {
                this.toastSurface = new Surface(this.toastTexture);
            }
        }
        createVrToast(Toast.makeText(getApplicationContext(), str, 0).getView());
    }

    public void createVrToastOnUiThread(final String str) {
        runOnUiThread(new Thread() { // from class: com.picovr.picovrlib.VrActivity.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                VrActivity.this.createVrToast(str);
            }
        });
    }

    float deadBand(float f) {
        if (f <= -0.01f || f >= 0.01f) {
            return f;
        }
        return 0.0f;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 16) != 0 && motionEvent.getAction() == 2) {
            nativeJoypadAxis(this.appPtr, deadBand(motionEvent.getAxisValue(0)), deadBand(motionEvent.getAxisValue(1)), deadBand(motionEvent.getAxisValue(12)) + deadBand(motionEvent.getAxisValue(11)), deadBand(motionEvent.getAxisValue(13)) + deadBand(motionEvent.getAxisValue(14)));
            for (int i = 0; i < 6; i++) {
                this.axisState[i] = axisButtons(motionEvent.getDeviceId(), motionEvent.getAxisValue(this.axisAxis[i]), this.axisNegativeButton[i], this.axisPositiveButton[i], this.axisState[i]);
            }
            return true;
        }
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z;
        int keyCode = keyEvent.getKeyCode();
        int deviceId = keyEvent.getDeviceId();
        if (keyEvent.getAction() == 0) {
            z = true;
        } else {
            if (keyEvent.getAction() != 1) {
                return super.dispatchKeyEvent(keyEvent);
            }
            z = false;
        }
        if (keyCode == 24) {
            if (z) {
                adjustVolume(1);
            }
            return true;
        }
        if (keyCode == 25) {
            if (z) {
                adjustVolume(-1);
            }
            return true;
        }
        if (keyEvent.getSource() == 1281) {
            keyCode |= 65536;
        }
        return buttonEvent(deviceId, keyCode, z, keyEvent.getRepeatCount());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        nativeTouch(this.appPtr, motionEvent.getAction(), motionEvent.getRawX(), motionEvent.getRawY());
        return true;
    }

    public void finishActivity() {
        finish();
    }

    public String getInstalledPackagePath(String str) {
        String str2;
        for (ApplicationInfo applicationInfo : getPackageManager().getInstalledApplications(0)) {
            String str3 = applicationInfo.className;
            if ((str3 != null && str3.toLowerCase().contains(str)) || ((str2 = applicationInfo.sourceDir) != null && str2.toLowerCase().contains(str))) {
                return applicationInfo.sourceDir;
            }
        }
        return "";
    }

    public String getLocalizedString(String str) {
        int identifier = getResources().getIdentifier(str, "string", getPackageName());
        return (identifier == 0 || identifier == 0) ? "" : getResources().getText(identifier).toString();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        VrLib.setCurrentLanguage(Locale.getDefault().getLanguage());
        this.soundPool = new SoundPool(3, 3, 100);
        this.soundPoolSoundIds = new ArrayList();
        this.soundPoolSoundNames = new ArrayList();
        AudioManager audioManager = (AudioManager) getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        audioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE");
        audioManager.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER");
        getApplicationContext().getSharedPreferences("oculusvr", 0).getString("username", "guest");
        Intent intent = getIntent();
        VrLib.getCommandStringFromIntent(intent);
        VrLib.getPackageStringFromIntent(intent);
        VrLib.getUriStringFromIntent(intent);
        SurfaceView surfaceView = new SurfaceView(this);
        setContentView(surfaceView);
        surfaceView.getHolder().addCallback(this);
        getWindow().addFlags(Commons.MSG_MCSP_INIT_SUCCESS);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.screenBrightness = 1.0f;
        getWindow().setAttributes(attributes);
        mPicoManager = (PicoManager) getSystemService("pico_manager");
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        long j = this.appPtr;
        this.appPtr = 0L;
        nativeDestroy(j);
        this.soundPool.release();
        this.soundPoolSoundIds.clear();
        this.soundPoolSoundNames.clear();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        VrLib.getCommandStringFromIntent(intent);
        VrLib.getPackageStringFromIntent(intent);
        VrLib.getUriStringFromIntent(intent);
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onPause() {
        if (getApplication() instanceof VrApplication) {
            ((VrApplication) getApplication()).setHostActivity(null);
        }
        super.onPause();
        nativePause(this.appPtr);
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onResume() {
        if (getApplication() instanceof VrApplication) {
            ((VrApplication) getApplication()).setHostActivity(this);
        }
        super.onResume();
        nativeResume(this.appPtr);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
    }

    @Override // android.app.ActivityGroup, android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    public void playSoundPoolSound(String str) {
        int i = 0;
        for (int i2 = 0; i2 < this.soundPoolSoundNames.size(); i2++) {
            if (this.soundPoolSoundNames.get(i2).equals(str)) {
                this.soundPool.play(this.soundPoolSoundIds.get(i2).intValue(), 1.0f, 1.0f, 1, 0, 1.0f);
                return;
            }
        }
        if (str.indexOf("res/raw/") == 0) {
            int identifier = getResources().getIdentifier(str.substring(4, str.length() - 4), "raw", getPackageName());
            if (identifier != 0) {
                i = this.soundPool.load(getResources().openRawResourceFd(identifier), 1);
            }
        } else {
            try {
                i = this.soundPool.load(getAssets().openFd(str), 1);
            } catch (IOException unused) {
            }
        }
        if (i == 0) {
            i = this.soundPool.load(str, 1);
        }
        this.soundPoolSoundNames.add(str);
        this.soundPoolSoundIds.add(Integer.valueOf(i));
        this.soundPool.play(this.soundPoolSoundIds.get(this.soundPoolSoundNames.size() - 1).intValue(), 1.0f, 1.0f, 1, 0, 1.0f);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (i2 < i3) {
            return;
        }
        nativeSurfaceChanged(this.appPtr, surfaceHolder.getSurface());
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        nativeSurfaceDestroyed(this.appPtr);
    }

    public void createVrToast(View view) {
        view.measure(0, 0);
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        this.toastTexture.setDefaultBufferSize(view.getWidth(), view.getHeight());
        try {
            Canvas lockCanvas = this.toastSurface.lockCanvas(null);
            view.draw(lockCanvas);
            this.toastSurface.unlockCanvasAndPost(lockCanvas);
        } catch (Exception unused) {
        }
        nativePopup(this.appPtr, view.getWidth(), view.getHeight(), 7.0f);
    }
}
