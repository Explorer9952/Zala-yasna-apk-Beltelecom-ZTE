package com.squareup.leakcanary;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class AnalysisResult implements Serializable {
    public final long analysisDurationMs;
    public final String className;
    public final boolean excludedLeak;
    public final Exception failure;
    public final boolean leakFound;
    public final LeakTrace leakTrace;

    private AnalysisResult(boolean z, boolean z2, String str, LeakTrace leakTrace, Exception exc, long j) {
        this.leakFound = z;
        this.excludedLeak = z2;
        this.className = str;
        this.leakTrace = leakTrace;
        this.failure = exc;
        this.analysisDurationMs = j;
    }

    public static AnalysisResult failure(Exception exc, long j) {
        return new AnalysisResult(false, false, null, null, exc, j);
    }

    public static AnalysisResult leakDetected(boolean z, String str, LeakTrace leakTrace, long j) {
        return new AnalysisResult(true, z, str, leakTrace, null, j);
    }

    public static AnalysisResult noLeak(long j) {
        return new AnalysisResult(false, false, null, null, null, j);
    }
}
