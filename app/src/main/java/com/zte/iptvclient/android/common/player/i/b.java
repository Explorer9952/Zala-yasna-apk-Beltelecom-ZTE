package com.zte.iptvclient.android.common.player.i;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.d;
import com.zte.iptvclient.common.uiframe.f;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: AssetListAdapter.java */
/* loaded from: classes.dex */
public class b extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<String> f4934a;

    /* renamed from: b, reason: collision with root package name */
    private Context f4935b;

    /* renamed from: c, reason: collision with root package name */
    private int f4936c;

    /* renamed from: d, reason: collision with root package name */
    private ListView f4937d;
    private InterfaceC0146b e;

    /* compiled from: AssetListAdapter.java */
    /* loaded from: classes.dex */
    class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f4938a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f4939b;

        a(int i, View view) {
            this.f4938a = i;
            this.f4939b = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.e.a(this.f4938a, this.f4939b);
        }
    }

    /* compiled from: AssetListAdapter.java */
    /* renamed from: com.zte.iptvclient.android.common.player.i.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0146b {
        void a(int i, View view);
    }

    /* compiled from: AssetListAdapter.java */
    /* loaded from: classes.dex */
    private static class c extends d {

        /* renamed from: a, reason: collision with root package name */
        TextView f4941a;

        /* renamed from: b, reason: collision with root package name */
        ImageView f4942b;

        private c() {
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    public b(Context context, ListView listView, ArrayList<String> arrayList, int i) {
        this.f4935b = context;
        this.f4937d = listView;
        this.f4934a = arrayList;
        this.f4936c = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<String> arrayList = this.f4934a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList<String> arrayList = this.f4934a;
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
        c cVar;
        if (view == null) {
            view = ((LayoutInflater) this.f4935b.getSystemService("layout_inflater")).inflate(R.layout.player_asset_list_item, (ViewGroup) null);
            cVar = new c(null);
            cVar.f4941a = (TextView) view.findViewById(R.id.asset_item_name);
            cVar.f4942b = (ImageView) view.findViewById(R.id.state_select_img);
            f.a(view);
            f.a(cVar.f4941a);
            f.a(cVar.f4942b);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        ArrayList<String> arrayList = this.f4934a;
        if (arrayList != null) {
            if (TextUtils.isEmpty(arrayList.get(i))) {
                cVar.f4941a.setText("");
            } else {
                cVar.f4941a.setText(this.f4934a.get(i));
                LogEx.d("AssetListAdapter", "getView txtvewAssetName +" + Arrays.toString(this.f4934a.get(i).split(",")));
            }
        }
        if (this.f4936c == i) {
            cVar.f4941a.setTypeface(Typeface.defaultFromStyle(1));
            cVar.f4942b.setVisibility(0);
        } else {
            cVar.f4941a.setTypeface(Typeface.defaultFromStyle(0));
            cVar.f4942b.setVisibility(4);
        }
        cVar.f4941a.setOnClickListener(new a(i, view));
        return view;
    }

    public void a(int i) {
        View childAt;
        int firstVisiblePosition = this.f4937d.getFirstVisiblePosition();
        LogEx.d("AssetListAdapter", "ifirstPosition-----" + firstVisiblePosition);
        LogEx.d("AssetListAdapter", "mSelectedIndex-------" + this.f4936c);
        LogEx.d("AssetListAdapter", "iselectedIndex-------" + i);
        int i2 = this.f4936c;
        if (i2 >= 0 && (childAt = this.f4937d.getChildAt(i2 - firstVisiblePosition)) != null) {
            c cVar = (c) childAt.getTag();
            cVar.f4941a.setTypeface(Typeface.defaultFromStyle(0));
            cVar.f4942b.setVisibility(4);
        }
        if (i >= 0) {
            View childAt2 = this.f4937d.getChildAt(i - firstVisiblePosition);
            if (childAt2 != null) {
                c cVar2 = (c) childAt2.getTag();
                cVar2.f4941a.setTypeface(Typeface.defaultFromStyle(1));
                cVar2.f4942b.setVisibility(0);
            }
            this.f4936c = i;
        }
    }

    public void a(InterfaceC0146b interfaceC0146b) {
        this.e = interfaceC0146b;
    }
}
