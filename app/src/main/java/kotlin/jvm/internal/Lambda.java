package kotlin.jvm.internal;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;

/* compiled from: Lambda.kt */
/* loaded from: classes2.dex */
public abstract class Lambda<R> implements e<R>, Serializable {
    private final int arity;

    public Lambda(int i) {
        this.arity = i;
    }

    @Override // kotlin.jvm.internal.e
    public int getArity() {
        return this.arity;
    }

    @NotNull
    public String toString() {
        String a2 = h.a((Lambda) this);
        f.a((Object) a2, "Reflection.renderLambdaToString(this)");
        return a2;
    }
}
