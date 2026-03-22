package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

/* loaded from: classes.dex */
class PhoneUtil16Impl {
    private static int aK = 10000;
    private static int aL = 10000;
    private TelephonyManager aM;
    private PhoneStateListener aN = new PhoneStateListener() { // from class: com.tencent.mm.sdk.platformtools.PhoneUtil16Impl.1
        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthChanged(int i) {
            super.onSignalStrengthChanged(i);
            int unused = PhoneUtil16Impl.aL = (i * 2) - 113;
            if (PhoneUtil16Impl.this.aM != null) {
                PhoneUtil16Impl.this.aM.listen(PhoneUtil16Impl.this.aN, 0);
            }
        }
    };

    /* JADX WARN: Can't wrap try/catch for region: R(11:5|6|7|(3:9|10|11)|12|13|14|(2:16|(9:20|(1:46)|22|23|24|25|26|27|(3:31|(4:34|(3:36|37|38)(1:40)|39|32)|41)))|47|27|(4:29|31|(1:32)|41)) */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x008e, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x008f, code lost:
    
        r17 = r4;
        r4 = -1;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0040 A[Catch: Exception -> 0x008e, TryCatch #1 {Exception -> 0x008e, blocks: (B:14:0x0038, B:16:0x0040, B:20:0x0051, B:23:0x0068, B:46:0x0059), top: B:13:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<com.tencent.mm.sdk.platformtools.PhoneUtil.CellInfo> getCellInfoList(android.content.Context r17) {
        /*
            Method dump skipped, instructions count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.PhoneUtil16Impl.getCellInfoList(android.content.Context):java.util.List");
    }

    public void getSignalStrength(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        this.aM = telephonyManager;
        telephonyManager.listen(this.aN, 256);
    }
}
