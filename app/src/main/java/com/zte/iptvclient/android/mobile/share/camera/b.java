package com.zte.iptvclient.android.mobile.share.camera;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.video.androidsdk.log.LogEx;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CameraConfigurationManager.java */
/* loaded from: classes2.dex */
public final class b {
    private static final String f = "b";
    private static final Pattern g = Pattern.compile(",");

    /* renamed from: a, reason: collision with root package name */
    private final Context f7183a;

    /* renamed from: b, reason: collision with root package name */
    private Point f7184b;

    /* renamed from: c, reason: collision with root package name */
    private Point f7185c;

    /* renamed from: d, reason: collision with root package name */
    private int f7186d;
    private String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context) {
        this.f7183a = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        this.f7186d = parameters.getPreviewFormat();
        this.e = parameters.get("preview-format");
        Log.d(f, "Default preview format: " + this.f7186d + '/' + this.e);
        Display defaultDisplay = ((WindowManager) this.f7183a.getSystemService("window")).getDefaultDisplay();
        this.f7184b = new Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        Log.d(f, "Screen resolution: " + this.f7184b);
        Point point = new Point();
        Point point2 = this.f7184b;
        point.x = point2.x;
        point.y = point2.y;
        int i = point2.x;
        int i2 = point2.y;
        if (i < i2) {
            point.x = i2;
            point.y = point2.x;
        }
        this.f7185c = a(parameters, point);
        Log.d(f, "Camera resolution: " + this.f7184b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        Log.d(f, "Setting preview size: " + this.f7185c);
        Point point = this.f7185c;
        parameters.setPreviewSize(point.x, point.y);
        a(parameters);
        b(parameters);
        camera.setDisplayOrientation(90);
        camera.setParameters(parameters);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Point d() {
        return this.f7184b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f7186d;
    }

    private void b(Camera.Parameters parameters) {
        String str = parameters.get("zoom-supported");
        if (str == null || Boolean.parseBoolean(str)) {
            int i = 27;
            String str2 = parameters.get("max-zoom");
            if (str2 != null) {
                try {
                    int parseDouble = (int) (Double.parseDouble(str2) * 10.0d);
                    if (27 > parseDouble) {
                        i = parseDouble;
                    }
                } catch (NumberFormatException unused) {
                    Log.w(f, "Bad max-zoom: " + str2);
                }
            }
            String str3 = parameters.get("taking-picture-zoom-max");
            if (str3 != null) {
                try {
                    int parseInt = Integer.parseInt(str3);
                    if (i > parseInt) {
                        i = parseInt;
                    }
                } catch (NumberFormatException unused2) {
                    Log.w(f, "Bad taking-picture-zoom-max: " + str3);
                }
            }
            String str4 = parameters.get("mot-zoom-values");
            if (str4 != null) {
                i = a(str4, i);
            }
            String str5 = parameters.get("mot-zoom-step");
            if (str5 != null) {
                try {
                    int parseDouble2 = (int) (Double.parseDouble(str5.trim()) * 10.0d);
                    if (parseDouble2 > 1) {
                        i -= i % parseDouble2;
                    }
                } catch (NumberFormatException e) {
                    LogEx.d("nfe=", e.toString());
                }
            }
            if (str2 != null || str4 != null) {
                double d2 = i;
                Double.isNaN(d2);
                parameters.set("zoom", String.valueOf(d2 / 10.0d));
            }
            if (str3 != null) {
                parameters.set("taking-picture-zoom", i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Point a() {
        return this.f7185c;
    }

    private static Point a(Camera.Parameters parameters, Point point) {
        String str = parameters.get("preview-size-values");
        if (str == null) {
            str = parameters.get("preview-size-value");
        }
        Point point2 = null;
        if (str != null) {
            Log.d(f, "preview-size-values parameter: " + str);
            point2 = a(str, point);
        }
        return point2 == null ? new Point((point.x >> 3) << 3, (point.y >> 3) << 3) : point2;
    }

    private static Point a(CharSequence charSequence, Point point) {
        String[] split = g.split(charSequence);
        int length = split.length;
        int i = Integer.MAX_VALUE;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            String trim = split[i2].trim();
            int indexOf = trim.indexOf(120);
            if (indexOf < 0) {
                Log.w(f, "Bad preview-size: " + trim);
            } else {
                try {
                    int parseInt = Integer.parseInt(trim.substring(0, indexOf));
                    int parseInt2 = Integer.parseInt(trim.substring(indexOf + 1));
                    int abs = Math.abs(parseInt - point.x) + Math.abs(parseInt2 - point.y);
                    if (abs == 0) {
                        i4 = parseInt2;
                        i3 = parseInt;
                        break;
                    }
                    if (abs < i) {
                        i4 = parseInt2;
                        i = abs;
                        i3 = parseInt;
                    }
                } catch (NumberFormatException unused) {
                    Log.w(f, "Bad preview-size: " + trim);
                }
            }
            i2++;
        }
        if (i3 <= 0 || i4 <= 0) {
            return null;
        }
        return new Point(i3, i4);
    }

    private static int a(CharSequence charSequence, int i) {
        int i2 = 0;
        for (String str : g.split(charSequence)) {
            try {
                double parseDouble = Double.parseDouble(str.trim());
                int i3 = (int) (10.0d * parseDouble);
                double d2 = i;
                Double.isNaN(d2);
                if (Math.abs(d2 - parseDouble) < Math.abs(i - i2)) {
                    i2 = i3;
                }
            } catch (NumberFormatException unused) {
                return i;
            }
        }
        return i2;
    }

    private void a(Camera.Parameters parameters) {
        if (Build.MODEL.contains("Behold II") && c.k == 3) {
            parameters.set("flash-value", 1);
        } else {
            parameters.set("flash-value", 2);
        }
        parameters.set("flash-mode", "off");
    }
}
