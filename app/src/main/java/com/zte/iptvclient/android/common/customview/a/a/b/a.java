package com.zte.iptvclient.android.common.customview.a.a.b;

import android.app.Dialog;
import android.content.Context;
import android.widget.ProgressBar;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;

/* compiled from: BrightControlDialog.java */
/* loaded from: classes.dex */
public class a extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private ProgressBar f4165a;

    public a(Context context) {
        super(context, R.style.dialog_noframe);
        setContentView(R.layout.bright_control_dialog);
        a();
    }

    public void a() {
        this.f4165a = (ProgressBar) findViewById(R.id.bright_dialog_progress);
        f.a(findViewById(R.id.bright_mute));
        f.a(findViewById(R.id.bright_dialog_progress));
    }

    public void a(int i) {
        if (i > 100) {
            this.f4165a.setProgress(100);
        } else if (i < 1) {
            this.f4165a.setProgress(0);
        } else {
            this.f4165a.setProgress(i);
        }
    }
}
