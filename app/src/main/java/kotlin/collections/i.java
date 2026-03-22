package kotlin.collections;

import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CollectionsJVM.kt */
/* loaded from: classes2.dex */
public class i {
    @NotNull
    public static <T> List<T> a(T t) {
        List<T> singletonList = Collections.singletonList(t);
        kotlin.jvm.internal.f.a((Object) singletonList, "java.util.Collections.singletonList(element)");
        return singletonList;
    }
}
