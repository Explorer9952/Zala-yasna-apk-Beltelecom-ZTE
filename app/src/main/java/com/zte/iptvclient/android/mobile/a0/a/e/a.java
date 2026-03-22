package com.zte.iptvclient.android.mobile.a0.a.e;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.d;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.video.androidsdk.log.LogEx;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.eventbus.multi.f;
import com.zte.iptvclient.android.common.f.b.i;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;
import org.greenrobot.eventbus.EventBus;

/* compiled from: AdapterRecycleTvChannel.java */
/* loaded from: classes2.dex */
public class a extends RecyclerView.g<RecyclerView.b0> {

    /* renamed from: d, reason: collision with root package name */
    private Activity f5328d;
    private ArrayList<Channel> e;
    private int f;
    private boolean i;
    private LayoutInflater j;

    /* renamed from: c, reason: collision with root package name */
    private String f5327c = a.class.getSimpleName();
    private int g = 0;
    private boolean h = false;

    /* compiled from: AdapterRecycleTvChannel.java */
    /* renamed from: com.zte.iptvclient.android.mobile.a0.a.e.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0170a extends RecyclerView.b0 {
        RelativeLayout t;
        View u;
        ImageView v;
        View w;
        ImageView x;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AdapterRecycleTvChannel.java */
        /* renamed from: com.zte.iptvclient.android.mobile.a0.a.e.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class ViewOnClickListenerC0171a implements View.OnClickListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f5329a;

            ViewOnClickListenerC0171a(int i) {
                this.f5329a = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LogEx.d(a.this.f5327c, "onClick");
                EventBus.getDefault().post(new f());
                EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.b(this.f5329a, a.this.h, a.this.i, ((Channel) a.this.e.get(this.f5329a)).getChannelcode()));
            }
        }

        public C0170a(View view) {
            super(view);
            this.t = (RelativeLayout) view.findViewById(R.id.rl_channel_item);
            this.u = view.findViewById(R.id.channel_left_line);
            this.v = (ImageView) view.findViewById(R.id.infImgTvItem);
            this.x = (ImageView) view.findViewById(R.id.imgTvLock);
            this.w = view.findViewById(R.id.divider_line);
            com.zte.iptvclient.common.uiframe.f.a(this.t);
            com.zte.iptvclient.common.uiframe.f.a(this.x);
            com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.channel_left_line));
            com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.rl_img_container));
            com.zte.iptvclient.common.uiframe.f.a(this.v);
            com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.divider_line));
        }

        public void c(int i) {
            if (a.this.f != 0) {
                if (a.this.g == i) {
                    this.t.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.multiplayer_channel_selected_dark));
                    ((SupportActivity) a.this.f5328d).a(this.t, TtmlNode.ATTR_TTS_BACKGROUND_COLOR, R.color.multiplayer_channel_selected_dark);
                    this.u.setVisibility(0);
                } else {
                    this.t.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.multiplayer_theme_bg_light));
                    ((SupportActivity) a.this.f5328d).a(this.t, TtmlNode.ATTR_TTS_BACKGROUND_COLOR, R.color.multiplayer_theme_bg_light);
                    this.u.setVisibility(4);
                }
            } else if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
                this.w.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.multiplayer_theme_dividerline_light));
                ((SupportActivity) a.this.f5328d).a(this.w, TtmlNode.ATTR_TTS_BACKGROUND_COLOR, R.color.multiplayer_theme_dividerline_light);
                this.u.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.tv_channel_leftline_color));
                ((SupportActivity) a.this.f5328d).a(this.u, TtmlNode.ATTR_TTS_BACKGROUND_COLOR, R.color.tv_channel_leftline_color);
                if (a.this.g == i) {
                    this.t.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.channel_child_select_bg));
                    ((SupportActivity) a.this.f5328d).a(this.t, TtmlNode.ATTR_TTS_BACKGROUND_COLOR, R.color.channel_child_select_bg);
                    this.u.setVisibility(4);
                } else {
                    this.t.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.channel_child_sort_bg));
                    ((SupportActivity) a.this.f5328d).a(this.t, TtmlNode.ATTR_TTS_BACKGROUND_COLOR, R.color.channel_child_sort_bg);
                    this.u.setVisibility(4);
                }
                this.w.setVisibility(8);
            } else {
                this.w.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.multiplayer_theme_dividerline_light));
                ((SupportActivity) a.this.f5328d).a(this.w, TtmlNode.ATTR_TTS_BACKGROUND_COLOR, R.color.multiplayer_theme_dividerline_light);
                this.u.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.tv_channel_leftline_color));
                ((SupportActivity) a.this.f5328d).a(this.u, TtmlNode.ATTR_TTS_BACKGROUND_COLOR, R.color.tv_channel_leftline_color);
                if (a.this.g == i) {
                    this.t.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.multiplayer_channel_leftline_light));
                    ((SupportActivity) a.this.f5328d).a(this.t, TtmlNode.ATTR_TTS_BACKGROUND_COLOR, R.color.multiplayer_channel_leftline_light);
                    this.u.setVisibility(0);
                } else {
                    this.t.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.multiplayer_theme_bg_light));
                    ((SupportActivity) a.this.f5328d).a(this.t, TtmlNode.ATTR_TTS_BACKGROUND_COLOR, R.color.multiplayer_theme_bg_light);
                    this.u.setVisibility(4);
                }
            }
            this.t.setOnClickListener(new ViewOnClickListenerC0171a(i));
            String posterimage = ((Channel) a.this.e.get(i)).getPosterimage();
            if (!TextUtils.isEmpty(posterimage)) {
                int indexOf = posterimage.indexOf("/image", 1);
                String str = i.g() + posterimage.substring(indexOf);
                if (a.this.f5328d != null && !a.this.f5328d.isFinishing()) {
                    d<String> a2 = com.bumptech.glide.i.a(a.this.f5328d).a(str);
                    a2.a(R.drawable.default_video_thumb);
                    a2.b(126, 94);
                    a2.a(this.v);
                    LogEx.d(a.this.f5327c, "imgTvLogo url = " + str);
                } else {
                    this.v.setImageResource(R.drawable.default_video_thumb);
                }
            } else {
                this.v.setImageResource(R.drawable.default_video_thumb);
            }
            if (!"1".equals(((Channel) a.this.e.get(i)).getIsChannelLock()) && !"1".equals(((Channel) a.this.e.get(i)).getSystemlimitenable())) {
                this.x.setVisibility(8);
            } else {
                this.x.setVisibility(0);
            }
        }
    }

    public a(Activity activity, ArrayList<Channel> arrayList, int i, boolean z) {
        this.f = 0;
        this.i = false;
        this.f5328d = activity;
        this.e = arrayList;
        this.f = i;
        this.i = z;
        this.j = LayoutInflater.from(activity);
    }

    public void a(ArrayList<Channel> arrayList) {
        this.e = arrayList;
    }

    public void b(boolean z) {
        this.h = z;
    }

    public void e(int i) {
        this.g = i;
        a(0, this.e.size() + 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int a() {
        ArrayList<Channel> arrayList = this.e;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.b0 b(ViewGroup viewGroup, int i) {
        if (BaseApp.a(this.f5328d)) {
            return new C0170a(this.j.inflate(R.layout.live_tv_channel_item_hd, viewGroup, false));
        }
        if (com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a()) {
            return new C0170a(this.j.inflate(R.layout.child_livetv_channel_item, viewGroup, false));
        }
        return new C0170a(this.j.inflate(R.layout.livetv_channel_item, viewGroup, false));
    }

    public ArrayList<Channel> e() {
        return this.e;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void b(RecyclerView.b0 b0Var, int i) {
        ((C0170a) b0Var).c(i);
    }
}
