package com.unity3d.player;

import android.os.Bundle;
import android.os.picovr.PicoManager;
import android.util.Log;
import android.view.SurfaceView;

/* loaded from: classes.dex */
public class UnityPlayerNativeActivityPico extends com.picovr.android.sdk.UnityPlayerNativeActivity {
    private static PicoManager mPicoManager;
    public static SurfaceView mSV;
    private static UnityPlayerNativeActivityPico mSigleton;

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
    
        android.util.Log.d("Try", "SurfaceView got");
        r4.setAccessible(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003c, code lost:
    
        r1 = (android.view.SurfaceView) r4.get(com.unity3d.player.UnityPlayerNativeActivityPico.mSigleton.mUnityPlayer);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0051, code lost:
    
        r4.setAccessible(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0055, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0056, code lost:
    
        r2 = r1;
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005f, code lost:
    
        r1.printStackTrace();
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004c, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004d, code lost:
    
        r1.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0050, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0047, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
    
        r1.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0065 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.view.Surface getSurfaceView() {
        /*
            android.view.SurfaceView r0 = com.unity3d.player.UnityPlayerNativeActivityPico.mSV
            if (r0 == 0) goto Ld
            android.view.SurfaceHolder r0 = r0.getHolder()
            android.view.Surface r0 = r0.getSurface()
            return r0
        Ld:
            r0 = 0
            java.lang.String r1 = "com.unity3d.player.UnityPlayer"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.ClassNotFoundException -> L5d
            java.lang.reflect.Field[] r1 = r1.getDeclaredFields()     // Catch: java.lang.ClassNotFoundException -> L5d
            r2 = 0
            r3 = 0
        L1a:
            int r4 = r1.length     // Catch: java.lang.ClassNotFoundException -> L5d
            if (r3 < r4) goto L1f
            r1 = r0
            goto L63
        L1f:
            r4 = r1[r3]     // Catch: java.lang.ClassNotFoundException -> L5d
            java.lang.Class r5 = r4.getType()     // Catch: java.lang.ClassNotFoundException -> L5d
            java.lang.String r5 = r5.getSimpleName()     // Catch: java.lang.ClassNotFoundException -> L5d
            java.lang.String r6 = "SurfaceView"
            boolean r5 = r5.equals(r6)     // Catch: java.lang.ClassNotFoundException -> L5d
            if (r5 == 0) goto L5a
            java.lang.String r1 = "Try"
            java.lang.String r3 = "SurfaceView got"
            android.util.Log.d(r1, r3)     // Catch: java.lang.ClassNotFoundException -> L5d
            r1 = 1
            r4.setAccessible(r1)     // Catch: java.lang.ClassNotFoundException -> L5d
            com.unity3d.player.UnityPlayerNativeActivityPico r1 = com.unity3d.player.UnityPlayerNativeActivityPico.mSigleton     // Catch: java.lang.IllegalArgumentException -> L47 java.lang.IllegalAccessException -> L4c java.lang.ClassNotFoundException -> L5d
            com.unity3d.player.UnityPlayer r1 = r1.mUnityPlayer     // Catch: java.lang.IllegalArgumentException -> L47 java.lang.IllegalAccessException -> L4c java.lang.ClassNotFoundException -> L5d
            java.lang.Object r1 = r4.get(r1)     // Catch: java.lang.IllegalArgumentException -> L47 java.lang.IllegalAccessException -> L4c java.lang.ClassNotFoundException -> L5d
            android.view.SurfaceView r1 = (android.view.SurfaceView) r1     // Catch: java.lang.IllegalArgumentException -> L47 java.lang.IllegalAccessException -> L4c java.lang.ClassNotFoundException -> L5d
            goto L51
        L47:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.ClassNotFoundException -> L5d
            goto L50
        L4c:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.ClassNotFoundException -> L5d
        L50:
            r1 = r0
        L51:
            r4.setAccessible(r2)     // Catch: java.lang.ClassNotFoundException -> L55
            goto L63
        L55:
            r2 = move-exception
            r7 = r2
            r2 = r1
            r1 = r7
            goto L5f
        L5a:
            int r3 = r3 + 1
            goto L1a
        L5d:
            r1 = move-exception
            r2 = r0
        L5f:
            r1.printStackTrace()
            r1 = r2
        L63:
            if (r1 != 0) goto L66
            return r0
        L66:
            com.unity3d.player.UnityPlayerNativeActivityPico.mSV = r1
            r1.getHolder()
            android.view.SurfaceView r0 = com.unity3d.player.UnityPlayerNativeActivityPico.mSV
            android.view.SurfaceHolder r0 = r0.getHolder()
            r0.getSurface()
            android.view.SurfaceView r0 = com.unity3d.player.UnityPlayerNativeActivityPico.mSV
            android.view.SurfaceHolder r0 = r0.getHolder()
            android.view.Surface r0 = r0.getSurface()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.player.UnityPlayerNativeActivityPico.getSurfaceView():android.view.Surface");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.picovr.android.sdk.UnityPlayerNativeActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (mSigleton != this) {
            mSigleton = this;
        }
        PicoManager picoManager = (PicoManager) getSystemService("pico_manager");
        mPicoManager = picoManager;
        if (picoManager != null) {
            Log.d("Try", "UnityPlayerActivityPico onCreate = " + mPicoManager.getDeviceProp(4));
            mPicoManager.setDeviceProp(4, "0, 1478400, 1593600");
            mPicoManager.setDeviceProp(4, "1, 1478400, 1593600");
            mPicoManager.setDeviceProp(4, "2, 2073600, 2150400");
            mPicoManager.setDeviceProp(4, "3, 2073600, 2150400");
            Log.d("Try", "UnityPlayerActivityPico onCreate = " + mPicoManager.getDeviceProp(4));
        }
    }
}
