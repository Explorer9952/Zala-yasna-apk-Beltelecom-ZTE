package com.zte.iptvclient.android.common.javabean;

import com.video.androidsdk.log.LogEx;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* loaded from: classes.dex */
public class BrowserReturnBean implements Serializable {
    private String columnCode;
    private String contentType;
    private String programCode;
    private String seriesNumber;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        LogEx.d(BrowserReturnBean.class.getName(), "readObject");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        LogEx.d(BrowserReturnBean.class.getName(), "writeObject");
    }

    public String getColumnCode() {
        return this.columnCode;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getProgramCode() {
        return this.programCode;
    }

    public String getSeriesNumber() {
        return this.seriesNumber;
    }

    public void setColumnCode(String str) {
        this.columnCode = str;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public void setProgramCode(String str) {
        this.programCode = str;
    }

    public void setSeriesNumber(String str) {
        this.seriesNumber = str;
    }
}
