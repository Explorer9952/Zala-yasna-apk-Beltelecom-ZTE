package com.video.androidsdk.common;

import com.video.androidsdk.common.util.SecurityUtil;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class BaseResponse implements Serializable {
    private static final long serialVersionUID = 1;
    private int miResultCode = 0;
    private String mstrErrorMsg = "";
    private Map<String, Object> mmapResponseHeadData = new HashMap();
    private List<Map<String, Object>> mlistResponseData = null;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        SecurityUtil.securityCheck(objectInputStream.toString(), "read");
        this.miResultCode = objectInputStream.read();
        this.mstrErrorMsg = objectInputStream.readUTF();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        SecurityUtil.securityCheck(objectOutputStream.toString(), "write");
        objectOutputStream.write(this.miResultCode);
        objectOutputStream.writeChars(this.mstrErrorMsg);
        objectOutputStream.writeObject(this.mlistResponseData);
    }

    public String getErrorMsg() {
        return this.mstrErrorMsg;
    }

    public List<Map<String, Object>> getResponseDataList() {
        return this.mlistResponseData;
    }

    public Map<String, Object> getResponseHeadData() {
        return this.mmapResponseHeadData;
    }

    public int getResultCode() {
        return this.miResultCode;
    }

    public void setErrorMsg(String str) {
        this.mstrErrorMsg = str;
    }

    public void setResponseDataList(List<Map<String, Object>> list) {
        this.mlistResponseData = list;
    }

    public void setResponseHeadData(Map<String, Object> map) {
        this.mmapResponseHeadData = map;
    }

    public void setResultCode(int i) {
        this.miResultCode = i;
    }

    public String toString() {
        return "ResultCode=" + this.miResultCode + "; m_strErrorMsg=" + this.mstrErrorMsg + "; listResponseData=" + this.mlistResponseData;
    }
}
