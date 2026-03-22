package com.video.androidsdk.common.json;

import com.video.androidsdk.log.LogEx;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Vector;

/* loaded from: classes.dex */
public class LightBeanReflectJSON {
    private static final String LOG_TAG = "LightBeanReflectJSON";
    protected Vector<String> memberMap = new Vector<>();

    public String bean2JSON(Class<?> cls, Map<String, String> map) {
        if (cls == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(reflect(cls, map));
        if (",".equals(sb.substring(sb.length() - 1))) {
            sb.replace(sb.length() - 1, sb.length(), "");
        }
        sb.append("}");
        return sb.toString();
    }

    protected String reflect(Class<?> cls, Map<String, String> map) {
        String str;
        if (cls != null) {
            if (Object.class != cls && String.class != cls && !cls.isPrimitive() && !Number.class.isAssignableFrom(cls)) {
                StringBuilder sb = new StringBuilder();
                if (cls.getSuperclass() != null && Object.class != cls.getSuperclass()) {
                    sb.append(reflect(cls.getSuperclass(), map));
                }
                for (Field field : cls.getDeclaredFields()) {
                    String name = field.getName();
                    if (!this.memberMap.contains(name)) {
                        this.memberMap.add(name);
                        if (!name.startsWith("_$_")) {
                            Class<?> type = field.getType();
                            if (type.isArray()) {
                                LogEx.w(LOG_TAG, "Field \"" + field.getName() + "\" is array. Ignore.");
                            } else if (!type.isPrimitive() && String.class != type && !Number.class.isAssignableFrom(type)) {
                                LogEx.w(LOG_TAG, "Field \"" + field.getName() + "\" is " + type + ". Only support java.lang.String.");
                            } else {
                                sb.append("\"");
                                sb.append(name);
                                sb.append("\":");
                                sb.append("\"");
                                if (map != null && (str = map.get(name)) != null) {
                                    sb.append(str.toString());
                                }
                                sb.append("\",");
                            }
                        }
                    }
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
