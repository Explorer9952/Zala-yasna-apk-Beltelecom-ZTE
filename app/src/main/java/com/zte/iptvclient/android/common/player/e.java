package com.zte.iptvclient.android.common.player;

import android.view.MotionEvent;
import android.view.View;
import com.video.androidsdk.log.LogEx;

/* compiled from: OnDoubleClickListener.java */
/* loaded from: classes.dex */
public class e implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    private int f4876a = 0;

    /* renamed from: b, reason: collision with root package name */
    private long f4877b = 0;

    /* renamed from: c, reason: collision with root package name */
    private long f4878c = 0;

    /* renamed from: d, reason: collision with root package name */
    private a f4879d;

    /* compiled from: OnDoubleClickListener.java */
    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    public e(a aVar) {
        this.f4879d = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            LogEx.d("OnDoubleClickListener", "DoubleClickCallback ACTION_DOWN");
            int i = this.f4876a + 1;
            this.f4876a = i;
            if (1 == i) {
                this.f4877b = System.currentTimeMillis();
            } else if (2 == i) {
                long currentTimeMillis = System.currentTimeMillis();
                this.f4878c = currentTimeMillis;
                if (currentTimeMillis - this.f4877b < 500) {
                    this.f4876a = 0;
                    this.f4877b = 0L;
                    this.f4878c = 0L;
                    a aVar = this.f4879d;
                    if (aVar != null) {
                        aVar.a();
                        return true;
                    }
                } else {
                    LogEx.d("OnDoubleClickListener", "DoubleClick interval is too Time");
                    this.f4877b = this.f4878c;
                    this.f4876a = 1;
                }
                this.f4878c = 0L;
            }
        }
        return false;
    }
}
