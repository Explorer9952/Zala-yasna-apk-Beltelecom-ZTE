package com.video.androidsdk.common;

import android.os.Looper;
import com.video.androidsdk.common.util.SessionUtil;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.log.LogEx;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public final class TimerMgr {
    public static final String LOG_TAG = "TimerMgr";
    private Map<String, TimerTask> mmapTimerTasks;
    private static final Timer m_tmrTimer = new Timer();
    private static TimerMgr m_tmMgr = null;

    /* loaded from: classes.dex */
    public interface ITimerMgr {
        void onTimer(String str);
    }

    private TimerMgr() {
        this.mmapTimerTasks = null;
        this.mmapTimerTasks = new HashMap();
    }

    public static TimerMgr getInstance() {
        synchronized (TimerMgr.class) {
            if (m_tmMgr != null) {
                return m_tmMgr;
            }
            TimerMgr timerMgr = new TimerMgr();
            m_tmMgr = timerMgr;
            return timerMgr;
        }
    }

    public String start(int i, ITimerMgr iTimerMgr) {
        return start(i, 0, iTimerMgr);
    }

    public String startRepeatTimer(final String str, int i, final ITimerMgr iTimerMgr) {
        if (i <= 0) {
            LogEx.w(LOG_TAG, "iIntervalSeconds is invalid," + i);
            return null;
        }
        if (iTimerMgr == null) {
            LogEx.w(LOG_TAG, "instance is null.");
            return null;
        }
        if (str == null) {
            LogEx.d(LOG_TAG, "strSessionID is null,create it.");
            str = SessionUtil.genSessionID();
        }
        LogEx.d(LOG_TAG, "start time,strSessionID=" + str + ", iIntervalSeconds=" + i);
        TimerTask timerTask = new TimerTask() { // from class: com.video.androidsdk.common.TimerMgr.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
                iTimerMgr.onTimer(str);
            }
        };
        long j = (long) i;
        m_tmrTimer.schedule(timerTask, j, j);
        synchronized (this.mmapTimerTasks) {
            this.mmapTimerTasks.put(str, timerTask);
        }
        return str;
    }

    public int stop(String str) {
        LogEx.d(LOG_TAG, "strSessionID=" + str);
        if (StringUtil.isEmptyString(str)) {
            LogEx.w(LOG_TAG, "strSessionID is empty!");
            return 1;
        }
        synchronized (this.mmapTimerTasks) {
            TimerTask remove = this.mmapTimerTasks.remove(str);
            if (remove != null) {
                remove.cancel();
                m_tmrTimer.purge();
                return 0;
            }
            LogEx.w(LOG_TAG, "Failed to get timer by strSessionID=" + str);
            return 2;
        }
    }

    public void stopAll() {
        LogEx.d(LOG_TAG, "enter.");
        synchronized (this.mmapTimerTasks) {
            Iterator<TimerTask> it2 = this.mmapTimerTasks.values().iterator();
            while (it2.hasNext()) {
                it2.next().cancel();
            }
            m_tmrTimer.purge();
            this.mmapTimerTasks.clear();
        }
    }

    public String start(int i, int i2, ITimerMgr iTimerMgr) {
        return start(null, i, i2, iTimerMgr);
    }

    public String start(String str, int i, ITimerMgr iTimerMgr) {
        return start(str, i, 0, iTimerMgr);
    }

    public String start(final String str, int i, int i2, final ITimerMgr iTimerMgr) {
        if (iTimerMgr == null) {
            LogEx.d(LOG_TAG, "Nothing to do!Ignore.");
            return null;
        }
        LogEx.d(LOG_TAG, "[start]delay=" + i + ", interval=" + i2);
        if (str == null) {
            LogEx.d(LOG_TAG, "strSessionID is null,create it.");
            str = SessionUtil.genSessionID();
        }
        if (i <= 0) {
            i = 0;
        }
        if (i2 <= 0) {
            i2 = 0;
        }
        TimerTask timerTask = new TimerTask() { // from class: com.video.androidsdk.common.TimerMgr.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
                LogEx.d(TimerMgr.LOG_TAG, "run timeout method,strSessionID=" + str);
                iTimerMgr.onTimer(str);
            }
        };
        if (i2 > 0) {
            m_tmrTimer.schedule(timerTask, i, i2);
        } else {
            m_tmrTimer.schedule(timerTask, i);
        }
        synchronized (this.mmapTimerTasks) {
            this.mmapTimerTasks.put(str, timerTask);
        }
        return str;
    }
}
