package net.lucode.hackware.magicindicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes2.dex */
public class MagicIndicator extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private net.lucode.hackware.magicindicator.d.a f8231a;

    public MagicIndicator(Context context) {
        super(context);
    }

    public void a(int i, float f, int i2) {
        net.lucode.hackware.magicindicator.d.a aVar = this.f8231a;
        if (aVar != null) {
            aVar.a(i, f, i2);
        }
    }

    public void b(int i) {
        net.lucode.hackware.magicindicator.d.a aVar = this.f8231a;
        if (aVar != null) {
            aVar.b(i);
        }
    }

    public MagicIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a(int i) {
        net.lucode.hackware.magicindicator.d.a aVar = this.f8231a;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    public void a(net.lucode.hackware.magicindicator.d.a aVar) {
        net.lucode.hackware.magicindicator.d.a aVar2 = this.f8231a;
        if (aVar2 == aVar) {
            return;
        }
        if (aVar2 != null) {
            aVar2.b();
        }
        this.f8231a = aVar;
        removeAllViews();
        if (this.f8231a instanceof View) {
            addView((View) this.f8231a, new FrameLayout.LayoutParams(-1, -1));
            this.f8231a.a();
        }
    }
}
