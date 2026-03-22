package com.zte.sdk.enumclass;

/* loaded from: classes2.dex */
public enum ParticipantStatusEnum {
    unknown("unknown", 0),
    connecting("connecting", 1),
    ringing("ringing", 2),
    connected("connected", 3),
    disconnected("disconnected", 4),
    usernotavailable("usernotavailable", 5),
    noanswer("noanswer", 6),
    busy("busy", 7),
    notreachable("notreachable", 8),
    routingfailure("routingfailure", 9),
    unabailable("unabailable", 10),
    generalfailure("generalfailure", 11),
    timerexpiry("timerexpiry", 12),
    deleted("deleted", 13),
    forbidden("forbidden", 14),
    onlinehelp("onlinehelp", 15),
    hangup("hangup", 16);

    private int code;
    private String value;

    ParticipantStatusEnum(String str, int i) {
        this.value = "unknown";
        this.code = 0;
        this.value = str;
        this.code = i;
    }

    public static ParticipantStatusEnum init(int i) {
        ParticipantStatusEnum participantStatusEnum = unabailable;
        for (ParticipantStatusEnum participantStatusEnum2 : values()) {
            if (i == participantStatusEnum2.getCode()) {
                participantStatusEnum = participantStatusEnum2;
            }
        }
        return participantStatusEnum;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getValue() {
        return this.value;
    }
}
