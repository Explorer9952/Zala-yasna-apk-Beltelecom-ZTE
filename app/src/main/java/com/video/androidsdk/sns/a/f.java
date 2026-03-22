package com.video.androidsdk.sns.a;

import com.video.androidsdk.sns.a.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FacebookHelper.java */
/* loaded from: classes.dex */
public /* synthetic */ class f {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f3836a;

    static {
        int[] iArr = new int[b.a.values().length];
        f3836a = iArr;
        try {
            iArr[b.a.POST_PHOTO.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f3836a[b.a.POST_STATUS_UPDATE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
