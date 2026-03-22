package kotlin.jvm.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KVisibility;
import kotlin.reflect.n;

/* loaded from: classes2.dex */
public abstract class CallableReference implements kotlin.reflect.b, Serializable {
    public static final Object NO_RECEIVER = a.f8177a;
    protected final Object receiver;
    private transient kotlin.reflect.b reflected;

    /* loaded from: classes2.dex */
    private static class a implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        private static final a f8177a = new a();

        private a() {
        }

        private Object readResolve() throws ObjectStreamException {
            return f8177a;
        }
    }

    public CallableReference() {
        this(NO_RECEIVER);
    }

    @Override // kotlin.reflect.b
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // kotlin.reflect.b
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public kotlin.reflect.b compute() {
        kotlin.reflect.b bVar = this.reflected;
        if (bVar != null) {
            return bVar;
        }
        kotlin.reflect.b computeReflected = computeReflected();
        this.reflected = computeReflected;
        return computeReflected;
    }

    protected abstract kotlin.reflect.b computeReflected();

    @Override // kotlin.reflect.a
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    public String getName() {
        throw new AbstractMethodError();
    }

    public kotlin.reflect.d getOwner() {
        throw new AbstractMethodError();
    }

    @Override // kotlin.reflect.b
    public List<Object> getParameters() {
        return getReflected().getParameters();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public kotlin.reflect.b getReflected() {
        kotlin.reflect.b compute = compute();
        if (compute != this) {
            return compute;
        }
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // kotlin.reflect.b
    public n getReturnType() {
        return getReflected().getReturnType();
    }

    public String getSignature() {
        throw new AbstractMethodError();
    }

    @Override // kotlin.reflect.b
    public List<Object> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // kotlin.reflect.b
    public KVisibility getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // kotlin.reflect.b
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // kotlin.reflect.b
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // kotlin.reflect.b
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // kotlin.reflect.b
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CallableReference(Object obj) {
        this.receiver = obj;
    }
}
