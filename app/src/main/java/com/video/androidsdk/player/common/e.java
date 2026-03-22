package com.video.androidsdk.player.common;

import com.video.androidsdk.log.LogEx;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UrlRedirectUtil.java */
/* loaded from: classes.dex */
public class e implements X509TrustManager {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ UrlRedirectUtil f3368a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(UrlRedirectUtil urlRedirectUtil) {
        this.f3368a = urlRedirectUtil;
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        LogEx.d("trustAllHosts", "checkClientTrusted");
        try {
            x509CertificateArr[0].checkValidity();
        } catch (Exception unused) {
            throw new CertificateException("Certificate not valid or trusted.");
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        LogEx.d("trustAllHosts", "checkServerTrusted");
        try {
            x509CertificateArr[0].checkValidity();
        } catch (Exception unused) {
            throw new CertificateException("Certificate not valid or trusted.");
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}
