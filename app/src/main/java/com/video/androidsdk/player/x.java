package com.video.androidsdk.player;

import android.net.Uri;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.drm.OfflineLicenseHelper;
import com.google.android.exoplayer2.source.dash.DashUtil;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.sina.weibo.sdk.exception.WeiboAuthException;

/* compiled from: OfflineLicenseLoader.java */
/* loaded from: classes.dex */
class x implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    String f3411a;

    /* renamed from: b, reason: collision with root package name */
    String f3412b;

    /* renamed from: c, reason: collision with root package name */
    String f3413c;

    /* renamed from: d, reason: collision with root package name */
    ILicenseUrlListener f3414d;
    final /* synthetic */ String e;
    final /* synthetic */ String f;
    final /* synthetic */ String g;
    final /* synthetic */ ILicenseUrlListener h;
    final /* synthetic */ OfflineLicenseLoader i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(OfflineLicenseLoader offlineLicenseLoader, String str, String str2, String str3, ILicenseUrlListener iLicenseUrlListener) {
        this.i = offlineLicenseLoader;
        this.e = str;
        this.f = str2;
        this.g = str3;
        this.h = iLicenseUrlListener;
        this.f3411a = this.e;
        this.f3412b = this.f;
        this.f3413c = this.g;
        this.f3414d = this.h;
    }

    @Override // java.lang.Runnable
    public void run() {
        HttpDataSource.Factory a2;
        String str;
        String str2;
        boolean a3;
        a2 = this.i.a((DefaultBandwidthMeter) null);
        try {
            HttpDataSource createDataSource = a2.createDataSource();
            OfflineLicenseHelper<FrameworkMediaCrypto> newWidevineInstance = OfflineLicenseHelper.newWidevineInstance(this.f3413c, false, a2, null);
            str = this.i.e;
            str2 = this.i.f;
            newWidevineInstance.refreshUserToken(str, str2);
            DashManifest loadManifest = DashUtil.loadManifest(createDataSource, Uri.parse(this.f3412b));
            if (loadManifest == null) {
                if (this.f3414d != null) {
                    this.f3414d.onLicenseUrlLoaded(WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, "load mpd file failed ", null);
                    return;
                }
                return;
            }
            DrmInitData loadDrmInitData = DashUtil.loadDrmInitData(createDataSource, loadManifest.getPeriod(0));
            if (loadDrmInitData == null) {
                if (this.f3414d != null) {
                    this.f3414d.onLicenseUrlLoaded(WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, "load drmInitData failed ", null);
                    return;
                }
                return;
            }
            byte[] downloadLicense = newWidevineInstance.downloadLicense(loadDrmInitData);
            if (downloadLicense != null) {
                a3 = this.i.a(this.f3411a, new String(downloadLicense));
                if (!a3) {
                    if (this.f3414d != null) {
                        this.f3414d.onLicenseUrlLoaded(WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, "write data to cache failed", downloadLicense);
                        return;
                    }
                    return;
                }
            }
            if (this.f3414d != null) {
                this.f3414d.onLicenseUrlLoaded("0", "success", downloadLicense);
            }
        } catch (Exception e) {
            this.h.onLicenseUrlLoaded(WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, e.getMessage(), null);
            e.printStackTrace();
        }
    }
}
