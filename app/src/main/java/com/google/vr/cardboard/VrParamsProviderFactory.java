package com.google.vr.cardboard;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class VrParamsProviderFactory {
    private static final boolean DEBUG = false;
    private static final String TAG = "VrParamsProviderFactory";
    private static VrParamsProvider providerForTesting;

    public static VrParamsProvider create(Context context) {
        VrParamsProvider vrParamsProvider = providerForTesting;
        if (vrParamsProvider != null) {
            return vrParamsProvider;
        }
        List<String> validContentProviderAuthorities = getValidContentProviderAuthorities(context);
        if (validContentProviderAuthorities != null) {
            for (String str : validContentProviderAuthorities) {
                ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(str);
                if (acquireContentProviderClient != null) {
                    return new ContentProviderVrParamsProvider(acquireContentProviderClient, str);
                }
            }
        }
        return new LegacyVrParamsProvider();
    }

    private static List getValidContentProviderAuthorities(Context context) {
        List<ResolveInfo> queryIntentContentProviders;
        if (Build.VERSION.SDK_INT < 19 || (queryIntentContentProviders = context.getPackageManager().queryIntentContentProviders(new Intent(VrSettingsProviderContract.PROVIDER_INTENT_ACTION), 0)) == null || queryIntentContentProviders.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<ResolveInfo> it2 = queryIntentContentProviders.iterator();
        while (it2.hasNext()) {
            ProviderInfo providerInfo = it2.next().providerInfo;
            if (PackageUtils.isGooglePackage(providerInfo.packageName)) {
                arrayList.add(providerInfo.authority);
            }
        }
        return arrayList;
    }

    public static boolean isContentProviderAvailable(Context context) {
        VrParamsProvider vrParamsProvider = providerForTesting;
        if (vrParamsProvider != null && (vrParamsProvider instanceof ContentProviderVrParamsProvider)) {
            return true;
        }
        List validContentProviderAuthorities = getValidContentProviderAuthorities(context);
        return (validContentProviderAuthorities == null || validContentProviderAuthorities.isEmpty()) ? false : true;
    }

    public static void setProviderForTesting(VrParamsProvider vrParamsProvider) {
        providerForTesting = vrParamsProvider;
    }
}
