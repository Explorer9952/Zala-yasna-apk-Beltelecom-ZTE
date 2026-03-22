package com.zte.iptvclient.android.common.player.multiplay.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/* compiled from: LayoutModuleFive.java */
/* loaded from: classes.dex */
public class d extends a {

    /* renamed from: b, reason: collision with root package name */
    private static d f5186b;

    private d() {
    }

    public static d a() {
        if (f5186b == null) {
            f5186b = new d();
        }
        a.f5182a = new int[]{0, 1, 2};
        return f5186b;
    }

    @Override // com.zte.iptvclient.android.common.player.multiplay.d.a
    public int a(int i, int i2, int i3, int i4) {
        if (i2 <= i4 / 2) {
            return 0;
        }
        return i <= i3 / 2 ? 1 : 2;
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
                int i5 = i2 / 2;
                childAt.layout(i / 4, 0, (i * 3) / 4, i5);
                if (layoutParams != null) {
                    layoutParams.width = i / 2;
                    layoutParams.height = i5;
                }
            } else if (i4 == 1) {
                int i6 = i2 / 2;
                int i7 = i / 2;
                childAt.layout(0, i6, i7, i2);
                if (layoutParams != null) {
                    layoutParams.width = i7;
                    layoutParams.height = i6;
                }
            } else if (i4 == 2) {
                int i8 = i / 2;
                int i9 = i2 / 2;
                childAt.layout(i8, i9, i, i2);
                if (layoutParams != null) {
                    layoutParams.width = i8;
                    layoutParams.height = i9;
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
                iArr2[2] = i2;
                return;
            }
        }
    }
}
