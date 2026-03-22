package com.bumptech.glide.s;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Looper;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/* compiled from: Util.java */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f2350a = "0123456789abcdef".toCharArray();

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f2351b = new char[64];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Util.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2352a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f2352a = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2352a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2352a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2352a[Bitmap.Config.ARGB_8888.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static String a(byte[] bArr) {
        String a2;
        synchronized (f2351b) {
            a2 = a(bArr, f2351b);
        }
        return a2;
    }

    public static void b() {
        if (!d()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    private static boolean b(int i) {
        return i > 0 || i == Integer.MIN_VALUE;
    }

    public static boolean c() {
        return !d();
    }

    public static boolean d() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    private static String a(byte[] bArr, char[] cArr) {
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            char[] cArr2 = f2350a;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    @TargetApi(19)
    public static int a(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
            }
        }
        return bitmap.getHeight() * bitmap.getRowBytes();
    }

    public static int a(int i, int i2, Bitmap.Config config) {
        return i * i2 * a(config);
    }

    private static int a(Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i = a.f2352a[config.ordinal()];
        if (i != 1) {
            return (i == 2 || i == 3) ? 2 : 4;
        }
        return 1;
    }

    public static boolean a(int i, int i2) {
        return b(i) && b(i2);
    }

    public static void a() {
        if (!c()) {
            throw new IllegalArgumentException("YOu must call this method on a background thread");
        }
    }

    public static <T> Queue<T> a(int i) {
        return new ArrayDeque(i);
    }

    public static <T> List<T> a(Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<T> it2 = collection.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next());
        }
        return arrayList;
    }
}
