package com.video.androidsdk.common;

import com.video.androidsdk.common.util.SecurityUtil;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;

/* loaded from: classes.dex */
public class NonidealDataException extends Exception {
    private static final long serialVersionUID = 8175101430779499399L;
    private Object m_value;

    public NonidealDataException() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws OptionalDataException, ClassNotFoundException, IOException {
        SecurityUtil.securityCheck(objectInputStream.toString(), "readObject");
        this.m_value = objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        SecurityUtil.securityCheck(objectOutputStream.toString(), "writeObject");
        objectOutputStream.writeObject(this.m_value);
    }

    public Object getValue() {
        return this.m_value;
    }

    public NonidealDataException(String str, Object obj) {
        super(str);
        this.m_value = obj;
    }
}
