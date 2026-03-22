package com.vk.api.sdk;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VKKeyValueStorage.kt */
/* loaded from: classes.dex */
public interface i {

    /* compiled from: VKKeyValueStorage.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public static void a(i iVar, @NotNull String str, @Nullable String str2) {
            kotlin.jvm.internal.f.b(str, "key");
            if (str2 != null) {
                iVar.a(str, str2);
            } else {
                iVar.remove(str);
            }
        }
    }

    @Nullable
    String a(@NotNull String str);

    void a(@NotNull String str, @NotNull String str2);

    void b(@NotNull String str, @Nullable String str2);

    void remove(@NotNull String str);
}
