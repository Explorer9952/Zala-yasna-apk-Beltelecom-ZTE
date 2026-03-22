package com.bumptech.glide.load.engine.executor;

import android.os.Process;
import android.util.Log;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class FifoPriorityThreadPoolExecutor extends ThreadPoolExecutor {

    private final AtomicInteger ordering;
    private final UncaughtThrowableStrategy uncaughtThrowableStrategy;

    public enum UncaughtThrowableStrategy {
        IGNORE,
        LOG {
            @Override
            protected void handle(Throwable th) {
                if (Log.isLoggable("PriorityExecutor", 6)) {
                    Log.e("PriorityExecutor", "Request threw uncaught throwable", th);
                }
            }
        },
        THROW {
            @Override
            protected void handle(Throwable th) {
                super.handle(th);
                throw new RuntimeException(th);
            }
        };

        protected void handle(Throwable th) {
            // Реализация по умолчанию (используется для IGNORE)
        }
    }

    public static class DefaultThreadFactory implements ThreadFactory {
        private int threadNum = 0;

        @Override
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "fifo-pool-thread-" + this.threadNum) {
                @Override
                public void run() {
                    Process.setThreadPriority(10); // Process.THREAD_PRIORITY_BACKGROUND
                    super.run();
                }
            };
            this.threadNum++;
            return thread;
        }
    }

    static class LoadTask<T> extends FutureTask<T> implements Comparable<LoadTask<?>> {
        private final int priority;
        private final int order;

        public LoadTask(Runnable runnable, T t, int order) {
            super(runnable, t);
            // Примечание: 'a' здесь ссылается на интерфейс Prioritized библиотеки Glide,
            // который был обфусцирован/декомпилирован как 'a'.
            if (runnable instanceof com.bumptech.glide.load.engine.executor.a) {
                this.priority = ((com.bumptech.glide.load.engine.executor.a) runnable).a();
                this.order = order;
            } else {
                throw new IllegalArgumentException("FifoPriorityThreadPoolExecutor must be given Runnables that implement Prioritized");
            }
        }

        @Override
        public int compareTo(LoadTask<?> other) {
            int result = this.priority - other.priority;
            return result == 0 ? this.order - other.order : result;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof LoadTask)) {
                return false;
            }
            LoadTask<?> other = (LoadTask<?>) obj;
            return this.order == other.order && this.priority == other.priority;
        }

        @Override
        public int hashCode() {
            return (this.priority * 31) + this.order;
        }
    }

    public FifoPriorityThreadPoolExecutor(int poolSize) {
        this(poolSize, UncaughtThrowableStrategy.LOG);
    }

    public FifoPriorityThreadPoolExecutor(int poolSize, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        this(poolSize, poolSize, 0L, TimeUnit.MILLISECONDS, new DefaultThreadFactory(), uncaughtThrowableStrategy);
    }

    public FifoPriorityThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit timeUnit, ThreadFactory threadFactory, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, timeUnit, new PriorityBlockingQueue<Runnable>(), threadFactory);
        this.ordering = new AtomicInteger();
        this.uncaughtThrowableStrategy = uncaughtThrowableStrategy;
    }

    @Override
    protected void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (th == null && (runnable instanceof Future)) {
            Future<?> future = (Future<?>) runnable;
            if (future.isDone() && !future.isCancelled()) {
                try {
                    future.get();
                } catch (InterruptedException | ExecutionException e) {
                    this.uncaughtThrowableStrategy.handle(e);
                }
            }
        }
    }

    @Override
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new LoadTask<>(runnable, t, this.ordering.getAndIncrement());
    }
}