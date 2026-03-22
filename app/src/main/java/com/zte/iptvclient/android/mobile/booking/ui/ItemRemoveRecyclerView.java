package com.zte.iptvclient.android.mobile.booking.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.Scroller;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.zte.iptvclient.android.mobile.booking.ui.b.b;
import com.zte.iptvclient.android.mobile.booking.ui.b.c;
import com.zte.iptvclient.android.zala.R;
import ijk.media.player.IMediaPlayer;

/* loaded from: classes.dex */
public class ItemRemoveRecyclerView extends RecyclerView {
    private int L0;
    private int M0;
    private int N0;
    private LinearLayout O0;
    private TextView P0;
    private int Q0;
    private boolean R0;
    private boolean S0;
    private boolean T0;
    private int U0;
    private VelocityTracker V0;
    private Scroller W0;
    private com.zte.iptvclient.android.mobile.c.c.a X0;
    private int Y0;
    private b Z0;
    private c a1;
    private com.zte.iptvclient.android.mobile.booking.ui.b.a b1;

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ItemRemoveRecyclerView.this.X0.a(ItemRemoveRecyclerView.this.N0);
            ItemRemoveRecyclerView.this.O0.scrollTo(0, 0);
            ItemRemoveRecyclerView.this.U0 = 0;
        }
    }

    public ItemRemoveRecyclerView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.W0.computeScrollOffset()) {
            this.O0.scrollTo(this.W0.getCurrX(), this.W0.getCurrY());
            invalidate();
        } else if (this.T0) {
            this.T0 = false;
            if (this.U0 == 1) {
                this.U0 = 0;
            }
            if (this.U0 == 2) {
                this.U0 = 3;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void i(int i) {
        super.i(i);
        this.R0 = i == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.V0.recycle();
        super.onDetachedFromWindow();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        int i2;
        com.zte.iptvclient.android.mobile.c.c.a aVar;
        this.V0.addMovement(motionEvent);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            int i3 = this.U0;
            if (i3 != 0) {
                if (i3 == 3) {
                    this.W0.startScroll(this.O0.getScrollX(), 0, -this.Q0, 0, IMediaPlayer.MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK);
                    invalidate();
                    this.U0 = 0;
                }
                return false;
            }
            View a2 = a(x, y);
            if (a2 == null) {
                return false;
            }
            int i4 = this.Y0;
            if (i4 == 0) {
                b bVar = (b) g(a2);
                this.Z0 = bVar;
                this.O0 = bVar.w;
                this.N0 = bVar.i();
            } else if (i4 == 1) {
                c cVar = (c) g(a2);
                this.a1 = cVar;
                this.O0 = cVar.v;
                this.N0 = cVar.i();
            } else if (i4 == 2) {
                b bVar2 = (b) g(a2);
                this.Z0 = bVar2;
                this.O0 = bVar2.w;
                this.N0 = bVar2.i();
            } else {
                com.zte.iptvclient.android.mobile.booking.ui.b.a aVar2 = (com.zte.iptvclient.android.mobile.booking.ui.b.a) g(a2);
                this.b1 = aVar2;
                this.O0 = aVar2.y;
                this.N0 = aVar2.i();
            }
            TextView textView = (TextView) this.O0.findViewById(R.id.item_delete);
            this.P0 = textView;
            this.Q0 = textView.getWidth();
            this.P0.setOnClickListener(new a());
        } else if (action == 1) {
            if (!this.S0 && !this.R0 && (aVar = this.X0) != null) {
                aVar.a(this.O0, this.N0);
            }
            this.S0 = false;
            this.V0.computeCurrentVelocity(1000);
            float xVelocity = this.V0.getXVelocity();
            float yVelocity = this.V0.getYVelocity();
            int scrollX = this.O0.getScrollX();
            if (Math.abs(xVelocity) <= 100.0f || Math.abs(xVelocity) <= Math.abs(yVelocity)) {
                int i5 = this.Q0;
                if (scrollX >= i5 / 2) {
                    i = i5 - scrollX;
                    this.U0 = 2;
                } else {
                    if (scrollX < i5 / 2) {
                        i = -scrollX;
                        this.U0 = 1;
                    }
                    i2 = 0;
                }
                i2 = i;
            } else {
                if (xVelocity <= -100.0f) {
                    i = this.Q0 - scrollX;
                    this.U0 = 2;
                } else {
                    if (xVelocity > 100.0f) {
                        i = -scrollX;
                        this.U0 = 1;
                    }
                    i2 = 0;
                }
                i2 = i;
            }
            this.W0.startScroll(scrollX, 0, i2, 0, IMediaPlayer.MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK);
            this.T0 = true;
            invalidate();
            this.V0.clear();
        } else if (action == 2) {
            int i6 = this.L0 - x;
            int i7 = this.M0 - y;
            int scrollX2 = this.O0.getScrollX();
            if (Math.abs(i6) > Math.abs(i7)) {
                this.S0 = true;
                int i8 = scrollX2 + i6;
                if (i8 <= 0) {
                    this.O0.scrollTo(0, 0);
                    return true;
                }
                int i9 = this.Q0;
                if (i8 >= i9) {
                    this.O0.scrollTo(i9, 0);
                    return true;
                }
                this.O0.scrollBy(i6, 0);
            }
        }
        this.L0 = x;
        this.M0 = y;
        return super.onTouchEvent(motionEvent);
    }

    public ItemRemoveRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ItemRemoveRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Y0 = 0;
        this.W0 = new Scroller(context, new LinearInterpolator());
        this.V0 = VelocityTracker.obtain();
    }

    public void a(int i, com.zte.iptvclient.android.mobile.c.c.a aVar) {
        this.Y0 = i;
        this.X0 = aVar;
    }
}
