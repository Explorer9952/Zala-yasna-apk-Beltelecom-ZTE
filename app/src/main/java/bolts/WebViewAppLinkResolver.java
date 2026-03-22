package bolts;

import android.content.Context;
import android.net.Uri;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class WebViewAppLinkResolver implements AppLinkResolver {
    private static final String KEY_AL_VALUE = "value";
    private static final String KEY_ANDROID = "android";
    private static final String KEY_APP_NAME = "app_name";
    private static final String KEY_CLASS = "class";
    private static final String KEY_PACKAGE = "package";
    private static final String KEY_SHOULD_FALLBACK = "should_fallback";
    private static final String KEY_URL = "url";
    private static final String KEY_WEB = "web";
    private static final String KEY_WEB_URL = "url";
    private static final String META_TAG_PREFIX = "al";
    private static final String PREFER_HEADER = "Prefer-Html-Meta-Tags";
    private static final String TAG_EXTRACTION_JAVASCRIPT = "javascript:boltsWebViewAppLinkResolverResult.setValue((function() {  var metaTags = document.getElementsByTagName('meta');  var results = [];  for (var i = 0; i < metaTags.length; i++) {    var property = metaTags[i].getAttribute('property');    if (property && property.substring(0, 'al:'.length) === 'al:') {      var tag = { \"property\": metaTags[i].getAttribute('property') };      if (metaTags[i].hasAttribute('content')) {        tag['content'] = metaTags[i].getAttribute('content');      }      results.push(tag);    }  }  return JSON.stringify(results);})())";
    private final Context context;

    public WebViewAppLinkResolver(Context context) {
        this.context = context;
    }

    private static List<Map<String, Object>> getAlList(Map<String, Object> map, String str) {
        List<Map<String, Object>> list = (List) map.get(str);
        return list == null ? Collections.emptyList() : list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x010f, code lost:
    
        if (java.util.Arrays.asList("no", "false", "0").contains(((java.lang.String) ((java.util.Map) r0.get(0)).get("value")).toLowerCase()) != false) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static bolts.AppLink makeAppLinkFromAlData(java.util.Map<java.lang.String, java.lang.Object> r16, android.net.Uri r17) {
        /*
            Method dump skipped, instructions count: 313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bolts.WebViewAppLinkResolver.makeAppLinkFromAlData(java.util.Map, android.net.Uri):bolts.AppLink");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.util.Map] */
    public static Map<String, Object> parseAlData(JSONArray jSONArray) throws JSONException {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            String[] split = jSONObject.getString("property").split(":");
            if (split[0].equals(META_TAG_PREFIX)) {
                HashMap hashMap2 = hashMap;
                int i2 = 1;
                while (true) {
                    if (i2 >= split.length) {
                        break;
                    }
                    List list = (List) hashMap2.get(split[i2]);
                    if (list == null) {
                        list = new ArrayList();
                        hashMap2.put(split[i2], list);
                    }
                    HashMap hashMap3 = list.size() > 0 ? (Map) list.get(list.size() - 1) : null;
                    if (hashMap3 == null || i2 == split.length - 1) {
                        hashMap2 = new HashMap();
                        list.add(hashMap2);
                    } else {
                        hashMap2 = hashMap3;
                    }
                    i2++;
                }
                if (jSONObject.has("content")) {
                    if (jSONObject.isNull("content")) {
                        hashMap2.put("value", null);
                    } else {
                        hashMap2.put("value", jSONObject.getString("content"));
                    }
                }
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String readFromConnection(URLConnection uRLConnection) throws IOException {
        InputStream inputStream;
        int i;
        if (uRLConnection instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
            try {
                inputStream = uRLConnection.getInputStream();
            } catch (Exception unused) {
                inputStream = httpURLConnection.getErrorStream();
            }
        } else {
            inputStream = uRLConnection.getInputStream();
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[Util.BYTE_OF_KB];
            while (true) {
                int read = inputStream.read(bArr);
                i = 0;
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            String contentEncoding = uRLConnection.getContentEncoding();
            if (contentEncoding == null) {
                String[] split = uRLConnection.getContentType().split(";");
                int length = split.length;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String trim = split[i].trim();
                    if (trim.startsWith("charset=")) {
                        contentEncoding = trim.substring(8);
                        break;
                    }
                    i++;
                }
                if (contentEncoding == null) {
                    contentEncoding = "UTF-8";
                }
            }
            return new String(byteArrayOutputStream.toByteArray(), contentEncoding);
        } finally {
            inputStream.close();
        }
    }

    private static Uri tryCreateUrl(String str) {
        if (str == null) {
            return null;
        }
        return Uri.parse(str);
    }

    @Override // bolts.AppLinkResolver
    public Task<AppLink> getAppLinkFromUrlInBackground(final Uri uri) {
        final Capture capture = new Capture();
        final Capture capture2 = new Capture();
        return Task.callInBackground(new Callable<Void>() { // from class: bolts.WebViewAppLinkResolver.3
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                URL url = new URL(uri.toString());
                URLConnection uRLConnection = null;
                while (url != null) {
                    uRLConnection = url.openConnection();
                    boolean z = uRLConnection instanceof HttpURLConnection;
                    if (z) {
                        ((HttpURLConnection) uRLConnection).setInstanceFollowRedirects(true);
                    }
                    uRLConnection.setRequestProperty(WebViewAppLinkResolver.PREFER_HEADER, WebViewAppLinkResolver.META_TAG_PREFIX);
                    uRLConnection.connect();
                    if (z) {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
                        if (httpURLConnection.getResponseCode() >= 300 && httpURLConnection.getResponseCode() < 400) {
                            URL url2 = new URL(httpURLConnection.getHeaderField("Location"));
                            httpURLConnection.disconnect();
                            url = url2;
                        }
                    }
                    url = null;
                }
                try {
                    capture.set(WebViewAppLinkResolver.readFromConnection(uRLConnection));
                    capture2.set(uRLConnection.getContentType());
                    return null;
                } finally {
                    if (uRLConnection instanceof HttpURLConnection) {
                        ((HttpURLConnection) uRLConnection).disconnect();
                    }
                }
            }
        }).onSuccessTask(new Continuation<Void, Task<JSONArray>>() { // from class: bolts.WebViewAppLinkResolver.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // bolts.Continuation
            public Task<JSONArray> then(Task<Void> task) throws Exception {
                final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                WebView webView = new WebView(WebViewAppLinkResolver.this.context);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.setNetworkAvailable(false);
                webView.setWebViewClient(new WebViewClient() { // from class: bolts.WebViewAppLinkResolver.2.1
                    private boolean loaded = false;

                    private void runJavaScript(WebView webView2) {
                        if (this.loaded) {
                            return;
                        }
                        this.loaded = true;
                        webView2.loadUrl(WebViewAppLinkResolver.TAG_EXTRACTION_JAVASCRIPT);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onLoadResource(WebView webView2, String str) {
                        super.onLoadResource(webView2, str);
                        runJavaScript(webView2);
                    }

                    @Override // android.webkit.WebViewClient
                    public void onPageFinished(WebView webView2, String str) {
                        super.onPageFinished(webView2, str);
                        runJavaScript(webView2);
                    }
                });
                webView.addJavascriptInterface(new Object() { // from class: bolts.WebViewAppLinkResolver.2.2
                    @JavascriptInterface
                    public void setValue(String str) {
                        try {
                            taskCompletionSource.trySetResult(new JSONArray(str));
                        } catch (JSONException e) {
                            taskCompletionSource.trySetError(e);
                        }
                    }
                }, "boltsWebViewAppLinkResolverResult");
                webView.loadDataWithBaseURL(uri.toString(), (String) capture.get(), capture2.get() != null ? ((String) capture2.get()).split(";")[0] : null, null, null);
                return taskCompletionSource.getTask();
            }
        }, Task.UI_THREAD_EXECUTOR).onSuccess(new Continuation<JSONArray, AppLink>() { // from class: bolts.WebViewAppLinkResolver.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // bolts.Continuation
            public AppLink then(Task<JSONArray> task) throws Exception {
                return WebViewAppLinkResolver.makeAppLinkFromAlData(WebViewAppLinkResolver.parseAlData(task.getResult()), uri);
            }
        });
    }
}
