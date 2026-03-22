package com.video.androidsdk.player;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.Util;
import com.video.androidsdk.log.LogEx;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class OfflineLicenseLoader {

    /* renamed from: d, reason: collision with root package name */
    private static OfflineLicenseLoader f3280d;
    private static Object g = OfflineLicenseLoader.class;

    /* renamed from: a, reason: collision with root package name */
    private Context f3281a;

    /* renamed from: b, reason: collision with root package name */
    private ExecutorService f3282b = Executors.newSingleThreadExecutor();

    /* renamed from: c, reason: collision with root package name */
    private SharedPreferences f3283c;
    private String e;
    private String f;

    private OfflineLicenseLoader(Context context) {
        this.f3281a = context.getApplicationContext();
        this.f3283c = this.f3281a.getSharedPreferences("drmfile", 0);
    }

    public static OfflineLicenseLoader getInstance(Context context) {
        OfflineLicenseLoader offlineLicenseLoader;
        synchronized (g) {
            if (f3280d == null) {
                f3280d = new OfflineLicenseLoader(context);
            }
            offlineLicenseLoader = f3280d;
        }
        return offlineLicenseLoader;
    }

    public void downloadAndRestoreLicense(String str, String str2, String str3, ILicenseUrlListener iLicenseUrlListener) {
        LogEx.d("OfflineLicenseLoader", "programId is " + str + " mpdUrl is " + str2);
        this.f3282b.execute(new x(this, str, str2, str3, iLicenseUrlListener));
    }

    public byte[] getOfflineKeySetId(String str) {
        String b2 = b(str, "");
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        return b2.getBytes();
    }

    public boolean releaseLicense(String str) {
        LogEx.d("OfflineLicenseLoader", "key is " + str);
        SharedPreferences sharedPreferences = this.f3283c;
        if (sharedPreferences == null) {
            return false;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.remove(str);
        return edit.commit();
    }

    public void setUserToken(String str, String str2) {
        this.e = str;
        this.f = str2;
    }

    private String b(String str, String str2) {
        LogEx.d("OfflineLicenseLoader", "key is " + str);
        SharedPreferences sharedPreferences = this.f3283c;
        return sharedPreferences != null ? sharedPreferences.getString(str, str2) : str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, String str2) {
        LogEx.d("OfflineLicenseLoader", "key is " + str);
        SharedPreferences sharedPreferences = this.f3283c;
        if (sharedPreferences == null) {
            return false;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(str, str2);
        return edit.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HttpDataSource.Factory a(DefaultBandwidthMeter defaultBandwidthMeter) {
        return new DefaultHttpDataSourceFactory(Util.getUserAgent(this.f3281a.getApplicationContext(), "ExoPlayerSDK"), defaultBandwidthMeter);
    }
}
