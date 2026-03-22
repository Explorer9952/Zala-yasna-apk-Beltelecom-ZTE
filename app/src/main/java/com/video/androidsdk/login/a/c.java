package com.video.androidsdk.login.a;

import android.text.TextUtils;
import com.video.androidsdk.common.AES;
import com.video.androidsdk.common.util.TimeUtil;
import com.video.androidsdk.log.LogEx;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SDKUtil.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static int f3148a;

    public static String a(String str, String str2) {
        return a(str, str2, null);
    }

    public static String b(String str, String str2, String str3) {
        String str4 = str + "$$";
        if (!TextUtils.isEmpty(str2)) {
            str4 = str4 + str2 + "$$";
        }
        if (!TextUtils.isEmpty(str3)) {
            str4 = str4 + str3 + "$$";
        }
        try {
            return AES.aesEncryptByBase64(((str4 + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis())) + "$$") + AES.randomString(10)).getBytes(), com.video.androidsdk.license.a.a("communitykey").getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String a(String str, String str2, String str3) {
        String str4;
        Calendar calendar = Calendar.getInstance();
        calendar.add(11, 1);
        String str5 = (str + "$$") + (Long.toHexString(calendar.getTimeInMillis() / 1000) + "$$");
        if (str2 != null) {
            str5 = str5 + str2 + "$$";
        }
        if (!TextUtils.isEmpty(str3)) {
            str5 = str5 + str3 + "$$";
        }
        String str6 = str5 + AES.randomString(10);
        byte[] bytes = str6.getBytes();
        String a2 = com.video.androidsdk.license.a.a("impkey");
        LogEx.d("SDKUtil", "key: " + a2 + " authString: " + str6 + " result:" + Arrays.toString(bytes));
        try {
            str4 = AES.aesEncryptByBase64(bytes, a2.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            str4 = "";
        }
        String str7 = str4 != null ? str4 : "";
        LogEx.d("encryptionAES", "encriptStr: " + str7);
        return str7;
    }

    public static String b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.add(11, 1);
        String str3 = (str + "$$") + Integer.toHexString(calendar.get(13)) + "$$";
        if (!TextUtils.isEmpty(str2)) {
            str3 = str3 + str2 + "$$";
        }
        byte[] bytes = (str3 + AES.randomString(10)).getBytes();
        StringBuffer stringBuffer = new StringBuffer(str);
        while (stringBuffer.length() < 16) {
            stringBuffer.append("0");
        }
        try {
            return AES.aesEncryptByBase64(bytes, stringBuffer.toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static HashMap<String, Object> a(JSONObject jSONObject, List<Map<String, Object>> list) {
        Object obj;
        HashMap<String, Object> hashMap = new HashMap<>();
        if (jSONObject != null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String valueOf = String.valueOf(keys.next());
                    if (jSONObject.get(valueOf) instanceof JSONArray) {
                        JSONArray jSONArray = jSONObject.getJSONArray(valueOf);
                        obj = null;
                        if (jSONArray != null && jSONArray.length() != 0) {
                            LogEx.d("SDKUtil", "data is leghth: " + jSONArray.length());
                            int i = 0;
                            Object obj2 = null;
                            while (i < jSONArray.length()) {
                                if (list.size() < jSONArray.length()) {
                                    list.add(null);
                                }
                                HashMap hashMap2 = (HashMap) list.get(i);
                                if (hashMap2 == null) {
                                    hashMap2 = new HashMap();
                                }
                                Object obj3 = jSONArray.get(i);
                                if (obj3 instanceof JSONObject) {
                                    ArrayList arrayList = new ArrayList();
                                    a((JSONObject) obj3, arrayList);
                                    hashMap2.put(valueOf, arrayList);
                                } else {
                                    hashMap2.put(valueOf, obj3);
                                }
                                list.set(i, hashMap2);
                                i++;
                                obj2 = obj3;
                            }
                            obj = obj2;
                        }
                    } else {
                        obj = (String) jSONObject.get(valueOf);
                    }
                    hashMap.put(valueOf, obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return hashMap;
    }

    public static HashMap<String, Object> a(String str, List<Map<String, Object>> list) {
        if (TextUtils.isEmpty(str)) {
            return new HashMap<>();
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return a(jSONObject, list);
    }

    public static String a(String str) {
        try {
            return AES.aesEncryptByBase64((str + "$$" + TimeUtil.formatUTC(new Date(), "yyyyMMddHHmmss") + "$$" + AES.randomString(6)).getBytes(), AES.getEncryptKey("1.0_login").getBytes());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }
}
