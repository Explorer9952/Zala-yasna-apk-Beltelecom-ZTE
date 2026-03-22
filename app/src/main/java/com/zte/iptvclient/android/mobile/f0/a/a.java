package com.zte.iptvclient.android.mobile.f0.a;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.k.v;
import com.zte.iptvclient.android.mobile.HostActivity;
import com.zte.iptvclient.android.mobile.MainActivity;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.lang.reflect.Field;

/* compiled from: MessageDetailWebFragment.java */
/* loaded from: classes2.dex */
public class a extends com.zte.fragmentlib.b {
    private Button p;
    private TextView q;
    private Context v;
    private RelativeLayout w;
    private b x;
    public String r = "";
    public String s = "";
    private String t = "MessageDetailWebFragment";
    private c u = null;
    private FragmentManager y = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MessageDetailWebFragment.java */
    /* renamed from: com.zte.iptvclient.android.mobile.f0.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class ViewOnClickListenerC0252a implements View.OnClickListener {
        ViewOnClickListenerC0252a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.x != null) {
                a.this.x.o();
            }
            if (a.this.getActivity() instanceof MainActivity) {
                a.this.F();
            } else if (a.this.getActivity() instanceof HostActivity) {
                a.this.getActivity().finish();
            }
        }
    }

    /* compiled from: MessageDetailWebFragment.java */
    /* loaded from: classes2.dex */
    public interface b {
        void o();
    }

    private void d(View view) {
        TextView textView = (TextView) view.findViewById(R.id.top);
        int a2 = v.a();
        if (a2 <= 0) {
            a2 = 60;
        }
        textView.setHeight(a2);
        this.w = (RelativeLayout) view.findViewById(R.id.title_rlayout);
        f.a(view.findViewById(R.id.title_rlayout));
        f.a(view.findViewById(R.id.web_title_rlayout));
        Button button = (Button) view.findViewById(R.id.btn_back);
        this.p = button;
        f.a(button);
        TextView textView2 = (TextView) view.findViewById(R.id.title_txt);
        this.q = textView2;
        textView2.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.title));
        f.a(this.q);
        f.a(view.findViewById(R.id.web_farment_view));
        this.q.setText(this.r);
        this.p.setOnClickListener(new ViewOnClickListenerC0252a());
    }

    @Override // com.zte.fragmentlib.b
    public boolean D() {
        b bVar = this.x;
        if (bVar == null) {
            return false;
        }
        bVar.o();
        return false;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        r b2;
        super.onActivityCreated(bundle);
        if (this.u == null) {
            c cVar = new c();
            this.u = cVar;
            cVar.a(this.v);
            this.u.s(this.r);
            this.u.t(this.s);
            FragmentManager fragmentManager = this.y;
            if (fragmentManager == null || (b2 = fragmentManager.b()) == null) {
                return;
            }
            this.u.I();
            b2.a(R.id.web_farment_view, this.u);
            b2.a();
        }
    }

    @Override // com.zte.fragmentlib.publicbaseclass.skinloader.a, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.v = context;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.r = arguments.getString("ContentName");
            this.s = arguments.getString("ContentUrl");
        }
        this.y = getChildFragmentManager();
        LogEx.d(this.t, "ContentName=" + this.r + ",ContentUrl" + this.s);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.mobi_web_fragment, viewGroup, false);
        d(inflate);
        return inflate;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // com.zte.fragmentlib.publicbaseclass.skinloader.a, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        try {
            Field declaredField = a.class.getDeclaredField("y");
            declaredField.setAccessible(true);
            declaredField.set(this, null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }
}
