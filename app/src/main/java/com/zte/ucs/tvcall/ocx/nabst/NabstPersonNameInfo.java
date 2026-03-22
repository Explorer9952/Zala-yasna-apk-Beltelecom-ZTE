package com.zte.ucs.tvcall.ocx.nabst;

/* loaded from: classes2.dex */
public class NabstPersonNameInfo {
    private String givenName = "";
    private String middleName = "";
    private String familyName = "";
    private String title = "";

    public String getFamilyName() {
        return this.familyName;
    }

    public String getGivenName() {
        return this.givenName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public String getTitle() {
        return this.title;
    }

    public void setFamilyName(String str) {
        this.familyName = str;
    }

    public void setGivenName(String str) {
        this.givenName = str;
    }

    public void setMiddleName(String str) {
        this.middleName = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
