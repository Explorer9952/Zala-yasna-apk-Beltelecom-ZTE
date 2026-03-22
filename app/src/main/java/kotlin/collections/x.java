package kotlin.collections;

import java.util.Collections;
import java.util.Map;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MapsJVM.kt */
/* loaded from: classes2.dex */
public class x extends w {
    public static int a(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    @NotNull
    public static final <K, V> Map<K, V> a(@NotNull Pair<? extends K, ? extends V> pair) {
        kotlin.jvm.internal.f.b(pair, "pair");
        Map<K, V> singletonMap = Collections.singletonMap(pair.getFirst(), pair.getSecond());
        kotlin.jvm.internal.f.a((Object) singletonMap, "java.util.Collections.si…(pair.first, pair.second)");
        return singletonMap;
    }

    @NotNull
    public static final <K, V> Map<K, V> a(@NotNull Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.f.b(map, "$this$toSingletonMap");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> singletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        kotlin.jvm.internal.f.a((Object) singletonMap, "java.util.Collections.singletonMap(key, value)");
        kotlin.jvm.internal.f.a((Object) singletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return singletonMap;
    }
}
