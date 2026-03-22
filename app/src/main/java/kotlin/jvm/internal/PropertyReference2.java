package kotlin.jvm.internal;

import kotlin.reflect.m;

/* loaded from: classes2.dex */
public abstract class PropertyReference2 extends PropertyReference implements m {
    @Override // kotlin.jvm.internal.CallableReference
    protected kotlin.reflect.b computeReflected() {
        h.a(this);
        return this;
    }

    @Override // kotlin.reflect.m
    public Object getDelegate(Object obj, Object obj2) {
        return ((m) getReflected()).getDelegate(obj, obj2);
    }

    @Override // kotlin.jvm.b.p
    public Object invoke(Object obj, Object obj2) {
        return get(obj, obj2);
    }

    @Override // kotlin.reflect.m
    public m.a getGetter() {
        return ((m) getReflected()).getGetter();
    }
}
