package kotlin.internal;

import com.facebook.internal.NativeProtocol;
import kotlin.TypeCastException;
import kotlin.jvm.internal.f;
import kotlin.text.v;
import org.jetbrains.annotations.NotNull;

/* compiled from: PlatformImplementations.kt */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f8176a;

    static {
        a aVar;
        Object newInstance;
        Object newInstance2;
        int a2 = a();
        if (a2 >= 65544) {
            try {
                newInstance = Class.forName("kotlin.internal.jdk8.JDK8PlatformImplementations").newInstance();
                f.a(newInstance, "Class.forName(\"kotlin.in…entations\").newInstance()");
                try {
                } catch (ClassCastException e) {
                    Throwable initCause = new ClassCastException("Instance classloader: " + newInstance.getClass().getClassLoader() + ", base type classloader: " + a.class.getClassLoader()).initCause(e);
                    f.a((Object) initCause, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                    throw initCause;
                }
            } catch (ClassNotFoundException unused) {
                Object newInstance3 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                f.a(newInstance3, "Class.forName(\"kotlin.in…entations\").newInstance()");
                try {
                    if (newInstance3 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    aVar = (a) newInstance3;
                } catch (ClassCastException e2) {
                    Throwable initCause2 = new ClassCastException("Instance classloader: " + newInstance3.getClass().getClassLoader() + ", base type classloader: " + a.class.getClassLoader()).initCause(e2);
                    f.a((Object) initCause2, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                    throw initCause2;
                }
            }
            if (newInstance == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
            }
            aVar = (a) newInstance;
            f8176a = aVar;
        }
        if (a2 >= 65543) {
            try {
                try {
                    newInstance2 = Class.forName("kotlin.internal.d.a").newInstance();
                    f.a(newInstance2, "Class.forName(\"kotlin.in…entations\").newInstance()");
                } catch (ClassNotFoundException unused2) {
                    Object newInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                    f.a(newInstance4, "Class.forName(\"kotlin.in…entations\").newInstance()");
                    try {
                        if (newInstance4 == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        aVar = (a) newInstance4;
                    } catch (ClassCastException e3) {
                        Throwable initCause3 = new ClassCastException("Instance classloader: " + newInstance4.getClass().getClassLoader() + ", base type classloader: " + a.class.getClassLoader()).initCause(e3);
                        f.a((Object) initCause3, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                        throw initCause3;
                    }
                }
            } catch (ClassNotFoundException unused3) {
            }
            try {
                if (newInstance2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                }
                aVar = (a) newInstance2;
                f8176a = aVar;
            } catch (ClassCastException e4) {
                Throwable initCause4 = new ClassCastException("Instance classloader: " + newInstance2.getClass().getClassLoader() + ", base type classloader: " + a.class.getClassLoader()).initCause(e4);
                f.a((Object) initCause4, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                throw initCause4;
            }
        }
        aVar = new a();
        f8176a = aVar;
    }

    private static final int a() {
        int a2;
        int a3;
        String property = System.getProperty("java.specification.version");
        if (property == null) {
            return NativeProtocol.MESSAGE_GET_LIKE_STATUS_REQUEST;
        }
        a2 = v.a((CharSequence) property, '.', 0, false, 6, (Object) null);
        if (a2 < 0) {
            try {
                return Integer.parseInt(property) * 65536;
            } catch (NumberFormatException unused) {
                return NativeProtocol.MESSAGE_GET_LIKE_STATUS_REQUEST;
            }
        }
        int i = a2 + 1;
        a3 = v.a((CharSequence) property, '.', i, false, 4, (Object) null);
        if (a3 < 0) {
            a3 = property.length();
        }
        if (property != null) {
            String substring = property.substring(0, a2);
            f.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (property != null) {
                String substring2 = property.substring(i, a3);
                f.a((Object) substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                try {
                    return (Integer.parseInt(substring) * 65536) + Integer.parseInt(substring2);
                } catch (NumberFormatException unused2) {
                    return NativeProtocol.MESSAGE_GET_LIKE_STATUS_REQUEST;
                }
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
}
