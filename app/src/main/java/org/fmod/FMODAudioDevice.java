package org.fmod;

import android.media.AudioTrack;
import android.util.Log;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class FMODAudioDevice implements Runnable {
    private static int h = 0;
    private static int i = 1;
    private static int j = 2;
    private static int k = 3;

    /* renamed from: a, reason: collision with root package name */
    private volatile Thread f8608a = null;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f8609b = false;

    /* renamed from: c, reason: collision with root package name */
    private AudioTrack f8610c = null;

    /* renamed from: d, reason: collision with root package name */
    private boolean f8611d = false;
    private ByteBuffer e = null;
    private byte[] f = null;
    private volatile a g;

    private native int fmodGetInfo(int i2);

    private native int fmodProcess(ByteBuffer byteBuffer);

    private void releaseAudioTrack() {
        AudioTrack audioTrack = this.f8610c;
        if (audioTrack != null) {
            if (audioTrack.getState() == 1) {
                this.f8610c.stop();
            }
            this.f8610c.release();
            this.f8610c = null;
        }
        this.e = null;
        this.f = null;
        this.f8611d = false;
    }

    public synchronized void close() {
        stop();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public native int fmodProcessMicData(ByteBuffer byteBuffer, int i2);

    public boolean isRunning() {
        return this.f8608a != null && this.f8608a.isAlive();
    }

    @Override // java.lang.Runnable
    public void run() {
        int i2 = 3;
        while (this.f8609b) {
            if (!this.f8611d && i2 > 0) {
                releaseAudioTrack();
                int fmodGetInfo = fmodGetInfo(h);
                int round = Math.round(AudioTrack.getMinBufferSize(fmodGetInfo, 3, 2) * 1.1f) & (-4);
                int fmodGetInfo2 = fmodGetInfo(i);
                int fmodGetInfo3 = fmodGetInfo(j) * fmodGetInfo2 * 4;
                AudioTrack audioTrack = new AudioTrack(3, fmodGetInfo, 3, 2, fmodGetInfo3 > round ? fmodGetInfo3 : round, 1);
                this.f8610c = audioTrack;
                boolean z = audioTrack.getState() == 1;
                this.f8611d = z;
                if (z) {
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fmodGetInfo2 * 2 * 2);
                    this.e = allocateDirect;
                    this.f = new byte[allocateDirect.capacity()];
                    this.f8610c.play();
                    i2 = 3;
                } else {
                    Log.e("FMOD", "AudioTrack failed to initialize (status " + this.f8610c.getState() + ")");
                    releaseAudioTrack();
                    i2 += -1;
                }
            }
            if (this.f8611d) {
                if (fmodGetInfo(k) == 1) {
                    fmodProcess(this.e);
                    ByteBuffer byteBuffer = this.e;
                    byteBuffer.get(this.f, 0, byteBuffer.capacity());
                    this.f8610c.write(this.f, 0, this.e.capacity());
                    this.e.position(0);
                } else {
                    releaseAudioTrack();
                }
            }
        }
        releaseAudioTrack();
    }

    public synchronized void start() {
        if (this.f8608a != null) {
            stop();
        }
        this.f8608a = new Thread(this, "FMODAudioDevice");
        this.f8608a.setPriority(10);
        this.f8609b = true;
        this.f8608a.start();
        if (this.g != null) {
            this.g.b();
        }
    }

    public synchronized int startAudioRecord(int i2, int i3, int i4) {
        if (this.g == null) {
            this.g = new a(this, i2, i3);
            this.g.b();
        }
        return this.g.a();
    }

    public synchronized void stop() {
        while (this.f8608a != null) {
            this.f8609b = false;
            try {
                this.f8608a.join();
                this.f8608a = null;
            } catch (InterruptedException unused) {
            }
        }
        if (this.g != null) {
            this.g.c();
        }
    }

    public synchronized void stopAudioRecord() {
        if (this.g != null) {
            this.g.c();
            this.g = null;
        }
    }
}
