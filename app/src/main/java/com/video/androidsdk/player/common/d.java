package com.video.androidsdk.player.common;

import android.text.TextUtils;
import com.video.androidsdk.log.LogEx;
import java.util.Arrays;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UrlRedirectUtil.java */
/* loaded from: classes.dex */
public class d implements HostnameVerifier {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ UrlRedirectUtil f3367a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(UrlRedirectUtil urlRedirectUtil) {
        this.f3367a = urlRedirectUtil;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        String[] strArr;
        LogEx.d(UrlRedirectUtil.f3351b, "verify hostname  " + str);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        strArr = UrlRedirectUtil.k;
        return !Arrays.asList(strArr).contains(str);
    }
}
