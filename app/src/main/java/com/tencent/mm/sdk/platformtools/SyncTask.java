package com.tencent.mm.sdk.platformtools;

import android.os.Handler;

/* loaded from: classes.dex */
public abstract class SyncTask<R> {
    private final long ba;
    private long bb;
    private long bc;
    private Runnable bd;
    private Object lock;
    private R result;

    public SyncTask() {
        this(0L, null);
    }

    public SyncTask(long j, R r) {
        this.lock = new Object();
        this.bd = new Runnable() { // from class: com.tencent.mm.sdk.platformtools.SyncTask.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                SyncTask syncTask = SyncTask.this;
                syncTask.bc = Util.ticksToNow(syncTask.bb);
                SyncTask syncTask2 = SyncTask.this;
                syncTask2.setResult(syncTask2.run());
            }
        };
        this.ba = j;
        this.result = r;
    }

    public R exec(Handler handler) {
        if (handler == null) {
            Log.d("MicroMsg.SDK.SyncTask", "null handler, task in exec thread, return now");
            return run();
        }
        if (Thread.currentThread().getId() == handler.getLooper().getThread().getId()) {
            Log.d("MicroMsg.SDK.SyncTask", "same tid, task in exec thread, return now");
            return run();
        }
        this.bb = Util.currentTicks();
        handler.post(this.bd);
        try {
            synchronized (this.lock) {
                this.lock.wait(this.ba);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long ticksToNow = Util.ticksToNow(this.bb);
        StringBuilder sb = new StringBuilder();
        sb.append(this.result);
        Log.v("MicroMsg.SDK.SyncTask", "sync task done, return=%s, cost=%d(wait=%d, run=%d)", sb.toString(), Long.valueOf(ticksToNow), Long.valueOf(this.bc), Long.valueOf(ticksToNow - this.bc));
        return this.result;
    }

    protected abstract R run();

    public void setResult(R r) {
        this.result = r;
        synchronized (this.lock) {
            this.lock.notify();
        }
    }
}
