package com.zte.iptvclient.android.common.j;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.download.DownloadConstant;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.homepage.SDKHomePageMgr;
import com.zte.iptvclient.android.common.BaseApp;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AdvertisementStorage.java */
/* loaded from: classes.dex */
public class a {
    private static a e;
    private static ArrayList<com.zte.iptvclient.android.common.javabean.models.a> f;
    private static Context g;

    /* renamed from: a, reason: collision with root package name */
    private int f4656a = 3;

    /* renamed from: b, reason: collision with root package name */
    private int f4657b = 0;

    /* renamed from: c, reason: collision with root package name */
    private String f4658c = "";

    /* renamed from: d, reason: collision with root package name */
    private Bitmap f4659d = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdvertisementStorage.java */
    /* renamed from: com.zte.iptvclient.android.common.j.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0135a implements SDKHomePageMgr.OnHomeBannerReturnListener {
        C0135a() {
        }

        @Override // com.video.androidsdk.service.homepage.SDKHomePageMgr.OnHomeBannerReturnListener
        public void onHomeBannerReturn(String str, String str2, String str3) {
            LogEx.d("AdvertisementStorage", "getHomeBanner returncode : " + str + " , strErrorMsg : " + str2 + " ,data :" + str3);
            if (TextUtils.equals("0", str)) {
                if (a.f == null || a.f.size() <= 0) {
                    ArrayList unused = a.f = new ArrayList();
                } else {
                    a.f.clear();
                }
                try {
                    JSONArray jSONArray = new JSONObject(str3).getJSONArray("data");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        a.f.add(com.zte.iptvclient.android.common.javabean.models.a.a(jSONArray.getJSONObject(i)));
                        if (a.f.size() >= 10) {
                            break;
                        }
                    }
                    a.this.a();
                } catch (Exception e) {
                    LogEx.e("AdvertisementStorage", e.getMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdvertisementStorage.java */
    /* loaded from: classes.dex */
    public class b extends com.bumptech.glide.q.j.g<Bitmap> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.zte.iptvclient.android.common.javabean.models.a f4661d;

        b(com.zte.iptvclient.android.common.javabean.models.a aVar) {
            this.f4661d = aVar;
        }

        @Override // com.bumptech.glide.q.j.j
        public /* bridge */ /* synthetic */ void a(Object obj, com.bumptech.glide.q.i.c cVar) {
            a((Bitmap) obj, (com.bumptech.glide.q.i.c<? super Bitmap>) cVar);
        }

        public void a(Bitmap bitmap, com.bumptech.glide.q.i.c<? super Bitmap> cVar) {
            String str;
            LogEx.d("AdvertisementStorage", "onResourceReady");
            if (bitmap != null) {
                a.this.f4659d = bitmap;
                String c2 = com.zte.iptvclient.common.uiframe.a.c("Splash_Advertise_Forbidden_Skip_Time");
                if (!StringUtil.isEmptyString(c2)) {
                    a.this.f4657b = Integer.parseInt(c2);
                }
                com.zte.iptvclient.android.common.javabean.models.a aVar = this.f4661d;
                if (aVar != null) {
                    a.this.f4658c = aVar.b();
                    str = this.f4661d.a();
                } else {
                    str = "";
                }
                LogEx.d("AdvertisementStorage", "m_strLinkSource = " + a.this.f4658c);
                if (!TextUtils.isEmpty(str)) {
                    a.this.f4656a = Integer.parseInt(str);
                    LogEx.d("AdvertisementStorage", " m_iTotalTime = " + Integer.parseInt(str));
                }
                new Thread(new c()).start();
            }
        }
    }

    /* compiled from: AdvertisementStorage.java */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f4659d != null) {
                a aVar = a.this;
                a.this.a(new com.zte.iptvclient.android.common.javabean.a(aVar.a(aVar.f4659d), a.this.f4658c, a.this.f4656a, a.this.f4657b));
            }
        }
    }

    public static final a d() {
        if (e == null) {
            e = new a();
        }
        return e;
    }

    public com.zte.iptvclient.android.common.javabean.a b() {
        return BaseApp.e().a().b();
    }

    public void a(Context context) {
        g = context;
        SDKHomePageMgr sDKHomePageMgr = new SDKHomePageMgr();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("bannerposition", DownloadConstant.REPORT_MSGTYPE_SPEED);
        sDKHomePageMgr.getHomeBanner(hashMap, new C0135a());
    }

    public void a() {
        int indexOf;
        ArrayList<com.zte.iptvclient.android.common.javabean.models.a> arrayList = f;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        com.zte.iptvclient.android.common.javabean.models.a aVar = f.get(new SecureRandom().nextInt(f.size()));
        String c2 = aVar.c();
        if (TextUtils.isEmpty(c2) || (indexOf = c2.indexOf("/image", 1)) <= -1) {
            return;
        }
        String str = com.zte.iptvclient.android.common.f.b.i.g() + c2.substring(indexOf);
        LogEx.d("AdvertisementStorage", "guid image url = " + str);
        Context context = g;
        if (context != null) {
            com.bumptech.glide.i.b(context).a(str).f().a((com.bumptech.glide.b<String>) new b(aVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.zte.iptvclient.android.common.javabean.a aVar) {
        int a2 = BaseApp.e().a().a();
        int a3 = BaseApp.e().a().a(aVar);
        ArrayList<com.zte.iptvclient.android.common.javabean.models.a> arrayList = f;
        if (arrayList != null) {
            arrayList.clear();
        }
        f = null;
        Bitmap bitmap = this.f4659d;
        if (bitmap != null) {
            bitmap.recycle();
        }
        LogEx.d("AdvertisementStorage", "deleResult = " + a2 + "  addResult = " + a3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bitmap.getWidth() * bitmap.getHeight() * 4);
        try {
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    bitmap.recycle();
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return byteArray;
            } catch (Exception e3) {
                e3.printStackTrace();
                try {
                    bitmap.recycle();
                    byteArrayOutputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                return new byte[0];
            }
        } catch (Throwable th) {
            try {
                bitmap.recycle();
                byteArrayOutputStream.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            throw th;
        }
    }
}
