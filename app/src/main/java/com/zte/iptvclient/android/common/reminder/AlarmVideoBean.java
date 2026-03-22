package com.zte.iptvclient.android.common.reminder;

import com.video.androidsdk.log.LogEx;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* loaded from: classes.dex */
public class AlarmVideoBean implements Serializable {
    private String columnCode;
    private String id;
    private String onLineTime;
    private String programCode;
    private String programName;
    private String programType;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        LogEx.d(AlarmVideoBean.class.getName(), "readObject");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        LogEx.d(AlarmVideoBean.class.getName(), "writeObject");
    }

    public String getColumnCode() {
        return this.columnCode;
    }

    public String getId() {
        return this.id;
    }

    public String getOnLineTime() {
        return this.onLineTime;
    }

    public String getProgramCode() {
        return this.programCode;
    }

    public String getProgramName() {
        return this.programName;
    }

    public String getProgramType() {
        return this.programType;
    }

    public void setColumnCode(String str) {
        this.columnCode = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setOnLineTime(String str) {
        this.onLineTime = str;
    }

    public void setProgramCode(String str) {
        this.programCode = str;
    }

    public void setProgramName(String str) {
        this.programName = str;
    }

    public void setProgramType(String str) {
        this.programType = str;
    }
}
