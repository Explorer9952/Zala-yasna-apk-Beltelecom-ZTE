package kotlin.text;

import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Strings.kt */
/* loaded from: classes2.dex */
public class v extends u {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Strings.kt */
    /* loaded from: classes2.dex */
    public static final class a extends Lambda implements kotlin.jvm.b.p<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f8228a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f8229b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(List list, boolean z) {
            super(2);
            this.f8228a = list;
            this.f8229b = z;
        }

        @Nullable
        public final Pair<Integer, Integer> a(@NotNull CharSequence charSequence, int i) {
            kotlin.jvm.internal.f.b(charSequence, "$receiver");
            Pair b2 = v.b(charSequence, this.f8228a, i, this.f8229b, false);
            if (b2 != null) {
                return kotlin.j.a(b2.getFirst(), Integer.valueOf(((String) b2.getSecond()).length()));
            }
            return null;
        }

        @Override // kotlin.jvm.b.p
        public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
            return a(charSequence, num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Strings.kt */
    /* loaded from: classes2.dex */
    public static final class b extends Lambda implements kotlin.jvm.b.l<kotlin.n.c, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CharSequence f8230a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(CharSequence charSequence) {
            super(1);
            this.f8230a = charSequence;
        }

        @Override // kotlin.jvm.b.l
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(@NotNull kotlin.n.c cVar) {
            kotlin.jvm.internal.f.b(cVar, LocaleUtil.ITALIAN);
            return v.a(this.f8230a, cVar);
        }
    }

    @NotNull
    public static final kotlin.n.c b(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.f.b(charSequence, "$this$indices");
        return new kotlin.n.c(0, charSequence.length() - 1);
    }

    public static final int c(@NotNull CharSequence charSequence) {
        kotlin.jvm.internal.f.b(charSequence, "$this$lastIndex");
        return charSequence.length() - 1;
    }

    @NotNull
    public static final String a(@NotNull CharSequence charSequence, @NotNull kotlin.n.c cVar) {
        kotlin.jvm.internal.f.b(charSequence, "$this$substring");
        kotlin.jvm.internal.f.b(cVar, "range");
        return charSequence.subSequence(cVar.e().intValue(), cVar.d().intValue() + 1).toString();
    }

    public static final int b(@NotNull CharSequence charSequence, @NotNull char[] cArr, int i, boolean z) {
        kotlin.jvm.internal.f.b(charSequence, "$this$lastIndexOfAny");
        kotlin.jvm.internal.f.b(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(kotlin.collections.b.a(cArr), i);
        }
        for (int b2 = kotlin.n.d.b(i, c(charSequence)); b2 >= 0; b2--) {
            char charAt = charSequence.charAt(b2);
            int length = cArr.length;
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (kotlin.text.b.a(cArr[i2], charAt, z)) {
                    z2 = true;
                    break;
                }
                i2++;
            }
            if (z2) {
                return b2;
            }
        }
        return -1;
    }

    public static /* synthetic */ String a(String str, char c2, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return a(str, c2, str2);
    }

    @NotNull
    public static final String a(@NotNull String str, char c2, @NotNull String str2) {
        kotlin.jvm.internal.f.b(str, "$this$substringAfterLast");
        kotlin.jvm.internal.f.b(str2, "missingDelimiterValue");
        int b2 = b((CharSequence) str, c2, 0, false, 6, (Object) null);
        if (b2 == -1) {
            return str2;
        }
        String substring = str.substring(b2 + 1, str.length());
        kotlin.jvm.internal.f.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final boolean a(@NotNull CharSequence charSequence, int i, @NotNull CharSequence charSequence2, int i2, int i3, boolean z) {
        kotlin.jvm.internal.f.b(charSequence, "$this$regionMatchesImpl");
        kotlin.jvm.internal.f.b(charSequence2, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!kotlin.text.b.a(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static final int a(@NotNull CharSequence charSequence, @NotNull char[] cArr, int i, boolean z) {
        boolean z2;
        kotlin.jvm.internal.f.b(charSequence, "$this$indexOfAny");
        kotlin.jvm.internal.f.b(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(kotlin.collections.b.a(cArr), i);
        }
        int a2 = kotlin.n.d.a(i, 0);
        int c2 = c(charSequence);
        if (a2 > c2) {
            return -1;
        }
        while (true) {
            char charAt = charSequence.charAt(a2);
            int length = cArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z2 = false;
                    break;
                }
                if (kotlin.text.b.a(cArr[i2], charAt, z)) {
                    z2 = true;
                    break;
                }
                i2++;
            }
            if (z2) {
                return a2;
            }
            if (a2 == c2) {
                return -1;
            }
            a2++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair<Integer, String> b(@NotNull CharSequence charSequence, Collection<String> collection, int i, boolean z, boolean z2) {
        Object obj;
        Object obj2;
        if (!z && collection.size() == 1) {
            String str = (String) kotlin.collections.h.c(collection);
            int a2 = !z2 ? l.a(charSequence, str, i, false, 4, (Object) null) : b(charSequence, str, i, false, 4, (Object) null);
            if (a2 < 0) {
                return null;
            }
            return kotlin.j.a(Integer.valueOf(a2), str);
        }
        kotlin.n.a cVar = !z2 ? new kotlin.n.c(kotlin.n.d.a(i, 0), charSequence.length()) : kotlin.n.d.c(kotlin.n.d.b(i, c(charSequence)), 0);
        if (charSequence instanceof String) {
            int a3 = cVar.a();
            int b2 = cVar.b();
            int c2 = cVar.c();
            if (c2 < 0 ? a3 >= b2 : a3 <= b2) {
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it2.next();
                        String str2 = (String) obj2;
                        if (u.a(str2, 0, (String) charSequence, a3, str2.length(), z)) {
                            break;
                        }
                    }
                    String str3 = (String) obj2;
                    if (str3 == null) {
                        if (a3 == b2) {
                            break;
                        }
                        a3 += c2;
                    } else {
                        return kotlin.j.a(Integer.valueOf(a3), str3);
                    }
                }
            }
        } else {
            int a4 = cVar.a();
            int b3 = cVar.b();
            int c3 = cVar.c();
            if (c3 < 0 ? a4 >= b3 : a4 <= b3) {
                while (true) {
                    Iterator<T> it3 = collection.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it3.next();
                        String str4 = (String) obj;
                        if (a(str4, 0, charSequence, a4, str4.length(), z)) {
                            break;
                        }
                    }
                    String str5 = (String) obj;
                    if (str5 == null) {
                        if (a4 == b3) {
                            break;
                        }
                        a4 += c3;
                    } else {
                        return kotlin.j.a(Integer.valueOf(a4), str5);
                    }
                }
            }
        }
        return null;
    }

    static /* synthetic */ int a(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        return a(charSequence, charSequence2, i, i2, z, (i3 & 16) != 0 ? false : z2);
    }

    private static final int a(@NotNull CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        kotlin.n.a c2;
        if (!z2) {
            c2 = new kotlin.n.c(kotlin.n.d.a(i, 0), kotlin.n.d.b(i2, charSequence.length()));
        } else {
            c2 = kotlin.n.d.c(kotlin.n.d.b(i, c(charSequence)), kotlin.n.d.a(i2, 0));
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int a2 = c2.a();
            int b2 = c2.b();
            int c3 = c2.c();
            if (c3 >= 0) {
                if (a2 > b2) {
                    return -1;
                }
            } else if (a2 < b2) {
                return -1;
            }
            while (!u.a((String) charSequence2, 0, (String) charSequence, a2, charSequence2.length(), z)) {
                if (a2 == b2) {
                    return -1;
                }
                a2 += c3;
            }
            return a2;
        }
        int a3 = c2.a();
        int b3 = c2.b();
        int c4 = c2.c();
        if (c4 >= 0) {
            if (a3 > b3) {
                return -1;
            }
        } else if (a3 < b3) {
            return -1;
        }
        while (!a(charSequence2, 0, charSequence, a3, charSequence2.length(), z)) {
            if (a3 == b3) {
                return -1;
            }
            a3 += c4;
        }
        return a3;
    }

    public static /* synthetic */ int a(CharSequence charSequence, char c2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return a(charSequence, c2, i, z);
    }

    public static /* synthetic */ int b(CharSequence charSequence, char c2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = c(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return b(charSequence, c2, i, z);
    }

    public static final int a(@NotNull CharSequence charSequence, char c2, int i, boolean z) {
        kotlin.jvm.internal.f.b(charSequence, "$this$indexOf");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c2, i);
        }
        return a(charSequence, new char[]{c2}, i, z);
    }

    public static final int b(@NotNull CharSequence charSequence, char c2, int i, boolean z) {
        kotlin.jvm.internal.f.b(charSequence, "$this$lastIndexOf");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(c2, i);
        }
        return b(charSequence, new char[]{c2}, i, z);
    }

    public static /* synthetic */ int a(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return a(charSequence, str, i, z);
    }

    public static /* synthetic */ int b(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = c(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return b(charSequence, str, i, z);
    }

    public static final int a(@NotNull CharSequence charSequence, @NotNull String str, int i, boolean z) {
        kotlin.jvm.internal.f.b(charSequence, "$this$indexOf");
        kotlin.jvm.internal.f.b(str, "string");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i);
        }
        return a(charSequence, str, i, charSequence.length(), z, false, 16, null);
    }

    public static final int b(@NotNull CharSequence charSequence, @NotNull String str, int i, boolean z) {
        kotlin.jvm.internal.f.b(charSequence, "$this$lastIndexOf");
        kotlin.jvm.internal.f.b(str, "string");
        if (!z && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(str, i);
        }
        return a(charSequence, (CharSequence) str, i, 0, z, true);
    }

    static /* synthetic */ kotlin.sequences.b a(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return a(charSequence, strArr, i, z, i2);
    }

    public static /* synthetic */ kotlin.sequences.b b(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return b(charSequence, strArr, z, i);
    }

    private static final kotlin.sequences.b<kotlin.n.c> a(@NotNull CharSequence charSequence, String[] strArr, int i, boolean z, int i2) {
        if (i2 >= 0) {
            return new d(charSequence, i, i2, new a(kotlin.collections.b.a(strArr), z));
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
    }

    @NotNull
    public static final kotlin.sequences.b<String> b(@NotNull CharSequence charSequence, @NotNull String[] strArr, boolean z, int i) {
        kotlin.jvm.internal.f.b(charSequence, "$this$splitToSequence");
        kotlin.jvm.internal.f.b(strArr, "delimiters");
        return kotlin.sequences.c.a(a(charSequence, strArr, 0, z, i, 2, null), new b(charSequence));
    }

    public static /* synthetic */ List a(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return a(charSequence, strArr, z, i);
    }

    @NotNull
    public static final List<String> a(@NotNull CharSequence charSequence, @NotNull String[] strArr, boolean z, int i) {
        kotlin.jvm.internal.f.b(charSequence, "$this$split");
        kotlin.jvm.internal.f.b(strArr, "delimiters");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (!(str.length() == 0)) {
                return a(charSequence, str, z, i);
            }
        }
        Iterable a2 = kotlin.sequences.c.a(a(charSequence, strArr, 0, z, i, 2, null));
        ArrayList arrayList = new ArrayList(kotlin.collections.h.a(a2, 10));
        Iterator it2 = a2.iterator();
        while (it2.hasNext()) {
            arrayList.add(a(charSequence, (kotlin.n.c) it2.next()));
        }
        return arrayList;
    }

    private static final List<String> a(@NotNull CharSequence charSequence, String str, boolean z, int i) {
        int i2 = 0;
        if (i >= 0) {
            int a2 = a(charSequence, str, 0, z);
            if (a2 != -1 && i != 1) {
                boolean z2 = i > 0;
                ArrayList arrayList = new ArrayList(z2 ? kotlin.n.d.b(i, 10) : 10);
                do {
                    arrayList.add(charSequence.subSequence(i2, a2).toString());
                    i2 = str.length() + a2;
                    if (z2 && arrayList.size() == i - 1) {
                        break;
                    }
                    a2 = a(charSequence, str, i2, z);
                } while (a2 != -1);
                arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
                return arrayList;
            }
            return kotlin.collections.h.a(charSequence.toString());
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i + '.').toString());
    }
}
