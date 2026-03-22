package com.tencent.mm.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class LRUMap<K, O> {

    /* renamed from: c, reason: collision with root package name */
    private Map<K, LRUMap<K, O>.TimeVal<O>> f2819c;

    /* renamed from: d, reason: collision with root package name */
    private int f2820d;
    private int e;
    private PreRemoveCallback<K, O> f;

    /* loaded from: classes.dex */
    public interface OnClearListener<K, O> {
        void onClear(K k, O o);
    }

    /* loaded from: classes.dex */
    public interface PreRemoveCallback<K, O> {
        void preRemoveCallback(K k, O o);
    }

    /* loaded from: classes.dex */
    public class TimeVal<OO> {
        public OO obj;
        public Long t;

        public TimeVal(OO oo) {
            this.obj = oo;
            UpTime();
        }

        public void UpTime() {
            this.t = Long.valueOf(System.currentTimeMillis());
        }
    }

    public LRUMap(int i) {
        this(i, null);
    }

    public LRUMap(int i, PreRemoveCallback<K, O> preRemoveCallback) {
        this.f2819c = null;
        this.f = null;
        this.f2820d = i;
        this.e = 0;
        this.f = preRemoveCallback;
        this.f2819c = new HashMap();
    }

    public boolean check(K k) {
        return this.f2819c.containsKey(k);
    }

    public boolean checkAndUpTime(K k) {
        if (!this.f2819c.containsKey(k)) {
            return false;
        }
        this.f2819c.get(k).UpTime();
        return true;
    }

    public void clear() {
        this.f2819c.clear();
    }

    public void clear(OnClearListener<K, O> onClearListener) {
        Map<K, LRUMap<K, O>.TimeVal<O>> map = this.f2819c;
        if (map != null) {
            if (onClearListener != null) {
                for (Map.Entry<K, LRUMap<K, O>.TimeVal<O>> entry : map.entrySet()) {
                    onClearListener.onClear(entry.getKey(), entry.getValue().obj);
                }
            }
            this.f2819c.clear();
        }
    }

    public O get(K k) {
        LRUMap<K, O>.TimeVal<O> timeVal = this.f2819c.get(k);
        if (timeVal == null) {
            return null;
        }
        return timeVal.obj;
    }

    public O getAndUptime(K k) {
        LRUMap<K, O>.TimeVal<O> timeVal = this.f2819c.get(k);
        if (timeVal == null) {
            return null;
        }
        this.f2819c.get(k).UpTime();
        return timeVal.obj;
    }

    public void remove(K k) {
        if (this.f2819c.containsKey(k)) {
            PreRemoveCallback<K, O> preRemoveCallback = this.f;
            if (preRemoveCallback != null) {
                preRemoveCallback.preRemoveCallback(k, this.f2819c.get(k).obj);
            }
            this.f2819c.remove(k);
        }
    }

    public void setMaxSize(int i) {
        if (i > 0) {
            this.f2820d = i;
        }
    }

    public void setPerDeleteSize(int i) {
        if (i > 0) {
            this.e = i;
        }
    }

    public int size() {
        return this.f2819c.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void update(K k, O o) {
        if (this.f2819c.get(k) != null) {
            this.f2819c.get(k).UpTime();
            this.f2819c.get(k).obj = o;
            return;
        }
        this.f2819c.put(k, new TimeVal<>(o));
        if (this.f2819c.size() > this.f2820d) {
            ArrayList arrayList = new ArrayList(this.f2819c.entrySet());
            Collections.sort(arrayList, new Comparator<Map.Entry<K, LRUMap<K, O>.TimeVal<O>>>() { // from class: com.tencent.mm.algorithm.LRUMap.1
                @Override // java.util.Comparator
                public int compare(Map.Entry<K, LRUMap<K, O>.TimeVal<O>> entry, Map.Entry<K, LRUMap<K, O>.TimeVal<O>> entry2) {
                    return entry.getValue().t.compareTo(entry2.getValue().t);
                }
            });
            int i = this.e;
            if (i <= 0 && (i = this.f2820d / 10) <= 0) {
                i = 1;
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                remove(((Map.Entry) it2.next()).getKey());
                i--;
                if (i <= 0) {
                    return;
                }
            }
        }
    }
}
