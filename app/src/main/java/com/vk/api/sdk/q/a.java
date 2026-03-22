package com.vk.api.sdk.q;

import kotlin.jvm.internal.f;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: VKBooleanRequest.kt */
/* loaded from: classes.dex */
public class a extends b<Boolean> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull String str) {
        super(str);
        f.b(str, "method");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.vk.api.sdk.q.b
    @NotNull
    public Boolean a(@NotNull JSONObject jSONObject) {
        f.b(jSONObject, "r");
        return true;
    }
}
