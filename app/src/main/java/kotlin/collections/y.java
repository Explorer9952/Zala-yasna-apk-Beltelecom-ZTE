package kotlin.collections;

import com.facebook.share.internal.ShareConstants;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TypeCastException;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Maps.kt */
/* loaded from: classes2.dex */
public class y extends x {
    @NotNull
    public static final <K, V> Map<K, V> a() {
        t tVar = t.f8156a;
        if (tVar != null) {
            return tVar;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <K, V> Map<K, V> b(@NotNull Map<K, ? extends V> map) {
        kotlin.jvm.internal.f.b(map, "$this$optimizeReadOnlyMap");
        int size = map.size();
        if (size != 0) {
            return size != 1 ? map : x.a(map);
        }
        return a();
    }

    @NotNull
    public static <K, V> Map<K, V> a(@NotNull Pair<? extends K, ? extends V>... pairArr) {
        kotlin.jvm.internal.f.b(pairArr, "pairs");
        if (pairArr.length <= 0) {
            return a();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(v.a(pairArr.length));
        a(pairArr, linkedHashMap);
        return linkedHashMap;
    }

    public static final <K, V> void a(@NotNull Map<? super K, ? super V> map, @NotNull Pair<? extends K, ? extends V>[] pairArr) {
        kotlin.jvm.internal.f.b(map, "$this$putAll");
        kotlin.jvm.internal.f.b(pairArr, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairArr) {
            map.put(pair.component1(), pair.component2());
        }
    }

    public static final <K, V> void a(@NotNull Map<? super K, ? super V> map, @NotNull Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        kotlin.jvm.internal.f.b(map, "$this$putAll");
        kotlin.jvm.internal.f.b(iterable, "pairs");
        for (Pair<? extends K, ? extends V> pair : iterable) {
            map.put(pair.component1(), pair.component2());
        }
    }

    @NotNull
    public static <K, V> Map<K, V> a(@NotNull Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        kotlin.jvm.internal.f.b(iterable, "$this$toMap");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                return a();
            }
            if (size == 1) {
                return x.a(iterable instanceof List ? (Pair<? extends K, ? extends V>) ((List) iterable).get(0) : iterable.iterator().next());
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(v.a(collection.size()));
            a(iterable, linkedHashMap);
            return linkedHashMap;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        a(iterable, linkedHashMap2);
        return b(linkedHashMap2);
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M a(@NotNull Iterable<? extends Pair<? extends K, ? extends V>> iterable, @NotNull M m) {
        kotlin.jvm.internal.f.b(iterable, "$this$toMap");
        kotlin.jvm.internal.f.b(m, ShareConstants.DESTINATION);
        a(m, iterable);
        return m;
    }

    @NotNull
    public static final <K, V, M extends Map<? super K, ? super V>> M a(@NotNull Pair<? extends K, ? extends V>[] pairArr, @NotNull M m) {
        kotlin.jvm.internal.f.b(pairArr, "$this$toMap");
        kotlin.jvm.internal.f.b(m, ShareConstants.DESTINATION);
        a(m, pairArr);
        return m;
    }
}
