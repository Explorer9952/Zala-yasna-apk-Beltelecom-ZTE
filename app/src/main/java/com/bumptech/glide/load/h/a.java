package com.bumptech.glide.load.h;

import android.net.Uri;
import com.video.androidsdk.service.comm.ParamConst;

/* compiled from: AssetUriParser.java */
/* loaded from: classes.dex */
final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final int f2069a = 22;

    public static boolean a(Uri uri) {
        return ParamConst.CHANNEL_PREVUE_INFO_RSP_FILENAME.equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }

    public static String b(Uri uri) {
        return uri.toString().substring(f2069a);
    }
}
