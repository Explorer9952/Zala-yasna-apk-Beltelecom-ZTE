package com.zte.iptvclient.android.mobile.tv.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.video.androidsdk.log.LogEx;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.e.n.e;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.a0.a.d;
import com.zte.iptvclient.android.mobile.tv.ui.DragListView;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.ArrayList;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes2.dex */
public class ChannelSortActivity extends SupportActivity {
    private ImageView A;
    private RelativeLayout B;
    private d x;
    private DragListView y;
    private ArrayList<Channel> v = new ArrayList<>();
    private ArrayList<Channel> w = new ArrayList<>();
    private int z = 2;
    private String C = "ChannelSortActivity";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChannelSortActivity.this.u();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ChannelSortActivity.this.onBackPressed();
        }
    }

    private boolean t() {
        ArrayList<Channel> arrayList = this.w;
        if (arrayList == null || arrayList.size() == 0) {
            return false;
        }
        for (int i = 0; i < this.w.size(); i++) {
            if (this.w.get(i) != null && this.v.get(i) != null && !TextUtils.equals(this.w.get(i).getChannelcode(), this.v.get(i).getChannelcode())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        ArrayList<Channel> arrayList;
        boolean t = t();
        if (t && (arrayList = this.w) != null) {
            arrayList.clear();
            this.w.addAll(this.v);
            a(this.v);
        }
        EventBus.getDefault().post(new e(this.z, t, "LiveTvChannels"));
        finish();
    }

    @Override // com.zte.fragmentlib.SupportActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        u();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zte.fragmentlib.SupportActivity, com.zte.fragmentlib.publicbaseclass.skinloader.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.channel_sort);
        a((Activity) this);
        r();
        s();
    }

    public void r() {
        ArrayList<Channel> a2 = com.zte.iptvclient.android.common.j.b.e().a();
        if (a2 == null || a2.size() <= 0) {
            return;
        }
        this.w = a2;
        this.v.addAll(a2);
    }

    public void s() {
        TextView textView = (TextView) findViewById(R.id.title_txt);
        f.a(textView);
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.channel_title_text));
        TextView textView2 = (TextView) findViewById(R.id.detail_tips);
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.channel_sort_tips));
        f.a(textView2);
        this.y = (DragListView) findViewById(R.id.draglist);
        this.x = new d(this, this.v);
        ((TextView) findViewById(R.id.top)).setHeight(v.a((Context) this));
        ((TextView) findViewById(R.id.top)).setBackgroundColor(getResources().getColor(R.color.white));
        ImageView imageView = (ImageView) findViewById(R.id.img_close);
        this.A = imageView;
        imageView.setOnClickListener(new a());
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl_colse_img);
        this.B = relativeLayout;
        relativeLayout.setOnClickListener(new b());
        this.y.a(new c());
        this.y.setAdapter((ListAdapter) this.x);
    }

    private String a(ArrayList<Channel> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < arrayList.size(); i++) {
            Channel channel = arrayList.get(i);
            if (i == 0) {
                stringBuffer.append(channel.getMixno());
            } else {
                stringBuffer.append(";" + channel.getMixno());
            }
        }
        com.zte.iptvclient.android.common.j.b.e().a(stringBuffer.toString());
        LogEx.d(this.C, "生成的json串为:" + stringBuffer.toString());
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c extends DragListView.c {

        /* renamed from: a, reason: collision with root package name */
        private Rect f7263a = new Rect();

        /* renamed from: b, reason: collision with root package name */
        private boolean f7264b;

        c() {
        }

        @Override // com.zte.iptvclient.android.mobile.tv.ui.DragListView.b
        public boolean a(View view, int i, int i2) {
            View findViewById = view.findViewById(R.id.dl_plugin_move);
            if (findViewById != null && findViewById.getVisibility() == 0) {
                float a2 = i - com.zte.iptvclient.android.mobile.a0.c.c.a(view);
                float b2 = i2 - com.zte.iptvclient.android.mobile.a0.c.c.b(view);
                findViewById.getHitRect(this.f7263a);
                if (this.f7263a.contains((int) a2, (int) b2)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.zte.iptvclient.android.mobile.tv.ui.DragListView.b
        public void a(View view) {
            this.f7264b = view.isSelected();
            View findViewById = view.findViewById(R.id.dl_plugin_move);
            view.setSelected(true);
            if (findViewById != null) {
                findViewById.setSelected(true);
            }
        }

        @Override // com.zte.iptvclient.android.mobile.tv.ui.DragListView.b
        public Bitmap a(View view, Bitmap bitmap) {
            view.setSelected(this.f7264b);
            View findViewById = view.findViewById(R.id.dl_plugin_move);
            if (findViewById != null) {
                findViewById.setSelected(false);
            }
            return bitmap;
        }

        @Override // com.zte.iptvclient.android.mobile.tv.ui.DragListView.b
        public boolean a(int i, int i2) {
            return ChannelSortActivity.this.x.a(i, i2);
        }
    }

    public void a(Activity activity) {
        WindowManager.LayoutParams attributes;
        if (activity != null && Build.VERSION.SDK_INT >= 19) {
            Window window = activity.getWindow();
            if (Build.VERSION.SDK_INT >= 21) {
                if (window != null) {
                    window.getDecorView().setSystemUiVisibility(9216);
                    window.addFlags(Integer.MIN_VALUE);
                    window.setStatusBarColor(0);
                    return;
                }
                return;
            }
            if (window == null || (attributes = window.getAttributes()) == null) {
                return;
            }
            attributes.flags = 67108864 | attributes.flags;
            window.setAttributes(attributes);
        }
    }
}
