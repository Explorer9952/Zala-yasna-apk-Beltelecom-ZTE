package com.picovr.picovrlib;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.picovr.PicoManager;
import android.util.Log;
import com.google.common.logging.nano.Vr;
import com.picovr.android.sdk.PicovrSDK;
import ijk.media.player.IMediaPlayer;

/* loaded from: classes.dex */
public class PeriodicService extends Service {
    private static PicoManager mPicoManager;
    private final int PERIODIC_EVENT_TIMEOUT = Vr.VREvent.EventType.START_VR_LAUNCHER_COLD;
    private final int PERIODIC_EVENT_TIMEOUT_PSENSORSTATE = IMediaPlayer.MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK;
    private Runnable doPeriodicTask = new Runnable() { // from class: com.picovr.picovrlib.PeriodicService.1
        @Override // java.lang.Runnable
        public void run() {
            Log.d("PeriodicService", "---doPeriodicTask---");
            if (PeriodicService.mPicoManager != null) {
                PeriodicService.mPicoManager.requestHidSensor(1);
            }
            PeriodicService.this.mPeriodicEventHandler.postDelayed(PeriodicService.this.doPeriodicTask, 3000L);
        }
    };
    private Runnable doPeriodicTaskPsensor = new Runnable() { // from class: com.picovr.picovrlib.PeriodicService.2
        @Override // java.lang.Runnable
        public void run() {
            Log.d("PeriodicService", "---doPeriodicTaskPsensor---");
            if (PeriodicService.mPicoManager != null) {
                PeriodicService.mPicoManager.updateHmdPsensorStatus(PicovrSDK.getPsensor());
            }
            PeriodicService.this.mPeriodicEventHandler.postDelayed(PeriodicService.this.doPeriodicTaskPsensor, 200L);
        }
    };
    private Handler mPeriodicEventHandler;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.d("PeriodicService", "---onCreate---");
        mPicoManager = (PicoManager) getSystemService("pico_manager");
        Handler handler = new Handler();
        this.mPeriodicEventHandler = handler;
        handler.postDelayed(this.doPeriodicTaskPsensor, 200L);
    }

    @Override // android.app.Service
    public void onDestroy() {
        Log.d("PeriodicService", "---onDestroy---");
        this.mPeriodicEventHandler.removeCallbacks(this.doPeriodicTaskPsensor);
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        Log.d("PeriodicService", "---onStartCommand---");
        return 2;
    }
}
