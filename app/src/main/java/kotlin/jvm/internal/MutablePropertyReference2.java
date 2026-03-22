package kotlin.jvm.internal;

import kotlin.reflect.i;
import kotlin.reflect.m;

/* loaded from: classes2.dex */
public abstract class MutablePropertyReference2 extends MutablePropertyReference implements kotlin.reflect.i {
    @Override // kotlin.jvm.internal.CallableReference
    protected kotlin.reflect.b computeReflected() {
        h.a(this);
        return this;
    }

    @Override // kotlin.reflect.m
    public Object getDelegate(Object obj, Object obj2) {
        return ((kotlin.reflect.i) getReflected()).getDelegate(obj, obj2);
    }

    @Override // kotlin.jvm.b.p
    public Object invoke(Object obj, Object obj2) {
        return get(obj, obj2);
    }

    @Override // kotlin.reflect.m
    public m.a getGetter() {
        return ((kotlin.reflect.i) getReflected()).getGetter();
    }

    @Override // kotlin.reflect.i
    public i.a getSetter() {
        return ((kotlin.reflect.i) getReflected()).getSetter();
    }
}
