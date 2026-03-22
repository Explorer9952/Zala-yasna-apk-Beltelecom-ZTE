package d.c.a;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: PropertyValuesHolder.java */
/* loaded from: classes.dex */
public class k implements Cloneable {
    private static final l k = new f();
    private static final l l = new d();
    private static Class[] m;
    private static Class[] n;
    private static Class[] o;
    private static final HashMap<Class, HashMap<String, Method>> p;
    private static final HashMap<Class, HashMap<String, Method>> q;

    /* renamed from: a, reason: collision with root package name */
    String f7991a;

    /* renamed from: b, reason: collision with root package name */
    protected com.nineoldandroids.util.c f7992b;

    /* renamed from: c, reason: collision with root package name */
    Method f7993c;

    /* renamed from: d, reason: collision with root package name */
    private Method f7994d;
    Class e;
    h f;
    final ReentrantReadWriteLock g;
    final Object[] h;
    private l i;
    private Object j;

    /* compiled from: PropertyValuesHolder.java */
    /* loaded from: classes.dex */
    static class a extends k {
        private com.nineoldandroids.util.a r;
        e s;
        float t;

        public a(String str, float... fArr) {
            super(str, (k) null);
            a(fArr);
        }

        @Override // d.c.a.k
        public void a(float... fArr) {
            super.a(fArr);
            this.s = (e) this.f;
        }

        @Override // d.c.a.k
        /* renamed from: clone */
        public a m16clone() {
            a aVar = (a) super.m16clone();
            aVar.s = (e) aVar.f;
            return aVar;
        }

        public a(com.nineoldandroids.util.c cVar, float... fArr) {
            super(cVar, (k) null);
            a(fArr);
            if (cVar instanceof com.nineoldandroids.util.a) {
                this.r = (com.nineoldandroids.util.a) this.f7992b;
            }
        }

        @Override // d.c.a.k
        void a(float f) {
            this.t = this.s.b(f);
        }

        @Override // d.c.a.k
        Object a() {
            return Float.valueOf(this.t);
        }

        @Override // d.c.a.k
        void a(Object obj) {
            com.nineoldandroids.util.a aVar = this.r;
            if (aVar != null) {
                aVar.a((com.nineoldandroids.util.a) obj, this.t);
                return;
            }
            com.nineoldandroids.util.c cVar = this.f7992b;
            if (cVar != null) {
                cVar.a(obj, Float.valueOf(this.t));
                return;
            }
            if (this.f7993c != null) {
                try {
                    this.h[0] = Float.valueOf(this.t);
                    this.f7993c.invoke(obj, this.h);
                } catch (IllegalAccessException e) {
                    Log.e("PropertyValuesHolder", e.toString());
                } catch (InvocationTargetException e2) {
                    Log.e("PropertyValuesHolder", e2.toString());
                }
            }
        }

        @Override // d.c.a.k
        void a(Class cls) {
            if (this.f7992b != null) {
                return;
            }
            super.a(cls);
        }
    }

    static {
        Class cls = Integer.TYPE;
        m = new Class[]{Float.TYPE, Float.class, Double.TYPE, cls, Double.class, Integer.class};
        Class cls2 = Double.TYPE;
        n = new Class[]{cls, Integer.class, Float.TYPE, cls2, Float.class, Double.class};
        o = new Class[]{cls2, Double.class, Float.TYPE, Integer.TYPE, Float.class, Integer.class};
        p = new HashMap<>();
        q = new HashMap<>();
    }

    private k(String str) {
        this.f7993c = null;
        this.f7994d = null;
        this.f = null;
        this.g = new ReentrantReadWriteLock();
        this.h = new Object[1];
        this.f7991a = str;
    }

    public static k a(String str, float... fArr) {
        return new a(str, fArr);
    }

    private void b(Class cls) {
        this.f7994d = a(cls, q, "get", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        l lVar;
        if (this.i == null) {
            Class cls = this.e;
            if (cls == Integer.class) {
                lVar = k;
            } else {
                lVar = cls == Float.class ? l : null;
            }
            this.i = lVar;
        }
        l lVar2 = this.i;
        if (lVar2 != null) {
            this.f.a(lVar2);
        }
    }

    public String toString() {
        return String.valueOf(this.f7991a) + ": " + this.f.toString();
    }

    public static k a(com.nineoldandroids.util.c<?, Float> cVar, float... fArr) {
        return new a(cVar, fArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Object obj) {
        com.nineoldandroids.util.c cVar = this.f7992b;
        if (cVar != null) {
            try {
                cVar.a(obj);
                Iterator<g> it2 = this.f.e.iterator();
                while (it2.hasNext()) {
                    g next = it2.next();
                    if (!next.d()) {
                        next.a(this.f7992b.a(obj));
                    }
                }
                return;
            } catch (ClassCastException unused) {
                Log.e("PropertyValuesHolder", "No such property (" + this.f7992b.a() + ") on target object " + obj + ". Trying reflection instead");
                this.f7992b = null;
            }
        }
        Class<?> cls = obj.getClass();
        if (this.f7993c == null) {
            a((Class) cls);
        }
        Iterator<g> it3 = this.f.e.iterator();
        while (it3.hasNext()) {
            g next2 = it3.next();
            if (!next2.d()) {
                if (this.f7994d == null) {
                    b((Class) cls);
                }
                try {
                    next2.a(this.f7994d.invoke(obj, new Object[0]));
                } catch (IllegalAccessException e) {
                    Log.e("PropertyValuesHolder", e.toString());
                } catch (InvocationTargetException e2) {
                    Log.e("PropertyValuesHolder", e2.toString());
                }
            }
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public k m16clone() {
        try {
            k kVar = (k) super.clone();
            kVar.f7991a = this.f7991a;
            kVar.f7992b = this.f7992b;
            kVar.f = this.f.m15clone();
            kVar.i = this.i;
            return kVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public static k a(String str, l lVar, Object... objArr) {
        k kVar = new k(str);
        kVar.a(objArr);
        kVar.a(lVar);
        return kVar;
    }

    public static <V> k a(com.nineoldandroids.util.c cVar, l<V> lVar, V... vArr) {
        k kVar = new k(cVar);
        kVar.a((Object[]) vArr);
        kVar.a((l) lVar);
        return kVar;
    }

    /* synthetic */ k(String str, k kVar) {
        this(str);
    }

    private k(com.nineoldandroids.util.c cVar) {
        this.f7993c = null;
        this.f7994d = null;
        this.f = null;
        this.g = new ReentrantReadWriteLock();
        this.h = new Object[1];
        this.f7992b = cVar;
        if (cVar != null) {
            this.f7991a = cVar.a();
        }
    }

    public void a(float... fArr) {
        this.e = Float.TYPE;
        this.f = h.a(fArr);
    }

    public void a(Object... objArr) {
        this.e = objArr[0].getClass();
        this.f = h.a(objArr);
    }

    private Method a(Class cls, String str, Class cls2) {
        Class<?>[] clsArr;
        String a2 = a(str, this.f7991a);
        Method method = null;
        if (cls2 == null) {
            try {
                return cls.getMethod(a2, null);
            } catch (NoSuchMethodException e) {
                try {
                    method = cls.getDeclaredMethod(a2, null);
                    method.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                    Log.e("PropertyValuesHolder", "Couldn't find no-arg method for property " + this.f7991a + ": " + e);
                }
            }
        } else {
            Class<?>[] clsArr2 = new Class[1];
            if (this.e.equals(Float.class)) {
                clsArr = m;
            } else if (this.e.equals(Integer.class)) {
                clsArr = n;
            } else {
                clsArr = this.e.equals(Double.class) ? o : new Class[]{this.e};
            }
            for (Class<?> cls3 : clsArr) {
                clsArr2[0] = cls3;
                try {
                    try {
                        Method method2 = cls.getMethod(a2, clsArr2);
                        this.e = cls3;
                        return method2;
                    } catch (NoSuchMethodException unused2) {
                    }
                } catch (NoSuchMethodException unused3) {
                    method = cls.getDeclaredMethod(a2, clsArr2);
                    method.setAccessible(true);
                    this.e = cls3;
                    return method;
                }
            }
            Log.e("PropertyValuesHolder", "Couldn't find setter/getter for property " + this.f7991a + " with value type " + this.e);
        }
        return method;
    }

    /* synthetic */ k(com.nineoldandroids.util.c cVar, k kVar) {
        this(cVar);
    }

    public String b() {
        return this.f7991a;
    }

    private Method a(Class cls, HashMap<Class, HashMap<String, Method>> hashMap, String str, Class cls2) {
        try {
            this.g.writeLock().lock();
            HashMap<String, Method> hashMap2 = hashMap.get(cls);
            Method method = hashMap2 != null ? hashMap2.get(this.f7991a) : null;
            if (method == null) {
                method = a(cls, str, cls2);
                if (hashMap2 == null) {
                    hashMap2 = new HashMap<>();
                    hashMap.put(cls, hashMap2);
                }
                hashMap2.put(this.f7991a, method);
            }
            return method;
        } finally {
            this.g.writeLock().unlock();
        }
    }

    void a(Class cls) {
        this.f7993c = a(cls, p, "set", this.e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Object obj) {
        com.nineoldandroids.util.c cVar = this.f7992b;
        if (cVar != null) {
            cVar.a(obj, a());
        }
        if (this.f7993c != null) {
            try {
                this.h[0] = a();
                this.f7993c.invoke(obj, this.h);
            } catch (IllegalAccessException e) {
                Log.e("PropertyValuesHolder", e.toString());
            } catch (InvocationTargetException e2) {
                Log.e("PropertyValuesHolder", e2.toString());
            }
        }
    }

    public void a(l lVar) {
        this.i = lVar;
        this.f.a(lVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f) {
        this.j = this.f.a(f);
    }

    public void a(String str) {
        this.f7991a = str;
    }

    public void a(com.nineoldandroids.util.c cVar) {
        this.f7992b = cVar;
    }

    Object a() {
        return this.j;
    }

    static String a(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            return str;
        }
        return String.valueOf(str) + Character.toUpperCase(str2.charAt(0)) + str2.substring(1);
    }
}
