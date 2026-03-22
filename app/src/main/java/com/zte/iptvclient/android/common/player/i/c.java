package com.zte.iptvclient.android.common.player.i;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.video.androidsdk.common.GlobalConst;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.d;
import com.zte.iptvclient.common.uiframe.f;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: VideoSettingAdapter.java */
/* loaded from: classes.dex */
public class c extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<String> f4943a;

    /* renamed from: b, reason: collision with root package name */
    private Context f4944b;

    /* renamed from: c, reason: collision with root package name */
    private int f4945c;

    /* renamed from: d, reason: collision with root package name */
    private String f4946d;
    private int e;
    private int f;
    private String g;

    /* compiled from: VideoSettingAdapter.java */
    /* loaded from: classes.dex */
    private static class b extends d {

        /* renamed from: a, reason: collision with root package name */
        RelativeLayout f4947a;

        /* renamed from: b, reason: collision with root package name */
        TextView f4948b;

        /* renamed from: c, reason: collision with root package name */
        ImageView f4949c;

        private b() {
        }
    }

    public c(Context context, ArrayList<String> arrayList, int i, int i2, int i3, String str) {
        this.e = 0;
        this.f = 0;
        this.f4944b = context;
        this.f4943a = arrayList;
        this.f4945c = i;
        this.e = i2;
        this.f = i3;
        this.g = str;
    }

    private String a(String str) {
        if ("1".equals(str)) {
            return this.f4944b.getResources().getString(R.string.SD);
        }
        if ("2".equals(str)) {
            return this.f4944b.getResources().getString(R.string.play_vedio_type_sd_h);
        }
        if ("4".equals(str)) {
            return this.f4944b.getResources().getString(R.string.HD);
        }
        return "8".equals(str) ? "4K" : GlobalConst.WINPHONE_CLIENT.equals(str) ? "720P" : GlobalConst.ANDRIODSTB_CLIENT.equals(str) ? "1280P" : "";
    }

    private String b(String str) {
        if ("MP4-lo".equals(str)) {
            return this.f4944b.getResources().getString(R.string.low);
        }
        if ("MP4-hi".equals(str)) {
            return this.f4944b.getResources().getString(R.string.high);
        }
        if ("MP4-mobile".equals(str)) {
            return this.f4944b.getResources().getString(R.string.low);
        }
        if ("MP4-low-mobile".equals(str)) {
            return this.f4944b.getResources().getString(R.string.low);
        }
        if ("MP4-SHQ".equals(str)) {
            return this.f4944b.getResources().getString(R.string.excellent);
        }
        if ("MP4-HD720".equals(str)) {
            return this.f4944b.getResources().getString(R.string.hd_720);
        }
        if ("MP4-HD1080".equals(str)) {
            return this.f4944b.getResources().getString(R.string.hd_1080);
        }
        if ("MP4-TAB-HD720".equals(str)) {
            return this.f4944b.getResources().getString(R.string.hd_720);
        }
        if ("MP4-TAB-HD1080".equals(str)) {
            return this.f4944b.getResources().getString(R.string.hd_1080);
        }
        if ("MP4-4KHDR".equals(str)) {
            return this.f4944b.getResources().getString(R.string.hdr_4k);
        }
        if ("MP4-4KDV".equals(str) || "MP4-UHD".equals(str) || "MP4-UHD12".equals(str) || "MP4-UHD20".equals(str)) {
            return "4K";
        }
        if ("MP4-4KHDR12".equals(str)) {
            return this.f4944b.getResources().getString(R.string.hdr_4k);
        }
        if ("MP4-4KHDR20".equals(str)) {
            return this.f4944b.getResources().getString(R.string.hdr_4k);
        }
        if ("MP4-SHQ-TP".equals(str)) {
            return this.f4944b.getResources().getString(R.string.excellent);
        }
        if ("MP4-HD1080-TP".equals(str)) {
            return this.f4944b.getResources().getString(R.string.hd_1080);
        }
        if ("MP4-TAB-HD1080-TP".equals(str)) {
            return this.f4944b.getResources().getString(R.string.hd_1080);
        }
        if ("MP4-HD1080-L2".equals(str)) {
            return this.f4944b.getResources().getString(R.string.hd_1080);
        }
        if ("MP4-TAB-HD1080-L2".equals(str)) {
            return this.f4944b.getResources().getString(R.string.hd_1080);
        }
        if ("MP4-SHQ-L2".equals(str)) {
            return this.f4944b.getResources().getString(R.string.excellent);
        }
        if ("MP4-SHQ-L4".equals(str)) {
            return this.f4944b.getResources().getString(R.string.excellent);
        }
        if ("MP4-TAB-HD720-TP".equals(str)) {
            return this.f4944b.getResources().getString(R.string.hd_720);
        }
        if ("MP4-TAB-HD720-L2".equals(str)) {
            return this.f4944b.getResources().getString(R.string.hd_720);
        }
        if ("MP4irwma-lo".equals(str)) {
            return this.f4944b.getResources().getString(R.string.low);
        }
        if ("MP4irwma-hi".equals(str)) {
            return this.f4944b.getResources().getString(R.string.high);
        }
        if ("MP4irwma-SHQ".equals(str)) {
            return this.f4944b.getResources().getString(R.string.excellent);
        }
        if ("MP4irwma-HD720".equals(str)) {
            return this.f4944b.getResources().getString(R.string.hd_720);
        }
        if ("MP4irwma-HD1080".equals(str)) {
            return this.f4944b.getResources().getString(R.string.hd_1080);
        }
        if ("MP4irwma-UHD12".equals(str)) {
            return this.f4944b.getResources().getString(R.string.uhd_4k);
        }
        if ("MP4irwma-UHD20".equals(str)) {
            return this.f4944b.getResources().getString(R.string.uhd_4k);
        }
        if ("MP4irwma-4KHDR12".equals(str)) {
            return this.f4944b.getResources().getString(R.string.uhd_hdr_4k);
        }
        if ("MP4irwma-4KHDR20".equals(str)) {
            return this.f4944b.getResources().getString(R.string.uhd_hdr_4k);
        }
        if ("MP4irwmb-lo".equals(str)) {
            return this.f4944b.getResources().getString(R.string.low);
        }
        if ("MP4irwmb-hi".equals(str)) {
            return this.f4944b.getResources().getString(R.string.high);
        }
        if ("MP4irwmb-SHQ".equals(str)) {
            return this.f4944b.getResources().getString(R.string.excellent);
        }
        if ("MP4irwmb-HD720".equals(str)) {
            return this.f4944b.getResources().getString(R.string.hd_720);
        }
        if ("MP4irwmb-HD1080".equals(str)) {
            return this.f4944b.getResources().getString(R.string.hd_1080);
        }
        if ("MP4irwmb-UHD12".equals(str)) {
            return this.f4944b.getResources().getString(R.string.uhd_4k);
        }
        if ("MP4irwmb-UHD20".equals(str)) {
            return this.f4944b.getResources().getString(R.string.uhd_4k);
        }
        if ("MP4irwmb-4KHDR12".equals(str)) {
            return this.f4944b.getResources().getString(R.string.uhd_hdr_4k);
        }
        return "MP4irwmb-4KHDR20".equals(str) ? this.f4944b.getResources().getString(R.string.uhd_hdr_4k) : "";
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<String> arrayList = this.f4943a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        ArrayList<String> arrayList = this.f4943a;
        if (arrayList == null) {
            return null;
        }
        return arrayList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = ((LayoutInflater) this.f4944b.getSystemService("layout_inflater")).inflate(R.layout.video_setting, (ViewGroup) null);
            bVar = new b();
            bVar.f4947a = (RelativeLayout) view.findViewById(R.id.rl_video_setting);
            bVar.f4948b = (TextView) view.findViewById(R.id.txt_video_setting);
            bVar.f4949c = (ImageView) view.findViewById(R.id.state_select_img);
            f.a(view);
            f.a(bVar.f4947a);
            f.a(bVar.f4948b);
            f.a(bVar.f4949c);
            f.a(view.findViewById(R.id.bottom_video_setting));
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        ArrayList<String> arrayList = this.f4943a;
        if (arrayList != null) {
            if (TextUtils.isEmpty(arrayList.get(i))) {
                bVar.f4948b.setText("");
            } else {
                int i2 = this.f4945c;
                if (i2 == 1) {
                    if (this.g.equals("ivi")) {
                        if (TextUtils.isEmpty(b(this.f4943a.get(i)))) {
                            bVar.f4948b.setText(this.f4943a.get(i));
                        } else {
                            bVar.f4948b.setText(b(this.f4943a.get(i)));
                        }
                        if (this.f4943a.get(i).equals(this.f4946d)) {
                            bVar.f4949c.setVisibility(0);
                        } else {
                            bVar.f4949c.setVisibility(4);
                        }
                    } else {
                        if (TextUtils.isEmpty(a(this.f4943a.get(i)))) {
                            bVar.f4948b.setText(this.f4943a.get(i));
                        } else {
                            bVar.f4948b.setText(a(this.f4943a.get(i)));
                        }
                        if (this.f4943a.get(i).equals(this.f4946d)) {
                            bVar.f4949c.setVisibility(0);
                        } else {
                            bVar.f4949c.setVisibility(4);
                        }
                    }
                } else if (i2 == 2) {
                    bVar.f4948b.setText(this.f4943a.get(i));
                    if (i == this.f) {
                        bVar.f4949c.setVisibility(0);
                    } else {
                        bVar.f4949c.setVisibility(4);
                    }
                } else {
                    bVar.f4948b.setText(this.f4943a.get(i));
                    if (i == this.e) {
                        bVar.f4949c.setVisibility(0);
                    } else {
                        bVar.f4949c.setVisibility(4);
                    }
                }
                LogEx.d("VideoSettingAdapter", "getView mTxtVideoSetting +" + Arrays.toString(this.f4943a.get(i).split(",")));
            }
        }
        return view;
    }

    public c(Context context, ArrayList<String> arrayList, int i, String str, int i2, int i3, String str2) {
        this.e = 0;
        this.f = 0;
        this.f4944b = context;
        this.f4943a = arrayList;
        this.f4945c = i;
        this.f4946d = str;
        this.e = i2;
        this.f = i3;
        this.g = str2;
    }
}
