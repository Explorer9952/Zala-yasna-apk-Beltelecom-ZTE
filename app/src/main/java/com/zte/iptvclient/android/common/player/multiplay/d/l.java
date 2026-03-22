package com.zte.iptvclient.android.common.player.multiplay.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/* compiled from: LayoutModuleTwo.java */
/* loaded from: classes.dex */
public class l extends a {

    /* renamed from: b, reason: collision with root package name */
    private static l f5194b;

    private l() {
    }

    public static l a() {
        if (f5194b == null) {
            f5194b = new l();
        }
        a.f5182a = new int[]{0, 1};
        return f5194b;
    }

    @Override // com.zte.iptvclient.android.common.player.multiplay.d.a
    public int a(int i, int i2, int i3, int i4) {
        return i <= i3 / 2 ? 0 : 1;
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
                    childAt.layout(0, 0, i5, i2);
                    layoutParams.width = i5;
                    layoutParams.height = i2;
                } else if (i4 == 1) {
                    int i6 = i / 2;
                    childAt.layout(i6, 0, i, i2);
                    layoutParams.width = i6;
                    layoutParams.height = i2;
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
                iArr2[1] = i2;
                return;
            }
        }
    }
}
