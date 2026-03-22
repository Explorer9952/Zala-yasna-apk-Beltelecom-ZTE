package d.e.b.d;

import android.os.Message;
import d.e.b.n.d;
import java.util.Locale;

/* loaded from: classes2.dex */
public class a extends d.e.b.b.b implements b {

    /* renamed from: d, reason: collision with root package name */
    private final String f8056d = a.class.getName();

    @Override // d.e.b.d.b
    public void a(int i, String str, String str2, String str3) {
        d.e.b.d.c.b bVar = new d.e.b.d.c.b();
        bVar.a(str2);
        bVar.b(str3);
        bVar.c(str);
        bVar.a(i);
        d.a(this.f8056d, String.format(Locale.getDefault(), "【点击拨号-点击拨号发起请求结果】 java_FireCreateCallSessionAck ErrorCode[%s]", bVar.a()));
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = bVar;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.d.b
    public void b(int i, String str, String str2) {
        d.e.b.d.c.d dVar = new d.e.b.d.c.d();
        dVar.a(str);
        dVar.b(str2);
        dVar.a(i);
        d.a(this.f8056d, String.format(Locale.getDefault(), "【点击拨号-点击拨号结束请求结果】 java_FireTerminateCallSessionAck ErrorCode[%s]", dVar.a()));
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = dVar;
        c().sendMessage(obtain);
    }
}
