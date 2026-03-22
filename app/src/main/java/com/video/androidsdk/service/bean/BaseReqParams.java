package com.video.androidsdk.service.bean;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class BaseReqParams {
    public HashMap<String, String> toHashMap() {
        HashMap<String, String> hashMap = new HashMap<>();
        Class<?> cls = getClass();
        ArrayList arrayList = new ArrayList();
        do {
            arrayList.add(cls);
            cls = cls.getSuperclass();
        } while (!cls.equals(Object.class));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            for (Field field : ((Class) it2.next()).getDeclaredFields()) {
                Object obj = null;
                field.setAccessible(true);
                try {
                    obj = field.get(this);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                }
                if (obj != null) {
                    hashMap.put(field.getName(), String.valueOf(obj));
                }
            }
        }
        return hashMap;
    }
}
