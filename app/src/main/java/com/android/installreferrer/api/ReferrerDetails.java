package com.android.installreferrer.api;

import android.os.Bundle;

/* loaded from: classes.dex */
public class ReferrerDetails {

    /* renamed from: a, reason: collision with root package name */
    private final Bundle f1882a;

    public ReferrerDetails(Bundle bundle) {
        this.f1882a = bundle;
    }

    public String a() {
        return this.f1882a.getString("install_referrer");
    }
}
