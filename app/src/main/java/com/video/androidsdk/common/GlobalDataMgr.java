package com.video.androidsdk.common;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class GlobalDataMgr {
    public static final String LOG_TAG = "GlobalDataMgr";
    private static GlobalDataMgr m_instance;
    private Map<String, Object> mmapGlobalDatas = new HashMap();

    private GlobalDataMgr() {
    }

    public static GlobalDataMgr getInstance() {
        synchronized (GlobalDataMgr.class) {
            if (m_instance != null) {
                return m_instance;
            }
            GlobalDataMgr globalDataMgr = new GlobalDataMgr();
            m_instance = globalDataMgr;
            return globalDataMgr;
        }
    }

    public Object getAndRemoveData(String str) {
        Object remove;
        synchronized (this.mmapGlobalDatas) {
            remove = this.mmapGlobalDatas.remove(str);
        }
        return remove;
    }

    public Object getData(String str) {
        Object obj;
        synchronized (this.mmapGlobalDatas) {
            obj = this.mmapGlobalDatas.get(str);
        }
        return obj;
    }

    public void putData(String str, Object obj) {
        synchronized (this.mmapGlobalDatas) {
            this.mmapGlobalDatas.put(str, obj);
        }
    }
}
