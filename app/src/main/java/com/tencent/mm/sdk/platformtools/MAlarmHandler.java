package com.tencent.mm.sdk.platformtools;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import junit.framework.Assert;

/* loaded from: classes.dex */
public class MAlarmHandler {
    public static final long NEXT_FIRE_INTERVAL = Long.MAX_VALUE;
    private static IBumper aC;
    private static int av;
    private final CallBack aB;
    private final int aw;
    private final boolean ax;
    private long ay = 0;
    private long az = 0;
    private static Map<Integer, MAlarmHandler> aA = new HashMap();
    private static boolean aD = false;

    /* loaded from: classes.dex */
    public interface CallBack {
        boolean onTimerExpired();
    }

    /* loaded from: classes.dex */
    public interface IBumper {
        void cancel();

        void prepare();
    }

    public MAlarmHandler(CallBack callBack, boolean z) {
        Assert.assertTrue("bumper not initialized", aD);
        this.aB = callBack;
        this.ax = z;
        if (av >= 8192) {
            av = 0;
        }
        int i = av + 1;
        av = i;
        this.aw = i;
    }

    public static long fire() {
        IBumper iBumper;
        LinkedList linkedList = new LinkedList();
        HashSet<Integer> hashSet = new HashSet();
        hashSet.addAll(aA.keySet());
        long j = Long.MAX_VALUE;
        for (Integer num : hashSet) {
            MAlarmHandler mAlarmHandler = aA.get(num);
            if (mAlarmHandler != null) {
                long ticksToNow = Util.ticksToNow(mAlarmHandler.ay);
                if (ticksToNow < 0) {
                    ticksToNow = 0;
                }
                long j2 = mAlarmHandler.az;
                if (ticksToNow > j2) {
                    if (mAlarmHandler.aB.onTimerExpired() && mAlarmHandler.ax) {
                        j = mAlarmHandler.az;
                    } else {
                        linkedList.add(num);
                    }
                    mAlarmHandler.ay = Util.currentTicks();
                } else if (j2 - ticksToNow < j) {
                    j = j2 - ticksToNow;
                }
            }
        }
        for (int i = 0; i < linkedList.size(); i++) {
            aA.remove(linkedList.get(i));
        }
        if (j == Long.MAX_VALUE && (iBumper = aC) != null) {
            iBumper.cancel();
            Log.v("MicroMsg.MAlarmHandler", "cancel bumper for no more handler");
        }
        return j;
    }

    public static void initAlarmBumper(IBumper iBumper) {
        aD = true;
        aC = iBumper;
    }

    protected void finalize() {
        stopTimer();
        super.finalize();
    }

    public void startTimer(long j) {
        this.az = j;
        this.ay = Util.currentTicks();
        long j2 = this.az;
        Log.d("MicroMsg.MAlarmHandler", "check need prepare: check=" + j2);
        Iterator<Map.Entry<Integer, MAlarmHandler>> it2 = aA.entrySet().iterator();
        long j3 = Long.MAX_VALUE;
        while (it2.hasNext()) {
            MAlarmHandler value = it2.next().getValue();
            if (value != null) {
                long ticksToNow = Util.ticksToNow(value.ay);
                if (ticksToNow < 0) {
                    ticksToNow = 0;
                }
                long j4 = value.az;
                if (ticksToNow <= j4) {
                    if (j4 - ticksToNow < j3) {
                        j4 -= ticksToNow;
                    }
                }
                j3 = j4;
            }
        }
        boolean z = j3 > j2;
        stopTimer();
        aA.put(Integer.valueOf(this.aw), this);
        if (aC == null || !z) {
            return;
        }
        Log.v("MicroMsg.MAlarmHandler", "prepare bumper");
        aC.prepare();
    }

    public void stopTimer() {
        aA.remove(Integer.valueOf(this.aw));
    }

    public boolean stopped() {
        return !aA.containsKey(Integer.valueOf(this.aw));
    }
}
