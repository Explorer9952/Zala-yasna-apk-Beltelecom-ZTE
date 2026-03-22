package d.e.b.b;

import android.os.Handler;
import android.os.Message;

/* loaded from: classes2.dex */
final class g implements Handler.Callback {
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        String str;
        str = f.f8051a;
        d.e.b.n.d.d(str, "NativeFactory default handler, do nothing. msg.what:" + message.what);
        return false;
    }
}
