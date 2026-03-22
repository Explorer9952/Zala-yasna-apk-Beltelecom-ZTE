package com.video.androidsdk.a;

import android.os.Process;
import android.text.TextUtils;
import com.video.androidsdk.common.util.SecurityUtil;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: ACache.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, a> f3023a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private C0092a f3024b;

    /* compiled from: ACache.java */
    /* renamed from: com.video.androidsdk.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0092a {

        /* renamed from: a, reason: collision with root package name */
        protected File f3025a;

        /* renamed from: b, reason: collision with root package name */
        private final AtomicLong f3026b;

        /* renamed from: c, reason: collision with root package name */
        private final AtomicInteger f3027c;

        /* renamed from: d, reason: collision with root package name */
        private final long f3028d;
        private final int e;
        private final Map<File, Long> f;

        private C0092a(File file, long j, int i) {
            this.f = Collections.synchronizedMap(new HashMap());
            this.f3025a = file;
            this.f3028d = j;
            this.e = i;
            this.f3026b = new AtomicLong();
            this.f3027c = new AtomicInteger();
            a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long d() {
            return this.f3026b.get();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean c(String str) {
            File a2 = a(str);
            SecurityUtil.securityCheck(a2.getAbsolutePath(), "delete");
            return a2.delete();
        }

        private void a() {
            new Thread(new c(this)).start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public File b(String str) {
            return new File(this.f3025a, str.hashCode() + "");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            this.f.clear();
            this.f3026b.set(0L);
            File[] listFiles = this.f3025a.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    SecurityUtil.securityCheck(file.getAbsolutePath(), "delete");
                    file.delete();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(File file) {
            int i = this.f3027c.get();
            while (i + 1 > this.e) {
                this.f3026b.addAndGet(-c());
                i = this.f3027c.addAndGet(-1);
            }
            this.f3027c.addAndGet(1);
            long b2 = b(file);
            long j = this.f3026b.get();
            while (j + b2 > this.f3028d) {
                j = this.f3026b.addAndGet(-c());
            }
            this.f3026b.addAndGet(b2);
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            file.setLastModified(valueOf.longValue());
            this.f.put(file, valueOf);
        }

        private long c() {
            File file;
            long j = 0;
            if (this.f.isEmpty()) {
                return 0L;
            }
            Set<Map.Entry<File, Long>> entrySet = this.f.entrySet();
            synchronized (this.f) {
                file = null;
                Long l = null;
                for (Map.Entry<File, Long> entry : entrySet) {
                    if (file == null) {
                        file = entry.getKey();
                        l = entry.getValue();
                    } else {
                        Long value = entry.getValue();
                        if (value.longValue() < l.longValue()) {
                            file = entry.getKey();
                            l = value;
                        }
                    }
                }
            }
            if (file != null) {
                j = b(file);
                SecurityUtil.securityCheck(file.getAbsolutePath(), "delete");
                if (file.delete()) {
                    this.f.remove(file);
                }
            }
            return j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long b(File file) {
            return file.length();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public File a(String str) {
            File b2 = b(str);
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            b2.setLastModified(valueOf.longValue());
            this.f.put(b2, valueOf);
            return b2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ACache.java */
    /* loaded from: classes.dex */
    public static class b {
        /* JADX INFO: Access modifiers changed from: private */
        public static boolean c(String str) {
            return c(str.getBytes());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String d(String str) {
            return (str == null || !e(str.getBytes())) ? str : str.substring(str.indexOf(32) + 1, str.length());
        }

        private static boolean e(byte[] bArr) {
            return bArr != null && bArr.length > 15 && bArr[13] == 45 && a(bArr, ' ') > 14;
        }

        private static String[] f(byte[] bArr) {
            if (e(bArr)) {
                return new String[]{new String(a(bArr, 0, 13)), new String(a(bArr, 14, a(bArr, ' ')))};
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean c(byte[] bArr) {
            String[] f = f(bArr);
            if (f != null && f.length == 2) {
                String str = f[0];
                while (str.startsWith("0")) {
                    str = str.substring(1, str.length());
                }
                if (System.currentTimeMillis() > Long.valueOf(str).longValue() + (Long.valueOf(f[1]).longValue() * 1000)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String b(int i, String str) {
            return a(i) + str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static byte[] b(int i, byte[] bArr) {
            byte[] bytes = a(i).getBytes();
            byte[] bArr2 = new byte[bytes.length + bArr.length];
            System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
            System.arraycopy(bArr, 0, bArr2, bytes.length, bArr.length);
            return bArr2;
        }

        private static int a(byte[] bArr, char c2) {
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] == c2) {
                    return i;
                }
            }
            return -1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static byte[] d(byte[] bArr) {
            return e(bArr) ? a(bArr, a(bArr, ' ') + 1, bArr.length) : bArr;
        }

        private static byte[] a(byte[] bArr, int i, int i2) {
            int i3 = i2 - i;
            if (i3 >= 0) {
                byte[] bArr2 = new byte[i3];
                System.arraycopy(bArr, i, bArr2, 0, Math.min(bArr.length - i, i3));
                return bArr2;
            }
            throw new IllegalArgumentException(i + " > " + i2);
        }

        private static String a(int i) {
            StringBuilder sb = new StringBuilder(System.currentTimeMillis() + "");
            while (sb.length() < 13) {
                sb.insert(0, "0");
            }
            return ((Object) sb) + "-" + i + ' ';
        }
    }

    private a(File file, long j, int i) {
        if (!file.exists() && !file.mkdirs()) {
            throw new RuntimeException("can't make dirs in " + file.getAbsolutePath());
        }
        this.f3024b = new C0092a(file, j, i);
    }

    public static a a(File file) {
        return a(file, 50000000L, Integer.MAX_VALUE);
    }

    private static String c() {
        return "_" + Process.myPid();
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0066: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:52:0x0066 */
    public byte[] b(String str) {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        RandomAccessFile randomAccessFile3 = null;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                File a2 = this.f3024b.a(str);
                if (!a2.exists()) {
                    return null;
                }
                randomAccessFile2 = new RandomAccessFile(a2, "r");
                try {
                    SecurityUtil.securityCheck(randomAccessFile2.toString(), "read");
                    byte[] bArr = new byte[(int) randomAccessFile2.length()];
                    if (randomAccessFile2.read(bArr) > 0 && !b.c(bArr)) {
                        byte[] d2 = b.d(bArr);
                        try {
                            randomAccessFile2.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return d2;
                    }
                    try {
                        randomAccessFile2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    d(str);
                    return null;
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    if (randomAccessFile2 != null) {
                        try {
                            randomAccessFile2.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (Exception e5) {
                e = e5;
                randomAccessFile2 = null;
            } catch (Throwable th) {
                th = th;
                if (randomAccessFile3 != null) {
                    try {
                        randomAccessFile3.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile3 = randomAccessFile;
        }
    }

    public boolean d(String str) {
        return this.f3024b.c(str);
    }

    protected void finalize() throws Throwable {
        super.finalize();
    }

    public static a a(File file, long j, int i) {
        a aVar = f3023a.get(file.getAbsoluteFile() + c());
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a(file, j, i);
        f3023a.put(file.getAbsolutePath() + c(), aVar2);
        return aVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(java.lang.String r6) {
        /*
            r5 = this;
            byte[] r6 = r5.b(r6)
            r0 = 0
            if (r6 == 0) goto L6b
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3e
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L39 java.lang.Exception -> L3e
            java.io.ObjectInputStream r6 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L36
            r6.<init>(r1)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L36
            java.lang.String r2 = r6.toString()     // Catch: java.lang.Exception -> L2f java.lang.Throwable -> L57
            java.lang.String r3 = "readObject"
            com.video.androidsdk.common.util.SecurityUtil.securityCheck(r2, r3)     // Catch: java.lang.Exception -> L2f java.lang.Throwable -> L57
            java.lang.Object r0 = r6.readObject()     // Catch: java.lang.Exception -> L2f java.lang.Throwable -> L57
            r1.close()     // Catch: java.io.IOException -> L22
            goto L26
        L22:
            r1 = move-exception
            r1.printStackTrace()
        L26:
            r6.close()     // Catch: java.io.IOException -> L2a
            goto L2e
        L2a:
            r6 = move-exception
            r6.printStackTrace()
        L2e:
            return r0
        L2f:
            r2 = move-exception
            goto L41
        L31:
            r6 = move-exception
            r4 = r0
            r0 = r6
            r6 = r4
            goto L58
        L36:
            r2 = move-exception
            r6 = r0
            goto L41
        L39:
            r6 = move-exception
            r1 = r0
            r0 = r6
            r6 = r1
            goto L58
        L3e:
            r2 = move-exception
            r6 = r0
            r1 = r6
        L41:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L57
            r1.close()     // Catch: java.io.IOException -> L48
            goto L4c
        L48:
            r1 = move-exception
            r1.printStackTrace()
        L4c:
            if (r6 == 0) goto L56
            r6.close()     // Catch: java.io.IOException -> L52
            goto L56
        L52:
            r6 = move-exception
            r6.printStackTrace()
        L56:
            return r0
        L57:
            r0 = move-exception
        L58:
            r1.close()     // Catch: java.io.IOException -> L5c
            goto L60
        L5c:
            r1 = move-exception
            r1.printStackTrace()
        L60:
            if (r6 == 0) goto L6a
            r6.close()     // Catch: java.io.IOException -> L66
            goto L6a
        L66:
            r6 = move-exception
            r6.printStackTrace()
        L6a:
            throw r0
        L6b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.video.androidsdk.a.a.c(java.lang.String):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            com.video.androidsdk.a.a$a r0 = r4.f3024b
            java.io.File r5 = com.video.androidsdk.a.a.C0092a.a(r0, r5)
            r0 = 0
            java.io.FileWriter r1 = new java.io.FileWriter     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L40
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L40
            java.io.BufferedWriter r2 = new java.io.BufferedWriter     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L39
            r3 = 1024(0x400, float:1.435E-42)
            r2.<init>(r1, r3)     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L39
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L31 java.io.IOException -> L33
            java.lang.String r3 = "write"
            com.video.androidsdk.common.util.SecurityUtil.securityCheck(r0, r3)     // Catch: java.lang.Throwable -> L31 java.io.IOException -> L33
            r2.write(r6)     // Catch: java.lang.Throwable -> L31 java.io.IOException -> L33
            r2.flush()     // Catch: java.lang.Throwable -> L31 java.io.IOException -> L33
            r1.close()     // Catch: java.io.IOException -> L27
            goto L2b
        L27:
            r6 = move-exception
            r6.printStackTrace()
        L2b:
            r2.close()     // Catch: java.io.IOException -> L2f
            goto L59
        L2f:
            r6 = move-exception
            goto L56
        L31:
            r6 = move-exception
            goto L37
        L33:
            r6 = move-exception
            goto L3b
        L35:
            r6 = move-exception
            r2 = r0
        L37:
            r0 = r1
            goto L60
        L39:
            r6 = move-exception
            r2 = r0
        L3b:
            r0 = r1
            goto L42
        L3d:
            r6 = move-exception
            r2 = r0
            goto L60
        L40:
            r6 = move-exception
            r2 = r0
        L42:
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L5f
            if (r0 == 0) goto L4f
            r0.close()     // Catch: java.io.IOException -> L4b
            goto L4f
        L4b:
            r6 = move-exception
            r6.printStackTrace()
        L4f:
            if (r2 == 0) goto L59
            r2.close()     // Catch: java.io.IOException -> L55
            goto L59
        L55:
            r6 = move-exception
        L56:
            r6.printStackTrace()
        L59:
            com.video.androidsdk.a.a$a r6 = r4.f3024b
            com.video.androidsdk.a.a.C0092a.a(r6, r5)
            return
        L5f:
            r6 = move-exception
        L60:
            if (r0 == 0) goto L6a
            r0.close()     // Catch: java.io.IOException -> L66
            goto L6a
        L66:
            r0 = move-exception
            r0.printStackTrace()
        L6a:
            if (r2 == 0) goto L74
            r2.close()     // Catch: java.io.IOException -> L70
            goto L74
        L70:
            r0 = move-exception
            r0.printStackTrace()
        L74:
            com.video.androidsdk.a.a$a r0 = r4.f3024b
            com.video.androidsdk.a.a.C0092a.a(r0, r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.video.androidsdk.a.a.a(java.lang.String, java.lang.String):void");
    }

    public long b() {
        return this.f3024b.d();
    }

    public void a(String str, String str2, int i) {
        a(str, b.b(i, str2));
    }

    public String a(String str) {
        BufferedReader bufferedReader;
        File a2 = this.f3024b.a(str);
        if (!a2.exists()) {
            return "";
        }
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(a2));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            SecurityUtil.securityCheck(bufferedReader.toString(), "readLine");
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            if (!b.c(sb.toString())) {
                String d2 = b.d(sb.toString());
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return d2;
            }
            try {
                bufferedReader.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            d(str);
            return "";
        } catch (IOException e4) {
            e = e4;
            bufferedReader2 = bufferedReader;
            e.printStackTrace();
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            if (0 != 0) {
                d(str);
            }
            return "";
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            if (0 == 0) {
                throw th;
            }
            d(str);
            throw th;
        }
    }

    public void a(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        File b2 = this.f3024b.b(str);
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(b2);
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            SecurityUtil.securityCheck(fileOutputStream.toString(), "write");
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
            try {
                fileOutputStream.close();
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                this.f3024b.a(b2);
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e4) {
                    e = e4;
                    e.printStackTrace();
                    this.f3024b.a(b2);
                }
            }
            this.f3024b.a(b2);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            this.f3024b.a(b2);
            throw th;
        }
        this.f3024b.a(b2);
    }

    public void a(String str, byte[] bArr, int i) {
        a(str, b.b(i, bArr));
    }

    public void a(String str, Serializable serializable) {
        a(str, serializable, -1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.ObjectOutputStream] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x003d -> B:11:0x0040). Please report as a decompilation issue!!! */
    public void a(String str, Serializable serializable, int i) {
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        ?? r0 = 0;
        ObjectOutputStream objectOutputStream2 = null;
        r0 = 0;
        try {
            try {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            r0 = r0;
        }
        try {
            SecurityUtil.securityCheck(objectOutputStream.toString(), "writeObject");
            objectOutputStream.writeObject(serializable);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            r0 = -1;
            if (i != -1) {
                a(str, byteArray, i);
            } else {
                a(str, byteArray);
            }
            objectOutputStream.close();
        } catch (Exception e3) {
            e = e3;
            objectOutputStream2 = objectOutputStream;
            e.printStackTrace();
            r0 = objectOutputStream2;
            if (objectOutputStream2 != null) {
                objectOutputStream2.close();
                r0 = objectOutputStream2;
            }
        } catch (Throwable th2) {
            th = th2;
            r0 = objectOutputStream;
            if (r0 != 0) {
                try {
                    r0.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
            throw th;
        }
    }

    public void a() {
        this.f3024b.b();
    }
}
