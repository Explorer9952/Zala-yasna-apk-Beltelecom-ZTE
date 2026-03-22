package kotlin.text;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Appendable.kt */
/* loaded from: classes2.dex */
public class m {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void a(@NotNull Appendable appendable, T t, @Nullable kotlin.jvm.b.l<? super T, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.f.b(appendable, "$this$appendElement");
        if (lVar != null) {
            appendable.append(lVar.invoke(t));
            return;
        }
        if (t != 0 ? t instanceof CharSequence : true) {
            appendable.append((CharSequence) t);
        } else if (t instanceof Character) {
            appendable.append(((Character) t).charValue());
        } else {
            appendable.append(String.valueOf(t));
        }
    }
}
