package okhttp3.internal.http2;

import java.io.IOException;
import okio.ByteString;

/* compiled from: Http2.java */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    static final ByteString f8397a = ByteString.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f8398b = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* renamed from: c, reason: collision with root package name */
    static final String[] f8399c = new String[64];

    /* renamed from: d, reason: collision with root package name */
    static final String[] f8400d = new String[256];

    static {
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = f8400d;
            if (i2 >= strArr.length) {
                break;
            }
            strArr[i2] = okhttp3.c0.c.a("%8s", Integer.toBinaryString(i2)).replace(' ', '0');
            i2++;
        }
        String[] strArr2 = f8399c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i3 = 0; i3 < 1; i3++) {
            int i4 = iArr[i3];
            f8399c[i4 | 8] = f8399c[i4] + "|PADDED";
        }
        String[] strArr3 = f8399c;
        strArr3[4] = "END_HEADERS";
        strArr3[32] = "PRIORITY";
        strArr3[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i5 = 0; i5 < 3; i5++) {
            int i6 = iArr2[i5];
            for (int i7 = 0; i7 < 1; i7++) {
                int i8 = iArr[i7];
                int i9 = i8 | i6;
                f8399c[i9] = f8399c[i8] + '|' + f8399c[i6];
                f8399c[i9 | 8] = f8399c[i8] + '|' + f8399c[i6] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr4 = f8399c;
            if (i >= strArr4.length) {
                return;
            }
            if (strArr4[i] == null) {
                strArr4[i] = f8400d[i];
            }
            i++;
        }
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IllegalArgumentException a(String str, Object... objArr) {
        throw new IllegalArgumentException(okhttp3.c0.c.a(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IOException b(String str, Object... objArr) throws IOException {
        throw new IOException(okhttp3.c0.c.a(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(boolean z, int i, int i2, byte b2, byte b3) {
        String[] strArr = f8398b;
        String a2 = b2 < strArr.length ? strArr[b2] : okhttp3.c0.c.a("0x%02x", Byte.valueOf(b2));
        String a3 = a(b2, b3);
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = a2;
        objArr[4] = a3;
        return okhttp3.c0.c.a("%s 0x%08x %5d %-13s %s", objArr);
    }

    static String a(byte b2, byte b3) {
        if (b3 == 0) {
            return "";
        }
        if (b2 != 2 && b2 != 3) {
            if (b2 == 4 || b2 == 6) {
                return b3 == 1 ? "ACK" : f8400d[b3];
            }
            if (b2 != 7 && b2 != 8) {
                String[] strArr = f8399c;
                String str = b3 < strArr.length ? strArr[b3] : f8400d[b3];
                if (b2 != 5 || (b3 & 4) == 0) {
                    return (b2 != 0 || (b3 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                }
                return str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return f8400d[b3];
    }
}
