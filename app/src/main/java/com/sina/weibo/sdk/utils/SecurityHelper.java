package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import com.sina.weibo.sdk.api.share.ApiUtils;
import com.sina.weibo.sdk.constant.WBConstants;

/* loaded from: classes.dex */
public class SecurityHelper {
    private static final String WEIBO_MD5_SIGNATURE = "18da2bf10352443a00a5e046d9fca6bd";

    public static boolean checkResponseAppLegal(Context context, Intent intent) {
        ApiUtils.WeiboInfo queryWeiboInfo = ApiUtils.queryWeiboInfo(context);
        if ((queryWeiboInfo != null && queryWeiboInfo.supportApi <= 10352) || queryWeiboInfo == null) {
            return true;
        }
        String stringExtra = intent.getStringExtra(WBConstants.Base.APP_PKG);
        return (stringExtra == null || intent.getStringExtra(WBConstants.TRAN) == null || !ApiUtils.validateWeiboSign(context, stringExtra)) ? false : true;
    }

    public static boolean containSign(Signature[] signatureArr, String str) {
        if (signatureArr == null || str == null) {
            return false;
        }
        for (Signature signature : signatureArr) {
            if (str.equals(MD5.hexdigest(signature.toByteArray()))) {
                return true;
            }
        }
        return false;
    }

    public static boolean validateAppSignatureForIntent(Context context, Intent intent) {
        ResolveInfo resolveActivity;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null || (resolveActivity = packageManager.resolveActivity(intent, 0)) == null) {
            return false;
        }
        try {
            return containSign(packageManager.getPackageInfo(resolveActivity.activityInfo.packageName, 64).signatures, WEIBO_MD5_SIGNATURE);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
