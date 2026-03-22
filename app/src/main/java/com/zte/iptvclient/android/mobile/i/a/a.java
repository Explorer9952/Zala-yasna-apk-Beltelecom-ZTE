package com.zte.iptvclient.android.mobile.i.a;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.i;
import com.video.androidsdk.common.config.ConfigMgr;
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
import java.util.Iterator;

/* compiled from: AdapterDownloaded.java */
/* loaded from: classes.dex */
public class a extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private Activity f6445a;

    /* renamed from: b, reason: collision with root package name */
    private com.zte.iptvclient.android.mobile.i.b.b f6446b;

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<DownloadTask> f6447c;
    private LayoutInflater e;
    private boolean f = false;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<DownloadTask> f6448d = new ArrayList<>();

    /* compiled from: AdapterDownloaded.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(DownloadTask downloadTask);

        void b(DownloadTask downloadTask);
    }

    /* compiled from: AdapterDownloaded.java */
    /* loaded from: classes.dex */
    private static class c {

        /* renamed from: a, reason: collision with root package name */
        TextView f6449a;

        /* renamed from: b, reason: collision with root package name */
        TextView f6450b;

        /* renamed from: c, reason: collision with root package name */
        TextView f6451c;

        /* renamed from: d, reason: collision with root package name */
        TextView f6452d;
        ImageView e;
        ImageView f;
        ImageView g;
        LinearLayout h;
        View i;

        private c() {
        }
    }

    /* compiled from: AdapterDownloaded.java */
    /* loaded from: classes.dex */
    private class d implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        private c f6453a;

        /* renamed from: b, reason: collision with root package name */
        private DownloadTask f6454b;

        public d(c cVar, DownloadTask downloadTask) {
            this.f6453a = cVar;
            this.f6454b = downloadTask;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!a.this.f) {
                if (a.this.f6446b instanceof b) {
                    if ("10".equals(this.f6454b.contentType)) {
                        ((b) a.this.f6446b).b(this.f6454b);
                        return;
                    } else {
                        ((b) a.this.f6446b).a(this.f6454b);
                        return;
                    }
                }
                return;
            }
            a aVar = a.this;
            if (aVar.a((ArrayList<DownloadTask>) aVar.f6448d, this.f6454b)) {
                if (a.this.f6448d.size() == a.this.f6447c.size()) {
                    a.this.f6446b.b(false);
                }
                a.this.a(this.f6454b.videoInfo.get("taskID"), a.this.f6448d);
                this.f6453a.e.setSelected(false);
            } else {
                a.this.f6448d.add(this.f6454b);
                this.f6453a.e.setSelected(true);
                if (a.this.f6448d.size() == a.this.f6447c.size()) {
                    a.this.f6446b.b(true);
                }
            }
            a.this.f6446b.e(a.this.f6448d.size());
        }
    }

    public a(Activity activity, com.zte.iptvclient.android.mobile.i.b.b bVar, ArrayList<DownloadTask> arrayList) {
        this.e = null;
        this.f6445a = activity;
        this.f6446b = bVar;
        this.f6447c = arrayList;
        this.e = (LayoutInflater) activity.getSystemService("layout_inflater");
    }

    public void e() {
        this.f6446b.e(this.f6448d.size());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<DownloadTask> arrayList = this.f6447c;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f6447c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        c cVar;
        if (view == null) {
            cVar = new c();
            view2 = this.e.inflate(R.layout.download_downloaded_item, (ViewGroup) null);
            cVar.h = (LinearLayout) view2.findViewById(R.id.ll_item);
            cVar.f6449a = (TextView) view2.findViewById(R.id.list_item_name);
            cVar.f6450b = (TextView) view2.findViewById(R.id.list_item_size);
            cVar.f6451c = (TextView) view2.findViewById(R.id.list_item_expired);
            cVar.f6452d = (TextView) view2.findViewById(R.id.list_item_store_path);
            cVar.e = (ImageView) view2.findViewById(R.id.img_check);
            cVar.f = (ImageView) view2.findViewById(R.id.img_poster);
            cVar.g = (ImageView) view2.findViewById(R.id.img_cloud);
            cVar.i = view2.findViewById(R.id.bottom_line);
            f.a(view2.findViewById(R.id.ll_item_all));
            f.a(cVar.h);
            f.a(cVar.f6449a);
            f.a(cVar.f6450b);
            f.a(cVar.f6451c);
            f.a(cVar.e);
            f.a(cVar.f);
            f.a(cVar.f6452d);
            f.a(cVar.g);
            cVar.f6449a.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.list_item_name));
            cVar.f6450b.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.list_item_size));
            cVar.f6452d.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_filter_local));
            cVar.f6451c.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.list_item_expired_sample));
            f.a(view2.findViewById(R.id.ll_content_description));
            view2.setTag(cVar);
        } else {
            view2 = view;
            cVar = (c) view.getTag();
        }
        DownloadTask downloadTask = this.f6447c.get(i);
        Date a2 = a(downloadTask);
        cVar.f6451c.setText(a(a2));
        if (com.zte.iptvclient.android.mobile.download.helper.c.c.a(a2)) {
            cVar.f6451c.setTextColor(this.f6445a.getResources().getColor(R.color.anhui_mobile_theme));
        } else {
            cVar.f6451c.setTextColor(this.f6445a.getResources().getColor(R.color.text_grey_new3));
        }
        if ("1".equals(ConfigMgr.readPropertie("SupportRemoteDownload", "0"))) {
            if (String.valueOf(1).equals(downloadTask.videoInfo.get("downLoadType"))) {
                cVar.f6452d.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_filter_local));
                cVar.g.setVisibility(4);
            } else {
                cVar.f6452d.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_filter_stb));
                cVar.g.setVisibility(0);
            }
        } else {
            cVar.f6452d.setVisibility(4);
            cVar.g.setVisibility(4);
        }
        String str = downloadTask.videoInfo.get("coverPath");
        if (!this.f6445a.isFinishing()) {
            com.bumptech.glide.d<String> a3 = i.a(this.f6445a).a(str);
            a3.b(R.drawable.default_poster_thumb);
            a3.a(R.drawable.default_poster_thumb);
            a3.c(300);
            a3.a(cVar.f);
        }
        String a4 = g.a((int) Double.valueOf(downloadTask.videoSize).doubleValue());
        String str2 = downloadTask.videoInfo.get("videoName");
        if ("10".equals(downloadTask.contentType)) {
            a4 = a4 + "(" + downloadTask.finCount + "个视频)";
            str2 = downloadTask.videoInfo.get("seriesHeadName");
        }
        cVar.f6450b.setText(a4);
        cVar.f6449a.setText(str2);
        if (this.f) {
            cVar.e.setVisibility(0);
            if (a(this.f6448d, downloadTask)) {
                cVar.e.setSelected(true);
            } else {
                cVar.e.setSelected(false);
            }
        } else {
            cVar.e.setVisibility(8);
        }
        if (i == this.f6447c.size() - 1) {
            cVar.i.setVisibility(0);
        } else {
            cVar.i.setVisibility(8);
        }
        cVar.h.setOnClickListener(new d(cVar, downloadTask));
        return view2;
    }

    public void b() {
        this.f6448d.clear();
    }

    public ArrayList<DownloadTask> c() {
        return this.f6448d;
    }

    public void d() {
        this.f6448d = new ArrayList<>(this.f6447c);
        notifyDataSetChanged();
        this.f6446b.e(this.f6448d.size());
    }

    public void a() {
        b();
        notifyDataSetChanged();
        this.f6446b.e(this.f6448d.size());
    }

    public void a(boolean z) {
        this.f = z;
        if (z) {
            this.f6448d.clear();
        }
        notifyDataSetChanged();
    }

    public void a(ArrayList<DownloadTask> arrayList) {
        this.f6447c = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ArrayList<DownloadTask> arrayList, DownloadTask downloadTask) {
        if (arrayList != null && downloadTask != null) {
            Iterator<DownloadTask> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                if (it2.next().videoInfo.get("taskID").equals(downloadTask.videoInfo.get("taskID"))) {
                    return true;
                }
            }
        }
        return false;
    }

    public void a(String str, ArrayList<DownloadTask> arrayList) {
        if (str == null || arrayList == null) {
            return;
        }
        Iterator<DownloadTask> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (str.equals(it2.next().videoInfo.get("taskID"))) {
                it2.remove();
            }
        }
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
        return this.f6445a.getString(R.string.download_available_until) + TimeUtil.format(date, "yy/MM/dd");
    }
}
