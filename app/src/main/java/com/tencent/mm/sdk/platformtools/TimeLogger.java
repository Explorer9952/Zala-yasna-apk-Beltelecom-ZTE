package com.tencent.mm.sdk.platformtools;

import android.os.SystemClock;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class TimeLogger {
    private String bg;
    private String bh;
    private boolean bi;
    ArrayList<Long> bj;
    ArrayList<String> bk;

    public TimeLogger(String str, String str2) {
        reset(str, str2);
    }

    public void addSplit(String str) {
        if (this.bi) {
            return;
        }
        this.bj.add(Long.valueOf(SystemClock.elapsedRealtime()));
        this.bk.add(str);
    }

    public void dumpToLog() {
        if (this.bi) {
            return;
        }
        Log.d(this.bg, this.bh + ": begin");
        long longValue = this.bj.get(0).longValue();
        long j = longValue;
        for (int i = 1; i < this.bj.size(); i++) {
            j = this.bj.get(i).longValue();
            String str = this.bk.get(i);
            long longValue2 = this.bj.get(i - 1).longValue();
            Log.d(this.bg, this.bh + ":      " + (j - longValue2) + " ms, " + str);
        }
        Log.d(this.bg, this.bh + ": end, " + (j - longValue) + " ms");
    }

    public void reset() {
        this.bi = false;
        if (0 != 0) {
            return;
        }
        ArrayList<Long> arrayList = this.bj;
        if (arrayList == null) {
            this.bj = new ArrayList<>();
            this.bk = new ArrayList<>();
        } else {
            arrayList.clear();
            this.bk.clear();
        }
        addSplit(null);
    }

    public void reset(String str, String str2) {
        this.bg = str;
        this.bh = str2;
        reset();
    }
}
