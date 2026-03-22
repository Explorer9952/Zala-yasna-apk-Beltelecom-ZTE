package com.zte.iptvclient.android.mobile.a0.c;

import android.text.TextUtils;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.comm.ParamConst;
import com.video.androidsdk.service.prevue.SDKPrevueMgr;
import com.zte.iptvclient.android.common.javabean.models.PrevueBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: PrevueOfBatchList.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private String f5550a;

    /* renamed from: b, reason: collision with root package name */
    private List<PrevueBean> f5551b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private b f5552c;

    /* compiled from: PrevueOfBatchList.java */
    /* renamed from: com.zte.iptvclient.android.mobile.a0.c.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0187a implements SDKPrevueMgr.OnCurrentPrevueReturnListener {
        C0187a() {
        }

        @Override // com.video.androidsdk.service.prevue.SDKPrevueMgr.OnCurrentPrevueReturnListener
        public void onCurrentPrevueReturn(String str, String str2, String str3) {
            PrevueBean prevueBean;
            if (TextUtils.equals(str, "0") && !TextUtils.isEmpty(str3)) {
                LogEx.d("PrevueOfBatchList", "onCurrentPrevueReturn returncode=" + str + " jdson=" + str3);
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    int optInt = jSONObject.optInt("returncode");
                    String optString = jSONObject.optString("errormsg");
                    if (!"0".equals(str) && a.this.f5552c != null) {
                        LogEx.e("PrevueOfBatchList", "returncode is " + str + "  errormsg is " + str2);
                        a.this.f5552c.a(optInt, str2, null);
                        return;
                    }
                    JSONObject jSONObject2 = new JSONObject(str3);
                    if (a.this.f5551b != null) {
                        a.this.f5551b.clear();
                    } else {
                        a.this.f5551b = new ArrayList();
                    }
                    JSONArray optJSONArray = jSONObject2.optJSONArray("data");
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONArray jSONArray = optJSONArray.getJSONArray(i);
                        if (jSONArray != null) {
                            prevueBean = PrevueBean.getPrevueBeanFromJSon(jSONArray.optJSONObject(0));
                        } else {
                            prevueBean = new PrevueBean();
                        }
                        a.this.f5551b.add(prevueBean);
                    }
                    if (a.this.f5552c != null) {
                        a.this.f5552c.a(optInt, optString, a.this.f5551b);
                        return;
                    }
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    LogEx.e("PrevueOfBatchList", "onCurrentPrevueReturn=" + e.getMessage());
                    if (a.this.f5552c != null) {
                        a.this.f5552c.a(-1, "json error", null);
                        return;
                    }
                    return;
                }
            }
            LogEx.w("PrevueOfBatchList", "getCurrentPrevue failed");
        }
    }

    /* compiled from: PrevueOfBatchList.java */
    /* loaded from: classes2.dex */
    public interface b {
        void a(int i, String str, List<PrevueBean> list);
    }

    public a(String str, String str2) {
        this.f5550a = "";
        this.f5550a = str;
    }

    public void a(b bVar) {
        this.f5552c = bVar;
        if (TextUtils.isEmpty(this.f5550a)) {
            return;
        }
        SDKPrevueMgr sDKPrevueMgr = new SDKPrevueMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(ParamConst.BATCH_PREVUE_LIST_REQ_CHANNELCODES, this.f5550a);
        sDKPrevueMgr.getCurrentPrevue(hashMap, new C0187a());
    }

    public void a() {
        this.f5552c = null;
    }
}
