package com.android.vending.expansion.zipfile;

import android.content.res.AssetFileDescriptor;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Collection;
import java.util.HashMap;

/* compiled from: ZipResourceFile.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, a> f1893a = new HashMap<>();

    public b(String str) throws IOException {
        new HashMap();
        ByteBuffer.allocate(4);
        a(str);
    }

    private static int a(int i) {
        return ((i & 255) << 24) + ((65280 & i) << 8) + ((16711680 & i) >>> 8) + ((i >>> 24) & 255);
    }

    public a[] a() {
        Collection<a> values = this.f1893a.values();
        return (a[]) values.toArray(new a[values.size()]);
    }

    public AssetFileDescriptor b(String str) {
        a aVar = this.f1893a.get(str);
        if (aVar != null) {
            return aVar.a();
        }
        return null;
    }

    private static int a(RandomAccessFile randomAccessFile) throws EOFException, IOException {
        return a(randomAccessFile.readInt());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) throws IOException {
        String str2 = str;
        File file = new File(str2);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        long length = randomAccessFile.length();
        if (length >= 22) {
            long j = 65557 > length ? length : 65557L;
            randomAccessFile.seek(0L);
            int a2 = a(randomAccessFile);
            if (a2 == 101010256) {
                Log.i("zipro", "Found Zip archive, but it looks empty");
                throw new IOException();
            }
            if (a2 == 67324752) {
                randomAccessFile.seek(length - j);
                ByteBuffer allocate = ByteBuffer.allocate((int) j);
                byte[] array = allocate.array();
                randomAccessFile.readFully(array);
                allocate.order(ByteOrder.LITTLE_ENDIAN);
                int length2 = array.length - 22;
                while (length2 >= 0 && (array[length2] != 80 || allocate.getInt(length2) != 101010256)) {
                    length2--;
                    str2 = str;
                    file = file;
                }
                if (length2 < 0) {
                    Log.d("zipro", "Zip: EOCD not found, " + str2 + " is not zip");
                }
                short s = allocate.getShort(length2 + 8);
                long j2 = allocate.getInt(length2 + 12) & 4294967295L;
                long j3 = allocate.getInt(length2 + 16) & 4294967295L;
                if (j3 + j2 > length) {
                    Log.w("zipro", "bad offsets (dir " + j3 + ", size " + j2 + ", eocd " + length2 + ")");
                    throw new IOException();
                }
                if (s != 0) {
                    MappedByteBuffer map = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_ONLY, j3, j2);
                    map.order(ByteOrder.LITTLE_ENDIAN);
                    short s2 = 65535;
                    byte[] bArr = new byte[65535];
                    ByteBuffer allocate2 = ByteBuffer.allocate(30);
                    allocate2.order(ByteOrder.LITTLE_ENDIAN);
                    int i = 0;
                    int i2 = 0;
                    int i3 = 0;
                    while (i2 < s) {
                        if (map.getInt(i3) == 33639248) {
                            int i4 = map.getShort(i3 + 28) & s2;
                            int i5 = map.getShort(i3 + 30) & s2;
                            int i6 = map.getShort(i3 + 32) & s2;
                            map.position(i3 + 46);
                            map.get(bArr, i, i4);
                            map.position(i);
                            String str3 = new String(bArr, i, i4);
                            a aVar = new a(str2, file, str3);
                            aVar.e = map.getShort(i3 + 10) & 65535;
                            aVar.f = map.getInt(i3 + 12) & 4294967295L;
                            aVar.g = map.getLong(i3 + 16) & 4294967295L;
                            aVar.h = map.getLong(i3 + 20) & 4294967295L;
                            aVar.i = map.getLong(i3 + 24) & 4294967295L;
                            aVar.f1897d = map.getInt(i3 + 42) & 4294967295L;
                            allocate2.clear();
                            aVar.a(randomAccessFile, allocate2);
                            this.f1893a.put(str3, aVar);
                            i3 += i4 + 46 + i5 + i6;
                            i2++;
                            str2 = str;
                            file = file;
                            s2 = 65535;
                            i = 0;
                        } else {
                            Log.w("zipro", "Missed a central dir sig (at " + i3 + ")");
                            throw new IOException();
                        }
                    }
                    return;
                }
                Log.w("zipro", "empty archive?");
                throw new IOException();
            }
            Log.v("zipro", "Not a Zip archive");
            throw new IOException();
        }
        throw new IOException();
    }

    /* compiled from: ZipResourceFile.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final File f1894a;

        /* renamed from: b, reason: collision with root package name */
        public final String f1895b;

        /* renamed from: c, reason: collision with root package name */
        public final String f1896c;

        /* renamed from: d, reason: collision with root package name */
        public long f1897d;
        public int e;
        public long f;
        public long g;
        public long h;
        public long i;
        public long j = -1;

        public a(String str, File file, String str2) {
            this.f1895b = str2;
            this.f1896c = str;
            this.f1894a = file;
        }

        public void a(RandomAccessFile randomAccessFile, ByteBuffer byteBuffer) throws IOException {
            long j = this.f1897d;
            try {
                randomAccessFile.seek(j);
                randomAccessFile.readFully(byteBuffer.array());
                if (byteBuffer.getInt(0) == 67324752) {
                    this.j = j + 30 + (byteBuffer.getShort(26) & 65535) + (byteBuffer.getShort(28) & 65535);
                } else {
                    Log.w("zipro", "didn't find signature at start of lfh");
                    throw new IOException();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }

        public long b() {
            return this.j;
        }

        public String c() {
            return this.f1896c;
        }

        public AssetFileDescriptor a() {
            if (this.e != 0) {
                return null;
            }
            try {
                return new AssetFileDescriptor(ParcelFileDescriptor.open(this.f1894a, 268435456), b(), this.i);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
