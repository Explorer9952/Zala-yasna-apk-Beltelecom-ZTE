package com.sina.weibo.sdk.api.share;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.api.share.ApiUtils;
import com.sina.weibo.sdk.api.share.IWeiboHandler;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.exception.WeiboShareException;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.Utility;

/* loaded from: classes.dex */
public class WeiboShareAPIImpl implements IWeiboShareAPI {
    private static final String TAG = "WeiboApiImpl";
    private String mAppKey;
    private Context mContext;
    private Dialog mDownloadConfirmDialog = null;
    private IWeiboDownloadListener mDownloadListener;
    private boolean mNeedDownloadWeibo;
    private ApiUtils.WeiboInfo mWeiboInfo;

    public WeiboShareAPIImpl(Context context, String str, boolean z) {
        this.mWeiboInfo = null;
        this.mNeedDownloadWeibo = true;
        this.mContext = context;
        this.mAppKey = str;
        this.mNeedDownloadWeibo = z;
        ApiUtils.WeiboInfo queryWeiboInfo = ApiUtils.queryWeiboInfo(context);
        this.mWeiboInfo = queryWeiboInfo;
        if (queryWeiboInfo != null) {
            LogUtil.d(TAG, queryWeiboInfo.toString());
        } else {
            LogUtil.d(TAG, "WeiboInfo: is null");
        }
    }

    private void sendBroadcast(Context context, String str, String str2, String str3, Bundle bundle) {
        Intent intent = new Intent(str);
        String packageName = context.getPackageName();
        intent.putExtra(WBConstants.Base.SDK_VER, 22);
        intent.putExtra(WBConstants.Base.APP_PKG, packageName);
        intent.putExtra(WBConstants.Base.APP_KEY, str2);
        intent.putExtra(WBConstants.SDK.FLAG, WBConstants.WEIBO_FLAG_SDK);
        intent.putExtra(WBConstants.SIGN, MD5.hexdigest(Utility.getSign(context, packageName)));
        if (!TextUtils.isEmpty(str3)) {
            intent.setPackage(str3);
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        LogUtil.d(TAG, "intent=" + intent + ", extra=" + intent.getExtras());
        context.sendBroadcast(intent, WBConstants.ACTION_WEIBO_SDK_PERMISSION);
    }

    private boolean shareWithWeibo(Activity activity, String str, String str2, String str3, Bundle bundle) {
        if (activity != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            Intent intent = new Intent();
            intent.setPackage(str2);
            intent.setAction(str);
            String packageName = activity.getPackageName();
            intent.putExtra(WBConstants.Base.SDK_VER, 22);
            intent.putExtra(WBConstants.Base.APP_PKG, packageName);
            intent.putExtra(WBConstants.Base.APP_KEY, str3);
            intent.putExtra(WBConstants.SDK.FLAG, WBConstants.WEIBO_FLAG_SDK);
            intent.putExtra(WBConstants.SIGN, MD5.hexdigest(Utility.getSign(activity, packageName)));
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            try {
                LogUtil.d(TAG, "intent=" + intent + ", extra=" + intent.getExtras());
                activity.startActivityForResult(intent, WBConstants.SDK_ACTIVITY_FOR_RESULT_CODE);
                return true;
            } catch (ActivityNotFoundException unused) {
                LogUtil.e(TAG, "Failed, target ActivityNotFound");
                return false;
            }
        }
        LogUtil.e("ActivityHandler", "send fail, invalid arguments");
        return false;
    }

    @Override // com.sina.weibo.sdk.api.share.IWeiboShareAPI
    public boolean checkEnvironment(boolean z) throws WeiboShareException {
        ApiUtils.WeiboInfo weiboInfo = this.mWeiboInfo;
        if (weiboInfo != null) {
            if (ApiUtils.isWeiboAppSupportAPI(weiboInfo.supportApi)) {
                if (ApiUtils.validateWeiboSign(this.mContext, this.mWeiboInfo.packageName)) {
                    return true;
                }
                throw new WeiboShareException("Weibo signature is incorrect!");
            }
            throw new WeiboShareException("Weibo do NOT support Share API!");
        }
        if (z) {
            Dialog dialog = this.mDownloadConfirmDialog;
            if (dialog == null) {
                Dialog createDownloadConfirmDialog = WeiboDownloader.createDownloadConfirmDialog(this.mContext, this.mDownloadListener);
                this.mDownloadConfirmDialog = createDownloadConfirmDialog;
                createDownloadConfirmDialog.show();
                return false;
            }
            if (dialog.isShowing()) {
                return false;
            }
            this.mDownloadConfirmDialog.show();
            return false;
        }
        throw new WeiboShareException("Weibo is NOT installed!");
    }

    @Override // com.sina.weibo.sdk.api.share.IWeiboShareAPI
    public int getWeiboAppSupportAPI() {
        ApiUtils.WeiboInfo weiboInfo = this.mWeiboInfo;
        if (weiboInfo == null) {
            return -1;
        }
        return weiboInfo.supportApi;
    }

    @Override // com.sina.weibo.sdk.api.share.IWeiboShareAPI
    public boolean handleWeiboRequest(Intent intent, IWeiboHandler.Request request) {
        if (intent == null || request == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(WBConstants.Base.APP_PKG);
        String stringExtra2 = intent.getStringExtra(WBConstants.TRAN);
        if (stringExtra == null) {
            LogUtil.e(TAG, "requestListener() faild appPackage validateSign faild");
            request.onRequest(null);
            return false;
        }
        if (stringExtra2 == null) {
            LogUtil.e(TAG, "requestListener() faild intent TRAN is null");
            request.onRequest(null);
            return false;
        }
        if (!ApiUtils.validateWeiboSign(this.mContext, stringExtra)) {
            LogUtil.e(TAG, "requestListener() faild appPackage validateSign faild");
            request.onRequest(null);
            return false;
        }
        request.onRequest(new ProvideMessageForWeiboRequest(intent.getExtras()));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sina.weibo.sdk.api.share.IWeiboShareAPI
    public boolean handleWeiboResponse(Intent intent, IWeiboHandler.Response response) {
        String stringExtra = intent.getStringExtra(WBConstants.Base.APP_PKG);
        if (stringExtra == null) {
            LogUtil.e(TAG, "responseListener() faild appPackage is null");
            return false;
        }
        if (!(response instanceof Activity)) {
            LogUtil.e(TAG, "responseListener() faild handler is not Activity");
            return false;
        }
        LogUtil.d(TAG, "responseListener() callPkg : " + ((Activity) response).getCallingPackage());
        if (intent.getStringExtra(WBConstants.TRAN) == null) {
            LogUtil.e(TAG, "responseListener() faild intent TRAN is null");
            return false;
        }
        if (!ApiUtils.validateWeiboSign(this.mContext, stringExtra)) {
            LogUtil.e(TAG, "responseListener() faild appPackage validateSign faild");
            return false;
        }
        response.onResponse(new SendMessageToWeiboResponse(intent.getExtras()));
        return true;
    }

    @Override // com.sina.weibo.sdk.api.share.IWeiboShareAPI
    public boolean isWeiboAppInstalled() {
        return this.mWeiboInfo != null;
    }

    @Override // com.sina.weibo.sdk.api.share.IWeiboShareAPI
    public boolean isWeiboAppSupportAPI() {
        return ApiUtils.isWeiboAppSupportAPI(getWeiboAppSupportAPI());
    }

    @Override // com.sina.weibo.sdk.api.share.IWeiboShareAPI
    public boolean launchWeibo() {
        ApiUtils.WeiboInfo weiboInfo = this.mWeiboInfo;
        if (weiboInfo == null) {
            LogUtil.e(TAG, "startWeibo() faild winfo is null");
            return false;
        }
        try {
            if (TextUtils.isEmpty(weiboInfo.packageName)) {
                LogUtil.e(TAG, "startWeibo() faild packageName is null");
                return false;
            }
            this.mContext.startActivity(this.mContext.getPackageManager().getLaunchIntentForPackage(this.mWeiboInfo.packageName));
            return true;
        } catch (Exception e) {
            LogUtil.e(TAG, e.getMessage());
            return false;
        }
    }

    @Override // com.sina.weibo.sdk.api.share.IWeiboShareAPI
    public boolean registerApp() {
        if (!checkEnvironment(this.mNeedDownloadWeibo)) {
            return false;
        }
        sendBroadcast(this.mContext, WBConstants.ACTION_WEIBO_REGISTER, this.mAppKey, null, null);
        return true;
    }

    @Override // com.sina.weibo.sdk.api.share.IWeiboShareAPI
    public void registerWeiboDownloadListener(IWeiboDownloadListener iWeiboDownloadListener) {
        this.mDownloadListener = iWeiboDownloadListener;
    }

    @Override // com.sina.weibo.sdk.api.share.IWeiboShareAPI
    public boolean sendRequest(BaseRequest baseRequest) {
        if (baseRequest == null) {
            LogUtil.e(TAG, "sendRequest faild act == null or request == null");
            return false;
        }
        if (!checkEnvironment(this.mNeedDownloadWeibo)) {
            return false;
        }
        if (!baseRequest.check(this.mContext, new VersionCheckHandler(this.mWeiboInfo.packageName))) {
            LogUtil.e(TAG, "sendRequest faild request check faild");
            return false;
        }
        Bundle bundle = new Bundle();
        baseRequest.toBundle(bundle);
        return shareWithWeibo((Activity) this.mContext, WBConstants.ACTIVITY_WEIBO, this.mWeiboInfo.packageName, this.mAppKey, bundle);
    }

    @Override // com.sina.weibo.sdk.api.share.IWeiboShareAPI
    public boolean sendResponse(BaseResponse baseResponse) {
        if (baseResponse == null) {
            LogUtil.e(TAG, "sendResponse failed response null");
            return false;
        }
        if (!baseResponse.check(this.mContext, new VersionCheckHandler())) {
            LogUtil.e(TAG, "sendResponse checkArgs fail");
            return false;
        }
        Bundle bundle = new Bundle();
        baseResponse.toBundle(bundle);
        sendBroadcast(this.mContext, WBConstants.ACTION_WEIBO_RESPONSE, this.mAppKey, baseResponse.reqPackageName, bundle);
        return true;
    }
}
