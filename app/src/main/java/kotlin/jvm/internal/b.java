package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.x;
import kotlin.collections.y;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.jvm.b.l;
import kotlin.jvm.b.m;
import kotlin.jvm.b.n;
import kotlin.jvm.b.o;
import kotlin.jvm.b.p;
import kotlin.jvm.b.q;
import kotlin.jvm.b.r;
import kotlin.jvm.b.s;
import kotlin.jvm.b.t;
import kotlin.jvm.b.u;
import kotlin.jvm.b.v;
import kotlin.jvm.b.w;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClassReference.kt */
/* loaded from: classes2.dex */
public final class b implements kotlin.reflect.c<Object>, kotlin.jvm.internal.a {

    /* renamed from: b, reason: collision with root package name */
    private static final Map<Class<? extends kotlin.c<?>>, Integer> f8178b;

    /* renamed from: c, reason: collision with root package name */
    private static final HashMap<String, String> f8179c;

    /* renamed from: d, reason: collision with root package name */
    private static final HashMap<String, String> f8180d;
    private static final HashMap<String, String> e;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Class<?> f8181a;

    /* compiled from: ClassReference.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(d dVar) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        List a2;
        int a3;
        Map<Class<? extends kotlin.c<?>>, Integer> a4;
        int a5;
        String a6;
        String a7;
        new a(null);
        int i = 0;
        a2 = kotlin.collections.j.a((Object[]) new Class[]{kotlin.jvm.b.a.class, l.class, p.class, q.class, r.class, s.class, t.class, u.class, v.class, w.class, kotlin.jvm.b.b.class, kotlin.jvm.b.c.class, kotlin.jvm.b.d.class, kotlin.jvm.b.e.class, kotlin.jvm.b.f.class, kotlin.jvm.b.g.class, kotlin.jvm.b.h.class, kotlin.jvm.b.i.class, kotlin.jvm.b.j.class, kotlin.jvm.b.k.class, m.class, n.class, o.class});
        a3 = kotlin.collections.k.a(a2, 10);
        ArrayList arrayList = new ArrayList(a3);
        for (Object obj : a2) {
            int i2 = i + 1;
            if (i >= 0) {
                arrayList.add(kotlin.j.a((Class) obj, Integer.valueOf(i)));
                i = i2;
            } else {
                kotlin.collections.h.b();
                throw null;
            }
        }
        a4 = y.a(arrayList);
        f8178b = a4;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        f8179c = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        f8180d = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(f8179c);
        hashMap3.putAll(f8180d);
        Collection<String> values = f8179c.values();
        f.a((Object) values, "primitiveFqNames.values");
        for (String str : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            f.a((Object) str, "kotlinName");
            a7 = kotlin.text.v.a(str, '.', (String) null, 2, (Object) null);
            sb.append(a7);
            sb.append("CompanionObject");
            Pair a8 = kotlin.j.a(sb.toString(), str + ".Companion");
            hashMap3.put(a8.getFirst(), a8.getSecond());
        }
        for (Map.Entry<Class<? extends kotlin.c<?>>, Integer> entry : f8178b.entrySet()) {
            Class<? extends kotlin.c<?>> key = entry.getKey();
            int intValue = entry.getValue().intValue();
            hashMap3.put(key.getName(), "kotlin.Function" + intValue);
        }
        e = hashMap3;
        a5 = x.a(hashMap3.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(a5);
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            Object key2 = entry2.getKey();
            a6 = kotlin.text.v.a((String) entry2.getValue(), '.', (String) null, 2, (Object) null);
            linkedHashMap.put(key2, a6);
        }
    }

    public b(@NotNull Class<?> cls) {
        f.b(cls, "jClass");
        this.f8181a = cls;
    }

    private final Void b() {
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // kotlin.jvm.internal.a
    @NotNull
    public Class<?> a() {
        return this.f8181a;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof b) && f.a(kotlin.jvm.a.a(this), kotlin.jvm.a.a((kotlin.reflect.c) obj));
    }

    @Override // kotlin.reflect.a
    @NotNull
    public List<Annotation> getAnnotations() {
        b();
        throw null;
    }

    public int hashCode() {
        return kotlin.jvm.a.a(this).hashCode();
    }

    @NotNull
    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
