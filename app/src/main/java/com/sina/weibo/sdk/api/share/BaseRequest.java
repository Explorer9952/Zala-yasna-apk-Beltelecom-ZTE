package com.sina.weibo.sdk.api.share;

import android.os.Bundle;
import com.sina.weibo.sdk.constant.WBConstants;

/* loaded from: classes.dex */
public abstract class BaseRequest extends Base {
    public String packageName;

    @Override // com.sina.weibo.sdk.api.share.Base
    public void fromBundle(Bundle bundle) {
        this.transaction = bundle.getString(WBConstants.TRAN);
        this.packageName = bundle.getString(WBConstants.Base.APP_PKG);
    }

    @Override // com.sina.weibo.sdk.api.share.Base
    public void toBundle(Bundle bundle) {
        bundle.putInt(WBConstants.COMMAND_TYPE_KEY, getType());
        bundle.putString(WBConstants.TRAN, this.transaction);
    }
}
