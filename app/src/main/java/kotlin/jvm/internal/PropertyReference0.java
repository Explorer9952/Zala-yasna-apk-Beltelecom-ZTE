package kotlin.jvm.internal;

import kotlin.reflect.k;

/* loaded from: classes2.dex */
public abstract class PropertyReference0 extends PropertyReference implements kotlin.reflect.k {
    public PropertyReference0() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected kotlin.reflect.b computeReflected() {
        h.a(this);
        return this;
    }

    @Override // kotlin.reflect.k
    public Object getDelegate() {
        return ((kotlin.reflect.k) getReflected()).getDelegate();
    }

    @Override // kotlin.jvm.b.a
    public Object invoke() {
        return get();
    }

    public PropertyReference0(Object obj) {
        super(obj);
    }

    @Override // kotlin.reflect.k
    public k.a getGetter() {
        return ((kotlin.reflect.k) getReflected()).getGetter();
    }
}
