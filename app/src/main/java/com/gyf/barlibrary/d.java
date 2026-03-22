package com.gyf.barlibrary;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: FlymeOSStatusBarFontUtils.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static Method f2373a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f2374b;

    /* renamed from: c, reason: collision with root package name */
    private static Field f2375c;

    /* renamed from: d, reason: collision with root package name */
    private static int f2376d;

    static {
        try {
            f2373a = Activity.class.getMethod("setStatusBarDarkIcon", Integer.TYPE);
        } catch (NoSuchMethodException unused) {
        }
        try {
            f2374b = Activity.class.getMethod("setStatusBarDarkIcon", Boolean.TYPE);
        } catch (NoSuchMethodException unused2) {
        }
        try {
            f2375c = WindowManager.LayoutParams.class.getField("statusBarColor");
        } catch (NoSuchFieldException unused3) {
        }
        try {
            f2376d = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR").getInt(null);
        } catch (IllegalAccessException | NoSuchFieldException unused4) {
        }
    }

    public static int a(int i) {
        return (((((i & 16711680) >> 16) * 38) + (((65280 & i) >> 8) * 75)) + ((i & 255) * 15)) >> 7;
    }

    public static boolean a(int i, int i2) {
        return a(i) < i2;
    }

    public static void b(Window window, int i) {
        try {
            a(window, i);
            if (Build.VERSION.SDK_INT > 22) {
                a(window.getDecorView(), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(Activity activity, int i) {
        Method method = f2373a;
        if (method != null) {
            try {
                method.invoke(activity, Integer.valueOf(i));
                return;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return;
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
                return;
            }
        }
        boolean a2 = a(i, 50);
        if (f2375c != null) {
            a(activity, a2, a2);
            b(activity.getWindow(), i);
        } else {
            a(activity, a2);
        }
    }

    public static void a(Activity activity, boolean z) {
        a(activity, z, true);
    }

    private static boolean a(WindowManager.LayoutParams layoutParams, String str, boolean z) {
        try {
            Field declaredField = layoutParams.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            int i = declaredField.getInt(layoutParams);
            Field declaredField2 = layoutParams.getClass().getDeclaredField("meizuFlags");
            declaredField2.setAccessible(true);
            int i2 = declaredField2.getInt(layoutParams);
            int i3 = z ? i | i2 : (i ^ (-1)) & i2;
            if (i2 == i3) {
                return false;
            }
            declaredField2.setInt(layoutParams, i3);
            return true;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return false;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return false;
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private static void a(View view, boolean z) {
        int i;
        int systemUiVisibility = view.getSystemUiVisibility();
        if (z) {
            i = f2376d | systemUiVisibility;
        } else {
            i = (f2376d ^ (-1)) & systemUiVisibility;
        }
        if (i != systemUiVisibility) {
            view.setSystemUiVisibility(i);
        }
    }

    private static void a(Window window, int i) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        Field field = f2375c;
        if (field != null) {
            try {
                if (field.getInt(attributes) != i) {
                    f2375c.set(attributes, Integer.valueOf(i));
                    window.setAttributes(attributes);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(Window window, boolean z) {
        if (Build.VERSION.SDK_INT < 23) {
            a(window.getAttributes(), "MEIZU_FLAG_DARK_STATUS_BAR_ICON", z);
        } else {
            a(window.getDecorView(), z);
            a(window, 0);
        }
    }

    private static void a(Activity activity, boolean z, boolean z2) {
        Method method = f2374b;
        if (method == null) {
            if (z2) {
                a(activity.getWindow(), z);
                return;
            }
            return;
        }
        try {
            method.invoke(activity, Boolean.valueOf(z));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        }
    }
}
