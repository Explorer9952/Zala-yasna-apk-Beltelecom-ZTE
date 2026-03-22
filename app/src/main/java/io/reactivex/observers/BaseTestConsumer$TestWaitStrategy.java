package io.reactivex.observers;

/* loaded from: classes2.dex */
public enum BaseTestConsumer$TestWaitStrategy implements Runnable {
    SPIN { // from class: io.reactivex.observers.BaseTestConsumer$TestWaitStrategy.a
        @Override // io.reactivex.observers.BaseTestConsumer$TestWaitStrategy, java.lang.Runnable
        public void run() {
        }
    },
    YIELD { // from class: io.reactivex.observers.BaseTestConsumer$TestWaitStrategy.b
        @Override // io.reactivex.observers.BaseTestConsumer$TestWaitStrategy, java.lang.Runnable
        public void run() {
            Thread.yield();
        }
    },
    SLEEP_1MS { // from class: io.reactivex.observers.BaseTestConsumer$TestWaitStrategy.c
        @Override // io.reactivex.observers.BaseTestConsumer$TestWaitStrategy, java.lang.Runnable
        public void run() {
            BaseTestConsumer$TestWaitStrategy.sleep(1);
        }
    },
    SLEEP_10MS { // from class: io.reactivex.observers.BaseTestConsumer$TestWaitStrategy.d
        @Override // io.reactivex.observers.BaseTestConsumer$TestWaitStrategy, java.lang.Runnable
        public void run() {
            BaseTestConsumer$TestWaitStrategy.sleep(10);
        }
    },
    SLEEP_100MS { // from class: io.reactivex.observers.BaseTestConsumer$TestWaitStrategy.e
        @Override // io.reactivex.observers.BaseTestConsumer$TestWaitStrategy, java.lang.Runnable
        public void run() {
            BaseTestConsumer$TestWaitStrategy.sleep(100);
        }
    },
    SLEEP_1000MS { // from class: io.reactivex.observers.BaseTestConsumer$TestWaitStrategy.f
        @Override // io.reactivex.observers.BaseTestConsumer$TestWaitStrategy, java.lang.Runnable
        public void run() {
            BaseTestConsumer$TestWaitStrategy.sleep(1000);
        }
    };

    static void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // java.lang.Runnable
    public abstract void run();
}
