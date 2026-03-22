package com.video.androidsdk.common.xml;

import com.video.androidsdk.log.LogEx;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/* loaded from: classes.dex */
public class BeanReflectXML {
    private static final String LOG_TAG = "BeanReflectXML";
    protected Vector<String> memberMap = new Vector<>();

    public String bean2XML(Class<?> cls, Map<String, Object> map) {
        if (cls == null) {
            return null;
        }
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + reflect(cls, true, map);
    }

    protected String reflect(Class<?> cls, boolean z, Map<String, Object> map) {
        Object obj;
        if (cls == null || Object.class == cls) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("<");
            sb.append(cls.getSimpleName());
            sb.append(">");
        }
        if (cls.getSuperclass() != null && Object.class != cls.getSuperclass()) {
            sb.append(reflect((Class<?>) cls.getSuperclass(), false, map));
        }
        for (Field field : cls.getDeclaredFields()) {
            String name = field.getName();
            if (!this.memberMap.contains(name)) {
                this.memberMap.add(name);
                if (!name.startsWith("_$_") && !name.contains("_$$_")) {
                    Class<?> type = field.getType();
                    boolean z2 = true;
                    if (type.isArray() && map != null) {
                        Object obj2 = map.get(name);
                        if (obj2 != null) {
                            if (obj2 instanceof List) {
                                List list = (List) map.get(name);
                                if (list != null) {
                                    Iterator it2 = list.iterator();
                                    while (true) {
                                        if (!it2.hasNext()) {
                                            break;
                                        }
                                        Object next = it2.next();
                                        if (!(next instanceof Map)) {
                                            z2 = false;
                                            break;
                                        }
                                        sb.append(new BeanReflectXML().reflect(type.getComponentType(), true, (Map<String, Object>) next));
                                    }
                                }
                                if (!z2) {
                                    LogEx.w(LOG_TAG, "ValuesMap is not expected Instances of List<Map<String, Object>>");
                                }
                            } else {
                                LogEx.w(LOG_TAG, "ValuesMap is not expected Instances of List<Map<String, Object>>");
                            }
                        }
                    } else if (type.isPrimitive() || String.class == type || Number.class.isAssignableFrom(type)) {
                        sb.append("<");
                        sb.append(name);
                        sb.append(">");
                        if (map != null && (obj = map.get(name)) != null) {
                            sb.append(obj.toString());
                        }
                        sb.append("</");
                        sb.append(name);
                        sb.append(">");
                    } else if (map != null) {
                        Object obj3 = map.get(name);
                        if (obj3 != null && (obj3 instanceof Map)) {
                            sb.append(new BeanReflectXML().reflect(type, true, (Map<String, Object>) map.get(name)));
                        }
                    } else {
                        sb.append(new BeanReflectXML().reflect(type, true, (Map<String, Object>) null));
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

    protected String reflect(Class<?> cls, boolean z, Object obj) {
        int i;
        if (cls == null || Object.class == cls) {
            return "";
        }
        if (cls.isPrimitive() || Number.class.isAssignableFrom(cls)) {
            if (obj == null) {
                return "";
            }
            if (!obj.getClass().isPrimitive() && !Number.class.isAssignableFrom(cls)) {
                LogEx.w(LOG_TAG, "Values type unsupported. Expected " + cls.getSimpleName());
                return "";
            }
            return obj.toString();
        }
        StringBuilder sb = new StringBuilder();
        if (String.class == cls) {
            sb.append("<");
            sb.append(cls.getSimpleName());
            sb.append(">");
            if (obj != null) {
                sb.append(obj.toString());
            }
            sb.append("</");
            sb.append(cls.getSimpleName());
            sb.append(">");
            return sb.toString();
        }
        if (z) {
            sb.append("<");
            sb.append(cls.getSimpleName());
            sb.append(">");
        }
        int i2 = 0;
        if (cls.getSuperclass() != null && Object.class != cls.getSuperclass()) {
            sb.append(reflect((Class<?>) cls.getSuperclass(), false, obj));
        }
        Field[] declaredFields = cls.getDeclaredFields();
        if (obj == null) {
            int length = declaredFields.length;
            while (i2 < length) {
                Field field = declaredFields[i2];
                String name = field.getName();
                if (!this.memberMap.contains(name)) {
                    this.memberMap.add(name);
                    if (!name.startsWith("_$_") && !name.contains("_$$_")) {
                        Class<?> type = field.getType();
                        if (!type.isArray() && !Iterable.class.isAssignableFrom(type)) {
                            if (!type.isPrimitive() && String.class != type && !Number.class.isAssignableFrom(cls)) {
                                sb.append(new BeanReflectXML().reflect(type, true, (Map<String, Object>) null));
                            } else {
                                sb.append("<");
                                sb.append(name);
                                sb.append("/>");
                            }
                        }
                    }
                }
                i2++;
            }
        } else if (cls.isArray()) {
            if (obj.getClass().isArray()) {
                Class<?> componentType = obj.getClass().getComponentType();
                int length2 = Array.getLength(obj);
                while (i2 < length2) {
                    sb.append(new BeanReflectXML().reflect(componentType, true, Array.get(obj, i2)));
                    i2++;
                }
            } else {
                LogEx.w(LOG_TAG, "Values type unsupported. Expected array");
            }
        } else if (Iterable.class.isAssignableFrom(cls)) {
            if (Iterable.class.isAssignableFrom(obj.getClass())) {
                for (Object obj2 : (Iterable) obj) {
                    sb.append(new BeanReflectXML().reflect(obj2.getClass(), true, obj2));
                }
            } else {
                LogEx.w(LOG_TAG, "Values type unsupported. Expected " + cls.getSimpleName());
            }
        } else if (obj.getClass().isAssignableFrom(cls)) {
            if (obj.getClass().isArray()) {
                Class<?> componentType2 = obj.getClass().getComponentType();
                int length3 = Array.getLength(obj);
                while (i2 < length3) {
                    sb.append(new BeanReflectXML().reflect(componentType2, true, Array.get(obj, i2)));
                    i2++;
                }
            } else {
                int length4 = declaredFields.length;
                int i3 = 0;
                while (i3 < length4) {
                    Field field2 = declaredFields[i3];
                    String name2 = field2.getName();
                    if (this.memberMap.contains(name2) || name2.startsWith("_$_") || name2.contains("_$$_")) {
                        i = length4;
                    } else {
                        Class<?> type2 = field2.getType();
                        StringBuilder sb2 = new StringBuilder();
                        i = length4;
                        sb2.append(name2.substring(0, 1).toUpperCase());
                        sb2.append(name2.substring(1));
                        String sb3 = sb2.toString();
                        try {
                            try {
                                Object invoke = obj.getClass().getMethod("get" + sb3, new Class[0]).invoke(obj, new Object[0]);
                                if (invoke != null && invoke.getClass() == type2) {
                                    sb.append(new BeanReflectXML().reflect(type2, true, invoke));
                                } else {
                                    LogEx.w(LOG_TAG, "Values type unsupported. Expected " + type2);
                                }
                            } catch (IllegalAccessException e) {
                                e = e;
                                LogEx.w(LOG_TAG, "Values type unsupported." + e.getMessage());
                                i3++;
                                length4 = i;
                            } catch (IllegalArgumentException e2) {
                                e = e2;
                                LogEx.w(LOG_TAG, "Values type unsupported." + e.getMessage());
                                i3++;
                                length4 = i;
                            } catch (NoSuchMethodException e3) {
                                e = e3;
                                LogEx.w(LOG_TAG, "Values type unsupported." + e.getMessage());
                                i3++;
                                length4 = i;
                            } catch (InvocationTargetException e4) {
                                e = e4;
                                LogEx.w(LOG_TAG, "Values type unsupported." + e.getMessage());
                                i3++;
                                length4 = i;
                            }
                        } catch (IllegalAccessException e5) {
                            e = e5;
                        } catch (IllegalArgumentException e6) {
                            e = e6;
                        } catch (NoSuchMethodException e7) {
                            e = e7;
                        } catch (InvocationTargetException e8) {
                            e = e8;
                        }
                    }
                    i3++;
                    length4 = i;
                }
            }
        } else if (obj.getClass().isAssignableFrom(Map.class)) {
            Map map = (Map) obj;
            int length5 = declaredFields.length;
            while (i2 < length5) {
                Field field3 = declaredFields[i2];
                String name3 = field3.getName();
                if (!this.memberMap.contains(name3)) {
                    this.memberMap.add(name3);
                    if (!name3.startsWith("_$_") && !name3.contains("_$$_")) {
                        sb.append(new BeanReflectXML().reflect(field3.getType(), true, map.get(name3)));
                        i2++;
                    }
                }
                i2++;
            }
        } else {
            LogEx.w(LOG_TAG, "Values Collection type unsupported.");
        }
        if (z) {
            sb.append("</");
            sb.append(cls.getSimpleName());
            sb.append(">");
        }
        return sb.toString();
    }
}
