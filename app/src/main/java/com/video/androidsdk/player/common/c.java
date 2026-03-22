package com.video.androidsdk.player.common;

import com.video.androidsdk.log.LogEx;
import java.util.HashMap;

/* compiled from: TimeCal.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, Long> f3361a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static String[] f3362b = {"Init", "Open", "Open complete", "Open to render", "Run", "Buffer", "Seek", "Seek complete", "Seek to last chunk", "Pause", "Start", "Stop", "Play complete", "Select video", "Select video complete", "Select audio", "Select audio complete", "Select subtitle", "Select subtitle complete", "Commit selection"};

    /* compiled from: TimeCal.java */
    /* loaded from: classes.dex */
    public enum a {
        INIT_TIME(0),
        OPEN_TIME(1),
        OPEN_COMPLETE_TIME(2),
        OPEN_RENDER_TIME(3),
        RUN_TIME(4),
        BUFFER_TIME(5),
        SEEK_TIME(6),
        SEEK_COMPLETE_TIME(7),
        SEEK_TO_LATEST_TRUNK(8),
        PAUSE_TIME(9),
        START_TIME(10),
        STOP_TIME(11),
        PLAY_COMPLETE(12),
        SELECT_VIDEO(13),
        SELECT_VIDEO_COMPLETE(14),
        SELECT_AUDIO(15),
        SELECT_AUDIO_COMPLETE(16),
        SELECT_SUBTITLE(17),
        SELECT_SUBTITLE_COMPLETE(18),
        COMMIT_SELECTION(19),
        API_TIME_MAX_ID(-1);

        private int v;

        a(int i) {
            this.v = i;
        }

        public int a() {
            return this.v;
        }
    }

    public static void a(a aVar) {
        long currentTimeMillis = System.currentTimeMillis();
        String str = f3362b[aVar.a()];
        f3361a.put(str, Long.valueOf(currentTimeMillis));
        LogEx.d("[APP][Time]", str + " start time: " + currentTimeMillis + " ms");
    }

    public static void b(a aVar) {
        long currentTimeMillis = System.currentTimeMillis();
        String str = f3362b[aVar.a()];
        a aVar2 = (aVar == a.OPEN_RENDER_TIME || aVar == a.OPEN_COMPLETE_TIME) ? a.OPEN_TIME : aVar;
        if (aVar == a.SEEK_TO_LATEST_TRUNK || aVar == a.SEEK_COMPLETE_TIME) {
            aVar2 = a.SEEK_TIME;
        }
        if (aVar == a.SELECT_VIDEO_COMPLETE) {
            aVar2 = a.SELECT_VIDEO;
        }
        if (aVar == a.SELECT_AUDIO_COMPLETE) {
            aVar2 = a.SELECT_AUDIO;
        }
        if (aVar == a.SELECT_SUBTITLE_COMPLETE) {
            aVar2 = a.SELECT_SUBTITLE;
        }
        if (aVar == a.PLAY_COMPLETE) {
            LogEx.d("[APP][Time]", "play complete time :" + currentTimeMillis + " ms");
            return;
        }
        String str2 = f3362b[aVar2.a()];
        HashMap<String, Long> hashMap = f3361a;
        if (hashMap == null || !hashMap.containsKey(str2) || f3361a.get(str2) == null) {
            return;
        }
        LogEx.d("[APP][Time]", str + " using time: " + (currentTimeMillis - f3361a.get(str2).longValue()) + " ms, current time: " + currentTimeMillis + " ms");
    }
}
