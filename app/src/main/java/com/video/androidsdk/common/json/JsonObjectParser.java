package com.video.androidsdk.common.json;

import com.video.androidsdk.log.LogEx;
import java.lang.reflect.Array;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class JsonObjectParser {
    private static final String LOG_TAG = "JsonObjectParser";

    public static Object reflectBean(String str, Class<?> cls) {
        if (str != null && cls != null) {
            if (String.class == cls) {
                return str;
            }
            try {
                if (Integer.TYPE == cls) {
                    return Integer.valueOf(Integer.parseInt(str));
                }
                if (Long.TYPE == cls) {
                    return Long.valueOf(Long.parseLong(str));
                }
                if (Double.TYPE == cls) {
                    return Double.valueOf(Double.parseDouble(str));
                }
                if (Float.TYPE == cls) {
                    return Float.valueOf(Float.parseFloat(str));
                }
                if (Integer.class == cls) {
                    return Integer.valueOf(str);
                }
                if (Long.class == cls) {
                    return Long.valueOf(str);
                }
                if (Double.class == cls) {
                    return Double.valueOf(str);
                }
                if (Float.class == cls) {
                    return Float.valueOf(str);
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    LogEx.d(LOG_TAG, "Try to reflect json " + str + " to " + cls.getName());
                    return reflectBean(jSONObject, cls);
                } catch (JSONException e) {
                    LogEx.w(LOG_TAG, "Not Json - " + e.getMessage() + ":" + str);
                    return null;
                }
            } catch (NumberFormatException e2) {
                LogEx.w(LOG_TAG, "Foramt " + str + " to " + cls.getName() + " error." + e2.getMessage());
            }
        }
        return null;
    }

    protected static Object reflectBean(JSONObject jSONObject, Class<?> cls) {
        if (jSONObject != null && cls != null) {
            try {
                return reflectBean(jSONObject, cls, cls.newInstance());
            } catch (IllegalAccessException e) {
                LogEx.w(LOG_TAG, "New " + cls.getName() + " Instance failed. " + e.getMessage());
                return null;
            } catch (InstantiationException e2) {
                LogEx.w(LOG_TAG, "New " + cls.getName() + " Instance failed. " + e2.getMessage());
            }
        }
        return null;
    }

    protected static Object reflectBean(JSONArray jSONArray, Class<?> cls) {
        if (jSONArray == null || cls == null || !cls.isArray()) {
            return null;
        }
        return reflectBean(jSONArray, cls, Array.newInstance(cls.getComponentType(), jSONArray.length()));
    }

    private static Object reflectBean(JSONArray jSONArray, Class<?> cls, Object obj) {
        if (obj == null || obj.getClass() != cls) {
            return null;
        }
        int length = jSONArray.length();
        Class<?> componentType = cls.getComponentType();
        int i = 0;
        if (componentType.isArray()) {
            while (i < length) {
                try {
                    Array.set(obj, i, reflectBean(jSONArray.getJSONArray(i), componentType));
                } catch (IllegalArgumentException e) {
                    LogEx.w(LOG_TAG, cls.getName() + " argument not expected. " + e.getMessage());
                } catch (JSONException e2) {
                    LogEx.w(LOG_TAG, "Parse json " + cls.getName() + " not expected. " + e2.getMessage());
                }
                i++;
            }
        } else {
            while (i < length) {
                try {
                    Array.set(obj, i, reflectBean(jSONArray.getJSONObject(i), componentType));
                } catch (IllegalArgumentException e3) {
                    LogEx.w(LOG_TAG, cls.getName() + " argument not expected. " + e3.getMessage());
                } catch (JSONException e4) {
                    LogEx.w(LOG_TAG, "Parse json " + cls.getName() + " not expected. " + e4.getMessage());
                }
                i++;
            }
        }
        return obj;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:(1:120)(4:29|30|31|(1:33)(9:98|(4:100|(5:102|103|104|105|106)|111|112)(2:113|(1:115))|40|41|42|43|44|45|(3:47|48|49)))|34|35|(2:37|(1:39))(2:75|(2:77|(1:79))(2:80|(2:82|(1:84))(1:(2:86|(1:88))(2:89|(2:91|92)))))|40|41|42|43|44|45|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0134, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0139, code lost:
    
        r7 = r10.substring(r5, 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0145, code lost:
    
        if (r7.equals(r7.toUpperCase()) != false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0147, code lost:
    
        com.video.androidsdk.log.LogEx.w(com.video.androidsdk.common.json.JsonObjectParser.LOG_TAG, "Set " + r10 + " failed! Ignore." + r0.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01b7, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x017e, code lost:
    
        r0 = r20.getMethod("set" + (r7.toUpperCase() + r10.substring(1)), r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0198, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0199, code lost:
    
        com.video.androidsdk.log.LogEx.w(com.video.androidsdk.common.json.JsonObjectParser.LOG_TAG, "Set " + r10 + " failed! Ignore." + r0.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0136, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0137, code lost:
    
        r5 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.Object reflectBean(org.json.JSONObject r19, java.lang.Class<?> r20, java.lang.Object r21) {
        /*
            Method dump skipped, instructions count: 1021
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.video.androidsdk.common.json.JsonObjectParser.reflectBean(org.json.JSONObject, java.lang.Class, java.lang.Object):java.lang.Object");
    }
}
