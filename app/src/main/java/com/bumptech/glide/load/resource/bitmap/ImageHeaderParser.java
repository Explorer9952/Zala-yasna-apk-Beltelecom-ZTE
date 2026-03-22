package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public class ImageHeaderParser {

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f2178b;

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f2179c = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* renamed from: a, reason: collision with root package name */
    private final b f2180a;

    /* loaded from: classes.dex */
    public enum ImageType {
        GIF(true),
        JPEG(false),
        PNG_A(true),
        PNG(false),
        UNKNOWN(false);

        private final boolean hasAlpha;

        ImageType(boolean z) {
            this.hasAlpha = z;
        }

        public boolean hasAlpha() {
            return this.hasAlpha;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f2181a;

        public a(byte[] bArr) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.f2181a = wrap;
            wrap.order(ByteOrder.BIG_ENDIAN);
        }

        public void a(ByteOrder byteOrder) {
            this.f2181a.order(byteOrder);
        }

        public int b(int i) {
            return this.f2181a.getInt(i);
        }

        public int a() {
            return this.f2181a.array().length;
        }

        public short a(int i) {
            return this.f2181a.getShort(i);
        }
    }

    static {
        byte[] bArr = new byte[0];
        try {
            bArr = "Exif\u0000\u0000".getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
        }
        f2178b = bArr;
    }

    public ImageHeaderParser(InputStream inputStream) {
        this.f2180a = new b(inputStream);
    }

    private static int a(int i, int i2) {
        return i + 2 + (i2 * 12);
    }

    private static boolean a(int i) {
        return (i & 65496) == 65496 || i == 19789 || i == 18761;
    }

    private byte[] d() throws IOException {
        short c2;
        int b2;
        long j;
        long a2;
        do {
            short c3 = this.f2180a.c();
            if (c3 != 255) {
                if (Log.isLoggable("ImageHeaderParser", 3)) {
                    Log.d("ImageHeaderParser", "Unknown segmentId=" + ((int) c3));
                }
                return null;
            }
            c2 = this.f2180a.c();
            if (c2 == 218) {
                return null;
            }
            if (c2 == 217) {
                if (Log.isLoggable("ImageHeaderParser", 3)) {
                    Log.d("ImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return null;
            }
            b2 = this.f2180a.b() - 2;
            if (c2 != 225) {
                j = b2;
                a2 = this.f2180a.a(j);
            } else {
                byte[] bArr = new byte[b2];
                int a3 = this.f2180a.a(bArr);
                if (a3 == b2) {
                    return bArr;
                }
                if (Log.isLoggable("ImageHeaderParser", 3)) {
                    Log.d("ImageHeaderParser", "Unable to read segment data, type: " + ((int) c2) + ", length: " + b2 + ", actually read: " + a3);
                }
                return null;
            }
        } while (a2 == j);
        if (Log.isLoggable("ImageHeaderParser", 3)) {
            Log.d("ImageHeaderParser", "Unable to skip enough data, type: " + ((int) c2) + ", wanted to skip: " + b2 + ", but actually skipped: " + a2);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int a() throws java.io.IOException {
        /*
            r7 = this;
            com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$b r0 = r7.f2180a
            int r0 = r0.b()
            boolean r0 = a(r0)
            r1 = -1
            if (r0 != 0) goto Le
            return r1
        Le:
            byte[] r0 = r7.d()
            r2 = 0
            if (r0 == 0) goto L1d
            int r3 = r0.length
            byte[] r4 = com.bumptech.glide.load.resource.bitmap.ImageHeaderParser.f2178b
            int r4 = r4.length
            if (r3 <= r4) goto L1d
            r3 = 1
            goto L1e
        L1d:
            r3 = 0
        L1e:
            if (r3 == 0) goto L30
            r4 = 0
        L21:
            byte[] r5 = com.bumptech.glide.load.resource.bitmap.ImageHeaderParser.f2178b
            int r6 = r5.length
            if (r4 >= r6) goto L30
            r6 = r0[r4]
            r5 = r5[r4]
            if (r6 == r5) goto L2d
            goto L31
        L2d:
            int r4 = r4 + 1
            goto L21
        L30:
            r2 = r3
        L31:
            if (r2 == 0) goto L3d
            com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$a r1 = new com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$a
            r1.<init>(r0)
            int r0 = a(r1)
            return r0
        L3d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.ImageHeaderParser.a():int");
    }

    public ImageType b() throws IOException {
        int b2 = this.f2180a.b();
        if (b2 == 65496) {
            return ImageType.JPEG;
        }
        int b3 = ((b2 << 16) & (-65536)) | (this.f2180a.b() & 65535);
        if (b3 == -1991225785) {
            this.f2180a.a(21L);
            return this.f2180a.a() >= 3 ? ImageType.PNG_A : ImageType.PNG;
        }
        if ((b3 >> 8) == 4671814) {
            return ImageType.GIF;
        }
        return ImageType.UNKNOWN;
    }

    public boolean c() throws IOException {
        return b().hasAlpha();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final InputStream f2182a;

        public b(InputStream inputStream) {
            this.f2182a = inputStream;
        }

        public long a(long j) throws IOException {
            if (j < 0) {
                return 0L;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.f2182a.skip(j2);
                if (skip <= 0) {
                    if (this.f2182a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j2 -= skip;
            }
            return j - j2;
        }

        public int b() throws IOException {
            return ((this.f2182a.read() << 8) & 65280) | (this.f2182a.read() & 255);
        }

        public short c() throws IOException {
            return (short) (this.f2182a.read() & 255);
        }

        public int a(byte[] bArr) throws IOException {
            int length = bArr.length;
            while (length > 0) {
                int read = this.f2182a.read(bArr, bArr.length - length, length);
                if (read == -1) {
                    break;
                }
                length -= read;
            }
            return bArr.length - length;
        }

        public int a() throws IOException {
            return this.f2182a.read();
        }
    }

    private static int a(a aVar) {
        ByteOrder byteOrder;
        short a2 = aVar.a(6);
        if (a2 == 19789) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else if (a2 == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else {
            if (Log.isLoggable("ImageHeaderParser", 3)) {
                Log.d("ImageHeaderParser", "Unknown endianness = " + ((int) a2));
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        aVar.a(byteOrder);
        int b2 = aVar.b(10) + 6;
        short a3 = aVar.a(b2);
        for (int i = 0; i < a3; i++) {
            int a4 = a(b2, i);
            short a5 = aVar.a(a4);
            if (a5 == 274) {
                short a6 = aVar.a(a4 + 2);
                if (a6 >= 1 && a6 <= 12) {
                    int b3 = aVar.b(a4 + 4);
                    if (b3 < 0) {
                        if (Log.isLoggable("ImageHeaderParser", 3)) {
                            Log.d("ImageHeaderParser", "Negative tiff component count");
                        }
                    } else {
                        if (Log.isLoggable("ImageHeaderParser", 3)) {
                            Log.d("ImageHeaderParser", "Got tagIndex=" + i + " tagType=" + ((int) a5) + " formatCode=" + ((int) a6) + " componentCount=" + b3);
                        }
                        int i2 = b3 + f2179c[a6];
                        if (i2 > 4) {
                            if (Log.isLoggable("ImageHeaderParser", 3)) {
                                Log.d("ImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) a6));
                            }
                        } else {
                            int i3 = a4 + 8;
                            if (i3 >= 0 && i3 <= aVar.a()) {
                                if (i2 >= 0 && i2 + i3 <= aVar.a()) {
                                    return aVar.a(i3);
                                }
                                if (Log.isLoggable("ImageHeaderParser", 3)) {
                                    Log.d("ImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) a5));
                                }
                            } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                                Log.d("ImageHeaderParser", "Illegal tagValueOffset=" + i3 + " tagType=" + ((int) a5));
                            }
                        }
                    }
                } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                    Log.d("ImageHeaderParser", "Got invalid format code=" + ((int) a6));
                }
            }
        }
        return -1;
    }
}
