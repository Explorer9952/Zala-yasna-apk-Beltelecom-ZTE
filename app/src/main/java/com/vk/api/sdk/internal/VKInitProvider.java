package com.vk.api.sdk.internal;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import kotlin.jvm.internal.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VKInitProvider.kt */
/* loaded from: classes.dex */
public final class VKInitProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public int delete(@NotNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        f.b(uri, ShareConstants.MEDIA_URI);
        return 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NotNull Uri uri) {
        f.b(uri, ShareConstants.MEDIA_URI);
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NotNull Uri uri, @Nullable ContentValues contentValues) {
        f.b(uri, ShareConstants.MEDIA_URI);
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        try {
            Context context = getContext();
            if (context == null) {
                f.a();
                throw null;
            }
            f.a((Object) context, "context!!");
            com.vk.api.sdk.a.b(context);
            return false;
        } catch (Exception e) {
            Log.e(VKInitProvider.class.getSimpleName(), "Failed to initialize the VK SDK", e);
            return false;
        }
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NotNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        f.b(uri, ShareConstants.MEDIA_URI);
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(@NotNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        f.b(uri, ShareConstants.MEDIA_URI);
        return 0;
    }
}
