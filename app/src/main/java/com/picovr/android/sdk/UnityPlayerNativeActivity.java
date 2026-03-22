package com.picovr.android.sdk;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.unity3d.player.UnityPlayer;

/* loaded from: classes.dex */
public class UnityPlayerNativeActivity extends Activity {
    protected UnityPlayer mUnityPlayer;

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Log.i("berton", "======dispatchKeyEvent======" + keyEvent.getKeyCode());
        if (keyEvent.getAction() == 2) {
            return this.mUnityPlayer.injectEvent(keyEvent);
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mUnityPlayer.configurationChanged(configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        getWindow().takeSurface(null);
        getWindow().setFormat(2);
        UnityPlayer unityPlayer = new UnityPlayer(this);
        this.mUnityPlayer = unityPlayer;
        setContentView(unityPlayer);
        this.mUnityPlayer.requestFocus();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        this.mUnityPlayer.quit();
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        return this.mUnityPlayer.injectEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Log.i("berton", "======onKeyDown======" + i);
        return this.mUnityPlayer.injectEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        Log.i("berton", "======onKeyUp======" + i);
        return this.mUnityPlayer.injectEvent(keyEvent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mUnityPlayer.pause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mUnityPlayer.resume();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mUnityPlayer.injectEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.mUnityPlayer.windowFocusChanged(z);
    }
}
