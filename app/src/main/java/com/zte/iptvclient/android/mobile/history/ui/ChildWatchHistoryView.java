package com.zte.iptvclient.android.mobile.history.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.tencent.mm.sdk.platformtools.Util;
import com.video.androidsdk.common.util.TimeUtil;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.vod.SDKVodMgr;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshFooter;
import com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh.DefaultRefreshHeader;
import com.zte.iptvclient.android.common.f.b.i;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.common.k.g;
import com.zte.iptvclient.android.common.k.h;
import com.zte.iptvclient.android.mobile.history.entity.WatchHistoryEntity;
import com.zte.iptvclient.android.mobile.k.c.a;
import com.zte.iptvclient.android.mobile.k.c.b;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ChildWatchHistoryView extends FrameLayout implements com.scwang.smartrefresh.layout.d.c, com.scwang.smartrefresh.layout.d.a {

    /* renamed from: a, reason: collision with root package name */
    private int f6397a;

    /* renamed from: b, reason: collision with root package name */
    private SmartRefreshLayout f6398b;

    /* renamed from: c, reason: collision with root package name */
    private RecyclerView f6399c;

    /* renamed from: d, reason: collision with root package name */
    private RelativeLayout f6400d;
    private TextView e;
    private com.zte.iptvclient.android.mobile.k.a.a f;
    private ArrayList<WatchHistoryEntity> g;
    private com.zte.iptvclient.android.mobile.k.c.a h;
    private Future<?> i;
    private SDKVodMgr j;
    private com.zte.iptvclient.android.mobile.k.c.b k;
    private d l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements b.InterfaceC0295b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WatchHistoryEntity f6401a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f6402b;

        a(WatchHistoryEntity watchHistoryEntity, int i) {
            this.f6401a = watchHistoryEntity;
            this.f6402b = i;
        }

        @Override // com.zte.iptvclient.android.mobile.k.c.b.InterfaceC0295b
        public void a(String str, String str2, String str3) {
            LogEx.d("ChildWatchHistoryView", " returncode: " + str + " , errormsg: " + str2 + " , data: " + str3);
            if (TextUtils.equals("0", str)) {
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    if (jSONArray.length() > 0) {
                        this.f6401a.g(ChildWatchHistoryView.this.b(jSONArray.getJSONObject(0).getString("channelcode")));
                        ChildWatchHistoryView.this.f.c(this.f6402b);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            ChildWatchHistoryView.this.b(this.f6402b + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements SDKVodMgr.OnVodDetailWithUrlReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WatchHistoryEntity f6404a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f6405b;

        b(WatchHistoryEntity watchHistoryEntity, int i) {
            this.f6404a = watchHistoryEntity;
            this.f6405b = i;
        }

        @Override // com.video.androidsdk.service.vod.SDKVodMgr.OnVodDetailWithUrlReturnListener
        public void onVodDetailWithUrlReturn(String str, String str2, String str3) {
            LogEx.d("ChildWatchHistoryView", " returncode: " + str + " , errormsg: " + str2 + " , data: " + str3);
            if (TextUtils.equals("0", str)) {
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    if (jSONArray.length() > 0) {
                        String string = jSONArray.getJSONObject(0).getString("posterfilelist");
                        String string2 = jSONArray.getJSONObject(0).getString("cpcode");
                        String a2 = g.a(BaseApp.f() ? 9 : 3, string);
                        if (!TextUtils.isEmpty(a2)) {
                            if (a2.contains("/image")) {
                                a2 = i.g() + a2.substring(a2.indexOf("/image", 1));
                            }
                            this.f6404a.g(a2);
                            this.f6404a.d(string2);
                            ChildWatchHistoryView.this.f.c(this.f6405b);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            ChildWatchHistoryView.this.b(this.f6405b + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements a.b {
        c() {
        }

        @Override // com.zte.iptvclient.android.mobile.k.c.a.b
        public void a(String str, String str2, String str3) {
            LogEx.d("ChildWatchHistoryView", "returncode: " + str + " , errormsg: " + str2 + " , data: " + str3);
            ChildWatchHistoryView.this.i = h.a().a(new e(ChildWatchHistoryView.this, str, str3));
        }
    }

    /* loaded from: classes.dex */
    private static final class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<ChildWatchHistoryView> f6409a;

        /* renamed from: b, reason: collision with root package name */
        private String f6410b;

        /* renamed from: c, reason: collision with root package name */
        private String f6411c;

        public e(ChildWatchHistoryView childWatchHistoryView, String str, String str2) {
            this.f6409a = new WeakReference<>(childWatchHistoryView);
            this.f6410b = str;
            this.f6411c = str2;
        }

        private void a() {
            ChildWatchHistoryView childWatchHistoryView = this.f6409a.get();
            if (childWatchHistoryView != null) {
                childWatchHistoryView.l.sendEmptyMessage(52418);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.equals(this.f6410b, "200")) {
                try {
                    JSONArray jSONArray = new JSONObject(this.f6411c).getJSONArray("data");
                    int length = jSONArray.length();
                    ArrayList arrayList = new ArrayList(length);
                    for (int i = 0; i < length; i++) {
                        arrayList.add(WatchHistoryEntity.a(jSONArray.getJSONObject(i)));
                    }
                    ChildWatchHistoryView childWatchHistoryView = this.f6409a.get();
                    if (childWatchHistoryView != null) {
                        Message obtainMessage = childWatchHistoryView.l.obtainMessage();
                        obtainMessage.what = 52417;
                        obtainMessage.obj = arrayList;
                        childWatchHistoryView.l.sendMessage(obtainMessage);
                        return;
                    }
                    return;
                } catch (JSONException e) {
                    e.printStackTrace();
                    a();
                    return;
                }
            }
            a();
        }
    }

    public ChildWatchHistoryView(Context context) {
        super(context);
        this.l = new d(this);
        a(context);
    }

    private String d() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        int i = this.f6397a;
        if (i == 1) {
            return simpleDateFormat.format(b(TimeUtil.getNow()));
        }
        if (i == 2) {
            return simpleDateFormat.format(b(new Date(TimeUtil.getNow().getTime() - Util.MILLSECONDS_OF_DAY)));
        }
        if (i == 3) {
            return simpleDateFormat.format(b(new Date(TimeUtil.getNow().getTime() - 172800000)));
        }
        return null;
    }

    private String e() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        int i = this.f6397a;
        if (i == 1) {
            return simpleDateFormat.format(a(TimeUtil.getNow()));
        }
        if (i == 2) {
            return simpleDateFormat.format(a(new Date(TimeUtil.getNow().getTime() - Util.MILLSECONDS_OF_DAY)));
        }
        if (i == 3) {
            return simpleDateFormat.format(a(new Date(TimeUtil.getNow().getTime() - 172800000)));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f6400d.setVisibility(0);
        this.f6399c.setVisibility(8);
        c();
    }

    private void g() {
        this.f6398b.a((com.scwang.smartrefresh.layout.d.c) this);
        this.f6398b.a((com.scwang.smartrefresh.layout.d.a) this);
    }

    @Override // com.scwang.smartrefresh.layout.d.a
    public void b(com.scwang.smartrefresh.layout.a.h hVar) {
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<ChildWatchHistoryView> f6408a;

        public d(ChildWatchHistoryView childWatchHistoryView) {
            this.f6408a = new WeakReference<>(childWatchHistoryView);
        }

        private void a(ArrayList<WatchHistoryEntity> arrayList) {
            ChildWatchHistoryView childWatchHistoryView = this.f6408a.get();
            if (childWatchHistoryView != null) {
                childWatchHistoryView.a(arrayList);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 52417:
                    a((ArrayList) message.obj);
                    return;
                case 52418:
                    a();
                    return;
                default:
                    return;
            }
        }

        private void a() {
            ChildWatchHistoryView childWatchHistoryView = this.f6408a.get();
            if (childWatchHistoryView != null) {
                childWatchHistoryView.f();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        if (this.g.size() > i) {
            WatchHistoryEntity watchHistoryEntity = this.g.get(i);
            String c2 = watchHistoryEntity.c();
            if (TextUtils.equals("0", c2)) {
                watchHistoryEntity.g(b(watchHistoryEntity.a()));
                this.f.c(i);
                b(i + 1);
            } else if (TextUtils.equals("1", c2)) {
                b(watchHistoryEntity, i);
            } else if (TextUtils.equals("2", c2)) {
                a(watchHistoryEntity, i);
            }
        }
    }

    private void c() {
        this.f6398b.a();
    }

    public ChildWatchHistoryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = new d(this);
        a(context);
    }

    private void a(Context context) {
        LogEx.d("ChildWatchHistoryView", "---init---");
        setBackgroundColor(androidx.core.content.a.a(context, R.color.transparent));
        View inflate = LayoutInflater.from(context).inflate(R.layout.fragment_child_watch_history_custom_view, this);
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) inflate.findViewById(R.id.refreshLayout);
        this.f6398b = smartRefreshLayout;
        smartRefreshLayout.a(new DefaultRefreshHeader(context));
        this.f6398b.a(new DefaultRefreshFooter(context));
        this.f6398b.a(false);
        this.f6398b.c(false);
        Resources resources = context.getResources();
        this.f6398b.e(g.a(context, resources.getDimension(R.dimen.refresh_footer_height)));
        this.f6398b.f(g.a(context, resources.getDimension(R.dimen.refresh_header_height)));
        this.f6399c = (RecyclerView) inflate.findViewById(R.id.recycle_view);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.rl_empty);
        this.f6400d = relativeLayout;
        TextView textView = (TextView) relativeLayout.findViewById(R.id.txt_pullrefresh);
        this.e = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.there_is_no_collection));
        f.a(this.f6400d.findViewById(R.id.ll_pullrefresh));
        f.a(this.f6400d.findViewById(R.id.img_pullrefresh_icon));
        f.a(this.f6400d.findViewById(R.id.txt_pullrefresh));
        f.a(this.f6400d.findViewById(R.id.refresh_image));
        ArrayList<WatchHistoryEntity> arrayList = new ArrayList<>();
        this.g = arrayList;
        this.f = new com.zte.iptvclient.android.mobile.k.a.a(arrayList);
        this.f6399c.a(new LinearLayoutManager(context));
        this.f6399c.d(true);
        this.f6399c.a(this.f);
        g();
    }

    public ChildWatchHistoryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = new d(this);
        a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(String str) {
        Channel a2 = a(str);
        String posterimage = a2 != null ? a2.getPosterimage() : null;
        if (TextUtils.isEmpty(posterimage) || posterimage == null) {
            return posterimage;
        }
        int indexOf = posterimage.indexOf("/image", 1);
        return i.g() + posterimage.substring(indexOf);
    }

    private void b(WatchHistoryEntity watchHistoryEntity, int i) {
        String a2 = watchHistoryEntity.a();
        this.j = new SDKVodMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("programcode", a2);
        this.j.getVodDetailWithUrl(hashMap, new b(watchHistoryEntity, i));
    }

    private Date b(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        return calendar.getTime();
    }

    public void b() {
        this.h = new com.zte.iptvclient.android.mobile.k.c.a();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("profilecode", com.zte.iptvclient.android.mobile.k.d.a.a());
        hashMap.put("begintime", d());
        hashMap.put("endtime", e());
        hashMap.put("langtype", com.zte.iptvclient.android.common.i.a.a.a(R.string.search_language_type));
        hashMap.put("rpsnum", "200");
        this.h.a(hashMap, new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<WatchHistoryEntity> arrayList) {
        this.g.clear();
        this.g.addAll(arrayList);
        this.f.d();
        if (this.g.size() > 0) {
            this.f6400d.setVisibility(8);
            this.f6399c.setVisibility(0);
        } else {
            this.f6400d.setVisibility(0);
            this.f6399c.setVisibility(8);
        }
        c();
        b(0);
    }

    public void b(boolean z) {
        this.f6398b.d(z);
    }

    private void a(WatchHistoryEntity watchHistoryEntity, int i) {
        String a2 = watchHistoryEntity.a();
        this.k = new com.zte.iptvclient.android.mobile.k.c.b();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("prevuecode", a2);
        this.k.a(hashMap, new a(watchHistoryEntity, i));
    }

    private Channel a(String str) {
        for (Channel channel : com.zte.iptvclient.android.common.j.i.d().b()) {
            if (channel.getChannelcode().equals(str)) {
                return channel;
            }
        }
        return null;
    }

    public void a(int i) {
        this.f6397a = i;
    }

    private Date a(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        return calendar.getTime();
    }

    public void a() {
        com.zte.iptvclient.android.mobile.k.c.a aVar = this.h;
        if (aVar != null) {
            aVar.a();
        }
        Future<?> future = this.i;
        if (future != null) {
            future.cancel(true);
        }
        SDKVodMgr sDKVodMgr = this.j;
        if (sDKVodMgr != null) {
            sDKVodMgr.cancelRequest();
        }
        com.zte.iptvclient.android.mobile.k.c.b bVar = this.k;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void a(boolean z) {
        this.f6398b.b(z);
    }

    @Override // com.scwang.smartrefresh.layout.d.c
    public void a(com.scwang.smartrefresh.layout.a.h hVar) {
        a();
        b();
    }
}
