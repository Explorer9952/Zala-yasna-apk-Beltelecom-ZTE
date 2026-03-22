package com.zte.iptvclient.android.common.player.multiplay.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/* compiled from: LayoutModuleNine.java */
/* loaded from: classes.dex */
public class f extends a {

    /* renamed from: b, reason: collision with root package name */
    private static f f5188b;

    private f() {
    }

    public static f a() {
        if (f5188b == null) {
            f5188b = new f();
        }
        a.f5182a = new int[]{0, 1, 2, 3};
        return f5188b;
    }

    @Override // com.zte.iptvclient.android.common.player.multiplay.d.a
    public int a(int i, int i2, int i3, int i4) {
        if (i <= (i3 * 66) / 100) {
            return 0;
        }
        if (i2 <= i4 / 3) {
            return 1;
        }
        return i2 <= (i4 * 2) / 3 ? 2 : 3;
    }

    @Override // com.zte.iptvclient.android.common.player.multiplay.d.a
    public void a(ViewGroup viewGroup, int i, int i2) {
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) childAt.getLayoutParams();
            int[] iArr = a.f5182a;
            if (i3 >= iArr.length) {
                return;
            }
            int i4 = iArr[i3];
            if (layoutParams != null) {
                if (i4 == 0) {
                    int i5 = (i * 66) / 100;
                    childAt.layout(0, 0, i5, i2);
                    layoutParams.width = i5;
                    layoutParams.height = i2;
                } else if (i4 == 1) {
                    int i6 = i2 / 3;
                    childAt.layout((i * 66) / 100, 0, i, i6);
                    layoutParams.width = (i * 34) / 100;
                    layoutParams.height = i6;
                } else if (i4 == 2) {
                    int i7 = i2 / 3;
                    childAt.layout((i * 66) / 100, i7, i, (i2 * 2) / 3);
                    layoutParams.width = (i * 34) / 100;
                    layoutParams.height = i7;
                } else if (i4 == 3) {
                    childAt.layout((i * 66) / 100, (i2 * 2) / 3, i, i2);
                    layoutParams.width = (i * 34) / 100;
                    layoutParams.height = i2 / 3;
                }
            }
        }
    }

    @Override // com.zte.iptvclient.android.common.player.multiplay.d.a
    public void a(int i, int i2) {
        int i3 = a.f5182a[i];
        int i4 = 0;
        while (true) {
            int[] iArr = a.f5182a;
            if (i4 >= iArr.length) {
                break;
            }
            if (iArr[i4] == i2) {
                iArr[i4] = i3;
                break;
            }
            i4++;
        }
        a.f5182a[i] = i2;
    }

    @Override // com.zte.iptvclient.android.common.player.multiplay.d.a
    public void a(int i) {
        int[] iArr = a.f5182a;
        if (i >= iArr.length) {
            return;
        }
        int i2 = iArr[i];
        while (true) {
            int[] iArr2 = a.f5182a;
            if (i < iArr2.length - 1) {
                int i3 = i + 1;
                iArr2[i] = iArr2[i3];
                i = i3;
            } else {
                iArr2[3] = i2;
                return;
            }
        }
    }
}
