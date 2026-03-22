package kotlin.n;

import java.util.NoSuchElementException;
import kotlin.collections.u;

/* compiled from: ProgressionIterators.kt */
/* loaded from: classes2.dex */
public final class b extends u {

    /* renamed from: a, reason: collision with root package name */
    private final int f8191a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f8192b;

    /* renamed from: c, reason: collision with root package name */
    private int f8193c;

    /* renamed from: d, reason: collision with root package name */
    private final int f8194d;

    public b(int i, int i2, int i3) {
        this.f8194d = i3;
        this.f8191a = i2;
        boolean z = true;
        if (i3 <= 0 ? i < i2 : i > i2) {
            z = false;
        }
        this.f8192b = z;
        this.f8193c = z ? i : this.f8191a;
    }

    @Override // kotlin.collections.u
    public int a() {
        int i = this.f8193c;
        if (i == this.f8191a) {
            if (this.f8192b) {
                this.f8192b = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f8193c = this.f8194d + i;
        }
        return i;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f8192b;
    }
}
