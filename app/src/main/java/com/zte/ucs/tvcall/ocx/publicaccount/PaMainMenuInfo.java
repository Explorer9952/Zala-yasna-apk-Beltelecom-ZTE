package com.zte.ucs.tvcall.ocx.publicaccount;

/* loaded from: classes2.dex */
public class PaMainMenuInfo {
    public PaMenuInfo paMenuInfo;
    public PaMenuInfo[] subMenuArry;
    public int submenuNum;

    public PaMenuInfo getPaMenuInfo() {
        return this.paMenuInfo;
    }

    public PaMenuInfo[] getSubMenuArry() {
        return this.subMenuArry;
    }

    public int getSubmenuNum() {
        return this.submenuNum;
    }

    public void setPaMenuInfo(PaMenuInfo paMenuInfo) {
        this.paMenuInfo = paMenuInfo;
    }

    public void setSubMenuArry(PaMenuInfo[] paMenuInfoArr) {
        if (paMenuInfoArr != null) {
            this.subMenuArry = (PaMenuInfo[]) paMenuInfoArr.clone();
        }
    }

    public void setSubmenuNum(int i) {
        this.submenuNum = i;
    }
}
