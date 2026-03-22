package com.squareup.leakcanary;

/* compiled from: Preconditions.java */
/* loaded from: classes.dex */
final class e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str + " must not be null");
    }
}
