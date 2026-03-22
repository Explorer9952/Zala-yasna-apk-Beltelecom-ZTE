package okhttp3.internal.http2;

import okhttp3.r;
import okio.ByteString;

/* compiled from: Header.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static final ByteString f8383d = ByteString.encodeUtf8(":");
    public static final ByteString e = ByteString.encodeUtf8(":status");
    public static final ByteString f = ByteString.encodeUtf8(":method");
    public static final ByteString g = ByteString.encodeUtf8(":path");
    public static final ByteString h = ByteString.encodeUtf8(":scheme");
    public static final ByteString i = ByteString.encodeUtf8(":authority");

    /* renamed from: a, reason: collision with root package name */
    public final ByteString f8384a;

    /* renamed from: b, reason: collision with root package name */
    public final ByteString f8385b;

    /* renamed from: c, reason: collision with root package name */
    final int f8386c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Header.java */
    /* renamed from: okhttp3.internal.http2.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0429a {
        void a(r rVar);
    }

    public a(String str, String str2) {
        this(ByteString.encodeUtf8(str), ByteString.encodeUtf8(str2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f8384a.equals(aVar.f8384a) && this.f8385b.equals(aVar.f8385b);
    }

    public int hashCode() {
        return ((527 + this.f8384a.hashCode()) * 31) + this.f8385b.hashCode();
    }

    public String toString() {
        return okhttp3.c0.c.a("%s: %s", this.f8384a.utf8(), this.f8385b.utf8());
    }

    public a(ByteString byteString, String str) {
        this(byteString, ByteString.encodeUtf8(str));
    }

    public a(ByteString byteString, ByteString byteString2) {
        this.f8384a = byteString;
        this.f8385b = byteString2;
        this.f8386c = byteString.size() + 32 + byteString2.size();
    }
}
