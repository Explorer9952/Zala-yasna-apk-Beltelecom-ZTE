package tv.agama.emp.client.a;

import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.zte.ucs.tvcall.Commons;
import tv.agama.emp.client.Definitions$DeviceMetadata;
import tv.agama.emp.client.Definitions$DsPlaylistType;
import tv.agama.emp.client.Definitions$DsProtocol;
import tv.agama.emp.client.Definitions$Measurement;
import tv.agama.emp.client.Definitions$SessionMetadata;
import tv.agama.emp.client.Definitions$ShutdownType;
import tv.agama.emp.client.Definitions$ViewStates;

/* compiled from: InternalDefinitions.java */
/* loaded from: classes2.dex */
public final class b {
    public static int a(Definitions$DsPlaylistType definitions$DsPlaylistType) {
        int i = a.f8617b[definitions$DsPlaylistType.ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    return -1;
                }
            }
        }
        return i2;
    }

    public static int a(Definitions$DsProtocol definitions$DsProtocol) {
        int i = a.f8619d[definitions$DsProtocol.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 3) {
            return 2;
        }
        if (i != 4) {
            return i != 5 ? -1 : 4;
        }
        return 3;
    }

    public static int a(Definitions$ShutdownType definitions$ShutdownType) {
        int i = a.e[definitions$ShutdownType.ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    i2 = 4;
                    if (i != 4) {
                        i2 = 5;
                        if (i != 5) {
                            return -1;
                        }
                    }
                }
            }
        }
        return i2;
    }

    public static int a(Definitions$Measurement definitions$Measurement) {
        switch (a.f[definitions$Measurement.ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            case 7:
                return 6;
            case 8:
                return 7;
            case 9:
                return 8;
            case 10:
                return 9;
            case 11:
                return 10;
            case 12:
                return 11;
            case 13:
                return 12;
            case 14:
                return 13;
            case 15:
                return 14;
            case 16:
                return 15;
            case 17:
                return 16;
            case 18:
                return 17;
            case 19:
                return 18;
            case 20:
                return 19;
            case 21:
                return 20;
            case 22:
                return 21;
            case 23:
                return 22;
            case 24:
                return 23;
            case 25:
                return 24;
            case 26:
                return 25;
            case 27:
                return 26;
            case 28:
                return 27;
            case 29:
                return 28;
            case 30:
                return 29;
            case 31:
                return 30;
            case 32:
                return 31;
            case 33:
                return 32;
            case 34:
                return 33;
            case 35:
                return 34;
            case 36:
                return 35;
            case 37:
                return 36;
            case 38:
                return 37;
            case 39:
                return 38;
            case 40:
                return 39;
            case 41:
                return 40;
            case 42:
                return 41;
            case 43:
                return 42;
            case 44:
                return 43;
            case 45:
                return 44;
            case 46:
                return 45;
            case 47:
                return 46;
            case 48:
                return 47;
            case 49:
                return 48;
            case 50:
                return 49;
            case 51:
                return 50;
            case 52:
                return 51;
            case 53:
                return 52;
            case 54:
                return 53;
            case 55:
                return 54;
            case 56:
                return 55;
            case 57:
                return 56;
            case 58:
                return 57;
            case 59:
                return 58;
            case 60:
                return 59;
            case 61:
                return 60;
            case 62:
                return 61;
            case 63:
                return 62;
            case 64:
                return 63;
            case 65:
                return 64;
            case 66:
                return 65;
            case 67:
                return 66;
            case 68:
                return 67;
            case 69:
                return 68;
            case 70:
                return 69;
            case 71:
                return 70;
            case 72:
                return 71;
            case 73:
                return 72;
            case 74:
                return 73;
            case 75:
                return 74;
            case 76:
                return 75;
            case 77:
                return 76;
            case 78:
                return 77;
            case 79:
                return 78;
            case 80:
                return 79;
            case 81:
                return 80;
            case 82:
                return 81;
            case 83:
                return 82;
            case 84:
                return 83;
            case 85:
                return 84;
            case 86:
                return 85;
            case 87:
                return 86;
            case 88:
                return 87;
            case 89:
                return 88;
            case 90:
                return 89;
            case 91:
                return 90;
            case 92:
                return 91;
            case 93:
                return 92;
            case 94:
                return 93;
            case 95:
                return 94;
            case 96:
                return 95;
            case 97:
                return 96;
            case 98:
                return 97;
            case 99:
                return 98;
            case 100:
                return 99;
            case 101:
                return 100;
            case 102:
                return 101;
            case 103:
                return 102;
            case 104:
                return 103;
            case 105:
                return 104;
            case 106:
                return 105;
            case 107:
                return 106;
            case 108:
                return 107;
            case 109:
                return 108;
            case 110:
                return 109;
            case 111:
                return 110;
            case 112:
                return 111;
            case 113:
                return 112;
            case 114:
                return 113;
            case 115:
                return 114;
            case 116:
                return 115;
            case 117:
                return 116;
            case 118:
                return 117;
            case 119:
                return 118;
            case 120:
                return 119;
            case 121:
                return 120;
            case 122:
                return 121;
            case 123:
                return 122;
            case 124:
                return 123;
            case 125:
                return 124;
            case 126:
                return 127;
            case 127:
                return Commons.MSG_MCSP_INIT_SUCCESS;
            case Commons.MSG_MCSP_INIT_SUCCESS /* 128 */:
                return 129;
            case 129:
                return 130;
            case 130:
                return Commons.VOIP_REGISTER_RETRY;
            case Commons.VOIP_REGISTER_RETRY /* 131 */:
                return Commons.VOIP_REGISTER_RUNNING;
            case Commons.VOIP_REGISTER_RUNNING /* 132 */:
                return Commons.VOIP_HOTKEY_STARTAPP;
            case Commons.VOIP_HOTKEY_STARTAPP /* 133 */:
                return 134;
            case 134:
                return TsExtractor.TS_STREAM_TYPE_E_AC3;
            case TsExtractor.TS_STREAM_TYPE_E_AC3 /* 135 */:
                return 136;
            case 136:
                return 137;
            case 137:
                return TsExtractor.TS_STREAM_TYPE_DTS;
            case TsExtractor.TS_STREAM_TYPE_DTS /* 138 */:
                return 139;
            case 139:
                return 140;
            case 140:
                return Commons.CONTACT_QUERY_ALL;
            case Commons.CONTACT_QUERY_ALL /* 141 */:
                return Commons.CONTACT_REFRESH_AFTER_DEL;
            case Commons.CONTACT_REFRESH_AFTER_DEL /* 142 */:
                return Commons.CONTACT_QUERY_BY_CONDITION;
            case Commons.CONTACT_QUERY_BY_CONDITION /* 143 */:
                return Commons.CONTACT_REFRESH_AFTER_EDIT;
            case Commons.CONTACT_REFRESH_AFTER_EDIT /* 144 */:
                return Commons.CONTACT_REFRESH_AFTER_ADD;
            case Commons.CONTACT_REFRESH_AFTER_ADD /* 145 */:
                return 146;
            case 146:
                return 147;
            case 147:
                return 148;
            case 148:
                return 149;
            case 149:
                return 150;
            case 150:
                return 151;
            case 151:
                return 152;
            case 152:
                return 153;
            case 153:
                return 154;
            case 154:
                return 155;
            case 155:
                return 68;
            case 156:
                return 69;
            case 157:
                return 70;
            case 158:
                return 73;
            case 159:
                return 74;
            case 160:
                return 110;
            case 161:
                return Commons.VOIP_REGISTER_RETRY;
            case 162:
                return Commons.VOIP_REGISTER_RUNNING;
            case 163:
                return 64;
            case 164:
                return 63;
            case 165:
                return 53;
            case 166:
                return 109;
            case 167:
                return Commons.CONTACT_REFRESH_AFTER_EDIT;
            case 168:
                return 98;
            case 169:
                return 122;
            case 170:
                return 99;
            default:
                return -1;
        }
    }

    public static int a(Definitions$DeviceMetadata definitions$DeviceMetadata) {
        switch (a.g[definitions$DeviceMetadata.ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            case 7:
                return 6;
            case 8:
                return 7;
            case 9:
                return 8;
            case 10:
                return 9;
            case 11:
                return 10;
            case 12:
                return 11;
            case 13:
                return 12;
            case 14:
                return 13;
            case 15:
                return 14;
            case 16:
                return 15;
            case 17:
                return 16;
            case 18:
                return 17;
            case 19:
                return 18;
            case 20:
                return 19;
            case 21:
                return 20;
            case 22:
                return 21;
            case 23:
                return 22;
            case 24:
                return 23;
            case 25:
                return 24;
            case 26:
                return 25;
            case 27:
                return 26;
            case 28:
                return 27;
            case 29:
                return 28;
            case 30:
                return 29;
            case 31:
                return 30;
            case 32:
                return 31;
            case 33:
                return 32;
            case 34:
                return 33;
            case 35:
                return 34;
            case 36:
                return 35;
            case 37:
                return 36;
            case 38:
                return 37;
            case 39:
                return 38;
            case 40:
                return 39;
            case 41:
                return 40;
            case 42:
                return 41;
            case 43:
                return 42;
            case 44:
                return 43;
            case 45:
                return 44;
            case 46:
                return 45;
            case 47:
                return 3;
            case 48:
                return 4;
            case 49:
                return 1;
            case 50:
                return 9;
            case 51:
                return 11;
            case 52:
                return 12;
            case 53:
                return 10;
            default:
                return -1;
        }
    }

    public static int a(Definitions$SessionMetadata definitions$SessionMetadata) {
        switch (a.h[definitions$SessionMetadata.ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            case 7:
                return 6;
            case 8:
                return 7;
            case 9:
                return 8;
            case 10:
                return 9;
            case 11:
                return 10;
            case 12:
                return 11;
            case 13:
                return 12;
            case 14:
                return 13;
            case 15:
                return 14;
            case 16:
                return 15;
            case 17:
                return 16;
            case 18:
                return 17;
            case 19:
                return 18;
            case 20:
                return 19;
            case 21:
                return 20;
            case 22:
                return 21;
            case 23:
                return 22;
            case 24:
                return 23;
            case 25:
                return 24;
            case 26:
                return 25;
            case 27:
                return 26;
            case 28:
                return 27;
            case 29:
                return 28;
            case 30:
                return 29;
            case 31:
                return 30;
            case 32:
                return 31;
            case 33:
                return 32;
            case 34:
                return 33;
            case 35:
                return 34;
            case 36:
                return 35;
            case 37:
                return 36;
            case 38:
                return 37;
            case 39:
                return 38;
            case 40:
                return 39;
            case 41:
                return 40;
            case 42:
                return 41;
            case 43:
                return 6;
            case 44:
                return 25;
            case 45:
                return 15;
            case 46:
                return 22;
            case 47:
                return 37;
            default:
                return -1;
        }
    }

    public static int a(Definitions$ViewStates definitions$ViewStates) {
        switch (a.i[definitions$ViewStates.ordinal()]) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            case 8:
                return 8;
            case 9:
                return 9;
            default:
                return -1;
        }
    }
}
