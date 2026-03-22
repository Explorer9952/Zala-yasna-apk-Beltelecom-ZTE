package com.zte.iptvclient.android.common.player.multiplay.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/* compiled from: LayoutModuleEight.java */
/* loaded from: classes.dex */
public class b extends a {

    /* renamed from: b, reason: collision with root package name */
    private static b f5183b;

    private b() {
    }

    public static b a() {
        if (f5183b == null) {
            f5183b = new b();
        }
        a.f5182a = new int[]{0, 1, 2, 3};
        return f5183b;
    }

    @Override // com.zte.iptvclient.android.common.player.multiplay.d.a
    public int a(int i, int i2, int i3, int i4) {
        return i <= i3 / 2 ? i2 <= i4 / 2 ? 0 : 2 : i2 <= i4 / 2 ? 1 : 3;
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
                    int i5 = i / 2;
                    int i6 = i2 / 2;
                    childAt.layout(0, 0, i5, i6);
                    layoutParams.width = i5;
                    layoutParams.height = i6;
                } else if (i4 == 1) {
                    int i7 = i / 2;
                    int i8 = i2 / 2;
                    childAt.layout(i7, 0, i, i8);
                    layoutParams.width = i7;
                    layoutParams.height = i8;
                } else if (i4 == 2) {
                    int i9 = i2 / 2;
                    int i10 = i / 2;
                    childAt.layout(0, i9, i10, i2);
                    layoutParams.width = i10;
                    layoutParams.height = i9;
                } else if (i4 == 3) {
                    int i11 = i / 2;
                    int i12 = i2 / 2;
                    childAt.layout(i11, i12, i, i2);
                    layoutParams.width = i11;
                    layoutParams.height = i12;
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
        int i2 = a.f5182a[i];
        while (true) {
            int[] iArr = a.f5182a;
            if (i < iArr.length - 1) {
                int i3 = i + 1;
                iArr[i] = iArr[i3];
                i = i3;
            } else {
                iArr[3] = i2;
                return;
            }
        }
    }
}
