package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.io.InputStream;
import java.util.EnumSet;
import java.util.Queue;
import java.util.Set;

/* compiled from: Downsampler.java */
/* loaded from: classes.dex */
public abstract class f implements com.bumptech.glide.load.resource.bitmap.a<InputStream> {

    /* renamed from: a, reason: collision with root package name */
    private static final Set<ImageHeaderParser.ImageType> f2192a = EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG);

    /* renamed from: b, reason: collision with root package name */
    private static final Queue<BitmapFactory.Options> f2193b = com.bumptech.glide.s.h.a(0);

    /* renamed from: c, reason: collision with root package name */
    public static final f f2194c = new a();

    /* compiled from: Downsampler.java */
    /* loaded from: classes.dex */
    static class a extends f {
        a() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.f
        protected int a(int i, int i2, int i3, int i4) {
            return Math.min(i2 / i4, i / i3);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.a
        public String a() {
            return "AT_LEAST.com.bumptech.glide.load.data.bitmap";
        }
    }

    /* compiled from: Downsampler.java */
    /* loaded from: classes.dex */
    static class b extends f {
        b() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.f
        protected int a(int i, int i2, int i3, int i4) {
            int ceil = (int) Math.ceil(Math.max(i2 / i4, i / i3));
            int max = Math.max(1, Integer.highestOneBit(ceil));
            return max << (max >= ceil ? 0 : 1);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.a
        public String a() {
            return "AT_MOST.com.bumptech.glide.load.data.bitmap";
        }
    }

    /* compiled from: Downsampler.java */
    /* loaded from: classes.dex */
    static class c extends f {
        c() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.f
        protected int a(int i, int i2, int i3, int i4) {
            return 0;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.a
        public String a() {
            return "NONE.com.bumptech.glide.load.data.bitmap";
        }
    }

    static {
        new b();
        new c();
    }

    private static Bitmap b(com.bumptech.glide.s.f fVar, RecyclableBufferedInputStream recyclableBufferedInputStream, BitmapFactory.Options options) {
        if (options.inJustDecodeBounds) {
            fVar.mark(5242880);
        } else {
            recyclableBufferedInputStream.g();
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(fVar, null, options);
        try {
            if (options.inJustDecodeBounds) {
                fVar.reset();
            }
        } catch (IOException e) {
            if (Log.isLoggable("Downsampler", 6)) {
                Log.e("Downsampler", "Exception loading inDecodeBounds=" + options.inJustDecodeBounds + " sample=" + options.inSampleSize, e);
            }
        }
        return decodeStream;
    }

    protected abstract int a(int i, int i2, int i3, int i4);

    public Bitmap a(InputStream inputStream, com.bumptech.glide.load.engine.l.c cVar, int i, int i2, DecodeFormat decodeFormat) {
        int i3;
        com.bumptech.glide.s.a b2 = com.bumptech.glide.s.a.b();
        byte[] a2 = b2.a();
        byte[] a3 = b2.a();
        BitmapFactory.Options b3 = b();
        RecyclableBufferedInputStream recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, a3);
        com.bumptech.glide.s.c b4 = com.bumptech.glide.s.c.b(recyclableBufferedInputStream);
        com.bumptech.glide.s.f fVar = new com.bumptech.glide.s.f(b4);
        try {
            b4.mark(5242880);
            try {
                try {
                    int a4 = new ImageHeaderParser(b4).a();
                    try {
                        b4.reset();
                    } catch (IOException e) {
                        if (Log.isLoggable("Downsampler", 5)) {
                            Log.w("Downsampler", "Cannot reset the input stream", e);
                        }
                    }
                    i3 = a4;
                } finally {
                }
            } catch (IOException e2) {
                if (Log.isLoggable("Downsampler", 5)) {
                    Log.w("Downsampler", "Cannot determine the image orientation from header", e2);
                }
                try {
                    b4.reset();
                } catch (IOException e3) {
                    if (Log.isLoggable("Downsampler", 5)) {
                        Log.w("Downsampler", "Cannot reset the input stream", e3);
                    }
                }
                i3 = 0;
            }
            b3.inTempStorage = a2;
            int[] a5 = a(fVar, recyclableBufferedInputStream, b3);
            int i4 = a5[0];
            int i5 = a5[1];
            Bitmap a6 = a(fVar, recyclableBufferedInputStream, b3, cVar, i4, i5, a(p.a(i3), i4, i5, i, i2), decodeFormat);
            IOException g = b4.g();
            if (g != null) {
                throw new RuntimeException(g);
            }
            Bitmap bitmap = null;
            if (a6 != null) {
                bitmap = p.a(a6, cVar, i3);
                if (!a6.equals(bitmap) && !cVar.a(a6)) {
                    a6.recycle();
                }
            }
            return bitmap;
        } finally {
            b2.a(a2);
            b2.a(a3);
            b4.k();
            a(b3);
        }
    }

    @TargetApi(11)
    private static synchronized BitmapFactory.Options b() {
        BitmapFactory.Options poll;
        synchronized (f.class) {
            synchronized (f2193b) {
                poll = f2193b.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                b(poll);
            }
        }
        return poll;
    }

    @TargetApi(11)
    private static void b(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        if (11 <= Build.VERSION.SDK_INT) {
            options.inBitmap = null;
            options.inMutable = true;
        }
    }

    private int a(int i, int i2, int i3, int i4, int i5) {
        int a2;
        if (i5 == Integer.MIN_VALUE) {
            i5 = i3;
        }
        if (i4 == Integer.MIN_VALUE) {
            i4 = i2;
        }
        if (i != 90 && i != 270) {
            a2 = a(i2, i3, i4, i5);
        } else {
            a2 = a(i3, i2, i4, i5);
        }
        return Math.max(1, a2 == 0 ? 0 : Integer.highestOneBit(a2));
    }

    private Bitmap a(com.bumptech.glide.s.f fVar, RecyclableBufferedInputStream recyclableBufferedInputStream, BitmapFactory.Options options, com.bumptech.glide.load.engine.l.c cVar, int i, int i2, int i3, DecodeFormat decodeFormat) {
        Bitmap.Config a2 = a(fVar, decodeFormat);
        options.inSampleSize = i3;
        options.inPreferredConfig = a2;
        if ((i3 == 1 || 19 <= Build.VERSION.SDK_INT) && a(fVar)) {
            double d2 = i;
            double d3 = i3;
            Double.isNaN(d2);
            Double.isNaN(d3);
            int ceil = (int) Math.ceil(d2 / d3);
            double d4 = i2;
            Double.isNaN(d4);
            Double.isNaN(d3);
            a(options, cVar.b(ceil, (int) Math.ceil(d4 / d3), a2));
        }
        return b(fVar, recyclableBufferedInputStream, options);
    }

    private static boolean a(InputStream inputStream) {
        if (19 <= Build.VERSION.SDK_INT) {
            return true;
        }
        inputStream.mark(Util.BYTE_OF_KB);
        try {
            try {
                boolean contains = f2192a.contains(new ImageHeaderParser(inputStream).b());
                try {
                    inputStream.reset();
                } catch (IOException e) {
                    if (Log.isLoggable("Downsampler", 5)) {
                        Log.w("Downsampler", "Cannot reset the input stream", e);
                    }
                }
                return contains;
            } catch (Throwable th) {
                try {
                    inputStream.reset();
                } catch (IOException e2) {
                    if (Log.isLoggable("Downsampler", 5)) {
                        Log.w("Downsampler", "Cannot reset the input stream", e2);
                    }
                }
                throw th;
            }
        } catch (IOException e3) {
            if (Log.isLoggable("Downsampler", 5)) {
                Log.w("Downsampler", "Cannot determine the image type from header", e3);
            }
            try {
                inputStream.reset();
                return false;
            } catch (IOException e4) {
                if (!Log.isLoggable("Downsampler", 5)) {
                    return false;
                }
                Log.w("Downsampler", "Cannot reset the input stream", e4);
                return false;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002c, code lost:
    
        if (android.util.Log.isLoggable("Downsampler", 5) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002e, code lost:
    
        android.util.Log.w("Downsampler", "Cannot reset the input stream", r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0058, code lost:
    
        if (android.util.Log.isLoggable("Downsampler", 5) == false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.graphics.Bitmap.Config a(java.io.InputStream r7, com.bumptech.glide.load.DecodeFormat r8) {
        /*
            java.lang.String r0 = "Cannot reset the input stream"
            java.lang.String r1 = "Downsampler"
            com.bumptech.glide.load.DecodeFormat r2 = com.bumptech.glide.load.DecodeFormat.ALWAYS_ARGB_8888
            if (r8 == r2) goto L72
            com.bumptech.glide.load.DecodeFormat r2 = com.bumptech.glide.load.DecodeFormat.PREFER_ARGB_8888
            if (r8 == r2) goto L72
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 16
            if (r2 != r3) goto L13
            goto L72
        L13:
            r2 = 0
            r3 = 1024(0x400, float:1.435E-42)
            r7.mark(r3)
            r3 = 5
            com.bumptech.glide.load.resource.bitmap.ImageHeaderParser r4 = new com.bumptech.glide.load.resource.bitmap.ImageHeaderParser     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
            r4.<init>(r7)     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
            boolean r2 = r4.c()     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
            r7.reset()     // Catch: java.io.IOException -> L27
            goto L5b
        L27:
            r7 = move-exception
            boolean r8 = android.util.Log.isLoggable(r1, r3)
            if (r8 == 0) goto L5b
        L2e:
            android.util.Log.w(r1, r0, r7)
            goto L5b
        L32:
            r8 = move-exception
            goto L63
        L34:
            r4 = move-exception
            boolean r5 = android.util.Log.isLoggable(r1, r3)     // Catch: java.lang.Throwable -> L32
            if (r5 == 0) goto L4f
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L32
            r5.<init>()     // Catch: java.lang.Throwable -> L32
            java.lang.String r6 = "Cannot determine whether the image has alpha or not from header for format "
            r5.append(r6)     // Catch: java.lang.Throwable -> L32
            r5.append(r8)     // Catch: java.lang.Throwable -> L32
            java.lang.String r8 = r5.toString()     // Catch: java.lang.Throwable -> L32
            android.util.Log.w(r1, r8, r4)     // Catch: java.lang.Throwable -> L32
        L4f:
            r7.reset()     // Catch: java.io.IOException -> L53
            goto L5b
        L53:
            r7 = move-exception
            boolean r8 = android.util.Log.isLoggable(r1, r3)
            if (r8 == 0) goto L5b
            goto L2e
        L5b:
            if (r2 == 0) goto L60
            android.graphics.Bitmap$Config r7 = android.graphics.Bitmap.Config.ARGB_8888
            goto L62
        L60:
            android.graphics.Bitmap$Config r7 = android.graphics.Bitmap.Config.RGB_565
        L62:
            return r7
        L63:
            r7.reset()     // Catch: java.io.IOException -> L67
            goto L71
        L67:
            r7 = move-exception
            boolean r2 = android.util.Log.isLoggable(r1, r3)
            if (r2 == 0) goto L71
            android.util.Log.w(r1, r0, r7)
        L71:
            throw r8
        L72:
            android.graphics.Bitmap$Config r7 = android.graphics.Bitmap.Config.ARGB_8888
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.f.a(java.io.InputStream, com.bumptech.glide.load.DecodeFormat):android.graphics.Bitmap$Config");
    }

    public int[] a(com.bumptech.glide.s.f fVar, RecyclableBufferedInputStream recyclableBufferedInputStream, BitmapFactory.Options options) {
        options.inJustDecodeBounds = true;
        b(fVar, recyclableBufferedInputStream, options);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    @TargetApi(11)
    private static void a(BitmapFactory.Options options, Bitmap bitmap) {
        if (11 <= Build.VERSION.SDK_INT) {
            options.inBitmap = bitmap;
        }
    }

    private static void a(BitmapFactory.Options options) {
        b(options);
        synchronized (f2193b) {
            f2193b.offer(options);
        }
    }
}
