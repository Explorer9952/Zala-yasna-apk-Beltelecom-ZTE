package com.zte.iptvclient.android.common.customview.viewgroup.scrollview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.javabean.column.ColumnBean;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class HorizontalScrollViewEx extends HorizontalScrollView {

    /* renamed from: a, reason: collision with root package name */
    private LinearLayout f4429a;

    /* renamed from: b, reason: collision with root package name */
    private LayoutInflater f4430b;

    /* renamed from: c, reason: collision with root package name */
    private View f4431c;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<View> f4432d;
    private int e;
    private Context f;
    private a g;
    private int h;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i);
    }

    /* loaded from: classes.dex */
    private class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        private a f4433a;

        /* renamed from: b, reason: collision with root package name */
        private int f4434b;

        public b(int i, a aVar) {
            this.f4433a = aVar;
            this.f4434b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            HorizontalScrollViewEx.this.f4431c.setSelected(false);
            if (BaseApp.a(HorizontalScrollViewEx.this.f)) {
                HorizontalScrollViewEx.this.f4431c.setBackground(HorizontalScrollViewEx.this.f.getResources().getDrawable(R.drawable.tv_column_channel_txt_bg));
            } else {
                HorizontalScrollViewEx.this.f4431c.setBackground(HorizontalScrollViewEx.this.f.getResources().getDrawable(R.drawable.tv_column_channel_txt__phone_bg));
            }
            view.setSelected(true);
            view.setBackground(HorizontalScrollViewEx.this.f.getResources().getDrawable(R.drawable.tv_column_channel_txt_bg_select));
            HorizontalScrollViewEx.this.f4431c = view;
            HorizontalScrollViewEx.this.a(view);
            a aVar = this.f4433a;
            if (aVar != null) {
                aVar.a(this.f4434b);
            }
        }
    }

    public HorizontalScrollViewEx(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 0;
        this.h = -1;
        this.f = context;
        this.f4430b = LayoutInflater.from(context);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f4429a = linearLayout;
        addView(linearLayout);
        f.a(this.f4429a);
    }

    public void a(int i, List<ColumnBean> list, int i2, a aVar) {
        View inflate;
        this.g = aVar;
        ArrayList<View> arrayList = this.f4432d;
        if (arrayList == null) {
            this.f4432d = new ArrayList<>();
            this.f4429a.removeAllViews();
        } else {
            arrayList.clear();
            this.f4429a.removeAllViews();
        }
        View view = this.f4431c;
        if (view != null) {
            view.setSelected(false);
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            int i4 = this.h;
            if (i4 != -1) {
                inflate = this.f4430b.inflate(i4, (ViewGroup) null);
            } else {
                inflate = this.f4430b.inflate(R.layout.tvcolumn_filter_item, (ViewGroup) null);
            }
            TextView textView = (TextView) inflate.findViewById(R.id.txt_filter);
            textView.setText(list.get(i3).getColumnName());
            if (i == 0) {
                ColorStateList a2 = c.a.a.a.d.b.d().a(R.color.tvcolumn_text_style_light);
                if (a2 != null) {
                    textView.setTextColor(a2);
                }
            } else {
                ColorStateList a3 = c.a.a.a.d.b.d().a(R.color.tvcolumn_text_style_light);
                if (a3 != null) {
                    textView.setTextColor(a3);
                }
            }
            if (i3 == i2) {
                this.f4431c = inflate;
                inflate.setSelected(true);
                inflate.setBackground(this.f.getResources().getDrawable(R.drawable.tv_column_channel_txt_bg_select));
            } else if (BaseApp.a(this.f)) {
                inflate.setBackground(this.f.getResources().getDrawable(R.drawable.tv_column_channel_txt_bg));
            } else {
                inflate.setBackground(this.f.getResources().getDrawable(R.drawable.tv_column_channel_txt__phone_bg));
            }
            this.f4429a.addView(inflate);
            this.f4432d.add(inflate);
            f.a(inflate);
            f.a(textView);
            inflate.setOnClickListener(new b(i3, aVar));
        }
    }

    public void a(int i) {
        ArrayList<View> arrayList = this.f4432d;
        if (arrayList != null) {
            View view = arrayList.get(i);
            this.f4431c.setSelected(false);
            if (BaseApp.a(this.f)) {
                this.f4431c.setBackground(this.f.getResources().getDrawable(R.drawable.tv_column_channel_txt_bg));
            } else {
                this.f4431c.setBackground(this.f.getResources().getDrawable(R.drawable.tv_column_channel_txt__phone_bg));
            }
            view.setBackground(this.f.getResources().getDrawable(R.drawable.tv_column_channel_txt_bg_select));
            view.setSelected(true);
            this.f4431c = view;
            a(view);
            this.g.a(i);
        }
    }

    public void a(int i, boolean z) {
        ArrayList<View> arrayList = this.f4432d;
        if (arrayList != null) {
            View view = arrayList.get(i);
            this.f4431c.setSelected(false);
            if (BaseApp.a(this.f)) {
                this.f4431c.setBackground(this.f.getResources().getDrawable(R.drawable.tv_column_channel_txt_bg));
            } else {
                this.f4431c.setBackground(this.f.getResources().getDrawable(R.drawable.tv_column_channel_txt__phone_bg));
            }
            view.setBackground(this.f.getResources().getDrawable(R.drawable.tv_column_channel_txt_bg_select));
            view.setSelected(true);
            this.f4431c = view;
            a(view);
            if (z) {
                return;
            }
            this.g.a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        this.e = getWidth();
        if (this.f.getResources().getConfiguration().orientation == 2) {
            this.e = (this.e * 3) / 5;
        }
        smoothScrollTo(view.getLeft() - ((this.e / 2) - (view.getWidth() / 2)), 0);
    }
}
