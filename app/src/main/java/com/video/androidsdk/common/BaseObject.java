package com.video.androidsdk.common;

import java.util.Date;

/* loaded from: classes.dex */
public class BaseObject {
    private Date m_tmCreateTime;

    public BaseObject() {
        this.m_tmCreateTime = null;
        this.m_tmCreateTime = new Date();
    }

    public static boolean isInterface(Class cls, Class cls2) {
        if (cls != null && cls2 != null) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i = 0; i < length; i++) {
                if (interfaces[i].equals(cls2)) {
                    return true;
                }
                Class<?>[] interfaces2 = interfaces[i].getInterfaces();
                for (int i2 = 0; i2 < interfaces2.length; i2++) {
                    if (interfaces2[i2].equals(cls2) || isInterface(interfaces2[i2], cls2)) {
                        return true;
                    }
                }
            }
            if (cls.getSuperclass() != null) {
                return isInterface(cls.getSuperclass(), cls2);
            }
        }
        return false;
    }

    public Date getObjectCreateTime() {
        return this.m_tmCreateTime;
    }
}
