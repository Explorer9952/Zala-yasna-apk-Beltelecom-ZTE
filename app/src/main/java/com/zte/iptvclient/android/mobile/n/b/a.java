package com.zte.iptvclient.android.mobile.n.b;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.facebook.appevents.codeless.internal.Constants;

/* compiled from: AndroidBug5497Workaround.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private View f6779a;

    /* renamed from: b, reason: collision with root package name */
    private int f6780b;

    /* renamed from: c, reason: collision with root package name */
    private FrameLayout.LayoutParams f6781c;

    /* renamed from: d, reason: collision with root package name */
    private int f6782d;
    private boolean e = true;
    private int f;

    /* compiled from: AndroidBug5497Workaround.java */
    /* renamed from: com.zte.iptvclient.android.mobile.n.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class ViewTreeObserverOnGlobalLayoutListenerC0307a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f6783a;

        ViewTreeObserverOnGlobalLayoutListenerC0307a(Activity activity) {
            this.f6783a = activity;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (a.this.e) {
                a aVar = a.this;
                aVar.f6782d = aVar.f6779a.getHeight();
                a.this.e = false;
            }
            a.this.b(this.f6783a);
        }
    }

    private a(Activity activity) {
        this.f = activity.getResources().getDimensionPixelSize(activity.getResources().getIdentifier("status_bar_height", "dimen", Constants.PLATFORM));
        View childAt = ((FrameLayout) activity.findViewById(R.id.content)).getChildAt(0);
        this.f6779a = childAt;
        childAt.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC0307a(activity));
        this.f6781c = (FrameLayout.LayoutParams) this.f6779a.getLayoutParams();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Activity activity) {
        int a2 = a((Context) activity);
        if (a2 != this.f6780b) {
            int height = this.f6779a.getRootView().getHeight();
            int i = height - a2;
            if (i > height / 4) {
                if (Build.VERSION.SDK_INT >= 19) {
                    FrameLayout.LayoutParams layoutParams = this.f6781c;
                    if (layoutParams != null) {
                        layoutParams.height = (height - i) + this.f;
                    }
                } else {
                    FrameLayout.LayoutParams layoutParams2 = this.f6781c;
                    if (layoutParams2 != null) {
                        layoutParams2.height = height - i;
                    }
                }
            } else {
                FrameLayout.LayoutParams layoutParams3 = this.f6781c;
                if (layoutParams3 != null) {
                    layoutParams3.height = this.f6782d;
                }
            }
            this.f6779a.requestLayout();
            this.f6780b = a2;
        }
    }

    public static void a(Activity activity) {
        new a(activity);
    }

    private int a(Context context) {
        Rect rect = new Rect();
        this.f6779a.getWindowVisibleDisplayFrame(rect);
        return (rect.bottom - rect.top) + Math.round(context.getResources().getDisplayMetrics().density * 100.0f);
    }
}
