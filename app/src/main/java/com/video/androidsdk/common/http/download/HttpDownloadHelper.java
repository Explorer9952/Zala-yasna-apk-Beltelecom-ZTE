package com.video.androidsdk.common.http.download;

import android.text.TextUtils;
import com.video.androidsdk.SDKMgr;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.PortalConst;
import com.video.androidsdk.common.http.SessionMgr;
import com.video.androidsdk.common.http.bean.HttpAttribute;
import com.video.androidsdk.common.http.bean.HttpRequest;
import com.video.androidsdk.common.http.bean.HttpResponse;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class HttpDownloadHelper {
    public static final String CHARSET_PARAM = "; charset=";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String DEFAULT_CHARSET = "UTF-8";
    private static final int Default_Timeout_Connection = 10000;
    private static final int Default_Timeout_Socket = 10000;
    public static final String ISO_8859_1 = "ISO-8859-1";
    private static final String LOG_TAG = "HttpDownloadHelper";
    public static final String UTF_8 = "UTF-8";

    public static String encodeURL(String str, String str2) {
        LogEx.d(LOG_TAG, "encoding start = " + str2);
        if (TextUtils.isEmpty(str)) {
            LogEx.w(LOG_TAG, "URL is empty!");
            return null;
        }
        String propertiesInfo = SDKLoginMgr.getInstance().getPropertiesInfo(PortalConst.STR_EPG_SERVER_ENCODER_MODE);
        if (!TextUtils.isEmpty(SDKLoginMgr.getInstance().getEPGHome()) && str.contains(SDKLoginMgr.getInstance().getEPGHome())) {
            if (!TextUtils.isEmpty(SDKMgr.getEPGCharset())) {
                str2 = SDKMgr.getEPGCharset();
                LogEx.d(LOG_TAG, "set encoding by sdkmgr getepgcharset:" + str2);
            } else if (!TextUtils.isEmpty(propertiesInfo)) {
                LogEx.d(LOG_TAG, "set encoding by PropertiesInfo:" + propertiesInfo);
                str2 = propertiesInfo;
            }
        }
        LogEx.d(LOG_TAG, "encoding finally = " + str2);
        LogEx.d(LOG_TAG, "URL=" + str);
        try {
            URL url = new URL(str);
            StringBuilder sb = new StringBuilder();
            String protocol = url.getProtocol();
            String host = url.getHost();
            int port = url.getPort();
            String path = url.getPath();
            String query = url.getQuery();
            if (-1 == port) {
                port = url.getDefaultPort();
            }
            sb.append(protocol);
            sb.append("://");
            sb.append(tryEncode(host, str2));
            sb.append(":");
            sb.append(port);
            if (!TextUtils.isEmpty(path)) {
                int indexOf = path.indexOf(";jsessionid=");
                if (-1 != indexOf) {
                    String substring = path.substring(indexOf + 12);
                    for (String str3 : path.substring(1, indexOf).split("/")) {
                        sb.append("/");
                        sb.append(tryEncode(str3, str2));
                    }
                    sb.append(";jsessionid=");
                    sb.append(tryEncode(substring, str2));
                    if (TextUtils.equals(path.substring(indexOf - 1), "/")) {
                        sb.append("/");
                    }
                } else {
                    for (String str4 : path.substring(1).split("/")) {
                        sb.append("/");
                        sb.append(tryEncode(str4, str2));
                    }
                    if (path.endsWith("/")) {
                        sb.append("/");
                    }
                }
            }
            if (!TextUtils.isEmpty(query)) {
                sb.append("?");
                String[] split = query.split("&");
                for (String str5 : split) {
                    int indexOf2 = str5.indexOf("=");
                    if (-1 != indexOf2) {
                        String substring2 = str5.substring(0, indexOf2);
                        String substring3 = str5.substring(indexOf2 + 1);
                        sb.append(tryEncode(substring2, str2));
                        sb.append("=");
                        sb.append(tryEncode(substring3, str2));
                        sb.append("&");
                    }
                }
                sb.replace(sb.length() - 1, sb.length(), "");
            }
            return sb.toString();
        } catch (MalformedURLException e) {
            LogEx.e(LOG_TAG, "URI is error:" + str + " : " + e.getMessage());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x028d A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0283  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.video.androidsdk.common.http.bean.HttpResponse get(com.video.androidsdk.common.http.bean.HttpRequest r17, com.video.androidsdk.common.http.bean.HttpAttribute r18) {
        /*
            Method dump skipped, instructions count: 718
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.video.androidsdk.common.http.download.HttpDownloadHelper.get(com.video.androidsdk.common.http.bean.HttpRequest, com.video.androidsdk.common.http.bean.HttpAttribute):com.video.androidsdk.common.http.bean.HttpResponse");
    }

    private static String getCharset(Map<String, String> map, Map<String, String> map2) {
        if (map == null && map2 == null) {
            LogEx.d(LOG_TAG, "response data charset is : ISO-8859-1");
            return "ISO-8859-1";
        }
        String str = null;
        if (map != null && map.containsKey("Content-Type")) {
            str = map.get("Content-Type");
        }
        if (!StringUtil.isEmptyString(str)) {
            String charsetFromContentType = getCharsetFromContentType(str);
            LogEx.d(LOG_TAG, "getCharset() response data charset is : " + charsetFromContentType);
            if (!StringUtil.isEmptyString(charsetFromContentType)) {
                return charsetFromContentType;
            }
        }
        if (map2 != null && map2.containsKey("Content-Type")) {
            str = map2.get("Content-Type");
        }
        if (!StringUtil.isEmptyString(str)) {
            String charsetFromContentType2 = getCharsetFromContentType(str);
            LogEx.d(LOG_TAG, "getCharset() request data charset is : " + charsetFromContentType2);
            if (!StringUtil.isEmptyString(charsetFromContentType2)) {
                return charsetFromContentType2;
            }
        }
        return "ISO-8859-1";
    }

    private static String getCharsetFromContentType(String str) {
        String str2 = null;
        for (String str3 : str.split(";")) {
            String str4 = "; " + str3.trim();
            if (str4.startsWith("; charset=") && str4.length() > 10) {
                str2 = str4.substring(10);
            }
        }
        return str2;
    }

    private static HashMap<String, String> getRspHeaderMap(URLConnection uRLConnection) {
        List<String> value;
        if (uRLConnection == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        Map<String, List<String>> headerFields = uRLConnection.getHeaderFields();
        if (headerFields == null) {
            return null;
        }
        for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
            String key = entry.getKey();
            if (key != null && (value = entry.getValue()) != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<String> it2 = value.iterator();
                while (it2.hasNext()) {
                    sb.append(it2.next());
                    sb.append(";");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                hashMap.put(key, sb.toString());
            }
        }
        return hashMap;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    private static com.video.androidsdk.common.http.bean.HttpResponse httpClientGet(java.lang.String r16, java.lang.String r17, int r18, int r19, java.util.Map<java.lang.String, java.lang.String> r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 1059
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.video.androidsdk.common.http.download.HttpDownloadHelper.httpClientGet(java.lang.String, java.lang.String, int, int, java.util.Map, boolean):com.video.androidsdk.common.http.bean.HttpResponse");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:(3:411|412|(39:416|19|(5:22|23|24|(1:26)(1:29)|27)|(5:249|(2:252|250)|253|254|(2:257|(1:259)(1:260)))|(1:262)|(1:264)|266|267|268|269|271|272|273|274|275|277|278|279|280|(2:281|(3:283|284|286)(1:290))|291|292|293|294|(1:296)(2:338|(1:340)(1:341))|297|(1:299)|300|(1:302)|(2:332|333)|304|305|307|308|309|310|(2:319|320)|(2:314|315)|313))|293|294|(0)(0)|297|(0)|300|(0)|(0)|304|305|307|308|309|310|(0)|(0)|313) */
    /* JADX WARN: Can't wrap try/catch for region: R(20:13|14|(4:434|435|(2:438|436)|439)|16|(25:(3:411|412|(39:416|19|(5:22|23|24|(1:26)(1:29)|27)|(5:249|(2:252|250)|253|254|(2:257|(1:259)(1:260)))|(1:262)|(1:264)|266|267|268|269|271|272|273|274|275|277|278|279|280|(2:281|(3:283|284|286)(1:290))|291|292|293|294|(1:296)(2:338|(1:340)(1:341))|297|(1:299)|300|(1:302)|(2:332|333)|304|305|307|308|309|310|(2:319|320)|(2:314|315)|313))|277|278|279|280|(3:281|(0)(0)|286)|291|292|293|294|(0)(0)|297|(0)|300|(0)|(0)|304|305|307|308|309|310|(0)|(0)|313)|18|19|(5:22|23|24|(0)(0)|27)|(6:247|249|(1:250)|253|254|(2:257|(0)(0)))|(0)|(0)|266|267|268|269|271|272|273|274|275) */
    /* JADX WARN: Can't wrap try/catch for region: R(6:(18:(3:411|412|(39:416|19|(5:22|23|24|(1:26)(1:29)|27)|(5:249|(2:252|250)|253|254|(2:257|(1:259)(1:260)))|(1:262)|(1:264)|266|267|268|269|271|272|273|274|275|277|278|279|280|(2:281|(3:283|284|286)(1:290))|291|292|293|294|(1:296)(2:338|(1:340)(1:341))|297|(1:299)|300|(1:302)|(2:332|333)|304|305|307|308|309|310|(2:319|320)|(2:314|315)|313))|293|294|(0)(0)|297|(0)|300|(0)|(0)|304|305|307|308|309|310|(0)|(0)|313)|279|280|(3:281|(0)(0)|286)|291|292) */
    /* JADX WARN: Code restructure failed: missing block: B:325:0x0328, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:326:0x0329, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:328:0x031f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:329:0x0320, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:330:0x0316, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:331:0x0317, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:347:0x035d, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:348:0x035e, code lost:
    
        r18 = "Timeout.";
     */
    /* JADX WARN: Code restructure failed: missing block: B:349:0x0366, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:350:0x0367, code lost:
    
        r1 = r0;
        r8 = "Timeout.";
        r9 = r10;
        r16 = r15;
        r3 = r3;
        r4 = r4;
        r6 = r6;
        r14 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:368:0x03a8, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:369:0x03a9, code lost:
    
        r1 = r0;
        r9 = r10;
        r3 = r3;
        r4 = r4;
        r6 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:370:0x03a2, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:371:0x03a3, code lost:
    
        r1 = r0;
        r8 = "Timeout.";
        r9 = r10;
        r3 = r3;
        r4 = r4;
        r6 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:372:0x039b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:373:0x039c, code lost:
    
        r18 = "Timeout.";
        r1 = r0;
        r9 = r10;
        r3 = r3;
        r4 = r4;
        r6 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:374:0x0396, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:375:0x0397, code lost:
    
        r2 = r0;
        r9 = r10;
        r3 = r3;
        r4 = r4;
        r6 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:376:0x0391, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:377:0x0392, code lost:
    
        r1 = r0;
        r9 = r10;
        r3 = r3;
        r4 = r4;
        r6 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:381:0x021a, code lost:
    
        com.video.androidsdk.log.LogEx.d(com.video.androidsdk.common.http.download.HttpDownloadHelper.LOG_TAG, "conn getErrorStream");
        r4 = r10.getErrorStream();
     */
    /* JADX WARN: Code restructure failed: missing block: B:385:0x022a, code lost:
    
        r6 = r4;
        r4 = new java.io.BufferedInputStream(r4);
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:387:0x03cc, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:388:0x03cd, code lost:
    
        r1 = r0;
        r6 = r4;
        r9 = r10;
        r4 = null;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:389:0x03c4, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:390:0x03c5, code lost:
    
        r1 = r0;
        r6 = r4;
        r8 = "Timeout.";
        r9 = r10;
        r4 = null;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:391:0x03bb, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:392:0x03bc, code lost:
    
        r18 = "Timeout.";
        r1 = r0;
        r6 = r4;
        r9 = r10;
        r4 = null;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:393:0x03b4, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:394:0x03b5, code lost:
    
        r2 = r0;
        r6 = r4;
        r9 = r10;
        r4 = null;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:395:0x03ad, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:396:0x03ae, code lost:
    
        r1 = r0;
        r6 = r4;
        r9 = r10;
        r4 = null;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:397:0x03ea, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:398:0x03eb, code lost:
    
        r1 = r0;
        r9 = r10;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:399:0x03e4, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:400:0x03e5, code lost:
    
        r1 = r0;
        r8 = "Timeout.";
        r9 = r10;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:401:0x03dd, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:402:0x03de, code lost:
    
        r18 = "Timeout.";
        r1 = r0;
        r9 = r10;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:403:0x03d8, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:404:0x03d9, code lost:
    
        r2 = r0;
        r9 = r10;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:405:0x03d3, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:406:0x03d4, code lost:
    
        r1 = r0;
        r9 = r10;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:407:0x0219, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:409:0x03ef, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:410:0x03f0, code lost:
    
        r18 = "Timeout.";
        r1 = r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x051e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0513 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0508 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x04fd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x04f2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x05db  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0617 A[Catch: IOException -> 0x04ae, TRY_ENTER, TRY_LEAVE, TryCatch #59 {IOException -> 0x04ae, blocks: (B:220:0x04a9, B:95:0x0529, B:180:0x059f, B:140:0x0617), top: B:2:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x060c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0601 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x05f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x05eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x05e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0563  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x059f A[Catch: IOException -> 0x04ae, TRY_ENTER, TRY_LEAVE, TryCatch #59 {IOException -> 0x04ae, blocks: (B:220:0x04a9, B:95:0x0529, B:180:0x059f, B:140:0x0617), top: B:2:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0594 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0589 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x057e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0573 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0568 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:213:0x046d  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x04a9 A[Catch: IOException -> 0x04ae, TRY_ENTER, TRY_LEAVE, TryCatch #59 {IOException -> 0x04ae, blocks: (B:220:0x04a9, B:95:0x0529, B:180:0x059f, B:140:0x0617), top: B:2:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:221:0x049e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0493 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0488 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x047d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0472 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0161 A[Catch: all -> 0x01cc, IOException -> 0x01d4, ConnectTimeoutException -> 0x01dc, SocketTimeoutException -> 0x01e6, MalformedURLException -> 0x01ef, LOOP:0: B:250:0x015b->B:252:0x0161, LOOP_END, TryCatch #37 {all -> 0x01cc, blocks: (B:23:0x0102, B:26:0x0118, B:29:0x0120, B:32:0x0135, B:33:0x013d, B:247:0x0146, B:249:0x014c, B:250:0x015b, B:252:0x0161, B:254:0x018a, B:257:0x01aa, B:259:0x01b4, B:260:0x01c0, B:262:0x01f9, B:264:0x01fe, B:267:0x0204, B:269:0x0207), top: B:22:0x0102 }] */
    /* JADX WARN: Removed duplicated region for block: B:259:0x01b4 A[Catch: all -> 0x01cc, IOException -> 0x01d4, ConnectTimeoutException -> 0x01dc, SocketTimeoutException -> 0x01e6, MalformedURLException -> 0x01ef, TryCatch #37 {all -> 0x01cc, blocks: (B:23:0x0102, B:26:0x0118, B:29:0x0120, B:32:0x0135, B:33:0x013d, B:247:0x0146, B:249:0x014c, B:250:0x015b, B:252:0x0161, B:254:0x018a, B:257:0x01aa, B:259:0x01b4, B:260:0x01c0, B:262:0x01f9, B:264:0x01fe, B:267:0x0204, B:269:0x0207), top: B:22:0x0102 }] */
    /* JADX WARN: Removed duplicated region for block: B:260:0x01c0 A[Catch: all -> 0x01cc, IOException -> 0x01d4, ConnectTimeoutException -> 0x01dc, SocketTimeoutException -> 0x01e6, MalformedURLException -> 0x01ef, TryCatch #37 {all -> 0x01cc, blocks: (B:23:0x0102, B:26:0x0118, B:29:0x0120, B:32:0x0135, B:33:0x013d, B:247:0x0146, B:249:0x014c, B:250:0x015b, B:252:0x0161, B:254:0x018a, B:257:0x01aa, B:259:0x01b4, B:260:0x01c0, B:262:0x01f9, B:264:0x01fe, B:267:0x0204, B:269:0x0207), top: B:22:0x0102 }] */
    /* JADX WARN: Removed duplicated region for block: B:262:0x01f9 A[Catch: all -> 0x01cc, IOException -> 0x01d4, ConnectTimeoutException -> 0x01dc, SocketTimeoutException -> 0x01e6, MalformedURLException -> 0x01ef, TryCatch #37 {all -> 0x01cc, blocks: (B:23:0x0102, B:26:0x0118, B:29:0x0120, B:32:0x0135, B:33:0x013d, B:247:0x0146, B:249:0x014c, B:250:0x015b, B:252:0x0161, B:254:0x018a, B:257:0x01aa, B:259:0x01b4, B:260:0x01c0, B:262:0x01f9, B:264:0x01fe, B:267:0x0204, B:269:0x0207), top: B:22:0x0102 }] */
    /* JADX WARN: Removed duplicated region for block: B:264:0x01fe A[Catch: all -> 0x01cc, IOException -> 0x01d4, ConnectTimeoutException -> 0x01dc, SocketTimeoutException -> 0x01e6, MalformedURLException -> 0x01ef, TRY_LEAVE, TryCatch #37 {all -> 0x01cc, blocks: (B:23:0x0102, B:26:0x0118, B:29:0x0120, B:32:0x0135, B:33:0x013d, B:247:0x0146, B:249:0x014c, B:250:0x015b, B:252:0x0161, B:254:0x018a, B:257:0x01aa, B:259:0x01b4, B:260:0x01c0, B:262:0x01f9, B:264:0x01fe, B:267:0x0204, B:269:0x0207), top: B:22:0x0102 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0118 A[Catch: UnsupportedEncodingException -> 0x0132, all -> 0x01cc, IOException -> 0x01d4, ConnectTimeoutException -> 0x01dc, SocketTimeoutException -> 0x01e6, MalformedURLException -> 0x01ef, TRY_ENTER, TryCatch #37 {all -> 0x01cc, blocks: (B:23:0x0102, B:26:0x0118, B:29:0x0120, B:32:0x0135, B:33:0x013d, B:247:0x0146, B:249:0x014c, B:250:0x015b, B:252:0x0161, B:254:0x018a, B:257:0x01aa, B:259:0x01b4, B:260:0x01c0, B:262:0x01f9, B:264:0x01fe, B:267:0x0204, B:269:0x0207), top: B:22:0x0102 }] */
    /* JADX WARN: Removed duplicated region for block: B:283:0x026b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:290:0x027a A[EDGE_INSN: B:290:0x027a->B:291:0x027a BREAK  A[LOOP:1: B:281:0x0265->B:286:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:296:0x029a A[Catch: ConnectTimeoutException -> 0x0344, SocketTimeoutException -> 0x0346, all -> 0x034f, IOException -> 0x0356, MalformedURLException -> 0x036e, TryCatch #90 {SocketTimeoutException -> 0x0346, ConnectTimeoutException -> 0x0344, blocks: (B:294:0x0287, B:296:0x029a, B:297:0x02b8, B:299:0x02dd, B:300:0x02fa, B:340:0x02a7, B:341:0x02af), top: B:293:0x0287 }] */
    /* JADX WARN: Removed duplicated region for block: B:299:0x02dd A[Catch: ConnectTimeoutException -> 0x0344, SocketTimeoutException -> 0x0346, all -> 0x034f, IOException -> 0x0356, MalformedURLException -> 0x036e, TryCatch #90 {SocketTimeoutException -> 0x0346, ConnectTimeoutException -> 0x0344, blocks: (B:294:0x0287, B:296:0x029a, B:297:0x02b8, B:299:0x02dd, B:300:0x02fa, B:340:0x02a7, B:341:0x02af), top: B:293:0x0287 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0120 A[Catch: UnsupportedEncodingException -> 0x0132, all -> 0x01cc, IOException -> 0x01d4, ConnectTimeoutException -> 0x01dc, SocketTimeoutException -> 0x01e6, MalformedURLException -> 0x01ef, TRY_LEAVE, TryCatch #37 {all -> 0x01cc, blocks: (B:23:0x0102, B:26:0x0118, B:29:0x0120, B:32:0x0135, B:33:0x013d, B:247:0x0146, B:249:0x014c, B:250:0x015b, B:252:0x0161, B:254:0x018a, B:257:0x01aa, B:259:0x01b4, B:260:0x01c0, B:262:0x01f9, B:264:0x01fe, B:267:0x0204, B:269:0x0207), top: B:22:0x0102 }] */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x033a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:319:0x032f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:332:0x0309 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:338:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x061f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x065b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0650 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0645 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x063a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x062f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0624 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x04ed  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0529 A[Catch: IOException -> 0x04ae, TRY_ENTER, TRY_LEAVE, TryCatch #59 {IOException -> 0x04ae, blocks: (B:220:0x04a9, B:95:0x0529, B:180:0x059f, B:140:0x0617), top: B:2:0x0022 }] */
    /* JADX WARN: Type inference failed for: r14v10, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v14, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r14v4, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r14v42 */
    /* JADX WARN: Type inference failed for: r14v43 */
    /* JADX WARN: Type inference failed for: r14v44 */
    /* JADX WARN: Type inference failed for: r14v45 */
    /* JADX WARN: Type inference failed for: r14v47 */
    /* JADX WARN: Type inference failed for: r14v48 */
    /* JADX WARN: Type inference failed for: r14v49 */
    /* JADX WARN: Type inference failed for: r14v50 */
    /* JADX WARN: Type inference failed for: r14v51 */
    /* JADX WARN: Type inference failed for: r14v52 */
    /* JADX WARN: Type inference failed for: r14v53 */
    /* JADX WARN: Type inference failed for: r14v55 */
    /* JADX WARN: Type inference failed for: r14v56 */
    /* JADX WARN: Type inference failed for: r14v57 */
    /* JADX WARN: Type inference failed for: r14v59 */
    /* JADX WARN: Type inference failed for: r14v60 */
    /* JADX WARN: Type inference failed for: r14v61 */
    /* JADX WARN: Type inference failed for: r14v62 */
    /* JADX WARN: Type inference failed for: r14v64 */
    /* JADX WARN: Type inference failed for: r14v65 */
    /* JADX WARN: Type inference failed for: r14v66 */
    /* JADX WARN: Type inference failed for: r14v7, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v106 */
    /* JADX WARN: Type inference failed for: r3v107 */
    /* JADX WARN: Type inference failed for: r3v108 */
    /* JADX WARN: Type inference failed for: r3v116 */
    /* JADX WARN: Type inference failed for: r3v117 */
    /* JADX WARN: Type inference failed for: r3v118 */
    /* JADX WARN: Type inference failed for: r3v119 */
    /* JADX WARN: Type inference failed for: r3v127 */
    /* JADX WARN: Type inference failed for: r3v128 */
    /* JADX WARN: Type inference failed for: r3v129 */
    /* JADX WARN: Type inference failed for: r3v15, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v18, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v21, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v92 */
    /* JADX WARN: Type inference failed for: r3v93 */
    /* JADX WARN: Type inference failed for: r3v94 */
    /* JADX WARN: Type inference failed for: r3v95 */
    /* JADX WARN: Type inference failed for: r3v96 */
    /* JADX WARN: Type inference failed for: r3v97 */
    /* JADX WARN: Type inference failed for: r3v98 */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v100 */
    /* JADX WARN: Type inference failed for: r4v101 */
    /* JADX WARN: Type inference failed for: r4v102 */
    /* JADX WARN: Type inference failed for: r4v103 */
    /* JADX WARN: Type inference failed for: r4v108 */
    /* JADX WARN: Type inference failed for: r4v109 */
    /* JADX WARN: Type inference failed for: r4v110 */
    /* JADX WARN: Type inference failed for: r4v15, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v18, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v21, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v25, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v82 */
    /* JADX WARN: Type inference failed for: r4v83 */
    /* JADX WARN: Type inference failed for: r4v84 */
    /* JADX WARN: Type inference failed for: r4v85 */
    /* JADX WARN: Type inference failed for: r4v86 */
    /* JADX WARN: Type inference failed for: r4v87 */
    /* JADX WARN: Type inference failed for: r4v88 */
    /* JADX WARN: Type inference failed for: r4v93 */
    /* JADX WARN: Type inference failed for: r4v94 */
    /* JADX WARN: Type inference failed for: r4v95 */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.video.androidsdk.common.http.bean.HttpResponse] */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v3, types: [com.video.androidsdk.common.http.bean.HttpResponse] */
    /* JADX WARN: Type inference failed for: r5v4, types: [com.video.androidsdk.common.http.bean.HttpResponse] */
    /* JADX WARN: Type inference failed for: r5v5, types: [com.video.androidsdk.common.http.bean.HttpResponse] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [com.video.androidsdk.common.http.bean.HttpResponse] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v104 */
    /* JADX WARN: Type inference failed for: r6v105 */
    /* JADX WARN: Type inference failed for: r6v106 */
    /* JADX WARN: Type inference failed for: r6v107 */
    /* JADX WARN: Type inference failed for: r6v112 */
    /* JADX WARN: Type inference failed for: r6v113 */
    /* JADX WARN: Type inference failed for: r6v114 */
    /* JADX WARN: Type inference failed for: r6v15, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v18, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v21, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v86 */
    /* JADX WARN: Type inference failed for: r6v87 */
    /* JADX WARN: Type inference failed for: r6v88 */
    /* JADX WARN: Type inference failed for: r6v89 */
    /* JADX WARN: Type inference failed for: r6v90 */
    /* JADX WARN: Type inference failed for: r6v91 */
    /* JADX WARN: Type inference failed for: r6v92 */
    /* JADX WARN: Type inference failed for: r6v97 */
    /* JADX WARN: Type inference failed for: r6v98 */
    /* JADX WARN: Type inference failed for: r6v99 */
    /* JADX WARN: Type inference failed for: r9v81, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.video.androidsdk.common.http.bean.HttpResponse httpPost(java.lang.String r20, java.lang.String r21, int r22, int r23, java.util.Map<java.lang.String, java.lang.String> r24, java.lang.String r25, java.util.HashMap<java.lang.String, java.lang.String> r26, java.lang.String r27) {
        /*
            Method dump skipped, instructions count: 1639
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.video.androidsdk.common.http.download.HttpDownloadHelper.httpPost(java.lang.String, java.lang.String, int, int, java.util.Map, java.lang.String, java.util.HashMap, java.lang.String):com.video.androidsdk.common.http.bean.HttpResponse");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x020c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x020d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.video.androidsdk.common.http.bean.HttpResponse post(com.video.androidsdk.common.http.bean.HttpRequest r16, com.video.androidsdk.common.http.bean.HttpAttribute r17) {
        /*
            Method dump skipped, instructions count: 587
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.video.androidsdk.common.http.download.HttpDownloadHelper.post(com.video.androidsdk.common.http.bean.HttpRequest, com.video.androidsdk.common.http.bean.HttpAttribute):com.video.androidsdk.common.http.bean.HttpResponse");
    }

    private static void refreshSession(HttpResponse httpResponse, String str) {
        int i = 0;
        if (ErrCode.getErrCode(ErrCode.ERRCODE_HTTP_MODELCODE, 0) != httpResponse.getReturnCode()) {
            return;
        }
        Map<String, String> headerMap = httpResponse.getHeaderMap();
        String str2 = null;
        String str3 = headerMap != null ? headerMap.get("Set-Cookie") : null;
        if (str3 != null) {
            String[] split = str3.split(";");
            int length = split.length;
            while (true) {
                if (i >= length) {
                    break;
                }
                String str4 = split[i];
                if (str4.startsWith("JSESSIONID=")) {
                    str2 = str4.replaceFirst("JSESSIONID=", "");
                    break;
                }
                i++;
            }
        }
        if (str2 != null) {
            LogEx.d(LOG_TAG, "putSessionID:domain=" + str + ";jsessionid=" + str2);
            SessionMgr.getInstance().putSessionID(str, str2);
        }
    }

    public static HttpResponse send(HttpRequest httpRequest) {
        return send(httpRequest, null);
    }

    private static String tryEncode(String str, String str2) {
        if (str == null) {
            return str;
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e) {
            LogEx.w(LOG_TAG, str2 + " not support." + e.getMessage());
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return str;
            }
        }
    }

    public static HttpResponse send(HttpRequest httpRequest, HttpAttribute httpAttribute) {
        if (httpRequest == null) {
            LogEx.w(LOG_TAG, "HttpRequest is null!");
            return new HttpResponse(ErrCode.getErrCode(ErrCode.ERRCODE_HTTP_MODELCODE, 2));
        }
        String method = httpRequest.getMethod();
        LogEx.d(LOG_TAG, "Request method:" + method);
        if (TextUtils.isEmpty(method)) {
            LogEx.w(LOG_TAG, "HttpRequest method is null!");
            return new HttpResponse(ErrCode.getErrCode(ErrCode.ERRCODE_HTTP_MODELCODE, 2));
        }
        if (HttpRequest.METHOD_GET.equals(method)) {
            return get(httpRequest, httpAttribute);
        }
        if (HttpRequest.METHOD_POST.equals(method)) {
            return post(httpRequest, httpAttribute);
        }
        LogEx.w(LOG_TAG, "HttpRequest method unknow:" + method);
        return new HttpResponse(ErrCode.getErrCode(ErrCode.ERRCODE_HTTP_MODELCODE, 3));
    }
}
