package com.zte.iptvclient.android.common.player.multiplay.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/* compiled from: LayoutModuleThree.java */
/* loaded from: classes.dex */
public class k extends a {

    /* renamed from: b, reason: collision with root package name */
    private static k f5193b;

    private k() {
    }

    public static k a() {
        if (f5193b == null) {
            f5193b = new k();
        }
        a.f5182a = new int[]{0, 1};
        return f5193b;
    }

    @Override // com.zte.iptvclient.android.common.player.multiplay.d.a
    public int a(int i, int i2, int i3, int i4) {
        int i5 = (i3 * 3) / 4;
        if (i5 >= i || i >= i4) {
            return 0;
        }
        int i6 = i5 - (i3 / 5);
        return (i2 <= (i3 / 4) + i6 || i2 >= i6) ? 0 : 1;
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
            if (i4 == 0) {
                childAt.layout(0, 0, i, i2);
                if (layoutParams != null) {
                    layoutParams.width = i;
                    layoutParams.height = i2;
                }
            } else if (i4 == 1) {
                if (layoutParams != null) {
                    layoutParams.width = i / 4;
                    layoutParams.height = i2 / 4;
                }
                int i5 = ((i2 * 3) / 4) - (i2 / 5);
                childAt.layout((i * 3) / 4, i5, i, (i2 / 4) + i5);
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
                iArr2[1] = i2;
                return;
            }
        }
    }
}
