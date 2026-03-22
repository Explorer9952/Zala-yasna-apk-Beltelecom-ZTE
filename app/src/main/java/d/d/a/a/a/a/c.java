package d.d.a.a.a.a;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Looper;
import java.util.ArrayList;

/* compiled from: DeviceSensorLooper.java */
/* loaded from: classes.dex */
public class c implements g {
    private static final String g = "c";

    /* renamed from: a, reason: collision with root package name */
    private boolean f8024a;

    /* renamed from: b, reason: collision with root package name */
    private SensorManager f8025b;

    /* renamed from: c, reason: collision with root package name */
    private Looper f8026c;

    /* renamed from: d, reason: collision with root package name */
    private SensorEventListener f8027d;
    private final ArrayList<SensorEventListener> e = new ArrayList<>();
    private int f;

    public c(SensorManager sensorManager, int i) {
        this.f8025b = sensorManager;
        this.f = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Sensor d() {
        if (Build.MANUFACTURER.equals("HTC")) {
            return null;
        }
        return this.f8025b.getDefaultSensor(16);
    }

    @Override // d.d.a.a.a.a.g
    public void a() {
        if (this.f8024a) {
            return;
        }
        this.f8027d = new d(this);
        e eVar = new e(this, "sensor");
        eVar.start();
        this.f8026c = eVar.getLooper();
        this.f8024a = true;
    }

    @Override // d.d.a.a.a.a.g
    public void b() {
        if (this.f8024a) {
            this.f8025b.unregisterListener(this.f8027d);
            this.f8027d = null;
            this.f8026c.quit();
            this.f8026c = null;
            this.f8024a = false;
        }
    }

    @Override // d.d.a.a.a.a.g
    public void a(SensorEventListener sensorEventListener) {
        synchronized (this.e) {
            this.e.remove(sensorEventListener);
        }
    }

    @Override // d.d.a.a.a.a.g
    public void b(SensorEventListener sensorEventListener) {
        synchronized (this.e) {
            this.e.add(sensorEventListener);
        }
    }
}
