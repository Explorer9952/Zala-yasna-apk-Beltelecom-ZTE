package com.zte.servicesdk.util;

import android.text.TextUtils;
import com.tencent.mm.sdk.contact.RContact;
import com.video.androidsdk.common.AES;
import com.video.androidsdk.common.Base64Encoder;
import com.video.androidsdk.common.config.ClientRequest;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.common.util.security.DES;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.zte.iptvclient.common.uiframe.h;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class SDKUtil {
    private static final String LOG_TAG = "SDKUtil";
    private static final String charsetName = "UTF-8";
    private static int iRequestCountForBMS;

    public static String booleanToString(boolean z) {
        return z ? "1" : "0";
    }

    public static String encryption3DES(String str) {
        byte[] bArr;
        try {
            bArr = DES.encrypt(AES.getEncryptKey("threeDESKey").getBytes("ASCII"), str.getBytes("UTF-8"), DES.ALGORITHM_TRIPLE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        return Base64Encoder.encode(bArr);
    }

    public static String generateAuthenticator(String str, String str2, String str3, StringBuilder sb) {
        byte[] bArr;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(RContact.FAVOUR_CONTACT_SHOW_HEAD_CHAR);
        sb2.append(str2);
        sb2.append(RContact.FAVOUR_CONTACT_SHOW_HEAD_CHAR);
        sb2.append(str3);
        LogEx.d(LOG_TAG, "EncodeKey: " + ((Object) sb2));
        while (sb.length() < 24) {
            sb.append("0");
        }
        try {
            bArr = DES.encrypt(sb.toString().getBytes("ASCII"), sb2.toString().getBytes("UTF-8"), DES.ALGORITHM_TRIPLE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        return Base64Encoder.encode(bArr);
    }

    public static String getBMSUrl(ClientRequest clientRequest) {
        String serverUrl = clientRequest.getServerUrl();
        if (StringUtil.isEmptyString(serverUrl)) {
            return "";
        }
        if (serverUrl.contains("{ipadd:port}")) {
            String readPropertie = h.readPropertie("DivideServicePage");
            if (readPropertie == null) {
                return "";
            }
            serverUrl = serverUrl.replace("{ipadd:port}", readPropertie);
        }
        LogEx.d(LOG_TAG, "url is " + serverUrl);
        return serverUrl;
    }

    public static String getIMPAddress() {
        String propertiesInfo = SDKLoginMgr.getInstance().getPropertiesInfo("IMP_Server");
        if (TextUtils.isEmpty(propertiesInfo)) {
            LogEx.d(LOG_TAG, "IMP IP and Port are set in ini.");
            propertiesInfo = h.readPropertie("IMP_Server");
        }
        return !TextUtils.isEmpty(propertiesInfo) ? propertiesInfo : "";
    }

    public static String getNewUrl(ClientRequest clientRequest) {
        String serverUrl = clientRequest.getServerUrl();
        if (StringUtil.isEmptyString(serverUrl)) {
            return "";
        }
        if (serverUrl.contains("{frame}")) {
            String userInfo = SDKLoginMgr.getInstance().getUserInfo("StypeUrl");
            if (userInfo == null) {
                return "";
            }
            serverUrl = serverUrl.replace("{frame}", userInfo);
        }
        LogEx.d(LOG_TAG, "frame is " + SDKLoginMgr.getInstance().getUserInfo("StypeUrl"));
        return serverUrl;
    }

    public static String getPortalConfig(String str) {
        if (StringUtil.isEmptyString(str)) {
            LogEx.w(LOG_TAG, "strConfigName is null!");
            return "";
        }
        LogEx.d(LOG_TAG, "strConfigName = " + str);
        String propertiesInfo = SDKLoginMgr.getInstance().getPropertiesInfo(str);
        if (propertiesInfo == null) {
            LogEx.w(LOG_TAG, "get columncode failed,strConfigName:" + str);
            return "";
        }
        LogEx.d(LOG_TAG, "strValue = " + propertiesInfo);
        return propertiesInfo;
    }

    public static HashMap<String, Object> jsonToHashMap(String str, List<Map<String, Object>> list) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        return toHashMap(jSONObject, list);
    }

    public static boolean stringToBooleanOf0IsTrue(String str) {
        return !StringUtil.isEmptyString(str) && str.equals("0");
    }

    public static boolean stringToBooleanOf1IsTrue(String str) {
        return !StringUtil.isEmptyString(str) && str.equals("1");
    }

    private static HashMap<String, Object> toHashMap(JSONObject jSONObject, List<Map<String, Object>> list) {
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
                            LogEx.d(LOG_TAG, "data is leghth: " + jSONArray.length());
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
                                    toHashMap((JSONObject) obj3, arrayList);
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

    public static String generateAuthenticator(String... strArr) {
        byte[] bArr;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strArr.length; i++) {
            if (i == 0) {
                stringBuffer.append(strArr[i]);
            } else {
                stringBuffer.append(RContact.FAVOUR_CONTACT_SHOW_HEAD_CHAR);
                stringBuffer.append(strArr[i]);
            }
        }
        LogEx.d(LOG_TAG, "strBuffer =" + ((Object) stringBuffer));
        StringBuilder sb = new StringBuilder(AES.getEncryptKey("threeDESKey"));
        while (sb.length() < 24) {
            sb.append("0");
        }
        try {
            bArr = DES.encrypt(sb.toString().getBytes("ASCII"), stringBuffer.toString().getBytes("UTF-8"), DES.ALGORITHM_TRIPLE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        return Base64Encoder.encode(bArr);
    }
}
