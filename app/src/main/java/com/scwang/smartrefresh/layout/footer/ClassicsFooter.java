package com.scwang.smartrefresh.layout.footer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.vr.cardboard.TransitionView;
import com.scwang.smartrefresh.layout.R$styleable;
import com.scwang.smartrefresh.layout.a.d;
import com.scwang.smartrefresh.layout.a.g;
import com.scwang.smartrefresh.layout.a.h;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;

/* loaded from: classes.dex */
public class ClassicsFooter extends LinearLayout implements d {
    public static String g = "上拉加载更多";
    public static String h = "释放立即加载";
    public static String i = "正在加载...";
    public static String j = "加载完成";
    public static String k = "全部加载完成";

    /* renamed from: a, reason: collision with root package name */
    private TextView f2757a;

    /* renamed from: b, reason: collision with root package name */
    private ImageView f2758b;

    /* renamed from: c, reason: collision with root package name */
    private com.scwang.smartrefresh.layout.c.a f2759c;

    /* renamed from: d, reason: collision with root package name */
    private SpinnerStyle f2760d;
    private boolean e;
    private Runnable f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        Drawable f2761a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ h f2762b;

        a(h hVar) {
            this.f2762b = hVar;
            this.f2761a = this.f2762b.n().getBackground();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2762b.n().setBackgroundDrawable(this.f2761a);
        }
    }

    /* loaded from: classes.dex */
    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2764a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f2764a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2764a[RefreshState.PullToUpLoad.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2764a[RefreshState.Loading.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2764a[RefreshState.ReleaseToLoad.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public ClassicsFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2760d = SpinnerStyle.Translate;
        this.e = false;
        a(context, attributeSet, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i2) {
        com.scwang.smartrefresh.layout.e.a aVar = new com.scwang.smartrefresh.layout.e.a();
        setGravity(17);
        setMinimumHeight(aVar.a(60.0f));
        com.scwang.smartrefresh.layout.c.a aVar2 = new com.scwang.smartrefresh.layout.c.a();
        this.f2759c = aVar2;
        aVar2.a(-10066330);
        ImageView imageView = new ImageView(context);
        this.f2758b = imageView;
        imageView.setImageDrawable(this.f2759c);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(aVar.a(16.0f), aVar.a(16.0f));
        layoutParams.rightMargin = aVar.a(10.0f);
        addView(this.f2758b, layoutParams);
        AppCompatTextView appCompatTextView = new AppCompatTextView(context, attributeSet, i2);
        this.f2757a = appCompatTextView;
        appCompatTextView.setTextColor(-10066330);
        this.f2757a.setTextSize(16.0f);
        this.f2757a.setText(g);
        addView(this.f2757a, -2, -2);
        if (!isInEditMode()) {
            this.f2758b.setVisibility(8);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClassicsFooter);
        this.f2760d = SpinnerStyle.values()[obtainStyledAttributes.getInt(R$styleable.ClassicsFooter_srlClassicsSpinnerStyle, this.f2760d.ordinal())];
        if (obtainStyledAttributes.hasValue(R$styleable.ClassicsFooter_srlPrimaryColor)) {
            int color = obtainStyledAttributes.getColor(R$styleable.ClassicsFooter_srlPrimaryColor, 0);
            if (obtainStyledAttributes.hasValue(R$styleable.ClassicsFooter_srlAccentColor)) {
                a(color, obtainStyledAttributes.getColor(R$styleable.ClassicsFooter_srlAccentColor, 0));
            } else {
                a(color);
            }
        } else if (obtainStyledAttributes.hasValue(R$styleable.ClassicsFooter_srlAccentColor)) {
            a(0, obtainStyledAttributes.getColor(R$styleable.ClassicsFooter_srlAccentColor, 0));
        }
        obtainStyledAttributes.recycle();
    }

    private void c() {
        Runnable runnable = this.f;
        if (runnable != null) {
            runnable.run();
            this.f = null;
        }
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public View a() {
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.a.d
    public void a(float f, int i2, int i3, int i4) {
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public void a(g gVar, int i2, int i3) {
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public SpinnerStyle b() {
        return this.f2760d;
    }

    @Override // com.scwang.smartrefresh.layout.a.d
    public void b(float f, int i2, int i3, int i4) {
    }

    public ClassicsFooter(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2760d = SpinnerStyle.Translate;
        this.e = false;
        a(context, attributeSet, i2);
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public void a(h hVar, int i2, int i3) {
        if (this.e) {
            return;
        }
        this.f2758b.setVisibility(0);
        this.f2759c.start();
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public int a(h hVar, boolean z) {
        if (this.e) {
            return 0;
        }
        this.f2759c.stop();
        this.f2758b.setVisibility(8);
        this.f2757a.setText(j);
        return TransitionView.TRANSITION_ANIMATION_DURATION_MS;
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public void a(int... iArr) {
        if (this.f2760d == SpinnerStyle.FixedBehind) {
            if (iArr.length > 1) {
                setBackgroundColor(iArr[0]);
                this.f2757a.setTextColor(iArr[1]);
                this.f2759c.a(iArr[1]);
            } else if (iArr.length > 0) {
                setBackgroundColor(iArr[0]);
                if (iArr[0] == -1) {
                    this.f2757a.setTextColor(-10066330);
                    this.f2759c.a(-10066330);
                } else {
                    this.f2757a.setTextColor(-1);
                    this.f2759c.a(-1);
                }
            }
        }
    }

    @Override // com.scwang.smartrefresh.layout.a.d
    public boolean a(boolean z) {
        if (this.e == z) {
            return true;
        }
        this.e = z;
        if (z) {
            this.f2757a.setText(k);
        } else {
            this.f2757a.setText(g);
        }
        this.f2759c.stop();
        this.f2758b.setVisibility(8);
        return true;
    }

    @Override // com.scwang.smartrefresh.layout.d.e
    public void a(h hVar, RefreshState refreshState, RefreshState refreshState2) {
        if (this.e) {
            return;
        }
        int i2 = b.f2764a[refreshState2.ordinal()];
        if (i2 == 1) {
            c();
        } else if (i2 != 2) {
            if (i2 == 3) {
                this.f2757a.setText(i);
                return;
            } else {
                if (i2 != 4) {
                    return;
                }
                this.f2757a.setText(h);
                a(hVar);
                return;
            }
        }
        this.f2757a.setText(g);
    }

    private void a(h hVar) {
        if (this.f == null && this.f2760d == SpinnerStyle.FixedBehind) {
            this.f = new a(hVar);
            hVar.n().setBackgroundDrawable(getBackground());
        }
    }
}
