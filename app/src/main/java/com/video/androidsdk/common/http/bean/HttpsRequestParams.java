package com.video.androidsdk.common.http.bean;

import com.video.androidsdk.common.http.DataAttribute;
import com.video.androidsdk.common.http.download.IHttpDownloadListener;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

/* loaded from: classes.dex */
public class HttpsRequestParams extends HttpRequestParams {
    private static final String LOG_TAG = "HttpsRequestParams";
    HostnameVerifier hostVerifier;
    Logger mLogger;
    SSLContext sslContext;

    public HttpsRequestParams(DataAttribute dataAttribute, HttpRequest httpRequest) {
        super(dataAttribute, httpRequest, null);
        this.mLogger = Logger.getLogger(LOG_TAG);
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x008e: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:40:0x008e */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.security.KeyStore getKeyStore(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            r0 = 0
            java.lang.String r1 = "JKS"
            java.security.KeyStore r1 = java.security.KeyStore.getInstance(r1)     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L29 java.security.cert.CertificateException -> L3c java.security.NoSuchAlgorithmException -> L4f java.io.FileNotFoundException -> L62 java.security.KeyStoreException -> L75
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L29 java.security.cert.CertificateException -> L3c java.security.NoSuchAlgorithmException -> L4f java.io.FileNotFoundException -> L62 java.security.KeyStoreException -> L75
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L29 java.security.cert.CertificateException -> L3c java.security.NoSuchAlgorithmException -> L4f java.io.FileNotFoundException -> L62 java.security.KeyStoreException -> L75
            char[] r4 = r4.toCharArray()     // Catch: java.io.IOException -> L1c java.security.cert.CertificateException -> L1e java.security.NoSuchAlgorithmException -> L20 java.io.FileNotFoundException -> L22 java.security.KeyStoreException -> L24 java.lang.Throwable -> L8d
            r1.load(r2, r4)     // Catch: java.io.IOException -> L1c java.security.cert.CertificateException -> L1e java.security.NoSuchAlgorithmException -> L20 java.io.FileNotFoundException -> L22 java.security.KeyStoreException -> L24 java.lang.Throwable -> L8d
            r2.close()     // Catch: java.io.IOException -> L17
            goto L1b
        L17:
            r4 = move-exception
            r4.printStackTrace()
        L1b:
            return r1
        L1c:
            r4 = move-exception
            goto L2b
        L1e:
            r4 = move-exception
            goto L3e
        L20:
            r4 = move-exception
            goto L51
        L22:
            r4 = move-exception
            goto L64
        L24:
            r4 = move-exception
            goto L77
        L26:
            r4 = move-exception
            goto L8f
        L29:
            r4 = move-exception
            r2 = r0
        L2b:
            java.util.logging.Logger r5 = r3.mLogger     // Catch: java.lang.Throwable -> L8d
            java.util.logging.Level r1 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L8d
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L8d
            r5.log(r1, r4)     // Catch: java.lang.Throwable -> L8d
            if (r2 == 0) goto L8c
            r2.close()     // Catch: java.io.IOException -> L88
            goto L8c
        L3c:
            r4 = move-exception
            r2 = r0
        L3e:
            java.util.logging.Logger r5 = r3.mLogger     // Catch: java.lang.Throwable -> L8d
            java.util.logging.Level r1 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L8d
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L8d
            r5.log(r1, r4)     // Catch: java.lang.Throwable -> L8d
            if (r2 == 0) goto L8c
            r2.close()     // Catch: java.io.IOException -> L88
            goto L8c
        L4f:
            r4 = move-exception
            r2 = r0
        L51:
            java.util.logging.Logger r5 = r3.mLogger     // Catch: java.lang.Throwable -> L8d
            java.util.logging.Level r1 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L8d
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L8d
            r5.log(r1, r4)     // Catch: java.lang.Throwable -> L8d
            if (r2 == 0) goto L8c
            r2.close()     // Catch: java.io.IOException -> L88
            goto L8c
        L62:
            r4 = move-exception
            r2 = r0
        L64:
            java.util.logging.Logger r5 = r3.mLogger     // Catch: java.lang.Throwable -> L8d
            java.util.logging.Level r1 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L8d
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L8d
            r5.log(r1, r4)     // Catch: java.lang.Throwable -> L8d
            if (r2 == 0) goto L8c
            r2.close()     // Catch: java.io.IOException -> L88
            goto L8c
        L75:
            r4 = move-exception
            r2 = r0
        L77:
            java.util.logging.Logger r5 = r3.mLogger     // Catch: java.lang.Throwable -> L8d
            java.util.logging.Level r1 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L8d
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L8d
            r5.log(r1, r4)     // Catch: java.lang.Throwable -> L8d
            if (r2 == 0) goto L8c
            r2.close()     // Catch: java.io.IOException -> L88
            goto L8c
        L88:
            r4 = move-exception
            r4.printStackTrace()
        L8c:
            return r0
        L8d:
            r4 = move-exception
            r0 = r2
        L8f:
            if (r0 == 0) goto L99
            r0.close()     // Catch: java.io.IOException -> L95
            goto L99
        L95:
            r5 = move-exception
            r5.printStackTrace()
        L99:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.video.androidsdk.common.http.bean.HttpsRequestParams.getKeyStore(java.lang.String, java.lang.String):java.security.KeyStore");
    }

    public SSLContext genSSLContext(String str, String str2, String str3) {
        try {
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(getKeyStore(str, str2), str.toCharArray());
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(getKeyStore(str, str3));
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);
            this.sslContext = sSLContext;
            return sSLContext;
        } catch (KeyManagementException e) {
            this.mLogger.log(Level.SEVERE, e.toString());
            return null;
        } catch (KeyStoreException e2) {
            this.mLogger.log(Level.SEVERE, e2.toString());
            return null;
        } catch (NoSuchAlgorithmException e3) {
            this.mLogger.log(Level.SEVERE, e3.toString());
            return null;
        } catch (UnrecoverableKeyException e4) {
            this.mLogger.log(Level.SEVERE, e4.toString());
            return null;
        }
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.hostVerifier;
    }

    public SSLContext getSSLContext() {
        return this.sslContext;
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.hostVerifier = hostnameVerifier;
    }

    public void setSSLContext(SSLContext sSLContext) {
        this.sslContext = sSLContext;
    }

    public HttpsRequestParams(DataAttribute dataAttribute, HttpRequest httpRequest, IHttpDownloadListener iHttpDownloadListener) {
        super(dataAttribute, httpRequest, iHttpDownloadListener);
        this.mLogger = Logger.getLogger(LOG_TAG);
    }

    public HttpsRequestParams(DataAttribute dataAttribute, HttpAttribute httpAttribute, HttpRequest httpRequest, IHttpDownloadListener iHttpDownloadListener) {
        super(dataAttribute, httpAttribute, httpRequest, iHttpDownloadListener);
        this.mLogger = Logger.getLogger(LOG_TAG);
    }
}
