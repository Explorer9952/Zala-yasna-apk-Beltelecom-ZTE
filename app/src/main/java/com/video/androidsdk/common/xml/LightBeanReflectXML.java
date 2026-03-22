package com.video.androidsdk.common.xml;

import com.video.androidsdk.log.LogEx;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Vector;

/* loaded from: classes.dex */
public class LightBeanReflectXML {
    private static final String LOG_TAG = "LightBeanReflectXML";
    protected Vector<String> memberMap = new Vector<>();

    public String bean2XML(Class<?> cls, Map<String, String> map) {
        if (cls == null) {
            return null;
        }
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + reflect(cls, true, map);
    }

    protected String reflect(Class<?> cls, boolean z, Map<String, String> map) {
        String str;
        if (cls != null) {
            if (Object.class != cls && String.class != cls && !cls.isPrimitive() && !Number.class.isAssignableFrom(cls)) {
                StringBuilder sb = new StringBuilder();
                if (z) {
                    sb.append("<");
                    sb.append(cls.getSimpleName());
                    sb.append(">");
                }
                if (cls.getSuperclass() != null && Object.class != cls.getSuperclass()) {
                    sb.append(reflect(cls.getSuperclass(), false, map));
                }
                for (Field field : cls.getDeclaredFields()) {
                    String name = field.getName();
                    if (!this.memberMap.contains(name)) {
                        this.memberMap.add(name);
                        if (!name.startsWith("_$_") && !name.contains("_$$_")) {
                            Class<?> type = field.getType();
                            if (type.isArray()) {
                                LogEx.w(LOG_TAG, "Field \"" + field.getName() + "\" is array. Ignore.");
                            } else if (!type.isPrimitive() && String.class != type && Integer.class != type && Double.class != type && Float.class != type && Short.class != type && Long.class != type) {
                                LogEx.w(LOG_TAG, "Field \"" + field.getName() + "\" is " + type + ". Only support java.lang.String.");
                            } else {
                                sb.append("<");
                                sb.append(name);
                                sb.append(">");
                                if (map != null && (str = map.get(name)) != null) {
                                    sb.append(str);
                                }
                                sb.append("</");
                                sb.append(name);
                                sb.append(">");
                            }
                        }
                    }
                }
                if (z) {
                    sb.append("</");
                    sb.append(cls.getSimpleName());
                    sb.append(">");
                }
                return sb.toString();
            }
            LogEx.w(LOG_TAG, "Class not support:" + cls.getName());
            return "";
        }
        LogEx.w(LOG_TAG, "Class is null.");
        return "";
    }
}
