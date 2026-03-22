package com.zte.iptvclient.android.mobile.vod.videofilter.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.k.g;
import com.zte.iptvclient.android.mobile.vod.bean.FilterBean;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import com.zte.sdk.enumclass.CapablityEnum;
import it.sephiroth.android.library.widget.AdapterView;
import it.sephiroth.android.library.widget.HListView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class VideoFilterMultiSelectHeadView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private Context f7691a;

    /* renamed from: b, reason: collision with root package name */
    private List<FilterBean> f7692b;

    /* renamed from: c, reason: collision with root package name */
    private List<FilterBean> f7693c;

    /* renamed from: d, reason: collision with root package name */
    private List<FilterBean> f7694d;
    private List<FilterBean> e;
    private List<FilterBean> f;
    private ArrayList<FilterBean> g;
    private d h;
    private LayoutInflater i;
    private View j;
    private LinearLayout k;
    private Button l;
    private int m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements View.OnTouchListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HListView f7695a;

        a(HListView hListView) {
            this.f7695a = hListView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0 && action != 1) {
                return false;
            }
            this.f7695a.requestFocus();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements AdapterView.OnItemClickListener {
        b() {
        }

        @Override // it.sephiroth.android.library.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            c cVar = (c) adapterView.getAdapter();
            List<FilterBean> b2 = cVar.b();
            if (i == 0) {
                FilterBean filterBean = b2.get(0);
                if (filterBean.b()) {
                    return;
                }
                filterBean.a(true);
                for (int i2 = 1; i2 < b2.size(); i2++) {
                    FilterBean filterBean2 = b2.get(i2);
                    if (filterBean2.b()) {
                        filterBean2.a(false);
                    }
                }
            } else {
                FilterBean filterBean3 = b2.get(i);
                if (filterBean3.b()) {
                    filterBean3.a(false);
                    if (cVar.c()) {
                        b2.get(0).a(true);
                    }
                } else {
                    filterBean3.a(true);
                    FilterBean filterBean4 = b2.get(0);
                    if (filterBean4.b()) {
                        filterBean4.a(false);
                    }
                }
            }
            cVar.a();
            if (VideoFilterMultiSelectHeadView.this.h != null) {
                VideoFilterMultiSelectHeadView videoFilterMultiSelectHeadView = VideoFilterMultiSelectHeadView.this;
                String c2 = videoFilterMultiSelectHeadView.c((List<FilterBean>) videoFilterMultiSelectHeadView.f7692b);
                VideoFilterMultiSelectHeadView videoFilterMultiSelectHeadView2 = VideoFilterMultiSelectHeadView.this;
                String a2 = videoFilterMultiSelectHeadView2.a((List<FilterBean>) videoFilterMultiSelectHeadView2.f7693c);
                VideoFilterMultiSelectHeadView videoFilterMultiSelectHeadView3 = VideoFilterMultiSelectHeadView.this;
                String c3 = videoFilterMultiSelectHeadView3.c((List<FilterBean>) videoFilterMultiSelectHeadView3.f7694d);
                VideoFilterMultiSelectHeadView videoFilterMultiSelectHeadView4 = VideoFilterMultiSelectHeadView.this;
                String d2 = videoFilterMultiSelectHeadView4.d((List<FilterBean>) videoFilterMultiSelectHeadView4.e);
                VideoFilterMultiSelectHeadView videoFilterMultiSelectHeadView5 = VideoFilterMultiSelectHeadView.this;
                String b3 = videoFilterMultiSelectHeadView5.b((List<FilterBean>) videoFilterMultiSelectHeadView5.f);
                VideoFilterMultiSelectHeadView videoFilterMultiSelectHeadView6 = VideoFilterMultiSelectHeadView.this;
                VideoFilterMultiSelectHeadView.this.h.a(c2, a2, c3, d2, b3, videoFilterMultiSelectHeadView6.c(videoFilterMultiSelectHeadView6.g));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends com.zte.iptvclient.common.uiframe.c {

        /* renamed from: d, reason: collision with root package name */
        private List<FilterBean> f7698d;
        private int e;

        public c(Context context, List<FilterBean> list, int i) {
            super(context, list);
            this.f7698d = list;
            this.e = i;
        }

        public List<FilterBean> b() {
            return this.f7698d;
        }

        public boolean c() {
            for (int i = 0; i < this.f7698d.size(); i++) {
                if (this.f7698d.get(i).b()) {
                    return false;
                }
            }
            return true;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            e eVar;
            if (view == null) {
                view = this.f7901c.inflate(R.layout.video_filter_item, (ViewGroup) null);
                eVar = new e(view);
                view.setTag(eVar);
            } else {
                eVar = (e) view.getTag();
            }
            if (i == 0) {
                eVar.f7701c.setText(VideoFilterMultiSelectHeadView.this.d());
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                eVar.f7701c.measure(makeMeasureSpec, makeMeasureSpec);
                VideoFilterMultiSelectHeadView.this.m = eVar.f7701c.getMeasuredWidth();
            }
            FilterBean filterBean = (FilterBean) getItem(i);
            String a2 = filterBean.a();
            int indexOf = a2.indexOf(":");
            if (this.e == 3 && a2.startsWith("-")) {
                eVar.f7701c.setText(a2.replace("-", com.zte.iptvclient.android.common.i.a.a.a(R.string.filter_year_before)));
            } else if (this.e == 4 && indexOf > 0) {
                eVar.f7701c.setText(a2.substring(indexOf + 1).trim());
            } else {
                eVar.f7701c.setText(a2);
            }
            if (filterBean.b()) {
                eVar.f7700b.setVisibility(0);
                eVar.f7701c.setSelected(true);
            } else {
                eVar.f7700b.setVisibility(4);
                eVar.f7701c.setSelected(false);
            }
            if (i == 0) {
                eVar.f7701c.setGravity(19);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) eVar.f7701c.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = VideoFilterMultiSelectHeadView.this.m;
                    eVar.f7701c.setLayoutParams(layoutParams);
                }
                int a3 = g.a(VideoFilterMultiSelectHeadView.this.f7691a, 10.0f);
                eVar.f7699a.setPadding(0, 0, a3, 0);
                eVar.f7699a.setPaddingRelative(0, 0, a3, 0);
            } else {
                eVar.f7701c.setGravity(17);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) eVar.f7701c.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.width = -2;
                    eVar.f7701c.setLayoutParams(layoutParams2);
                }
                int a4 = g.a(VideoFilterMultiSelectHeadView.this.f7691a, 10.0f);
                eVar.f7699a.setPadding(a4, 0, a4, 0);
                eVar.f7699a.setPaddingRelative(a4, 0, a4, 0);
            }
            return view;
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a(String str, String str2, String str3, String str4, String str5, String str6);
    }

    /* loaded from: classes2.dex */
    static class e {

        /* renamed from: a, reason: collision with root package name */
        public View f7699a;

        /* renamed from: b, reason: collision with root package name */
        public ImageView f7700b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f7701c;

        public e(View view) {
            this.f7699a = view;
            this.f7700b = (ImageView) view.findViewById(R.id.iv_check);
            this.f7701c = (TextView) view.findViewById(R.id.txt_filter);
            f.a(this.f7700b);
            f.a(this.f7701c);
        }
    }

    public VideoFilterMultiSelectHeadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VideoFilterMultiSelectHeadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public VideoFilterMultiSelectHeadView(Context context, ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<String> arrayList3, ArrayList<String> arrayList4, ArrayList<String> arrayList5, ArrayList<String> arrayList6, d dVar) {
        super(context);
        this.f7691a = context;
        long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        if (arrayList != null && arrayList.size() > 0) {
            int size = arrayList.size();
            this.f7692b = new ArrayList(size + 1);
            FilterBean filterBean = new FilterBean(com.zte.iptvclient.android.common.i.a.a.a(R.string.filter_all_genre));
            filterBean.a(true);
            this.f7692b.add(filterBean);
            for (int i = 0; i < size; i++) {
                this.f7692b.add(new FilterBean(arrayList.get(i)));
            }
        }
        if (arrayList2 != null && arrayList2.size() > 0) {
            int size2 = arrayList2.size();
            this.f7693c = new ArrayList(size2 + 1);
            FilterBean filterBean2 = new FilterBean(com.zte.iptvclient.android.common.i.a.a.a(R.string.filter_all_year));
            filterBean2.a(true);
            this.f7693c.add(filterBean2);
            for (int i2 = 0; i2 < size2; i2++) {
                this.f7693c.add(new FilterBean(arrayList2.get(i2)));
            }
        }
        if (arrayList3 != null && arrayList3.size() > 0) {
            int size3 = arrayList3.size();
            this.f7694d = new ArrayList(size3 + 1);
            FilterBean filterBean3 = new FilterBean(com.zte.iptvclient.android.common.i.a.a.a(R.string.filter_all_country));
            filterBean3.a(true);
            this.f7694d.add(filterBean3);
            for (int i3 = 0; i3 < size3; i3++) {
                this.f7694d.add(new FilterBean(arrayList3.get(i3)));
            }
        }
        if (arrayList4 != null && arrayList4.size() > 0) {
            int size4 = arrayList4.size();
            this.e = new ArrayList(size4 + 1);
            FilterBean filterBean4 = new FilterBean(com.zte.iptvclient.android.common.i.a.a.a(R.string.filter_all_rating));
            filterBean4.a(true);
            this.e.add(filterBean4);
            for (int i4 = 0; i4 < size4; i4++) {
                String str = arrayList4.get(i4);
                if (a(str)) {
                    this.e.add(new FilterBean(str));
                }
            }
            if (this.e.size() == 1) {
                this.e.clear();
            }
        }
        if (arrayList5 != null && arrayList5.size() > 0) {
            int size5 = arrayList5.size();
            this.f = new ArrayList(size5 + 1);
            FilterBean filterBean5 = new FilterBean(com.zte.iptvclient.android.common.i.a.a.a(R.string.filter_all_film));
            filterBean5.a(true);
            this.f.add(filterBean5);
            for (int i5 = 0; i5 < size5; i5++) {
                this.f.add(new FilterBean(arrayList5.get(i5)));
            }
        }
        if (arrayList6 != null && arrayList6.size() > 0) {
            int size6 = arrayList6.size();
            this.g = new ArrayList<>(size6 + 1);
            FilterBean filterBean6 = new FilterBean(com.zte.iptvclient.android.common.i.a.a.a(R.string.filter_all_age));
            filterBean6.a(true);
            this.g.add(filterBean6);
            for (int i6 = 0; i6 < size6; i6++) {
                this.g.add(new FilterBean(arrayList6.get(i6)));
            }
        }
        LogEx.d("VideoFilterMultiSelectHeadView", "VideoFilterMultiSelectHeadView constructor..." + (SystemClock.currentThreadTimeMillis() - currentThreadTimeMillis));
        this.h = dVar;
        this.i = (LayoutInflater) context.getSystemService("layout_inflater");
        this.j = View.inflate(context, R.layout.video_popup_filter, this);
        a();
        b();
    }

    private void b() {
        long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        List<FilterBean> list = this.f7692b;
        int i = 1;
        if (list == null || list.isEmpty()) {
            i = 0;
        } else {
            a(0, this.f7692b, 1);
        }
        List<FilterBean> list2 = this.f7694d;
        if (list2 != null && !list2.isEmpty()) {
            a(i, this.f7694d, 2);
            i++;
        }
        List<FilterBean> list3 = this.f7693c;
        if (list3 != null && !list3.isEmpty()) {
            a(i, this.f7693c, 3);
            i++;
        }
        if (c()) {
            ArrayList<FilterBean> arrayList = this.g;
            if (arrayList != null && !arrayList.isEmpty()) {
                a(i, this.g, 6);
                i++;
            }
        } else {
            List<FilterBean> list4 = this.e;
            if (list4 != null && !list4.isEmpty()) {
                a(i, this.e, 4);
                i++;
            }
        }
        List<FilterBean> list5 = this.f;
        if (list5 != null && !list5.isEmpty()) {
            a(i, this.f, 5);
        }
        LogEx.d("VideoFilterMultiSelectHeadView", "createFilters..." + (SystemClock.currentThreadTimeMillis() - currentThreadTimeMillis));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(List<FilterBean> list) {
        if (list == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                if (list.get(0).b()) {
                    return null;
                }
            } else if (list.get(i).b()) {
                stringBuffer.append(list.get(i).a() + ";");
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.endsWith(";") ? stringBuffer2.substring(0, stringBuffer2.length() - 1) : stringBuffer2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d() {
        int g = g.g(this.f7691a);
        LogEx.d("VideoFilterMultiSelectHeadView", " envIndex: " + g);
        if (g == 1) {
            return com.zte.iptvclient.android.common.i.a.a.a(R.string.filter_all_country);
        }
        return com.zte.iptvclient.android.common.i.a.a.a(R.string.filter_all_rating);
    }

    private boolean a(String str) {
        return (TextUtils.isEmpty(str) || str.trim().startsWith(":") || str.trim().endsWith(":") || str.length() - str.replace(":", "").length() != 1) ? false : true;
    }

    private void a() {
        Button button = (Button) this.j.findViewById(R.id.btn_ok);
        this.l = button;
        button.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_ok));
        this.k = (LinearLayout) this.j.findViewById(R.id.ll_filter_container);
        f.a(this.l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(List<FilterBean> list) {
        if (list == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                if (list.get(0).b()) {
                    return null;
                }
            } else if (list.get(i).b()) {
                String a2 = list.get(i).a();
                stringBuffer.append(a2.substring(0, a2.indexOf(":")) + ";");
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.endsWith(";") ? stringBuffer2.substring(0, stringBuffer2.length() - 1) : stringBuffer2;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void a(int i, List<FilterBean> list, int i2) {
        LinearLayout linearLayout = (LinearLayout) this.i.inflate(R.layout.video_filter_row_2, (ViewGroup) null);
        HListView hListView = (HListView) linearLayout.findViewById(R.id.ll_filter);
        f.a(linearLayout);
        f.a(hListView);
        f.a(linearLayout.findViewById(R.id.line_bottom));
        this.k.addView(linearLayout);
        hListView.setAdapter((ListAdapter) new c(this.f7691a, list, i2));
        hListView.setOnTouchListener(new a(hListView));
        hListView.setOnItemClickListener(new b());
    }

    private boolean c() {
        return com.zte.iptvclient.android.mobile.home.tab.helper.a.n().a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(List<FilterBean> list) {
        if (list == null || list.get(0).b()) {
            return null;
        }
        return "1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(List<FilterBean> list) {
        if (list == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        StringBuffer stringBuffer3 = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                if (list.get(0).b()) {
                    return null;
                }
            } else {
                FilterBean filterBean = list.get(i);
                if (filterBean.b()) {
                    String a2 = filterBean.a();
                    int indexOf = a2.indexOf("-");
                    if (indexOf < 0) {
                        stringBuffer.append(a2 + ";");
                    } else if (indexOf == 0) {
                        stringBuffer2.append(a2 + ";");
                    } else {
                        stringBuffer3.append(a2 + ";");
                    }
                }
            }
        }
        String stringBuffer4 = stringBuffer.toString();
        String stringBuffer5 = stringBuffer2.toString();
        String stringBuffer6 = stringBuffer3.toString();
        if (stringBuffer4.endsWith(";")) {
            stringBuffer4 = stringBuffer4.substring(0, stringBuffer4.length() - 1);
        }
        if (stringBuffer5.endsWith(";")) {
            stringBuffer5 = stringBuffer5.substring(0, stringBuffer5.length() - 1);
        }
        if (stringBuffer6.endsWith(";")) {
            stringBuffer6 = stringBuffer6.substring(0, stringBuffer6.length() - 1);
        }
        if (TextUtils.isEmpty(stringBuffer5)) {
            stringBuffer5 = "";
        } else if (!TextUtils.isEmpty("")) {
            stringBuffer5 = "" + CapablityEnum.SPLIT_CODE + stringBuffer5;
        }
        if (TextUtils.isEmpty(stringBuffer6)) {
            stringBuffer6 = stringBuffer5;
        } else if (!TextUtils.isEmpty(stringBuffer5)) {
            stringBuffer6 = stringBuffer5 + CapablityEnum.SPLIT_CODE + stringBuffer6;
        }
        if (TextUtils.isEmpty(stringBuffer4)) {
            return stringBuffer6;
        }
        if (TextUtils.isEmpty(stringBuffer6)) {
            return stringBuffer4;
        }
        return stringBuffer6 + CapablityEnum.SPLIT_CODE + stringBuffer4;
    }
}
