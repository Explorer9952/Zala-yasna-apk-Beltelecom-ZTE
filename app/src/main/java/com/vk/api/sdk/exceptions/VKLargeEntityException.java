package com.vk.api.sdk.exceptions;

import kotlin.jvm.internal.f;
import org.jetbrains.annotations.NotNull;

/* compiled from: VKLargeEntityException.kt */
/* loaded from: classes.dex */
public class VKLargeEntityException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VKLargeEntityException(@NotNull String str) {
        super(str);
        f.b(str, "detailMessage");
    }
}
