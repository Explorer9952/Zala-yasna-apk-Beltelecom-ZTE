package com.zte.iptvclient.android.common.player;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.video.androidsdk.common.AndroidUniqueCode;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.http.bean.HttpRequest;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: MegogoPlayMgr.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private com.zte.iptvclient.android.common.j.h f4869a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<com.zte.iptvclient.android.common.player.j.h> f4870b;

    /* renamed from: c, reason: collision with root package name */
    private com.zte.iptvclient.android.common.player.j.h f4871c;

    /* renamed from: d, reason: collision with root package name */
    private e f4872d;
    private Context e;
    private String f;
    private String g;
    private List<com.zte.iptvclient.android.common.player.j.g> h = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MegogoPlayMgr.java */
    /* loaded from: classes.dex */
    public class a extends TypeToken<ArrayList<com.zte.iptvclient.android.common.player.j.h>> {
        a(d dVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MegogoPlayMgr.java */
    /* loaded from: classes.dex */
    public class b implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        b() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            String str2;
            LogEx.d("MegogoPlayMgr", "queryPlayUrl response is  " + str);
            if (TextUtils.isEmpty(str)) {
                d.this.f4872d.a("1", "", d.this.h);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (TextUtils.equals(jSONObject.optString("result"), "ok")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    String optString = optJSONObject.optString("src");
                    JSONArray jSONArray = optJSONObject.getJSONArray("audio_tracks");
                    int a2 = d.this.a(LocaleUtil.RUSSIAN, jSONArray);
                    if (a2 == -1 && (a2 = d.this.a("be", jSONArray)) == -1) {
                        a2 = d.this.a("en", jSONArray);
                    }
                    LogEx.d("MegogoPlayMgr", "play url is  " + optString);
                    d.this.h = d.this.a(optJSONObject.getJSONArray("bitrates"), a2);
                    if (!TextUtils.isEmpty(optString)) {
                        if (optString.contains("/a/0")) {
                            str2 = optString.replace("/a/0", "/a/" + a2);
                        } else {
                            int lastIndexOf = optString.lastIndexOf("/", optString.lastIndexOf("/"));
                            String substring = optString.substring(0, lastIndexOf);
                            String substring2 = optString.substring(lastIndexOf);
                            LogEx.d("MegogoPlayMgr", "strBefore is  " + substring);
                            LogEx.d("MegogoPlayMgr", "strAfter is  " + substring2);
                            str2 = substring + "/a/" + a2 + substring2;
                        }
                        optString = str2;
                        LogEx.d("MegogoPlayMgr", "play url is  " + optString);
                    }
                    d.this.f4872d.a("0", optString, d.this.h);
                    return;
                }
                if (jSONObject.optInt("code") != 403) {
                    d.this.f4872d.a("1", "", d.this.h);
                } else {
                    d.this.a("2", "");
                }
            } catch (JSONException e) {
                e.printStackTrace();
                d.this.f4872d.a("1", "", d.this.h);
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            d.this.f4872d.a(String.valueOf(i), "", d.this.h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MegogoPlayMgr.java */
    /* loaded from: classes.dex */
    public class c extends TypeToken<ArrayList<com.zte.iptvclient.android.common.player.j.h>> {
        c(d dVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MegogoPlayMgr.java */
    /* renamed from: com.zte.iptvclient.android.common.player.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0143d implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4874a;

        C0143d(String str) {
            this.f4874a = str;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            String V = d.this.f4869a.V();
            d.this.f4871c = new com.zte.iptvclient.android.common.player.j.h();
            LogEx.d("MegogoPlayMgr", "getMegogoData response is  " + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("returncode");
                if (TextUtils.equals("0", optString)) {
                    if (TextUtils.equals(this.f4874a, "2")) {
                        String optString2 = jSONObject.optJSONObject("data").optJSONObject("tokens").optString("access_token");
                        LogEx.d("MegogoPlayMgr", "accessToken  ===  " + optString2);
                        d.this.f4869a.s(optString2);
                        d.this.f4869a.m(true);
                        if (!TextUtils.isEmpty(d.this.g)) {
                            if (!TextUtils.equals(d.this.f, "0")) {
                                d.this.a(DownloadConstant.REPORT_MSGTYPE_URL_NULL, d.this.g);
                            } else {
                                d.this.a(d.this.g);
                            }
                        }
                    } else if (TextUtils.equals(this.f4874a, DownloadConstant.REPORT_MSGTYPE_STB_RECONNECT)) {
                        d.this.f4871c.a(jSONObject.optString("expiration"));
                        d.this.f4871c.b(V);
                        d.this.f4870b.add(d.this.f4871c);
                        String json = new Gson().toJson(d.this.f4870b);
                        LogEx.d("MegogoPlayMgr", "expirtion_jsonStr  = " + json);
                        d.this.f4869a.t(json);
                    } else if (TextUtils.equals(this.f4874a, DownloadConstant.REPORT_MSGTYPE_URL_NULL) || TextUtils.equals(this.f4874a, "3")) {
                        d.this.a(d.this.g);
                    }
                } else if (!TextUtils.equals("0", optString)) {
                    if (!TextUtils.equals(this.f4874a, "2") && !TextUtils.equals(this.f4874a, "3")) {
                        if (TextUtils.equals(this.f4874a, DownloadConstant.REPORT_MSGTYPE_URL_NULL)) {
                            if (!TextUtils.equals("403", optString)) {
                                d.this.f4872d.a(optString, "", d.this.h);
                            } else {
                                d.this.a("2", "");
                            }
                        }
                    }
                    d.this.f4869a.m(false);
                    if (d.this.f4872d != null) {
                        d.this.f4872d.a(optString, "", d.this.h);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            if (TextUtils.equals(this.f4874a, "2") || TextUtils.equals(this.f4874a, "3")) {
                d.this.f4869a.m(false);
                if (d.this.f4872d != null) {
                    d.this.f4872d.a(String.valueOf(i), "", d.this.h);
                    return;
                }
                return;
            }
            if (TextUtils.equals(this.f4874a, DownloadConstant.REPORT_MSGTYPE_URL_NULL)) {
                d.this.f4872d.a(String.valueOf(i), "", d.this.h);
            }
        }
    }

    /* compiled from: MegogoPlayMgr.java */
    /* loaded from: classes.dex */
    public interface e {
        void a(String str, String str2, List<com.zte.iptvclient.android.common.player.j.g> list);
    }

    public d(Context context) {
        this.e = context;
        this.f4869a = new com.zte.iptvclient.android.common.j.h(context);
    }

    public void a(boolean z) {
    }

    private String b(String str) {
        LogEx.d("MegogoPlayMgr", "plainText is " + str);
        try {
            String bigInteger = new BigInteger(1, MessageDigest.getInstance("md5").digest(str.getBytes())).toString(16);
            for (int i = 0; i < 32 - bigInteger.length(); i++) {
                bigInteger = "0" + bigInteger;
            }
            LogEx.d("MegogoPlayMgr", "secret string is " + bigInteger);
            return bigInteger;
        } catch (NoSuchAlgorithmException unused) {
            throw new RuntimeException("Invalid algorithm！");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(java.lang.String r5, java.lang.String r6, com.zte.iptvclient.android.common.player.d.e r7) {
        /*
            r4 = this;
            r4.f4872d = r7
            if (r7 != 0) goto L5
            return
        L5:
            r4.f = r5
            r4.g = r6
            java.lang.String r7 = "0"
            boolean r5 = android.text.TextUtils.equals(r5, r7)
            if (r5 == 0) goto L98
            com.zte.iptvclient.android.common.j.h r5 = r4.f4869a
            java.lang.String r5 = r5.x()
            boolean r7 = android.text.TextUtils.isEmpty(r5)
            r0 = 0
            java.lang.String r1 = ""
            if (r7 != 0) goto L6f
            com.google.gson.Gson r7 = new com.google.gson.Gson
            r7.<init>()
            com.zte.iptvclient.android.common.player.d$a r2 = new com.zte.iptvclient.android.common.player.d$a
            r2.<init>(r4)
            java.lang.reflect.Type r2 = r2.getType()
            java.lang.Object r5 = r7.fromJson(r5, r2)
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            r4.f4870b = r5
            if (r5 == 0) goto L6f
            int r5 = r5.size()
            if (r5 <= 0) goto L6f
            r7 = r1
            r5 = 0
        L40:
            java.util.ArrayList<com.zte.iptvclient.android.common.player.j.h> r2 = r4.f4870b
            int r2 = r2.size()
            if (r5 >= r2) goto L70
            java.util.ArrayList<com.zte.iptvclient.android.common.player.j.h> r2 = r4.f4870b
            java.lang.Object r2 = r2.get(r5)
            com.zte.iptvclient.android.common.player.j.h r2 = (com.zte.iptvclient.android.common.player.j.h) r2
            java.lang.String r2 = r2.b()
            com.zte.iptvclient.android.common.j.h r3 = r4.f4869a
            java.lang.String r3 = r3.V()
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L6c
            java.util.ArrayList<com.zte.iptvclient.android.common.player.j.h> r7 = r4.f4870b
            java.lang.Object r7 = r7.get(r5)
            com.zte.iptvclient.android.common.player.j.h r7 = (com.zte.iptvclient.android.common.player.j.h) r7
            java.lang.String r7 = r7.a()
        L6c:
            int r5 = r5 + 1
            goto L40
        L6f:
            r7 = r1
        L70:
            boolean r5 = android.text.TextUtils.isEmpty(r7)
            java.lang.String r2 = "7"
            if (r5 == 0) goto L7c
            r4.a(r2, r1)
            goto L9d
        L7c:
            java.util.Date r5 = com.zte.iptvclient.android.common.k.x.h(r7)
            if (r5 == 0) goto L8d
            java.util.Date r7 = com.zte.iptvclient.android.common.k.s.b()
            boolean r5 = r5.before(r7)
            if (r5 != 0) goto L8d
            goto L8e
        L8d:
            r0 = 1
        L8e:
            if (r0 == 0) goto L94
            r4.a(r2, r1)
            goto L9d
        L94:
            r4.a(r6)
            goto L9d
        L98:
            java.lang.String r5 = "6"
            r4.a(r5, r6)
        L9d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.common.player.d.a(java.lang.String, java.lang.String, com.zte.iptvclient.android.common.player.d$e):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        this.h = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("video_id=");
        stringBuffer.append(str);
        stringBuffer.append("&did=");
        stringBuffer.append(AndroidUniqueCode.getAndroidId(this.e));
        stringBuffer.append("&access_token=");
        stringBuffer.append(this.f4869a.v());
        String str2 = b(stringBuffer.toString().replace("&", "") + SDKLoginMgr.getInstance().getPropertiesInfo("Megogo_Private_Key_DASH")) + SDKLoginMgr.getInstance().getPropertiesInfo("Megogo_Public_Key_DASH");
        stringBuffer.append("&sign=");
        stringBuffer.append(str2);
        new SDKNetHTTPRequest().startRequest("https://api.megogo.net/v1/stream?" + stringBuffer.toString(), HttpRequest.METHOD_GET, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(String str, JSONArray jSONArray) {
        int i;
        int i2 = 0;
        while (true) {
            if (i2 >= jSONArray.length()) {
                i = -1;
                break;
            }
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (TextUtils.equals(optJSONObject.optString("lang"), str)) {
                i = optJSONObject.optInt("index");
                break;
            }
            i2++;
        }
        LogEx.d("MegogoPlayMgr", "AudioIndex  is " + i);
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.zte.iptvclient.android.common.player.j.g> a(JSONArray jSONArray, int i) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                arrayList.add(com.zte.iptvclient.android.common.player.j.g.a(jSONArray.getJSONObject(i2), i));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return arrayList;
    }

    public void a(String str, String str2) {
        LogEx.d("MegogoPlayMgr", "megogoType is " + str);
        String str3 = SDKLoginMgr.getInstance().getFrameHome() + "sdk_getmegogodata.jsp";
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        if (TextUtils.equals(str, DownloadConstant.REPORT_MSGTYPE_STB_RECONNECT)) {
            this.f4870b = new ArrayList<>();
            sDKNetHTTPRequest.setParam("megogoType", str);
            sDKNetHTTPRequest.setParam("operation", "subscribe");
            String x = this.f4869a.x();
            if (!TextUtils.isEmpty(x)) {
                this.f4870b = (ArrayList) new Gson().fromJson(x, new c(this).getType());
            }
        } else {
            sDKNetHTTPRequest.setParam("megogoType", str);
            sDKNetHTTPRequest.setParam("keyType", "DASH");
            if (TextUtils.equals(str, "3")) {
                sDKNetHTTPRequest.setParam("operation", "subscribe");
            } else if (TextUtils.equals(str, DownloadConstant.REPORT_MSGTYPE_URL_NULL)) {
                sDKNetHTTPRequest.setParam("videoId", str2);
            }
        }
        LogEx.d("MegogoPlayMgr", "getMegogoData url  is  " + str3);
        sDKNetHTTPRequest.startRequest(str3, HttpRequest.METHOD_GET, new C0143d(str));
    }
}
