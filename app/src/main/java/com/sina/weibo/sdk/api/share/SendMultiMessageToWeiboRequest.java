package com.sina.weibo.sdk.api.share;

import android.content.Context;
import android.os.Bundle;
import com.sina.weibo.sdk.api.WeiboMultiMessage;

/* loaded from: classes.dex */
public class SendMultiMessageToWeiboRequest extends BaseRequest {
    public WeiboMultiMessage multiMessage;

    public SendMultiMessageToWeiboRequest() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.sina.weibo.sdk.api.share.Base
    public final boolean check(Context context, VersionCheckHandler versionCheckHandler) {
        WeiboMultiMessage weiboMultiMessage = this.multiMessage;
        if (weiboMultiMessage == null) {
            return false;
        }
        if (versionCheckHandler == null || versionCheckHandler.check(context, weiboMultiMessage)) {
            return this.multiMessage.checkArgs();
        }
        return false;
    }

    @Override // com.sina.weibo.sdk.api.share.BaseRequest, com.sina.weibo.sdk.api.share.Base
    public void fromBundle(Bundle bundle) {
        super.fromBundle(bundle);
        this.multiMessage = new WeiboMultiMessage(bundle);
    }

    @Override // com.sina.weibo.sdk.api.share.Base
    public int getType() {
        return 1;
    }

    @Override // com.sina.weibo.sdk.api.share.BaseRequest, com.sina.weibo.sdk.api.share.Base
    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putAll(this.multiMessage.toBundle(bundle));
    }

    public SendMultiMessageToWeiboRequest(Bundle bundle) {
        fromBundle(bundle);
    }
}
