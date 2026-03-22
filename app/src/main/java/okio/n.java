package okio;

import com.facebook.internal.Utility;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Segment.java */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    final byte[] f8595a;

    /* renamed from: b, reason: collision with root package name */
    int f8596b;

    /* renamed from: c, reason: collision with root package name */
    int f8597c;

    /* renamed from: d, reason: collision with root package name */
    boolean f8598d;
    boolean e;
    n f;
    n g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n() {
        this.f8595a = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
        this.e = true;
        this.f8598d = false;
    }

    public final n a(n nVar) {
        nVar.g = this;
        nVar.f = this.f;
        this.f.g = nVar;
        this.f = nVar;
        return nVar;
    }

    @Nullable
    public final n b() {
        n nVar = this.f;
        if (nVar == this) {
            nVar = null;
        }
        n nVar2 = this.g;
        nVar2.f = this.f;
        this.f.g = nVar2;
        this.f = null;
        this.g = null;
        return nVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final n c() {
        this.f8598d = true;
        return new n(this.f8595a, this.f8596b, this.f8597c, true, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.f8595a = bArr;
        this.f8596b = i;
        this.f8597c = i2;
        this.f8598d = z;
        this.e = z2;
    }

    public final n a(int i) {
        n a2;
        if (i > 0 && i <= this.f8597c - this.f8596b) {
            if (i >= 1024) {
                a2 = c();
            } else {
                a2 = o.a();
                System.arraycopy(this.f8595a, this.f8596b, a2.f8595a, 0, i);
            }
            a2.f8597c = a2.f8596b + i;
            this.f8596b += i;
            this.g.a(a2);
            return a2;
        }
        throw new IllegalArgumentException();
    }

    public final void a() {
        n nVar = this.g;
        if (nVar != this) {
            if (nVar.e) {
                int i = this.f8597c - this.f8596b;
                if (i > (8192 - nVar.f8597c) + (nVar.f8598d ? 0 : nVar.f8596b)) {
                    return;
                }
                a(this.g, i);
                b();
                o.a(this);
                return;
            }
            return;
        }
        throw new IllegalStateException();
    }

    public final void a(n nVar, int i) {
        if (nVar.e) {
            int i2 = nVar.f8597c;
            if (i2 + i > 8192) {
                if (!nVar.f8598d) {
                    int i3 = nVar.f8596b;
                    if ((i2 + i) - i3 <= 8192) {
                        byte[] bArr = nVar.f8595a;
                        System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
                        nVar.f8597c -= nVar.f8596b;
                        nVar.f8596b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f8595a, this.f8596b, nVar.f8595a, nVar.f8597c, i);
            nVar.f8597c += i;
            this.f8596b += i;
            return;
        }
        throw new IllegalArgumentException();
    }
}
