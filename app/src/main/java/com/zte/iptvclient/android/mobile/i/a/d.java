package com.zte.iptvclient.android.mobile.i.a;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.i;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.download.bean.DownloadTask;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.k.g;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: AdapterDownloading.java */
/* loaded from: classes.dex */
public class d extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private Activity f6478a;

    /* renamed from: b, reason: collision with root package name */
    private com.zte.iptvclient.android.mobile.i.b.b f6479b;

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<DownloadTask> f6480c;
    LayoutInflater e;
    private List<Map<String, String>> f;
    private boolean g = false;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<DownloadTask> f6481d = new ArrayList<>();

    /* compiled from: AdapterDownloading.java */
    /* loaded from: classes.dex */
    public interface b {
        void c(DownloadTask downloadTask);
    }

    /* compiled from: AdapterDownloading.java */
    /* loaded from: classes.dex */
    private static class c {

        /* renamed from: a, reason: collision with root package name */
        TextView f6482a;

        /* renamed from: b, reason: collision with root package name */
        TextView f6483b;

        /* renamed from: c, reason: collision with root package name */
        TextView f6484c;

        /* renamed from: d, reason: collision with root package name */
        TextView f6485d;
        TextView e;
        TextView f;
        ImageView g;
        ImageView h;
        ImageView i;
        ImageView j;
        FrameLayout k;
        LinearLayout l;
        RelativeLayout m;
        ProgressBar n;
        ProgressBar o;
        View p;

        private c() {
        }
    }

    /* compiled from: AdapterDownloading.java */
    /* renamed from: com.zte.iptvclient.android.mobile.i.a.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class ViewOnClickListenerC0276d implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        private c f6486a;

        /* renamed from: b, reason: collision with root package name */
        private DownloadTask f6487b;

        public ViewOnClickListenerC0276d(c cVar, DownloadTask downloadTask) {
            this.f6486a = cVar;
            this.f6487b = downloadTask;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!d.this.g) {
                if (d.this.f6479b instanceof b) {
                    ((b) d.this.f6479b).c(this.f6487b);
                    return;
                }
                return;
            }
            d dVar = d.this;
            if (dVar.a((ArrayList<DownloadTask>) dVar.f6481d, this.f6487b)) {
                if (d.this.f6481d.size() == d.this.f6480c.size()) {
                    d.this.f6479b.b(false);
                }
                d.this.a(this.f6487b.videoInfo.get("taskID"), d.this.f6481d);
                this.f6486a.g.setSelected(false);
            } else {
                d.this.f6481d.add(this.f6487b);
                this.f6486a.g.setSelected(true);
                if (d.this.f6481d.size() == d.this.f6480c.size()) {
                    d.this.f6479b.b(true);
                }
            }
            d.this.f6479b.e(d.this.f6481d.size());
        }
    }

    public d(Activity activity, com.zte.iptvclient.android.mobile.i.b.b bVar, ArrayList<DownloadTask> arrayList) {
        this.e = null;
        this.f6478a = activity;
        this.f6479b = bVar;
        this.f6480c = arrayList;
        this.e = (LayoutInflater) activity.getSystemService("layout_inflater");
    }

    public void e() {
        this.f6479b.e(this.f6481d.size());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<DownloadTask> arrayList = this.f6480c;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f6480c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        View view2;
        if (view == null) {
            cVar = new c();
            view2 = this.e.inflate(R.layout.download_downloading_item, (ViewGroup) null);
            cVar.l = (LinearLayout) view2.findViewById(R.id.ll_item);
            cVar.f6482a = (TextView) view2.findViewById(R.id.list_item_name);
            cVar.f6483b = (TextView) view2.findViewById(R.id.list_item_size);
            cVar.f6484c = (TextView) view2.findViewById(R.id.list_item_status);
            cVar.f6485d = (TextView) view2.findViewById(R.id.list_item_store_path);
            cVar.g = (ImageView) view2.findViewById(R.id.img_check);
            cVar.i = (ImageView) view2.findViewById(R.id.img_poster_paused);
            cVar.h = (ImageView) view2.findViewById(R.id.img_poster);
            cVar.j = (ImageView) view2.findViewById(R.id.img_cloud);
            cVar.k = (FrameLayout) view2.findViewById(R.id.fl_poster);
            cVar.m = (RelativeLayout) view2.findViewById(R.id.rl_processbar);
            cVar.n = (ProgressBar) view2.findViewById(R.id.downloading_progressbar_light);
            cVar.o = (ProgressBar) view2.findViewById(R.id.downloading_progressbar_dark);
            cVar.p = view2.findViewById(R.id.bottom_line);
            cVar.e = (TextView) view2.findViewById(R.id.tv_series_index);
            cVar.f = (TextView) view2.findViewById(R.id.txt_download_speed);
            f.a(view2.findViewById(R.id.ll_item_all));
            f.a(cVar.l);
            f.a(cVar.f6482a);
            f.a(cVar.f6483b);
            f.a(cVar.f6484c);
            f.a(cVar.g);
            f.a(cVar.h);
            f.a(cVar.i);
            f.a(cVar.k);
            f.a(cVar.m);
            f.a(cVar.n);
            f.a(cVar.o);
            f.a(cVar.f6485d);
            f.a(cVar.j);
            f.a(cVar.e);
            f.a(cVar.f);
            cVar.f6482a.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.list_item_name));
            cVar.f6485d.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_filter_local));
            cVar.f6483b.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.list_item_size));
            cVar.f6484c.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.list_item_status));
            view2.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
            view2 = view;
        }
        if (TextUtils.equals(com.zte.fragmentlib.publicbaseclass.skinloader.b.f4075b, "white.skin")) {
            cVar.o.setVisibility(8);
            cVar.n.setVisibility(0);
        } else {
            cVar.o.setVisibility(0);
            cVar.n.setVisibility(8);
        }
        DownloadTask downloadTask = this.f6480c.get(i);
        cVar.f6482a.setText(downloadTask.videoInfo.get("videoName"));
        if ("11".equals(downloadTask.contentType)) {
            String str = downloadTask.videoInfo.get("seriesIndex");
            if (!TextUtils.isEmpty(str)) {
                cVar.e.setVisibility(0);
                cVar.e.setText(String.format(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_series_index), Integer.valueOf(str)));
            }
        } else {
            cVar.e.setVisibility(8);
        }
        double doubleValue = Double.valueOf(downloadTask.downloadSize).doubleValue();
        double doubleValue2 = Double.valueOf(downloadTask.videoSize).doubleValue();
        cVar.f6483b.setText(g.a((int) doubleValue) + "/" + g.a((int) doubleValue2));
        if (!TextUtils.isEmpty(downloadTask.progress)) {
            cVar.o.setProgress(Integer.parseInt(downloadTask.progress));
            cVar.n.setProgress(Integer.parseInt(downloadTask.progress));
        } else {
            int i2 = (int) (((doubleValue * 1.0d) / doubleValue2) * 100.0d);
            cVar.o.setProgress(i2);
            cVar.n.setProgress(i2);
        }
        if ("1".equals(ConfigMgr.readPropertie("SupportRemoteDownload", "0"))) {
            if (String.valueOf(1).equals(downloadTask.videoInfo.get("downLoadType"))) {
                cVar.f6485d.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_filter_local));
                cVar.j.setVisibility(4);
            } else {
                cVar.f6485d.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.download_filter_stb));
                cVar.j.setVisibility(0);
            }
        } else {
            cVar.f6485d.setVisibility(4);
            cVar.j.setVisibility(4);
        }
        int intValue = Integer.valueOf(downloadTask.status).intValue();
        cVar.f6484c.setText(a(intValue));
        if (intValue == 1) {
            cVar.f6484c.setTextColor(c.a.a.a.d.b.d().b(R.color.mine_download_rate_textcolor));
            ((SupportActivity) this.f6478a).a(cVar.f6484c, "textColor", R.color.mine_download_rate_textcolor);
            cVar.f.setVisibility(0);
        } else {
            cVar.f6484c.setTextColor(c.a.a.a.d.b.d().b(R.color.mine_download_size_textcolor));
            ((SupportActivity) this.f6478a).a(cVar.f6484c, "textColor", R.color.mine_download_size_textcolor);
            cVar.f.setVisibility(8);
        }
        if (intValue == -1) {
            cVar.i.setVisibility(0);
        } else {
            cVar.i.setVisibility(8);
        }
        if (intValue == 0) {
            cVar.m.setVisibility(8);
        } else {
            cVar.m.setVisibility(0);
        }
        String str2 = downloadTask.videoInfo.get("coverPath");
        Activity activity = this.f6478a;
        if (activity != null && !activity.isFinishing()) {
            com.bumptech.glide.d<String> a2 = i.a(this.f6478a).a(str2);
            a2.b(R.drawable.default_poster_thumb);
            a2.a(R.drawable.default_poster_thumb);
            a2.c(300);
            a2.a(cVar.h);
        }
        List<Map<String, String>> list = this.f;
        if (list != null) {
            Iterator<Map<String, String>> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Map<String, String> next = it2.next();
                String str3 = downloadTask.videoId;
                if (str3 != null && str3.equals(next.get("videoid"))) {
                    cVar.f.setText(a(next.get("downloadspeed")));
                    break;
                }
            }
        }
        if (this.g) {
            cVar.g.setVisibility(0);
            if (a(this.f6481d, downloadTask)) {
                cVar.g.setSelected(true);
            } else {
                cVar.g.setSelected(false);
            }
        } else {
            cVar.g.setVisibility(8);
        }
        if (i == this.f6480c.size() - 1) {
            cVar.p.setVisibility(0);
        } else {
            cVar.p.setVisibility(8);
        }
        cVar.l.setOnClickListener(new ViewOnClickListenerC0276d(cVar, downloadTask));
        return view2;
    }

    public void b() {
        this.f6481d.clear();
    }

    public ArrayList<DownloadTask> c() {
        return this.f6481d;
    }

    public void d() {
        this.f6481d = new ArrayList<>(this.f6480c);
        notifyDataSetChanged();
        this.f6479b.e(this.f6481d.size());
    }

    public void a(List<Map<String, String>> list) {
        this.f = list;
    }

    public void a() {
        b();
        notifyDataSetChanged();
        this.f6479b.e(this.f6481d.size());
    }

    public void a(boolean z) {
        this.g = z;
        if (z) {
            this.f6481d.clear();
        }
        notifyDataSetChanged();
    }

    public void a(ArrayList<DownloadTask> arrayList) {
        this.f6480c = arrayList;
    }

    private String a(int i) {
        if (i == -1) {
            return com.zte.iptvclient.android.common.i.a.a.a(R.string.paused);
        }
        if (i != 1) {
            return (i == 2 || i == 3) ? com.zte.iptvclient.android.common.i.a.a.a(R.string.waiting_for_download) : "";
        }
        return com.zte.iptvclient.android.common.i.a.a.a(R.string.download_tag_downloading);
    }

    private String a(String str) {
        if (Integer.valueOf(str).intValue() >= 1024) {
            return new DecimalFormat("#.0").format(r0 / 1024.0f) + "M/s";
        }
        return str + "KB/s";
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
}
