package com.vk.api.sdk.utils.log;

import android.util.Log;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.vk.api.sdk.utils.log.Logger;
import kotlin.d;
import kotlin.jvm.internal.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DefaultApiLogger.kt */
/* loaded from: classes.dex */
public class b implements Logger {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private d<? extends Logger.LogLevel> f4028a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f4029b;

    public b(@NotNull d<? extends Logger.LogLevel> dVar, @NotNull String str) {
        f.b(dVar, "logLevel");
        f.b(str, ViewHierarchyConstants.TAG_KEY);
        this.f4028a = dVar;
        this.f4029b = str;
    }

    @Override // com.vk.api.sdk.utils.log.Logger
    @NotNull
    public d<Logger.LogLevel> a() {
        return this.f4028a;
    }

    @NotNull
    public String b() {
        return this.f4029b;
    }

    @Override // com.vk.api.sdk.utils.log.Logger
    public void a(@NotNull Logger.LogLevel logLevel, @Nullable String str, @Nullable Throwable th) {
        f.b(logLevel, "level");
        if (a(logLevel)) {
            return;
        }
        int i = a.f4027a[logLevel.ordinal()];
        if (i == 2) {
            Log.v(b(), str, th);
            return;
        }
        if (i == 3) {
            Log.d(b(), str, th);
        } else if (i == 4) {
            Log.w(b(), str, th);
        } else {
            if (i != 5) {
                return;
            }
            Log.e(b(), str, th);
        }
    }

    private final boolean a(Logger.LogLevel logLevel) {
        return a().getValue().ordinal() > logLevel.ordinal();
    }
}
