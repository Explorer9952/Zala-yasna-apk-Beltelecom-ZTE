package com.zte.iptvclient.android.mobile.e0.f;

import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.log.LogEx;

/* compiled from: GenreLockHelper.java */
/* loaded from: classes2.dex */
public class c {
    public static final boolean a() {
        LogEx.d("GenreLockHelper", "---isGenreLockByGenreIdListWithAttr---");
        return "1".equals(ConfigMgr.readPropertie("isGenreLockByGenreIdList"));
    }
}
