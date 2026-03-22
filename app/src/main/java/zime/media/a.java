package zime.media;

import android.app.Activity;
import android.content.Context;
import android.view.OrientationEventListener;

/* loaded from: classes2.dex */
final class a extends OrientationEventListener {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        super(context, 3);
    }

    @Override // android.view.OrientationEventListener
    public final void onOrientationChanged(int i) {
        int i2;
        int i3;
        Activity activity;
        int surfaceRotation;
        int i4;
        synchronized (this) {
            try {
                if ((i <= 45 && i >= 0) || (i <= 360 && i > 315)) {
                    int unused = VideoDeviceCallBack.sSensorOrientation = 0;
                } else if (i <= 135 && i > 45) {
                    int unused2 = VideoDeviceCallBack.sSensorOrientation = 90;
                } else if (i <= 225 && i > 135) {
                    int unused3 = VideoDeviceCallBack.sSensorOrientation = 180;
                } else if (i <= 315 && i > 225) {
                    int unused4 = VideoDeviceCallBack.sSensorOrientation = 270;
                }
                i2 = VideoDeviceCallBack.videoCurrentValue;
                if (i2 == 2) {
                    int unused5 = VideoDeviceCallBack.s_Degree = 0;
                } else {
                    i3 = VideoDeviceCallBack.videoCurrentValue;
                    if (i3 != 3) {
                        activity = VideoDeviceCallBack.s_CurActivity;
                        surfaceRotation = VideoDeviceCallBack.getSurfaceRotation(activity);
                        i4 = VideoDeviceCallBack.sSensorOrientation;
                        int unused6 = VideoDeviceCallBack.s_Degree = surfaceRotation + i4;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
