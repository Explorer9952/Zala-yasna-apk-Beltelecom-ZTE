package kotlin.text;

import java.util.Collection;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StringsJVM.kt */
/* loaded from: classes2.dex */
public class u extends t {
    public static /* synthetic */ String a(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return a(str, str2, str3, z);
    }

    @NotNull
    public static final String a(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z) {
        kotlin.jvm.internal.f.b(str, "$this$replace");
        kotlin.jvm.internal.f.b(str2, "oldValue");
        kotlin.jvm.internal.f.b(str3, "newValue");
        return kotlin.sequences.c.a(v.b(str, new String[]{str2}, z, 0, 4, (Object) null), str3, null, null, 0, null, null, 62, null);
    }

    public static /* synthetic */ boolean a(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return a(str, str2, z);
    }

    public static final boolean a(@NotNull String str, @NotNull String str2, boolean z) {
        kotlin.jvm.internal.f.b(str, "$this$startsWith");
        kotlin.jvm.internal.f.b(str2, "prefix");
        if (!z) {
            return str.startsWith(str2);
        }
        return a(str, 0, str2, 0, str2.length(), z);
    }

    public static boolean a(@NotNull CharSequence charSequence) {
        boolean z;
        kotlin.jvm.internal.f.b(charSequence, "$this$isBlank");
        if (charSequence.length() != 0) {
            Iterable b2 = v.b(charSequence);
            if (!(b2 instanceof Collection) || !((Collection) b2).isEmpty()) {
                Iterator it2 = b2.iterator();
                while (it2.hasNext()) {
                    if (!a.a(charSequence.charAt(((kotlin.collections.u) it2).a()))) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public static final boolean a(@NotNull String str, int i, @NotNull String str2, int i2, int i3, boolean z) {
        kotlin.jvm.internal.f.b(str, "$this$regionMatches");
        kotlin.jvm.internal.f.b(str2, "other");
        if (!z) {
            return str.regionMatches(i, str2, i2, i3);
        }
        return str.regionMatches(z, i, str2, i2, i3);
    }
}
