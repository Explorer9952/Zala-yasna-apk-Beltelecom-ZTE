package com.zte.iptvclient.android.mobile.t.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zte.iptvclient.android.common.javabean.models.QuizListBean;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/* compiled from: QuizListAdapter.java */
/* loaded from: classes2.dex */
public class b extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private List<QuizListBean> f7251a;

    /* renamed from: b, reason: collision with root package name */
    private LayoutInflater f7252b;

    /* renamed from: c, reason: collision with root package name */
    private Context f7253c;

    /* renamed from: d, reason: collision with root package name */
    private String f7254d = "";

    /* compiled from: QuizListAdapter.java */
    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QuizListBean f7255a;

        a(QuizListBean quizListBean) {
            this.f7255a = quizListBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f7255a == null) {
                return;
            }
            Intent intent = new Intent(b.this.f7253c, (Class<?>) HostActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("myDataBean", this.f7255a);
            bundle.putString("fragmenttype", "answer");
            intent.putExtras(bundle);
            b.this.f7253c.startActivity(intent);
        }
    }

    /* compiled from: QuizListAdapter.java */
    /* renamed from: com.zte.iptvclient.android.mobile.t.c.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0352b {

        /* renamed from: a, reason: collision with root package name */
        private LinearLayout f7257a;

        /* renamed from: b, reason: collision with root package name */
        private ImageView f7258b;

        /* renamed from: c, reason: collision with root package name */
        private TextView f7259c;

        /* renamed from: d, reason: collision with root package name */
        private TextView f7260d;
        private TextView e;
        private TextView f;

        C0352b() {
        }
    }

    public b(Context context, List<QuizListBean> list) {
        this.f7253c = context;
        this.f7251a = list;
        this.f7252b = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<QuizListBean> list = this.f7251a;
        if (list == null || list.size() == 0) {
            return 0;
        }
        return this.f7251a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f7251a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0352b c0352b;
        if (view == null) {
            view = this.f7252b.inflate(R.layout.quizlist_layout, (ViewGroup) null);
            c0352b = new C0352b();
            c0352b.f7257a = (LinearLayout) view.findViewById(R.id.item_layout);
            c0352b.f7258b = (ImageView) view.findViewById(R.id.img_subject_state);
            c0352b.f7259c = (TextView) view.findViewById(R.id.subject_name);
            c0352b.f7260d = (TextView) view.findViewById(R.id.subject_type);
            c0352b.e = (TextView) view.findViewById(R.id.subject_time);
            c0352b.f = (TextView) view.findViewById(R.id.overview);
            f.a(c0352b.f7257a);
            f.a(c0352b.f7258b);
            f.a(c0352b.f7259c);
            f.a(c0352b.f7260d);
            f.a(c0352b.e);
            f.a(c0352b.f);
            view.setTag(c0352b);
        } else {
            c0352b = (C0352b) view.getTag();
        }
        if (this.f7251a.size() == 0) {
            return view;
        }
        if ("1".equals(this.f7251a.get(i).getSubjectstate())) {
            c0352b.f7258b.setVisibility(0);
        } else {
            c0352b.f7258b.setVisibility(4);
        }
        c0352b.f7259c.setText(this.f7251a.get(i).getSubjectname());
        this.f7254d = "";
        if ("0".equals(this.f7251a.get(i).getSubjecttype())) {
            this.f7254d = this.f7253c.getResources().getString(R.string.test_paper);
        } else if ("1".equals(this.f7251a.get(i).getSubjecttype())) {
            this.f7254d = this.f7253c.getResources().getString(R.string.questionnaire);
        } else if ("2".equals(this.f7251a.get(i).getSubjecttype())) {
            this.f7254d = this.f7253c.getResources().getString(R.string.vote);
        }
        c0352b.f7260d.setText(this.f7253c.getResources().getString(R.string.type) + " " + this.f7254d);
        c0352b.e.setText(this.f7253c.getResources().getString(R.string.time) + a(this.f7251a.get(i).getSubjectstarttime()) + " - " + a(this.f7251a.get(i).getSubjectendtime()));
        c0352b.f.setText(this.f7253c.getResources().getString(R.string.overview) + this.f7251a.get(i).getQuestionnum() + " " + this.f7253c.getResources().getString(R.string.questions));
        c0352b.f7257a.setOnClickListener(new a(this.f7251a.get(i)));
        return view;
    }

    private String a(String str) {
        try {
            return new SimpleDateFormat("dd.MM.yyyy").format(new SimpleDateFormat("yyyy-MM-dd").parse(str));
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }
}
