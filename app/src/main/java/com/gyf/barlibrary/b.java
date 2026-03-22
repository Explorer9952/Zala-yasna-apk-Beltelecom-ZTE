package com.gyf.barlibrary;

import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BarParams.java */
/* loaded from: classes.dex */
public class b implements Cloneable {
    View q;
    View r;
    int s;
    h y;

    /* renamed from: a, reason: collision with root package name */
    int f2365a = 0;

    /* renamed from: b, reason: collision with root package name */
    int f2366b = -16777216;

    /* renamed from: c, reason: collision with root package name */
    int f2367c = -16777216;

    /* renamed from: d, reason: collision with root package name */
    float f2368d = 0.0f;
    float e = 0.0f;
    public boolean f = false;
    boolean g = false;
    BarHide h = BarHide.FLAG_SHOW_BAR;
    boolean i = false;
    boolean j = false;
    boolean k = true;
    int l = -16777216;
    int m = -16777216;
    Map<View, Map<Integer, Integer>> n = new HashMap();
    float o = 0.0f;
    public boolean p = false;
    boolean t = false;
    public boolean u = false;
    int v = 18;
    boolean w = true;
    boolean x = true;

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public b m11clone() {
        try {
            return (b) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
