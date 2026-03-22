package com.sina.weibo.sdk.api.share;

import android.content.Context;
import android.os.Bundle;

/* loaded from: classes.dex */
public abstract class Base {
    public String transaction;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean check(Context context, VersionCheckHandler versionCheckHandler);

    public abstract void fromBundle(Bundle bundle);

    public abstract int getType();

    public abstract void toBundle(Bundle bundle);
}
