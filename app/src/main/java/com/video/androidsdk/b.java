package com.video.androidsdk;

import android.content.Context;
import com.video.androidsdk.log.LogEx;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: ThreadPoolMgr.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3034a = "b";

    /* renamed from: b, reason: collision with root package name */
    private static volatile b f3035b;
    private int g;
    private ExecutorService h;
    private int e = 10;
    private int f = 3;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, ExecutorService> f3036c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private Map<String, Integer> f3037d = new HashMap();
    private Object i = new Object();

    public static b a() {
        if (f3035b == null) {
            f3035b = new b();
        }
        return f3035b;
    }

    public synchronized void a(Context context) {
        for (Map.Entry<String, ExecutorService> entry : this.f3036c.entrySet()) {
            ExecutorService value = entry.getValue();
            if (value != null) {
                synchronized (this.i) {
                    LogEx.i(f3034a, "Shutdown threadpool[" + entry.getKey() + "]");
                    value.shutdownNow();
                }
            }
        }
        this.f3036c.clear();
        this.g = 0;
        for (Map.Entry<String, Integer> entry2 : this.f3037d.entrySet()) {
            String key = entry2.getKey();
            int intValue = entry2.getValue().intValue();
            if (intValue > 0) {
                if (this.e > 0) {
                    if (this.g + intValue <= this.e) {
                        this.g += intValue;
                    } else {
                        if (this.g >= this.e) {
                            break;
                        }
                        int i = this.e;
                        this.g = i;
                        intValue = this.e - i;
                    }
                }
                try {
                    this.f3036c.put(key, Executors.newFixedThreadPool(intValue));
                } catch (IllegalArgumentException e) {
                    LogEx.d(f3034a, "Failed to create threadpool[" + key + "] " + intValue + " " + e.getMessage());
                }
            }
        }
    }

    public synchronized ExecutorService a(String str, int i) {
        ExecutorService executorService;
        this.f3037d.put(str, Integer.valueOf(i));
        if (this.f3036c.containsKey(str) && (executorService = this.f3036c.get(str)) != null) {
            return executorService;
        }
        synchronized (this.f3036c) {
            if (this.g + i <= this.e) {
                this.g += i;
            } else if (this.g < this.e) {
                int i2 = this.e;
                this.g = i2;
                i = this.e - i2;
            } else {
                if (this.h == null) {
                    this.h = Executors.newFixedThreadPool(this.f);
                }
                return this.h;
            }
            try {
                ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(i);
                this.f3036c.put(str, newFixedThreadPool);
                return newFixedThreadPool;
            } catch (IllegalArgumentException e) {
                LogEx.d(f3034a, "Failed to create threadpool[" + str + "] " + i + " " + e.getMessage());
                return null;
            }
        }
    }

    public synchronized void a(String str) {
        ExecutorService executorService;
        if (this.f3036c.containsKey(str) && (executorService = this.f3036c.get(str)) != null) {
            synchronized (this.i) {
                LogEx.d(f3034a, "Shutdown threadpool[" + str + "]");
                executorService.shutdownNow();
            }
        }
    }
}
