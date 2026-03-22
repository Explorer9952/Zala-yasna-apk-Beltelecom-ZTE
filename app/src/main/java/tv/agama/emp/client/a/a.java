package tv.agama.emp.client.a;

import tv.agama.emp.client.Definitions$DeviceMetadata;
import tv.agama.emp.client.Definitions$DsPlaylistType;
import tv.agama.emp.client.Definitions$DsProtocol;
import tv.agama.emp.client.Definitions$DtvDeliverySystem;
import tv.agama.emp.client.Definitions$Measurement;
import tv.agama.emp.client.Definitions$SessionMetadata;
import tv.agama.emp.client.Definitions$ShutdownType;
import tv.agama.emp.client.Definitions$ViewStates;
import tv.agama.emp.client.Definitions$VodProtocol;

/* compiled from: InternalDefinitions.java */
/* loaded from: classes2.dex */
/* synthetic */ class a {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f8616a;

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ int[] f8617b;

    /* renamed from: c, reason: collision with root package name */
    static final /* synthetic */ int[] f8618c;

    /* renamed from: d, reason: collision with root package name */
    static final /* synthetic */ int[] f8619d;
    static final /* synthetic */ int[] e;
    static final /* synthetic */ int[] f;
    static final /* synthetic */ int[] g;
    static final /* synthetic */ int[] h;
    static final /* synthetic */ int[] i;

    static {
        int[] iArr = new int[Definitions$ViewStates.values().length];
        i = iArr;
        try {
            iArr[Definitions$ViewStates.PAUSED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            i[Definitions$ViewStates.PLAYING.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            i[Definitions$ViewStates.FASTFORWARDING.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            i[Definitions$ViewStates.REWINDING.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            i[Definitions$ViewStates.FAILED.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            i[Definitions$ViewStates.INITIAL_BUFFERING.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            i[Definitions$ViewStates.STALLED.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            i[Definitions$ViewStates.NO_ACCESS.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            i[Definitions$ViewStates.SEEK.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
        int[] iArr2 = new int[Definitions$SessionMetadata.values().length];
        h = iArr2;
        try {
            iArr2[Definitions$SessionMetadata.DE_JITTER_BUFFER_SIZE_IN_KILOBYTE.ordinal()] = 1;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            h[Definitions$SessionMetadata.CHANNEL_CHANGE_TIME.ordinal()] = 2;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            h[Definitions$SessionMetadata.IGMP_JOIN_TIME.ordinal()] = 3;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            h[Definitions$SessionMetadata.IGMP_LEAVE_TIME.ordinal()] = 4;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            h[Definitions$SessionMetadata.INITIAL_BUFFERING_TIME.ordinal()] = 5;
        } catch (NoSuchFieldError unused14) {
        }
        try {
            h[Definitions$SessionMetadata.INITIAL_RANDOM_ACCESS_TIME.ordinal()] = 6;
        } catch (NoSuchFieldError unused15) {
        }
        try {
            h[Definitions$SessionMetadata.RTSP_SETUP_TIME.ordinal()] = 7;
        } catch (NoSuchFieldError unused16) {
        }
        try {
            h[Definitions$SessionMetadata.RTSP_TEARDOWN_TIME.ordinal()] = 8;
        } catch (NoSuchFieldError unused17) {
        }
        try {
            h[Definitions$SessionMetadata.TR135_SEVERE_LOSS_MIN_DISTANCE.ordinal()] = 9;
        } catch (NoSuchFieldError unused18) {
        }
        try {
            h[Definitions$SessionMetadata.TUNED_FREQUENCY.ordinal()] = 10;
        } catch (NoSuchFieldError unused19) {
        }
        try {
            h[Definitions$SessionMetadata.TUNING_TIME.ordinal()] = 11;
        } catch (NoSuchFieldError unused20) {
        }
        try {
            h[Definitions$SessionMetadata.VOD_SETUP_DELAY.ordinal()] = 12;
        } catch (NoSuchFieldError unused21) {
        }
        try {
            h[Definitions$SessionMetadata.GENERIC_DESCRIPTION.ordinal()] = 13;
        } catch (NoSuchFieldError unused22) {
        }
        try {
            h[Definitions$SessionMetadata.CONTENT_TITLE.ordinal()] = 14;
        } catch (NoSuchFieldError unused23) {
        }
        try {
            h[Definitions$SessionMetadata.CONTENT_DESCRIPTION.ordinal()] = 15;
        } catch (NoSuchFieldError unused24) {
        }
        try {
            h[Definitions$SessionMetadata.SPECIFIED_DURATION.ordinal()] = 16;
        } catch (NoSuchFieldError unused25) {
        }
        try {
            h[Definitions$SessionMetadata.DS_NR_OF_SEGMENT_BUFFERS.ordinal()] = 17;
        } catch (NoSuchFieldError unused26) {
        }
        try {
            h[Definitions$SessionMetadata.DS_SEGMENT_BUFFER_SIZE.ordinal()] = 18;
        } catch (NoSuchFieldError unused27) {
        }
        try {
            h[Definitions$SessionMetadata.DS_NR_OF_PREBUFFERED_SEGMENTS.ordinal()] = 19;
        } catch (NoSuchFieldError unused28) {
        }
        try {
            h[Definitions$SessionMetadata.DS_SEGMENT_PREBUFFER_SIZE.ordinal()] = 20;
        } catch (NoSuchFieldError unused29) {
        }
        try {
            h[Definitions$SessionMetadata.NR_OF_REDIRECTS.ordinal()] = 21;
        } catch (NoSuchFieldError unused30) {
        }
        try {
            h[Definitions$SessionMetadata.DS_ORIGINATING_SOURCE.ordinal()] = 22;
        } catch (NoSuchFieldError unused31) {
        }
        try {
            h[Definitions$SessionMetadata.DS_ORIGINATING_SERVER_MANIFEST.ordinal()] = 23;
        } catch (NoSuchFieldError unused32) {
        }
        try {
            h[Definitions$SessionMetadata.DS_ORIGINATING_SERVER_SEGMENT.ordinal()] = 24;
        } catch (NoSuchFieldError unused33) {
        }
        try {
            h[Definitions$SessionMetadata.DS_INITIAL_PROFILE.ordinal()] = 25;
        } catch (NoSuchFieldError unused34) {
        }
        try {
            h[Definitions$SessionMetadata.DS_NR_OF_CONTENT_PROFILES.ordinal()] = 26;
        } catch (NoSuchFieldError unused35) {
        }
        try {
            h[Definitions$SessionMetadata.DS_MANIFEST_FILE.ordinal()] = 27;
        } catch (NoSuchFieldError unused36) {
        }
        try {
            h[Definitions$SessionMetadata.HLS_INITIAL_PATPMT.ordinal()] = 28;
        } catch (NoSuchFieldError unused37) {
        }
        try {
            h[Definitions$SessionMetadata.DS_PLAYLIST_TYPE.ordinal()] = 29;
        } catch (NoSuchFieldError unused38) {
        }
        try {
            h[Definitions$SessionMetadata.DATA_CONNECTION_TYPE.ordinal()] = 30;
        } catch (NoSuchFieldError unused39) {
        }
        try {
            h[Definitions$SessionMetadata.IP_NEGOTIATED_BITRATE.ordinal()] = 31;
        } catch (NoSuchFieldError unused40) {
        }
        try {
            h[Definitions$SessionMetadata.CONTENT_CA_SYSTEM.ordinal()] = 32;
        } catch (NoSuchFieldError unused41) {
        }
        try {
            h[Definitions$SessionMetadata.RF_MODULATION.ordinal()] = 33;
        } catch (NoSuchFieldError unused42) {
        }
        try {
            h[Definitions$SessionMetadata.RF_SYMBOLRATE.ordinal()] = 34;
        } catch (NoSuchFieldError unused43) {
        }
        try {
            h[Definitions$SessionMetadata.RF_STANDARD.ordinal()] = 35;
        } catch (NoSuchFieldError unused44) {
        }
        try {
            h[Definitions$SessionMetadata.DS_EXIT_BEFORE_INITIAL_PLAY.ordinal()] = 36;
        } catch (NoSuchFieldError unused45) {
        }
        try {
            h[Definitions$SessionMetadata.DS_EXIT_WHILE_STALLED.ordinal()] = 37;
        } catch (NoSuchFieldError unused46) {
        }
        try {
            h[Definitions$SessionMetadata.CONTENT_SERVICE_TITLE.ordinal()] = 38;
        } catch (NoSuchFieldError unused47) {
        }
        try {
            h[Definitions$SessionMetadata.CONTENT_TYPE.ordinal()] = 39;
        } catch (NoSuchFieldError unused48) {
        }
        try {
            h[Definitions$SessionMetadata.APP_SUCCESSFULLY_STARTED.ordinal()] = 40;
        } catch (NoSuchFieldError unused49) {
        }
        try {
            h[Definitions$SessionMetadata.APP_STARTUP_TIME.ordinal()] = 41;
        } catch (NoSuchFieldError unused50) {
        }
        try {
            h[Definitions$SessionMetadata.CDN.ordinal()] = 42;
        } catch (NoSuchFieldError unused51) {
        }
        try {
            h[Definitions$SessionMetadata.STREAM_SETUP_TIME.ordinal()] = 43;
        } catch (NoSuchFieldError unused52) {
        }
        try {
            h[Definitions$SessionMetadata.NUMBER_OF_CONTENT_PROFILES.ordinal()] = 44;
        } catch (NoSuchFieldError unused53) {
        }
        try {
            h[Definitions$SessionMetadata.ASSET_DURATION.ordinal()] = 45;
        } catch (NoSuchFieldError unused54) {
        }
        try {
            h[Definitions$SessionMetadata.MANIFEST_URI.ordinal()] = 46;
        } catch (NoSuchFieldError unused55) {
        }
        try {
            h[Definitions$SessionMetadata.SERVICE_NAME.ordinal()] = 47;
        } catch (NoSuchFieldError unused56) {
        }
        int[] iArr3 = new int[Definitions$DeviceMetadata.values().length];
        g = iArr3;
        try {
            iArr3[Definitions$DeviceMetadata.STB_MAC.ordinal()] = 1;
        } catch (NoSuchFieldError unused57) {
        }
        try {
            g[Definitions$DeviceMetadata.STB_IP.ordinal()] = 2;
        } catch (NoSuchFieldError unused58) {
        }
        try {
            g[Definitions$DeviceMetadata.STB_SERIAL_NUMBER.ordinal()] = 3;
        } catch (NoSuchFieldError unused59) {
        }
        try {
            g[Definitions$DeviceMetadata.STB_MANUFACTURER.ordinal()] = 4;
        } catch (NoSuchFieldError unused60) {
        }
        try {
            g[Definitions$DeviceMetadata.STB_MODEL.ordinal()] = 5;
        } catch (NoSuchFieldError unused61) {
        }
        try {
            g[Definitions$DeviceMetadata.STB_CHIPSET.ordinal()] = 6;
        } catch (NoSuchFieldError unused62) {
        }
        try {
            g[Definitions$DeviceMetadata.EMPCLIENT_INTEGRATION_VERSION.ordinal()] = 7;
        } catch (NoSuchFieldError unused63) {
        }
        try {
            g[Definitions$DeviceMetadata.EMPCLIENT_INTEGRATION_BUILDDATE.ordinal()] = 8;
        } catch (NoSuchFieldError unused64) {
        }
        try {
            g[Definitions$DeviceMetadata.INTEGRATION_SPECIFIC_DEVICE_METADATA.ordinal()] = 9;
        } catch (NoSuchFieldError unused65) {
        }
        try {
            g[Definitions$DeviceMetadata.PLATFORM_VERSION.ordinal()] = 10;
        } catch (NoSuchFieldError unused66) {
        }
        try {
            g[Definitions$DeviceMetadata.FIRMWARE_VERSION.ordinal()] = 11;
        } catch (NoSuchFieldError unused67) {
        }
        try {
            g[Definitions$DeviceMetadata.MIDDLEWARE.ordinal()] = 12;
        } catch (NoSuchFieldError unused68) {
        }
        try {
            g[Definitions$DeviceMetadata.MIDDLEWARE_VERSION.ordinal()] = 13;
        } catch (NoSuchFieldError unused69) {
        }
        try {
            g[Definitions$DeviceMetadata.CA_SYSTEM.ordinal()] = 14;
        } catch (NoSuchFieldError unused70) {
        }
        try {
            g[Definitions$DeviceMetadata.EDID_INFORMATION.ordinal()] = 15;
        } catch (NoSuchFieldError unused71) {
        }
        try {
            g[Definitions$DeviceMetadata.CONFIGURATION_SET_FROM.ordinal()] = 16;
        } catch (NoSuchFieldError unused72) {
        }
        try {
            g[Definitions$DeviceMetadata.DISK_SIZE.ordinal()] = 17;
        } catch (NoSuchFieldError unused73) {
        }
        try {
            g[Definitions$DeviceMetadata.WAN_LINK_SPEED.ordinal()] = 18;
        } catch (NoSuchFieldError unused74) {
        }
        try {
            g[Definitions$DeviceMetadata.WLAN_CHANNEL.ordinal()] = 19;
        } catch (NoSuchFieldError unused75) {
        }
        try {
            g[Definitions$DeviceMetadata.WLAN_BANDWIDTH.ordinal()] = 20;
        } catch (NoSuchFieldError unused76) {
        }
        try {
            g[Definitions$DeviceMetadata.WLAN_CHANNEL_BANDWIDTH.ordinal()] = 21;
        } catch (NoSuchFieldError unused77) {
        }
        try {
            g[Definitions$DeviceMetadata.STB_EXTERNAL_ID.ordinal()] = 22;
        } catch (NoSuchFieldError unused78) {
        }
        try {
            g[Definitions$DeviceMetadata.LOCATION_DESCRIPTION.ordinal()] = 23;
        } catch (NoSuchFieldError unused79) {
        }
        try {
            g[Definitions$DeviceMetadata.SMARTCARD_ID.ordinal()] = 24;
        } catch (NoSuchFieldError unused80) {
        }
        try {
            g[Definitions$DeviceMetadata.CA_PAIRING_ID.ordinal()] = 25;
        } catch (NoSuchFieldError unused81) {
        }
        try {
            g[Definitions$DeviceMetadata.CA_ENTITLEMENT.ordinal()] = 26;
        } catch (NoSuchFieldError unused82) {
        }
        try {
            g[Definitions$DeviceMetadata.PARENTAL_CONTROL_PARAMETERS.ordinal()] = 27;
        } catch (NoSuchFieldError unused83) {
        }
        try {
            g[Definitions$DeviceMetadata.USER_PIN_CODE.ordinal()] = 28;
        } catch (NoSuchFieldError unused84) {
        }
        try {
            g[Definitions$DeviceMetadata.SERVICE_GROUP.ordinal()] = 29;
        } catch (NoSuchFieldError unused85) {
        }
        try {
            g[Definitions$DeviceMetadata.USER_ACCOUNT_ID.ordinal()] = 30;
        } catch (NoSuchFieldError unused86) {
        }
        try {
            g[Definitions$DeviceMetadata.DEVICE_TYPE.ordinal()] = 31;
        } catch (NoSuchFieldError unused87) {
        }
        try {
            g[Definitions$DeviceMetadata.SOFT_STANDBY.ordinal()] = 32;
        } catch (NoSuchFieldError unused88) {
        }
        try {
            g[Definitions$DeviceMetadata.DEVICE_ID.ordinal()] = 33;
        } catch (NoSuchFieldError unused89) {
        }
        try {
            g[Definitions$DeviceMetadata.SERVICE_STATUS.ordinal()] = 34;
        } catch (NoSuchFieldError unused90) {
        }
        try {
            g[Definitions$DeviceMetadata.EMM.ordinal()] = 35;
        } catch (NoSuchFieldError unused91) {
        }
        try {
            g[Definitions$DeviceMetadata.RF.ordinal()] = 36;
        } catch (NoSuchFieldError unused92) {
        }
        try {
            g[Definitions$DeviceMetadata.NETWORK.ordinal()] = 37;
        } catch (NoSuchFieldError unused93) {
        }
        try {
            g[Definitions$DeviceMetadata.MULTISCREEN.ordinal()] = 38;
        } catch (NoSuchFieldError unused94) {
        }
        try {
            g[Definitions$DeviceMetadata.HDD_PARAMETERS.ordinal()] = 39;
        } catch (NoSuchFieldError unused95) {
        }
        try {
            g[Definitions$DeviceMetadata.DEVICE_OS.ordinal()] = 40;
        } catch (NoSuchFieldError unused96) {
        }
        try {
            g[Definitions$DeviceMetadata.DEVICE_BROWSER.ordinal()] = 41;
        } catch (NoSuchFieldError unused97) {
        }
        try {
            g[Definitions$DeviceMetadata.APPLICATION.ordinal()] = 42;
        } catch (NoSuchFieldError unused98) {
        }
        try {
            g[Definitions$DeviceMetadata.APPLICATION_VERSION.ordinal()] = 43;
        } catch (NoSuchFieldError unused99) {
        }
        try {
            g[Definitions$DeviceMetadata.DEVICE_LATITUDE.ordinal()] = 44;
        } catch (NoSuchFieldError unused100) {
        }
        try {
            g[Definitions$DeviceMetadata.DEVICE_LONGITUDE.ordinal()] = 45;
        } catch (NoSuchFieldError unused101) {
        }
        try {
            g[Definitions$DeviceMetadata.DATA_CONNECTION_TYPE.ordinal()] = 46;
        } catch (NoSuchFieldError unused102) {
        }
        try {
            g[Definitions$DeviceMetadata.DEVICE_MANUFACTURER.ordinal()] = 47;
        } catch (NoSuchFieldError unused103) {
        }
        try {
            g[Definitions$DeviceMetadata.DEVICE_MODEL.ordinal()] = 48;
        } catch (NoSuchFieldError unused104) {
        }
        try {
            g[Definitions$DeviceMetadata.DEVICE_IP.ordinal()] = 49;
        } catch (NoSuchFieldError unused105) {
        }
        try {
            g[Definitions$DeviceMetadata.DEVICE_OS_VERSION.ordinal()] = 50;
        } catch (NoSuchFieldError unused106) {
        }
        try {
            g[Definitions$DeviceMetadata.PLAYER.ordinal()] = 51;
        } catch (NoSuchFieldError unused107) {
        }
        try {
            g[Definitions$DeviceMetadata.PLAYER_VERSION.ordinal()] = 52;
        } catch (NoSuchFieldError unused108) {
        }
        try {
            g[Definitions$DeviceMetadata.DEVICE_BROWSER_VERSION.ordinal()] = 53;
        } catch (NoSuchFieldError unused109) {
        }
        int[] iArr4 = new int[Definitions$Measurement.values().length];
        f = iArr4;
        try {
            iArr4[Definitions$Measurement.AUDIO_BUFFER_OVERFLOW.ordinal()] = 1;
        } catch (NoSuchFieldError unused110) {
        }
        try {
            f[Definitions$Measurement.AUDIO_BUFFER_UNDERFLOW.ordinal()] = 2;
        } catch (NoSuchFieldError unused111) {
        }
        try {
            f[Definitions$Measurement.AUDIO_DECODING_ERROR.ordinal()] = 3;
        } catch (NoSuchFieldError unused112) {
        }
        try {
            f[Definitions$Measurement.AUDIO_DISCONTINUITY.ordinal()] = 4;
        } catch (NoSuchFieldError unused113) {
        }
        try {
            f[Definitions$Measurement.AUDIO_OUT_OF_SYNC_ERROR.ordinal()] = 5;
        } catch (NoSuchFieldError unused114) {
        }
        try {
            f[Definitions$Measurement.CPU_USAGE.ordinal()] = 6;
        } catch (NoSuchFieldError unused115) {
        }
        try {
            f[Definitions$Measurement.CURRENT_NUMBER_OF_RECORDINGS.ordinal()] = 7;
        } catch (NoSuchFieldError unused116) {
        }
        try {
            f[Definitions$Measurement.FAN_RPM.ordinal()] = 8;
        } catch (NoSuchFieldError unused117) {
        }
        try {
            f[Definitions$Measurement.FEC_CORRECTED_PACKET_COUNT.ordinal()] = 9;
        } catch (NoSuchFieldError unused118) {
        }
        try {
            f[Definitions$Measurement.FEC_UNCORRECTED_PACKET_COUNT.ordinal()] = 10;
        } catch (NoSuchFieldError unused119) {
        }
        try {
            f[Definitions$Measurement.FREE_DISK_SPACE.ordinal()] = 11;
        } catch (NoSuchFieldError unused120) {
        }
        try {
            f[Definitions$Measurement.FREE_MEMORY.ordinal()] = 12;
        } catch (NoSuchFieldError unused121) {
        }
        try {
            f[Definitions$Measurement.HD_TEMPERATURE.ordinal()] = 13;
        } catch (NoSuchFieldError unused122) {
        }
        try {
            f[Definitions$Measurement.HDCP_AUTHENTICATIONS_FAILED.ordinal()] = 14;
        } catch (NoSuchFieldError unused123) {
        }
        try {
            f[Definitions$Measurement.HDCP_AUTHENTICATIONS_SUCCEDED.ordinal()] = 15;
        } catch (NoSuchFieldError unused124) {
        }
        try {
            f[Definitions$Measurement.IP_INTERFACE_BITRATE.ordinal()] = 16;
        } catch (NoSuchFieldError unused125) {
        }
        try {
            f[Definitions$Measurement.IP_STREAM_BITRATE.ordinal()] = 17;
        } catch (NoSuchFieldError unused126) {
        }
        try {
            f[Definitions$Measurement.NON_AV_DISCONTINUITY.ordinal()] = 18;
        } catch (NoSuchFieldError unused127) {
        }
        try {
            f[Definitions$Measurement.RF_BER.ordinal()] = 19;
        } catch (NoSuchFieldError unused128) {
        }
        try {
            f[Definitions$Measurement.RF_BER_PREVITERBI.ordinal()] = 20;
        } catch (NoSuchFieldError unused129) {
        }
        try {
            f[Definitions$Measurement.RF_BER_POSTVITERBI.ordinal()] = 21;
        } catch (NoSuchFieldError unused130) {
        }
        try {
            f[Definitions$Measurement.RF_MER.ordinal()] = 22;
        } catch (NoSuchFieldError unused131) {
        }
        try {
            f[Definitions$Measurement.RF_SIGNAL_STRENGTH.ordinal()] = 23;
        } catch (NoSuchFieldError unused132) {
        }
        try {
            f[Definitions$Measurement.RF_SIGNAL_STRENGTH_DBM_50_OHM.ordinal()] = 24;
        } catch (NoSuchFieldError unused133) {
        }
        try {
            f[Definitions$Measurement.RF_SIGNAL_STRENGTH_DBM_75_OHM.ordinal()] = 25;
        } catch (NoSuchFieldError unused134) {
        }
        try {
            f[Definitions$Measurement.RF_SIGNAL_STRENGTH_DBMV.ordinal()] = 26;
        } catch (NoSuchFieldError unused135) {
        }
        try {
            f[Definitions$Measurement.RF_SNR.ordinal()] = 27;
        } catch (NoSuchFieldError unused136) {
        }
        try {
            f[Definitions$Measurement.RF_UNCORRECTED_BLOCK_ERRORS.ordinal()] = 28;
        } catch (NoSuchFieldError unused137) {
        }
        try {
            f[Definitions$Measurement.RTP_DROPPED_PACKET_COUNT.ordinal()] = 29;
        } catch (NoSuchFieldError unused138) {
        }
        try {
            f[Definitions$Measurement.RTP_LATE_PACKET_DROPPED_COUNT.ordinal()] = 30;
        } catch (NoSuchFieldError unused139) {
        }
        try {
            f[Definitions$Measurement.RTP_DUPLICATED_PACKET_COUNT.ordinal()] = 31;
        } catch (NoSuchFieldError unused140) {
        }
        try {
            f[Definitions$Measurement.RTP_PACKET_COUNT.ordinal()] = 32;
        } catch (NoSuchFieldError unused141) {
        }
        try {
            f[Definitions$Measurement.RTP_LOST_PACKET_COUNT.ordinal()] = 33;
        } catch (NoSuchFieldError unused142) {
        }
        try {
            f[Definitions$Measurement.RTP_REORDERED_PACKET_COUNT.ordinal()] = 34;
        } catch (NoSuchFieldError unused143) {
        }
        try {
            f[Definitions$Measurement.SOURCE_BUFFER_OVERFLOW.ordinal()] = 35;
        } catch (NoSuchFieldError unused144) {
        }
        try {
            f[Definitions$Measurement.SOURCE_BUFFER_UNDERFLOW.ordinal()] = 36;
        } catch (NoSuchFieldError unused145) {
        }
        try {
            f[Definitions$Measurement.TIMESHIFT_DELAY.ordinal()] = 37;
        } catch (NoSuchFieldError unused146) {
        }
        try {
            f[Definitions$Measurement.TR135_GMIN.ordinal()] = 38;
        } catch (NoSuchFieldError unused147) {
        }
        try {
            f[Definitions$Measurement.TR135_LOSS_EVENTS.ordinal()] = 39;
        } catch (NoSuchFieldError unused148) {
        }
        try {
            f[Definitions$Measurement.TR135_LOSS_EVENTS_BEFORE_EC.ordinal()] = 40;
        } catch (NoSuchFieldError unused149) {
        }
        try {
            f[Definitions$Measurement.TR135_MAXIMUM_LOSS_PERIOD.ordinal()] = 41;
        } catch (NoSuchFieldError unused150) {
        }
        try {
            f[Definitions$Measurement.TR135_MINIMUM_LOSS_DISTANCE.ordinal()] = 42;
        } catch (NoSuchFieldError unused151) {
        }
        try {
            f[Definitions$Measurement.TR135_OVERRUNS.ordinal()] = 43;
        } catch (NoSuchFieldError unused152) {
        }
        try {
            f[Definitions$Measurement.TR135_SEVERE_LOSS_INDEX_COUNT.ordinal()] = 44;
        } catch (NoSuchFieldError unused153) {
        }
        try {
            f[Definitions$Measurement.TR135_UNDERRUNS.ordinal()] = 45;
        } catch (NoSuchFieldError unused154) {
        }
        try {
            f[Definitions$Measurement.TS_STREAM_BITRATE.ordinal()] = 46;
        } catch (NoSuchFieldError unused155) {
        }
        try {
            f[Definitions$Measurement.UI_REACTIVITY_TIME.ordinal()] = 47;
        } catch (NoSuchFieldError unused156) {
        }
        try {
            f[Definitions$Measurement.VIDEO_BUFFER_OVERFLOW.ordinal()] = 48;
        } catch (NoSuchFieldError unused157) {
        }
        try {
            f[Definitions$Measurement.VIDEO_BUFFER_UNDERFLOW.ordinal()] = 49;
        } catch (NoSuchFieldError unused158) {
        }
        try {
            f[Definitions$Measurement.VIDEO_DECODING_ERROR.ordinal()] = 50;
        } catch (NoSuchFieldError unused159) {
        }
        try {
            f[Definitions$Measurement.VIDEO_DISCONTINUITY.ordinal()] = 51;
        } catch (NoSuchFieldError unused160) {
        }
        try {
            f[Definitions$Measurement.VIDEO_OUT_OF_SYNC_ERROR.ordinal()] = 52;
        } catch (NoSuchFieldError unused161) {
        }
        try {
            f[Definitions$Measurement.VQE_CHANNEL_CHANGE_REQUESTS.ordinal()] = 53;
        } catch (NoSuchFieldError unused162) {
        }
        try {
            f[Definitions$Measurement.VQE_POST_REPAIR_LOSSES_RCC.ordinal()] = 54;
        } catch (NoSuchFieldError unused163) {
        }
        try {
            f[Definitions$Measurement.VQE_PRIMARY_RTCP_INPUTS.ordinal()] = 55;
        } catch (NoSuchFieldError unused164) {
        }
        try {
            f[Definitions$Measurement.VQE_PRIMARY_RTCP_OUTPUTS.ordinal()] = 56;
        } catch (NoSuchFieldError unused165) {
        }
        try {
            f[Definitions$Measurement.VQE_RCC_ABORTS_BURST_ACTIVITY.ordinal()] = 57;
        } catch (NoSuchFieldError unused166) {
        }
        try {
            f[Definitions$Measurement.VQE_RCC_ABORTS_BURST_START.ordinal()] = 58;
        } catch (NoSuchFieldError unused167) {
        }
        try {
            f[Definitions$Measurement.VQE_RCC_ABORTS_OTHER.ordinal()] = 59;
        } catch (NoSuchFieldError unused168) {
        }
        try {
            f[Definitions$Measurement.VQE_RCC_ABORTS_RESPONSE_INVALID.ordinal()] = 60;
        } catch (NoSuchFieldError unused169) {
        }
        try {
            f[Definitions$Measurement.VQE_RCC_ABORTS_RESPONSE_TIMEOUT.ordinal()] = 61;
        } catch (NoSuchFieldError unused170) {
        }
        try {
            f[Definitions$Measurement.VQE_RCC_ABORTS_SERVER_REJECT.ordinal()] = 62;
        } catch (NoSuchFieldError unused171) {
        }
        try {
            f[Definitions$Measurement.VQE_RCC_ABORTS_STUN_TIMEOUT.ordinal()] = 63;
        } catch (NoSuchFieldError unused172) {
        }
        try {
            f[Definitions$Measurement.VQE_RCC_ABORTS_TOTAL.ordinal()] = 64;
        } catch (NoSuchFieldError unused173) {
        }
        try {
            f[Definitions$Measurement.VQE_RCC_REQUESTS.ordinal()] = 65;
        } catch (NoSuchFieldError unused174) {
        }
        try {
            f[Definitions$Measurement.VQE_REPAIR_RTCP_INPUTS.ordinal()] = 66;
        } catch (NoSuchFieldError unused175) {
        }
        try {
            f[Definitions$Measurement.VQE_REPAIR_RTCP_STUN_INPUTS.ordinal()] = 67;
        } catch (NoSuchFieldError unused176) {
        }
        try {
            f[Definitions$Measurement.VQE_REPAIR_RTCP_STUN_OUTPUTS.ordinal()] = 68;
        } catch (NoSuchFieldError unused177) {
        }
        try {
            f[Definitions$Measurement.RET_PACKET_DROPS.ordinal()] = 69;
        } catch (NoSuchFieldError unused178) {
        }
        try {
            f[Definitions$Measurement.RET_PACKET_DROPS_LATE.ordinal()] = 70;
        } catch (NoSuchFieldError unused179) {
        }
        try {
            f[Definitions$Measurement.RET_PACKETS_RECEIVED.ordinal()] = 71;
        } catch (NoSuchFieldError unused180) {
        }
        try {
            f[Definitions$Measurement.VQE_REPAIR_RTP_STUN_INPUTS.ordinal()] = 72;
        } catch (NoSuchFieldError unused181) {
        }
        try {
            f[Definitions$Measurement.VQE_REPAIR_RTP_STUN_OUTPUTS.ordinal()] = 73;
        } catch (NoSuchFieldError unused182) {
        }
        try {
            f[Definitions$Measurement.RET_REQUESTS_POLICED.ordinal()] = 74;
        } catch (NoSuchFieldError unused183) {
        }
        try {
            f[Definitions$Measurement.RET_REQUESTS.ordinal()] = 75;
        } catch (NoSuchFieldError unused184) {
        }
        try {
            f[Definitions$Measurement.VQE_TUNER_QUEUE_DROPS.ordinal()] = 76;
        } catch (NoSuchFieldError unused185) {
        }
        try {
            f[Definitions$Measurement.VQE_UNDERRUNS.ordinal()] = 77;
        } catch (NoSuchFieldError unused186) {
        }
        try {
            f[Definitions$Measurement.WAN_RX_PACKET_COUNT.ordinal()] = 78;
        } catch (NoSuchFieldError unused187) {
        }
        try {
            f[Definitions$Measurement.WAN_RX_BYTE_COUNT.ordinal()] = 79;
        } catch (NoSuchFieldError unused188) {
        }
        try {
            f[Definitions$Measurement.WAN_RX_CRC_ERROR_PACKET_COUNT.ordinal()] = 80;
        } catch (NoSuchFieldError unused189) {
        }
        try {
            f[Definitions$Measurement.WAN_RX_LOST_PACKET_COUNT.ordinal()] = 81;
        } catch (NoSuchFieldError unused190) {
        }
        try {
            f[Definitions$Measurement.WAN_TX_PACKET_COUNT.ordinal()] = 82;
        } catch (NoSuchFieldError unused191) {
        }
        try {
            f[Definitions$Measurement.WAN_TX_BYTE_COUNT.ordinal()] = 83;
        } catch (NoSuchFieldError unused192) {
        }
        try {
            f[Definitions$Measurement.WAN_TX_LOST_PACKET_COUNT.ordinal()] = 84;
        } catch (NoSuchFieldError unused193) {
        }
        try {
            f[Definitions$Measurement.WLAN_RX_PACKET_COUNT.ordinal()] = 85;
        } catch (NoSuchFieldError unused194) {
        }
        try {
            f[Definitions$Measurement.WLAN_RX_BYTE_COUNT.ordinal()] = 86;
        } catch (NoSuchFieldError unused195) {
        }
        try {
            f[Definitions$Measurement.WLAN_RX_CRC_ERROR_PACKET_COUNT.ordinal()] = 87;
        } catch (NoSuchFieldError unused196) {
        }
        try {
            f[Definitions$Measurement.WLAN_TX_PACKET_COUNT.ordinal()] = 88;
        } catch (NoSuchFieldError unused197) {
        }
        try {
            f[Definitions$Measurement.WLAN_TX_BYTE_COUNT.ordinal()] = 89;
        } catch (NoSuchFieldError unused198) {
        }
        try {
            f[Definitions$Measurement.WLAN_TX_SUCCESSFUL_PACKETS.ordinal()] = 90;
        } catch (NoSuchFieldError unused199) {
        }
        try {
            f[Definitions$Measurement.WLAN_TX_PACKET_RETRY_COUNTS.ordinal()] = 91;
        } catch (NoSuchFieldError unused200) {
        }
        try {
            f[Definitions$Measurement.DS_NR_OF_CONTENT_PROFILE_BITRATE_DOWN_CHANGES.ordinal()] = 92;
        } catch (NoSuchFieldError unused201) {
        }
        try {
            f[Definitions$Measurement.DS_NR_OF_CONTENT_PROFILE_BITRATE_UP_CHANGES.ordinal()] = 93;
        } catch (NoSuchFieldError unused202) {
        }
        try {
            f[Definitions$Measurement.DS_NR_OF_SEGMENTS_REQUESTED.ordinal()] = 94;
        } catch (NoSuchFieldError unused203) {
        }
        try {
            f[Definitions$Measurement.DS_NR_OF_SEGMENTS_RECEIVED.ordinal()] = 95;
        } catch (NoSuchFieldError unused204) {
        }
        try {
            f[Definitions$Measurement.DS_NR_OF_SEGMENT_TIMEOUTS.ordinal()] = 96;
        } catch (NoSuchFieldError unused205) {
        }
        try {
            f[Definitions$Measurement.DS_NR_OF_SEGMENT_FAILURES.ordinal()] = 97;
        } catch (NoSuchFieldError unused206) {
        }
        try {
            f[Definitions$Measurement.DS_NR_OF_SEGMENT_UNDERRUNS.ordinal()] = 98;
        } catch (NoSuchFieldError unused207) {
        }
        try {
            f[Definitions$Measurement.DS_SEGMENT_READ_BITRATE.ordinal()] = 99;
        } catch (NoSuchFieldError unused208) {
        }
        try {
            f[Definitions$Measurement.DS_SEGMENT_PROFILE_BITRATE.ordinal()] = 100;
        } catch (NoSuchFieldError unused209) {
        }
        try {
            f[Definitions$Measurement.DS_SEGMENT_NR_READ_BITRATE_BELOW_PROFILE.ordinal()] = 101;
        } catch (NoSuchFieldError unused210) {
        }
        try {
            f[Definitions$Measurement.DS_SEGMENTS_TOTAL_TIME.ordinal()] = 102;
        } catch (NoSuchFieldError unused211) {
        }
        try {
            f[Definitions$Measurement.DS_NR_OF_SEGMENT_BUFFER_LEVEL.ordinal()] = 103;
        } catch (NoSuchFieldError unused212) {
        }
        try {
            f[Definitions$Measurement.RET_CORRECTED_PACKET_COUNT.ordinal()] = 104;
        } catch (NoSuchFieldError unused213) {
        }
        try {
            f[Definitions$Measurement.RET_PACKETS_REQUESTED.ordinal()] = 105;
        } catch (NoSuchFieldError unused214) {
        }
        try {
            f[Definitions$Measurement.RET_MAX_HOLE_SIZE.ordinal()] = 106;
        } catch (NoSuchFieldError unused215) {
        }
        try {
            f[Definitions$Measurement.APPLICATION_STARTUP_TIME.ordinal()] = 107;
        } catch (NoSuchFieldError unused216) {
        }
        try {
            f[Definitions$Measurement.BYTES_RECEIVED.ordinal()] = 108;
        } catch (NoSuchFieldError unused217) {
        }
        try {
            f[Definitions$Measurement.NR_OF_FRAMES_ENCODED.ordinal()] = 109;
        } catch (NoSuchFieldError unused218) {
        }
        try {
            f[Definitions$Measurement.NR_OF_FRAMES_DROPPED.ordinal()] = 110;
        } catch (NoSuchFieldError unused219) {
        }
        try {
            f[Definitions$Measurement.NUMBER_OF_FRAMES_REPEATED.ordinal()] = 111;
        } catch (NoSuchFieldError unused220) {
        }
        try {
            f[Definitions$Measurement.WLAN_SIGNAL_STRENGTH.ordinal()] = 112;
        } catch (NoSuchFieldError unused221) {
        }
        try {
            f[Definitions$Measurement.WLAN_SIGNAL_STRENGTH_DBMV.ordinal()] = 113;
        } catch (NoSuchFieldError unused222) {
        }
        try {
            f[Definitions$Measurement.WLAN_SIGNAL_STRENGTH_DBM.ordinal()] = 114;
        } catch (NoSuchFieldError unused223) {
        }
        try {
            f[Definitions$Measurement.WLAN_PER.ordinal()] = 115;
        } catch (NoSuchFieldError unused224) {
        }
        try {
            f[Definitions$Measurement.WLAN_SNR.ordinal()] = 116;
        } catch (NoSuchFieldError unused225) {
        }
        try {
            f[Definitions$Measurement.MOBILE_SIGNAL_STRENGTH.ordinal()] = 117;
        } catch (NoSuchFieldError unused226) {
        }
        try {
            f[Definitions$Measurement.MOBILE_SIGNAL_STRENGTH_DBMV.ordinal()] = 118;
        } catch (NoSuchFieldError unused227) {
        }
        try {
            f[Definitions$Measurement.MOBILE_SIGNAL_STRENGTH_DBM.ordinal()] = 119;
        } catch (NoSuchFieldError unused228) {
        }
        try {
            f[Definitions$Measurement.MOBILE_SNR.ordinal()] = 120;
        } catch (NoSuchFieldError unused229) {
        }
        try {
            f[Definitions$Measurement.DS_NR_OF_REQUESTS.ordinal()] = 121;
        } catch (NoSuchFieldError unused230) {
        }
        try {
            f[Definitions$Measurement.DS_NR_OF_REQUEST_ERRORS.ordinal()] = 122;
        } catch (NoSuchFieldError unused231) {
        }
        try {
            f[Definitions$Measurement.DS_SEGMENT_PROFILE_NR.ordinal()] = 123;
        } catch (NoSuchFieldError unused232) {
        }
        try {
            f[Definitions$Measurement.DS_SEGMENT_SOURCE_IP.ordinal()] = 124;
        } catch (NoSuchFieldError unused233) {
        }
        try {
            f[Definitions$Measurement.DS_MANIFEST_SOURCE_IP.ordinal()] = 125;
        } catch (NoSuchFieldError unused234) {
        }
        try {
            f[Definitions$Measurement.CA_GENERIC_ERRORS.ordinal()] = 126;
        } catch (NoSuchFieldError unused235) {
        }
        try {
            f[Definitions$Measurement.EPG_NUMBER_OF_REQUESTS.ordinal()] = 127;
        } catch (NoSuchFieldError unused236) {
        }
        try {
            f[Definitions$Measurement.EPG_NUMBER_OF_TIMEOUTS.ordinal()] = 128;
        } catch (NoSuchFieldError unused237) {
        }
        try {
            f[Definitions$Measurement.VQE_POST_REPAIR_OUTPUTS.ordinal()] = 129;
        } catch (NoSuchFieldError unused238) {
        }
        try {
            f[Definitions$Measurement.VQE_PRE_REPAIR_LOSSES.ordinal()] = 130;
        } catch (NoSuchFieldError unused239) {
        }
        try {
            f[Definitions$Measurement.VQE_POST_REPAIR_LOSSES.ordinal()] = 131;
        } catch (NoSuchFieldError unused240) {
        }
        try {
            f[Definitions$Measurement.VQE_RCC_WITH_LOSS.ordinal()] = 132;
        } catch (NoSuchFieldError unused241) {
        }
        try {
            f[Definitions$Measurement.RTP_EXPECTED_PACKET_COUNT.ordinal()] = 133;
        } catch (NoSuchFieldError unused242) {
        }
        try {
            f[Definitions$Measurement.TR135_PACKETS_EXPECTED.ordinal()] = 134;
        } catch (NoSuchFieldError unused243) {
        }
        try {
            f[Definitions$Measurement.TR135_PACKETS_RECEIVED.ordinal()] = 135;
        } catch (NoSuchFieldError unused244) {
        }
        try {
            f[Definitions$Measurement.TR135_PACKETS_LOST.ordinal()] = 136;
        } catch (NoSuchFieldError unused245) {
        }
        try {
            f[Definitions$Measurement.TR135_PACKETS_LOST_BEFORE_EC.ordinal()] = 137;
        } catch (NoSuchFieldError unused246) {
        }
        try {
            f[Definitions$Measurement.HTTP_REQUEST_STATUS_CODE_1XX.ordinal()] = 138;
        } catch (NoSuchFieldError unused247) {
        }
        try {
            f[Definitions$Measurement.HTTP_REQUEST_STATUS_CODE_2XX.ordinal()] = 139;
        } catch (NoSuchFieldError unused248) {
        }
        try {
            f[Definitions$Measurement.HTTP_REQUEST_STATUS_CODE_3XX.ordinal()] = 140;
        } catch (NoSuchFieldError unused249) {
        }
        try {
            f[Definitions$Measurement.HTTP_REQUEST_STATUS_CODE_4XX.ordinal()] = 141;
        } catch (NoSuchFieldError unused250) {
        }
        try {
            f[Definitions$Measurement.HTTP_REQUEST_STATUS_CODE_5XX.ordinal()] = 142;
        } catch (NoSuchFieldError unused251) {
        }
        try {
            f[Definitions$Measurement.NR_OF_FRAMES_DECODED.ordinal()] = 143;
        } catch (NoSuchFieldError unused252) {
        }
        try {
            f[Definitions$Measurement.CPU_TEMPERATURE.ordinal()] = 144;
        } catch (NoSuchFieldError unused253) {
        }
        try {
            f[Definitions$Measurement.PLAYBACK_DELTA_TO_ORIGIN.ordinal()] = 145;
        } catch (NoSuchFieldError unused254) {
        }
        try {
            f[Definitions$Measurement.ORIGIN_TIMESTAMP.ordinal()] = 146;
        } catch (NoSuchFieldError unused255) {
        }
        try {
            f[Definitions$Measurement.RF_BER_PREREEDSOLOMON.ordinal()] = 147;
        } catch (NoSuchFieldError unused256) {
        }
        try {
            f[Definitions$Measurement.RF_BER_PREBCH.ordinal()] = 148;
        } catch (NoSuchFieldError unused257) {
        }
        try {
            f[Definitions$Measurement.RF_BER_POSTBCH.ordinal()] = 149;
        } catch (NoSuchFieldError unused258) {
        }
        try {
            f[Definitions$Measurement.RF_BER_PRELDPC.ordinal()] = 150;
        } catch (NoSuchFieldError unused259) {
        }
        try {
            f[Definitions$Measurement.RF_BER_POSTLDPC.ordinal()] = 151;
        } catch (NoSuchFieldError unused260) {
        }
        try {
            f[Definitions$Measurement.PLAYBACK_POSITION.ordinal()] = 152;
        } catch (NoSuchFieldError unused261) {
        }
        try {
            f[Definitions$Measurement.BUFFER_LENGTH.ordinal()] = 153;
        } catch (NoSuchFieldError unused262) {
        }
        try {
            f[Definitions$Measurement.STREAM_DELTA_TO_ORIGIN.ordinal()] = 154;
        } catch (NoSuchFieldError unused263) {
        }
        try {
            f[Definitions$Measurement.VQE_REPAIR_RTP_DROPS.ordinal()] = 155;
        } catch (NoSuchFieldError unused264) {
        }
        try {
            f[Definitions$Measurement.VQE_REPAIR_RTP_DROPS_LATE.ordinal()] = 156;
        } catch (NoSuchFieldError unused265) {
        }
        try {
            f[Definitions$Measurement.VQE_REPAIR_RTP_INPUTS.ordinal()] = 157;
        } catch (NoSuchFieldError unused266) {
        }
        try {
            f[Definitions$Measurement.VQE_REPAIRS_POLICED.ordinal()] = 158;
        } catch (NoSuchFieldError unused267) {
        }
        try {
            f[Definitions$Measurement.VQE_REPAIRS_REQUESTED.ordinal()] = 159;
        } catch (NoSuchFieldError unused268) {
        }
        try {
            f[Definitions$Measurement.NR_OF_FRAMES_REPEATED.ordinal()] = 160;
        } catch (NoSuchFieldError unused269) {
        }
        try {
            f[Definitions$Measurement.RET_PRE_REPAIR_LOSSES.ordinal()] = 161;
        } catch (NoSuchFieldError unused270) {
        }
        try {
            f[Definitions$Measurement.RET_POST_REPAIR_LOSSES.ordinal()] = 162;
        } catch (NoSuchFieldError unused271) {
        }
        try {
            f[Definitions$Measurement.FCC_REQUESTS.ordinal()] = 163;
        } catch (NoSuchFieldError unused272) {
        }
        try {
            f[Definitions$Measurement.FCC_ABORTS.ordinal()] = 164;
        } catch (NoSuchFieldError unused273) {
        }
        try {
            f[Definitions$Measurement.FCC_PACKET_LOSS.ordinal()] = 165;
        } catch (NoSuchFieldError unused274) {
        }
        try {
            f[Definitions$Measurement.NUMBER_OF_FRAMES_DROPPED.ordinal()] = 166;
        } catch (NoSuchFieldError unused275) {
        }
        try {
            f[Definitions$Measurement.NUMBER_OF_FRAMES_DECODED.ordinal()] = 167;
        } catch (NoSuchFieldError unused276) {
        }
        try {
            f[Definitions$Measurement.SEGMENT_READ_BITRATE.ordinal()] = 168;
        } catch (NoSuchFieldError unused277) {
        }
        try {
            f[Definitions$Measurement.SEGMENT_PROFILE_NUMBER.ordinal()] = 169;
        } catch (NoSuchFieldError unused278) {
        }
        try {
            f[Definitions$Measurement.SEGMENT_PROFILE_BITRATE.ordinal()] = 170;
        } catch (NoSuchFieldError unused279) {
        }
        int[] iArr5 = new int[Definitions$ShutdownType.values().length];
        e = iArr5;
        try {
            iArr5[Definitions$ShutdownType.NORMAL_SHUTDOWN.ordinal()] = 1;
        } catch (NoSuchFieldError unused280) {
        }
        try {
            e[Definitions$ShutdownType.REBOOT.ordinal()] = 2;
        } catch (NoSuchFieldError unused281) {
        }
        try {
            e[Definitions$ShutdownType.HARD_STANDBY.ordinal()] = 3;
        } catch (NoSuchFieldError unused282) {
        }
        try {
            e[Definitions$ShutdownType.RESTART.ordinal()] = 4;
        } catch (NoSuchFieldError unused283) {
        }
        try {
            e[Definitions$ShutdownType.ABNORMAL_TERMINATION.ordinal()] = 5;
        } catch (NoSuchFieldError unused284) {
        }
        int[] iArr6 = new int[Definitions$DsProtocol.values().length];
        f8619d = iArr6;
        try {
            iArr6[Definitions$DsProtocol.UNDEFINED.ordinal()] = 1;
        } catch (NoSuchFieldError unused285) {
        }
        try {
            f8619d[Definitions$DsProtocol.APPLE_HLS.ordinal()] = 2;
        } catch (NoSuchFieldError unused286) {
        }
        try {
            f8619d[Definitions$DsProtocol.MS_SMOOTH.ordinal()] = 3;
        } catch (NoSuchFieldError unused287) {
        }
        try {
            f8619d[Definitions$DsProtocol.ADOBE_HDS.ordinal()] = 4;
        } catch (NoSuchFieldError unused288) {
        }
        try {
            f8619d[Definitions$DsProtocol.MPEG_DASH.ordinal()] = 5;
        } catch (NoSuchFieldError unused289) {
        }
        int[] iArr7 = new int[Definitions$DtvDeliverySystem.values().length];
        f8618c = iArr7;
        try {
            iArr7[Definitions$DtvDeliverySystem.DVB_C.ordinal()] = 1;
        } catch (NoSuchFieldError unused290) {
        }
        try {
            f8618c[Definitions$DtvDeliverySystem.DVB_S.ordinal()] = 2;
        } catch (NoSuchFieldError unused291) {
        }
        try {
            f8618c[Definitions$DtvDeliverySystem.DVB_T.ordinal()] = 3;
        } catch (NoSuchFieldError unused292) {
        }
        try {
            f8618c[Definitions$DtvDeliverySystem.IP.ordinal()] = 4;
        } catch (NoSuchFieldError unused293) {
        }
        try {
            f8618c[Definitions$DtvDeliverySystem.ATSC.ordinal()] = 5;
        } catch (NoSuchFieldError unused294) {
        }
        try {
            f8618c[Definitions$DtvDeliverySystem.ISDB_T.ordinal()] = 6;
        } catch (NoSuchFieldError unused295) {
        }
        int[] iArr8 = new int[Definitions$DsPlaylistType.values().length];
        f8617b = iArr8;
        try {
            iArr8[Definitions$DsPlaylistType.EVENT.ordinal()] = 1;
        } catch (NoSuchFieldError unused296) {
        }
        try {
            f8617b[Definitions$DsPlaylistType.VOD.ordinal()] = 2;
        } catch (NoSuchFieldError unused297) {
        }
        try {
            f8617b[Definitions$DsPlaylistType.LIVE.ordinal()] = 3;
        } catch (NoSuchFieldError unused298) {
        }
        int[] iArr9 = new int[Definitions$VodProtocol.values().length];
        f8616a = iArr9;
        try {
            iArr9[Definitions$VodProtocol.HTTP.ordinal()] = 1;
        } catch (NoSuchFieldError unused299) {
        }
        try {
            f8616a[Definitions$VodProtocol.RTSP.ordinal()] = 2;
        } catch (NoSuchFieldError unused300) {
        }
        try {
            f8616a[Definitions$VodProtocol.MYRIO.ordinal()] = 3;
        } catch (NoSuchFieldError unused301) {
        }
    }
}
