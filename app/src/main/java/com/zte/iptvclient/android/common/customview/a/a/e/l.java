package com.zte.iptvclient.android.common.customview.a.a.e;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.video.androidsdk.cast.bean.DLNAEvent;
import com.video.androidsdk.cast.bean.Device;
import com.video.androidsdk.common.AndroidUniqueCode;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: StbSelectDialogNew.java */
/* loaded from: classes.dex */
public class l extends Dialog {
    private static h r;

    /* renamed from: a, reason: collision with root package name */
    private String f4271a;

    /* renamed from: b, reason: collision with root package name */
    private Context f4272b;

    /* renamed from: c, reason: collision with root package name */
    SharedPreferences f4273c;

    /* renamed from: d, reason: collision with root package name */
    ListView f4274d;
    i e;
    private boolean f;
    List<Device> g;
    private Animation h;
    private LinearLayout i;
    private ImageView j;
    private TextView k;
    private ImageView l;
    private com.zte.iptvclient.android.common.j.h m;
    Timer n;
    Handler o;
    private boolean p;
    private TextView q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StbSelectDialogNew.java */
    /* loaded from: classes.dex */
    public class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                l.this.k.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.batch_text));
                l.this.j.clearAnimation();
            }
            super.handleMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StbSelectDialogNew.java */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.this.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StbSelectDialogNew.java */
    /* loaded from: classes.dex */
    public class c implements DialogInterface.OnDismissListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Message message = new Message();
            message.what = 1;
            l.this.o.sendMessage(message);
            l.this.p = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StbSelectDialogNew.java */
    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            l.this.dismiss();
        }
    }

    /* compiled from: StbSelectDialogNew.java */
    /* loaded from: classes.dex */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Message message = new Message();
            message.what = 1;
            l.this.o.sendMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StbSelectDialogNew.java */
    /* loaded from: classes.dex */
    public class f extends TimerTask {
        f() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            l.this.p = false;
            Message message = new Message();
            message.what = 1;
            l.this.o.sendMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StbSelectDialogNew.java */
    /* loaded from: classes.dex */
    public class g extends TimerTask {
        g() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            l.this.p = false;
            Message message = new Message();
            message.what = 1;
            l.this.o.sendMessage(message);
        }
    }

    /* compiled from: StbSelectDialogNew.java */
    /* loaded from: classes.dex */
    public interface h {
        void c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: StbSelectDialogNew.java */
    /* loaded from: classes.dex */
    public class i extends BaseAdapter {

        /* compiled from: StbSelectDialogNew.java */
        /* loaded from: classes.dex */
        private class a {

            /* renamed from: a, reason: collision with root package name */
            TextView f4283a;

            /* renamed from: b, reason: collision with root package name */
            ImageView f4284b;

            private a(i iVar) {
            }

            /* synthetic */ a(i iVar, a aVar) {
                this(iVar);
            }
        }

        private i() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return l.this.g.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return l.this.g.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            Device device;
            View view2;
            a aVar;
            a aVar2 = null;
            if (l.this.g.size() == 0 || (device = l.this.g.get(i)) == null) {
                return null;
            }
            if (view == null) {
                aVar = new a(this, aVar2);
                view2 = LayoutInflater.from(l.this.f4272b).inflate(R.layout.remote_stbselect_item, (ViewGroup) null);
                TextView textView = (TextView) view2.findViewById(R.id.remote_item_mac);
                ImageView imageView = (ImageView) view2.findViewById(R.id.remote_item_select);
                aVar.f4283a = textView;
                aVar.f4284b = imageView;
                view2.setTag(aVar);
                com.zte.iptvclient.common.uiframe.f.a(aVar.f4283a);
                com.zte.iptvclient.common.uiframe.f.a(aVar.f4284b);
            } else {
                view2 = view;
                aVar = (a) view.getTag();
            }
            String macAddress = device.getMacAddress();
            String friendlyName = device.getFriendlyName();
            if (friendlyName != null) {
                macAddress = friendlyName;
            }
            String udn = device.getUDN();
            if (macAddress != null) {
                macAddress = l.this.f4272b.getSharedPreferences("stbcachefile", 0).getString(udn, macAddress);
            }
            aVar.f4283a.setText(macAddress);
            Device b2 = com.zte.iptvclient.android.mobile.h.a.a.g().b();
            if (b2 != null && udn.equalsIgnoreCase(b2.getUDN())) {
                aVar.f4284b.setVisibility(0);
                aVar.f4283a.setTextColor(c.a.a.a.d.b.d().b(R.color.stb_selector_stbname_selected));
                ((SupportActivity) l.this.f4272b).a(aVar.f4283a, "textColor", R.color.stb_selector_stbname_selected);
            } else {
                aVar.f4284b.setVisibility(4);
                aVar.f4283a.setTextColor(c.a.a.a.d.b.d().b(R.color.stb_selector_stbname_normal));
                ((SupportActivity) l.this.f4272b).a(aVar.f4283a, "textColor", R.color.stb_selector_stbname_normal);
            }
            return view2;
        }

        /* synthetic */ i(l lVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: StbSelectDialogNew.java */
    /* loaded from: classes.dex */
    public class j implements AdapterView.OnItemClickListener {

        /* compiled from: StbSelectDialogNew.java */
        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                l.this.dismiss();
            }
        }

        private j() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Device device;
            Device a2;
            if (l.this.g.size() <= i || (device = l.this.g.get(i)) == null || (a2 = com.zte.iptvclient.android.mobile.h.a.a.g().a(device)) == null) {
                return;
            }
            LogEx.d(l.this.f4271a, "sendUerNameAndDeviceIdToStb start");
            com.zte.iptvclient.android.mobile.h.a.a.g().a(SDKLoginMgr.getInstance().getUserID(), AndroidUniqueCode.getAndroidId(l.this.f4272b), l.this.m.U());
            l.this.m.C(a2.getUDN());
            l.this.m.A(com.zte.iptvclient.android.mobile.h.a.a.g().a(l.this.f4272b));
            l.this.e.notifyDataSetChanged();
            if (l.r != null) {
                l.r.c();
            }
            new Handler().postDelayed(new a(), 700L);
        }

        /* synthetic */ j(l lVar, a aVar) {
            this();
        }
    }

    public l(Context context, boolean z) {
        super(context, R.style.dialogstyle);
        this.f4271a = "StbSelectDialogNew";
        this.f = false;
        this.n = null;
        this.o = new a();
        this.p = false;
        this.f = z;
        this.m = new com.zte.iptvclient.android.common.j.h(context);
        this.f4272b = context;
    }

    private void f() {
        i iVar = new i(this, null);
        this.e = iVar;
        this.f4274d.setAdapter((ListAdapter) iVar);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        r = null;
        Timer timer = this.n;
        if (timer != null) {
            timer.cancel();
            this.n = null;
        }
        LogEx.d(this.f4271a, "EventBus unregister");
        EventBus.getDefault().unregister(this);
        super.dismiss();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = View.inflate(this.f4272b, R.layout.remote_stbselect_popup, null);
        setContentView(inflate);
        e();
        a(inflate);
        f();
        d();
        this.h = AnimationUtils.loadAnimation(this.f4272b, R.anim.remote_refresh_rotate);
        this.h.setInterpolator(new LinearInterpolator());
        this.j.setAnimation(this.h);
        setCanceledOnTouchOutside(true);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.l.b bVar) {
        if (bVar == null) {
            return;
        }
        this.p = false;
        Timer timer = this.n;
        if (timer != null) {
            timer.cancel();
            this.n.purge();
            this.n = null;
        }
        LogEx.d(this.f4271a, "dlna event [" + bVar.a() + "]");
        String a2 = bVar.a();
        if (DLNAEvent.EVENT_DEVICE_ONLINE.equals(a2) || DLNAEvent.EVENT_DEVICE_OFFLINE.equals(a2)) {
            this.g.clear();
            this.e.notifyDataSetChanged();
            for (Device device : com.zte.iptvclient.android.mobile.h.a.a.g().a()) {
                if (device != null) {
                    this.g.add(device);
                }
            }
            this.e.notifyDataSetChanged();
            h hVar = r;
            if (hVar != null && this.f) {
                hVar.c();
            }
            this.f4274d.postDelayed(new e(), 500L);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        String macAddress;
        super.show();
        if (!EventBus.getDefault().isRegistered(this)) {
            LogEx.d(this.f4271a, "EventBus register");
            EventBus.getDefault().register(this);
        }
        this.g.clear();
        for (Device device : com.zte.iptvclient.android.mobile.h.a.a.g().a()) {
            if (device != null && (macAddress = device.getMacAddress()) != null && !TextUtils.equals(macAddress.trim(), "")) {
                this.g.add(device);
            }
        }
    }

    private void d() {
        this.f4274d.setOnItemClickListener(new j(this, null));
        this.i.setOnClickListener(new b());
        setOnDismissListener(new c());
        this.l.setOnClickListener(new d());
    }

    private void e() {
        if (this.f4273c == null) {
            this.f4273c = this.f4272b.getSharedPreferences("stbcachefile", 0);
        }
        if (this.g == null) {
            this.g = new ArrayList();
        }
    }

    public void b() {
        this.g.clear();
        this.e.notifyDataSetChanged();
        if (this.p) {
            return;
        }
        this.k.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.Is_refreshing));
        this.j.startAnimation(this.h);
        this.p = true;
        LogEx.d(this.f4271a, " StbSelectDialogNew scanDevices");
        com.zte.iptvclient.android.mobile.h.a.a.g().c();
        Timer timer = this.n;
        if (timer != null) {
            timer.cancel();
            this.n.purge();
            this.n = null;
        }
        Timer timer2 = new Timer();
        this.n = timer2;
        timer2.schedule(new f(), DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
    }

    public void a() {
        if (this.g.size() > 0) {
            Message message = new Message();
            message.what = 1;
            this.o.sendMessage(message);
            f();
            this.e.notifyDataSetChanged();
            return;
        }
        this.g.clear();
        this.e.notifyDataSetChanged();
        if (this.p) {
            return;
        }
        this.k.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.Is_refreshing));
        this.j.startAnimation(this.h);
        this.p = true;
        LogEx.d(this.f4271a, " StbSelectDialogNew scanDevices");
        com.zte.iptvclient.android.mobile.h.a.a.g().c();
        Timer timer = this.n;
        if (timer != null) {
            timer.cancel();
            this.n.purge();
            this.n = null;
        }
        Timer timer2 = new Timer();
        this.n = timer2;
        timer2.schedule(new g(), DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
    }

    private void a(View view) {
        this.f4274d = (ListView) view.findViewById(R.id.liststb);
        this.i = (LinearLayout) view.findViewById(R.id.refresh_llayout);
        this.j = (ImageView) view.findViewById(R.id.btn_refresh);
        this.k = (TextView) view.findViewById(R.id.txt_scan);
        this.l = (ImageView) view.findViewById(R.id.img_close);
        this.q = (TextView) view.findViewById(R.id.text_connect_stb);
        com.zte.iptvclient.common.uiframe.f.a(this.f4274d);
        com.zte.iptvclient.common.uiframe.f.a(this.i);
        com.zte.iptvclient.common.uiframe.f.a(this.l);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.remote_popup_llayout));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_stb_container));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.btn_refresh));
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.txt_scan));
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        this.q.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.connect_stb));
        this.k.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.batch_text));
    }

    public void a(h hVar) {
        r = hVar;
    }
}
