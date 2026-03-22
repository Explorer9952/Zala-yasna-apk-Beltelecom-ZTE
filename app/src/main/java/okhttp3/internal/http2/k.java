package okhttp3.internal.http2;

import com.zte.ucs.tvcall.Commons;
import java.util.Arrays;

/* compiled from: Settings.java */
/* loaded from: classes2.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private int f8477a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f8478b = new int[10];

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f8477a = 0;
        Arrays.fill(this.f8478b, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        if ((this.f8477a & 2) != 0) {
            return this.f8478b[1];
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i) {
        return (this.f8477a & 32) != 0 ? this.f8478b[5] : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(int i) {
        return ((1 << i) & this.f8477a) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i) {
        return (this.f8477a & 16) != 0 ? this.f8478b[4] : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        if ((this.f8477a & Commons.MSG_MCSP_INIT_SUCCESS) != 0) {
            return this.f8478b[7];
        }
        return 65535;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return Integer.bitCount(this.f8477a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k a(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.f8478b;
            if (i < iArr.length) {
                this.f8477a = (1 << i) | this.f8477a;
                iArr[i] = i2;
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i) {
        return this.f8478b[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(k kVar) {
        for (int i = 0; i < 10; i++) {
            if (kVar.d(i)) {
                a(i, kVar.a(i));
            }
        }
    }
}
