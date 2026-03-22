package com.zte.iptvclient.android.mobile.tv.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.log.LogEx;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.customview.viewgroup.gridview.draggridview.DragGridView;
import com.zte.iptvclient.android.common.e.n.e;
import com.zte.iptvclient.android.common.j.j;
import com.zte.iptvclient.android.common.j.k;
import com.zte.iptvclient.android.common.javabean.column.ColumnBean;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.ArrayList;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes2.dex */
public class ColumnSortActivity extends SupportActivity {
    private TextView D;
    private TextView E;
    private DragGridView v;
    private com.zte.iptvclient.android.mobile.l.a.c w;
    private ImageView x;
    private RelativeLayout y;
    private ArrayList<ColumnBean> z = new ArrayList<>();
    private ArrayList<ColumnBean> A = new ArrayList<>();
    private int B = 3;
    private String C = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ColumnSortActivity.this.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ColumnSortActivity.this.t();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements AdapterView.OnItemClickListener {
        c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ColumnSortActivity.this.v.a(i);
            if ("1".equals(ConfigMgr.readPropertie("isShowSub"))) {
                ColumnSortActivity.this.B = i + 3;
            } else {
                ColumnSortActivity.this.B = i + 1;
            }
            ColumnSortActivity.this.t();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements AdapterView.OnItemLongClickListener {
        d() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            ((Vibrator) ColumnSortActivity.this.getApplicationContext().getSystemService("vibrator")).vibrate(50L);
            ColumnSortActivity.this.v.b(i);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        ArrayList<ColumnBean> arrayList;
        boolean u = u();
        if (u && (arrayList = this.z) != null) {
            arrayList.clear();
            this.z.addAll(this.A);
            a(this.z);
        }
        EventBus.getDefault().post(new e(this.B, u, this.C));
        finish();
    }

    private boolean u() {
        ArrayList<ColumnBean> arrayList = this.z;
        if (arrayList == null || arrayList.size() == 0) {
            return false;
        }
        for (int i = 0; i < this.z.size(); i++) {
            if (this.z.get(i) != null && this.A.get(i) != null && !TextUtils.equals(this.z.get(i).getColumnCode(), this.A.get(i).getColumnCode())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.zte.fragmentlib.SupportActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        t();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zte.fragmentlib.SupportActivity, com.zte.fragmentlib.publicbaseclass.skinloader.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.column_sort);
        a((Activity) this);
        Intent intent = getIntent();
        if (intent != null) {
            this.C = intent.getStringExtra("From");
        }
        if ("0".equals(ConfigMgr.readPropertie("isShowSub"))) {
            this.B = 0;
        }
        r();
        s();
    }

    public void r() {
        f.a((RelativeLayout) findViewById(R.id.actions_bar));
        TextView textView = (TextView) findViewById(R.id.txt_title);
        this.D = textView;
        f.a(textView);
        this.E = (TextView) findViewById(R.id.tips);
        f.a(findViewById(R.id.detail_control));
        f.a(this.E);
        String str = this.C;
        if (str != null && str.equalsIgnoreCase("LiveTvFragment")) {
            this.z = j.e().a();
            this.D.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.sort_title_text));
            this.E.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.sort_longpress_tips));
        } else {
            String str2 = this.C;
            if (str2 != null && str2.equalsIgnoreCase("VideoFragment")) {
                this.z = k.i().c();
                this.D.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.video_column_sort_title));
                this.E.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.video_sort_longpress_tips));
            }
        }
        ArrayList<ColumnBean> arrayList = this.z;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        this.A.addAll(this.z);
        String str3 = this.C;
        if (str3 == null || !str3.equalsIgnoreCase("LiveTvFragment")) {
            return;
        }
        if (!"1".equals(ConfigMgr.readPropertie("isShowSub"))) {
            this.A.remove(0);
            return;
        }
        for (int i = 0; i < 3; i++) {
            this.A.remove(0);
        }
    }

    public void s() {
        DragGridView dragGridView = (DragGridView) findViewById(R.id.tv_column_grid);
        this.v = dragGridView;
        f.a(dragGridView);
        ((TextView) findViewById(R.id.top)).setHeight(v.a((Context) this));
        findViewById(R.id.top).setBackgroundColor(Color.parseColor("#ffffff"));
        ImageView imageView = (ImageView) findViewById(R.id.img_close);
        this.x = imageView;
        f.a(imageView);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl_colse_img);
        this.y = relativeLayout;
        relativeLayout.setOnClickListener(new a());
        this.x.setOnClickListener(new b());
        com.zte.iptvclient.android.mobile.l.a.c cVar = new com.zte.iptvclient.android.mobile.l.a.c(this, this.A);
        this.w = cVar;
        this.v.setAdapter((ListAdapter) cVar);
        this.v.setOnItemClickListener(new c());
        this.v.setOnItemLongClickListener(new d());
    }

    private String a(ArrayList<ColumnBean> arrayList) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            ColumnBean columnBean = arrayList.get(i);
            if (i == arrayList.size() - 3) {
                sb.append(columnBean.getColumnCode());
            } else {
                sb.append(columnBean.getColumnCode());
                sb.append(";");
            }
        }
        String sb2 = sb.toString();
        String str = this.C;
        if (str != null && str.equalsIgnoreCase("LiveTvFragment")) {
            j.e().a(sb2);
        } else {
            String str2 = this.C;
            if (str2 != null && str2.equalsIgnoreCase("VideoFragment")) {
                k.i().a(sb2);
            }
        }
        LogEx.d("SortColumnFragment", "生成的json串为:" + ((Object) sb) + "   " + arrayList.get(0).getPosterfilelist());
        return sb2;
    }

    public void a(Activity activity) {
        int i;
        WindowManager.LayoutParams attributes;
        if (activity != null && (i = Build.VERSION.SDK_INT) >= 19) {
            if (i >= 21) {
                Window window = activity.getWindow();
                if (window != null) {
                    window.getDecorView().setSystemUiVisibility(9216);
                    window.addFlags(Integer.MIN_VALUE);
                    window.setStatusBarColor(0);
                    return;
                }
                return;
            }
            Window window2 = activity.getWindow();
            if (window2 == null || (attributes = window2.getAttributes()) == null) {
                return;
            }
            attributes.flags = 67108864 | attributes.flags;
            window2.setAttributes(attributes);
        }
    }
}
