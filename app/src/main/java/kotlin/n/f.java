package kotlin.n;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _Ranges.kt */
/* loaded from: classes2.dex */
public class f extends e {
    public static int a(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    public static int a(int i, int i2, int i3) {
        if (i2 <= i3) {
            return i < i2 ? i2 : i > i3 ? i3 : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + '.');
    }

    public static int b(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    @NotNull
    public static a c(int i, int i2) {
        return a.f8187d.a(i, i2, -1);
    }

    @NotNull
    public static c d(int i, int i2) {
        if (i2 <= Integer.MIN_VALUE) {
            return c.f.a();
        }
        return new c(i, i2 - 1);
    }
}
