package pl.droidsonroids.gif;

/* loaded from: classes2.dex */
class ConditionVariable {
    private volatile boolean mCondition;

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void block() throws InterruptedException {
        while (!this.mCondition) {
            wait();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void close() {
        synchronized (this) {
            this.mCondition = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void open() {
        synchronized (this) {
            boolean z = this.mCondition;
            this.mCondition = true;
            if (!z) {
                notify();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void set(boolean z) {
        if (z) {
            open();
        } else {
            close();
        }
    }
}
