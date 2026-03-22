package com.unity3d.player;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.tencent.mm.sdk.platformtools.Util;
import com.unity3d.player.i;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes.dex */
public class UnityPlayer extends FrameLayout {
    public static Activity currentActivity;
    private static boolean m;

    /* renamed from: a, reason: collision with root package name */
    c f2933a;

    /* renamed from: b, reason: collision with root package name */
    f f2934b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f2935c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f2936d;
    private h e;
    private final ConcurrentLinkedQueue f;
    private BroadcastReceiver g;
    private boolean h;
    private a i;
    private TelephonyManager j;
    private ContextWrapper k;
    private SurfaceView l;
    private boolean n;
    private Bundle o;
    private i p;
    private boolean q;
    private ProgressBar r;
    private Runnable s;
    private Runnable t;

    /* renamed from: com.unity3d.player.UnityPlayer$4, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass4 extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ UnityPlayer f2958a;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            this.f2958a.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends PhoneStateListener {
        private a() {
        }

        /* synthetic */ a(UnityPlayer unityPlayer, byte b2) {
            this();
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCallStateChanged(int i, String str) {
            UnityPlayer.this.nativeMuteMasterAudio(i == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum b {
        PAUSE,
        RESUME,
        QUIT,
        FOCUS_GAINED,
        FOCUS_LOST,
        NEXT_FRAME
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends Thread {

        /* renamed from: a, reason: collision with root package name */
        Handler f2977a;

        /* renamed from: b, reason: collision with root package name */
        boolean f2978b;

        private c() {
            this.f2978b = false;
        }

        /* synthetic */ c(UnityPlayer unityPlayer, byte b2) {
            this();
        }

        private void a(b bVar) {
            Message.obtain(this.f2977a, 2269, bVar).sendToTarget();
        }

        public final void a() {
            a(b.QUIT);
        }

        public final void a(boolean z) {
            a(z ? b.FOCUS_GAINED : b.FOCUS_LOST);
        }

        public final void b() {
            a(b.RESUME);
        }

        public final void c() {
            a(b.PAUSE);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            setName("UnityMain");
            Looper.prepare();
            this.f2977a = new Handler(new Handler.Callback() { // from class: com.unity3d.player.UnityPlayer.c.1
                /* JADX WARN: Code restructure failed: missing block: B:22:0x0038, code lost:
                
                    if (r5.f2978b == false) goto L14;
                 */
                @Override // android.os.Handler.Callback
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final boolean handleMessage(android.os.Message r5) {
                    /*
                        r4 = this;
                        int r0 = r5.what
                        r1 = 0
                        r2 = 2269(0x8dd, float:3.18E-42)
                        if (r0 == r2) goto L8
                        return r1
                    L8:
                        java.lang.Object r5 = r5.obj
                        com.unity3d.player.UnityPlayer$b r5 = (com.unity3d.player.UnityPlayer.b) r5
                        com.unity3d.player.UnityPlayer$b r0 = com.unity3d.player.UnityPlayer.b.QUIT
                        r3 = 1
                        if (r5 != r0) goto L19
                        android.os.Looper r5 = android.os.Looper.myLooper()
                        r5.quit()
                        goto L61
                    L19:
                        com.unity3d.player.UnityPlayer$b r0 = com.unity3d.player.UnityPlayer.b.RESUME
                        if (r5 != r0) goto L22
                        com.unity3d.player.UnityPlayer$c r5 = com.unity3d.player.UnityPlayer.c.this
                        r5.f2978b = r3
                        goto L61
                    L22:
                        com.unity3d.player.UnityPlayer$b r0 = com.unity3d.player.UnityPlayer.b.PAUSE
                        if (r5 != r0) goto L30
                        com.unity3d.player.UnityPlayer$c r5 = com.unity3d.player.UnityPlayer.c.this
                        r5.f2978b = r1
                    L2a:
                        com.unity3d.player.UnityPlayer r5 = com.unity3d.player.UnityPlayer.this
                        r5.executeGLThreadJobs()
                        goto L61
                    L30:
                        com.unity3d.player.UnityPlayer$b r0 = com.unity3d.player.UnityPlayer.b.FOCUS_LOST
                        if (r5 != r0) goto L3b
                        com.unity3d.player.UnityPlayer$c r5 = com.unity3d.player.UnityPlayer.c.this
                        boolean r0 = r5.f2978b
                        if (r0 != 0) goto L61
                        goto L2a
                    L3b:
                        com.unity3d.player.UnityPlayer$b r0 = com.unity3d.player.UnityPlayer.b.NEXT_FRAME
                        if (r5 != r0) goto L61
                        com.unity3d.player.UnityPlayer$c r5 = com.unity3d.player.UnityPlayer.c.this
                        com.unity3d.player.UnityPlayer r5 = com.unity3d.player.UnityPlayer.this
                        r5.executeGLThreadJobs()
                        com.unity3d.player.UnityPlayer$c r5 = com.unity3d.player.UnityPlayer.c.this
                        com.unity3d.player.UnityPlayer r5 = com.unity3d.player.UnityPlayer.this
                        boolean r5 = r5.isFinishing()
                        if (r5 != 0) goto L61
                        com.unity3d.player.UnityPlayer$c r5 = com.unity3d.player.UnityPlayer.c.this
                        com.unity3d.player.UnityPlayer r5 = com.unity3d.player.UnityPlayer.this
                        boolean r5 = com.unity3d.player.UnityPlayer.a(r5)
                        if (r5 != 0) goto L61
                        com.unity3d.player.UnityPlayer$c r5 = com.unity3d.player.UnityPlayer.c.this
                        com.unity3d.player.UnityPlayer r5 = com.unity3d.player.UnityPlayer.this
                        com.unity3d.player.UnityPlayer.b(r5)
                    L61:
                        com.unity3d.player.UnityPlayer$c r5 = com.unity3d.player.UnityPlayer.c.this
                        boolean r0 = r5.f2978b
                        if (r0 == 0) goto L72
                        android.os.Handler r5 = r5.f2977a
                        com.unity3d.player.UnityPlayer$b r0 = com.unity3d.player.UnityPlayer.b.NEXT_FRAME
                        android.os.Message r5 = android.os.Message.obtain(r5, r2, r0)
                        r5.sendToTarget()
                    L72:
                        return r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.unity3d.player.UnityPlayer.c.AnonymousClass1.handleMessage(android.os.Message):boolean");
                }
            });
            Looper.loop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public abstract class d implements Runnable {
        private d() {
        }

        /* synthetic */ d(UnityPlayer unityPlayer, byte b2) {
            this();
        }

        public abstract void a();

        @Override // java.lang.Runnable
        public final void run() {
            if (UnityPlayer.this.isFinishing()) {
                return;
            }
            a();
        }
    }

    static {
        new g().a();
        m = false;
        m = loadLibraryStatic("main");
    }

    public UnityPlayer(ContextWrapper contextWrapper) {
        super(contextWrapper);
        byte b2 = 0;
        this.f2935c = false;
        this.f2936d = true;
        this.e = new h();
        this.f = new ConcurrentLinkedQueue();
        this.g = null;
        this.f2933a = new c(this, b2);
        this.h = false;
        this.i = new a(this, b2);
        this.o = new Bundle();
        this.q = false;
        this.f2934b = null;
        this.r = null;
        this.s = new Runnable() { // from class: com.unity3d.player.UnityPlayer.2
            @Override // java.lang.Runnable
            public final void run() {
                int nativeActivityIndicatorStyle = UnityPlayer.this.nativeActivityIndicatorStyle();
                if (nativeActivityIndicatorStyle >= 0) {
                    if (UnityPlayer.this.r == null) {
                        int[] iArr = {R.attr.progressBarStyleLarge, R.attr.progressBarStyleLargeInverse, R.attr.progressBarStyleSmall, R.attr.progressBarStyleSmallInverse};
                        UnityPlayer.this.r = new ProgressBar(UnityPlayer.this.k, null, iArr[nativeActivityIndicatorStyle]);
                        UnityPlayer.this.r.setIndeterminate(true);
                        UnityPlayer.this.r.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 51));
                        UnityPlayer unityPlayer = UnityPlayer.this;
                        unityPlayer.addView(unityPlayer.r);
                    }
                    UnityPlayer.this.r.setVisibility(0);
                    UnityPlayer unityPlayer2 = UnityPlayer.this;
                    unityPlayer2.bringChildToFront(unityPlayer2.r);
                }
            }
        };
        this.t = new Runnable() { // from class: com.unity3d.player.UnityPlayer.3
            @Override // java.lang.Runnable
            public final void run() {
                if (UnityPlayer.this.r != null) {
                    UnityPlayer.this.r.setVisibility(8);
                    UnityPlayer unityPlayer = UnityPlayer.this;
                    unityPlayer.removeView(unityPlayer.r);
                    UnityPlayer.this.r = null;
                }
            }
        };
        if (contextWrapper instanceof Activity) {
            currentActivity = (Activity) contextWrapper;
        }
        this.k = contextWrapper;
        a();
        if (e.f3000b) {
            if (currentActivity != null) {
                e.f3001c.a(currentActivity, new Runnable() { // from class: com.unity3d.player.UnityPlayer.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        UnityPlayer.this.a(new Runnable() { // from class: com.unity3d.player.UnityPlayer.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                UnityPlayer.this.e.d();
                                UnityPlayer.this.e();
                            }
                        });
                    }
                });
            } else {
                this.e.d();
            }
        }
        a(this.k.getApplicationInfo());
        if (!h.c()) {
            AlertDialog create = new AlertDialog.Builder(this.k).setTitle("Failure to initialize!").setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.unity3d.player.UnityPlayer.13
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    UnityPlayer.this.b();
                }
            }).setMessage("Your hardware does not support this application, sorry!").create();
            create.setCancelable(false);
            create.show();
            return;
        }
        initJni(contextWrapper);
        nativeFile(this.k.getPackageCodePath());
        g();
        SurfaceView surfaceView = new SurfaceView(contextWrapper);
        this.l = surfaceView;
        surfaceView.getHolder().setFormat(2);
        this.l.getHolder().addCallback(new SurfaceHolder.Callback() { // from class: com.unity3d.player.UnityPlayer.14
            @Override // android.view.SurfaceHolder.Callback
            public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                UnityPlayer.this.a(0, surfaceHolder.getSurface());
            }

            @Override // android.view.SurfaceHolder.Callback
            public final void surfaceCreated(SurfaceHolder surfaceHolder) {
                UnityPlayer.this.a(0, surfaceHolder.getSurface());
            }

            @Override // android.view.SurfaceHolder.Callback
            public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                UnityPlayer.this.a(0, (Surface) null);
            }
        });
        this.l.setFocusable(true);
        this.l.setFocusableInTouchMode(true);
        addView(this.l);
        this.n = false;
        nativeInitWWW(WWW.class);
        nativeInitWebRequest(UnityWebRequest.class);
        h();
        this.j = (TelephonyManager) this.k.getSystemService("phone");
        this.f2933a.start();
    }

    public static void UnitySendMessage(String str, String str2, String str3) {
        if (h.c()) {
            nativeUnitySendMessage(str, str2, str3);
            return;
        }
        com.unity3d.player.c.Log(5, "Native libraries not loaded - dropping message for " + str + "." + str2);
    }

    private static String a(String str) {
        byte[] bArr;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(str);
            long length = new File(str).length();
            fileInputStream.skip(length - Math.min(length, 65558L));
            byte[] bArr2 = new byte[Util.BYTE_OF_KB];
            for (int i = 0; i != -1; i = fileInputStream.read(bArr2)) {
                messageDigest.update(bArr2, 0, i);
            }
            bArr = messageDigest.digest();
        } catch (FileNotFoundException | IOException | NoSuchAlgorithmException unused) {
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            stringBuffer.append(Integer.toString((b2 & 255) + 256, 16).substring(1));
        }
        return stringBuffer.toString();
    }

    private void a() {
        try {
            File file = new File(this.k.getPackageCodePath(), "assets/bin/Data/settings.xml");
            InputStream fileInputStream = file.exists() ? new FileInputStream(file) : this.k.getAssets().open("bin/Data/settings.xml");
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            newInstance.setNamespaceAware(true);
            XmlPullParser newPullParser = newInstance.newPullParser();
            newPullParser.setInput(fileInputStream, null);
            String str = null;
            String str2 = null;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2) {
                    str2 = newPullParser.getName();
                    for (int i = 0; i < newPullParser.getAttributeCount(); i++) {
                        if (newPullParser.getAttributeName(i).equalsIgnoreCase("name")) {
                            str = newPullParser.getAttributeValue(i);
                        }
                    }
                } else if (eventType == 3) {
                    str2 = null;
                } else if (eventType == 4 && str != null) {
                    if (str2.equalsIgnoreCase("integer")) {
                        this.o.putInt(str, Integer.parseInt(newPullParser.getText()));
                    } else if (str2.equalsIgnoreCase("string")) {
                        this.o.putString(str, newPullParser.getText());
                    } else if (str2.equalsIgnoreCase("bool")) {
                        this.o.putBoolean(str, Boolean.parseBoolean(newPullParser.getText()));
                    } else if (str2.equalsIgnoreCase("float")) {
                        this.o.putFloat(str, Float.parseFloat(newPullParser.getText()));
                    }
                    str = null;
                }
            }
        } catch (Exception e) {
            com.unity3d.player.c.Log(6, "Unable to locate player settings. " + e.getLocalizedMessage());
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, Surface surface) {
        if (this.f2935c) {
            return;
        }
        b(0, surface);
    }

    private static void a(ApplicationInfo applicationInfo) {
        if (m && NativeLoader.load(applicationInfo.nativeLibraryDir)) {
            h.a();
        }
    }

    private void a(d dVar) {
        if (isFinishing()) {
            return;
        }
        b(dVar);
    }

    private static String[] a(Context context) {
        String packageName = context.getPackageName();
        Vector vector = new Vector();
        try {
            int i = context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
            if (Environment.getExternalStorageState().equals("mounted")) {
                File file = new File(Environment.getExternalStorageDirectory().toString() + "/Android/obb/" + packageName);
                if (file.exists()) {
                    if (i > 0) {
                        String str = file + File.separator + "main." + i + "." + packageName + ".obb";
                        if (new File(str).isFile()) {
                            vector.add(str);
                        }
                    }
                    if (i > 0) {
                        String str2 = file + File.separator + "patch." + i + "." + packageName + ".obb";
                        if (new File(str2).isFile()) {
                            vector.add(str2);
                        }
                    }
                }
            }
            String[] strArr = new String[vector.size()];
            vector.toArray(strArr);
            return strArr;
        } catch (PackageManager.NameNotFoundException unused) {
            return new String[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ContextWrapper contextWrapper = this.k;
        if (!(contextWrapper instanceof Activity) || ((Activity) contextWrapper).isFinishing()) {
            return;
        }
        ((Activity) this.k).finish();
    }

    private void b(Runnable runnable) {
        if (h.c()) {
            if (Thread.currentThread() == this.f2933a) {
                runnable.run();
            } else {
                this.f.add(runnable);
            }
        }
    }

    private boolean b(int i, Surface surface) {
        if (!h.c()) {
            return false;
        }
        nativeRecreateGfxState(i, surface);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        reportSoftInputStr(null, 1, true);
        if (this.e.g()) {
            if (h.c()) {
                final Semaphore semaphore = new Semaphore(0);
                b(isFinishing() ? new Runnable() { // from class: com.unity3d.player.UnityPlayer.16
                    @Override // java.lang.Runnable
                    public final void run() {
                        UnityPlayer.this.d();
                        semaphore.release();
                    }
                } : new Runnable() { // from class: com.unity3d.player.UnityPlayer.17
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (!UnityPlayer.this.nativePause()) {
                            semaphore.release();
                            return;
                        }
                        UnityPlayer.i(UnityPlayer.this);
                        UnityPlayer.this.d();
                        semaphore.release(2);
                    }
                });
                try {
                    if (!semaphore.tryAcquire(4L, TimeUnit.SECONDS)) {
                        com.unity3d.player.c.Log(5, "Timeout while trying to pause the Unity Engine.");
                    }
                } catch (InterruptedException unused) {
                    com.unity3d.player.c.Log(5, "UI thread got interrupted while trying to pause the Unity Engine.");
                }
                if (semaphore.drainPermits() > 0) {
                    quit();
                }
            }
            this.e.c(false);
            this.e.b(true);
            if (this.h) {
                this.j.listen(this.i, 0);
            }
            this.f2933a.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        nativeDone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.e.f()) {
            this.e.c(true);
            if (h.c()) {
                g();
            }
            b(new Runnable() { // from class: com.unity3d.player.UnityPlayer.18
                @Override // java.lang.Runnable
                public final void run() {
                    UnityPlayer.this.nativeResume();
                }
            });
            this.f2933a.b();
        }
    }

    private static void f() {
        if (h.c()) {
            if (!NativeLoader.unload()) {
                throw new UnsatisfiedLinkError("Unable to unload libraries from libmain.so");
            }
            h.b();
        }
    }

    private void g() {
        if (this.o.getBoolean("useObb")) {
            for (String str : a(this.k)) {
                String a2 = a(str);
                if (this.o.getBoolean(a2)) {
                    nativeFile(str);
                }
                this.o.remove(a2);
            }
        }
    }

    private void h() {
        ContextWrapper contextWrapper = this.k;
        if (contextWrapper instanceof Activity) {
            ((Activity) contextWrapper).getWindow().setFlags(Util.BYTE_OF_KB, Util.BYTE_OF_KB);
        }
    }

    static /* synthetic */ boolean i(UnityPlayer unityPlayer) {
        unityPlayer.n = true;
        return true;
    }

    private final native void initJni(Context context);

    protected static boolean loadLibraryStatic(String str) {
        StringBuilder sb;
        try {
            System.loadLibrary(str);
            return true;
        } catch (Exception e) {
            sb = new StringBuilder("Unknown error ");
            sb.append(e);
            com.unity3d.player.c.Log(6, sb.toString());
            return false;
        } catch (UnsatisfiedLinkError unused) {
            sb = new StringBuilder("Unable to find ");
            sb.append(str);
            com.unity3d.player.c.Log(6, sb.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native int nativeActivityIndicatorStyle();

    private final native void nativeDone();

    private final native void nativeFile(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeFocusChanged(boolean z);

    private final native void nativeInitWWW(Class cls);

    private final native void nativeInitWebRequest(Class cls);

    private final native boolean nativeInjectEvent(InputEvent inputEvent);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeMuteMasterAudio(boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public final native boolean nativePause();

    private final native void nativeRecreateGfxState(int i, Surface surface);

    /* JADX INFO: Access modifiers changed from: private */
    public final native boolean nativeRender();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeResume();

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeSetInputCanceled(boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeSetInputString(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeSoftInputClosed();

    private static native void nativeUnitySendMessage(String str, String str2, String str3);

    final void a(Runnable runnable) {
        ContextWrapper contextWrapper = this.k;
        if (contextWrapper instanceof Activity) {
            ((Activity) contextWrapper).runOnUiThread(runnable);
        } else {
            com.unity3d.player.c.Log(5, "Not running Unity from an Activity; ignored...");
        }
    }

    protected void addPhoneCallListener() {
        this.h = true;
        this.j.listen(this.i, 32);
    }

    public void configurationChanged(Configuration configuration) {
        SurfaceView surfaceView = this.l;
        if (surfaceView instanceof SurfaceView) {
            surfaceView.getHolder().setSizeFromLayout();
        }
        i iVar = this.p;
        if (iVar != null) {
            iVar.updateVideoLayout();
        }
    }

    protected void disableLogger() {
        com.unity3d.player.c.f2994a = true;
    }

    public boolean displayChanged(int i, Surface surface) {
        if (i == 0) {
            this.f2935c = surface != null;
            a(new Runnable() { // from class: com.unity3d.player.UnityPlayer.15
                @Override // java.lang.Runnable
                public final void run() {
                    if (UnityPlayer.this.f2935c) {
                        UnityPlayer unityPlayer = UnityPlayer.this;
                        unityPlayer.removeView(unityPlayer.l);
                    } else {
                        UnityPlayer unityPlayer2 = UnityPlayer.this;
                        unityPlayer2.addView(unityPlayer2.l);
                    }
                }
            });
        }
        return b(i, surface);
    }

    protected void executeGLThreadJobs() {
        while (true) {
            Runnable runnable = (Runnable) this.f.poll();
            if (runnable == null) {
                return;
            } else {
                runnable.run();
            }
        }
    }

    public Bundle getSettings() {
        return this.o;
    }

    protected int getSplashMode() {
        return this.o.getInt("splash_mode");
    }

    public View getView() {
        return this;
    }

    protected void hideSoftInput() {
        final Runnable runnable = new Runnable() { // from class: com.unity3d.player.UnityPlayer.6
            @Override // java.lang.Runnable
            public final void run() {
                f fVar = UnityPlayer.this.f2934b;
                if (fVar != null) {
                    fVar.dismiss();
                    UnityPlayer.this.f2934b = null;
                }
            }
        };
        if (e.f2999a) {
            a(new d() { // from class: com.unity3d.player.UnityPlayer.7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(UnityPlayer.this, (byte) 0);
                }

                @Override // com.unity3d.player.UnityPlayer.d
                public final void a() {
                    UnityPlayer.this.a(runnable);
                }
            });
        } else {
            a(runnable);
        }
    }

    public void init(int i, boolean z) {
    }

    public boolean injectEvent(InputEvent inputEvent) {
        return nativeInjectEvent(inputEvent);
    }

    protected boolean isFinishing() {
        if (!this.n) {
            ContextWrapper contextWrapper = this.k;
            boolean z = (contextWrapper instanceof Activity) && ((Activity) contextWrapper).isFinishing();
            this.n = z;
            if (!z) {
                return false;
            }
        }
        return true;
    }

    protected void kill() {
        Process.killProcess(Process.myPid());
    }

    protected boolean loadLibrary(String str) {
        return loadLibraryStatic(str);
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        return injectEvent(motionEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return injectEvent(keyEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return injectEvent(motionEvent);
    }

    public void pause() {
        i iVar = this.p;
        if (iVar == null) {
            c();
            return;
        }
        boolean a2 = iVar.a();
        this.q = a2;
        if (a2) {
            return;
        }
        this.p.pause();
    }

    public void quit() {
        this.n = true;
        if (!this.e.e()) {
            pause();
        }
        this.f2933a.a();
        try {
            this.f2933a.join(4000L);
        } catch (InterruptedException unused) {
            this.f2933a.interrupt();
        }
        BroadcastReceiver broadcastReceiver = this.g;
        if (broadcastReceiver != null) {
            this.k.unregisterReceiver(broadcastReceiver);
        }
        this.g = null;
        if (h.c()) {
            removeAllViews();
        }
        kill();
        f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportSoftInputStr(final String str, final int i, final boolean z) {
        if (i == 1) {
            hideSoftInput();
        }
        a(new d() { // from class: com.unity3d.player.UnityPlayer.9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(UnityPlayer.this, (byte) 0);
            }

            @Override // com.unity3d.player.UnityPlayer.d
            public final void a() {
                if (z) {
                    UnityPlayer.this.nativeSetInputCanceled(true);
                } else {
                    String str2 = str;
                    if (str2 != null) {
                        UnityPlayer.this.nativeSetInputString(str2);
                    }
                }
                if (i == 1) {
                    UnityPlayer.this.nativeSoftInputClosed();
                }
            }
        });
    }

    public void resume() {
        this.e.b(false);
        i iVar = this.p;
        if (iVar == null) {
            e();
        } else {
            if (this.q) {
                return;
            }
            iVar.start();
        }
    }

    protected void setSoftInputStr(final String str) {
        a(new Runnable() { // from class: com.unity3d.player.UnityPlayer.8
            @Override // java.lang.Runnable
            public final void run() {
                String str2;
                f fVar = UnityPlayer.this.f2934b;
                if (fVar == null || (str2 = str) == null) {
                    return;
                }
                fVar.a(str2);
            }
        });
    }

    protected void showSoftInput(final String str, final int i, final boolean z, final boolean z2, final boolean z3, final boolean z4, final String str2) {
        a(new Runnable() { // from class: com.unity3d.player.UnityPlayer.5
            @Override // java.lang.Runnable
            public final void run() {
                UnityPlayer.this.f2934b = new f(UnityPlayer.this.k, this, str, i, z, z2, z3, str2);
                UnityPlayer.this.f2934b.show();
            }
        });
    }

    protected boolean showVideoPlayer(final String str, final int i, final int i2, final int i3, final boolean z, final int i4, final int i5) {
        Runnable runnable;
        boolean z2 = false;
        final Semaphore semaphore = new Semaphore(0);
        final AtomicInteger atomicInteger = new AtomicInteger(-1);
        a(new Runnable() { // from class: com.unity3d.player.UnityPlayer.10
            @Override // java.lang.Runnable
            public final void run() {
                if (UnityPlayer.this.p != null) {
                    com.unity3d.player.c.Log(5, "Video already playing");
                    atomicInteger.set(2);
                    semaphore.release();
                } else {
                    UnityPlayer.this.p = new i(UnityPlayer.this.k, str, i, i2, i3, z, i4, i5, new i.a() { // from class: com.unity3d.player.UnityPlayer.10.1
                        @Override // com.unity3d.player.i.a
                        public final void a(int i6) {
                            atomicInteger.set(i6);
                            if (i6 == 3) {
                                if (UnityPlayer.this.l.getParent() == null) {
                                    UnityPlayer unityPlayer = UnityPlayer.this;
                                    unityPlayer.addView(unityPlayer.l);
                                }
                                if (UnityPlayer.this.p != null) {
                                    UnityPlayer.this.p.destroyPlayer();
                                    UnityPlayer unityPlayer2 = UnityPlayer.this;
                                    unityPlayer2.removeView(unityPlayer2.p);
                                    UnityPlayer.this.p = null;
                                }
                                UnityPlayer.this.resume();
                            }
                            if (i6 != 0) {
                                semaphore.release();
                            }
                        }
                    });
                    UnityPlayer unityPlayer = UnityPlayer.this;
                    unityPlayer.addView(unityPlayer.p);
                }
            }
        });
        try {
            semaphore.acquire();
            if (atomicInteger.get() != 2) {
                z2 = true;
            }
        } catch (InterruptedException unused) {
        }
        StringBuilder sb = new StringBuilder("Video returned ");
        sb.append(z2 ? "OK" : "FAIL");
        com.unity3d.player.c.Log(2, sb.toString());
        if (!z2) {
            com.unity3d.player.c.Log(4, "Video failed");
            if (this.p != null) {
                runnable = new Runnable() { // from class: com.unity3d.player.UnityPlayer.12
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (UnityPlayer.this.l.getParent() == null) {
                            UnityPlayer unityPlayer = UnityPlayer.this;
                            unityPlayer.addView(unityPlayer.l);
                        }
                        if (UnityPlayer.this.p != null) {
                            UnityPlayer.this.p.destroyPlayer();
                            UnityPlayer unityPlayer2 = UnityPlayer.this;
                            unityPlayer2.removeView(unityPlayer2.p);
                            UnityPlayer.this.p = null;
                        }
                        UnityPlayer.this.resume();
                    }
                };
                a(runnable);
            }
        } else if (this.p != null) {
            runnable = new Runnable() { // from class: com.unity3d.player.UnityPlayer.11
                @Override // java.lang.Runnable
                public final void run() {
                    if (UnityPlayer.this.p != null) {
                        UnityPlayer.this.c();
                        UnityPlayer.this.p.requestFocus();
                        UnityPlayer unityPlayer = UnityPlayer.this;
                        unityPlayer.removeView(unityPlayer.l);
                    }
                }
            };
            a(runnable);
        }
        return z2;
    }

    protected void startActivityIndicator() {
        a(this.s);
    }

    protected void stopActivityIndicator() {
        a(this.t);
    }

    public void windowFocusChanged(final boolean z) {
        this.e.a(z);
        if (z && this.f2934b != null) {
            reportSoftInputStr(null, 1, false);
        }
        b(new Runnable() { // from class: com.unity3d.player.UnityPlayer.19
            @Override // java.lang.Runnable
            public final void run() {
                UnityPlayer.this.nativeFocusChanged(z);
            }
        });
        this.f2933a.a(z);
        e();
    }
}
