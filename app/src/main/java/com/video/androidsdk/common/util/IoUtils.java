package com.video.androidsdk.common.util;

import java.io.Closeable;
import java.io.FilePermission;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class IoUtils {
    public static final int CONTINUE_LOADING_PERCENTAGE = 75;
    public static final int DEFAULT_BUFFER_SIZE = 32768;
    private static SecurityManager security = System.getSecurityManager();

    /* loaded from: classes.dex */
    public interface CopyListener {
        boolean onBytesCopied(int i, int i2);
    }

    private IoUtils() {
    }

    public static void closeSilently(Closeable closeable) {
        try {
            closeable.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean copyStream(InputStream inputStream, OutputStream outputStream, CopyListener copyListener) throws IOException {
        return copyStream(inputStream, outputStream, copyListener, DEFAULT_BUFFER_SIZE);
    }

    public static void readAndCloseStream(InputStream inputStream) {
        SecurityManager securityManager = security;
        if (securityManager != null) {
            securityManager.checkPermission(new FilePermission(inputStream.toString(), "read"));
        }
        do {
            try {
                try {
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } finally {
                closeSilently(inputStream);
            }
        } while (inputStream.read(new byte[DEFAULT_BUFFER_SIZE], 0, DEFAULT_BUFFER_SIZE) != -1);
    }

    private static boolean shouldStopLoading(CopyListener copyListener, int i, int i2) {
        return (copyListener == null || copyListener.onBytesCopied(i, i2) || (i * 100) / i2 >= 75) ? false : true;
    }

    public static boolean copyStream(InputStream inputStream, OutputStream outputStream, CopyListener copyListener, int i) throws IOException {
        SecurityManager securityManager = security;
        if (securityManager != null) {
            securityManager.checkPermission(new FilePermission(inputStream.toString(), "read"));
        }
        int available = inputStream.available();
        byte[] bArr = new byte[i];
        if (shouldStopLoading(copyListener, 0, available)) {
            return false;
        }
        int i2 = 0;
        do {
            int read = inputStream.read(bArr, 0, i);
            if (read == -1) {
                return true;
            }
            outputStream.write(bArr, 0, read);
            i2 += read;
        } while (!shouldStopLoading(copyListener, i2, available));
        return false;
    }
}
