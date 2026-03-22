package com.bumptech.glide.load.engine.l;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* compiled from: SizeConfigStrategy.java */
@TargetApi(19)
/* loaded from: classes.dex */
public class i implements g {

    /* renamed from: d, reason: collision with root package name */
    private static final Bitmap.Config[] f2030d = {Bitmap.Config.ARGB_8888, null};
    private static final Bitmap.Config[] e = {Bitmap.Config.RGB_565};
    private static final Bitmap.Config[] f = {Bitmap.Config.ARGB_4444};
    private static final Bitmap.Config[] g = {Bitmap.Config.ALPHA_8};

    /* renamed from: a, reason: collision with root package name */
    private final c f2031a = new c();

    /* renamed from: b, reason: collision with root package name */
    private final e<b, Bitmap> f2032b = new e<>();

    /* renamed from: c, reason: collision with root package name */
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> f2033c = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SizeConfigStrategy.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2034a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f2034a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2034a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2034a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2034a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SizeConfigStrategy.java */
    /* loaded from: classes.dex */
    public static final class b implements h {

        /* renamed from: a, reason: collision with root package name */
        private final c f2035a;

        /* renamed from: b, reason: collision with root package name */
        private int f2036b;

        /* renamed from: c, reason: collision with root package name */
        private Bitmap.Config f2037c;

        public b(c cVar) {
            this.f2035a = cVar;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f2036b != bVar.f2036b) {
                return false;
            }
            Bitmap.Config config = this.f2037c;
            Bitmap.Config config2 = bVar.f2037c;
            if (config == null) {
                if (config2 != null) {
                    return false;
                }
            } else if (!config.equals(config2)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i = this.f2036b * 31;
            Bitmap.Config config = this.f2037c;
            return i + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return i.b(this.f2036b, this.f2037c);
        }

        public void a(int i, Bitmap.Config config) {
            this.f2036b = i;
            this.f2037c = config;
        }

        @Override // com.bumptech.glide.load.engine.l.h
        public void a() {
            this.f2035a.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SizeConfigStrategy.java */
    /* loaded from: classes.dex */
    public static class c extends com.bumptech.glide.load.engine.l.b<b> {
        c() {
        }

        public b a(int i, Bitmap.Config config) {
            b b2 = b();
            b2.a(i, config);
            return b2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.l.b
        public b a() {
            return new b(this);
        }
    }

    private NavigableMap<Integer, Integer> b(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.f2033c.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f2033c.put(config, treeMap);
        return treeMap;
    }

    @Override // com.bumptech.glide.load.engine.l.g
    public String c(Bitmap bitmap) {
        return b(com.bumptech.glide.s.h.a(bitmap), bitmap.getConfig());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.f2032b);
        sb.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.f2033c.entrySet()) {
            sb.append(entry.getKey());
            sb.append('[');
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!this.f2033c.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }

    @Override // com.bumptech.glide.load.engine.l.g
    public void a(Bitmap bitmap) {
        b a2 = this.f2031a.a(com.bumptech.glide.s.h.a(bitmap), bitmap.getConfig());
        this.f2032b.a(a2, bitmap);
        NavigableMap<Integer, Integer> b2 = b(bitmap.getConfig());
        Integer num = (Integer) b2.get(Integer.valueOf(a2.f2036b));
        b2.put(Integer.valueOf(a2.f2036b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // com.bumptech.glide.load.engine.l.g
    public String b(int i, int i2, Bitmap.Config config) {
        return b(com.bumptech.glide.s.h.a(i, i2, config), config);
    }

    @Override // com.bumptech.glide.load.engine.l.g
    public int b(Bitmap bitmap) {
        return com.bumptech.glide.s.h.a(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(int i, Bitmap.Config config) {
        return "[" + i + "](" + config + ")";
    }

    @Override // com.bumptech.glide.load.engine.l.g
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        int a2 = com.bumptech.glide.s.h.a(i, i2, config);
        Bitmap a3 = this.f2032b.a((e<b, Bitmap>) a(this.f2031a.a(a2, config), a2, config));
        if (a3 != null) {
            a(Integer.valueOf(com.bumptech.glide.s.h.a(a3)), a3.getConfig());
            a3.reconfigure(i, i2, a3.getConfig() != null ? a3.getConfig() : Bitmap.Config.ARGB_8888);
        }
        return a3;
    }

    private b a(b bVar, int i, Bitmap.Config config) {
        for (Bitmap.Config config2 : a(config)) {
            Integer ceilingKey = b(config2).ceilingKey(Integer.valueOf(i));
            if (ceilingKey != null && ceilingKey.intValue() <= i * 8) {
                if (ceilingKey.intValue() == i) {
                    if (config2 == null) {
                        if (config == null) {
                            return bVar;
                        }
                    } else if (config2.equals(config)) {
                        return bVar;
                    }
                }
                this.f2031a.a(bVar);
                return this.f2031a.a(ceilingKey.intValue(), config2);
            }
        }
        return bVar;
    }

    @Override // com.bumptech.glide.load.engine.l.g
    public Bitmap a() {
        Bitmap a2 = this.f2032b.a();
        if (a2 != null) {
            a(Integer.valueOf(com.bumptech.glide.s.h.a(a2)), a2.getConfig());
        }
        return a2;
    }

    private void a(Integer num, Bitmap.Config config) {
        NavigableMap<Integer, Integer> b2 = b(config);
        Integer num2 = (Integer) b2.get(num);
        if (num2.intValue() == 1) {
            b2.remove(num);
        } else {
            b2.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    private static Bitmap.Config[] a(Bitmap.Config config) {
        int i = a.f2034a[config.ordinal()];
        if (i == 1) {
            return f2030d;
        }
        if (i == 2) {
            return e;
        }
        if (i != 3) {
            return i != 4 ? new Bitmap.Config[]{config} : g;
        }
        return f;
    }
}
