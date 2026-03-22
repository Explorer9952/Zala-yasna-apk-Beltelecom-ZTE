package com.scwang.smartrefresh.layout.header;

import android.R;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.vr.cardboard.TransitionView;
import com.scwang.smartrefresh.layout.R$styleable;
import com.scwang.smartrefresh.layout.a.e;
import com.scwang.smartrefresh.layout.a.g;
import com.scwang.smartrefresh.layout.a.h;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.pathview.PathsView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class ClassicsHeader extends RelativeLayout implements e {
    public static String k = "下拉可以刷新";
    public static String l = "正在刷新";
    public static String m = "释放立即刷新";
    public static String n = "刷新完成";
    public static String o = "刷新失败";

    /* renamed from: a, reason: collision with root package name */
    private String f2780a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f2781b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f2782c;

    /* renamed from: d, reason: collision with root package name */
    private PathsView f2783d;
    private ImageView e;
    private com.scwang.smartrefresh.layout.c.a f;
    private DateFormat g;
    private SpinnerStyle h;
    private SharedPreferences i;
    private Runnable j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        Drawable f2784a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ h f2785b;

        a(h hVar) {
            this.f2785b = hVar;
            this.f2784a = this.f2785b.n().getBackground();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2785b.n().setBackgroundDrawable(this.f2784a);
        }
    }

    /* loaded from: classes.dex */
    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2787a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f2787a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2787a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2787a[RefreshState.Refreshing.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2787a[RefreshState.ReleaseToRefresh.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public ClassicsHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2780a = "LAST_UPDATE_TIME";
        this.g = new SimpleDateFormat("上次更新 M-d HH:mm", Locale.CHINA);
        this.h = SpinnerStyle.Translate;
        a(context, attributeSet, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        FragmentManager supportFragmentManager;
        List<Fragment> u;
        com.scwang.smartrefresh.layout.e.a aVar = new com.scwang.smartrefresh.layout.e.a();
        setMinimumHeight(aVar.a(80.0f));
        LinearLayout linearLayout = new LinearLayout(context, attributeSet, i);
        linearLayout.setId(R.id.widget_frame);
        linearLayout.setGravity(1);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(context);
        this.f2781b = textView;
        textView.setText(k);
        this.f2781b.setTextColor(-10066330);
        this.f2781b.setTextSize(16.0f);
        TextView textView2 = new TextView(context);
        this.f2782c = textView2;
        textView2.setTextColor(-8618884);
        this.f2782c.setTextSize(12.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = aVar.a(20.0f);
        layoutParams.rightMargin = aVar.a(20.0f);
        linearLayout.addView(this.f2781b, layoutParams);
        linearLayout.addView(this.f2782c, new LinearLayout.LayoutParams(-2, -2));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        addView(linearLayout, layoutParams2);
        com.scwang.smartrefresh.layout.c.a aVar2 = new com.scwang.smartrefresh.layout.c.a();
        this.f = aVar2;
        aVar2.a(-10066330);
        ImageView imageView = new ImageView(context);
        this.e = imageView;
        imageView.setImageDrawable(this.f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(aVar.a(20.0f), aVar.a(20.0f));
        layoutParams3.rightMargin = aVar.a(20.0f);
        layoutParams3.addRule(15);
        layoutParams3.addRule(0, R.id.widget_frame);
        addView(this.e, layoutParams3);
        PathsView pathsView = new PathsView(context);
        this.f2783d = pathsView;
        pathsView.a(-10066330);
        this.f2783d.a("M20,12l-1.41,-1.41L13,16.17V4h-2v12.17l-5.58,-5.59L4,12l8,8 8,-8z");
        addView(this.f2783d, layoutParams3);
        if (isInEditMode()) {
            this.f2783d.setVisibility(8);
            this.f2781b.setText(l);
        } else {
            this.e.setVisibility(8);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClassicsHeader);
        this.h = SpinnerStyle.values()[obtainStyledAttributes.getInt(R$styleable.ClassicsHeader_srlClassicsSpinnerStyle, this.h.ordinal())];
        int color = obtainStyledAttributes.getColor(R$styleable.ClassicsHeader_srlPrimaryColor, 0);
        int color2 = obtainStyledAttributes.getColor(R$styleable.ClassicsHeader_srlAccentColor, 0);
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
        if ((context instanceof FragmentActivity) && (supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager()) != null && (u = supportFragmentManager.u()) != null && u.size() > 0) {
            a(new Date());
            return;
        }
        this.f2780a += context.getClass().getName();
        this.i = context.getSharedPreferences("ClassicsHeader", 0);
        a(new Date(this.i.getLong(this.f2780a, System.currentTimeMillis())));
    }

    private void c() {
        Runnable runnable = this.j;
        if (runnable != null) {
            runnable.run();
            this.j = null;
        }
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public View a() {
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public void a(g gVar, int i, int i2) {
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public SpinnerStyle b() {
        return this.h;
    }

    @Override // com.scwang.smartrefresh.layout.a.e
    public void c(float f, int i, int i2, int i3) {
    }

    @Override // com.scwang.smartrefresh.layout.a.e
    public void d(float f, int i, int i2, int i3) {
    }

    public ClassicsHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2780a = "LAST_UPDATE_TIME";
        this.g = new SimpleDateFormat("上次更新 M-d HH:mm", Locale.CHINA);
        this.h = SpinnerStyle.Translate;
        a(context, attributeSet, i);
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public void a(h hVar, int i, int i2) {
        this.f.start();
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public int a(h hVar, boolean z) {
        this.f.stop();
        this.e.setVisibility(8);
        if (z) {
            this.f2781b.setText(n);
            a(new Date());
            return TransitionView.TRANSITION_ANIMATION_DURATION_MS;
        }
        this.f2781b.setText(o);
        return TransitionView.TRANSITION_ANIMATION_DURATION_MS;
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public void a(int... iArr) {
        if (iArr.length > 1) {
            setBackgroundColor(iArr[0]);
            this.f2783d.a(iArr[1]);
            this.f2781b.setTextColor(iArr[1]);
            this.f.a(iArr[1]);
            this.f2782c.setTextColor((iArr[1] & 16777215) | (-1728053248));
            return;
        }
        if (iArr.length > 0) {
            setBackgroundColor(iArr[0]);
            if (iArr[0] == -1) {
                this.f2783d.a(-10066330);
                this.f2781b.setTextColor(-10066330);
                this.f.a(-10066330);
                this.f2782c.setTextColor(-1721342362);
                return;
            }
            this.f2783d.a(-1);
            this.f2781b.setTextColor(-1);
            this.f.a(-1);
            this.f2782c.setTextColor(-1426063361);
        }
    }

    @Override // com.scwang.smartrefresh.layout.d.e
    public void a(h hVar, RefreshState refreshState, RefreshState refreshState2) {
        int i = b.f2787a[refreshState2.ordinal()];
        if (i == 1) {
            c();
        } else if (i != 2) {
            if (i == 3) {
                this.f2781b.setText(l);
                this.e.setVisibility(0);
                this.f2783d.setVisibility(8);
                return;
            } else {
                if (i != 4) {
                    return;
                }
                this.f2781b.setText(m);
                this.f2783d.animate().rotation(180.0f);
                a(hVar);
                return;
            }
        }
        this.f2781b.setText(k);
        this.f2783d.setVisibility(0);
        this.e.setVisibility(8);
        this.f2783d.animate().rotation(0.0f);
    }

    private void a(h hVar) {
        if (this.j == null && this.h == SpinnerStyle.FixedBehind) {
            this.j = new a(hVar);
            hVar.n().setBackgroundDrawable(getBackground());
        }
    }

    public ClassicsHeader a(Date date) {
        this.f2782c.setText(this.g.format(date));
        SharedPreferences sharedPreferences = this.i;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(this.f2780a, date.getTime()).apply();
        }
        return this;
    }
}
