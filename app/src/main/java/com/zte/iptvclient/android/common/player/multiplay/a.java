package com.zte.iptvclient.android.common.player.multiplay;

import android.text.TextUtils;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.javabean.f;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.common.javabean.models.PrevueBean;
import com.zte.iptvclient.android.common.javabean.models.VideoDetailBean;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: CachePlayBundle.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<f> f5126a;

    /* compiled from: CachePlayBundle.java */
    /* loaded from: classes.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final a f5127a = new a();
    }

    public static final a c() {
        return b.f5127a;
    }

    public ArrayList<f> a() {
        return this.f5126a;
    }

    public boolean b() {
        return this.f5126a.size() < 4;
    }

    private a() {
        this.f5126a = new ArrayList<>();
    }

    public void a(ArrayList<f> arrayList) {
        LogEx.d("CachePlayBundle", "setPlayerBundleBeanList=" + arrayList.size());
        this.f5126a = arrayList;
    }

    public boolean a(f fVar) {
        if (fVar != null && !TextUtils.isEmpty(fVar.c()) && !TextUtils.isEmpty(fVar.d())) {
            Iterator<f> it2 = this.f5126a.iterator();
            while (it2.hasNext()) {
                f next = it2.next();
                if (TextUtils.equals(next.c(), fVar.c()) && TextUtils.equals(next.d(), fVar.d())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static f a(PrevueBean prevueBean) {
        if (prevueBean == null) {
            return null;
        }
        f fVar = new f();
        fVar.e(prevueBean.getPrevuecode());
        fVar.f(prevueBean.getPrevuename());
        fVar.d("1");
        return fVar;
    }

    public static f a(Channel channel) {
        if (channel == null) {
            return null;
        }
        f fVar = new f();
        fVar.e(channel.getChannelcode());
        fVar.f(channel.getChannelname());
        fVar.c(channel.getMixno());
        fVar.k(channel.getTelecomcode());
        fVar.d("0");
        return fVar;
    }

    public static f a(VideoDetailBean videoDetailBean) {
        if (videoDetailBean == null) {
            return null;
        }
        f fVar = new f();
        fVar.e(videoDetailBean.getProgramcode());
        fVar.f(videoDetailBean.getProgramname());
        fVar.d("2");
        return fVar;
    }

    public static f a(com.zte.iptvclient.android.common.javabean.models.f fVar) {
        if (fVar == null) {
            return null;
        }
        f fVar2 = new f();
        fVar2.e(fVar.r());
        fVar2.f(fVar.e());
        fVar2.g(fVar.z());
        if (TextUtils.isEmpty(fVar.v())) {
            fVar2.j("");
        } else {
            fVar2.j(fVar.v());
        }
        if (!TextUtils.isEmpty(fVar.u())) {
            fVar2.a(fVar.u());
        }
        if (!TextUtils.isEmpty(fVar.d())) {
            fVar2.i(fVar.d());
        }
        if (!TextUtils.isEmpty(fVar.w())) {
            fVar2.h(fVar.w());
        }
        fVar2.d("2");
        return fVar2;
    }

    public boolean a(String str, String str2) {
        Iterator<f> it2 = this.f5126a.iterator();
        while (it2.hasNext()) {
            f next = it2.next();
            if (TextUtils.equals(next.c(), str) && TextUtils.equals(next.d(), str2)) {
                return true;
            }
        }
        return false;
    }
}
