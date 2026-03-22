package kotlin.collections;

import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _ArraysJvm.kt */
/* loaded from: classes2.dex */
public class e extends d {
    @NotNull
    public static <T> List<T> a(@NotNull T[] tArr) {
        kotlin.jvm.internal.f.b(tArr, "$this$asList");
        List<T> a2 = g.a(tArr);
        kotlin.jvm.internal.f.a((Object) a2, "ArraysUtilJVM.asList(this)");
        return a2;
    }
}
