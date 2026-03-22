package com.zte.ucs.tvcall.ocx.wb;

/* loaded from: classes2.dex */
public class WhiteBoardShareType {
    private int actiontype;
    private int calltype;
    private int datanum;
    private int needRpt;
    private int operationtype;
    private PositionData[] position;
    private String nIndex = "";
    private String receiverUri = "";
    private String senderUri = "";
    private String msgid = "";
    private String wbFlag = "";
    private String linecolor = "";
    private String linewidth = "";
    private String height = "";
    private String width = "";

    public int getActiontype() {
        return this.actiontype;
    }

    public int getCalltype() {
        return this.calltype;
    }

    public int getDatanum() {
        return this.datanum;
    }

    public String getHeight() {
        return this.height;
    }

    public String getLinecolor() {
        return this.linecolor;
    }

    public String getLinewidth() {
        return this.linewidth;
    }

    public String getMsgid() {
        return this.msgid;
    }

    public int getNeedRpt() {
        return this.needRpt;
    }

    public int getOperationtype() {
        return this.operationtype;
    }

    public PositionData[] getPosition() {
        return this.position;
    }

    public String getReceiverUri() {
        return this.receiverUri;
    }

    public String getSenderUri() {
        return this.senderUri;
    }

    public String getWbFlag() {
        return this.wbFlag;
    }

    public String getWidth() {
        return this.width;
    }

    public String getnIndex() {
        return this.nIndex;
    }

    public void setActiontype(int i) {
        this.actiontype = i;
    }

    public void setCalltype(int i) {
        this.calltype = i;
    }

    public void setDatanum(int i) {
        this.datanum = i;
    }

    public void setHeight(String str) {
        this.height = str;
    }

    public void setLinecolor(String str) {
        this.linecolor = str;
    }

    public void setLinewidth(String str) {
        this.linewidth = str;
    }

    public void setMsgid(String str) {
        this.msgid = str;
    }

    public void setNeedRpt(int i) {
        this.needRpt = i;
    }

    public void setOperationtype(int i) {
        this.operationtype = i;
    }

    public void setPosition(PositionData[] positionDataArr) {
        if (positionDataArr != null) {
            this.position = (PositionData[]) positionDataArr.clone();
        }
    }

    public void setReceiverUri(String str) {
        this.receiverUri = str;
    }

    public void setSenderUri(String str) {
        this.senderUri = str;
    }

    public void setWbFlag(String str) {
        this.wbFlag = str;
    }

    public void setWidth(String str) {
        this.width = str;
    }

    public void setnIndex(String str) {
        this.nIndex = str;
    }
}
