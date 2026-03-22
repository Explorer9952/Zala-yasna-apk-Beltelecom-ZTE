package com.zte.iptvclient.common.video;

import com.video.androidsdk.service.comm.DefinitionType;

/* compiled from: VideoInfo.java */
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private MediaServiceType f7952a;

    /* renamed from: b, reason: collision with root package name */
    private String f7953b;

    /* renamed from: c, reason: collision with root package name */
    private String f7954c;

    public String a() {
        if (this.f7954c.equals("1")) {
            return "1";
        }
        if (this.f7954c.equals("2")) {
            return "2";
        }
        if (this.f7954c.equals("4")) {
            return "4";
        }
        if (this.f7954c.equals("0")) {
            return "0";
        }
        if (this.f7954c.equals(DefinitionType.TYPE_DEFINITION_OTHER)) {
            return DefinitionType.TYPE_DEFINITION_OTHER;
        }
        return null;
    }

    public void a(String str) {
    }

    public MediaServiceType b() {
        return this.f7952a;
    }

    public void b(String str) {
    }

    public VideoType c() {
        if (this.f7953b.equals("28")) {
            return VideoType.TYPE_VIDEO_POSTIVE;
        }
        if (this.f7953b.equals("20")) {
            return VideoType.TYPE_VIDEO_TRAILER;
        }
        return null;
    }

    public void c(String str) {
    }

    public void d(String str) {
        this.f7954c = str;
    }

    public void e(String str) {
    }

    public void f(String str) {
    }

    public void g(String str) {
        if (str.equals("1")) {
            this.f7952a = MediaServiceType.TYPE_MEDIASERVICE_RTSP;
            return;
        }
        if (str.equals("2")) {
            this.f7952a = MediaServiceType.TYPE_MEDIASERVICE_HLS;
            return;
        }
        if (str.equals("4")) {
            this.f7952a = MediaServiceType.TYPE_MEDIASERVICE_SILVERLIGHT;
        } else if (str.equals("8")) {
            this.f7952a = MediaServiceType.TYPE_MEDIASERVICE_ADOBE;
        } else {
            this.f7952a = null;
        }
    }

    public void h(String str) {
    }

    public void i(String str) {
    }

    public void j(String str) {
    }

    public void k(String str) {
    }

    public void l(String str) {
        this.f7953b = str;
    }

    public void m(String str) {
    }
}
