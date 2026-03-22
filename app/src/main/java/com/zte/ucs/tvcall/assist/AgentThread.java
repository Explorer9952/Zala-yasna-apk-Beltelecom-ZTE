package com.zte.ucs.tvcall.assist;

import android.os.Looper;
import android.os.Message;
import d.e.b.n.d;

/* loaded from: classes2.dex */
public class AgentThread {
    int depth;
    String mTag;
    int mpno;
    Thread ownLooperThread;
    Looper myLooper = null;
    a mLooperThreadHandler = null;

    public AgentThread(String str, int i) {
        this.ownLooperThread = null;
        this.mTag = "";
        this.mTag = str == null ? "" : str;
        this.mpno = i;
        b bVar = new b(this);
        this.ownLooperThread = bVar;
        bVar.setName(this.mTag);
        this.depth = 0;
    }

    public void postServiceMsg(int i) {
        a aVar = this.mLooperThreadHandler;
        if (aVar != null) {
            Message obtainMessage = aVar.obtainMessage(2, i, 1, null);
            d.c(this.mTag, "begin post PRO_SERVICE msgPtr:" + i);
            this.mLooperThreadHandler.sendMessage(obtainMessage);
        } else {
            d.d(this.mTag, "mLooperThreadHandler is null! can not send PRO_SERVICE msgPtr:" + i);
        }
        d.c(this.mTag, "done post PRO_SERVICE msgPtr:" + i);
    }

    public void startThread() {
        Thread thread = this.ownLooperThread;
        if (thread != null) {
            thread.start();
        }
    }

    public void stopThread() {
    }
}
