package d.e.b.c;

import android.os.Message;
import com.google.gson.Gson;
import d.e.b.c.c.f;
import d.e.b.c.c.h;
import d.e.b.c.c.j;
import d.e.b.n.d;
import java.util.Locale;

/* loaded from: classes2.dex */
public class a extends d.e.b.b.b implements b {

    /* renamed from: d, reason: collision with root package name */
    private final String f8055d = a.class.getName();

    @Override // d.e.b.c.b
    public void a(d.e.b.c.c.b bVar) {
        String json = new Gson().toJson(bVar);
        d.a(this.f8055d, String.format(Locale.getDefault(), "【宽带助手-获取DM配置结果】 java_CBBroadBandGetDmCfgInfo " + json, new Object[0]));
        Message obtain = Message.obtain();
        obtain.what = 4;
        obtain.obj = bVar;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.c.b
    public void a(d.e.b.c.c.d dVar) {
        String json = new Gson().toJson(dVar);
        d.a(this.f8055d, String.format(Locale.getDefault(), "【宽带助手-获取DM服务端的cookie结果】 java_CBBroadBandGetDmCookie " + json, new Object[0]));
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = dVar;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.c.b
    public void a(f fVar) {
        String json = new Gson().toJson(fVar);
        d.a(this.f8055d, String.format(Locale.getDefault(), "【宽带助手-查询通话时长结果】 java_CBBroadBandQueryAccount " + json, new Object[0]));
        Message obtain = Message.obtain();
        obtain.what = 5;
        obtain.obj = fVar;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.c.b
    public void a(h hVar) {
        String json = new Gson().toJson(hVar);
        d.a(this.f8055d, String.format(Locale.getDefault(), "【宽带助手-短信验证码回传结果】 java_CBBroadBandSmsCodeReturn " + json, new Object[0]));
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.obj = hVar;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.c.b
    public void a(j jVar) {
        String json = new Gson().toJson(jVar);
        d.a(this.f8055d, String.format(Locale.getDefault(), "【宽带助手-宽带账号验证结果】 java_CBBroadBandVerifyECOPAccount " + json, new Object[0]));
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = jVar;
        c().sendMessage(obtain);
    }
}
