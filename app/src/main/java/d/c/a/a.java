package d.c.a;

import android.view.animation.Interpolator;
import java.util.ArrayList;

/* compiled from: Animator.java */
/* loaded from: classes.dex */
public abstract class a implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    ArrayList<InterfaceC0407a> f7958a = null;

    /* compiled from: Animator.java */
    /* renamed from: d.c.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0407a {
        void a(a aVar);

        void b(a aVar);

        void c(a aVar);
    }

    public abstract a a(long j);

    public abstract void a(Interpolator interpolator);

    public void a(InterfaceC0407a interfaceC0407a) {
        if (this.f7958a == null) {
            this.f7958a = new ArrayList<>();
        }
        this.f7958a.add(interfaceC0407a);
    }

    public void b() {
    }

    public void b(InterfaceC0407a interfaceC0407a) {
        ArrayList<InterfaceC0407a> arrayList = this.f7958a;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(interfaceC0407a);
        if (this.f7958a.size() == 0) {
            this.f7958a = null;
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public a m12clone() {
        try {
            a aVar = (a) super.clone();
            if (this.f7958a != null) {
                ArrayList<InterfaceC0407a> arrayList = this.f7958a;
                aVar.f7958a = new ArrayList<>();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    aVar.f7958a.add(arrayList.get(i));
                }
            }
            return aVar;
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }

    public ArrayList<InterfaceC0407a> a() {
        return this.f7958a;
    }
}
