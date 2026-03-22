package com.zte.iptvclient.android.common.player;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.video.androidsdk.common.GlobalConst;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.zala.R;
import com.zte.servicesdk.util.PortalConst;
import java.util.ArrayList;

/* compiled from: VideoSelectPopwindow.java */
/* loaded from: classes.dex */
public class h extends PopupWindow {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<String> f4919a;

    /* renamed from: b, reason: collision with root package name */
    private String f4920b;

    /* renamed from: c, reason: collision with root package name */
    private Context f4921c;

    /* renamed from: d, reason: collision with root package name */
    private View f4922d;
    private String e;
    private int f;
    private ListView g;
    private c h;
    private b i;
    private TextView j;
    private int k;
    private String l;
    private String m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoSelectPopwindow.java */
    /* loaded from: classes.dex */
    public class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            View childAt;
            if (h.this.f == i) {
                return;
            }
            int firstVisiblePosition = h.this.g.getFirstVisiblePosition();
            LogEx.d("VideoSelectPopwindow", "ifirstPosition-----" + firstVisiblePosition);
            LogEx.d("VideoSelectPopwindow", "mSelectedIndex-------" + h.this.f);
            LogEx.d("VideoSelectPopwindow", "iselectedIndex-------" + i);
            if (h.this.f >= 0 && (childAt = h.this.g.getChildAt(h.this.f - firstVisiblePosition)) != null) {
                ((d) childAt.getTag()).f4926a.setVisibility(4);
            }
            if (i >= 0) {
                View childAt2 = h.this.g.getChildAt(i - firstVisiblePosition);
                if (childAt2 != null) {
                    ((d) childAt2.getTag()).f4926a.setVisibility(0);
                }
                h.this.f = i;
                h hVar = h.this;
                hVar.e = (String) hVar.f4919a.get(i);
                h.this.i.a(h.this.e);
            }
        }
    }

    /* compiled from: VideoSelectPopwindow.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(String str);
    }

    /* compiled from: VideoSelectPopwindow.java */
    /* loaded from: classes.dex */
    public class c extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        LayoutInflater f4924a;

        public c() {
            this.f4924a = (LayoutInflater) h.this.f4921c.getSystemService("layout_inflater");
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (h.this.f4919a == null) {
                return 0;
            }
            return h.this.f4919a.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (h.this.f4919a == null) {
                return null;
            }
            return h.this.f4919a.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            d dVar;
            String b2;
            if (view == null) {
                view = this.f4924a.inflate(R.layout.player_videoselect_list_item, (ViewGroup) null);
                dVar = new d(null);
                dVar.f4926a = (ImageView) view.findViewById(R.id.imgview_video_selected);
                dVar.f4927b = (TextView) view.findViewById(R.id.txtvew_full_screen_video);
                com.zte.iptvclient.common.uiframe.f.a(dVar.f4926a);
                com.zte.iptvclient.common.uiframe.f.a(dVar.f4927b);
                view.setTag(dVar);
            } else {
                dVar = (d) view.getTag();
            }
            String str = (String) h.this.f4919a.get(i);
            if (TextUtils.equals(h.this.f4920b, "Megogo")) {
                b2 = str;
            } else {
                b2 = TextUtils.equals(h.this.f4920b, "ivi") ? h.this.b(str) : h.this.a(str);
            }
            if (DownloadConstant.REPORT_MSGTYPE_ADD.equals(str)) {
                dVar.f4927b.setText(R.string.play_vedio_type_local);
            } else if (DownloadConstant.REPORT_MSGTYPE_URL_NULL.equals(str)) {
                dVar.f4927b.setText(R.string.play_vedio_type_hc);
            } else {
                dVar.f4927b.setText(b2);
            }
            if (h.this.e.equals(str)) {
                dVar.f4926a.setVisibility(0);
                h.this.f = i;
            } else {
                dVar.f4926a.setVisibility(4);
            }
            return view;
        }
    }

    /* compiled from: VideoSelectPopwindow.java */
    /* loaded from: classes.dex */
    private static class d extends com.zte.iptvclient.common.uiframe.d {

        /* renamed from: a, reason: collision with root package name */
        ImageView f4926a;

        /* renamed from: b, reason: collision with root package name */
        TextView f4927b;

        private d() {
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    public h(Context context, ArrayList<String> arrayList, String str) {
        super(context);
        String str2;
        this.f4919a = new ArrayList<>();
        this.f4920b = "";
        this.l = "";
        this.m = "";
        this.f4921c = context;
        this.f4919a = arrayList;
        this.f4920b = str;
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.player_videoselect_list, (ViewGroup) null);
        this.f4922d = inflate;
        this.g = (ListView) inflate.findViewById(R.id.listvew_player_video);
        this.j = (TextView) this.f4922d.findViewById(R.id.txt_megogo_best);
        com.zte.iptvclient.common.uiframe.f.a(this.f4922d);
        com.zte.iptvclient.common.uiframe.f.a(this.g);
        com.zte.iptvclient.common.uiframe.f.a(this.j);
        String c2 = com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_RATE_DEFINITION_LEVEL);
        this.l = c2;
        if (!TextUtils.isEmpty(c2)) {
            this.l.split(",");
        }
        String c3 = com.zte.iptvclient.common.uiframe.a.c(PortalConst.STR_RATE_DEFINITION_TITLE);
        this.m = c3;
        if (!TextUtils.isEmpty(c3)) {
            this.m.split(",");
        }
        if (TextUtils.equals(str, "Megogo")) {
            str2 = "1111111111111";
        } else {
            str2 = TextUtils.equals(str, "ivi") ? "1111111111" : "1111111";
        }
        this.j.setText(str2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.j.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredWidth = this.j.getMeasuredWidth();
        this.k = measuredWidth;
        double d2 = measuredWidth;
        Double.isNaN(d2);
        int i = (int) (d2 * 1.5d);
        this.k = i;
        setWidth(i);
        setHeight(-2);
        setContentView(this.f4922d);
        setBackgroundDrawable(new BitmapDrawable());
        setOutsideTouchable(true);
        setFocusable(true);
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(String str) {
        if ("MP4-lo".equals(str)) {
            return this.f4921c.getResources().getString(R.string.low);
        }
        if ("MP4-hi".equals(str)) {
            return this.f4921c.getResources().getString(R.string.high);
        }
        if ("MP4-mobile".equals(str)) {
            return this.f4921c.getResources().getString(R.string.low);
        }
        if ("MP4-low-mobile".equals(str)) {
            return this.f4921c.getResources().getString(R.string.low);
        }
        if ("MP4-SHQ".equals(str)) {
            return this.f4921c.getResources().getString(R.string.excellent);
        }
        if ("MP4-HD720".equals(str)) {
            return this.f4921c.getResources().getString(R.string.hd_720);
        }
        if ("MP4-HD1080".equals(str)) {
            return this.f4921c.getResources().getString(R.string.hd_1080);
        }
        if ("MP4-TAB-HD720".equals(str)) {
            return this.f4921c.getResources().getString(R.string.hd_720);
        }
        if ("MP4-TAB-HD1080".equals(str)) {
            return this.f4921c.getResources().getString(R.string.hd_1080);
        }
        if ("MP4-4KHDR".equals(str)) {
            return this.f4921c.getResources().getString(R.string.hdr_4k);
        }
        if ("MP4-4KDV".equals(str) || "MP4-UHD".equals(str) || "MP4-UHD12".equals(str) || "MP4-UHD20".equals(str)) {
            return "4K";
        }
        if ("MP4-4KHDR12".equals(str)) {
            return this.f4921c.getResources().getString(R.string.hdr_4k);
        }
        if ("MP4-4KHDR20".equals(str)) {
            return this.f4921c.getResources().getString(R.string.hdr_4k);
        }
        if ("MP4-SHQ-TP".equals(str)) {
            return this.f4921c.getResources().getString(R.string.excellent);
        }
        if ("MP4-HD1080-TP".equals(str)) {
            return this.f4921c.getResources().getString(R.string.hd_1080);
        }
        if ("MP4-TAB-HD1080-TP".equals(str)) {
            return this.f4921c.getResources().getString(R.string.hd_1080);
        }
        if ("MP4-HD1080-L2".equals(str)) {
            return this.f4921c.getResources().getString(R.string.hd_1080);
        }
        if ("MP4-TAB-HD1080-L2".equals(str)) {
            return this.f4921c.getResources().getString(R.string.hd_1080);
        }
        if ("MP4-SHQ-L2".equals(str)) {
            return this.f4921c.getResources().getString(R.string.excellent);
        }
        if ("MP4-SHQ-L4".equals(str)) {
            return this.f4921c.getResources().getString(R.string.excellent);
        }
        if ("MP4-TAB-HD720-TP".equals(str)) {
            return this.f4921c.getResources().getString(R.string.hd_720);
        }
        if ("MP4-TAB-HD720-L2".equals(str)) {
            return this.f4921c.getResources().getString(R.string.hd_720);
        }
        if ("MP4irwma-lo".equals(str)) {
            return this.f4921c.getResources().getString(R.string.low);
        }
        if ("MP4irwma-hi".equals(str)) {
            return this.f4921c.getResources().getString(R.string.high);
        }
        if ("MP4irwma-SHQ".equals(str)) {
            return this.f4921c.getResources().getString(R.string.excellent);
        }
        if ("MP4irwma-HD720".equals(str)) {
            return this.f4921c.getResources().getString(R.string.hd_720);
        }
        if ("MP4irwma-HD1080".equals(str)) {
            return this.f4921c.getResources().getString(R.string.hd_1080);
        }
        if ("MP4irwma-UHD12".equals(str)) {
            return this.f4921c.getResources().getString(R.string.uhd_4k);
        }
        if ("MP4irwma-UHD20".equals(str)) {
            return this.f4921c.getResources().getString(R.string.uhd_4k);
        }
        if ("MP4irwma-4KHDR12".equals(str)) {
            return this.f4921c.getResources().getString(R.string.uhd_hdr_4k);
        }
        if ("MP4irwma-4KHDR20".equals(str)) {
            return this.f4921c.getResources().getString(R.string.uhd_hdr_4k);
        }
        if ("MP4irwmb-lo".equals(str)) {
            return this.f4921c.getResources().getString(R.string.low);
        }
        if ("MP4irwmb-hi".equals(str)) {
            return this.f4921c.getResources().getString(R.string.high);
        }
        if ("MP4irwmb-SHQ".equals(str)) {
            return this.f4921c.getResources().getString(R.string.excellent);
        }
        if ("MP4irwmb-HD720".equals(str)) {
            return this.f4921c.getResources().getString(R.string.hd_720);
        }
        if ("MP4irwmb-HD1080".equals(str)) {
            return this.f4921c.getResources().getString(R.string.hd_1080);
        }
        if ("MP4irwmb-UHD12".equals(str)) {
            return this.f4921c.getResources().getString(R.string.uhd_4k);
        }
        if ("MP4irwmb-UHD20".equals(str)) {
            return this.f4921c.getResources().getString(R.string.uhd_4k);
        }
        if ("MP4irwmb-4KHDR12".equals(str)) {
            return this.f4921c.getResources().getString(R.string.uhd_hdr_4k);
        }
        return "MP4irwmb-4KHDR20".equals(str) ? this.f4921c.getResources().getString(R.string.uhd_hdr_4k) : "";
    }

    private void a() {
        this.g.setOnItemClickListener(new a());
    }

    public void a(ArrayList<String> arrayList, String str, String str2, View view, int i, int i2, int i3) {
        this.f4919a = arrayList;
        this.f4920b = str;
        this.e = str2;
        c cVar = this.h;
        if (cVar == null) {
            c cVar2 = new c();
            this.h = cVar2;
            this.g.setAdapter((ListAdapter) cVar2);
        } else {
            cVar.notifyDataSetChanged();
        }
        showAtLocation(view, i, i2, i3);
        setWidth(this.k);
        setHeight(-2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        if ("1".equals(str)) {
            return this.f4921c.getResources().getString(R.string.SD);
        }
        if ("2".equals(str)) {
            return this.f4921c.getResources().getString(R.string.play_vedio_type_sd_h);
        }
        if ("4".equals(str)) {
            return this.f4921c.getResources().getString(R.string.HD);
        }
        return "8".equals(str) ? "4K" : GlobalConst.WINPHONE_CLIENT.equals(str) ? "720P" : GlobalConst.ANDRIODSTB_CLIENT.equals(str) ? "1280P" : "";
    }

    public void a(b bVar) {
        this.i = bVar;
    }
}
