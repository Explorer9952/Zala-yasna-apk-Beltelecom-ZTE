package io.reactivex.l.a;

/* compiled from: ObjectHelper.java */
/* loaded from: classes2.dex */
public final class b {

    /* compiled from: ObjectHelper.java */
    /* loaded from: classes2.dex */
    static final class a {
        a() {
        }
    }

    static {
        new a();
    }

    public static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
