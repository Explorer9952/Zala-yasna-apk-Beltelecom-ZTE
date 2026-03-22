package com.google.vr.ndk.base;

import android.app.Presentation;
import android.content.Context;
import android.content.res.Configuration;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.vr.cardboard.AndroidNCompat;
import com.google.vr.cardboard.DisplaySynchronizer;
import com.google.vr.cardboard.DisplayUtils;
import com.google.vr.cardboard.EglFactory;
import com.google.vr.cardboard.ScanlineRacingRenderer;
import com.google.vr.cardboard.ThreadUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class GvrLayout extends FrameLayout {
    private static final int EXTERNAL_PRESENTATION_MIN_API = 16;
    private static final String TAG = "GvrLayout";
    private static PresentationFactory sOptionalPresentationFactory;
    private DisplaySynchronizer displaySynchronizer;
    private EglFactory eglFactory;
    private int fixedSurfaceHeightPixels;
    private int fixedSurfaceWidthPixels;
    private GvrApi gvrApi;
    private PresentationHelper presentationHelper;
    private FrameLayout presentationLayout;
    private View presentationView;
    private ScanlineRacingRenderer scanlineRacingRenderer;
    private GvrSurfaceView scanlineRacingView;
    private GvrUiLayout uiLayout;

    /* loaded from: classes.dex */
    public interface PresentationFactory {
        Presentation create(Context context, Display display);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class PresentationHelper implements DisplayManager.DisplayListener {
        private static final boolean DEBUG = false;
        private final Context context;
        private final DisplayManager displayManager;
        private final DisplaySynchronizer displaySynchronizer;
        private String externalDisplayName;
        private final RelativeLayout.LayoutParams layout = new RelativeLayout.LayoutParams(-1, -1);
        private final List listeners = new ArrayList();
        private final FrameLayout originalParent;
        private Presentation presentation;
        private final View view;

        PresentationHelper(Context context, FrameLayout frameLayout, View view, DisplaySynchronizer displaySynchronizer, String str) {
            this.context = context;
            this.originalParent = frameLayout;
            this.view = view;
            this.displaySynchronizer = displaySynchronizer;
            this.externalDisplayName = str;
            this.displayManager = (DisplayManager) context.getSystemService("display");
        }

        private static void detachViewFromParent(View view) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }

        private boolean hasCurrentPresentationExpired() {
            Presentation presentation = this.presentation;
            if (presentation == null) {
                return false;
            }
            return (presentation.isShowing() && this.presentation.getDisplay().isValid()) ? false : true;
        }

        private boolean isValidExternalDisplay(Display display) {
            return display.isValid() && display.getName().equals(this.externalDisplayName);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x008f  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x009f  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00b9  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00d5 A[ORIG_RETURN, RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0094  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void setDisplay(android.view.Display r5) {
            /*
                r4 = this;
                android.app.Presentation r0 = r4.presentation
                r1 = 0
                if (r0 == 0) goto La
                android.view.Display r0 = r0.getDisplay()
                goto Lb
            La:
                r0 = r1
            Lb:
                boolean r2 = r4.hasCurrentPresentationExpired()
                if (r2 != 0) goto L18
                boolean r0 = com.google.vr.cardboard.DisplayUtils.isSameDisplay(r5, r0)
                if (r0 == 0) goto L18
                return
            L18:
                android.app.Presentation r0 = r4.presentation
                if (r0 == 0) goto L21
                r0.dismiss()
                r4.presentation = r1
            L21:
                android.view.View r2 = r4.view
                detachViewFromParent(r2)
                if (r5 == 0) goto L81
                com.google.vr.ndk.base.GvrLayout$PresentationFactory r2 = com.google.vr.ndk.base.GvrLayout.access$400()
                if (r2 == 0) goto L39
                com.google.vr.ndk.base.GvrLayout$PresentationFactory r2 = com.google.vr.ndk.base.GvrLayout.access$400()
                android.content.Context r3 = r4.context
                android.app.Presentation r5 = r2.create(r3, r5)
                goto L41
            L39:
                android.app.Presentation r2 = new android.app.Presentation
                android.content.Context r3 = r4.context
                r2.<init>(r3, r5)
                r5 = r2
            L41:
                r4.presentation = r5
                android.view.View r2 = r4.view
                android.widget.RelativeLayout$LayoutParams r3 = r4.layout
                r5.addContentView(r2, r3)
                android.app.Presentation r5 = r4.presentation     // Catch: android.view.WindowManager.InvalidDisplayException -> L50
                r5.show()     // Catch: android.view.WindowManager.InvalidDisplayException -> L50
                goto L89
            L50:
                r5 = move-exception
                java.lang.String r5 = java.lang.String.valueOf(r5)
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                java.lang.String r3 = java.lang.String.valueOf(r5)
                int r3 = r3.length()
                int r3 = r3 + 57
                r2.<init>(r3)
                java.lang.String r3 = "Attaching Cardboard View to the external display failed: "
                r2.append(r3)
                r2.append(r5)
                java.lang.String r5 = r2.toString()
                java.lang.String r2 = "GvrLayout"
                android.util.Log.e(r2, r5)
                android.app.Presentation r5 = r4.presentation
                r5.cancel()
                r4.presentation = r1
                android.view.View r5 = r4.view
                detachViewFromParent(r5)
            L81:
                android.widget.FrameLayout r5 = r4.originalParent
                android.view.View r1 = r4.view
                r2 = 0
                r5.addView(r1, r2)
            L89:
                com.google.vr.cardboard.DisplaySynchronizer r5 = r4.displaySynchronizer
                android.app.Presentation r1 = r4.presentation
                if (r1 == 0) goto L94
                android.view.Display r1 = r1.getDisplay()
                goto L9a
            L94:
                android.content.Context r1 = r4.context
                android.view.Display r1 = com.google.vr.cardboard.DisplayUtils.getDefaultDisplay(r1)
            L9a:
                r5.setDisplay(r1)
                if (r0 == 0) goto Lb5
                java.util.List r5 = r4.listeners
                java.util.Iterator r5 = r5.iterator()
            La5:
                boolean r0 = r5.hasNext()
                if (r0 == 0) goto Lb5
                java.lang.Object r0 = r5.next()
                com.google.vr.ndk.base.GvrLayout$PresentationListener r0 = (com.google.vr.ndk.base.GvrLayout.PresentationListener) r0
                r0.onPresentationStopped()
                goto La5
            Lb5:
                android.app.Presentation r5 = r4.presentation
                if (r5 == 0) goto Ld5
                java.util.List r5 = r4.listeners
                java.util.Iterator r5 = r5.iterator()
            Lbf:
                boolean r0 = r5.hasNext()
                if (r0 == 0) goto Ld5
                java.lang.Object r0 = r5.next()
                com.google.vr.ndk.base.GvrLayout$PresentationListener r0 = (com.google.vr.ndk.base.GvrLayout.PresentationListener) r0
                android.app.Presentation r1 = r4.presentation
                android.view.Display r1 = r1.getDisplay()
                r0.onPresentationStarted(r1)
                goto Lbf
            Ld5:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.vr.ndk.base.GvrLayout.PresentationHelper.setDisplay(android.view.Display):void");
        }

        public void addListener(PresentationListener presentationListener) {
            if (this.listeners.contains(presentationListener)) {
                return;
            }
            this.listeners.add(presentationListener);
            Presentation presentation = this.presentation;
            if (presentation != null) {
                presentationListener.onPresentationStarted(presentation.getDisplay());
            }
        }

        public boolean isPresenting() {
            Presentation presentation = this.presentation;
            return presentation != null && presentation.isShowing();
        }

        public void onDetachedFromWindow() {
            this.displayManager.unregisterDisplayListener(this);
            setDisplay(null);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i) {
            Display display = this.displayManager.getDisplay(i);
            if (isValidExternalDisplay(display)) {
                setDisplay(display);
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i) {
            Presentation presentation = this.presentation;
            if (presentation == null || presentation.getDisplay().getDisplayId() != i) {
                return;
            }
            setDisplay(null);
        }

        public void onPause() {
            this.displayManager.unregisterDisplayListener(this);
        }

        public void onResume() {
            String externalDisplayName = DisplayUtils.getExternalDisplayName(this.context);
            this.externalDisplayName = externalDisplayName;
            Display display = null;
            if (externalDisplayName == null) {
                setDisplay(null);
                return;
            }
            this.displayManager.registerDisplayListener(this, null);
            Display[] displays = this.displayManager.getDisplays();
            int length = displays.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                Display display2 = displays[i];
                if (isValidExternalDisplay(display2)) {
                    display = display2;
                    break;
                }
                i++;
            }
            setDisplay(display);
        }

        public void shutdown() {
            this.displayManager.unregisterDisplayListener(this);
            Presentation presentation = this.presentation;
            if (presentation != null) {
                presentation.cancel();
                this.presentation = null;
                Iterator it2 = this.listeners.iterator();
                while (it2.hasNext()) {
                    ((PresentationListener) it2.next()).onPresentationStopped();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface PresentationListener {
        void onPresentationStarted(Display display);

        void onPresentationStopped();
    }

    public GvrLayout(Context context) {
        super(context);
        init(null);
    }

    public GvrLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(null);
    }

    public GvrLayout(Context context, DisplaySynchronizer displaySynchronizer) {
        super(context);
        init(displaySynchronizer);
    }

    private void addScanlineRacingView() {
        if (this.scanlineRacingView != null) {
            return;
        }
        this.scanlineRacingRenderer = new ScanlineRacingRenderer(getGvrApi());
        EglFactory eglFactory = new EglFactory();
        this.eglFactory = eglFactory;
        eglFactory.setUsePriorityContext(true);
        this.eglFactory.setUseProtectedBuffers(getGvrApi().getUsingProtectedBuffers());
        this.eglFactory.setEGLContextClientVersion(2);
        GvrSurfaceView gvrSurfaceView = new GvrSurfaceView(getContext());
        this.scanlineRacingView = gvrSurfaceView;
        gvrSurfaceView.setEGLContextClientVersion(2);
        this.scanlineRacingView.setEGLConfigChooser(8, 8, 8, 0, 0, 0);
        this.scanlineRacingView.setZOrderMediaOverlay(true);
        this.scanlineRacingView.setEGLContextFactory(this.eglFactory);
        this.scanlineRacingView.setEGLWindowSurfaceFactory(this.eglFactory);
        this.scanlineRacingView.setRenderer(this.scanlineRacingRenderer);
        this.scanlineRacingView.setSwapMode(1);
        if (this.fixedSurfaceWidthPixels > 0 && this.fixedSurfaceHeightPixels > 0) {
            this.scanlineRacingView.getHolder().setFixedSize(this.fixedSurfaceWidthPixels, this.fixedSurfaceHeightPixels);
        }
        this.presentationLayout.addView(this.scanlineRacingView, 0);
    }

    private void init(DisplaySynchronizer displaySynchronizer) {
        this.presentationLayout = new FrameLayout(getContext());
        this.uiLayout = new GvrUiLayout(getContext());
        if (displaySynchronizer == null) {
            displaySynchronizer = GvrApi.createDefaultDisplaySynchronizer(getContext());
        }
        this.displaySynchronizer = displaySynchronizer;
        this.presentationHelper = tryCreatePresentationHelper();
        addView(this.presentationLayout, 0);
        addView(this.uiLayout, 1);
    }

    public static void setPresentationFactory(PresentationFactory presentationFactory) {
        sOptionalPresentationFactory = presentationFactory;
    }

    private PresentationHelper tryCreatePresentationHelper() {
        if (Build.VERSION.SDK_INT <= 16) {
            return null;
        }
        String externalDisplayName = DisplayUtils.getExternalDisplayName(getContext());
        if (externalDisplayName != null) {
            return new PresentationHelper(getContext(), this, this.presentationLayout, this.displaySynchronizer, externalDisplayName);
        }
        Log.e(TAG, "HDMI display name could not be found, disabling external presentation support");
        return null;
    }

    public void addPresentationListener(PresentationListener presentationListener) {
        PresentationHelper presentationHelper = this.presentationHelper;
        if (presentationHelper != null) {
            presentationHelper.addListener(presentationListener);
        }
    }

    public DisplaySynchronizer getDisplaySynchronizer() {
        return this.displaySynchronizer;
    }

    public GvrApi getGvrApi() {
        if (this.gvrApi == null) {
            if (this.presentationView == null) {
                Log.w(TAG, "No presentation View has been set, stereo rendering may not work properly.");
            }
            this.gvrApi = new GvrApi(getContext(), this.displaySynchronizer);
        }
        return this.gvrApi;
    }

    public GvrUiLayout getUiLayout() {
        return this.uiLayout;
    }

    public boolean isPresenting() {
        PresentationHelper presentationHelper;
        return (this.presentationView == null || (presentationHelper = this.presentationHelper) == null || !presentationHelper.isPresenting()) ? false : true;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.displaySynchronizer.onConfigurationChanged();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        PresentationHelper presentationHelper = this.presentationHelper;
        if (presentationHelper != null) {
            presentationHelper.onDetachedFromWindow();
        }
    }

    public void onPause() {
        GvrSurfaceView gvrSurfaceView = this.scanlineRacingView;
        if (gvrSurfaceView != null) {
            gvrSurfaceView.queueEvent(new Runnable() { // from class: com.google.vr.ndk.base.GvrLayout.1
                @Override // java.lang.Runnable
                public void run() {
                    GvrLayout.this.scanlineRacingRenderer.onPause();
                }
            });
            this.scanlineRacingView.onPause();
        }
        PresentationHelper presentationHelper = this.presentationHelper;
        if (presentationHelper != null) {
            presentationHelper.onPause();
        }
        this.displaySynchronizer.onPause();
    }

    public void onResume() {
        this.displaySynchronizer.onResume();
        PresentationHelper presentationHelper = this.presentationHelper;
        if (presentationHelper != null) {
            presentationHelper.onResume();
        }
        GvrSurfaceView gvrSurfaceView = this.scanlineRacingView;
        if (gvrSurfaceView != null) {
            gvrSurfaceView.onResume();
            this.scanlineRacingView.queueEvent(new Runnable() { // from class: com.google.vr.ndk.base.GvrLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    GvrLayout.this.scanlineRacingRenderer.onResume();
                }
            });
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.presentationView != null && isPresenting() && this.presentationView.dispatchTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setFixedPresentationSurfaceSize(final int i, final int i2) {
        if ((i == 0) != (i2 == 0)) {
            throw new IllegalArgumentException("Custom surface dimensions should both either be zero or non-zero");
        }
        getGvrApi().setSurfaceSize(i, i2);
        if (getGvrApi().getBoolParameter(1)) {
            ThreadUtils.runOnUiThread(new Runnable() { // from class: com.google.vr.ndk.base.GvrLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    GvrLayout.this.fixedSurfaceWidthPixels = i;
                    GvrLayout.this.fixedSurfaceHeightPixels = i2;
                    if (i <= 0 || i2 <= 0) {
                        GvrLayout.this.scanlineRacingView.getHolder().setSizeFromLayout();
                    } else {
                        GvrLayout.this.scanlineRacingView.getHolder().setFixedSize(i, i2);
                    }
                }
            });
        }
    }

    public void setPresentationView(View view) {
        View view2 = this.presentationView;
        if (view2 != null) {
            this.presentationLayout.removeView(view2);
        }
        this.presentationLayout.addView(view, 0);
        this.presentationView = view;
    }

    public boolean setScanlineRacingEnabled(boolean z) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("setScanlineRacingEnabled may only be called from the UI thread");
        }
        if (this.scanlineRacingView != null && !z) {
            throw new UnsupportedOperationException("Scanline racing cannot be disabled once enabled");
        }
        if (z && !AndroidNCompat.isVrReady(getContext())) {
            return false;
        }
        boolean boolParameter = getGvrApi().setBoolParameter(1, z);
        if (z && boolParameter) {
            addScanlineRacingView();
        }
        return boolParameter;
    }

    public void shutdown() {
        this.displaySynchronizer.shutdown();
        removeView(this.presentationLayout);
        this.scanlineRacingView = null;
        this.presentationView = null;
        PresentationHelper presentationHelper = this.presentationHelper;
        if (presentationHelper != null) {
            presentationHelper.shutdown();
            this.presentationHelper = null;
        }
        GvrApi gvrApi = this.gvrApi;
        if (gvrApi != null) {
            gvrApi.shutdown();
            this.gvrApi = null;
        }
    }
}
