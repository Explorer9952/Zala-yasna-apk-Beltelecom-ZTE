package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;

/* loaded from: classes.dex */
class PhoneUtil20Impl {
    private static int aK = 10000;
    private static int aL = 10000;
    private TelephonyManager aM;
    private PhoneStateListener aN = new PhoneStateListener() { // from class: com.tencent.mm.sdk.platformtools.PhoneUtil20Impl.1
        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            super.onSignalStrengthsChanged(signalStrength);
            if (PhoneUtil20Impl.this.aP == 2) {
                int unused = PhoneUtil20Impl.aL = signalStrength.getCdmaDbm();
            }
            if (PhoneUtil20Impl.this.aP == 1) {
                int unused2 = PhoneUtil20Impl.aL = (signalStrength.getGsmSignalStrength() * 2) - 113;
            }
            if (PhoneUtil20Impl.this.aM != null) {
                PhoneUtil20Impl.this.aM.listen(PhoneUtil20Impl.this.aN, 0);
            }
        }
    };
    private int aP;

    /* JADX WARN: Removed duplicated region for block: B:12:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x004b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<com.tencent.mm.sdk.platformtools.PhoneUtil.CellInfo> getCellInfoList(android.content.Context r20) {
        /*
            Method dump skipped, instructions count: 632
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.PhoneUtil20Impl.getCellInfoList(android.content.Context):java.util.List");
    }

    public void getSignalStrength(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        this.aM = telephonyManager;
        telephonyManager.listen(this.aN, 256);
        this.aP = this.aM.getPhoneType();
    }
}
