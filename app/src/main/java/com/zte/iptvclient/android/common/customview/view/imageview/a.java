package com.zte.iptvclient.android.common.customview.view.imageview;

import android.content.Context;
import androidx.appcompat.widget.AppCompatImageView;

/* compiled from: AdImageView.java */
/* loaded from: classes.dex */
public class a extends AppCompatImageView {

    /* renamed from: c, reason: collision with root package name */
    private String f4365c;

    /* renamed from: d, reason: collision with root package name */
    private int f4366d;
    private int e;
    private int f;

    public a(Context context) {
        super(context);
    }

    public void a(String str) {
        this.f4365c = str;
    }

    public void b(int i) {
        this.e = i;
    }

    public void c(int i) {
        this.f = i;
    }

    public int g() {
        return this.f4366d;
    }

    public int h() {
        return this.e;
    }

    public int i() {
        return this.f;
    }

    public String j() {
        return this.f4365c;
    }

    public void a(int i) {
        this.f4366d = i;
    }
}
