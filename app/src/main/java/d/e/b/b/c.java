package d.e.b.b;

import android.os.Handler;
import android.os.Message;

/* loaded from: classes2.dex */
final class c implements Handler.Callback {
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        String str;
        str = b.f8047b;
        d.e.b.n.d.d(str, "BaseNative default handler, do nothing. msg.what:" + message.what);
        return false;
    }
}
