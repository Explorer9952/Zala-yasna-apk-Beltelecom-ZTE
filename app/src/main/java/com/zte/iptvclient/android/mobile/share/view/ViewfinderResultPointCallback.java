package com.zte.iptvclient.android.mobile.share.view;

import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;

/* loaded from: classes2.dex */
public final class ViewfinderResultPointCallback implements ResultPointCallback {

    /* renamed from: a, reason: collision with root package name */
    private final ViewfinderView f7222a;

    public ViewfinderResultPointCallback(ViewfinderView viewfinderView) {
        this.f7222a = viewfinderView;
    }

    @Override // com.google.zxing.ResultPointCallback
    public void foundPossibleResultPoint(ResultPoint resultPoint) {
        this.f7222a.a(resultPoint);
    }
}
