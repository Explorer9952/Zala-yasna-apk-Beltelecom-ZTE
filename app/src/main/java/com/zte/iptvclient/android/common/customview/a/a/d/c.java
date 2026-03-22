package com.zte.iptvclient.android.common.customview.a.a.d;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.video.androidsdk.cast.bean.DLNAEvent;
import com.video.androidsdk.cast.bean.Device;
import com.video.androidsdk.common.AndroidUniqueCode;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.zte.iptvclient.android.common.j.h;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* compiled from: MutiScreenStbDialog.java */
/* loaded from: classes.dex */
public class c extends PopupWindow {
    private static e o;

    /* renamed from: a, reason: collision with root package name */
    private String f4202a;

    /* renamed from: b, reason: collision with root package name */
    private Context f4203b;

    /* renamed from: c, reason: collision with root package name */
    private LayoutInflater f4204c;

    /* renamed from: d, reason: collision with root package name */
    private View f4205d;
    private int e;
    ListView f;
    f g;
    List<Device> h;
    private LinearLayout i;
    private TextView j;
    private TextView k;
    private TextView l;
    private h m;
    Handler n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MutiScreenStbDialog.java */
    /* loaded from: classes.dex */
    public class a extends Handler {
        a(c cVar) {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            super.handleMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MutiScreenStbDialog.java */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {

        /* compiled from: MutiScreenStbDialog.java */
        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.dismiss();
            }
        }

        /* compiled from: MutiScreenStbDialog.java */
        /* renamed from: com.zte.iptvclient.android.common.customview.a.a.d.c$b$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0119b implements Runnable {
            RunnableC0119b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.dismiss();
            }
        }

        /* compiled from: MutiScreenStbDialog.java */
        /* renamed from: com.zte.iptvclient.android.common.customview.a.a.d.c$b$c, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0120c implements Runnable {
            RunnableC0120c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.dismiss();
            }
        }

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.h.size() <= c.this.e) {
                new Handler().postDelayed(new a(), 200L);
                return;
            }
            c cVar = c.this;
            Device device = cVar.h.get(cVar.e);
            if (device == null) {
                new Handler().postDelayed(new RunnableC0119b(), 200L);
                return;
            }
            Device a2 = com.zte.iptvclient.android.mobile.h.a.a.g().a(device);
            if (a2 != null) {
                c.this.m.C(a2.getUDN());
            }
            c.this.g.notifyDataSetChanged();
            if (c.o != null) {
                c.o.c();
            }
            new Handler().postDelayed(new RunnableC0120c(), 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MutiScreenStbDialog.java */
    /* renamed from: com.zte.iptvclient.android.common.customview.a.a.d.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0121c implements View.OnClickListener {

        /* compiled from: MutiScreenStbDialog.java */
        /* renamed from: com.zte.iptvclient.android.common.customview.a.a.d.c$c$a */
        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.dismiss();
            }
        }

        ViewOnClickListenerC0121c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new Handler().postDelayed(new a(), 100L);
        }
    }

    /* compiled from: MutiScreenStbDialog.java */
    /* loaded from: classes.dex */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Message message = new Message();
            message.what = 1;
            c.this.n.sendMessage(message);
            c.this.g.notifyDataSetChanged();
        }
    }

    /* compiled from: MutiScreenStbDialog.java */
    /* loaded from: classes.dex */
    public interface e {
        void c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MutiScreenStbDialog.java */
    /* loaded from: classes.dex */
    public class f extends BaseAdapter {

        /* compiled from: MutiScreenStbDialog.java */
        /* loaded from: classes.dex */
        private class a {

            /* renamed from: a, reason: collision with root package name */
            TextView f4214a;

            /* renamed from: b, reason: collision with root package name */
            ImageView f4215b;

            private a(f fVar) {
            }

            /* synthetic */ a(f fVar, a aVar) {
                this(fVar);
            }
        }

        private f() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return c.this.h.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return c.this.h.get(i);
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
            if (c.this.h.size() == 0 || (device = c.this.h.get(i)) == null) {
                return null;
            }
            if (view == null) {
                aVar = new a(this, aVar2);
                view2 = LayoutInflater.from(c.this.f4203b).inflate(R.layout.remote_stbselect_item, (ViewGroup) null);
                view2.setBackground(c.this.f4203b.getResources().getDrawable(R.drawable.menu_bg));
                TextView textView = (TextView) view2.findViewById(R.id.remote_item_mac);
                ImageView imageView = (ImageView) view2.findViewById(R.id.remote_item_select);
                aVar.f4214a = textView;
                aVar.f4215b = imageView;
                view2.setTag(aVar);
            } else {
                view2 = view;
                aVar = (a) view.getTag();
            }
            String macAddress = device.getMacAddress();
            String friendlyName = device.getFriendlyName();
            if (friendlyName == null) {
                friendlyName = macAddress;
            }
            String udn = device.getUDN();
            if (friendlyName != null) {
                friendlyName = c.this.f4203b.getSharedPreferences("stbcachefile", 0).getString(udn, friendlyName);
            }
            aVar.f4214a.setText(friendlyName);
            Device b2 = com.zte.iptvclient.android.mobile.h.a.a.g().b();
            if (b2 != null && macAddress.equalsIgnoreCase(b2.getMacAddress())) {
                aVar.f4215b.setVisibility(0);
            } else {
                aVar.f4215b.setVisibility(4);
            }
            if (i == c.this.e) {
                aVar.f4215b.setVisibility(0);
            }
            return view2;
        }

        /* synthetic */ f(c cVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MutiScreenStbDialog.java */
    /* loaded from: classes.dex */
    public class g implements AdapterView.OnItemClickListener {
        private g() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            LogEx.d(c.this.f4202a, "sendUerNameAndDeviceIdToStb start");
            com.zte.iptvclient.android.mobile.h.a.a.g().a(SDKLoginMgr.getInstance().getUserID(), AndroidUniqueCode.getAndroidId(c.this.f4203b), c.this.m.U());
            c.this.e = i;
            c.this.g.notifyDataSetChanged();
        }

        /* synthetic */ g(c cVar, a aVar) {
            this();
        }
    }

    public c(Context context) {
        super(context);
        this.f4202a = "StbSelectDialogNew";
        this.n = new a(this);
        this.m = new h(context);
        this.f4203b = context;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f4204c = layoutInflater;
        View inflate = layoutInflater.inflate(R.layout.stb_select_dialog_mutiscreen, (ViewGroup) null);
        this.f4205d = inflate;
        setContentView(inflate);
        setWidth(-1);
        setHeight(-2);
        setBackgroundDrawable(new BitmapDrawable());
        setOutsideTouchable(true);
        setFocusable(true);
        setAnimationStyle(R.style.AnimBottom);
        d();
        c();
        e();
        b();
        EventBus.getDefault().register(this);
    }

    private void e() {
        f fVar = new f(this, null);
        this.g = fVar;
        this.f.setAdapter((ListAdapter) fVar);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        o = null;
        EventBus.getDefault().unregister(this);
        super.dismiss();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.l.b bVar) {
        LogEx.d(this.f4202a, "dlna event [" + bVar.a() + "]");
        String a2 = bVar.a();
        if (DLNAEvent.EVENT_DEVICE_ONLINE.equals(a2) || DLNAEvent.EVENT_DEVICE_OFFLINE.equals(a2)) {
            this.h.clear();
            for (Device device : com.zte.iptvclient.android.mobile.h.a.a.g().a()) {
                if (device != null) {
                    this.h.add(device);
                }
            }
            e eVar = o;
            if (eVar != null) {
                eVar.c();
            }
            this.f.postDelayed(new d(), 500L);
        }
    }

    private void b() {
        this.f.setOnItemClickListener(new g(this, null));
        this.j.setOnClickListener(new b());
        this.k.setOnClickListener(new ViewOnClickListenerC0121c());
    }

    private void c() {
        this.f = (ListView) this.f4205d.findViewById(R.id.liststb);
        this.i = (LinearLayout) this.f4205d.findViewById(R.id.confirm_layout);
        TextView textView = (TextView) this.f4205d.findViewById(R.id.stb_select_txt_ok);
        this.j = textView;
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_ok));
        TextView textView2 = (TextView) this.f4205d.findViewById(R.id.select_dialog_title);
        this.l = textView2;
        textView2.setText("请选择机顶盒后，重新摇一摇");
        TextView textView3 = (TextView) this.f4205d.findViewById(R.id.stb_select_txt_cancel);
        this.k = textView3;
        textView3.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_cancel));
        com.zte.iptvclient.common.uiframe.f.a(this.f);
        com.zte.iptvclient.common.uiframe.f.a(this.i);
        com.zte.iptvclient.common.uiframe.f.a(this.j);
        com.zte.iptvclient.common.uiframe.f.a(this.k);
        com.zte.iptvclient.common.uiframe.f.a(this.f4205d.findViewById(R.id.remote_popup_llayout));
        com.zte.iptvclient.common.uiframe.f.a(this.f4205d.findViewById(R.id.select_dialog_title));
    }

    private void d() {
        this.h = new ArrayList();
    }

    public void a(e eVar) {
        o = eVar;
    }

    public void a(String str) {
        this.l.setText(str);
    }
}
