package kotlin.text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Regex.kt */
/* loaded from: classes2.dex */
public final class Regex implements Serializable {
    public static final a Companion = new a(null);
    private Set<? extends RegexOption> _options;
    private final Pattern nativePattern;

    /* compiled from: Regex.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int a(int i) {
            return (i & 2) != 0 ? i | 64 : i;
        }

        public /* synthetic */ a(kotlin.jvm.internal.d dVar) {
            this();
        }
    }

    /* compiled from: Regex.kt */
    /* loaded from: classes2.dex */
    private static final class b implements Serializable {
        private static final long serialVersionUID = 0;

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private final String f8207a;

        /* renamed from: b, reason: collision with root package name */
        private final int f8208b;

        /* compiled from: Regex.kt */
        /* loaded from: classes2.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.d dVar) {
                this();
            }
        }

        static {
            new a(null);
        }

        public b(@NotNull String str, int i) {
            kotlin.jvm.internal.f.b(str, "pattern");
            this.f8207a = str;
            this.f8208b = i;
        }

        private final Object readResolve() {
            Pattern compile = Pattern.compile(this.f8207a, this.f8208b);
            kotlin.jvm.internal.f.a((Object) compile, "Pattern.compile(pattern, flags)");
            return new Regex(compile);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Regex.kt */
    /* loaded from: classes2.dex */
    public static final class c extends Lambda implements kotlin.jvm.b.a<i> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CharSequence f8210b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f8211c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(CharSequence charSequence, int i) {
            super(0);
            this.f8210b = charSequence;
            this.f8211c = i;
        }

        @Override // kotlin.jvm.b.a
        @Nullable
        public final i invoke() {
            return Regex.this.find(this.f8210b, this.f8211c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Regex.kt */
    /* loaded from: classes2.dex */
    public static final /* synthetic */ class d extends FunctionReference implements kotlin.jvm.b.l<i, i> {

        /* renamed from: a, reason: collision with root package name */
        public static final d f8212a = new d();

        d() {
            super(1);
        }

        @Override // kotlin.jvm.b.l
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final i invoke(@NotNull i iVar) {
            kotlin.jvm.internal.f.b(iVar, "p1");
            return iVar.next();
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final String getName() {
            return "next";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final kotlin.reflect.d getOwner() {
            return kotlin.jvm.internal.h.a(i.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public final String getSignature() {
            return "next()Lkotlin/text/MatchResult;";
        }
    }

    public Regex(@NotNull Pattern pattern) {
        kotlin.jvm.internal.f.b(pattern, "nativePattern");
        this.nativePattern = pattern;
    }

    public static /* synthetic */ i find$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.find(charSequence, i);
    }

    public static /* synthetic */ kotlin.sequences.b findAll$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.findAll(charSequence, i);
    }

    public static /* synthetic */ List split$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.split(charSequence, i);
    }

    private final Object writeReplace() {
        String pattern = this.nativePattern.pattern();
        kotlin.jvm.internal.f.a((Object) pattern, "nativePattern.pattern()");
        return new b(pattern, this.nativePattern.flags());
    }

    public final boolean containsMatchIn(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.f.b(charSequence, "input");
        return this.nativePattern.matcher(charSequence).find();
    }

    @Nullable
    public final i find(@NotNull CharSequence charSequence, int i) {
        i b2;
        kotlin.jvm.internal.f.b(charSequence, "input");
        Matcher matcher = this.nativePattern.matcher(charSequence);
        kotlin.jvm.internal.f.a((Object) matcher, "nativePattern.matcher(input)");
        b2 = k.b(matcher, i, charSequence);
        return b2;
    }

    @NotNull
    public final kotlin.sequences.b<i> findAll(@NotNull CharSequence charSequence, int i) {
        kotlin.sequences.b<i> a2;
        kotlin.jvm.internal.f.b(charSequence, "input");
        a2 = kotlin.sequences.f.a(new c(charSequence, i), d.f8212a);
        return a2;
    }

    @NotNull
    public final Set<RegexOption> getOptions() {
        Set set = this._options;
        if (set != null) {
            return set;
        }
        final int flags = this.nativePattern.flags();
        EnumSet allOf = EnumSet.allOf(RegexOption.class);
        kotlin.collections.o.a(allOf, new kotlin.jvm.b.l<T, Boolean>() { // from class: kotlin.text.Regex$fromInt$$inlined$apply$lambda$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.b.l
            public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
                return Boolean.valueOf(invoke((Enum) obj));
            }

            /* JADX WARN: Incorrect types in method signature: (TT;)Z */
            /* JADX WARN: Multi-variable type inference failed */
            public final boolean invoke(Enum r3) {
                e eVar = (e) r3;
                return (flags & eVar.getMask()) == eVar.getValue();
            }
        });
        Set<RegexOption> unmodifiableSet = Collections.unmodifiableSet(allOf);
        kotlin.jvm.internal.f.a((Object) unmodifiableSet, "Collections.unmodifiable…mask == it.value }\n    })");
        this._options = unmodifiableSet;
        return unmodifiableSet;
    }

    @NotNull
    public final String getPattern() {
        String pattern = this.nativePattern.pattern();
        kotlin.jvm.internal.f.a((Object) pattern, "nativePattern.pattern()");
        return pattern;
    }

    @Nullable
    public final i matchEntire(@NotNull CharSequence charSequence) {
        i b2;
        kotlin.jvm.internal.f.b(charSequence, "input");
        Matcher matcher = this.nativePattern.matcher(charSequence);
        kotlin.jvm.internal.f.a((Object) matcher, "nativePattern.matcher(input)");
        b2 = k.b(matcher, charSequence);
        return b2;
    }

    public final boolean matches(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.f.b(charSequence, "input");
        return this.nativePattern.matcher(charSequence).matches();
    }

    @NotNull
    public final String replace(@NotNull CharSequence charSequence, @NotNull String str) {
        kotlin.jvm.internal.f.b(charSequence, "input");
        kotlin.jvm.internal.f.b(str, "replacement");
        String replaceAll = this.nativePattern.matcher(charSequence).replaceAll(str);
        kotlin.jvm.internal.f.a((Object) replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return replaceAll;
    }

    @NotNull
    public final String replaceFirst(@NotNull CharSequence charSequence, @NotNull String str) {
        kotlin.jvm.internal.f.b(charSequence, "input");
        kotlin.jvm.internal.f.b(str, "replacement");
        String replaceFirst = this.nativePattern.matcher(charSequence).replaceFirst(str);
        kotlin.jvm.internal.f.a((Object) replaceFirst, "nativePattern.matcher(in…replaceFirst(replacement)");
        return replaceFirst;
    }

    @NotNull
    public final List<String> split(@NotNull CharSequence charSequence, int i) {
        List<String> a2;
        kotlin.jvm.internal.f.b(charSequence, "input");
        int i2 = 0;
        if (i >= 0) {
            Matcher matcher = this.nativePattern.matcher(charSequence);
            if (matcher.find() && i != 1) {
                ArrayList arrayList = new ArrayList(i > 0 ? kotlin.n.f.b(i, 10) : 10);
                int i3 = i - 1;
                do {
                    arrayList.add(charSequence.subSequence(i2, matcher.start()).toString());
                    i2 = matcher.end();
                    if (i3 >= 0 && arrayList.size() == i3) {
                        break;
                    }
                } while (matcher.find());
                arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
                return arrayList;
            }
            a2 = kotlin.collections.i.a(charSequence.toString());
            return a2;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i + '.').toString());
    }

    @NotNull
    public final Pattern toPattern() {
        return this.nativePattern;
    }

    @NotNull
    public String toString() {
        String pattern = this.nativePattern.toString();
        kotlin.jvm.internal.f.a((Object) pattern, "nativePattern.toString()");
        return pattern;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Regex(@org.jetbrains.annotations.NotNull java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.f.b(r2, r0)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.lang.String r0 = "Pattern.compile(pattern)"
            kotlin.jvm.internal.f.a(r2, r0)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String):void");
    }

    @NotNull
    public final String replace(@NotNull CharSequence charSequence, @NotNull kotlin.jvm.b.l<? super i, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.f.b(charSequence, "input");
        kotlin.jvm.internal.f.b(lVar, "transform");
        int i = 0;
        i find$default = find$default(this, charSequence, 0, 2, null);
        if (find$default != null) {
            int length = charSequence.length();
            StringBuilder sb = new StringBuilder(length);
            while (find$default != null) {
                sb.append(charSequence, i, find$default.a().e().intValue());
                sb.append(lVar.invoke(find$default));
                i = find$default.a().d().intValue() + 1;
                find$default = find$default.next();
                if (i >= length || find$default == null) {
                    if (i < length) {
                        sb.append(charSequence, i, length);
                    }
                    String sb2 = sb.toString();
                    kotlin.jvm.internal.f.a((Object) sb2, "sb.toString()");
                    return sb2;
                }
            }
            kotlin.jvm.internal.f.a();
            throw null;
        }
        return charSequence.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Regex(@org.jetbrains.annotations.NotNull java.lang.String r2, @org.jetbrains.annotations.NotNull kotlin.text.RegexOption r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.f.b(r2, r0)
            java.lang.String r0 = "option"
            kotlin.jvm.internal.f.b(r3, r0)
            kotlin.text.Regex$a r0 = kotlin.text.Regex.Companion
            int r3 = r3.getValue()
            int r3 = kotlin.text.Regex.a.a(r0, r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "Pattern.compile(pattern,…nicodeCase(option.value))"
            kotlin.jvm.internal.f.a(r2, r3)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String, kotlin.text.RegexOption):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Regex(@org.jetbrains.annotations.NotNull java.lang.String r2, @org.jetbrains.annotations.NotNull java.util.Set<? extends kotlin.text.RegexOption> r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.f.b(r2, r0)
            java.lang.String r0 = "options"
            kotlin.jvm.internal.f.b(r3, r0)
            kotlin.text.Regex$a r0 = kotlin.text.Regex.Companion
            int r3 = kotlin.text.k.a(r3)
            int r3 = kotlin.text.Regex.a.a(r0, r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "Pattern.compile(pattern,…odeCase(options.toInt()))"
            kotlin.jvm.internal.f.a(r2, r3)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String, java.util.Set):void");
    }
}
