package kotlin.jvm.internal;

import kotlin.reflect.g;
import kotlin.reflect.k;

/* loaded from: classes2.dex */
public abstract class MutablePropertyReference0 extends MutablePropertyReference implements kotlin.reflect.g {
    public MutablePropertyReference0() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected kotlin.reflect.b computeReflected() {
        h.a(this);
        return this;
    }

    @Override // kotlin.reflect.k
    public Object getDelegate() {
        return ((kotlin.reflect.g) getReflected()).getDelegate();
    }

    @Override // kotlin.jvm.b.a
    public Object invoke() {
        return get();
    }

    public MutablePropertyReference0(Object obj) {
        super(obj);
    }

    @Override // kotlin.reflect.k
    public k.a getGetter() {
        return ((kotlin.reflect.g) getReflected()).getGetter();
    }

    @Override // kotlin.reflect.g
    public g.a getSetter() {
        return ((kotlin.reflect.g) getReflected()).getSetter();
    }
}
