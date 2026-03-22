package ijk.media.player;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.MimeTypes;
import com.video.androidsdk.service.comm.ParamConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: IjkMediaMeta.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public Bundle f8083a;

    /* renamed from: b, reason: collision with root package name */
    public String f8084b;

    /* renamed from: c, reason: collision with root package name */
    public long f8085c;

    /* renamed from: d, reason: collision with root package name */
    public long f8086d;
    public long e;
    public final ArrayList<a> f = new ArrayList<>();
    public a g;
    public a h;

    /* compiled from: IjkMediaMeta.java */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public Bundle f8087a;

        /* renamed from: b, reason: collision with root package name */
        public final int f8088b;

        /* renamed from: c, reason: collision with root package name */
        public String f8089c;

        /* renamed from: d, reason: collision with root package name */
        public String f8090d;
        public String e;
        public String f;
        public String g;
        public long h;
        public int i;
        public int j;
        public int k;
        public int l;
        public int m;
        public int n;
        public int o;
        public int p;
        public int q;
        public long r;

        public a(int i) {
            this.f8088b = i;
        }

        public String a(String str) {
            return this.f8087a.getString(str);
        }

        public int b(String str) {
            return a(str, 0);
        }

        public long c(String str) {
            return a(str, 0L);
        }

        public String d() {
            int i = this.q;
            return i <= 0 ? "N/A" : String.format(Locale.US, "%d Hz", Integer.valueOf(i));
        }

        public int a(String str, int i) {
            String a2 = a(str);
            if (TextUtils.isEmpty(a2)) {
                return i;
            }
            try {
                return Integer.parseInt(a2);
            } catch (NumberFormatException unused) {
                return i;
            }
        }

        public String b() {
            int i = this.i;
            return (i <= 0 || this.j <= 0) ? "N/A" : (this.o <= 0 || this.p <= 0) ? String.format(Locale.US, "%d x %d", Integer.valueOf(this.i), Integer.valueOf(this.j)) : String.format(Locale.US, "%d x %d [SAR %d:%d]", Integer.valueOf(i), Integer.valueOf(this.j), Integer.valueOf(this.o), Integer.valueOf(this.p));
        }

        public String c() {
            long j = this.h;
            return j <= 0 ? "N/A" : j < 1000 ? String.format(Locale.US, "%d bit/s", Long.valueOf(j)) : String.format(Locale.US, "%d kb/s", Long.valueOf(j / 1000));
        }

        public long a(String str, long j) {
            String a2 = a(str);
            if (TextUtils.isEmpty(a2)) {
                return j;
            }
            try {
                return Long.parseLong(a2);
            } catch (NumberFormatException unused) {
                return j;
            }
        }

        public String a() {
            return !TextUtils.isEmpty(this.e) ? this.e : "N/A";
        }
    }

    public String a(String str) {
        return this.f8083a.getString(str);
    }

    public long b(String str) {
        return a(str, 0L);
    }

    public ArrayList<Bundle> c(String str) {
        return this.f8083a.getParcelableArrayList(str);
    }

    public int a(String str, int i) {
        String a2 = a(str);
        if (TextUtils.isEmpty(a2)) {
            return i;
        }
        try {
            return Integer.parseInt(a2);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public long a(String str, long j) {
        String a2 = a(str);
        if (TextUtils.isEmpty(a2)) {
            return j;
        }
        try {
            return Long.parseLong(a2);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    public static c a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        c cVar = new c();
        cVar.f8083a = bundle;
        cVar.f8084b = cVar.a(ParamConst.VOD_DETAIL_QUERY_RSP_FORMAT);
        cVar.f8085c = cVar.b("duration_us");
        cVar.f8086d = cVar.b("start_us");
        cVar.e = cVar.b("bitrate");
        int i = -1;
        int a2 = cVar.a("video", -1);
        int a3 = cVar.a(MimeTypes.BASE_TYPE_AUDIO, -1);
        cVar.a("timedtext", -1);
        ArrayList<Bundle> c2 = cVar.c("streams");
        if (c2 == null) {
            return cVar;
        }
        Iterator<Bundle> it2 = c2.iterator();
        while (it2.hasNext()) {
            Bundle next = it2.next();
            i++;
            if (next != null) {
                a aVar = new a(i);
                aVar.f8087a = next;
                aVar.f8089c = aVar.a("type");
                aVar.f8090d = aVar.a("language");
                if (!TextUtils.isEmpty(aVar.f8089c)) {
                    aVar.e = aVar.a("codec_name");
                    aVar.f = aVar.a("codec_profile");
                    aVar.g = aVar.a("codec_long_name");
                    aVar.h = aVar.b("bitrate");
                    if (aVar.f8089c.equalsIgnoreCase("video")) {
                        aVar.i = aVar.b("width");
                        aVar.j = aVar.b("height");
                        aVar.k = aVar.b("fps_num");
                        aVar.l = aVar.b("fps_den");
                        aVar.m = aVar.b("tbr_num");
                        aVar.n = aVar.b("tbr_den");
                        aVar.o = aVar.b("sar_num");
                        aVar.p = aVar.b("sar_den");
                        if (a2 == i) {
                            cVar.g = aVar;
                        }
                    } else if (aVar.f8089c.equalsIgnoreCase(MimeTypes.BASE_TYPE_AUDIO)) {
                        aVar.q = aVar.b("sample_rate");
                        aVar.r = aVar.c("channel_layout");
                        if (a3 == i) {
                            cVar.h = aVar;
                        }
                    }
                    cVar.f.add(aVar);
                }
            }
        }
        return cVar;
    }
}
