package com.zte.iptvclient.android.common.player;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.player.IBasePlayer;
import com.video.androidsdk.player.common.AssetStatus;
import com.video.androidsdk.player.common.AssetType;
import com.zte.iptvclient.android.common.player.i.b;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;

/* compiled from: AssetPopwindow.java */
/* loaded from: classes.dex */
public class b extends PopupWindow {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<String> f4862a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<String> f4863b;

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<String> f4864c;

    /* renamed from: d, reason: collision with root package name */
    private int f4865d;
    private int e;
    private int f;
    private int g;
    private Context h;
    private IBasePlayer i;
    private ListView j;
    private TextView k;
    private View l;
    private com.zte.iptvclient.android.common.player.i.b m;
    private com.zte.iptvclient.android.common.player.i.b n;
    private com.zte.iptvclient.android.common.player.i.b o;
    private View p;
    private c q;
    private d r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AssetPopwindow.java */
    /* loaded from: classes.dex */
    public class a implements b.InterfaceC0146b {
        a() {
        }

        @Override // com.zte.iptvclient.android.common.player.i.b.InterfaceC0146b
        public void a(int i, View view) {
            if (b.this.i == null) {
                return;
            }
            b.this.f4865d = i;
            if (b.this.i.selectVideoByIndex(b.this.f4865d)) {
                b.this.m.a(b.this.f4865d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AssetPopwindow.java */
    /* renamed from: com.zte.iptvclient.android.common.player.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0142b implements b.InterfaceC0146b {
        C0142b() {
        }

        @Override // com.zte.iptvclient.android.common.player.i.b.InterfaceC0146b
        public void a(int i, View view) {
            if (b.this.i == null) {
                LogEx.e("AssetPopwindow", "+++ mPlayer is null! +++");
                return;
            }
            b.this.e = i;
            b.this.i.selectAudioByIndex(b.this.e);
            b.this.n.a(b.this.e);
            b.this.q.a((String) b.this.f4863b.get(b.this.e));
        }
    }

    /* compiled from: AssetPopwindow.java */
    /* loaded from: classes.dex */
    public interface c {
        void a(String str);
    }

    /* compiled from: AssetPopwindow.java */
    /* loaded from: classes.dex */
    public interface d {
        void a(int i, String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AssetPopwindow.java */
    /* loaded from: classes.dex */
    public class e implements b.InterfaceC0146b {
        private e() {
        }

        @Override // com.zte.iptvclient.android.common.player.i.b.InterfaceC0146b
        public void a(int i, View view) {
            if (b.this.i == null) {
                LogEx.e("AssetPopwindow", "mPlayer is null!");
                return;
            }
            b.this.f = i;
            if (b.this.f < 0 || b.this.f >= b.this.f4864c.size() - 1) {
                if (b.this.f == b.this.f4864c.size() - 1) {
                    LogEx.d("AssetPopwindow", ">>>enableSubtitle(false)");
                    b.this.i.enableSubtitle(false);
                    b.this.o.a(b.this.f);
                    b.this.r.a(b.this.f, (String) b.this.f4864c.get(b.this.f));
                    return;
                }
                LogEx.e("AssetPopwindow", ">>>Subtitle exception!");
                return;
            }
            LogEx.d("AssetPopwindow", ">>>enableSubtitle(true)");
            b.this.i.enableSubtitle(true);
            b.this.i.selectSubtitleByIndex(b.this.f);
            b.this.o.a(b.this.f);
            b.this.r.a(b.this.f, (String) b.this.f4864c.get(b.this.f));
        }

        /* synthetic */ e(b bVar, a aVar) {
            this();
        }
    }

    public b(Context context, IBasePlayer iBasePlayer) {
        super(context);
        this.f4862a = new ArrayList<>();
        this.f4863b = new ArrayList<>();
        this.f4864c = new ArrayList<>();
        this.f4865d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.i = null;
        this.h = context;
        this.i = iBasePlayer;
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.player_asset_list, (ViewGroup) null);
        this.l = inflate;
        this.j = (ListView) inflate.findViewById(R.id.asset_list);
        this.k = (TextView) this.l.findViewById(R.id.asset_title);
        com.zte.iptvclient.common.uiframe.f.a(this.l);
        com.zte.iptvclient.common.uiframe.f.a(this.k);
        com.zte.iptvclient.common.uiframe.f.a(this.j);
        setContentView(this.l);
        setWidth(-2);
        setHeight(-2);
        setSoftInputMode(1);
        setBackgroundDrawable(new BitmapDrawable());
        setOutsideTouchable(true);
        setFocusable(true);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        View view = this.p;
        if (view != null) {
            view.setFitsSystemWindows(false);
        }
    }

    public void a(View view, int i, int i2, int i3, AssetType assetType) {
        this.p = view;
        if (AssetType.Asset_Video == assetType) {
            this.k.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.play_activity_subtitle));
            c();
        }
        if (AssetType.Asset_Audio == assetType) {
            this.k.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.play_activity_audio));
            a();
        } else if (AssetType.Asset_Subtitle == assetType) {
            this.k.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.play_activity_subtitle));
            b();
        }
        View view2 = this.p;
        if (view2 != null) {
            view2.setFitsSystemWindows(true);
        }
        showAtLocation(view, i, i2, i3);
    }

    public void b() {
        LogEx.d("AssetPopwindow", "+++ updateSubTitleInfo +++");
        if (this.i == null) {
            return;
        }
        this.f4864c.clear();
        b(this.f4864c);
        this.f4864c.add(this.h.getResources().getString(R.string.text_disable));
        int i = this.g;
        if (i != this.f) {
            this.f = i;
        }
        LogEx.d("AssetPopwindow", "Multitrack  --- mSelectedSubtitleIndex: " + this.f4865d);
        if (this.f4864c.size() <= 1) {
            this.f = 0;
            this.i.enableSubtitle(false);
            LogEx.d("AssetPopwindow", ">>>enableSubtitle(false)");
        } else if (this.f < this.f4864c.size()) {
            if (TextUtils.equals(this.h.getResources().getString(R.string.text_disable), this.f4864c.get(this.f))) {
                this.i.enableSubtitle(false);
                LogEx.d("AssetPopwindow", ">>>enableSubtitle(false)");
            } else {
                this.i.enableSubtitle(true);
                LogEx.d("AssetPopwindow", ">>>enableSubtitle(true)");
            }
        }
        LogEx.d("AssetPopwindow", ">>>mSelectedSubtitleIndex " + this.f);
        com.zte.iptvclient.android.common.player.i.b bVar = new com.zte.iptvclient.android.common.player.i.b(this.h, this.j, this.f4864c, this.f);
        this.o = bVar;
        bVar.a(new e(this, null));
        this.j.setAdapter((ListAdapter) this.o);
    }

    public void c() {
        LogEx.d("AssetPopwindow", "+++ updateVideoInfo +++");
        if (this.i == null) {
            return;
        }
        this.f4862a.clear();
        c(this.f4862a);
        com.zte.iptvclient.android.common.player.i.b bVar = new com.zte.iptvclient.android.common.player.i.b(this.h, this.j, this.f4862a, this.f4865d);
        this.m = bVar;
        bVar.a(new a());
        this.j.setAdapter((ListAdapter) this.m);
        LogEx.d("AssetPopwindow", "+++ updateVideoInfo +++");
    }

    private void c(ArrayList<String> arrayList) {
        IBasePlayer iBasePlayer;
        if (arrayList == null || (iBasePlayer = this.i) == null) {
            return;
        }
        iBasePlayer.getVideoInfoArray(arrayList);
        this.f4865d = this.i.getAssetIndex(AssetType.Asset_Video, AssetStatus.Asset_Playing);
        LogEx.d("AssetPopwindow", "Multitrack getVideoInfoArray --- default: " + arrayList);
        LogEx.d("AssetPopwindow", "Multitrack getVideoDescription --- default: " + this.f4865d);
    }

    public void a() {
        LogEx.d("AssetPopwindow", "+++ updateAudioInfo +++");
        if (this.i == null) {
            return;
        }
        this.f4863b.clear();
        a(this.f4863b);
        com.zte.iptvclient.android.common.player.i.b bVar = new com.zte.iptvclient.android.common.player.i.b(this.h, this.j, this.f4863b, this.e);
        this.n = bVar;
        bVar.a(new C0142b());
        this.j.setAdapter((ListAdapter) this.n);
        LogEx.d("AssetPopwindow", "+++ updateAudioInfo +++");
    }

    public void a(int i) {
        this.g = i;
    }

    private void a(ArrayList<String> arrayList) {
        IBasePlayer iBasePlayer;
        if (arrayList == null || (iBasePlayer = this.i) == null) {
            return;
        }
        iBasePlayer.getAudioInfoArray(arrayList);
        this.e = this.i.getAssetIndex(AssetType.Asset_Audio, AssetStatus.Asset_Playing);
        LogEx.d("AssetPopwindow", "Multitrack+++Mulit getAudioInfoArray --- default: " + arrayList + " size=" + arrayList.size());
        StringBuilder sb = new StringBuilder();
        sb.append("Multitrack getAudioDescription --- default: ");
        sb.append(this.e);
        LogEx.d("AssetPopwindow", sb.toString());
    }

    private void b(ArrayList<String> arrayList) {
        IBasePlayer iBasePlayer;
        if (arrayList == null || (iBasePlayer = this.i) == null) {
            return;
        }
        iBasePlayer.getSubtitleInfoArray(arrayList);
        this.f = this.i.getAssetIndex(AssetType.Asset_Subtitle, AssetStatus.Asset_Playing);
        LogEx.d("AssetPopwindow", "Multitrack getAudioDescription --- default: " + arrayList);
        LogEx.d("AssetPopwindow", "Multitrack getSubtitleDescription --- mSelectedSubtitleIndex: " + this.f4865d);
    }

    public void a(c cVar) {
        this.q = cVar;
    }

    public void a(d dVar) {
        this.r = dVar;
    }
}
