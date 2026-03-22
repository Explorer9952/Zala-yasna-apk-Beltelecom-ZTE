package com.video.androidsdk.common.http;

import com.video.androidsdk.log.LogEx;
import java.util.HashMap;

/* loaded from: classes.dex */
public class SessionMgr {
    private static final String LOG_TAG = "SessionMgr";
    private static volatile SessionMgr mInstance;
    private HashMap<String, String> sessionIdCache = new HashMap<>();

    public static SessionMgr getInstance() {
        if (mInstance == null) {
            mInstance = new SessionMgr();
        }
        return mInstance;
    }

    public void clearSessionCache() {
        this.sessionIdCache.clear();
    }

    public String getSessionID(String str) {
        LogEx.d(LOG_TAG, "getSessionID,domain=" + str);
        if (str == null || str.trim().length() == 0) {
            return null;
        }
        return this.sessionIdCache.get(str);
    }

    public void putSessionID(String str, String str2) {
        LogEx.d(LOG_TAG, "putSessionID,Domain:" + str + " sessionid:" + str2);
        if (str == null || str.trim().length() == 0) {
            return;
        }
        if (str2 != null && str2.trim().length() != 0) {
            this.sessionIdCache.put(str, str2);
        } else {
            this.sessionIdCache.remove(str);
        }
    }
}
