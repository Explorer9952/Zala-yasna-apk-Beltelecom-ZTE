package com.tencent.mm.sdk.platformtools;

import android.os.Process;
import java.io.File;
import java.util.Scanner;

/* loaded from: classes.dex */
public final class TrafficStats {
    public static final String DEV_FILE = "/proc/self/net/dev";
    public static final String GPRSLINE = "rmnet0";
    public static final String WIFILINE = "tiwlan0";
    private static long bl;
    private static long bm;
    private static long bn;
    private static long bo;
    private static long bp;
    private static long bq;
    private static long br;
    private static long bs;

    private TrafficStats() {
    }

    public static long getMobileRx(long j) {
        long j2 = bq;
        return j2 > j ? j2 : j;
    }

    public static long getMobileTx(long j) {
        long j2 = bp;
        return j2 > j ? j2 : j;
    }

    public static long getWifiRx(long j) {
        long j2 = bs;
        return j2 > j ? j2 : j;
    }

    public static long getWifiTx(long j) {
        long j2 = br;
        return j2 > j ? j2 : j;
    }

    public static void reset() {
        bl = -1L;
        bm = -1L;
        bn = -1L;
        bo = -1L;
        update();
    }

    public static void update() {
        char c2 = 0;
        try {
            Scanner scanner = new Scanner(new File("/proc/" + Process.myPid() + "/net/dev"));
            scanner.nextLine();
            scanner.nextLine();
            long j = 0;
            long j2 = 0;
            long j3 = 0;
            long j4 = 0;
            while (scanner.hasNext()) {
                String[] split = scanner.nextLine().split("[ :\t]+");
                int i = split[c2].length() == 0 ? 1 : 0;
                if (!split[c2].equals("lo") && split[i + 0].startsWith("rmnet")) {
                    j += Long.parseLong(split[i + 9]);
                    j2 += Long.parseLong(split[i + 1]);
                }
                int i2 = i + 0;
                if (!split[i2].equals("lo") && !split[i2].startsWith("rmnet")) {
                    j3 += Long.parseLong(split[i + 9]);
                    j4 += Long.parseLong(split[i + 1]);
                }
                c2 = 0;
            }
            scanner.close();
            if (bl < 0) {
                bl = j;
                Log.v("MicroMsg.SDK.TrafficStats", "fix loss newMobileTx %d", Long.valueOf(j));
            }
            if (bm < 0) {
                bm = j2;
                Log.v("MicroMsg.SDK.TrafficStats", "fix loss newMobileRx %d", Long.valueOf(j2));
            }
            if (bn < 0) {
                bn = j3;
                Log.v("MicroMsg.SDK.TrafficStats", "fix loss newWifiTx %d", Long.valueOf(j3));
            }
            if (bo < 0) {
                bo = j4;
                Log.v("MicroMsg.SDK.TrafficStats", "fix loss newWifiRx %d", Long.valueOf(j4));
            }
            if (j4 - bo < 0) {
                Log.v("MicroMsg.SDK.TrafficStats", "minu %d", Long.valueOf(j4 - bo));
            }
            if (j3 - bn < 0) {
                Log.v("MicroMsg.SDK.TrafficStats", "minu %d", Long.valueOf(j3 - bn));
            }
            bp = j >= bl ? j - bl : j;
            bq = j2 >= bm ? j2 - bm : j2;
            br = j3 >= bn ? j3 - bn : j3;
            bs = j4 >= bo ? j4 - bo : j4;
            bl = j;
            bm = j2;
            bn = j3;
            bo = j4;
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d("MicroMsg.SDK.TrafficStats", "current system traffic: wifi rx/tx=%d/%d, mobile rx/tx=%d/%d", Long.valueOf(bs), Long.valueOf(br), Long.valueOf(bq), Long.valueOf(bp));
    }

    public static long updateMobileRx(long j) {
        update();
        return getMobileRx(j);
    }

    public static long updateMobileTx(long j) {
        update();
        return getMobileTx(j);
    }

    public static long updateWifiRx(long j) {
        update();
        return getWifiRx(j);
    }

    public static long updateWifiTx(long j) {
        update();
        return getWifiTx(j);
    }
}
