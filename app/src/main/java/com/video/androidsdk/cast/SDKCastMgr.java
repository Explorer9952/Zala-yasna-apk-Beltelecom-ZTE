package com.video.androidsdk.cast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.video.androidsdk.cast.bean.DLNAInitReq;
import com.video.androidsdk.cast.bean.Device;
import com.video.androidsdk.common.ClientNetworkInfo;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.ErrMessage;
import com.video.androidsdk.common.http.HttpConstant;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.comm.ParamConst;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes.dex */
public final class SDKCastMgr {
    private static SDKCastMgr C = null;
    public static final int CODE_RECEIVED = 501;
    public static final int DLNA_NOTIFY_DEVICE_OFFLINE = 16;
    public static final int DLNA_NOTIFY_DEVICE_ONLINE = 1;
    public static final int DLNA_NOTIFY_UNKNOW = 0;
    public static final String DMRDEVICELIST = "DMRDeviceList";
    public static final String DMSDEVICELIST = "DMSDeviceList";
    public static final int ERR_DEVICE_OFFLINE = 170003;
    public static final int ERR_DLNAINIT_FAILED = 170002;
    public static final int ERR_DLNAINIT_NOIP = 170001;
    public static final int ERR_MISS_PARAM = 170004;
    public static final int ERR_PARAM_INVALID = 170005;
    public static final int ERR_REQUEST_OVERFLOW = 170009;

    /* renamed from: d, reason: collision with root package name */
    private static Context f3043d;
    public static String mRequestConfigFilePath;
    private BroadcastReceiver e;
    private c f;
    private Map<String, a> k;
    private ArrayList<Device> l;
    private ArrayList<Device> m;
    private volatile Device n;
    private volatile Device o;
    private IInitDLNAListener p;
    private IDLNANotifyListener q;

    /* renamed from: a, reason: collision with root package name */
    private static Handler f3042a = new Handler();
    private static Object B = new Object();

    /* renamed from: b, reason: collision with root package name */
    private boolean f3044b = false;

    /* renamed from: c, reason: collision with root package name */
    private String f3045c = null;
    private int g = 0;
    private long h = 0;
    private boolean i = false;
    private boolean j = false;
    private int r = 0;
    private boolean s = true;
    private String t = null;
    private String u = "";
    private String v = "";
    private String w = "";
    private String x = "";
    private int y = 2;
    private boolean z = true;
    private boolean A = true;
    private Runnable D = new d(this);

    /* loaded from: classes.dex */
    public interface IDLNAActionCallback {
        void onDLNAResponse(String str, String str2, Map<String, String> map);
    }

    /* loaded from: classes.dex */
    public interface IDLNANotifyListener {
        void onDLNANotify(int i, Map<String, ArrayList<Device>> map);
    }

    /* loaded from: classes.dex */
    public interface IInitDLNAListener {
        void onInitDLNAReturn(String str, String str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        int f3046a;

        /* renamed from: b, reason: collision with root package name */
        long f3047b;

        /* renamed from: c, reason: collision with root package name */
        IDLNAActionCallback f3048c;

        public a(int i, long j, IDLNAActionCallback iDLNAActionCallback) {
            this.f3046a = i;
            this.f3047b = j;
            this.f3048c = iDLNAActionCallback;
        }

        public int a() {
            return this.f3046a;
        }

        public IDLNAActionCallback b() {
            return this.f3048c;
        }
    }

    static {
        System.loadLibrary("threadutil");
        System.loadLibrary("ixml");
        System.loadLibrary("upnp");
        System.loadLibrary("qcsdlna");
        System.loadLibrary("dlnajni");
        System.loadLibrary("mesjni");
    }

    private SDKCastMgr() {
        this.k = null;
        d();
        this.l = new ArrayList<>();
        this.m = new ArrayList<>();
        this.k = new HashMap();
        this.f = new g(this);
    }

    public static SDKCastMgr getInstance() {
        SDKCastMgr sDKCastMgr;
        synchronized (B) {
            if (C == null) {
                C = new SDKCastMgr();
            }
            sDKCastMgr = C;
        }
        return sDKCastMgr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int l(SDKCastMgr sDKCastMgr) {
        int i = sDKCastMgr.r - 1;
        sDKCastMgr.r = i;
        return i;
    }

    public void bindQRCode(String str, Map<String, String> map, String str2, String str3, IDLNAActionCallback iDLNAActionCallback) {
        if (!com.video.androidsdk.license.a.f3130b) {
            LogEx.e("SDKCastMgr", ErrMessage.LIC_INVALIDATE);
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 17)), ErrMessage.LIC_INVALIDATE, null);
                return;
            }
            return;
        }
        if (!this.f3044b) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 18)), "dlna not init", null);
                return;
            }
            return;
        }
        if (this.k.size() > 1000) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 19)), "request overflow", null);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(this.n.getUDN())) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 20)), "device offline", null);
                return;
            }
            return;
        }
        if (str2 == null) {
            str2 = e();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        sb.append("<request>");
        sb.append("<DeviceID>");
        sb.append(str);
        sb.append("</DeviceID>");
        sb.append("<UserToken>");
        sb.append(str3);
        sb.append("</UserToken>");
        sb.append("</request>");
        this.k.put(str2, new a(20, System.currentTimeMillis(), iDLNAActionCallback));
        com.video.androidsdk.cast.a.a().a(8522, sb.length(), sb.toString());
    }

    protected void finalize() throws Throwable {
        com.video.androidsdk.cast.a.a().b(this.f);
        f3042a = null;
        f3043d.unregisterReceiver(this.e);
        super.finalize();
    }

    public void getChannelInfo(IDLNAActionCallback iDLNAActionCallback) {
        getChannelInfo(e(), iDLNAActionCallback);
    }

    public ArrayList<Device> getDMRList() {
        if (!com.video.androidsdk.license.a.f3130b) {
            LogEx.e("SDKCastMgr", ErrMessage.LIC_INVALIDATE);
            return null;
        }
        return this.l;
    }

    public ArrayList<Device> getDMSList() {
        if (!com.video.androidsdk.license.a.f3130b) {
            LogEx.e("SDKCastMgr", ErrMessage.LIC_INVALIDATE);
            return null;
        }
        return this.m;
    }

    public void getMediaInfo(IDLNAActionCallback iDLNAActionCallback) {
        getMediaInfo(e(), iDLNAActionCallback);
    }

    public Device getPairDMR() {
        if (!com.video.androidsdk.license.a.f3130b) {
            LogEx.e("SDKCastMgr", ErrMessage.LIC_INVALIDATE);
            return null;
        }
        return this.n;
    }

    public Device getPairDMS() {
        if (!com.video.androidsdk.license.a.f3130b) {
            LogEx.e("SDKCastMgr", ErrMessage.LIC_INVALIDATE);
            return null;
        }
        return this.o;
    }

    public void getPositionInfo(IDLNAActionCallback iDLNAActionCallback) {
        getPositionInfo(e(), iDLNAActionCallback);
    }

    public void getSTBConfig(String str, IDLNAActionCallback iDLNAActionCallback) {
        getSTBConfig(e(), str, iDLNAActionCallback);
    }

    public String getSelectedDeviceUDN() {
        if (!com.video.androidsdk.license.a.f3130b) {
            LogEx.e("SDKCastMgr", ErrMessage.LIC_INVALIDATE);
            return null;
        }
        if (this.n != null) {
            return this.n.getUDN();
        }
        return null;
    }

    public void getTransportInfo(IDLNAActionCallback iDLNAActionCallback) {
        getTransportInfo(e(), iDLNAActionCallback);
    }

    public void getVolume(IDLNAActionCallback iDLNAActionCallback) {
        getVolume(e(), iDLNAActionCallback);
    }

    public int initDLNA(Context context, DLNAInitReq dLNAInitReq, IInitDLNAListener iInitDLNAListener) {
        if (!com.video.androidsdk.license.a.f3130b) {
            LogEx.e("SDKCastMgr", ErrMessage.LIC_INVALIDATE);
            return -1;
        }
        if (dLNAInitReq == null) {
            LogEx.d("SDKCastMgr", "req parameters is null, please set the params");
            return 1;
        }
        if (this.j) {
            LogEx.d("SDKCastMgr", "dlna initilizing!");
            return 0;
        }
        if (context == null && this.f3045c == null) {
            LogEx.w("SDKCastMgr", "Context invalid!");
            return 1;
        }
        LogEx.d("SDKCastMgr", "Start dlna!");
        this.p = iInitDLNAListener;
        this.j = true;
        b();
        this.u = dLNAInitReq.getMultiGateHost();
        this.v = dLNAInitReq.getMultiGatePort();
        this.w = dLNAInitReq.getUserID();
        this.x = dLNAInitReq.getUserToken();
        this.y = dLNAInitReq.getOpflag();
        this.z = dLNAInitReq.isNeedDlna();
        this.A = dLNAInitReq.isIsztedevice();
        this.t = dLNAInitReq.getDeviceId();
        return a(context);
    }

    public Boolean isDeviceOnline(String str) {
        if (!com.video.androidsdk.license.a.f3130b) {
            LogEx.e("SDKCastMgr", ErrMessage.LIC_INVALIDATE);
            return false;
        }
        if (!TextUtils.isEmpty(str) && this.l != null) {
            for (int i = 0; i < this.l.size(); i++) {
                if (TextUtils.equals(str, this.l.get(i).getUDN())) {
                    return true;
                }
            }
        }
        return false;
    }

    public Boolean isDeviceSelected(String str) {
        if (!com.video.androidsdk.license.a.f3130b) {
            LogEx.e("SDKCastMgr", ErrMessage.LIC_INVALIDATE);
            return false;
        }
        if (this.n == null || !TextUtils.equals(str, this.n.getUDN())) {
            return false;
        }
        return true;
    }

    public Boolean isSelectedDeviceOnline() {
        if (!com.video.androidsdk.license.a.f3130b) {
            LogEx.e("SDKCastMgr", ErrMessage.LIC_INVALIDATE);
            return false;
        }
        if (this.n != null) {
            String udn = this.n.getUDN();
            if (this.l != null) {
                for (int i = 0; i < this.l.size(); i++) {
                    if (TextUtils.equals(udn, this.l.get(i).getUDN())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void playMediaWithURI(String str, IDLNAActionCallback iDLNAActionCallback) {
        playMediaWithURI(str, e(), iDLNAActionCallback);
    }

    public void reinit() {
    }

    public void scanDevices() {
        if (!com.video.androidsdk.license.a.f3130b) {
            LogEx.e("SDKCastMgr", ErrMessage.LIC_INVALIDATE);
        } else {
            com.video.androidsdk.cast.a.a().c();
        }
    }

    public void seek(String str, String str2, IDLNAActionCallback iDLNAActionCallback) {
        seek(str, str2, e(), iDLNAActionCallback);
    }

    public int selectDevice(Device device) {
        if (!com.video.androidsdk.license.a.f3130b) {
            LogEx.e("SDKCastMgr", ErrMessage.LIC_INVALIDATE);
            return -1;
        }
        if (device == null) {
            return -1;
        }
        if (device.isDMR()) {
            return a(device.getUDN());
        }
        if (device.isDMS()) {
            return b(device.getUDN());
        }
        return -1;
    }

    public void sendContent(String str, IDLNAActionCallback iDLNAActionCallback) {
        sendContent(str, e(), iDLNAActionCallback);
    }

    public void sendRemoteKey(String str, IDLNAActionCallback iDLNAActionCallback) {
        sendRemoteKey(str, e(), iDLNAActionCallback);
    }

    public void sendVoiceTransformText(String str, String str2, IDLNAActionCallback iDLNAActionCallback) {
        sendVoiceTransformText(e(), str, str2, iDLNAActionCallback);
    }

    public void setCarePairOnly(boolean z) {
        if (!com.video.androidsdk.license.a.f3130b) {
            LogEx.e("SDKCastMgr", ErrMessage.LIC_INVALIDATE);
        } else {
            this.s = z;
        }
    }

    public void setDLNANotifyListener(IDLNANotifyListener iDLNANotifyListener) {
        this.q = iDLNANotifyListener;
    }

    public void setLogConfig(int i, String str) {
        if (!com.video.androidsdk.license.a.f3130b) {
            LogEx.e("SDKCastMgr", ErrMessage.LIC_INVALIDATE);
        } else {
            DlnaNativeSDK.JNI_SetLogOption(i, str);
        }
    }

    public void startWriteLog() {
        if (!com.video.androidsdk.license.a.f3130b) {
            LogEx.e("SDKCastMgr", ErrMessage.LIC_INVALIDATE);
        } else {
            DlnaNativeSDK.JNI_StartLogWrite();
        }
    }

    public void stopWriteLog() {
        if (!com.video.androidsdk.license.a.f3130b) {
            LogEx.e("SDKCastMgr", ErrMessage.LIC_INVALIDATE);
        } else {
            DlnaNativeSDK.JNI_StopLogWrite();
        }
    }

    public void uninitDLNA() {
        LogEx.d("SDKCastMgr", "Stop dlna!");
        b();
        com.video.androidsdk.cast.a.a().b(this.f);
        com.video.androidsdk.cast.a.a().b();
        this.f3044b = false;
        BroadcastReceiver broadcastReceiver = this.e;
        if (broadcastReceiver != null) {
            try {
                f3043d.unregisterReceiver(broadcastReceiver);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.e = null;
        }
    }

    public void xmppLogin(String str, String str2) {
        if (!com.video.androidsdk.license.a.f3130b) {
            LogEx.e("SDKCastMgr", ErrMessage.LIC_INVALIDATE);
        } else {
            com.video.androidsdk.cast.a.a().a(str, str2);
        }
    }

    private String c(String str) {
        return str.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\"", "&quot;").replaceAll("'", "&apos;");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void d() {
        /*
            r5 = this;
            android.content.Context r0 = com.video.androidsdk.SDKMgr.getApplicationContext()
            java.io.File r0 = r0.getFilesDir()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r0 = r0.getAbsolutePath()
            r1.append(r0)
            java.lang.String r0 = "/"
            r1.append(r0)
            java.lang.String r0 = "requestconfig.xml"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.video.androidsdk.cast.SDKCastMgr.mRequestConfigFilePath = r0
            r0 = 0
            java.io.FileWriter r1 = new java.io.FileWriter     // Catch: java.lang.Throwable -> L48 java.io.IOException -> L4d
            java.lang.String r2 = com.video.androidsdk.cast.SDKCastMgr.mRequestConfigFilePath     // Catch: java.lang.Throwable -> L48 java.io.IOException -> L4d
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L48 java.io.IOException -> L4d
            com.video.androidsdk.common.config.RequestConfigDefaultClass r0 = new com.video.androidsdk.common.config.RequestConfigDefaultClass     // Catch: java.io.IOException -> L46 java.lang.Throwable -> L5f
            r0.<init>()     // Catch: java.io.IOException -> L46 java.lang.Throwable -> L5f
            java.lang.String r2 = r1.toString()     // Catch: java.io.IOException -> L46 java.lang.Throwable -> L5f
            java.lang.String r3 = "write"
            com.video.androidsdk.common.util.SecurityUtil.securityCheck(r2, r3)     // Catch: java.io.IOException -> L46 java.lang.Throwable -> L5f
            java.lang.String r0 = r0.getXMLStr()     // Catch: java.io.IOException -> L46 java.lang.Throwable -> L5f
            r1.write(r0)     // Catch: java.io.IOException -> L46 java.lang.Throwable -> L5f
            r1.close()     // Catch: java.io.IOException -> L5a
            goto L5e
        L46:
            r0 = move-exception
            goto L51
        L48:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L60
        L4d:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L51:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L5f
            if (r1 == 0) goto L5e
            r1.close()     // Catch: java.io.IOException -> L5a
            goto L5e
        L5a:
            r0 = move-exception
            r0.printStackTrace()
        L5e:
            return
        L5f:
            r0 = move-exception
        L60:
            if (r1 == 0) goto L6a
            r1.close()     // Catch: java.io.IOException -> L66
            goto L6a
        L66:
            r1 = move-exception
            r1.printStackTrace()
        L6a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.video.androidsdk.cast.SDKCastMgr.d():void");
    }

    private synchronized String e() {
        return String.valueOf(new SecureRandom().nextInt(Integer.MAX_VALUE));
    }

    public void getChannelInfo(String str, IDLNAActionCallback iDLNAActionCallback) {
        if (!com.video.androidsdk.license.a.f3130b) {
            LogEx.e("SDKCastMgr", ErrMessage.LIC_INVALIDATE);
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 17)), ErrMessage.LIC_INVALIDATE, null);
                return;
            }
            return;
        }
        if (!isSelectedDeviceOnline().booleanValue()) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 15)), ErrMessage.STB_DISCONNECT, null);
                return;
            }
            return;
        }
        if (!this.f3044b) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 18)), "dlna not init", null);
                return;
            }
            return;
        }
        if (this.k.size() > 1000) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 19)), "request overflow", null);
                return;
            }
            return;
        }
        String udn = this.n.getUDN();
        if (TextUtils.isEmpty(udn)) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 20)), "device offline", null);
                return;
            }
            return;
        }
        if (str == null) {
            str = e();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        sb.append("<request>");
        sb.append("<SessionID>");
        sb.append(str);
        sb.append("</SessionID>");
        sb.append("<devudn>");
        sb.append(udn);
        sb.append("</devudn>");
        sb.append("<InstanceID>");
        sb.append("0");
        sb.append("</InstanceID>");
        sb.append("</request>");
        this.k.put(str, new a(1, System.currentTimeMillis(), iDLNAActionCallback));
        com.video.androidsdk.cast.a.a().a(8514, sb.length(), sb.toString());
    }

    public void getMediaInfo(String str, IDLNAActionCallback iDLNAActionCallback) {
        if (!com.video.androidsdk.license.a.f3130b) {
            LogEx.e("SDKCastMgr", ErrMessage.LIC_INVALIDATE);
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 17)), ErrMessage.LIC_INVALIDATE, null);
                return;
            }
            return;
        }
        if (!isSelectedDeviceOnline().booleanValue()) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 15)), ErrMessage.STB_DISCONNECT, null);
                return;
            }
            return;
        }
        if (!this.f3044b) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 18)), "dlna not init", null);
                return;
            }
            return;
        }
        if (this.k.size() > 1000) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 19)), "request overflow", null);
                return;
            }
            return;
        }
        String udn = this.n.getUDN();
        if (TextUtils.isEmpty(udn)) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 20)), "device offline", null);
                return;
            }
            return;
        }
        if (str == null) {
            str = e();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        sb.append("<request>");
        sb.append("<SessionID>");
        sb.append(str);
        sb.append("</SessionID>");
        sb.append("<devudn>");
        sb.append(udn);
        sb.append("</devudn>");
        sb.append("<InstanceID>");
        sb.append("0");
        sb.append("</InstanceID>");
        sb.append("</request>");
        this.k.put(str, new a(13, System.currentTimeMillis(), iDLNAActionCallback));
        com.video.androidsdk.cast.a.a().a(8526, sb.length(), sb.toString());
    }

    public void getPositionInfo(String str, IDLNAActionCallback iDLNAActionCallback) {
        if (!com.video.androidsdk.license.a.f3130b) {
            LogEx.e("SDKCastMgr", ErrMessage.LIC_INVALIDATE);
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 17)), ErrMessage.LIC_INVALIDATE, null);
                return;
            }
            return;
        }
        if (!isSelectedDeviceOnline().booleanValue()) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 15)), ErrMessage.STB_DISCONNECT, null);
                return;
            }
            return;
        }
        if (!this.f3044b) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 18)), "dlna not init", null);
                return;
            }
            return;
        }
        if (this.k.size() > 1000) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 19)), "request overflow", null);
                return;
            }
            return;
        }
        String udn = this.n.getUDN();
        if (TextUtils.isEmpty(udn)) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 20)), "device offline", null);
                return;
            }
            return;
        }
        if (str == null) {
            str = e();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        sb.append("<request>");
        sb.append("<SessionID>");
        sb.append(str);
        sb.append("</SessionID>");
        sb.append("<devudn>");
        sb.append(udn);
        sb.append("</devudn>");
        sb.append("<InstanceID>");
        sb.append("0");
        sb.append("</InstanceID>");
        sb.append("</request>");
        this.k.put(str, new a(3, System.currentTimeMillis(), iDLNAActionCallback));
        com.video.androidsdk.cast.a.a().a(8530, sb.length(), sb.toString());
    }

    public void getSTBConfig(String str, String str2, IDLNAActionCallback iDLNAActionCallback) {
        if (!com.video.androidsdk.license.a.f3130b) {
            LogEx.e("SDKCastMgr", ErrMessage.LIC_INVALIDATE);
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 17)), ErrMessage.LIC_INVALIDATE, null);
                return;
            }
            return;
        }
        if (!isSelectedDeviceOnline().booleanValue()) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 15)), ErrMessage.STB_DISCONNECT, null);
                return;
            }
            return;
        }
        if (!this.f3044b) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 18)), "dlna not init", null);
                return;
            }
            return;
        }
        String udn = this.n.getUDN();
        if (TextUtils.isEmpty(udn)) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 20)), "device offline", null);
                return;
            }
            return;
        }
        if (str == null) {
            str = e();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        sb.append("<request>");
        sb.append("<SessionID>");
        sb.append(str);
        sb.append("</SessionID>");
        sb.append("<devudn>");
        sb.append(udn);
        sb.append("</devudn>");
        sb.append("<KeyName>");
        sb.append(str2);
        sb.append("</KeyName>");
        sb.append("<InstanceID>");
        sb.append("0");
        sb.append("</InstanceID>");
        sb.append("</request>");
        this.k.put(str, new a(12, System.currentTimeMillis(), iDLNAActionCallback));
        com.video.androidsdk.cast.a.a().a(8804, sb.length(), sb.toString());
    }

    public void getTransportInfo(String str, IDLNAActionCallback iDLNAActionCallback) {
        if (!com.video.androidsdk.license.a.f3130b) {
            LogEx.e("SDKCastMgr", ErrMessage.LIC_INVALIDATE);
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 17)), ErrMessage.LIC_INVALIDATE, null);
                return;
            }
            return;
        }
        if (!isSelectedDeviceOnline().booleanValue()) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 15)), ErrMessage.STB_DISCONNECT, null);
                return;
            }
            return;
        }
        if (!this.f3044b) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 18)), "dlna not init", null);
                return;
            }
            return;
        }
        if (this.k.size() > 1000) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 19)), "request overflow", null);
                return;
            }
            return;
        }
        String udn = this.n.getUDN();
        if (TextUtils.isEmpty(udn)) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 20)), "device offline", null);
                return;
            }
            return;
        }
        if (str == null) {
            str = e();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        sb.append("<request>");
        sb.append("<SessionID>");
        sb.append(str);
        sb.append("</SessionID>");
        sb.append("<devudn>");
        sb.append(udn);
        sb.append("</devudn>");
        sb.append("<InstanceID>");
        sb.append("0");
        sb.append("</InstanceID>");
        sb.append("</request>");
        this.k.put(str, new a(2, System.currentTimeMillis(), iDLNAActionCallback));
        com.video.androidsdk.cast.a.a().a(8516, sb.length(), sb.toString());
    }

    public void getVolume(String str, IDLNAActionCallback iDLNAActionCallback) {
        if (!com.video.androidsdk.license.a.f3130b) {
            LogEx.e("SDKCastMgr", ErrMessage.LIC_INVALIDATE);
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 17)), ErrMessage.LIC_INVALIDATE, null);
                return;
            }
            return;
        }
        if (!isSelectedDeviceOnline().booleanValue()) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 15)), ErrMessage.STB_DISCONNECT, null);
                return;
            }
            return;
        }
        if (!this.f3044b) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 18)), "dlna not init", null);
                return;
            }
            return;
        }
        if (this.k.size() > 1000) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 19)), "request overflow", null);
                return;
            }
            return;
        }
        String udn = this.n.getUDN();
        if (TextUtils.isEmpty(udn)) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 20)), "device offline", null);
                return;
            }
            return;
        }
        if (str == null) {
            str = e();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        sb.append("<request>");
        sb.append("<SessionID>");
        sb.append(str);
        sb.append("</SessionID>");
        sb.append("<devudn>");
        sb.append(udn);
        sb.append("</devudn>");
        sb.append("<InstanceID>");
        sb.append("0");
        sb.append("</InstanceID>");
        sb.append("<Channel>");
        sb.append("Master");
        sb.append("</Channel>");
        sb.append("</request>");
        this.k.put(str, new a(4, System.currentTimeMillis(), iDLNAActionCallback));
        com.video.androidsdk.cast.a.a().a(8512, sb.length(), sb.toString());
    }

    public void playMediaWithURI(String str, String str2, IDLNAActionCallback iDLNAActionCallback) {
        if (!com.video.androidsdk.license.a.f3130b) {
            LogEx.e("SDKCastMgr", ErrMessage.LIC_INVALIDATE);
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 17)), ErrMessage.LIC_INVALIDATE, null);
                return;
            }
            return;
        }
        if (!isSelectedDeviceOnline().booleanValue()) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 15)), ErrMessage.STB_DISCONNECT, null);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 3)), ErrMessage.INVALID_PARAM, null);
                return;
            }
            return;
        }
        if (!this.f3044b) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 18)), "dlna not init", null);
                return;
            }
            return;
        }
        String udn = this.n.getUDN();
        if (TextUtils.isEmpty(udn)) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 20)), "device offline", null);
                return;
            }
            return;
        }
        String c2 = c(str);
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        sb.append("<request>");
        sb.append("<SessionID>");
        sb.append(str2);
        sb.append("</SessionID>");
        sb.append("<devudn>");
        sb.append(udn);
        sb.append("</devudn>");
        sb.append("<InstanceID>");
        sb.append("0");
        sb.append("</InstanceID>");
        sb.append("<CurrentURI>");
        sb.append(c2);
        sb.append("</CurrentURI>");
        sb.append("<CurrentURIMetaData></CurrentURIMetaData>");
        sb.append("</request>");
        com.video.androidsdk.cast.a.a().a(8508, sb.length(), sb.toString());
        this.r++;
        f3042a.postDelayed(new f(this, str2, iDLNAActionCallback), 500L);
    }

    public void seek(String str, String str2, String str3, IDLNAActionCallback iDLNAActionCallback) {
        if (!com.video.androidsdk.license.a.f3130b) {
            LogEx.e("SDKCastMgr", ErrMessage.LIC_INVALIDATE);
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 17)), ErrMessage.LIC_INVALIDATE, null);
                return;
            }
            return;
        }
        if (!isSelectedDeviceOnline().booleanValue()) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 15)), ErrMessage.STB_DISCONNECT, null);
                return;
            }
            return;
        }
        if (!this.f3044b) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 18)), "dlna not init", null);
                return;
            }
            return;
        }
        if (this.k.size() > 1000) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 19)), "request overflow", null);
                return;
            }
            return;
        }
        String udn = this.n.getUDN();
        if (TextUtils.isEmpty(udn)) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 20)), "device offline", null);
                return;
            }
            return;
        }
        if (str3 == null) {
            str3 = e();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        sb.append("<request>");
        sb.append("<SessionID>");
        sb.append(str3);
        sb.append("</SessionID>");
        sb.append("<devudn>");
        sb.append(udn);
        sb.append("</devudn>");
        sb.append("<InstanceID>");
        sb.append("0");
        sb.append("</InstanceID>");
        sb.append("<Unit>");
        sb.append(str);
        sb.append("</Unit>");
        sb.append("<Target>");
        sb.append(str2);
        sb.append("</Target>");
        sb.append("</request>");
        this.k.put(str3, new a(14, System.currentTimeMillis(), iDLNAActionCallback));
        com.video.androidsdk.cast.a.a().a(8518, sb.length(), sb.toString());
    }

    public void sendContent(String str, String str2, IDLNAActionCallback iDLNAActionCallback) {
        if (!com.video.androidsdk.license.a.f3130b) {
            LogEx.e("SDKCastMgr", ErrMessage.LIC_INVALIDATE);
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 17)), ErrMessage.LIC_INVALIDATE, null);
                return;
            }
            return;
        }
        if (!isSelectedDeviceOnline().booleanValue()) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 15)), ErrMessage.STB_DISCONNECT, null);
                return;
            }
            return;
        }
        if (str == null) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 3)), ErrMessage.INVALID_PARAM, null);
                return;
            }
            return;
        }
        if (!this.f3044b) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 18)), "dlna not init", null);
                return;
            }
            return;
        }
        if (this.k.size() > 1000) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 19)), "request overflow", null);
                return;
            }
            return;
        }
        String udn = this.n.getUDN();
        if (TextUtils.isEmpty(udn)) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 20)), "device offline", null);
                return;
            }
            return;
        }
        if (str2 == null) {
            str2 = e();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        sb.append("<request>");
        sb.append("<SessionID>");
        sb.append(str2);
        sb.append("</SessionID>");
        sb.append("<devudn>");
        sb.append(udn);
        sb.append("</devudn>");
        sb.append("<InstanceID>");
        sb.append("0");
        sb.append("</InstanceID>");
        sb.append("<content>");
        sb.append(str);
        sb.append("</content>");
        sb.append("<length>");
        sb.append(str.length());
        sb.append("</length>");
        sb.append("</request>");
        this.k.put(str2, new a(6, System.currentTimeMillis(), iDLNAActionCallback));
        com.video.androidsdk.cast.a.a().a(8506, sb.length(), sb.toString());
    }

    public void sendRemoteKey(String str, String str2, IDLNAActionCallback iDLNAActionCallback) {
        if (!com.video.androidsdk.license.a.f3130b) {
            LogEx.e("SDKCastMgr", ErrMessage.LIC_INVALIDATE);
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 17)), ErrMessage.LIC_INVALIDATE, null);
                return;
            }
            return;
        }
        if (!isSelectedDeviceOnline().booleanValue()) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 15)), ErrMessage.STB_DISCONNECT, null);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 3)), ErrMessage.INVALID_PARAM, null);
                return;
            }
            return;
        }
        if (!this.f3044b) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 18)), "dlna not init", null);
                return;
            }
            return;
        }
        if (this.k.size() > 1000) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 19)), "request overflow", null);
                return;
            }
            return;
        }
        String udn = this.n.getUDN();
        if (TextUtils.isEmpty(udn)) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 20)), "device offline", null);
                return;
            }
            return;
        }
        if (str2 == null) {
            str2 = e();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        sb.append("<request>");
        sb.append("<SessionID>");
        sb.append(str2);
        sb.append("</SessionID>");
        sb.append("<devudn>");
        sb.append(udn);
        sb.append("</devudn>");
        sb.append("<InstanceID>");
        sb.append("0");
        sb.append("</InstanceID>");
        sb.append("<Header>");
        sb.append("0xFFFFAAAA");
        sb.append("</Header>");
        sb.append("<Keycode>");
        sb.append(str);
        sb.append("</Keycode>");
        sb.append("</request>");
        this.k.put(str2, new a(5, System.currentTimeMillis(), iDLNAActionCallback));
        com.video.androidsdk.cast.a.a().a(8504, sb.length(), sb.toString());
    }

    public void sendVoiceTransformText(String str, String str2, String str3, IDLNAActionCallback iDLNAActionCallback) {
        if (!this.f3044b) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 18)), "dlna not init", null);
                return;
            }
            return;
        }
        if (!isSelectedDeviceOnline().booleanValue()) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 15)), ErrMessage.STB_DISCONNECT, null);
                return;
            }
            return;
        }
        if (this.k.size() > 1000) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ERR_REQUEST_OVERFLOW), "ERR_REQUEST_OVERFLOW", null);
                return;
            }
            return;
        }
        try {
            String udn = this.n.getUDN();
            if (udn == null) {
                if (iDLNAActionCallback != null) {
                    iDLNAActionCallback.onDLNAResponse(String.valueOf(ERR_DEVICE_OFFLINE), "ERR_DEVICE_OFFLINE", null);
                    return;
                }
                return;
            }
            if (str == null) {
                str = UUID.randomUUID().toString();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
            sb.append("<request>");
            sb.append("<SessionID>");
            sb.append(str);
            sb.append("</SessionID>");
            sb.append("<devudn>");
            sb.append(udn);
            sb.append("</devudn>");
            sb.append("<SoundInfo>");
            sb.append(str2);
            sb.append("</SoundInfo>");
            sb.append("<InstanceID>");
            sb.append("0");
            sb.append("</InstanceID>");
            sb.append("<Type>");
            sb.append(str3);
            sb.append("</Type>");
            sb.append("</request>");
            this.k.put(str, new a(15, System.currentTimeMillis(), iDLNAActionCallback));
            com.video.androidsdk.cast.a.a().a(8806, sb.length(), sb.toString());
        } catch (Exception unused) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ERR_DEVICE_OFFLINE), "ERR_DEVICE_OFFLINE", null);
            }
        }
    }

    private int b(String str) {
        if (this.o != null && str != null && this.o.getUDN().equals(str)) {
            return 0;
        }
        this.o = null;
        if (str != null) {
            for (int i = 0; i < this.m.size(); i++) {
                Device device = this.m.get(i);
                if (str.equalsIgnoreCase(device.getUDN())) {
                    this.o = device;
                    return 0;
                }
            }
        }
        return ERR_DEVICE_OFFLINE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.g = 0;
    }

    private int a(Context context) {
        if (context != null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    if (activeNetworkInfo.getType() == 1) {
                        this.f3045c = new ClientNetworkInfo().getLocalIP((WifiManager) context.getSystemService("wifi"));
                        LogEx.d("SDKCastMgr", "network is switch to WIFI");
                    } else if (activeNetworkInfo.getType() == 0) {
                        this.f3045c = new ClientNetworkInfo().getLocalIPAddress();
                        LogEx.d("SDKCastMgr", "network is switch to mobile");
                    }
                    LogEx.d("SDKCastMgr", "get local ip address:" + this.f3045c);
                    f3043d = context.getApplicationContext();
                    if (this.e == null) {
                        this.e = new e(this);
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                        intentFilter.setPriority(1000);
                        f3043d.registerReceiver(this.e, intentFilter);
                    }
                } else {
                    LogEx.d("SDKCastMgr", "getActiveNetworkInfo is null");
                    this.j = false;
                    return ERR_DLNAINIT_NOIP;
                }
            } catch (Exception e) {
                LogEx.d("SDKCastMgr", "handleMessage error :" + e.getMessage());
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    LogEx.d("SDKCastMgr", stackTraceElement.toString());
                }
                this.j = false;
                return ERR_DLNAINIT_NOIP;
            }
        }
        com.video.androidsdk.cast.a.a(this.f3045c, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.t).a(this.f);
        f3042a.postDelayed(this.D, DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        synchronized (this.l) {
            this.l.clear();
        }
        synchronized (this.m) {
            this.m.clear();
        }
        synchronized (this.k) {
            this.k.clear();
        }
        this.n = null;
        this.o = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(String str) {
        boolean isEmpty = TextUtils.isEmpty(str);
        String str2 = WeiboAuthException.DEFAULT_AUTH_ERROR_CODE;
        if (isEmpty) {
            return WeiboAuthException.DEFAULT_AUTH_ERROR_CODE;
        }
        if (!str.startsWith("rtsp") && str.indexOf("virtualDomain") != -1) {
            if (str.startsWith(HttpConstant.PROTOCOL_HTTP)) {
                String a2 = a(str, "virtualDomain");
                String a3 = a(str, "PlayType");
                if (a2.contains(".tvod_") || a2.contains(".npvr_") || a3.equals(ParamConst.PLAY_CONTENTTYPE_TVOD) || a3.equals(ParamConst.PLAY_CONTENTTYPE_NPVR)) {
                    str2 = "2";
                } else if (a2.contains(".vod_") || a3.equals(ParamConst.PLAY_CONTENTTYPE_VOD)) {
                    str2 = "0";
                }
            }
        } else {
            str2 = a(str, "playtype");
        }
        LogEx.d("SDKCastMgr", "in distinguishTvodAndVodPlayType playType=" + str2);
        return str2;
    }

    private int a(String str) {
        if (this.n != null && this.n.getUDN().equals(str)) {
            return 0;
        }
        this.n = null;
        if (str != null) {
            for (int i = 0; i < this.l.size(); i++) {
                Device device = this.l.get(i);
                if (str.equalsIgnoreCase(device.getUDN())) {
                    this.n = device;
                    return 0;
                }
            }
        }
        return ERR_DEVICE_OFFLINE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, IDLNAActionCallback iDLNAActionCallback) {
        if (!this.f3044b) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 18)), "dlna not init", null);
                return;
            }
            return;
        }
        String udn = this.n.getUDN();
        if (TextUtils.isEmpty(udn)) {
            if (iDLNAActionCallback != null) {
                iDLNAActionCallback.onDLNAResponse(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_DLNA_MODELCODE, 20)), "device offline", null);
                return;
            }
            return;
        }
        if (str == null) {
            str = e();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        sb.append("<request>");
        sb.append("<SessionID>");
        sb.append(str);
        sb.append("</SessionID>");
        sb.append("<devudn>");
        sb.append(udn);
        sb.append("</devudn>");
        sb.append("<InstanceID>");
        sb.append("0");
        sb.append("</InstanceID>");
        sb.append("<Speed>");
        sb.append("1");
        sb.append("</Speed>");
        sb.append("</request>");
        com.video.androidsdk.cast.a.a().a(8510, sb.length(), sb.toString());
        this.k.put(str, new a(7, System.currentTimeMillis(), iDLNAActionCallback));
    }

    private String a(String str, String str2) {
        if (str.indexOf(str2) <= -1) {
            return "";
        }
        String substring = str.substring(str.indexOf(str2 + "=") + str2.length() + 1);
        LogEx.d("SDKCastMgr", "parTem1=" + substring);
        String substring2 = substring.substring(0, substring.indexOf("&"));
        LogEx.d("SDKCastMgr", "parTem2=" + substring2);
        return substring2;
    }
}
