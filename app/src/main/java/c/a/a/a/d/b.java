package c.a.a.a.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import c.a.a.a.c.c;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: SkinManager.java */
/* loaded from: classes.dex */
public class b {
    private static b g;

    /* renamed from: a, reason: collision with root package name */
    private List<c> f1864a;

    /* renamed from: b, reason: collision with root package name */
    private Context f1865b;

    /* renamed from: c, reason: collision with root package name */
    private String f1866c;

    /* renamed from: d, reason: collision with root package name */
    private Resources f1867d;
    private String e;
    private boolean f = false;

    private b() {
    }

    public static synchronized b d() {
        b bVar;
        synchronized (b.class) {
            if (g == null) {
                g = new b();
            }
            bVar = g;
        }
        return bVar;
    }

    public void c() {
        List<c> list = this.f1864a;
        if (list == null) {
            return;
        }
        Iterator<c> it2 = list.iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
    }

    public void b() {
        a(c.a.a.a.a.a.a(this.f1865b), (c.a.a.a.c.b) null);
    }

    public float c(int i) {
        Context context = this.f1865b;
        if (context == null) {
            return -1.0f;
        }
        float dimension = context.getResources().getDimension(i);
        if (this.f1867d != null && !this.f) {
            try {
                return this.f1867d.getDimension(this.f1867d.getIdentifier(this.f1865b.getResources().getResourceEntryName(i), "dimen", this.f1866c));
            } catch (Resources.NotFoundException unused) {
            }
        }
        return dimension;
    }

    @SuppressLint({"NewApi"})
    public Drawable d(int i) {
        Drawable drawable;
        Context context = this.f1865b;
        if (context == null) {
            return null;
        }
        Drawable drawable2 = context.getResources().getDrawable(i);
        if (this.f1867d == null || this.f) {
            return drawable2;
        }
        int identifier = this.f1867d.getIdentifier(this.f1865b.getResources().getResourceEntryName(i), "drawable", this.f1866c);
        try {
            if (Build.VERSION.SDK_INT < 22) {
                drawable = this.f1867d.getDrawable(identifier);
            } else {
                drawable = this.f1867d.getDrawable(identifier, null);
            }
            return drawable;
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
            return drawable2;
        }
    }

    public boolean a() {
        return (this.f || this.f1867d == null) ? false : true;
    }

    public void b(c cVar) {
        List<c> list = this.f1864a;
        if (list != null && list.contains(cVar)) {
            this.f1864a.remove(cVar);
        }
    }

    public void a(Context context) {
        this.f1865b = context.getApplicationContext();
    }

    public void a(String str, c.a.a.a.c.b bVar) {
        new a(bVar).execute(str);
    }

    public int b(int i) {
        Context context = this.f1865b;
        if (context == null) {
            return 0;
        }
        int color = context.getResources().getColor(i);
        if (this.f1867d == null || this.f) {
            return color;
        }
        try {
            return this.f1867d.getColor(this.f1867d.getIdentifier(this.f1865b.getResources().getResourceEntryName(i), TtmlNode.ATTR_TTS_COLOR, this.f1866c));
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
            return color;
        }
    }

    public void a(c cVar) {
        if (this.f1864a == null) {
            this.f1864a = new ArrayList();
        }
        if (this.f1864a.contains(cVar)) {
            return;
        }
        this.f1864a.add(cVar);
    }

    public ColorStateList a(int i) {
        boolean z = (this.f1867d == null || this.f) ? false : true;
        Context context = this.f1865b;
        if (context == null) {
            return null;
        }
        String resourceEntryName = context.getResources().getResourceEntryName(i);
        if (z) {
            int identifier = this.f1867d.getIdentifier(resourceEntryName, TtmlNode.ATTR_TTS_COLOR, this.f1866c);
            if (identifier == 0) {
                try {
                    return this.f1865b.getResources().getColorStateList(i);
                } catch (Resources.NotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    return this.f1867d.getColorStateList(identifier);
                } catch (Resources.NotFoundException e2) {
                    e2.printStackTrace();
                }
            }
        } else {
            try {
                return this.f1865b.getResources().getColorStateList(i);
            } catch (Resources.NotFoundException e3) {
                e3.printStackTrace();
            }
        }
        return new ColorStateList((int[][]) Array.newInstance((Class<?>) int.class, 1, 1), new int[]{this.f1865b.getResources().getColor(i)});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SkinManager.java */
    /* loaded from: classes.dex */
    public class a extends AsyncTask<String, Void, Resources> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c.a.a.a.c.b f1868a;

        a(c.a.a.a.c.b bVar) {
            this.f1868a = bVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Resources doInBackground(String... strArr) {
            PackageInfo packageArchiveInfo;
            try {
                if (strArr.length != 1) {
                    return null;
                }
                String str = strArr[0];
                if (!new File(str).exists()) {
                    return null;
                }
                PackageManager packageManager = b.this.f1865b.getPackageManager();
                if (packageManager != null && (packageArchiveInfo = packageManager.getPackageArchiveInfo(str, 1)) != null) {
                    b.this.f1866c = packageArchiveInfo.packageName;
                }
                AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
                assetManager.getClass().getMethod("addAssetPath", String.class).invoke(assetManager, str);
                Resources resources = b.this.f1865b.getResources();
                Resources resources2 = new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                c.a.a.a.a.a.a(b.this.f1865b, str);
                b.this.e = str;
                b.this.f = false;
                return resources2;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            c.a.a.a.c.b bVar = this.f1868a;
            if (bVar != null) {
                bVar.b();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Resources resources) {
            b.this.f1867d = resources;
            if (b.this.f1867d == null) {
                b.this.f = true;
                c.a.a.a.c.b bVar = this.f1868a;
                if (bVar != null) {
                    bVar.a();
                    return;
                }
                return;
            }
            b.this.c();
            c.a.a.a.c.b bVar2 = this.f1868a;
            if (bVar2 != null) {
                bVar2.onSuccess();
            }
        }
    }
}
