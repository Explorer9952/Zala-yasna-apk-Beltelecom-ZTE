package c.a.a.a.d;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import c.a.a.a.b.g;
import c.a.a.a.b.h;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SkinInflaterFactory.java */
/* loaded from: classes.dex */
public class a implements LayoutInflater.Factory {

    /* renamed from: a, reason: collision with root package name */
    private List<h> f1863a = new ArrayList();

    private View a(Context context, String str, AttributeSet attributeSet) {
        View createView;
        try {
            if (-1 == str.indexOf(46)) {
                createView = "View".equals(str) ? LayoutInflater.from(context).createView(str, "android.view.", attributeSet) : null;
                if (createView == null) {
                    createView = LayoutInflater.from(context).createView(str, "android.widget.", attributeSet);
                }
                if (createView == null) {
                    createView = LayoutInflater.from(context).createView(str, "android.webkit.", attributeSet);
                }
            } else {
                createView = LayoutInflater.from(context).createView(str, null, attributeSet);
            }
            c.a.a.a.e.a.b("about to create " + str);
            return createView;
        } catch (Exception e) {
            c.a.a.a.e.a.a("error while create 【" + str + "】 : " + e.getMessage());
            return null;
        }
    }

    public void b() {
        if (c.a.a.a.e.b.a(this.f1863a)) {
            return;
        }
        for (h hVar : this.f1863a) {
            if (hVar.f1861a != null) {
                hVar.b();
            }
        }
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View a2;
        if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/android/skin", "enable", false) || (a2 = a(context, str, attributeSet)) == null) {
            return null;
        }
        a(context, attributeSet, a2);
        return a2;
    }

    private void a(Context context, AttributeSet attributeSet, View view) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < attributeSet.getAttributeCount(); i++) {
            String attributeName = attributeSet.getAttributeName(i);
            String attributeValue = attributeSet.getAttributeValue(i);
            if (c.a.a.a.b.a.a(attributeName) && attributeValue.startsWith("@")) {
                try {
                    int parseInt = Integer.parseInt(attributeValue.substring(1));
                    g a2 = c.a.a.a.b.a.a(attributeName, parseInt, context.getResources().getResourceEntryName(parseInt), context.getResources().getResourceTypeName(parseInt));
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                } catch (Resources.NotFoundException e) {
                    e.printStackTrace();
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
        }
        if (c.a.a.a.e.b.a(arrayList)) {
            return;
        }
        h hVar = new h();
        hVar.f1861a = view;
        hVar.f1862b = arrayList;
        this.f1863a.add(hVar);
        if (b.d().a()) {
            hVar.a();
        }
    }

    public void a() {
        if (c.a.a.a.e.b.a(this.f1863a)) {
            return;
        }
        for (h hVar : this.f1863a) {
            if (hVar.f1861a != null) {
                hVar.a();
            }
        }
    }

    public void a(Context context, View view, String str, int i) {
        g a2 = c.a.a.a.b.a.a(str, i, context.getResources().getResourceEntryName(i), context.getResources().getResourceTypeName(i));
        h hVar = new h();
        hVar.f1861a = view;
        ArrayList arrayList = new ArrayList();
        arrayList.add(a2);
        hVar.f1862b = arrayList;
        a(hVar);
    }

    public void a(h hVar) {
        this.f1863a.add(hVar);
    }
}
