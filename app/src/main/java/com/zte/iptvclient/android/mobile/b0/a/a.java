package com.zte.iptvclient.android.mobile.b0.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.d;
import com.video.androidsdk.common.util.StringUtil;
import com.zte.iptvclient.android.common.e.x.e;
import com.zte.iptvclient.android.common.javabean.models.i;
import com.zte.iptvclient.android.mobile.home.tab.helper.TabHostManager;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

/* compiled from: AdapterTvHistory.java */
/* loaded from: classes2.dex */
public class a extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    List<i> f5561a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private boolean f5562b = false;

    /* renamed from: c, reason: collision with root package name */
    private List<i> f5563c;

    /* renamed from: d, reason: collision with root package name */
    private com.zte.iptvclient.android.mobile.b0.b.a f5564d;
    private LayoutInflater e;

    /* compiled from: AdapterTvHistory.java */
    /* renamed from: com.zte.iptvclient.android.mobile.b0.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class ViewOnClickListenerC0188a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f5565a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f5566b;

        /* compiled from: AdapterTvHistory.java */
        /* renamed from: com.zte.iptvclient.android.mobile.b0.a.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class RunnableC0189a implements Runnable {
            RunnableC0189a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                EventBus.getDefault().post(new e(ViewOnClickListenerC0188a.this.f5565a.a(), ""));
            }
        }

        ViewOnClickListenerC0188a(i iVar, b bVar) {
            this.f5565a = iVar;
            this.f5566b = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!a.this.f5562b) {
                a.this.f5564d.getActivity().finish();
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.n.a(TabHostManager.TabName.TV));
                view.postDelayed(new RunnableC0189a(), 500L);
                return;
            }
            if (a.this.f5561a.contains(this.f5565a)) {
                a.this.f5561a.remove(this.f5565a);
                this.f5566b.f.setBackgroundResource(R.drawable.icon_last_watch_unselect);
            } else {
                a.this.f5561a.add(this.f5565a);
                this.f5566b.f.setBackgroundResource(R.drawable.icon_last_watch_selected);
            }
            a.this.f();
            a.this.f5564d.O();
            a.this.f5564d.N();
        }
    }

    /* compiled from: AdapterTvHistory.java */
    /* loaded from: classes2.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        TextView f5569a;

        /* renamed from: b, reason: collision with root package name */
        TextView f5570b;

        /* renamed from: c, reason: collision with root package name */
        TextView f5571c;

        /* renamed from: d, reason: collision with root package name */
        RelativeLayout f5572d;
        ImageView e;
        ImageView f;
        ImageView g;

        private b() {
        }

        /* synthetic */ b(ViewOnClickListenerC0188a viewOnClickListenerC0188a) {
            this();
        }
    }

    public a(com.zte.iptvclient.android.mobile.b0.b.a aVar, List<i> list) {
        this.f5563c = list;
        this.f5564d = aVar;
        if (aVar.getActivity() != null) {
            this.e = (LayoutInflater) aVar.getActivity().getSystemService("layout_inflater");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f5563c.size();
        this.f5561a.size();
    }

    public List<i> d() {
        return this.f5563c;
    }

    public void e() {
        this.f5561a = new ArrayList(this.f5563c);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<i> list = this.f5563c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<i> list = this.f5563c;
        if (list != null && list.size() > i) {
            return this.f5563c.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        b bVar;
        if (view == null) {
            bVar = new b(null);
            view2 = this.e.inflate(R.layout.item_layout_tv_history, (ViewGroup) null);
            bVar.f5572d = (RelativeLayout) view2.findViewById(R.id.rl_content);
            bVar.f5569a = (TextView) view2.findViewById(R.id.tv_channel);
            bVar.f5571c = (TextView) view2.findViewById(R.id.tv_time);
            bVar.e = (ImageView) view2.findViewById(R.id.iv_poster);
            bVar.f = (ImageView) view2.findViewById(R.id.iv_select);
            bVar.g = (ImageView) view2.findViewById(R.id.iv_now);
            bVar.f5570b = (TextView) view2.findViewById(R.id.tv_programme);
            f.a(bVar.f5572d);
            f.a(bVar.f5569a);
            f.a(bVar.f5571c);
            f.a(bVar.e);
            f.a(bVar.f);
            f.a(bVar.g);
            f.a(bVar.f5570b);
            view2.setTag(bVar);
        } else {
            view2 = view;
            bVar = (b) view.getTag();
        }
        i iVar = this.f5563c.get(i);
        bVar.f5572d.setOnClickListener(new ViewOnClickListenerC0188a(iVar, bVar));
        if (iVar != null) {
            bVar.f5569a.setText(StringUtil.isEmptyString(iVar.b()) ? "" : iVar.b());
            d<String> a2 = com.bumptech.glide.i.a(this.f5564d).a(iVar.d());
            a2.a(R.drawable.default_poster_thumb);
            a2.a(bVar.e);
            bVar.f.setVisibility(this.f5562b ? 0 : 8);
            bVar.f.setBackgroundResource(this.f5561a.contains(iVar) ? R.drawable.icon_last_watch_selected : R.drawable.icon_last_watch_unselect);
            bVar.f5571c.setText(iVar.f());
            bVar.f5570b.setText(iVar.e());
        }
        return view2;
    }

    public void a() {
        this.f5561a.clear();
        notifyDataSetChanged();
    }

    public int b() {
        List<i> list = this.f5561a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<i> c() {
        return this.f5561a;
    }

    public void a(boolean z) {
        this.f5562b = z;
        if (z) {
            this.f5561a.clear();
        }
        notifyDataSetChanged();
    }

    public void a(List<i> list) {
        this.f5563c = list;
        this.f5561a.clear();
        notifyDataSetChanged();
    }
}
