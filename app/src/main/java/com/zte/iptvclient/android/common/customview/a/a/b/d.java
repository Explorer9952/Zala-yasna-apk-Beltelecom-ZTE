package com.zte.iptvclient.android.common.customview.a.a.b;

import android.app.Dialog;
import android.content.Context;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;

/* compiled from: VoiceControlDialog.java */
/* loaded from: classes.dex */
public class d extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private ProgressBar f4179a;

    /* renamed from: b, reason: collision with root package name */
    private ImageView f4180b;

    /* renamed from: c, reason: collision with root package name */
    private ImageView f4181c;

    public d(Context context) {
        super(context, R.style.dialog_noframe);
        setContentView(R.layout.voice_control_dialog);
        a();
    }

    public void a() {
        this.f4181c = (ImageView) findViewById(R.id.voice_mute);
        this.f4180b = (ImageView) findViewById(R.id.voice_normal);
        this.f4179a = (ProgressBar) findViewById(R.id.voice_dialog_progress);
        f.a(findViewById(R.id.voice_mute));
        f.a(findViewById(R.id.voice_normal));
        f.a(findViewById(R.id.voice_dialog_progress));
    }

    public void a(int i) {
        if (i > 100) {
            this.f4181c.setVisibility(4);
            this.f4180b.setVisibility(0);
            this.f4179a.setProgress(100);
        } else if (i < 1) {
            this.f4181c.setVisibility(0);
            this.f4180b.setVisibility(4);
            this.f4179a.setProgress(0);
        } else {
            this.f4181c.setVisibility(4);
            this.f4180b.setVisibility(0);
            this.f4179a.setProgress(i);
        }
    }
}
