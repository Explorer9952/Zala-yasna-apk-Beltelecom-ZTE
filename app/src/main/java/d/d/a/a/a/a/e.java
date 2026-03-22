package d.d.a.a.a.a;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;

/* compiled from: DeviceSensorLooper.java */
/* loaded from: classes.dex */
class e extends HandlerThread {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f8029a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(c cVar, String str) {
        super(str);
        this.f8029a = cVar;
    }

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() {
        SensorManager sensorManager;
        SensorManager sensorManager2;
        SensorEventListener sensorEventListener;
        int i;
        Sensor d2;
        SensorManager sensorManager3;
        SensorEventListener sensorEventListener2;
        int i2;
        String str;
        SensorManager sensorManager4;
        Handler handler = new Handler(Looper.myLooper());
        sensorManager = this.f8029a.f8025b;
        Sensor defaultSensor = sensorManager.getDefaultSensor(1);
        sensorManager2 = this.f8029a.f8025b;
        sensorEventListener = this.f8029a.f8027d;
        i = this.f8029a.f;
        sensorManager2.registerListener(sensorEventListener, defaultSensor, i, handler);
        d2 = this.f8029a.d();
        if (d2 == null) {
            str = c.g;
            Log.i(str, "Uncalibrated gyroscope unavailable, default to regular gyroscope.");
            sensorManager4 = this.f8029a.f8025b;
            d2 = sensorManager4.getDefaultSensor(4);
        }
        sensorManager3 = this.f8029a.f8025b;
        sensorEventListener2 = this.f8029a.f8027d;
        i2 = this.f8029a.f;
        sensorManager3.registerListener(sensorEventListener2, d2, i2, handler);
    }
}
