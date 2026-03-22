package com.zte.ucs.tvcall.ocx.presence;

import com.zte.ucs.tvcall.ocx.ResultInfo;

/* loaded from: classes2.dex */
public class PresCheckDocCallbackInfo {
    private PresDocumentInfoNode[] respobjarray;
    private ResultInfo resultInfo;
    private String sessionID = "";

    public PresDocumentInfoNode[] getRespobjarray() {
        return this.respobjarray;
    }

    public ResultInfo getResultInfo() {
        return this.resultInfo;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public void setRespobjarray(PresDocumentInfoNode[] presDocumentInfoNodeArr) {
        if (presDocumentInfoNodeArr != null) {
            this.respobjarray = (PresDocumentInfoNode[]) presDocumentInfoNodeArr.clone();
        }
    }

    public void setResultInfo(ResultInfo resultInfo) {
        this.resultInfo = resultInfo;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }
}
