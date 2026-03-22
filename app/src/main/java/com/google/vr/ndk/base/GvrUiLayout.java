package com.google.vr.ndk.base;

import android.app.Activity;
import android.content.Context;
import android.widget.FrameLayout;
import com.google.vr.cardboard.UiLayer;
import com.google.vr.cardboard.UiUtils;

/* loaded from: classes.dex */
public class GvrUiLayout extends FrameLayout {
    private final UiLayer uiLayer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GvrUiLayout(Context context) {
        super(context);
        UiLayer uiLayer = new UiLayer(context);
        this.uiLayer = uiLayer;
        addView(uiLayer.getView());
    }

    public static void launchOrInstallGvrApp(Activity activity) {
        UiUtils.launchOrInstallCardboard(activity, true);
    }

    public UiLayer getUiLayer() {
        return this.uiLayer;
    }

    public void setAlignmentMarkerEnabled(boolean z) {
        this.uiLayer.setAlignmentMarkerEnabled(z);
    }

    public void setBackButtonListener(Runnable runnable) {
        this.uiLayer.setBackButtonListener(runnable);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        this.uiLayer.setEnabled(z);
    }

    public void setSettingsButtonEnabled(boolean z) {
        this.uiLayer.setSettingsButtonEnabled(z);
    }

    public void setTransitionViewEnabled(boolean z) {
        this.uiLayer.setTransitionViewEnabled(z);
    }

    public void setViewerName(String str) {
        this.uiLayer.setViewerName(str);
    }
}
