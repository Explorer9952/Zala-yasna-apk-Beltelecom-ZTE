package com.video.androidsdk.cast;

import com.video.androidsdk.cast.SDKCastMgr;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.ErrMessage;
import com.video.androidsdk.log.LogEx;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SDKCastMgr.java */
/* loaded from: classes.dex */
public class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ SDKCastMgr f3057a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SDKCastMgr sDKCastMgr) {
        this.f3057a = sDKCastMgr;
    }

    @Override // java.lang.Runnable
    public void run() {
        SDKCastMgr.IInitDLNAListener iInitDLNAListener;
        SDKCastMgr.IInitDLNAListener iInitDLNAListener2;
        SDKCastMgr.IInitDLNAListener iInitDLNAListener3;
        SDKCastMgr.IInitDLNAListener iInitDLNAListener4;
        if (!com.video.androidsdk.license.a.f3130b) {
            LogEx.e("SDKCastMgr", ErrMessage.LIC_INVALIDATE);
            return;
        }
        LogEx.d("SDKCastMgr", "DLNA init timeout. Susposed over.");
        if (a.a().a()) {
            iInitDLNAListener3 = this.f3057a.p;
            if (iInitDLNAListener3 != null) {
                iInitDLNAListener4 = this.f3057a.p;
                iInitDLNAListener4.onInitDLNAReturn(Integer.toString(0), "DLNA initlized success!");
            }
            this.f3057a.f3044b = true;
        } else {
            iInitDLNAListener = this.f3057a.p;
            if (iInitDLNAListener != null) {
                iInitDLNAListener2 = this.f3057a.p;
                iInitDLNAListener2.onInitDLNAReturn(Integer.toString(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 1)), "DLNA initlized Failed!");
            }
        }
        this.f3057a.j = false;
    }
}
