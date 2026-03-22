package com.zte.iptvclient.android.mobile.p.d;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.npvr.GetUserNPVRListByFrameReq;
import com.video.androidsdk.service.npvr.SDKNPVRMgr;
import com.zte.iptvclient.android.mobile.npvr.model.bean.AddNpvrResultBean;
import com.zte.iptvclient.android.mobile.npvr.model.bean.DeleteNpvrResultBean;
import com.zte.iptvclient.android.mobile.npvr.model.bean.NpvrListBean;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: NpvrTask.java */
/* loaded from: classes.dex */
public class a implements com.zte.iptvclient.android.mobile.p.b {

    /* renamed from: b, reason: collision with root package name */
    private static final String f7007b = "com.zte.iptvclient.android.mobile.p.d.a";

    /* renamed from: a, reason: collision with root package name */
    private Gson f7008a = new Gson();

    /* compiled from: NpvrTask.java */
    /* renamed from: com.zte.iptvclient.android.mobile.p.d.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0330a implements SDKNPVRMgr.OnUserNPVRListByFrameReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.mobile.p.a f7009a;

        C0330a(com.zte.iptvclient.android.mobile.p.a aVar) {
            this.f7009a = aVar;
        }

        @Override // com.video.androidsdk.service.npvr.SDKNPVRMgr.OnUserNPVRListByFrameReturnListener
        public void onUserNPVRListByFrameReturn(String str, String str2, String str3) {
            LogEx.d(a.f7007b, "onUserNPVRListReturn errorCode = " + str + " errorMsg = " + str2 + " resultJson = " + str3);
            if ("0".equals(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    NpvrListBean npvrListBean = (NpvrListBean) a.this.f7008a.fromJson(str3, NpvrListBean.class);
                    if (npvrListBean == null) {
                        if (this.f7009a != null) {
                            this.f7009a.a("Data Error");
                        }
                    } else {
                        npvrListBean.dataParseToBeanList(jSONObject.optJSONArray("data"));
                        if (this.f7009a != null) {
                            this.f7009a.b(npvrListBean);
                        }
                    }
                    return;
                } catch (Exception unused) {
                    com.zte.iptvclient.android.mobile.p.a aVar = this.f7009a;
                    if (aVar != null) {
                        aVar.a(str2);
                        return;
                    }
                    return;
                }
            }
            com.zte.iptvclient.android.mobile.p.a aVar2 = this.f7009a;
            if (aVar2 != null) {
                aVar2.a(str2);
            }
        }
    }

    /* compiled from: NpvrTask.java */
    /* loaded from: classes.dex */
    class b implements SDKNPVRMgr.OnAddNPVRReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.mobile.p.a f7011a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f7012b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f7013c;

        b(a aVar, com.zte.iptvclient.android.mobile.p.a aVar2, String str, String str2) {
            this.f7011a = aVar2;
            this.f7012b = str;
            this.f7013c = str2;
        }

        @Override // com.video.androidsdk.service.npvr.SDKNPVRMgr.OnAddNPVRReturnListener
        public void onAddNPVRReturn(String str, String str2) {
            LogEx.d(a.f7007b, "errorCode = " + str + " errorMsg = " + str2);
            if (!"0".equals(str) && !"70112503".equals(str)) {
                this.f7011a.b(str2, str);
            } else {
                this.f7011a.c(new AddNpvrResultBean(this.f7012b, this.f7013c));
            }
        }
    }

    /* compiled from: NpvrTask.java */
    /* loaded from: classes.dex */
    class c implements SDKNPVRMgr.OnDelNPVRReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.mobile.p.a f7014a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f7015b;

        c(a aVar, com.zte.iptvclient.android.mobile.p.a aVar2, String str) {
            this.f7014a = aVar2;
            this.f7015b = str;
        }

        @Override // com.video.androidsdk.service.npvr.SDKNPVRMgr.OnDelNPVRReturnListener
        public void onDelNPVRReturn(String str, String str2) {
            LogEx.d(a.f7007b, "errorCode = " + str + " errorMsg = " + str2);
            if ("0".equals(str)) {
                this.f7014a.a((com.zte.iptvclient.android.mobile.p.a) new DeleteNpvrResultBean(this.f7015b));
            } else {
                this.f7014a.a(str, str2);
            }
        }
    }

    @Override // com.zte.iptvclient.android.mobile.p.b
    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, com.zte.iptvclient.android.mobile.p.a aVar) {
        SDKNPVRMgr sDKNPVRMgr = new SDKNPVRMgr();
        GetUserNPVRListByFrameReq getUserNPVRListByFrameReq = new GetUserNPVRListByFrameReq();
        if (!TextUtils.isEmpty(str7)) {
            getUserNPVRListByFrameReq.channelcode = str7;
        }
        getUserNPVRListByFrameReq.pageno = str;
        getUserNPVRListByFrameReq.numperpage = str2;
        getUserNPVRListByFrameReq.mediaservices = str3;
        if (!TextUtils.isEmpty(str4)) {
            getUserNPVRListByFrameReq.ordertype = str4;
        }
        if (!TextUtils.isEmpty(str5)) {
            getUserNPVRListByFrameReq.sorttype = str5;
        }
        if (!TextUtils.isEmpty(str6)) {
            getUserNPVRListByFrameReq.languagetype = str6;
        }
        LogEx.d(f7007b, "request params = " + getUserNPVRListByFrameReq.toString());
        sDKNPVRMgr.getUserNPVRListByFrame(getUserNPVRListByFrameReq, new C0330a(aVar));
    }

    @Override // com.zte.iptvclient.android.mobile.p.b
    public void a(String str, String str2, String str3, String str4, String str5, String str6, com.zte.iptvclient.android.mobile.p.a aVar) {
        SDKNPVRMgr sDKNPVRMgr = new SDKNPVRMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("prevuecode", str);
        hashMap.put("mediaservices", str2);
        hashMap.put("channelcode", str3);
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("action", str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            hashMap.put("contentcode", str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            hashMap.put("columncode", str6);
        }
        LogEx.d(f7007b, "request params = " + hashMap.toString());
        sDKNPVRMgr.doAddNPVR(hashMap, new b(this, aVar, str, str3));
    }

    @Override // com.zte.iptvclient.android.mobile.p.b
    public void a(String str, String str2, com.zte.iptvclient.android.mobile.p.a aVar) {
        SDKNPVRMgr sDKNPVRMgr = new SDKNPVRMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("prevuecode", str);
        hashMap.put("mediaservices", str2);
        LogEx.d(f7007b, "request params = " + hashMap.toString());
        sDKNPVRMgr.doDelNPVR(hashMap, new c(this, aVar, str));
    }
}
