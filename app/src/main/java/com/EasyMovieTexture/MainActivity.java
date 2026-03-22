package com.EasyMovieTexture;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class MainActivity extends Activity {

    /* renamed from: b, reason: collision with root package name */
    private Button f1872b;

    /* renamed from: c, reason: collision with root package name */
    private Button f1873c;

    /* renamed from: d, reason: collision with root package name */
    private int f1874d = 3;

    /* renamed from: a, reason: collision with root package name */
    Handler f1871a = new com.EasyMovieTexture.a(this);

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (MainActivity.this.f1874d >= 0) {
                try {
                    Thread.sleep(1000L);
                    Message message = new Message();
                    message.what = 1;
                    MainActivity.this.f1871a.sendMessage(message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int a(MainActivity mainActivity) {
        int i = mainActivity.f1874d;
        mainActivity.f1874d = i - 1;
        return i;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle("VR");
        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        layoutParams2.setMargins(0, 0, 0, 0);
        Button button = new Button(this);
        this.f1872b = button;
        button.setText("Start VR (" + this.f1874d + ")");
        Button button2 = new Button(this);
        this.f1873c = button2;
        button2.setText("Settings");
        linearLayout.addView(this.f1872b);
        linearLayout.addView(this.f1873c);
        setContentView(linearLayout);
        this.f1872b.setOnClickListener(new b(this));
        this.f1873c.setOnClickListener(new c(this));
        new Thread(new a()).start();
    }
}
