package com.vk.api.sdk.q;

import com.vk.api.sdk.c;
import com.vk.api.sdk.e;
import com.vk.api.sdk.exceptions.VKApiException;
import com.vk.api.sdk.exceptions.VKApiExecutionException;
import com.vk.api.sdk.f;
import com.vk.api.sdk.j;
import java.io.IOException;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.d;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: VKRequest.kt */
/* loaded from: classes.dex */
public class b<T> extends com.vk.api.sdk.internal.a<T> implements f<T> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final LinkedHashMap<String, String> f3985a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private String f3986b;

    /* compiled from: VKRequest.kt */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(d dVar) {
            this();
        }
    }

    static {
        new a(null);
    }

    public b(@NotNull String str) {
        kotlin.jvm.internal.f.b(str, "method");
        this.f3986b = str;
        this.f3985a = new LinkedHashMap<>();
    }

    @Override // com.vk.api.sdk.f
    public T a(@NotNull String str) throws VKApiException {
        kotlin.jvm.internal.f.b(str, "response");
        try {
            return a(new JSONObject(str));
        } catch (Throwable th) {
            throw new VKApiExecutionException(-2, this.f3986b, true, '[' + this.f3986b + "] " + th.getLocalizedMessage(), null, null, null, 112, null);
        }
    }

    public T a(@NotNull JSONObject jSONObject) throws Exception {
        throw null;
    }

    @Override // com.vk.api.sdk.internal.a
    protected T b(@NotNull e eVar) throws InterruptedException, IOException, VKApiException {
        kotlin.jvm.internal.f.b(eVar, "manager");
        c a2 = eVar.a();
        this.f3985a.put("lang", a2.h());
        this.f3985a.put("device_id", a2.e().getValue());
        this.f3985a.put("v", a2.n());
        j.a a3 = a(a2);
        a3.a(this.f3985a);
        a3.a(this.f3986b);
        a3.b(a2.n());
        return (T) eVar.b(a3.a(), this);
    }

    @NotNull
    protected j.a a(@NotNull c cVar) {
        kotlin.jvm.internal.f.b(cVar, "config");
        return new j.a();
    }
}
