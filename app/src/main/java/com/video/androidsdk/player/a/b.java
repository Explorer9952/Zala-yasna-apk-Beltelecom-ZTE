package com.video.androidsdk.player.a;

import com.render.vrlib.a.g;
import ijk.media.player.IMediaPlayer;
import ijk.media.player.IjkMediaPlayer;

/* compiled from: TexturePlayer.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public String f3313a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3314b;

    /* renamed from: c, reason: collision with root package name */
    private IMediaPlayer f3315c = new IjkMediaPlayer();

    /* renamed from: d, reason: collision with root package name */
    private g f3316d = null;
    private boolean e = false;
    private boolean f = false;
    private int g = 0;
    private float h;

    public IMediaPlayer a() {
        return this.f3315c;
    }

    public g b() {
        return this.f3316d;
    }

    public boolean c() {
        return this.e;
    }

    public boolean d() {
        return this.f;
    }

    public int e() {
        return this.g;
    }

    public float f() {
        return this.h;
    }

    public void g() {
        this.f3315c.setSurface(null);
        this.f3315c.stop();
        this.f3315c.reset();
        this.f3315c.release();
    }

    public void a(g gVar) {
        this.f3316d = gVar;
    }

    public void b(boolean z) {
        this.f = z;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public void a(int i) {
        this.g = i;
    }

    public void a(float f) {
        this.h = f;
    }
}
