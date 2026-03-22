package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/* compiled from: Dns.java */
/* loaded from: classes2.dex */
public interface o {

    /* renamed from: a, reason: collision with root package name */
    public static final o f8510a = new a();

    /* compiled from: Dns.java */
    /* loaded from: classes2.dex */
    class a implements o {
        a() {
        }

        @Override // okhttp3.o
        public List<InetAddress> a(String str) throws UnknownHostException {
            if (str != null) {
                try {
                    return Arrays.asList(InetAddress.getAllByName(str));
                } catch (NullPointerException e) {
                    UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + str);
                    unknownHostException.initCause(e);
                    throw unknownHostException;
                }
            }
            throw new UnknownHostException("hostname == null");
        }
    }

    List<InetAddress> a(String str) throws UnknownHostException;
}
