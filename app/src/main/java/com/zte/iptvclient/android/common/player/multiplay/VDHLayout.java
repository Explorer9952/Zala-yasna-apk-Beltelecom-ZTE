package com.zte.iptvclient.android.common.player.multiplay;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.e.j;
import androidx.customview.a.a;
import com.video.androidsdk.log.LogEx;
import com.zte.iptvclient.android.common.javabean.f;
import com.zte.iptvclient.android.common.player.k.d;
import com.zte.iptvclient.android.zala.R;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class VDHLayout extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private androidx.customview.a.a f5121a;

    /* renamed from: b, reason: collision with root package name */
    private int f5122b;

    /* renamed from: c, reason: collision with root package name */
    private int f5123c;

    /* renamed from: d, reason: collision with root package name */
    private com.zte.iptvclient.android.common.player.multiplay.d.a f5124d;
    private ArrayList<View> e;
    private ArrayList<Point> f;
    private View g;
    private boolean h;
    private b i;
    private int j;
    private boolean k;

    /* loaded from: classes.dex */
    class a extends a.c {
        a() {
        }

        @Override // androidx.customview.a.a.c
        public int a(View view, int i, int i2) {
            return i;
        }

        @Override // androidx.customview.a.a.c
        public void a(int i, int i2) {
        }

        @Override // androidx.customview.a.a.c
        public void a(View view, int i, int i2, int i3, int i4) {
            super.a(view, i, i2, i3, i4);
        }

        @Override // androidx.customview.a.a.c
        public int b(View view, int i, int i2) {
            return i;
        }

        @Override // androidx.customview.a.a.c
        public boolean b(View view, int i) {
            if (VDHLayout.this.k) {
                LogEx.d("VDHLayout", "onLayout mIsForceLayout=" + VDHLayout.this.k);
                return false;
            }
            int i2 = com.zte.iptvclient.android.common.player.multiplay.d.c.f5184a;
            if (i2 == 3) {
                return false;
            }
            if (i2 != 10) {
                if (VDHLayout.this.g == null) {
                    VDHLayout.this.g = view;
                }
                VDHLayout.this.g.setBackgroundResource(R.drawable.black);
                VDHLayout.this.f5124d.a(((ViewGroup) view.getParent()).indexOfChild(view));
                view.bringToFront();
                view.setBackgroundResource(R.drawable.br_blue);
                VDHLayout.this.g = view;
                if (VDHLayout.this.i == null) {
                    return true;
                }
                VDHLayout.this.i.c((d) view.getTag(R.id.multi_player_tag2));
                return true;
            }
            VDHLayout.this.j = 0;
            if (VDHLayout.this.i != null) {
                VDHLayout.this.i.a((d) view.getTag(R.id.multi_player_tag2));
            }
            return false;
        }

        @Override // androidx.customview.a.a.c
        public void a(View view, float f, float f2) {
            int left = view.getLeft() + ((view.getRight() - view.getLeft()) / 2);
            int top = view.getTop() + ((view.getBottom() - view.getTop()) / 2);
            int indexOfChild = ((ViewGroup) view.getParent()).indexOfChild(view);
            int i = com.zte.iptvclient.android.common.player.multiplay.d.a.f5182a[indexOfChild];
            int a2 = VDHLayout.this.f5124d.a(left, top, VDHLayout.this.f5122b, VDHLayout.this.f5123c);
            VDHLayout.this.j = a2;
            Log.d("VDHLayout", "OldPosition" + i + "NewPosition" + a2);
            if (i == a2) {
                int i2 = 0;
                while (true) {
                    if (i2 >= VDHLayout.this.e.size()) {
                        break;
                    }
                    if (((View) VDHLayout.this.e.get(i2)).equals(view)) {
                        VDHLayout.this.f5121a.d(((Point) VDHLayout.this.f.get(i2)).x, ((Point) VDHLayout.this.f.get(i2)).y);
                        VDHLayout.this.invalidate();
                        break;
                    }
                    i2++;
                }
            } else {
                VDHLayout.this.h = true;
                VDHLayout.this.f5124d.a(indexOfChild, a2);
                VDHLayout.this.e.remove(view);
                VDHLayout.this.e.add(a2, view);
                view.bringToFront();
            }
            if (VDHLayout.this.i != null) {
                VDHLayout.this.i.a((d) view.getTag(R.id.multi_player_tag2));
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(d dVar);

        void b(d dVar);

        void c(d dVar);
    }

    public VDHLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new ArrayList<>();
        this.f = new ArrayList<>();
        this.h = true;
        this.i = null;
        this.k = false;
        this.f5124d = com.zte.iptvclient.android.common.player.multiplay.d.c.a();
        androidx.customview.a.a a2 = androidx.customview.a.a.a(this, 3.0f, new a());
        this.f5121a = a2;
        a2.d(1);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f5121a.a(true)) {
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int b2 = j.b(motionEvent);
        if (b2 != 3 && b2 != 1) {
            return this.f5121a.b(motionEvent);
        }
        this.f5121a.b();
        return false;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams;
        super.onLayout(z, i, i2, i3, i4);
        LogEx.d("VDHLayout", "onLayout mIsForceLayout=" + this.k);
        if (this.k) {
            return;
        }
        this.f5122b = i3;
        this.f5123c = i4;
        com.zte.iptvclient.android.common.player.multiplay.d.a aVar = this.f5124d;
        if (aVar != null) {
            aVar.a(this, i3, i4);
        }
        if (this.h) {
            this.h = false;
            if (getChildCount() > 0 && getChildAt(0) != null && (layoutParams = getChildAt(0).getLayoutParams()) != null) {
                getChildAt(0).setLayoutParams(layoutParams);
            }
        }
        ArrayList<Point> arrayList = this.f;
        if (arrayList != null) {
            arrayList.clear();
        }
        for (int i5 = 0; i5 < this.e.size(); i5++) {
            Point point = new Point();
            point.x = this.e.get(i5).getLeft();
            point.y = this.e.get(i5).getTop();
            ArrayList<Point> arrayList2 = this.f;
            if (arrayList2 != null) {
                arrayList2.add(point);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f5121a.a(motionEvent);
        return true;
    }

    public com.zte.iptvclient.android.common.player.multiplay.d.a b() {
        return this.f5124d;
    }

    public void c(View view) {
        if (view == null) {
            return;
        }
        this.g = view;
    }

    public ArrayList<View> d() {
        return this.e;
    }

    public void e() {
        this.f5124d = com.zte.iptvclient.android.common.player.multiplay.d.c.a();
        this.h = true;
    }

    public void b(View view) {
        if (view == null) {
            return;
        }
        this.g = view;
        view.setBackgroundResource(R.drawable.br_blue);
    }

    public View c() {
        return this.g;
    }

    public void a(b bVar) {
        this.i = bVar;
    }

    public void a(boolean z) {
        this.k = z;
    }

    public ArrayList<View> a() {
        ArrayList<View> arrayList = new ArrayList<>();
        for (int i = 0; i < getChildCount(); i++) {
            arrayList.add(getChildAt(i));
        }
        return arrayList;
    }

    public void a(View view) {
        this.e.add(view);
    }

    public void a(ArrayList<f> arrayList) {
        boolean z;
        int i = 0;
        while (i < this.e.size()) {
            int i2 = 0;
            while (true) {
                if (i2 >= arrayList.size()) {
                    z = true;
                    break;
                } else {
                    if (((f) this.e.get(i).getTag(R.id.multi_player_tag1)).d().equals(arrayList.get(i2).d())) {
                        z = false;
                        break;
                    }
                    i2++;
                }
            }
            if (z) {
                View view = this.g;
                if (view != null && view.equals(this.e.get(i))) {
                    this.g = null;
                }
                ((d) this.e.get(i).getTag(R.id.multi_player_tag2)).R();
                b bVar = this.i;
                if (bVar != null) {
                    bVar.b((d) this.e.get(i).getTag(R.id.multi_player_tag2));
                }
                removeView(this.e.get(i));
                this.e.remove(i);
                i--;
            }
            i++;
        }
    }

    public boolean a(int i) {
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            if (this.e.get(i2).getId() == i) {
                return true;
            }
        }
        return false;
    }

    public boolean a(f fVar) {
        for (int i = 0; i < this.e.size(); i++) {
            if (((f) this.e.get(i).getTag(R.id.multi_player_tag1)).d().equals(fVar.d())) {
                return false;
            }
        }
        return true;
    }
}
