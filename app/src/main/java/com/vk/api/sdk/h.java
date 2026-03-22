package com.vk.api.sdk;

import android.content.Context;
import com.vk.api.sdk.exceptions.VKApiExecutionException;
import com.vk.api.sdk.g;
import com.vk.api.sdk.ui.VKCaptchaActivity;
import com.vk.api.sdk.ui.VKConfirmationActivity;
import com.vk.api.sdk.ui.VKWebViewAuthActivity;
import org.jetbrains.annotations.NotNull;

/* compiled from: VKDefaultValidationHandler.kt */
/* loaded from: classes.dex */
public class h implements g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Context f3918a;

    public h(@NotNull Context context) {
        kotlin.jvm.internal.f.b(context, "context");
        this.f3918a = context;
    }

    @Override // com.vk.api.sdk.g
    public void a(@NotNull VKApiExecutionException vKApiExecutionException, @NotNull e eVar) throws VKApiExecutionException {
        kotlin.jvm.internal.f.b(vKApiExecutionException, "ex");
        kotlin.jvm.internal.f.b(eVar, "apiManager");
        g.c.a(this, vKApiExecutionException, eVar);
        throw null;
    }

    @Override // com.vk.api.sdk.g
    public void b(@NotNull String str, @NotNull g.a<Boolean> aVar) {
        kotlin.jvm.internal.f.b(str, "confirmationText");
        kotlin.jvm.internal.f.b(aVar, "cb");
        VKConfirmationActivity.f4013b.a(false);
        VKConfirmationActivity.f4013b.a(this.f3918a, str);
        com.vk.api.sdk.r.h.f3998c.a();
        aVar.a(Boolean.valueOf(VKConfirmationActivity.f4013b.a()));
        VKConfirmationActivity.f4013b.a(false);
    }

    @Override // com.vk.api.sdk.g
    public void c(@NotNull String str, @NotNull g.a<String> aVar) {
        kotlin.jvm.internal.f.b(str, "img");
        kotlin.jvm.internal.f.b(aVar, "cb");
        VKCaptchaActivity.e.a(this.f3918a, str);
        com.vk.api.sdk.r.h.f3998c.a();
        a(aVar);
    }

    private final void a(g.a<String> aVar) {
        if (VKCaptchaActivity.e.a() != null) {
            String a2 = VKCaptchaActivity.e.a();
            if (a2 != null) {
                aVar.a(a2);
                return;
            } else {
                kotlin.jvm.internal.f.a();
                throw null;
            }
        }
        aVar.a();
    }

    @Override // com.vk.api.sdk.g
    public void a(@NotNull String str, @NotNull g.a<g.b> aVar) {
        kotlin.jvm.internal.f.b(str, "validationUrl");
        kotlin.jvm.internal.f.b(aVar, "cb");
        VKWebViewAuthActivity.e.a(null);
        VKWebViewAuthActivity.e.a(this.f3918a, str);
        com.vk.api.sdk.r.h.f3998c.a();
        g.b a2 = VKWebViewAuthActivity.e.a();
        if (a2 != null) {
            aVar.a(a2);
        } else {
            aVar.a();
        }
        VKWebViewAuthActivity.e.a(null);
    }
}
