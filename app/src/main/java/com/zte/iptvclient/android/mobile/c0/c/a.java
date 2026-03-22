package com.zte.iptvclient.android.mobile.c0.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.zte.iptvclient.android.common.customview.a.a.e.f;
import com.zte.iptvclient.android.zala.R;
import java.util.List;

/* compiled from: AdapterMineMenu.java */
/* loaded from: classes2.dex */
public class a extends RecyclerView.g<c> {

    /* renamed from: c, reason: collision with root package name */
    private Context f5641c;

    /* renamed from: d, reason: collision with root package name */
    private List<com.zte.iptvclient.android.mobile.l.c.a.b> f5642d;
    private String e;
    private d g;
    private int h = -1;
    private com.zte.iptvclient.android.mobile.n.c.b f = com.zte.iptvclient.android.mobile.n.c.b.k();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdapterMineMenu.java */
    /* renamed from: com.zte.iptvclient.android.mobile.c0.c.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class ViewOnClickListenerC0199a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5643a;

        ViewOnClickListenerC0199a(int i) {
            this.f5643a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.g != null) {
                a.this.g.a(view, this.f5643a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdapterMineMenu.java */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {

        /* compiled from: AdapterMineMenu.java */
        /* renamed from: com.zte.iptvclient.android.mobile.c0.c.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0200a implements f.c {
            C0200a() {
            }

            @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
            public void a() {
                a.this.e();
            }

            @Override // com.zte.iptvclient.android.common.customview.a.a.e.f.c
            public void b() {
            }
        }

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.zte.iptvclient.android.common.k.c.a()) {
                return;
            }
            f fVar = new f(a.this.f5641c, -1, R.string.logout_confirm, R.drawable.lock_dialog_rightbg, R.string.common_confirm, 0, R.drawable.lock_dialog_leftbg, R.string.common_cancel, 0, new C0200a());
            fVar.a();
            fVar.setCanceledOnTouchOutside(false);
        }
    }

    /* compiled from: AdapterMineMenu.java */
    /* loaded from: classes2.dex */
    public static class c extends RecyclerView.b0 {
        private RelativeLayout t;
        private ImageView u;
        private TextView v;
        private TextView w;
        private TextView x;
        private Button y;

        public c(View view) {
            super(view);
            this.t = (RelativeLayout) view.findViewById(R.id.rlayout_mine_menu_item_root);
            this.u = (ImageView) view.findViewById(R.id.ivew_mine_menu_icon);
            this.x = (TextView) view.findViewById(R.id.txt_balance);
            TextView textView = (TextView) view.findViewById(R.id.txtvew_mine_menu_title);
            this.v = textView;
            textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.mine_login_or_register));
            this.w = (TextView) view.findViewById(R.id.vew_item_separator);
            Button button = (Button) view.findViewById(R.id.btn_loginout);
            this.y = button;
            button.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.account_logout));
            com.zte.iptvclient.common.uiframe.f.a(this.t);
            com.zte.iptvclient.common.uiframe.f.a(this.u);
            com.zte.iptvclient.common.uiframe.f.a(this.v);
            com.zte.iptvclient.common.uiframe.f.a(this.w);
            com.zte.iptvclient.common.uiframe.f.a(this.y);
        }
    }

    /* compiled from: AdapterMineMenu.java */
    /* loaded from: classes2.dex */
    public interface d {
        void a(View view, int i);
    }

    public a(Context context, List<com.zte.iptvclient.android.mobile.l.c.a.b> list, String str) {
        this.f5641c = context;
        this.f5642d = list;
        this.e = str;
    }

    public void e(int i) {
        this.h = i;
    }

    public void a(d dVar) {
        this.g = dVar;
    }

    public void e() {
        this.f.a(com.zte.iptvclient.android.common.c.e.a.f4112a);
        com.zte.iptvclient.android.common.f.a.a().cancel();
        this.f.h();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0105 A[Catch: Exception -> 0x01a2, TryCatch #0 {Exception -> 0x01a2, blocks: (B:2:0x0000, B:4:0x0043, B:7:0x0061, B:9:0x006b, B:10:0x0074, B:11:0x0098, B:13:0x00b8, B:15:0x00be, B:17:0x00c8, B:18:0x0101, B:20:0x0105, B:21:0x0178, B:23:0x0181, B:25:0x0187, B:26:0x019e, B:30:0x018f, B:31:0x0197, B:32:0x013f, B:33:0x00fa, B:34:0x007c, B:36:0x0086, B:37:0x0091), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0181 A[Catch: Exception -> 0x01a2, TryCatch #0 {Exception -> 0x01a2, blocks: (B:2:0x0000, B:4:0x0043, B:7:0x0061, B:9:0x006b, B:10:0x0074, B:11:0x0098, B:13:0x00b8, B:15:0x00be, B:17:0x00c8, B:18:0x0101, B:20:0x0105, B:21:0x0178, B:23:0x0181, B:25:0x0187, B:26:0x019e, B:30:0x018f, B:31:0x0197, B:32:0x013f, B:33:0x00fa, B:34:0x007c, B:36:0x0086, B:37:0x0091), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0197 A[Catch: Exception -> 0x01a2, TryCatch #0 {Exception -> 0x01a2, blocks: (B:2:0x0000, B:4:0x0043, B:7:0x0061, B:9:0x006b, B:10:0x0074, B:11:0x0098, B:13:0x00b8, B:15:0x00be, B:17:0x00c8, B:18:0x0101, B:20:0x0105, B:21:0x0178, B:23:0x0181, B:25:0x0187, B:26:0x019e, B:30:0x018f, B:31:0x0197, B:32:0x013f, B:33:0x00fa, B:34:0x007c, B:36:0x0086, B:37:0x0091), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x013f A[Catch: Exception -> 0x01a2, TryCatch #0 {Exception -> 0x01a2, blocks: (B:2:0x0000, B:4:0x0043, B:7:0x0061, B:9:0x006b, B:10:0x0074, B:11:0x0098, B:13:0x00b8, B:15:0x00be, B:17:0x00c8, B:18:0x0101, B:20:0x0105, B:21:0x0178, B:23:0x0181, B:25:0x0187, B:26:0x019e, B:30:0x018f, B:31:0x0197, B:32:0x013f, B:33:0x00fa, B:34:0x007c, B:36:0x0086, B:37:0x0091), top: B:1:0x0000 }] */
    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(com.zte.iptvclient.android.mobile.c0.c.a.c r8, int r9) {
        /*
            Method dump skipped, instructions count: 423
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.mobile.c0.c.a.b(com.zte.iptvclient.android.mobile.c0.c.a$c, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public c b(ViewGroup viewGroup, int i) {
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mine_menu_item, viewGroup, false));
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    private void b2(c cVar, int i) {
        cVar.t.setOnClickListener(new ViewOnClickListenerC0199a(i));
        cVar.y.setOnClickListener(new b());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int a() {
        List<com.zte.iptvclient.android.mobile.l.c.a.b> list = this.f5642d;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void a(List<com.zte.iptvclient.android.mobile.l.c.a.b> list, String str) {
        if (list != null) {
            this.f5642d = list;
            this.e = str;
        }
        d();
    }
}
