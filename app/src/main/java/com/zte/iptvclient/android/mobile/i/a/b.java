package com.zte.iptvclient.android.mobile.i.a;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.i;
import com.video.androidsdk.download.bean.DownloadTask;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: AdapterDownloadedAT.java */
/* loaded from: classes.dex */
public class b extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private Activity f6456a;

    /* renamed from: b, reason: collision with root package name */
    private com.zte.iptvclient.android.mobile.i.b.b f6457b;

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<DownloadTask> f6458c;
    private LayoutInflater e;
    private boolean f = false;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<DownloadTask> f6459d = new ArrayList<>();

    /* compiled from: AdapterDownloadedAT.java */
    /* renamed from: com.zte.iptvclient.android.mobile.i.a.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0274b {
        void a(DownloadTask downloadTask);

        void b(DownloadTask downloadTask);
    }

    /* compiled from: AdapterDownloadedAT.java */
    /* loaded from: classes.dex */
    private class c implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        private d f6460a;

        /* renamed from: b, reason: collision with root package name */
        private DownloadTask f6461b;

        public c(d dVar, DownloadTask downloadTask) {
            this.f6460a = dVar;
            this.f6461b = downloadTask;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!b.this.f) {
                if (b.this.f6457b instanceof InterfaceC0274b) {
                    if ("10".equals(this.f6461b.contentType)) {
                        ((InterfaceC0274b) b.this.f6457b).b(this.f6461b);
                        return;
                    } else {
                        ((InterfaceC0274b) b.this.f6457b).a(this.f6461b);
                        return;
                    }
                }
                return;
            }
            b bVar = b.this;
            if (bVar.a((ArrayList<DownloadTask>) bVar.f6459d, this.f6461b)) {
                if (b.this.f6459d.size() == b.this.f6458c.size()) {
                    b.this.f6457b.b(false);
                }
                b.this.a(this.f6461b.videoInfo.get("taskID"), b.this.f6459d);
                this.f6460a.f6466d.setVisibility(8);
            } else {
                b.this.f6459d.add(this.f6461b);
                this.f6460a.f6466d.setVisibility(0);
                if (b.this.f6459d.size() == b.this.f6458c.size()) {
                    b.this.f6457b.b(true);
                }
            }
            b.this.f6457b.e(b.this.f6459d.size());
        }
    }

    /* compiled from: AdapterDownloadedAT.java */
    /* loaded from: classes.dex */
    private static class d {

        /* renamed from: a, reason: collision with root package name */
        TextView f6463a;

        /* renamed from: b, reason: collision with root package name */
        ImageView f6464b;

        /* renamed from: c, reason: collision with root package name */
        RelativeLayout f6465c;

        /* renamed from: d, reason: collision with root package name */
        RelativeLayout f6466d;
        RelativeLayout e;

        private d() {
        }
    }

    public b(Activity activity, com.zte.iptvclient.android.mobile.i.b.b bVar, ArrayList<DownloadTask> arrayList) {
        this.e = null;
        this.f6456a = activity;
        this.f6457b = bVar;
        this.f6458c = arrayList;
        this.e = (LayoutInflater) activity.getSystemService("layout_inflater");
    }

    public void e() {
        this.f6457b.e(this.f6459d.size());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<DownloadTask> arrayList = this.f6458c;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f6458c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        d dVar;
        if (view == null) {
            dVar = new d();
            view2 = this.e.inflate(R.layout.at_download_downloaded_item, (ViewGroup) null);
            dVar.f6465c = (RelativeLayout) view2.findViewById(R.id.ll_item);
            dVar.f6463a = (TextView) view2.findViewById(R.id.list_item_name);
            dVar.f6464b = (ImageView) view2.findViewById(R.id.img_poster);
            dVar.f6466d = (RelativeLayout) view2.findViewById(R.id.rl_del_selected);
            dVar.e = (RelativeLayout) view2.findViewById(R.id.rl_del_select);
            f.a(dVar.f6465c);
            f.a(dVar.f6463a);
            f.a(dVar.f6464b);
            f.a(dVar.f6466d);
            f.a(dVar.e);
            f.a(view2.findViewById(R.id.img_del_selected));
            f.a(view2.findViewById(R.id.img_del_select));
            f.a(view2.findViewById(R.id.ll_content_description));
            view2.setTag(dVar);
        } else {
            view2 = view;
            dVar = (d) view.getTag();
        }
        DownloadTask downloadTask = this.f6458c.get(i);
        String str = downloadTask.videoInfo.get("coverPath");
        Activity activity = this.f6456a;
        if (activity != null && !activity.isFinishing()) {
            com.bumptech.glide.d<String> a2 = i.a(this.f6456a).a(str);
            a2.b(R.drawable.default_poster_thumb);
            a2.a(R.drawable.default_poster_thumb);
            a2.c(300);
            a2.a(dVar.f6464b);
        }
        String str2 = downloadTask.videoInfo.get("videoName");
        if ("10".equals(downloadTask.contentType)) {
            str2 = downloadTask.videoInfo.get("seriesHeadName");
        }
        dVar.f6463a.setText(str2);
        if (this.f && a(this.f6459d, downloadTask)) {
            dVar.f6466d.setVisibility(0);
        } else {
            dVar.f6466d.setVisibility(8);
        }
        if (this.f) {
            dVar.e.setVisibility(0);
        } else {
            dVar.e.setVisibility(8);
        }
        dVar.f6465c.setOnClickListener(new c(dVar, downloadTask));
        return view2;
    }

    public void b() {
        this.f6459d.clear();
    }

    public ArrayList<DownloadTask> c() {
        return this.f6459d;
    }

    public void d() {
        this.f6459d = new ArrayList<>(this.f6458c);
        notifyDataSetChanged();
        this.f6457b.e(this.f6459d.size());
    }

    public void a() {
        b();
        notifyDataSetChanged();
        this.f6457b.e(this.f6459d.size());
    }

    public void a(boolean z) {
        this.f = z;
        if (z) {
            this.f6459d.clear();
        }
        notifyDataSetChanged();
    }

    public void a(ArrayList<DownloadTask> arrayList) {
        this.f6458c = arrayList;
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
