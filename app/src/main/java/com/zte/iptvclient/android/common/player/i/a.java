package com.zte.iptvclient.android.common.player.i;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.video.androidsdk.log.LogEx;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.javabean.f;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;

/* compiled from: AdapterPlayBundleBean.java */
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    private static final String e = a.class.getSimpleName();

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<f> f4928a;

    /* renamed from: b, reason: collision with root package name */
    private Context f4929b;

    /* renamed from: c, reason: collision with root package name */
    private int f4930c;

    /* renamed from: d, reason: collision with root package name */
    private SupportActivity f4931d;

    /* compiled from: AdapterPlayBundleBean.java */
    /* renamed from: com.zte.iptvclient.android.common.player.i.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0145a {

        /* renamed from: a, reason: collision with root package name */
        TextView f4932a;

        /* renamed from: b, reason: collision with root package name */
        ImageView f4933b;

        C0145a() {
        }
    }

    public a(Context context, ArrayList<f> arrayList, int i) {
        this.f4930c = 0;
        this.f4929b = context;
        this.f4928a = arrayList;
        this.f4930c = i;
    }

    public void a(int i) {
        this.f4930c = i;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f4928a == null) {
            return 0;
        }
        String str = e;
        StringBuilder sb = new StringBuilder();
        sb.append("getCount=");
        sb.append(this.f4928a.size() > 4 ? 4 : this.f4928a.size());
        LogEx.d(str, sb.toString());
        if (this.f4928a.size() > 4) {
            return 4;
        }
        return this.f4928a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList<f> arrayList = this.f4928a;
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
        C0145a c0145a;
        if (view == null) {
            c0145a = new C0145a();
            view2 = ((LayoutInflater) this.f4929b.getSystemService("layout_inflater")).inflate(R.layout.program_edit_item, (ViewGroup) null);
            c0145a.f4932a = (TextView) view2.findViewById(R.id.txt_program);
            c0145a.f4933b = (ImageView) view2.findViewById(R.id.img_close);
            com.zte.iptvclient.common.uiframe.f.a(view2);
            com.zte.iptvclient.common.uiframe.f.a(c0145a.f4932a);
            com.zte.iptvclient.common.uiframe.f.a(c0145a.f4933b);
            view2.setTag(c0145a);
        } else {
            view2 = view;
            c0145a = (C0145a) view.getTag();
        }
        if (this.f4930c == 0) {
            if (this.f4931d != null) {
                c0145a.f4932a.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.multiplayer_add_programitem_txt_background_light));
                this.f4931d.a(c0145a.f4932a, TtmlNode.ATTR_TTS_BACKGROUND_COLOR, R.color.multiplayer_add_programitem_txt_background_light);
                c0145a.f4932a.setTextColor(c.a.a.a.d.b.d().b(R.color.multiplayer_add_programitem_txt_color_light));
                this.f4931d.a(c0145a.f4932a, "textColor", R.color.multiplayer_add_programitem_txt_color_light);
            }
        } else if (this.f4931d != null) {
            c0145a.f4932a.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.multiplayer_add_programitem_txt_background_dark));
            this.f4931d.a(c0145a.f4932a, TtmlNode.ATTR_TTS_BACKGROUND_COLOR, R.color.multiplayer_add_programitem_txt_background_dark);
            c0145a.f4932a.setTextColor(c.a.a.a.d.b.d().b(R.color.multiplayer_add_programitem_txt_color_dark));
            this.f4931d.a(c0145a.f4932a, "textColor", R.color.multiplayer_add_programitem_txt_color_dark);
        }
        c0145a.f4932a.setText(this.f4928a.get(i).e());
        return view2;
    }
}
