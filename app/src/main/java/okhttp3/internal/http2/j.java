package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;

/* compiled from: PushObserver.java */
/* loaded from: classes2.dex */
public interface j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f8476a = new a();

    /* compiled from: PushObserver.java */
    /* loaded from: classes2.dex */
    class a implements j {
        a() {
        }

        @Override // okhttp3.internal.http2.j
        public void a(int i, ErrorCode errorCode) {
        }

        @Override // okhttp3.internal.http2.j
        public boolean a(int i, List<okhttp3.internal.http2.a> list) {
            return true;
        }

        @Override // okhttp3.internal.http2.j
        public boolean a(int i, List<okhttp3.internal.http2.a> list, boolean z) {
            return true;
        }

        @Override // okhttp3.internal.http2.j
        public boolean a(int i, okio.e eVar, int i2, boolean z) throws IOException {
            eVar.skip(i2);
            return true;
        }
    }

    void a(int i, ErrorCode errorCode);

    boolean a(int i, List<okhttp3.internal.http2.a> list);

    boolean a(int i, List<okhttp3.internal.http2.a> list, boolean z);

    boolean a(int i, okio.e eVar, int i2, boolean z) throws IOException;
}
