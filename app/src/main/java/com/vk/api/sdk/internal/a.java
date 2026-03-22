package com.vk.api.sdk.internal;

import com.vk.api.sdk.exceptions.VKApiException;
import java.io.IOException;
import kotlin.jvm.internal.f;
import org.jetbrains.annotations.NotNull;

/* compiled from: ApiCommand.kt */
/* loaded from: classes.dex */
public abstract class a<Response> {
    public final Response a(@NotNull com.vk.api.sdk.e eVar) throws InterruptedException, IOException, VKApiException {
        f.b(eVar, "manager");
        return b(eVar);
    }

    protected abstract Response b(@NotNull com.vk.api.sdk.e eVar) throws InterruptedException, IOException, VKApiException;
}
