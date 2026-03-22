package com.zte.iptvclient.android.common.f.b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.video.androidsdk.common.GlobalConst;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.comm.ParamConst;
import com.video.androidsdk.service.recommend.SDKRecommendMgr;
import com.zte.iptvclient.android.common.javabean.models.CommonVideoBean;
import com.zte.iptvclient.android.common.javabean.models.VideoDetailBean;
import com.zte.iptvclient.android.zala.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: RecommendVodMgr.java */
/* loaded from: classes.dex */
public class k {
    private static final String g = "k";

    /* renamed from: a, reason: collision with root package name */
    private Context f4571a;

    /* renamed from: b, reason: collision with root package name */
    private String f4572b;

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<CommonVideoBean> f4573c;

    /* renamed from: d, reason: collision with root package name */
    private c f4574d;
    private VideoDetailBean e;
    private b f = new b(this);

    /* compiled from: RecommendVodMgr.java */
    /* loaded from: classes.dex */
    class a implements SDKRecommendMgr.OnCollaborateRankListReturnListener {
        a() {
        }

        @Override // com.video.androidsdk.service.recommend.SDKRecommendMgr.OnCollaborateRankListReturnListener
        public void onCollaborateRankListReturn(String str, String str2, String str3) {
            LogEx.d(k.g, "returncode : " + str + ", errormsg : " + str2 + ", data : " + str3);
            Message obtain = Message.obtain();
            obtain.what = 40961;
            if (TextUtils.equals(str, "0")) {
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("programinfo");
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(CommonVideoBean.a(jSONArray.getJSONObject(i)));
                    }
                    obtain.obj = arrayList;
                } catch (Exception e) {
                    LogEx.e(k.g, e.getMessage());
                }
            }
            k.this.f.sendMessage(obtain);
        }
    }

    /* compiled from: RecommendVodMgr.java */
    /* loaded from: classes.dex */
    private static final class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<k> f4576a;

        public b(k kVar) {
            this.f4576a = new WeakReference<>(kVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            k kVar = this.f4576a.get();
            if (kVar != null && message.what == 40961) {
                kVar.f4573c = (ArrayList) message.obj;
                if (kVar.f4574d != null) {
                    kVar.f4574d.a(kVar.f4573c);
                }
            }
        }
    }

    /* compiled from: RecommendVodMgr.java */
    /* loaded from: classes.dex */
    public interface c {
        void a(ArrayList<CommonVideoBean> arrayList);
    }

    public k(Context context, String str, VideoDetailBean videoDetailBean, c cVar) {
        this.f4571a = context;
        this.f4572b = str;
        this.e = videoDetailBean;
        this.f4574d = cVar;
        new com.zte.iptvclient.android.common.j.h(this.f4571a);
    }

    public void a() {
    }

    public void a(int i) {
        if (TextUtils.isEmpty(this.f4572b)) {
            return;
        }
        ArrayList<CommonVideoBean> arrayList = this.f4573c;
        if (arrayList == null) {
            this.f4573c = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("rec_num", GlobalConst.ANDRIODSTB_CLIENT);
        hashMap.put("cpcode", this.e.getCpcode());
        hashMap.put("bocode", this.e.getBocode());
        hashMap.put("mediaservices", "2");
        hashMap.put("columncode", this.e.getColumncode());
        hashMap.put(ParamConst.VOD_DETAIL_RECOMMEND_REQ_FILTERCOLUMNCODE, "");
        hashMap.put("contentcode", this.e.getContentcode());
        hashMap.put("programcode", this.e.getProgramcode());
        hashMap.put("contenttype", "1,14");
        hashMap.put("langtype", com.zte.iptvclient.android.common.i.a.a.a(R.string.search_language_type));
        hashMap.put("genre", "");
        hashMap.put("ungenre", com.zte.iptvclient.android.mobile.home.tab.helper.b.a());
        if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
            int i2 = com.zte.iptvclient.android.mobile.home.tab.helper.a.n().i();
            if (i2 == 0) {
                hashMap.put(ParamConst.VOD_DETAIL_RECOMMEND_REQ_USERLEVEL, GlobalConst.WINPHONE_CLIENT);
            } else {
                hashMap.put(ParamConst.VOD_DETAIL_RECOMMEND_REQ_USERLEVEL, String.valueOf(i2));
            }
        }
        hashMap.put(ParamConst.VOD_DETAIL_RECOMMEND_REQ_SID, "1");
        hashMap.put(ParamConst.VOD_DETAIL_RECOMMEND_REQ_COLUMNLOCK, "");
        hashMap.put(ParamConst.VOD_DETAIL_RECOMMEND_REQ_ALGORITHM, "1");
        if (i == 1) {
            if (!TextUtils.isEmpty(this.e.getDirector())) {
                hashMap.put("director", this.e.getDirector());
            }
        } else if (i == 0 && !TextUtils.isEmpty(this.e.getActor())) {
            hashMap.put("actor", this.e.getActor());
        }
        String c2 = com.zte.iptvclient.common.uiframe.a.c("Un_Recommend_VodColumn");
        if (!TextUtils.isEmpty(c2)) {
            hashMap.put(ParamConst.VOD_DETAIL_RECOMMEND_REQ_COLUMNLOCK, c2);
        }
        if (this.e.getProgramtype().equals("14") && this.e.getSeriestype() != null) {
            if (this.e.getSeriestype().equals("3")) {
                hashMap.put("seriestype", "3");
            } else {
                hashMap.put("seriestype", "1");
            }
        }
        SDKRecommendMgr sDKRecommendMgr = new SDKRecommendMgr();
        if (!TextUtils.isEmpty(this.f4572b)) {
            sDKRecommendMgr.setServerDomain(this.f4572b);
        }
        sDKRecommendMgr.getCollaborateRankList(hashMap, new a());
    }
}
