package io.reactivex.parallel;

import io.reactivex.k.c;

/* loaded from: classes2.dex */
public enum ParallelFailureHandling implements c<Long, Throwable, ParallelFailureHandling> {
    STOP,
    ERROR,
    SKIP,
    RETRY;

    @Override // io.reactivex.k.c
    public ParallelFailureHandling apply(Long l, Throwable th) {
        return this;
    }
}
