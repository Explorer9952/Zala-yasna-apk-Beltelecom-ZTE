package com.zte.iptvclient.android.mobile.share.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.video.androidsdk.log.LogEx;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.mobile.share.camera.c;
import com.zte.iptvclient.android.mobile.share.decoding.f;
import com.zte.iptvclient.android.mobile.share.view.ViewfinderView;
import com.zte.iptvclient.android.zala.R;
import java.io.IOException;
import java.util.Vector;

/* loaded from: classes2.dex */
public class CaptureActivity extends SupportActivity implements SurfaceHolder.Callback {
    private String A;
    private f B;
    private MediaPlayer C;
    private boolean D;
    private boolean E;
    private final MediaPlayer.OnCompletionListener F = new b();
    private com.zte.iptvclient.android.mobile.share.decoding.a v;
    private ViewfinderView w;
    private Button x;
    private boolean y;
    private Vector<BarcodeFormat> z;

    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CaptureActivity.this.finish();
        }
    }

    /* loaded from: classes2.dex */
    class b implements MediaPlayer.OnCompletionListener {
        b() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            mediaPlayer.seekTo(0);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x005b -> B:9:0x005e). Please report as a decompilation issue!!! */
    private void t() {
        if (this.D && this.C == null) {
            setVolumeControlStream(3);
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.C = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
            this.C.setOnCompletionListener(this.F);
            AssetFileDescriptor openRawResourceFd = getResources().openRawResourceFd(R.raw.beep);
            try {
                try {
                    this.C.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                    openRawResourceFd.close();
                    this.C.setVolume(0.1f, 0.1f);
                    this.C.prepare();
                    openRawResourceFd.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException unused) {
                openRawResourceFd.close();
            } catch (Throwable th) {
                try {
                    openRawResourceFd.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                throw th;
            }
        }
    }

    private void u() {
        MediaPlayer mediaPlayer;
        if (this.D && (mediaPlayer = this.C) != null) {
            mediaPlayer.start();
        }
        if (this.E) {
            ((Vibrator) getSystemService("vibrator")).vibrate(200L);
        }
    }

    public void a(Result result, Bitmap bitmap) {
        this.B.a();
        u();
        String text = result.getText();
        if (TextUtils.isEmpty(text)) {
            Toast.makeText(this, "Scan failed!", 0).show();
        } else {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("qr_scan_result", text);
            LogEx.d("CaptureActivity", "handleDecode " + text);
            intent.putExtras(bundle);
            setResult(-1, intent);
        }
        finish();
    }

    public Handler j() {
        return this.v;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zte.fragmentlib.SupportActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.zte.fragmentlib.SupportActivity, com.zte.fragmentlib.publicbaseclass.skinloader.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_scanner);
        TextView textView = (TextView) findViewById(R.id.title_txt);
        textView.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.scan_qrcode));
        c.a(getApplication());
        this.w = (ViewfinderView) findViewById(R.id.viewfinder_content);
        Button button = (Button) findViewById(R.id.btn_back);
        this.x = button;
        button.setOnClickListener(new a());
        this.x.setVisibility(0);
        this.y = false;
        this.B = new f(this);
        com.zte.iptvclient.common.uiframe.f.a(findViewById(R.id.title_rlayout));
        com.zte.iptvclient.common.uiframe.f.a(textView);
        com.zte.iptvclient.common.uiframe.f.a(this.x);
        com.zte.iptvclient.common.uiframe.f.a(findViewById(R.id.header_bottom_line));
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zte.fragmentlib.SupportActivity, com.zte.fragmentlib.publicbaseclass.skinloader.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.B.b();
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        com.zte.iptvclient.android.mobile.share.decoding.a aVar = this.v;
        if (aVar != null) {
            aVar.a();
            this.v = null;
        }
        c.f().a();
    }

    @Override // com.zte.fragmentlib.publicbaseclass.skinloader.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        SurfaceHolder holder = ((SurfaceView) findViewById(R.id.scanner_view)).getHolder();
        if (this.y) {
            a(holder);
        } else {
            holder.addCallback(this);
            holder.setType(3);
        }
        this.z = null;
        this.A = null;
        this.D = true;
        if (((AudioManager) getSystemService(MimeTypes.BASE_TYPE_AUDIO)).getRingerMode() != 2) {
            this.D = false;
        }
        t();
        this.E = true;
    }

    public void r() {
        this.w.a();
    }

    public ViewfinderView s() {
        return this.w;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (this.y) {
            return;
        }
        this.y = true;
        a(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.y = false;
    }

    private void a(SurfaceHolder surfaceHolder) {
        try {
            c.f().a(surfaceHolder);
            c.f().a((Activity) this);
            if (this.v == null) {
                this.v = new com.zte.iptvclient.android.mobile.share.decoding.a(this, this.z, this.A);
            }
        } catch (IOException | RuntimeException unused) {
        }
    }
}
