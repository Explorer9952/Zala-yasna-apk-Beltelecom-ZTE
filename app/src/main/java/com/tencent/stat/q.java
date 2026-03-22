package com.tencent.stat;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.stat.a.b f2906a;

    /* renamed from: b, reason: collision with root package name */
    private StatReportStrategy f2907b;

    /* renamed from: c, reason: collision with root package name */
    private h f2908c = new r(this);

    public q(com.tencent.stat.a.b bVar) {
        this.f2907b = null;
        this.f2906a = bVar;
        this.f2907b = c.q();
    }

    private void a() {
        if (t.c().a() <= 0) {
            a(true);
        } else {
            t.c().a(this.f2906a, (h) null);
            t.c().a(-1);
        }
    }

    private void a(boolean z) {
        j.b().a(this.f2906a, this.f2908c);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:31:0x00b2. Please report as an issue. */
    @Override // java.lang.Runnable
    public void run() {
        com.tencent.stat.i.b bVar;
        com.tencent.stat.i.b bVar2;
        com.tencent.stat.i.b bVar3;
        t b2;
        com.tencent.stat.a.b bVar4;
        com.tencent.stat.i.b bVar5;
        com.tencent.stat.i.b bVar6;
        com.tencent.stat.i.b bVar7;
        try {
            if (!c.u()) {
                return;
            }
            if (this.f2906a.a() != com.tencent.stat.a.f.ERROR && this.f2906a.d().length() > c.j()) {
                bVar7 = e.h;
                bVar7.c("Event length exceed StatConfig.getMaxReportEventLength(): " + c.j());
                return;
            }
            if (c.l() > 0) {
                if (c.f() >= c.l()) {
                    bVar6 = e.h;
                    bVar6.c("Times for reporting events has reached the limit of StatConfig.getMaxSessionStatReportCount() in current session.");
                    return;
                }
                c.c();
            }
            bVar2 = e.h;
            bVar2.e("Lauch stat task in thread:" + Thread.currentThread().getName());
            Context c2 = this.f2906a.c();
            s sVar = null;
            if (!com.tencent.stat.i.m.o(c2)) {
                t.b(c2).a(this.f2906a, (h) null);
                return;
            }
            if (c.t() && this.f2907b != StatReportStrategy.ONLY_WIFI_NO_CACHE && com.tencent.stat.i.m.n(c2)) {
                this.f2907b = StatReportStrategy.INSTANT;
            }
            switch (n.f2902a[this.f2907b.ordinal()]) {
                case 2:
                    if (!com.tencent.stat.i.m.l(c2)) {
                        b2 = t.b(c2);
                        bVar4 = this.f2906a;
                        b2.a(bVar4, sVar);
                        return;
                    }
                case 1:
                    a();
                    return;
                case 3:
                case 4:
                    b2 = t.b(c2);
                    bVar4 = this.f2906a;
                    b2.a(bVar4, sVar);
                    return;
                case 5:
                    if (t.b(this.f2906a.c()) == null) {
                        return;
                    }
                    b2 = t.b(c2);
                    bVar4 = this.f2906a;
                    sVar = new s(this);
                    b2.a(bVar4, sVar);
                    return;
                case 6:
                    try {
                        t.b(c2).a(this.f2906a, (h) null);
                        Long valueOf = Long.valueOf(com.tencent.stat.i.q.a(c2, "last_period_ts", 0L));
                        Long valueOf2 = Long.valueOf(System.currentTimeMillis());
                        if (Long.valueOf(Long.valueOf(valueOf2.longValue() - valueOf.longValue()).longValue() / 60000).longValue() > c.n()) {
                            t.b(c2).a(-1);
                            com.tencent.stat.i.q.b(c2, "last_period_ts", valueOf2.longValue());
                            return;
                        }
                        return;
                    } catch (Exception e) {
                        bVar3 = e.h;
                        bVar3.a(e);
                        return;
                    }
                case 7:
                    if (com.tencent.stat.i.m.l(c2)) {
                        a(false);
                        return;
                    }
                    return;
                default:
                    bVar5 = e.h;
                    bVar5.d("Invalid stat strategy:" + c.q());
                    return;
            }
        } catch (Throwable th) {
            bVar = e.h;
            bVar.c(th);
        }
    }
}
