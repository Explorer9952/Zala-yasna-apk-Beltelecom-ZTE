package com.video.androidsdk.player;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.video.androidsdk.log.LogEx;

/* loaded from: classes.dex */
public class MediaPlayer {
    public static final int PLAYER_TYPE_ANDROIDMEDIAPLAYER = 6;
    public static final int PLAYER_TYPE_EXOPLAYER = 7;
    public static final int PLAYER_TYPE_FVPLAYER = 12;
    public static final int PLAYER_TYPE_IJKPLAYER = 8;
    public static final int PLAYER_TYPE_IPTVPLAYER = 9;
    public static final int PLAYER_TYPE_MULTIVRPLAYER = 10;
    public static final int PLAYER_TYPE_NEXSTREAM = 3;
    public static final int PLAYER_TYPE_OMAFPLAYER = 11;
    public static final int PLAYER_TYPE_PLAYREADY = 4;
    public static final int PLAYER_TYPE_VIDEOPLAYER = 2;
    public static final int PLAYER_TYPE_VISUALON = 1;
    public static final int PLAYER_TYPE_VRPLAYER = 5;
    public static String TAG = "PlayerFactory";

    /* renamed from: a, reason: collision with root package name */
    private int f3259a;

    /* renamed from: b, reason: collision with root package name */
    private Context f3260b;

    /* renamed from: c, reason: collision with root package name */
    private Bundle f3261c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f3262d = false;
    private Activity e;

    public MediaPlayer(Context context, int i) {
        this.f3260b = context;
        this.f3259a = i;
    }

    public IBasePlayer createPlayer() {
        int i = this.f3259a;
        if (i != 1) {
            switch (i) {
                case 4:
                    LogEx.i(TAG, "create PlayReadyPlayer failed!!! you need to set a Bundle as Parameter to create PlayReadyPlayer with call createPlayer()!!!");
                    return new VisualonPlayer(this.f3260b);
                case 5:
                    LogEx.d(TAG, "create VrPlayer");
                    return new VrPlayer(this.f3260b);
                case 6:
                    LogEx.d(TAG, "create AndroidMediaPlayer");
                    return new c(this.f3260b);
                case 7:
                    LogEx.d(TAG, "create ExoPlayer");
                    return new Exoplayer(this.f3260b, this.f3261c);
                case 8:
                    LogEx.d(TAG, "create IjkPlayer");
                    return new IjkPlayer(this.f3260b);
                case 9:
                    LogEx.d(TAG, "create ExoPlayer");
                    return new IPTVPlayer(this.f3260b, this.f3261c);
                case 10:
                    LogEx.d(TAG, "create MultiVrPlayer");
                    return new MultiVrPlayer(this.f3260b, this.f3261c);
                case 11:
                    LogEx.d(TAG, "create OmafPlayer");
                    return new OmafPlayer(this.f3260b);
                case 12:
                    LogEx.d(TAG, "create FVPlayer");
                    return new l(this.f3260b, this.f3261c);
                default:
                    LogEx.w(TAG, " PlayerType does not exist, default is  VideoPlayer!");
                    return new IjkPlayer(this.f3260b);
            }
        }
        LogEx.d(TAG, "create VisualonPlayer");
        return new VisualonPlayer(this.f3260b);
    }

    public MediaPlayer(Context context, Activity activity, int i) {
        this.e = activity;
        this.f3259a = i;
        this.f3260b = context;
    }

    public MediaPlayer(Context context, int i, Bundle bundle) {
        this.f3260b = context;
        this.f3259a = i;
        this.f3261c = bundle;
    }
}
