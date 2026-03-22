package com.bumptech.glide.load.h;

import android.content.Context;
import android.net.Uri;
import com.video.androidsdk.common.http.HttpConstant;
import com.video.androidsdk.service.comm.ParamConst;

/* compiled from: UriLoader.java */
/* loaded from: classes.dex */
public abstract class q<T> implements l<Uri, T> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f2104a;

    /* renamed from: b, reason: collision with root package name */
    private final l<d, T> f2105b;

    public q(Context context, l<d, T> lVar) {
        this.f2104a = context;
        this.f2105b = lVar;
    }

    protected abstract com.bumptech.glide.load.g.c<T> a(Context context, Uri uri);

    protected abstract com.bumptech.glide.load.g.c<T> a(Context context, String str);

    @Override // com.bumptech.glide.load.h.l
    public final com.bumptech.glide.load.g.c<T> a(Uri uri, int i, int i2) {
        String scheme = uri.getScheme();
        if (a(scheme)) {
            if (a.a(uri)) {
                return a(this.f2104a, a.b(uri));
            }
            return a(this.f2104a, uri);
        }
        if (this.f2105b == null || !(HttpConstant.PROTOCOL_HTTP.equals(scheme) || HttpConstant.PROTOCOL_HTTPS.equals(scheme))) {
            return null;
        }
        return this.f2105b.a(new d(uri.toString()), i, i2);
    }

    private static boolean a(String str) {
        return ParamConst.CHANNEL_PREVUE_INFO_RSP_FILENAME.equals(str) || "content".equals(str) || "android.resource".equals(str);
    }
}
