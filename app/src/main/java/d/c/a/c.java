package d.c.a;

import android.view.animation.Interpolator;
import d.c.a.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: AnimatorSet.java */
/* loaded from: classes.dex */
public final class c extends d.c.a.a {
    private boolean i;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<d.c.a.a> f7959b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private HashMap<d.c.a.a, f> f7960c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<f> f7961d = new ArrayList<>();
    private ArrayList<f> e = new ArrayList<>();
    private boolean f = true;
    private b g = null;
    boolean h = false;
    private long j = 0;
    private m k = null;

    /* compiled from: AnimatorSet.java */
    /* loaded from: classes.dex */
    class a extends d.c.a.b {

        /* renamed from: a, reason: collision with root package name */
        boolean f7962a = false;

        /* renamed from: c, reason: collision with root package name */
        private final /* synthetic */ ArrayList f7964c;

        a(ArrayList arrayList) {
            this.f7964c = arrayList;
        }

        @Override // d.c.a.a.InterfaceC0407a
        public void c(d.c.a.a aVar) {
            if (this.f7962a) {
                return;
            }
            int size = this.f7964c.size();
            for (int i = 0; i < size; i++) {
                f fVar = (f) this.f7964c.get(i);
                fVar.f7974a.b();
                c.this.f7959b.add(fVar.f7974a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatorSet.java */
    /* loaded from: classes.dex */
    public class b implements a.InterfaceC0407a {

        /* renamed from: a, reason: collision with root package name */
        private c f7965a;

        b(c cVar) {
            this.f7965a = cVar;
        }

        @Override // d.c.a.a.InterfaceC0407a
        public void a(d.c.a.a aVar) {
        }

        @Override // d.c.a.a.InterfaceC0407a
        public void b(d.c.a.a aVar) {
        }

        @Override // d.c.a.a.InterfaceC0407a
        public void c(d.c.a.a aVar) {
            aVar.b(this);
            c.this.f7959b.remove(aVar);
            boolean z = true;
            ((f) this.f7965a.f7960c.get(aVar)).f = true;
            if (c.this.h) {
                return;
            }
            ArrayList arrayList = this.f7965a.e;
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (!((f) arrayList.get(i)).f) {
                    z = false;
                    break;
                }
                i++;
            }
            if (z) {
                ArrayList<a.InterfaceC0407a> arrayList2 = c.this.f7958a;
                if (arrayList2 != null) {
                    ArrayList arrayList3 = (ArrayList) arrayList2.clone();
                    int size2 = arrayList3.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((a.InterfaceC0407a) arrayList3.get(i2)).c(this.f7965a);
                    }
                }
                this.f7965a.i = false;
            }
        }
    }

    /* compiled from: AnimatorSet.java */
    /* renamed from: d.c.a.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0408c {

        /* renamed from: a, reason: collision with root package name */
        private f f7967a;

        C0408c(d.c.a.a aVar) {
            f fVar = (f) c.this.f7960c.get(aVar);
            this.f7967a = fVar;
            if (fVar == null) {
                this.f7967a = new f(aVar);
                c.this.f7960c.put(aVar, this.f7967a);
                c.this.f7961d.add(this.f7967a);
            }
        }

        public C0408c a(d.c.a.a aVar) {
            f fVar = (f) c.this.f7960c.get(aVar);
            if (fVar == null) {
                fVar = new f(aVar);
                c.this.f7960c.put(aVar, fVar);
                c.this.f7961d.add(fVar);
            }
            fVar.a(new d(this.f7967a, 0));
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatorSet.java */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public f f7969a;

        /* renamed from: b, reason: collision with root package name */
        public int f7970b;

        public d(f fVar, int i) {
            this.f7969a = fVar;
            this.f7970b = i;
        }
    }

    /* compiled from: AnimatorSet.java */
    /* loaded from: classes.dex */
    private static class e implements a.InterfaceC0407a {

        /* renamed from: a, reason: collision with root package name */
        private c f7971a;

        /* renamed from: b, reason: collision with root package name */
        private f f7972b;

        /* renamed from: c, reason: collision with root package name */
        private int f7973c;

        public e(c cVar, f fVar, int i) {
            this.f7971a = cVar;
            this.f7972b = fVar;
            this.f7973c = i;
        }

        private void d(d.c.a.a aVar) {
            if (this.f7971a.h) {
                return;
            }
            d dVar = null;
            int size = this.f7972b.f7976c.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    d dVar2 = this.f7972b.f7976c.get(i);
                    if (dVar2.f7970b == this.f7973c && dVar2.f7969a.f7974a == aVar) {
                        aVar.b(this);
                        dVar = dVar2;
                        break;
                    }
                    i++;
                } else {
                    break;
                }
            }
            this.f7972b.f7976c.remove(dVar);
            if (this.f7972b.f7976c.size() == 0) {
                this.f7972b.f7974a.b();
                this.f7971a.f7959b.add(this.f7972b.f7974a);
            }
        }

        @Override // d.c.a.a.InterfaceC0407a
        public void a(d.c.a.a aVar) {
        }

        @Override // d.c.a.a.InterfaceC0407a
        public void b(d.c.a.a aVar) {
            if (this.f7973c == 0) {
                d(aVar);
            }
        }

        @Override // d.c.a.a.InterfaceC0407a
        public void c(d.c.a.a aVar) {
            if (this.f7973c == 1) {
                d(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatorSet.java */
    /* loaded from: classes.dex */
    public static class f implements Cloneable {

        /* renamed from: a, reason: collision with root package name */
        public d.c.a.a f7974a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<d> f7975b = null;

        /* renamed from: c, reason: collision with root package name */
        public ArrayList<d> f7976c = null;

        /* renamed from: d, reason: collision with root package name */
        public ArrayList<f> f7977d = null;
        public ArrayList<f> e = null;
        public boolean f = false;

        public f(d.c.a.a aVar) {
            this.f7974a = aVar;
        }

        public void a(d dVar) {
            if (this.f7975b == null) {
                this.f7975b = new ArrayList<>();
                this.f7977d = new ArrayList<>();
            }
            this.f7975b.add(dVar);
            if (!this.f7977d.contains(dVar.f7969a)) {
                this.f7977d.add(dVar.f7969a);
            }
            f fVar = dVar.f7969a;
            if (fVar.e == null) {
                fVar.e = new ArrayList<>();
            }
            fVar.e.add(this);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public f m13clone() {
            try {
                f fVar = (f) super.clone();
                fVar.f7974a = this.f7974a.m12clone();
                return fVar;
            } catch (CloneNotSupportedException unused) {
                throw new AssertionError();
            }
        }
    }

    @Override // d.c.a.a
    public /* bridge */ /* synthetic */ d.c.a.a a(long j) {
        a(j);
        return this;
    }

    private void c() {
        if (this.f) {
            this.e.clear();
            ArrayList arrayList = new ArrayList();
            int size = this.f7961d.size();
            for (int i = 0; i < size; i++) {
                f fVar = this.f7961d.get(i);
                ArrayList<d> arrayList2 = fVar.f7975b;
                if (arrayList2 == null || arrayList2.size() == 0) {
                    arrayList.add(fVar);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            while (arrayList.size() > 0) {
                int size2 = arrayList.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    f fVar2 = (f) arrayList.get(i2);
                    this.e.add(fVar2);
                    ArrayList<f> arrayList4 = fVar2.e;
                    if (arrayList4 != null) {
                        int size3 = arrayList4.size();
                        for (int i3 = 0; i3 < size3; i3++) {
                            f fVar3 = fVar2.e.get(i3);
                            fVar3.f7977d.remove(fVar2);
                            if (fVar3.f7977d.size() == 0) {
                                arrayList3.add(fVar3);
                            }
                        }
                    }
                }
                arrayList.clear();
                arrayList.addAll(arrayList3);
                arrayList3.clear();
            }
            this.f = false;
            if (this.e.size() != this.f7961d.size()) {
                throw new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
            }
            return;
        }
        int size4 = this.f7961d.size();
        for (int i4 = 0; i4 < size4; i4++) {
            f fVar4 = this.f7961d.get(i4);
            ArrayList<d> arrayList5 = fVar4.f7975b;
            if (arrayList5 != null && arrayList5.size() > 0) {
                int size5 = fVar4.f7975b.size();
                for (int i5 = 0; i5 < size5; i5++) {
                    d dVar = fVar4.f7975b.get(i5);
                    if (fVar4.f7977d == null) {
                        fVar4.f7977d = new ArrayList<>();
                    }
                    if (!fVar4.f7977d.contains(dVar.f7969a)) {
                        fVar4.f7977d.add(dVar.f7969a);
                    }
                }
            }
            fVar4.f = false;
        }
    }

    @Override // d.c.a.a
    public void b() {
        ArrayList<a.InterfaceC0407a> arrayList;
        this.h = false;
        c();
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            f fVar = this.e.get(i);
            ArrayList<a.InterfaceC0407a> a2 = fVar.f7974a.a();
            if (a2 != null && a2.size() > 0) {
                Iterator it2 = new ArrayList(a2).iterator();
                while (it2.hasNext()) {
                    a.InterfaceC0407a interfaceC0407a = (a.InterfaceC0407a) it2.next();
                    if ((interfaceC0407a instanceof e) || (interfaceC0407a instanceof b)) {
                        fVar.f7974a.b(interfaceC0407a);
                    }
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            f fVar2 = this.e.get(i2);
            if (this.g == null) {
                this.g = new b(this);
            }
            ArrayList<d> arrayList3 = fVar2.f7975b;
            if (arrayList3 != null && arrayList3.size() != 0) {
                int size2 = fVar2.f7975b.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    d dVar = fVar2.f7975b.get(i3);
                    dVar.f7969a.f7974a.a(new e(this, fVar2, dVar.f7970b));
                }
                fVar2.f7976c = (ArrayList) fVar2.f7975b.clone();
            } else {
                arrayList2.add(fVar2);
            }
            fVar2.f7974a.a(this.g);
        }
        if (this.j <= 0) {
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                f fVar3 = (f) it3.next();
                fVar3.f7974a.b();
                this.f7959b.add(fVar3.f7974a);
            }
        } else {
            m b2 = m.b(0.0f, 1.0f);
            this.k = b2;
            b2.a(this.j);
            this.k.a(new a(arrayList2));
            this.k.b();
        }
        ArrayList<a.InterfaceC0407a> arrayList4 = this.f7958a;
        if (arrayList4 != null) {
            ArrayList arrayList5 = (ArrayList) arrayList4.clone();
            int size3 = arrayList5.size();
            for (int i4 = 0; i4 < size3; i4++) {
                ((a.InterfaceC0407a) arrayList5.get(i4)).b(this);
            }
        }
        if (this.f7961d.size() == 0 && this.j == 0 && (arrayList = this.f7958a) != null) {
            ArrayList arrayList6 = (ArrayList) arrayList.clone();
            int size4 = arrayList6.size();
            for (int i5 = 0; i5 < size4; i5++) {
                ((a.InterfaceC0407a) arrayList6.get(i5)).c(this);
            }
        }
    }

    @Override // d.c.a.a
    /* renamed from: clone */
    public c m12clone() {
        c cVar = (c) super.m12clone();
        cVar.f = true;
        cVar.h = false;
        cVar.i = false;
        cVar.f7959b = new ArrayList<>();
        cVar.f7960c = new HashMap<>();
        cVar.f7961d = new ArrayList<>();
        cVar.e = new ArrayList<>();
        HashMap hashMap = new HashMap();
        Iterator<f> it2 = this.f7961d.iterator();
        while (it2.hasNext()) {
            f next = it2.next();
            f m13clone = next.m13clone();
            hashMap.put(next, m13clone);
            cVar.f7961d.add(m13clone);
            cVar.f7960c.put(m13clone.f7974a, m13clone);
            ArrayList arrayList = null;
            m13clone.f7975b = null;
            m13clone.f7976c = null;
            m13clone.e = null;
            m13clone.f7977d = null;
            ArrayList<a.InterfaceC0407a> a2 = m13clone.f7974a.a();
            if (a2 != null) {
                Iterator<a.InterfaceC0407a> it3 = a2.iterator();
                while (it3.hasNext()) {
                    a.InterfaceC0407a next2 = it3.next();
                    if (next2 instanceof b) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(next2);
                    }
                }
                if (arrayList != null) {
                    Iterator it4 = arrayList.iterator();
                    while (it4.hasNext()) {
                        a2.remove((a.InterfaceC0407a) it4.next());
                    }
                }
            }
        }
        Iterator<f> it5 = this.f7961d.iterator();
        while (it5.hasNext()) {
            f next3 = it5.next();
            f fVar = (f) hashMap.get(next3);
            ArrayList<d> arrayList2 = next3.f7975b;
            if (arrayList2 != null) {
                Iterator<d> it6 = arrayList2.iterator();
                while (it6.hasNext()) {
                    d next4 = it6.next();
                    fVar.a(new d((f) hashMap.get(next4.f7969a), next4.f7970b));
                }
            }
        }
        return cVar;
    }

    public void a(d.c.a.a... aVarArr) {
        if (aVarArr != null) {
            this.f = true;
            C0408c a2 = a(aVarArr[0]);
            for (int i = 1; i < aVarArr.length; i++) {
                a2.a(aVarArr[i]);
            }
        }
    }

    public void a(Collection<d.c.a.a> collection) {
        if (collection == null || collection.size() <= 0) {
            return;
        }
        this.f = true;
        C0408c c0408c = null;
        for (d.c.a.a aVar : collection) {
            if (c0408c == null) {
                c0408c = a(aVar);
            } else {
                c0408c.a(aVar);
            }
        }
    }

    @Override // d.c.a.a
    public void a(Interpolator interpolator) {
        Iterator<f> it2 = this.f7961d.iterator();
        while (it2.hasNext()) {
            it2.next().f7974a.a(interpolator);
        }
    }

    public C0408c a(d.c.a.a aVar) {
        if (aVar == null) {
            return null;
        }
        this.f = true;
        return new C0408c(aVar);
    }

    @Override // d.c.a.a
    public c a(long j) {
        if (j >= 0) {
            Iterator<f> it2 = this.f7961d.iterator();
            while (it2.hasNext()) {
                it2.next().f7974a.a(j);
            }
            return this;
        }
        throw new IllegalArgumentException("duration must be a value of zero or greater");
    }
}
