package com.picovr.picovrlib.service;

import android.util.Log;

/* loaded from: classes.dex */
public class LarkActionAnalyse {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x002b. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x002e. Please report as an issue. */
    private static LarkAction checkData(byte[] bArr) {
        int i = bArr[0] & 255;
        Log.d("LarkManager", "actionCode = " + i);
        LarkAction larkAction = new LarkAction();
        if (i != 16) {
            if (i == 144) {
                larkAction.action = 30;
                larkAction.data = bArr[1] & 255;
                larkAction.extra = bArr[2] & 255;
                return larkAction;
            }
            if (i != 255) {
                switch (i) {
                    case 1:
                        if (bArr[1] == 0) {
                            larkAction.action = 21;
                            return larkAction;
                        }
                        break;
                    case 2:
                        if (bArr[1] == 0) {
                            larkAction.action = 22;
                            return larkAction;
                        }
                        break;
                    case 3:
                        if (bArr[1] == 0) {
                            larkAction.action = 24;
                            return larkAction;
                        }
                        break;
                    case 4:
                        if (bArr[1] == 0) {
                            larkAction.action = 23;
                            return larkAction;
                        }
                        break;
                    case 5:
                        if (bArr[1] == 0) {
                            larkAction.action = 20;
                            return larkAction;
                        }
                        break;
                    case 6:
                        if (bArr[1] == 0) {
                            larkAction.action = 25;
                            return larkAction;
                        }
                        break;
                    case 7:
                        if (bArr[1] == 0) {
                            larkAction.action = 26;
                            return larkAction;
                        }
                        break;
                    case 8:
                        larkAction.action = 28;
                        return larkAction;
                    default:
                        switch (i) {
                            case 80:
                                byte b2 = bArr[1];
                                if (b2 == 17) {
                                    byte b3 = bArr[2];
                                    if (b3 == 17) {
                                        larkAction.action = 10;
                                        return larkAction;
                                    }
                                    if (b3 == 34) {
                                        larkAction.action = 11;
                                        return larkAction;
                                    }
                                    if (b3 == 51) {
                                        larkAction.action = 12;
                                        return larkAction;
                                    }
                                } else if (b2 == 34) {
                                    byte b4 = bArr[2];
                                    if (b4 == 17) {
                                        larkAction.action = 50;
                                        return larkAction;
                                    }
                                    if (b4 == 34) {
                                        larkAction.action = 51;
                                        return larkAction;
                                    }
                                }
                                break;
                            case 81:
                                larkAction.action = 40;
                                return larkAction;
                            case 82:
                                larkAction.action = 70;
                                byte[] bArr2 = new byte[7];
                                for (int i2 = 1; i2 < 8; i2++) {
                                    bArr2[i2 - 1] = bArr[i2];
                                }
                                larkAction.version = MacFormat.versionByte2String(bArr2);
                                return larkAction;
                        }
                }
            } else {
                larkAction.action = 27;
                return larkAction;
            }
        }
        return null;
    }

    public static LarkAction getAction(byte[] bArr) {
        if (bArr == null || bArr.length != 8) {
            return null;
        }
        return checkData(bArr);
    }
}
