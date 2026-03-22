package com.zte.iptvclient.android.mobile.user.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.video.androidsdk.common.AndroidUniqueCode;
import com.video.androidsdk.common.GlobalConst;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.SDKUserMgr4CELLC;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.k.b;
import com.zte.iptvclient.android.zala.R;
import com.zte.sdk.enumclass.CapablityEnum;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: BtTerminalBindingAdapter.java */
/* loaded from: classes2.dex */
public class e extends RecyclerView.g {

    /* renamed from: d, reason: collision with root package name */
    private Context f7435d;
    private LayoutInflater e;
    private ArrayList<TerminalBindList> f;
    private String g;

    /* renamed from: c, reason: collision with root package name */
    private String f7434c = "BtTerminalBindingAdapter";
    SDKUserMgr4CELLC h = new SDKUserMgr4CELLC();

    /* compiled from: BtTerminalBindingAdapter.java */
    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f7436a;

        a(c cVar) {
            this.f7436a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LogEx.d(e.this.f7434c, "Unbunding onClick");
            e.this.b((String) this.f7436a.y.getTag());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BtTerminalBindingAdapter.java */
    /* loaded from: classes2.dex */
    public class b implements b.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f7438a;

        /* compiled from: BtTerminalBindingAdapter.java */
        /* loaded from: classes2.dex */
        class a implements SDKUserMgr4CELLC.OnUnbindTerminalDeviceReturnListener {
            a() {
            }

            @Override // com.video.androidsdk.service.SDKUserMgr4CELLC.OnUnbindTerminalDeviceReturnListener
            public void onUnbindTerminalDeviceReturn(String str, String str2) {
                if ("0".equals(str)) {
                    b bVar = b.this;
                    int a2 = e.this.a(bVar.f7438a);
                    if (a2 < 0 || a2 >= e.this.f.size()) {
                        return;
                    }
                    e.this.f.remove(a2);
                    e.this.d();
                    com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.unbunding_success_info));
                    return;
                }
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(com.zte.iptvclient.android.common.i.a.a.a(R.string.feature_unbind_fail));
            }
        }

        b(String str) {
            this.f7438a = str;
        }

        @Override // com.zte.iptvclient.android.common.k.b.d
        public void a() {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("binddeviceid", this.f7438a);
            e.this.h.unbindTerminalDevice(hashMap, new a());
        }

        @Override // com.zte.iptvclient.android.common.k.b.d
        public void b() {
        }
    }

    /* compiled from: BtTerminalBindingAdapter.java */
    /* loaded from: classes2.dex */
    public static class c extends RecyclerView.b0 {
        private ImageView t;
        private ImageView u;
        private TextView v;
        private TextView w;
        private TextView x;
        private TextView y;

        public c(View view) {
            super(view);
            this.t = (ImageView) view.findViewById(R.id.unbunding_local_img1);
            this.u = (ImageView) view.findViewById(R.id.unbunding_local_img2);
            this.v = (TextView) view.findViewById(R.id.unbunding_info_device_id_text);
            this.w = (TextView) view.findViewById(R.id.unbunding_info_model_text);
            this.x = (TextView) view.findViewById(R.id.unbunding_info_type_text);
            this.y = (TextView) view.findViewById(R.id.unbunding_btn_text);
            com.zte.iptvclient.common.uiframe.f.a(this.t);
            com.zte.iptvclient.common.uiframe.f.a(this.u);
            com.zte.iptvclient.common.uiframe.f.a(this.v);
            com.zte.iptvclient.common.uiframe.f.a(this.w);
            com.zte.iptvclient.common.uiframe.f.a(this.x);
            com.zte.iptvclient.common.uiframe.f.a(this.y);
        }
    }

    public e(Context context, ArrayList<TerminalBindList> arrayList) {
        this.f7435d = context;
        this.e = LayoutInflater.from(context);
        this.f = arrayList;
        this.g = AndroidUniqueCode.getAndroidId(context);
        AndroidUniqueCode.getDeviceMacAddress(context);
    }

    private void a(TextView textView, int i) {
        textView.setTextSize(2, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.b0 b(ViewGroup viewGroup, int i) {
        return new c(this.e.inflate(R.layout.bt_terminal_bunding_item, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int a() {
        ArrayList<TerminalBindList> arrayList = this.f;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(String str) {
        for (int i = 0; i < this.f.size(); i++) {
            if (this.f.get(i).a().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void b(RecyclerView.b0 b0Var, int i) {
        c cVar = (c) b0Var;
        TerminalBindList terminalBindList = this.f.get(i);
        String a2 = terminalBindList.a();
        String b2 = terminalBindList.b();
        terminalBindList.e();
        String c2 = terminalBindList.c();
        if (a2 == null) {
            a2 = "unknow";
        }
        if (c2 == null) {
            c2 = "unknow";
        }
        String d2 = terminalBindList.d();
        StringBuilder sb = new StringBuilder();
        sb.append(com.zte.iptvclient.android.common.i.a.a.a(R.string.terminal_device_id));
        sb.append(": ");
        sb.append(d2);
        cVar.v.setText(sb);
        cVar.w.setText(c2.replace(CapablityEnum.SPLIT_CODE, " "));
        cVar.y.setTag(a2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cVar.u.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        if (d2 == null || !d2.equalsIgnoreCase(this.g)) {
            cVar.u.setVisibility(4);
            layoutParams.topMargin = 0;
            layoutParams.height = 0;
            cVar.u.requestLayout();
            cVar.y.setVisibility(0);
        } else {
            cVar.u.setVisibility(0);
            layoutParams.topMargin = 10;
            layoutParams.height = -2;
            cVar.u.requestLayout();
            cVar.y.setVisibility(8);
        }
        if ("1".equals(b2)) {
            cVar.t.setImageResource(R.drawable.icon_stb);
        } else if ("2".equals(b2)) {
            cVar.t.setImageResource(R.drawable.icon_smartphoneicon);
        } else if ("4".equals(b2)) {
            cVar.t.setImageResource(R.drawable.icon_pc);
        } else if ("8".equals(b2)) {
            cVar.t.setImageResource(R.drawable.icon_pad);
        } else if (GlobalConst.WINPHONE_CLIENT.equals(b2)) {
            cVar.t.setImageResource(R.drawable.icon_tv);
        }
        if (BaseApp.a(this.f7435d)) {
            a(cVar.v, 15);
            a(cVar.w, 14);
            a(cVar.x, 14);
            a(cVar.y, 14);
        }
        cVar.y.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.terminal_unbinding));
        cVar.y.setOnClickListener(new a(cVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        com.zte.iptvclient.android.common.k.b.a(this.f7435d, com.zte.iptvclient.android.common.i.a.a.a(R.string.terminal_binding_title), new b(str));
    }
}
