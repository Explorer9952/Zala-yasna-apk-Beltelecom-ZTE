package okhttp3.c0.f;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.Protocol;

/* compiled from: StatusLine.java */
/* loaded from: classes2.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final Protocol f8301a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8302b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8303c;

    public k(Protocol protocol, int i, String str) {
        this.f8301a = protocol;
        this.f8302b = i;
        this.f8303c = str;
    }

    public static k a(String str) throws IOException {
        Protocol protocol;
        String str2;
        int i = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() >= 9 && str.charAt(8) == ' ') {
                int charAt = str.charAt(7) - '0';
                if (charAt == 0) {
                    protocol = Protocol.HTTP_1_0;
                } else if (charAt == 1) {
                    protocol = Protocol.HTTP_1_1;
                } else {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else if (str.startsWith("ICY ")) {
            protocol = Protocol.HTTP_1_0;
            i = 4;
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        int i2 = i + 3;
        if (str.length() >= i2) {
            try {
                int parseInt = Integer.parseInt(str.substring(i, i2));
                if (str.length() <= i2) {
                    str2 = "";
                } else if (str.charAt(i2) == ' ') {
                    str2 = str.substring(i + 4);
                } else {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                return new k(protocol, parseInt, str2);
            } catch (NumberFormatException unused) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        }
        throw new ProtocolException("Unexpected status line: " + str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8301a == Protocol.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.f8302b);
        if (this.f8303c != null) {
            sb.append(' ');
            sb.append(this.f8303c);
        }
        return sb.toString();
    }
}
