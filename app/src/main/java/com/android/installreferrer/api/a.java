package com.android.installreferrer.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.finsky.externalreferrer.IGetInstallReferrerService;
import com.zte.ucs.tvcall.Commons;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InstallReferrerClientImpl.java */
/* loaded from: classes.dex */
public class a extends InstallReferrerClient {

    /* renamed from: a, reason: collision with root package name */
    private int f1883a = 0;

    /* renamed from: b, reason: collision with root package name */
    private final Context f1884b;

    /* renamed from: c, reason: collision with root package name */
    private IGetInstallReferrerService f1885c;

    /* renamed from: d, reason: collision with root package name */
    private ServiceConnection f1886d;

    /* compiled from: InstallReferrerClientImpl.java */
    /* loaded from: classes.dex */
    private final class b implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        private final InstallReferrerStateListener f1887a;

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.a.a.a.a.a("InstallReferrerClient", "Install Referrer service connected.");
            a.this.f1885c = IGetInstallReferrerService.Stub.asInterface(iBinder);
            a.this.f1883a = 2;
            this.f1887a.onInstallReferrerSetupFinished(0);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            d.a.a.a.a.b("InstallReferrerClient", "Install Referrer service disconnected.");
            a.this.f1885c = null;
            a.this.f1883a = 0;
            this.f1887a.onInstallReferrerServiceDisconnected();
        }

        private b(InstallReferrerStateListener installReferrerStateListener) {
            if (installReferrerStateListener != null) {
                this.f1887a = installReferrerStateListener;
                return;
            }
            throw new RuntimeException("Please specify a listener to know when setup is done.");
        }
    }

    public a(Context context) {
        this.f1884b = context.getApplicationContext();
    }

    private boolean c() {
        try {
            return this.f1884b.getPackageManager().getPackageInfo("com.android.vending", Commons.MSG_MCSP_INIT_SUCCESS).versionCode >= 80837300;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public boolean b() {
        return (this.f1883a != 2 || this.f1885c == null || this.f1886d == null) ? false : true;
    }

    @Override // com.android.installreferrer.api.InstallReferrerClient
    public void a(InstallReferrerStateListener installReferrerStateListener) {
        ServiceInfo serviceInfo;
        if (b()) {
            d.a.a.a.a.a("InstallReferrerClient", "Service connection is valid. No need to re-initialize.");
            installReferrerStateListener.onInstallReferrerSetupFinished(0);
            return;
        }
        int i = this.f1883a;
        if (i == 1) {
            d.a.a.a.a.b("InstallReferrerClient", "Client is already in the process of connecting to the service.");
            installReferrerStateListener.onInstallReferrerSetupFinished(3);
            return;
        }
        if (i == 3) {
            d.a.a.a.a.b("InstallReferrerClient", "Client was already closed and can't be reused. Please create another instance.");
            installReferrerStateListener.onInstallReferrerSetupFinished(3);
            return;
        }
        d.a.a.a.a.a("InstallReferrerClient", "Starting install referrer service setup.");
        this.f1886d = new b(installReferrerStateListener);
        Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
        intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
        List<ResolveInfo> queryIntentServices = this.f1884b.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices != null && !queryIntentServices.isEmpty() && (serviceInfo = queryIntentServices.get(0).serviceInfo) != null) {
            String str = serviceInfo.packageName;
            String str2 = serviceInfo.name;
            if ("com.android.vending".equals(str) && str2 != null && c()) {
                if (this.f1884b.bindService(new Intent(intent), this.f1886d, 1)) {
                    d.a.a.a.a.a("InstallReferrerClient", "Service was bonded successfully.");
                    return;
                }
                d.a.a.a.a.b("InstallReferrerClient", "Connection to service is blocked.");
                this.f1883a = 0;
                installReferrerStateListener.onInstallReferrerSetupFinished(1);
                return;
            }
            d.a.a.a.a.b("InstallReferrerClient", "Play Store missing or incompatible. Version 8.3.73 or later required.");
            this.f1883a = 0;
            installReferrerStateListener.onInstallReferrerSetupFinished(2);
            return;
        }
        this.f1883a = 0;
        d.a.a.a.a.a("InstallReferrerClient", "Install Referrer service unavailable on device.");
        installReferrerStateListener.onInstallReferrerSetupFinished(2);
    }

    @Override // com.android.installreferrer.api.InstallReferrerClient
    public ReferrerDetails a() throws RemoteException {
        if (b()) {
            Bundle bundle = new Bundle();
            bundle.putString("package_name", this.f1884b.getPackageName());
            try {
                return new ReferrerDetails(this.f1885c.getInstallReferrer(bundle));
            } catch (RemoteException e) {
                d.a.a.a.a.b("InstallReferrerClient", "RemoteException getting install referrer information");
                this.f1883a = 0;
                throw e;
            }
        }
        throw new IllegalStateException("Service not connected. Please start a connection before using the service.");
    }
}
