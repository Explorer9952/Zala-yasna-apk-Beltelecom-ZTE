package com.bumptech.glide.load.h;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: LazyHeaders.java */
/* loaded from: classes.dex */
public final class j implements e {

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, List<i>> f2089b;

    /* renamed from: c, reason: collision with root package name */
    private volatile Map<String, String> f2090c;

    /* compiled from: LazyHeaders.java */
    /* loaded from: classes.dex */
    public static final class a {
        private static final String e = System.getProperty("http.agent");
        private static final Map<String, List<i>> f;

        /* renamed from: a, reason: collision with root package name */
        private boolean f2091a = true;

        /* renamed from: b, reason: collision with root package name */
        private Map<String, List<i>> f2092b = f;

        /* renamed from: c, reason: collision with root package name */
        private boolean f2093c = true;

        /* renamed from: d, reason: collision with root package name */
        private boolean f2094d = true;

        static {
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(e)) {
                hashMap.put("User-Agent", Collections.singletonList(new b(e)));
            }
            hashMap.put("Accept-Encoding", Collections.singletonList(new b("identity")));
            f = Collections.unmodifiableMap(hashMap);
        }

        private void c() {
            if (this.f2091a) {
                this.f2091a = false;
                this.f2092b = b();
            }
        }

        public a a(String str, String str2) {
            a(str, new b(str2));
            return this;
        }

        public a b(String str, i iVar) {
            c();
            if (iVar == null) {
                this.f2092b.remove(str);
            } else {
                List<i> a2 = a(str);
                a2.clear();
                a2.add(iVar);
            }
            if (this.f2093c && "Accept-Encoding".equalsIgnoreCase(str)) {
                this.f2093c = false;
            }
            if (this.f2094d && "User-Agent".equalsIgnoreCase(str)) {
                this.f2094d = false;
            }
            return this;
        }

        public a a(String str, i iVar) {
            if ((this.f2093c && "Accept-Encoding".equalsIgnoreCase(str)) || (this.f2094d && "User-Agent".equalsIgnoreCase(str))) {
                b(str, iVar);
                return this;
            }
            c();
            a(str).add(iVar);
            return this;
        }

        private List<i> a(String str) {
            List<i> list = this.f2092b.get(str);
            if (list != null) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            this.f2092b.put(str, arrayList);
            return arrayList;
        }

        public j a() {
            this.f2091a = true;
            return new j(this.f2092b);
        }

        private Map<String, List<i>> b() {
            HashMap hashMap = new HashMap(this.f2092b.size());
            for (Map.Entry<String, List<i>> entry : this.f2092b.entrySet()) {
                hashMap.put(entry.getKey(), new ArrayList(entry.getValue()));
            }
            return hashMap;
        }
    }

    /* compiled from: LazyHeaders.java */
    /* loaded from: classes.dex */
    static final class b implements i {

        /* renamed from: a, reason: collision with root package name */
        private final String f2095a;

        b(String str) {
            this.f2095a = str;
        }

        @Override // com.bumptech.glide.load.h.i
        public String a() {
            return this.f2095a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f2095a.equals(((b) obj).f2095a);
            }
            return false;
        }

        public int hashCode() {
            return this.f2095a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f2095a + "'}";
        }
    }

    j(Map<String, List<i>> map) {
        this.f2089b = Collections.unmodifiableMap(map);
    }

    private Map<String, String> b() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<i>> entry : this.f2089b.entrySet()) {
            StringBuilder sb = new StringBuilder();
            List<i> value = entry.getValue();
            for (int i = 0; i < value.size(); i++) {
                sb.append(value.get(i).a());
                if (i != value.size() - 1) {
                    sb.append(',');
                }
            }
            hashMap.put(entry.getKey(), sb.toString());
        }
        return hashMap;
    }

    @Override // com.bumptech.glide.load.h.e
    public Map<String, String> a() {
        if (this.f2090c == null) {
            synchronized (this) {
                if (this.f2090c == null) {
                    this.f2090c = Collections.unmodifiableMap(b());
                }
            }
        }
        return this.f2090c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f2089b.equals(((j) obj).f2089b);
        }
        return false;
    }

    public int hashCode() {
        return this.f2089b.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f2089b + '}';
    }
}
