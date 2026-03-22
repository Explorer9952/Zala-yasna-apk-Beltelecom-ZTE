package kotlin.internal;

/* compiled from: progressionUtil.kt */
/* loaded from: classes2.dex */
public final class c {
    private static final int a(int i, int i2) {
        int i3 = i % i2;
        return i3 >= 0 ? i3 : i3 + i2;
    }

    public static final int b(int i, int i2, int i3) {
        if (i3 > 0) {
            return i >= i2 ? i2 : i2 - a(i2, i, i3);
        }
        if (i3 < 0) {
            return i <= i2 ? i2 : i2 + a(i, i2, -i3);
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    private static final int a(int i, int i2, int i3) {
        return a(a(i, i3) - a(i2, i3), i3);
    }
}
