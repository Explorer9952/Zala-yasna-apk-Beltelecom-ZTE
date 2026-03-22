package com.video.androidsdk.player.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.FrameLayout;
import com.render.vrlib.MDVRLibrary;
import com.render.vrlib.n.a;
import com.render.vrlib.w.o;
import com.rendergl.google.android.apps.muzei.GLTextureView;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.player.render.RenderImpl;

/* loaded from: classes.dex */
public class VrView extends RenderImpl {

    /* renamed from: a, reason: collision with root package name */
    private FrameLayout f3395a;

    /* renamed from: b, reason: collision with root package name */
    private String f3396b;

    public VrView(Context context, FrameLayout frameLayout) {
        this.m = context;
        this.f3395a = frameLayout;
    }

    public void loadVrPic(String str) {
        this.f3396b = str;
        GLTextureView gLTextureView = new GLTextureView(this.m);
        this.f3395a.removeAllViews();
        this.f3395a.addView(gLTextureView);
        MDVRLibrary.a d2 = MDVRLibrary.d(this.m);
        d2.a(101);
        d2.b(2);
        d2.c(201);
        d2.a(new MDVRLibrary.d() { // from class: com.video.androidsdk.player.view.VrView.2
            @Override // com.render.vrlib.MDVRLibrary.d
            public void onProvideBitmap(a.b bVar) {
                VrView vrView = VrView.this;
                vrView.a(Uri.parse(vrView.f3396b), bVar);
            }
        });
        d2.a(new MDVRLibrary.m() { // from class: com.video.androidsdk.player.view.VrView.1
            @Override // com.render.vrlib.MDVRLibrary.m
            public void onHotspotHit(com.render.vrlib.j.a.a aVar, o oVar) {
                LogEx.d("VrView", "Ray:" + oVar + ", hitHotspot:" + aVar);
            }
        });
        d2.a(true);
        this.l = d2.a(gLTextureView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Uri uri, final a.b bVar) {
        Target target = new Target() { // from class: com.video.androidsdk.player.view.VrView.3
            public void onBitmapFailed(Drawable drawable) {
            }

            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
                LogEx.d("VrView", "loaded image, size:" + bitmap.getWidth() + "," + bitmap.getHeight());
                ((RenderImpl) VrView.this).l.a((float) bitmap.getWidth(), (float) bitmap.getHeight());
                bVar.a(bitmap);
            }

            public void onPrepareLoad(Drawable drawable) {
            }
        };
        LogEx.d("VrView", "load image with max texture size:" + bVar.a());
        Picasso.with(this.m).load(uri).resize(bVar.a(), bVar.a()).onlyScaleDown().centerInside().memoryPolicy(MemoryPolicy.NO_CACHE, new MemoryPolicy[]{MemoryPolicy.NO_STORE}).into(target);
    }
}
