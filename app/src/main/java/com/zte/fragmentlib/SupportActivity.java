package com.zte.fragmentlib;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.tencent.mm.sdk.platformtools.Util;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.comm.ParamConst;
import com.video.androidsdk.service.prevue.SDKPrevueMgr;
import com.zte.fragmentlib.anim.DefaultVerticalAnimator;
import com.zte.fragmentlib.anim.FragmentAnimator;
import com.zte.fragmentlib.publicbaseclass.skinloader.BaseFragmentActivity;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.customview.a.a.e.g;
import com.zte.iptvclient.android.common.e.x.o;
import com.zte.iptvclient.android.common.e.x.p;
import com.zte.iptvclient.android.common.j.h;
import com.zte.iptvclient.android.common.j.i;
import com.zte.iptvclient.android.common.javabean.BrowserReturnBean;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.common.javabean.models.MovieDetailBundleBean;
import com.zte.iptvclient.android.common.javabean.models.PrevueBean;
import com.zte.iptvclient.android.common.player.activity.VOPlayerActivity;
import com.zte.iptvclient.android.common.reminder.AlarmVideoBean;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.home.tab.helper.TabHostManager;
import com.zte.iptvclient.android.zala.R;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SupportActivity extends BaseFragmentActivity {

    /* renamed from: c, reason: collision with root package name */
    private com.zte.fragmentlib.a f4030c;

    /* renamed from: d, reason: collision with root package name */
    private FragmentAnimator f4031d;
    private Handler h;
    private g i;
    private Method j;
    private Object k;
    private h p;
    private g.a q;
    private String s;
    private int e = 0;
    boolean f = false;
    private boolean g = true;
    private String[] l = {"Activity", "FragmentActivity", "BaseFragmentActivity", "SupportActivity"};
    private com.zte.iptvclient.android.common.reminder.b m = null;
    private Timer n = null;
    private int o = 0;
    private ArrayList<PrevueBean> r = new ArrayList<>();
    private ArrayList<Channel> t = new ArrayList<>();
    private Handler u = new a();

    /* loaded from: classes.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                SupportActivity.b(SupportActivity.this);
                if (SupportActivity.this.o >= 20) {
                    SupportActivity.this.d();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    class b extends TimerTask {
        b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.e(SupportActivity.this.s, ""));
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.n.a(TabHostManager.TabName.TV));
            com.zte.iptvclient.android.common.e.x.e eVar = new com.zte.iptvclient.android.common.e.x.e(SupportActivity.this.s, "");
            eVar.a(true);
            EventBus.getDefault().post(eVar);
            SupportActivity.this.p.k(SupportActivity.this.s);
        }
    }

    /* loaded from: classes.dex */
    class c extends TimerTask {
        c() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            SupportActivity.this.t = i.d().c();
            if (SupportActivity.this.t.size() > 0) {
                LogEx.d("SupportActivity", "null != getTvColumnAllChannelList");
                SupportActivity supportActivity = SupportActivity.this;
                supportActivity.a(supportActivity.s);
                return;
            }
            LogEx.d("SupportActivity", "null == getTvColumnAllChannelList");
        }
    }

    /* loaded from: classes.dex */
    class d extends TimerTask {
        d() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Message message = new Message();
            message.what = 1;
            SupportActivity.this.u.sendMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements SDKPrevueMgr.OnPrevueDetailWithUrlReturnListener {
        e() {
        }

        @Override // com.video.androidsdk.service.prevue.SDKPrevueMgr.OnPrevueDetailWithUrlReturnListener
        public void onPrevueDetailWithUrlReturn(String str, String str2, String str3) {
            LogEx.d("SupportActivity", "onPrevueDetailWithUrlReturn msg=" + str3);
            if (TextUtils.equals(str, "0")) {
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        SupportActivity.this.r.add(PrevueBean.getPrevueBeanFromJSon(jSONArray.getJSONObject(i)));
                    }
                    PrevueBean prevueBean = (PrevueBean) SupportActivity.this.r.get(0);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.ENGLISH);
                    Date parse = simpleDateFormat.parse(prevueBean.getBegintime());
                    Date parse2 = simpleDateFormat.parse(prevueBean.getEndtime());
                    SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH);
                    String format = simpleDateFormat2.format(parse);
                    String format2 = simpleDateFormat2.format(parse2);
                    prevueBean.setBegintime(format);
                    prevueBean.setEndtime(format2);
                    EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.n.a(TabHostManager.TabName.TV));
                    EventBus.getDefault().post(new o(prevueBean));
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.query_tvod_info_fail);
                    return;
                }
            }
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(R.string.query_tvod_info_fail);
        }
    }

    /* loaded from: classes.dex */
    class f implements com.vk.api.sdk.auth.b {
        f() {
        }

        @Override // com.vk.api.sdk.auth.b
        public void a(com.vk.api.sdk.auth.a aVar) {
            LogEx.i("VK", "onLogin:" + aVar.a());
        }

        @Override // com.vk.api.sdk.auth.b
        public void a(int i) {
            LogEx.i("VK", "onLoginFailed" + i);
        }
    }

    static /* synthetic */ int b(SupportActivity supportActivity) {
        int i = supportActivity.o;
        supportActivity.o = i + 1;
        return i;
    }

    private void r() {
        if (Build.VERSION.SDK_INT < 11) {
            return;
        }
        try {
            if (this.j != null && this.k != null) {
                this.j.invoke(this.k, new Object[0]);
                return;
            }
            Class<?> cls = getClass();
            do {
                cls = cls.getSuperclass();
                if (this.l[0].equals(cls.getSimpleName()) || this.l[1].equals(cls.getSimpleName()) || this.l[2].equals(cls.getSimpleName())) {
                    break;
                }
            } while (!this.l[3].equals(cls.getSimpleName()));
            Field a2 = a(cls, "mFragments");
            if (a2 != null) {
                Object obj = a2.get(this);
                this.k = obj;
                Method a3 = a(obj, "noteStateNotSaved", new Class[0]);
                this.j = a3;
                if (a3 != null) {
                    a3.invoke(this.k, new Object[0]);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z) {
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.g) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = super.getResources();
        Configuration configuration = new Configuration();
        configuration.setToDefaults();
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return resources;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.zte.fragmentlib.a h() {
        if (this.f4030c == null) {
            this.f4030c = new com.zte.fragmentlib.a(this);
        }
        return this.f4030c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Handler j() {
        if (this.h == null) {
            this.h = new Handler();
        }
        return this.h;
    }

    public com.zte.fragmentlib.b k() {
        return this.f4030c.b(getSupportFragmentManager());
    }

    public void l() {
        if (getSupportFragmentManager().q() > 1) {
            n();
        } else {
            finish();
        }
    }

    protected FragmentAnimator m() {
        return new DefaultVerticalAnimator();
    }

    public void n() {
        this.f4030c.a(getSupportFragmentManager());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
        this.f = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (com.vk.api.sdk.a.a(i, i2, intent, new f())) {
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @Deprecated
    public void onBackPressed() {
        if (!this.g) {
            b(true);
        }
        if (this.f4030c.a(this.f4030c.a((com.zte.fragmentlib.b) null, getSupportFragmentManager()))) {
            return;
        }
        l();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (Double.doubleToLongBits(configuration.fontScale) != 1) {
            getResources();
        }
        super.onConfigurationChanged(configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zte.fragmentlib.publicbaseclass.skinloader.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (BaseApp.a(this)) {
            if (getRequestedOrientation() != 0) {
                setRequestedOrientation(0);
                com.zte.iptvclient.common.uiframe.f.a(Util.BYTE_OF_KB, 768);
            }
        } else if (getRequestedOrientation() != 1) {
            setRequestedOrientation(1);
            com.zte.iptvclient.common.uiframe.f.a(480, 800);
        }
        com.zte.iptvclient.common.uiframe.f.a(this);
        this.f4030c = h();
        this.f4031d = m();
        this.p = new h(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zte.fragmentlib.publicbaseclass.skinloader.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.i != null) {
            this.i = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && !this.g) {
            b(true);
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        r();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p() {
        this.f = true;
    }

    public void q() {
        if (this.i == null) {
            g gVar = new g(this);
            this.i = gVar;
            g.a aVar = this.q;
            if (aVar != null) {
                gVar.a(aVar);
            }
            this.i.show();
            this.o = 0;
            if (this.n == null) {
                this.n = new Timer();
            }
            d dVar = new d();
            Timer timer = this.n;
            if (timer != null) {
                timer.schedule(dVar, 1000L, 1000L);
            }
        }
    }

    private void c(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAMS_PROGRAMCODE, str);
        Intent intent = new Intent(this, (Class<?>) HostActivity.class);
        bundle.putString("fragmenttype", "seriesdetail");
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void b(com.zte.fragmentlib.b bVar) {
        this.f4030c.a(getSupportFragmentManager(), k(), bVar, 0, 0, 1, null, null);
    }

    public void d() {
        g gVar = this.i;
        if (gVar != null && gVar.isShowing()) {
            this.i.dismiss();
        }
        Timer timer = this.n;
        if (timer != null) {
            timer.purge();
            this.n.cancel();
            this.n = null;
        }
        this.o = 0;
        this.i = null;
    }

    public int f() {
        return this.e;
    }

    public FragmentAnimator g() {
        if (this.f4031d != null) {
            return new FragmentAnimator(this.f4031d.a(), this.f4031d.b(), this.f4031d.c(), this.f4031d.d());
        }
        return null;
    }

    private Field a(Class<?> cls, String str) throws NoSuchFieldException {
        if (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField;
            } finally {
                cls.getSuperclass();
            }
        }
        throw new NoSuchFieldException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Intent intent) {
        if (intent.getSerializableExtra("TvAlert_TvShowItem") != null) {
            PrevueBean prevueBean = (PrevueBean) intent.getSerializableExtra("TvAlert_TvShowItem");
            if (intent.getBooleanExtra("TvAlert_needConfirm", true)) {
                com.zte.iptvclient.android.common.reminder.b bVar = this.m;
                if (bVar == null || !bVar.isShowing()) {
                    com.zte.iptvclient.android.common.reminder.b bVar2 = new com.zte.iptvclient.android.common.reminder.b(this);
                    this.m = bVar2;
                    bVar2.show();
                }
            } else if (prevueBean != null) {
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.i(prevueBean.getChannelcode()));
            }
            p pVar = new p();
            pVar.a(prevueBean);
            EventBus.getDefault().post(pVar);
            return;
        }
        if (intent.getSerializableExtra("VodAlert_VodAlarmItem") != null) {
            com.zte.iptvclient.android.common.reminder.b bVar3 = this.m;
            if (bVar3 == null || !bVar3.isShowing()) {
                com.zte.iptvclient.android.common.reminder.b bVar4 = new com.zte.iptvclient.android.common.reminder.b(this);
                this.m = bVar4;
                bVar4.show();
            }
            AlarmVideoBean alarmVideoBean = (AlarmVideoBean) intent.getSerializableExtra("VodAlert_VodAlarmItem");
            com.zte.iptvclient.android.common.e.b0.e eVar = new com.zte.iptvclient.android.common.e.b0.e();
            eVar.a(alarmVideoBean);
            EventBus.getDefault().post(eVar);
        }
    }

    private Method a(Object obj, String str, Class<?>... clsArr) {
        for (Class<?> cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                return cls.getDeclaredMethod(str, clsArr);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public void a(int i, com.zte.fragmentlib.b bVar) {
        this.f4030c.a(getSupportFragmentManager(), i, bVar);
    }

    public void a(int i, com.zte.fragmentlib.b bVar, boolean z) {
        this.f4030c.a(getSupportFragmentManager(), i, bVar, z);
    }

    public void a(com.zte.fragmentlib.b bVar) {
        a(bVar, 0);
    }

    public void a(com.zte.fragmentlib.b bVar, int i) {
        this.f4030c.a(getSupportFragmentManager(), k(), bVar, 0, i, 0, null, null);
    }

    public <T extends com.zte.fragmentlib.b> T a(Class<T> cls) {
        return (T) this.f4030c.a((Class) cls, getSupportFragmentManager(), false);
    }

    public void a(Class<?> cls, boolean z) {
        this.f4030c.a(cls, z, (Runnable) null, getSupportFragmentManager());
    }

    private void b(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAMS_PROGRAMCODE, str);
        Intent intent = new Intent(this, (Class<?>) HostActivity.class);
        bundle.putString("fragmenttype", "moviedetail");
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Intent intent) {
        if (intent.getSerializableExtra("BrowserReturnData") != null) {
            if (this instanceof VOPlayerActivity) {
                finish();
            }
            BrowserReturnBean browserReturnBean = (BrowserReturnBean) intent.getSerializableExtra("BrowserReturnData");
            if (browserReturnBean != null) {
                if (browserReturnBean.getContentType().equals("14")) {
                    a(browserReturnBean.getProgramCode(), browserReturnBean.getColumnCode(), browserReturnBean.getSeriesNumber());
                    return;
                }
                if (browserReturnBean.getContentType().equals("2")) {
                    EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.i(browserReturnBean.getProgramCode()));
                    return;
                } else if (browserReturnBean.getContentType().equals("4")) {
                    EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.b0.c(browserReturnBean.getProgramCode()));
                    return;
                } else {
                    if (browserReturnBean.getContentType().equals("1")) {
                        b(browserReturnBean.getProgramCode());
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (TextUtils.isEmpty(intent.getStringExtra("videoid")) || TextUtils.isEmpty(intent.getStringExtra(ParamConst.VOD_DETAIL_QUERY_RSP_VIDEOTYPE))) {
            return;
        }
        this.s = intent.getStringExtra("videoid");
        String stringExtra = intent.getStringExtra(ParamConst.VOD_DETAIL_QUERY_RSP_VIDEOTYPE);
        LogEx.d("SupportActivity", "share url videoid = " + this.s + " videotype =" + stringExtra);
        if ("14".equals(stringExtra)) {
            c(this.s);
            return;
        }
        if ("1".equals(stringExtra)) {
            b(this.s);
            return;
        }
        if ("2".equals(stringExtra)) {
            new Timer().schedule(new b(), 1000L);
        } else if ("4".equals(stringExtra)) {
            ArrayList<Channel> c2 = i.d().c();
            this.t = c2;
            if (c2.size() > 0) {
                LogEx.d("SupportActivity", "null != getTvColumnAllChannelList");
                a(this.s);
            } else {
                new Timer().schedule(new c(), 7000L);
            }
        }
    }

    private void a(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAMS_PROGRAMCODE, str);
        bundle.putString(MovieDetailBundleBean.MOVIE_BUNDLEPARAM_COLUMNCODE, str2);
        bundle.putString(MovieDetailBundleBean.SERIES_BUNDLEPARAMS_SERIES_NUM, str3);
        Intent intent = new Intent(this, (Class<?>) HostActivity.class);
        bundle.putString("fragmenttype", "seriesdetail");
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void a(g.a aVar) {
        this.q = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        this.r.clear();
        SDKPrevueMgr sDKPrevueMgr = new SDKPrevueMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("prevuecode", str);
        sDKPrevueMgr.getPrevueDetailWithUrl(hashMap, new e());
    }
}
