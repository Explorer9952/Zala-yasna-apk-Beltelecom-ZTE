package com.zte.iptvclient.android.common.customview.a.a.e;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.javabean.models.Channel;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.greenrobot.eventbus.EventBus;

/* compiled from: ChannelLineupDialog.java */
/* loaded from: classes.dex */
public class e extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private Context f4240a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f4241b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f4242c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f4243d;
    private TextView e;
    private EditText f;
    private ArrayList<Channel> g;
    private int h;
    private boolean i;
    private String j;

    /* compiled from: ChannelLineupDialog.java */
    /* loaded from: classes.dex */
    class a implements View.OnClickListener {

        /* compiled from: ChannelLineupDialog.java */
        /* renamed from: com.zte.iptvclient.android.common.customview.a.a.e.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0124a implements Comparator<Channel> {
            C0124a(a aVar) {
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
                    LogEx.d("NumberFormatException", e.toString());
                    return -1;
                }
            }
        }

        /* compiled from: ChannelLineupDialog.java */
        /* loaded from: classes.dex */
        class b implements Comparator<Channel> {
            b(a aVar) {
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
                    LogEx.d("NumberFormatException", e.toString());
                    return -1;
                }
            }
        }

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(e.this.f.getText().toString()) || e.this.f.getText().length() == 0 || e.this.f.getText().toString().equals("0")) {
                return;
            }
            String obj = e.this.f.getText().toString();
            if (obj.equals(e.this.j)) {
                e.this.dismiss();
                return;
            }
            String valueOf = String.valueOf(Integer.parseInt(obj));
            if (e.this.f.getVisibility() == 0) {
                int i = 0;
                while (true) {
                    if (i >= e.this.g.size()) {
                        break;
                    }
                    if (valueOf.equals(((Channel) e.this.g.get(i)).getCustomsort())) {
                        LogEx.d("ChannelLineupDialog", "Need transposition");
                        e.this.i = true;
                        ((Channel) e.this.g.get(i)).setCustomsort(((Channel) e.this.g.get(e.this.h)).getCustomsort());
                        ((Channel) e.this.g.get(e.this.h)).setCustomsort(valueOf);
                        break;
                    }
                    LogEx.d("ChannelLineupDialog", "NO Need transposition");
                    e.this.i = false;
                    i++;
                }
                if (!e.this.i) {
                    ((Channel) e.this.g.get(e.this.h)).setCustomsort(valueOf);
                    Collections.sort(e.this.g, new C0124a(this));
                    EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.c(e.this.g));
                    e.this.dismiss();
                    return;
                }
                e.this.f.setVisibility(8);
                e.this.f4242c.setText(e.this.f4240a.getResources().getString(R.string.replace_serial_number));
                e.this.f4241b.setVisibility(8);
                return;
            }
            int i2 = 0;
            while (true) {
                if (i2 >= e.this.g.size()) {
                    break;
                }
                if (valueOf.equals(((Channel) e.this.g.get(i2)).getCustomsort())) {
                    LogEx.d("ChannelLineupDialog", "Need transposition");
                    e.this.i = true;
                    ((Channel) e.this.g.get(i2)).setCustomsort(((Channel) e.this.g.get(e.this.h)).getCustomsort());
                    ((Channel) e.this.g.get(e.this.h)).setCustomsort(valueOf);
                    break;
                }
                LogEx.d("ChannelLineupDialog", "NO Need transposition");
                e.this.i = false;
                i2++;
            }
            if (!e.this.i) {
                ((Channel) e.this.g.get(e.this.h)).setCustomsort(valueOf);
            }
            Collections.sort(e.this.g, new b(this));
            e.this.dismiss();
            EventBus.getDefault().post(new com.zte.iptvclient.android.common.e.x.c(e.this.g));
        }
    }

    /* compiled from: ChannelLineupDialog.java */
    /* loaded from: classes.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.dismiss();
        }
    }

    public e(Context context, int i, ArrayList<Channel> arrayList, int i2) {
        super(context, i);
        this.i = false;
        this.f4240a = context;
        this.g = arrayList;
        this.h = i2;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.channellineup_dialog);
        this.f4241b = (TextView) findViewById(R.id.title);
        this.f4242c = (TextView) findViewById(R.id.new_number);
        this.f4243d = (TextView) findViewById(R.id.ok);
        this.e = (TextView) findViewById(R.id.cancel);
        this.f = (EditText) findViewById(R.id.mixno);
        com.zte.iptvclient.common.uiframe.f.a(findViewById(R.id.ll_order_dialog));
        com.zte.iptvclient.common.uiframe.f.a(findViewById(R.id.ll_ok));
        com.zte.iptvclient.common.uiframe.f.a(this.f4241b);
        com.zte.iptvclient.common.uiframe.f.a(this.f4242c);
        com.zte.iptvclient.common.uiframe.f.a(this.f4243d);
        com.zte.iptvclient.common.uiframe.f.a(this.e);
        com.zte.iptvclient.common.uiframe.f.a(this.f);
        String customsort = this.g.get(this.h).getCustomsort();
        this.j = customsort;
        this.f.setText(customsort);
        this.f.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
        this.f4241b.setText(this.f4240a.getResources().getString(R.string.current_number) + " " + this.g.get(this.h).getCustomsort());
        this.e.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.float_frist_close_cancel));
        this.f4243d.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.common_ok));
        this.f.setInputType(2);
        this.f.setKeyListener(DigitsKeyListener.getInstance("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"));
        this.f4243d.setOnClickListener(new a());
        this.e.setOnClickListener(new b());
    }

    public void a() {
        show();
    }
}
