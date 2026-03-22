package com.zte.iptvclient.android.common.i.b;

import android.os.AsyncTask;
import com.tencent.mm.sdk.platformtools.Util;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.k.g;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

/* compiled from: DownloadAsyncTask.java */
/* loaded from: classes.dex */
public class a extends AsyncTask<String, Void, Boolean> {

    /* renamed from: a, reason: collision with root package name */
    private final String f4636a = a.class.getSimpleName();

    /* renamed from: b, reason: collision with root package name */
    private InterfaceC0133a f4637b;

    /* renamed from: c, reason: collision with root package name */
    private String f4638c;

    /* renamed from: d, reason: collision with root package name */
    private String f4639d;

    /* compiled from: DownloadAsyncTask.java */
    /* renamed from: com.zte.iptvclient.android.common.i.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0133a {
        void a(boolean z);
    }

    public a(String str, InterfaceC0133a interfaceC0133a) {
        this.f4638c = "";
        this.f4639d = "";
        this.f4637b = interfaceC0133a;
        this.f4638c = str;
        String str2 = this.f4638c + "/source/tempshow";
        this.f4639d = str2;
        com.zte.iptvclient.android.common.i.c.a.c(str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(String... strArr) {
        HttpEntity entity;
        int statusCode;
        FileOutputStream fileOutputStream;
        boolean z;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 60000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 60000);
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(basicHttpParams);
        try {
            String str = strArr[0];
            LogEx.d(this.f4636a, "downUrl=" + str);
            HttpResponse execute = defaultHttpClient.execute(new HttpGet(str));
            entity = execute.getEntity();
            statusCode = execute.getStatusLine().getStatusCode();
            LogEx.d(this.f4636a, "statusCode=" + statusCode);
        } catch (Exception e) {
            LogEx.d(this.f4636a, "download e=" + e.getMessage());
        }
        if (200 != statusCode) {
            return false;
        }
        long contentLength = entity.getContentLength();
        InputStream content = entity.getContent();
        if (content != null) {
            long j = 0;
            if (contentLength > 0) {
                String str2 = this.f4638c + "/source/resource.zip";
                LogEx.d(this.f4636a, ",fileName=" + str2);
                File file = new File(str2);
                if (file.exists()) {
                    com.zte.iptvclient.android.common.i.c.a.c(str2);
                }
                com.zte.iptvclient.android.common.i.c.a.b(str2);
                BufferedOutputStream bufferedOutputStream2 = null;
                try {
                    bufferedInputStream = new BufferedInputStream(content);
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        try {
                            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                        } catch (Exception e2) {
                            e = e2;
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                }
                try {
                    byte[] bArr = new byte[Util.BYTE_OF_KB];
                    g.b(bufferedInputStream.toString(), "read");
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        g.b(bufferedOutputStream.toString(), "write");
                        bufferedOutputStream.write(bArr, 0, read);
                        j += read;
                    }
                    bufferedOutputStream.flush();
                    if (j != contentLength) {
                        LogEx.d(this.f4636a, "download fail count=" + j + ",length=" + contentLength);
                        com.zte.iptvclient.android.common.i.c.a.c(str2);
                        z = false;
                    } else {
                        LogEx.d(this.f4636a, "download success");
                        z = true;
                    }
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                    try {
                        fileOutputStream.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                } catch (Exception e6) {
                    e = e6;
                    bufferedOutputStream2 = bufferedOutputStream;
                    LogEx.d(this.f4636a, "write file e=" + e.getMessage());
                    com.zte.iptvclient.android.common.i.c.a.c(str2);
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (Exception e7) {
                            e7.printStackTrace();
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e8) {
                            e8.printStackTrace();
                        }
                    }
                    z = false;
                    LogEx.d(this.f4636a, "download success");
                    if (z) {
                        a(this.f4638c + "/source/tempshow/finish.txt");
                        return true;
                    }
                    com.zte.iptvclient.android.common.i.c.a.c(this.f4639d);
                    return false;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream2 = bufferedOutputStream;
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (Exception e9) {
                            e9.printStackTrace();
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            throw th;
                        } catch (Exception e10) {
                            e10.printStackTrace();
                            throw th;
                        }
                    }
                    throw th;
                }
                LogEx.d(this.f4636a, "download success");
                if (z && a(str2, this.f4639d)) {
                    a(this.f4638c + "/source/tempshow/finish.txt");
                    return true;
                }
                com.zte.iptvclient.android.common.i.c.a.c(this.f4639d);
                return false;
            }
        }
        LogEx.d(this.f4636a, "InputStream is null");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        InterfaceC0133a interfaceC0133a = this.f4637b;
        if (interfaceC0133a != null) {
            interfaceC0133a.a(bool.booleanValue());
        }
    }

    public boolean a(String str, String str2) {
        ZipInputStream zipInputStream;
        ZipInputStream zipInputStream2 = null;
        try {
            try {
                zipInputStream = new ZipInputStream(new FileInputStream(new File(str)));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            LogEx.d(this.f4636a, "inZip=" + zipInputStream);
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    break;
                }
                String name = nextEntry.getName();
                LogEx.d(this.f4636a, "szName:" + name);
                if (nextEntry.isDirectory()) {
                    new File(str2 + File.separator + name.substring(0, name.length() - 1));
                }
            }
            zipInputStream.close();
            try {
                zipInputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return true;
        } catch (Exception e3) {
            e = e3;
            zipInputStream2 = zipInputStream;
            LogEx.d(this.f4636a, "e=" + e.getMessage());
            if (zipInputStream2 != null) {
                try {
                    zipInputStream2.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            zipInputStream2 = zipInputStream;
            if (zipInputStream2 != null) {
                try {
                    zipInputStream2.close();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
            throw th;
        }
    }

    private boolean a(String str) {
        if (new File(str).exists()) {
            com.zte.iptvclient.android.common.i.c.a.c(str);
        }
        com.zte.iptvclient.android.common.i.c.a.b(str);
        return false;
    }
}
