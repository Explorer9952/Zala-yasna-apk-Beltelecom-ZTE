package com.zte.iptvclient.android.mobile.n.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.d;
import com.zte.iptvclient.common.uiframe.f;
import java.util.ArrayList;

/* compiled from: AdapterLoginAccount.java */
/* loaded from: classes.dex */
public class a extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<String> f6770a;

    /* renamed from: b, reason: collision with root package name */
    private LayoutInflater f6771b;

    /* renamed from: c, reason: collision with root package name */
    private com.zte.iptvclient.android.common.g.b f6772c;

    /* renamed from: d, reason: collision with root package name */
    private long f6773d = 0;

    /* compiled from: AdapterLoginAccount.java */
    /* renamed from: com.zte.iptvclient.android.mobile.n.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class ViewOnClickListenerC0306a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f6774a;

        ViewOnClickListenerC0306a(int i) {
            this.f6774a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.a() || a.this.f6772c == null) {
                return;
            }
            a.this.f6772c.b(this.f6774a);
        }
    }

    /* compiled from: AdapterLoginAccount.java */
    /* loaded from: classes.dex */
    static class b extends d {

        /* renamed from: a, reason: collision with root package name */
        RelativeLayout f6776a;

        /* renamed from: b, reason: collision with root package name */
        TextView f6777b;

        /* renamed from: c, reason: collision with root package name */
        ImageView f6778c;

        b() {
        }
    }

    public a(Context context, ArrayList<String> arrayList) {
        this.f6770a = arrayList;
        this.f6771b = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<String> arrayList = this.f6770a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList<String> arrayList = this.f6770a;
        if (arrayList == null) {
            return null;
        }
        return arrayList.get(i);
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
            bVar = new b();
            view2 = this.f6771b.inflate(R.layout.login_accounts_list_item, (ViewGroup) null);
            bVar.f6776a = (RelativeLayout) view2.findViewById(R.id.rl_accounts_layout);
            bVar.f6777b = (TextView) view2.findViewById(R.id.txt_account);
            bVar.f6778c = (ImageView) view2.findViewById(R.id.img_clear_accounts);
            f.a(view2);
            f.a(bVar.f6776a);
            f.a(bVar.f6777b);
            f.a(bVar.f6778c);
            view2.setTag(bVar);
        } else {
            view2 = view;
            bVar = (b) view.getTag();
        }
        if (i < this.f6770a.size()) {
            if (!TextUtils.isEmpty(this.f6770a.get(i))) {
                bVar.f6776a.setVisibility(0);
                bVar.f6777b.setText(this.f6770a.get(i));
            } else {
                bVar.f6776a.setVisibility(8);
            }
            bVar.f6778c.setOnClickListener(new ViewOnClickListenerC0306a(i));
        }
        return view2;
    }

    public void a(ArrayList<String> arrayList) {
        this.f6770a = arrayList;
        notifyDataSetChanged();
    }

    public void a(com.zte.iptvclient.android.common.g.b bVar) {
        this.f6772c = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f6773d <= 800) {
            LogEx.w("UseeTv", "Operate limit,less than 1000(ms)!");
            return true;
        }
        this.f6773d = currentTimeMillis;
        return false;
    }
}
