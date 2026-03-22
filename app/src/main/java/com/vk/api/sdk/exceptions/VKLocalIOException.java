package com.vk.api.sdk.exceptions;

import java.io.IOException;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.f;
import org.jetbrains.annotations.NotNull;

/* compiled from: VKLocalIOException.kt */
/* loaded from: classes.dex */
public final class VKLocalIOException extends IOException {
    public static final a Companion = new a(null);
    public static final long serialVersionUID = 3940183432046758205L;

    /* compiled from: VKLocalIOException.kt */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(d dVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VKLocalIOException(@NotNull Throwable th) {
        super(th);
        f.b(th, "throwable");
    }
}
