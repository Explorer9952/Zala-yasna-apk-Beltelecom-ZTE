package kotlin.collections;

import java.util.NoSuchElementException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Arrays.kt */
/* loaded from: classes2.dex */
public class f extends e {
    public static boolean a(@NotNull int[] iArr, int i) {
        kotlin.jvm.internal.f.b(iArr, "$this$contains");
        return b(iArr, i) >= 0;
    }

    public static final int b(@NotNull int[] iArr, int i) {
        kotlin.jvm.internal.f.b(iArr, "$this$indexOf");
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i == iArr[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public static char a(@NotNull char[] cArr) {
        kotlin.jvm.internal.f.b(cArr, "$this$single");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    @Nullable
    public static <T> T b(@NotNull T[] tArr) {
        kotlin.jvm.internal.f.b(tArr, "$this$singleOrNull");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    @NotNull
    public static final <A extends Appendable> A a(@NotNull byte[] bArr, @NotNull A a2, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i, @NotNull CharSequence charSequence4, @Nullable kotlin.jvm.b.l<? super Byte, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.f.b(bArr, "$this$joinTo");
        kotlin.jvm.internal.f.b(a2, "buffer");
        kotlin.jvm.internal.f.b(charSequence, "separator");
        kotlin.jvm.internal.f.b(charSequence2, "prefix");
        kotlin.jvm.internal.f.b(charSequence3, "postfix");
        kotlin.jvm.internal.f.b(charSequence4, "truncated");
        a2.append(charSequence2);
        int i2 = 0;
        for (byte b2 : bArr) {
            i2++;
            if (i2 > 1) {
                a2.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            if (lVar != null) {
                a2.append(lVar.invoke(Byte.valueOf(b2)));
            } else {
                a2.append(String.valueOf((int) b2));
            }
        }
        if (i >= 0 && i2 > i) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static /* synthetic */ String a(byte[] bArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, kotlin.jvm.b.l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i2 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i2 & 4) == 0 ? charSequence3 : "";
        int i3 = (i2 & 8) != 0 ? -1 : i;
        if ((i2 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            lVar = null;
        }
        return a(bArr, charSequence, charSequence5, charSequence6, i3, charSequence7, lVar);
    }

    @NotNull
    public static final String a(@NotNull byte[] bArr, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i, @NotNull CharSequence charSequence4, @Nullable kotlin.jvm.b.l<? super Byte, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.f.b(bArr, "$this$joinToString");
        kotlin.jvm.internal.f.b(charSequence, "separator");
        kotlin.jvm.internal.f.b(charSequence2, "prefix");
        kotlin.jvm.internal.f.b(charSequence3, "postfix");
        kotlin.jvm.internal.f.b(charSequence4, "truncated");
        StringBuilder sb = new StringBuilder();
        a(bArr, sb, charSequence, charSequence2, charSequence3, i, charSequence4, lVar);
        String sb2 = sb.toString();
        kotlin.jvm.internal.f.a((Object) sb2, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb2;
    }
}
