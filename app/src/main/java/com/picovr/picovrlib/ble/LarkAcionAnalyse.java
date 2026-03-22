package com.picovr.picovrlib.ble;

import android.util.Log;
import com.picovr.picovrlib.service.MacFormat;

/* loaded from: classes.dex */
public class LarkAcionAnalyse {
    private static final String TAG = "BLE";
    private static int lastStatus;
    private static int occurrences;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static LarkAction checkData(byte[] bArr) {
        LarkAction larkAction = new LarkAction();
        if (bArr[0] == 112) {
            switch (bArr[1]) {
                case 1:
                    Log.d(TAG, "Touch 鍚戜笂");
                    larkAction.action = 2;
                    break;
                case 2:
                    Log.d(TAG, "Touch 鍚戜笅");
                    larkAction.action = 3;
                    break;
                case 3:
                    Log.d(TAG, "Touch 鍚戝乏");
                    larkAction.action = 4;
                    break;
                case 4:
                    Log.d(TAG, "Touch 鍚戝彸");
                    larkAction.action = 5;
                    break;
                case 5:
                    Log.d(TAG, "Touch 鐐瑰嚮");
                    larkAction.action = 1;
                    break;
                case 6:
                    Log.d(TAG, "back 鐭\ue15f寜");
                    larkAction.action = 6;
                    break;
                case 7:
                    Log.d(TAG, "back 闀挎寜");
                    larkAction.action = 7;
                    break;
            }
        } else if (bArr[0] == 80) {
            if (bArr[1] == 17) {
                byte b2 = bArr[2];
                if (b2 == 17) {
                    Log.d(TAG, "p-sensor 闈犺繎");
                    larkAction.action = 13;
                } else if (b2 == 34) {
                    Log.d(TAG, "p-sensor 杩滅\ue787");
                    larkAction.action = 14;
                } else if (b2 == 51) {
                    Log.d(TAG, "p-sensor 鍑洪敊");
                    larkAction.action = 15;
                }
            } else if (bArr[1] == 34) {
                byte b3 = bArr[2];
                if (b3 == 17) {
                    Log.d(TAG, "鑰虫満 鎻掑叆");
                    larkAction.action = 11;
                } else if (b3 == 34) {
                    Log.d(TAG, "鑰虫満 鎷斿嚭");
                    larkAction.action = 12;
                }
            }
        } else if (bArr[0] == 83) {
            larkAction.action = 8;
            for (int i = 0; i < 6; i++) {
                larkAction.mac[i] = bArr[6 - i];
            }
        } else if (bArr[0] == 81) {
            Log.d(TAG, "MFB澶氬姛鑳介敭");
            larkAction.action = 10;
        } else if ((bArr[0] & 255) == 144) {
            Log.d(TAG, "闊抽噺鍔犲噺閿�");
            larkAction.action = 9;
            larkAction.data = bArr[1] & 255;
            larkAction.extra = bArr[2] & 255;
            Log.d(TAG, "鐢佃瘽闊抽噺 " + larkAction.data);
            Log.d(TAG, "濯掍綋闊抽噺 " + larkAction.extra);
        } else if (bArr[0] == 82) {
            larkAction.action = 16;
            byte[] bArr2 = new byte[6];
            for (int i2 = 1; i2 <= 6; i2++) {
                bArr2[i2 - 1] = bArr[i2];
            }
            larkAction.version = MacFormat.versionByte2String(bArr2);
            Log.d(TAG, "鏌ヨ\ue1d7鍒拌摑鐗欏浐浠剁増鏈� " + larkAction.version);
        } else if (bArr[0] == 85) {
            if (bArr[1] == 17) {
                byte b4 = bArr[3];
                if (b4 == 17) {
                    Log.d(TAG, "鐢甸噺鍏呰冻");
                    larkAction.action = 18;
                } else if (b4 == 34) {
                    Log.d(TAG, "鐢甸噺杩囦綆");
                    larkAction.action = 19;
                }
            } else if (bArr[1] == 34) {
                Log.d(TAG, "鍐欏叆鏂囦欢鏍￠獙鍜岃繑鍥�");
                byte b5 = bArr[2];
                if (b5 == 0) {
                    larkAction.action = 21;
                    Log.d(TAG, "鏍￠獙鍜岄敊璇�");
                } else if (b5 == 1) {
                    larkAction.action = 22;
                    Log.d(TAG, "鏍￠獙鍜屾\ue11c纭�");
                } else if (b5 == 2) {
                    Log.d(TAG, "鐗堟湰鍙锋牎楠屽け璐�");
                    larkAction.action = 24;
                } else if (b5 == 3) {
                    larkAction.action = 23;
                    Log.d(TAG, "flash鐑у啓澶辫触");
                }
            }
        } else if (bArr[0] == 89) {
            if (bArr[3] == 17) {
                byte b6 = bArr[1];
                if (b6 == 17) {
                    Log.d(TAG, "A2DP_CONNECTED");
                    larkAction.action = 27;
                    lastStatus = 0;
                } else if (b6 == 34) {
                    Log.d(TAG, "DISCONNECT_A2DP");
                    larkAction.action = 25;
                    lastStatus = 1;
                }
            } else if (bArr[3] == 34) {
                larkAction.action = 26;
            }
            if (bArr[4] == 17) {
                int i3 = occurrences;
                if (i3 == 0) {
                    Log.d(TAG, "stop trying disconnect a2dp");
                    larkAction.action = 28;
                    occurrences = 1;
                } else if (i3 == 1) {
                    Log.d(TAG, "NEED_NOT_SHOW_TOAST");
                }
            } else if (bArr[4] == 0) {
                Log.d(TAG, "occurrences = 0");
                occurrences = 0;
            }
        } else if (bArr[0] == 86) {
            larkAction.packetNum = ((bArr[1] & 255) << 8) + (bArr[2] & 255);
            larkAction.action = 20;
        }
        return larkAction;
    }

    public static LarkAction getAction(byte[] bArr) {
        if (bArr != null) {
            return checkData(bArr);
        }
        return null;
    }
}
