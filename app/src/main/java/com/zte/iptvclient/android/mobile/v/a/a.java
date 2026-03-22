package com.zte.iptvclient.android.mobile.v.a;

import android.app.Activity;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.mobile.search.bean.d;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.ArrayList;

/* compiled from: SearchHintKeyWordsAdapter.java */
/* loaded from: classes2.dex */
public class a extends BaseAdapter {

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<d> f7489b;

    /* renamed from: c, reason: collision with root package name */
    private Activity f7490c;

    /* renamed from: a, reason: collision with root package name */
    private String f7488a = "SearchHintKeyWordsAdapter";

    /* renamed from: d, reason: collision with root package name */
    private String f7491d = "";
    private boolean e = false;

    /* compiled from: SearchHintKeyWordsAdapter.java */
    /* loaded from: classes2.dex */
    private static class b extends com.zte.iptvclient.common.uiframe.d {

        /* renamed from: a, reason: collision with root package name */
        TextView f7492a;

        /* renamed from: b, reason: collision with root package name */
        RelativeLayout f7493b;

        private b() {
        }
    }

    public a(Activity activity, ArrayList<d> arrayList) {
        this.f7490c = activity;
        this.f7489b = arrayList;
    }

    public void a(boolean z) {
        this.e = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f7489b == null) {
            return 0;
        }
        LogEx.d(this.f7488a, "getCount=" + this.f7489b.size());
        return this.f7489b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(i);
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
            view2 = ((LayoutInflater) this.f7490c.getSystemService("layout_inflater")).inflate(R.layout.search_hint_keywords_item, (ViewGroup) null);
            bVar.f7493b = (RelativeLayout) view2.findViewById(R.id.hint_item);
            bVar.f7492a = (TextView) view2.findViewById(R.id.search_hint_txt);
            f.a(bVar.f7493b);
            f.a(bVar.f7492a);
            view2.setTag(bVar);
        } else {
            view2 = view;
            bVar = (b) view.getTag();
        }
        try {
            if (i < this.f7489b.size() && this.f7489b.get(i) != null) {
                d dVar = this.f7489b.get(i);
                if (!TextUtils.isEmpty(dVar.a())) {
                    LogEx.d(this.f7488a, "hintText=" + dVar.a());
                    bVar.f7492a.setText(dVar.a());
                    if (!TextUtils.isEmpty(this.f7491d)) {
                        if (dVar.a().contains(this.f7491d)) {
                            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(dVar.a());
                            if (TextUtils.equals(com.zte.fragmentlib.publicbaseclass.skinloader.b.f4075b, "black.skin")) {
                                bVar.f7492a.setTextColor(Color.parseColor("#9da3b4"));
                                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f7490c.getResources().getColor(R.color.anhui_mobile_light_theme)), dVar.a().indexOf(this.f7491d), dVar.a().indexOf(this.f7491d) + this.f7491d.length(), 33);
                            } else if (this.e) {
                                bVar.f7492a.setTextColor(this.f7490c.getResources().getColor(R.color.search_small_color));
                                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f7490c.getResources().getColor(R.color.common_column_text_selected)), dVar.a().indexOf(this.f7491d), dVar.a().indexOf(this.f7491d) + this.f7491d.length(), 33);
                            } else {
                                bVar.f7492a.setTextColor(this.f7490c.getResources().getColor(R.color.search_most_color));
                                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f7490c.getResources().getColor(R.color.common_column_text_selected)), dVar.a().indexOf(this.f7491d), dVar.a().indexOf(this.f7491d) + this.f7491d.length(), 33);
                            }
                            bVar.f7492a.setText(spannableStringBuilder);
                        } else if (TextUtils.equals(com.zte.fragmentlib.publicbaseclass.skinloader.b.f4075b, "black.skin")) {
                            bVar.f7492a.setTextColor(Color.parseColor("#9da3b4"));
                        } else if (this.e) {
                            bVar.f7492a.setTextColor(this.f7490c.getResources().getColor(R.color.search_small_color));
                        } else {
                            bVar.f7492a.setTextColor(this.f7490c.getResources().getColor(R.color.search_most_color));
                        }
                    } else if (TextUtils.equals(com.zte.fragmentlib.publicbaseclass.skinloader.b.f4075b, "black.skin")) {
                        bVar.f7492a.setTextColor(Color.parseColor("#9da3b4"));
                    } else if (this.e) {
                        bVar.f7492a.setTextColor(this.f7490c.getResources().getColor(R.color.search_small_color));
                    } else {
                        bVar.f7492a.setTextColor(this.f7490c.getResources().getColor(R.color.search_most_color));
                    }
                } else {
                    bVar.f7492a.setText("");
                    if (TextUtils.equals(com.zte.fragmentlib.publicbaseclass.skinloader.b.f4075b, "black.skin")) {
                        bVar.f7492a.setTextColor(Color.parseColor("#9da3b4"));
                    } else {
                        bVar.f7492a.setTextColor(this.f7490c.getResources().getColor(R.color.search_most_color));
                    }
                }
            }
        } catch (Exception e) {
            LogEx.e(this.f7488a, e.getMessage());
        }
        return view2;
    }

    public void a(String str) {
        this.f7491d = str;
    }
}
