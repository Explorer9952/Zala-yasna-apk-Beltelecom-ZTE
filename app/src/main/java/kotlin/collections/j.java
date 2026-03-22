package kotlin.collections;

import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Collection;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Collections.kt */
/* loaded from: classes2.dex */
public class j extends i {
    @NotNull
    public static final <T> List<T> a() {
        return EmptyList.INSTANCE;
    }

    public static void b() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    @NotNull
    public static <T> List<T> a(@NotNull T... tArr) {
        List<T> a2;
        kotlin.jvm.internal.f.b(tArr, MessengerShareContentUtility.ELEMENTS);
        if (tArr.length <= 0) {
            return a();
        }
        a2 = e.a(tArr);
        return a2;
    }

    @NotNull
    public static kotlin.n.c a(@NotNull Collection<?> collection) {
        kotlin.jvm.internal.f.b(collection, "$this$indices");
        return new kotlin.n.c(0, collection.size() - 1);
    }
}
