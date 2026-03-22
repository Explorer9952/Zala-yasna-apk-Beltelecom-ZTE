package com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: RecordingModifyChoiceAdapter.java */
/* loaded from: classes.dex */
public class d extends RecyclerView.g {
    private static String g = "com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.d";

    /* renamed from: c, reason: collision with root package name */
    ArrayList<b> f5689c;

    /* renamed from: d, reason: collision with root package name */
    InterfaceC0206d f5690d;
    private LayoutInflater e;
    private int f = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RecordingModifyChoiceAdapter.java */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f5691a;

        a(int i) {
            this.f5691a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = d.this.f;
            d.this.f = this.f5691a;
            d.this.a(i, MessengerShareContentUtility.ATTACHMENT_PAYLOAD);
            d dVar = d.this;
            dVar.a(dVar.f, MessengerShareContentUtility.ATTACHMENT_PAYLOAD);
            InterfaceC0206d interfaceC0206d = d.this.f5690d;
            if (interfaceC0206d != null) {
                interfaceC0206d.b(this.f5691a);
            }
        }
    }

    /* compiled from: RecordingModifyChoiceAdapter.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f5693a;

        /* renamed from: b, reason: collision with root package name */
        public String f5694b;

        public b(int i, String str) {
            this.f5693a = i;
            this.f5694b = str;
        }

        public String a() {
            String str = this.f5694b;
            return str == null ? "" : str;
        }

        public int b() {
            return this.f5693a;
        }
    }

    /* compiled from: RecordingModifyChoiceAdapter.java */
    /* loaded from: classes.dex */
    public class c extends RecyclerView.b0 {
        private TextView t;
        private ImageView u;

        public c(d dVar, View view) {
            super(view);
            this.u = (ImageView) view.findViewById(R.id.recording_modify_choice_select_img);
            this.t = (TextView) view.findViewById(R.id.recording_modify_choice_item_txt);
        }
    }

    /* compiled from: RecordingModifyChoiceAdapter.java */
    /* renamed from: com.zte.iptvclient.android.mobile.clouddvr.mvp.view.adapter.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0206d {
        void b(int i);
    }

    public d(Context context, ArrayList<b> arrayList) {
        this.f5689c = arrayList;
        this.e = LayoutInflater.from(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.b0 b(ViewGroup viewGroup, int i) {
        return new c(this, this.e.inflate(R.layout.recording_modify_choice_item_layout, viewGroup, false));
    }

    public void e(int i) {
        int i2 = this.f;
        this.f = i;
        a(i2, MessengerShareContentUtility.ATTACHMENT_PAYLOAD);
        a(this.f, MessengerShareContentUtility.ATTACHMENT_PAYLOAD);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void b(RecyclerView.b0 b0Var, int i) {
        c cVar = (c) b0Var;
        Log.d(g, "onBindViewHolder# position=" + i);
        cVar.t.setText(this.f5689c.get(i).a());
        if (this.f == i) {
            cVar.u.setVisibility(0);
        } else {
            cVar.u.setVisibility(4);
        }
        cVar.f1492a.setOnClickListener(new a(i));
    }

    public void a(InterfaceC0206d interfaceC0206d) {
        this.f5690d = interfaceC0206d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void a(RecyclerView.b0 b0Var, int i, List list) {
        Log.d(g, "onBindViewHolder payload: " + list);
        if (list.isEmpty()) {
            b(b0Var, i);
            return;
        }
        Log.d(g, "局部刷新选中的图片， position = " + i);
        c cVar = (c) b0Var;
        if (this.f == i) {
            cVar.u.setVisibility(0);
        } else {
            cVar.u.setVisibility(4);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int a() {
        ArrayList<b> arrayList = this.f5689c;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }
}
