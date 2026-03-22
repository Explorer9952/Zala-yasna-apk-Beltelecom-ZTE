package com.scwang.smartrefresh.layout.b;

import android.view.MotionEvent;
import android.view.View;
import com.scwang.smartrefresh.layout.a.i;

/* compiled from: RefreshScrollBoundaryAdapter.java */
/* loaded from: classes.dex */
public class d implements i {

    /* renamed from: a, reason: collision with root package name */
    MotionEvent f2745a;

    /* renamed from: b, reason: collision with root package name */
    i f2746b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(MotionEvent motionEvent) {
        this.f2745a = motionEvent;
    }

    @Override // com.scwang.smartrefresh.layout.a.i
    public boolean b(View view) {
        i iVar = this.f2746b;
        if (iVar != null) {
            return iVar.b(view);
        }
        return com.scwang.smartrefresh.layout.e.b.a(view, this.f2745a);
    }

    @Override // com.scwang.smartrefresh.layout.a.i
    public boolean a(View view) {
        i iVar = this.f2746b;
        if (iVar != null) {
            return iVar.a(view);
        }
        return com.scwang.smartrefresh.layout.e.b.b(view, this.f2745a);
    }
}
