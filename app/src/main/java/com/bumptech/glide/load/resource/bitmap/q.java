package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.DecodeFormat;
import java.io.IOException;

/* compiled from: VideoBitmapDecoder.java */
/* loaded from: classes.dex */
public class q implements com.bumptech.glide.load.resource.bitmap.a<ParcelFileDescriptor> {

    /* renamed from: c, reason: collision with root package name */
    private static final a f2225c = new a();

    /* renamed from: a, reason: collision with root package name */
    private a f2226a;

    /* renamed from: b, reason: collision with root package name */
    private int f2227b;

    /* compiled from: VideoBitmapDecoder.java */
    /* loaded from: classes.dex */
    static class a {
        a() {
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    public q() {
        this(f2225c, -1);
    }

    public Bitmap a(ParcelFileDescriptor parcelFileDescriptor, com.bumptech.glide.load.engine.l.c cVar, int i, int i2, DecodeFormat decodeFormat) throws IOException {
        Bitmap frameAtTime;
        MediaMetadataRetriever a2 = this.f2226a.a();
        a2.setDataSource(parcelFileDescriptor.getFileDescriptor());
        int i3 = this.f2227b;
        if (i3 >= 0) {
            frameAtTime = a2.getFrameAtTime(i3);
        } else {
            frameAtTime = a2.getFrameAtTime();
        }
        a2.release();
        parcelFileDescriptor.close();
        return frameAtTime;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.a
    public String a() {
        return "VideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    }

    q(a aVar, int i) {
        this.f2226a = aVar;
        this.f2227b = i;
    }
}
