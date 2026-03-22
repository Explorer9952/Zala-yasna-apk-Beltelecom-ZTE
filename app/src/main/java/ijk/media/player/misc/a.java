package ijk.media.player.misc;

import android.text.TextUtils;
import ijk.media.player.c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: IjkMediaFormat.java */
/* loaded from: classes2.dex */
public class a implements IMediaFormat {

    /* renamed from: b, reason: collision with root package name */
    private static final Map<String, AbstractC0413a> f8101b = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final c.a f8102a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IjkMediaFormat.java */
    /* renamed from: ijk.media.player.misc.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractC0413a {
        private AbstractC0413a() {
        }

        protected String a() {
            return "N/A";
        }

        protected abstract String a(a aVar);

        public String b(a aVar) {
            String a2 = a(aVar);
            return TextUtils.isEmpty(a2) ? a() : a2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ AbstractC0413a(b bVar) {
            this();
        }
    }

    public a(c.a aVar) {
        f8101b.put("ijk-codec-long-name-ui", new b(this));
        f8101b.put("ijk-codec-name-ui", new c(this));
        f8101b.put("ijk-bit-rate-ui", new d(this));
        f8101b.put("ijk-profile-level-ui", new e(this));
        f8101b.put("ijk-pixel-format-ui", new f(this));
        f8101b.put("ijk-resolution-ui", new g(this));
        f8101b.put("ijk-frame-rate-ui", new h(this));
        f8101b.put("ijk-sample-rate-ui", new i(this));
        f8101b.put("ijk-channel-ui", new j(this));
        this.f8102a = aVar;
    }

    @Override // ijk.media.player.misc.IMediaFormat
    public int getInteger(String str) {
        c.a aVar = this.f8102a;
        if (aVar == null) {
            return 0;
        }
        return aVar.b(str);
    }

    @Override // ijk.media.player.misc.IMediaFormat
    public String getString(String str) {
        if (this.f8102a == null) {
            return null;
        }
        if (f8101b.containsKey(str)) {
            return f8101b.get(str).b(this);
        }
        return this.f8102a.a(str);
    }
}
