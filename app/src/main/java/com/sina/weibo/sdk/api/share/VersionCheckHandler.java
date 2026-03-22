package com.sina.weibo.sdk.api.share;

import android.content.Context;
import com.sina.weibo.sdk.api.BaseMediaObject;
import com.sina.weibo.sdk.api.CmdObject;
import com.sina.weibo.sdk.api.VoiceObject;
import com.sina.weibo.sdk.api.WeiboMessage;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.api.share.ApiUtils;
import com.sina.weibo.sdk.utils.LogUtil;

/* loaded from: classes.dex */
public class VersionCheckHandler implements IVersionCheckHandler {
    private static final String TAG = "VersionCheckHandler";
    private String mPackageName;

    public VersionCheckHandler(String str) {
        this.mPackageName = str;
    }

    @Override // com.sina.weibo.sdk.api.share.IVersionCheckHandler
    public boolean check(Context context, WeiboMessage weiboMessage) {
        ApiUtils.WeiboInfo queryWeiboInfoByPackage;
        BaseMediaObject baseMediaObject;
        BaseMediaObject baseMediaObject2;
        LogUtil.d(TAG, "check WeiboMessage package : " + this.mPackageName);
        String str = this.mPackageName;
        if (str == null || str.length() == 0 || (queryWeiboInfoByPackage = ApiUtils.queryWeiboInfoByPackage(context, this.mPackageName)) == null) {
            return false;
        }
        LogUtil.d(TAG, "check WeiboMessage WeiboInfo supportApi : " + queryWeiboInfoByPackage.supportApi);
        if (queryWeiboInfoByPackage.supportApi < 10351 && (baseMediaObject2 = weiboMessage.mediaObject) != null && (baseMediaObject2 instanceof VoiceObject)) {
            weiboMessage.mediaObject = null;
        }
        if (queryWeiboInfoByPackage.supportApi >= 10352 || (baseMediaObject = weiboMessage.mediaObject) == null || !(baseMediaObject instanceof CmdObject)) {
            return true;
        }
        weiboMessage.mediaObject = null;
        return true;
    }

    public void setPackageName(String str) {
        this.mPackageName = str;
    }

    public VersionCheckHandler() {
    }

    @Override // com.sina.weibo.sdk.api.share.IVersionCheckHandler
    public boolean check(Context context, WeiboMultiMessage weiboMultiMessage) {
        ApiUtils.WeiboInfo queryWeiboInfoByPackage;
        BaseMediaObject baseMediaObject;
        LogUtil.d(TAG, "check WeiboMultiMessage package : " + this.mPackageName);
        String str = this.mPackageName;
        if (str == null || str.length() == 0 || (queryWeiboInfoByPackage = ApiUtils.queryWeiboInfoByPackage(context, this.mPackageName)) == null) {
            return false;
        }
        LogUtil.d(TAG, "check WeiboMultiMessage WeiboInfo supportApi : " + queryWeiboInfoByPackage.supportApi);
        int i = queryWeiboInfoByPackage.supportApi;
        if (i < 10351) {
            return false;
        }
        if (i >= 10352 || (baseMediaObject = weiboMultiMessage.mediaObject) == null || !(baseMediaObject instanceof CmdObject)) {
            return true;
        }
        weiboMultiMessage.mediaObject = null;
        return true;
    }
}
