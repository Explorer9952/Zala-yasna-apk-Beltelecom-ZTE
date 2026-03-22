package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.j;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: MultiTransformation.java */
/* loaded from: classes.dex */
public class c<T> implements f<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Collection<? extends f<T>> f1962a;

    /* renamed from: b, reason: collision with root package name */
    private String f1963b;

    @SafeVarargs
    public c(f<T>... fVarArr) {
        if (fVarArr.length >= 1) {
            this.f1962a = Arrays.asList(fVarArr);
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }

    @Override // com.bumptech.glide.load.f
    public j<T> a(j<T> jVar, int i, int i2) {
        Iterator<? extends f<T>> it2 = this.f1962a.iterator();
        j<T> jVar2 = jVar;
        while (it2.hasNext()) {
            j<T> a2 = it2.next().a(jVar2, i, i2);
            if (jVar2 != null && !jVar2.equals(jVar) && !jVar2.equals(a2)) {
                jVar2.a();
            }
            jVar2 = a2;
        }
        return jVar2;
    }

    @Override // com.bumptech.glide.load.f
    public String a() {
        if (this.f1963b == null) {
            StringBuilder sb = new StringBuilder();
            Iterator<? extends f<T>> it2 = this.f1962a.iterator();
            while (it2.hasNext()) {
                sb.append(it2.next().a());
            }
            this.f1963b = sb.toString();
        }
        return this.f1963b;
    }
}
