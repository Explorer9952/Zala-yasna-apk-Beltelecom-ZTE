package com.zte.ucs.tvcall.ocx.publicaccount;

/* loaded from: classes2.dex */
public class PaInfo {
    public String cIntro;
    public String cLogoUrl;
    public String cName;
    public String cPa_uuid;
    public int idtype;
    public int recommendlevel;
    public String subscribetime;
    public int suscribestatus;

    public int getIdtype() {
        return this.idtype;
    }

    public int getRecommendlevel() {
        return this.recommendlevel;
    }

    public String getSubscribetime() {
        return this.subscribetime;
    }

    public int getSuscribestatus() {
        return this.suscribestatus;
    }

    public String getcIntro() {
        return this.cIntro;
    }

    public String getcLogoUrl() {
        return this.cLogoUrl;
    }

    public String getcName() {
        return this.cName;
    }

    public String getcPa_uuid() {
        return this.cPa_uuid;
    }

    public void setIdtype(int i) {
        this.idtype = i;
    }

    public void setRecommendlevel(int i) {
        this.recommendlevel = i;
    }

    public void setSubscribetime(String str) {
        this.subscribetime = str;
    }

    public void setSuscribestatus(int i) {
        this.suscribestatus = i;
    }

    public void setcIntro(String str) {
        this.cIntro = str;
    }

    public void setcLogoUrl(String str) {
        this.cLogoUrl = str;
    }

    public void setcName(String str) {
        this.cName = str;
    }

    public void setcPa_uuid(String str) {
        this.cPa_uuid = str;
    }
}
