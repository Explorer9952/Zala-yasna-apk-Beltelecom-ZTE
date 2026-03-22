package com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.ahmobile.android.tvclient.R$styleable;
import com.scwang.smartrefresh.layout.a.d;
import com.scwang.smartrefresh.layout.a.g;
import com.scwang.smartrefresh.layout.a.h;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;

/* loaded from: classes.dex */
public class DefaultRefreshFooter extends RelativeLayout implements d {

    /* renamed from: a, reason: collision with root package name */
    private ImageView f4413a;

    /* renamed from: b, reason: collision with root package name */
    private AnimationDrawable f4414b;

    /* renamed from: c, reason: collision with root package name */
    private SpinnerStyle f4415c;

    /* renamed from: d, reason: collision with root package name */
    private Runnable f4416d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        Drawable f4417a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ h f4418b;

        a(h hVar) {
            this.f4418b = hVar;
            this.f4417a = this.f4418b.n().getBackground();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4418b.n().setBackgroundDrawable(this.f4417a);
        }
    }

    /* loaded from: classes.dex */
    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4420a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f4420a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4420a[RefreshState.PullToUpLoad.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4420a[RefreshState.Loading.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4420a[RefreshState.ReleaseToLoad.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public DefaultRefreshFooter(Context context) {
        super(context);
        this.f4415c = SpinnerStyle.Translate;
        a(context, (AttributeSet) null, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        LayoutInflater.from(context).inflate(R.layout.default_refresh_rooter, this);
        ImageView imageView = (ImageView) findViewById(R.id.animation_iv);
        this.f4413a = imageView;
        this.f4414b = (AnimationDrawable) imageView.getDrawable();
        f.a(this.f4413a);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClassicsHeader);
        this.f4415c = SpinnerStyle.values()[obtainStyledAttributes.getInt(1, this.f4415c.ordinal())];
        int color = obtainStyledAttributes.getColor(2, 0);
        int color2 = obtainStyledAttributes.getColor(0, 0);
        if (color != 0) {
            if (color2 != 0) {
                a(color, color2);
            } else {
                a(color);
            }
        } else if (color2 != 0) {
            a(0, color2);
        }
        obtainStyledAttributes.recycle();
    }

    private void c() {
        Runnable runnable = this.f4416d;
        if (runnable != null) {
            runnable.run();
            this.f4416d = null;
        }
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public View a() {
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.a.d
    public void a(float f, int i, int i2, int i3) {
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public void a(g gVar, int i, int i2) {
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public void a(h hVar, int i, int i2) {
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public void a(int... iArr) {
    }

    @Override // com.scwang.smartrefresh.layout.a.d
    public boolean a(boolean z) {
        return true;
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public SpinnerStyle b() {
        return this.f4415c;
    }

    @Override // com.scwang.smartrefresh.layout.a.d
    public void b(float f, int i, int i2, int i3) {
    }

    public DefaultRefreshFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4415c = SpinnerStyle.Translate;
        a(context, attributeSet, 0);
    }

    public DefaultRefreshFooter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4415c = SpinnerStyle.Translate;
        a(context, attributeSet, i);
    }

    private void a(h hVar) {
        if (this.f4416d == null && this.f4415c == SpinnerStyle.FixedBehind) {
            this.f4416d = new a(hVar);
            hVar.n().setBackgroundDrawable(getBackground());
        }
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public int a(h hVar, boolean z) {
        this.f4414b.stop();
        return 0;
    }

    @Override // com.scwang.smartrefresh.layout.d.e
    public void a(h hVar, RefreshState refreshState, RefreshState refreshState2) {
        int i = b.f4420a[refreshState2.ordinal()];
        if (i == 1) {
            c();
            return;
        }
        if (i == 2) {
            this.f4414b.selectDrawable(0);
        } else if (i == 3) {
            this.f4414b.start();
        } else {
            if (i != 4) {
                return;
            }
            a(hVar);
        }
    }
}
