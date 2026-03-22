package kotlin.collections;

import java.util.Collection;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Iterables.kt */
/* loaded from: classes2.dex */
public class k extends j {
    public static <T> int a(@NotNull Iterable<? extends T> iterable, int i) {
        kotlin.jvm.internal.f.b(iterable, "$this$collectionSizeOrDefault");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i;
    }
}
