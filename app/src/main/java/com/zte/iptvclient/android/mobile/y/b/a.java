package com.zte.iptvclient.android.mobile.y.b;

import android.text.TextUtils;
import com.zte.iptvclient.android.common.javabean.models.VideoDetailBean;
import com.zte.iptvclient.android.common.javabean.models.f;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: CacheMovieBundle.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<VideoDetailBean> f7796a;

    /* compiled from: CacheMovieBundle.java */
    /* loaded from: classes2.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final a f7797a = new a();
    }

    public static final a c() {
        return b.f7797a;
    }

    public ArrayList<VideoDetailBean> a() {
        return this.f7796a;
    }

    public boolean b() {
        return this.f7796a.size() < 10;
    }

    private a() {
        this.f7796a = new ArrayList<>();
    }

    public boolean a(VideoDetailBean videoDetailBean) {
        if (videoDetailBean != null && !TextUtils.isEmpty(videoDetailBean.getProgramtype()) && !TextUtils.isEmpty(videoDetailBean.getProgramcode())) {
            Iterator<VideoDetailBean> it2 = this.f7796a.iterator();
            while (it2.hasNext()) {
                if (TextUtils.equals(it2.next().getProgramcode(), videoDetailBean.getProgramcode())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static VideoDetailBean a(f fVar) {
        if (fVar == null) {
            return null;
        }
        VideoDetailBean videoDetailBean = new VideoDetailBean();
        videoDetailBean.setProgramcode(fVar.r());
        videoDetailBean.setProgramname(fVar.e());
        videoDetailBean.setActor(fVar.a());
        videoDetailBean.setDefinition(fVar.g());
        videoDetailBean.setStarttime(fVar.x());
        videoDetailBean.setEndtime(fVar.j());
        videoDetailBean.setPosterfilelist(fVar.o());
        videoDetailBean.setDirector(fVar.h());
        videoDetailBean.setElapsedtime(fVar.i());
        videoDetailBean.setColumncode(fVar.y());
        videoDetailBean.setProgramtype("2");
        return videoDetailBean;
    }
}
