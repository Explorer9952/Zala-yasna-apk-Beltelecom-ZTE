package com.zte.iptvclient.common.uiframe;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.PopupWindow;

/* loaded from: classes2.dex */
public class BasePopupWindow extends PopupWindow {

    /* renamed from: a, reason: collision with root package name */
    c f7873a;

    /* renamed from: b, reason: collision with root package name */
    private int f7874b;

    /* renamed from: c, reason: collision with root package name */
    private Handler f7875c;

    /* loaded from: classes2.dex */
    class a implements View.OnKeyListener {
        a() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i != 4 || !BasePopupWindow.this.isShowing()) {
                return false;
            }
            BasePopupWindow.this.dismiss();
            BasePopupWindow basePopupWindow = BasePopupWindow.this;
            c cVar = basePopupWindow.f7873a;
            if (cVar == null) {
                return true;
            }
            cVar.a(basePopupWindow);
            return true;
        }
    }

    /* loaded from: classes2.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BasePopupWindow.this.dismiss();
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(PopupWindow popupWindow);
    }

    public BasePopupWindow() {
        this.f7873a = null;
        this.f7874b = 0;
        this.f7875c = new Handler();
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View view, int i, int i2, int i3) {
        if (this.f7874b > 0) {
            this.f7875c.postDelayed(new b(), this.f7874b);
        }
        super.showAtLocation(view, i, i2, i3);
    }

    public BasePopupWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7873a = null;
        this.f7874b = 0;
        this.f7875c = new Handler();
    }

    public BasePopupWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7873a = null;
        this.f7874b = 0;
        this.f7875c = new Handler();
    }

    public BasePopupWindow(View view, int i, int i2, boolean z) {
        super(view, i, i2, z);
        this.f7873a = null;
        this.f7874b = 0;
        this.f7875c = new Handler();
        view.setOnKeyListener(new a());
    }
}
