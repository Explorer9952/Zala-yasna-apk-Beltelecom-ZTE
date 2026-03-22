package com.bumptech.glide.load.h;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: StreamEncoder.java */
/* loaded from: classes.dex */
public class o implements com.bumptech.glide.load.a<InputStream> {
    @Override // com.bumptech.glide.load.a
    public String a() {
        return "";
    }

    @Override // com.bumptech.glide.load.a
    public boolean a(InputStream inputStream, OutputStream outputStream) {
        byte[] a2 = com.bumptech.glide.s.a.b().a();
        while (true) {
            try {
                int read = inputStream.read(a2);
                if (read != -1) {
                    outputStream.write(a2, 0, read);
                } else {
                    return true;
                }
            } catch (IOException e) {
                if (Log.isLoggable("StreamEncoder", 3)) {
                    Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", e);
                }
                return false;
            } finally {
                com.bumptech.glide.s.a.b().a(a2);
            }
        }
    }
}
