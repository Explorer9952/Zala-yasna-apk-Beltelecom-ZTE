package com.picovr.picovrlib;

import android.app.Application;

/* loaded from: classes.dex */
public class VrApplication extends Application {
    protected VrActivity hostActivity;

    public VrActivity getHostActivity() {
        return this.hostActivity;
    }

    public void setHostActivity(VrActivity vrActivity) {
        this.hostActivity = vrActivity;
    }
}
