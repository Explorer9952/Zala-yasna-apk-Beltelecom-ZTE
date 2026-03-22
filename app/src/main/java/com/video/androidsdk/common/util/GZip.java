package com.video.androidsdk.common.util;

import com.tencent.mm.sdk.platformtools.Util;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes.dex */
public class GZip {
    public static byte[] compress(byte[] bArr) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        compress(byteArrayInputStream, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        byteArrayInputStream.close();
        return byteArray;
    }

    public static String decompress(byte[] bArr) {
        return decompress(bArr, (String) null);
    }

    public static String decompress(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        return decompress(new ByteArrayInputStream(bArr), str);
    }

    public static String decompress(InputStream inputStream) {
        return decompress(inputStream, (String) null);
    }

    public static String decompress(InputStream inputStream, String str) {
        InputStreamReader inputStreamReader;
        if (inputStream == null) {
            return null;
        }
        try {
            GZIPInputStream gZIPInputStream = new GZIPInputStream(inputStream);
            if (str == null) {
                inputStreamReader = new InputStreamReader(gZIPInputStream, "utf-8");
            } else {
                inputStreamReader = new InputStreamReader(gZIPInputStream, str);
            }
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();
            SecurityUtil.securityCheck(bufferedReader.toString(), "readLine");
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    stringBuffer.append(readLine);
                    stringBuffer.append("\r\n");
                } else {
                    inputStreamReader.close();
                    gZIPInputStream.close();
                    return stringBuffer.toString();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void compress(InputStream inputStream, OutputStream outputStream) throws Exception {
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        byte[] bArr = new byte[Util.BYTE_OF_KB];
        SecurityUtil.securityCheck(inputStream.toString(), "read");
        while (true) {
            int read = inputStream.read(bArr, 0, Util.BYTE_OF_KB);
            if (read != -1) {
                gZIPOutputStream.write(bArr, 0, read);
            } else {
                gZIPOutputStream.finish();
                gZIPOutputStream.flush();
                gZIPOutputStream.close();
                return;
            }
        }
    }
}
