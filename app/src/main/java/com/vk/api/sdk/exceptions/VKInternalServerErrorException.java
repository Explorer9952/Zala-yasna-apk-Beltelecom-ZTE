package com.vk.api.sdk.exceptions;

import kotlin.jvm.internal.f;
import org.jetbrains.annotations.NotNull;

/* compiled from: VKInternalServerErrorException.kt */
/* loaded from: classes.dex */
public class VKInternalServerErrorException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VKInternalServerErrorException(int i, @NotNull String str) {
        super("Server returned httpStatusCode=" + i + " with body: " + str);
        f.b(str, "detailMessage");
    }
}
