package com.sina.weibo.sdk.api.share;

import android.content.Context;
import android.os.Bundle;
import com.sina.weibo.sdk.api.WeiboMessage;

/* loaded from: classes.dex */
public class SendMessageToWeiboRequest extends BaseRequest {
    public WeiboMessage message;

    public SendMessageToWeiboRequest() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.sina.weibo.sdk.api.share.Base
    public final boolean check(Context context, VersionCheckHandler versionCheckHandler) {
        WeiboMessage weiboMessage = this.message;
        if (weiboMessage == null) {
            return false;
        }
        if (versionCheckHandler == null || versionCheckHandler.check(context, weiboMessage)) {
            return this.message.checkArgs();
        }
        return false;
    }

    @Override // com.sina.weibo.sdk.api.share.BaseRequest, com.sina.weibo.sdk.api.share.Base
    public void fromBundle(Bundle bundle) {
        super.fromBundle(bundle);
        this.message = new WeiboMessage(bundle);
    }

    @Override // com.sina.weibo.sdk.api.share.Base
    public int getType() {
        return 1;
    }

    @Override // com.sina.weibo.sdk.api.share.BaseRequest, com.sina.weibo.sdk.api.share.Base
    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putAll(this.message.toBundle(bundle));
    }

    public SendMessageToWeiboRequest(Bundle bundle) {
        fromBundle(bundle);
    }
}
