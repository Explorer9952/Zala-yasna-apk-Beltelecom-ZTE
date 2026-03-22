package com.video.androidsdk.common;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* loaded from: classes.dex */
public class ImageReq extends BaseRequest {
    private String m_strImageUrl = null;

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
    }

    @Override // com.video.androidsdk.common.BaseRequest
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public String getImageUrl() {
        return this.m_strImageUrl;
    }

    @Override // com.video.androidsdk.common.BaseRequest
    public int hashCode() {
        return super.hashCode();
    }

    public void setImageUrl(String str) {
        this.m_strImageUrl = str;
    }
}
