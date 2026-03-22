package com.sina.weibo.sdk.api.share;

import android.content.Context;
import android.os.Bundle;
import com.sina.weibo.sdk.api.WeiboMultiMessage;

/* loaded from: classes.dex */
public class ProvideMultiMessageForWeiboResponse extends BaseResponse {
    public WeiboMultiMessage multiMessage;

    public ProvideMultiMessageForWeiboResponse() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.sina.weibo.sdk.api.share.Base
    public final boolean check(Context context, VersionCheckHandler versionCheckHandler) {
        if (this.multiMessage == null) {
            return false;
        }
        if (versionCheckHandler != null) {
            versionCheckHandler.setPackageName(this.reqPackageName);
            if (!versionCheckHandler.check(context, this.multiMessage)) {
                return false;
            }
        }
        return this.multiMessage.checkArgs();
    }

    @Override // com.sina.weibo.sdk.api.share.BaseResponse, com.sina.weibo.sdk.api.share.Base
    public void fromBundle(Bundle bundle) {
        super.fromBundle(bundle);
        this.multiMessage = new WeiboMultiMessage(bundle);
    }

    @Override // com.sina.weibo.sdk.api.share.Base
    public int getType() {
        return 2;
    }

    @Override // com.sina.weibo.sdk.api.share.BaseResponse, com.sina.weibo.sdk.api.share.Base
    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putAll(this.multiMessage.toBundle(bundle));
    }

    public ProvideMultiMessageForWeiboResponse(Bundle bundle) {
        fromBundle(bundle);
    }
}
