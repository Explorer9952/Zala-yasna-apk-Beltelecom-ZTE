package com.sina.weibo.sdk.api.share;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;
import java.util.List;

/* loaded from: classes.dex */
public class ApiUtils {
    public static final int BUILD_INT = 10350;
    public static final int BUILD_INT_VER_2_2 = 10351;
    public static final int BUILD_INT_VER_2_3 = 10352;
    private static final String TAG = "ApiUtils";
    private static final String WEIBO_IDENTITY_ACTION = "com.sina.weibo.action.sdkidentity";
    private static final Uri WEIBO_NAME_URI = Uri.parse("content://com.sina.weibo.sdkProvider/query/package");
    private static final String WEIBO_SIGN = "18da2bf10352443a00a5e046d9fca6bd";

    /* loaded from: classes.dex */
    public static class WeiboInfo {
        public String packageName;
        public int supportApi;

        public String toString() {
            return "WeiboInfo: PackageName = " + this.packageName + ", supportApi = " + this.supportApi;
        }
    }

    public static boolean containSign(Signature[] signatureArr, String str) {
        if (signatureArr == null || str == null) {
            return false;
        }
        for (Signature signature : signatureArr) {
            if (str.equals(MD5.hexdigest(signature.toByteArray()))) {
                LogUtil.d(TAG, "check pass");
                return true;
            }
        }
        return false;
    }

    public static boolean isWeiboAppSupportAPI(int i) {
        return i >= 10350;
    }

    public static WeiboInfo queryWeiboInfo(Context context) {
        WeiboInfo queryWeiboInfoByProvider = queryWeiboInfoByProvider(context);
        return queryWeiboInfoByProvider == null ? queryWeiboInfoByFile(context) : queryWeiboInfoByProvider;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0059, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0096, code lost:
    
        if (r1 == null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x007b, code lost:
    
        if (r1 == null) goto L56;
     */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.sina.weibo.sdk.api.share.ApiUtils.WeiboInfo queryWeiboInfoByAsset(android.content.Context r8, java.lang.String r9) {
        /*
            r0 = 0
            if (r8 == 0) goto La2
            if (r9 != 0) goto L7
            goto La2
        L7:
            r1 = 2
            android.content.Context r1 = r8.createPackageContext(r9, r1)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L70 org.json.JSONException -> L81 java.io.IOException -> L89 android.content.pm.PackageManager.NameNotFoundException -> L91
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r2]     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L70 org.json.JSONException -> L81 java.io.IOException -> L89 android.content.pm.PackageManager.NameNotFoundException -> L91
            android.content.res.AssetManager r1 = r1.getAssets()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L70 org.json.JSONException -> L81 java.io.IOException -> L89 android.content.pm.PackageManager.NameNotFoundException -> L91
            java.lang.String r4 = "weibo_for_sdk.json"
            java.io.InputStream r1 = r1.open(r4)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L70 org.json.JSONException -> L81 java.io.IOException -> L89 android.content.pm.PackageManager.NameNotFoundException -> L91
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L66 org.json.JSONException -> L68 java.io.IOException -> L6a android.content.pm.PackageManager.NameNotFoundException -> L6c java.lang.Throwable -> L9a
            r4.<init>()     // Catch: java.lang.Exception -> L66 org.json.JSONException -> L68 java.io.IOException -> L6a android.content.pm.PackageManager.NameNotFoundException -> L6c java.lang.Throwable -> L9a
        L20:
            r5 = 0
            int r6 = r1.read(r3, r5, r2)     // Catch: java.lang.Exception -> L66 org.json.JSONException -> L68 java.io.IOException -> L6a android.content.pm.PackageManager.NameNotFoundException -> L6c java.lang.Throwable -> L9a
            r7 = -1
            if (r6 != r7) goto L5d
            java.lang.String r2 = r4.toString()     // Catch: java.lang.Exception -> L66 org.json.JSONException -> L68 java.io.IOException -> L6a android.content.pm.PackageManager.NameNotFoundException -> L6c java.lang.Throwable -> L9a
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Exception -> L66 org.json.JSONException -> L68 java.io.IOException -> L6a android.content.pm.PackageManager.NameNotFoundException -> L6c java.lang.Throwable -> L9a
            if (r2 != 0) goto L57
            boolean r8 = validateWeiboSign(r8, r9)     // Catch: java.lang.Exception -> L66 org.json.JSONException -> L68 java.io.IOException -> L6a android.content.pm.PackageManager.NameNotFoundException -> L6c java.lang.Throwable -> L9a
            if (r8 != 0) goto L39
            goto L57
        L39:
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch: java.lang.Exception -> L66 org.json.JSONException -> L68 java.io.IOException -> L6a android.content.pm.PackageManager.NameNotFoundException -> L6c java.lang.Throwable -> L9a
            java.lang.String r2 = r4.toString()     // Catch: java.lang.Exception -> L66 org.json.JSONException -> L68 java.io.IOException -> L6a android.content.pm.PackageManager.NameNotFoundException -> L6c java.lang.Throwable -> L9a
            r8.<init>(r2)     // Catch: java.lang.Exception -> L66 org.json.JSONException -> L68 java.io.IOException -> L6a android.content.pm.PackageManager.NameNotFoundException -> L6c java.lang.Throwable -> L9a
            java.lang.String r2 = "support_api"
            int r8 = r8.optInt(r2, r7)     // Catch: java.lang.Exception -> L66 org.json.JSONException -> L68 java.io.IOException -> L6a android.content.pm.PackageManager.NameNotFoundException -> L6c java.lang.Throwable -> L9a
            com.sina.weibo.sdk.api.share.ApiUtils$WeiboInfo r2 = new com.sina.weibo.sdk.api.share.ApiUtils$WeiboInfo     // Catch: java.lang.Exception -> L66 org.json.JSONException -> L68 java.io.IOException -> L6a android.content.pm.PackageManager.NameNotFoundException -> L6c java.lang.Throwable -> L9a
            r2.<init>()     // Catch: java.lang.Exception -> L66 org.json.JSONException -> L68 java.io.IOException -> L6a android.content.pm.PackageManager.NameNotFoundException -> L6c java.lang.Throwable -> L9a
            r2.packageName = r9     // Catch: java.lang.Exception -> L66 org.json.JSONException -> L68 java.io.IOException -> L6a android.content.pm.PackageManager.NameNotFoundException -> L6c java.lang.Throwable -> L9a
            r2.supportApi = r8     // Catch: java.lang.Exception -> L66 org.json.JSONException -> L68 java.io.IOException -> L6a android.content.pm.PackageManager.NameNotFoundException -> L6c java.lang.Throwable -> L9a
            if (r1 == 0) goto L56
            r1.close()     // Catch: java.io.IOException -> L56
        L56:
            return r2
        L57:
            if (r1 == 0) goto L5c
            r1.close()     // Catch: java.io.IOException -> L5c
        L5c:
            return r0
        L5d:
            java.lang.String r7 = new java.lang.String     // Catch: java.lang.Exception -> L66 org.json.JSONException -> L68 java.io.IOException -> L6a android.content.pm.PackageManager.NameNotFoundException -> L6c java.lang.Throwable -> L9a
            r7.<init>(r3, r5, r6)     // Catch: java.lang.Exception -> L66 org.json.JSONException -> L68 java.io.IOException -> L6a android.content.pm.PackageManager.NameNotFoundException -> L6c java.lang.Throwable -> L9a
            r4.append(r7)     // Catch: java.lang.Exception -> L66 org.json.JSONException -> L68 java.io.IOException -> L6a android.content.pm.PackageManager.NameNotFoundException -> L6c java.lang.Throwable -> L9a
            goto L20
        L66:
            r8 = move-exception
            goto L72
        L68:
            r8 = move-exception
            goto L83
        L6a:
            r8 = move-exception
            goto L8b
        L6c:
            r8 = move-exception
            goto L93
        L6e:
            r8 = move-exception
            goto L9c
        L70:
            r8 = move-exception
            r1 = r0
        L72:
            java.lang.String r9 = "ApiUtils"
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Throwable -> L9a
            com.sina.weibo.sdk.utils.LogUtil.e(r9, r8)     // Catch: java.lang.Throwable -> L9a
            if (r1 == 0) goto L99
        L7d:
            r1.close()     // Catch: java.io.IOException -> L99
            goto L99
        L81:
            r8 = move-exception
            r1 = r0
        L83:
            r8.printStackTrace()     // Catch: java.lang.Throwable -> L9a
            if (r1 == 0) goto L99
            goto L7d
        L89:
            r8 = move-exception
            r1 = r0
        L8b:
            r8.printStackTrace()     // Catch: java.lang.Throwable -> L9a
            if (r1 == 0) goto L99
            goto L7d
        L91:
            r8 = move-exception
            r1 = r0
        L93:
            r8.printStackTrace()     // Catch: java.lang.Throwable -> L9a
            if (r1 == 0) goto L99
            goto L7d
        L99:
            return r0
        L9a:
            r8 = move-exception
            r0 = r1
        L9c:
            if (r0 == 0) goto La1
            r0.close()     // Catch: java.io.IOException -> La1
        La1:
            throw r8
        La2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.api.share.ApiUtils.queryWeiboInfoByAsset(android.content.Context, java.lang.String):com.sina.weibo.sdk.api.share.ApiUtils$WeiboInfo");
    }

    private static WeiboInfo queryWeiboInfoByFile(Context context) {
        ApplicationInfo applicationInfo;
        String str;
        WeiboInfo queryWeiboInfoByAsset;
        Intent intent = new Intent(WEIBO_IDENTITY_ACTION);
        intent.addCategory("android.intent.category.DEFAULT");
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            return null;
        }
        for (ResolveInfo resolveInfo : queryIntentServices) {
            ServiceInfo serviceInfo = resolveInfo.serviceInfo;
            if (serviceInfo != null && (applicationInfo = serviceInfo.applicationInfo) != null && (str = applicationInfo.packageName) != null && str.length() != 0 && (queryWeiboInfoByAsset = queryWeiboInfoByAsset(context, resolveInfo.serviceInfo.applicationInfo.packageName)) != null) {
                return queryWeiboInfoByAsset;
            }
        }
        return null;
    }

    public static WeiboInfo queryWeiboInfoByPackage(Context context, String str) {
        if (context != null && str != null) {
            WeiboInfo queryWeiboInfoByAsset = queryWeiboInfoByAsset(context, str);
            if (queryWeiboInfoByAsset != null) {
                return queryWeiboInfoByAsset;
            }
            WeiboInfo queryWeiboInfoByProvider = queryWeiboInfoByProvider(context);
            if (queryWeiboInfoByProvider != null && str.equals(queryWeiboInfoByProvider.packageName)) {
                return queryWeiboInfoByProvider;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0056, code lost:
    
        if (r0 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0070, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006d, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006b, code lost:
    
        if (r0 == null) goto L34;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0075  */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.sina.weibo.sdk.api.share.ApiUtils.WeiboInfo queryWeiboInfoByProvider(android.content.Context r7) {
        /*
            android.content.ContentResolver r0 = r7.getContentResolver()
            r6 = 0
            android.net.Uri r1 = com.sina.weibo.sdk.api.share.ApiUtils.WEIBO_NAME_URI     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            if (r0 != 0) goto L17
            if (r0 == 0) goto L16
            r0.close()
        L16:
            return r6
        L17:
            java.lang.String r1 = "support_api"
            int r1 = r0.getColumnIndex(r1)     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L71
            java.lang.String r2 = "package"
            int r2 = r0.getColumnIndex(r2)     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L71
            boolean r3 = r0.moveToFirst()     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L71
            if (r3 == 0) goto L56
            r3 = -1
            java.lang.String r1 = r0.getString(r1)     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L71
            int r3 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.NumberFormatException -> L33 java.lang.Exception -> L59 java.lang.Throwable -> L71
            goto L37
        L33:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L71
        L37:
            java.lang.String r1 = r0.getString(r2)     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L71
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L71
            if (r2 != 0) goto L56
            boolean r7 = validateWeiboSign(r7, r1)     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L71
            if (r7 == 0) goto L56
            com.sina.weibo.sdk.api.share.ApiUtils$WeiboInfo r7 = new com.sina.weibo.sdk.api.share.ApiUtils$WeiboInfo     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L71
            r7.<init>()     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L71
            r7.packageName = r1     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L71
            r7.supportApi = r3     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L71
            if (r0 == 0) goto L55
            r0.close()
        L55:
            return r7
        L56:
            if (r0 == 0) goto L70
            goto L6d
        L59:
            r7 = move-exception
            goto L5f
        L5b:
            r7 = move-exception
            goto L73
        L5d:
            r7 = move-exception
            r0 = r6
        L5f:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = "ApiUtils"
            java.lang.String r7 = r7.getMessage()     // Catch: java.lang.Throwable -> L71
            com.sina.weibo.sdk.utils.LogUtil.e(r1, r7)     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L70
        L6d:
            r0.close()
        L70:
            return r6
        L71:
            r7 = move-exception
            r6 = r0
        L73:
            if (r6 == 0) goto L78
            r6.close()
        L78:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.api.share.ApiUtils.queryWeiboInfoByProvider(android.content.Context):com.sina.weibo.sdk.api.share.ApiUtils$WeiboInfo");
    }

    public static boolean validateWeiboSign(Context context, String str) {
        try {
            return containSign(context.getPackageManager().getPackageInfo(str, 64).signatures, WEIBO_SIGN);
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
