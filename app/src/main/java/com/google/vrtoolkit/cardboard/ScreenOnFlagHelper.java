package com.google.vrtoolkit.cardboard;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.Window;
import com.google.android.exoplayer2.C;
import com.zte.ucs.tvcall.Commons;

/* loaded from: classes.dex */
public class ScreenOnFlagHelper implements SensorEventListener {
    private static final boolean DEBUG = false;
    private static final long IDLE_TIMEOUT_MS = 30000;
    private static final int NUM_SAMPLES = 120;
    private static final long SAMPLE_INTERVAL_MS = 250;
    private static final float SENSOR_THRESHOLD = 0.2f;
    private static final String TAG = "ScreenOnFlagHelper";
    private Activity activity;
    private Sensor sensor;
    private SensorManager sensorManager;
    private boolean screenAlwaysOn = false;
    private SensorReadingStats sensorStats = new SensorReadingStats(120, 3);
    private long lastSampleTimestamp = 0;
    private boolean isFlagSet = false;

    public ScreenOnFlagHelper(Activity activity) {
        this.activity = activity;
    }

    private void setKeepScreenOnFlag(boolean z) {
        if (z == this.isFlagSet) {
            return;
        }
        Window window = this.activity.getWindow();
        if (z) {
            window.addFlags(Commons.MSG_MCSP_INIT_SUCCESS);
        } else {
            window.clearFlags(Commons.MSG_MCSP_INIT_SUCCESS);
        }
        this.isFlagSet = z;
    }

    private void updateFlag() {
        if (this.screenAlwaysOn || !this.sensorStats.statsAvailable()) {
            setKeepScreenOnFlag(true);
        } else {
            setKeepScreenOnFlag(this.sensorStats.getMaxAbsoluteDeviation() > SENSOR_THRESHOLD);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if ((sensorEvent.timestamp - this.lastSampleTimestamp) / C.MICROS_PER_SECOND < SAMPLE_INTERVAL_MS) {
            return;
        }
        this.sensorStats.addSample(sensorEvent.values);
        this.lastSampleTimestamp = sensorEvent.timestamp;
        updateFlag();
    }

    public void setScreenAlwaysOn(boolean z) {
        this.screenAlwaysOn = z;
        updateFlag();
    }

    void setSensorManager(SensorManager sensorManager) {
        this.sensorManager = sensorManager;
    }

    public void start() {
        if (this.sensorManager == null) {
            this.sensorManager = (SensorManager) this.activity.getSystemService("sensor");
        }
        if (this.sensor == null) {
            this.sensor = this.sensorManager.getDefaultSensor(1);
        }
        this.isFlagSet = false;
        setKeepScreenOnFlag(true);
        this.sensorStats.reset();
        this.sensorManager.registerListener(this, this.sensor, 250000);
    }

    public void stop() {
        SensorManager sensorManager = this.sensorManager;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        setKeepScreenOnFlag(false);
    }
}
