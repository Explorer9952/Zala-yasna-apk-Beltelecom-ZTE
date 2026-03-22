package com.zte.sdk.enumclass;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public enum CapablityEnum {
    Pager_Mode(0, "+g.3gpp.icsi-ref=\"urn%3Aurn-7%3A3gpp-service.ims.icsi.oma.cpm.msg\""),
    Large_Message_Mode(1, "+g.3gpp.icsi-ref=\"urn%3Aurn-7%3A3gpp-service.ims.icsi.oma.cpm.largemsg\""),
    Chat(2, "+g.3gpp.icsi-ref=\"urn%3Aurn-7%3A3gpp-service.ims.icsi.oma.cpm.session\""),
    Full_Store(3, "+g.3gpp.iari-ref=\"urn%3Aurn-7%3A3gpp-application.ims.iari.rcs.fullsfgroupchat\""),
    File_Transfer(4, "+g.3gpp.icsi-ref=\"urn%3Aurn-7%3A3gpp-service.ims.icsi.oma.cpm.filetransfer\""),
    File_Transfer_Thumbnail(5, "+g.3gpp.iari-ref=\"urn%3Aurn-7%3A3gpp-application.ims.iari.rcs.ftthumb\""),
    File_Transfer_Store_and_Forward(6, "+g.3gpp.iari-ref=\"urn%3Aurn-7%3A3gpp-application.ims.iari.rcs.ftstandfw\""),
    IP_voice_call(8, "+g.3gpp.icsi-ref=\"urn%3Aurn-7%3A3gpp-service.ims.icsi.mmtel\""),
    IP_video_call(10, "+g.3gpp.icsi-ref=\"urn%3Aurn-7%3A3gpp-service.ims.icsi.mmtel\";video"),
    Public_Message(15, "+g.3gpp.iari-ref=\"urn%3Aurn-7%3A3gpp-application.ims.iari.rcs.mnc000.mcc460.publicmsg\""),
    Group_Manage(17, "+g.3gpp.iari-ref=\"urn%3Aurn-7%3A3gpp-application.ims.iari.rcs.mnc000.mcc460.gpmanage\";vs=1"),
    Common_Extension(19, "+g.3gpp.iari-ref=\"urn%3Aurn-7%3A3gpp-application.ims.iari.rcs.mnc000.mcc460.commonextension\""),
    Burn_After_Reading(20, "barCycle"),
    Card_Message(21, "+g.3gpp.iari-ref=\"urn%3Aurn-7%3A3gpp-application.ims.iari.rcs.mnc000.mcc460.cardmsg\""),
    OFFLINE_MSG(22, "*;+g.3gpp.iari-ref=\"urn%3Aurn-7%3A3gpp-application.ims.iari.rcs.offlinemsg\""),
    Group_Qrcode(23, "+g.3gpp.iari-ref=\"urn%3Aurn-7%3A3gpp-application.ims.iari.rcs .mnc000.mcc460.groupqrcode\""),
    Msg_Revoke(24, "+g.gsma.rcs.msgrevoke");

    public static final String SPLIT_CODE = "|";
    private int code;
    private String value;

    CapablityEnum(int i, String str) {
        this.value = "+g.3gpp.icsi-ref=\"urn%3Aurn-7%3A3gpp-service.ims.icsi.oma.cpm.msg\"";
        this.code = 0;
        this.value = str;
        this.code = i;
    }

    public static CapablityEnum initByCode(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(Pager_Mode.getCode());
        if (sb.toString().equals(str)) {
            return Pager_Mode;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(Large_Message_Mode.getCode());
        if (sb2.toString().equals(str)) {
            return Large_Message_Mode;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(Chat.getCode());
        if (sb3.toString().equals(str)) {
            return Chat;
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append(Full_Store.getCode());
        if (sb4.toString().equals(str)) {
            return Full_Store;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(File_Transfer.getCode());
        if (sb5.toString().equals(str)) {
            return File_Transfer;
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append(File_Transfer_Thumbnail.getCode());
        if (sb6.toString().equals(str)) {
            return File_Transfer_Thumbnail;
        }
        StringBuilder sb7 = new StringBuilder();
        sb7.append(File_Transfer_Store_and_Forward.getCode());
        if (sb7.toString().equals(str)) {
            return File_Transfer_Store_and_Forward;
        }
        StringBuilder sb8 = new StringBuilder();
        sb8.append(IP_voice_call.getCode());
        if (sb8.toString().equals(str)) {
            return IP_voice_call;
        }
        StringBuilder sb9 = new StringBuilder();
        sb9.append(IP_video_call.getCode());
        if (sb9.toString().equals(str)) {
            return IP_video_call;
        }
        StringBuilder sb10 = new StringBuilder();
        sb10.append(Public_Message.getCode());
        if (sb10.toString().equals(str)) {
            return Public_Message;
        }
        StringBuilder sb11 = new StringBuilder();
        sb11.append(Group_Manage.getCode());
        if (sb11.toString().equals(str)) {
            return Group_Manage;
        }
        StringBuilder sb12 = new StringBuilder();
        sb12.append(Common_Extension.getCode());
        if (sb12.toString().equals(str)) {
            return Common_Extension;
        }
        StringBuilder sb13 = new StringBuilder();
        sb13.append(Burn_After_Reading.getCode());
        if (sb13.toString().equals(str)) {
            return Burn_After_Reading;
        }
        StringBuilder sb14 = new StringBuilder();
        sb14.append(Card_Message.getCode());
        if (sb14.toString().equals(str)) {
            return Card_Message;
        }
        StringBuilder sb15 = new StringBuilder();
        sb15.append(OFFLINE_MSG.getCode());
        if (sb15.toString().equals(str)) {
            return OFFLINE_MSG;
        }
        StringBuilder sb16 = new StringBuilder();
        sb16.append(Group_Qrcode.getCode());
        if (sb16.toString().equals(str)) {
            return Group_Qrcode;
        }
        StringBuilder sb17 = new StringBuilder();
        sb17.append(Msg_Revoke.getCode());
        if (sb17.toString().equals(str)) {
            return Msg_Revoke;
        }
        return null;
    }

    public static List<CapablityEnum> toList() {
        CapablityEnum[] values = values();
        ArrayList arrayList = new ArrayList();
        for (CapablityEnum capablityEnum : values) {
            arrayList.add(capablityEnum);
        }
        return arrayList;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getValue() {
        return this.value;
    }
}
