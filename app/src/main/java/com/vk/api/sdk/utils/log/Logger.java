package com.vk.api.sdk.utils.log;

import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Logger.kt */
/* loaded from: classes.dex */
public interface Logger {

    /* compiled from: Logger.kt */
    /* loaded from: classes.dex */
    public enum LogLevel {
        VERBOSE,
        DEBUG,
        WARNING,
        ERROR,
        NONE
    }

    /* compiled from: Logger.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public static /* synthetic */ void a(Logger logger, LogLevel logLevel, String str, Throwable th, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str = null;
                }
                if ((i & 4) != 0) {
                    th = null;
                }
                logger.a(logLevel, str, th);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
        }
    }

    @NotNull
    d<LogLevel> a();

    void a(@NotNull LogLevel logLevel, @Nullable String str, @Nullable Throwable th);
}
