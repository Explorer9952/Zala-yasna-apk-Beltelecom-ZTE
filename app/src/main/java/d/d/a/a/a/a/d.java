package d.d.a.a.a.a;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: DeviceSensorLooper.java */
/* loaded from: classes.dex */
class d implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f8028a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.f8028a = cVar;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
        ArrayList arrayList;
        ArrayList arrayList2;
        arrayList = this.f8028a.e;
        synchronized (arrayList) {
            arrayList2 = this.f8028a.e;
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                ((SensorEventListener) it2.next()).onAccuracyChanged(sensor, i);
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        ArrayList arrayList;
        ArrayList arrayList2;
        arrayList = this.f8028a.e;
        synchronized (arrayList) {
            arrayList2 = this.f8028a.e;
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                ((SensorEventListener) it2.next()).onSensorChanged(sensorEvent);
            }
        }
    }
}
