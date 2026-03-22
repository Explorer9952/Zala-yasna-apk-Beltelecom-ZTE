package com.zte.iptvclient.android.mobile.y.c;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.i;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.comm.ParamConst;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.javabean.models.VideoDetailBean;
import com.zte.iptvclient.android.common.k.o;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.tv.ui.DragListView;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PlaySortFragment.java */
/* loaded from: classes2.dex */
public class b extends com.zte.fragmentlib.b {
    private int A;
    private TextView B;
    private ImageView p;
    private TextView q;
    private DragListView r;
    private SupportActivity s;
    private f t;
    private int z;
    private LinkedHashMap<String, ArrayList<VideoDetailBean>> u = new LinkedHashMap<>();
    private ArrayList<String> v = new ArrayList<>();
    private ArrayList<VideoDetailBean> w = new ArrayList<>();
    private ArrayList<VideoDetailBean> x = new ArrayList<>();
    private ArrayList<VideoDetailBean> y = new ArrayList<>();
    private View.OnClickListener C = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlaySortFragment.java */
    /* loaded from: classes2.dex */
    public class a implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        a() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            if (str != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.getInt("resultcode") == 0) {
                        JSONArray jSONArray = new JSONArray(Uri.decode(jSONObject.getString("datavalue")));
                        for (int i = 0; i < jSONArray.length(); i++) {
                            ArrayList arrayList = new ArrayList();
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String optString = jSONObject2.optString("listName");
                            JSONArray optJSONArray = jSONObject2.optJSONArray("data");
                            if (optJSONArray == null) {
                                b.this.u.put(optString, null);
                            } else {
                                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                    JSONObject jSONObject3 = optJSONArray.getJSONObject(i2);
                                    VideoDetailBean videoDetailBean = new VideoDetailBean();
                                    videoDetailBean.setProgramcode(jSONObject3.optString("programcode"));
                                    videoDetailBean.setProgramname(jSONObject3.optString("programname"));
                                    videoDetailBean.setPosterfilelist(jSONObject3.optString(ParamConst.COLUMN_INFO_RSP_NORMALPOSTER));
                                    arrayList.add(videoDetailBean);
                                }
                                b.this.u.put(optString, arrayList);
                            }
                        }
                        b.this.v.clear();
                        b.this.v.addAll(b.this.u.keySet());
                        b.this.y.clear();
                        b.this.y.addAll((ArrayList) b.this.u.get(b.this.v.get(b.this.z)));
                        b.this.x = b.this.y;
                        b.this.w.addAll(b.this.y);
                        b.this.t.notifyDataSetChanged();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("PlayingSortFragment", "query fail:" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlaySortFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.y.c.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0401b implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        C0401b() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            LogEx.d("PlayingSortFragment", "set return:" + str);
            com.zte.iptvclient.android.mobile.h.a.a.g().a(1, b.this.z, b.this.A, 6, "");
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.w.c(b.this.A));
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            LogEx.d("PlayingSortFragment", "set fail" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlaySortFragment.java */
    /* loaded from: classes2.dex */
    public class c extends DragListView.c {

        /* renamed from: a, reason: collision with root package name */
        private Rect f7815a = new Rect();

        /* renamed from: b, reason: collision with root package name */
        private boolean f7816b;

        c() {
        }

        @Override // com.zte.iptvclient.android.mobile.tv.ui.DragListView.b
        public boolean a(int i, int i2) {
            return b.this.t.a(i, i2);
        }

        @Override // com.zte.iptvclient.android.mobile.tv.ui.DragListView.b
        public boolean a(View view, int i, int i2) {
            View findViewById = view.findViewById(R.id.iv_order_order_fragment);
            if (findViewById != null && findViewById.getVisibility() == 0) {
                float a2 = i - com.zte.iptvclient.android.mobile.a0.c.c.a(view);
                float b2 = i2 - com.zte.iptvclient.android.mobile.a0.c.c.b(view);
                findViewById.getHitRect(this.f7815a);
                if (this.f7815a.contains((int) a2, (int) b2)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.zte.iptvclient.android.mobile.tv.ui.DragListView.b
        public void a(View view) {
            this.f7816b = view.isSelected();
            View findViewById = view.findViewById(R.id.iv_order_order_fragment);
            view.setSelected(true);
            if (findViewById != null) {
                findViewById.setSelected(true);
            }
        }

        @Override // com.zte.iptvclient.android.mobile.tv.ui.DragListView.b
        public Bitmap a(View view, Bitmap bitmap) {
            view.setSelected(this.f7816b);
            View findViewById = view.findViewById(R.id.iv_order_order_fragment);
            if (findViewById != null) {
                findViewById.setSelected(false);
            }
            return bitmap;
        }
    }

    /* compiled from: PlaySortFragment.java */
    /* loaded from: classes2.dex */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.iv_back_order_fragment) {
                b.this.D();
            } else {
                if (id != R.id.tv_complete_order_fragment) {
                    return;
                }
                b.this.D();
            }
        }
    }

    /* compiled from: PlaySortFragment.java */
    /* loaded from: classes2.dex */
    private static class e {

        /* renamed from: a, reason: collision with root package name */
        private TextView f7819a;

        /* renamed from: b, reason: collision with root package name */
        private ImageView f7820b;

        /* renamed from: c, reason: collision with root package name */
        private TextView f7821c;

        /* synthetic */ e(View view, a aVar) {
            this(view);
        }

        private e(View view) {
            view.setTag(this);
            this.f7819a = (TextView) view.findViewById(R.id.tv_num_order_fragment);
            this.f7820b = (ImageView) view.findViewById(R.id.iv_image_order_fragment);
            this.f7821c = (TextView) view.findViewById(R.id.tv_name_order_fragment);
        }
    }

    private boolean J() {
        ArrayList<VideoDetailBean> arrayList = this.x;
        if (arrayList == null || arrayList.size() == 0) {
            return false;
        }
        for (int i = 0; i < this.x.size(); i++) {
            if (this.x.get(i) != null && this.w.get(i) != null && !TextUtils.equals(this.x.get(i).getProgramcode(), this.w.get(i).getProgramcode())) {
                return true;
            }
        }
        return false;
    }

    private void K() {
        ArrayList<VideoDetailBean> arrayList;
        if (!J() || (arrayList = this.x) == null) {
            return;
        }
        arrayList.clear();
        this.x.addAll(this.w);
        this.v.clear();
        this.v.addAll(this.u.keySet());
        if (this.x.size() != 0) {
            int i = 0;
            while (true) {
                if (i >= this.x.size()) {
                    break;
                }
                if (TextUtils.equals(this.x.get(i).getProgramcode(), this.y.get(this.A).getProgramcode())) {
                    this.A = i;
                    break;
                }
                i++;
            }
            this.u.put(this.v.get(this.z), this.x);
            t(I().toString());
        }
    }

    private void L() {
        this.u.clear();
        this.y.clear();
        String str = o.j().i() + "/getuserdata";
        d.e.a.a.d.a aVar = new d.e.a.a.d.a();
        aVar.a(s("").toString());
        aVar.b("UTF-8");
        aVar.a("Content-Type", "application/json");
        aVar.a(str, "POST", new a());
    }

    @Override // com.zte.fragmentlib.b
    public boolean D() {
        K();
        if (getActivity() == null) {
            return true;
        }
        getActivity().finish();
        return true;
    }

    public JSONObject I() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("usercode", com.zte.iptvclient.common.uiframe.a.d("UserID"));
            jSONObject.put("datatype", 6);
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < this.u.size(); i++) {
                this.v.clear();
                this.v.addAll(this.u.keySet());
                JSONObject jSONObject2 = new JSONObject();
                JSONArray jSONArray2 = new JSONArray();
                if (this.u.get(this.v.get(i)) == null) {
                    jSONObject2.put("listName", this.v.get(i));
                    jSONObject2.put("data", "");
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.u.get(this.v.get(i)));
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        VideoDetailBean videoDetailBean = (VideoDetailBean) it2.next();
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("programcode", videoDetailBean.getProgramcode());
                        jSONObject3.put("programname", videoDetailBean.getProgramname());
                        jSONObject3.put(ParamConst.COLUMN_INFO_RSP_NORMALPOSTER, videoDetailBean.getPosterfilelist());
                        jSONArray2.put(jSONObject3);
                    }
                    jSONObject2.put("listName", this.v.get(i));
                    if (jSONArray2.length() == 0) {
                        jSONObject2.put("data", "");
                    } else {
                        jSONObject2.put("data", jSONArray2);
                    }
                }
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("datavalue", Uri.encode(jSONArray.toString()));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        this.z = arguments.getInt("index");
        this.A = arguments.getInt("childIndex");
        L();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof SupportActivity) {
            this.s = (SupportActivity) activity;
        }
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_order, viewGroup, false);
        a(this.s);
        d(inflate);
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public JSONObject s(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("usercode", com.zte.iptvclient.common.uiframe.a.d("UserID"));
            jSONObject.put("datatype", 6);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("datavalue", str);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void t(String str) {
        String str2 = o.j().i() + "/setuserdata";
        d.e.a.a.d.a aVar = new d.e.a.a.d.a();
        aVar.a(str);
        aVar.b("UTF-8");
        aVar.a("Content-Type", "application/json;charset=UTF-8");
        aVar.a(str2, "POST", new C0401b());
    }

    /* compiled from: PlaySortFragment.java */
    /* loaded from: classes2.dex */
    public class f extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        private SupportActivity f7822a;

        /* renamed from: b, reason: collision with root package name */
        private LayoutInflater f7823b;

        public f(SupportActivity supportActivity) {
            this.f7822a = supportActivity;
            this.f7823b = LayoutInflater.from(supportActivity);
        }

        private VideoDetailBean a(int i) {
            if (i < b.this.w.size()) {
                return (VideoDetailBean) b.this.w.get(i);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (b.this.w == null) {
                return 0;
            }
            return b.this.w.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return b.this.w.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            e eVar;
            if (view == null) {
                view = this.f7823b.inflate(R.layout.order_list, viewGroup, false);
                eVar = new e(view, null);
            } else {
                eVar = (e) view.getTag();
            }
            VideoDetailBean a2 = a(i);
            if (a2 != null) {
                eVar.f7821c.setText(a2.getProgramname());
                String posterfilelist = a2.getPosterfilelist();
                if (!posterfilelist.contains("poster")) {
                    posterfilelist = "/iptvepg/images/poster/" + posterfilelist;
                }
                com.bumptech.glide.d<String> a3 = i.a((FragmentActivity) this.f7822a).a(com.zte.iptvclient.android.common.f.b.i.b() + posterfilelist);
                a3.a(DiskCacheStrategy.ALL);
                a3.b(R.drawable.default_poster_thumb);
                a3.a(R.drawable.default_poster_thumb);
                a3.c(300);
                a3.a(eVar.f7820b);
                if (i < 9) {
                    eVar.f7819a.setText("0" + (i + 1) + "");
                } else if (i == 9) {
                    eVar.f7819a.setText((i + 1) + "");
                }
            }
            return view;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        public boolean a(int i, int i2) {
            boolean z;
            VideoDetailBean a2 = a(i);
            VideoDetailBean a3 = a(i2);
            int indexOf = b.this.w.indexOf(a2);
            int indexOf2 = b.this.w.indexOf(a3);
            if (indexOf == -1 || indexOf2 == -1) {
                z = false;
            } else {
                Collections.swap(b.this.w, indexOf, indexOf2);
                z = true;
            }
            if (z) {
                b.this.t.notifyDataSetChanged();
            }
            return z;
        }
    }

    private void d(View view) {
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        this.B = (TextView) view.findViewById(R.id.top);
        this.p = (ImageView) view.findViewById(R.id.iv_back_order_fragment);
        this.q = (TextView) view.findViewById(R.id.tv_complete_order_fragment);
        this.r = (DragListView) view.findViewById(R.id.rv_order_fragment);
        this.t = new f(this.s);
        com.zte.iptvclient.common.uiframe.f.a(this.r);
        com.zte.iptvclient.common.uiframe.f.a(this.q);
        com.zte.iptvclient.common.uiframe.f.a(this.p);
        com.zte.iptvclient.common.uiframe.f.a(this.B);
        com.zte.iptvclient.common.uiframe.f.a(view.findViewById(R.id.ll_order_fragment));
        this.B.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.movies_list_adjust_sort));
        this.q.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.movies_list_finish));
        this.p.setOnClickListener(this.C);
        this.q.setOnClickListener(this.C);
        this.r.a(new c());
        this.r.setAdapter((ListAdapter) this.t);
    }

    private void a(SupportActivity supportActivity) {
        int i;
        WindowManager.LayoutParams attributes;
        if (supportActivity != null && (i = Build.VERSION.SDK_INT) >= 19) {
            if (i >= 21) {
                Window window = supportActivity.getWindow();
                if (window != null) {
                    window.getDecorView().setSystemUiVisibility(9216);
                    window.addFlags(Integer.MIN_VALUE);
                    window.setStatusBarColor(0);
                    return;
                }
                return;
            }
            Window window2 = supportActivity.getWindow();
            if (window2 == null || (attributes = window2.getAttributes()) == null) {
                return;
            }
            attributes.flags = 67108864 | attributes.flags;
            window2.setAttributes(attributes);
        }
    }
}
