package com.zte.iptvclient.android.mobile.e;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.internal.ServerProtocol;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.userdata.SDKUserDataMgr;
import com.video.androidsdk.service.userdata.SetUserDataReq;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.j.h;
import com.zte.iptvclient.android.common.j.i;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.common.k.g;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.mobile.a0.a.d;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ChannelLineupFragment.java */
/* loaded from: classes.dex */
public class a extends com.zte.fragmentlib.b {
    private d q;
    private ListView r;
    private Button s;
    private String w;
    private ArrayList<Channel> p = new ArrayList<>();
    private String t = "ChannelLineupFragment";
    private String u = "false";
    private h v = null;
    ArrayList<Channel> x = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChannelLineupFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.e.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0215a implements View.OnClickListener {
        ViewOnClickListenerC0215a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.K();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChannelLineupFragment.java */
    /* loaded from: classes.dex */
    public class b implements SDKUserDataMgr.OnSetUserDataReturnListener {
        b() {
        }

        @Override // com.video.androidsdk.service.userdata.SDKUserDataMgr.OnSetUserDataReturnListener
        public void onSetUserDataReturn(String str, String str2) {
            LogEx.d(a.this.t, "sdkSetUserDateForChannelList return return= " + str + " Json " + str2);
            if (!"0".equals(str)) {
                com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(((com.zte.fragmentlib.b) a.this).h.getResources().getString(R.string.operation_failed));
            } else {
                a aVar = a.this;
                aVar.s(aVar.w);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChannelLineupFragment.java */
    /* loaded from: classes.dex */
    public class c implements Comparator<Channel> {
        c() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Channel channel, Channel channel2) {
            try {
                int parseInt = Integer.parseInt(channel.getCustomsort());
                int parseInt2 = Integer.parseInt(channel2.getCustomsort());
                if (parseInt > parseInt2) {
                    return 1;
                }
                return parseInt == parseInt2 ? 0 : -1;
            } catch (NumberFormatException e) {
                LogEx.d(a.this.t, "NumberFormatException" + e.toString());
                return -1;
            }
        }
    }

    private String J() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.p == null) {
                return "";
            }
            for (int i = 0; i < this.p.size(); i++) {
                jSONObject.put(this.p.get(i).getMixno(), Integer.parseInt(this.p.get(i).getCustomsort()));
            }
            LogEx.d(this.t, "sdkSetUserDateForChannelListNew defaul= " + jSONObject.toString());
            return Uri.encode(Uri.encode(jSONObject.toString()));
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        if (getActivity() instanceof MainActivity) {
            F();
        } else if (getActivity() instanceof HostActivity) {
            getActivity().finish();
        }
    }

    private void L() {
        SDKUserDataMgr sDKUserDataMgr = new SDKUserDataMgr();
        SetUserDataReq setUserDataReq = new SetUserDataReq();
        setUserDataReq.datatype = "8";
        String J = J();
        this.w = J;
        setUserDataReq.datavalue = J;
        LogEx.d(this.t, "sdkSetUserDateForChannelListNew datavalue " + J());
        sDKUserDataMgr.setUserData(setUserDataReq, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str) {
        try {
            String decode = Uri.decode(Uri.decode(Uri.decode(str)));
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(decode);
            LogEx.d(this.t, "sdkGetUserDateForChannelListNews datavalue " + decode);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                arrayList.add(com.zte.iptvclient.android.common.javabean.models.b.a(next, jSONObject.getString(next)));
            }
            if (arrayList.size() == this.x.size()) {
                for (int i = 0; i < this.x.size(); i++) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        if (this.x.get(i).getMixno().equals(((com.zte.iptvclient.android.common.javabean.models.b) arrayList.get(i2)).b())) {
                            this.x.get(i).setCustomsort(((com.zte.iptvclient.android.common.javabean.models.b) arrayList.get(i2)).a());
                        }
                    }
                }
                Collections.sort(this.x, new c());
            }
            com.zte.iptvclient.android.mobile.n.c.b.k().d();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void I() {
        this.x = i.d().c();
        ArrayList<Channel> arrayList = this.p;
        if (arrayList != null) {
            arrayList.clear();
            ArrayList<Channel> arrayList2 = this.x;
            if (arrayList2 != null && arrayList2.size() > 0) {
                this.p.addAll(this.x);
            }
            if (this.p.get(0).getCustomsort() == null) {
                for (int i = 0; i < this.p.size(); i++) {
                    this.p.get(i).setCustomsort(this.p.get(i).getMixno());
                }
            }
        }
        this.r.setAdapter((ListAdapter) this.q);
        com.zte.iptvclient.android.mobile.n.c.b.k().d();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.channellineup_sort, (ViewGroup) null);
        h hVar = new h(this.h);
        this.v = hVar;
        this.u = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
        hVar.f(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        EventBus.getDefault().register(this);
        d(inflate);
        I();
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.o.a aVar) {
        this.x = i.d().c();
        ArrayList<Channel> arrayList = this.p;
        if (arrayList != null) {
            arrayList.clear();
            ArrayList<Channel> arrayList2 = this.x;
            if (arrayList2 != null && arrayList2.size() > 0) {
                this.p.addAll(this.x);
            }
            if (this.p.get(0).getCustomsort() == null) {
                for (int i = 0; i < this.p.size(); i++) {
                    this.p.get(i).setCustomsort(this.p.get(i).getMixno());
                }
            }
        }
        this.q.notifyDataSetChanged();
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.u = "false";
        this.v.f("false");
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    public void d(View view) {
        TextView textView = (TextView) view.findViewById(R.id.title_txt);
        f.a(textView);
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.tab_name_lineup));
        this.r = (ListView) view.findViewById(R.id.draglist);
        this.q = new d(this.h, this.p);
        view.findViewById(R.id.top).setMinimumHeight(v.a((Context) this.h));
        view.findViewById(R.id.top).setBackgroundColor(getResources().getColor(R.color.home_top_status_bg));
        Button button = (Button) view.findViewById(R.id.btn_back);
        this.s = button;
        f.a(button);
        f.a(view.findViewById(R.id.actions_bar));
        f.a(view.findViewById(R.id.header_bottom_line));
        ImageView imageView = (ImageView) view.findViewById(R.id.header_bottom_line);
        f.a(imageView);
        f.a(view.findViewById(R.id.txt_channellineup));
        if (BaseApp.a(this.h)) {
            imageView.setVisibility(0);
            g.a(imageView, this.h);
        }
        this.s.setOnClickListener(new ViewOnClickListenerC0215a());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(com.zte.iptvclient.android.common.e.x.c cVar) {
        if (cVar.a() != null) {
            this.p = cVar.a();
            this.q.notifyDataSetChanged();
            L();
        }
    }
}
