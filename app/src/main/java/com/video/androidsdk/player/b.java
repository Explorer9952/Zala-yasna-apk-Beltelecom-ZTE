package com.video.androidsdk.player;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.player.IBasePlayer;
import com.video.androidsdk.player.common.UrlRedirectUtil;
import com.video.androidsdk.player.common.UrlUtils;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbsBasePlayer.java */
/* loaded from: classes.dex */
public class b implements UrlRedirectUtil.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3332a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f3333b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ a f3334c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str, boolean z) {
        this.f3334c = aVar;
        this.f3332a = str;
        this.f3333b = z;
    }

    @Override // com.video.androidsdk.player.common.UrlRedirectUtil.a
    public void a(String str, String str2) {
        LogEx.d("AbsBasePlayer", "final url is " + str2);
        if (TextUtils.isEmpty(str2)) {
            IBasePlayer.OnEventListener onEventListener = this.f3334c.f3307c;
            if (onEventListener != null) {
                onEventListener.onError("0120" + str, "[source_error]URL redirection failed, the url is " + str2);
                return;
            }
            return;
        }
        HashMap<String, Pair<String, Long>> urlMap = UrlUtils.getUrlMap();
        if (urlMap.size() > 100) {
            urlMap.clear();
        }
        if (!TextUtils.isEmpty(this.f3332a) && this.f3333b) {
            LogEx.d("AbsBasePlayer", "cache url ,channelcode : " + this.f3332a + "  url is " + str2);
            urlMap.put(this.f3332a, new Pair<>(str2, Long.valueOf(SystemClock.elapsedRealtime())));
        }
        a aVar = this.f3334c;
        aVar.f(aVar.b(str2));
    }
}
