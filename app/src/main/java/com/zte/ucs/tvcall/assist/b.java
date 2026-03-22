package com.zte.ucs.tvcall.assist;

import android.os.Looper;
import d.e.b.n.d;

/* loaded from: classes2.dex */
final class b extends Thread {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AgentThread f7956a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AgentThread agentThread) {
        this.f7956a = agentThread;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Looper.prepare();
        this.f7956a.myLooper = Looper.myLooper();
        AgentThread agentThread = this.f7956a;
        AgentThread agentThread2 = this.f7956a;
        agentThread.mLooperThreadHandler = new a(agentThread2, agentThread2.myLooper);
        this.f7956a.mLooperThreadHandler.removeMessages(0);
        d.a(this.f7956a.mTag, "begin run!");
        this.f7956a.mLooperThreadHandler.sendMessage(this.f7956a.mLooperThreadHandler.obtainMessage(1, 1, 1, null));
        Looper.loop();
    }
}
