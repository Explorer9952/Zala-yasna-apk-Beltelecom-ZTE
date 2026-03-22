package com.vk.api.sdk.exceptions;

import kotlin.jvm.internal.d;
import kotlin.jvm.internal.f;
import org.jetbrains.annotations.NotNull;

/* compiled from: VKApiException.kt */
/* loaded from: classes.dex */
public class VKApiException extends Exception {
    public static final a Companion = new a(null);
    public static final long serialVersionUID = 1221900559703281428L;

    /* compiled from: VKApiException.kt */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(d dVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VKApiException(@NotNull String str) {
        super(str);
        f.b(str, "detailMessage");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VKApiException(@NotNull String str, @NotNull Throwable th) {
        super(str, th);
        f.b(str, "detailMessage");
        f.b(th, "throwable");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VKApiException(@NotNull Throwable th) {
        super(th);
        f.b(th, "throwable");
    }
}
