package it.sephiroth.android.library.widget;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.Checkable;
import android.widget.ListAdapter;
import androidx.core.e.a;
import androidx.core.e.i0.c;
import b.b.h;
import com.ahmobile.android.tvclient.R$styleable;
import com.facebook.internal.Utility;
import com.video.androidsdk.log.LogEx;
import ijk.media.player.IMediaPlayer;
import it.sephiroth.android.library.util.ViewHelperFactory;
import it.sephiroth.android.library.util.v11.MultiChoiceModeListener;
import it.sephiroth.android.library.util.v11.MultiChoiceModeWrapper;
import it.sephiroth.android.library.widget.AdapterView;
import java.util.ArrayList;
import java.util.List;

@TargetApi(11)
/* loaded from: classes2.dex */
public abstract class AbsHListView extends AdapterView<ListAdapter> implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnTouchModeChangeListener {
    private static final int CHECK_POSITION_SEARCH_DISTANCE = 20;
    private static final int INVALID_POINTER = -1;
    public static final int LAYOUT_FORCE_LEFT = 1;
    public static final int LAYOUT_FORCE_RIGHT = 3;
    public static final int LAYOUT_MOVE_SELECTION = 6;
    public static final int LAYOUT_NORMAL = 0;
    public static final int LAYOUT_SET_SELECTION = 2;
    public static final int LAYOUT_SPECIFIC = 4;
    public static final int LAYOUT_SYNC = 5;
    protected static final int OVERSCROLL_LIMIT_DIVISOR = 3;
    private static final String TAG = "AbsListView";
    public static final int TOUCH_MODE_DONE_WAITING = 2;
    public static final int TOUCH_MODE_DOWN = 0;
    public static final int TOUCH_MODE_FLING = 4;
    private static final int TOUCH_MODE_OFF = 1;
    private static final int TOUCH_MODE_ON = 0;
    public static final int TOUCH_MODE_OVERFLING = 6;
    public static final int TOUCH_MODE_OVERSCROLL = 5;
    public static final int TOUCH_MODE_REST = -1;
    public static final int TOUCH_MODE_SCROLL = 3;
    public static final int TOUCH_MODE_TAP = 1;
    private static final int TOUCH_MODE_UNKNOWN = -1;
    public static final int TRANSCRIPT_MODE_ALWAYS_SCROLL = 2;
    public static final int TRANSCRIPT_MODE_DISABLED = 0;
    public static final int TRANSCRIPT_MODE_NORMAL = 1;
    private ListItemAccessibilityDelegate mAccessibilityDelegate;
    private int mActivePointerId;
    protected ListAdapter mAdapter;
    boolean mAdapterHasStableIds;
    private int mCacheColorHint;
    protected boolean mCachingActive;
    protected boolean mCachingStarted;
    protected h<Boolean> mCheckStates;
    LongSparseArray<Integer> mCheckedIdStates;
    int mCheckedItemCount;
    public Object mChoiceActionMode;
    protected int mChoiceMode;
    private Runnable mClearScrollingCache;
    private ContextMenu.ContextMenuInfo mContextMenuInfo;
    protected AdapterDataSetObserver mDataSetObserver;
    private int mDirection;
    boolean mDrawSelectorOnTop;
    private EdgeEffect mEdgeGlowBottom;
    private EdgeEffect mEdgeGlowTop;
    boolean mFastScrollEnabled;
    private int mFirstPositionDistanceGuess;
    private FlingRunnable mFlingRunnable;
    private boolean mForceTranscriptScroll;
    private int mGlowPaddingBottom;
    private int mGlowPaddingTop;
    protected int mHeightMeasureSpec;
    private float mHorizontalScrollFactor;
    protected boolean mIsAttached;
    private boolean mIsChildViewEnabled;
    protected final boolean[] mIsScrap;
    private int mLastAccessibilityScrollEventFromIndex;
    private int mLastAccessibilityScrollEventToIndex;
    private int mLastHandledItemCount;
    private int mLastPositionDistanceGuess;
    private int mLastScrollState;
    private int mLastTouchMode;
    int mLastX;
    protected int mLayoutMode;
    protected Rect mListPadding;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    int mMotionCorrection;
    protected int mMotionPosition;
    int mMotionViewNewLeft;
    int mMotionViewOriginalLeft;
    int mMotionX;
    int mMotionY;
    Object mMultiChoiceModeCallback;
    private OnScrollListener mOnScrollListener;
    int mOverflingDistance;
    int mOverscrollDistance;
    protected int mOverscrollMax;
    private CheckForKeyLongPress mPendingCheckForKeyLongPress;
    private CheckForLongPress mPendingCheckForLongPress;
    private Runnable mPendingCheckForTap;
    private SavedState mPendingSync;
    private PerformClick mPerformClick;
    protected Runnable mPositionScrollAfterLayout;
    protected PositionScroller mPositionScroller;
    protected final RecycleBin mRecycler;
    protected int mResurrectToPosition;
    View mScrollLeft;
    View mScrollRight;
    boolean mScrollingCacheEnabled;
    protected int mSelectedLeft;
    int mSelectionBottomPadding;
    int mSelectionLeftPadding;
    int mSelectionRightPadding;
    int mSelectionTopPadding;
    Drawable mSelector;
    int mSelectorPosition;
    protected Rect mSelectorRect;
    private boolean mSmoothScrollbarEnabled;
    protected boolean mStackFromRight;
    private Rect mTouchFrame;
    protected int mTouchMode;
    private Runnable mTouchModeReset;
    private int mTouchSlop;
    private int mTranscriptMode;
    private float mVelocityScale;
    private VelocityTracker mVelocityTracker;
    ViewHelperFactory.ViewHelper mViewHelper;
    static final Interpolator sLinearInterpolator = new LinearInterpolator();
    public static final int[] STATESET_NOTHING = {0};

    /* loaded from: classes2.dex */
    public class AdapterDataSetObserver extends AdapterView<ListAdapter>.AdapterDataSetObserver {
        public AdapterDataSetObserver() {
            super();
        }

        @Override // it.sephiroth.android.library.widget.AdapterView.AdapterDataSetObserver
        public /* bridge */ /* synthetic */ void clearSavedState() {
            super.clearSavedState();
        }

        @Override // it.sephiroth.android.library.widget.AdapterView.AdapterDataSetObserver, android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
        }

        @Override // it.sephiroth.android.library.widget.AdapterView.AdapterDataSetObserver, android.database.DataSetObserver
        public void onInvalidated() {
            super.onInvalidated();
        }
    }

    /* loaded from: classes2.dex */
    private class CheckForKeyLongPress extends WindowRunnnable implements Runnable {
        private CheckForKeyLongPress() {
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            AbsHListView absHListView;
            int i;
            boolean z;
            if (!AbsHListView.this.isPressed() || (i = (absHListView = AbsHListView.this).mSelectedPosition) < 0) {
                return;
            }
            View childAt = absHListView.getChildAt(i - absHListView.mFirstPosition);
            AbsHListView absHListView2 = AbsHListView.this;
            if (!absHListView2.mDataChanged) {
                if (sameWindow()) {
                    AbsHListView absHListView3 = AbsHListView.this;
                    z = absHListView3.performLongPress(childAt, absHListView3.mSelectedPosition, absHListView3.mSelectedColId);
                } else {
                    z = false;
                }
                if (z) {
                    AbsHListView.this.setPressed(false);
                    childAt.setPressed(false);
                    return;
                }
                return;
            }
            absHListView2.setPressed(false);
            if (childAt != null) {
                childAt.setPressed(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class CheckForLongPress extends WindowRunnnable implements Runnable {
        private CheckForLongPress() {
            super();
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
        /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r7 = this;
                it.sephiroth.android.library.widget.AbsHListView r0 = it.sephiroth.android.library.widget.AbsHListView.this
                int r1 = r0.mMotionPosition
                int r2 = r0.mFirstPosition
                int r1 = r1 - r2
                android.view.View r0 = r0.getChildAt(r1)
                if (r0 == 0) goto L3d
                it.sephiroth.android.library.widget.AbsHListView r1 = it.sephiroth.android.library.widget.AbsHListView.this
                int r2 = r1.mMotionPosition
                android.widget.ListAdapter r1 = r1.mAdapter
                long r3 = r1.getItemId(r2)
                boolean r1 = r7.sameWindow()
                r5 = 0
                if (r1 == 0) goto L29
                it.sephiroth.android.library.widget.AbsHListView r1 = it.sephiroth.android.library.widget.AbsHListView.this
                boolean r6 = r1.mDataChanged
                if (r6 != 0) goto L29
                boolean r1 = r1.performLongPress(r0, r2, r3)
                goto L2a
            L29:
                r1 = 0
            L2a:
                if (r1 == 0) goto L38
                it.sephiroth.android.library.widget.AbsHListView r1 = it.sephiroth.android.library.widget.AbsHListView.this
                r2 = -1
                r1.mTouchMode = r2
                r1.setPressed(r5)
                r0.setPressed(r5)
                goto L3d
            L38:
                it.sephiroth.android.library.widget.AbsHListView r0 = it.sephiroth.android.library.widget.AbsHListView.this
                r1 = 2
                r0.mTouchMode = r1
            L3d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: it.sephiroth.android.library.widget.AbsHListView.CheckForLongPress.run():void");
        }
    }

    /* loaded from: classes2.dex */
    final class CheckForTap implements Runnable {
        CheckForTap() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Drawable current;
            AbsHListView absHListView = AbsHListView.this;
            if (absHListView.mTouchMode == 0) {
                absHListView.mTouchMode = 1;
                View childAt = absHListView.getChildAt(absHListView.mMotionPosition - absHListView.mFirstPosition);
                if (childAt == null || childAt.hasFocusable()) {
                    return;
                }
                AbsHListView absHListView2 = AbsHListView.this;
                absHListView2.mLayoutMode = 0;
                if (!absHListView2.mDataChanged) {
                    childAt.setPressed(true);
                    AbsHListView.this.setPressed(true);
                    AbsHListView.this.layoutChildren();
                    AbsHListView absHListView3 = AbsHListView.this;
                    absHListView3.positionSelector(absHListView3.mMotionPosition, childAt);
                    AbsHListView.this.refreshDrawableState();
                    int longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    boolean isLongClickable = AbsHListView.this.isLongClickable();
                    Drawable drawable = AbsHListView.this.mSelector;
                    if (drawable != null && (current = drawable.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                        if (isLongClickable) {
                            ((TransitionDrawable) current).startTransition(longPressTimeout);
                        } else {
                            ((TransitionDrawable) current).resetTransition();
                        }
                    }
                    if (isLongClickable) {
                        if (AbsHListView.this.mPendingCheckForLongPress == null) {
                            AbsHListView absHListView4 = AbsHListView.this;
                            absHListView4.mPendingCheckForLongPress = new CheckForLongPress();
                        }
                        AbsHListView.this.mPendingCheckForLongPress.rememberWindowAttachCount();
                        AbsHListView absHListView5 = AbsHListView.this;
                        absHListView5.postDelayed(absHListView5.mPendingCheckForLongPress, longPressTimeout);
                        return;
                    }
                    AbsHListView.this.mTouchMode = 2;
                    return;
                }
                absHListView2.mTouchMode = 2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class FlingRunnable implements Runnable {
        private static final int FLYWHEEL_TIMEOUT = 40;
        private final Runnable mCheckFlywheel = new Runnable() { // from class: it.sephiroth.android.library.widget.AbsHListView.FlingRunnable.1
            @Override // java.lang.Runnable
            public void run() {
                int i = AbsHListView.this.mActivePointerId;
                VelocityTracker velocityTracker = AbsHListView.this.mVelocityTracker;
                OverScroller overScroller = FlingRunnable.this.mScroller;
                if (velocityTracker == null || i == -1) {
                    return;
                }
                velocityTracker.computeCurrentVelocity(1000, AbsHListView.this.mMaximumVelocity);
                float f = -velocityTracker.getXVelocity(i);
                if (Math.abs(f) >= AbsHListView.this.mMinimumVelocity && overScroller.isScrollingInDirection(f, 0.0f)) {
                    AbsHListView.this.postDelayed(this, 40L);
                    return;
                }
                FlingRunnable.this.endFling();
                AbsHListView absHListView = AbsHListView.this;
                absHListView.mTouchMode = 3;
                absHListView.reportScrollStateChange(1);
            }
        };
        private int mLastFlingX;
        private final OverScroller mScroller;

        FlingRunnable() {
            this.mScroller = new OverScroller(AbsHListView.this.getContext());
        }

        void edgeReached(int i) {
            this.mScroller.notifyHorizontalEdgeReached(AbsHListView.this.getScrollX(), 0, AbsHListView.this.mOverflingDistance);
            int overScrollMode = AbsHListView.this.getOverScrollMode();
            if (overScrollMode != 0 && (overScrollMode != 1 || AbsHListView.this.contentFits())) {
                AbsHListView absHListView = AbsHListView.this;
                absHListView.mTouchMode = -1;
                PositionScroller positionScroller = absHListView.mPositionScroller;
                if (positionScroller != null) {
                    positionScroller.stop();
                }
            } else {
                AbsHListView.this.mTouchMode = 6;
                int currVelocity = (int) this.mScroller.getCurrVelocity();
                if (i > 0) {
                    AbsHListView.this.mEdgeGlowTop.onAbsorb(currVelocity);
                } else {
                    AbsHListView.this.mEdgeGlowBottom.onAbsorb(currVelocity);
                }
            }
            AbsHListView.this.invalidate();
            AbsHListView.this.mViewHelper.postOnAnimation(this);
        }

        void endFling() {
            AbsHListView absHListView = AbsHListView.this;
            absHListView.mTouchMode = -1;
            absHListView.removeCallbacks(this);
            AbsHListView.this.removeCallbacks(this.mCheckFlywheel);
            AbsHListView.this.reportScrollStateChange(0);
            AbsHListView.this.clearScrollingCache();
            this.mScroller.abortAnimation();
            AbsHListView.this.overScrollBy(0, 0, 0, 0, 0, 0, 0, 0, false);
        }

        void flywheelTouch() {
            AbsHListView.this.postDelayed(this.mCheckFlywheel, 40L);
        }

        @Override // java.lang.Runnable
        public void run() {
            int max;
            int i = AbsHListView.this.mTouchMode;
            boolean z = false;
            if (i != 3) {
                if (i != 4) {
                    if (i != 6) {
                        endFling();
                        return;
                    }
                    OverScroller overScroller = this.mScroller;
                    if (overScroller.computeScrollOffset()) {
                        int scrollX = AbsHListView.this.getScrollX();
                        int currX = overScroller.getCurrX();
                        AbsHListView absHListView = AbsHListView.this;
                        if (!absHListView.overScrollBy(currX - scrollX, 0, scrollX, 0, 0, 0, absHListView.mOverflingDistance, 0, false)) {
                            AbsHListView.this.invalidate();
                            AbsHListView.this.mViewHelper.postOnAnimation(this);
                            return;
                        }
                        boolean z2 = scrollX <= 0 && currX > 0;
                        if (scrollX >= 0 && currX < 0) {
                            z = true;
                        }
                        if (!z2 && !z) {
                            startSpringback();
                            return;
                        }
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        if (z) {
                            currVelocity = -currVelocity;
                        }
                        overScroller.abortAnimation();
                        start(currVelocity);
                        return;
                    }
                    endFling();
                    return;
                }
            } else if (this.mScroller.isFinished()) {
                return;
            }
            AbsHListView absHListView2 = AbsHListView.this;
            if (absHListView2.mDataChanged) {
                absHListView2.layoutChildren();
            }
            AbsHListView absHListView3 = AbsHListView.this;
            if (absHListView3.mItemCount != 0 && absHListView3.getChildCount() != 0) {
                OverScroller overScroller2 = this.mScroller;
                boolean computeScrollOffset = overScroller2.computeScrollOffset();
                int currX2 = overScroller2.getCurrX();
                int i2 = this.mLastFlingX - currX2;
                if (i2 > 0) {
                    AbsHListView absHListView4 = AbsHListView.this;
                    absHListView4.mMotionPosition = absHListView4.mFirstPosition;
                    AbsHListView.this.mMotionViewOriginalLeft = absHListView4.getChildAt(0).getLeft();
                    max = Math.min(((AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight()) - AbsHListView.this.getPaddingLeft()) - 1, i2);
                } else {
                    int childCount = AbsHListView.this.getChildCount() - 1;
                    AbsHListView absHListView5 = AbsHListView.this;
                    absHListView5.mMotionPosition = absHListView5.mFirstPosition + childCount;
                    AbsHListView.this.mMotionViewOriginalLeft = absHListView5.getChildAt(childCount).getLeft();
                    max = Math.max(-(((AbsHListView.this.getWidth() - AbsHListView.this.getPaddingRight()) - AbsHListView.this.getPaddingLeft()) - 1), i2);
                }
                AbsHListView absHListView6 = AbsHListView.this;
                View childAt = absHListView6.getChildAt(absHListView6.mMotionPosition - absHListView6.mFirstPosition);
                int left = childAt != null ? childAt.getLeft() : 0;
                boolean trackMotionScroll = AbsHListView.this.trackMotionScroll(max, max);
                if (trackMotionScroll && max != 0) {
                    z = true;
                }
                if (z) {
                    if (childAt != null) {
                        int i3 = -(max - (childAt.getLeft() - left));
                        AbsHListView absHListView7 = AbsHListView.this;
                        absHListView7.overScrollBy(i3, 0, absHListView7.getScrollX(), 0, 0, 0, AbsHListView.this.mOverflingDistance, 0, false);
                    }
                    if (computeScrollOffset) {
                        edgeReached(max);
                        return;
                    }
                    return;
                }
                if (computeScrollOffset) {
                    if (trackMotionScroll) {
                        AbsHListView.this.invalidate();
                    }
                    this.mLastFlingX = currX2;
                    AbsHListView.this.mViewHelper.postOnAnimation(this);
                    return;
                }
                endFling();
                return;
            }
            endFling();
        }

        void start(int i) {
            int i2 = i < 0 ? Integer.MAX_VALUE : 0;
            this.mLastFlingX = i2;
            this.mScroller.setInterpolator(null);
            this.mScroller.fling(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
            AbsHListView absHListView = AbsHListView.this;
            absHListView.mTouchMode = 4;
            absHListView.mViewHelper.postOnAnimation(this);
        }

        void startOverfling(int i) {
            this.mScroller.setInterpolator(null);
            this.mScroller.fling(AbsHListView.this.getScrollX(), 0, i, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0, AbsHListView.this.getWidth(), 0);
            AbsHListView absHListView = AbsHListView.this;
            absHListView.mTouchMode = 6;
            absHListView.invalidate();
            AbsHListView.this.mViewHelper.postOnAnimation(this);
        }

        void startScroll(int i, int i2, boolean z) {
            int i3 = i < 0 ? Integer.MAX_VALUE : 0;
            this.mLastFlingX = i3;
            this.mScroller.setInterpolator(z ? AbsHListView.sLinearInterpolator : null);
            this.mScroller.startScroll(i3, 0, i, 0, i2);
            AbsHListView absHListView = AbsHListView.this;
            absHListView.mTouchMode = 4;
            absHListView.mViewHelper.postOnAnimation(this);
        }

        void startSpringback() {
            if (this.mScroller.springBack(AbsHListView.this.getScrollX(), 0, 0, 0, 0, 0)) {
                AbsHListView absHListView = AbsHListView.this;
                absHListView.mTouchMode = 6;
                absHListView.invalidate();
                AbsHListView.this.mViewHelper.postOnAnimation(this);
                return;
            }
            AbsHListView absHListView2 = AbsHListView.this;
            absHListView2.mTouchMode = -1;
            absHListView2.reportScrollStateChange(0);
        }
    }

    @TargetApi(14)
    /* loaded from: classes2.dex */
    class ListItemAccessibilityDelegate extends a {
        ListItemAccessibilityDelegate() {
        }

        @Override // androidx.core.e.a
        public void onInitializeAccessibilityNodeInfo(View view, c cVar) {
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            int positionForView = AbsHListView.this.getPositionForView(view);
            ListAdapter adapter = AbsHListView.this.getAdapter();
            if (positionForView == -1 || adapter == null || !AbsHListView.this.isEnabled() || !adapter.isEnabled(positionForView)) {
                return;
            }
            if (positionForView == AbsHListView.this.getSelectedItemPosition()) {
                cVar.k(true);
                cVar.a(8);
            } else {
                cVar.a(4);
            }
            if (AbsHListView.this.isClickable()) {
                cVar.a(16);
                cVar.c(true);
            }
            if (AbsHListView.this.isLongClickable()) {
                cVar.a(32);
                cVar.h(true);
            }
        }

        @Override // androidx.core.e.a
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            int positionForView = AbsHListView.this.getPositionForView(view);
            ListAdapter adapter = AbsHListView.this.getAdapter();
            if (positionForView != -1 && adapter != null && AbsHListView.this.isEnabled() && adapter.isEnabled(positionForView)) {
                long itemIdAtPosition = AbsHListView.this.getItemIdAtPosition(positionForView);
                if (i != 4) {
                    if (i == 8) {
                        if (AbsHListView.this.getSelectedItemPosition() != positionForView) {
                            return false;
                        }
                        AbsHListView.this.setSelection(-1);
                        return true;
                    }
                    if (i != 16) {
                        if (i == 32 && AbsHListView.this.isLongClickable()) {
                            return AbsHListView.this.performLongPress(view, positionForView, itemIdAtPosition);
                        }
                        return false;
                    }
                    if (AbsHListView.this.isClickable()) {
                        return AbsHListView.this.performItemClick(view, positionForView, itemIdAtPosition);
                    }
                    return false;
                }
                if (AbsHListView.this.getSelectedItemPosition() != positionForView) {
                    AbsHListView.this.setSelection(positionForView);
                    return true;
                }
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public interface OnScrollListener {
        public static final int SCROLL_STATE_FLING = 2;
        public static final int SCROLL_STATE_IDLE = 0;
        public static final int SCROLL_STATE_TOUCH_SCROLL = 1;

        void onScroll(AbsHListView absHListView, int i, int i2, int i3);

        void onScrollStateChanged(AbsHListView absHListView, int i);
    }

    /* loaded from: classes2.dex */
    private class PerformClick extends WindowRunnnable implements Runnable {
        int mClickMotionPosition;

        private PerformClick() {
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            AbsHListView absHListView = AbsHListView.this;
            if (absHListView.mDataChanged) {
                return;
            }
            ListAdapter listAdapter = absHListView.mAdapter;
            int i = this.mClickMotionPosition;
            if (listAdapter == null || absHListView.mItemCount <= 0 || i == -1 || i >= listAdapter.getCount() || !sameWindow()) {
                return;
            }
            AbsHListView absHListView2 = AbsHListView.this;
            View childAt = absHListView2.getChildAt(i - absHListView2.mFirstPosition);
            if (childAt != null) {
                AbsHListView.this.performItemClick(childAt, i, listAdapter.getItemId(i));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class PositionScroller implements Runnable {
        private static final int MOVE_DOWN_BOUND = 3;
        private static final int MOVE_DOWN_POS = 1;
        private static final int MOVE_OFFSET = 5;
        private static final int MOVE_UP_BOUND = 4;
        private static final int MOVE_UP_POS = 2;
        private static final int SCROLL_DURATION = 200;
        private int mBoundPos;
        private final int mExtraScroll;
        private int mLastSeenPos;
        private int mMode;
        private int mOffsetFromLeft;
        private int mScrollDuration;
        private int mTargetPos;

        PositionScroller() {
            this.mExtraScroll = ViewConfiguration.get(AbsHListView.this.getContext()).getScaledFadingEdgeLength();
        }

        @Override // java.lang.Runnable
        public void run() {
            int width = AbsHListView.this.getWidth();
            AbsHListView absHListView = AbsHListView.this;
            int i = absHListView.mFirstPosition;
            int i2 = this.mMode;
            if (i2 == 1) {
                int childCount = absHListView.getChildCount() - 1;
                int i3 = i + childCount;
                if (childCount < 0) {
                    return;
                }
                if (i3 == this.mLastSeenPos) {
                    AbsHListView.this.mViewHelper.postOnAnimation(this);
                    return;
                }
                View childAt = AbsHListView.this.getChildAt(childCount);
                int width2 = childAt.getWidth();
                int left = width - childAt.getLeft();
                AbsHListView absHListView2 = AbsHListView.this;
                int i4 = absHListView2.mItemCount - 1;
                int i5 = absHListView2.mListPadding.right;
                if (i3 < i4) {
                    i5 = Math.max(i5, this.mExtraScroll);
                }
                AbsHListView.this.smoothScrollBy((width2 - left) + i5, this.mScrollDuration, true);
                this.mLastSeenPos = i3;
                if (i3 < this.mTargetPos) {
                    AbsHListView.this.mViewHelper.postOnAnimation(this);
                    return;
                }
                return;
            }
            int i6 = 0;
            if (i2 == 2) {
                if (i == this.mLastSeenPos) {
                    absHListView.mViewHelper.postOnAnimation(this);
                    return;
                }
                View childAt2 = absHListView.getChildAt(0);
                if (childAt2 == null) {
                    return;
                }
                AbsHListView.this.smoothScrollBy(childAt2.getLeft() - (i > 0 ? Math.max(this.mExtraScroll, AbsHListView.this.mListPadding.left) : AbsHListView.this.mListPadding.left), this.mScrollDuration, true);
                this.mLastSeenPos = i;
                if (i > this.mTargetPos) {
                    AbsHListView.this.mViewHelper.postOnAnimation(this);
                    return;
                }
                return;
            }
            if (i2 == 3) {
                int childCount2 = absHListView.getChildCount();
                if (i == this.mBoundPos || childCount2 <= 1) {
                    return;
                }
                int i7 = childCount2 + i;
                AbsHListView absHListView3 = AbsHListView.this;
                if (i7 >= absHListView3.mItemCount) {
                    return;
                }
                int i8 = i + 1;
                if (i8 == this.mLastSeenPos) {
                    absHListView3.mViewHelper.postOnAnimation(this);
                    return;
                }
                View childAt3 = absHListView3.getChildAt(1);
                int width3 = childAt3.getWidth();
                int left2 = childAt3.getLeft();
                int max = Math.max(AbsHListView.this.mListPadding.right, this.mExtraScroll);
                if (i8 < this.mBoundPos) {
                    AbsHListView.this.smoothScrollBy(Math.max(0, (width3 + left2) - max), this.mScrollDuration, true);
                    this.mLastSeenPos = i8;
                    AbsHListView.this.mViewHelper.postOnAnimation(this);
                    return;
                } else {
                    if (left2 > max) {
                        AbsHListView.this.smoothScrollBy(left2 - max, this.mScrollDuration, true);
                        return;
                    }
                    return;
                }
            }
            if (i2 == 4) {
                int childCount3 = absHListView.getChildCount() - 2;
                if (childCount3 < 0) {
                    return;
                }
                int i9 = i + childCount3;
                if (i9 == this.mLastSeenPos) {
                    AbsHListView.this.mViewHelper.postOnAnimation(this);
                    return;
                }
                View childAt4 = AbsHListView.this.getChildAt(childCount3);
                int width4 = childAt4.getWidth();
                int left3 = childAt4.getLeft();
                int i10 = width - left3;
                int max2 = Math.max(AbsHListView.this.mListPadding.left, this.mExtraScroll);
                this.mLastSeenPos = i9;
                if (i9 > this.mBoundPos) {
                    AbsHListView.this.smoothScrollBy(-(i10 - max2), this.mScrollDuration, true);
                    AbsHListView.this.mViewHelper.postOnAnimation(this);
                    return;
                }
                int i11 = width - max2;
                int i12 = left3 + width4;
                if (i11 > i12) {
                    AbsHListView.this.smoothScrollBy(-(i11 - i12), this.mScrollDuration, true);
                    return;
                }
                return;
            }
            if (i2 != 5) {
                return;
            }
            if (this.mLastSeenPos == i) {
                absHListView.mViewHelper.postOnAnimation(this);
                return;
            }
            this.mLastSeenPos = i;
            int childCount4 = absHListView.getChildCount();
            int i13 = this.mTargetPos;
            int i14 = (i + childCount4) - 1;
            if (i13 < i) {
                i6 = (i - i13) + 1;
            } else if (i13 > i14) {
                i6 = i13 - i14;
            }
            float min = Math.min(Math.abs(i6 / childCount4), 1.0f);
            if (i13 < i) {
                AbsHListView.this.smoothScrollBy((int) ((-AbsHListView.this.getWidth()) * min), (int) (this.mScrollDuration * min), true);
                AbsHListView.this.mViewHelper.postOnAnimation(this);
            } else if (i13 > i14) {
                AbsHListView.this.smoothScrollBy((int) (AbsHListView.this.getWidth() * min), (int) (this.mScrollDuration * min), true);
                AbsHListView.this.mViewHelper.postOnAnimation(this);
            } else {
                AbsHListView.this.smoothScrollBy(AbsHListView.this.getChildAt(i13 - i).getLeft() - this.mOffsetFromLeft, (int) (this.mScrollDuration * (Math.abs(r0) / AbsHListView.this.getWidth())), true);
            }
        }

        void scrollToVisible(int i, int i2, int i3) {
            AbsHListView absHListView = AbsHListView.this;
            int i4 = absHListView.mFirstPosition;
            int childCount = (absHListView.getChildCount() + i4) - 1;
            AbsHListView absHListView2 = AbsHListView.this;
            int i5 = absHListView2.mListPadding.left;
            int width = absHListView2.getWidth() - AbsHListView.this.mListPadding.right;
            if (i < i4 || i > childCount) {
                LogEx.w(AbsHListView.TAG, "scrollToVisible called with targetPos " + i + " not visible [" + i4 + ", " + childCount + "]");
            }
            if (i2 < i4 || i2 > childCount) {
                i2 = -1;
            }
            View childAt = AbsHListView.this.getChildAt(i - i4);
            int left = childAt.getLeft();
            int right = childAt.getRight();
            int i6 = right > width ? right - width : 0;
            if (left < i5) {
                i6 = left - i5;
            }
            if (i6 == 0) {
                return;
            }
            if (i2 >= 0) {
                View childAt2 = AbsHListView.this.getChildAt(i2 - i4);
                int left2 = childAt2.getLeft();
                int right2 = childAt2.getRight();
                int abs = Math.abs(i6);
                if (i6 < 0 && right2 + abs > width) {
                    i6 = Math.max(0, right2 - width);
                } else if (i6 > 0 && left2 - abs < i5) {
                    i6 = Math.min(0, left2 - i5);
                }
            }
            AbsHListView.this.smoothScrollBy(i6, i3);
        }

        void start(final int i) {
            int i2;
            stop();
            AbsHListView absHListView = AbsHListView.this;
            if (absHListView.mDataChanged) {
                absHListView.mPositionScrollAfterLayout = new Runnable() { // from class: it.sephiroth.android.library.widget.AbsHListView.PositionScroller.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PositionScroller.this.start(i);
                    }
                };
                return;
            }
            int childCount = absHListView.getChildCount();
            if (childCount == 0) {
                return;
            }
            AbsHListView absHListView2 = AbsHListView.this;
            int i3 = absHListView2.mFirstPosition;
            int i4 = (childCount + i3) - 1;
            int max = Math.max(0, Math.min(absHListView2.getCount() - 1, i));
            if (max < i3) {
                i2 = (i3 - max) + 1;
                this.mMode = 2;
            } else if (max > i4) {
                i2 = (max - i4) + 1;
                this.mMode = 1;
            } else {
                scrollToVisible(max, -1, 200);
                return;
            }
            if (i2 > 0) {
                this.mScrollDuration = 200 / i2;
            } else {
                this.mScrollDuration = 200;
            }
            this.mTargetPos = max;
            this.mBoundPos = -1;
            this.mLastSeenPos = -1;
            AbsHListView.this.mViewHelper.postOnAnimation(this);
        }

        void startWithOffset(int i, int i2) {
            startWithOffset(i, i2, 200);
        }

        public void stop() {
            AbsHListView.this.removeCallbacks(this);
        }

        void startWithOffset(final int i, final int i2, final int i3) {
            int i4;
            stop();
            AbsHListView absHListView = AbsHListView.this;
            if (absHListView.mDataChanged) {
                absHListView.mPositionScrollAfterLayout = new Runnable() { // from class: it.sephiroth.android.library.widget.AbsHListView.PositionScroller.3
                    @Override // java.lang.Runnable
                    public void run() {
                        PositionScroller.this.startWithOffset(i, i2, i3);
                    }
                };
                return;
            }
            int childCount = absHListView.getChildCount();
            if (childCount == 0) {
                return;
            }
            int paddingLeft = i2 + AbsHListView.this.getPaddingLeft();
            int max = Math.max(0, Math.min(AbsHListView.this.getCount() - 1, i));
            this.mTargetPos = max;
            this.mOffsetFromLeft = paddingLeft;
            this.mBoundPos = -1;
            this.mLastSeenPos = -1;
            this.mMode = 5;
            AbsHListView absHListView2 = AbsHListView.this;
            int i5 = absHListView2.mFirstPosition;
            int i6 = (i5 + childCount) - 1;
            if (max < i5) {
                i4 = i5 - max;
            } else {
                if (max <= i6) {
                    AbsHListView.this.smoothScrollBy(absHListView2.getChildAt(max - i5).getLeft() - paddingLeft, i3, false);
                    return;
                }
                i4 = max - i6;
            }
            float f = i4 / childCount;
            if (f >= 1.0f) {
                i3 = (int) (i3 / f);
            }
            this.mScrollDuration = i3;
            this.mLastSeenPos = -1;
            AbsHListView.this.mViewHelper.postOnAnimation(this);
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0064  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void start(final int r7, final int r8) {
            /*
                r6 = this;
                r6.stop()
                r0 = -1
                if (r8 != r0) goto La
                r6.start(r7)
                return
            La:
                it.sephiroth.android.library.widget.AbsHListView r1 = it.sephiroth.android.library.widget.AbsHListView.this
                boolean r2 = r1.mDataChanged
                if (r2 == 0) goto L18
                it.sephiroth.android.library.widget.AbsHListView$PositionScroller$2 r0 = new it.sephiroth.android.library.widget.AbsHListView$PositionScroller$2
                r0.<init>()
                r1.mPositionScrollAfterLayout = r0
                return
            L18:
                int r1 = r1.getChildCount()
                if (r1 != 0) goto L1f
                return
            L1f:
                it.sephiroth.android.library.widget.AbsHListView r2 = it.sephiroth.android.library.widget.AbsHListView.this
                int r3 = r2.mFirstPosition
                int r1 = r1 + r3
                r4 = 1
                int r1 = r1 - r4
                r5 = 0
                int r2 = r2.getCount()
                int r2 = r2 - r4
                int r7 = java.lang.Math.min(r2, r7)
                int r7 = java.lang.Math.max(r5, r7)
                r2 = 200(0xc8, float:2.8E-43)
                if (r7 >= r3) goto L4a
                int r1 = r1 - r8
                if (r1 >= r4) goto L3c
                return
            L3c:
                int r3 = r3 - r7
                int r3 = r3 + r4
                int r1 = r1 - r4
                if (r1 >= r3) goto L46
                r3 = 4
                r6.mMode = r3
            L44:
                r3 = r1
                goto L5e
            L46:
                r1 = 2
                r6.mMode = r1
                goto L5e
            L4a:
                if (r7 <= r1) goto L74
                int r3 = r8 - r3
                if (r3 >= r4) goto L51
                return
            L51:
                int r1 = r7 - r1
                int r1 = r1 + r4
                int r3 = r3 - r4
                if (r3 >= r1) goto L5b
                r1 = 3
                r6.mMode = r1
                goto L5e
            L5b:
                r6.mMode = r4
                goto L44
            L5e:
                if (r3 <= 0) goto L64
                int r2 = r2 / r3
                r6.mScrollDuration = r2
                goto L66
            L64:
                r6.mScrollDuration = r2
            L66:
                r6.mTargetPos = r7
                r6.mBoundPos = r8
                r6.mLastSeenPos = r0
                it.sephiroth.android.library.widget.AbsHListView r7 = it.sephiroth.android.library.widget.AbsHListView.this
                it.sephiroth.android.library.util.ViewHelperFactory$ViewHelper r7 = r7.mViewHelper
                r7.postOnAnimation(r6)
                return
            L74:
                r6.scrollToVisible(r7, r8, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: it.sephiroth.android.library.widget.AbsHListView.PositionScroller.start(int, int):void");
        }
    }

    /* loaded from: classes2.dex */
    public class RecycleBin {
        private View[] mActiveViews = new View[0];
        private ArrayList<View> mCurrentScrap;
        private int mFirstActivePosition;
        private RecyclerListener mRecyclerListener;
        private ArrayList<View>[] mScrapViews;
        private ArrayList<View> mSkippedScrap;
        private h<View> mTransientStateViews;
        private int mViewTypeCount;

        public RecycleBin() {
        }

        @SuppressLint({"NewApi"})
        private void pruneScrapViews() {
            int length = this.mActiveViews.length;
            int i = this.mViewTypeCount;
            ArrayList<View>[] arrayListArr = this.mScrapViews;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                ArrayList<View> arrayList = arrayListArr[i3];
                int size = arrayList.size();
                int i4 = size - length;
                int i5 = size - 1;
                int i6 = 0;
                while (i6 < i4) {
                    AbsHListView.this.removeDetachedView(arrayList.remove(i5), false);
                    i6++;
                    i5--;
                }
            }
            if (this.mTransientStateViews != null) {
                while (i2 < this.mTransientStateViews.b()) {
                    if (!this.mTransientStateViews.e(i2).hasTransientState()) {
                        this.mTransientStateViews.d(i2);
                        i2--;
                    }
                    i2++;
                }
            }
        }

        @SuppressLint({"NewApi"})
        public void addScrapView(View view, int i) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.scrappedFromPosition = i;
            int i2 = layoutParams.viewType;
            boolean hasTransientState = Build.VERSION.SDK_INT >= 16 ? view.hasTransientState() : false;
            if (shouldRecycleViewType(i2) && !hasTransientState) {
                view.onStartTemporaryDetach();
                if (this.mViewTypeCount == 1) {
                    this.mCurrentScrap.add(view);
                } else {
                    this.mScrapViews[i2].add(view);
                }
                if (Build.VERSION.SDK_INT >= 14) {
                    view.setAccessibilityDelegate(null);
                }
                RecyclerListener recyclerListener = this.mRecyclerListener;
                if (recyclerListener != null) {
                    recyclerListener.onMovedToScrapHeap(view);
                    return;
                }
                return;
            }
            if (i2 != -2 || hasTransientState) {
                if (this.mSkippedScrap == null) {
                    this.mSkippedScrap = new ArrayList<>();
                }
                this.mSkippedScrap.add(view);
            }
            if (hasTransientState) {
                if (this.mTransientStateViews == null) {
                    this.mTransientStateViews = new h<>();
                }
                view.onStartTemporaryDetach();
                this.mTransientStateViews.c(i, view);
            }
        }

        public void clear() {
            int i = this.mViewTypeCount;
            if (i == 1) {
                ArrayList<View> arrayList = this.mCurrentScrap;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    AbsHListView.this.removeDetachedView(arrayList.remove((size - 1) - i2), false);
                }
            } else {
                for (int i3 = 0; i3 < i; i3++) {
                    ArrayList<View> arrayList2 = this.mScrapViews[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        AbsHListView.this.removeDetachedView(arrayList2.remove((size2 - 1) - i4), false);
                    }
                }
            }
            h<View> hVar = this.mTransientStateViews;
            if (hVar != null) {
                hVar.a();
            }
        }

        void clearTransientStateViews() {
            h<View> hVar = this.mTransientStateViews;
            if (hVar != null) {
                hVar.a();
            }
        }

        public void fillActiveViews(int i, int i2) {
            if (this.mActiveViews.length < i) {
                this.mActiveViews = new View[i];
            }
            this.mFirstActivePosition = i2;
            View[] viewArr = this.mActiveViews;
            for (int i3 = 0; i3 < i; i3++) {
                View childAt = AbsHListView.this.getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams != null && layoutParams.viewType != -2) {
                    viewArr[i3] = childAt;
                }
            }
        }

        public View getActiveView(int i) {
            int i2 = i - this.mFirstActivePosition;
            View[] viewArr = this.mActiveViews;
            if (i2 < 0 || i2 >= viewArr.length) {
                return null;
            }
            View view = viewArr[i2];
            viewArr[i2] = null;
            return view;
        }

        View getScrapView(int i) {
            if (this.mViewTypeCount == 1) {
                return AbsHListView.retrieveFromScrap(this.mCurrentScrap, i);
            }
            int itemViewType = AbsHListView.this.mAdapter.getItemViewType(i);
            if (itemViewType < 0) {
                return null;
            }
            ArrayList<View>[] arrayListArr = this.mScrapViews;
            if (itemViewType < arrayListArr.length) {
                return AbsHListView.retrieveFromScrap(arrayListArr[itemViewType], i);
            }
            return null;
        }

        View getTransientStateView(int i) {
            int b2;
            h<View> hVar = this.mTransientStateViews;
            if (hVar == null || (b2 = hVar.b(i)) < 0) {
                return null;
            }
            View e = this.mTransientStateViews.e(b2);
            this.mTransientStateViews.d(b2);
            return e;
        }

        public void markChildrenDirty() {
            int i = this.mViewTypeCount;
            if (i == 1) {
                ArrayList<View> arrayList = this.mCurrentScrap;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).forceLayout();
                }
            } else {
                for (int i3 = 0; i3 < i; i3++) {
                    ArrayList<View> arrayList2 = this.mScrapViews[i3];
                    int size2 = arrayList2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        arrayList2.get(i4).forceLayout();
                    }
                }
            }
            h<View> hVar = this.mTransientStateViews;
            if (hVar != null) {
                int b2 = hVar.b();
                for (int i5 = 0; i5 < b2; i5++) {
                    this.mTransientStateViews.e(i5).forceLayout();
                }
            }
        }

        void reclaimScrapViews(List<View> list) {
            int i = this.mViewTypeCount;
            if (i == 1) {
                list.addAll(this.mCurrentScrap);
                return;
            }
            ArrayList<View>[] arrayListArr = this.mScrapViews;
            for (int i2 = 0; i2 < i; i2++) {
                list.addAll(arrayListArr[i2]);
            }
        }

        public void removeSkippedScrap() {
            ArrayList<View> arrayList = this.mSkippedScrap;
            if (arrayList == null) {
                return;
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                AbsHListView.this.removeDetachedView(this.mSkippedScrap.get(i), false);
            }
            this.mSkippedScrap.clear();
        }

        @SuppressLint({"NewApi"})
        public void scrapActiveViews() {
            LayoutParams layoutParams;
            View[] viewArr = this.mActiveViews;
            boolean z = this.mRecyclerListener != null;
            boolean z2 = this.mViewTypeCount > 1;
            ArrayList<View> arrayList = this.mCurrentScrap;
            for (int length = viewArr.length - 1; length >= 0; length--) {
                View view = viewArr[length];
                if (view != null && (layoutParams = (LayoutParams) view.getLayoutParams()) != null) {
                    int i = layoutParams.viewType;
                    viewArr[length] = null;
                    boolean hasTransientState = Build.VERSION.SDK_INT >= 16 ? view.hasTransientState() : false;
                    if (!shouldRecycleViewType(i) || hasTransientState) {
                        if (i != -2 || hasTransientState) {
                            AbsHListView.this.removeDetachedView(view, false);
                        }
                        if (hasTransientState) {
                            if (this.mTransientStateViews == null) {
                                this.mTransientStateViews = new h<>();
                            }
                            this.mTransientStateViews.c(this.mFirstActivePosition + length, view);
                        }
                    } else {
                        if (z2) {
                            arrayList = this.mScrapViews[i];
                        }
                        view.onStartTemporaryDetach();
                        layoutParams.scrappedFromPosition = this.mFirstActivePosition + length;
                        arrayList.add(view);
                        if (Build.VERSION.SDK_INT >= 14) {
                            view.setAccessibilityDelegate(null);
                        }
                        if (z) {
                            this.mRecyclerListener.onMovedToScrapHeap(view);
                        }
                    }
                }
            }
            pruneScrapViews();
        }

        void setCacheColorHint(int i) {
            int i2 = this.mViewTypeCount;
            if (i2 == 1) {
                ArrayList<View> arrayList = this.mCurrentScrap;
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    arrayList.get(i3).setDrawingCacheBackgroundColor(i);
                }
            } else {
                for (int i4 = 0; i4 < i2; i4++) {
                    ArrayList<View> arrayList2 = this.mScrapViews[i4];
                    int size2 = arrayList2.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        arrayList2.get(i5).setDrawingCacheBackgroundColor(i);
                    }
                }
            }
            for (View view : this.mActiveViews) {
                if (view != null) {
                    view.setDrawingCacheBackgroundColor(i);
                }
            }
        }

        public void setViewTypeCount(int i) {
            if (i >= 1) {
                ArrayList<View>[] arrayListArr = new ArrayList[i];
                for (int i2 = 0; i2 < i; i2++) {
                    arrayListArr[i2] = new ArrayList<>();
                }
                this.mViewTypeCount = i;
                this.mCurrentScrap = arrayListArr[0];
                this.mScrapViews = arrayListArr;
                return;
            }
            throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
        }

        public boolean shouldRecycleViewType(int i) {
            return i >= 0;
        }
    }

    /* loaded from: classes2.dex */
    public interface RecyclerListener {
        void onMovedToScrapHeap(View view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> PARCELABLECREATOR = new Parcelable.Creator<SavedState>() { // from class: it.sephiroth.android.library.widget.AbsHListView.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        LongSparseArray<Integer> checkIdState;
        h<Boolean> checkState;
        int checkedItemCount;
        String filter;
        long firstId;
        boolean inActionMode;
        int position;
        long selectedId;
        int viewLeft;
        int width;

        private h<Boolean> readSparseBooleanArray(Parcel parcel) {
            int readInt = parcel.readInt();
            if (readInt < 0) {
                return null;
            }
            h<Boolean> hVar = new h<>(readInt);
            readSparseBooleanArrayInternal(hVar, parcel, readInt);
            return hVar;
        }

        private void readSparseBooleanArrayInternal(h<Boolean> hVar, Parcel parcel, int i) {
            while (i > 0) {
                int readInt = parcel.readInt();
                boolean z = true;
                if (parcel.readByte() != 1) {
                    z = false;
                }
                hVar.a(readInt, Boolean.valueOf(z));
                i--;
            }
        }

        private LongSparseArray<Integer> readSparseLongArray(Parcel parcel) {
            int readInt = parcel.readInt();
            if (readInt <= 0) {
                return null;
            }
            LongSparseArray<Integer> longSparseArray = new LongSparseArray<>(readInt);
            readSparseLongArrayInternal(longSparseArray, parcel, readInt);
            return longSparseArray;
        }

        private void readSparseLongArrayInternal(LongSparseArray<Integer> longSparseArray, Parcel parcel, int i) {
            while (i > 0) {
                longSparseArray.put(parcel.readLong(), Integer.valueOf(parcel.readInt()));
                i--;
            }
        }

        private void writeSparseBooleanArray(h<Boolean> hVar, Parcel parcel) {
            if (hVar == null) {
                parcel.writeInt(-1);
                return;
            }
            int b2 = hVar.b();
            parcel.writeInt(b2);
            for (int i = 0; i < b2; i++) {
                parcel.writeInt(hVar.c(i));
                parcel.writeByte(hVar.e(i).booleanValue() ? (byte) 1 : (byte) 0);
            }
        }

        private void writeSparseLongArray(LongSparseArray<Integer> longSparseArray, Parcel parcel) {
            int size = longSparseArray != null ? longSparseArray.size() : 0;
            parcel.writeInt(size);
            for (int i = 0; i < size; i++) {
                parcel.writeLong(longSparseArray.keyAt(i));
                parcel.writeInt(longSparseArray.valueAt(i).intValue());
            }
        }

        public String toString() {
            return "AbsListView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.selectedId + " firstId=" + this.firstId + " viewLeft=" + this.viewLeft + " position=" + this.position + " width=" + this.width + " filter=" + this.filter + " checkState=" + this.checkState + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeLong(this.selectedId);
            parcel.writeLong(this.firstId);
            parcel.writeInt(this.viewLeft);
            parcel.writeInt(this.position);
            parcel.writeInt(this.width);
            parcel.writeString(this.filter);
            parcel.writeByte(this.inActionMode ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.checkedItemCount);
            writeSparseBooleanArray(this.checkState, parcel);
            writeSparseLongArray(this.checkIdState, parcel);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.selectedId = parcel.readLong();
            this.firstId = parcel.readLong();
            this.viewLeft = parcel.readInt();
            this.position = parcel.readInt();
            this.width = parcel.readInt();
            this.filter = parcel.readString();
            this.inActionMode = parcel.readByte() != 0;
            this.checkedItemCount = parcel.readInt();
            this.checkState = readSparseBooleanArray(parcel);
            this.checkIdState = readSparseLongArray(parcel);
        }
    }

    /* loaded from: classes2.dex */
    public interface SelectionBoundsAdjuster {
        void adjustListItemSelectionBounds(Rect rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class WindowRunnnable {
        private int mOriginalAttachCount;

        private WindowRunnnable() {
        }

        public void rememberWindowAttachCount() {
            this.mOriginalAttachCount = AbsHListView.this.getWindowAttachCount();
        }

        public boolean sameWindow() {
            return AbsHListView.this.hasWindowFocus() && AbsHListView.this.getWindowAttachCount() == this.mOriginalAttachCount;
        }
    }

    public AbsHListView(Context context) {
        super(context);
        this.mChoiceMode = 0;
        this.mLayoutMode = 0;
        this.mDrawSelectorOnTop = false;
        this.mSelectorPosition = -1;
        this.mSelectorRect = new Rect();
        this.mRecycler = new RecycleBin();
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mListPadding = new Rect();
        this.mHeightMeasureSpec = 0;
        this.mTouchMode = -1;
        this.mSelectedLeft = 0;
        this.mSmoothScrollbarEnabled = true;
        this.mResurrectToPosition = -1;
        this.mContextMenuInfo = null;
        this.mLastTouchMode = -1;
        this.mLastScrollState = 0;
        this.mVelocityScale = 1.0f;
        this.mIsScrap = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        initAbsListView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearScrollingCache() {
        if (this.mViewHelper.isHardwareAccelerated()) {
            return;
        }
        if (this.mClearScrollingCache == null) {
            this.mClearScrollingCache = new Runnable() { // from class: it.sephiroth.android.library.widget.AbsHListView.2
                @Override // java.lang.Runnable
                public void run() {
                    AbsHListView absHListView = AbsHListView.this;
                    if (absHListView.mCachingStarted) {
                        absHListView.mCachingActive = false;
                        absHListView.mCachingStarted = false;
                        absHListView.setChildrenDrawnWithCacheEnabled(false);
                        if ((AbsHListView.this.getPersistentDrawingCache() & 2) == 0) {
                            AbsHListView.this.setChildrenDrawingCacheEnabled(false);
                        }
                        if (AbsHListView.this.isAlwaysDrawnWithCacheEnabled()) {
                            return;
                        }
                        AbsHListView.this.invalidate();
                    }
                }
            };
        }
        post(this.mClearScrollingCache);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean contentFits() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        return childCount == this.mItemCount && getChildAt(0).getLeft() >= this.mListPadding.left && getChildAt(childCount - 1).getRight() <= getWidth() - this.mListPadding.right;
    }

    private void createScrollingCache() {
        if (!this.mScrollingCacheEnabled || this.mCachingStarted || this.mViewHelper.isHardwareAccelerated()) {
            return;
        }
        setChildrenDrawnWithCacheEnabled(true);
        setChildrenDrawingCacheEnabled(true);
        this.mCachingActive = true;
        this.mCachingStarted = true;
    }

    private void drawSelector(Canvas canvas) {
        if (this.mSelectorRect.isEmpty()) {
            return;
        }
        Drawable drawable = this.mSelector;
        drawable.setBounds(this.mSelectorRect);
        drawable.draw(canvas);
    }

    private void finishGlows() {
        EdgeEffect edgeEffect = this.mEdgeGlowTop;
        if (edgeEffect != null) {
            edgeEffect.finish();
            this.mEdgeGlowBottom.finish();
        }
    }

    public static int getDistance(Rect rect, Rect rect2, int i) {
        int width;
        int height;
        int width2;
        int i2;
        int height2;
        int i3;
        if (i == 1 || i == 2) {
            width = rect.right + (rect.width() / 2);
            height = (rect.height() / 2) + rect.top;
            width2 = rect2.left + (rect2.width() / 2);
            i2 = rect2.top;
            height2 = rect2.height() / 2;
        } else {
            if (i != 17) {
                if (i == 33) {
                    width = rect.left + (rect.width() / 2);
                    height = rect.top;
                    width2 = rect2.left + (rect2.width() / 2);
                    i3 = rect2.bottom;
                } else if (i == 66) {
                    width = rect.right;
                    height = (rect.height() / 2) + rect.top;
                    width2 = rect2.left;
                    i2 = rect2.top;
                    height2 = rect2.height() / 2;
                } else if (i == 130) {
                    width = rect.left + (rect.width() / 2);
                    height = rect.bottom;
                    width2 = rect2.left + (rect2.width() / 2);
                    i3 = rect2.top;
                } else {
                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, FOCUS_FORWARD, FOCUS_BACKWARD}.");
                }
                int i4 = width2 - width;
                int i5 = i3 - height;
                return (i5 * i5) + (i4 * i4);
            }
            width = rect.left;
            height = (rect.height() / 2) + rect.top;
            width2 = rect2.right;
            i2 = rect2.top;
            height2 = rect2.height() / 2;
        }
        i3 = height2 + i2;
        int i42 = width2 - width;
        int i52 = i3 - height;
        return (i52 * i52) + (i42 * i42);
    }

    private void initAbsListView() {
        setClickable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        setAlwaysDrawnWithCacheEnabled(false);
        setScrollingCacheEnabled(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mOverscrollDistance = viewConfiguration.getScaledOverscrollDistance();
        this.mOverflingDistance = viewConfiguration.getScaledOverflingDistance();
        this.mViewHelper = ViewHelperFactory.create(this);
    }

    private void initOrResetVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (motionEvent.getPointerId(action) == this.mActivePointerId) {
            int i = action == 0 ? 1 : 0;
            this.mMotionX = (int) motionEvent.getX(i);
            this.mMotionY = (int) motionEvent.getY(i);
            this.mMotionCorrection = 0;
            this.mActivePointerId = motionEvent.getPointerId(i);
        }
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    static View retrieveFromScrap(ArrayList<View> arrayList, int i) {
        int size = arrayList.size();
        if (size <= 0) {
            return null;
        }
        for (int i2 = 0; i2 < size; i2++) {
            View view = arrayList.get(i2);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams != null && layoutParams.scrappedFromPosition == i) {
                arrayList.remove(i2);
                return view;
            }
        }
        return arrayList.remove(size - 1);
    }

    private void scrollIfNeeded(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int childCount;
        VelocityTracker velocityTracker;
        ViewParent parent;
        int i7 = i - this.mMotionX;
        int i8 = i7 - this.mMotionCorrection;
        int i9 = this.mLastX;
        int i10 = i9 != Integer.MIN_VALUE ? i - i9 : i8;
        int i11 = this.mTouchMode;
        if (i11 == 3) {
            if (i != this.mLastX) {
                if (Math.abs(i7) > this.mTouchSlop && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                int i12 = this.mMotionPosition;
                if (i12 >= 0) {
                    childCount = i12 - this.mFirstPosition;
                } else {
                    childCount = getChildCount() / 2;
                }
                View childAt = getChildAt(childCount);
                int left = childAt != null ? childAt.getLeft() : 0;
                boolean trackMotionScroll = i10 != 0 ? trackMotionScroll(i8, i10) : false;
                View childAt2 = getChildAt(childCount);
                if (childAt2 != null) {
                    int left2 = childAt2.getLeft();
                    if (trackMotionScroll) {
                        int i13 = (-i10) - (left2 - left);
                        overScrollBy(i13, 0, getScrollX(), 0, 0, 0, this.mOverscrollDistance, 0, true);
                        if (Math.abs(this.mOverscrollDistance) == Math.abs(getScrollX()) && (velocityTracker = this.mVelocityTracker) != null) {
                            velocityTracker.clear();
                        }
                        int overScrollMode = getOverScrollMode();
                        if (overScrollMode == 0 || (overScrollMode == 1 && !contentFits())) {
                            this.mDirection = 0;
                            this.mTouchMode = 5;
                            if (i7 > 0) {
                                this.mEdgeGlowTop.onPull(i13 / getWidth());
                                if (!this.mEdgeGlowBottom.isFinished()) {
                                    this.mEdgeGlowBottom.onRelease();
                                }
                                invalidate(this.mEdgeGlowTop.getBounds(false));
                            } else if (i7 < 0) {
                                this.mEdgeGlowBottom.onPull(i13 / getWidth());
                                if (!this.mEdgeGlowTop.isFinished()) {
                                    this.mEdgeGlowTop.onRelease();
                                }
                                invalidate(this.mEdgeGlowBottom.getBounds(true));
                            }
                        }
                    }
                    this.mMotionX = i;
                }
                this.mLastX = i;
                return;
            }
            return;
        }
        if (i11 != 5 || i == this.mLastX) {
            return;
        }
        int scrollX = getScrollX();
        int i14 = scrollX - i10;
        int i15 = i > this.mLastX ? 1 : -1;
        if (this.mDirection == 0) {
            this.mDirection = i15;
        }
        int i16 = -i10;
        if ((i14 >= 0 || scrollX < 0) && (i14 <= 0 || scrollX > 0)) {
            i2 = i16;
            i3 = 0;
        } else {
            int i17 = -scrollX;
            i3 = i10 + i17;
            i2 = i17;
        }
        if (i2 != 0) {
            i4 = i3;
            int i18 = i2;
            i5 = i15;
            overScrollBy(i2, 0, getScrollX(), 0, 0, 0, this.mOverscrollDistance, 0, true);
            int overScrollMode2 = getOverScrollMode();
            if (overScrollMode2 == 0 || (overScrollMode2 == 1 && !contentFits())) {
                if (i7 > 0) {
                    this.mEdgeGlowTop.onPull(i18 / getWidth());
                    if (!this.mEdgeGlowBottom.isFinished()) {
                        this.mEdgeGlowBottom.onRelease();
                    }
                    invalidate(this.mEdgeGlowTop.getBounds(false));
                } else if (i7 < 0) {
                    this.mEdgeGlowBottom.onPull(i18 / getWidth());
                    if (!this.mEdgeGlowTop.isFinished()) {
                        this.mEdgeGlowTop.onRelease();
                    }
                    invalidate(this.mEdgeGlowBottom.getBounds(true));
                }
            }
        } else {
            i4 = i3;
            i5 = i15;
        }
        if (i4 != 0) {
            if (getScrollX() != 0) {
                i6 = 0;
                this.mViewHelper.setScrollX(0);
                invalidateParentIfNeeded();
            } else {
                i6 = 0;
            }
            trackMotionScroll(i4, i4);
            this.mTouchMode = 3;
            int findClosestMotionCol = findClosestMotionCol(i);
            this.mMotionCorrection = i6;
            View childAt3 = getChildAt(findClosestMotionCol - this.mFirstPosition);
            this.mMotionViewOriginalLeft = childAt3 != null ? childAt3.getLeft() : 0;
            this.mMotionX = i;
            this.mMotionPosition = findClosestMotionCol;
        }
        this.mLastX = i;
        this.mDirection = i5;
    }

    private boolean startScrollIfNeeded(int i) {
        int i2 = i - this.mMotionX;
        int abs = Math.abs(i2);
        boolean z = getScrollX() != 0;
        if (!z && abs <= this.mTouchSlop) {
            return false;
        }
        createScrollingCache();
        if (z) {
            this.mTouchMode = 5;
            this.mMotionCorrection = 0;
        } else {
            this.mTouchMode = 3;
            this.mMotionCorrection = i2 > 0 ? this.mTouchSlop : -this.mTouchSlop;
        }
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.mPendingCheckForLongPress);
        }
        setPressed(false);
        View childAt = getChildAt(this.mMotionPosition - this.mFirstPosition);
        if (childAt != null) {
            childAt.setPressed(false);
        }
        reportScrollStateChange(1);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        scrollIfNeeded(i);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateOnScreenCheckedViews() {
        int i = this.mFirstPosition;
        int childCount = getChildCount();
        boolean z = Build.VERSION.SDK_INT >= 11;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            int i3 = i + i2;
            if (childAt instanceof Checkable) {
                ((Checkable) childAt).setChecked(this.mCheckStates.b(i3, false).booleanValue());
            } else if (z) {
                childAt.setActivated(this.mCheckStates.b(i3, false).booleanValue());
            }
        }
    }

    private void useDefaultSelector() {
        setSelector(getResources().getDrawable(R.drawable.list_selector_background));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        int childCount = getChildCount();
        int i = this.mFirstPosition;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null) {
            return;
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (listAdapter.isEnabled(i + i2)) {
                arrayList.add(childAt);
            }
            childAt.addTouchables(arrayList);
        }
    }

    @Override // android.view.View
    public boolean checkInputConnectionProxy(View view) {
        return false;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void clearChoices() {
        h<Boolean> hVar = this.mCheckStates;
        if (hVar != null) {
            hVar.a();
        }
        LongSparseArray<Integer> longSparseArray = this.mCheckedIdStates;
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
        this.mCheckedItemCount = 0;
    }

    @Override // android.view.View
    protected int computeHorizontalScrollExtent() {
        int childCount = getChildCount();
        if (childCount <= 0) {
            return 0;
        }
        if (!this.mSmoothScrollbarEnabled) {
            return 1;
        }
        int i = childCount * 100;
        View childAt = getChildAt(0);
        int left = childAt.getLeft();
        int width = childAt.getWidth();
        if (width > 0) {
            i += (left * 100) / width;
        }
        View childAt2 = getChildAt(childCount - 1);
        int right = childAt2.getRight();
        int width2 = childAt2.getWidth();
        return width2 > 0 ? i - (((right - getWidth()) * 100) / width2) : i;
    }

    @Override // android.view.View
    protected int computeHorizontalScrollOffset() {
        int i = this.mFirstPosition;
        int childCount = getChildCount();
        int i2 = 0;
        if (i >= 0 && childCount > 0) {
            if (this.mSmoothScrollbarEnabled) {
                View childAt = getChildAt(0);
                int left = childAt.getLeft();
                int width = childAt.getWidth();
                if (width > 0) {
                    return Math.max(((i * 100) - ((left * 100) / width)) + ((int) ((getScrollX() / getWidth()) * this.mItemCount * 100.0f)), 0);
                }
            } else {
                int i3 = this.mItemCount;
                if (i != 0) {
                    i2 = i + childCount == i3 ? i3 : (childCount / 2) + i;
                }
                return (int) (i + (childCount * (i2 / i3)));
            }
        }
        return 0;
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        if (this.mSmoothScrollbarEnabled) {
            int max = Math.max(this.mItemCount * 100, 0);
            return getScrollX() != 0 ? max + Math.abs((int) ((getScrollX() / getWidth()) * this.mItemCount * 100.0f)) : max;
        }
        return this.mItemCount;
    }

    void confirmCheckedPositionsById() {
        Object obj;
        boolean z;
        Object obj2;
        Object obj3;
        this.mCheckStates.a();
        int i = 0;
        boolean z2 = false;
        while (i < this.mCheckedIdStates.size()) {
            long keyAt = this.mCheckedIdStates.keyAt(i);
            int intValue = this.mCheckedIdStates.valueAt(i).intValue();
            if (keyAt != this.mAdapter.getItemId(intValue)) {
                int max = Math.max(0, intValue - 20);
                int min = Math.min(intValue + 20, this.mItemCount);
                while (true) {
                    if (max >= min) {
                        z = false;
                        break;
                    } else {
                        if (keyAt == this.mAdapter.getItemId(max)) {
                            this.mCheckStates.c(max, true);
                            this.mCheckedIdStates.setValueAt(i, Integer.valueOf(max));
                            z = true;
                            break;
                        }
                        max++;
                    }
                }
                if (!z) {
                    this.mCheckedIdStates.delete(keyAt);
                    i--;
                    this.mCheckedItemCount--;
                    if (Build.VERSION.SDK_INT > 11 && (obj2 = this.mChoiceActionMode) != null && (obj3 = this.mMultiChoiceModeCallback) != null) {
                        ((MultiChoiceModeWrapper) obj3).onItemCheckedStateChanged((ActionMode) obj2, intValue, keyAt, false);
                    }
                    z2 = true;
                }
            } else {
                this.mCheckStates.c(intValue, true);
            }
            i++;
        }
        if (!z2 || (obj = this.mChoiceActionMode) == null || Build.VERSION.SDK_INT <= 11) {
            return;
        }
        ((ActionMode) obj).invalidate();
    }

    ContextMenu.ContextMenuInfo createContextMenuInfo(View view, int i, long j) {
        return new AdapterView.AdapterContextMenuInfo(view, i, j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        boolean z = this.mDrawSelectorOnTop;
        if (!z) {
            drawSelector(canvas);
        }
        super.dispatchDraw(canvas);
        if (z) {
            drawSelector(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.mEdgeGlowTop != null) {
            int scrollX = getScrollX();
            if (!this.mEdgeGlowTop.isFinished()) {
                int save = canvas.save();
                Rect rect = this.mListPadding;
                int i = rect.top + this.mGlowPaddingTop;
                int height = (getHeight() - i) - (rect.bottom + this.mGlowPaddingBottom);
                int min = Math.min(0, this.mFirstPositionDistanceGuess + scrollX);
                canvas.rotate(-90.0f);
                canvas.translate((-getHeight()) + i, min);
                this.mEdgeGlowTop.setSize(height, height);
                if (this.mEdgeGlowTop.draw(canvas)) {
                    this.mEdgeGlowTop.setPosition(min, i);
                    invalidate();
                }
                canvas.restoreToCount(save);
            }
            if (this.mEdgeGlowBottom.isFinished()) {
                return;
            }
            int save2 = canvas.save();
            Rect rect2 = this.mListPadding;
            int height2 = (getHeight() - (rect2.left + this.mGlowPaddingTop)) - (rect2.right + this.mGlowPaddingBottom);
            int max = Math.max(getWidth(), scrollX + this.mLastPositionDistanceGuess);
            canvas.rotate(90.0f);
            canvas.translate(-r3, -max);
            this.mEdgeGlowBottom.setSize(height2, height2);
            if (this.mEdgeGlowBottom.draw(canvas)) {
                invalidate();
            }
            canvas.restoreToCount(save2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        updateSelectorState();
    }

    protected abstract void fillGap(boolean z);

    protected int findClosestMotionCol(int i) {
        if (getChildCount() == 0) {
            return -1;
        }
        int findMotionCol = findMotionCol(i);
        return findMotionCol != -1 ? findMotionCol : (this.mFirstPosition + r0) - 1;
    }

    protected abstract int findMotionCol(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -1, 0);
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public int getCacheColorHint() {
        return this.mCacheColorHint;
    }

    public int getCheckedItemCount() {
        return this.mCheckedItemCount;
    }

    public long[] getCheckedItemIds() {
        LongSparseArray<Integer> longSparseArray;
        if (this.mChoiceMode == 0 || (longSparseArray = this.mCheckedIdStates) == null || this.mAdapter == null) {
            return new long[0];
        }
        int size = longSparseArray.size();
        long[] jArr = new long[size];
        for (int i = 0; i < size; i++) {
            jArr[i] = longSparseArray.keyAt(i);
        }
        return jArr;
    }

    public int getCheckedItemPosition() {
        h<Boolean> hVar;
        if (this.mChoiceMode == 1 && (hVar = this.mCheckStates) != null && hVar.b() == 1) {
            return this.mCheckStates.c(0);
        }
        return -1;
    }

    public h<Boolean> getCheckedItemPositions() {
        if (this.mChoiceMode != 0) {
            return this.mCheckStates;
        }
        return null;
    }

    public int getChoiceMode() {
        return this.mChoiceMode;
    }

    @Override // android.view.View
    protected ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return this.mContextMenuInfo;
    }

    @Override // android.view.View
    public void getFocusedRect(Rect rect) {
        View selectedView = getSelectedView();
        if (selectedView != null && selectedView.getParent() == this) {
            selectedView.getFocusedRect(rect);
            offsetDescendantRectToMyCoords(selectedView, rect);
        } else {
            super.getFocusedRect(rect);
        }
    }

    protected int getFooterViewsCount() {
        return 0;
    }

    protected int getHeaderViewsCount() {
        return 0;
    }

    protected float getHorizontalScrollFactor() {
        if (this.mHorizontalScrollFactor == 0.0f) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(com.zte.iptvclient.android.zala.R.attr.hlv_listPreferredItemWidth, typedValue, true)) {
                this.mHorizontalScrollFactor = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define hlv_listPreferredItemWidth.");
            }
        }
        return this.mHorizontalScrollFactor;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public int getHorizontalScrollbarHeight() {
        return super.getHorizontalScrollbarHeight();
    }

    @Override // android.view.View
    protected float getLeftFadingEdgeStrength() {
        int childCount = getChildCount();
        float leftFadingEdgeStrength = super.getLeftFadingEdgeStrength();
        if (childCount == 0) {
            return leftFadingEdgeStrength;
        }
        if (this.mFirstPosition > 0) {
            return 1.0f;
        }
        return getChildAt(0).getLeft() < getPaddingLeft() ? (-(r0 - getPaddingLeft())) / getHorizontalFadingEdgeLength() : leftFadingEdgeStrength;
    }

    public int getListPaddingBottom() {
        return this.mListPadding.bottom;
    }

    public int getListPaddingLeft() {
        return this.mListPadding.left;
    }

    public int getListPaddingRight() {
        return this.mListPadding.right;
    }

    public int getListPaddingTop() {
        return this.mListPadding.top;
    }

    @Override // android.view.View
    protected float getRightFadingEdgeStrength() {
        int childCount = getChildCount();
        float rightFadingEdgeStrength = super.getRightFadingEdgeStrength();
        if (childCount == 0) {
            return rightFadingEdgeStrength;
        }
        if ((this.mFirstPosition + childCount) - 1 < this.mItemCount - 1) {
            return 1.0f;
        }
        return getChildAt(childCount - 1).getRight() > getWidth() - getPaddingRight() ? ((r0 - r2) + getPaddingRight()) / getHorizontalFadingEdgeLength() : rightFadingEdgeStrength;
    }

    @Override // it.sephiroth.android.library.widget.AdapterView
    @ViewDebug.ExportedProperty
    public View getSelectedView() {
        int i;
        if (this.mItemCount <= 0 || (i = this.mSelectedPosition) < 0) {
            return null;
        }
        return getChildAt(i - this.mFirstPosition);
    }

    public Drawable getSelector() {
        return this.mSelector;
    }

    @Override // android.view.View
    public int getSolidColor() {
        return this.mCacheColorHint;
    }

    public int getTranscriptMode() {
        return this.mTranscriptMode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // it.sephiroth.android.library.widget.AdapterView
    public void handleDataChanged() {
        ListAdapter listAdapter;
        int i = this.mItemCount;
        int i2 = this.mLastHandledItemCount;
        this.mLastHandledItemCount = i;
        if (this.mChoiceMode != 0 && (listAdapter = this.mAdapter) != null && listAdapter.hasStableIds()) {
            confirmCheckedPositionsById();
        }
        this.mRecycler.clearTransientStateViews();
        if (i > 0) {
            if (this.mNeedSync) {
                this.mNeedSync = false;
                this.mPendingSync = null;
                int i3 = this.mTranscriptMode;
                if (i3 == 2) {
                    this.mLayoutMode = 3;
                    return;
                }
                if (i3 == 1) {
                    if (this.mForceTranscriptScroll) {
                        this.mForceTranscriptScroll = false;
                        this.mLayoutMode = 3;
                        return;
                    }
                    int childCount = getChildCount();
                    int width = getWidth() - getPaddingRight();
                    View childAt = getChildAt(childCount - 1);
                    int bottom = childAt != null ? childAt.getBottom() : width;
                    if (this.mFirstPosition + childCount >= i2 && bottom <= width) {
                        this.mLayoutMode = 3;
                        return;
                    }
                    awakenScrollBars();
                }
                int i4 = this.mSyncMode;
                if (i4 != 0) {
                    if (i4 == 1) {
                        this.mLayoutMode = 5;
                        this.mSyncPosition = Math.min(Math.max(0, this.mSyncPosition), i - 1);
                        return;
                    }
                } else {
                    if (isInTouchMode()) {
                        this.mLayoutMode = 5;
                        this.mSyncPosition = Math.min(Math.max(0, this.mSyncPosition), i - 1);
                        return;
                    }
                    int findSyncPosition = findSyncPosition();
                    if (findSyncPosition >= 0 && lookForSelectablePosition(findSyncPosition, true) == findSyncPosition) {
                        this.mSyncPosition = findSyncPosition;
                        if (this.mSyncWidth == getWidth()) {
                            this.mLayoutMode = 5;
                        } else {
                            this.mLayoutMode = 2;
                        }
                        setNextSelectedPositionInt(findSyncPosition);
                        return;
                    }
                }
            }
            if (!isInTouchMode()) {
                int selectedItemPosition = getSelectedItemPosition();
                if (selectedItemPosition >= i) {
                    selectedItemPosition = i - 1;
                }
                if (selectedItemPosition < 0) {
                    selectedItemPosition = 0;
                }
                int lookForSelectablePosition = lookForSelectablePosition(selectedItemPosition, true);
                if (lookForSelectablePosition >= 0) {
                    setNextSelectedPositionInt(lookForSelectablePosition);
                    return;
                }
                int lookForSelectablePosition2 = lookForSelectablePosition(selectedItemPosition, false);
                if (lookForSelectablePosition2 >= 0) {
                    setNextSelectedPositionInt(lookForSelectablePosition2);
                    return;
                }
            } else if (this.mResurrectToPosition >= 0) {
                return;
            }
        }
        this.mLayoutMode = this.mStackFromRight ? 3 : 1;
        this.mSelectedPosition = -1;
        this.mSelectedColId = Long.MIN_VALUE;
        this.mNextSelectedPosition = -1;
        this.mNextSelectedColId = Long.MIN_VALUE;
        this.mNeedSync = false;
        this.mPendingSync = null;
        this.mSelectorPosition = -1;
        checkSelectionChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideSelector() {
        int i = this.mSelectedPosition;
        if (i != -1) {
            if (this.mLayoutMode != 4) {
                this.mResurrectToPosition = i;
            }
            int i2 = this.mNextSelectedPosition;
            if (i2 >= 0 && i2 != this.mSelectedPosition) {
                this.mResurrectToPosition = i2;
            }
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.mSelectedLeft = 0;
        }
    }

    @TargetApi(11)
    protected void invalidateParentIfNeeded() {
        if (this.mViewHelper.isHardwareAccelerated() && (getParent() instanceof View)) {
            ((View) getParent()).invalidate();
        }
    }

    public void invalidateViews() {
        this.mDataChanged = true;
        rememberSyncState();
        requestLayout();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void invokeOnItemScrollListener() {
        OnScrollListener onScrollListener = this.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener.onScroll(this, this.mFirstPosition, getChildCount(), this.mItemCount);
        }
        onScrollChanged(0, 0, 0, 0);
    }

    public boolean isItemChecked(int i) {
        h<Boolean> hVar;
        if (this.mChoiceMode == 0 || (hVar = this.mCheckStates) == null) {
            return false;
        }
        return hVar.b(i, false).booleanValue();
    }

    @ViewDebug.ExportedProperty
    public boolean isScrollingCacheEnabled() {
        return this.mScrollingCacheEnabled;
    }

    @ViewDebug.ExportedProperty
    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    public boolean isStackFromRight() {
        return this.mStackFromRight;
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.mSelector;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void keyPressed() {
        if (isEnabled() && isClickable()) {
            Drawable drawable = this.mSelector;
            Rect rect = this.mSelectorRect;
            if (drawable != null) {
                if ((isFocused() || touchModeDrawsInPressedState()) && !rect.isEmpty()) {
                    View childAt = getChildAt(this.mSelectedPosition - this.mFirstPosition);
                    if (childAt != null) {
                        if (childAt.hasFocusable()) {
                            return;
                        } else {
                            childAt.setPressed(true);
                        }
                    }
                    setPressed(true);
                    boolean isLongClickable = isLongClickable();
                    Drawable current = drawable.getCurrent();
                    if (current != null && (current instanceof TransitionDrawable)) {
                        if (isLongClickable) {
                            ((TransitionDrawable) current).startTransition(ViewConfiguration.getLongPressTimeout());
                        } else {
                            ((TransitionDrawable) current).resetTransition();
                        }
                    }
                    if (!isLongClickable || this.mDataChanged) {
                        return;
                    }
                    if (this.mPendingCheckForKeyLongPress == null) {
                        this.mPendingCheckForKeyLongPress = new CheckForKeyLongPress();
                    }
                    this.mPendingCheckForKeyLongPress.rememberWindowAttachCount();
                    postDelayed(this.mPendingCheckForKeyLongPress, ViewConfiguration.getLongPressTimeout());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void layoutChildren() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"NewApi"})
    public View obtainView(int i, boolean[] zArr) {
        View view;
        LayoutParams layoutParams;
        zArr[0] = false;
        View transientStateView = this.mRecycler.getTransientStateView(i);
        if (transientStateView != null) {
            return transientStateView;
        }
        View scrapView = this.mRecycler.getScrapView(i);
        if (scrapView != null) {
            view = this.mAdapter.getView(i, scrapView, this);
            if (view != null) {
                if (Build.VERSION.SDK_INT >= 16 && view.getImportantForAccessibility() == 0) {
                    view.setImportantForAccessibility(1);
                }
                if (!view.equals(scrapView)) {
                    this.mRecycler.addScrapView(scrapView, i);
                    int i2 = this.mCacheColorHint;
                    if (i2 != 0) {
                        view.setDrawingCacheBackgroundColor(i2);
                    }
                } else {
                    zArr[0] = true;
                    view.onFinishTemporaryDetach();
                }
            }
        } else {
            view = this.mAdapter.getView(i, null, this);
            if (view != null) {
                if (Build.VERSION.SDK_INT >= 16 && view.getImportantForAccessibility() == 0) {
                    view.setImportantForAccessibility(1);
                }
                int i3 = this.mCacheColorHint;
                if (i3 != 0) {
                    view.setDrawingCacheBackgroundColor(i3);
                }
            }
        }
        if (this.mAdapterHasStableIds && view != null) {
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams = (LayoutParams) generateDefaultLayoutParams();
            } else if (!checkLayoutParams(layoutParams2)) {
                layoutParams = (LayoutParams) generateLayoutParams(layoutParams2);
            } else {
                layoutParams = (LayoutParams) layoutParams2;
            }
            layoutParams.itemId = this.mAdapter.getItemId(i);
            view.setLayoutParams(layoutParams);
        }
        if (this.mAccessibilityManager.isEnabled() && this.mAccessibilityDelegate == null) {
            this.mAccessibilityDelegate = new ListItemAccessibilityDelegate();
        }
        return view;
    }

    public void offsetChildrenLeftAndRight(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            getChildAt(i2).offsetLeftAndRight(i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnTouchModeChangeListener(this);
        if (this.mAdapter != null && this.mDataSetObserver == null) {
            AdapterDataSetObserver adapterDataSetObserver = new AdapterDataSetObserver();
            this.mDataSetObserver = adapterDataSetObserver;
            this.mAdapter.registerDataSetObserver(adapterDataSetObserver);
            this.mDataChanged = true;
            this.mOldItemCount = this.mItemCount;
            this.mItemCount = this.mAdapter.getCount();
        }
        this.mIsAttached = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"Override"})
    protected int[] onCreateDrawableState(int i) {
        if (this.mIsChildViewEnabled) {
            return super.onCreateDrawableState(i);
        }
        int i2 = ViewGroup.ENABLED_STATE_SET[0];
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        int length = onCreateDrawableState.length - 1;
        while (true) {
            if (length < 0) {
                length = -1;
                break;
            }
            if (onCreateDrawableState[length] == i2) {
                break;
            }
            length--;
        }
        if (length >= 0) {
            System.arraycopy(onCreateDrawableState, length + 1, onCreateDrawableState, length, (onCreateDrawableState.length - length) - 1);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // it.sephiroth.android.library.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        AdapterDataSetObserver adapterDataSetObserver;
        super.onDetachedFromWindow();
        this.mRecycler.clear();
        getViewTreeObserver().removeOnTouchModeChangeListener(this);
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null && (adapterDataSetObserver = this.mDataSetObserver) != null) {
            listAdapter.unregisterDataSetObserver(adapterDataSetObserver);
            this.mDataSetObserver = null;
        }
        FlingRunnable flingRunnable = this.mFlingRunnable;
        if (flingRunnable != null) {
            removeCallbacks(flingRunnable);
        }
        PositionScroller positionScroller = this.mPositionScroller;
        if (positionScroller != null) {
            positionScroller.stop();
        }
        Runnable runnable = this.mClearScrollingCache;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        PerformClick performClick = this.mPerformClick;
        if (performClick != null) {
            removeCallbacks(performClick);
        }
        Runnable runnable2 = this.mTouchModeReset;
        if (runnable2 != null) {
            removeCallbacks(runnable2);
            this.mTouchModeReset = null;
        }
        this.mIsAttached = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        ListAdapter listAdapter;
        super.onFocusChanged(z, i, rect);
        if (!z || this.mSelectedPosition >= 0 || isInTouchMode()) {
            return;
        }
        if (!this.mIsAttached && (listAdapter = this.mAdapter) != null) {
            this.mDataChanged = true;
            this.mOldItemCount = this.mItemCount;
            this.mItemCount = listAdapter.getCount();
        }
        resurrectSelection();
    }

    @Override // android.view.View
    @TargetApi(12)
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && this.mTouchMode == -1) {
            float axisValue = motionEvent.getAxisValue(10);
            if (Double.doubleToLongBits(axisValue) != Double.doubleToLongBits(0.0d)) {
                int horizontalScrollFactor = (int) (axisValue * getHorizontalScrollFactor());
                if (!trackMotionScroll(horizontalScrollFactor, horizontalScrollFactor)) {
                    return true;
                }
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // it.sephiroth.android.library.widget.AdapterView, android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(AbsHListView.class.getName());
    }

    @Override // it.sephiroth.android.library.widget.AdapterView, android.view.View
    @SuppressLint({"Override"})
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(AbsHListView.class.getName());
        if (isEnabled()) {
            if (getFirstVisiblePosition() > 0) {
                accessibilityNodeInfo.addAction(Utility.DEFAULT_STREAM_BUFFER_SIZE);
            }
            if (getLastVisiblePosition() < getCount() - 1) {
                accessibilityNodeInfo.addAction(4096);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        PositionScroller positionScroller = this.mPositionScroller;
        if (positionScroller != null) {
            positionScroller.stop();
        }
        if (!this.mIsAttached) {
            return false;
        }
        int i = action & 255;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 6) {
                            onSecondaryPointerUp(motionEvent);
                        }
                    }
                } else if (this.mTouchMode == 0) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex == -1) {
                        this.mActivePointerId = motionEvent.getPointerId(0);
                        findPointerIndex = 0;
                    }
                    int x = (int) motionEvent.getX(findPointerIndex);
                    initVelocityTrackerIfNotExists();
                    this.mVelocityTracker.addMovement(motionEvent);
                    if (startScrollIfNeeded(x)) {
                        return true;
                    }
                }
            }
            this.mTouchMode = -1;
            this.mActivePointerId = -1;
            recycleVelocityTracker();
            reportScrollStateChange(0);
        } else {
            int i2 = this.mTouchMode;
            if (i2 != 6 && i2 != 5) {
                int x2 = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                this.mActivePointerId = motionEvent.getPointerId(0);
                int findMotionCol = findMotionCol(x2);
                if (i2 != 4 && findMotionCol >= 0) {
                    this.mMotionViewOriginalLeft = getChildAt(findMotionCol - this.mFirstPosition).getLeft();
                    this.mMotionX = x2;
                    this.mMotionY = y;
                    this.mMotionPosition = findMotionCol;
                    this.mTouchMode = 0;
                    clearScrollingCache();
                }
                this.mLastX = Integer.MIN_VALUE;
                initOrResetVelocityTracker();
                this.mVelocityTracker.addMovement(motionEvent);
                if (i2 == 4) {
                    return true;
                }
            } else {
                this.mMotionCorrection = 0;
                return true;
            }
        }
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        int i2;
        ListAdapter listAdapter;
        if (i == 23 || i == 66) {
            if (!isEnabled()) {
                return true;
            }
            if (isClickable() && isPressed() && (i2 = this.mSelectedPosition) >= 0 && (listAdapter = this.mAdapter) != null && i2 < listAdapter.getCount()) {
                View childAt = getChildAt(this.mSelectedPosition - this.mFirstPosition);
                if (childAt != null) {
                    performItemClick(childAt, this.mSelectedPosition, this.mSelectedColId);
                    childAt.setPressed(false);
                }
                setPressed(false);
                return true;
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // it.sephiroth.android.library.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mInLayout = true;
        if (z) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                getChildAt(i5).forceLayout();
            }
            this.mRecycler.markChildrenDirty();
        }
        layoutChildren();
        this.mInLayout = false;
        this.mOverscrollMax = (i3 - i) / 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (this.mSelector == null) {
            useDefaultSelector();
        }
        Rect rect = this.mListPadding;
        rect.left = this.mSelectionLeftPadding + getPaddingLeft();
        rect.top = this.mSelectionTopPadding + getPaddingTop();
        rect.right = this.mSelectionRightPadding + getPaddingRight();
        rect.bottom = this.mSelectionBottomPadding + getPaddingBottom();
        if (this.mTranscriptMode == 1) {
            int childCount = getChildCount();
            int width = getWidth() - getPaddingRight();
            View childAt = getChildAt(childCount - 1);
            this.mForceTranscriptScroll = this.mFirstPosition + childCount >= this.mLastHandledItemCount && (childAt != null ? childAt.getRight() : width) <= width;
        }
    }

    @Override // android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        if (getScrollX() != i) {
            onScrollChanged(i, getScrollY(), getScrollX(), getScrollY());
            this.mViewHelper.setScrollX(i);
            invalidateParentIfNeeded();
            awakenScrollBars();
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Object obj;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mDataChanged = true;
        this.mSyncWidth = savedState.width;
        long j = savedState.selectedId;
        if (j >= 0) {
            this.mNeedSync = true;
            this.mPendingSync = savedState;
            this.mSyncColId = j;
            this.mSyncPosition = savedState.position;
            this.mSpecificLeft = savedState.viewLeft;
            this.mSyncMode = 0;
        } else if (savedState.firstId >= 0) {
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.mSelectorPosition = -1;
            this.mNeedSync = true;
            this.mPendingSync = savedState;
            this.mSyncColId = savedState.firstId;
            this.mSyncPosition = savedState.position;
            this.mSpecificLeft = savedState.viewLeft;
            this.mSyncMode = 1;
        }
        h<Boolean> hVar = savedState.checkState;
        if (hVar != null) {
            this.mCheckStates = hVar;
        }
        LongSparseArray<Integer> longSparseArray = savedState.checkIdState;
        if (longSparseArray != null) {
            this.mCheckedIdStates = longSparseArray;
        }
        this.mCheckedItemCount = savedState.checkedItemCount;
        if (Build.VERSION.SDK_INT >= 11 && savedState.inActionMode && this.mChoiceMode == 3 && (obj = this.mMultiChoiceModeCallback) != null) {
            this.mChoiceActionMode = startActionMode((MultiChoiceModeWrapper) obj);
        }
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.mPendingSync;
        if (savedState2 != null) {
            savedState.selectedId = savedState2.selectedId;
            savedState.firstId = savedState2.firstId;
            savedState.viewLeft = savedState2.viewLeft;
            savedState.position = savedState2.position;
            savedState.width = savedState2.width;
            savedState.filter = savedState2.filter;
            savedState.inActionMode = savedState2.inActionMode;
            savedState.checkedItemCount = savedState2.checkedItemCount;
            savedState.checkState = savedState2.checkState;
            savedState.checkIdState = savedState2.checkIdState;
            return savedState;
        }
        boolean z = getChildCount() > 0 && this.mItemCount > 0;
        long selectedItemId = getSelectedItemId();
        savedState.selectedId = selectedItemId;
        savedState.width = getWidth();
        if (selectedItemId >= 0) {
            savedState.viewLeft = this.mSelectedLeft;
            savedState.position = getSelectedItemPosition();
            savedState.firstId = -1L;
        } else if (z && this.mFirstPosition > 0) {
            savedState.viewLeft = getChildAt(0).getLeft();
            int i = this.mFirstPosition;
            int i2 = this.mItemCount;
            if (i >= i2) {
                i = i2 - 1;
            }
            savedState.position = i;
            savedState.firstId = this.mAdapter.getItemId(i);
        } else {
            savedState.viewLeft = 0;
            savedState.firstId = -1L;
            savedState.position = 0;
        }
        savedState.filter = null;
        savedState.inActionMode = Build.VERSION.SDK_INT >= 11 && this.mChoiceMode == 3 && this.mChoiceActionMode != null;
        h<Boolean> hVar = this.mCheckStates;
        if (hVar != null) {
            try {
                savedState.checkState = hVar.m2clone();
            } catch (NoSuchMethodError e) {
                e.printStackTrace();
                savedState.checkState = new h<>();
            }
        }
        if (this.mCheckedIdStates != null) {
            LongSparseArray<Integer> longSparseArray = new LongSparseArray<>();
            int size = this.mCheckedIdStates.size();
            for (int i3 = 0; i3 < size; i3++) {
                longSparseArray.put(this.mCheckedIdStates.keyAt(i3), this.mCheckedIdStates.valueAt(i3));
            }
            savedState.checkIdState = longSparseArray;
        }
        savedState.checkedItemCount = this.mCheckedItemCount;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        if (getChildCount() > 0) {
            this.mDataChanged = true;
            rememberSyncState();
        }
    }

    @Override // android.view.View
    @SuppressLint({"Override"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Drawable current;
        int i = 0;
        if (!isEnabled()) {
            return isClickable() || isLongClickable();
        }
        PositionScroller positionScroller = this.mPositionScroller;
        if (positionScroller != null) {
            positionScroller.stop();
        }
        if (!this.mIsAttached) {
            return false;
        }
        int action = motionEvent.getAction();
        initVelocityTrackerIfNotExists();
        this.mVelocityTracker.addMovement(motionEvent);
        int i2 = action & 255;
        if (i2 == 0) {
            if (this.mTouchMode != 6) {
                this.mActivePointerId = motionEvent.getPointerId(0);
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                int pointToPosition = pointToPosition(x, y);
                if (!this.mDataChanged) {
                    if (this.mTouchMode != 4 && pointToPosition >= 0 && getAdapter().isEnabled(pointToPosition)) {
                        this.mTouchMode = 0;
                        if (this.mPendingCheckForTap == null) {
                            this.mPendingCheckForTap = new CheckForTap();
                        }
                        postDelayed(this.mPendingCheckForTap, ViewConfiguration.getTapTimeout());
                    } else if (this.mTouchMode == 4) {
                        createScrollingCache();
                        this.mTouchMode = 3;
                        this.mMotionCorrection = 0;
                        pointToPosition = findMotionCol(x);
                        this.mFlingRunnable.flywheelTouch();
                    }
                }
                if (pointToPosition >= 0) {
                    this.mMotionViewOriginalLeft = getChildAt(pointToPosition - this.mFirstPosition).getLeft();
                }
                this.mMotionX = x;
                this.mMotionY = y;
                this.mMotionPosition = pointToPosition;
                this.mLastX = Integer.MIN_VALUE;
            } else {
                this.mFlingRunnable.endFling();
                PositionScroller positionScroller2 = this.mPositionScroller;
                if (positionScroller2 != null) {
                    positionScroller2.stop();
                }
                this.mTouchMode = 5;
                this.mMotionY = (int) motionEvent.getY();
                int x2 = (int) motionEvent.getX();
                this.mLastX = x2;
                this.mMotionX = x2;
                this.mMotionCorrection = 0;
                this.mActivePointerId = motionEvent.getPointerId(0);
                this.mDirection = 0;
            }
            if (performButtonActionOnTouchDown(motionEvent) && this.mTouchMode == 0) {
                removeCallbacks(this.mPendingCheckForTap);
            }
        } else if (i2 == 1) {
            int i3 = this.mTouchMode;
            if (i3 == 0 || i3 == 1 || i3 == 2) {
                int i4 = this.mMotionPosition;
                final View childAt = getChildAt(i4 - this.mFirstPosition);
                float x3 = motionEvent.getX();
                boolean z = x3 > ((float) this.mListPadding.left) && x3 < ((float) (getWidth() - this.mListPadding.right));
                if (childAt != null && !childAt.hasFocusable() && z) {
                    if (this.mTouchMode != 0) {
                        childAt.setPressed(false);
                    }
                    if (this.mPerformClick == null) {
                        this.mPerformClick = new PerformClick();
                    }
                    final PerformClick performClick = this.mPerformClick;
                    performClick.mClickMotionPosition = i4;
                    performClick.rememberWindowAttachCount();
                    this.mResurrectToPosition = i4;
                    int i5 = this.mTouchMode;
                    if (i5 != 0 && i5 != 1) {
                        if (!this.mDataChanged && this.mAdapter.isEnabled(i4)) {
                            performClick.run();
                        }
                    } else {
                        Handler handler = getHandler();
                        if (handler != null) {
                            handler.removeCallbacks(this.mTouchMode == 0 ? this.mPendingCheckForTap : this.mPendingCheckForLongPress);
                        }
                        this.mLayoutMode = 0;
                        if (!this.mDataChanged && this.mAdapter.isEnabled(i4)) {
                            this.mTouchMode = 1;
                            setSelectedPositionInt(this.mMotionPosition);
                            layoutChildren();
                            childAt.setPressed(true);
                            positionSelector(this.mMotionPosition, childAt);
                            setPressed(true);
                            Drawable drawable = this.mSelector;
                            if (drawable != null && (current = drawable.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                                ((TransitionDrawable) current).resetTransition();
                            }
                            Runnable runnable = this.mTouchModeReset;
                            if (runnable != null) {
                                removeCallbacks(runnable);
                            }
                            Runnable runnable2 = new Runnable() { // from class: it.sephiroth.android.library.widget.AbsHListView.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AbsHListView.this.mTouchMode = -1;
                                    childAt.setPressed(false);
                                    AbsHListView.this.setPressed(false);
                                    if (AbsHListView.this.mDataChanged) {
                                        return;
                                    }
                                    performClick.run();
                                }
                            };
                            this.mTouchModeReset = runnable2;
                            postDelayed(runnable2, ViewConfiguration.getPressedStateDuration());
                        } else {
                            this.mTouchMode = -1;
                            updateSelectorState();
                        }
                        return true;
                    }
                }
                this.mTouchMode = -1;
                updateSelectorState();
            } else if (i3 == 3) {
                int childCount = getChildCount();
                if (childCount > 0) {
                    int left = getChildAt(0).getLeft();
                    int right = getChildAt(childCount - 1).getRight();
                    int i6 = this.mListPadding.left;
                    int width = getWidth() - this.mListPadding.right;
                    int i7 = this.mFirstPosition;
                    if (i7 == 0 && left >= i6 && i7 + childCount < this.mItemCount && right <= getWidth() - width) {
                        this.mTouchMode = -1;
                        reportScrollStateChange(0);
                    } else {
                        VelocityTracker velocityTracker = this.mVelocityTracker;
                        velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                        int xVelocity = (int) (velocityTracker.getXVelocity(this.mActivePointerId) * this.mVelocityScale);
                        if (Math.abs(xVelocity) > this.mMinimumVelocity && ((this.mFirstPosition != 0 || left != i6 - this.mOverscrollDistance) && (this.mFirstPosition + childCount != this.mItemCount || right != width + this.mOverscrollDistance))) {
                            if (this.mFlingRunnable == null) {
                                this.mFlingRunnable = new FlingRunnable();
                            }
                            reportScrollStateChange(2);
                            this.mFlingRunnable.start(-xVelocity);
                        } else {
                            this.mTouchMode = -1;
                            reportScrollStateChange(0);
                            FlingRunnable flingRunnable = this.mFlingRunnable;
                            if (flingRunnable != null) {
                                flingRunnable.endFling();
                            }
                            PositionScroller positionScroller3 = this.mPositionScroller;
                            if (positionScroller3 != null) {
                                positionScroller3.stop();
                            }
                        }
                    }
                } else {
                    this.mTouchMode = -1;
                    reportScrollStateChange(0);
                }
            } else if (i3 == 5) {
                if (this.mFlingRunnable == null) {
                    this.mFlingRunnable = new FlingRunnable();
                }
                VelocityTracker velocityTracker2 = this.mVelocityTracker;
                velocityTracker2.computeCurrentVelocity(1000, this.mMaximumVelocity);
                int xVelocity2 = (int) velocityTracker2.getXVelocity(this.mActivePointerId);
                reportScrollStateChange(2);
                if (Math.abs(xVelocity2) > this.mMinimumVelocity) {
                    this.mFlingRunnable.startOverfling(-xVelocity2);
                } else {
                    this.mFlingRunnable.startSpringback();
                }
            }
            setPressed(false);
            EdgeEffect edgeEffect = this.mEdgeGlowTop;
            if (edgeEffect != null) {
                edgeEffect.onRelease();
                this.mEdgeGlowBottom.onRelease();
            }
            invalidate();
            Handler handler2 = getHandler();
            if (handler2 != null) {
                handler2.removeCallbacks(this.mPendingCheckForLongPress);
            }
            recycleVelocityTracker();
            this.mActivePointerId = -1;
        } else if (i2 == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
            if (findPointerIndex == -1) {
                this.mActivePointerId = motionEvent.getPointerId(0);
            } else {
                i = findPointerIndex;
            }
            int x4 = (int) motionEvent.getX(i);
            if (this.mDataChanged) {
                layoutChildren();
            }
            int i8 = this.mTouchMode;
            if (i8 == 0 || i8 == 1 || i8 == 2) {
                startScrollIfNeeded(x4);
            } else if (i8 == 3 || i8 == 5) {
                scrollIfNeeded(x4);
            }
        } else if (i2 == 3) {
            int i9 = this.mTouchMode;
            if (i9 == 5) {
                if (this.mFlingRunnable == null) {
                    this.mFlingRunnable = new FlingRunnable();
                }
                this.mFlingRunnable.startSpringback();
            } else if (i9 != 6) {
                this.mTouchMode = -1;
                setPressed(false);
                View childAt2 = getChildAt(this.mMotionPosition - this.mFirstPosition);
                if (childAt2 != null) {
                    childAt2.setPressed(false);
                }
                clearScrollingCache();
                Handler handler3 = getHandler();
                if (handler3 != null) {
                    handler3.removeCallbacks(this.mPendingCheckForLongPress);
                }
                recycleVelocityTracker();
            }
            EdgeEffect edgeEffect2 = this.mEdgeGlowTop;
            if (edgeEffect2 != null) {
                edgeEffect2.onRelease();
                this.mEdgeGlowBottom.onRelease();
            }
            this.mActivePointerId = -1;
        } else if (i2 == 5) {
            int actionIndex = motionEvent.getActionIndex();
            int pointerId = motionEvent.getPointerId(actionIndex);
            int x5 = (int) motionEvent.getX(actionIndex);
            int y2 = (int) motionEvent.getY(actionIndex);
            this.mMotionCorrection = 0;
            this.mActivePointerId = pointerId;
            this.mMotionX = x5;
            this.mMotionY = y2;
            int pointToPosition2 = pointToPosition(x5, y2);
            if (pointToPosition2 >= 0) {
                this.mMotionViewOriginalLeft = getChildAt(pointToPosition2 - this.mFirstPosition).getLeft();
                this.mMotionPosition = pointToPosition2;
            }
            this.mLastX = x5;
        } else if (i2 == 6) {
            onSecondaryPointerUp(motionEvent);
            int i10 = this.mMotionX;
            int pointToPosition3 = pointToPosition(i10, this.mMotionY);
            if (pointToPosition3 >= 0) {
                this.mMotionViewOriginalLeft = getChildAt(pointToPosition3 - this.mFirstPosition).getLeft();
                this.mMotionPosition = pointToPosition3;
            }
            this.mLastX = i10;
        }
        return true;
    }

    @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
    public void onTouchModeChanged(boolean z) {
        if (z) {
            hideSelector();
            if (getWidth() > 0 && getChildCount() > 0) {
                layoutChildren();
            }
            updateSelectorState();
            return;
        }
        int i = this.mTouchMode;
        if (i == 5 || i == 6) {
            FlingRunnable flingRunnable = this.mFlingRunnable;
            if (flingRunnable != null) {
                flingRunnable.endFling();
            }
            PositionScroller positionScroller = this.mPositionScroller;
            if (positionScroller != null) {
                positionScroller.stop();
            }
            if (getScrollX() != 0) {
                this.mViewHelper.setScrollX(0);
                finishGlows();
                invalidate();
            }
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        int i = !isInTouchMode() ? 1 : 0;
        if (!z) {
            setChildrenDrawingCacheEnabled(false);
            FlingRunnable flingRunnable = this.mFlingRunnable;
            if (flingRunnable != null) {
                removeCallbacks(flingRunnable);
                this.mFlingRunnable.endFling();
                PositionScroller positionScroller = this.mPositionScroller;
                if (positionScroller != null) {
                    positionScroller.stop();
                }
                if (getScrollX() != 0) {
                    this.mViewHelper.setScrollX(0);
                    finishGlows();
                    invalidate();
                }
            }
            if (i == 1) {
                this.mResurrectToPosition = this.mSelectedPosition;
            }
        } else {
            int i2 = this.mLastTouchMode;
            if (i != i2 && i2 != -1) {
                if (i == 1) {
                    resurrectSelection();
                } else {
                    hideSelector();
                    this.mLayoutMode = 0;
                    layoutChildren();
                }
            }
        }
        this.mLastTouchMode = i;
    }

    @Override // android.view.View
    @TargetApi(16)
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        if (super.performAccessibilityAction(i, bundle)) {
            return true;
        }
        if (i != 4096) {
            if (i != 8192 || !isEnabled() || this.mFirstPosition <= 0) {
                return false;
            }
            int width = getWidth();
            Rect rect = this.mListPadding;
            smoothScrollBy(-((width - rect.left) - rect.right), IMediaPlayer.MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK);
            return true;
        }
        if (!isEnabled() || getLastVisiblePosition() >= getCount() - 1) {
            return false;
        }
        int width2 = getWidth();
        Rect rect2 = this.mListPadding;
        smoothScrollBy((width2 - rect2.left) - rect2.right, IMediaPlayer.MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK);
        return true;
    }

    @TargetApi(14)
    protected boolean performButtonActionOnTouchDown(MotionEvent motionEvent) {
        return Build.VERSION.SDK_INT >= 14 && (motionEvent.getButtonState() & 2) != 0 && showContextMenu(motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState());
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00df  */
    @Override // it.sephiroth.android.library.widget.AdapterView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean performItemClick(android.view.View r11, int r12, long r13) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: it.sephiroth.android.library.widget.AbsHListView.performItemClick(android.view.View, int, long):boolean");
    }

    boolean performLongPress(View view, int i, long j) {
        if (Build.VERSION.SDK_INT >= 11 && this.mChoiceMode == 3) {
            if (this.mChoiceActionMode == null) {
                ActionMode startActionMode = startActionMode((MultiChoiceModeWrapper) this.mMultiChoiceModeCallback);
                this.mChoiceActionMode = startActionMode;
                if (startActionMode != null) {
                    setItemChecked(i, true);
                    performHapticFeedback(0);
                }
            }
            return true;
        }
        AdapterView.OnItemLongClickListener onItemLongClickListener = this.mOnItemLongClickListener;
        boolean onItemLongClick = onItemLongClickListener != null ? onItemLongClickListener.onItemLongClick(this, view, i, j) : false;
        if (!onItemLongClick) {
            this.mContextMenuInfo = createContextMenuInfo(view, i, j);
            onItemLongClick = super.showContextMenuForChild(this);
        }
        if (onItemLongClick) {
            performHapticFeedback(0);
        }
        return onItemLongClick;
    }

    public long pointToColId(int i, int i2) {
        int pointToPosition = pointToPosition(i, i2);
        if (pointToPosition >= 0) {
            return this.mAdapter.getItemId(pointToPosition);
        }
        return Long.MIN_VALUE;
    }

    public int pointToPosition(int i, int i2) {
        Rect rect = this.mTouchFrame;
        if (rect == null) {
            rect = new Rect();
            this.mTouchFrame = rect;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i, i2)) {
                    return this.mFirstPosition + childCount;
                }
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void positionSelector(int i, View view) {
        if (i != -1) {
            this.mSelectorPosition = i;
        }
        Rect rect = this.mSelectorRect;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        if (view instanceof SelectionBoundsAdjuster) {
            ((SelectionBoundsAdjuster) view).adjustListItemSelectionBounds(rect);
        }
        positionSelector(rect.left, rect.top, rect.right, rect.bottom);
        boolean z = this.mIsChildViewEnabled;
        if (view.isEnabled() != z) {
            this.mIsChildViewEnabled = !z;
            if (getSelectedItemPosition() != -1) {
                refreshDrawableState();
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void reclaimViews(List<View> list) {
        int childCount = getChildCount();
        RecyclerListener recyclerListener = this.mRecycler.mRecyclerListener;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams != null && this.mRecycler.shouldRecycleViewType(layoutParams.viewType)) {
                list.add(childAt);
                if (Build.VERSION.SDK_INT >= 14) {
                    childAt.setAccessibilityDelegate(null);
                }
                if (recyclerListener != null) {
                    recyclerListener.onMovedToScrapHeap(childAt);
                }
            }
        }
        this.mRecycler.reclaimScrapViews(list);
        removeAllViewsInLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int reconcileSelectedPosition() {
        int i = this.mSelectedPosition;
        if (i < 0) {
            i = this.mResurrectToPosition;
        }
        return Math.min(Math.max(0, i), this.mItemCount - 1);
    }

    void reportScrollStateChange(int i) {
        OnScrollListener onScrollListener;
        if (i == this.mLastScrollState || (onScrollListener = this.mOnScrollListener) == null) {
            return;
        }
        this.mLastScrollState = i;
        onScrollListener.onScrollStateChanged(this, i);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            recycleVelocityTracker();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mBlockLayoutRequests || this.mInLayout) {
            return;
        }
        super.requestLayout();
    }

    void requestLayoutIfNecessary() {
        if (getChildCount() > 0) {
            resetList();
            requestLayout();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void resetList() {
        removeAllViewsInLayout();
        this.mFirstPosition = 0;
        this.mDataChanged = false;
        this.mPositionScrollAfterLayout = null;
        this.mNeedSync = false;
        this.mPendingSync = null;
        this.mOldSelectedPosition = -1;
        this.mOldSelectedColId = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        this.mSelectedLeft = 0;
        this.mSelectorPosition = -1;
        this.mSelectorRect.setEmpty();
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d3 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    boolean resurrectSelection() {
        /*
            Method dump skipped, instructions count: 213
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: it.sephiroth.android.library.widget.AbsHListView.resurrectSelection():boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean resurrectSelectionIfNeeded() {
        if (this.mSelectedPosition >= 0 || !resurrectSelection()) {
            return false;
        }
        updateSelectorState();
        return true;
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEvent(int i) {
        if (i == 4096) {
            int firstVisiblePosition = getFirstVisiblePosition();
            int lastVisiblePosition = getLastVisiblePosition();
            if (this.mLastAccessibilityScrollEventFromIndex == firstVisiblePosition && this.mLastAccessibilityScrollEventToIndex == lastVisiblePosition) {
                return;
            }
            this.mLastAccessibilityScrollEventFromIndex = firstVisiblePosition;
            this.mLastAccessibilityScrollEventToIndex = lastVisiblePosition;
        }
        super.sendAccessibilityEvent(i);
    }

    public void setCacheColorHint(int i) {
        if (i != this.mCacheColorHint) {
            this.mCacheColorHint = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                getChildAt(i2).setDrawingCacheBackgroundColor(i);
            }
            this.mRecycler.setCacheColorHint(i);
        }
    }

    @TargetApi(11)
    public void setChoiceMode(int i) {
        ListAdapter listAdapter;
        Object obj;
        this.mChoiceMode = i;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 11 && (obj = this.mChoiceActionMode) != null) {
            if (i2 >= 11) {
                ((ActionMode) obj).finish();
            }
            this.mChoiceActionMode = null;
        }
        if (this.mChoiceMode != 0) {
            if (this.mCheckStates == null) {
                this.mCheckStates = new h<>();
            }
            if (this.mCheckedIdStates == null && (listAdapter = this.mAdapter) != null && listAdapter.hasStableIds()) {
                this.mCheckedIdStates = new LongSparseArray<>();
            }
            if (Build.VERSION.SDK_INT < 11 || this.mChoiceMode != 3) {
                return;
            }
            clearChoices();
            setLongClickable(true);
        }
    }

    public void setDrawSelectorOnTop(boolean z) {
        this.mDrawSelectorOnTop = z;
    }

    public void setFriction(float f) {
        if (this.mFlingRunnable == null) {
            this.mFlingRunnable = new FlingRunnable();
        }
        this.mFlingRunnable.mScroller.setFriction(f);
    }

    public void setItemChecked(int i, boolean z) {
        int i2 = this.mChoiceMode;
        if (i2 == 0) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 11 && z && i2 == 3 && this.mChoiceActionMode == null) {
            Object obj = this.mMultiChoiceModeCallback;
            if (obj != null && ((MultiChoiceModeWrapper) obj).hasWrappedCallback()) {
                this.mChoiceActionMode = startActionMode((MultiChoiceModeWrapper) this.mMultiChoiceModeCallback);
            } else {
                throw new IllegalStateException("AbsListView: attempted to start selection mode for CHOICE_MODE_MULTIPLE_MODAL but no choice mode callback was supplied. Call setMultiChoiceModeListener to set a callback.");
            }
        }
        int i3 = this.mChoiceMode;
        if (i3 != 2 && (Build.VERSION.SDK_INT < 11 || i3 != 3)) {
            boolean z2 = this.mCheckedIdStates != null && this.mAdapter.hasStableIds();
            if (z || isItemChecked(i)) {
                this.mCheckStates.a();
                if (z2) {
                    this.mCheckedIdStates.clear();
                }
            }
            if (z) {
                this.mCheckStates.c(i, true);
                if (z2) {
                    this.mCheckedIdStates.put(this.mAdapter.getItemId(i), Integer.valueOf(i));
                }
                this.mCheckedItemCount = 1;
            } else if (this.mCheckStates.b() == 0 || !this.mCheckStates.e(0).booleanValue()) {
                this.mCheckedItemCount = 0;
            }
        } else {
            boolean booleanValue = this.mCheckStates.b(i, false).booleanValue();
            this.mCheckStates.c(i, Boolean.valueOf(z));
            if (this.mCheckedIdStates != null && this.mAdapter.hasStableIds()) {
                if (z) {
                    this.mCheckedIdStates.put(this.mAdapter.getItemId(i), Integer.valueOf(i));
                } else {
                    this.mCheckedIdStates.delete(this.mAdapter.getItemId(i));
                }
            }
            if (booleanValue != z) {
                if (z) {
                    this.mCheckedItemCount++;
                } else {
                    this.mCheckedItemCount--;
                }
            }
            if (this.mChoiceActionMode != null) {
                ((MultiChoiceModeWrapper) this.mMultiChoiceModeCallback).onItemCheckedStateChanged((ActionMode) this.mChoiceActionMode, i, this.mAdapter.getItemId(i), z);
            }
        }
        if (this.mInLayout || this.mBlockLayoutRequests) {
            return;
        }
        this.mDataChanged = true;
        rememberSyncState();
        requestLayout();
    }

    @TargetApi(11)
    public void setMultiChoiceModeListener(MultiChoiceModeListener multiChoiceModeListener) {
        if (Build.VERSION.SDK_INT >= 11) {
            if (this.mMultiChoiceModeCallback == null) {
                this.mMultiChoiceModeCallback = new MultiChoiceModeWrapper(this);
            }
            ((MultiChoiceModeWrapper) this.mMultiChoiceModeCallback).setWrapped(multiChoiceModeListener);
            return;
        }
        Log.e(TAG, "setMultiChoiceModeListener not supported for this version of Android");
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.mOnScrollListener = onScrollListener;
        invokeOnItemScrollListener();
    }

    public void setOverScrollEffectPadding(int i, int i2) {
        this.mGlowPaddingTop = i;
        this.mGlowPaddingBottom = i2;
    }

    @Override // android.view.View
    public void setOverScrollMode(int i) {
        if (i != 2) {
            if (this.mEdgeGlowTop == null) {
                Context context = getContext();
                this.mEdgeGlowTop = new EdgeEffect(context, 1);
                this.mEdgeGlowBottom = new EdgeEffect(context, 1);
            }
        } else {
            this.mEdgeGlowTop = null;
            this.mEdgeGlowBottom = null;
        }
        super.setOverScrollMode(i);
    }

    public void setRecyclerListener(RecyclerListener recyclerListener) {
        this.mRecycler.mRecyclerListener = recyclerListener;
    }

    public void setScrollIndicators(View view, View view2) {
        this.mScrollLeft = view;
        this.mScrollRight = view2;
    }

    public void setScrollingCacheEnabled(boolean z) {
        if (this.mScrollingCacheEnabled && !z) {
            clearScrollingCache();
        }
        this.mScrollingCacheEnabled = z;
    }

    public abstract void setSelectionInt(int i);

    public void setSelector(int i) {
        setSelector(getResources().getDrawable(i));
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.mSmoothScrollbarEnabled = z;
    }

    public void setStackFromRight(boolean z) {
        if (this.mStackFromRight != z) {
            this.mStackFromRight = z;
            requestLayoutIfNecessary();
        }
    }

    public void setTranscriptMode(int i) {
        this.mTranscriptMode = i;
    }

    public void setVelocityScale(float f) {
        this.mVelocityScale = f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setVisibleRangeHint(int i, int i2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean shouldShowSelector() {
        return (hasFocus() && !isInTouchMode()) || touchModeDrawsInPressedState();
    }

    public boolean showContextMenu(float f, float f2, int i) {
        int pointToPosition = pointToPosition((int) f, (int) f2);
        if (pointToPosition != -1) {
            long itemId = this.mAdapter.getItemId(pointToPosition);
            View childAt = getChildAt(pointToPosition - this.mFirstPosition);
            if (childAt != null) {
                this.mContextMenuInfo = createContextMenuInfo(childAt, pointToPosition, itemId);
                return super.showContextMenuForChild(this);
            }
        }
        return showContextMenu(f, f2, i);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean showContextMenuForChild(View view) {
        int positionForView = getPositionForView(view);
        if (positionForView < 0) {
            return false;
        }
        long itemId = this.mAdapter.getItemId(positionForView);
        AdapterView.OnItemLongClickListener onItemLongClickListener = this.mOnItemLongClickListener;
        boolean onItemLongClick = onItemLongClickListener != null ? onItemLongClickListener.onItemLongClick(this, view, positionForView, itemId) : false;
        if (onItemLongClick) {
            return onItemLongClick;
        }
        this.mContextMenuInfo = createContextMenuInfo(getChildAt(positionForView - this.mFirstPosition), positionForView, itemId);
        return super.showContextMenuForChild(view);
    }

    public void smoothScrollBy(int i, int i2) {
        smoothScrollBy(i, i2, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void smoothScrollByOffset(int i) {
        int lastVisiblePosition;
        View childAt;
        if (i < 0) {
            lastVisiblePosition = getFirstVisiblePosition();
        } else {
            lastVisiblePosition = i > 0 ? getLastVisiblePosition() : -1;
        }
        if (lastVisiblePosition <= -1 || (childAt = getChildAt(lastVisiblePosition - getFirstVisiblePosition())) == null) {
            return;
        }
        if (childAt.getGlobalVisibleRect(new Rect())) {
            float width = (r2.width() * r2.height()) / (childAt.getWidth() * childAt.getHeight());
            if (i < 0 && width < 0.75f) {
                lastVisiblePosition++;
            } else if (i > 0 && width < 0.75f) {
                lastVisiblePosition--;
            }
        }
        smoothScrollToPosition(Math.max(0, Math.min(getCount(), lastVisiblePosition + i)));
    }

    public void smoothScrollToPosition(int i) {
        if (this.mPositionScroller == null) {
            this.mPositionScroller = new PositionScroller();
        }
        this.mPositionScroller.start(i);
    }

    public void smoothScrollToPositionFromLeft(int i, int i2, int i3) {
        if (this.mPositionScroller == null) {
            this.mPositionScroller = new PositionScroller();
        }
        this.mPositionScroller.startWithOffset(i, i2, i3);
    }

    boolean touchModeDrawsInPressedState() {
        int i = this.mTouchMode;
        return i == 1 || i == 2;
    }

    boolean trackMotionScroll(int i, int i2) {
        int min;
        int min2;
        int i3;
        int i4;
        int i5;
        int i6;
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        int left = getChildAt(0).getLeft();
        int i7 = childCount - 1;
        int right = getChildAt(i7).getRight();
        Rect rect = this.mListPadding;
        int i8 = 0 - left;
        int width = right - (getWidth() - 0);
        int width2 = (getWidth() - getPaddingRight()) - getPaddingLeft();
        if (i < 0) {
            min = Math.max(-(width2 - 1), i);
        } else {
            min = Math.min(width2 - 1, i);
        }
        if (i2 < 0) {
            min2 = Math.max(-(width2 - 1), i2);
        } else {
            min2 = Math.min(width2 - 1, i2);
        }
        int i9 = this.mFirstPosition;
        if (i9 == 0) {
            this.mFirstPositionDistanceGuess = left - rect.left;
        } else {
            this.mFirstPositionDistanceGuess += min2;
        }
        int i10 = i9 + childCount;
        if (i10 == this.mItemCount) {
            this.mLastPositionDistanceGuess = rect.right + right;
        } else {
            this.mLastPositionDistanceGuess += min2;
        }
        boolean z = i9 == 0 && left >= rect.left && min2 >= 0;
        boolean z2 = i10 == this.mItemCount && right <= getWidth() - rect.right && min2 <= 0;
        if (z || z2) {
            return min2 != 0;
        }
        boolean z3 = min2 < 0;
        boolean isInTouchMode = isInTouchMode();
        if (isInTouchMode) {
            hideSelector();
        }
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = this.mItemCount - getFooterViewsCount();
        if (z3) {
            int i11 = -min2;
            int i12 = 0;
            i4 = 0;
            while (i12 < childCount) {
                View childAt = getChildAt(i12);
                if (childAt.getRight() >= i11) {
                    break;
                }
                i4++;
                int i13 = i9 + i12;
                if (i13 < headerViewsCount || i13 >= footerViewsCount) {
                    i6 = childCount;
                } else {
                    i6 = childCount;
                    this.mRecycler.addScrapView(childAt, i13);
                }
                i12++;
                childCount = i6;
            }
            i3 = 0;
        } else {
            int width3 = getWidth() - min2;
            i3 = 0;
            i4 = 0;
            while (i7 >= 0) {
                View childAt2 = getChildAt(i7);
                if (childAt2.getLeft() <= width3) {
                    break;
                }
                i4++;
                int i14 = i9 + i7;
                if (i14 >= headerViewsCount && i14 < footerViewsCount) {
                    this.mRecycler.addScrapView(childAt2, i14);
                }
                int i15 = i7;
                i7--;
                i3 = i15;
            }
        }
        this.mMotionViewNewLeft = this.mMotionViewOriginalLeft + min;
        this.mBlockLayoutRequests = true;
        if (i4 > 0) {
            detachViewsFromParent(i3, i4);
            this.mRecycler.removeSkippedScrap();
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        offsetChildrenLeftAndRight(min2);
        if (z3) {
            this.mFirstPosition += i4;
        }
        int abs = Math.abs(min2);
        if (i8 < abs || width < abs) {
            fillGap(z3);
        }
        if (!isInTouchMode && (i5 = this.mSelectedPosition) != -1) {
            int i16 = i5 - this.mFirstPosition;
            if (i16 >= 0 && i16 < getChildCount()) {
                positionSelector(this.mSelectedPosition, getChildAt(i16));
            }
        } else {
            int i17 = this.mSelectorPosition;
            if (i17 != -1) {
                int i18 = i17 - this.mFirstPosition;
                if (i18 >= 0 && i18 < getChildCount()) {
                    positionSelector(-1, getChildAt(i18));
                }
            } else {
                this.mSelectorRect.setEmpty();
            }
        }
        this.mBlockLayoutRequests = false;
        invokeOnItemScrollListener();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateScrollIndicators() {
        if (this.mScrollLeft != null) {
            boolean z = this.mFirstPosition > 0;
            if (!z && getChildCount() > 0) {
                z = getChildAt(0).getLeft() < this.mListPadding.left;
            }
            this.mScrollLeft.setVisibility(z ? 0 : 4);
        }
        if (this.mScrollRight != null) {
            int childCount = getChildCount();
            boolean z2 = this.mFirstPosition + childCount < this.mItemCount;
            if (!z2 && childCount > 0) {
                z2 = getChildAt(childCount - 1).getRight() > getRight() - this.mListPadding.right;
            }
            this.mScrollRight.setVisibility(z2 ? 0 : 4);
        }
    }

    void updateSelectorState() {
        if (this.mSelector != null) {
            if (shouldShowSelector()) {
                this.mSelector.setState(getDrawableState());
            } else {
                this.mSelector.setState(STATESET_NOTHING);
            }
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return this.mSelector.equals(drawable) || super.verifyDrawable(drawable);
    }

    /* loaded from: classes2.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        public boolean forceAdd;
        public long itemId;
        public boolean recycledHeaderFooter;
        public int scrappedFromPosition;
        public int viewType;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.itemId = -1L;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.itemId = -1L;
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2);
            this.itemId = -1L;
            this.viewType = i3;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.itemId = -1L;
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // it.sephiroth.android.library.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            boolean hasStableIds = this.mAdapter.hasStableIds();
            this.mAdapterHasStableIds = hasStableIds;
            if (this.mChoiceMode != 0 && hasStableIds && this.mCheckedIdStates == null) {
                this.mCheckedIdStates = new LongSparseArray<>();
            }
        }
        h<Boolean> hVar = this.mCheckStates;
        if (hVar != null) {
            hVar.a();
        }
        LongSparseArray<Integer> longSparseArray = this.mCheckedIdStates;
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }

    public void setSelector(Drawable drawable) {
        Drawable drawable2 = this.mSelector;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.mSelector);
        }
        this.mSelector = drawable;
        Rect rect = new Rect();
        drawable.getPadding(rect);
        this.mSelectionLeftPadding = rect.left;
        this.mSelectionTopPadding = rect.top;
        this.mSelectionRightPadding = rect.right;
        this.mSelectionBottomPadding = rect.bottom;
        drawable.setCallback(this);
        updateSelectorState();
    }

    public void smoothScrollBy(int i, int i2, boolean z) {
        if (this.mFlingRunnable == null) {
            this.mFlingRunnable = new FlingRunnable();
        }
        int i3 = this.mFirstPosition;
        int childCount = getChildCount();
        int i4 = i3 + childCount;
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        if (i != 0 && this.mItemCount != 0 && childCount != 0 && ((i3 != 0 || getChildAt(0).getLeft() != paddingLeft || i >= 0) && (i4 != this.mItemCount || getChildAt(childCount - 1).getRight() != width || i <= 0))) {
            reportScrollStateChange(2);
            this.mFlingRunnable.startScroll(i, i2, z);
            return;
        }
        this.mFlingRunnable.endFling();
        PositionScroller positionScroller = this.mPositionScroller;
        if (positionScroller != null) {
            positionScroller.stop();
        }
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void smoothScrollToPosition(int i, int i2) {
        if (this.mPositionScroller == null) {
            this.mPositionScroller = new PositionScroller();
        }
        this.mPositionScroller.start(i, i2);
    }

    public void smoothScrollToPositionFromLeft(int i, int i2) {
        if (this.mPositionScroller == null) {
            this.mPositionScroller = new PositionScroller();
        }
        this.mPositionScroller.startWithOffset(i, i2);
    }

    private void positionSelector(int i, int i2, int i3, int i4) {
        this.mSelectorRect.set(i - this.mSelectionLeftPadding, i2 - this.mSelectionTopPadding, i3 + this.mSelectionRightPadding, i4 + this.mSelectionBottomPadding);
    }

    public AbsHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.zte.iptvclient.android.zala.R.attr.hlv_absHListViewStyle);
    }

    public AbsHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i2;
        boolean z;
        boolean z2;
        int i3;
        int i4;
        boolean z3 = false;
        this.mChoiceMode = 0;
        this.mLayoutMode = 0;
        this.mDrawSelectorOnTop = false;
        this.mSelectorPosition = -1;
        this.mSelectorRect = new Rect();
        this.mRecycler = new RecycleBin();
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mListPadding = new Rect();
        this.mHeightMeasureSpec = 0;
        this.mTouchMode = -1;
        this.mSelectedLeft = 0;
        boolean z4 = true;
        this.mSmoothScrollbarEnabled = true;
        this.mResurrectToPosition = -1;
        Drawable drawable = null;
        this.mContextMenuInfo = null;
        this.mLastTouchMode = -1;
        this.mLastScrollState = 0;
        this.mVelocityScale = 1.0f;
        this.mIsScrap = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        initAbsListView();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.AbsHListView, i, 0);
        if (obtainStyledAttributes != null) {
            drawable = obtainStyledAttributes.getDrawable(0);
            boolean z5 = obtainStyledAttributes.getBoolean(1, false);
            z2 = obtainStyledAttributes.getBoolean(6, false);
            boolean z6 = obtainStyledAttributes.getBoolean(2, true);
            i3 = obtainStyledAttributes.getInt(7, 0);
            i4 = obtainStyledAttributes.getColor(3, 0);
            boolean z7 = obtainStyledAttributes.getBoolean(5, true);
            int i5 = obtainStyledAttributes.getInt(4, 0);
            obtainStyledAttributes.recycle();
            i2 = i5;
            z3 = z5;
            z = z7;
            z4 = z6;
        } else {
            i2 = 0;
            z = true;
            z2 = false;
            i3 = 0;
            i4 = 0;
        }
        if (drawable != null) {
            setSelector(drawable);
        }
        this.mDrawSelectorOnTop = z3;
        setStackFromRight(z2);
        setScrollingCacheEnabled(z4);
        setTranscriptMode(i3);
        setCacheColorHint(i4);
        setSmoothScrollbarEnabled(z);
        setChoiceMode(i2);
    }
}
