package com.android.installreferrer.api;

import android.content.Context;
import android.os.RemoteException;

/* loaded from: classes.dex */
public abstract class InstallReferrerClient {

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final Context f1881a;

        public InstallReferrerClient a() {
            Context context = this.f1881a;
            if (context != null) {
                return new com.android.installreferrer.api.a(context);
            }
            throw new IllegalArgumentException("Please provide a valid Context.");
        }

        private b(Context context) {
            this.f1881a = context;
        }
    }

    public static b a(Context context) {
        return new b(context);
    }

    public abstract ReferrerDetails a() throws RemoteException;

    public abstract void a(InstallReferrerStateListener installReferrerStateListener);
}
