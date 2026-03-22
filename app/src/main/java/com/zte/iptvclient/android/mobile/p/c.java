package com.zte.iptvclient.android.mobile.p;

import com.zte.iptvclient.android.mobile.npvr.model.bean.AddNpvrResultBean;
import com.zte.iptvclient.android.mobile.npvr.model.bean.DeleteNpvrResultBean;
import com.zte.iptvclient.android.mobile.npvr.model.bean.NpvrListBean;

/* compiled from: NpvrMVPContract.java */
/* loaded from: classes.dex */
public interface c {
    void a(AddNpvrResultBean addNpvrResultBean);

    void a(DeleteNpvrResultBean deleteNpvrResultBean);

    void a(NpvrListBean npvrListBean);

    void b(String str, String str2);

    void d(String str, String str2);

    void l(String str);
}
