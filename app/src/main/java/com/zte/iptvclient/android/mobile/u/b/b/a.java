package com.zte.iptvclient.android.mobile.u.b.b;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.video.androidsdk.common.GlobalConst;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.channel.SDKChannelMgr;
import com.video.androidsdk.service.comm.ParamConst;
import com.video.androidsdk.service.prevue.SDKPrevueMgr;
import com.video.androidsdk.service.vod.SDKVodMgr;
import com.zte.iptvclient.android.common.customview.a.a.e.f;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.common.javabean.models.VideoDetailBean;
import com.zte.iptvclient.android.common.k.x;
import com.zte.iptvclient.android.mobile.dlna.bean.BackplayPositionInfoBean;
import com.zte.iptvclient.android.mobile.h.a.a;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.video.ContentType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RemoteDirectionLayout.java */
/* loaded from: classes2.dex */
public class a extends RelativeLayout {
    private View A;
    private View B;
    private View C;
    private ImageView D;
    private RelativeLayout E;
    private ImageView F;
    private ImageView G;
    private ImageView J;
    private ImageView K;
    private ImageView L;
    private boolean M;
    private ArrayList<com.zte.iptvclient.android.common.javabean.models.c> N;
    private ArrayList<com.zte.iptvclient.android.common.javabean.models.d> O;
    private ArrayList<VideoDetailBean> P;
    private r Q;
    private com.zte.iptvclient.android.common.customview.a.a.e.g R;
    private Timer S;
    private int T;
    private long U;
    private boolean V;
    private boolean W;

    /* renamed from: a, reason: collision with root package name */
    private com.zte.iptvclient.android.common.player.f f7341a;
    Thread a0;

    /* renamed from: b, reason: collision with root package name */
    private boolean f7342b;
    private Handler b0;

    /* renamed from: c, reason: collision with root package name */
    private Context f7343c;
    private Handler c0;

    /* renamed from: d, reason: collision with root package name */
    private com.zte.iptvclient.android.common.j.h f7344d;
    private com.zte.iptvclient.android.mobile.u.a.a e;
    private Button f;
    private Button g;
    private Button h;
    private Button i;
    private Button j;
    private Button k;
    private Button l;
    private Button m;
    private Button n;
    private TextView o;
    private TextView p;
    private ImageView q;
    private RelativeLayout r;
    private ImageView s;
    private Button t;
    private Button u;
    private Button v;
    private Button w;
    private RelativeLayout x;
    private View y;
    private View z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemoteDirectionLayout.java */
    /* renamed from: com.zte.iptvclient.android.mobile.u.b.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0360a implements SDKVodMgr.OnVodDetailWithUrlReturnListener {
        C0360a() {
        }

        @Override // com.video.androidsdk.service.vod.SDKVodMgr.OnVodDetailWithUrlReturnListener
        public void onVodDetailWithUrlReturn(String str, String str2, String str3) {
            LogEx.d("RemoteDirectionLayout", "returncode : " + str + ", errormsg : " + str2 + ",data : " + str3);
            if (TextUtils.equals(str, "0")) {
                try {
                    if (str3.contains("},]}")) {
                        str3 = str3.replace("},]}", "}]}");
                    }
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    HashMap<String, String> hashMap = new HashMap<>();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        VideoDetailBean videoDetailBeanFromJSon = VideoDetailBean.getVideoDetailBeanFromJSon(jSONObject);
                        if (videoDetailBeanFromJSon != null) {
                            hashMap.put(videoDetailBeanFromJSon.getDefinition(), videoDetailBeanFromJSon.getPlayurl());
                            videoDetailBeanFromJSon.setProductVIP("0");
                            videoDetailBeanFromJSon.setDownloadURL(hashMap);
                            if (jSONObject.has("productlist")) {
                                JSONArray jSONArray2 = jSONObject.getJSONArray("productlist");
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= jSONArray2.length()) {
                                        break;
                                    }
                                    String optString = jSONArray2.getJSONObject(i2).optString("productname");
                                    if (optString != null && optString.contains("VIP")) {
                                        videoDetailBeanFromJSon.setProductVIP("1");
                                        break;
                                    }
                                    i2++;
                                }
                            }
                            a.this.P.add(videoDetailBeanFromJSon);
                        }
                    }
                    a.this.a();
                    a.this.a(((VideoDetailBean) a.this.P.get(0)).getPlayurl(), a.this.a(a.this.Q.f7371b) + "", a.this.Q.f7372c);
                } catch (Exception e) {
                    LogEx.e("RemoteDirectionLayout", e.getMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemoteDirectionLayout.java */
    /* loaded from: classes2.dex */
    public class b implements f.c {
        b() {
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
        public void a() {
        }

        @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
        public void b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemoteDirectionLayout.java */
    /* loaded from: classes2.dex */
    public class c extends TimerTask {
        c() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Message message = new Message();
            message.what = 1;
            a.this.b0.sendMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemoteDirectionLayout.java */
    /* loaded from: classes2.dex */
    public class d extends Handler {
        d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                a.b(a.this);
                if (a.this.T >= 20) {
                    a.this.a();
                }
            }
            if (message.what == 2) {
                a.this.b(R.string.custom_play);
            }
            if (message.what == 3) {
                a.this.b(R.string.custom_suspend);
            }
            if (message.what == 4) {
                a.this.b(R.string.custom_copyright);
            }
        }
    }

    /* compiled from: RemoteDirectionLayout.java */
    /* loaded from: classes2.dex */
    class e extends Handler {
        e() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                Bundle bundle = new Bundle();
                a.this.f7341a = new com.zte.iptvclient.android.common.player.f();
                bundle.putString(ParamConst.UPDATE_VERSION_RSP_URL, message.getData().getString("url"));
                bundle.putString("auth_contenttype", String.valueOf(ContentType.TYPE_CONTENT_TVOD.getIntValue()));
                bundle.putBoolean("isProjection", true);
                com.zte.iptvclient.android.common.player.j.l lVar = new com.zte.iptvclient.android.common.player.j.l();
                a.this.f7341a.a(false);
                a.this.f7341a.b(false);
                a.this.f7341a.a(lVar, bundle, a.this.f7343c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemoteDirectionLayout.java */
    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.s.getVisibility() == 0) {
                a.this.M = false;
                a.this.s.setVisibility(4);
                a.this.r.setVisibility(0);
                a.this.D.setImageResource(R.drawable.remote_btn_direction_pressed);
                return;
            }
            a.this.M = true;
            a.this.s.setVisibility(0);
            a.this.r.setVisibility(4);
            a.this.D.setImageResource(R.drawable.remote_btn_direction_norl_night);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemoteDirectionLayout.java */
    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.e.J()) {
                a.this.e.M();
            } else if (com.zte.iptvclient.android.mobile.h.a.a.g().b() == null) {
                a.this.e.N();
            } else {
                a.this.h();
                a.this.d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemoteDirectionLayout.java */
    /* loaded from: classes2.dex */
    public class h implements a.r {
        h() {
        }

        @Override // com.zte.iptvclient.android.mobile.h.a.a.r
        public void a(String str, String str2, String str3) {
            LogEx.d("RemoteDirectionLayout", "queryTransportInfo: returncode=" + str);
            LogEx.d("RemoteDirectionLayout", "queryTransportInfo: currentTransportState=" + str2);
            LogEx.d("RemoteDirectionLayout", "queryTransportInfo: currentTransportStatus=" + str3);
            a.this.f7344d.J();
            if (!TextUtils.equals("", "") && !"".equals(com.zte.iptvclient.common.uiframe.a.c("BSTV_CP_Code"))) {
                if (str.equals("0") && !str2.equals("NO_MEDIA_PRESENT") && !str3.equals("ERROR_OCCURRED")) {
                    a.this.g();
                    return;
                } else {
                    a.this.a();
                    return;
                }
            }
            if (str.equals("0") && !str2.equals("NO_MEDIA_PRESENT") && str3.equals("OK")) {
                LogEx.d("RemoteDirectionLayout", "queryTransportInfo: STB state is OK!");
                a.this.Q = new r(null);
                a.this.g();
                return;
            }
            a.this.a();
            Message message = new Message();
            message.what = 2;
            a.this.b0.sendMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemoteDirectionLayout.java */
    /* loaded from: classes2.dex */
    public class i implements a.q {
        i() {
        }

        @Override // com.zte.iptvclient.android.mobile.h.a.a.q
        public void a(BackplayPositionInfoBean backplayPositionInfoBean) {
            if (backplayPositionInfoBean == null) {
                LogEx.d("RemoteDirectionLayout", "querySTBPlayPosition bean is null");
                a.this.a();
                Message message = new Message();
                message.what = 3;
                a.this.b0.sendMessage(message);
                return;
            }
            LogEx.d("RemoteDirectionLayout", "Bean:" + backplayPositionInfoBean.toString());
            a.this.Q.f7370a = backplayPositionInfoBean.getPushtype();
            a.this.Q.f7371b = backplayPositionInfoBean.getRelTime();
            if (backplayPositionInfoBean.getUrlfromstb() != null && backplayPositionInfoBean.getUrlfromstb().contains("rtsp")) {
                a.this.Q.f7371b = backplayPositionInfoBean.getRelTime();
                StringBuilder sb = new StringBuilder();
                sb.append("pushtype=");
                sb.append(backplayPositionInfoBean.getPushtype());
                sb.append("&telecomcode=");
                sb.append(backplayPositionInfoBean.getTelecomcode());
                sb.append("&begintime=");
                sb.append(TextUtils.isEmpty(backplayPositionInfoBean.getBegintime()) ? "" : a.this.e(backplayPositionInfoBean.getBegintime()));
                sb.append("&endtime=");
                sb.append(TextUtils.isEmpty(backplayPositionInfoBean.getEndtime()) ? "" : a.this.e(backplayPositionInfoBean.getEndtime()));
                if ("0".equals(backplayPositionInfoBean.getPushtype())) {
                    sb.append("&mixno=");
                    sb.append(backplayPositionInfoBean.getMixno());
                }
                String sb2 = sb.toString();
                LogEx.d("RemoteDirectionLayout", "playUrlFromSTB=" + sb2);
                a.this.b(sb2);
                return;
            }
            String urlfromstb = backplayPositionInfoBean.getUrlfromstb();
            String pushtype = backplayPositionInfoBean.getPushtype();
            if ("0".equals(pushtype)) {
                a.this.c(backplayPositionInfoBean.getChannelcode());
                return;
            }
            if (DownloadConstant.REPORT_MSGTYPE_ADD.equals(pushtype)) {
                Message message2 = new Message();
                message2.what = 1;
                Bundle bundle = new Bundle();
                bundle.putString("url", urlfromstb);
                message2.setData(bundle);
                a.this.c0.sendMessage(message2);
                return;
            }
            a.this.a();
            a.this.d(urlfromstb.substring(urlfromstb.indexOf("&programid=") + 11, urlfromstb.lastIndexOf("&boid")));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemoteDirectionLayout.java */
    /* loaded from: classes2.dex */
    public class j implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        j() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("RemoteDirectionLayout", "queryBackPlayInfoFromFrame return data= " + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (TextUtils.equals(jSONObject.optString("returncode"), "0")) {
                    if (!"0".equals(a.this.Q.f7370a)) {
                        if (DownloadConstant.REPORT_MSGTYPE_ADD.equals(a.this.Q.f7370a)) {
                            if (a.this.N != null) {
                                a.this.N.clear();
                            }
                            a.this.a(com.zte.iptvclient.android.common.javabean.models.d.a(jSONObject).l(), false);
                            return;
                        }
                        a.this.Q.f7372c = jSONObject.optString("programname");
                        a.this.d(jSONObject.optString("programcode"));
                        return;
                    }
                    a.this.c(jSONObject.optString("channelcode"));
                    return;
                }
                a.this.a();
                Message message = new Message();
                message.what = 4;
                a.this.b0.sendMessage(message);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("RemoteDirectionLayout", "sdkQueryOttDetail failed, errorCode=" + i + ", errorMsg=" + str);
            a.this.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemoteDirectionLayout.java */
    /* loaded from: classes2.dex */
    public class k implements SDKChannelMgr.OnChannelDetailWithUrlReturnListener {
        k() {
        }

        @Override // com.video.androidsdk.service.channel.SDKChannelMgr.OnChannelDetailWithUrlReturnListener
        public void onChannelDetailWithUrlReturn(String str, String str2, String str3) {
            LogEx.d("RemoteDirectionLayout", "returnCode:" + str);
            LogEx.d("RemoteDirectionLayout", "msg:" + str3);
            if ("0".equals(str)) {
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        a.this.N.add(com.zte.iptvclient.android.common.javabean.models.c.a(jSONArray.getJSONObject(i)));
                    }
                    a.this.a();
                    a.this.i();
                } catch (Exception e) {
                    LogEx.e("RemoteDirectionLayout", e.getMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemoteDirectionLayout.java */
    /* loaded from: classes2.dex */
    public class l implements SDKPrevueMgr.OnPrevueDetailWithUrlReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f7356a;

        l(boolean z) {
            this.f7356a = z;
        }

        @Override // com.video.androidsdk.service.prevue.SDKPrevueMgr.OnPrevueDetailWithUrlReturnListener
        public void onPrevueDetailWithUrlReturn(String str, String str2, String str3) {
            LogEx.d("RemoteDirectionLayout", "sdkQueryTvodById:  onDataReturn,arg0= " + str3);
            if (TextUtils.equals(str, "0")) {
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        a.this.O.add(com.zte.iptvclient.android.common.javabean.models.d.a(jSONArray.getJSONObject(i)));
                    }
                    a.this.a();
                    a.this.a(this.f7356a);
                } catch (Exception e) {
                    e.printStackTrace();
                    LogEx.e("RemoteDirectionLayout", e.getMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemoteDirectionLayout.java */
    /* loaded from: classes2.dex */
    public class m implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        private int f7358a;

        m() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!(view instanceof ImageView)) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    LogEx.d("RemoteDirectionLayout", "ACTION_UP");
                    a.this.s.setImageResource(R.drawable.remote_btn_ok_normal);
                    if (this.f7358a == 4100) {
                        LogEx.w("RemoteDirectionLayout", "中心确定按键");
                        if (a.this.e.J()) {
                            a.this.e.M();
                            return true;
                        }
                        if (com.zte.iptvclient.android.mobile.h.a.a.g().b() == null) {
                            a.this.e.N();
                            return true;
                        }
                        LogEx.i("RemoteDirectionLayout", "sendKeycode");
                        com.zte.iptvclient.android.mobile.h.a.a.g().a(this.f7358a);
                    }
                    a aVar = a.this;
                    aVar.a0 = null;
                    aVar.V = true;
                    a.this.W = false;
                    return true;
                }
                if (action != 2) {
                    if (action != 3) {
                        return true;
                    }
                    LogEx.d("RemoteDirectionLayout", "Action_CANCEL");
                    a.this.s.setImageResource(R.drawable.remote_btn_ok_normal);
                    return true;
                }
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int width = view.getWidth() / 2;
            double d2 = width * 2;
            float f = width;
            if (Math.pow(x - f, 2.0d) + Math.pow(y - f, 2.0d) < Math.pow(width / 3, 2.0d)) {
                a.this.s.setImageResource(R.drawable.remote_btn_ok_press);
                this.f7358a = 4100;
                return true;
            }
            if (y < x) {
                double d3 = y;
                double d4 = -x;
                Double.isNaN(d4);
                Double.isNaN(d2);
                if (d3 > d4 + d2) {
                    a.this.s.setImageResource(R.drawable.remote_btn_right_press);
                    this.f7358a = 4097;
                    LogEx.i("RemoteDirectionLayout", "sendKeycode");
                    a.this.a(this.f7358a);
                    return true;
                }
            }
            if (y > x) {
                double d5 = y;
                double d6 = -x;
                Double.isNaN(d6);
                Double.isNaN(d2);
                if (d5 > d6 + d2) {
                    a.this.s.setImageResource(R.drawable.remote_btn_down_press);
                    this.f7358a = 4099;
                    LogEx.i("RemoteDirectionLayout", "sendKeycode");
                    a.this.a(this.f7358a);
                    return true;
                }
            }
            if (y > x) {
                double d7 = y;
                double d8 = -x;
                Double.isNaN(d8);
                Double.isNaN(d2);
                if (d7 < d8 + d2) {
                    a.this.s.setImageResource(R.drawable.remote_btn_left_press);
                    this.f7358a = 4096;
                    LogEx.i("RemoteDirectionLayout", "sendKeycode");
                    a.this.a(this.f7358a);
                    return true;
                }
            }
            if (y >= x) {
                return true;
            }
            double d9 = y;
            double d10 = -x;
            Double.isNaN(d10);
            Double.isNaN(d2);
            if (d9 >= d10 + d2) {
                return true;
            }
            a.this.s.setImageResource(R.drawable.remote_btn_up_press);
            this.f7358a = 4098;
            LogEx.i("RemoteDirectionLayout", "sendKeycode");
            a.this.a(this.f7358a);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RemoteDirectionLayout.java */
    /* loaded from: classes2.dex */
    public class n implements View.OnLongClickListener {
        private n() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            LogEx.d("RemoteDirectionLayout", "gesture long click");
            a.this.f7342b = true;
            if (a.this.e.J()) {
                a.this.e.M();
                return true;
            }
            if (com.zte.iptvclient.android.mobile.h.a.a.g().b() == null) {
                a.this.e.N();
                return true;
            }
            LogEx.i("RemoteDirectionLayout", "sendKeycode");
            com.zte.iptvclient.android.mobile.h.a.a.g().a(4100);
            return true;
        }

        /* synthetic */ n(a aVar, d dVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RemoteDirectionLayout.java */
    /* loaded from: classes2.dex */
    public class o implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        private int f7361a;

        /* renamed from: b, reason: collision with root package name */
        private float f7362b;

        /* renamed from: c, reason: collision with root package name */
        private float f7363c;

        o() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            a.this.getParent().requestDisallowInterceptTouchEvent(true);
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f7362b = motionEvent.getX();
                this.f7363c = motionEvent.getY();
            } else if (action == 1) {
                float x = motionEvent.getX() - this.f7362b;
                float y = motionEvent.getY() - this.f7363c;
                if (a.this.f7342b) {
                    a.this.f7342b = false;
                    return true;
                }
                LogEx.d("RemoteDirectionLayout", "gesture up");
                if (a.this.e.J()) {
                    a.this.e.M();
                    return true;
                }
                if (com.zte.iptvclient.android.mobile.h.a.a.g().b() == null) {
                    a.this.e.N();
                    return true;
                }
                if (Math.abs(x) > 80.0f || Math.abs(y) > 80.0f) {
                    if (Math.abs(x) > Math.abs(y)) {
                        if (x > 0.0f) {
                            this.f7361a = 4097;
                            LogEx.d("RemoteDirectionLayout", " right ");
                        } else {
                            this.f7361a = 4096;
                            LogEx.d("RemoteDirectionLayout", " left ");
                        }
                    } else if (y > 0.0f) {
                        this.f7361a = 4099;
                        LogEx.d("RemoteDirectionLayout", " down ");
                    } else {
                        this.f7361a = 4098;
                        LogEx.d("RemoteDirectionLayout", " up ");
                    }
                    LogEx.d("RemoteDirectionLayout", "distenceX = " + x + "   distenceY = " + y);
                    StringBuilder sb = new StringBuilder();
                    sb.append("currentvalue = ");
                    sb.append(this.f7361a);
                    LogEx.d("RemoteDirectionLayout", sb.toString());
                    LogEx.i("RemoteDirectionLayout", "sendKeycode");
                    com.zte.iptvclient.android.mobile.h.a.a.g().a(this.f7361a);
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RemoteDirectionLayout.java */
    /* loaded from: classes2.dex */
    public class p implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        private int f7365a;

        /* compiled from: RemoteDirectionLayout.java */
        /* renamed from: com.zte.iptvclient.android.mobile.u.b.b.a$p$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0361a implements f.c {
            C0361a() {
            }

            @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
            public void a() {
                LogEx.i("RemoteDirectionLayout", "sendKeycode");
                com.zte.iptvclient.android.mobile.h.a.a.g().a(p.this.f7365a);
            }

            @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
            public void b() {
            }
        }

        public p(int i) {
            this.f7365a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.e.J()) {
                a.this.e.M();
                return;
            }
            if (com.zte.iptvclient.android.mobile.h.a.a.g().b() == null) {
                a.this.e.N();
                return;
            }
            if (this.f7365a == 4128) {
                com.zte.iptvclient.android.common.customview.a.a.e.f fVar = new com.zte.iptvclient.android.common.customview.a.a.e.f(a.this.f7343c, R.drawable.remote_stb_dialog_img, R.string.confirm_shut_down_stb, R.drawable.lock_dialog_rightbg, R.string.confirm, 0, R.drawable.lock_dialog_leftbg, R.string.common_cancel, 0, new C0361a());
                fVar.a();
                fVar.setCanceledOnTouchOutside(false);
            } else {
                LogEx.i("RemoteDirectionLayout", "sendKeycode");
                com.zte.iptvclient.android.mobile.h.a.a.g().a(this.f7365a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RemoteDirectionLayout.java */
    /* loaded from: classes2.dex */
    public class q implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        private int f7368a;

        private q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f()) {
                return;
            }
            if (com.zte.iptvclient.android.mobile.h.a.a.g().b() == null) {
                a.this.e.N();
            } else {
                LogEx.i("RemoteDirectionLayout", "sendKeycode");
                com.zte.iptvclient.android.mobile.h.a.a.g().a(this.f7368a);
            }
        }

        /* synthetic */ q(a aVar, d dVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RemoteDirectionLayout.java */
    /* loaded from: classes2.dex */
    public static class r {

        /* renamed from: a, reason: collision with root package name */
        String f7370a;

        /* renamed from: b, reason: collision with root package name */
        String f7371b;

        /* renamed from: c, reason: collision with root package name */
        String f7372c;

        private r() {
        }

        /* synthetic */ r(d dVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RemoteDirectionLayout.java */
    /* loaded from: classes2.dex */
    public class s implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        private int f7373a;

        public s(int i) {
            this.f7373a = i;
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x000b, code lost:
        
            if (r3 != 2) goto L11;
         */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onTouch(android.view.View r3, android.view.MotionEvent r4) {
            /*
                r2 = this;
                int r3 = r4.getAction()
                r4 = 0
                if (r3 == 0) goto L1c
                r0 = 1
                if (r3 == r0) goto Le
                r0 = 2
                if (r3 == r0) goto L1c
                goto L2a
            Le:
                com.zte.iptvclient.android.mobile.u.b.b.a r3 = com.zte.iptvclient.android.mobile.u.b.b.a.this
                r1 = 0
                r3.a0 = r1
                com.zte.iptvclient.android.mobile.u.b.b.a.c(r3, r0)
                com.zte.iptvclient.android.mobile.u.b.b.a r3 = com.zte.iptvclient.android.mobile.u.b.b.a.this
                com.zte.iptvclient.android.mobile.u.b.b.a.d(r3, r4)
                goto L2a
            L1c:
                java.lang.String r3 = "RemoteDirectionLayout"
                java.lang.String r0 = "sendKeycode"
                com.video.androidsdk.log.LogEx.i(r3, r0)
                com.zte.iptvclient.android.mobile.u.b.b.a r3 = com.zte.iptvclient.android.mobile.u.b.b.a.this
                int r0 = r2.f7373a
                com.zte.iptvclient.android.mobile.u.b.b.a.b(r3, r0)
            L2a:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.mobile.u.b.b.a.s.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    public a(Context context, com.zte.iptvclient.android.mobile.u.a.a aVar) {
        super(context);
        this.f7341a = null;
        this.f7342b = false;
        this.M = true;
        this.N = new ArrayList<>();
        this.O = new ArrayList<>();
        this.P = new ArrayList<>();
        this.S = null;
        this.T = 0;
        this.U = 0L;
        this.b0 = new d();
        this.c0 = new e();
        this.f7343c = context;
        a(context);
        this.e = aVar;
    }

    static /* synthetic */ int b(a aVar) {
        int i2 = aVar.T;
        aVar.T = i2 + 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.U <= 500) {
            LogEx.w("UseeTv", "Operate limit,less than 500(ms)!");
            return true;
        }
        this.U = currentTimeMillis;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.zte.iptvclient.android.mobile.h.a.a.g().a(new i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        com.zte.iptvclient.android.mobile.h.a.a.g().a(new h());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        com.zte.iptvclient.android.common.javabean.models.c cVar = this.N.get(0);
        Bundle bundle = new Bundle();
        this.f7341a = new com.zte.iptvclient.android.common.player.f();
        com.zte.iptvclient.android.mobile.download.helper.a.n().a((Boolean) true);
        Iterator<com.zte.iptvclient.android.common.javabean.models.c> it2 = this.N.iterator();
        while (it2.hasNext()) {
            com.zte.iptvclient.android.common.javabean.models.c next = it2.next();
            String j2 = next.j();
            if (TextUtils.equals(next.g(), "1")) {
                if (TextUtils.isEmpty(j2)) {
                    j2 = "";
                }
                bundle.putString("url_sd", j2);
            } else if (TextUtils.equals(next.g(), "2")) {
                if (TextUtils.isEmpty(j2)) {
                    j2 = "";
                }
                bundle.putString("url_sd_h", j2);
            } else if (TextUtils.equals(next.g(), "4")) {
                if (TextUtils.isEmpty(j2)) {
                    j2 = "";
                }
                bundle.putString("url_hd", j2);
            } else if (TextUtils.equals(next.g(), "8")) {
                if (TextUtils.isEmpty(j2)) {
                    j2 = "";
                }
                bundle.putString("url_480p", j2);
            } else if (TextUtils.equals(next.g(), GlobalConst.WINPHONE_CLIENT)) {
                if (TextUtils.isEmpty(j2)) {
                    j2 = "";
                }
                bundle.putString("url_720p", j2);
            } else if (TextUtils.equals(next.g(), GlobalConst.ANDRIODSTB_CLIENT)) {
                if (TextUtils.isEmpty(j2)) {
                    j2 = "";
                }
                bundle.putString("url_1280p", j2);
            } else {
                bundle.putString("url_sd", "");
            }
        }
        bundle.putString("tv_name", cVar.e());
        bundle.putString("programname", cVar.l());
        bundle.putString("isprotection", cVar.h());
        bundle.putString("supportTimeShift", cVar.q());
        bundle.putString(ParamConst.CHANNEL_INFO_RSP_TSAVAILABLE, cVar.r());
        bundle.putString("playuri4dlna", com.zte.iptvclient.android.mobile.h.a.b.b(cVar.i(), cVar.p(), cVar.d(), cVar.f()));
        bundle.putString("telecomcode", cVar.p());
        bundle.putString("poster_image", cVar.k());
        bundle.putInt(ParamConst.TV_CHANNEL_SHIFT_PLAY_REQ_AUTHID, TextUtils.isEmpty(cVar.c()) ? -1 : Integer.valueOf(cVar.c()).intValue());
        bundle.putString("contentcode", cVar.d());
        bundle.putString("ratingid", cVar.n());
        bundle.putString(ParamConst.UPDATE_VERSION_RSP_URL, cVar.j());
        bundle.putBoolean("Is_Dash_URL", com.zte.iptvclient.android.common.k.i.c());
        bundle.putString("auth_contenttype", String.valueOf(ContentType.TYPE_CONTENT_TV.getIntValue()));
        bundle.putBoolean("IsUesMutliWindowToPlay", false);
        bundle.putBoolean("isProjection", true);
        com.zte.iptvclient.android.common.player.j.i iVar = new com.zte.iptvclient.android.common.player.j.i();
        iVar.b(cVar.d());
        iVar.a(cVar.f());
        this.f7341a.a(iVar, bundle, this.f7343c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        this.P.clear();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("programcode", str);
        hashMap.put("recommendtype", "0");
        new SDKVodMgr().getVodDetailWithUrl(hashMap, new C0360a());
    }

    private void e() {
        this.f.setOnClickListener(new p(4128));
        this.g.setOnClickListener(new p(4118));
        this.h.setOnClickListener(new p(4108));
        this.i.setOnClickListener(new p(4101));
        this.j.setOnClickListener(new p(4105));
        this.k.setOnClickListener(new p(4124));
        this.m.setOnClickListener(new p(4103));
        this.t.setOnClickListener(new p(4120));
        this.u.setOnClickListener(new p(4121));
        this.v.setOnClickListener(new p(4122));
        this.w.setOnClickListener(new p(4123));
        this.l.setOnTouchListener(new s(4106));
        this.n.setOnTouchListener(new s(4107));
        this.r.setOnTouchListener(new o());
        d dVar = null;
        this.r.setOnLongClickListener(new n(this, dVar));
        this.s.setOnTouchListener(new m());
        this.y.setOnClickListener(new q(this, dVar));
        this.z.setOnClickListener(new q(this, dVar));
        this.A.setOnClickListener(new q(this, dVar));
        this.B.setOnClickListener(new q(this, dVar));
        this.C.setOnClickListener(new q(this, dVar));
        this.D.setOnClickListener(new f());
        this.L.setOnClickListener(new g());
    }

    public void c() {
        this.f.setBackgroundResource(R.drawable.remote_btn_power_bg);
        this.L.setImageResource(R.drawable.remote_mobile_back);
        this.h.setBackgroundResource(R.drawable.remote_btn_mute_bg);
        this.i.setBackgroundResource(R.drawable.remote_btn_back_bg);
        this.j.setBackgroundResource(R.drawable.remote_btn_menu_bg);
        this.k.setBackgroundResource(R.drawable.remote_btn_home_bg);
        this.l.setBackgroundResource(R.drawable.remote_btn_volup_bg);
        this.m.setBackgroundResource(R.drawable.remote_btn_playpause_bg);
        this.n.setBackgroundResource(R.drawable.remote_btn_voldown_bg);
        this.s.setImageResource(R.drawable.remote_btn_ok_normal);
        this.D.setImageResource(R.drawable.remote_btn_direction_norl_night);
        this.o.setTextColor(getResources().getColor(R.color.remote_hinttext_textcolor));
        this.p.setTextColor(getResources().getColor(R.color.remote_hinttext_textcolor));
        this.q.setBackgroundResource(R.drawable.remote_hand);
        if (this.M) {
            return;
        }
        this.J.setBackgroundResource(R.drawable.remote_arrow_up);
        this.K.setBackgroundResource(R.drawable.remote_arrow_down);
        this.F.setBackgroundResource(R.drawable.remote_arrow_left);
        this.G.setBackgroundResource(R.drawable.remote_arrow_right);
    }

    public void b() {
        this.f.setBackgroundResource(R.drawable.remote_btn_power_bg_night);
        this.h.setBackgroundResource(R.drawable.remote_btn_mute_bg_night);
        this.i.setBackgroundResource(R.drawable.remote_btn_back_bg_night);
        this.j.setBackgroundResource(R.drawable.remote_btn_menu_bg_night);
        this.k.setBackgroundResource(R.drawable.remote_btn_home_bg_night);
        this.l.setBackgroundResource(R.drawable.remote_btn_volup_bg_night);
        this.m.setBackgroundResource(R.drawable.remote_btn_playpause_bg_night);
        this.n.setBackgroundResource(R.drawable.remote_btn_voldown_bg_night);
        this.s.setImageResource(R.drawable.remote_btn_ok_normal_night);
        if (!this.M) {
            this.J.setBackgroundResource(R.drawable.remote_arrow_up_night);
            this.K.setBackgroundResource(R.drawable.remote_arrow_down_night);
            this.F.setBackgroundResource(R.drawable.remote_arrow_left_night);
            this.G.setBackgroundResource(R.drawable.remote_arrow_right_night);
        }
        this.L.setImageResource(R.drawable.remote_mobile_night_sel);
        this.D.setImageResource(R.drawable.remote_btn_direction_norl_night);
        this.o.setTextColor(-1);
        this.p.setTextColor(-1);
        this.q.setBackgroundResource(R.drawable.remote_hand_night);
        this.r.setBackgroundColor(Color.argb(33, 85, 90, 92));
    }

    private void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.remote_direction_fragment, this);
        inflate.setLayoutDirection(0);
        this.f7344d = new com.zte.iptvclient.android.common.j.h(this.f7343c);
        a(inflate);
        e();
        if ("1".equals(ConfigMgr.readPropertie("IsShowRemoteGesture"))) {
            this.r.setVisibility(0);
            this.x.setVisibility(8);
        }
    }

    public void d() {
        if (this.R == null) {
            com.zte.iptvclient.android.common.customview.a.a.e.g gVar = new com.zte.iptvclient.android.common.customview.a.a.e.g(this.f7343c);
            this.R = gVar;
            gVar.show();
            this.T = 0;
            if (this.S == null) {
                this.S = new Timer();
            }
            c cVar = new c();
            Timer timer = this.S;
            if (timer != null) {
                timer.schedule(cVar, 1000L, 1000L);
            }
        }
    }

    private void a(View view) {
        this.f = (Button) view.findViewById(R.id.btn_power_off);
        this.g = (Button) view.findViewById(R.id.btn_playback);
        this.h = (Button) view.findViewById(R.id.btn_mute);
        this.i = (Button) view.findViewById(R.id.btn_back);
        this.j = (Button) view.findViewById(R.id.btn_menu);
        this.k = (Button) view.findViewById(R.id.btn_home);
        this.l = (Button) view.findViewById(R.id.btn_volup);
        this.m = (Button) view.findViewById(R.id.btn_playpause);
        this.n = (Button) view.findViewById(R.id.btn_voldown);
        this.s = (ImageView) view.findViewById(R.id.img_remote);
        this.r = (RelativeLayout) view.findViewById(R.id.rl_gesture);
        this.x = (RelativeLayout) view.findViewById(R.id.rl_remote_key);
        this.y = view.findViewById(R.id.btn_key_ok);
        this.z = view.findViewById(R.id.btn_key_up);
        this.A = view.findViewById(R.id.btn_key_down);
        this.B = view.findViewById(R.id.btn_key_left);
        this.C = view.findViewById(R.id.btn_key_right);
        this.D = (ImageView) view.findViewById(R.id.img_remote_change_mode);
        this.E = (RelativeLayout) view.findViewById(R.id.rl_remote_change_mode);
        this.L = (ImageView) view.findViewById(R.id.txt_return);
        this.o = (TextView) view.findViewById(R.id.tv_remote1);
        this.p = (TextView) view.findViewById(R.id.tv_remote2);
        this.q = (ImageView) view.findViewById(R.id.img_hand);
        this.J = (ImageView) view.findViewById(R.id.img_gester_up);
        this.K = (ImageView) view.findViewById(R.id.img_gester_down);
        this.F = (ImageView) view.findViewById(R.id.img_gester_left);
        this.G = (ImageView) view.findViewById(R.id.img_gester_right);
        this.t = (Button) view.findViewById(R.id.txt_f1);
        this.u = (Button) view.findViewById(R.id.txt_f2);
        this.v = (Button) view.findViewById(R.id.txt_f3);
        this.w = (Button) view.findViewById(R.id.txt_f4);
        com.zte.iptvclient.common.uiframe.f.b(this.L);
        com.zte.iptvclient.common.uiframe.f.b(this.f);
        com.zte.iptvclient.common.uiframe.f.b(this.g);
        com.zte.iptvclient.common.uiframe.f.b(this.h);
        com.zte.iptvclient.common.uiframe.f.b(this.i);
        com.zte.iptvclient.common.uiframe.f.b(this.j);
        com.zte.iptvclient.common.uiframe.f.b(this.k);
        com.zte.iptvclient.common.uiframe.f.b(this.l);
        com.zte.iptvclient.common.uiframe.f.b(this.m);
        com.zte.iptvclient.common.uiframe.f.b(this.n);
        com.zte.iptvclient.common.uiframe.f.b(this.s);
        com.zte.iptvclient.common.uiframe.f.b(this.D);
        com.zte.iptvclient.common.uiframe.f.b(this.E);
        com.zte.iptvclient.common.uiframe.f.b(view.findViewById(R.id.btn_title_fnume));
        com.zte.iptvclient.common.uiframe.f.b(this.t);
        com.zte.iptvclient.common.uiframe.f.b(this.u);
        com.zte.iptvclient.common.uiframe.f.b(this.v);
        com.zte.iptvclient.common.uiframe.f.b(this.w);
        com.zte.iptvclient.common.uiframe.f.b(this.r);
        com.zte.iptvclient.common.uiframe.f.b(view.findViewById(R.id.img_gester_up));
        com.zte.iptvclient.common.uiframe.f.b(view.findViewById(R.id.img_gester_down));
        com.zte.iptvclient.common.uiframe.f.b(view.findViewById(R.id.img_gester_left));
        com.zte.iptvclient.common.uiframe.f.b(view.findViewById(R.id.img_gester_right));
        com.zte.iptvclient.common.uiframe.f.b(view.findViewById(R.id.ll_guide));
        com.zte.iptvclient.common.uiframe.f.b(view.findViewById(R.id.tv_remote1));
        com.zte.iptvclient.common.uiframe.f.b(view.findViewById(R.id.tv_remote2));
        com.zte.iptvclient.common.uiframe.f.b(view.findViewById(R.id.img_hand));
        com.zte.iptvclient.common.uiframe.f.b(this.x);
        com.zte.iptvclient.common.uiframe.f.b(this.y);
        com.zte.iptvclient.common.uiframe.f.b(this.z);
        com.zte.iptvclient.common.uiframe.f.b(this.A);
        com.zte.iptvclient.common.uiframe.f.b(this.B);
        com.zte.iptvclient.common.uiframe.f.b(this.C);
        if (TextUtils.equals("1", ConfigMgr.readPropertie("isAt"))) {
            this.L.setVisibility(8);
        }
        this.o.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.remote_slide_move_focus));
        this.p.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.remote_long_press_select));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        ArrayList<com.zte.iptvclient.android.common.javabean.models.c> arrayList = this.N;
        if (arrayList != null) {
            arrayList.clear();
        }
        SDKChannelMgr sDKChannelMgr = new SDKChannelMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("channelcode", str);
        sDKChannelMgr.getChannelDetailWithURl(hashMap, new k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        String str2 = "http://{epgdomain}:{port}/iptvepg/{frame}/getbackplay.jsp".replace("http://{epgdomain}:{port}/iptvepg/{frame}/", com.zte.iptvclient.android.common.f.b.i.f()) + "?" + str;
        LogEx.d("RemoteDirectionLayout", "sdkQueryGetPlayBackJSP totalUrl = " + str2);
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setHeader("Cookie", com.zte.iptvclient.android.common.f.b.i.h());
        sDKNetHTTPRequest.startRequest(str2, "GET", new j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e(String str) {
        return x.c(str, "yyyyMMddHHmmss", "yyyy.MM.dd HH:mm:ss", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        com.zte.iptvclient.android.common.customview.a.a.e.f fVar = new com.zte.iptvclient.android.common.customview.a.a.e.f(this.f7343c, R.drawable.custom_dialog_title_img, i2, R.drawable.custom_dialog_button_blue, R.string.common_ok, 0, 0, 0, 0, new b());
        fVar.a();
        fVar.setCanceledOnTouchOutside(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        this.f7341a = new com.zte.iptvclient.android.common.player.f();
        bundle.putString(ParamConst.UPDATE_VERSION_RSP_URL, str);
        bundle.putString("auth_contenttype", String.valueOf(ContentType.TYPE_CONTENT_NORMAL_VOD.getIntValue()));
        bundle.putString("bookmark_breakpoint", str2);
        bundle.putBoolean("isProjection", true);
        bundle.putString("programname", str3);
        if (this.P.size() > 0) {
            VideoDetailBean videoDetailBean = this.P.get(0);
            if (TextUtils.equals(videoDetailBean.getDefinition(), "1")) {
                bundle.putString("url_sd", str);
            } else if (TextUtils.equals(videoDetailBean.getDefinition(), "2")) {
                bundle.putString("url_sd_h", str);
            } else if (TextUtils.equals(videoDetailBean.getDefinition(), "4")) {
                bundle.putString("url_hd", str);
            } else if (TextUtils.equals(videoDetailBean.getDefinition(), "8")) {
                bundle.putString("url_480p", str);
            } else if (TextUtils.equals(videoDetailBean.getDefinition(), GlobalConst.WINPHONE_CLIENT)) {
                bundle.putString("url_720p", str);
            } else if (TextUtils.equals(videoDetailBean.getDefinition(), GlobalConst.ANDRIODSTB_CLIENT)) {
                bundle.putString("url_1280p", str);
            } else {
                bundle.putString("url_sd", str);
            }
        }
        com.zte.iptvclient.android.common.player.j.l lVar = new com.zte.iptvclient.android.common.player.j.l();
        this.f7341a.a(false);
        this.f7341a.b(false);
        this.f7341a.a(lVar, bundle, this.f7343c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z) {
        ArrayList<com.zte.iptvclient.android.common.javabean.models.c> arrayList = this.N;
        if (arrayList != null && arrayList.size() > 0) {
            this.N.clear();
        }
        SDKPrevueMgr sDKPrevueMgr = new SDKPrevueMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("prevuecode", str);
        hashMap.put("recommendtype", z ? "1" : "0");
        sDKPrevueMgr.getPrevueDetailWithUrl(hashMap, new l(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        ArrayList<com.zte.iptvclient.android.common.javabean.models.d> arrayList = this.O;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        com.zte.iptvclient.android.common.javabean.models.d dVar = this.O.get(0);
        String a2 = dVar.a();
        LogEx.d("RemoteDirectionLayout", "onDataReturn: channelAuthId=" + a2);
        this.f7341a = new com.zte.iptvclient.android.common.player.f();
        Bundle bundle = new Bundle();
        Iterator<com.zte.iptvclient.android.common.javabean.models.d> it2 = this.O.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            com.zte.iptvclient.android.common.javabean.models.d next = it2.next();
            String k2 = next.k();
            if (TextUtils.equals(next.f(), "1")) {
                bundle.putString("url_sd", TextUtils.isEmpty(k2) ? "" : k2);
                bundle.putString("physicalcontentid_url_sd", next.j());
            } else if (TextUtils.equals(next.f(), "2")) {
                bundle.putString("url_sd_h", TextUtils.isEmpty(k2) ? "" : k2);
                bundle.putString("physicalcontentid_url_sd_h", next.j());
            } else if (TextUtils.equals(next.f(), "4")) {
                bundle.putString("url_hd", TextUtils.isEmpty(k2) ? "" : k2);
                bundle.putString("physicalcontentid_url_hd", next.j());
            } else if (TextUtils.equals(next.f(), "8")) {
                bundle.putString("url_480p", TextUtils.isEmpty(k2) ? "" : k2);
                bundle.putString("physicalcontentid_url_480p", next.j());
            } else if (TextUtils.equals(next.f(), GlobalConst.WINPHONE_CLIENT)) {
                bundle.putString("url_720p", TextUtils.isEmpty(k2) ? "" : k2);
                bundle.putString("physicalcontentid_url_720p", next.j());
            } else if (TextUtils.equals(next.f(), GlobalConst.ANDRIODSTB_CLIENT)) {
                bundle.putString("url_1280p", TextUtils.isEmpty(k2) ? "" : k2);
                bundle.putString("physicalcontentid_url_1280p", next.j());
            } else {
                bundle.putString("url_sd", "");
            }
        }
        if (!TextUtils.isEmpty(a2)) {
            bundle.putInt(ParamConst.TV_CHANNEL_SHIFT_PLAY_REQ_AUTHID, Integer.valueOf(a2).intValue());
        } else {
            bundle.putInt(ParamConst.TV_CHANNEL_SHIFT_PLAY_REQ_AUTHID, -1);
        }
        String c2 = dVar.c();
        Channel channel = null;
        ArrayList<Channel> b2 = com.zte.iptvclient.android.common.j.i.d().b();
        int i2 = 0;
        while (true) {
            if (i2 < b2.size()) {
                if (b2.get(i2).getChannelcode().equals(c2) && b2.get(i2).getColumncode().equals(dVar.e())) {
                    channel = b2.get(i2);
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        if (channel == null) {
            return;
        }
        bundle.putString("poster_image", channel.getPosterimage());
        bundle.putString("prevue_name", dVar.m());
        bundle.putString("tv_name", channel.getChannelname() + " " + channel.getMixno());
        bundle.putString("tv_id", dVar.c());
        bundle.putString("supportTimeShift", channel.getSupporttimeshift());
        bundle.putString("isprotection", dVar.h());
        bundle.putString("contentcode", dVar.l());
        bundle.putString("ratingid", dVar.o());
        bundle.putString(ParamConst.UPDATE_VERSION_RSP_URL, dVar.k());
        bundle.putString("recommendtype", z ? "1" : "0");
        String b3 = dVar.b();
        bundle.putString("prevuebegintime", b3);
        String g2 = dVar.g();
        bundle.putString("prevueendtime", g2);
        bundle.putString(ParamConst.NPVR_QUERY_RSP_DURATION, x.c(b3, "yyyy.MM.dd HH:mm:ss", "HH:mm", 1) + "-" + x.c(g2, "yyyy.MM.dd HH:mm:ss", "HH:mm", 1));
        String p2 = dVar.p();
        bundle.putString("playuri4dlna", com.zte.iptvclient.android.mobile.h.a.b.a(dVar.l(), c2, p2, x.c(b3, "yyyy.MM.dd HH:mm:ss", "yyyyMMddHHmmss", 1), x.c(g2, "yyyy.MM.dd HH:mm:ss", "yyyyMMddHHmmss", 1)));
        bundle.putString("telecomcode", p2);
        bundle.putBoolean("isProjection", true);
        bundle.putString("cmsid", dVar.d());
        bundle.putString("physicalcontentid", dVar.j());
        this.f7344d.J();
        if (!TextUtils.equals("", "") && !TextUtils.equals("", com.zte.iptvclient.common.uiframe.a.c("BSTV_CP_Code"))) {
            bundle.putString("bookmark_breakpoint", this.Q.f7371b);
        } else {
            bundle.putString("bookmark_breakpoint", a(this.Q.f7371b) + "");
        }
        com.zte.iptvclient.android.common.player.j.j jVar = new com.zte.iptvclient.android.common.player.j.j();
        jVar.b(c2);
        jVar.a(channel.getColumncode());
        jVar.c("1");
        this.f7341a.a(true);
        if (TextUtils.equals("1", ConfigMgr.readPropertie("SuportTvoDAddBookMark", "0"))) {
            this.f7341a.b(true);
        } else {
            this.f7341a.b(false);
        }
        this.f7341a.a(jVar, bundle, this.f7343c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        if (f()) {
            return;
        }
        if (this.e.J()) {
            this.e.M();
        } else if (com.zte.iptvclient.android.mobile.h.a.a.g().b() == null) {
            this.e.N();
        } else {
            LogEx.d("RemoteDirectionLayout", "发送了一次请求");
            com.zte.iptvclient.android.mobile.h.a.a.g().a(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        String[] split = str.split(":");
        int length = split.length;
        int i2 = 0;
        for (int i3 = 0; i3 < split.length; i3++) {
            i2 += Integer.parseInt(split[i3]) * ((int) Math.pow(60.0d, (length - 1) - i3));
        }
        return i2;
    }

    public void a() {
        com.zte.iptvclient.android.common.customview.a.a.e.g gVar = this.R;
        if (gVar != null) {
            gVar.dismiss();
            Timer timer = this.S;
            if (timer != null) {
                timer.purge();
                this.S.cancel();
            }
            this.S = null;
            this.T = 0;
            this.R = null;
        }
    }
}
