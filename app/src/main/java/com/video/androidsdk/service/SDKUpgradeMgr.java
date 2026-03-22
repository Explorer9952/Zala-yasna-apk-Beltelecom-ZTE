package com.video.androidsdk.service;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.video.androidsdk.common.ErrCode;
import com.video.androidsdk.common.ErrMessage;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.license.a;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.a.c;
import com.video.androidsdk.service.comm.ParamConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SDKUpgradeMgr {

    /* renamed from: c, reason: collision with root package name */
    private List<Map<String, Object>> f3417c;
    private String n;

    /* renamed from: a, reason: collision with root package name */
    private String f3415a = "";

    /* renamed from: b, reason: collision with root package name */
    private int f3416b = -1;

    /* renamed from: d, reason: collision with root package name */
    private Map<String, Integer> f3418d = null;
    private String e = "";
    private int f = 0;
    private String g = "";
    private Context h = null;
    private OnUpgradeInfoReturnListener i = null;
    private OnMoreAppsUpgradeInfoReturnListener j = null;
    private int k = -1;
    private int l = -1;
    private int m = -1;

    /* loaded from: classes.dex */
    public interface OnMoreAppsUpgradeInfoReturnListener {
        void onUpgradeInfoReturn(String str, String str2, Map<String, Integer> map);
    }

    /* loaded from: classes.dex */
    public interface OnUpgradeInfoReturnListener {
        void onUpgradeInfoReturn(String str, String str2, int i);
    }

    private SDKUpgradeMgr() {
        this.f3417c = null;
        this.f3417c = new ArrayList();
    }

    public static SDKUpgradeMgr createInstance() {
        return new SDKUpgradeMgr();
    }

    public static List<String> getDefaultResultFieldList() {
        if (!a.e) {
            LogEx.e("SDKUpgradeMgr", ErrMessage.LIC_INVALIDATE);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("RawData");
        return arrayList;
    }

    public void checkMoreAppsUpgrade(Context context, int i, String str, OnMoreAppsUpgradeInfoReturnListener onMoreAppsUpgradeInfoReturnListener) {
        if (!a.e) {
            LogEx.e("SDKUpgradeMgr", ErrMessage.LIC_INVALIDATE);
            return;
        }
        if (onMoreAppsUpgradeInfoReturnListener == null) {
            LogEx.w("SDKUpgradeMgr", "listener is null");
            return;
        }
        if (context == null) {
            onMoreAppsUpgradeInfoReturnListener.onUpgradeInfoReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_UPGRADE_MODELCODE, 3, 2)), ErrMessage.PARAM_IS_NULL, null);
            LogEx.w("SDKUpgradeMgr", "");
            return;
        }
        this.k = 2;
        this.h = context;
        this.m = i;
        this.j = onMoreAppsUpgradeInfoReturnListener;
        if (StringUtil.isEmptyString(str)) {
            OnMoreAppsUpgradeInfoReturnListener onMoreAppsUpgradeInfoReturnListener2 = this.j;
            if (onMoreAppsUpgradeInfoReturnListener2 != null) {
                onMoreAppsUpgradeInfoReturnListener2.onUpgradeInfoReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_UPGRADE_MODELCODE, 3, 2)), ErrMessage.PARAM_IS_NULL, null);
            }
            LogEx.w("SDKUpgradeMgr", "url is empty or versionName is null or AppId is null");
            return;
        }
        this.f3418d = new HashMap();
        if (this.f3415a.equals(str)) {
            a();
        } else {
            this.f3415a = str;
            a(str);
        }
    }

    public void checkUpgrade(String str, String str2, String str3, OnUpgradeInfoReturnListener onUpgradeInfoReturnListener) {
        if (!a.e) {
            LogEx.e("SDKUpgradeMgr", ErrMessage.LIC_INVALIDATE);
            return;
        }
        this.k = 0;
        this.i = onUpgradeInfoReturnListener;
        this.e = str2;
        this.g = str;
        if (!StringUtil.isEmptyString(str3) && !StringUtil.isEmptyString(this.e) && !StringUtil.isEmptyString(this.g)) {
            if (this.f3415a.equals(str3) && this.f3416b == 0) {
                OnUpgradeInfoReturnListener onUpgradeInfoReturnListener2 = this.i;
                if (onUpgradeInfoReturnListener2 == null || this.f3417c == null) {
                    return;
                }
                onUpgradeInfoReturnListener2.onUpgradeInfoReturn(String.valueOf(0), "", a(a(this.f3417c), this.e));
                return;
            }
            this.f3415a = str3;
            a(str3);
            return;
        }
        OnUpgradeInfoReturnListener onUpgradeInfoReturnListener3 = this.i;
        if (onUpgradeInfoReturnListener3 != null) {
            onUpgradeInfoReturnListener3.onUpgradeInfoReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_UPGRADE_MODELCODE, 2)), ErrMessage.PARAM_IS_NULL, -1);
        }
        LogEx.w("SDKUpgradeMgr", "url is empty or versionName is null or AppId is null");
    }

    public String getDescription(String str, String str2) {
        if (!a.e) {
            LogEx.e("SDKUpgradeMgr", ErrMessage.LIC_INVALIDATE);
            return null;
        }
        if (this.f3417c == null || StringUtil.isEmptyString(str2)) {
            LogEx.d("SDKUpgradeMgr", "no data response");
            return "";
        }
        int i = 0;
        while (true) {
            if (i >= this.f3417c.size()) {
                break;
            }
            if (str.equalsIgnoreCase((String) this.f3417c.get(i).get(ParamConst.UPDATE_VERSION_RSP_APPID))) {
                List list = (List) this.f3417c.get(i).get(ParamConst.UPDATE_VERSION_RSP_UPDATEINFO);
                if (list == null) {
                    return "";
                }
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (str2.equalsIgnoreCase((String) ((Map) list.get(i2)).get("lang"))) {
                        return (String) ((Map) list.get(i2)).get(ParamConst.UPDATE_VERSION_RSP_DESC);
                    }
                }
            } else {
                i++;
            }
        }
        return "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0047, code lost:
    
        r2 = new org.json.JSONObject(r2.optJSONArray(com.video.androidsdk.service.comm.ParamConst.UPDATE_VERSION_RSP_DIYINFO).optString(r6));
        r9 = r2.optJSONArray("lang");
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0060, code lost:
    
        if (r5 >= r9.length()) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x006a, code lost:
    
        if (android.text.TextUtils.equals(r10, r9.optString(r5)) == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0075, code lost:
    
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006c, code lost:
    
        r9 = r2.optJSONArray(r11).optString(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String getDiyInfo(java.lang.String r9, java.lang.String r10, java.lang.String r11) {
        /*
            r8 = this;
            java.lang.String r0 = "parse DiyInfo json error."
            java.lang.String r1 = ""
            boolean r2 = com.video.androidsdk.license.a.e
            java.lang.String r3 = "SDKUpgradeMgr"
            if (r2 != 0) goto L11
            java.lang.String r9 = "license invalidate"
            com.video.androidsdk.log.LogEx.e(r3, r9)
            r9 = 0
            return r9
        L11:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L7b org.json.JSONException -> L7d
            r2.<init>()     // Catch: java.lang.Exception -> L7b org.json.JSONException -> L7d
            java.lang.String r4 = "updateinfo="
            r2.append(r4)     // Catch: java.lang.Exception -> L7b org.json.JSONException -> L7d
            java.lang.String r4 = r8.n     // Catch: java.lang.Exception -> L7b org.json.JSONException -> L7d
            r2.append(r4)     // Catch: java.lang.Exception -> L7b org.json.JSONException -> L7d
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L7b org.json.JSONException -> L7d
            com.video.androidsdk.log.LogEx.d(r3, r2)     // Catch: java.lang.Exception -> L7b org.json.JSONException -> L7d
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Exception -> L7b org.json.JSONException -> L7d
            java.lang.String r4 = r8.n     // Catch: java.lang.Exception -> L7b org.json.JSONException -> L7d
            r2.<init>(r4)     // Catch: java.lang.Exception -> L7b org.json.JSONException -> L7d
            java.lang.String r4 = "AppID"
            org.json.JSONArray r4 = r2.optJSONArray(r4)     // Catch: java.lang.Exception -> L7b org.json.JSONException -> L7d
            r5 = 0
            r6 = 0
        L37:
            int r7 = r4.length()     // Catch: java.lang.Exception -> L7b org.json.JSONException -> L7d
            if (r6 >= r7) goto L8c
            java.lang.String r7 = r4.optString(r6)     // Catch: java.lang.Exception -> L7b org.json.JSONException -> L7d
            boolean r7 = android.text.TextUtils.equals(r9, r7)     // Catch: java.lang.Exception -> L7b org.json.JSONException -> L7d
            if (r7 == 0) goto L78
            java.lang.String r9 = "DiyInfo"
            org.json.JSONArray r9 = r2.optJSONArray(r9)     // Catch: java.lang.Exception -> L7b org.json.JSONException -> L7d
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Exception -> L7b org.json.JSONException -> L7d
            java.lang.String r9 = r9.optString(r6)     // Catch: java.lang.Exception -> L7b org.json.JSONException -> L7d
            r2.<init>(r9)     // Catch: java.lang.Exception -> L7b org.json.JSONException -> L7d
            java.lang.String r9 = "lang"
            org.json.JSONArray r9 = r2.optJSONArray(r9)     // Catch: java.lang.Exception -> L7b org.json.JSONException -> L7d
        L5c:
            int r4 = r9.length()     // Catch: java.lang.Exception -> L7b org.json.JSONException -> L7d
            if (r5 >= r4) goto L8c
            java.lang.String r4 = r9.optString(r5)     // Catch: java.lang.Exception -> L7b org.json.JSONException -> L7d
            boolean r4 = android.text.TextUtils.equals(r10, r4)     // Catch: java.lang.Exception -> L7b org.json.JSONException -> L7d
            if (r4 == 0) goto L75
            org.json.JSONArray r9 = r2.optJSONArray(r11)     // Catch: java.lang.Exception -> L7b org.json.JSONException -> L7d
            java.lang.String r9 = r9.optString(r5)     // Catch: java.lang.Exception -> L7b org.json.JSONException -> L7d
            goto L8d
        L75:
            int r5 = r5 + 1
            goto L5c
        L78:
            int r6 = r6 + 1
            goto L37
        L7b:
            r9 = move-exception
            goto L7f
        L7d:
            r9 = move-exception
            goto L86
        L7f:
            com.video.androidsdk.log.LogEx.w(r3, r0)
            r9.printStackTrace()
            goto L8c
        L86:
            com.video.androidsdk.log.LogEx.w(r3, r0)
            r9.printStackTrace()
        L8c:
            r9 = r1
        L8d:
            if (r9 != 0) goto L90
            goto L91
        L90:
            r1 = r9
        L91:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "diyInfo="
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            com.video.androidsdk.log.LogEx.d(r3, r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.video.androidsdk.service.SDKUpgradeMgr.getDiyInfo(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public String getHint(String str, String str2) {
        if (!a.e) {
            LogEx.e("SDKUpgradeMgr", ErrMessage.LIC_INVALIDATE);
            return null;
        }
        if (this.f3417c == null || StringUtil.isEmptyString(str2)) {
            LogEx.d("SDKUpgradeMgr", "no data response");
            return "";
        }
        int i = 0;
        while (true) {
            if (i >= this.f3417c.size()) {
                break;
            }
            if (str.equalsIgnoreCase((String) this.f3417c.get(i).get(ParamConst.UPDATE_VERSION_RSP_APPID))) {
                List list = (List) this.f3417c.get(i).get(ParamConst.UPDATE_VERSION_RSP_UPDATEINFO);
                if (list == null) {
                    return "";
                }
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (str2.equalsIgnoreCase((String) ((Map) list.get(i2)).get("lang"))) {
                        int i3 = this.l;
                        if (i3 == 1) {
                            return (String) ((Map) list.get(i2)).get(ParamConst.UPDATE_VERSION_RSP_FORCEHINT);
                        }
                        if (i3 == 2) {
                            return (String) ((Map) list.get(i2)).get(ParamConst.UPDATE_VERSION_RSP_OPTIONALHINT);
                        }
                    }
                }
            } else {
                i++;
            }
        }
        return "";
    }

    public String getURL(String str) {
        if (!a.e) {
            LogEx.e("SDKUpgradeMgr", ErrMessage.LIC_INVALIDATE);
            return null;
        }
        if (this.f3417c != null && !StringUtil.isEmptyString(str)) {
            for (int i = 0; i < this.f3417c.size(); i++) {
                if (str.equalsIgnoreCase((String) this.f3417c.get(i).get(ParamConst.UPDATE_VERSION_RSP_APPID))) {
                    return (String) this.f3417c.get(i).get(ParamConst.UPDATE_VERSION_RSP_URL);
                }
            }
            return "";
        }
        LogEx.d("SDKUpgradeMgr", "no data response");
        return "";
    }

    public String getVersionName() {
        if (!a.e) {
            LogEx.e("SDKUpgradeMgr", ErrMessage.LIC_INVALIDATE);
            return null;
        }
        try {
            JSONArray jSONArray = new JSONObject(this.n).getJSONArray(ParamConst.UPDATE_VERSION_RSP_VERSIONNAME);
            return jSONArray != null ? jSONArray.optString(0) : "";
        } catch (JSONException e) {
            LogEx.w("SDKUpgradeMgr", "getversionname json parse error.");
            e.printStackTrace();
            return "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.j == null || this.f3417c == null) {
            return;
        }
        for (int i = 0; i < this.f3417c.size(); i++) {
            String str = (String) this.f3417c.get(i).get(ParamConst.UPDATE_VERSION_RSP_APPID);
            this.g = str;
            int i2 = this.m;
            if (i2 == 1) {
                this.e = a(this.h, i2, str);
                this.f3418d.put(this.g, Integer.valueOf(a(a(this.f3417c), this.e)));
            } else if (i2 == 2) {
                List<Map<String, Object>> list = this.f3417c;
                this.f3418d.put(this.g, Integer.valueOf(a(list, a(this.h, i2, (String) list.get(i).get(ParamConst.UPDATE_VERSION_RSP_APPID)))));
            } else {
                OnMoreAppsUpgradeInfoReturnListener onMoreAppsUpgradeInfoReturnListener = this.j;
                if (onMoreAppsUpgradeInfoReturnListener != null) {
                    onMoreAppsUpgradeInfoReturnListener.onUpgradeInfoReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_UPGRADE_MODELCODE, 3)), ErrMessage.INVALID_PARAM, null);
                }
            }
        }
        this.j.onUpgradeInfoReturn(String.valueOf(0), "success", this.f3418d);
    }

    public void checkUpgrade(String str, int i, String str2, OnUpgradeInfoReturnListener onUpgradeInfoReturnListener) {
        if (!a.e) {
            LogEx.e("SDKUpgradeMgr", ErrMessage.LIC_INVALIDATE);
            return;
        }
        this.k = 1;
        this.i = onUpgradeInfoReturnListener;
        this.f = i;
        this.g = str;
        if (!StringUtil.isEmptyString(str2) && !StringUtil.isEmptyString(this.g)) {
            if (this.f3415a.equals(str2)) {
                OnUpgradeInfoReturnListener onUpgradeInfoReturnListener2 = this.i;
                if (onUpgradeInfoReturnListener2 == null || this.f3417c == null) {
                    return;
                }
                onUpgradeInfoReturnListener2.onUpgradeInfoReturn(String.valueOf(0), "", a(this.f3417c, String.valueOf(this.f)));
                return;
            }
            this.f3415a = str2;
            a(str2);
            return;
        }
        OnUpgradeInfoReturnListener onUpgradeInfoReturnListener3 = this.i;
        if (onUpgradeInfoReturnListener3 != null) {
            onUpgradeInfoReturnListener3.onUpgradeInfoReturn(String.valueOf(ErrCode.getErrCode(ErrCode.ERRCODE_UPGRADE_MODELCODE, 2, 2)), ErrMessage.PARAM_IS_NULL, -1);
        }
        LogEx.w("SDKUpgradeMgr", "url is empty or versionName is null or AppId is null");
    }

    private String a(Context context, int i, String str) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        for (int i2 = 0; i2 < installedPackages.size(); i2++) {
            PackageInfo packageInfo = installedPackages.get(i2);
            if (packageInfo != null && str.equals(packageInfo.packageName)) {
                LogEx.d("SDKUpgradeMgr", "getCurVersion: succ to find " + str);
                if (i == 1) {
                    return packageInfo.versionName;
                }
                return String.valueOf(packageInfo.versionCode);
            }
        }
        return "";
    }

    private void a(String str) {
        new SDKNetHTTPRequest().startRequest(str, "POST", new SDKNetHTTPRequest.IHTTPRequestReturnListener() { // from class: com.video.androidsdk.service.SDKUpgradeMgr.1
            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onDataReturn(String str2) {
                SDKUpgradeMgr.this.f3416b = 0;
                LogEx.d("SDKUpgradeMgr", "update rsp is :" + str2);
                SDKUpgradeMgr.this.n = str2;
                c.a(str2, (List<Map<String, Object>>) SDKUpgradeMgr.this.f3417c);
                if (SDKUpgradeMgr.this.k != 0) {
                    if (SDKUpgradeMgr.this.k != 1) {
                        if (SDKUpgradeMgr.this.k == 2) {
                            LogEx.d("SDKUpgradeMgr", "check update info for STB");
                            SDKUpgradeMgr.this.a();
                            return;
                        }
                        return;
                    }
                    LogEx.d("SDKUpgradeMgr", "check update info by versionCode");
                    if (SDKUpgradeMgr.this.i == null || SDKUpgradeMgr.this.f3417c == null) {
                        return;
                    }
                    OnUpgradeInfoReturnListener onUpgradeInfoReturnListener = SDKUpgradeMgr.this.i;
                    String valueOf = String.valueOf(0);
                    SDKUpgradeMgr sDKUpgradeMgr = SDKUpgradeMgr.this;
                    onUpgradeInfoReturnListener.onUpgradeInfoReturn(valueOf, "", sDKUpgradeMgr.a((List<Map<String, Object>>) sDKUpgradeMgr.f3417c, String.valueOf(SDKUpgradeMgr.this.f)));
                    return;
                }
                LogEx.d("SDKUpgradeMgr", "check update info by versionName");
                SDKUpgradeMgr sDKUpgradeMgr2 = SDKUpgradeMgr.this;
                String a2 = sDKUpgradeMgr2.a((List<Map<String, Object>>) sDKUpgradeMgr2.f3417c);
                if (SDKUpgradeMgr.this.i == null || SDKUpgradeMgr.this.f3417c == null) {
                    return;
                }
                OnUpgradeInfoReturnListener onUpgradeInfoReturnListener2 = SDKUpgradeMgr.this.i;
                String valueOf2 = String.valueOf(String.valueOf(0));
                SDKUpgradeMgr sDKUpgradeMgr3 = SDKUpgradeMgr.this;
                onUpgradeInfoReturnListener2.onUpgradeInfoReturn(valueOf2, "", sDKUpgradeMgr3.a(a2, sDKUpgradeMgr3.e));
            }

            @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
            public void onFailReturn(int i, String str2) {
                SDKUpgradeMgr.this.f3416b = i;
                if (SDKUpgradeMgr.this.i != null) {
                    SDKUpgradeMgr.this.i.onUpgradeInfoReturn(String.valueOf(i), str2, i);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(List<Map<String, Object>> list) {
        if (list != null && !StringUtil.isEmptyString(this.g)) {
            for (int i = 0; i < list.size(); i++) {
                LogEx.d("SDKUpgradeMgr", "item result " + list.get(i));
                if (this.g.equalsIgnoreCase((String) list.get(i).get(ParamConst.UPDATE_VERSION_RSP_APPID))) {
                    String str = (String) list.get(i).get(ParamConst.UPDATE_VERSION_RSP_VERSIONNAME);
                    LogEx.d("SDKUpgradeMgr", "return version name is " + str);
                    return str;
                }
            }
            return "";
        }
        LogEx.w("SDKUpgradeMgr", "mapresult can not be null");
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        if (!StringUtil.isEmptyString(str)) {
            if (str3.startsWith("V") || str3.startsWith("v")) {
                str3 = str3.substring(1);
            }
            String[] split = str3.split("\\.");
            if (split != null && 4 == split.length) {
                String str5 = split[0];
                String str6 = split[1];
                String str7 = split[2];
                String str8 = split[3];
                LogEx.d("SDKUpgradeMgr", " serversplitone =" + str5 + ", serversplittwo = " + str6 + ", serversplitthree = " + str7 + ", serversplifour = " + str8);
                int intValue = Integer.valueOf(str5).intValue();
                int intValue2 = Integer.valueOf(str6).intValue();
                int intValue3 = Integer.valueOf(str7).intValue();
                int intValue4 = Integer.valueOf(str8).intValue();
                if (!StringUtil.isEmptyString(str2)) {
                    if (str4.startsWith("V") || str4.startsWith("v")) {
                        str4 = str4.substring(1);
                    }
                    String[] split2 = str4.split("\\.");
                    if (split2 != null && 4 == split2.length) {
                        String str9 = split2[0];
                        String str10 = split2[1];
                        String str11 = split2[2];
                        String str12 = split2[3];
                        LogEx.d("SDKUpgradeMgr", " cursplitone =" + str9 + ", cursplittwo = " + str10 + ", cursplitthree = " + str11 + ", cursplifour = " + str12);
                        int intValue5 = Integer.valueOf(str9).intValue();
                        int intValue6 = Integer.valueOf(str10).intValue();
                        int intValue7 = Integer.valueOf(str11).intValue();
                        int intValue8 = Integer.valueOf(str12).intValue();
                        if (intValue > intValue5 || (intValue == intValue5 && intValue2 > intValue6)) {
                            LogEx.d("SDKUpgradeMgr", "showForcibleUpgradeMessage");
                            this.l = 1;
                        } else if (intValue != intValue5 || intValue2 != intValue6) {
                            this.l = 0;
                        } else if (intValue3 > intValue7 || intValue4 > intValue8) {
                            LogEx.d("SDKUpgradeMgr", "showUpgradeMessage");
                            this.l = 2;
                        }
                    } else {
                        LogEx.w("SDKUpgradeMgr", " illegal curVersionName");
                        return -1;
                    }
                } else {
                    LogEx.w("SDKUpgradeMgr", "curVersionName is null");
                    this.l = -1;
                }
                return this.l;
            }
            LogEx.w("SDKUpgradeMgr", " illegal ServerVersionName");
            return -1;
        }
        LogEx.w("SDKUpgradeMgr", "ServerVersionName is null");
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(List<Map<String, Object>> list, String str) {
        String str2;
        String str3;
        if (list != null && !StringUtil.isEmptyString(str)) {
            int i = 0;
            while (true) {
                str2 = "";
                if (i >= list.size()) {
                    str3 = "";
                    break;
                }
                if (this.g.equalsIgnoreCase((String) list.get(i).get(ParamConst.UPDATE_VERSION_RSP_APPID))) {
                    str2 = (String) list.get(i).get(ParamConst.UPDATE_VERSION_RSP_LATEST);
                    str3 = (String) list.get(i).get(ParamConst.UPDATE_VERSION_RSP_LOWEST);
                    break;
                }
                i++;
            }
            try {
                int intValue = Integer.valueOf(str).intValue();
                int intValue2 = Integer.valueOf(str2).intValue();
                int intValue3 = Integer.valueOf(str3).intValue();
                if (intValue >= intValue2) {
                    this.l = 0;
                } else if (intValue < intValue3) {
                    this.l = 1;
                } else {
                    this.l = 2;
                }
            } catch (Exception unused) {
                LogEx.w("SDKUpgradeMgr", "String versioncode cast to integer error");
                this.l = -1;
            }
            return this.l;
        }
        LogEx.w("SDKUpgradeMgr", "mapresult can not be null");
        return -1;
    }
}
