package com.zte.iptvclient.android.mobile.h.a;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.video.androidsdk.cast.SDKCastMgr;
import com.video.androidsdk.cast.bean.DLNAEvent;
import com.video.androidsdk.cast.bean.Device;
import com.video.androidsdk.common.ParamConst;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.mobile.dlna.bean.BackplayPositionInfoBean;
import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: IPTVDLNAMgr.java */
/* loaded from: classes.dex */
public class a {
    private static int o = 1000;
    private static a p;
    private static Handler q;

    /* renamed from: d, reason: collision with root package name */
    private Device f6342d;
    private HashMap<p, ArrayList<Integer>> e;
    private SDKCastMgr.IInitDLNAListener f;
    private SDKCastMgr.IDLNANotifyListener g;
    private Object h;
    private Object i;
    private int j;

    /* renamed from: a, reason: collision with root package name */
    private boolean f6339a = false;

    /* renamed from: b, reason: collision with root package name */
    private boolean f6340b = false;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f6341c = false;
    private Runnable k = new h();
    private Runnable l = new k();
    private Runnable m = new l();
    String n = "";

    /* compiled from: IPTVDLNAMgr.java */
    /* renamed from: com.zte.iptvclient.android.mobile.h.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0267a implements SDKCastMgr.IDLNAActionCallback {
        C0267a() {
        }

        @Override // com.video.androidsdk.cast.SDKCastMgr.IDLNAActionCallback
        public void onDLNAResponse(String str, String str2, Map<String, String> map) {
            LogEx.i("DLNAManager", "sendKeycode response: " + str2 + "[" + str + "]");
            int parseInt = Integer.parseInt(str);
            if (parseInt == 170002 || parseInt == 170003) {
                a.this.b(null, "11");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IPTVDLNAMgr.java */
    /* loaded from: classes.dex */
    public class b implements SDKCastMgr.IDLNAActionCallback {
        b() {
        }

        @Override // com.video.androidsdk.cast.SDKCastMgr.IDLNAActionCallback
        public void onDLNAResponse(String str, String str2, Map<String, String> map) {
            LogEx.d("DLNAManager", "setAVTransportURI response: " + str2 + "[" + str + "]");
            int parseInt = Integer.parseInt(str);
            if (parseInt == 170002 || parseInt == 170003) {
                a.this.b(null, "11");
            }
        }
    }

    /* compiled from: IPTVDLNAMgr.java */
    /* loaded from: classes.dex */
    class c implements SDKCastMgr.IDLNAActionCallback {
        c() {
        }

        @Override // com.video.androidsdk.cast.SDKCastMgr.IDLNAActionCallback
        public void onDLNAResponse(String str, String str2, Map<String, String> map) {
            if ("0".equals(str)) {
                LogEx.d("IPTVDLNAMgr", "sendUserNameToStb successed");
            } else {
                LogEx.d("IPTVDLNAMgr", "sendUserNameToStb failed");
            }
        }
    }

    /* compiled from: IPTVDLNAMgr.java */
    /* loaded from: classes.dex */
    class d implements SDKCastMgr.IDLNAActionCallback {
        d() {
        }

        @Override // com.video.androidsdk.cast.SDKCastMgr.IDLNAActionCallback
        public void onDLNAResponse(String str, String str2, Map<String, String> map) {
            Log.e("------ErrorCode----", str);
            Log.e("------strErrorMsg----", str2);
            Log.e("--------mapC------", map.toString());
            if ("0".equals(str)) {
                a.this.n = map.get(ParamConst.DLNA_SENDDMRGETSTBCONFIG_RSP_KEYVALUE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IPTVDLNAMgr.java */
    /* loaded from: classes.dex */
    public class e implements SDKCastMgr.IDLNAActionCallback {
        e() {
        }

        @Override // com.video.androidsdk.cast.SDKCastMgr.IDLNAActionCallback
        public void onDLNAResponse(String str, String str2, Map<String, String> map) {
            LogEx.d("------ErrorCode----", str);
            LogEx.d("------strErrorMsg----", str2);
            LogEx.d("--------mapC------", map.toString());
        }
    }

    /* compiled from: IPTVDLNAMgr.java */
    /* loaded from: classes.dex */
    class f implements SDKCastMgr.IDLNAActionCallback {
        f() {
        }

        @Override // com.video.androidsdk.cast.SDKCastMgr.IDLNAActionCallback
        public void onDLNAResponse(String str, String str2, Map<String, String> map) {
            LogEx.d("IPTVDLNAMgr", "-----onDLNAResponse---" + str + " s1 " + str2);
        }
    }

    /* compiled from: IPTVDLNAMgr.java */
    /* loaded from: classes.dex */
    class g implements SDKCastMgr.IDLNAActionCallback {
        g() {
        }

        @Override // com.video.androidsdk.cast.SDKCastMgr.IDLNAActionCallback
        public void onDLNAResponse(String str, String str2, Map<String, String> map) {
            if ("0".equals(str)) {
                LogEx.d("IPTVDLNAMgr", "sendFunctionMeaasgeToStb successed");
            } else {
                LogEx.d("IPTVDLNAMgr", "sendFunctionMeaasgeToStb failed");
            }
        }
    }

    /* compiled from: IPTVDLNAMgr.java */
    /* loaded from: classes.dex */
    class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            boolean z;
            Device device;
            Device device2;
            LogEx.d("DLNAManager", "refresh favDev status ...");
            if (a.this.f6342d != null && a.this.f6342d.getMacAddress() != null) {
                String macAddress = a.this.f6342d.getMacAddress();
                synchronized (a.this.h) {
                    ArrayList<Device> dMRList = SDKCastMgr.getInstance().getDMRList();
                    i = 0;
                    if (dMRList != null) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= dMRList.size()) {
                                break;
                            }
                            try {
                                device2 = dMRList.get(i2);
                            } catch (IndexOutOfBoundsException e) {
                                e.printStackTrace();
                            }
                            if (device2 == null || !macAddress.equalsIgnoreCase(device2.getMacAddress())) {
                                i2++;
                            } else if (SDKCastMgr.getInstance().selectDevice(device2) == 0) {
                                z = true;
                            }
                        }
                    }
                    z = false;
                    if (a.this.f6339a && !z) {
                        a.this.a(1, new DLNAEvent(DLNAEvent.EVENT_DEVICE_OFFLINE, Integer.toString(0), null, "10"));
                        LogEx.d("DLNAManager", "notifyLinstener EVENT_DEVICE_OFFLINE");
                    }
                    a.this.a(1, new DLNAEvent(DLNAEvent.EVENT_DEVICE_ONLINE, Integer.toString(0), null, "10"));
                    LogEx.d("DLNAManager", "notifyLinstener EVENT_DEVICE_OFFLINE");
                }
                synchronized (a.this.i) {
                    ArrayList<Device> dMSList = SDKCastMgr.getInstance().getDMSList();
                    if (dMSList == null) {
                        return;
                    }
                    while (i < dMSList.size()) {
                        try {
                            device = dMSList.get(i);
                        } catch (IndexOutOfBoundsException e2) {
                            e2.printStackTrace();
                        }
                        if (device != null && macAddress.equalsIgnoreCase(device.getMacAddress())) {
                            SDKCastMgr.getInstance().selectDevice(device);
                            break;
                        }
                        i++;
                    }
                    return;
                }
            }
            LogEx.d("DLNAManager", "refresh favDev status mFavDev  is null for return");
        }
    }

    /* compiled from: IPTVDLNAMgr.java */
    /* loaded from: classes.dex */
    class i implements SDKCastMgr.IDLNAActionCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ q f6351a;

        i(q qVar) {
            this.f6351a = qVar;
        }

        @Override // com.video.androidsdk.cast.SDKCastMgr.IDLNAActionCallback
        public void onDLNAResponse(String str, String str2, Map<String, String> map) {
            if (map != null) {
                LogEx.d("DLNAManager", "resultMap=" + map.toString());
                LogEx.d("DLNAManager", "query current positioninfo response: " + str2 + "[" + str + "]");
                StringBuilder sb = new StringBuilder();
                sb.append("@@@@@@ resultmap : ");
                sb.append(map.toString());
                LogEx.d("DLNAManager", sb.toString());
            }
            if (map == null || !map.containsKey(ParamConst.DLNA_SENDDMRGETCURRPOSITIONINFO_RSP_URLFROMSTB)) {
                a.this.a(11, (DLNAEvent) null);
            } else {
                a.this.a(11, new DLNAEvent("dlna.getpositioninfo.complete", str, str2, map.get(ParamConst.DLNA_SENDDMRGETCURRPOSITIONINFO_RSP_URLFROMSTB)));
            }
            BackplayPositionInfoBean backplayPositionInfoBean = new BackplayPositionInfoBean();
            if (map != null && map.containsKey("abscount")) {
                backplayPositionInfoBean.setAbsCount(map.get("abscount"));
            }
            if (map != null && map.containsKey("AbsTime")) {
                backplayPositionInfoBean.setAbsTime(map.get("AbsTime"));
            }
            if (map != null && map.containsKey("Track")) {
                backplayPositionInfoBean.setTrack(map.get("Track"));
            }
            if (map != null && map.containsKey("TrackMetaData")) {
                backplayPositionInfoBean.setTrackMetaData(map.get("TrackMetaData"));
            }
            if (map != null && map.containsKey(ParamConst.DLNA_SENDDMRGETCURRPOSITIONINFO_RSP_TRACKURI)) {
                backplayPositionInfoBean.setTrackURI(map.get(ParamConst.DLNA_SENDDMRGETCURRPOSITIONINFO_RSP_TRACKURI));
            }
            if (map != null && map.containsKey(ParamConst.DLNA_SENDDMRGETCURRPOSITIONINFO_RSP_RELCOUNT)) {
                backplayPositionInfoBean.setRelCount(map.get(ParamConst.DLNA_SENDDMRGETCURRPOSITIONINFO_RSP_RELCOUNT));
            }
            if (map != null && map.containsKey(ParamConst.DLNA_SENDDMRGETCURRPOSITIONINFO_RSP_TRACKDURATION)) {
                backplayPositionInfoBean.setTrackDuration(map.get(ParamConst.DLNA_SENDDMRGETCURRPOSITIONINFO_RSP_TRACKDURATION));
            }
            if (map != null && map.containsKey(ParamConst.DLNA_SENDDMRGETCURRPOSITIONINFO_RSP_RELTIME)) {
                backplayPositionInfoBean.setRelTime(map.get(ParamConst.DLNA_SENDDMRGETCURRPOSITIONINFO_RSP_RELTIME));
            }
            if (map != null && map.containsKey("Seq")) {
                backplayPositionInfoBean.setSeq(map.get("Seq"));
            }
            if (map != null && map.containsKey("errormsg")) {
                backplayPositionInfoBean.setErrorMsg(map.get("errormsg"));
            }
            if (map != null && map.containsKey("returncode")) {
                backplayPositionInfoBean.setReturnCode(map.get("returncode"));
            }
            if (map != null && map.containsKey("mixno")) {
                backplayPositionInfoBean.setMixno(map.get("mixno"));
            }
            if (map != null && map.containsKey("telecomcode")) {
                backplayPositionInfoBean.setTelecomcode(map.get("telecomcode"));
            }
            if (map != null && map.containsKey("begintime")) {
                backplayPositionInfoBean.setBegintime(map.get("begintime"));
            }
            if (map != null && map.containsKey(ParamConst.DLNA_SENDDMRGETCURRPOSITIONINFO_RSP_PUSHTYPE)) {
                backplayPositionInfoBean.setPushtype(map.get(ParamConst.DLNA_SENDDMRGETCURRPOSITIONINFO_RSP_PUSHTYPE));
            }
            if (map != null && map.containsKey("endtime")) {
                backplayPositionInfoBean.setEndtime(map.get("endtime"));
            }
            if (map != null && map.containsKey("breakpoint")) {
                backplayPositionInfoBean.setBreakpoint(map.get("breakpoint"));
            }
            if (map != null && map.containsKey(ParamConst.DLNA_SENDDMRGETCURRPOSITIONINFO_RSP_URLFROMSTB)) {
                backplayPositionInfoBean.setUrlfromstb(map.get(ParamConst.DLNA_SENDDMRGETCURRPOSITIONINFO_RSP_URLFROMSTB));
            }
            if (map != null && map.containsKey("programid")) {
                backplayPositionInfoBean.setProgramid(map.get("programid"));
            }
            if (map != null && map.containsKey("channelcode")) {
                backplayPositionInfoBean.setChannelcode(map.get("channelcode"));
            }
            this.f6351a.a(backplayPositionInfoBean);
        }
    }

    /* compiled from: IPTVDLNAMgr.java */
    /* loaded from: classes.dex */
    class j implements SDKCastMgr.IDLNAActionCallback {
        j() {
        }

        @Override // com.video.androidsdk.cast.SDKCastMgr.IDLNAActionCallback
        public void onDLNAResponse(String str, String str2, Map<String, String> map) {
            LogEx.d("IPTVDLNAMgr", "-----onDLNAResponse---" + str + " strErrorMsg " + str2);
        }
    }

    /* compiled from: IPTVDLNAMgr.java */
    /* loaded from: classes.dex */
    class k implements Runnable {
        k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            boolean z2;
            Device device;
            Device device2;
            LogEx.d("DLNAManager", "check favDev online ...");
            if (a.this.f6342d != null && a.this.f6342d.getMacAddress() != null) {
                String macAddress = a.this.f6342d.getMacAddress();
                synchronized (a.this.h) {
                    ArrayList<Device> dMRList = SDKCastMgr.getInstance().getDMRList();
                    if (dMRList != null) {
                        int i = 0;
                        while (true) {
                            if (i >= dMRList.size()) {
                                break;
                            }
                            try {
                                device2 = dMRList.get(i);
                            } catch (IndexOutOfBoundsException e) {
                                e.printStackTrace();
                            }
                            if (device2 == null || !macAddress.equalsIgnoreCase(device2.getMacAddress())) {
                                i++;
                            } else if (SDKCastMgr.getInstance().selectDevice(device2) == 0) {
                                z2 = true;
                            }
                        }
                    }
                    z2 = false;
                }
                synchronized (a.this.i) {
                    ArrayList<Device> dMSList = SDKCastMgr.getInstance().getDMSList();
                    if (dMSList != null) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= dMSList.size()) {
                                break;
                            }
                            try {
                                device = dMSList.get(i2);
                            } catch (IndexOutOfBoundsException e2) {
                                e2.printStackTrace();
                            }
                            if (device == null || !macAddress.equalsIgnoreCase(device.getMacAddress())) {
                                i2++;
                            } else if (SDKCastMgr.getInstance().selectDevice(device) == 0) {
                                z = true;
                            }
                        }
                    }
                    z = false;
                }
            } else {
                LogEx.d("DLNAManager", "refresh favDev status mFavDev  is null ");
                z = false;
                z2 = false;
            }
            if (!a.this.f6339a) {
                a.this.a(1, new DLNAEvent(DLNAEvent.EVENT_DEVICE_ONLINE, Integer.toString(0), null, "10"));
                LogEx.d("DLNAManager", "notifyLinstener EVENT_DEVICE_ONLINE");
            } else if (z2 || z) {
                a.this.a(1, new DLNAEvent(DLNAEvent.EVENT_DEVICE_ONLINE, Integer.toString(0), null, "10"));
                LogEx.d("DLNAManager", "notifyLinstener EVENT_DEVICE_ONLINE");
            }
        }
    }

    /* compiled from: IPTVDLNAMgr.java */
    /* loaded from: classes.dex */
    class l implements Runnable {
        l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            boolean z2;
            Device device;
            Device device2;
            LogEx.d("DLNAManager", "check favDev offline ...");
            if (a.this.f6342d != null && a.this.f6342d.getMacAddress() != null) {
                String macAddress = a.this.f6342d.getMacAddress();
                synchronized (a.this.h) {
                    ArrayList<Device> dMRList = SDKCastMgr.getInstance().getDMRList();
                    if (dMRList != null) {
                        int i = 0;
                        while (true) {
                            if (i >= dMRList.size()) {
                                break;
                            }
                            try {
                                device2 = dMRList.get(i);
                            } catch (IndexOutOfBoundsException e) {
                                e.printStackTrace();
                            }
                            if (device2 == null || !macAddress.equalsIgnoreCase(device2.getMacAddress())) {
                                i++;
                            } else if (SDKCastMgr.getInstance().selectDevice(device2) == 0) {
                                z2 = true;
                            }
                        }
                    }
                    z2 = false;
                }
                synchronized (a.this.i) {
                    ArrayList<Device> dMSList = SDKCastMgr.getInstance().getDMSList();
                    if (dMSList != null) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= dMSList.size()) {
                                break;
                            }
                            try {
                                device = dMSList.get(i2);
                            } catch (IndexOutOfBoundsException e2) {
                                e2.printStackTrace();
                            }
                            if (device == null || !macAddress.equalsIgnoreCase(device.getMacAddress())) {
                                i2++;
                            } else if (SDKCastMgr.getInstance().selectDevice(device) == 0) {
                                z = true;
                            }
                        }
                    }
                    z = false;
                }
            } else {
                LogEx.d("DLNAManager", "check favDev offline  mFavDev is null");
                z = false;
                z2 = false;
            }
            if (!a.this.f6339a) {
                a.this.a(1, new DLNAEvent(DLNAEvent.EVENT_DEVICE_OFFLINE, Integer.toString(0), null, "10"));
                LogEx.d("DLNAManager", "notifyLinstener EVENT_DEVICE_OFFLINE");
            } else {
                if (z2 && z) {
                    return;
                }
                a.this.a(1, new DLNAEvent(DLNAEvent.EVENT_DEVICE_OFFLINE, Integer.toString(0), null, "10"));
                LogEx.d("DLNAManager", "notifyLinstener EVENT_DEVICE_OFFLINE");
            }
        }
    }

    /* compiled from: IPTVDLNAMgr.java */
    /* loaded from: classes.dex */
    class m implements SDKCastMgr.IDLNAActionCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ r f6356a;

        m(r rVar) {
            this.f6356a = rVar;
        }

        @Override // com.video.androidsdk.cast.SDKCastMgr.IDLNAActionCallback
        public void onDLNAResponse(String str, String str2, Map<String, String> map) {
            LogEx.d("DLNAManager", "query current transportinfo response: " + str2 + "[" + str + "]");
            if (map == null || !map.containsKey(ParamConst.DLNA_SENDDMRGETCURRTRANSPORTINFO_RSP_CURRENTTRANSPORTSTATE)) {
                a.this.a(10, (DLNAEvent) null);
            } else {
                a.this.a(10, new DLNAEvent("dlna.gettransportinfo.complete", str, str2, map.get(ParamConst.DLNA_SENDDMRGETCURRTRANSPORTINFO_RSP_CURRENTTRANSPORTSTATE)));
            }
            if (map != null) {
                this.f6356a.a(map.get("returncode"), map.get(ParamConst.DLNA_SENDDMRGETCURRTRANSPORTINFO_RSP_CURRENTTRANSPORTSTATE), map.get(ParamConst.DLNA_SENDDMRGETCURRTRANSPORTINFO_RSP_CURRENTTRANSPORTSTATUS));
                return;
            }
            this.f6356a.a(WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, "", "");
        }
    }

    /* compiled from: IPTVDLNAMgr.java */
    /* loaded from: classes.dex */
    class n implements SDKCastMgr.IInitDLNAListener {
        n() {
        }

        @Override // com.video.androidsdk.cast.SDKCastMgr.IInitDLNAListener
        public void onInitDLNAReturn(String str, String str2) {
            if (!"0".equals(str)) {
                LogEx.e("DLNAManager", "DLNA initilize failed!");
                return;
            }
            LogEx.d("DLNAManager", "onInitDLNAReturn " + str + " postDelayed RefreshPairFaveDev");
            a.q.postDelayed(a.this.k, (long) a.o);
        }
    }

    /* compiled from: IPTVDLNAMgr.java */
    /* loaded from: classes.dex */
    class o implements SDKCastMgr.IDLNANotifyListener {
        o() {
        }

        @Override // com.video.androidsdk.cast.SDKCastMgr.IDLNANotifyListener
        public void onDLNANotify(int i, Map<String, ArrayList<Device>> map) {
            LogEx.d("DLNAManager", "Base onDLNANotify EventNo=" + i);
            if (i == 1) {
                a.q.postDelayed(a.this.l, a.o);
                return;
            }
            if (i == 16) {
                a.q.postDelayed(a.this.m, a.o);
                return;
            }
            for (Map.Entry<String, ArrayList<Device>> entry : map.entrySet()) {
                try {
                    a.this.a(-1, new DLNAEvent(entry.getKey(), entry.getKey(), "0", entry.getValue()));
                    LogEx.d("DLNAManager", "notifyLinstener DLNAACTION_INIT_COMPLETE key " + entry.getKey() + " value=" + entry.getValue());
                } catch (NumberFormatException unused) {
                    LogEx.w("DLNAManager", "Got unknow event " + entry.getKey());
                }
            }
        }
    }

    /* compiled from: IPTVDLNAMgr.java */
    /* loaded from: classes.dex */
    public interface p {
        void a(DLNAEvent dLNAEvent);
    }

    /* compiled from: IPTVDLNAMgr.java */
    /* loaded from: classes.dex */
    public interface q {
        void a(BackplayPositionInfoBean backplayPositionInfoBean);
    }

    /* compiled from: IPTVDLNAMgr.java */
    /* loaded from: classes.dex */
    public interface r {
        void a(String str, String str2, String str3);
    }

    public a() {
        this.e = null;
        this.e = new HashMap<>();
        q = new Handler();
        this.h = new Object();
        this.i = new Object();
        this.f = new n();
        this.g = new o();
        SDKCastMgr.getInstance().setCarePairOnly(this.f6339a);
        SDKCastMgr.getInstance().setDLNANotifyListener(this.g);
    }

    public void a(String str) {
    }

    protected void finalize() throws Throwable {
        SDKCastMgr.getInstance().setDLNANotifyListener(null);
        super.finalize();
    }

    private synchronized String f() {
        int i2;
        i2 = this.j + 1;
        this.j = i2;
        NumberFormat numberInstance = NumberFormat.getNumberInstance();
        numberInstance.setMinimumIntegerDigits(8);
        numberInstance.setGroupingUsed(false);
        return String.valueOf(i2);
    }

    public static a g() {
        if (p == null) {
            p = new a();
        }
        return p;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(android.content.Context r12) {
        /*
            r11 = this;
            com.video.androidsdk.login.SDKLoginMgr r0 = com.video.androidsdk.login.SDKLoginMgr.getInstance()
            java.lang.String r1 = "MultiGate_Host_IP"
            java.lang.String r0 = r0.getPropertiesInfo(r1)
            com.video.androidsdk.login.SDKLoginMgr r1 = com.video.androidsdk.login.SDKLoginMgr.getInstance()
            java.lang.String r2 = "MultiGate_Host_Port"
            java.lang.String r1 = r1.getPropertiesInfo(r2)
            com.video.androidsdk.login.SDKLoginMgr r2 = com.video.androidsdk.login.SDKLoginMgr.getInstance()
            java.lang.String r3 = "UserID"
            java.lang.String r2 = r2.getUserInfo(r3)
            com.video.androidsdk.login.SDKLoginMgr r3 = com.video.androidsdk.login.SDKLoginMgr.getInstance()
            java.lang.String r4 = "UserToken"
            java.lang.String r3 = r3.getUserInfo(r4)
            com.video.androidsdk.login.SDKLoginMgr r4 = com.video.androidsdk.login.SDKLoginMgr.getInstance()
            java.lang.String r5 = "DlnaOPFlag"
            java.lang.String r4 = r4.getPropertiesInfo(r5)
            if (r4 != 0) goto L38
            java.lang.String r4 = com.video.androidsdk.common.config.ConfigMgr.readPropertie(r5)
        L38:
            if (r4 == 0) goto L43
            int r4 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.NumberFormatException -> L3f
            goto L44
        L3f:
            r4 = move-exception
            r4.printStackTrace()
        L43:
            r4 = 2
        L44:
            com.video.androidsdk.login.SDKLoginMgr r5 = com.video.androidsdk.login.SDKLoginMgr.getInstance()
            java.lang.String r6 = "DlnaFlag"
            java.lang.String r5 = r5.getPropertiesInfo(r6)
            if (r5 != 0) goto L54
            java.lang.String r5 = com.video.androidsdk.common.config.ConfigMgr.readPropertie(r6)
        L54:
            java.lang.String r6 = "0"
            boolean r5 = r6.equals(r5)
            r5 = r5 ^ 1
            com.video.androidsdk.login.SDKLoginMgr r7 = com.video.androidsdk.login.SDKLoginMgr.getInstance()
            java.lang.String r8 = "DlnaDevFlag"
            java.lang.String r7 = r7.getPropertiesInfo(r8)
            if (r7 != 0) goto L6c
            java.lang.String r7 = com.video.androidsdk.common.config.ConfigMgr.readPropertie(r8)
        L6c:
            boolean r6 = r6.equals(r7)
            r6 = r6 ^ 1
            java.lang.String r7 = com.video.androidsdk.common.AndroidUniqueCode.getAndroidId(r12)
            com.video.androidsdk.cast.bean.DLNAInitReq r8 = new com.video.androidsdk.cast.bean.DLNAInitReq
            r8.<init>()
            r8.setGateDomain(r0, r1)
            r8.setUserInfo(r2, r3)
            r8.setUpnpPares(r4, r5, r6)
            r8.setDeviceId(r7)
            com.video.androidsdk.cast.SDKCastMgr r9 = com.video.androidsdk.cast.SDKCastMgr.getInstance()
            com.video.androidsdk.cast.SDKCastMgr$IInitDLNAListener r10 = r11.f
            int r12 = r9.initDLNA(r12, r8, r10)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "DLNA multiHost : "
            r8.append(r9)
            r8.append(r0)
            java.lang.String r0 = ", multiPort : "
            r8.append(r0)
            r8.append(r1)
            java.lang.String r0 = ",userid:"
            r8.append(r0)
            r8.append(r2)
            java.lang.String r0 = ",usertoken:"
            r8.append(r0)
            r8.append(r3)
            java.lang.String r0 = ",opflag:"
            r8.append(r0)
            r8.append(r4)
            java.lang.String r0 = ",needdlna:"
            r8.append(r0)
            r8.append(r5)
            java.lang.String r0 = ",devflag:"
            r8.append(r0)
            r8.append(r6)
            java.lang.String r0 = ",deviceid:"
            r8.append(r0)
            r8.append(r7)
            java.lang.String r0 = r8.toString()
            java.lang.String r1 = "DLNAManager"
            com.video.androidsdk.log.LogEx.i(r1, r0)
            if (r12 != 0) goto Le7
            java.lang.String r12 = "DLNA initilizing ..."
            com.video.androidsdk.log.LogEx.i(r1, r12)
            goto Lf5
        Le7:
            java.lang.String r12 = " [cast_error] DLNA initilize failed."
            com.video.androidsdk.log.LogEx.e(r1, r12)
            com.zte.iptvclient.android.common.f.b.h r0 = com.zte.iptvclient.android.common.f.b.h.a()
            java.lang.String r1 = ""
            r0.a(r1, r12)
        Lf5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.mobile.h.a.a.b(android.content.Context):void");
    }

    public void c() {
        if (this.f6340b) {
            return;
        }
        LogEx.d("DLNAManager", "scanDevices!");
        SDKCastMgr.getInstance().scanDevices();
    }

    public int a(r rVar) {
        LogEx.d("DLNAManager", "queryTransportInfo");
        if (SDKCastMgr.getInstance().getPairDMR() == null) {
            LogEx.w("DLNAManager", "DMR is offline!");
            rVar.a(WeiboAuthException.DEFAULT_AUTH_ERROR_CODE, "", "");
            return 16;
        }
        SDKCastMgr.getInstance().getTransportInfo(f(), new m(rVar));
        return 0;
    }

    public void c(String str) {
        LogEx.d("DLNAManager", "setAVTransportURI:" + str);
        SDKCastMgr.getInstance().playMediaWithURI(str, f(), new b());
    }

    public ArrayList<Device> a() {
        ArrayList<Device> arrayList = new ArrayList<>();
        try {
            if (SDKCastMgr.getInstance().getDMRList() != null) {
                LogEx.d("DLNAManager", "SDKCastMgr.getInstance().getDMRList() is not null ");
            } else {
                LogEx.d("DLNAManager", "SDKCastMgr.getInstance().getDMRList() is null");
            }
            arrayList.addAll(SDKCastMgr.getInstance().getDMRList());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    public Device a(Device device) {
        IndexOutOfBoundsException e2;
        this.f6342d = device;
        if (device != null && !TextUtils.isEmpty(device.getMacAddress())) {
            LogEx.d("DLNAManager", "setSelectDrm Name=" + this.f6342d.getSTBName());
            String macAddress = this.f6342d.getMacAddress();
            ArrayList<Device> dMRList = SDKCastMgr.getInstance().getDMRList();
            int i2 = 0;
            if (dMRList != null) {
                LogEx.d("DLNAManager", "setSelectDrm MAcAdress=" + macAddress);
                int i3 = 0;
                while (i2 < dMRList.size()) {
                    int i4 = 1;
                    try {
                        Device device2 = dMRList.get(i2);
                        if (device2 != null) {
                            LogEx.d("DLNAManager", "onlineDevice MAcAdress=" + device2.getMacAddress());
                            if (macAddress.equalsIgnoreCase(device2.getMacAddress()) && SDKCastMgr.getInstance().selectDevice(device2) == 0) {
                                try {
                                    LogEx.d("DLNAManager", "setSelectDrm bind sucess!");
                                    i3 = 1;
                                } catch (IndexOutOfBoundsException e3) {
                                    e2 = e3;
                                    e2.printStackTrace();
                                    i3 = i4;
                                }
                            }
                        }
                        i2++;
                    } catch (IndexOutOfBoundsException e4) {
                        i4 = i3;
                        e2 = e4;
                    }
                }
                i2 = i3;
            }
            if (i2 == 0) {
                SDKCastMgr.getInstance().selectDevice(null);
            }
            return SDKCastMgr.getInstance().getPairDMR();
        }
        SDKCastMgr.getInstance().selectDevice(null);
        return null;
    }

    public Device b() {
        return SDKCastMgr.getInstance().getPairDMR();
    }

    public void b(String str, String str2) {
        LogEx.d("DLNAManager", "showScanSTBPopupWin - " + str + " : " + str2);
        DLNAEvent dLNAEvent = new DLNAEvent(DLNAEvent.EVENT_DEVICE_OFFLINE, "", null, str2);
        if (str != null) {
            dLNAEvent.setArg1(str);
        }
        a(1, dLNAEvent);
    }

    public void a(p pVar, int i2) {
        if (this.e.containsKey(pVar)) {
            ArrayList<Integer> arrayList = this.e.get(pVar);
            if (arrayList.contains(0) || arrayList.contains(Integer.valueOf(i2))) {
                return;
            }
            if (i2 == 0) {
                arrayList.clear();
            }
            arrayList.add(Integer.valueOf(i2));
            return;
        }
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(Integer.valueOf(i2));
        this.e.put(pVar, arrayList2);
    }

    public void b(String str) {
        LogEx.d("IPTVDLNAMgr", "inputcontent" + str);
        try {
            str = com.zte.iptvclient.android.mobile.q.b.a.a(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        SDKCastMgr.getInstance().getSTBConfig(f(), "_stbcmd_sendtext2webpage_" + str, new g());
    }

    public void a(int i2) {
        LogEx.i("DLNAManager", "sendKeycode:" + i2);
        SDKCastMgr.getInstance().sendRemoteKey(Integer.toString(i2), f(), new C0267a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(int i2, DLNAEvent dLNAEvent) {
        LogEx.d("DLNAManager", " notifyLinstener iEventType = " + i2 + ",event= " + dLNAEvent);
        while (this.f6341c) {
            try {
                wait(300L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
        this.f6341c = true;
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<p, ArrayList<Integer>> entry : this.e.entrySet()) {
            try {
                p key = entry.getKey();
                ArrayList<Integer> value = entry.getValue();
                if (value != null) {
                    Iterator<Integer> it2 = value.iterator();
                    while (it2.hasNext()) {
                        Integer next = it2.next();
                        if (next.intValue() == 0 || next.intValue() == i2) {
                            arrayList.add(key);
                            break;
                        }
                    }
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            ((p) it3.next()).a(dLNAEvent);
        }
        this.f6341c = false;
    }

    public void a(String str, String str2, String str3) {
        LogEx.d("IPTVDLNAMgr", "sendUserNameToStb userId=" + str);
        String replace = "{\"userid\":\"replace_userId\" , \"deviceid\":\"replace_deviceId\" , \"username\":\"replace_username\"}".replace("replace_userId", str).replace("replace_deviceId", str2).replace("replace_username", str3);
        try {
            replace = com.zte.iptvclient.android.mobile.q.b.a.a(replace.getBytes("GBK"));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        String str4 = "_stbbroadcast_" + replace;
        LogEx.d("IPTVDLNAMgr", "In sendUerNameAndDeviceIdToStb userJson=" + str4);
        LogEx.d("IPTVDLNAMgr", "sendUserNameToStb getSTBConfig");
        SDKCastMgr.getInstance().getSTBConfig(f(), str4, new c());
    }

    public String a(Context context) {
        SDKCastMgr.getInstance().getSTBConfig(f(), "{\"cmdtype\":\"getcpcode\"}", new d());
        return this.n;
    }

    public void a(String str, String str2, String str3, long j2, String str4, String str5) {
        String d2 = com.zte.iptvclient.common.uiframe.a.d("UserID");
        StringBuilder sb = new StringBuilder();
        sb.append("{\"cmdtype\":\"mirocast\",\"type\":\"0\",\"pushtype\":\"");
        sb.append(str);
        sb.append("\",\"userid\":\"");
        sb.append(d2);
        sb.append("\",\"contentid\":\"");
        sb.append(str2);
        sb.append("\",\"url\":\"");
        sb.append(Uri.encode("url=" + str3 + "&pushtype=" + str + "&telecomcode=" + str5 + "&mixno=" + str4));
        sb.append("\",\"breakpoint\":\"");
        sb.append((int) Math.floor((double) (j2 / 1000)));
        sb.append("\"}");
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(j2);
        sb3.append("");
        LogEx.d("------breakpoint------", sb3.toString());
        LogEx.d("-----strKeyNmaesss-----", sb2);
        SDKCastMgr.getInstance().getSTBConfig(f(), sb2, new e());
    }

    public void a(int i2, int i3, int i4, int i5, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("pushtype=7");
        sb.append("&sceneid=");
        sb.append(i2);
        sb.append("&filmdirid=");
        sb.append(i3);
        sb.append("&filmindex=");
        sb.append(i4);
        sb.append("&action=");
        sb.append(i5);
        sb.append("&breakpoint=");
        sb.append(str);
        LogEx.d("IPTVDLNAMgr", "-----pushSTBPlayerControl---" + sb.toString());
        SDKCastMgr.getInstance().playMediaWithURI(sb.toString().trim(), new f());
    }

    public int a(q qVar) {
        LogEx.d("DLNAManager", "queryPositionInfo");
        if (SDKCastMgr.getInstance().getPairDMR() == null) {
            LogEx.w("DLNAManager", "DMR is offline!");
            return 16;
        }
        SDKCastMgr.getInstance().getPositionInfo(f(), new i(qVar));
        return 0;
    }

    public void a(String str, String str2) {
        SDKCastMgr.getInstance().seek(str, str2, f(), new j());
    }
}
