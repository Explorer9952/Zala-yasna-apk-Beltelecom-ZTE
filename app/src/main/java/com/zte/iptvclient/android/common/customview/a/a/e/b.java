package com.zte.iptvclient.android.common.customview.a.a.e;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.zte.iptvclient.android.common.javabean.models.MultiDefinitionURLBean;
import com.zte.iptvclient.android.common.javabean.models.VideoDetailBean;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;

/* compiled from: AudoDialog.java */
/* loaded from: classes.dex */
public class b extends AlertDialog {

    /* renamed from: a, reason: collision with root package name */
    private TextView f4224a;

    /* renamed from: b, reason: collision with root package name */
    private ListView f4225b;

    /* renamed from: c, reason: collision with root package name */
    private com.zte.iptvclient.android.common.customview.a.a.e.c f4226c;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<VideoDetailBean> f4227d;
    private ArrayList<MultiDefinitionURLBean> e;
    private Context f;
    private c g;

    /* compiled from: AudoDialog.java */
    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.dismiss();
        }
    }

    /* compiled from: AudoDialog.java */
    /* renamed from: com.zte.iptvclient.android.common.customview.a.a.e.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0123b implements AdapterView.OnItemClickListener {
        C0123b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (b.this.f4227d != null) {
                b.this.g.a((VideoDetailBean) b.this.f4227d.get(i));
            } else {
                b.this.g.a((MultiDefinitionURLBean) b.this.e.get(i));
            }
            b.this.dismiss();
        }
    }

    /* compiled from: AudoDialog.java */
    /* loaded from: classes.dex */
    public interface c {
        void a(MultiDefinitionURLBean multiDefinitionURLBean);

        void a(VideoDetailBean videoDetailBean);
    }

    public b(Context context, int i, ArrayList<VideoDetailBean> arrayList, ArrayList<MultiDefinitionURLBean> arrayList2) {
        super(context, i);
        this.f = context;
        this.f4227d = arrayList;
        this.e = arrayList2;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.audo_dialog);
        this.f4224a = (TextView) findViewById(R.id.cancel);
        this.f4225b = (ListView) findViewById(R.id.lv_audo);
        com.zte.iptvclient.common.uiframe.f.a(findViewById(R.id.ll_audo_dialog));
        com.zte.iptvclient.common.uiframe.f.a(findViewById(R.id.ll_cancel));
        com.zte.iptvclient.common.uiframe.f.a(this.f4224a);
        if (this.f4227d != null) {
            this.f4226c = new com.zte.iptvclient.android.common.customview.a.a.e.c(this.f, this.f4227d, null);
        } else {
            this.f4226c = new com.zte.iptvclient.android.common.customview.a.a.e.c(this.f, null, this.e);
        }
        this.f4225b.setAdapter((ListAdapter) this.f4226c);
        this.f4224a.setOnClickListener(new a());
        this.f4225b.setOnItemClickListener(new C0123b());
    }

    public void a(c cVar) {
        this.g = cVar;
    }
}
