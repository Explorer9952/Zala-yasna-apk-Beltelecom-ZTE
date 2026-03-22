package com.zte.iptvclient.android.common.customview.CustomTimePicker;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.customview.CustomTimePicker.TimePickerView;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;
import java.util.ArrayList;

/* compiled from: TimePickerPopWindow.java */
/* loaded from: classes.dex */
public class a extends PopupWindow {

    /* renamed from: a, reason: collision with root package name */
    private Context f4121a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f4122b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f4123c;

    /* renamed from: d, reason: collision with root package name */
    private TimePickerView f4124d;
    private TimePickerView e;
    private ArrayList<String> f;
    private ArrayList<String> g;
    private String h;
    private String i;
    private int j;
    private int k;
    private int l;
    private int m;
    private e n;
    private int o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TimePickerPopWindow.java */
    /* renamed from: com.zte.iptvclient.android.common.customview.CustomTimePicker.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ViewOnClickListenerC0112a implements View.OnClickListener {
        ViewOnClickListenerC0112a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.n != null) {
                a.this.n.a(a.this.h + ":" + a.this.i);
            }
            a.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TimePickerPopWindow.java */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TimePickerPopWindow.java */
    /* loaded from: classes.dex */
    public class c implements TimePickerView.c {
        c() {
        }

        @Override // com.zte.iptvclient.android.common.customview.CustomTimePicker.TimePickerView.c
        public void a(String str) {
            a.this.h = str.trim();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TimePickerPopWindow.java */
    /* loaded from: classes.dex */
    public class d implements TimePickerView.c {
        d() {
        }

        @Override // com.zte.iptvclient.android.common.customview.CustomTimePicker.TimePickerView.c
        public void a(String str) {
            a.this.i = str.trim();
        }
    }

    /* compiled from: TimePickerPopWindow.java */
    /* loaded from: classes.dex */
    public interface e {
        void a(String str);
    }

    public a(Context context, int i, String str) {
        super(context);
        this.h = "";
        this.i = "";
        this.k = 0;
        this.l = 11;
        this.m = 59;
        this.o = 0;
        this.f4121a = context;
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.time_picker_window_layout, (ViewGroup) null);
        this.f4124d = (TimePickerView) inflate.findViewById(R.id.picker_hour);
        this.e = (TimePickerView) inflate.findViewById(R.id.picker_minute);
        this.f4122b = (TextView) inflate.findViewById(R.id.pop_cancel);
        this.f4123c = (TextView) inflate.findViewById(R.id.pop_confirm);
        this.f4124d.b(0);
        this.e.b(0);
        this.f4124d.a(true);
        this.e.a(true);
        f.a(inflate.findViewById(R.id.rl_pop_window));
        f.a(inflate.findViewById(R.id.rl_time_picker_view));
        f.a(inflate.findViewById(R.id.ll_time_picker_view));
        f.a(inflate.findViewById(R.id.devide_line_pop));
        f.a(this.f4122b);
        f.a(this.f4123c);
        f.a(this.f4124d);
        f.a(this.e);
        this.o = i;
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(":");
            if (split.length == 2) {
                this.h = split[0];
                this.i = split[1];
            }
        }
        setContentView(inflate);
        setWidth(-1);
        setHeight(-2);
        setBackgroundDrawable(new BitmapDrawable());
        setOutsideTouchable(true);
        setFocusable(true);
        a();
        c();
    }

    private void c() {
        this.f4123c.setOnClickListener(new ViewOnClickListenerC0112a());
        this.f4122b.setOnClickListener(new b());
        this.f4124d.a(new c());
        this.e.a(new d());
    }

    private void a() {
        this.j = 0;
        this.l = 11;
        if (this.o != 0) {
            this.j = 12;
            this.l = 23;
        }
        ArrayList<String> arrayList = this.f;
        if (arrayList == null) {
            this.f = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        ArrayList<String> arrayList2 = this.g;
        if (arrayList2 == null) {
            this.g = new ArrayList<>();
        } else {
            arrayList2.clear();
        }
        b();
    }

    private void b() {
        for (int i = this.j; i <= this.l; i++) {
            this.f.add(a(i));
        }
        for (int i2 = this.k; i2 <= this.m; i2++) {
            this.g.add(a(i2));
        }
        this.f4124d.a(this.f);
        this.e.a(this.g);
        if (!TextUtils.isEmpty(this.h)) {
            this.f4124d.a(this.h);
        } else {
            this.f4124d.a(0);
        }
        if (!TextUtils.isEmpty(this.i)) {
            this.e.a(this.i);
        } else {
            this.e.a(0);
        }
        this.h = this.f4124d.a();
        this.i = this.e.a();
        LogEx.d("TimePickerPopWindow", "mstrHourSelected = " + this.h);
        LogEx.d("TimePickerPopWindow", "mstrMinutesSelected = " + this.i);
    }

    public void a(View view) {
        LogEx.d("TimePickerPopWindow", "showAtLocation");
        showAtLocation(view, 80, 0, 0);
    }

    private String a(int i) {
        if (i >= 10) {
            return String.valueOf(i);
        }
        return "0" + String.valueOf(i);
    }

    public void a(e eVar) {
        this.n = eVar;
    }
}
