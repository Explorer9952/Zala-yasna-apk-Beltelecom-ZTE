package com.zte.iptvclient.android.common.k;

import android.content.Context;
import android.text.TextUtils;
import com.sina.weibo.sdk.exception.WeiboAuthException;
import com.video.androidsdk.common.PreferenceHelper;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.comm.ParamConst;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.iptvclient.android.common.k.q;
import com.zte.sdk.enumclass.CapablityEnum;
import com.zte.servicesdk.util.TimeShowUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BlackoutUpdateUtils.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    private static com.zte.iptvclient.android.common.javabean.c f4800b;

    /* renamed from: d, reason: collision with root package name */
    private static PreferenceHelper f4802d;

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, com.zte.iptvclient.android.common.javabean.d> f4799a = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private static String f4801c = "0";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BlackoutUpdateUtils.java */
    /* loaded from: classes.dex */
    public static class a implements q.d {
        a() {
        }

        @Override // com.zte.iptvclient.android.common.k.q.d
        public void a(String str, String str2, String str3) {
        }

        @Override // com.zte.iptvclient.android.common.k.q.d
        public void b(String str, String str2, String str3) {
        }

        @Override // com.zte.iptvclient.android.common.k.q.d
        public void c(String str, String str2, String str3) {
            if (e.e() != null) {
                e.b();
            }
            if (!str.equalsIgnoreCase("0") || TextUtils.isEmpty(str3)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str3);
                String optString = jSONObject.optString("blackouttype");
                String optString2 = jSONObject.optString("blackinfo");
                String optString3 = jSONObject.optString("begintime");
                String optString4 = jSONObject.optString("endtime");
                com.zte.iptvclient.android.common.javabean.c cVar = new com.zte.iptvclient.android.common.javabean.c();
                cVar.a(optString2);
                cVar.a(Integer.parseInt(optString));
                if (!TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4)) {
                    cVar.a(new com.zte.iptvclient.android.mobile.b.a(x.d(optString3), x.d(optString4)));
                }
                e.a(cVar);
            } catch (JSONException e) {
                LogEx.e("BlackoutUpdateUtils", "JSON ERROR = " + e.toString());
            }
        }

        @Override // com.zte.iptvclient.android.common.k.q.d
        public void d(String str, String str2, String str3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BlackoutUpdateUtils.java */
    /* loaded from: classes.dex */
    public static class b implements q.d {
        b() {
        }

        @Override // com.zte.iptvclient.android.common.k.q.d
        public void a(String str, String str2, String str3) {
            if (TextUtils.isEmpty(str3) || !TextUtils.equals("0", str)) {
                return;
            }
            LogEx.d("BlackoutUpdateUtils", "SDKBlackoutMgr onGetChannelBlackOutInfoReturn code = " + str + " ,data = " + str3);
            try {
                JSONObject jSONObject = new JSONObject(str3);
                JSONArray jSONArray = jSONObject.getJSONArray("data");
                String optString = jSONObject.optString("timestamp");
                PreferenceHelper unused = e.f4802d = e.c();
                if (e.f4802d != null && !TextUtils.isEmpty(optString)) {
                    e.f4802d.putString("timestamp", optString);
                    LogEx.d("BlackoutUpdateUtils", "getSharedPreferencesByAccount timestamp=" + optString);
                }
                e.b(jSONArray);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.zte.iptvclient.android.common.k.q.d
        public void b(String str, String str2, String str3) {
        }

        @Override // com.zte.iptvclient.android.common.k.q.d
        public void c(String str, String str2, String str3) {
        }

        @Override // com.zte.iptvclient.android.common.k.q.d
        public void d(String str, String str2, String str3) {
        }
    }

    public static void b(String str, String str2) {
        if (f4800b != null) {
            f4800b = null;
        }
        String d2 = com.zte.iptvclient.common.uiframe.a.d("TeamID");
        LogEx.d("BlackoutUpdateUtils", "queryVodBlackout >strTeamID = " + d2);
        if (TextUtils.isEmpty(d2)) {
            d2 = "";
        }
        String userInfo = SDKLoginMgr.getInstance().getUserInfo(ParamConst.LOGIN_PORTALAUTH_RSP_USERIP);
        LogEx.d("BlackoutUpdateUtils", "queryVodBlackout >mStrIpAddr = " + userInfo);
        String a2 = w.a(TextUtils.isEmpty(userInfo) ? "" : userInfo);
        LogEx.d("BlackoutUpdateUtils", "ipaddr is  " + a2);
        HashMap hashMap = new HashMap();
        hashMap.put("teamid", d2);
        hashMap.put("ipaddr", a2);
        hashMap.put("querytype", "1");
        hashMap.put("querycode", str);
        hashMap.put("columncode", str2);
        q.a("1", hashMap, new a());
    }

    public static PreferenceHelper c() {
        Context applicationContext = BaseApp.e().getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        com.zte.iptvclient.android.common.j.h hVar = new com.zte.iptvclient.android.common.j.h(applicationContext);
        LogEx.d("BlackoutUpdateUtils", "getSharedPreferencesByAccount =" + hVar.V());
        return new PreferenceHelper(applicationContext, hVar.V());
    }

    private static String d() {
        PreferenceHelper c2 = c();
        f4802d = c2;
        if (c2 == null) {
            return "0";
        }
        try {
            return c2.getString("timestamp", "0");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return "0";
        }
    }

    public static com.zte.iptvclient.android.common.javabean.c e() {
        return f4800b;
    }

    public static void f() {
        LogEx.d("BlackoutUpdateUtils", "initChannelInfoBlackot");
        HashMap hashMap = new HashMap();
        hashMap.put("ipaddr", SDKLoginMgr.getInstance().getUserInfo(ParamConst.LOGIN_PORTALAUTH_RSP_USERIP));
        hashMap.put("teamid", com.zte.iptvclient.common.uiframe.a.d("TeamID"));
        hashMap.put("querytype", "2");
        String d2 = d();
        f4801c = d2;
        hashMap.put("querycode", d2);
        LogEx.d("BlackoutUpdateUtils", "initChannelBalckout List mTimestamp=" + f4801c);
        q.a("2", hashMap, new b());
    }

    public static String a(Date date, String str) {
        LogEx.d("BlackoutUpdateUtils", "getChannelBlackOutInfo  channelCode " + str + " checkDate" + date);
        com.zte.iptvclient.android.common.javabean.d dVar = f4799a.get(str);
        com.zte.iptvclient.android.common.f.b.b.j().a((ArrayList<com.zte.iptvclient.android.mobile.b.a>) null);
        if (dVar != null) {
            ArrayList<com.zte.iptvclient.android.mobile.b.a> b2 = dVar.b();
            if (b2 != null) {
                com.zte.iptvclient.android.common.f.b.b.j().a(b2);
                for (int i = 0; i < b2.size(); i++) {
                    String format = new SimpleDateFormat(TimeShowUtil.STR_VOD_DURATION_TIME_FORMATE).format(date);
                    String format2 = new SimpleDateFormat(TimeShowUtil.STR_VOD_DURATION_TIME_FORMATE).format(b2.get(i).a());
                    String format3 = new SimpleDateFormat(TimeShowUtil.STR_VOD_DURATION_TIME_FORMATE).format(b2.get(i).b());
                    LogEx.d("BlackoutUpdateUtils", "getChannelBlackOutInfo  channelCodes " + str + " checkDate" + format + "   begin=" + format2 + "    end=" + format3);
                    if (a(format, format2, format3)) {
                        return dVar.a();
                    }
                }
                return WeiboAuthException.DEFAULT_AUTH_ERROR_CODE;
            }
            LogEx.d("BlackoutUpdateUtils", "current channel " + str + " for blackoutTimeScalList is null");
            return WeiboAuthException.DEFAULT_AUTH_ERROR_CODE;
        }
        LogEx.d("BlackoutUpdateUtils", "current channel " + str + " for blackoutId is null");
        return WeiboAuthException.DEFAULT_AUTH_ERROR_CODE;
    }

    public static void b() {
        f4800b = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(JSONArray jSONArray) throws JSONException {
        f4799a.clear();
        int i = 0;
        int i2 = 0;
        while (i2 < jSONArray.length()) {
            JSONArray jSONArray2 = jSONArray.getJSONArray(i2);
            if (jSONArray2 == null) {
                return;
            }
            String[] a2 = a(jSONArray2.getString(i), CapablityEnum.SPLIT_CODE);
            String[] a3 = a(jSONArray2.getString(1), ",");
            com.zte.iptvclient.android.common.javabean.d dVar = new com.zte.iptvclient.android.common.javabean.d();
            dVar.b(a2[i]);
            dVar.a(a2[1]);
            String str = a2[i];
            LogEx.d("BlackoutUpdateUtils", "getTvBlackoutInfo Item ChannelCode=" + a2[i] + " blackoutId= " + a2[1]);
            ArrayList<com.zte.iptvclient.android.mobile.b.a> arrayList = new ArrayList<>();
            int length = a3.length;
            int i3 = 0;
            while (i3 < length) {
                String[] a4 = a(a3[i3], CapablityEnum.SPLIT_CODE);
                String str2 = d.a("yyyyMMdd") + a4[i];
                String str3 = d.a("yyyyMMdd") + a4[1];
                Date c2 = x.c(str2, "yyyyMMddHHmmss");
                Date c3 = x.c(str3, "yyyyMMddHHmmss");
                com.zte.iptvclient.android.mobile.b.a aVar = new com.zte.iptvclient.android.mobile.b.a(c2, c3);
                LogEx.d("BlackoutUpdateUtils", "BlackoutTimeBean channnecode = " + str + "  startTime " + c2 + "endTime " + c3);
                arrayList.add(aVar);
                i3++;
                i = 0;
            }
            dVar.a(arrayList);
            f4799a.put(str, dVar);
            i2++;
            i = 0;
        }
        LogEx.d("BlackoutUpdateUtils", "getTvBlackoutInfo mTvBlackoutMap=" + f4799a.size());
    }

    private static boolean a(String str, String str2, String str3) {
        Date date;
        Date date2;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TimeShowUtil.STR_VOD_DURATION_TIME_FORMATE);
        Date date3 = null;
        try {
            date = simpleDateFormat.parse(str);
            try {
                date2 = simpleDateFormat.parse(str2);
                try {
                    date3 = simpleDateFormat.parse(str3);
                } catch (ParseException e) {
                    e = e;
                    e.printStackTrace();
                    if (date.after(date2)) {
                    }
                }
            } catch (ParseException e2) {
                e = e2;
                date2 = null;
            }
        } catch (ParseException e3) {
            e = e3;
            date = null;
            date2 = null;
        }
        return !date.after(date2) && date.before(date3);
    }

    public static com.zte.iptvclient.android.common.javabean.c a(Date date) {
        com.zte.iptvclient.android.common.javabean.c cVar = f4800b;
        if (cVar != null) {
            return cVar;
        }
        LogEx.e("BlackoutUpdateUtils", "currnt vod had not VODBlackoutBean !");
        com.zte.iptvclient.android.common.f.b.b.j().a((com.zte.iptvclient.android.mobile.b.a) null);
        return null;
    }

    private static String[] a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return new String[]{""};
        }
        return TextUtils.isEmpty(str2) ? new String[]{str} : StringUtil.splitString(str, str2);
    }

    public static String a(String str) {
        return SDKLoginMgr.getInstance().getEPGHome() + "images/blackout/" + str;
    }

    public static void a(com.zte.iptvclient.android.common.javabean.c cVar) {
        f4800b = cVar;
    }
}
