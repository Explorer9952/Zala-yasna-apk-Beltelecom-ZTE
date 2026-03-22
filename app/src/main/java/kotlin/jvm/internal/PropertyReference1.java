package kotlin.jvm.internal;

import kotlin.reflect.l;

/* loaded from: classes2.dex */
public abstract class PropertyReference1 extends PropertyReference implements l {
    public PropertyReference1() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected kotlin.reflect.b computeReflected() {
        h.a(this);
        return this;
    }

    @Override // kotlin.reflect.l
    public Object getDelegate(Object obj) {
        return ((l) getReflected()).getDelegate(obj);
    }

    @Override // kotlin.jvm.b.l
    public Object invoke(Object obj) {
        return get(obj);
    }

    public PropertyReference1(Object obj) {
        super(obj);
    }

    @Override // kotlin.reflect.l
    public l.a getGetter() {
        return ((l) getReflected()).getGetter();
    }
}
