package com.zte.ucs.tvcall.assist;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import d.e.b.n.d;

/* loaded from: classes2.dex */
final class a extends Handler {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AgentThread f7955a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AgentThread agentThread, Looper looper) {
        super(looper);
        this.f7955a = agentThread;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        d.a(this.f7955a.mTag, "message.what :" + message.what);
        int i = message.what;
        if (i == 1) {
            d.a(this.f7955a.mTag, "setPCBThreadid begin:" + this.f7955a.mpno);
            Native.JNIStartPCB(this.f7955a.mpno);
            d.a(this.f7955a.mTag, "setPCBThreadid end:" + this.f7955a.mpno);
            return;
        }
        if (i != 2) {
            d.d(this.f7955a.mTag, "get unknown event:" + message.what + " arg1:" + message.arg1);
            return;
        }
        AgentThread agentThread = this.f7955a;
        agentThread.depth++;
        d.a(agentThread.mTag, "call Service[" + this.f7955a.mpno + "]Interface msgPtr[" + message.arg1 + "] begin by depth:" + this.f7955a.depth);
        Native.ServieInterface(this.f7955a.mpno, message.arg1);
        AgentThread agentThread2 = this.f7955a;
        agentThread2.depth = agentThread2.depth - 1;
        d.a(agentThread2.mTag, "call Service[" + this.f7955a.mpno + "]Interface msgPtr[" + message.arg1 + "] end by depth:" + this.f7955a.depth);
    }
}
