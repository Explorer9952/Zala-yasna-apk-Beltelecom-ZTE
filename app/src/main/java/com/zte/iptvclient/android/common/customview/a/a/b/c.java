package com.zte.iptvclient.android.common.customview.a.a.b;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.i;
import com.bumptech.glide.k;
import com.bumptech.glide.load.h.j;
import com.bumptech.glide.q.f;
import com.bumptech.glide.q.j.g;
import com.video.androidsdk.common.GlobalConst;
import com.video.androidsdk.common.util.StringUtil;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.service.thumbnail.GetThumbnailsReq;
import com.video.androidsdk.service.thumbnail.SDKThumbnailMgr;
import com.zte.iptvclient.android.common.javabean.models.j;
import com.zte.iptvclient.android.common.k.o;
import com.zte.iptvclient.android.common.k.x;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: PlayVODThumbNailDialog.java */
/* loaded from: classes.dex */
public class c extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private String f4170a;

    /* renamed from: b, reason: collision with root package name */
    private ImageView f4171b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f4172c;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f4173d;
    private Bitmap e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private HashMap<String, Bitmap> k;
    private HashMap<com.bumptech.glide.load.h.d, String> l;
    private ArrayList<j> m;
    private boolean n;
    private Bundle o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayVODThumbNailDialog.java */
    /* loaded from: classes.dex */
    public class a implements SDKThumbnailMgr.OnGetThumbnailsReturnListener {
        a() {
        }

        @Override // com.video.androidsdk.service.thumbnail.SDKThumbnailMgr.OnGetThumbnailsReturnListener
        public void onGetThumbnailsReturn(String str, String str2, String str3) {
            LogEx.d(c.this.f4170a, "onGetThumbnailsReturn returncode=" + str + " errorMsg=" + str2 + " json=" + str3);
            if (TextUtils.equals(str, "0")) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    if (TextUtils.equals(jSONObject.optString("returncode"), "0")) {
                        if (c.this.m != null) {
                            c.this.m.clear();
                        } else {
                            c.this.m = new ArrayList();
                        }
                        c.this.g = jSONObject.optInt("timeinterval");
                        JSONArray optJSONArray = jSONObject.optJSONArray("thumbnails");
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            c.this.m.add(j.a(optJSONArray.optJSONObject(i)));
                        }
                        c.this.n = true;
                    } else {
                        c.this.n = false;
                        LogEx.e(c.this.f4170a, "onGetThumbnailsReturn getfaild errorcode=" + str + " errorMsg=" + str2);
                    }
                } catch (Exception e) {
                    c.this.n = false;
                    LogEx.e(c.this.f4170a, "getThumbnailJsonException=" + e.getMessage());
                }
            } else {
                c.this.n = false;
                LogEx.e(c.this.f4170a, "onGetThumbnailsReturn getfaild errorcode=" + str + " errorMsg=" + str2);
            }
            if (c.this.m != null) {
                c cVar = c.this;
                cVar.a(cVar.m);
                c.this.f();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayVODThumbNailDialog.java */
    /* loaded from: classes.dex */
    public class b extends g<Bitmap> {
        b() {
        }

        public void a(Bitmap bitmap, com.bumptech.glide.q.i.c<? super Bitmap> cVar) {
        }

        @Override // com.bumptech.glide.q.j.j
        public /* bridge */ /* synthetic */ void a(Object obj, com.bumptech.glide.q.i.c cVar) {
            a((Bitmap) obj, (com.bumptech.glide.q.i.c<? super Bitmap>) cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayVODThumbNailDialog.java */
    /* loaded from: classes.dex */
    public class d extends g<Bitmap> {
        d() {
        }

        @Override // com.bumptech.glide.q.j.j
        public /* bridge */ /* synthetic */ void a(Object obj, com.bumptech.glide.q.i.c cVar) {
            a((Bitmap) obj, (com.bumptech.glide.q.i.c<? super Bitmap>) cVar);
        }

        public void a(Bitmap bitmap, com.bumptech.glide.q.i.c<? super Bitmap> cVar) {
            LogEx.d(c.this.f4170a, "onResourceReady into bitmap=" + bitmap.toString());
        }
    }

    public c(Context context) {
        super(context, R.style.dialog_noframe);
        this.f4170a = "PlayVODThumbNailDialog";
        this.f = 10;
        this.g = 60;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.n = true;
        setContentView(R.layout.play_control_thumb_dialog);
        d();
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        ArrayList<j> arrayList = this.m;
        if (arrayList == null || this.i >= arrayList.size() || this.m.get(this.i).a() == 0) {
            return;
        }
        this.f = this.m.get(this.i).a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayVODThumbNailDialog.java */
    /* renamed from: com.zte.iptvclient.android.common.customview.a.a.b.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0115c implements f<com.bumptech.glide.load.h.d, Bitmap> {
        C0115c() {
        }

        @Override // com.bumptech.glide.q.f
        public boolean a(Exception exc, com.bumptech.glide.load.h.d dVar, com.bumptech.glide.q.j.j<Bitmap> jVar, boolean z) {
            if (dVar == null) {
                return false;
            }
            String str = dVar.b().get("Cookie");
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (c.this.k == null) {
                c.this.k = new HashMap();
            }
            c.this.k.put(str, null);
            if (c.this.l == null) {
                c.this.l = new HashMap();
            }
            c.this.l.put(dVar, String.valueOf(1));
            c.this.a(dVar);
            return false;
        }

        @Override // com.bumptech.glide.q.f
        public boolean a(Bitmap bitmap, com.bumptech.glide.load.h.d dVar, com.bumptech.glide.q.j.j<Bitmap> jVar, boolean z, boolean z2) {
            if (dVar == null) {
                return false;
            }
            String str = dVar.b().get("Cookie");
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (c.this.k == null) {
                c.this.k = new HashMap();
            }
            c.this.k.put(str, bitmap);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlayVODThumbNailDialog.java */
    /* loaded from: classes.dex */
    public class e implements f<com.bumptech.glide.load.h.d, Bitmap> {
        e() {
        }

        @Override // com.bumptech.glide.q.f
        public boolean a(Exception exc, com.bumptech.glide.load.h.d dVar, com.bumptech.glide.q.j.j<Bitmap> jVar, boolean z) {
            if (dVar == null) {
                return false;
            }
            String str = dVar.b().get("Cookie");
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (c.this.k == null) {
                c.this.k = new HashMap();
            }
            c.this.k.put(str, null);
            if (c.this.l != null && !TextUtils.isEmpty((CharSequence) c.this.l.get(dVar))) {
                c.this.l.put(dVar, String.valueOf(Integer.parseInt((String) c.this.l.get(dVar)) + 1));
            }
            c.this.a(dVar);
            return false;
        }

        @Override // com.bumptech.glide.q.f
        public boolean a(Bitmap bitmap, com.bumptech.glide.load.h.d dVar, com.bumptech.glide.q.j.j<Bitmap> jVar, boolean z, boolean z2) {
            if (dVar == null) {
                return false;
            }
            String str = dVar.b().get("Cookie");
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (c.this.k == null) {
                c.this.k = new HashMap();
            }
            c.this.k.put(str, bitmap);
            return false;
        }
    }

    private void d() {
        this.f4171b = (ImageView) findViewById(R.id.img_thumb);
        this.f4173d = (LinearLayout) findViewById(R.id.play_control_2);
        this.f4172c = (TextView) findViewById(R.id.goto_time);
        ((TextView) findViewById(R.id.play_control_3)).setText(":");
        com.zte.iptvclient.common.uiframe.f.a(findViewById(R.id.play_control_2));
        com.zte.iptvclient.common.uiframe.f.a(findViewById(R.id.goto_time));
    }

    private void e() {
        int width;
        try {
            f();
            if (this.k == null) {
                LogEx.d(this.f4170a, "mCacheMap is null!");
                return;
            }
            LogEx.d(this.f4170a, "mCacheMap is  not null!");
            if (this.k.get(String.valueOf(this.i)) != null) {
                Bitmap bitmap = this.k.get(String.valueOf(this.i));
                if (bitmap != null) {
                    LogEx.d(this.f4170a, "curBitMapByProgress getBitMap is not null!");
                    LogEx.d(this.f4170a, "iCurrentThumbIndex=" + this.i + " iDefaultSpritsNum=" + this.f);
                    if (a(bitmap)) {
                        width = bitmap.getWidth() - (bitmap.getWidth() / this.f);
                        LogEx.d(this.f4170a, "curBitMapByProgress createBitmap for x or currentWidth=" + width);
                    } else {
                        width = (this.j * bitmap.getWidth()) / this.f;
                        LogEx.d(this.f4170a, "curBitMapByProgress createBitmap for x or currentWidth=" + width);
                    }
                    int width2 = bitmap.getWidth() / this.f;
                    int height = bitmap.getHeight();
                    if (width < 0 || height < 0 || width2 < 0) {
                        LogEx.e(this.f4170a, "curBitMapByProgress getXeception for x or Width < 0");
                    }
                    this.e = Bitmap.createBitmap(bitmap, width, 0, width2, height);
                } else {
                    this.e = null;
                    LogEx.e(this.f4170a, "curBitMapByProgress getBitMap is null!>>>");
                }
            } else {
                this.e = null;
                LogEx.e(this.f4170a, "curBitMapByProgress getBitMap is null!");
            }
            if (this.e != null) {
                this.f4171b.setImageBitmap(this.e);
            } else {
                dismiss();
            }
        } catch (Exception e2) {
            e2.fillInStackTrace();
            dismiss();
            LogEx.e(this.f4170a, "curBitMapByProgress getexception=" + e2.getMessage());
        }
    }

    public void c() {
        LogEx.d(this.f4170a, "releaseReasouce!");
        Bitmap bitmap = this.e;
        if (bitmap != null) {
            bitmap.recycle();
            this.e = null;
        }
        ArrayList<j> arrayList = this.m;
        if (arrayList != null) {
            arrayList.clear();
            this.m = null;
        }
        HashMap<String, Bitmap> hashMap = this.k;
        if (hashMap != null) {
            hashMap.clear();
            this.k = null;
        }
        if (this.o != null) {
            this.o = null;
        }
    }

    public void b() {
        HashMap<String, Bitmap> hashMap = this.k;
        if (hashMap == null) {
            this.k = new HashMap<>();
        } else {
            hashMap.clear();
        }
        ArrayList<j> arrayList = this.m;
        if (arrayList == null) {
            this.m = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        HashMap<com.bumptech.glide.load.h.d, String> hashMap2 = this.l;
        if (hashMap2 == null) {
            this.l = new HashMap<>();
        } else {
            hashMap2.clear();
        }
    }

    public void a(int i, String str, long j) {
        LogEx.d(this.f4170a, "progress=" + i);
        if (TextUtils.isEmpty(str)) {
            this.f4173d.setVisibility(8);
        } else {
            this.f4173d.setVisibility(0);
            this.f4172c.setText(str);
        }
        int round = Math.round(i / this.g);
        int i2 = this.g;
        int i3 = round * i2;
        this.h = i3;
        int i4 = this.f;
        this.i = i3 / (i2 * i4);
        this.j = (i3 % (i4 * i2)) / i2;
        e();
        LogEx.d(this.f4170a, "在第" + this.i + "张所略图 第" + this.j + "雪碧图；代表第" + i + "秒");
    }

    private String b(Bundle bundle, String str) {
        String string;
        if ("1".equals(str)) {
            if (!StringUtil.isEmptyString(bundle.getString("physicalcontentid_url_sd"))) {
                string = bundle.getString("physicalcontentid_url_sd");
            }
            string = "";
        } else if ("2".equals(str)) {
            if (!StringUtil.isEmptyString(bundle.getString("physicalcontentid_url_sd_h"))) {
                string = bundle.getString("physicalcontentid_url_sd_h");
            }
            string = "";
        } else if ("4".equals(str)) {
            if (!StringUtil.isEmptyString(bundle.getString("physicalcontentid_url_hd"))) {
                string = bundle.getString("physicalcontentid_url_hd");
            }
            string = "";
        } else if ("8".equals(str)) {
            if (!StringUtil.isEmptyString(bundle.getString("physicalcontentid_url_480p"))) {
                string = bundle.getString("physicalcontentid_url_480p");
            }
            string = "";
        } else if (GlobalConst.WINPHONE_CLIENT.equals(str)) {
            if (!StringUtil.isEmptyString(bundle.getString("physicalcontentid_url_720p"))) {
                string = bundle.getString("physicalcontentid_url_720p");
            }
            string = "";
        } else {
            if (GlobalConst.ANDRIODSTB_CLIENT.equals(str) && !StringUtil.isEmptyString(bundle.getString("physicalcontentid_url_1280p"))) {
                string = bundle.getString("physicalcontentid_url_1280p");
            }
            string = "";
        }
        return TextUtils.isEmpty(string) ? bundle.getString("physicalcontentid") : string;
    }

    public void a(String str) {
        Bundle bundle = this.o;
        if (bundle != null) {
            a(bundle, str);
        } else {
            LogEx.e(this.f4170a, "mDataBundle is null!");
        }
    }

    public void a(Bundle bundle, String str) {
        this.o = bundle;
        b();
        SDKThumbnailMgr sDKThumbnailMgr = new SDKThumbnailMgr();
        String h = o.j().h();
        sDKThumbnailMgr.setServerDomain(h);
        GetThumbnailsReq getThumbnailsReq = new GetThumbnailsReq();
        String string = bundle.getString("cmsid");
        String str2 = "4";
        if ("4".equals(bundle.getString("auth_contenttype"))) {
            String a2 = x.a(bundle.getString("prevuebegintime"), "yyyy.MM.dd HH:mm:ss", "yyyyMMddHHmmss");
            String a3 = x.a(bundle.getString("prevueendtime"), "yyyy.MM.dd HH:mm:ss", "yyyyMMddHHmmss");
            getThumbnailsReq.programbegin = a2;
            getThumbnailsReq.programend = a3;
            LogEx.d(this.f4170a, "programbegin=" + a2 + " programend=" + a3);
            str2 = "2";
        }
        getThumbnailsReq.cmsid = string;
        getThumbnailsReq.playtype = str2;
        getThumbnailsReq.definition = "";
        String b2 = b(bundle, str);
        getThumbnailsReq.physicalcontentid = b2;
        LogEx.d(this.f4170a, "strCDN=" + h + " strPhysicalContentId= " + b2 + " strCmsid= " + string + " strCurrentDefinitonType=" + str);
        sDKThumbnailMgr.getThumbnails(getThumbnailsReq, new a());
    }

    public boolean a() {
        return this.n;
    }

    public void a(ArrayList<j> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) != null && !TextUtils.isEmpty(arrayList.get(i).b())) {
                LogEx.d(this.f4170a, "mArryPosterURL.get(j)=" + arrayList.get(i).b());
                a(arrayList.get(i).b(), i);
            }
        }
    }

    private void a(String str, int i) {
        j.a aVar = new j.a();
        aVar.a("Cookie", String.valueOf(i));
        com.bumptech.glide.b f = i.b(getContext()).a((k) new com.bumptech.glide.load.h.d(str, aVar.a())).f();
        f.a((f) new C0115c());
        f.a((com.bumptech.glide.b) new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.bumptech.glide.load.h.d dVar) {
        HashMap<com.bumptech.glide.load.h.d, String> hashMap = this.l;
        if (hashMap != null && !TextUtils.isEmpty(hashMap.get(dVar))) {
            if (Integer.parseInt(this.l.get(dVar)) > 3) {
                LogEx.d(this.f4170a, "downloadTimes over MaxTimes for stop downloadBitmap ");
                return;
            }
            com.bumptech.glide.b f = i.b(getContext()).a((k) dVar).f();
            f.a((f) new e());
            f.a((com.bumptech.glide.b) new d());
            return;
        }
        LogEx.e(this.f4170a, "reDownloadBitmap ocu exception for  mDownloadFaildUrl or times ");
    }

    private boolean a(Bitmap bitmap) {
        return bitmap != null && ((bitmap.getWidth() * this.j) / this.f) + (bitmap.getWidth() / this.f) > bitmap.getWidth();
    }
}
