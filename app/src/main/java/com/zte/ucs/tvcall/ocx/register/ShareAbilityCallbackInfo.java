package com.zte.ucs.tvcall.ocx.register;

/* loaded from: classes2.dex */
public class ShareAbilityCallbackInfo {
    int result = -1;
    String accontid = "";
    String sharedAbility = "";

    public String getAccontid() {
        return this.accontid;
    }

    public int getResult() {
        return this.result;
    }

    public String getSharedAbility() {
        return this.sharedAbility;
    }

    public void setAccontid(String str) {
        this.accontid = str;
    }

    public void setResult(int i) {
        this.result = i;
    }

    public void setSharedAbility(String str) {
        this.sharedAbility = str;
    }
}
