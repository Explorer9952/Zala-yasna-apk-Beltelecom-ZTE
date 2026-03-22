package com.video.androidsdk.common.json;

import com.video.androidsdk.log.LogEx;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/* loaded from: classes.dex */
public class BeanReflectJSON {
    private static final String LOG_TAG = "BeanReflectJSON";
    protected Vector<String> memberMap = new Vector<>();

    public String bean2JSON(Object obj) {
        if (obj == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(reflect(obj));
        if (",".equals(sb.substring(sb.length() - 1))) {
            sb.replace(sb.length() - 1, sb.length(), "");
        }
        sb.append("}");
        return sb.toString();
    }

    protected String reflect(Class<?> cls, Map<String, Object> map) {
        Field[] fieldArr;
        Object obj;
        boolean z;
        BeanReflectJSON beanReflectJSON = this;
        if (cls == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (Object.class != cls && String.class != cls && !cls.isPrimitive() && !Number.class.isAssignableFrom(cls)) {
            if (cls.getSuperclass() != null && Object.class != cls.getSuperclass()) {
                sb.append(beanReflectJSON.reflect((Class<?>) cls.getSuperclass(), map));
            }
            Field[] declaredFields = cls.getDeclaredFields();
            int length = declaredFields.length;
            int i = 0;
            while (i < length) {
                Field field = declaredFields[i];
                String name = field.getName();
                if (!beanReflectJSON.memberMap.contains(name)) {
                    beanReflectJSON.memberMap.add(name);
                    if (!name.startsWith("_$_")) {
                        sb.append("\"");
                        sb.append(name);
                        sb.append("\":");
                        Class<?> type = field.getType();
                        if (type.isArray() && map != null) {
                            sb.append("{");
                            Object obj2 = map.get(name);
                            if (obj2 == null) {
                                fieldArr = declaredFields;
                            } else if (obj2 instanceof List) {
                                List list = (List) map.get(name);
                                if (list != null) {
                                    for (Object obj3 : list) {
                                        if (!(obj3 instanceof Map)) {
                                            fieldArr = declaredFields;
                                            z = false;
                                            break;
                                        }
                                        sb.append(new BeanReflectJSON().reflect(type.getComponentType(), (Map<String, Object>) obj3));
                                        declaredFields = declaredFields;
                                    }
                                }
                                fieldArr = declaredFields;
                                z = true;
                                if (!z) {
                                    LogEx.w(LOG_TAG, "ValuesMap is not expected Instances of List<Map<String, Object>>");
                                }
                            } else {
                                fieldArr = declaredFields;
                                LogEx.w(LOG_TAG, "ValuesMap is not expected Instances of List<Map<String, Object>>");
                            }
                            if (",".equals(sb.substring(sb.length() - 1))) {
                                sb.replace(sb.length() - 1, sb.length(), "");
                            }
                            sb.append("},");
                        } else {
                            fieldArr = declaredFields;
                            if (!type.isPrimitive() && String.class != type && !Number.class.isAssignableFrom(type)) {
                                sb.append("{");
                                if (map != null) {
                                    Object obj4 = map.get(name);
                                    if (obj4 != null) {
                                        if (obj4 instanceof Map) {
                                            try {
                                                sb.append(new BeanReflectJSON().reflect(type, (Map<String, Object>) map.get(name)));
                                            } catch (ClassCastException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    } else {
                                        sb.append(new BeanReflectJSON().reflect(type, (Map<String, Object>) null));
                                    }
                                } else {
                                    sb.append(new BeanReflectJSON().reflect(type, (Map<String, Object>) null));
                                }
                                if (",".equals(sb.substring(sb.length() - 1))) {
                                    sb.replace(sb.length() - 1, sb.length(), "");
                                }
                                sb.append("},");
                            } else {
                                sb.append("\"");
                                if (map != null && (obj = map.get(name)) != null) {
                                    sb.append(obj.toString());
                                }
                                sb.append("\",");
                            }
                        }
                        i++;
                        beanReflectJSON = this;
                        declaredFields = fieldArr;
                    }
                }
                fieldArr = declaredFields;
                i++;
                beanReflectJSON = this;
                declaredFields = fieldArr;
            }
            return sb.toString();
        }
        if (map != null) {
            Iterator<Map.Entry<String, Object>> it2 = map.entrySet().iterator();
            while (it2.hasNext()) {
                Object value = it2.next().getValue();
                if (value != null) {
                    sb.append("\"");
                    sb.append(value.toString());
                    sb.append("\",");
                }
            }
        } else {
            sb.append("\"\",");
        }
        return sb.toString();
    }

    public String bean2JSON(Class<?> cls, Map<String, Object> map) {
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

    protected String reflect(Object obj) {
        if (obj == null) {
            return "";
        }
        Class<?> cls = obj.getClass();
        StringBuilder sb = new StringBuilder();
        if (!cls.isPrimitive() && !Number.class.isAssignableFrom(cls) && String.class != cls && Object.class != cls) {
            return reflect(cls, obj);
        }
        sb.append("\"");
        sb.append(cls.getSimpleName());
        sb.append("\":\"");
        sb.append(obj.toString());
        sb.append("\",");
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0318  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected java.lang.String reflect(java.lang.Class<?> r23, java.lang.Object r24) {
        /*
            Method dump skipped, instructions count: 1029
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.video.androidsdk.common.json.BeanReflectJSON.reflect(java.lang.Class, java.lang.Object):java.lang.String");
    }
}
