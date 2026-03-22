package com.vk.api.sdk.p;

import android.support.v4.media.session.PlaybackStateCompat;
import com.vk.api.sdk.utils.log.Logger;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.reflect.j;
import kotlin.text.Regex;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.t;
import okhttp3.y;
import okhttp3.z;
import org.jetbrains.annotations.NotNull;

/* compiled from: LoggingInterceptor.kt */
/* loaded from: classes.dex */
public final class a implements t {

    /* renamed from: d, reason: collision with root package name */
    static final /* synthetic */ j[] f3962d;

    /* renamed from: a, reason: collision with root package name */
    private final com.vk.api.sdk.r.c f3963a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f3964b;

    /* renamed from: c, reason: collision with root package name */
    private final Logger f3965c;

    /* compiled from: LoggingInterceptor.kt */
    /* renamed from: com.vk.api.sdk.p.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0101a {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        private static final b.b.a<Logger.LogLevel, HttpLoggingInterceptor.Level> f3966a;

        /* renamed from: b, reason: collision with root package name */
        public static final C0101a f3967b = new C0101a();

        static {
            b.b.a<Logger.LogLevel, HttpLoggingInterceptor.Level> aVar = new b.b.a<>();
            f3966a = aVar;
            aVar.put(Logger.LogLevel.NONE, HttpLoggingInterceptor.Level.NONE);
            f3966a.put(Logger.LogLevel.ERROR, HttpLoggingInterceptor.Level.NONE);
            f3966a.put(Logger.LogLevel.WARNING, HttpLoggingInterceptor.Level.BASIC);
            f3966a.put(Logger.LogLevel.DEBUG, HttpLoggingInterceptor.Level.HEADERS);
            f3966a.put(Logger.LogLevel.VERBOSE, HttpLoggingInterceptor.Level.BODY);
        }

        private C0101a() {
        }

        @NotNull
        public final b.b.a<Logger.LogLevel, HttpLoggingInterceptor.Level> a() {
            return f3966a;
        }
    }

    /* compiled from: LoggingInterceptor.kt */
    /* loaded from: classes.dex */
    static final class b extends Lambda implements kotlin.jvm.b.a<HttpLoggingInterceptor> {

        /* compiled from: LoggingInterceptor.kt */
        /* renamed from: com.vk.api.sdk.p.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0102a implements HttpLoggingInterceptor.a {
            C0102a() {
            }

            private final String b(String str) {
                return new Regex("client_secret=[a-zA-Z0-9]+").replace(new Regex("key=[a-z0-9]+").replace(new Regex("access_token=[a-z0-9]+").replace(str, "access_token=<HIDE>"), "key=<HIDE>"), "client_secret=<HIDE>");
            }

            @Override // okhttp3.logging.HttpLoggingInterceptor.a
            public void a(@NotNull String str) {
                f.b(str, "message");
                if (a.this.f3964b) {
                    str = b(str);
                }
                Logger.a.a(a.this.f3965c, a.this.f3965c.a().getValue(), str, null, 4, null);
            }
        }

        b() {
            super(0);
        }

        @Override // kotlin.jvm.b.a
        @NotNull
        public final HttpLoggingInterceptor invoke() {
            return new HttpLoggingInterceptor(new C0102a());
        }
    }

    static {
        PropertyReference1Impl propertyReference1Impl = new PropertyReference1Impl(h.a(a.class), "delegate", "getDelegate()Lokhttp3/logging/HttpLoggingInterceptor;");
        h.a(propertyReference1Impl);
        f3962d = new j[]{propertyReference1Impl};
    }

    public a(boolean z, @NotNull Logger logger) {
        f.b(logger, "logger");
        this.f3964b = z;
        this.f3965c = logger;
        this.f3963a = com.vk.api.sdk.r.e.a(new b());
    }

    private final HttpLoggingInterceptor a() {
        return (HttpLoggingInterceptor) com.vk.api.sdk.r.e.a(this.f3963a, this, f3962d[0]);
    }

    @Override // okhttp3.t
    @NotNull
    public z a(@NotNull t.a aVar) {
        f.b(aVar, "chain");
        y a2 = aVar.e().a();
        a().a((a2 != null ? a2.a() : 0L) > PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID ? HttpLoggingInterceptor.Level.BASIC : C0101a.f3967b.a().get(this.f3965c.a().getValue()));
        z a3 = a().a(aVar);
        f.a((Object) a3, "delegate.intercept(chain)");
        return a3;
    }
}
