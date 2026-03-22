package com.zte.iptvclient.android.common.customview.viewgroup.layout.relativelayout.refresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ahmobile.android.tvclient.R$styleable;
import com.scwang.smartrefresh.layout.a.e;
import com.scwang.smartrefresh.layout.a.g;
import com.scwang.smartrefresh.layout.a.h;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.zala.R;
import com.zte.iptvclient.common.uiframe.f;

/* loaded from: classes.dex */
public class DefaultRefreshHeader extends RelativeLayout implements e {

    /* renamed from: a, reason: collision with root package name */
    private FrameLayout f4421a;

    /* renamed from: b, reason: collision with root package name */
    protected ProgressBar f4422b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f4423c;

    /* renamed from: d, reason: collision with root package name */
    private SpinnerStyle f4424d;
    private RelativeLayout e;
    private ImageView f;
    private AnimationDrawable g;
    protected SupportActivity h;
    private Runnable i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        Drawable f4425a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ h f4426b;

        a(h hVar) {
            this.f4426b = hVar;
            this.f4425a = this.f4426b.n().getBackground();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4426b.n().setBackgroundDrawable(this.f4425a);
        }
    }

    /* loaded from: classes.dex */
    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4428a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f4428a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4428a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4428a[RefreshState.Refreshing.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4428a[RefreshState.ReleaseToRefresh.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public DefaultRefreshHeader(Context context) {
        super(context);
        this.f4424d = SpinnerStyle.Translate;
        a(context, (AttributeSet) null, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i) {
        setMinimumHeight(new com.scwang.smartrefresh.layout.e.a().a(80.0f));
        LayoutInflater.from(context).inflate(R.layout.default_refresh_header, this);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl_refresh);
        this.e = relativeLayout;
        relativeLayout.setBackgroundColor(c.a.a.a.d.b.d().b(R.color.default_refresh_header_bg));
        SupportActivity supportActivity = this.h;
        if (supportActivity != null) {
            supportActivity.a(this.e, "background", R.color.default_refresh_header_bg);
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.fl_inner);
        this.f4421a = frameLayout;
        this.f4423c = (TextView) frameLayout.findViewById(R.id.pull_to_refresh_text);
        this.f4422b = (ProgressBar) this.f4421a.findViewById(R.id.pull_to_refresh_progress);
        this.f4423c.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.pull_down_to_refresh));
        this.f4423c.setTextColor(-10066330);
        this.f4423c.setTextSize(12.0f);
        ImageView imageView = (ImageView) findViewById(R.id.animation_iv);
        this.f = imageView;
        f.a(imageView);
        this.g = (AnimationDrawable) this.f.getDrawable();
        if (isInEditMode()) {
            this.f4423c.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.loading));
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClassicsHeader);
        this.f4424d = SpinnerStyle.values()[obtainStyledAttributes.getInt(1, this.f4424d.ordinal())];
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

    private void d() {
        Runnable runnable = this.i;
        if (runnable != null) {
            runnable.run();
            this.i = null;
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
    public void a(h hVar, int i, int i2) {
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public SpinnerStyle b() {
        return this.f4424d;
    }

    public void c() {
        this.e.setBackgroundColor(getResources().getColor(R.color.multiplayer_theme_bg_dark));
    }

    @Override // com.scwang.smartrefresh.layout.a.e
    public void d(float f, int i, int i2, int i3) {
    }

    public DefaultRefreshHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4424d = SpinnerStyle.Translate;
        a(context, attributeSet, 0);
    }

    @Override // com.scwang.smartrefresh.layout.a.e
    public void c(float f, int i, int i2, int i3) {
        this.f4422b.setVisibility(0);
    }

    public DefaultRefreshHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4424d = SpinnerStyle.Translate;
        a(context, attributeSet, i);
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public int a(h hVar, boolean z) {
        if (z) {
            this.f4423c.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.refresh_complete));
        } else {
            this.f4423c.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.refresh_failed));
        }
        this.f4422b.setVisibility(8);
        this.g.stop();
        return 0;
    }

    @Override // com.scwang.smartrefresh.layout.a.f
    public void a(int... iArr) {
        if (iArr.length > 1) {
            setBackgroundColor(iArr[0]);
            this.f4423c.setTextColor(iArr[1]);
        } else if (iArr.length > 0) {
            setBackgroundColor(iArr[0]);
            if (iArr[0] == -1) {
                this.f4423c.setTextColor(-10066330);
            } else {
                this.f4423c.setTextColor(-1);
            }
        }
    }

    @Override // com.scwang.smartrefresh.layout.d.e
    public void a(h hVar, RefreshState refreshState, RefreshState refreshState2) {
        int i = b.f4428a[refreshState2.ordinal()];
        if (i == 1) {
            d();
            return;
        }
        if (i == 2) {
            this.f4423c.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.pull_down_to_refresh));
            this.g.selectDrawable(0);
        } else if (i == 3) {
            this.f4423c.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.loading));
            this.g.start();
        } else {
            if (i != 4) {
                return;
            }
            this.f4423c.setText(com.zte.iptvclient.android.common.i.a.a.a(R.string.refresh_release));
            a(hVar);
        }
    }

    private void a(h hVar) {
        if (this.i == null && this.f4424d == SpinnerStyle.FixedBehind) {
            this.i = new a(hVar);
            hVar.n().setBackgroundDrawable(getBackground());
        }
    }
}
