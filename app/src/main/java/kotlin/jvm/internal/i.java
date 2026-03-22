package kotlin.jvm.internal;

import kotlin.reflect.l;
import kotlin.reflect.m;

/* compiled from: ReflectionFactory.java */
/* loaded from: classes2.dex */
public class i {
    public kotlin.reflect.c a(Class cls) {
        return new b(cls);
    }

    public kotlin.reflect.e a(FunctionReference functionReference) {
        return functionReference;
    }

    public kotlin.reflect.g a(MutablePropertyReference0 mutablePropertyReference0) {
        return mutablePropertyReference0;
    }

    public kotlin.reflect.h a(MutablePropertyReference1 mutablePropertyReference1) {
        return mutablePropertyReference1;
    }

    public kotlin.reflect.i a(MutablePropertyReference2 mutablePropertyReference2) {
        return mutablePropertyReference2;
    }

    public kotlin.reflect.k a(PropertyReference0 propertyReference0) {
        return propertyReference0;
    }

    public l a(PropertyReference1 propertyReference1) {
        return propertyReference1;
    }

    public m a(PropertyReference2 propertyReference2) {
        return propertyReference2;
    }

    public String a(Lambda lambda) {
        return a((e) lambda);
    }

    public String a(e eVar) {
        String obj = eVar.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring(21) : obj;
    }
}
