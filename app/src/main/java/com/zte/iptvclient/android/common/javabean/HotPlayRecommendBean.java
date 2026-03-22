package com.zte.iptvclient.android.common.javabean;

import com.video.androidsdk.log.LogEx;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes.dex */
public class HotPlayRecommendBean implements Serializable {
    private String error;
    private String errorMsg;
    private List<Object> programInfo;
    private String rec_num;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        LogEx.d(HotPlayRecommendBean.class.getName(), "readObject");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        LogEx.d(HotPlayRecommendBean.class.getName(), "writeObject");
    }

    public String getError() {
        return this.error;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public List<Object> getProgramInfo() {
        return this.programInfo;
    }

    public String getRec_num() {
        return this.rec_num;
    }

    public void setError(String str) {
        this.error = str;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setProgramInfo(List<Object> list) {
        this.programInfo = list;
    }

    public void setRec_num(String str) {
        this.rec_num = str;
    }
}
