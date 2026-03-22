package b.e.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.facebook.internal.logging.monitor.MonitorLogServerProtocol;
import com.zte.ucs.tvcall.Commons;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* compiled from: LocalBroadcastManager.java */
/* loaded from: classes.dex */
public final class a {
    private static final Object f = new Object();
    private static a g;

    /* renamed from: a, reason: collision with root package name */
    private final Context f1842a;

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<BroadcastReceiver, ArrayList<c>> f1843b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private final HashMap<String, ArrayList<c>> f1844c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private final ArrayList<b> f1845d = new ArrayList<>();
    private final Handler e;

    /* compiled from: LocalBroadcastManager.java */
    /* renamed from: b.e.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class HandlerC0057a extends Handler {
        HandlerC0057a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                a.this.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LocalBroadcastManager.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        final Intent f1847a;

        /* renamed from: b, reason: collision with root package name */
        final ArrayList<c> f1848b;

        b(Intent intent, ArrayList<c> arrayList) {
            this.f1847a = intent;
            this.f1848b = arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LocalBroadcastManager.java */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        final IntentFilter f1849a;

        /* renamed from: b, reason: collision with root package name */
        final BroadcastReceiver f1850b;

        /* renamed from: c, reason: collision with root package name */
        boolean f1851c;

        /* renamed from: d, reason: collision with root package name */
        boolean f1852d;

        c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f1849a = intentFilter;
            this.f1850b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(Commons.MSG_MCSP_INIT_SUCCESS);
            sb.append("Receiver{");
            sb.append(this.f1850b);
            sb.append(" filter=");
            sb.append(this.f1849a);
            if (this.f1852d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    private a(Context context) {
        this.f1842a = context;
        this.e = new HandlerC0057a(context.getMainLooper());
    }

    public static a a(Context context) {
        a aVar;
        synchronized (f) {
            if (g == null) {
                g = new a(context.getApplicationContext());
            }
            aVar = g;
        }
        return aVar;
    }

    public void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f1843b) {
            c cVar = new c(intentFilter, broadcastReceiver);
            ArrayList<c> arrayList = this.f1843b.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.f1843b.put(broadcastReceiver, arrayList);
            }
            arrayList.add(cVar);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList<c> arrayList2 = this.f1844c.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.f1844c.put(action, arrayList2);
                }
                arrayList2.add(cVar);
            }
        }
    }

    public void a(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f1843b) {
            ArrayList<c> remove = this.f1843b.remove(broadcastReceiver);
            if (remove == null) {
                return;
            }
            for (int size = remove.size() - 1; size >= 0; size--) {
                c cVar = remove.get(size);
                cVar.f1852d = true;
                for (int i = 0; i < cVar.f1849a.countActions(); i++) {
                    String action = cVar.f1849a.getAction(i);
                    ArrayList<c> arrayList = this.f1844c.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            c cVar2 = arrayList.get(size2);
                            if (cVar2.f1850b == broadcastReceiver) {
                                cVar2.f1852d = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.f1844c.remove(action);
                        }
                    }
                }
            }
        }
    }

    public boolean a(Intent intent) {
        int i;
        String str;
        ArrayList arrayList;
        ArrayList<c> arrayList2;
        String str2;
        synchronized (this.f1843b) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f1842a.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                Log.v("LocalBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<c> arrayList3 = this.f1844c.get(intent.getAction());
            if (arrayList3 != null) {
                if (z) {
                    Log.v("LocalBroadcastManager", "Action list: " + arrayList3);
                }
                ArrayList arrayList4 = null;
                int i2 = 0;
                while (i2 < arrayList3.size()) {
                    c cVar = arrayList3.get(i2);
                    if (z) {
                        Log.v("LocalBroadcastManager", "Matching against filter " + cVar.f1849a);
                    }
                    if (cVar.f1851c) {
                        if (z) {
                            Log.v("LocalBroadcastManager", "  Filter's target already added");
                        }
                        i = i2;
                        arrayList2 = arrayList3;
                        str = action;
                        str2 = resolveTypeIfNeeded;
                        arrayList = arrayList4;
                    } else {
                        i = i2;
                        str = action;
                        arrayList = arrayList4;
                        arrayList2 = arrayList3;
                        str2 = resolveTypeIfNeeded;
                        int match = cVar.f1849a.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (match >= 0) {
                            if (z) {
                                Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                            }
                            arrayList4 = arrayList == null ? new ArrayList() : arrayList;
                            arrayList4.add(cVar);
                            cVar.f1851c = true;
                            i2 = i + 1;
                            action = str;
                            arrayList3 = arrayList2;
                            resolveTypeIfNeeded = str2;
                        } else if (z) {
                            Log.v("LocalBroadcastManager", "  Filter did not match: " + (match != -4 ? match != -3 ? match != -2 ? match != -1 ? "unknown reason" : "type" : "data" : "action" : MonitorLogServerProtocol.PARAM_CATEGORY));
                        }
                    }
                    arrayList4 = arrayList;
                    i2 = i + 1;
                    action = str;
                    arrayList3 = arrayList2;
                    resolveTypeIfNeeded = str2;
                }
                ArrayList arrayList5 = arrayList4;
                if (arrayList5 != null) {
                    for (int i3 = 0; i3 < arrayList5.size(); i3++) {
                        ((c) arrayList5.get(i3)).f1851c = false;
                    }
                    this.f1845d.add(new b(intent, arrayList5));
                    if (!this.e.hasMessages(1)) {
                        this.e.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    void a() {
        int size;
        b[] bVarArr;
        while (true) {
            synchronized (this.f1843b) {
                size = this.f1845d.size();
                if (size <= 0) {
                    return;
                }
                bVarArr = new b[size];
                this.f1845d.toArray(bVarArr);
                this.f1845d.clear();
            }
            for (int i = 0; i < size; i++) {
                b bVar = bVarArr[i];
                int size2 = bVar.f1848b.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    c cVar = bVar.f1848b.get(i2);
                    if (!cVar.f1852d) {
                        cVar.f1850b.onReceive(this.f1842a, bVar.f1847a);
                    }
                }
            }
        }
    }
}
