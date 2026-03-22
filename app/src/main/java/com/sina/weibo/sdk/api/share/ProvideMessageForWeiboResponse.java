package com.sina.weibo.sdk.api.share;

import android.content.Context;
import android.os.Bundle;
import com.sina.weibo.sdk.api.WeiboMessage;

/* loaded from: classes.dex */
public class ProvideMessageForWeiboResponse extends BaseResponse {
    public WeiboMessage message;

    public ProvideMessageForWeiboResponse() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.sina.weibo.sdk.api.share.Base
    public final boolean check(Context context, VersionCheckHandler versionCheckHandler) {
        if (this.message == null) {
            return false;
        }
        if (versionCheckHandler != null) {
            versionCheckHandler.setPackageName(this.reqPackageName);
            if (!versionCheckHandler.check(context, this.message)) {
                return false;
            }
        }
        return this.message.checkArgs();
    }

    @Override // com.sina.weibo.sdk.api.share.BaseResponse, com.sina.weibo.sdk.api.share.Base
    public void fromBundle(Bundle bundle) {
        super.fromBundle(bundle);
        this.message = new WeiboMessage(bundle);
    }

    @Override // com.sina.weibo.sdk.api.share.Base
    public int getType() {
        return 2;
    }

    @Override // com.sina.weibo.sdk.api.share.BaseResponse, com.sina.weibo.sdk.api.share.Base
    public void toBundle(Bundle bundle) {
        super.toBundle(bundle);
        bundle.putAll(this.message.toBundle(bundle));
    }

    public ProvideMessageForWeiboResponse(Bundle bundle) {
        fromBundle(bundle);
    }
}
