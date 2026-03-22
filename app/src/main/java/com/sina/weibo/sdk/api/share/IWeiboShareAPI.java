package com.sina.weibo.sdk.api.share;

import android.content.Intent;
import com.sina.weibo.sdk.api.share.IWeiboHandler;
import com.sina.weibo.sdk.exception.WeiboShareException;

/* loaded from: classes.dex */
public interface IWeiboShareAPI {
    boolean checkEnvironment(boolean z) throws WeiboShareException;

    int getWeiboAppSupportAPI();

    boolean handleWeiboRequest(Intent intent, IWeiboHandler.Request request);

    boolean handleWeiboResponse(Intent intent, IWeiboHandler.Response response);

    boolean isWeiboAppInstalled();

    boolean isWeiboAppSupportAPI();

    boolean launchWeibo();

    boolean registerApp();

    void registerWeiboDownloadListener(IWeiboDownloadListener iWeiboDownloadListener);

    boolean sendRequest(BaseRequest baseRequest);

    boolean sendResponse(BaseResponse baseResponse);
}
