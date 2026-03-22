package com.zte.iptvclient.android.mobile.t.c;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.i;
import com.zte.iptvclient.android.common.javabean.models.AnswerBean;
import com.zte.iptvclient.android.common.javabean.models.OptionBean;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.List;
import org.json.JSONObject;

/* compiled from: AnswerAdapter.java */
/* loaded from: classes2.dex */
public class a extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private AnswerBean f7237a;

    /* renamed from: b, reason: collision with root package name */
    private List<OptionBean> f7238b;

    /* renamed from: c, reason: collision with root package name */
    private LayoutInflater f7239c;

    /* renamed from: d, reason: collision with root package name */
    private Context f7240d;
    private String e;
    private String f;
    private String g;

    /* compiled from: AnswerAdapter.java */
    /* renamed from: com.zte.iptvclient.android.mobile.t.c.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class ViewOnClickListenerC0351a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f7241a;

        ViewOnClickListenerC0351a(int i) {
            this.f7241a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!((OptionBean) a.this.f7238b.get(this.f7241a)).isSelected()) {
                ((OptionBean) a.this.f7238b.get(this.f7241a)).setSelected(true);
            }
            for (int i = 0; i < a.this.f7238b.size(); i++) {
                if (i != this.f7241a) {
                    ((OptionBean) a.this.f7238b.get(i)).setSelected(false);
                }
            }
            a.this.notifyDataSetChanged();
        }
    }

    /* compiled from: AnswerAdapter.java */
    /* loaded from: classes2.dex */
    class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f7243a;

        b(int i) {
            this.f7243a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (((OptionBean) a.this.f7238b.get(this.f7243a)).isSelected()) {
                ((OptionBean) a.this.f7238b.get(this.f7243a)).setSelected(false);
            } else {
                ((OptionBean) a.this.f7238b.get(this.f7243a)).setSelected(true);
            }
            a.this.notifyDataSetChanged();
        }
    }

    /* compiled from: AnswerAdapter.java */
    /* loaded from: classes2.dex */
    class c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f7245a;

        c(int i) {
            this.f7245a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!((OptionBean) a.this.f7238b.get(this.f7245a)).isSelected()) {
                ((OptionBean) a.this.f7238b.get(this.f7245a)).setSelected(true);
            }
            for (int i = 0; i < a.this.f7238b.size(); i++) {
                if (i != this.f7245a) {
                    ((OptionBean) a.this.f7238b.get(i)).setSelected(false);
                }
            }
            a.this.notifyDataSetChanged();
        }
    }

    /* compiled from: AnswerAdapter.java */
    /* loaded from: classes2.dex */
    static class d {

        /* renamed from: a, reason: collision with root package name */
        private CheckBox f7247a;

        /* renamed from: b, reason: collision with root package name */
        private TextView f7248b;

        /* renamed from: c, reason: collision with root package name */
        private ImageView f7249c;

        /* renamed from: d, reason: collision with root package name */
        private LinearLayout f7250d;
        private ImageView e;
        private TextView f;
        private TextView g;
        private LinearLayout h;
        private TextView i;

        d() {
        }
    }

    public a(Context context, AnswerBean answerBean, List<OptionBean> list, String str) {
        new JSONObject();
        this.f7240d = context;
        this.f7237a = answerBean;
        this.f7238b = list;
        this.f = str;
        this.f7239c = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<OptionBean> list = this.f7238b;
        if (list == null || list.size() == 0) {
            return 0;
        }
        return this.f7238b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f7238b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        d dVar;
        if (view == null) {
            String questiontype = this.f7237a.getQuestiontype();
            this.e = questiontype;
            if ("0".equals(questiontype)) {
                view = this.f7239c.inflate(R.layout.single_choice, (ViewGroup) null);
                dVar = new d();
                dVar.f7247a = (CheckBox) view.findViewById(R.id.ck_selector);
                dVar.f7248b = (TextView) view.findViewById(R.id.optionname);
                dVar.f7250d = (LinearLayout) view.findViewById(R.id.ll_item);
                dVar.e = (ImageView) view.findViewById(R.id.img_questionpicture);
                dVar.f = (TextView) view.findViewById(R.id.subjectname);
                dVar.g = (TextView) view.findViewById(R.id.questionname);
                dVar.h = (LinearLayout) view.findViewById(R.id.ll_questionname);
                dVar.i = (TextView) view.findViewById(R.id.questionid);
                f.a(dVar.f7247a);
                f.a(dVar.f7248b);
                f.a(dVar.f7250d);
                f.a(dVar.e);
                f.a(dVar.f);
                f.a(dVar.g);
                f.a(dVar.h);
                f.a(dVar.i);
                view.setTag(dVar);
            } else if ("1".equals(this.e)) {
                view = this.f7239c.inflate(R.layout.multiple_choice, (ViewGroup) null);
                dVar = new d();
                dVar.f7249c = (ImageView) view.findViewById(R.id.img_selected);
                dVar.f7248b = (TextView) view.findViewById(R.id.optionname);
                dVar.f7250d = (LinearLayout) view.findViewById(R.id.ll_item);
                dVar.e = (ImageView) view.findViewById(R.id.img_questionpicture);
                dVar.f = (TextView) view.findViewById(R.id.subjectname);
                dVar.g = (TextView) view.findViewById(R.id.questionname);
                dVar.h = (LinearLayout) view.findViewById(R.id.ll_questionname);
                dVar.i = (TextView) view.findViewById(R.id.questionid);
                f.a(dVar.f7249c);
                f.a(dVar.f7248b);
                f.a(dVar.f7250d);
                f.a(dVar.e);
                f.a(dVar.f);
                f.a(dVar.g);
                f.a(dVar.h);
                f.a(dVar.i);
                view.setTag(dVar);
            } else if ("2".equals(this.e)) {
                view = this.f7239c.inflate(R.layout.judge, (ViewGroup) null);
                dVar = new d();
                dVar.f7247a = (CheckBox) view.findViewById(R.id.ck_selector);
                dVar.f7248b = (TextView) view.findViewById(R.id.optionname);
                dVar.f7250d = (LinearLayout) view.findViewById(R.id.ll_item);
                dVar.e = (ImageView) view.findViewById(R.id.img_questionpicture);
                dVar.f = (TextView) view.findViewById(R.id.subjectname);
                dVar.g = (TextView) view.findViewById(R.id.questionname);
                dVar.h = (LinearLayout) view.findViewById(R.id.ll_questionname);
                dVar.i = (TextView) view.findViewById(R.id.questionid);
                f.a(dVar.f7247a);
                f.a(dVar.f7248b);
                f.a(dVar.f7250d);
                f.a(dVar.e);
                f.a(dVar.f);
                f.a(dVar.g);
                f.a(dVar.h);
                f.a(dVar.i);
                view.setTag(dVar);
            } else {
                dVar = null;
            }
        } else {
            dVar = (d) view.getTag();
        }
        if (i == 0) {
            if (dVar != null) {
                dVar.h.setVisibility(0);
                if ("0".equals(this.f7237a.getQuestiontype())) {
                    this.g = this.f7240d.getResources().getString(R.string.single_choice);
                } else if ("1".equals(this.f7237a.getQuestiontype())) {
                    this.g = this.f7240d.getResources().getString(R.string.multiple_choice);
                } else {
                    this.g = "";
                }
                dVar.f.setText(this.g);
                dVar.g.setText(this.f7237a.getQuestionname());
                dVar.i.setText(this.f + ". ");
            }
        } else if (dVar != null) {
            dVar.h.setVisibility(8);
        }
        if (dVar == null) {
            return null;
        }
        if (TextUtils.isEmpty(this.f7238b.get(i).getOptionid())) {
            dVar.f7250d.setVisibility(8);
        } else {
            dVar.f7250d.setVisibility(0);
        }
        dVar.f7248b.setText(this.f7238b.get(i).getOptionname());
        if (TextUtils.isEmpty(this.f7237a.getQuestionpicture()) || this.f7238b.size() != i + 1) {
            dVar.e.setVisibility(8);
        } else {
            if (!this.f7237a.getQuestionpicture().equals(dVar.e.getTag(R.id.img_questionpicture))) {
                com.bumptech.glide.d<String> a2 = i.b(this.f7240d).a(this.f7237a.getQuestionpicture());
                a2.a(false);
                a2.a(R.drawable.default_video_thumb);
                a2.c(300);
                a2.a(dVar.e);
                dVar.e.setTag(R.id.img_questionpicture, this.f7237a.getQuestionpicture());
            }
            dVar.e.setVisibility(0);
        }
        if ("0".equals(this.e)) {
            if (dVar.f7247a != null) {
                if (this.f7238b.get(i).isSelected()) {
                    dVar.f7247a.setChecked(true);
                } else {
                    dVar.f7247a.setChecked(false);
                }
            }
            dVar.f7250d.setOnClickListener(new ViewOnClickListenerC0351a(i));
        } else if ("1".equals(this.e)) {
            if (dVar.f7249c != null) {
                if (this.f7238b.get(i).isSelected()) {
                    dVar.f7249c.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.select));
                } else {
                    dVar.f7249c.setImageDrawable(c.a.a.a.d.b.d().d(R.drawable.unselect));
                }
            }
            dVar.f7250d.setOnClickListener(new b(i));
        } else if ("2".equals(this.e)) {
            if (dVar.f7247a != null) {
                if (this.f7238b.get(i).isSelected()) {
                    dVar.f7247a.setChecked(true);
                } else {
                    dVar.f7247a.setChecked(false);
                }
            }
            dVar.f7250d.setOnClickListener(new c(i));
        }
        return view;
    }
}
