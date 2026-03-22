package com.bumptech.glide.l;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: DiskLruCache.java */
/* loaded from: classes.dex */
public final class a implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    private final File f1942a;

    /* renamed from: b, reason: collision with root package name */
    private final File f1943b;

    /* renamed from: c, reason: collision with root package name */
    private final File f1944c;

    /* renamed from: d, reason: collision with root package name */
    private final File f1945d;
    private final int e;
    private long f;
    private final int g;
    private Writer i;
    private int k;
    private long h = 0;
    private final LinkedHashMap<String, c> j = new LinkedHashMap<>(0, 0.75f, true);
    private long l = 0;
    final ThreadPoolExecutor m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Callable<Void> n = new CallableC0060a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DiskLruCache.java */
    /* renamed from: com.bumptech.glide.l.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class CallableC0060a implements Callable<Void> {
        CallableC0060a() {
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            synchronized (a.this) {
                if (a.this.i == null) {
                    return null;
                }
                a.this.p();
                if (a.this.l()) {
                    a.this.o();
                    a.this.k = 0;
                }
                return null;
            }
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public final class b {

        /* renamed from: a, reason: collision with root package name */
        private final c f1947a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean[] f1948b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f1949c;

        /* synthetic */ b(a aVar, c cVar, CallableC0060a callableC0060a) {
            this(cVar);
        }

        public void c() throws IOException {
            a.this.a(this, true);
            this.f1949c = true;
        }

        private b(c cVar) {
            this.f1947a = cVar;
            this.f1948b = cVar.e ? null : new boolean[a.this.g];
        }

        public File a(int i) throws IOException {
            File b2;
            synchronized (a.this) {
                if (this.f1947a.f == this) {
                    if (!this.f1947a.e) {
                        this.f1948b[i] = true;
                    }
                    b2 = this.f1947a.b(i);
                    if (!a.this.f1942a.exists()) {
                        a.this.f1942a.mkdirs();
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
            return b2;
        }

        public void b() {
            if (this.f1949c) {
                return;
            }
            try {
                a();
            } catch (IOException unused) {
            }
        }

        public void a() throws IOException {
            a.this.a(this, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public final class c {

        /* renamed from: a, reason: collision with root package name */
        private final String f1951a;

        /* renamed from: b, reason: collision with root package name */
        private final long[] f1952b;

        /* renamed from: c, reason: collision with root package name */
        File[] f1953c;

        /* renamed from: d, reason: collision with root package name */
        File[] f1954d;
        private boolean e;
        private b f;
        private long g;

        /* synthetic */ c(a aVar, String str, CallableC0060a callableC0060a) {
            this(str);
        }

        private c(String str) {
            this.f1951a = str;
            this.f1952b = new long[a.this.g];
            this.f1953c = new File[a.this.g];
            this.f1954d = new File[a.this.g];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i = 0; i < a.this.g; i++) {
                sb.append(i);
                this.f1953c[i] = new File(a.this.f1942a, sb.toString());
                sb.append(".tmp");
                this.f1954d[i] = new File(a.this.f1942a, sb.toString());
                sb.setLength(length);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String[] strArr) throws IOException {
            if (strArr.length == a.this.g) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.f1952b[i] = Long.parseLong(strArr[i]);
                    } catch (NumberFormatException unused) {
                        a(strArr);
                        throw null;
                    }
                }
                return;
            }
            a(strArr);
            throw null;
        }

        public String a() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long j : this.f1952b) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        public File b(int i) {
            return this.f1954d[i];
        }

        private IOException a(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File a(int i) {
            return this.f1953c[i];
        }
    }

    /* compiled from: DiskLruCache.java */
    /* loaded from: classes.dex */
    public final class d {

        /* renamed from: a, reason: collision with root package name */
        private final File[] f1955a;

        /* synthetic */ d(a aVar, String str, long j, File[] fileArr, long[] jArr, CallableC0060a callableC0060a) {
            this(aVar, str, j, fileArr, jArr);
        }

        public File a(int i) {
            return this.f1955a[i];
        }

        private d(a aVar, String str, long j, File[] fileArr, long[] jArr) {
            this.f1955a = fileArr;
        }
    }

    private a(File file, int i, int i2, long j) {
        this.f1942a = file;
        this.e = i;
        this.f1943b = new File(file, "journal");
        this.f1944c = new File(file, "journal.tmp");
        this.f1945d = new File(file, "journal.bkp");
        this.g = i2;
        this.f = j;
    }

    private void k() {
        if (this.i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l() {
        int i = this.k;
        return i >= 2000 && i >= this.j.size();
    }

    private void m() throws IOException {
        a(this.f1944c);
        Iterator<c> it2 = this.j.values().iterator();
        while (it2.hasNext()) {
            c next = it2.next();
            int i = 0;
            if (next.f != null) {
                next.f = null;
                while (i < this.g) {
                    a(next.a(i));
                    a(next.b(i));
                    i++;
                }
                it2.remove();
            } else {
                while (i < this.g) {
                    this.h += next.f1952b[i];
                    i++;
                }
            }
        }
    }

    private void n() throws IOException {
        com.bumptech.glide.l.b bVar = new com.bumptech.glide.l.b(new FileInputStream(this.f1943b), com.bumptech.glide.l.c.f1961a);
        try {
            String k = bVar.k();
            String k2 = bVar.k();
            String k3 = bVar.k();
            String k4 = bVar.k();
            String k5 = bVar.k();
            if (!"libcore.io.DiskLruCache".equals(k) || !"1".equals(k2) || !Integer.toString(this.e).equals(k3) || !Integer.toString(this.g).equals(k4) || !"".equals(k5)) {
                throw new IOException("unexpected journal header: [" + k + ", " + k2 + ", " + k4 + ", " + k5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    e(bVar.k());
                    i++;
                } catch (EOFException unused) {
                    this.k = i - this.j.size();
                    if (bVar.g()) {
                        o();
                    } else {
                        this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f1943b, true), com.bumptech.glide.l.c.f1961a));
                    }
                    com.bumptech.glide.l.c.a(bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            com.bumptech.glide.l.c.a(bVar);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void o() throws IOException {
        if (this.i != null) {
            this.i.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f1944c), com.bumptech.glide.l.c.f1961a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.e));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.g));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (c cVar : this.j.values()) {
                if (cVar.f != null) {
                    bufferedWriter.write("DIRTY " + cVar.f1951a + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + cVar.f1951a + cVar.a() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.f1943b.exists()) {
                a(this.f1943b, this.f1945d, true);
            }
            a(this.f1944c, this.f1943b, false);
            this.f1945d.delete();
            this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f1943b, true), com.bumptech.glide.l.c.f1961a));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() throws IOException {
        while (this.h > this.f) {
            d(this.j.entrySet().iterator().next().getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.i == null) {
            return;
        }
        Iterator it2 = new ArrayList(this.j.values()).iterator();
        while (it2.hasNext()) {
            c cVar = (c) it2.next();
            if (cVar.f != null) {
                cVar.f.a();
            }
        }
        p();
        this.i.close();
        this.i = null;
    }

    public void g() throws IOException {
        close();
        com.bumptech.glide.l.c.a(this.f1942a);
    }

    private void e(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            if (indexOf2 == -1) {
                substring = str.substring(i);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.j.remove(substring);
                    return;
                }
            } else {
                substring = str.substring(i, indexOf2);
            }
            c cVar = this.j.get(substring);
            CallableC0060a callableC0060a = null;
            if (cVar == null) {
                cVar = new c(this, substring, callableC0060a);
                this.j.put(substring, cVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                cVar.e = true;
                cVar.f = null;
                cVar.b(split);
                return;
            }
            if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                cVar.f = new b(this, cVar, callableC0060a);
                return;
            }
            if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
                return;
            }
            throw new IOException("unexpected journal line: " + str);
        }
        throw new IOException("unexpected journal line: " + str);
    }

    public b b(String str) throws IOException {
        return a(str, -1L);
    }

    public synchronized d c(String str) throws IOException {
        k();
        c cVar = this.j.get(str);
        if (cVar == null) {
            return null;
        }
        if (!cVar.e) {
            return null;
        }
        for (File file : cVar.f1953c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.k++;
        this.i.append((CharSequence) "READ");
        this.i.append(' ');
        this.i.append((CharSequence) str);
        this.i.append('\n');
        if (l()) {
            this.m.submit(this.n);
        }
        return new d(this, str, cVar.g, cVar.f1953c, cVar.f1952b, null);
    }

    public synchronized boolean d(String str) throws IOException {
        k();
        c cVar = this.j.get(str);
        if (cVar != null && cVar.f == null) {
            for (int i = 0; i < this.g; i++) {
                File a2 = cVar.a(i);
                if (a2.exists() && !a2.delete()) {
                    throw new IOException("failed to delete " + a2);
                }
                this.h -= cVar.f1952b[i];
                cVar.f1952b[i] = 0;
            }
            this.k++;
            this.i.append((CharSequence) "REMOVE");
            this.i.append(' ');
            this.i.append((CharSequence) str);
            this.i.append('\n');
            this.j.remove(str);
            if (l()) {
                this.m.submit(this.n);
            }
            return true;
        }
        return false;
    }

    public static a a(File file, int i, int i2, long j) throws IOException {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i2 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            a aVar = new a(file, i, i2, j);
            if (aVar.f1943b.exists()) {
                try {
                    aVar.n();
                    aVar.m();
                    return aVar;
                } catch (IOException e) {
                    System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                    aVar.g();
                }
            }
            file.mkdirs();
            a aVar2 = new a(file, i, i2, j);
            aVar2.o();
            return aVar2;
        }
        throw new IllegalArgumentException("valueCount <= 0");
    }

    private static void a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void a(File file, File file2, boolean z) throws IOException {
        if (z) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    private synchronized b a(String str, long j) throws IOException {
        k();
        c cVar = this.j.get(str);
        CallableC0060a callableC0060a = null;
        if (j != -1 && (cVar == null || cVar.g != j)) {
            return null;
        }
        if (cVar != null) {
            if (cVar.f != null) {
                return null;
            }
        } else {
            cVar = new c(this, str, callableC0060a);
            this.j.put(str, cVar);
        }
        b bVar = new b(this, cVar, callableC0060a);
        cVar.f = bVar;
        this.i.append((CharSequence) "DIRTY");
        this.i.append(' ');
        this.i.append((CharSequence) str);
        this.i.append('\n');
        this.i.flush();
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(b bVar, boolean z) throws IOException {
        c cVar = bVar.f1947a;
        if (cVar.f == bVar) {
            if (z && !cVar.e) {
                for (int i = 0; i < this.g; i++) {
                    if (bVar.f1948b[i]) {
                        if (!cVar.b(i).exists()) {
                            bVar.a();
                            return;
                        }
                    } else {
                        bVar.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    }
                }
            }
            for (int i2 = 0; i2 < this.g; i2++) {
                File b2 = cVar.b(i2);
                if (z) {
                    if (b2.exists()) {
                        File a2 = cVar.a(i2);
                        b2.renameTo(a2);
                        long j = cVar.f1952b[i2];
                        long length = a2.length();
                        cVar.f1952b[i2] = length;
                        this.h = (this.h - j) + length;
                    }
                } else {
                    a(b2);
                }
            }
            this.k++;
            cVar.f = null;
            if (!(cVar.e | z)) {
                this.j.remove(cVar.f1951a);
                this.i.append((CharSequence) "REMOVE");
                this.i.append(' ');
                this.i.append((CharSequence) cVar.f1951a);
                this.i.append('\n');
            } else {
                cVar.e = true;
                this.i.append((CharSequence) "CLEAN");
                this.i.append(' ');
                this.i.append((CharSequence) cVar.f1951a);
                this.i.append((CharSequence) cVar.a());
                this.i.append('\n');
                if (z) {
                    long j2 = this.l;
                    this.l = 1 + j2;
                    cVar.g = j2;
                }
            }
            this.i.flush();
            if (this.h > this.f || l()) {
                this.m.submit(this.n);
            }
            return;
        }
        throw new IllegalStateException();
    }
}
