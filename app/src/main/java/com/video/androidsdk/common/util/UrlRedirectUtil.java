package com.video.androidsdk.common.util;

import android.os.AsyncTask;
import android.util.Log;

/* loaded from: classes.dex */
public class UrlRedirectUtil {
    private static String LOG_TAG = "UrlRedirectUtil";
    private static String RET_FAIl = "fail";
    private static String RET_GET = "get";
    private static String RET_REDO = "redo";
    private UrlRedirectListener callback;
    private String finalUrl = "";
    private getUrlAfterRedirectionTask getUrlTask;
    private String oriPlayUrl;

    /* loaded from: classes.dex */
    public interface UrlRedirectListener {
        void onUrlRedirected(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class getUrlAfterRedirectionTask extends AsyncTask<String, String, String> {
        private getUrlAfterRedirectionTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00bc  */
        /* JADX WARN: Type inference failed for: r6v2 */
        /* JADX WARN: Type inference failed for: r6v5, types: [java.net.HttpURLConnection] */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String doInBackground(java.lang.String... r6) {
            /*
                r5 = this;
                r0 = 0
                java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> La3 java.io.IOException -> La8
                r2 = 0
                r6 = r6[r2]     // Catch: java.lang.Throwable -> La3 java.io.IOException -> La8
                r1.<init>(r6)     // Catch: java.lang.Throwable -> La3 java.io.IOException -> La8
                java.net.URLConnection r6 = r1.openConnection()     // Catch: java.lang.Throwable -> La3 java.io.IOException -> La8
                java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch: java.lang.Throwable -> La3 java.io.IOException -> La8
                if (r6 != 0) goto L1b
                java.lang.String r0 = com.video.androidsdk.common.util.UrlRedirectUtil.access$100()     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lb9
                if (r6 == 0) goto L1a
                r6.disconnect()
            L1a:
                return r0
            L1b:
                java.lang.String r0 = "GET"
                r6.setRequestMethod(r0)     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lb9
                int r0 = r6.getResponseCode()     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lb9
                r1 = 200(0xc8, float:2.8E-43)
                if (r0 != r1) goto L3f
                com.video.androidsdk.common.util.UrlRedirectUtil r0 = com.video.androidsdk.common.util.UrlRedirectUtil.this     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lb9
                java.net.URL r1 = r6.getURL()     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lb9
                java.lang.String r1 = r1.toString()     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lb9
                com.video.androidsdk.common.util.UrlRedirectUtil.access$202(r0, r1)     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lb9
                java.lang.String r0 = com.video.androidsdk.common.util.UrlRedirectUtil.access$300()     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lb9
                if (r6 == 0) goto L3e
                r6.disconnect()
            L3e:
                return r0
            L3f:
                r1 = 302(0x12e, float:4.23E-43)
                if (r0 != r1) goto L7f
                java.lang.String r0 = com.video.androidsdk.common.util.UrlRedirectUtil.access$400()     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lb9
                java.lang.String r1 = "httpcode=302"
                com.video.androidsdk.log.LogEx.i(r0, r1)     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lb9
                java.lang.String r0 = "Location"
                java.lang.String r0 = r6.getHeaderField(r0)     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lb9
                boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lb9
                if (r1 != 0) goto L75
                com.video.androidsdk.common.util.UrlRedirectUtil r1 = com.video.androidsdk.common.util.UrlRedirectUtil.this     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lb9
                java.lang.String r2 = new java.lang.String     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lb9
                java.lang.String r3 = "iso-8859-1"
                byte[] r0 = r0.getBytes(r3)     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lb9
                java.lang.String r3 = "utf-8"
                r2.<init>(r0, r3)     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lb9
                com.video.androidsdk.common.util.UrlRedirectUtil.access$502(r1, r2)     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lb9
                java.lang.String r0 = com.video.androidsdk.common.util.UrlRedirectUtil.access$600()     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lb9
                if (r6 == 0) goto L74
                r6.disconnect()
            L74:
                return r0
            L75:
                java.lang.String r0 = com.video.androidsdk.common.util.UrlRedirectUtil.access$100()     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lb9
                if (r6 == 0) goto L7e
                r6.disconnect()
            L7e:
                return r0
            L7f:
                java.lang.String r1 = com.video.androidsdk.common.util.UrlRedirectUtil.access$400()     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lb9
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lb9
                r2.<init>()     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lb9
                java.lang.String r3 = "Http Resp Error, Response Code is "
                r2.append(r3)     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lb9
                r2.append(r0)     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lb9
                java.lang.String r0 = r2.toString()     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lb9
                android.util.Log.w(r1, r0)     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lb9
                java.lang.String r0 = com.video.androidsdk.common.util.UrlRedirectUtil.access$100()     // Catch: java.io.IOException -> La1 java.lang.Throwable -> Lb9
                if (r6 == 0) goto La0
                r6.disconnect()
            La0:
                return r0
            La1:
                r0 = move-exception
                goto Lac
            La3:
                r6 = move-exception
                r4 = r0
                r0 = r6
                r6 = r4
                goto Lba
            La8:
                r6 = move-exception
                r4 = r0
                r0 = r6
                r6 = r4
            Lac:
                r0.printStackTrace()     // Catch: java.lang.Throwable -> Lb9
                java.lang.String r0 = com.video.androidsdk.common.util.UrlRedirectUtil.access$100()     // Catch: java.lang.Throwable -> Lb9
                if (r6 == 0) goto Lb8
                r6.disconnect()
            Lb8:
                return r0
            Lb9:
                r0 = move-exception
            Lba:
                if (r6 == 0) goto Lbf
                r6.disconnect()
            Lbf:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.video.androidsdk.common.util.UrlRedirectUtil.getUrlAfterRedirectionTask.doInBackground(java.lang.String[]):java.lang.String");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String str) {
            if (str.equals(UrlRedirectUtil.RET_GET)) {
                UrlRedirectUtil.this.returnResult();
            } else if (!str.equals(UrlRedirectUtil.RET_REDO)) {
                UrlRedirectUtil.this.returnFail();
            } else {
                UrlRedirectUtil urlRedirectUtil = UrlRedirectUtil.this;
                urlRedirectUtil.getUrlAfterRedirection(urlRedirectUtil.oriPlayUrl);
            }
            super.onPostExecute((getUrlAfterRedirectionTask) str);
        }
    }

    public UrlRedirectUtil(UrlRedirectListener urlRedirectListener) {
        this.callback = urlRedirectListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void returnFail() {
        Log.w(LOG_TAG, "Url Redirect fail");
        if (this.callback != null) {
            Log.d(LOG_TAG, "UrlRedirectListener is noticed");
            this.callback.onUrlRedirected("");
        } else {
            Log.w(LOG_TAG, "UrlRedirectListener is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void returnResult() {
        Log.i(LOG_TAG, "Finish url redirect, new url:" + this.finalUrl);
        if (this.callback != null) {
            Log.d(LOG_TAG, "UrlRedirectListener is noticed");
            this.callback.onUrlRedirected(this.finalUrl);
        } else {
            Log.w(LOG_TAG, "UrlRedirectListener is null");
        }
    }

    public void getUrlAfterRedirection(String str) {
        Log.i(LOG_TAG, "Begin url redirect, original url:" + str);
        this.oriPlayUrl = str;
        getUrlAfterRedirectionTask geturlafterredirectiontask = new getUrlAfterRedirectionTask();
        this.getUrlTask = geturlafterredirectiontask;
        geturlafterredirectiontask.execute(str);
    }
}
