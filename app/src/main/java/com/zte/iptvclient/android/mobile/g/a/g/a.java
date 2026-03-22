package com.zte.iptvclient.android.mobile.g.a.g;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.clouddvr.SDKCloudDVRMgr;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.DeleteSchduleResultBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.RecordFileDetailBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.RecordFileListBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.RecordFileListNoDateBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.ScheduleListBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.ScheduleListNoDateBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.ScheduleResultBean;
import com.zte.iptvclient.android.mobile.clouddvr.mvp.model.bean.UserVolumeBean;
import java.util.HashMap;

/* compiled from: CloudDvrTask.java */
/* loaded from: classes.dex */
public class a implements com.zte.iptvclient.android.mobile.g.a.b {

    /* renamed from: c, reason: collision with root package name */
    private static final String f6240c = "com.zte.iptvclient.android.mobile.g.a.g.a";

    /* renamed from: d, reason: collision with root package name */
    private static volatile a f6241d;

    /* renamed from: a, reason: collision with root package name */
    private Gson f6242a = new Gson();

    /* renamed from: b, reason: collision with root package name */
    SDKCloudDVRMgr f6243b = new SDKCloudDVRMgr();

    /* compiled from: CloudDvrTask.java */
    /* renamed from: com.zte.iptvclient.android.mobile.g.a.g.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0255a implements SDKCloudDVRMgr.OnGetRecordDetailReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.mobile.g.a.a f6244a;

        C0255a(com.zte.iptvclient.android.mobile.g.a.a aVar) {
            this.f6244a = aVar;
        }

        @Override // com.video.androidsdk.service.clouddvr.SDKCloudDVRMgr.OnGetRecordDetailReturnListener
        public void onGetRecordDetailReturn(String str, String str2, String str3) {
            LogEx.d(a.f6240c, "errorCode = " + str + " errorMsg = " + str2 + " resultJson = " + str3);
            if ("0".equals(str)) {
                RecordFileDetailBean recordFileDetailBean = null;
                try {
                    recordFileDetailBean = (RecordFileDetailBean) a.this.f6242a.fromJson(str3, RecordFileDetailBean.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (recordFileDetailBean == null) {
                    this.f6244a.e("Data Error");
                    return;
                }
                if ("0".equals(recordFileDetailBean.getReturncode() + "")) {
                    this.f6244a.e((com.zte.iptvclient.android.mobile.g.a.a) recordFileDetailBean);
                    return;
                }
                this.f6244a.e("returncode:" + recordFileDetailBean.getReturncode());
                return;
            }
            this.f6244a.e(str2);
        }
    }

    /* compiled from: CloudDvrTask.java */
    /* loaded from: classes.dex */
    class b implements SDKCloudDVRMgr.OnDelRecordReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.mobile.g.a.a f6246a;

        b(a aVar, com.zte.iptvclient.android.mobile.g.a.a aVar2) {
            this.f6246a = aVar2;
        }

        @Override // com.video.androidsdk.service.clouddvr.SDKCloudDVRMgr.OnDelRecordReturnListener
        public void onDelRecordReturn(String str, String str2) {
            LogEx.d(a.f6240c, "errorCode = " + str + " errorMsg = " + str2);
            if ("0".equals(str)) {
                this.f6246a.b((com.zte.iptvclient.android.mobile.g.a.a) str2);
            } else {
                this.f6246a.f(str2);
            }
        }
    }

    /* compiled from: CloudDvrTask.java */
    /* loaded from: classes.dex */
    class c implements SDKCloudDVRMgr.OnGetUserVolumeReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.mobile.g.a.a f6247a;

        c(com.zte.iptvclient.android.mobile.g.a.a aVar) {
            this.f6247a = aVar;
        }

        @Override // com.video.androidsdk.service.clouddvr.SDKCloudDVRMgr.OnGetUserVolumeReturnListener
        public void onGetUserVolumeReturn(String str, String str2, String str3) {
            LogEx.d(a.f6240c, "errorCode = " + str + " errorMsg = " + str2 + " resultJson = " + str3);
            if ("0".equals(str)) {
                UserVolumeBean userVolumeBean = null;
                try {
                    userVolumeBean = (UserVolumeBean) a.this.f6242a.fromJson(str3, UserVolumeBean.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (userVolumeBean == null) {
                    this.f6247a.c("Data Error");
                    return;
                }
                if ("0".equals(userVolumeBean.getReturncode() + "")) {
                    this.f6247a.a((com.zte.iptvclient.android.mobile.g.a.a) userVolumeBean);
                    return;
                }
                this.f6247a.c("returncode:" + userVolumeBean.getReturncode());
                return;
            }
            this.f6247a.c(str2);
        }
    }

    /* compiled from: CloudDvrTask.java */
    /* loaded from: classes.dex */
    class d implements SDKCloudDVRMgr.OnModifyRecordReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.mobile.g.a.a f6249a;

        d(a aVar, com.zte.iptvclient.android.mobile.g.a.a aVar2) {
            this.f6249a = aVar2;
        }

        @Override // com.video.androidsdk.service.clouddvr.SDKCloudDVRMgr.OnModifyRecordReturnListener
        public void onModifyRecordReturn(String str, String str2) {
            LogEx.d(a.f6240c, "errorCode = " + str + " errorMsg = " + str2);
            if ("0".equals(str)) {
                this.f6249a.h((com.zte.iptvclient.android.mobile.g.a.a) str2);
            } else {
                this.f6249a.h(str2);
            }
        }
    }

    /* compiled from: CloudDvrTask.java */
    /* loaded from: classes.dex */
    class e implements SDKCloudDVRMgr.OnGetScheduleListReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.mobile.g.a.a f6250a;

        e(com.zte.iptvclient.android.mobile.g.a.a aVar) {
            this.f6250a = aVar;
        }

        @Override // com.video.androidsdk.service.clouddvr.SDKCloudDVRMgr.OnGetScheduleListReturnListener
        public void onGetScheduleListReturn(String str, String str2, String str3) {
            ScheduleListBean scheduleListBean;
            LogEx.d(a.f6240c, "errorCode = " + str + " errorMsg = " + str2 + " resultJson = " + str3);
            if ("0".equals(str)) {
                ScheduleListNoDateBean scheduleListNoDateBean = null;
                try {
                    scheduleListBean = (ScheduleListBean) a.this.f6242a.fromJson(str3, ScheduleListBean.class);
                } catch (Exception e) {
                    e.printStackTrace();
                    scheduleListBean = null;
                }
                if (scheduleListBean == null) {
                    try {
                        scheduleListNoDateBean = (ScheduleListNoDateBean) a.this.f6242a.fromJson(str3, ScheduleListNoDateBean.class);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    if (scheduleListNoDateBean != null) {
                        LogEx.d(a.f6240c, "scheduleListNoDateBean != null");
                        scheduleListBean = new ScheduleListBean();
                        scheduleListBean.setReturncode(scheduleListNoDateBean.getReturncode());
                        scheduleListBean.setTotalcount(scheduleListNoDateBean.getTotalcount());
                    }
                }
                if (scheduleListBean == null) {
                    this.f6250a.a("Data Error");
                    return;
                }
                if ("0".equals(scheduleListBean.getReturncode() + "")) {
                    this.f6250a.c((com.zte.iptvclient.android.mobile.g.a.a) scheduleListBean);
                    return;
                }
                this.f6250a.a("returncode:" + scheduleListBean.getReturncode());
                return;
            }
            this.f6250a.a(str2);
        }
    }

    /* compiled from: CloudDvrTask.java */
    /* loaded from: classes.dex */
    class f implements SDKCloudDVRMgr.OnDelScheduleReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.mobile.g.a.a f6252a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f6253b;

        f(com.zte.iptvclient.android.mobile.g.a.a aVar, String str) {
            this.f6252a = aVar;
            this.f6253b = str;
        }

        @Override // com.video.androidsdk.service.clouddvr.SDKCloudDVRMgr.OnDelScheduleReturnListener
        public void onDelScheduleReturn(String str, String str2, String str3) {
            LogEx.d(a.f6240c, "errorCode = " + str + " errorMsg = " + str2 + " resultJson = " + str3);
            if ("0".equals(str)) {
                DeleteSchduleResultBean deleteSchduleResultBean = null;
                try {
                    deleteSchduleResultBean = (DeleteSchduleResultBean) a.this.f6242a.fromJson(str3, DeleteSchduleResultBean.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (deleteSchduleResultBean == null) {
                    this.f6252a.b("Data Error");
                    return;
                }
                deleteSchduleResultBean.setScheduleid(this.f6253b);
                if ("0".equals(deleteSchduleResultBean.getReturncode() + "")) {
                    this.f6252a.d((com.zte.iptvclient.android.mobile.g.a.a) deleteSchduleResultBean);
                    return;
                }
                this.f6252a.b("returncode:" + deleteSchduleResultBean.getReturncode());
                return;
            }
            this.f6252a.b(str2);
        }
    }

    /* compiled from: CloudDvrTask.java */
    /* loaded from: classes.dex */
    class g implements SDKCloudDVRMgr.OnModifyScheduleReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.mobile.g.a.a f6255a;

        g(com.zte.iptvclient.android.mobile.g.a.a aVar) {
            this.f6255a = aVar;
        }

        @Override // com.video.androidsdk.service.clouddvr.SDKCloudDVRMgr.OnModifyScheduleReturnListener
        public void onModifyScheduleReturn(String str, String str2, String str3) {
            LogEx.d(a.f6240c, "errorCode = " + str + " errorMsg = " + str2 + " resultJson = " + str3);
            if ("0".equals(str)) {
                ScheduleResultBean scheduleResultBean = null;
                try {
                    scheduleResultBean = (ScheduleResultBean) a.this.f6242a.fromJson(str3, ScheduleResultBean.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (scheduleResultBean == null) {
                    this.f6255a.g("Data Error");
                    return;
                }
                if ("0".equals(scheduleResultBean.getReturncode() + "")) {
                    this.f6255a.f((com.zte.iptvclient.android.mobile.g.a.a) scheduleResultBean);
                    return;
                }
                this.f6255a.g("returncode:" + scheduleResultBean.getReturncode());
                return;
            }
            this.f6255a.g(str2);
        }
    }

    /* compiled from: CloudDvrTask.java */
    /* loaded from: classes.dex */
    class h implements SDKCloudDVRMgr.OnGetRecordListReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.mobile.g.a.a f6257a;

        h(com.zte.iptvclient.android.mobile.g.a.a aVar) {
            this.f6257a = aVar;
        }

        @Override // com.video.androidsdk.service.clouddvr.SDKCloudDVRMgr.OnGetRecordListReturnListener
        public void onGetRecordListReturn(String str, String str2, String str3) {
            RecordFileListBean recordFileListBean;
            LogEx.d(a.f6240c, "errorCode = " + str + " errorMsg = " + str2 + " resultJson = " + str3);
            if ("0".equals(str)) {
                RecordFileListNoDateBean recordFileListNoDateBean = null;
                try {
                    recordFileListBean = (RecordFileListBean) a.this.f6242a.fromJson(str3, RecordFileListBean.class);
                } catch (Exception e) {
                    e.printStackTrace();
                    recordFileListBean = null;
                }
                if (recordFileListBean == null) {
                    try {
                        recordFileListNoDateBean = (RecordFileListNoDateBean) a.this.f6242a.fromJson(str3, RecordFileListNoDateBean.class);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    if (recordFileListNoDateBean != null) {
                        LogEx.d(a.f6240c, "recordFileListNoDateBean != null");
                        recordFileListBean = new RecordFileListBean();
                        recordFileListBean.setReturncode(recordFileListNoDateBean.getReturncode());
                        recordFileListBean.setTotalcount(recordFileListNoDateBean.getTotalcount());
                    }
                }
                if (recordFileListBean == null) {
                    this.f6257a.d("Data Error");
                    return;
                }
                if ("0".equals(recordFileListBean.getReturncode() + "")) {
                    this.f6257a.g((com.zte.iptvclient.android.mobile.g.a.a) recordFileListBean);
                    return;
                }
                this.f6257a.d("returncode:" + recordFileListBean.getReturncode());
                return;
            }
            this.f6257a.d(str2);
        }
    }

    public static synchronized a b() {
        a aVar;
        synchronized (a.class) {
            if (f6241d == null) {
                f6241d = new a();
            }
            aVar = f6241d;
        }
        return aVar;
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.b
    public void c(String str, String str2, String str3, String str4, String str5, com.zte.iptvclient.android.mobile.g.a.a aVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (str5 == null) {
            str5 = "";
        }
        hashMap.put("ProfileCode", str5);
        hashMap.put("scheduleid", str);
        hashMap.put("seriesrec", str2);
        hashMap.put("begintime", str3);
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("type", str4);
        }
        LogEx.d(f6240c, "request params = " + hashMap.toString());
        this.f6243b.delSchedule(hashMap, new f(aVar, str));
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.b
    public void a(String str, String str2, String str3, String str4, String str5, com.zte.iptvclient.android.mobile.g.a.a aVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (str5 == null) {
            str5 = "";
        }
        hashMap.put("ProfileCode", str5);
        hashMap.put("pageno", str);
        hashMap.put("numperpage", str2);
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("sorttype", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("searchdate", str4);
        }
        LogEx.d(f6240c, "request params = " + hashMap.toString());
        this.f6243b.getScheduleList(hashMap, new e(aVar));
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.b
    public void b(String str, String str2, String str3, String str4, String str5, com.zte.iptvclient.android.mobile.g.a.a aVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (str5 == null) {
            str5 = "";
        }
        hashMap.put("ProfileCode", str5);
        hashMap.put("scheduleid", str);
        hashMap.put("seriesrec", str2);
        hashMap.put("recmode", str3);
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("rectimeafter", str4);
        } else {
            hashMap.put("rectimeafter", "0");
        }
        LogEx.d(f6240c, "request params = " + hashMap.toString());
        this.f6243b.modifyRecord(hashMap, new d(this, aVar));
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.b
    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, com.zte.iptvclient.android.mobile.g.a.a aVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("mac", str);
        hashMap.put("scheduleid", str2);
        hashMap.put("prevueid", str3);
        hashMap.put("seriesrec", str4);
        hashMap.put("channelmode", str5);
        hashMap.put("recordtype", str6);
        hashMap.put("rectimebefore", str7);
        hashMap.put("rectimeafter", str8);
        hashMap.put("recmode", str9);
        hashMap.put("keepatmost", str10);
        hashMap.put("episodetype", str11);
        hashMap.put("ProfileCode", str12 == null ? "" : str12);
        if (!TextUtils.isEmpty(str13)) {
            hashMap.put("starttimeutc", str13);
        }
        if (!TextUtils.isEmpty(str14)) {
            hashMap.put("endtimeutc", str14);
        }
        if (!TextUtils.isEmpty(str15)) {
            hashMap.put("channelcode", str15);
        }
        LogEx.d(f6240c, "request params = " + hashMap.toString());
        this.f6243b.modifySchedule(hashMap, new g(aVar));
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.b
    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, com.zte.iptvclient.android.mobile.g.a.a aVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (str8 == null) {
            str8 = "";
        }
        hashMap.put("ProfileCode", str8);
        hashMap.put("type", str);
        hashMap.put("pageno", str2);
        hashMap.put("numperpage", str3);
        hashMap.put("sorttype", str4);
        hashMap.put("langtype", str5);
        if (!TextUtils.isEmpty(str6)) {
            hashMap.put("ordertype", str6);
        }
        if (!TextUtils.isEmpty(str7)) {
            hashMap.put("seriesid", str7);
        }
        LogEx.d(f6240c, "request params = " + hashMap.toString());
        this.f6243b.getRecordList(hashMap, new h(aVar));
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.b
    public void a(String str, String str2, String str3, String str4, com.zte.iptvclient.android.mobile.g.a.a aVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (str4 == null) {
            str4 = "";
        }
        hashMap.put("ProfileCode", str4);
        hashMap.put("scheduleid", str);
        hashMap.put("seriesrec", str2);
        hashMap.put("langtype", str3);
        LogEx.d(f6240c, "request params = " + hashMap.toString());
        this.f6243b.getRecordDetail(hashMap, new C0255a(aVar));
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.b
    public void a(String str, String str2, String str3, com.zte.iptvclient.android.mobile.g.a.a aVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (str3 == null) {
            str3 = "";
        }
        hashMap.put("ProfileCode", str3);
        hashMap.put("type", str);
        hashMap.put("scheduleids", str2);
        LogEx.d(f6240c, "request params = " + hashMap.toString());
        this.f6243b.delRecord(hashMap, new b(this, aVar));
    }

    @Override // com.zte.iptvclient.android.mobile.g.a.b
    public void a(com.zte.iptvclient.android.mobile.g.a.a aVar) {
        this.f6243b.getUserVolume(new c(aVar));
    }
}
