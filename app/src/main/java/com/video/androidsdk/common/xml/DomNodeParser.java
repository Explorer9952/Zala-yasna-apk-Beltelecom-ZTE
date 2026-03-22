package com.video.androidsdk.common.xml;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class DomNodeParser {
    private static final String LOG_TAG = "DomNodeParser";
    Set<String> mClildSet = new HashSet();

    protected Field getFiled(Class<?> cls, String str) {
        if (cls == null || str == null || str.trim().length() == 0) {
            return null;
        }
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            if (Object.class != cls.getSuperclass()) {
                return getFiled(cls.getSuperclass(), str);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:121:0x047f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x021c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x03e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object reflectBean(org.w3c.dom.Element r21, java.lang.Class<?> r22) {
        /*
            Method dump skipped, instructions count: 1239
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.video.androidsdk.common.xml.DomNodeParser.reflectBean(org.w3c.dom.Element, java.lang.Class):java.lang.Object");
    }
}
