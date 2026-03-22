package com.zte.iptvclient.android.common.customview.viewgroup.gridview.draggridview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.GridView;
import com.video.androidsdk.log.LogEx;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.zala.R;
import d.c.a.a;
import d.c.a.i;
import d.c.a.l;
import d.c.a.m;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes.dex */
public class DragGridView extends GridView {

    /* renamed from: a, reason: collision with root package name */
    private int f4395a;

    /* renamed from: b, reason: collision with root package name */
    private int f4396b;

    /* renamed from: c, reason: collision with root package name */
    private BitmapDrawable f4397c;

    /* renamed from: d, reason: collision with root package name */
    private Rect f4398d;
    private String e;
    private View f;
    private int g;
    private int h;
    private boolean i;
    private boolean j;
    private boolean k;
    private com.zte.iptvclient.android.common.customview.viewgroup.gridview.draggridview.b l;
    private int m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements a.InterfaceC0407a {
        a() {
        }

        @Override // d.c.a.a.InterfaceC0407a
        public void a(d.c.a.a aVar) {
        }

        @Override // d.c.a.a.InterfaceC0407a
        public void b(d.c.a.a aVar) {
        }

        @Override // d.c.a.a.InterfaceC0407a
        public void c(d.c.a.a aVar) {
            DragGridView.this.k = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements l<Rect> {
        b() {
        }

        public int a(int i, int i2, float f) {
            return (int) (i + (f * (i2 - i)));
        }

        @Override // d.c.a.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Rect evaluate(float f, Rect rect, Rect rect2) {
            return new Rect(a(rect.left, rect2.left, f), a(rect.top, rect2.top, f), a(rect.right, rect2.right, f), a(rect.bottom, rect2.bottom, f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements m.g {
        c() {
        }

        @Override // d.c.a.m.g
        public void a(m mVar) {
            DragGridView.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements a.InterfaceC0407a {
        d() {
        }

        @Override // d.c.a.a.InterfaceC0407a
        public void a(d.c.a.a aVar) {
        }

        @Override // d.c.a.a.InterfaceC0407a
        public void b(d.c.a.a aVar) {
        }

        @Override // d.c.a.a.InterfaceC0407a
        public void c(d.c.a.a aVar) {
            DragGridView.this.j = false;
            if (DragGridView.this.h != DragGridView.this.g) {
                DragGridView.this.e();
                DragGridView dragGridView = DragGridView.this;
                dragGridView.g = dragGridView.h;
            }
            DragGridView.this.f4397c = null;
            DragGridView.this.f.findViewById(R.id.item_container).setVisibility(0);
            if (DragGridView.this.l != null) {
                DragGridView.this.l.a(DragGridView.this.h);
            }
        }
    }

    public DragGridView(Context context) {
        this(context, null);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        BitmapDrawable bitmapDrawable = this.f4397c;
        if (bitmapDrawable != null) {
            bitmapDrawable.draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() / getChildAt(0).getWidth();
        int childCount = getChildCount();
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        if (TextUtils.equals(com.zte.fragmentlib.publicbaseclass.skinloader.b.f4075b, "white.skin")) {
            paint.setColor(getContext().getResources().getColor(R.color.common_separateline_color));
        } else {
            paint.setColor(getContext().getResources().getColor(R.color.item_decoration_title_fontcolor));
        }
        for (int i = 0; i < childCount; i++) {
            int left = getChildAt(i).getLeft();
            if (left > this.m) {
                this.m = left;
            }
            if (androidx.core.c.c.b(Locale.getDefault()) == 1) {
                canvas.drawLine(r10.getLeft(), r10.getBottom(), r10.getRight(), r10.getBottom(), paint);
                canvas.drawLine(r10.getRight(), r10.getTop(), r10.getRight(), r10.getBottom(), paint);
                if (i == childCount - 1) {
                    canvas.drawLine(this.m, r10.getTop(), this.m, r10.getBottom(), paint);
                }
            } else {
                if (i < 3) {
                    canvas.drawLine(r10.getLeft(), r10.getBottom(), r10.getRight(), r10.getBottom(), paint);
                }
                if (i % width == 0) {
                    canvas.drawLine(r10.getLeft(), r10.getTop(), r10.getLeft(), r10.getBottom(), paint);
                }
                int i2 = i + 1;
                if (i2 % width == 0) {
                    canvas.drawLine(r10.getLeft(), r10.getBottom(), r10.getRight(), r10.getBottom(), paint);
                } else if (i2 > childCount - (childCount % width)) {
                    canvas.drawLine(r10.getRight(), r10.getTop(), r10.getRight(), r10.getBottom(), paint);
                    canvas.drawLine(r10.getLeft(), r10.getBottom(), r10.getRight(), r10.getBottom(), paint);
                } else {
                    canvas.drawLine(r10.getRight(), r10.getTop(), r10.getRight(), r10.getBottom(), paint);
                    canvas.drawLine(r10.getLeft(), r10.getBottom(), r10.getRight(), r10.getBottom(), paint);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
    
        if (r2 != 3) goto L22;
     */
    @Override // android.widget.AbsListView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            float r0 = r5.getX()
            int r0 = (int) r0
            float r1 = r5.getY()
            int r1 = (int) r1
            int r2 = r5.getAction()
            if (r2 == 0) goto L50
            r3 = 1
            if (r2 == r3) goto L45
            r3 = 2
            if (r2 == r3) goto L1a
            r0 = 3
            if (r2 == r0) goto L45
            goto L54
        L1a:
            boolean r2 = r4.j
            if (r2 == 0) goto L54
            int r5 = r4.f4395a
            int r5 = r0 - r5
            int r2 = r4.f4396b
            int r2 = r1 - r2
            r4.f4395a = r0
            r4.f4396b = r1
            android.graphics.Rect r3 = r4.f4398d
            r3.offset(r5, r2)
            android.graphics.drawable.BitmapDrawable r5 = r4.f4397c
            android.graphics.Rect r2 = r4.f4398d
            r5.setBounds(r2)
            r4.invalidate()
            boolean r5 = r4.k
            if (r5 != 0) goto L40
            r4.a(r0, r1)
        L40:
            r4.d()
            r5 = 0
            return r5
        L45:
            boolean r0 = r4.j
            if (r0 == 0) goto L54
            r4.c()
            r4.e()
            goto L54
        L50:
            r4.f4395a = r0
            r4.f4396b = r1
        L54:
            boolean r5 = super.onTouchEvent(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zte.iptvclient.android.common.customview.viewgroup.gridview.draggridview.DragGridView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public DragGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(int i) {
        ArrayList arrayList = new ArrayList();
        int i2 = this.h;
        if (i < i2) {
            for (int i3 = i + 1; i3 <= this.h; i3++) {
                View childAt = getChildAt(i3 - getFirstVisiblePosition());
                if (i3 % getNumColumns() == 0) {
                    arrayList.add(a(childAt, childAt.getWidth() * (getNumColumns() - 1), 0.0f, -childAt.getHeight(), 0.0f));
                } else {
                    arrayList.add(a(childAt, -childAt.getWidth(), 0.0f, 0.0f, 0.0f));
                }
            }
        } else {
            while (i2 < i) {
                View childAt2 = getChildAt(i2 - getFirstVisiblePosition());
                i2++;
                if (i2 % getNumColumns() == 0) {
                    arrayList.add(a(childAt2, (-childAt2.getWidth()) * (getNumColumns() - 1), 0.0f, childAt2.getHeight(), 0.0f));
                } else {
                    arrayList.add(a(childAt2, childAt2.getWidth(), 0.0f, 0.0f, 0.0f));
                }
            }
        }
        this.h = i;
        d.c.a.c cVar = new d.c.a.c();
        cVar.a(arrayList);
        cVar.a(300L);
        cVar.a(new AccelerateDecelerateInterpolator());
        cVar.a(new a());
        cVar.b();
    }

    private void d() {
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        int height = getHeight();
        int computeVerticalScrollExtent = computeVerticalScrollExtent();
        int computeHorizontalScrollRange = computeHorizontalScrollRange();
        if (this.f4398d.top <= 0 && computeVerticalScrollOffset > 0) {
            smoothScrollBy(-60, 0);
        } else {
            if (this.f4398d.bottom < height || computeVerticalScrollOffset + computeVerticalScrollExtent >= computeHorizontalScrollRange) {
                return;
            }
            smoothScrollBy(60, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        View view = this.f;
        if (view != null) {
            view.findViewById(R.id.item_container).setVisibility(0);
            this.f.findViewById(R.id.item_container).setBackgroundColor(c.a.a.a.d.b.d().b(R.color.column_sort_bg));
            ((SupportActivity) getContext()).a(this.f.findViewById(R.id.item_container), "background", R.color.column_sort_bg);
        }
    }

    public DragGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4395a = -1;
        this.f4396b = -1;
        this.e = "DragGridView";
        this.g = -1;
        this.h = -1;
    }

    public void b(int i) {
        if (i == -1) {
            return;
        }
        e();
        View childAt = getChildAt(i - getFirstVisiblePosition());
        this.f = childAt;
        if (childAt != null) {
            this.j = true;
            this.i = true;
            if (TextUtils.equals(com.zte.fragmentlib.publicbaseclass.skinloader.b.f4075b, "white.skin")) {
                this.f.findViewById(R.id.item_container).setBackground(getResources().getDrawable(R.drawable.drag_grid_line));
            } else {
                this.f.findViewById(R.id.item_container).setBackground(getResources().getDrawable(R.drawable.drag_grid_line_red));
            }
            this.g = i;
            this.h = i;
            this.f4397c = b(this.f);
            this.f.findViewById(R.id.item_container).setVisibility(4);
            com.zte.iptvclient.android.common.customview.viewgroup.gridview.draggridview.b bVar = this.l;
            if (bVar != null) {
                bVar.b(i);
            }
        }
    }

    public com.zte.iptvclient.android.common.customview.viewgroup.gridview.draggridview.a a() {
        return (com.zte.iptvclient.android.common.customview.viewgroup.gridview.draggridview.a) getAdapter();
    }

    public void a(int i) {
        if (this.i) {
            this.i = false;
            return;
        }
        e();
        LogEx.i(this.e, "点击 Item " + i);
    }

    private void a(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition == -1 || pointToPosition == this.h) {
            return;
        }
        this.k = true;
        this.i = false;
        e();
        a().a(this.h, pointToPosition);
        View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
        this.f = childAt;
        childAt.findViewById(R.id.item_container).setVisibility(4);
        this.f.findViewById(R.id.item_container).setBackgroundColor(Color.parseColor("#ffffff"));
        c(pointToPosition);
    }

    private void b() {
        i a2 = i.a(this.f4397c, "bounds", new b(), this.f4398d);
        a2.a(new c());
        a2.a(new d());
        a2.b();
    }

    private d.c.a.a a(View view, float f, float f2, float f3, float f4) {
        i a2 = i.a(view, "translationX", f, f2);
        i a3 = i.a(view, "translationY", f3, f4);
        d.c.a.c cVar = new d.c.a.c();
        cVar.a(a2, a3);
        return cVar;
    }

    private void c() {
        this.f4398d.set(this.f.getLeft(), this.f.getTop(), this.f.getRight(), this.f.getBottom());
        b();
    }

    private BitmapDrawable b(View view) {
        int left = view.getLeft();
        int top = view.getTop();
        int width = view.getWidth();
        int height = view.getHeight();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), a(view));
        Rect rect = new Rect(left - 18, top - 18, left + width + 18, top + height + 18);
        this.f4398d = rect;
        bitmapDrawable.setBounds(rect);
        return bitmapDrawable;
    }

    private Bitmap a(View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }
}
