package com.zte.iptvclient.android.common.customview.a.a.b;

import android.app.Dialog;
import android.content.Context;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;

/* compiled from: PlayControlDialog.java */
/* loaded from: classes.dex */
public class b extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private ProgressBar f4166a;

    /* renamed from: b, reason: collision with root package name */
    private ImageView f4167b;

    /* renamed from: c, reason: collision with root package name */
    private ImageView f4168c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f4169d;
    private TextView e;

    public b(Context context) {
        super(context, R.style.dialog_noframe);
        setContentView(R.layout.play_control_dialog);
        a();
    }

    public void a() {
        this.f4167b = (ImageView) findViewById(R.id.shift_left);
        this.f4168c = (ImageView) findViewById(R.id.shift_right);
        this.f4169d = (TextView) findViewById(R.id.goto_time);
        this.e = (TextView) findViewById(R.id.max_time);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.play_dialog_progress);
        this.f4166a = progressBar;
        progressBar.setMax(100);
        ((TextView) findViewById(R.id.play_control_3)).setText("/");
        f.a(findViewById(R.id.shift_left));
        f.a(findViewById(R.id.shift_right));
        f.a(findViewById(R.id.play_control_2));
        f.a(findViewById(R.id.goto_time));
        f.a(findViewById(R.id.play_control_3));
        f.a(findViewById(R.id.max_time));
        f.a(findViewById(R.id.play_dialog_progress));
    }

    public void a(int i, String str, String str2, boolean z) {
        this.f4169d.setText(str);
        this.e.setText(str2);
        if (i > 100) {
            this.f4166a.setProgress(100);
        } else if (i < 1) {
            this.f4166a.setProgress(0);
        } else {
            this.f4166a.setProgress(i);
        }
        if (z) {
            this.f4168c.setVisibility(0);
            this.f4167b.setVisibility(4);
        } else {
            this.f4168c.setVisibility(4);
            this.f4167b.setVisibility(0);
        }
    }
}
