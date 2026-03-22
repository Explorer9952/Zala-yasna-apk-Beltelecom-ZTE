package com.zte.ucs.tvcall.ocx.nabst;

/* loaded from: classes2.dex */
public class NabstUpLoadUserMsgReminSettingReq {
    private String accountid = "";
    private String sessionID = "";
    private NabstMsgReminderSettingInfo tMsgReminder;

    public String getAccountid() {
        return this.accountid;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public NabstMsgReminderSettingInfo gettMsgReminder() {
        return this.tMsgReminder;
    }

    public void setAccountid(String str) {
        this.accountid = str;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }

    public void settMsgReminder(NabstMsgReminderSettingInfo nabstMsgReminderSettingInfo) {
        this.tMsgReminder = nabstMsgReminderSettingInfo;
    }
}
