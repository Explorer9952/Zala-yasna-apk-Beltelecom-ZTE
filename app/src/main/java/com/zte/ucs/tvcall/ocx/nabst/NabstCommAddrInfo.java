package com.zte.ucs.tvcall.ocx.nabst;

/* loaded from: classes2.dex */
public class NabstCommAddrInfo {
    private int emailCount;
    private int telCount;
    private NabstPersonTelInfo[] telArray = new NabstPersonTelInfo[0];
    private String[] email = new String[0];

    public String[] getEmail() {
        return this.email;
    }

    public int getEmailCount() {
        return this.emailCount;
    }

    public NabstPersonTelInfo[] getTelArray() {
        return this.telArray;
    }

    public int getTelCount() {
        return this.telCount;
    }

    public void setEmail(String[] strArr) {
        if (strArr != null) {
            this.email = (String[]) strArr.clone();
        }
    }

    public void setEmailCount(int i) {
        this.emailCount = i;
    }

    public void setTelArray(NabstPersonTelInfo[] nabstPersonTelInfoArr) {
        if (nabstPersonTelInfoArr != null) {
            this.telArray = (NabstPersonTelInfo[]) nabstPersonTelInfoArr.clone();
        }
    }

    public void setTelCount(int i) {
        this.telCount = i;
    }
}
