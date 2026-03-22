package com.vk.api.sdk.internal;

import android.content.Context;
import kotlin.jvm.internal.f;
import org.jetbrains.annotations.Nullable;

/* compiled from: Validation.kt */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f3926a = new e();

    private e() {
    }

    public final void a(@Nullable Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context is null");
        }
    }

    public final void b(@Nullable String str) {
        if (str == null || str.length() == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Illegal host value: ");
            if (str == null) {
                f.a();
                throw null;
            }
            sb.append(str);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public final void a(@Nullable String str) {
        if (str == null) {
            throw new IllegalArgumentException("Illegal accessToken value");
        }
    }
}
