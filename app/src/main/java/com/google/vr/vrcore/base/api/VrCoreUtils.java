package com.google.vr.vrcore.base.api;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.os.Build;
import com.facebook.internal.Utility;
import com.zte.ucs.tvcall.Commons;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class VrCoreUtils {
    private static final boolean DEBUG = false;
    private static final String TAG = "VrCoreUtils";

    /* loaded from: classes.dex */
    public class ConnectionResult {
        public static final int NOT_SUPPORTED = 7;
        public static final int NO_PERMISSION = 6;
        public static final int SERVICE_DISABLED = 2;
        public static final int SERVICE_MISSING = 1;
        public static final int SERVICE_NOT_CONNECTED = 5;
        public static final int SERVICE_OBSOLETE = 4;
        public static final int SERVICE_UPDATING = 3;
        public static final int SUCCESS = 0;
        public static final int UNKNOWN = 8;
    }

    public static int checkVrCoreAvailability(Context context) {
        return checkVrCoreAvailabilityImpl(context);
    }

    private static int checkVrCoreAvailabilityImpl(Context context) {
        if ("com.google.vr.vrcore".equals(context.getPackageName())) {
            return 0;
        }
        try {
            return context.getPackageManager().getApplicationInfo("com.google.vr.vrcore", 0).enabled ? 0 : 2;
        } catch (PackageManager.NameNotFoundException unused) {
            if (Build.VERSION.SDK_INT >= 21) {
                Iterator<PackageInstaller.SessionInfo> it2 = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
                while (it2.hasNext()) {
                    if ("com.google.vr.vrcore".equals(it2.next().getAppPackageName())) {
                        return 3;
                    }
                }
            }
            try {
                return context.getPackageManager().getApplicationInfo("com.google.vr.vrcore", Utility.DEFAULT_STREAM_BUFFER_SIZE).enabled ? 3 : 1;
            } catch (PackageManager.NameNotFoundException unused2) {
                return 1;
            }
        }
    }

    public static String getConnectionResultString(int i) {
        switch (i) {
            case 0:
                return "VR Service present";
            case 1:
                return "VR Service missing";
            case 2:
                return "VR Service disabled";
            case 3:
                return "VR Service updating";
            case 4:
                return "VR Service obsolete";
            case 5:
                return "VR Service not connected";
            case 6:
                return "No permission to do operation";
            case 7:
                return "This operation is not supported on this device";
            case 8:
                return "An unknown failure occurred";
            default:
                StringBuilder sb = new StringBuilder(38);
                sb.append("Invalid connection result: ");
                sb.append(i);
                return sb.toString();
        }
    }

    public static int getVrCoreClientApiVersion(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo("com.google.vr.vrcore", Commons.MSG_MCSP_INIT_SUCCESS);
            if (!applicationInfo.enabled) {
                throw new VrCoreNotAvailableException(2);
            }
            if (applicationInfo.metaData != null) {
                return applicationInfo.metaData.getInt("com.google.vr.vrcore.ClientApiVersion", 0);
            }
            return 0;
        } catch (PackageManager.NameNotFoundException unused) {
            throw new VrCoreNotAvailableException(checkVrCoreAvailability(context));
        }
    }

    public static boolean isVrCoreAvailable(Context context) {
        return checkVrCoreAvailability(context) == 0;
    }
}
