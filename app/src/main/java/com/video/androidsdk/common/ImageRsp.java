package com.video.androidsdk.common;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* loaded from: classes.dex */
public class ImageRsp extends BaseResponse {
    private String m_strLocalPath = null;
    private int m_iSize = 0;
    private String strCode = null;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
    }

    public String getLocalPath() {
        return this.m_strLocalPath;
    }

    public int getSize() {
        return this.m_iSize;
    }

    public String getStrCode() {
        return this.strCode;
    }

    public void setLocalPath(String str) {
        this.m_strLocalPath = str;
    }

    public void setSize(int i) {
        this.m_iSize = i;
    }

    public void setStrCode(String str) {
        this.strCode = str;
    }
}
