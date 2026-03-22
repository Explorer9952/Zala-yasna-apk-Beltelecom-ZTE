package com.sina.weibo.sdk.api.share;

import android.content.Context;
import android.os.Bundle;

/* loaded from: classes.dex */
public class ProvideMessageForWeiboRequest extends BaseRequest {
    public ProvideMessageForWeiboRequest() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.sina.weibo.sdk.api.share.Base
    public final boolean check(Context context, VersionCheckHandler versionCheckHandler) {
        return true;
    }

    @Override // com.sina.weibo.sdk.api.share.Base
    public int getType() {
        return 2;
    }

    public ProvideMessageForWeiboRequest(Bundle bundle) {
        fromBundle(bundle);
    }
}
