package com.zte.iptvclient.common.video;

import com.video.androidsdk.service.comm.ParamConst;
import java.util.Map;

/* compiled from: MultiplePlayUrl.java */
/* loaded from: classes2.dex */
public class c {
    public c(Map<String, Object> map) {
        a(map);
    }

    private void a(Map<String, Object> map) {
        b((String) map.get("columncode"));
        c((String) map.get("definition"));
        e((String) map.get("playurl"));
        f((String) map.get("programcode"));
        g((String) map.get("programtype"));
        a((String) map.get(ParamConst.VOD_MULTIPLE_URL_RSP_AUTH_RETURNCODE));
        d((String) map.get(ParamConst.VOD_MULTIPLE_URL_RSP_EXPIRED_TIME));
    }

    public void a(String str) {
    }

    public void b(String str) {
    }

    public void c(String str) {
    }

    public void d(String str) {
    }

    public void e(String str) {
    }

    public void f(String str) {
    }

    public void g(String str) {
    }
}
