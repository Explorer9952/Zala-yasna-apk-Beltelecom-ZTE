package com.zte.iptvclient.android.common.eventbus.multi;

import com.video.androidsdk.log.LogEx;

/* loaded from: classes.dex */
public class MultiPlayWindowEvent {

    /* renamed from: a, reason: collision with root package name */
    private int f4521a = 0;

    /* loaded from: classes.dex */
    public enum MultiPlayWindowEventType {
        CONTROL_GRAVITY_INDUCTION_IS_OPEN,
        RELEASE_PLAYER_MES_FROM_PLAYER,
        RELEASE_PLAYER_MES_FROM_UI,
        INIT_MULTI_WINDOW_PLAY_ENVIRONMENT,
        EXIT_MULTI_WINDOW_PLAY_ENVIRONMENT,
        RELEASE_ALL_MULTI_WINDOW_PLAYER,
        REFRESH_TABS,
        HIDE_NETWORK_HINT,
        SHOW_NETWORK_HINT,
        REFRESH_TV_FRAGMENT_BACK_IMG
    }

    public MultiPlayWindowEvent(MultiPlayWindowEventType multiPlayWindowEventType) {
    }

    public int a() {
        return this.f4521a;
    }

    public void a(boolean z) {
        LogEx.d("MultiPlayWindowEvent", "isOpenGravityInduction" + z);
    }
}
