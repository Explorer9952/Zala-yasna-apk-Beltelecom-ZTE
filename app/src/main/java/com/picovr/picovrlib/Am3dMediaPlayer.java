package com.picovr.picovrlib;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.util.Log;

/* loaded from: classes.dex */
public class Am3dMediaPlayer {
    private AM3DEffect effect_am3d;
    MediaPlayer mediaPlayer = new MediaPlayer();

    public Am3dMediaPlayer() {
        this.effect_am3d = null;
        this.effect_am3d = new AM3DEffect(this.mediaPlayer.getAudioSessionId());
    }

    public void PlaySound(Context context, String str, boolean z) {
        Log.d("am3d", "PlaySound");
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer == null) {
            return;
        }
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            try {
                this.mediaPlayer.setAudioStreamType(3);
                if (!z) {
                    AssetFileDescriptor openFd = context.getAssets().openFd(str);
                    this.mediaPlayer.setDataSource(openFd.getFileDescriptor(), openFd.getStartOffset(), openFd.getLength());
                } else {
                    this.mediaPlayer.setDataSource(str);
                }
                this.mediaPlayer.setLooping(true);
                this.mediaPlayer.prepare();
                this.mediaPlayer.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void ReleaseSound() {
        Log.d("am3d", "ReleaseSound");
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.mediaPlayer.stop();
            }
            this.mediaPlayer.release();
            this.mediaPlayer = null;
        }
    }

    public void StopSound() {
        Log.d("am3d", "StopSound");
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.mediaPlayer.stop();
        this.mediaPlayer.reset();
    }

    public void setAudioType(int i, int i2, int i3) {
        this.effect_am3d.setAM3DParameter(i, i2, i3);
    }

    public void setSensor(float f) {
        Log.d("testdeg", "unity deg is " + f);
        if (f > 0.0f && f < 180.0f) {
            f = -f;
        } else if (f > 180.0f && f < 360.0f) {
            f = 360.0f - f;
        }
        Log.d("testdeg", "am3d deg is " + f);
        AM3DEffect aM3DEffect = this.effect_am3d;
        if (aM3DEffect != null) {
            aM3DEffect.setAM3DParameter(6, 12, (int) f);
        }
    }
}
