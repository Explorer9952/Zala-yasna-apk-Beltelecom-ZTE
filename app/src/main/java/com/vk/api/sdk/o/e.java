package com.vk.api.sdk.o;

import com.video.androidsdk.service.comm.ParamConst;
import com.vk.api.sdk.exceptions.VKApiException;
import com.vk.api.sdk.p.d;
import kotlin.TypeCastException;
import kotlin.text.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MethodChainCall.kt */
/* loaded from: classes.dex */
public class e<T> extends b<T> {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final com.vk.api.sdk.p.b f3951b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private final d.a f3952c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private String f3953d;

    @NotNull
    private final String e;

    @Nullable
    private final com.vk.api.sdk.f<T> f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull com.vk.api.sdk.e eVar, @NotNull com.vk.api.sdk.p.b bVar, @NotNull d.a aVar, @NotNull String str, @NotNull String str2, @Nullable com.vk.api.sdk.f<T> fVar) {
        super(eVar);
        kotlin.jvm.internal.f.b(eVar, "manager");
        kotlin.jvm.internal.f.b(bVar, "okHttpExecutor");
        kotlin.jvm.internal.f.b(aVar, "callBuilder");
        kotlin.jvm.internal.f.b(str, "defaultDeviceId");
        kotlin.jvm.internal.f.b(str2, "defaultLang");
        this.f3951b = bVar;
        this.f3952c = aVar;
        this.f3953d = str;
        this.e = str2;
        this.f = fVar;
    }

    @Override // com.vk.api.sdk.o.b
    @Nullable
    public T a(@NotNull a aVar) throws Exception {
        boolean a2;
        boolean a3;
        kotlin.jvm.internal.f.b(aVar, "args");
        if (aVar.d()) {
            d.a aVar2 = this.f3952c;
            aVar2.a("captcha_sid", aVar.b());
            aVar2.a("captcha_key", aVar.a());
        }
        if (aVar.c()) {
            this.f3952c.a(ParamConst.NPVR_ADD_REQ_CONFIRM, "1");
        }
        String a4 = this.f3952c.a("device_id");
        if (a4 == null) {
            a4 = "";
        }
        a2 = u.a(a4);
        if (a2) {
            a4 = this.f3953d;
        }
        d.a aVar3 = this.f3952c;
        if (a4 != null) {
            String lowerCase = a4.toLowerCase();
            kotlin.jvm.internal.f.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
            aVar3.a("device_id", lowerCase);
            String a5 = this.f3952c.a("lang");
            String str = a5 != null ? a5 : "";
            a3 = u.a(str);
            if (a3) {
                str = this.e;
            }
            d.a aVar4 = this.f3952c;
            if (str != null) {
                String lowerCase2 = str.toLowerCase();
                kotlin.jvm.internal.f.a((Object) lowerCase2, "(this as java.lang.String).toLowerCase()");
                aVar4.a("lang", lowerCase2);
                return a(this.f3952c.a());
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @Nullable
    public T a(@NotNull com.vk.api.sdk.p.d dVar) {
        kotlin.jvm.internal.f.b(dVar, "mc");
        return a(this.f3951b.a(dVar), dVar.b(), null);
    }

    @Nullable
    public final T a(@Nullable String str, @NotNull String str2, @Nullable int[] iArr) {
        kotlin.jvm.internal.f.b(str2, "methodName");
        if (str != null) {
            if (!com.vk.api.sdk.r.a.a(str)) {
                if (!com.vk.api.sdk.r.a.a(str, iArr)) {
                    com.vk.api.sdk.f<T> fVar = this.f;
                    if (fVar != null) {
                        return fVar.a(str);
                    }
                    return null;
                }
                throw com.vk.api.sdk.r.a.a(str, str2, iArr);
            }
            throw com.vk.api.sdk.r.a.a(str, str2);
        }
        throw new VKApiException("Response returned null instead of valid string response");
    }
}
