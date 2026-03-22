package com.unity3d.player;

import android.util.Log;

/* loaded from: classes.dex */
final class c {

    /* renamed from: a, reason: collision with root package name */
    protected static boolean f2994a = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public static void Log(int i, String str) {
        if (f2994a) {
            return;
        }
        if (i == 6) {
            Log.e("Unity", str);
        }
        if (i == 5) {
            Log.w("Unity", str);
        }
    }
}
