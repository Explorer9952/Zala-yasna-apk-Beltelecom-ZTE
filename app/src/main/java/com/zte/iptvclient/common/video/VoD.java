package com.zte.iptvclient.common.video;

import android.text.TextUtils;
import com.video.androidsdk.common.http.SDKNetHTTPRequest;
import com.video.androidsdk.common.http.bean.HttpRequest;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.video.androidsdk.service.auth.SDKAuthMgr;
import com.video.androidsdk.service.bean.AuthReq;
import com.video.androidsdk.service.comm.DefinitionType;
import com.video.androidsdk.service.comm.ParamConst;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class VoD implements Serializable {
    private static String ExtendFields = "";
    private static final String LOG_TAG = "VoD";
    private static final long serialVersionUID = 1;
    private int TotalCount;
    private String actorcode;
    private String castPlayUrl;
    private String directorcode;
    private String doubanrate;
    private String episodebreakpoint;
    private String episodeproramname;
    private List<String> extendFiledsList;
    private String istrailer;
    private com.zte.iptvclient.common.video.b mGetVodReq;
    private String singercode;
    private String trailer;
    private String updatenum;
    private List<com.zte.iptvclient.common.video.d> videoInfoList;
    private String viewingtime;
    private i0 vodInfoReturnListener;
    private String vrflag;
    private String mstrUrl = "";
    private String ProgramCode = "";
    private String ContentCode = "";
    private String ProgramName = "";
    private String ProgramNameLen = "";
    private String ProgramType = "";
    private String SeriesProgramCode = "";
    private String isRecommend = "";
    private String isHot = "";
    private String isFirstPage = "";
    private String CatagoryCode = "";
    private String BoCode = "";
    private String ProgramSearchKey = "";
    private String MediaServices = "";
    private String RatingId = "";
    private String RecommendId = "";
    private String SortNum = "";
    private String Price = "";
    private String EnabledTime = "";
    private String DisabledTime = "";
    private String OnlineTime = "";
    private String OfflineTime = "";
    private String CreateTime = "";
    private String CountryName = "";
    private String isSimpleTrailer = "";
    private String TelecomCode = "";
    private String MediaCode = "";
    private String TrailerBeginTime = "";
    private String TrailerEndTime = "";
    private String SeriesNum = "";
    private String PosterfileList = "";
    private String PosterPath = "";
    private String WgGenre = "";
    private String WgKeywords = "";
    private String WgTags = "";
    private String Description = "";
    private String Director = "";
    private String DirectorSearchkey = "";
    private String Actor = "";
    private String Actorsearchkey = "";
    private String CpCode = "";
    private String CpName = "";
    private String ColumnCode = "";
    private String CatalogName = "";
    private String DescriptionKey = "";
    private String AdvertiseContent = "";
    private String ReleaseDate = "";
    private String Writer = "";
    private String AudioLang = "";
    private String SubTitleLang = "";
    private String PubCompany = "";
    private String DetailDescribed = "";
    private String SeriesSeason = "";
    private String Genre = "";
    private String LicensePeriod = "";
    private String ChannelCode = "";
    private String SubGenre = "";
    private String ShortDesc = "";
    private String ShortTitle = "";
    private String ElapsedTime = "";
    private String StarLevel = "";
    private String isTimeShift = "";
    private String isArchiveMode = "";
    private String isProtection = "";
    private String TimeShiftMode = "";
    private String ArchiveMode = "";
    private String CopyProtection = "";
    private String Language = "";
    private String Format = "";
    private String Aspect = "";
    private String Dolby = "";
    private String EpisodeTitle = "";
    private String ParentalAdvisory = "";
    private String CatalogType = "";
    private com.zte.iptvclient.common.video.d videoInfoBean = null;
    private String RatingNum = "";
    private String RatingSum = "";
    private String isFavorite = "";
    private String is3SFavorite = "";
    private String isLocked = "";
    private String bookmarktype = "";
    private String bookmarktype3S = "";
    private String breakpoint = "";
    private String breakpoint3S = "";

    class a implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        final String f7920a;

        final x f7921b;

        a(String str, x xVar) {
            this.f7920a = str;
            this.f7921b = xVar;
        }

        @Override
        public void onDataReturn(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("returncode") == 0) {
                    if (StringUtil.isSameString(this.f7920a, StringUtil.getStringNotNull(jSONObject.optString(ParamConst.USER_PROPERTIES_RSP_LIMITPWD)))) {
                        LogEx.d(VoD.LOG_TAG, "unlock sucessfully!");
                        VoD.this.setIsLocked("1");
                        this.f7921b.a(0, "Check Lock Succeed.");
                    } else {
                        LogEx.w(VoD.LOG_TAG, "unlock failed!");
                        VoD.this.setIsLocked("0");
                        this.f7921b.a(-1, "Check Lock Fail.");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
                this.f7921b.a(-1, "json error");
            }
        }

        @Override
        public void onFailReturn(int i, String str) {
            this.f7921b.a(i, str);
        }
    }

    /* loaded from: classes2.dex */
    public interface a0 {
        void a(int i, String str);
    }

    /* loaded from: classes2.dex */
    class b implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ w f7923a;

        b(VoD voD, w wVar) {
            this.f7923a = wVar;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f7923a.a(jSONObject.optInt("returncode"), jSONObject.optString("errormsg"));
            } catch (JSONException e) {
                e.printStackTrace();
                this.f7923a.a(-1, "json error");
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            this.f7923a.a(i, str);
        }
    }

    /* loaded from: classes2.dex */
    public interface b0 {
        void a(int i, String str);
    }

    /* loaded from: classes2.dex */
    class c implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a0 f7924a;

        c(VoD voD, a0 a0Var) {
            this.f7924a = a0Var;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f7924a.a(jSONObject.optInt("returncode"), jSONObject.optString("errormsg"));
            } catch (JSONException e) {
                e.printStackTrace();
                this.f7924a.a(-1, "json error");
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            this.f7924a.a(i, str);
        }
    }

    /* loaded from: classes2.dex */
    public interface c0 {
        void a(int i, String str);
    }

    /* loaded from: classes2.dex */
    class d implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c0 f7925a;

        d(c0 c0Var) {
            this.f7925a = c0Var;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("returncode");
                if (optInt == 0) {
                    VoD.this.searchStarRating();
                }
                this.f7925a.a(optInt, jSONObject.optString("errormsg"));
            } catch (JSONException e) {
                e.printStackTrace();
                this.f7925a.a(-1, "json error");
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            this.f7925a.a(i, str);
        }
    }

    /* loaded from: classes2.dex */
    public interface d0 {
        void a(int i, String str, String str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements SDKNetHTTPRequest.IHTTPRequestReturnListener {
        e() {
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("returncode") == 0) {
                    JSONArray jSONArray = jSONObject.getJSONArray("ratingnum");
                    JSONArray jSONArray2 = jSONObject.getJSONArray("ratingsum");
                    if (jSONArray.length() > 0) {
                        VoD.this.setRatingNum((String) jSONArray.get(0));
                    }
                    if (jSONArray2.length() > 0) {
                        VoD.this.setRatingSum((String) jSONArray2.get(0));
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
        }
    }

    /* loaded from: classes2.dex */
    public interface e0 {
        void a(int i, String str);
    }

    /* loaded from: classes2.dex */
    class f implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f0 f7928a;

        f(VoD voD, f0 f0Var) {
            this.f7928a = f0Var;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f7928a.a(jSONObject.optInt("returncode"), jSONObject.optString("errormsg"), jSONObject.optString("url"));
            } catch (JSONException e) {
                e.printStackTrace();
                this.f7928a.a(-1, "json error", null);
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            this.f7928a.a(i, str, null);
        }
    }

    /* loaded from: classes2.dex */
    public interface f0 {
        void a(int i, String str, String str2);
    }

    /* loaded from: classes2.dex */
    class g implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d0 f7929a;

        g(VoD voD, d0 d0Var) {
            this.f7929a = d0Var;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f7929a.a(jSONObject.optInt("returncode"), jSONObject.optString("errormsg"), jSONObject.optString("url"));
            } catch (JSONException e) {
                e.printStackTrace();
                this.f7929a.a(-1, "json error", null);
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            this.f7929a.a(i, str, null);
        }
    }

    /* loaded from: classes2.dex */
    public interface g0 {
        void a(int i, String str);
    }

    /* loaded from: classes2.dex */
    class h implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ e0 f7930a;

        h(VoD voD, e0 e0Var) {
            this.f7930a = e0Var;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f7930a.a(jSONObject.optInt("returncode"), jSONObject.optString("errormsg"));
            } catch (JSONException e) {
                e.printStackTrace();
                this.f7930a.a(-1, "json error");
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            this.f7930a.a(i, str);
        }
    }

    /* loaded from: classes2.dex */
    public interface h0 {
        void a(int i, String str);
    }

    /* loaded from: classes2.dex */
    class i implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ j0 f7931a;

        i(VoD voD, j0 j0Var) {
            this.f7931a = j0Var;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("returncode");
                if (optInt == 0) {
                    JSONArray jSONArray = jSONObject.getJSONArray("vodInfo");
                    int length = jSONArray.length();
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < length; i++) {
                        HashMap hashMap = new HashMap();
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        hashMap.put(ParamConst.VOD_MULTIPLE_URL_RSP_AUTH_RETURNCODE, jSONObject2.optString(ParamConst.VOD_MULTIPLE_URL_RSP_AUTH_RETURNCODE));
                        hashMap.put("playurl", jSONObject2.optString("playurl"));
                        hashMap.put("definition", jSONObject2.optString("definition"));
                        hashMap.put("programcode", jSONObject2.optString("programcode"));
                        hashMap.put("programtype", jSONObject2.optString("programtype"));
                        hashMap.put("columncode", jSONObject2.optString("columncode"));
                        hashMap.put(ParamConst.VOD_MULTIPLE_URL_RSP_EXPIRED_TIME, jSONObject2.optString(ParamConst.VOD_MULTIPLE_URL_RSP_EXPIRED_TIME));
                        arrayList.add(hashMap);
                    }
                    ArrayList<com.zte.iptvclient.common.video.c> arrayList2 = new ArrayList<>();
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        arrayList2.add(new com.zte.iptvclient.common.video.c((Map) arrayList.get(i2)));
                    }
                    this.f7931a.a(optInt, null, arrayList2);
                    return;
                }
                this.f7931a.a(optInt, jSONObject.optString("errormsg"), null);
            } catch (JSONException e) {
                e.printStackTrace();
                this.f7931a.a(-1, "json error", null);
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            this.f7931a.a(i, str, null);
        }
    }

    /* loaded from: classes2.dex */
    public interface i0 {
    }

    /* loaded from: classes2.dex */
    class j implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f7932a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ s f7933b;

        j(int i, s sVar) {
            this.f7932a = i;
            this.f7933b = sVar;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("returncode");
                String optString = jSONObject.optString("errormsg");
                if (optInt == 0) {
                    VoD.this.setBreakpoint(String.valueOf(this.f7932a));
                }
                this.f7933b.a(optInt, optString);
            } catch (JSONException e) {
                e.printStackTrace();
                this.f7933b.a(-1, "json error");
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            this.f7933b.a(i, str);
        }
    }

    /* loaded from: classes2.dex */
    public interface j0 {
        void a(int i, String str, ArrayList<com.zte.iptvclient.common.video.c> arrayList);
    }

    /* loaded from: classes2.dex */
    class k implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ u f7935a;

        k(u uVar) {
            this.f7935a = uVar;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("returncode");
                if (optInt == 0) {
                    VoD.this.setIsFavorite("1");
                }
                this.f7935a.a(optInt, jSONObject.optString("errormsg"));
            } catch (JSONException e) {
                e.printStackTrace();
                this.f7935a.a(-1, "json error");
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            this.f7935a.a(i, str);
        }
    }

    /* loaded from: classes2.dex */
    class l implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ z f7937a;

        l(z zVar) {
            this.f7937a = zVar;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("returncode");
                if (optInt == 0) {
                    VoD.this.setIsFavorite("0");
                }
                this.f7937a.a(optInt, jSONObject.optString("errormsg"));
            } catch (JSONException e) {
                e.printStackTrace();
                this.f7937a.a(-1, "json error");
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            this.f7937a.a(i, str);
        }
    }

    /* loaded from: classes2.dex */
    class m implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f7939a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ t f7940b;

        m(int i, t tVar) {
            this.f7939a = i;
            this.f7940b = tVar;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("returncode");
                if (optInt == 0) {
                    VoD.this.setBreakpoint(String.valueOf(this.f7939a));
                }
                this.f7940b.a(optInt, jSONObject.optString("errormsg"));
            } catch (JSONException e) {
                e.printStackTrace();
                this.f7940b.a(-1, "json error");
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            this.f7940b.a(i, str);
        }
    }

    /* loaded from: classes2.dex */
    class n implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ y f7942a;

        n(y yVar) {
            this.f7942a = yVar;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("returncode");
                if (optInt == 0) {
                    VoD.this.setBreakpoint("0");
                }
                this.f7942a.a(optInt, jSONObject.optString("errormsg"));
            } catch (JSONException e) {
                e.printStackTrace();
                this.f7942a.a(-1, "json error");
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            this.f7942a.a(i, str);
        }
    }

    /* loaded from: classes2.dex */
    class o implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ v f7944a;

        o(v vVar) {
            this.f7944a = vVar;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("returncode");
                if (optInt == 0) {
                    VoD.this.setIsLocked("0");
                }
                this.f7944a.a(optInt, jSONObject.optString("errormsg"));
            } catch (JSONException e) {
                e.printStackTrace();
                this.f7944a.a(-1, "json error");
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            this.f7944a.a(i, str);
        }
    }

    /* loaded from: classes2.dex */
    class p implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b0 f7946a;

        p(b0 b0Var) {
            this.f7946a = b0Var;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("returncode");
                if (optInt == 0) {
                    VoD.this.setIsLocked("1");
                }
                this.f7946a.a(optInt, jSONObject.optString("errormsg"));
            } catch (JSONException e) {
                e.printStackTrace();
                this.f7946a.a(-1, "json error");
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            this.f7946a.a(i, str);
        }
    }

    /* loaded from: classes2.dex */
    class q implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h0 f7948a;

        q(h0 h0Var) {
            this.f7948a = h0Var;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x004f A[Catch: JSONException -> 0x00a0, TRY_LEAVE, TryCatch #2 {JSONException -> 0x00a0, blocks: (B:3:0x0001, B:5:0x000e, B:8:0x001f, B:10:0x0043, B:12:0x004f, B:14:0x007f, B:16:0x0082, B:19:0x0091, B:22:0x0056, B:24:0x0061, B:26:0x0026, B:28:0x002b), top: B:2:0x0001, inners: #0, #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0082 A[Catch: JSONException -> 0x00a0, TryCatch #2 {JSONException -> 0x00a0, blocks: (B:3:0x0001, B:5:0x000e, B:8:0x001f, B:10:0x0043, B:12:0x004f, B:14:0x007f, B:16:0x0082, B:19:0x0091, B:22:0x0056, B:24:0x0061, B:26:0x0026, B:28:0x002b), top: B:2:0x0001, inners: #0, #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0091 A[Catch: JSONException -> 0x00a0, TRY_LEAVE, TryCatch #2 {JSONException -> 0x00a0, blocks: (B:3:0x0001, B:5:0x000e, B:8:0x001f, B:10:0x0043, B:12:0x004f, B:14:0x007f, B:16:0x0082, B:19:0x0091, B:22:0x0056, B:24:0x0061, B:26:0x0026, B:28:0x002b), top: B:2:0x0001, inners: #0, #1 }] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onDataReturn(java.lang.String r7) {
            /*
                r6 = this;
                r0 = -1
                org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> La0
                r1.<init>(r7)     // Catch: org.json.JSONException -> La0
                java.lang.String r7 = "returncode"
                int r7 = r1.optInt(r7)     // Catch: org.json.JSONException -> La0
                if (r7 != 0) goto Lab
                java.lang.String r7 = "limitlevel"
                java.lang.String r7 = r1.optString(r7)     // Catch: org.json.JSONException -> La0
                boolean r1 = android.text.TextUtils.isEmpty(r7)     // Catch: org.json.JSONException -> La0
                java.lang.String r2 = ") as an integer!"
                java.lang.String r3 = "VoD"
                r4 = 0
                if (r1 == 0) goto L26
                java.lang.String r7 = "strLimitLevel is empty!"
                com.video.androidsdk.log.LogEx.w(r3, r7)     // Catch: org.json.JSONException -> La0
            L24:
                r7 = 0
                goto L43
            L26:
                int r7 = java.lang.Integer.parseInt(r7)     // Catch: java.lang.NumberFormatException -> L2b org.json.JSONException -> La0
                goto L43
            L2b:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: org.json.JSONException -> La0
                r1.<init>()     // Catch: org.json.JSONException -> La0
                java.lang.String r5 = "Failed to parse strLimitLevel("
                r1.append(r5)     // Catch: org.json.JSONException -> La0
                r1.append(r7)     // Catch: org.json.JSONException -> La0
                r1.append(r2)     // Catch: org.json.JSONException -> La0
                java.lang.String r7 = r1.toString()     // Catch: org.json.JSONException -> La0
                com.video.androidsdk.log.LogEx.w(r3, r7)     // Catch: org.json.JSONException -> La0
                goto L24
            L43:
                com.zte.iptvclient.common.video.VoD r1 = com.zte.iptvclient.common.video.VoD.this     // Catch: org.json.JSONException -> La0
                java.lang.String r1 = com.zte.iptvclient.common.video.VoD.access$100(r1)     // Catch: org.json.JSONException -> La0
                boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: org.json.JSONException -> La0
                if (r1 == 0) goto L56
                java.lang.String r1 = "RatingId is empty!"
                com.video.androidsdk.log.LogEx.w(r3, r1)     // Catch: org.json.JSONException -> La0
            L54:
                r1 = 0
                goto L7f
            L56:
                com.zte.iptvclient.common.video.VoD r1 = com.zte.iptvclient.common.video.VoD.this     // Catch: java.lang.NumberFormatException -> L61 org.json.JSONException -> La0
                java.lang.String r1 = com.zte.iptvclient.common.video.VoD.access$100(r1)     // Catch: java.lang.NumberFormatException -> L61 org.json.JSONException -> La0
                int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.NumberFormatException -> L61 org.json.JSONException -> La0
                goto L7f
            L61:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: org.json.JSONException -> La0
                r1.<init>()     // Catch: org.json.JSONException -> La0
                java.lang.String r5 = "Failed to parse RatingId("
                r1.append(r5)     // Catch: org.json.JSONException -> La0
                com.zte.iptvclient.common.video.VoD r5 = com.zte.iptvclient.common.video.VoD.this     // Catch: org.json.JSONException -> La0
                java.lang.String r5 = com.zte.iptvclient.common.video.VoD.access$100(r5)     // Catch: org.json.JSONException -> La0
                r1.append(r5)     // Catch: org.json.JSONException -> La0
                r1.append(r2)     // Catch: org.json.JSONException -> La0
                java.lang.String r1 = r1.toString()     // Catch: org.json.JSONException -> La0
                com.video.androidsdk.log.LogEx.w(r3, r1)     // Catch: org.json.JSONException -> La0
                goto L54
            L7f:
                r7 = r7 & r1
                if (r7 != 0) goto L91
                com.zte.iptvclient.common.video.VoD r7 = com.zte.iptvclient.common.video.VoD.this     // Catch: org.json.JSONException -> La0
                java.lang.String r1 = "1"
                r7.setIsLocked(r1)     // Catch: org.json.JSONException -> La0
                com.zte.iptvclient.common.video.VoD$h0 r7 = r6.f7948a     // Catch: org.json.JSONException -> La0
                java.lang.String r1 = "no limitlock"
                r7.a(r0, r1)     // Catch: org.json.JSONException -> La0
                goto Lab
            L91:
                com.zte.iptvclient.common.video.VoD r7 = com.zte.iptvclient.common.video.VoD.this     // Catch: org.json.JSONException -> La0
                java.lang.String r1 = "0"
                r7.setIsLocked(r1)     // Catch: org.json.JSONException -> La0
                com.zte.iptvclient.common.video.VoD$h0 r7 = r6.f7948a     // Catch: org.json.JSONException -> La0
                java.lang.String r1 = "need to checklock"
                r7.a(r4, r1)     // Catch: org.json.JSONException -> La0
                goto Lab
            La0:
                r7 = move-exception
                r7.printStackTrace()
                com.zte.iptvclient.common.video.VoD$h0 r7 = r6.f7948a
                java.lang.String r1 = "json error"
                r7.a(r0, r1)
            Lab:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.common.video.VoD.q.onDataReturn(java.lang.String):void");
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            this.f7948a.a(i, str);
        }
    }

    /* loaded from: classes2.dex */
    class r implements SDKNetHTTPRequest.IHTTPRequestReturnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g0 f7950a;

        r(g0 g0Var) {
            this.f7950a = g0Var;
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onDataReturn(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("returncode");
                if (optInt == 0) {
                    VoD.this.setIsLocked("0");
                } else {
                    VoD.this.setIsLocked("1");
                }
                this.f7950a.a(optInt, jSONObject.optString("errormsg"));
            } catch (JSONException e) {
                e.printStackTrace();
                this.f7950a.a(-1, "json error");
            }
        }

        @Override // com.video.androidsdk.common.http.SDKNetHTTPRequest.IHTTPRequestReturnListener
        public void onFailReturn(int i, String str) {
            this.f7950a.a(i, str);
        }
    }

    /* loaded from: classes2.dex */
    public interface s {
        void a(int i, String str);
    }

    /* loaded from: classes2.dex */
    public interface t {
        void a(int i, String str);
    }

    /* loaded from: classes2.dex */
    public interface u {
        void a(int i, String str);
    }

    /* loaded from: classes2.dex */
    public interface v {
        void a(int i, String str);
    }

    /* loaded from: classes2.dex */
    public interface w {
        void a(int i, String str);
    }

    /* loaded from: classes2.dex */
    public interface x {
        void a(int i, String str);
    }

    /* loaded from: classes2.dex */
    public interface y {
        void a(int i, String str);
    }

    /* loaded from: classes2.dex */
    public interface z {
        void a(int i, String str);
    }

    public VoD(Map<String, Object> map) {
        init();
        vodMapToBean(map);
    }

    private static String analysisEachJason(JSONObject jSONObject, String str) {
        if (StringUtil.isEmptyString(str)) {
            return "";
        }
        try {
            return (String) jSONObject.get(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            LogEx.w(LOG_TAG, "Failed to parse json , JSONException : " + e2);
            return "";
        }
    }

    public static Map<String, Object> analysisJson(String str, List<Map<String, Object>> list) {
        HashMap hashMap = new HashMap();
        if (StringUtil.isEmptyString(str)) {
            LogEx.w(LOG_TAG, "strResponseJson is null");
            hashMap.put("returncode", Integer.valueOf(com.zte.iptvclient.common.uiframe.k.getErrCode(1506, 3)));
            return hashMap;
        }
        LogEx.d(LOG_TAG, "strResponseJson:" + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            LogEx.d(LOG_TAG, "jsonobject:" + jSONObject);
            int parseInt = Integer.parseInt((String) jSONObject.get("returncode"));
            hashMap.put("returncode", Integer.valueOf(parseInt));
            LogEx.d(LOG_TAG, "intReturnCode:" + parseInt);
            String str2 = (String) jSONObject.get("errormsg");
            hashMap.put("errormsg", str2);
            LogEx.d(LOG_TAG, "strMsg:" + str2);
            if (parseInt != 0) {
                LogEx.w(LOG_TAG, "the json String is error.strMsg:" + str2);
                return hashMap;
            }
            int parseInt2 = Integer.parseInt((String) jSONObject.get("totalcount"));
            hashMap.put("totalcount", (String) jSONObject.get("totalcount"));
            LogEx.d(LOG_TAG, "totalcount: " + parseInt2);
            if (parseInt2 <= 0) {
                LogEx.w(LOG_TAG, "totalcount <= 0");
                hashMap.put("totalcount", String.valueOf(0));
                hashMap.put("returncode", 0);
                return hashMap;
            }
            JSONArray jSONArray = jSONObject.getJSONArray("vodInfo");
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                Map<String, Object> hashMap2 = new HashMap<>();
                analysisPublicJson(jSONArray.getJSONObject(i2), hashMap2);
                if (jSONArray.getJSONObject(i2).has(ParamConst.VOD_DETAIL_QUERY_RSP_VIDEOINFO)) {
                    JSONArray jSONArray2 = jSONArray.getJSONObject(i2).getJSONArray(ParamConst.VOD_DETAIL_QUERY_RSP_VIDEOINFO);
                    if (jSONArray2.length() <= 0) {
                        hashMap2.put(ParamConst.VOD_DETAIL_QUERY_RSP_VIDEOINFO, null);
                    }
                    List<com.zte.iptvclient.common.video.d> analysisVideoInfoJson = analysisVideoInfoJson(jSONArray2);
                    if (analysisVideoInfoJson != null) {
                        hashMap2.put(ParamConst.VOD_DETAIL_QUERY_RSP_VIDEOINFO, analysisVideoInfoJson);
                        LogEx.d(LOG_TAG, "videoinfo: " + analysisVideoInfoJson.size());
                    }
                    LogEx.d(LOG_TAG, "videoinfo: " + ((List) hashMap2.get(ParamConst.VOD_DETAIL_QUERY_RSP_VIDEOINFO)).size());
                } else if (jSONArray.getJSONObject(i2).has("vodInfo")) {
                    JSONArray jSONArray3 = jSONArray.getJSONObject(i2).getJSONArray("vodInfo");
                    if (jSONArray3.length() <= 0) {
                        hashMap2.put("vodInfo", null);
                    }
                    List<com.zte.iptvclient.common.video.d> analysisVideoInfoJson2 = analysisVideoInfoJson(jSONArray3);
                    if (analysisVideoInfoJson2 != null) {
                        hashMap2.put("vodInfo", analysisVideoInfoJson2);
                        LogEx.d(LOG_TAG, "vodifo: " + analysisVideoInfoJson2.size());
                        LogEx.d(LOG_TAG, "vodifo: " + ((List) hashMap2.get("vodInfo")).size());
                    }
                }
                list.add(hashMap2);
            }
            LogEx.d(LOG_TAG, "rsp: showview" + list.toString());
            LogEx.d(LOG_TAG, "rsp: showview" + list.size());
            return hashMap;
        } catch (Exception e2) {
            e2.printStackTrace();
            LogEx.w(LOG_TAG, "Failed to parse jason:" + str);
            return null;
        }
    }

    private static void analysisPublicJson(JSONObject jSONObject, Map<String, Object> map) {
        if (jSONObject != null && map != null) {
            if (jSONObject.has("actor")) {
                map.put("actor", analysisEachJason(jSONObject, "actor"));
            }
            if (jSONObject.has(ParamConst.VOD_DETAIL_QUERY_RSP_ACTORSEARCHKEY)) {
                map.put(ParamConst.VOD_DETAIL_QUERY_RSP_ACTORSEARCHKEY, analysisEachJason(jSONObject, ParamConst.VOD_DETAIL_QUERY_RSP_ACTORSEARCHKEY));
            }
            if (jSONObject.has("advertisecontent")) {
                map.put("advertisecontent", analysisEachJason(jSONObject, "advertisecontent"));
            }
            if (jSONObject.has("archivemode")) {
                map.put("archivemode", analysisEachJason(jSONObject, "archivemode"));
            }
            if (jSONObject.has(ParamConst.VOD_DETAIL_QUERY_RSP_ASPECT)) {
                map.put(ParamConst.VOD_DETAIL_QUERY_RSP_ASPECT, analysisEachJason(jSONObject, ParamConst.VOD_DETAIL_QUERY_RSP_ASPECT));
            }
            if (jSONObject.has("audiolang")) {
                map.put("audiolang", analysisEachJason(jSONObject, "audiolang"));
            }
            if (jSONObject.has("bocode")) {
                map.put("bocode", analysisEachJason(jSONObject, "bocode"));
            }
            if (jSONObject.has(ParamConst.VOD_DETAIL_QUERY_RSP_CATAGORYCODE)) {
                map.put(ParamConst.VOD_DETAIL_QUERY_RSP_CATAGORYCODE, analysisEachJason(jSONObject, ParamConst.VOD_DETAIL_QUERY_RSP_CATAGORYCODE));
            }
            if (jSONObject.has(ParamConst.VOD_DETAIL_QUERY_RSP_CATALOGNAME)) {
                map.put(ParamConst.VOD_DETAIL_QUERY_RSP_CATALOGNAME, analysisEachJason(jSONObject, ParamConst.VOD_DETAIL_QUERY_RSP_CATALOGNAME));
            }
            if (jSONObject.has(ParamConst.VOD_DETAIL_QUERY_RSP_CATALOGTYPE)) {
                map.put(ParamConst.VOD_DETAIL_QUERY_RSP_CATALOGTYPE, analysisEachJason(jSONObject, ParamConst.VOD_DETAIL_QUERY_RSP_CATALOGTYPE));
            }
            if (jSONObject.has("channelcode")) {
                map.put("channelcode", analysisEachJason(jSONObject, "channelcode"));
            }
            if (jSONObject.has("columncode")) {
                map.put("columncode", analysisEachJason(jSONObject, "columncode"));
            }
            if (jSONObject.has("contentcode")) {
                map.put("contentcode", analysisEachJason(jSONObject, "contentcode"));
            }
            if (jSONObject.has("copyprotection")) {
                map.put("copyprotection", analysisEachJason(jSONObject, "copyprotection"));
            }
            if (jSONObject.has("countryname")) {
                map.put("countryname", analysisEachJason(jSONObject, "countryname"));
            }
            if (jSONObject.has("cpcode")) {
                map.put("cpcode", analysisEachJason(jSONObject, "cpcode"));
            }
            if (jSONObject.has("cpname")) {
                map.put("cpname", analysisEachJason(jSONObject, "cpname"));
            }
            if (jSONObject.has("createtime")) {
                map.put("createtime", analysisEachJason(jSONObject, "createtime"));
            }
            if (jSONObject.has("description")) {
                map.put("description", analysisEachJason(jSONObject, "description"));
            }
            if (jSONObject.has(ParamConst.VOD_DETAIL_QUERY_RSP_DESCRIPTIONKEY)) {
                map.put(ParamConst.VOD_DETAIL_QUERY_RSP_DESCRIPTIONKEY, analysisEachJason(jSONObject, ParamConst.VOD_DETAIL_QUERY_RSP_DESCRIPTIONKEY));
            }
            if (jSONObject.has("detaildescribed")) {
                map.put("detaildescribed", analysisEachJason(jSONObject, "detaildescribed"));
            }
            if (jSONObject.has("director")) {
                map.put("director", analysisEachJason(jSONObject, "director"));
            }
            if (jSONObject.has(ParamConst.VOD_DETAIL_QUERY_RSP_DIRECTORSEARCHKEY)) {
                map.put(ParamConst.VOD_DETAIL_QUERY_RSP_DIRECTORSEARCHKEY, analysisEachJason(jSONObject, ParamConst.VOD_DETAIL_QUERY_RSP_DIRECTORSEARCHKEY));
            }
            if (jSONObject.has(ParamConst.VOD_DETAIL_QUERY_RSP_DISABLEDTIME)) {
                map.put(ParamConst.VOD_DETAIL_QUERY_RSP_DISABLEDTIME, analysisEachJason(jSONObject, ParamConst.VOD_DETAIL_QUERY_RSP_DISABLEDTIME));
            }
            if (jSONObject.has("dolby")) {
                map.put("dolby", analysisEachJason(jSONObject, "dolby"));
            }
            if (jSONObject.has("elapsedtime")) {
                map.put("elapsedtime", analysisEachJason(jSONObject, "elapsedtime"));
            }
            if (jSONObject.has(ParamConst.VOD_DETAIL_QUERY_RSP_ENABLEDTIME)) {
                map.put(ParamConst.VOD_DETAIL_QUERY_RSP_ENABLEDTIME, analysisEachJason(jSONObject, ParamConst.VOD_DETAIL_QUERY_RSP_ENABLEDTIME));
            }
            if (jSONObject.has("episodetitle")) {
                map.put("episodetitle", analysisEachJason(jSONObject, "episodetitle"));
            }
            if (jSONObject.has(ParamConst.VOD_DETAIL_QUERY_RSP_FORMAT)) {
                map.put(ParamConst.VOD_DETAIL_QUERY_RSP_FORMAT, analysisEachJason(jSONObject, ParamConst.VOD_DETAIL_QUERY_RSP_FORMAT));
            }
            if (jSONObject.has("genre")) {
                map.put("genre", analysisEachJason(jSONObject, "genre"));
            }
            if (jSONObject.has("is3Sfavorite")) {
                map.put("is3Sfavorite", analysisEachJason(jSONObject, "is3Sfavorite"));
            }
            if (jSONObject.has("isarchivemode")) {
                map.put("isarchivemode", analysisEachJason(jSONObject, "isarchivemode"));
            }
            if (jSONObject.has("isfavorite")) {
                map.put("isfavorite", analysisEachJason(jSONObject, "isfavorite"));
            }
            if (jSONObject.has(ParamConst.VOD_DETAIL_QUERY_RSP_ISFIRSTPAGE)) {
                map.put(ParamConst.VOD_DETAIL_QUERY_RSP_ISFIRSTPAGE, analysisEachJason(jSONObject, ParamConst.VOD_DETAIL_QUERY_RSP_ISFIRSTPAGE));
            }
            if (jSONObject.has("ishot")) {
                map.put("ishot", analysisEachJason(jSONObject, "ishot"));
            }
            if (jSONObject.has("islocked")) {
                map.put("islocked", analysisEachJason(jSONObject, "islocked"));
            }
            if (jSONObject.has("isprotection")) {
                map.put("isprotection", analysisEachJason(jSONObject, "isprotection"));
            }
            if (jSONObject.has("isrecommend")) {
                map.put("isrecommend", analysisEachJason(jSONObject, "isrecommend"));
            }
            if (jSONObject.has(ParamConst.VOD_DETAIL_QUERY_RSP_ISSIMPLETRAILER)) {
                map.put(ParamConst.VOD_DETAIL_QUERY_RSP_ISSIMPLETRAILER, analysisEachJason(jSONObject, ParamConst.VOD_DETAIL_QUERY_RSP_ISSIMPLETRAILER));
            }
            if (jSONObject.has("istimeshift")) {
                map.put("istimeshift", analysisEachJason(jSONObject, "istimeshift"));
            }
            if (jSONObject.has("language")) {
                map.put("language", analysisEachJason(jSONObject, "language"));
            }
            if (jSONObject.has(ParamConst.VOD_DETAIL_QUERY_RSP_LICENSEPERIOD)) {
                map.put(ParamConst.VOD_DETAIL_QUERY_RSP_LICENSEPERIOD, analysisEachJason(jSONObject, ParamConst.VOD_DETAIL_QUERY_RSP_LICENSEPERIOD));
            }
            if (jSONObject.has("mediacode")) {
                map.put("mediacode", analysisEachJason(jSONObject, "mediacode"));
            }
            if (jSONObject.has("mediaservices")) {
                map.put("mediaservices", analysisEachJason(jSONObject, "mediaservices"));
            }
            if (jSONObject.has(ParamConst.VOD_DETAIL_QUERY_RSP_OFFLINETIME)) {
                map.put(ParamConst.VOD_DETAIL_QUERY_RSP_OFFLINETIME, analysisEachJason(jSONObject, ParamConst.VOD_DETAIL_QUERY_RSP_OFFLINETIME));
            }
            if (jSONObject.has("onlinetime")) {
                map.put("onlinetime", analysisEachJason(jSONObject, "onlinetime"));
            }
            if (jSONObject.has("parentaladvisory")) {
                map.put("parentaladvisory", analysisEachJason(jSONObject, "parentaladvisory"));
            }
            if (jSONObject.has("posterfilelist")) {
                map.put("posterfilelist", analysisEachJason(jSONObject, "posterfilelist"));
            }
            if (jSONObject.has("posterpath")) {
                map.put("posterpath", analysisEachJason(jSONObject, "posterpath"));
            }
            if (jSONObject.has("price")) {
                map.put("price", analysisEachJason(jSONObject, "price"));
            }
            if (jSONObject.has("programcode")) {
                map.put("programcode", analysisEachJason(jSONObject, "programcode"));
            }
            if (jSONObject.has("programname")) {
                map.put("programname", analysisEachJason(jSONObject, "programname"));
            }
            if (jSONObject.has(ParamConst.VOD_DETAIL_QUERY_RSP_PROGRAMNAMELEN)) {
                map.put(ParamConst.VOD_DETAIL_QUERY_RSP_PROGRAMNAMELEN, analysisEachJason(jSONObject, ParamConst.VOD_DETAIL_QUERY_RSP_PROGRAMNAMELEN));
            }
            if (jSONObject.has(ParamConst.VOD_DETAIL_QUERY_RSP_PROGRAMSEARCHKEY)) {
                map.put(ParamConst.VOD_DETAIL_QUERY_RSP_PROGRAMSEARCHKEY, analysisEachJason(jSONObject, ParamConst.VOD_DETAIL_QUERY_RSP_PROGRAMSEARCHKEY));
            }
            if (jSONObject.has("programtype")) {
                map.put("programtype", analysisEachJason(jSONObject, "programtype"));
            }
            if (jSONObject.has(ParamConst.VOD_DETAIL_QUERY_RSP_PUBCOMPANY)) {
                map.put(ParamConst.VOD_DETAIL_QUERY_RSP_PUBCOMPANY, analysisEachJason(jSONObject, ParamConst.VOD_DETAIL_QUERY_RSP_PUBCOMPANY));
            }
            if (jSONObject.has("ratingid")) {
                map.put("ratingid", analysisEachJason(jSONObject, "ratingid"));
            }
            if (jSONObject.has("ratingnum")) {
                map.put("ratingnum", analysisEachJason(jSONObject, "ratingnum"));
            }
            if (jSONObject.has("ratingsum")) {
                map.put("ratingsum", analysisEachJason(jSONObject, "ratingsum"));
            }
            if (jSONObject.has(ParamConst.VOD_DETAIL_QUERY_RSP_RECOMMENDID)) {
                map.put(ParamConst.VOD_DETAIL_QUERY_RSP_RECOMMENDID, analysisEachJason(jSONObject, ParamConst.VOD_DETAIL_QUERY_RSP_RECOMMENDID));
            }
            if (jSONObject.has("releasedate")) {
                map.put("releasedate", analysisEachJason(jSONObject, "releasedate"));
            }
            if (jSONObject.has("seriesnum")) {
                map.put("seriesnum", analysisEachJason(jSONObject, "seriesnum"));
            }
            if (jSONObject.has("seriesprogramcode")) {
                map.put("seriesprogramcode", analysisEachJason(jSONObject, "seriesprogramcode"));
            }
            if (jSONObject.has(ParamConst.VOD_DETAIL_QUERY_RSP_SERIESSEASON)) {
                map.put(ParamConst.VOD_DETAIL_QUERY_RSP_SERIESSEASON, analysisEachJason(jSONObject, ParamConst.VOD_DETAIL_QUERY_RSP_SERIESSEASON));
            }
            if (jSONObject.has(ParamConst.VOD_DETAIL_QUERY_RSP_SHORTDESC)) {
                map.put(ParamConst.VOD_DETAIL_QUERY_RSP_SHORTDESC, analysisEachJason(jSONObject, ParamConst.VOD_DETAIL_QUERY_RSP_SHORTDESC));
            }
            if (jSONObject.has(ParamConst.VOD_DETAIL_QUERY_RSP_SHORTTITLE)) {
                map.put(ParamConst.VOD_DETAIL_QUERY_RSP_SHORTTITLE, analysisEachJason(jSONObject, ParamConst.VOD_DETAIL_QUERY_RSP_SHORTTITLE));
            }
            if (jSONObject.has("sortnum")) {
                map.put("sortnum", analysisEachJason(jSONObject, "sortnum"));
            }
            if (jSONObject.has("starlevel")) {
                map.put("starlevel", analysisEachJason(jSONObject, "starlevel"));
            }
            if (jSONObject.has("subgenre")) {
                map.put("subgenre", analysisEachJason(jSONObject, "subgenre"));
            }
            if (jSONObject.has("subtitlelang")) {
                map.put("subtitlelang", analysisEachJason(jSONObject, "subtitlelang"));
            }
            if (jSONObject.has("telecomcode")) {
                map.put("telecomcode", analysisEachJason(jSONObject, "telecomcode"));
            }
            if (jSONObject.has("timeshiftmode")) {
                map.put("timeshiftmode", analysisEachJason(jSONObject, "timeshiftmode"));
            }
            if (jSONObject.has(ParamConst.VOD_DETAIL_QUERY_RSP_TRAILERBEGINTIME)) {
                map.put(ParamConst.VOD_DETAIL_QUERY_RSP_TRAILERBEGINTIME, analysisEachJason(jSONObject, ParamConst.VOD_DETAIL_QUERY_RSP_TRAILERBEGINTIME));
            }
            if (jSONObject.has(ParamConst.VOD_DETAIL_QUERY_RSP_TRAILERENDTIME)) {
                map.put(ParamConst.VOD_DETAIL_QUERY_RSP_TRAILERENDTIME, analysisEachJason(jSONObject, ParamConst.VOD_DETAIL_QUERY_RSP_TRAILERENDTIME));
            }
            if (jSONObject.has(ParamConst.VOD_DETAIL_QUERY_RSP_WGGENRE)) {
                map.put(ParamConst.VOD_DETAIL_QUERY_RSP_WGGENRE, analysisEachJason(jSONObject, ParamConst.VOD_DETAIL_QUERY_RSP_WGGENRE));
            }
            if (jSONObject.has(ParamConst.VOD_DETAIL_QUERY_RSP_WGKEYWORDS)) {
                map.put(ParamConst.VOD_DETAIL_QUERY_RSP_WGKEYWORDS, analysisEachJason(jSONObject, ParamConst.VOD_DETAIL_QUERY_RSP_WGKEYWORDS));
            }
            if (jSONObject.has(ParamConst.VOD_DETAIL_QUERY_RSP_WGTAGS)) {
                map.put(ParamConst.VOD_DETAIL_QUERY_RSP_WGTAGS, analysisEachJason(jSONObject, ParamConst.VOD_DETAIL_QUERY_RSP_WGTAGS));
            }
            if (jSONObject.has("writer")) {
                map.put("writer", analysisEachJason(jSONObject, "writer"));
            }
            if (jSONObject.has("breakpoint")) {
                map.put("breakpoint", analysisEachJason(jSONObject, "breakpoint"));
            }
            if (jSONObject.has("bookmarktype")) {
                map.put("bookmarktype", analysisEachJason(jSONObject, "bookmarktype"));
            }
            if (jSONObject.has(ParamConst.VOD_DETAIL_QUERY_RSP_TRAILER)) {
                map.put(ParamConst.VOD_DETAIL_QUERY_RSP_TRAILER, analysisEachJason(jSONObject, ParamConst.VOD_DETAIL_QUERY_RSP_TRAILER));
            }
            if (jSONObject.has(ParamConst.VOD_DETAIL_QUERY_RSP_ISTRAILER)) {
                map.put(ParamConst.VOD_DETAIL_QUERY_RSP_ISTRAILER, analysisEachJason(jSONObject, ParamConst.VOD_DETAIL_QUERY_RSP_ISTRAILER));
            }
            if (jSONObject.has(ParamConst.VOD_DETAIL_QUERY_RSP_UPDATENNUM)) {
                map.put(ParamConst.VOD_DETAIL_QUERY_RSP_UPDATENNUM, analysisEachJason(jSONObject, ParamConst.VOD_DETAIL_QUERY_RSP_UPDATENNUM));
            }
            if (jSONObject.has(ParamConst.VOD_DETAIL_QUERY_RSP_EPISODEBREAKPOINT)) {
                map.put(ParamConst.VOD_DETAIL_QUERY_RSP_EPISODEBREAKPOINT, analysisEachJason(jSONObject, ParamConst.VOD_DETAIL_QUERY_RSP_EPISODEBREAKPOINT));
            }
            if (jSONObject.has(ParamConst.VOD_DETAIL_QUERY_RSP_EPISODEPROGRAMNAME)) {
                map.put(ParamConst.VOD_DETAIL_QUERY_RSP_EPISODEPROGRAMNAME, analysisEachJason(jSONObject, ParamConst.VOD_DETAIL_QUERY_RSP_EPISODEPROGRAMNAME));
            }
            if (jSONObject.has("viewingtime")) {
                map.put("viewingtime", analysisEachJason(jSONObject, "viewingtime"));
            }
            if (jSONObject.has("vrflag")) {
                map.put("vrflag", analysisEachJason(jSONObject, "vrflag"));
                return;
            }
            return;
        }
        LogEx.w(LOG_TAG, "jsonobject or programMap is null");
    }

    private static List<com.zte.iptvclient.common.video.d> analysisVideoInfoJson(JSONArray jSONArray) {
        String str = "vrflag";
        String str2 = "ispurchased";
        if (jSONArray == null) {
            LogEx.w(LOG_TAG, "jsonobject or programMap is null");
            return null;
        }
        try {
            int length = jSONArray.length();
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            while (i2 < length) {
                int i3 = length;
                com.zte.iptvclient.common.video.d dVar = new com.zte.iptvclient.common.video.d();
                String str3 = str;
                if (jSONArray.getJSONObject(i2).has(ParamConst.VOD_DETAIL_QUERY_RSP_VIDEOCODE)) {
                    dVar.h(analysisEachJason(jSONArray.getJSONObject(i2), ParamConst.VOD_DETAIL_QUERY_RSP_VIDEOCODE));
                }
                if (jSONArray.getJSONObject(i2).has("mediaservice")) {
                    dVar.g(analysisEachJason(jSONArray.getJSONObject(i2), "mediaservice"));
                }
                if (jSONArray.getJSONObject(i2).has(ParamConst.VOD_DETAIL_QUERY_RSP_VIDEOTYPE)) {
                    dVar.l(analysisEachJason(jSONArray.getJSONObject(i2), ParamConst.VOD_DETAIL_QUERY_RSP_VIDEOTYPE));
                }
                if (jSONArray.getJSONObject(i2).has("definition")) {
                    dVar.d(analysisEachJason(jSONArray.getJSONObject(i2), "definition"));
                }
                if (jSONArray.getJSONObject(i2).has(ParamConst.VOD_DETAIL_QUERY_RSP_VIDEOMEDIACODE)) {
                    dVar.j(analysisEachJason(jSONArray.getJSONObject(i2), ParamConst.VOD_DETAIL_QUERY_RSP_VIDEOMEDIACODE));
                }
                if (jSONArray.getJSONObject(i2).has(ParamConst.VOD_DETAIL_QUERY_RSP_VIDEOTELECOMCODE)) {
                    dVar.k(analysisEachJason(jSONArray.getJSONObject(i2), ParamConst.VOD_DETAIL_QUERY_RSP_VIDEOTELECOMCODE));
                }
                if (jSONArray.getJSONObject(i2).has("bitrate")) {
                    dVar.a(analysisEachJason(jSONArray.getJSONObject(i2), "bitrate"));
                }
                if (jSONArray.getJSONObject(i2).has(ParamConst.VOD_DETAIL_QUERY_RSP_VIDEOELAPSEDTIME)) {
                    dVar.i(analysisEachJason(jSONArray.getJSONObject(i2), ParamConst.VOD_DETAIL_QUERY_RSP_VIDEOELAPSEDTIME));
                }
                if (jSONArray.getJSONObject(i2).has(ParamConst.VOD_DETAIL_QUERY_RSP_ENCRYPTTYPE)) {
                    dVar.e(analysisEachJason(jSONArray.getJSONObject(i2), ParamConst.VOD_DETAIL_QUERY_RSP_ENCRYPTTYPE));
                }
                if (jSONArray.getJSONObject(i2).has(ParamConst.VOD_DETAIL_QUERY_RSP_CNTMEDIACODE)) {
                    dVar.b(analysisEachJason(jSONArray.getJSONObject(i2), ParamConst.VOD_DETAIL_QUERY_RSP_CNTMEDIACODE));
                }
                if (jSONArray.getJSONObject(i2).has(ParamConst.VOD_DETAIL_QUERY_RSP_CNTTELECOMCODE)) {
                    dVar.c(analysisEachJason(jSONArray.getJSONObject(i2), ParamConst.VOD_DETAIL_QUERY_RSP_CNTTELECOMCODE));
                }
                if (jSONArray.getJSONObject(i2).has(str2)) {
                    dVar.f(analysisEachJason(jSONArray.getJSONObject(i2), str2));
                }
                String str4 = str2;
                if (jSONArray.getJSONObject(i2).has(str3)) {
                    dVar.m(analysisEachJason(jSONArray.getJSONObject(i2), str3));
                }
                ArrayList arrayList2 = arrayList;
                arrayList2.add(dVar);
                i2++;
                arrayList = arrayList2;
                str = str3;
                length = i3;
                str2 = str4;
            }
            return arrayList;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private BookmarkType getBookmarkType(String str) {
        if (str.equals("14")) {
            return BookmarkType.TYPE_BOOKMARK_SERIES;
        }
        return BookmarkType.TYPE_BOOKMARK_PROGRAM;
    }

    private ContentType getContentType(String str) {
        if (str.equals("14")) {
            return ContentType.TYPE_CONTENT_TV_SERIES_HEAD;
        }
        return ContentType.TYPE_CONTENT_NORMAL_VOD;
    }

    public static String getExtendFields() {
        return ExtendFields;
    }

    public static List<String> getExtendRspFields() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ParamConst.VOD_DETAIL_QUERY_RSP_PROGRAMNAMELEN);
        arrayList.add("isrecommend");
        arrayList.add("ishot");
        arrayList.add(ParamConst.VOD_DETAIL_QUERY_RSP_ISFIRSTPAGE);
        arrayList.add(ParamConst.VOD_DETAIL_QUERY_RSP_CATAGORYCODE);
        arrayList.add("bocode");
        arrayList.add(ParamConst.VOD_DETAIL_QUERY_RSP_PROGRAMSEARCHKEY);
        arrayList.add(ParamConst.VOD_DETAIL_QUERY_RSP_RECOMMENDID);
        arrayList.add("telecomcode");
        arrayList.add("mediacode");
        arrayList.add(ParamConst.VOD_DETAIL_QUERY_RSP_WGGENRE);
        arrayList.add(ParamConst.VOD_DETAIL_QUERY_RSP_WGKEYWORDS);
        arrayList.add(ParamConst.VOD_DETAIL_QUERY_RSP_WGTAGS);
        arrayList.add(ParamConst.VOD_DETAIL_QUERY_RSP_DIRECTORSEARCHKEY);
        arrayList.add(ParamConst.VOD_DETAIL_QUERY_RSP_ACTORSEARCHKEY);
        arrayList.add("cpcode");
        arrayList.add("cpname");
        arrayList.add("isarchivemode");
        arrayList.add("isprotection");
        arrayList.add("archivemode");
        arrayList.add("copyprotection");
        arrayList.add("dolby");
        arrayList.add(ParamConst.VOD_DETAIL_QUERY_RSP_VIDEOMEDIACODE);
        arrayList.add(ParamConst.VOD_DETAIL_QUERY_RSP_VIDEOTELECOMCODE);
        arrayList.add("bitrate");
        arrayList.add(ParamConst.VOD_DETAIL_QUERY_RSP_CNTMEDIACODE);
        arrayList.add(ParamConst.VOD_DETAIL_QUERY_RSP_CNTTELECOMCODE);
        return arrayList;
    }

    private FavoriteType getFavoriteType(String str) {
        if (str.equals("14")) {
            return FavoriteType.TYPE_FAVORITE_SERIES;
        }
        return FavoriteType.TYPE_FAVORITE_PROGRAM;
    }

    private LimitType getLimitType(String str) {
        if (str.equals("14")) {
            return LimitType.TYPE_LIMIT_SERIES;
        }
        return LimitType.TYPE_LIMIT_PROGRAM;
    }

    private void getVodInfoLoaderStart() {
        com.zte.iptvclient.common.video.b bVar = this.mGetVodReq;
        if (bVar == null) {
            LogEx.w(LOG_TAG, "mGetVodReq is null");
        } else {
            bVar.a();
            throw null;
        }
    }

    private void init() {
        this.videoInfoList = new ArrayList();
        List<String> extendRspFields = getExtendRspFields();
        this.extendFiledsList = extendRspFields;
        ExtendFields = listToString(extendRspFields);
    }

    public static String listToString(List<String> list) {
        if (list == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z2 = false;
        for (String str : list) {
            if (z2) {
                sb.append(",");
            } else {
                z2 = true;
            }
            sb.append(str);
        }
        return sb.toString();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        LogEx.d(VoD.class.getName(), "readObject");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void searchStarRating() {
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setParam("contentcodes", this.ContentCode);
        sDKNetHTTPRequest.setParam("contenttypes", String.valueOf(getContentType(this.ProgramType).getIntValue()));
        sDKNetHTTPRequest.startRequest(String.format("%sdatasource/querystarrating.jsp", d.e.a.a.c.a()), HttpRequest.METHOD_GET, new e());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        LogEx.d(VoD.class.getName(), "writeObject");
    }

    public void addBookmark(int i2, t tVar) {
        if (tVar == null) {
            return;
        }
        if (StringUtil.isEmptyString(this.ContentCode)) {
            LogEx.w(LOG_TAG, "contentCode is null");
            return;
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setParam("bookmarktype", String.valueOf(getBookmarkType(this.ProgramType).getIntValue()));
        sDKNetHTTPRequest.setParam("contentcode", this.ContentCode);
        sDKNetHTTPRequest.setParam("columncode", this.ColumnCode);
        sDKNetHTTPRequest.setParam("breakpoint", String.valueOf(i2));
        if (d.e.a.a.a.c()) {
            sDKNetHTTPRequest.setParam("isshared", "1");
        } else {
            sDKNetHTTPRequest.setParam("isshared", "0");
        }
        sDKNetHTTPRequest.setParam("limitaction", d.e.a.a.a.a());
        sDKNetHTTPRequest.setParam("terminalflag", "");
        sDKNetHTTPRequest.startRequest(String.format("%sdatasource/doaddbookmark.jsp", d.e.a.a.c.a()), HttpRequest.METHOD_GET, new m(i2, tVar));
    }

    public void addBookmarkForDividePlatform(int i2, String str, s sVar) {
        if (StringUtil.isEmptyString(this.ContentCode)) {
            LogEx.w(LOG_TAG, "contentCode is null");
            return;
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setParam("columncode", this.ColumnCode);
        sDKNetHTTPRequest.setParam("contentcode", this.ContentCode);
        sDKNetHTTPRequest.setParam("bookmarktype", String.valueOf(getBookmarkType(this.ProgramType).getIntValue()));
        if (d.e.a.a.a.c()) {
            sDKNetHTTPRequest.setParam("isshared", "1");
        } else {
            sDKNetHTTPRequest.setParam("isshared", "0");
        }
        sDKNetHTTPRequest.setParam("breakpoint", String.valueOf(i2));
        sDKNetHTTPRequest.setParam("binduserid", str);
        sDKNetHTTPRequest.setParam("copyright", this.isProtection);
        sDKNetHTTPRequest.startRequest(String.format("%s%s/addbookmarkbind.jsp", d.e.a.a.c.a(), SDKLoginMgr.getInstance().getUserInfo("StypeUrl")), HttpRequest.METHOD_GET, new j(i2, sVar));
    }

    public void addFavorite(u uVar) {
        if (uVar == null) {
            return;
        }
        if (StringUtil.isEmptyString(this.ContentCode)) {
            LogEx.w(LOG_TAG, "ContentCode is null");
            return;
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setParam("favoritetype", String.valueOf(getFavoriteType(this.ProgramType).getIntValue()));
        sDKNetHTTPRequest.setParam("contentcode", this.ContentCode);
        sDKNetHTTPRequest.setParam("columncode", this.ColumnCode);
        if (d.e.a.a.a.c()) {
            sDKNetHTTPRequest.setParam("isshared", "1");
        } else {
            sDKNetHTTPRequest.setParam("isshared", "0");
        }
        sDKNetHTTPRequest.setParam("limitaction", d.e.a.a.a.a());
        sDKNetHTTPRequest.setParam("dirid", "0");
        sDKNetHTTPRequest.startRequest(String.format("%sdatasource/doaddfavorite.jsp", d.e.a.a.c.a()), HttpRequest.METHOD_GET, new k(uVar));
    }

    public void addLock(v vVar) {
        if (vVar == null) {
            return;
        }
        if (StringUtil.isEmptyString(this.ContentCode)) {
            LogEx.w(LOG_TAG, "ContentCode is null");
            return;
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setParam("limittype", String.valueOf(getLimitType(this.ProgramType).getIntValue()));
        sDKNetHTTPRequest.setParam("contentcode", this.ContentCode);
        if (d.e.a.a.a.c()) {
            sDKNetHTTPRequest.setParam("isshared", "1");
        } else {
            sDKNetHTTPRequest.setParam("isshared", "0");
        }
        sDKNetHTTPRequest.setParam("limitaction", d.e.a.a.a.a());
        sDKNetHTTPRequest.setParam("terminalflag", "");
        if (d.e.a.a.a.b()) {
            sDKNetHTTPRequest.setParam("blocktitleenable", "1");
        } else {
            sDKNetHTTPRequest.setParam("blocktitleenable", "0");
        }
        sDKNetHTTPRequest.startRequest(String.format("%sdatasource/doaddlimit.jsp", d.e.a.a.c.a()), HttpRequest.METHOD_GET, new o(vVar));
    }

    public void addViewRecord(String str, w wVar) {
        if (wVar == null) {
            return;
        }
        if (StringUtil.isEmptyString(this.ContentCode)) {
            LogEx.w(LOG_TAG, "ContentCode is null");
            return;
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setParam("userid", SDKLoginMgr.getInstance().getUserID());
        sDKNetHTTPRequest.setParam("columncode", this.ColumnCode);
        sDKNetHTTPRequest.setParam("contentcode", this.ContentCode);
        sDKNetHTTPRequest.setParam("contentname", str);
        sDKNetHTTPRequest.setParam("limitaction", d.e.a.a.a.a());
        sDKNetHTTPRequest.startRequest(String.format("%sdatasource/doaddviewrecord.jsp", d.e.a.a.c.a()), HttpRequest.METHOD_GET, new b(this, wVar));
    }

    public void cancelCallBack() {
        this.vodInfoReturnListener = null;
    }

    public void checkLock(String str, x xVar) {
        if (xVar == null) {
            return;
        }
        if (str == null) {
            LogEx.w(LOG_TAG, "strPassword is null!");
            xVar.a(-1, "Check Lock Fail.");
        } else {
            SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
            sDKNetHTTPRequest.setParam("timestamp", "");
            sDKNetHTTPRequest.startRequest(String.format("%sdatasource/getuserproperties.jsp", d.e.a.a.c.a()), HttpRequest.METHOD_GET, new a(str, xVar));
        }
    }

    public void delBookmark(y yVar) {
        if (yVar == null) {
            return;
        }
        if (StringUtil.isEmptyString(this.ContentCode)) {
            LogEx.w(LOG_TAG, "ContentCode is null");
            return;
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setParam("bookmarktype", String.valueOf(getBookmarkType(this.ProgramType).getIntValue()));
        sDKNetHTTPRequest.setParam("contentcode", this.ContentCode);
        sDKNetHTTPRequest.setParam("columncode", this.ColumnCode);
        sDKNetHTTPRequest.startRequest(String.format("%sdatasource/dodelbookmark.jsp", d.e.a.a.c.a()), HttpRequest.METHOD_GET, new n(yVar));
    }

    public void delFavorite(z zVar) {
        if (zVar == null) {
            return;
        }
        if (StringUtil.isEmptyString(this.ContentCode)) {
            LogEx.w(LOG_TAG, "ContentCode is null");
            return;
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setParam("favoritetype", String.valueOf(getFavoriteType(this.ProgramType).getIntValue()));
        sDKNetHTTPRequest.setParam("contentcode", this.ContentCode);
        sDKNetHTTPRequest.setParam("columncode", this.ColumnCode);
        sDKNetHTTPRequest.setParam("dirid", "0");
        sDKNetHTTPRequest.startRequest(String.format("%sdatasource/dodelfavorite.jsp", d.e.a.a.c.a()), HttpRequest.METHOD_GET, new l(zVar));
    }

    public void delViewRecord(a0 a0Var) {
        if (a0Var == null) {
            return;
        }
        if (StringUtil.isEmptyString(this.ContentCode)) {
            LogEx.w(LOG_TAG, "ContentCode is null");
            return;
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setParam("userid", SDKLoginMgr.getInstance().getUserID());
        sDKNetHTTPRequest.setParam("columncode", this.ColumnCode);
        sDKNetHTTPRequest.setParam("contentcode", this.ContentCode);
        sDKNetHTTPRequest.setParam(ParamConst.VOD_VIEW_RECORD_DEL_REQ_DELACTION, String.valueOf(1));
        sDKNetHTTPRequest.startRequest(String.format("%sdatasource/dodelviewrecords.jsp", d.e.a.a.c.a()), HttpRequest.METHOD_GET, new c(this, a0Var));
    }

    public void deleteLock(b0 b0Var) {
        if (b0Var == null) {
            return;
        }
        if (StringUtil.isEmptyString(this.ContentCode)) {
            LogEx.w(LOG_TAG, "ContentCode is null");
            return;
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setParam("limittype", String.valueOf(getLimitType(this.ProgramType).getIntValue()));
        sDKNetHTTPRequest.setParam("contentcode", this.ContentCode);
        if (d.e.a.a.a.c()) {
            sDKNetHTTPRequest.setParam("isshared", "1");
        } else {
            sDKNetHTTPRequest.setParam("isshared", "0");
        }
        sDKNetHTTPRequest.startRequest(String.format("%sdatasource/dodellimit.jsp", d.e.a.a.c.a()), HttpRequest.METHOD_GET, new p(b0Var));
    }

    public void doAuth(boolean z2, String str, SDKAuthMgr.OnDoAuthReturnListener onDoAuthReturnListener) {
        AuthReq authReq;
        if (this.ProgramType.equals("14")) {
            authReq = new AuthReq(this.ColumnCode, this.SeriesProgramCode, this.ProgramType);
        } else {
            authReq = new AuthReq(this.ColumnCode, this.ProgramCode, this.ProgramType);
        }
        authReq.definition = str;
        authReq.isplay = z2 ? "1" : "0";
        new SDKAuthMgr().doAuth(authReq, onDoAuthReturnListener);
    }

    public void doStar(String str, c0 c0Var) {
        if (c0Var == null) {
            return;
        }
        if (StringUtil.isEmptyString(this.ContentCode)) {
            LogEx.w(LOG_TAG, "ContentCode is null");
            return;
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setParam("contentcode", this.ContentCode);
        sDKNetHTTPRequest.setParam("usercode", SDKLoginMgr.getInstance().getUserID());
        sDKNetHTTPRequest.setParam("contenttype", String.valueOf(getContentType(this.ProgramType).getIntValue()));
        sDKNetHTTPRequest.setParam("starrating", str);
        sDKNetHTTPRequest.startRequest(String.format("%sdatasource/dostarrating.jsp", d.e.a.a.c.a()), HttpRequest.METHOD_GET, new d(c0Var));
    }

    public String get3SBookmarktype() {
        return this.bookmarktype3S;
    }

    public String get3SBreakpoint() {
        return this.breakpoint3S;
    }

    public String getActor() {
        return this.Actor;
    }

    public String getActorcode() {
        return this.actorcode;
    }

    public String getActorsearchkey() {
        return this.Actorsearchkey;
    }

    public String getArchiveMode() {
        return this.ArchiveMode;
    }

    public String getAspect() {
        return this.Aspect;
    }

    public String getAudioLang() {
        return this.AudioLang;
    }

    public String getBoCode() {
        return this.BoCode;
    }

    public String getBookmarktype() {
        return this.bookmarktype;
    }

    public String getBreakpoint() {
        return this.breakpoint;
    }

    public String getCastPlayUrl() {
        return this.castPlayUrl;
    }

    public String getCatagoryCode() {
        return this.CatagoryCode;
    }

    public String getCatalogName() {
        return this.CatalogName;
    }

    public String getCatalogType() {
        return this.CatalogType;
    }

    public String getChannelCode() {
        return this.ChannelCode;
    }

    public String getColumnCode() {
        return this.ColumnCode;
    }

    public String getContentCode() {
        return this.ContentCode;
    }

    public String getCopyProtection() {
        return this.CopyProtection;
    }

    public String getCountryName() {
        return this.CountryName;
    }

    public String getCpCode() {
        return this.CpCode;
    }

    public String getCpName() {
        return this.CpName;
    }

    public String getCreateTime() {
        return this.CreateTime;
    }

    public String getDescription() {
        return this.Description;
    }

    public String getDescriptionKey() {
        return this.DescriptionKey;
    }

    public String getDetailDescribed() {
        return this.DetailDescribed;
    }

    public String getDirector() {
        return this.Director;
    }

    public String getDirectorSearchkey() {
        return this.DirectorSearchkey;
    }

    public String getDirectorcode() {
        return this.directorcode;
    }

    public String getDisabledTime() {
        return this.DisabledTime;
    }

    public String getDolby() {
        return this.Dolby;
    }

    public String getDoubanrate() {
        return this.doubanrate;
    }

    public String getElapsedTime() {
        return this.ElapsedTime;
    }

    public String getEnabledTime() {
        return this.EnabledTime;
    }

    public String getEpisodeTitle() {
        return this.EpisodeTitle;
    }

    public String getEpisodebreakpoint() {
        return this.episodebreakpoint;
    }

    public String getEpisodeproramname() {
        return this.episodeproramname;
    }

    public String getFormat() {
        return this.Format;
    }

    public String getGenre() {
        return this.Genre;
    }

    public String getLanguage() {
        return this.Language;
    }

    public String getLicensePeriod() {
        return this.LicensePeriod;
    }

    public String getMediaCode() {
        return this.MediaCode;
    }

    public String getMediaServices() {
        return this.MediaServices;
    }

    public String getOfflineTime() {
        return this.OfflineTime;
    }

    public String getOnlineTime() {
        return this.OnlineTime;
    }

    public String getParentalAdvisory() {
        return this.ParentalAdvisory;
    }

    public String getPosterFile(PosterFileType posterFileType) {
        String str = this.PosterPath;
        LogEx.d(LOG_TAG, "strPosterPath=" + str);
        String str2 = this.PosterfileList;
        LogEx.d(LOG_TAG, "strPosterURLArray=" + str2);
        if (!StringUtil.isEmptyString(str2)) {
            String splitedString = StringUtil.getSplitedString(str2, ";", posterFileType.getIntValue());
            LogEx.d(LOG_TAG, "strPosterURL=" + splitedString);
            if (!StringUtil.isEmptyString(splitedString)) {
                if (StringUtil.isEmptyString(str) || str.equals("null")) {
                    str = "/images/poster/";
                }
                return StringUtil.getStringNotNull(str).concat(splitedString);
            }
            LogEx.w(LOG_TAG, "strPosterURL is null");
        }
        return "";
    }

    public String getPosterPath() {
        return this.PosterPath;
    }

    public String getPosterfileList() {
        return this.PosterfileList;
    }

    public String getPrice() {
        return this.Price;
    }

    public String getProgramCode() {
        return this.ProgramCode;
    }

    public String getProgramName() {
        return this.ProgramName;
    }

    public String getProgramNameLen() {
        return this.ProgramNameLen;
    }

    public String getProgramSearchKey() {
        return this.ProgramSearchKey;
    }

    public String getProgramType() {
        return this.ProgramType;
    }

    public String getPubCompany() {
        return this.PubCompany;
    }

    public String getRatingId() {
        return this.RatingId;
    }

    public String getRatingNum() {
        return this.RatingNum;
    }

    public String getRatingSum() {
        return this.RatingSum;
    }

    public String getRecommendId() {
        return this.RecommendId;
    }

    public String getReleaseDate() {
        return this.ReleaseDate;
    }

    public String getSeriesNum() {
        return this.SeriesNum;
    }

    public String getSeriesProgramCode() {
        return this.SeriesProgramCode;
    }

    public String getSeriesSeason() {
        return this.SeriesSeason;
    }

    public String getShortDesc() {
        return this.ShortDesc;
    }

    public String getShortTitle() {
        return this.ShortTitle;
    }

    public String getSingercode() {
        return this.singercode;
    }

    public String getSortNum() {
        return this.SortNum;
    }

    public String getStarLevel() {
        return this.StarLevel;
    }

    public String getSubGenre() {
        return this.SubGenre;
    }

    public String getSubTitleLang() {
        return this.SubTitleLang;
    }

    public String getTelecomCode() {
        return this.TelecomCode;
    }

    public String getTimeShiftMode() {
        return this.TimeShiftMode;
    }

    public int getTotalCount() {
        return this.TotalCount;
    }

    public String getTrailer() {
        return this.trailer;
    }

    public String getTrailerBeginTime() {
        return this.TrailerBeginTime;
    }

    public String getTrailerEndTime() {
        return this.TrailerEndTime;
    }

    public String getUpdatenum() {
        return this.updatenum;
    }

    public com.zte.iptvclient.common.video.d getVideoInfo(String str, MediaServiceType mediaServiceType, VideoType videoType) {
        com.zte.iptvclient.common.video.d dVar = null;
        if (getVideoInfoList() == null || getVideoInfoList().size() == 0) {
            return null;
        }
        for (int i2 = 0; i2 < getVideoInfoList().size(); i2++) {
            if (getVideoInfoList().get(i2).c() == videoType && TextUtils.equals(getVideoInfoList().get(i2).a(), str) && getVideoInfoList().get(i2).b() == mediaServiceType) {
                dVar = getVideoInfoList().get(i2);
            }
        }
        return dVar;
    }

    public com.zte.iptvclient.common.video.d getVideoInfoBean() {
        return this.videoInfoBean;
    }

    public List<com.zte.iptvclient.common.video.d> getVideoInfoList() {
        return this.videoInfoList;
    }

    public String getViewingTime() {
        return this.viewingtime;
    }

    public void getVoDPlayURL(String str, int i2, int i3, MediaServiceType mediaServiceType, f0 f0Var) {
        if (f0Var == null) {
            return;
        }
        if (StringUtil.isEmptyString(this.ProgramCode)) {
            LogEx.w(LOG_TAG, "ContentCode is null");
            return;
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setParam("breakpoint", String.valueOf(i2));
        sDKNetHTTPRequest.setParam("programcode", this.ProgramCode);
        sDKNetHTTPRequest.setParam("authidsession", str);
        if (!StringUtil.isEmptyString(String.valueOf(i3)) && !String.valueOf(i3).equals("0")) {
            sDKNetHTTPRequest.setParam("definition", String.valueOf(i3));
        }
        String valueOf = String.valueOf(mediaServiceType.getIntValue());
        if (StringUtil.isEmptyString(String.valueOf(valueOf))) {
            sDKNetHTTPRequest.setParam("mediaservice", "");
        } else {
            sDKNetHTTPRequest.setParam("mediaservice", valueOf);
        }
        sDKNetHTTPRequest.startRequest(String.format("%sdatasource/getvodurl.jsp", d.e.a.a.c.a()), HttpRequest.METHOD_GET, new f(this, f0Var));
    }

    public void getVoDTrailerPlayURL(SnapflagType snapflagType, DefinitionType definitionType, MediaServiceType mediaServiceType, d0 d0Var) {
        if (d0Var == null) {
            return;
        }
        if (StringUtil.isEmptyString(this.ProgramCode)) {
            LogEx.w(LOG_TAG, "ContentCode is null");
            return;
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setParam(ParamConst.VOD_TRAILER_URL_REQ_SNAPFLAG, String.valueOf(snapflagType.getIntValue()));
        sDKNetHTTPRequest.setParam("programcode", this.ProgramCode);
        if (!StringUtil.isEmptyString(String.valueOf(definitionType)) && !String.valueOf(definitionType).equals("0")) {
            sDKNetHTTPRequest.setParam("definition", String.valueOf(definitionType));
        }
        if (StringUtil.isEmptyString(String.valueOf(mediaServiceType.getIntValue()))) {
            sDKNetHTTPRequest.setParam("mediaservice", "");
        } else {
            sDKNetHTTPRequest.setParam("mediaservice", String.valueOf(mediaServiceType.getIntValue()));
        }
        sDKNetHTTPRequest.startRequest(String.format("%sdatasource/getvodsnapplayurl.jsp", d.e.a.a.c.a()), HttpRequest.METHOD_GET, new g(this, d0Var));
    }

    public void getVodMultiplePlayUrl(j0 j0Var) {
        if (j0Var == null) {
            return;
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setParam("programcode", this.ProgramCode);
        sDKNetHTTPRequest.setParam("programtype", this.ProgramType);
        sDKNetHTTPRequest.setParam("columncode", this.ColumnCode);
        sDKNetHTTPRequest.setParam("seriesprogramcode", this.SeriesProgramCode);
        sDKNetHTTPRequest.startRequest(String.format("%s%s/getvideodefinitions.jsp", d.e.a.a.c.a(), SDKLoginMgr.getInstance().getUserInfo("StypeUrl")), HttpRequest.METHOD_GET, new i(this, j0Var));
    }

    public void getVodPlayAvailable(String str, e0 e0Var) {
        if (e0Var == null) {
            return;
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setParam("contentcode", str);
        sDKNetHTTPRequest.startRequest(String.format("%sdatasource/vodview.jsp", d.e.a.a.c.a()), HttpRequest.METHOD_GET, new h(this, e0Var));
    }

    public String getVrflag() {
        return this.vrflag;
    }

    public String getWgGenre() {
        return this.WgGenre;
    }

    public String getWgKeywords() {
        return this.WgKeywords;
    }

    public String getWgTags() {
        return this.WgTags;
    }

    public String getWriter() {
        return this.Writer;
    }

    public boolean is3SFavorite() {
        return this.is3SFavorite.equals("0");
    }

    public boolean isAdvertiseContent() {
        int i2;
        try {
            i2 = Integer.parseInt(this.AdvertiseContent);
        } catch (Exception e2) {
            e2.printStackTrace();
            i2 = 0;
        }
        return i2 > 0;
    }

    public boolean isArchiveMode() {
        return this.isArchiveMode.equals("1");
    }

    public boolean isFavorite() {
        return this.isFavorite.equals("1");
    }

    public boolean isFirstPage() {
        return this.isFirstPage.equals("1");
    }

    public boolean isHot() {
        return this.isHot.equals("1");
    }

    public boolean isIstrailer() {
        return "1".equals(this.trailer);
    }

    public boolean isLocked() {
        return this.isLocked.equals("0");
    }

    public boolean isProtection() {
        return this.isProtection.equals("1");
    }

    public boolean isRecommend() {
        return this.isRecommend.equals("1");
    }

    public boolean isSimpleTrailer() {
        return this.isSimpleTrailer.equals("1");
    }

    public boolean isTimeShift() {
        return this.isTimeShift.equals("1");
    }

    public void queryIsAddedLock(g0 g0Var) {
        if (g0Var == null) {
            return;
        }
        if (StringUtil.isEmptyString(this.ContentCode)) {
            LogEx.w(LOG_TAG, "ContentCode is null");
            return;
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setParam("limittype", String.valueOf(getLimitType(this.ProgramType).getIntValue()));
        sDKNetHTTPRequest.setParam("contentcode", this.ContentCode);
        sDKNetHTTPRequest.startRequest(String.format("%sdatasource/checkislocked.jsp", d.e.a.a.c.a()), HttpRequest.METHOD_GET, new r(g0Var));
    }

    public void queryLimitLock(h0 h0Var) {
        if (h0Var == null) {
            return;
        }
        SDKNetHTTPRequest sDKNetHTTPRequest = new SDKNetHTTPRequest();
        sDKNetHTTPRequest.setParam("timestamp", "");
        sDKNetHTTPRequest.startRequest(String.format("%sdatasource/getuserproperties.jsp", d.e.a.a.c.a()), HttpRequest.METHOD_GET, new q(h0Var));
    }

    public void set3SBookmarktype(String str) {
        this.bookmarktype3S = str;
    }

    public void set3SBreakpoint(String str) {
        this.breakpoint3S = str;
    }

    public void setActor(String str) {
        this.Actor = str;
    }

    public void setActorcode(String str) {
        this.actorcode = str;
    }

    public void setActorsearchkey(String str) {
        this.Actorsearchkey = str;
    }

    public void setAdvertiseContent(String str) {
        this.AdvertiseContent = str;
    }

    public void setArchiveMode(String str) {
        this.ArchiveMode = str;
    }

    public void setAspect(String str) {
        this.Aspect = str;
    }

    public void setAudioLang(String str) {
        this.AudioLang = str;
    }

    public void setBoCode(String str) {
        this.BoCode = str;
    }

    public void setBookmarktype(String str) {
        this.bookmarktype = str;
    }

    public void setBreakpoint(String str) {
        this.breakpoint = str;
    }

    public void setCastPlayUrl(String str) {
        this.castPlayUrl = str;
    }

    public void setCatagoryCode(String str) {
        this.CatagoryCode = str;
    }

    public void setCatalogName(String str) {
        this.CatalogName = str;
    }

    public void setCatalogType(String str) {
        this.CatalogType = str;
    }

    public void setChannelCode(String str) {
        this.ChannelCode = str;
    }

    public void setColumnCode(String str) {
        this.ColumnCode = str;
    }

    public void setContentCode(String str) {
        this.ContentCode = str;
    }

    public void setCopyProtection(String str) {
        this.CopyProtection = str;
    }

    public void setCountryName(String str) {
        this.CountryName = str;
    }

    public void setCpCode(String str) {
        this.CpCode = str;
    }

    public void setCpName(String str) {
        this.CpName = str;
    }

    public void setCreateTime(String str) {
        this.CreateTime = str;
    }

    public void setDescription(String str) {
        this.Description = str;
    }

    public void setDescriptionKey(String str) {
        this.DescriptionKey = str;
    }

    public void setDetailDescribed(String str) {
        this.DetailDescribed = str;
    }

    public void setDirector(String str) {
        this.Director = str;
    }

    public void setDirectorSearchkey(String str) {
        this.DirectorSearchkey = str;
    }

    public void setDirectorcode(String str) {
        this.directorcode = str;
    }

    public void setDisabledTime(String str) {
        this.DisabledTime = str;
    }

    public void setDolby(String str) {
        this.Dolby = str;
    }

    public void setDoubanrate(String str) {
        this.doubanrate = str;
    }

    public void setElapsedTime(String str) {
        this.ElapsedTime = str;
    }

    public void setEnabledTime(String str) {
        this.EnabledTime = str;
    }

    public void setEpisodeTitle(String str) {
        this.EpisodeTitle = str;
    }

    public void setEpisodebreakpoint(String str) {
        this.episodebreakpoint = str;
    }

    public void setEpisodeproramname(String str) {
        this.episodeproramname = str;
    }

    public void setExtendFields(String str) {
        ExtendFields = str;
    }

    public void setFormat(String str) {
        this.Format = str;
    }

    public void setGenre(String str) {
        this.Genre = str;
    }

    public void setIs3SFavorite(String str) {
        this.is3SFavorite = str;
    }

    public void setIsArchiveMode(String str) {
        this.isArchiveMode = str;
    }

    public void setIsFavorite(String str) {
        this.isFavorite = str;
    }

    public void setIsFirstPage(String str) {
        this.isFirstPage = str;
    }

    public void setIsHot(String str) {
        this.isHot = str;
    }

    public void setIsLocked(String str) {
        this.isLocked = str;
    }

    public void setIsProtection(String str) {
        this.isProtection = str;
    }

    public void setIsRecommend(String str) {
        this.isRecommend = str;
    }

    public void setIsSimpleTrailer(String str) {
        this.isSimpleTrailer = str;
    }

    public void setIsTimeShift(String str) {
        this.isTimeShift = str;
    }

    public void setIstrailer(String str) {
        this.istrailer = str;
    }

    public void setLanguage(String str) {
        this.Language = str;
    }

    public void setLicensePeriod(String str) {
        this.LicensePeriod = str;
    }

    public void setMediaCode(String str) {
        this.MediaCode = str;
    }

    public void setMediaServices(String str) {
        this.MediaServices = str;
    }

    public void setOfflineTime(String str) {
        this.OfflineTime = str;
    }

    public void setOnlineTime(String str) {
        this.OnlineTime = str;
    }

    public void setParentalAdvisory(String str) {
        this.ParentalAdvisory = str;
    }

    public void setPosterPath(String str) {
        this.PosterPath = str;
    }

    public void setPosterfileList(String str) {
        this.PosterfileList = str;
    }

    public void setPrice(String str) {
        this.Price = str;
    }

    public void setProgramCode(String str) {
        this.ProgramCode = str;
    }

    public void setProgramName(String str) {
        this.ProgramName = str;
    }

    public void setProgramNameLen(String str) {
        this.ProgramNameLen = str;
    }

    public void setProgramSearchKey(String str) {
        this.ProgramSearchKey = str;
    }

    public void setProgramType(String str) {
        this.ProgramType = str;
    }

    public void setPubCompany(String str) {
        this.PubCompany = str;
    }

    public void setRatingId(String str) {
        this.RatingId = str;
    }

    public void setRatingNum(String str) {
        this.RatingNum = str;
    }

    public void setRatingSum(String str) {
        this.RatingSum = str;
    }

    public void setRecommendId(String str) {
        this.RecommendId = str;
    }

    public void setReleaseDate(String str) {
        this.ReleaseDate = str;
    }

    public void setSeriesNum(String str) {
        this.SeriesNum = str;
    }

    public void setSeriesProgramCode(String str) {
        this.SeriesProgramCode = str;
    }

    public void setSeriesSeason(String str) {
        this.SeriesSeason = str;
    }

    public void setShortDesc(String str) {
        this.ShortDesc = str;
    }

    public void setShortTitle(String str) {
        this.ShortTitle = str;
    }

    public void setSingercode(String str) {
        this.singercode = str;
    }

    public void setSortNum(String str) {
        this.SortNum = str;
    }

    public void setStarLevel(String str) {
        this.StarLevel = str;
    }

    public void setSubGenre(String str) {
        this.SubGenre = str;
    }

    public void setSubTitleLang(String str) {
        this.SubTitleLang = str;
    }

    public void setTelecomCode(String str) {
        this.TelecomCode = str;
    }

    public void setTimeShiftMode(String str) {
        this.TimeShiftMode = str;
    }

    public void setTotalCount(int i2) {
        this.TotalCount = i2;
    }

    public void setTrailer(String str) {
        this.trailer = str;
    }

    public void setTrailerBeginTime(String str) {
        this.TrailerBeginTime = str;
    }

    public void setTrailerEndTime(String str) {
        this.TrailerEndTime = str;
    }

    public void setUpdatenum(String str) {
        this.updatenum = str;
    }

    public void setVideoInfoBean(com.zte.iptvclient.common.video.d dVar) {
        this.videoInfoBean = dVar;
    }

    public void setVideoInfoList(List<com.zte.iptvclient.common.video.d> list) {
        this.videoInfoList = list;
    }

    public void setViewingTime(String str) {
        this.viewingtime = str;
    }

    public void setVrflag(String str) {
        this.vrflag = str;
    }

    public void setWgGenre(String str) {
        this.WgGenre = str;
    }

    public void setWgKeywords(String str) {
        this.WgKeywords = str;
    }

    public void setWgTags(String str) {
        this.WgTags = str;
    }

    public void setWriter(String str) {
        this.Writer = str;
    }

    public void vodMapToBean(Map<String, Object> map) {
        setActorsearchkey(StringUtil.getStringFromObject(map.get(ParamConst.VOD_DETAIL_QUERY_RSP_ACTORSEARCHKEY)));
        setAdvertiseContent(StringUtil.getStringFromObject(map.get("advertisecontent")));
        setActor(StringUtil.getStringFromObject(map.get("actor")));
        setActorsearchkey(StringUtil.getStringFromObject(map.get(ParamConst.VOD_DETAIL_QUERY_RSP_ACTORSEARCHKEY)));
        setAdvertiseContent(StringUtil.getStringFromObject(map.get("advertisecontent")));
        setArchiveMode(StringUtil.getStringFromObject(map.get("archivemode")));
        setAspect(StringUtil.getStringFromObject(map.get(ParamConst.VOD_DETAIL_QUERY_RSP_ASPECT)));
        setAudioLang(StringUtil.getStringFromObject(map.get("audiolang")));
        setBoCode(StringUtil.getStringFromObject(map.get("bocode")));
        setCatagoryCode(StringUtil.getStringFromObject(map.get(ParamConst.VOD_DETAIL_QUERY_RSP_CATAGORYCODE)));
        setCatalogName(StringUtil.getStringFromObject(map.get(ParamConst.VOD_DETAIL_QUERY_RSP_CATALOGNAME)));
        setCatalogType(StringUtil.getStringFromObject(map.get(ParamConst.VOD_DETAIL_QUERY_RSP_CATALOGTYPE)));
        setChannelCode(StringUtil.getStringFromObject(map.get("channelcode")));
        setColumnCode(StringUtil.getStringFromObject(map.get("columncode")));
        setContentCode(StringUtil.getStringFromObject(map.get("contentcode")));
        setCopyProtection(StringUtil.getStringFromObject(map.get("copyprotection")));
        setCountryName(StringUtil.getStringFromObject(map.get("countryname")));
        setCpCode(StringUtil.getStringFromObject(map.get("cpcode")));
        setCpName(StringUtil.getStringFromObject(map.get("cpname")));
        setCreateTime(StringUtil.getStringFromObject(map.get("createtime")));
        setDescription(StringUtil.getStringFromObject(map.get("description")));
        setDescriptionKey(StringUtil.getStringFromObject(map.get(ParamConst.VOD_DETAIL_QUERY_RSP_DESCRIPTIONKEY)));
        setDetailDescribed(StringUtil.getStringFromObject(map.get("detaildescribed")));
        setDirector(StringUtil.getStringFromObject(map.get("director")));
        setDirectorSearchkey(StringUtil.getStringFromObject(map.get(ParamConst.VOD_DETAIL_QUERY_RSP_DIRECTORSEARCHKEY)));
        setDisabledTime(StringUtil.getStringFromObject(map.get(ParamConst.VOD_DETAIL_QUERY_RSP_DISABLEDTIME)));
        setDolby(StringUtil.getStringFromObject(map.get("dolby")));
        setElapsedTime(StringUtil.getStringFromObject(map.get("elapsedtime")));
        setEnabledTime(StringUtil.getStringFromObject(map.get(ParamConst.VOD_DETAIL_QUERY_RSP_ENABLEDTIME)));
        setEpisodeTitle(StringUtil.getStringFromObject(map.get("episodetitle")));
        setFormat(StringUtil.getStringFromObject(map.get(ParamConst.VOD_DETAIL_QUERY_RSP_FORMAT)));
        setGenre(StringUtil.getStringFromObject(map.get("genre")));
        setIs3SFavorite(StringUtil.getStringFromObject(map.get("is3Sfavorite")));
        setIsArchiveMode(StringUtil.getStringFromObject(map.get("isarchivemode")));
        setIsFavorite(StringUtil.getStringFromObject(map.get("isfavorite")));
        setIsFirstPage(StringUtil.getStringFromObject(map.get(ParamConst.VOD_DETAIL_QUERY_RSP_ISFIRSTPAGE)));
        setIsHot(StringUtil.getStringFromObject(map.get("ishot")));
        setIsLocked(StringUtil.getStringFromObject(map.get("islocked")));
        setIsProtection(StringUtil.getStringFromObject(map.get("isprotection")));
        setIsRecommend(StringUtil.getStringFromObject(map.get("isrecommend")));
        setIsSimpleTrailer(StringUtil.getStringFromObject(map.get(ParamConst.VOD_DETAIL_QUERY_RSP_ISSIMPLETRAILER)));
        setIsTimeShift(StringUtil.getStringFromObject(map.get("istimeshift")));
        setLanguage(StringUtil.getStringFromObject(map.get("language")));
        setLicensePeriod(StringUtil.getStringFromObject(map.get(ParamConst.VOD_DETAIL_QUERY_RSP_LICENSEPERIOD)));
        setMediaCode(StringUtil.getStringFromObject(map.get("mediacode")));
        setMediaServices(StringUtil.getStringFromObject(map.get("mediaservices")));
        setOfflineTime(StringUtil.getStringFromObject(map.get(ParamConst.VOD_DETAIL_QUERY_RSP_OFFLINETIME)));
        setOnlineTime(StringUtil.getStringFromObject(map.get("onlinetime")));
        setParentalAdvisory(StringUtil.getStringFromObject(map.get("parentaladvisory")));
        setPosterfileList(StringUtil.getStringFromObject(map.get("posterfilelist")));
        setPosterPath(StringUtil.getStringFromObject(map.get("posterpath")));
        setPrice(StringUtil.getStringFromObject(map.get("price")));
        setProgramCode(StringUtil.getStringFromObject(map.get("programcode")));
        setProgramName(StringUtil.getStringFromObject(map.get("programname")));
        setProgramNameLen(StringUtil.getStringFromObject(map.get(ParamConst.VOD_DETAIL_QUERY_RSP_PROGRAMNAMELEN)));
        setProgramSearchKey(StringUtil.getStringFromObject(map.get(ParamConst.VOD_DETAIL_QUERY_RSP_PROGRAMSEARCHKEY)));
        setProgramType(StringUtil.getStringFromObject(map.get("programtype")));
        setPubCompany(StringUtil.getStringFromObject(map.get(ParamConst.VOD_DETAIL_QUERY_RSP_PUBCOMPANY)));
        setRatingId(StringUtil.getStringFromObject(map.get("ratingid")));
        setRatingNum(StringUtil.getStringFromObject(map.get("ratingnum")));
        setRatingSum(StringUtil.getStringFromObject(map.get("ratingsum")));
        setRecommendId(StringUtil.getStringFromObject(map.get(ParamConst.VOD_DETAIL_QUERY_RSP_RECOMMENDID)));
        setReleaseDate(StringUtil.getStringFromObject(map.get("releasedate")));
        setSeriesNum(StringUtil.getStringFromObject(map.get("seriesnum")));
        setSeriesProgramCode(StringUtil.getStringFromObject(map.get("seriesprogramcode")));
        setSeriesSeason(StringUtil.getStringFromObject(map.get(ParamConst.VOD_DETAIL_QUERY_RSP_SERIESSEASON)));
        setShortDesc(StringUtil.getStringFromObject(map.get(ParamConst.VOD_DETAIL_QUERY_RSP_SHORTDESC)));
        setShortTitle(StringUtil.getStringFromObject(map.get(ParamConst.VOD_DETAIL_QUERY_RSP_SHORTTITLE)));
        setSortNum(StringUtil.getStringFromObject(map.get("sortnum")));
        setStarLevel(StringUtil.getStringFromObject(map.get("starlevel")));
        setSubGenre(StringUtil.getStringFromObject(map.get("subgenre")));
        setSubTitleLang(StringUtil.getStringFromObject(map.get("subtitlelang")));
        setTelecomCode(StringUtil.getStringFromObject(map.get("telecomcode")));
        setTimeShiftMode(StringUtil.getStringFromObject(map.get("timeshiftmode")));
        setTrailerBeginTime(StringUtil.getStringFromObject(map.get(ParamConst.VOD_DETAIL_QUERY_RSP_TRAILERBEGINTIME)));
        setTrailerEndTime(StringUtil.getStringFromObject(map.get(ParamConst.VOD_DETAIL_QUERY_RSP_TRAILERENDTIME)));
        setWgGenre(StringUtil.getStringFromObject(map.get(ParamConst.VOD_DETAIL_QUERY_RSP_WGGENRE)));
        setWgKeywords(StringUtil.getStringFromObject(map.get(ParamConst.VOD_DETAIL_QUERY_RSP_WGKEYWORDS)));
        setWgTags(StringUtil.getStringFromObject(map.get(ParamConst.VOD_DETAIL_QUERY_RSP_WGTAGS)));
        setWriter(StringUtil.getStringFromObject(map.get("writer")));
        setBookmarktype(StringUtil.getStringFromObject(map.get("bookmarktype")));
        setBreakpoint(StringUtil.getStringFromObject(map.get("breakpoint")));
        set3SBookmarktype(StringUtil.getStringFromObject(map.get(ParamConst.VOD_DETAIL_QUERY_RSP_3SBOOKMARKTYPE)));
        set3SBreakpoint(StringUtil.getStringFromObject(map.get(ParamConst.VOD_DETAIL_QUERY_RSP_3SBREAKPOINT)));
        setTrailer(StringUtil.getStringFromObject(map.get(ParamConst.VOD_DETAIL_QUERY_RSP_TRAILER)));
        setIstrailer(StringUtil.getStringFromObject(map.get(ParamConst.VOD_DETAIL_QUERY_RSP_ISTRAILER)));
        setUpdatenum(StringUtil.getStringFromObject(map.get(ParamConst.VOD_DETAIL_QUERY_RSP_UPDATENNUM)));
        setEpisodebreakpoint(StringUtil.getStringFromObject(map.get(ParamConst.VOD_DETAIL_QUERY_RSP_EPISODEBREAKPOINT)));
        setEpisodeproramname(StringUtil.getStringFromObject(map.get(ParamConst.VOD_DETAIL_QUERY_RSP_EPISODEPROGRAMNAME)));
        setVrflag(StringUtil.getStringFromObject(map.get("vrflag")));
        setVideoInfoList((List) map.get(ParamConst.VOD_DETAIL_QUERY_RSP_VIDEOINFO));
        setActorcode(StringUtil.getStringFromObject(map.get("actorcode")));
        setDirectorcode(StringUtil.getStringFromObject(map.get("directorcode")));
        setSingercode(StringUtil.getStringFromObject(map.get("singercode")));
    }

    public VoD(com.zte.iptvclient.common.video.b bVar, i0 i0Var) {
        this.mGetVodReq = bVar;
        this.vodInfoReturnListener = i0Var;
        init();
        this.mGetVodReq.a();
        throw null;
    }
}
