package kotlin.jvm.internal;

import kotlin.reflect.h;
import kotlin.reflect.l;

/* loaded from: classes2.dex */
public abstract class MutablePropertyReference1 extends MutablePropertyReference implements kotlin.reflect.h {
    public MutablePropertyReference1() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected kotlin.reflect.b computeReflected() {
        h.a(this);
        return this;
    }

    @Override // kotlin.reflect.l
    public Object getDelegate(Object obj) {
        return ((kotlin.reflect.h) getReflected()).getDelegate(obj);
    }

    @Override // kotlin.jvm.b.l
    public Object invoke(Object obj) {
        return get(obj);
    }

    public MutablePropertyReference1(Object obj) {
        super(obj);
    }

    @Override // kotlin.reflect.l
    public l.a getGetter() {
        return ((kotlin.reflect.h) getReflected()).getGetter();
    }

    @Override // kotlin.reflect.h
    public h.a getSetter() {
        return ((kotlin.reflect.h) getReflected()).getSetter();
    }
}
