package com.tencent.stat;

import android.content.Context;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private Context f2904a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, Integer> f2905b;

    public p(Context context, Map<String, Integer> map) {
        this.f2904a = null;
        this.f2905b = null;
        this.f2904a = context;
        if (map != null) {
            this.f2905b = map;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private b a(String str, int i) {
        com.tencent.stat.i.b bVar;
        com.tencent.stat.i.b bVar2;
        com.tencent.stat.i.b bVar3;
        int i2;
        com.tencent.stat.i.b bVar4;
        com.tencent.stat.i.b bVar5;
        b bVar6 = new b();
        Socket socket = new Socket();
        try {
            try {
                bVar6.a(str);
                bVar6.a(i);
                long currentTimeMillis = System.currentTimeMillis();
                InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
                socket.connect(inetSocketAddress, 30000);
                bVar6.a(System.currentTimeMillis() - currentTimeMillis);
                bVar6.b(inetSocketAddress.getAddress().getHostAddress());
                socket.close();
                try {
                    socket.close();
                } catch (Throwable th) {
                    bVar5 = e.h;
                    bVar5.c(th);
                }
                i2 = 0;
                socket = socket;
            } catch (IOException e) {
                bVar = e.h;
                bVar.a((Exception) e);
                try {
                    socket.close();
                    bVar3 = socket;
                } catch (Throwable th2) {
                    bVar2 = e.h;
                    bVar2.c(th2);
                    bVar3 = bVar2;
                }
                i2 = -1;
                socket = bVar3;
            }
            bVar6.b(i2);
            return bVar6;
        } catch (Throwable th3) {
            try {
                socket.close();
            } catch (Throwable th4) {
                bVar4 = e.h;
                bVar4.c(th4);
            }
            throw th3;
        }
    }

    private Map<String, Integer> a() {
        String str;
        com.tencent.stat.i.b bVar;
        HashMap hashMap = new HashMap();
        String a2 = c.a("__MTA_TEST_SPEED__", (String) null);
        if (a2 != null && a2.trim().length() != 0) {
            for (String str2 : a2.split(";")) {
                String[] split = str2.split(",");
                if (split != null && split.length == 2 && (str = split[0]) != null && str.trim().length() != 0) {
                    try {
                        hashMap.put(str, Integer.valueOf(Integer.valueOf(split[1]).intValue()));
                    } catch (NumberFormatException e) {
                        bVar = e.h;
                        bVar.a((Exception) e);
                    }
                }
            }
        }
        return hashMap;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.stat.i.b bVar;
        com.tencent.stat.i.b bVar2;
        com.tencent.stat.i.b bVar3;
        String str;
        try {
            if (com.tencent.stat.i.m.o(this.f2904a)) {
                if (this.f2905b == null) {
                    this.f2905b = a();
                }
                if (this.f2905b != null && this.f2905b.size() != 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry<String, Integer> entry : this.f2905b.entrySet()) {
                        String key = entry.getKey();
                        if (key != null && key.length() != 0) {
                            if (entry.getValue() == null) {
                                bVar3 = e.h;
                                str = "port is null for " + key;
                                bVar3.g(str);
                            } else {
                                jSONArray.put(a(entry.getKey(), entry.getValue().intValue()).a());
                            }
                        }
                        bVar3 = e.h;
                        str = "empty domain name.";
                        bVar3.g(str);
                    }
                    if (jSONArray.length() == 0) {
                        return;
                    }
                    com.tencent.stat.a.c cVar = new com.tencent.stat.a.c(this.f2904a, e.a(this.f2904a, false));
                    cVar.a(jSONArray.toString());
                    if (e.c(this.f2904a) != null) {
                        e.c(this.f2904a).post(new q(cVar));
                        return;
                    }
                    return;
                }
                bVar2 = e.h;
                bVar2.g("empty domain list.");
            }
        } catch (Throwable th) {
            bVar = e.h;
            bVar.c(th);
        }
    }
}
