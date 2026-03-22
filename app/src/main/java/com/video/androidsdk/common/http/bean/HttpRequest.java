package com.video.androidsdk.common.http.bean;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class HttpRequest {
    public static final String METHOD_GET = "Get";
    public static final String METHOD_POST = "Post";
    String body;
    boolean canceled;
    Object extra;
    String method;
    HashMap<String, String> params;
    String url;
    boolean bAutoRedirect = true;
    Map<String, String> headerMap = new HashMap();

    public HttpRequest(String str) {
        this.method = str;
    }

    public void addHeader(String str, String str2) {
        if (str == null || str.trim().length() == 0 || str2 == null || str2.trim().length() == 0) {
            return;
        }
        String trim = str.trim();
        String trim2 = str2.trim();
        if (this.headerMap.containsKey(trim)) {
            String str3 = this.headerMap.get(trim);
            if (!TextUtils.isEmpty(str3)) {
                for (String str4 : str3.split(";")) {
                    if (str4.equalsIgnoreCase(trim2)) {
                        return;
                    }
                }
                trim2 = str3 + ";" + trim2;
            }
        }
        this.headerMap.put(trim, trim2);
    }

    public boolean compareTo(Object obj) {
        boolean z;
        if (obj == null || !(obj instanceof HttpRequest)) {
            return false;
        }
        HttpRequest httpRequest = (HttpRequest) obj;
        if (this.method == null && httpRequest.getMethod() != null) {
            return false;
        }
        String str = this.method;
        if (str != null && !str.equalsIgnoreCase(httpRequest.getMethod())) {
            return false;
        }
        if (this.url == null && httpRequest.getUrl() != null) {
            return false;
        }
        String str2 = this.url;
        if (str2 != null && !str2.equalsIgnoreCase(httpRequest.getUrl())) {
            return false;
        }
        if ((this.params == null && httpRequest.getParams() != null) || (this.params != null && httpRequest.getParams() == null)) {
            return false;
        }
        if (this.params == null && httpRequest.getParams() == null) {
            return true;
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap<String, String> hashMap3 = this.params;
        if (hashMap3 != null && !hashMap3.isEmpty()) {
            for (Map.Entry<String, String> entry : this.params.entrySet()) {
                if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                    hashMap.put(entry.getKey(), entry.getValue());
                }
            }
        }
        if (httpRequest.getParams() != null && !httpRequest.getParams().isEmpty()) {
            for (Map.Entry<String, String> entry2 : httpRequest.getParams().entrySet()) {
                if (entry2 != null && entry2.getKey() != null && entry2.getValue() != null) {
                    hashMap2.put(entry2.getKey(), entry2.getValue());
                }
            }
        }
        if (hashMap.size() != hashMap2.size()) {
            return false;
        }
        for (Map.Entry entry3 : hashMap.entrySet()) {
            Iterator it2 = hashMap2.entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = false;
                    break;
                }
                Map.Entry entry4 = (Map.Entry) it2.next();
                if (((String) entry3.getKey()).equals(entry4.getKey())) {
                    if (!((String) entry3.getValue()).equals(entry4.getValue())) {
                        return false;
                    }
                    z = true;
                }
            }
            if (!z) {
                return false;
            }
        }
        if (this.body == null && httpRequest.getBody() != null) {
            return false;
        }
        String str3 = this.body;
        return (str3 == null || str3.equals(httpRequest.getBody())) && this.bAutoRedirect == httpRequest.isAutoRedirect();
    }

    public void enableAutoRedirect(boolean z) {
        this.bAutoRedirect = z;
    }

    public String getBody() {
        return this.body;
    }

    public Object getExtra() {
        return this.extra;
    }

    public Map<String, String> getHeaderMap() {
        return this.headerMap;
    }

    public String getMethod() {
        return this.method;
    }

    public HashMap<String, String> getParams() {
        return this.params;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isAutoRedirect() {
        return this.bAutoRedirect;
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    public void setBody(String str) {
        this.body = str;
    }

    public void setCanceled(boolean z) {
        this.canceled = z;
    }

    public void setExtra(Object obj) {
        this.extra = obj;
    }

    public void setHeader(String str, String str2) {
        if (str == null || str.trim().length() == 0 || str2 == null || str2.trim().length() == 0) {
            return;
        }
        this.headerMap.put(str.trim(), str2.trim());
    }

    public void setHeaderMap(Map<String, String> map) {
        this.headerMap = map;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setParams(HashMap<String, String> hashMap) {
        this.params = hashMap;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public HttpRequest(String str, String str2) {
        this.method = str;
        this.url = str2;
    }

    public HttpRequest(String str, String str2, HashMap<String, String> hashMap) {
        this.method = str;
        this.url = str2;
        this.params = hashMap;
    }

    public HttpRequest(String str, String str2, String str3) {
        this.method = str;
        this.url = str2;
        this.body = str3;
    }

    public HttpRequest(String str, String str2, HashMap<String, String> hashMap, String str3) {
        this.method = str;
        this.url = str2;
        this.params = hashMap;
        this.body = str3;
    }
}
