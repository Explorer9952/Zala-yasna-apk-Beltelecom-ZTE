package com.vk.api.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.vk.api.sdk.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VKPreferencesKeyValueStorage.kt */
/* loaded from: classes.dex */
public final class l implements i {

    /* renamed from: a, reason: collision with root package name */
    private final SharedPreferences f3936a;

    /* compiled from: VKPreferencesKeyValueStorage.kt */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.d dVar) {
            this();
        }
    }

    static {
        new a(null);
    }

    public l(@NotNull Context context, @NotNull String str) {
        kotlin.jvm.internal.f.b(context, "context");
        kotlin.jvm.internal.f.b(str, "prefsName");
        this.f3936a = context.getSharedPreferences(str, 0);
    }

    @Override // com.vk.api.sdk.i
    public void a(@NotNull String str, @NotNull String str2) {
        kotlin.jvm.internal.f.b(str, "key");
        kotlin.jvm.internal.f.b(str2, "value");
        this.f3936a.edit().putString(str, str2).apply();
    }

    @Override // com.vk.api.sdk.i
    public void b(@NotNull String str, @Nullable String str2) {
        kotlin.jvm.internal.f.b(str, "key");
        i.a.a(this, str, str2);
    }

    @Override // com.vk.api.sdk.i
    public void remove(@NotNull String str) {
        kotlin.jvm.internal.f.b(str, "key");
        this.f3936a.edit().remove(str).apply();
    }

    @Override // com.vk.api.sdk.i
    @Nullable
    public String a(@NotNull String str) {
        kotlin.jvm.internal.f.b(str, "key");
        return this.f3936a.getString(str, null);
    }

    public /* synthetic */ l(Context context, String str, int i, kotlin.jvm.internal.d dVar) {
        this(context, (i & 2) != 0 ? "com.vkontakte.android_pref_name" : str);
    }
}
