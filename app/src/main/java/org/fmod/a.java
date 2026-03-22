package org.fmod;

import android.media.AudioRecord;
import android.util.Log;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final FMODAudioDevice f8612a;

    /* renamed from: b, reason: collision with root package name */
    private final ByteBuffer f8613b;

    /* renamed from: c, reason: collision with root package name */
    private final int f8614c;

    /* renamed from: d, reason: collision with root package name */
    private final int f8615d;
    private final int e = 2;
    private volatile Thread f;
    private volatile boolean g;
    private AudioRecord h;
    private boolean i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(FMODAudioDevice fMODAudioDevice, int i, int i2) {
        this.f8612a = fMODAudioDevice;
        this.f8614c = i;
        this.f8615d = i2;
        this.f8613b = ByteBuffer.allocateDirect(AudioRecord.getMinBufferSize(i, i2, 2));
    }

    private void d() {
        AudioRecord audioRecord = this.h;
        if (audioRecord != null) {
            if (audioRecord.getState() == 1) {
                this.h.stop();
            }
            this.h.release();
            this.h = null;
        }
        this.f8613b.position(0);
        this.i = false;
    }

    public final int a() {
        return this.f8613b.capacity();
    }

    public final void b() {
        if (this.f != null) {
            c();
        }
        this.g = true;
        this.f = new Thread(this);
        this.f.start();
    }

    public final void c() {
        while (this.f != null) {
            this.g = false;
            try {
                this.f.join();
                this.f = null;
            } catch (InterruptedException unused) {
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = 3;
        while (this.g) {
            if (!this.i && i > 0) {
                d();
                AudioRecord audioRecord = new AudioRecord(1, this.f8614c, this.f8615d, this.e, this.f8613b.capacity());
                this.h = audioRecord;
                boolean z = audioRecord.getState() == 1;
                this.i = z;
                if (z) {
                    this.f8613b.position(0);
                    this.h.startRecording();
                    i = 3;
                } else {
                    Log.e("FMOD", "AudioRecord failed to initialize (status " + this.h.getState() + ")");
                    i += -1;
                    d();
                }
            }
            if (this.i && this.h.getRecordingState() == 3) {
                AudioRecord audioRecord2 = this.h;
                ByteBuffer byteBuffer = this.f8613b;
                this.f8612a.fmodProcessMicData(this.f8613b, audioRecord2.read(byteBuffer, byteBuffer.capacity()));
                this.f8613b.position(0);
            }
        }
        d();
    }
}
