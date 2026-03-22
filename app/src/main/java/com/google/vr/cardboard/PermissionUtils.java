package com.google.vr.cardboard;

import android.app.Activity;
import android.content.Context;
import android.os.Build;

/* loaded from: classes.dex */
public class PermissionUtils {
    private static final String STORAGE_PERMISSION = "android.permission.READ_EXTERNAL_STORAGE";
    private static final int STORAGE_PERMISSION_DUMMY_REQUEST_CODE = 239;

    public void requestStoragePermission(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        if (!(context instanceof Activity)) {
            throw new IllegalStateException("Context should be an activity.");
        }
        Activity activity = (Activity) context;
        if (activity.checkSelfPermission(STORAGE_PERMISSION) == 0) {
            return;
        }
        activity.requestPermissions(new String[]{STORAGE_PERMISSION}, STORAGE_PERMISSION_DUMMY_REQUEST_CODE);
    }
}
