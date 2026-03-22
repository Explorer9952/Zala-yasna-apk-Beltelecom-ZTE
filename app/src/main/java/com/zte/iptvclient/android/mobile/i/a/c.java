package com.zte.iptvclient.android.mobile.i.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.i;
import com.video.androidsdk.common.util.TimeUtil;
import com.video.androidsdk.download.bean.DownloadTask;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.k.g;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/* compiled from: AdapterDownloadedSeries.java */
/* loaded from: classes.dex */
public class c extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private Context f6467a;

    /* renamed from: b, reason: collision with root package name */
    private com.zte.iptvclient.android.mobile.i.b.b f6468b;

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<DownloadTask> f6469c;
    LayoutInflater e;
    private boolean f = false;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<DownloadTask> f6470d = new ArrayList<>();

    /* compiled from: AdapterDownloadedSeries.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(DownloadTask downloadTask);
    }

    /* compiled from: AdapterDownloadedSeries.java */
    /* renamed from: com.zte.iptvclient.android.mobile.i.a.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0275c {

        /* renamed from: a, reason: collision with root package name */
        TextView f6471a;

        /* renamed from: b, reason: collision with root package name */
        TextView f6472b;

        /* renamed from: c, reason: collision with root package name */
        TextView f6473c;

        /* renamed from: d, reason: collision with root package name */
        TextView f6474d;
        ImageView e;
        ImageView f;
        LinearLayout g;
        View h;

        private C0275c() {
        }
    }

    /* compiled from: AdapterDownloadedSeries.java */
    /* loaded from: classes.dex */
    private class d implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        private C0275c f6475a;

        /* renamed from: b, reason: collision with root package name */
        private DownloadTask f6476b;

        public d(C0275c c0275c, DownloadTask downloadTask) {
            this.f6475a = c0275c;
            this.f6476b = downloadTask;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.f) {
                if (c.this.f6470d.contains(this.f6476b)) {
                    if (c.this.f6470d.size() == c.this.f6469c.size()) {
                        c.this.f6468b.b(false);
                    }
                    c.this.f6470d.remove(this.f6476b);
                    this.f6475a.e.setSelected(false);
                } else {
                    c.this.f6470d.add(this.f6476b);
                    this.f6475a.e.setSelected(true);
                    if (c.this.f6470d.size() == c.this.f6469c.size()) {
                        c.this.f6468b.b(true);
                    }
                }
                c.this.f6468b.e(c.this.f6470d.size());
                return;
            }
            if (c.this.f6468b instanceof b) {
                ((b) c.this.f6468b).a(this.f6476b);
            }
        }
    }

    public c(Context context, com.zte.iptvclient.android.mobile.i.b.b bVar, ArrayList<DownloadTask> arrayList) {
        this.e = null;
        this.f6467a = context;
        this.f6468b = bVar;
        this.f6469c = arrayList;
        this.e = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f6469c.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f6469c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        C0275c c0275c;
        if (view == null) {
            c0275c = new C0275c();
            view2 = this.e.inflate(R.layout.download_downloaded_series_item, (ViewGroup) null);
            c0275c.g = (LinearLayout) view2.findViewById(R.id.ll_item);
            c0275c.f6471a = (TextView) view2.findViewById(R.id.list_item_name);
            c0275c.f6472b = (TextView) view2.findViewById(R.id.list_item_size);
            c0275c.f6473c = (TextView) view2.findViewById(R.id.list_item_expired);
            c0275c.e = (ImageView) view2.findViewById(R.id.img_check);
            c0275c.f = (ImageView) view2.findViewById(R.id.img_poster);
            c0275c.f6474d = (TextView) view2.findViewById(R.id.tv_series_index);
            c0275c.h = view2.findViewById(R.id.bottom_line);
            f.a(c0275c.f6471a);
            f.a(c0275c.f6472b);
            f.a(c0275c.f6473c);
            f.a(c0275c.e);
            f.a(c0275c.f);
            f.a(c0275c.f6474d);
            f.a(c0275c.g);
            f.a(view2.findViewById(R.id.ll_content_description));
            c0275c.f6471a.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.list_item_name));
            c0275c.f6472b.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.list_item_size));
            c0275c.f6473c.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.list_item_expired_sample));
            view2.setTag(c0275c);
        } else {
            view2 = view;
            c0275c = (C0275c) view.getTag();
        }
        DownloadTask downloadTask = this.f6469c.get(i);
        String str = downloadTask.videoInfo.get("coverPath");
        Context context = this.f6467a;
        if (context != null && !((Activity) context).isFinishing()) {
            com.bumptech.glide.d<String> a2 = i.b(this.f6467a).a(str);
            a2.b(R.drawable.default_poster_thumb);
            a2.a(R.drawable.default_poster_thumb);
            a2.c(300);
            a2.a(c0275c.f);
        }
        if ("11".equals(downloadTask.contentType)) {
            String str2 = downloadTask.videoInfo.get("seriesIndex");
            if (this.f6467a != null && !TextUtils.isEmpty(str2)) {
                c0275c.f6474d.setVisibility(0);
                c0275c.f6474d.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_series_index), Integer.valueOf(str2)));
            }
        } else {
            c0275c.f6474d.setVisibility(8);
        }
        c0275c.f6471a.setText(downloadTask.videoInfo.get("videoName"));
        Date a3 = a(downloadTask);
        c0275c.f6473c.setText(a(a3));
        if (this.f6467a != null) {
            if (com.zte.iptvclient.android.mobile.download.helper.c.c.a(a3)) {
                c0275c.f6473c.setTextColor(this.f6467a.getResources().getColor(R.color.anhui_mobile_theme));
            } else {
                c0275c.f6473c.setTextColor(this.f6467a.getResources().getColor(R.color.text_grey_new3));
            }
        }
        c0275c.f6472b.setText(g.a((int) Double.valueOf(downloadTask.videoSize).doubleValue()));
        if (this.f) {
            c0275c.e.setVisibility(0);
            if (this.f6470d.contains(downloadTask)) {
                c0275c.e.setSelected(true);
            } else {
                c0275c.e.setSelected(false);
            }
        } else {
            c0275c.e.setVisibility(8);
        }
        if (i == this.f6469c.size() - 1) {
            c0275c.h.setVisibility(0);
        } else {
            c0275c.h.setVisibility(8);
        }
        c0275c.g.setOnClickListener(new d(c0275c, downloadTask));
        return view2;
    }

    public void a() {
        b();
        notifyDataSetChanged();
        this.f6468b.e(this.f6470d.size());
    }

    public void b() {
        this.f6470d.clear();
    }

    public ArrayList<DownloadTask> c() {
        return this.f6470d;
    }

    public void d() {
        this.f6470d = new ArrayList<>(this.f6469c);
        notifyDataSetChanged();
        this.f6468b.e(this.f6470d.size());
    }

    public void a(boolean z) {
        this.f = z;
        if (z) {
            this.f6470d.clear();
        }
        notifyDataSetChanged();
    }

    public void a(ArrayList<DownloadTask> arrayList) {
        this.f6469c = arrayList;
    }

    private Date a(DownloadTask downloadTask) {
        String str = downloadTask.videoInfo.get("expiredDate");
        Date date = new Date();
        try {
            return new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").parse(str);
        } catch (ParseException unused) {
            LogEx.d("AdapterDownloaded", "Parse expiredDateStr : " + str + " failed!");
            return date;
        }
    }

    private String a(Date date) {
        if (this.f6467a == null) {
            return "";
        }
        return com.zte.iptvclient.android.common.i.a.a.a(R.string.download_available_until) + TimeUtil.format(date, "yy/MM/dd");
    }
}
