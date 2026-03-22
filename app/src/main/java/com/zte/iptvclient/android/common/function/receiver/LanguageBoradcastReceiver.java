package com.zte.iptvclient.android.common.function.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.SDKUserMgr;
import com.zte.iptvclient.android.common.e.o.b;
import com.zte.iptvclient.android.zala.R;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes.dex */
public class LanguageBoradcastReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private String f4596a = LanguageBoradcastReceiver.class.getSimpleName();

    /* loaded from: classes.dex */
    class a implements SDKUserMgr.OnSetUserLanguageReturnListener {
        a(LanguageBoradcastReceiver languageBoradcastReceiver) {
        }

        @Override // com.video.androidsdk.service.SDKUserMgr.OnSetUserLanguageReturnListener
        public void onUserLanguageReturn(String str, String str2) {
            EventBus.getDefault().post(new b());
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        LogEx.d(this.f4596a, " LanguageReceiver onReceive");
        SDKUserMgr sDKUserMgr = new SDKUserMgr();
        LogEx.d(this.f4596a, "configuration Changed");
        sDKUserMgr.setUserLanguage(com.zte.iptvclient.android.common.i.a.a.a(R.string.login_set_language), new a(this));
    }
}
