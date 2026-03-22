package com.zte.iptvclient.android.mobile.download.bean;

import com.video.androidsdk.download.Linstener.OnTaskOperReturnListener;
import com.video.androidsdk.download.bean.DownloadTaskReq;
import java.util.HashMap;

/* compiled from: DownloadEvent.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private DownloadTaskReq f5743a;

    /* renamed from: b, reason: collision with root package name */
    private HashMap<String, String> f5744b;

    /* renamed from: c, reason: collision with root package name */
    private OnTaskOperReturnListener f5745c;

    public void a(DownloadTaskReq downloadTaskReq) {
        this.f5743a = downloadTaskReq;
    }

    public DownloadTaskReq b() {
        return this.f5743a;
    }

    public HashMap<String, String> c() {
        return this.f5744b;
    }

    public void a(HashMap<String, String> hashMap) {
        this.f5744b = hashMap;
    }

    public OnTaskOperReturnListener a() {
        return this.f5745c;
    }

    public void a(OnTaskOperReturnListener onTaskOperReturnListener) {
        this.f5745c = onTaskOperReturnListener;
    }
}
