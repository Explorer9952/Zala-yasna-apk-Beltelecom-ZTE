package kotlin.jvm.internal;

import kotlin.reflect.l;
import kotlin.reflect.m;

/* compiled from: Reflection.java */
/* loaded from: classes2.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static final i f8183a;

    static {
        i iVar = null;
        try {
            iVar = (i) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (iVar == null) {
            iVar = new i();
        }
        f8183a = iVar;
    }

    public static kotlin.reflect.c a(Class cls) {
        return f8183a.a(cls);
    }

    public static String a(Lambda lambda) {
        return f8183a.a(lambda);
    }

    public static String a(e eVar) {
        return f8183a.a(eVar);
    }

    public static kotlin.reflect.e a(FunctionReference functionReference) {
        f8183a.a(functionReference);
        return functionReference;
    }

    public static kotlin.reflect.k a(PropertyReference0 propertyReference0) {
        f8183a.a(propertyReference0);
        return propertyReference0;
    }

    public static kotlin.reflect.g a(MutablePropertyReference0 mutablePropertyReference0) {
        f8183a.a(mutablePropertyReference0);
        return mutablePropertyReference0;
    }

    public static l a(PropertyReference1 propertyReference1) {
        f8183a.a(propertyReference1);
        return propertyReference1;
    }

    public static kotlin.reflect.h a(MutablePropertyReference1 mutablePropertyReference1) {
        f8183a.a(mutablePropertyReference1);
        return mutablePropertyReference1;
    }

    public static m a(PropertyReference2 propertyReference2) {
        f8183a.a(propertyReference2);
        return propertyReference2;
    }

    public static kotlin.reflect.i a(MutablePropertyReference2 mutablePropertyReference2) {
        f8183a.a(mutablePropertyReference2);
        return mutablePropertyReference2;
    }
}
