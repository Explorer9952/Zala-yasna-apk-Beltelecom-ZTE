package it.sephiroth.android.library.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ArrayAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import android.widget.RemoteViews;
import b.b.h;
import com.ahmobile.android.tvclient.R$styleable;
import com.zte.iptvclient.android.zala.R;
import it.sephiroth.android.library.widget.AbsHListView;
import java.util.ArrayList;

@RemoteViews.RemoteView
/* loaded from: classes2.dex */
public class HListView extends AbsHListView {
    private static final String LOG_TAG = "hListViews";
    private static final float MAX_SCROLL_FACTOR = 0.33f;
    private static final int MIN_SCROLL_PREVIEW_PIXELS = 2;
    static final int NO_POSITION = -1;
    private boolean mAreAllItemsSelectable;
    private final ArrowScrollFocusResult mArrowScrollFocusResult;
    Drawable mDivider;
    private boolean mDividerIsOpaque;
    private Paint mDividerPaint;
    int mDividerWidth;
    private FocusSelector mFocusSelector;
    private boolean mFooterDividersEnabled;
    private ArrayList<FixedViewInfo> mFooterViewInfos;
    private boolean mHeaderDividersEnabled;
    private ArrayList<FixedViewInfo> mHeaderViewInfos;
    private boolean mIsCacheColorOpaque;
    private boolean mItemsCanFocus;
    int mMeasureWithChild;
    Drawable mOverScrollFooter;
    Drawable mOverScrollHeader;
    private final Rect mTempRect;
    private int miLastX;
    private int miLastY;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class ArrowScrollFocusResult {
        private int mAmountToScroll;
        private int mSelectedPosition;

        private ArrowScrollFocusResult() {
        }

        public int getAmountToScroll() {
            return this.mAmountToScroll;
        }

        public int getSelectedPosition() {
            return this.mSelectedPosition;
        }

        void populate(int i, int i2) {
            this.mSelectedPosition = i;
            this.mAmountToScroll = i2;
        }
    }

    /* loaded from: classes2.dex */
    public static class FixedViewInfo {
        public Object data;
        public boolean isSelectable;
        public View view;
    }

    /* loaded from: classes2.dex */
    private class FocusSelector implements Runnable {
        private int mPosition;
        private int mPositionLeft;

        private FocusSelector() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HListView.this.setSelectionFromLeft(this.mPosition, this.mPositionLeft);
        }

        public FocusSelector setup(int i, int i2) {
            this.mPosition = i;
            this.mPositionLeft = i2;
            return this;
        }
    }

    public HListView(Context context) {
        this(context, null);
    }

    private View addViewAfter(View view, int i) {
        int i2 = i + 1;
        View obtainView = obtainView(i2, this.mIsScrap);
        setupChild(obtainView, i2, view.getRight() + this.mDividerWidth, true, this.mListPadding.top, false, this.mIsScrap[0]);
        return obtainView;
    }

    private View addViewBefore(View view, int i) {
        int i2 = i - 1;
        View obtainView = obtainView(i2, this.mIsScrap);
        setupChild(obtainView, i2, view.getLeft() - this.mDividerWidth, false, this.mListPadding.top, false, this.mIsScrap[0]);
        return obtainView;
    }

    private void adjustViewsLeftOrRight() {
        int childCount = getChildCount();
        if (childCount > 0) {
            int i = 0;
            if (!this.mStackFromRight) {
                int left = getChildAt(0).getLeft() - this.mListPadding.left;
                if (this.mFirstPosition != 0) {
                    left -= this.mDividerWidth;
                }
                if (left >= 0) {
                    i = left;
                }
            } else {
                int right = getChildAt(childCount - 1).getRight() - (getWidth() - this.mListPadding.right);
                if (this.mFirstPosition + childCount < this.mItemCount) {
                    right += this.mDividerWidth;
                }
                if (right <= 0) {
                    i = right;
                }
            }
            if (i != 0) {
                offsetChildrenLeftAndRight(-i);
            }
        }
    }

    private int amountToScroll(int i, int i2) {
        int width = getWidth();
        Rect rect = this.mListPadding;
        int i3 = width - rect.right;
        int i4 = rect.left;
        int childCount = getChildCount();
        if (i == 130) {
            int i5 = childCount - 1;
            int i6 = i2 != -1 ? i2 - this.mFirstPosition : i5;
            int i7 = this.mFirstPosition + i6;
            View childAt = getChildAt(i6);
            int arrowScrollPreviewLength = i7 < this.mItemCount + (-1) ? i3 - getArrowScrollPreviewLength() : i3;
            if (childAt.getRight() <= arrowScrollPreviewLength) {
                return 0;
            }
            if (i2 != -1 && arrowScrollPreviewLength - childAt.getLeft() >= getMaxScrollAmount()) {
                return 0;
            }
            int right = childAt.getRight() - arrowScrollPreviewLength;
            if (this.mFirstPosition + childCount == this.mItemCount) {
                right = Math.min(right, getChildAt(i5).getRight() - i3);
            }
            return Math.min(right, getMaxScrollAmount());
        }
        int i8 = i2 != -1 ? i2 - this.mFirstPosition : 0;
        int i9 = this.mFirstPosition + i8;
        View childAt2 = getChildAt(i8);
        int arrowScrollPreviewLength2 = i9 > 0 ? getArrowScrollPreviewLength() + i4 : i4;
        if (childAt2.getLeft() >= arrowScrollPreviewLength2) {
            return 0;
        }
        if (i2 != -1 && childAt2.getRight() - arrowScrollPreviewLength2 >= getMaxScrollAmount()) {
            return 0;
        }
        int left = arrowScrollPreviewLength2 - childAt2.getLeft();
        if (this.mFirstPosition == 0) {
            left = Math.min(left, i4 - getChildAt(0).getLeft());
        }
        return Math.min(left, getMaxScrollAmount());
    }

    private int amountToScrollToNewFocus(int i, View view, int i2) {
        int i3;
        int arrowScrollPreviewLength;
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        if (i == 33) {
            int i4 = this.mTempRect.left;
            int i5 = this.mListPadding.left;
            if (i4 < i5) {
                i3 = i5 - i4;
                if (i2 <= 0) {
                    return i3;
                }
                arrowScrollPreviewLength = getArrowScrollPreviewLength();
                return i3 + arrowScrollPreviewLength;
            }
            return 0;
        }
        int width = getWidth() - this.mListPadding.right;
        Rect rect = this.mTempRect;
        if (rect.bottom > width) {
            i3 = rect.right - width;
            if (i2 >= this.mItemCount - 1) {
                return i3;
            }
            arrowScrollPreviewLength = getArrowScrollPreviewLength();
            return i3 + arrowScrollPreviewLength;
        }
        return 0;
    }

    private ArrowScrollFocusResult arrowScrollFocused(int i) {
        View findNextFocusFromRect;
        int lookForSelectablePositionOnScreen;
        View selectedView = getSelectedView();
        if (selectedView != null && selectedView.hasFocus()) {
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocus(this, selectedView.findFocus(), i);
        } else {
            if (i == 130) {
                int arrowScrollPreviewLength = this.mListPadding.left + (this.mFirstPosition > 0 ? getArrowScrollPreviewLength() : 0);
                if (selectedView != null && selectedView.getLeft() > arrowScrollPreviewLength) {
                    arrowScrollPreviewLength = selectedView.getLeft();
                }
                this.mTempRect.set(arrowScrollPreviewLength, 0, arrowScrollPreviewLength, 0);
            } else {
                int width = (getWidth() - this.mListPadding.right) - ((this.mFirstPosition + getChildCount()) - 1 < this.mItemCount ? getArrowScrollPreviewLength() : 0);
                if (selectedView != null && selectedView.getRight() < width) {
                    width = selectedView.getRight();
                }
                this.mTempRect.set(width, 0, width, 0);
            }
            findNextFocusFromRect = FocusFinder.getInstance().findNextFocusFromRect(this, this.mTempRect, i);
        }
        if (findNextFocusFromRect != null) {
            int positionOfNewFocus = positionOfNewFocus(findNextFocusFromRect);
            int i2 = this.mSelectedPosition;
            if (i2 != -1 && positionOfNewFocus != i2 && (lookForSelectablePositionOnScreen = lookForSelectablePositionOnScreen(i)) != -1 && ((i == 130 && lookForSelectablePositionOnScreen < positionOfNewFocus) || (i == 33 && lookForSelectablePositionOnScreen > positionOfNewFocus))) {
                return null;
            }
            int amountToScrollToNewFocus = amountToScrollToNewFocus(i, findNextFocusFromRect, positionOfNewFocus);
            int maxScrollAmount = getMaxScrollAmount();
            if (amountToScrollToNewFocus < maxScrollAmount) {
                findNextFocusFromRect.requestFocus(i);
                this.mArrowScrollFocusResult.populate(positionOfNewFocus, amountToScrollToNewFocus);
                return this.mArrowScrollFocusResult;
            }
            if (distanceToView(findNextFocusFromRect) < maxScrollAmount) {
                findNextFocusFromRect.requestFocus(i);
                this.mArrowScrollFocusResult.populate(positionOfNewFocus, maxScrollAmount);
                return this.mArrowScrollFocusResult;
            }
        }
        return null;
    }

    private boolean arrowScrollImpl(int i) {
        View findFocus;
        View focusedChild;
        if (getChildCount() <= 0) {
            return false;
        }
        View selectedView = getSelectedView();
        int i2 = this.mSelectedPosition;
        int lookForSelectablePositionOnScreen = lookForSelectablePositionOnScreen(i);
        int amountToScroll = amountToScroll(i, lookForSelectablePositionOnScreen);
        View view = null;
        ArrowScrollFocusResult arrowScrollFocused = this.mItemsCanFocus ? arrowScrollFocused(i) : null;
        if (arrowScrollFocused != null) {
            lookForSelectablePositionOnScreen = arrowScrollFocused.getSelectedPosition();
            amountToScroll = arrowScrollFocused.getAmountToScroll();
        }
        boolean z = arrowScrollFocused != null;
        if (lookForSelectablePositionOnScreen != -1) {
            handleNewSelectionChange(selectedView, i, lookForSelectablePositionOnScreen, arrowScrollFocused != null);
            setSelectedPositionInt(lookForSelectablePositionOnScreen);
            setNextSelectedPositionInt(lookForSelectablePositionOnScreen);
            selectedView = getSelectedView();
            if (this.mItemsCanFocus && arrowScrollFocused == null && (focusedChild = getFocusedChild()) != null) {
                focusedChild.clearFocus();
            }
            checkSelectionChanged();
            i2 = lookForSelectablePositionOnScreen;
            z = true;
        }
        if (amountToScroll > 0) {
            if (i != 33) {
                amountToScroll = -amountToScroll;
            }
            scrollListItemsBy(amountToScroll);
            z = true;
        }
        if (this.mItemsCanFocus && arrowScrollFocused == null && selectedView != null && selectedView.hasFocus() && (findFocus = selectedView.findFocus()) != null && (!isViewAncestorOf(findFocus, this) || distanceToView(findFocus) > 0)) {
            findFocus.clearFocus();
        }
        if (lookForSelectablePositionOnScreen != -1 || selectedView == null || isViewAncestorOf(selectedView, this)) {
            view = selectedView;
        } else {
            hideSelector();
            this.mResurrectToPosition = -1;
        }
        if (!z) {
            return false;
        }
        if (view != null) {
            positionSelector(i2, view);
            this.mSelectedLeft = view.getLeft();
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        invokeOnItemScrollListener();
        return true;
    }

    private void clearRecycledState(ArrayList<FixedViewInfo> arrayList) {
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                AbsHListView.LayoutParams layoutParams = (AbsHListView.LayoutParams) arrayList.get(i).view.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.recycledHeaderFooter = false;
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x006e, code lost:
    
        if (fullScroll(130) != false) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x009e, code lost:
    
        if (fullScroll(33) != false) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x00ca, code lost:
    
        if (fullScroll(130) != false) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x00de, code lost:
    
        if (fullScroll(33) != false) goto L120;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x014e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x014f  */
    @android.annotation.TargetApi(11)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean commonKey(int r8, int r9, android.view.KeyEvent r10) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: it.sephiroth.android.library.widget.HListView.commonKey(int, int, android.view.KeyEvent):boolean");
    }

    private void correctTooSmall(int i) {
        if (this.mFirstPosition != 0 || i <= 0) {
            return;
        }
        int left = getChildAt(0).getLeft();
        int i2 = this.mListPadding.left;
        int right = (getRight() - getLeft()) - this.mListPadding.right;
        int i3 = left - i2;
        View childAt = getChildAt(i - 1);
        int right2 = childAt.getRight();
        int i4 = (this.mFirstPosition + i) - 1;
        if (i3 > 0) {
            int i5 = this.mItemCount;
            if (i4 >= i5 - 1 && right2 <= right) {
                if (i4 == i5 - 1) {
                    adjustViewsLeftOrRight();
                    return;
                }
                return;
            }
            if (i4 == this.mItemCount - 1) {
                i3 = Math.min(i3, right2 - right);
            }
            offsetChildrenLeftAndRight(-i3);
            if (i4 < this.mItemCount - 1) {
                fillRight(i4 + 1, childAt.getRight() + this.mDividerWidth);
                adjustViewsLeftOrRight();
            }
        }
    }

    private void correctTooWide(int i) {
        if ((this.mFirstPosition + i) - 1 != this.mItemCount - 1 || i <= 0) {
            return;
        }
        int right = ((getRight() - getLeft()) - this.mListPadding.right) - getChildAt(i - 1).getRight();
        View childAt = getChildAt(0);
        int left = childAt.getLeft();
        if (right > 0) {
            if (this.mFirstPosition > 0 || left < this.mListPadding.top) {
                if (this.mFirstPosition == 0) {
                    right = Math.min(right, this.mListPadding.top - left);
                }
                offsetChildrenLeftAndRight(right);
                int i2 = this.mFirstPosition;
                if (i2 > 0) {
                    fillLeft(i2 - 1, childAt.getLeft() - this.mDividerWidth);
                    adjustViewsLeftOrRight();
                }
            }
        }
    }

    private int distanceToView(View view) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        int right = getRight() - getLeft();
        Rect rect = this.mListPadding;
        int i = right - rect.right;
        Rect rect2 = this.mTempRect;
        int i2 = rect2.right;
        int i3 = rect.left;
        if (i2 < i3) {
            return i3 - i2;
        }
        int i4 = rect2.left;
        if (i4 > i) {
            return i4 - i;
        }
        return 0;
    }

    private void fillBeforeAndAfter(View view, int i) {
        int i2 = this.mDividerWidth;
        if (!this.mStackFromRight) {
            fillLeft(i - 1, view.getLeft() - i2);
            adjustViewsLeftOrRight();
            fillRight(i + 1, view.getRight() + i2);
        } else {
            fillRight(i + 1, view.getRight() + i2);
            adjustViewsLeftOrRight();
            fillLeft(i - 1, view.getLeft() - i2);
        }
    }

    private View fillFromLeft(int i) {
        int min = Math.min(this.mFirstPosition, this.mSelectedPosition);
        this.mFirstPosition = min;
        int min2 = Math.min(min, this.mItemCount - 1);
        this.mFirstPosition = min2;
        if (min2 < 0) {
            this.mFirstPosition = 0;
        }
        return fillRight(this.mFirstPosition, i);
    }

    private View fillFromMiddle(int i, int i2) {
        int i3 = i2 - i;
        int reconcileSelectedPosition = reconcileSelectedPosition();
        View makeAndAddView = makeAndAddView(reconcileSelectedPosition, i, true, this.mListPadding.top, true);
        this.mFirstPosition = reconcileSelectedPosition;
        int measuredWidth = makeAndAddView.getMeasuredWidth();
        if (measuredWidth <= i3) {
            makeAndAddView.offsetLeftAndRight((i3 - measuredWidth) / 2);
        }
        fillBeforeAndAfter(makeAndAddView, reconcileSelectedPosition);
        if (!this.mStackFromRight) {
            correctTooWide(getChildCount());
        } else {
            correctTooSmall(getChildCount());
        }
        return makeAndAddView;
    }

    private View fillFromSelection(int i, int i2, int i3) {
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int i4 = this.mSelectedPosition;
        int leftSelectionPixel = getLeftSelectionPixel(i2, horizontalFadingEdgeLength, i4);
        int rightSelectionPixel = getRightSelectionPixel(i3, horizontalFadingEdgeLength, i4);
        View makeAndAddView = makeAndAddView(i4, i, true, this.mListPadding.top, true);
        if (makeAndAddView.getRight() > rightSelectionPixel) {
            makeAndAddView.offsetLeftAndRight(-Math.min(makeAndAddView.getLeft() - leftSelectionPixel, makeAndAddView.getRight() - rightSelectionPixel));
        } else if (makeAndAddView.getLeft() < leftSelectionPixel) {
            makeAndAddView.offsetLeftAndRight(Math.min(leftSelectionPixel - makeAndAddView.getLeft(), rightSelectionPixel - makeAndAddView.getRight()));
        }
        fillBeforeAndAfter(makeAndAddView, i4);
        if (!this.mStackFromRight) {
            correctTooWide(getChildCount());
        } else {
            correctTooSmall(getChildCount());
        }
        return makeAndAddView;
    }

    private View fillLeft(int i, int i2) {
        View view = null;
        int i3 = i2;
        while (true) {
            if (i3 <= 0 || i < 0) {
                break;
            }
            boolean z = i == this.mSelectedPosition;
            View makeAndAddView = makeAndAddView(i, i3, false, this.mListPadding.top, z);
            i3 = makeAndAddView.getLeft() - this.mDividerWidth;
            if (z) {
                view = makeAndAddView;
            }
            i--;
        }
        int i4 = i + 1;
        this.mFirstPosition = i4;
        setVisibleRangeHint(i4, (getChildCount() + i4) - 1);
        return view;
    }

    private View fillRight(int i, int i2) {
        int right = getRight() - getLeft();
        View view = null;
        int i3 = i2;
        while (true) {
            if (i3 >= right || i >= this.mItemCount) {
                break;
            }
            boolean z = i == this.mSelectedPosition;
            View makeAndAddView = makeAndAddView(i, i3, true, this.mListPadding.top, z);
            i3 = this.mDividerWidth + makeAndAddView.getRight();
            if (z) {
                view = makeAndAddView;
            }
            i++;
        }
        int i4 = this.mFirstPosition;
        setVisibleRangeHint(i4, (getChildCount() + i4) - 1);
        return view;
    }

    private View fillSpecific(int i, int i2) {
        View view;
        View view2;
        boolean z = i == this.mSelectedPosition;
        View makeAndAddView = makeAndAddView(i, i2, true, this.mListPadding.top, z);
        this.mFirstPosition = i;
        int i3 = this.mDividerWidth;
        if (!this.mStackFromRight) {
            view = fillLeft(i - 1, makeAndAddView.getLeft() - i3);
            adjustViewsLeftOrRight();
            view2 = fillRight(i + 1, makeAndAddView.getRight() + i3);
            int childCount = getChildCount();
            if (childCount > 0) {
                correctTooWide(childCount);
            }
        } else {
            View fillRight = fillRight(i + 1, makeAndAddView.getRight() + i3);
            adjustViewsLeftOrRight();
            View fillLeft = fillLeft(i - 1, makeAndAddView.getLeft() - i3);
            int childCount2 = getChildCount();
            if (childCount2 > 0) {
                correctTooSmall(childCount2);
            }
            view = fillLeft;
            view2 = fillRight;
        }
        return z ? makeAndAddView : view != null ? view : view2;
    }

    private int getArrowScrollPreviewLength() {
        return Math.max(2, getHorizontalFadingEdgeLength());
    }

    private int getLeftSelectionPixel(int i, int i2, int i3) {
        return i3 > 0 ? i + i2 : i;
    }

    private int getRightSelectionPixel(int i, int i2, int i3) {
        return i3 != this.mItemCount + (-1) ? i - i2 : i;
    }

    private boolean handleHorizontalFocusWithinListItem(int i) {
        View selectedView;
        View findNextFocus;
        if (i != 33 && i != 130) {
            throw new IllegalArgumentException("direction must be one of {View.FOCUS_UP, View.FOCUS_DOWN}");
        }
        int childCount = getChildCount();
        if (!this.mItemsCanFocus || childCount <= 0 || this.mSelectedPosition == -1 || (selectedView = getSelectedView()) == null || !selectedView.hasFocus() || !(selectedView instanceof ViewGroup)) {
            return false;
        }
        View findFocus = selectedView.findFocus();
        if (findFocus != null && (findNextFocus = FocusFinder.getInstance().findNextFocus((ViewGroup) selectedView, findFocus, i)) != null) {
            findFocus.getFocusedRect(this.mTempRect);
            offsetDescendantRectToMyCoords(findFocus, this.mTempRect);
            offsetRectIntoDescendantCoords(findNextFocus, this.mTempRect);
            if (findNextFocus.requestFocus(i, this.mTempRect)) {
                return true;
            }
        }
        View findNextFocus2 = FocusFinder.getInstance().findNextFocus((ViewGroup) getRootView(), findFocus, i);
        if (findNextFocus2 != null) {
            return isViewAncestorOf(findNextFocus2, this);
        }
        return false;
    }

    private void handleNewSelectionChange(View view, int i, int i2, boolean z) {
        View childAt;
        boolean z2;
        if (i2 != -1) {
            int i3 = this.mSelectedPosition;
            int i4 = this.mFirstPosition;
            int i5 = i3 - i4;
            int i6 = i2 - i4;
            if (i == 33) {
                z2 = true;
                childAt = view;
                view = getChildAt(i6);
                i5 = i6;
                i6 = i5;
            } else {
                childAt = getChildAt(i6);
                z2 = false;
            }
            int childCount = getChildCount();
            if (view != null) {
                view.setSelected(!z && z2);
                measureAndAdjustRight(view, i5, childCount);
            }
            if (childAt != null) {
                childAt.setSelected((z || z2) ? false : true);
                measureAndAdjustRight(childAt, i6, childCount);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("newSelectedPosition needs to be valid");
    }

    private boolean isDirectChildHeaderOrFooter(View view) {
        ArrayList<FixedViewInfo> arrayList = this.mHeaderViewInfos;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (view.equals(arrayList.get(i).view)) {
                return true;
            }
        }
        ArrayList<FixedViewInfo> arrayList2 = this.mFooterViewInfos;
        int size2 = arrayList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (view.equals(arrayList2.get(i2).view)) {
                return true;
            }
        }
        return false;
    }

    private boolean isViewAncestorOf(View view, View view2) {
        if (view.equals(view2)) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && isViewAncestorOf((View) parent, view2);
    }

    private int lookForSelectablePositionOnScreen(int i) {
        int i2 = this.mFirstPosition;
        if (i == 130) {
            int i3 = this.mSelectedPosition;
            int i4 = i3 != -1 ? i3 + 1 : i2;
            if (i4 >= this.mAdapter.getCount()) {
                return -1;
            }
            if (i4 < i2) {
                i4 = i2;
            }
            int lastVisiblePosition = getLastVisiblePosition();
            ListAdapter adapter = getAdapter();
            while (i4 <= lastVisiblePosition) {
                if (adapter.isEnabled(i4) && getChildAt(i4 - i2).getVisibility() == 0) {
                    return i4;
                }
                i4++;
            }
        } else {
            int childCount = (getChildCount() + i2) - 1;
            int i5 = this.mSelectedPosition;
            if (i5 == -1) {
                i5 = getChildCount() + i2;
            }
            int i6 = i5 - 1;
            if (i6 >= 0 && i6 < this.mAdapter.getCount()) {
                if (i6 <= childCount) {
                    childCount = i6;
                }
                ListAdapter adapter2 = getAdapter();
                while (childCount >= i2) {
                    if (adapter2.isEnabled(childCount) && getChildAt(childCount - i2).getVisibility() == 0) {
                        return childCount;
                    }
                    childCount--;
                }
            }
        }
        return -1;
    }

    private View makeAndAddView(int i, int i2, boolean z, int i3, boolean z2) {
        View activeView;
        if (!this.mDataChanged && (activeView = this.mRecycler.getActiveView(i)) != null) {
            setupChild(activeView, i, i2, z, i3, z2, true);
            return activeView;
        }
        View obtainView = obtainView(i, this.mIsScrap);
        setupChild(obtainView, i, i2, z, i3, z2, this.mIsScrap[0]);
        return obtainView;
    }

    private void measureAndAdjustRight(View view, int i, int i2) {
        int width = view.getWidth();
        measureItem(view);
        if (view.getMeasuredWidth() == width) {
            return;
        }
        relayoutMeasuredItem(view);
        int measuredWidth = view.getMeasuredWidth() - width;
        while (true) {
            i++;
            if (i >= i2) {
                return;
            } else {
                getChildAt(i).offsetLeftAndRight(measuredWidth);
            }
        }
    }

    private void measureItem(View view) {
        int makeMeasureSpec;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -1);
        }
        int i = this.mHeightMeasureSpec;
        Rect rect = this.mListPadding;
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, rect.top + rect.bottom, layoutParams.height);
        int i2 = layoutParams.width;
        if (i2 > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(makeMeasureSpec, childMeasureSpec);
    }

    private void measureScrapChildWidth(View view, int i, int i2) {
        int makeMeasureSpec;
        AbsHListView.LayoutParams layoutParams = (AbsHListView.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (AbsHListView.LayoutParams) generateDefaultLayoutParams();
            view.setLayoutParams(layoutParams);
        }
        layoutParams.viewType = this.mAdapter.getItemViewType(i);
        layoutParams.forceAdd = true;
        Rect rect = this.mListPadding;
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, rect.top + rect.bottom, ((ViewGroup.LayoutParams) layoutParams).height);
        int i3 = ((ViewGroup.LayoutParams) layoutParams).width;
        if (i3 > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(makeMeasureSpec, childMeasureSpec);
    }

    private View moveSelection(View view, View view2, int i, int i2, int i3) {
        View makeAndAddView;
        View makeAndAddView2;
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        int i4 = this.mSelectedPosition;
        int leftSelectionPixel = getLeftSelectionPixel(i2, horizontalFadingEdgeLength, i4);
        int rightSelectionPixel = getRightSelectionPixel(i2, horizontalFadingEdgeLength, i4);
        if (i > 0) {
            View makeAndAddView3 = makeAndAddView(i4 - 1, view.getLeft(), true, this.mListPadding.top, false);
            int i5 = this.mDividerWidth;
            makeAndAddView = makeAndAddView(i4, makeAndAddView3.getRight() + i5, true, this.mListPadding.top, true);
            if (makeAndAddView.getRight() > rightSelectionPixel) {
                int i6 = -Math.min(Math.min(makeAndAddView.getLeft() - leftSelectionPixel, makeAndAddView.getRight() - rightSelectionPixel), (i3 - i2) / 2);
                makeAndAddView3.offsetLeftAndRight(i6);
                makeAndAddView.offsetLeftAndRight(i6);
            }
            if (!this.mStackFromRight) {
                fillLeft(this.mSelectedPosition - 2, makeAndAddView.getLeft() - i5);
                adjustViewsLeftOrRight();
                fillRight(this.mSelectedPosition + 1, makeAndAddView.getRight() + i5);
            } else {
                fillRight(this.mSelectedPosition + 1, makeAndAddView.getRight() + i5);
                adjustViewsLeftOrRight();
                fillLeft(this.mSelectedPosition - 2, makeAndAddView.getLeft() - i5);
            }
        } else if (i < 0) {
            if (view2 != null) {
                makeAndAddView2 = makeAndAddView(i4, view2.getLeft(), true, this.mListPadding.top, true);
            } else {
                makeAndAddView2 = makeAndAddView(i4, view.getLeft(), false, this.mListPadding.top, true);
            }
            makeAndAddView = makeAndAddView2;
            if (makeAndAddView.getLeft() < leftSelectionPixel) {
                makeAndAddView.offsetLeftAndRight(Math.min(Math.min(leftSelectionPixel - makeAndAddView.getLeft(), rightSelectionPixel - makeAndAddView.getRight()), (i3 - i2) / 2));
            }
            fillBeforeAndAfter(makeAndAddView, i4);
        } else {
            int left = view.getLeft();
            makeAndAddView = makeAndAddView(i4, left, true, this.mListPadding.top, true);
            if (left < i2 && makeAndAddView.getRight() < i2 + 20) {
                makeAndAddView.offsetLeftAndRight(i2 - makeAndAddView.getLeft());
            }
            fillBeforeAndAfter(makeAndAddView, i4);
        }
        return makeAndAddView;
    }

    private int positionOfNewFocus(View view) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (isViewAncestorOf(view, getChildAt(i))) {
                return this.mFirstPosition + i;
            }
        }
        throw new IllegalArgumentException("newFocus is not a child of any of the children of the list!");
    }

    private void relayoutMeasuredItem(View view) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i = this.mListPadding.top;
        int left = view.getLeft();
        view.layout(left, i, measuredWidth + left, measuredHeight + i);
    }

    private void removeFixedViewInfo(View view, ArrayList<FixedViewInfo> arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i).view.equals(view)) {
                arrayList.remove(i);
                return;
            }
        }
    }

    private void scrollListItemsBy(int i) {
        int i2;
        int i3;
        offsetChildrenLeftAndRight(i);
        int width = getWidth();
        Rect rect = this.mListPadding;
        int i4 = width - rect.right;
        int i5 = rect.left;
        AbsHListView.RecycleBin recycleBin = this.mRecycler;
        if (i < 0) {
            int childCount = getChildCount();
            View childAt = getChildAt(childCount - 1);
            while (childAt.getRight() < i4 && (this.mFirstPosition + childCount) - 1 < this.mItemCount - 1) {
                childAt = addViewAfter(childAt, i3);
                childCount++;
            }
            if (childAt.getBottom() < i4) {
                offsetChildrenLeftAndRight(i4 - childAt.getRight());
            }
            View childAt2 = getChildAt(0);
            while (childAt2.getRight() < i5) {
                AbsHListView.LayoutParams layoutParams = (AbsHListView.LayoutParams) childAt2.getLayoutParams();
                if (layoutParams != null && recycleBin.shouldRecycleViewType(layoutParams.viewType)) {
                    detachViewFromParent(childAt2);
                    recycleBin.addScrapView(childAt2, this.mFirstPosition);
                } else {
                    removeViewInLayout(childAt2);
                }
                childAt2 = getChildAt(0);
                this.mFirstPosition++;
            }
            return;
        }
        View childAt3 = getChildAt(0);
        while (childAt3.getLeft() > i5 && (i2 = this.mFirstPosition) > 0) {
            childAt3 = addViewBefore(childAt3, i2);
            this.mFirstPosition--;
        }
        if (childAt3.getLeft() > i5) {
            offsetChildrenLeftAndRight(i5 - childAt3.getLeft());
        }
        int childCount2 = getChildCount() - 1;
        View childAt4 = getChildAt(childCount2);
        while (childAt4.getLeft() > i4) {
            AbsHListView.LayoutParams layoutParams2 = (AbsHListView.LayoutParams) childAt4.getLayoutParams();
            if (layoutParams2 != null && recycleBin.shouldRecycleViewType(layoutParams2.viewType)) {
                detachViewFromParent(childAt4);
                recycleBin.addScrapView(childAt4, this.mFirstPosition + childCount2);
            } else {
                removeViewInLayout(childAt4);
            }
            childCount2--;
            childAt4 = getChildAt(childCount2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @TargetApi(11)
    private void setupChild(View view, int i, int i2, boolean z, int i3, boolean z2, boolean z3) {
        AbsHListView.LayoutParams layoutParams;
        int makeMeasureSpec;
        h<Boolean> hVar;
        boolean z4 = z2 && shouldShowSelector();
        boolean z5 = z4 != view.isSelected();
        int i4 = this.mTouchMode;
        boolean z6 = i4 > 0 && i4 < 3 && this.mMotionPosition == i;
        boolean z7 = z6 != view.isPressed();
        boolean z8 = !z3 || z5 || view.isLayoutRequested();
        AbsHListView.LayoutParams layoutParams2 = (AbsHListView.LayoutParams) view.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = (AbsHListView.LayoutParams) generateDefaultLayoutParams();
        }
        layoutParams2.viewType = this.mAdapter.getItemViewType(i);
        if ((z3 && !layoutParams2.forceAdd) || (layoutParams2.recycledHeaderFooter && layoutParams2.viewType == -2)) {
            attachViewToParent(view, z ? -1 : 0, layoutParams2);
        } else {
            layoutParams2.forceAdd = false;
            if (layoutParams2.viewType == -2) {
                layoutParams2.recycledHeaderFooter = true;
            }
            addViewInLayout(view, z ? -1 : 0, layoutParams2, true);
        }
        if (z5) {
            view.setSelected(z4);
        }
        if (z7) {
            view.setPressed(z6);
        }
        if (this.mChoiceMode != 0 && (hVar = this.mCheckStates) != null) {
            if (view instanceof Checkable) {
                ((Checkable) view).setChecked(hVar.b(i, false).booleanValue());
            } else if (Build.VERSION.SDK_INT >= 11) {
                view.setActivated(hVar.b(i, false).booleanValue());
            }
        }
        if (z8) {
            int i5 = this.mHeightMeasureSpec;
            Rect rect = this.mListPadding;
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i5, rect.top + rect.bottom, ((ViewGroup.LayoutParams) layoutParams2).height);
            int i6 = ((ViewGroup.LayoutParams) layoutParams2).width;
            if (i6 > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(makeMeasureSpec, childMeasureSpec);
        } else {
            cleanupLayoutState(view);
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i7 = z ? i2 : i2 - measuredWidth;
        if (z8) {
            view.layout(i7, i3, measuredWidth + i7, measuredHeight + i3);
        } else {
            view.offsetLeftAndRight(i7 - view.getLeft());
            view.offsetTopAndBottom(i3 - view.getTop());
        }
        if (this.mCachingStarted && !view.isDrawingCacheEnabled()) {
            view.setDrawingCacheEnabled(true);
        }
        if (Build.VERSION.SDK_INT < 11 || (layoutParams = (AbsHListView.LayoutParams) view.getLayoutParams()) == null || !z3 || layoutParams.scrappedFromPosition == i) {
            return;
        }
        view.jumpDrawablesToCurrentState();
    }

    private boolean showingLeftFadingEdge() {
        return this.mFirstPosition > 0 || getChildAt(0).getLeft() > getScrollX() + this.mListPadding.left;
    }

    private boolean showingRightFadingEdge() {
        int childCount = getChildCount();
        return (this.mFirstPosition + childCount) - 1 < this.mItemCount - 1 || getChildAt(childCount + (-1)).getRight() < (getScrollX() + getWidth()) - this.mListPadding.right;
    }

    public void addFooterView(View view, Object obj, boolean z) {
        AbsHListView.AdapterDataSetObserver adapterDataSetObserver;
        FixedViewInfo fixedViewInfo = new FixedViewInfo();
        fixedViewInfo.view = view;
        fixedViewInfo.data = obj;
        fixedViewInfo.isSelectable = z;
        this.mFooterViewInfos.add(fixedViewInfo);
        if (this.mAdapter == null || (adapterDataSetObserver = this.mDataSetObserver) == null) {
            return;
        }
        adapterDataSetObserver.onChanged();
    }

    public void addHeaderView(View view, Object obj, boolean z) {
        AbsHListView.AdapterDataSetObserver adapterDataSetObserver;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null && !(listAdapter instanceof HeaderViewListAdapter)) {
            throw new IllegalStateException("Cannot add header view to list -- setAdapter has already been called.");
        }
        FixedViewInfo fixedViewInfo = new FixedViewInfo();
        fixedViewInfo.view = view;
        fixedViewInfo.data = obj;
        fixedViewInfo.isSelectable = z;
        this.mHeaderViewInfos.add(fixedViewInfo);
        if (this.mAdapter == null || (adapterDataSetObserver = this.mDataSetObserver) == null) {
            return;
        }
        adapterDataSetObserver.onChanged();
    }

    boolean arrowScroll(int i) {
        try {
            this.mInLayout = true;
            boolean arrowScrollImpl = arrowScrollImpl(i);
            if (arrowScrollImpl) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
            }
            return arrowScrollImpl;
        } finally {
            this.mInLayout = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // it.sephiroth.android.library.widget.AdapterView, android.view.ViewGroup
    public boolean canAnimate() {
        return super.canAnimate() && this.mItemCount > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01be, code lost:
    
        if (r8.isEnabled(r3 + 1) == false) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0117, code lost:
    
        if (r8.isEnabled(r7 + 1) == false) goto L70;
     */
    @Override // it.sephiroth.android.library.widget.AbsHListView, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void dispatchDraw(android.graphics.Canvas r25) {
        /*
            Method dump skipped, instructions count: 519
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: it.sephiroth.android.library.widget.HListView.dispatchDraw(android.graphics.Canvas):void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        return (dispatchKeyEvent || getFocusedChild() == null || keyEvent.getAction() != 0) ? dispatchKeyEvent : onKeyDown(keyEvent.getKeyCode(), keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 2) {
            if (Math.abs(x - this.miLastX) < Math.abs(y - this.miLastY)) {
                getParent().requestDisallowInterceptTouchEvent(false);
            } else {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        }
        this.miLastX = x;
        this.miLastY = y;
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild = super.drawChild(canvas, view, j);
        if (this.mCachingActive) {
            this.mCachingActive = false;
        }
        return drawChild;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        Drawable drawable = this.mDivider;
        if (drawable != null) {
            drawable.setBounds(rect);
            drawable.draw(canvas);
        }
    }

    void drawOverscrollFooter(Canvas canvas, Drawable drawable, Rect rect) {
        int minimumWidth = drawable.getMinimumWidth();
        canvas.save();
        canvas.clipRect(rect);
        int i = rect.right;
        int i2 = rect.left;
        if (i - i2 < minimumWidth) {
            rect.right = i2 + minimumWidth;
        }
        drawable.setBounds(rect);
        drawable.draw(canvas);
        canvas.restore();
    }

    void drawOverscrollHeader(Canvas canvas, Drawable drawable, Rect rect) {
        int minimumWidth = drawable.getMinimumWidth();
        canvas.save();
        canvas.clipRect(rect);
        int i = rect.right;
        if (i - rect.left < minimumWidth) {
            rect.left = i - minimumWidth;
        }
        drawable.setBounds(rect);
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // it.sephiroth.android.library.widget.AbsHListView
    protected void fillGap(boolean z) {
        int childCount = getChildCount();
        if (z) {
            fillRight(this.mFirstPosition + childCount, childCount > 0 ? this.mDividerWidth + getChildAt(childCount - 1).getRight() : 0);
            correctTooWide(getChildCount());
        } else {
            fillLeft(this.mFirstPosition - 1, childCount > 0 ? getChildAt(0).getLeft() - this.mDividerWidth : getWidth() - 0);
            correctTooSmall(getChildCount());
        }
    }

    @Override // it.sephiroth.android.library.widget.AbsHListView
    protected int findMotionCol(int i) {
        int childCount = getChildCount();
        if (childCount <= 0) {
            return -1;
        }
        if (this.mStackFromRight) {
            for (int i2 = childCount - 1; i2 >= 0; i2--) {
                if (i >= getChildAt(i2).getLeft()) {
                    return this.mFirstPosition + i2;
                }
            }
            return -1;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            if (i <= getChildAt(i3).getRight()) {
                return this.mFirstPosition + i3;
            }
        }
        return -1;
    }

    boolean fullScroll(int i) {
        boolean z = false;
        if (i == 33) {
            if (this.mSelectedPosition != 0) {
                int lookForSelectablePosition = lookForSelectablePosition(0, true);
                if (lookForSelectablePosition >= 0) {
                    this.mLayoutMode = 1;
                    setSelectionInt(lookForSelectablePosition);
                    invokeOnItemScrollListener();
                }
                z = true;
            }
        } else if (i == 130) {
            int i2 = this.mSelectedPosition;
            int i3 = this.mItemCount;
            if (i2 < i3 - 1) {
                int lookForSelectablePosition2 = lookForSelectablePosition(i3 - 1, true);
                if (lookForSelectablePosition2 >= 0) {
                    this.mLayoutMode = 3;
                    setSelectionInt(lookForSelectablePosition2);
                    invokeOnItemScrollListener();
                }
                z = true;
            }
        }
        if (z && !awakenScrollBars()) {
            awakenScrollBars();
            invalidate();
        }
        return z;
    }

    @Deprecated
    public long[] getCheckItemIds() {
        h<Boolean> hVar;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null && listAdapter.hasStableIds()) {
            return getCheckedItemIds();
        }
        if (this.mChoiceMode == 0 || (hVar = this.mCheckStates) == null || this.mAdapter == null) {
            return new long[0];
        }
        int b2 = hVar.b();
        long[] jArr = new long[b2];
        ListAdapter listAdapter2 = this.mAdapter;
        int i = 0;
        for (int i2 = 0; i2 < b2; i2++) {
            if (hVar.e(i2).booleanValue()) {
                jArr[i] = listAdapter2.getItemId(hVar.c(i2));
                i++;
            }
        }
        if (i == b2) {
            return jArr;
        }
        long[] jArr2 = new long[i];
        System.arraycopy(jArr, 0, jArr2, 0, i);
        return jArr2;
    }

    public Drawable getDivider() {
        return this.mDivider;
    }

    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    @Override // it.sephiroth.android.library.widget.AbsHListView
    public int getFooterViewsCount() {
        return this.mFooterViewInfos.size();
    }

    @Override // it.sephiroth.android.library.widget.AbsHListView
    public int getHeaderViewsCount() {
        return this.mHeaderViewInfos.size();
    }

    public boolean getItemsCanFocus() {
        return this.mItemsCanFocus;
    }

    public int getMaxScrollAmount() {
        return (int) ((getRight() - getLeft()) * MAX_SCROLL_FACTOR);
    }

    public Drawable getOverscrollFooter() {
        return this.mOverScrollFooter;
    }

    public Drawable getOverscrollHeader() {
        return this.mOverScrollHeader;
    }

    @Override // android.view.View
    public boolean isOpaque() {
        boolean z = (this.mCachingActive && this.mIsCacheColorOpaque && this.mDividerIsOpaque) || super.isOpaque();
        if (z) {
            Rect rect = this.mListPadding;
            int paddingLeft = rect != null ? rect.left : getPaddingLeft();
            View childAt = getChildAt(0);
            if (childAt != null && childAt.getLeft() <= paddingLeft) {
                int width = getWidth();
                Rect rect2 = this.mListPadding;
                int paddingRight = width - (rect2 != null ? rect2.right : getPaddingRight());
                View childAt2 = getChildAt(getChildCount() - 1);
                if (childAt2 == null || childAt2.getRight() < paddingRight) {
                }
            }
            return false;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01c4, code lost:
    
        r0 = getFocusedChild();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01c8, code lost:
    
        if (r0 == null) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01ca, code lost:
    
        r0.clearFocus();
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01cd, code lost:
    
        positionSelector(-1, r1);
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008c A[Catch: all -> 0x0283, TryCatch #0 {all -> 0x0283, blocks: (B:5:0x000a, B:7:0x0014, B:13:0x001f, B:22:0x0046, B:25:0x004f, B:26:0x0055, B:28:0x005d, B:29:0x0064, B:30:0x0088, B:32:0x008c, B:33:0x008f, B:35:0x0093, B:40:0x009e, B:42:0x00a8, B:46:0x00b6, B:48:0x00c7, B:51:0x00cf, B:55:0x00e2, B:56:0x00e8, B:57:0x00f0, B:59:0x00f5, B:61:0x0144, B:62:0x0196, B:64:0x019b, B:66:0x01a0, B:68:0x01a6, B:70:0x01ac, B:73:0x01b4, B:76:0x01c4, B:78:0x01ca, B:79:0x01cd, B:80:0x01de, B:82:0x0214, B:84:0x021a, B:85:0x021d, B:87:0x0226, B:88:0x022e, B:90:0x023d, B:91:0x0240, B:96:0x01d1, B:97:0x01ba, B:101:0x01db, B:102:0x01e5, B:104:0x01e9, B:106:0x01ee, B:108:0x01f9, B:109:0x0207, B:112:0x020f, B:113:0x01ff, B:114:0x0151, B:115:0x0164, B:117:0x0168, B:119:0x016e, B:122:0x0177, B:123:0x0173, B:124:0x017c, B:126:0x0182, B:129:0x018b, B:130:0x0187, B:131:0x0190, B:133:0x00fa, B:135:0x0105, B:136:0x010f, B:137:0x011b, B:139:0x0129, B:140:0x0132, B:141:0x0137, B:142:0x00d9, B:144:0x00df, B:146:0x00c4, B:147:0x0249, B:148:0x0282, B:151:0x0074, B:154:0x007d), top: B:4:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0093 A[Catch: all -> 0x0283, TRY_LEAVE, TryCatch #0 {all -> 0x0283, blocks: (B:5:0x000a, B:7:0x0014, B:13:0x001f, B:22:0x0046, B:25:0x004f, B:26:0x0055, B:28:0x005d, B:29:0x0064, B:30:0x0088, B:32:0x008c, B:33:0x008f, B:35:0x0093, B:40:0x009e, B:42:0x00a8, B:46:0x00b6, B:48:0x00c7, B:51:0x00cf, B:55:0x00e2, B:56:0x00e8, B:57:0x00f0, B:59:0x00f5, B:61:0x0144, B:62:0x0196, B:64:0x019b, B:66:0x01a0, B:68:0x01a6, B:70:0x01ac, B:73:0x01b4, B:76:0x01c4, B:78:0x01ca, B:79:0x01cd, B:80:0x01de, B:82:0x0214, B:84:0x021a, B:85:0x021d, B:87:0x0226, B:88:0x022e, B:90:0x023d, B:91:0x0240, B:96:0x01d1, B:97:0x01ba, B:101:0x01db, B:102:0x01e5, B:104:0x01e9, B:106:0x01ee, B:108:0x01f9, B:109:0x0207, B:112:0x020f, B:113:0x01ff, B:114:0x0151, B:115:0x0164, B:117:0x0168, B:119:0x016e, B:122:0x0177, B:123:0x0173, B:124:0x017c, B:126:0x0182, B:129:0x018b, B:130:0x0187, B:131:0x0190, B:133:0x00fa, B:135:0x0105, B:136:0x010f, B:137:0x011b, B:139:0x0129, B:140:0x0132, B:141:0x0137, B:142:0x00d9, B:144:0x00df, B:146:0x00c4, B:147:0x0249, B:148:0x0282, B:151:0x0074, B:154:0x007d), top: B:4:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009e A[Catch: all -> 0x0283, TRY_ENTER, TryCatch #0 {all -> 0x0283, blocks: (B:5:0x000a, B:7:0x0014, B:13:0x001f, B:22:0x0046, B:25:0x004f, B:26:0x0055, B:28:0x005d, B:29:0x0064, B:30:0x0088, B:32:0x008c, B:33:0x008f, B:35:0x0093, B:40:0x009e, B:42:0x00a8, B:46:0x00b6, B:48:0x00c7, B:51:0x00cf, B:55:0x00e2, B:56:0x00e8, B:57:0x00f0, B:59:0x00f5, B:61:0x0144, B:62:0x0196, B:64:0x019b, B:66:0x01a0, B:68:0x01a6, B:70:0x01ac, B:73:0x01b4, B:76:0x01c4, B:78:0x01ca, B:79:0x01cd, B:80:0x01de, B:82:0x0214, B:84:0x021a, B:85:0x021d, B:87:0x0226, B:88:0x022e, B:90:0x023d, B:91:0x0240, B:96:0x01d1, B:97:0x01ba, B:101:0x01db, B:102:0x01e5, B:104:0x01e9, B:106:0x01ee, B:108:0x01f9, B:109:0x0207, B:112:0x020f, B:113:0x01ff, B:114:0x0151, B:115:0x0164, B:117:0x0168, B:119:0x016e, B:122:0x0177, B:123:0x0173, B:124:0x017c, B:126:0x0182, B:129:0x018b, B:130:0x0187, B:131:0x0190, B:133:0x00fa, B:135:0x0105, B:136:0x010f, B:137:0x011b, B:139:0x0129, B:140:0x0132, B:141:0x0137, B:142:0x00d9, B:144:0x00df, B:146:0x00c4, B:147:0x0249, B:148:0x0282, B:151:0x0074, B:154:0x007d), top: B:4:0x000a }] */
    @Override // it.sephiroth.android.library.widget.AbsHListView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void layoutChildren() {
        /*
            Method dump skipped, instructions count: 668
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: it.sephiroth.android.library.widget.HListView.layoutChildren():void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // it.sephiroth.android.library.widget.AdapterView
    public int lookForSelectablePosition(int i, boolean z) {
        int min;
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter != null && !isInTouchMode()) {
            int count = listAdapter.getCount();
            if (!this.mAreAllItemsSelectable) {
                if (z) {
                    min = Math.max(0, i);
                    while (min < count && !listAdapter.isEnabled(min)) {
                        min++;
                    }
                } else {
                    min = Math.min(i, count - 1);
                    while (min >= 0 && !listAdapter.isEnabled(min)) {
                        min--;
                    }
                }
                if (min < 0 || min >= count) {
                    return -1;
                }
                return min;
            }
            if (i >= 0 && i < count) {
                return i;
            }
        }
        return -1;
    }

    final int measureWidthOfChildren(int i, int i2, int i3, int i4, int i5) {
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null) {
            Rect rect = this.mListPadding;
            return rect.left + rect.right;
        }
        Rect rect2 = this.mListPadding;
        int i6 = rect2.left + rect2.right;
        int i7 = this.mDividerWidth;
        int i8 = 0;
        if (i7 <= 0 || this.mDivider == null) {
            i7 = 0;
        }
        if (i3 == -1) {
            i3 = listAdapter.getCount() - 1;
        }
        AbsHListView.RecycleBin recycleBin = this.mRecycler;
        boolean recycleOnMeasure = recycleOnMeasure();
        boolean[] zArr = this.mIsScrap;
        while (i2 <= i3) {
            View obtainView = obtainView(i2, zArr);
            measureScrapChildWidth(obtainView, i2, i);
            if (i2 > 0) {
                i6 += i7;
            }
            AbsHListView.LayoutParams layoutParams = (AbsHListView.LayoutParams) obtainView.getLayoutParams();
            if (layoutParams != null && recycleOnMeasure && recycleBin.shouldRecycleViewType(layoutParams.viewType)) {
                recycleBin.addScrapView(obtainView, -1);
            }
            i6 += obtainView.getMeasuredWidth();
            if (i6 >= i4) {
                return (i5 < 0 || i2 <= i5 || i8 <= 0 || i6 == i4) ? i4 : i8;
            }
            if (i5 >= 0 && i2 >= i5) {
                i8 = i6;
            }
            i2++;
        }
        return i6;
    }

    final int[] measureWithLargeChildren(int i, int i2, int i3, int i4, int i5, int i6) {
        ListAdapter listAdapter = this.mAdapter;
        if (listAdapter == null) {
            Rect rect = this.mListPadding;
            return new int[]{rect.left + rect.right, rect.top + rect.bottom};
        }
        Rect rect2 = this.mListPadding;
        int i7 = rect2.left + rect2.right;
        int i8 = rect2.top + rect2.bottom;
        int i9 = this.mDividerWidth;
        if (i9 <= 0 || this.mDivider == null) {
            i9 = 0;
        }
        int i10 = i3;
        if (i10 == -1) {
            i10 = listAdapter.getCount() - 1;
        }
        AbsHListView.RecycleBin recycleBin = this.mRecycler;
        boolean recycleOnMeasure = recycleOnMeasure();
        boolean[] zArr = this.mIsScrap;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = i2; i13 <= i10; i13++) {
            View obtainView = obtainView(i13, zArr);
            measureScrapChildWidth(obtainView, i13, i);
            AbsHListView.LayoutParams layoutParams = (AbsHListView.LayoutParams) obtainView.getLayoutParams();
            if (layoutParams != null && recycleOnMeasure && recycleBin.shouldRecycleViewType(layoutParams.viewType)) {
                recycleBin.addScrapView(obtainView, -1);
            }
            i11 = Math.max(i11, obtainView.getMeasuredWidth() + i9);
            i12 = Math.max(i12, obtainView.getMeasuredHeight());
        }
        return new int[]{Math.min(i7 + i11, i4), Math.min(i8 + i12, i5)};
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                addHeaderView(getChildAt(i));
            }
            removeAllViews();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // it.sephiroth.android.library.widget.AbsHListView, android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        ListAdapter listAdapter = this.mAdapter;
        int i2 = 0;
        int i3 = -1;
        if (listAdapter != null && z && rect != null) {
            rect.offset(getScrollX(), getScrollY());
            if (listAdapter.getCount() < getChildCount() + this.mFirstPosition) {
                this.mLayoutMode = 0;
                layoutChildren();
            }
            Rect rect2 = this.mTempRect;
            int childCount = getChildCount();
            int i4 = this.mFirstPosition;
            int i5 = 0;
            int i6 = -1;
            int i7 = Integer.MAX_VALUE;
            while (i2 < childCount) {
                if (listAdapter.isEnabled(i4 + i2)) {
                    View childAt = getChildAt(i2);
                    childAt.getDrawingRect(rect2);
                    offsetDescendantRectToMyCoords(childAt, rect2);
                    int distance = AbsHListView.getDistance(rect, rect2, i);
                    if (distance < i7) {
                        i5 = childAt.getLeft();
                        i6 = i2;
                        i7 = distance;
                    }
                }
                i2++;
            }
            i2 = i5;
            i3 = i6;
        }
        if (i3 >= 0) {
            setSelectionFromLeft(i3 + this.mFirstPosition, i2);
        } else {
            requestLayout();
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
    }

    @Override // it.sephiroth.android.library.widget.AbsHListView, it.sephiroth.android.library.widget.AdapterView, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(HListView.class.getName());
    }

    @Override // it.sephiroth.android.library.widget.AbsHListView, it.sephiroth.android.library.widget.AdapterView, android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(HListView.class.getName());
    }

    @Override // it.sephiroth.android.library.widget.AbsHListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return commonKey(i, 1, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return commonKey(i, i2, keyEvent);
    }

    @Override // it.sephiroth.android.library.widget.AbsHListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return commonKey(i, 1, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // it.sephiroth.android.library.widget.AbsHListView, android.view.View
    @TargetApi(11)
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        ListAdapter listAdapter = this.mAdapter;
        int count = listAdapter == null ? 0 : listAdapter.getCount();
        this.mItemCount = count;
        if (count <= 0 || !(mode == 0 || mode2 == 0)) {
            i3 = 0;
            i4 = 0;
        } else {
            View obtainView = obtainView(0, this.mIsScrap);
            measureScrapChildWidth(obtainView, 0, i2);
            int measuredWidth = obtainView.getMeasuredWidth();
            int measuredHeight = obtainView.getMeasuredHeight();
            r3 = Build.VERSION.SDK_INT >= 11 ? ViewGroup.combineMeasuredStates(0, obtainView.getMeasuredState()) : 0;
            AbsHListView.LayoutParams layoutParams = (AbsHListView.LayoutParams) obtainView.getLayoutParams();
            if (layoutParams != null && recycleOnMeasure() && this.mRecycler.shouldRecycleViewType(layoutParams.viewType)) {
                this.mRecycler.addScrapView(obtainView, -1);
            }
            i3 = r3;
            i4 = measuredWidth;
            r3 = measuredHeight;
        }
        if (mode2 == 0) {
            Rect rect = this.mListPadding;
            size2 = rect.top + rect.bottom + r3 + getHorizontalScrollbarHeight();
        } else if (mode2 == Integer.MIN_VALUE && this.mItemCount > 0 && (i5 = this.mMeasureWithChild) > -1) {
            size2 = measureWithLargeChildren(i2, i5, i5, size, size2, -1)[1];
        } else if (Build.VERSION.SDK_INT >= 11) {
            size2 |= (-16777216) & i3;
        }
        if (mode == 0) {
            Rect rect2 = this.mListPadding;
            size = (getHorizontalFadingEdgeLength() * 2) + rect2.left + rect2.right + i4;
        }
        int i6 = size;
        if (mode == Integer.MIN_VALUE) {
            i6 = measureWidthOfChildren(i2, 0, -1, i6, -1);
        }
        setMeasuredDimension(i6, size2);
        this.mHeightMeasureSpec = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // it.sephiroth.android.library.widget.AbsHListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        View focusedChild;
        if (getChildCount() > 0 && (focusedChild = getFocusedChild()) != null) {
            int indexOfChild = this.mFirstPosition + indexOfChild(focusedChild);
            int left = focusedChild.getLeft() - Math.max(0, focusedChild.getRight() - (i - getPaddingLeft()));
            if (this.mFocusSelector == null) {
                this.mFocusSelector = new FocusSelector();
            }
            post(this.mFocusSelector.setup(indexOfChild, left));
        }
        super.onSizeChanged(i, i2, i3, i4);
    }

    boolean pageScroll(int i) {
        int i2;
        boolean z;
        int lookForSelectablePosition;
        if (i == 33) {
            i2 = Math.max(0, (this.mSelectedPosition - getChildCount()) - 1);
        } else {
            if (i == 130) {
                i2 = Math.min(this.mItemCount - 1, (this.mSelectedPosition + getChildCount()) - 1);
                z = true;
                if (i2 >= 0 || (lookForSelectablePosition = lookForSelectablePosition(i2, z)) < 0) {
                    return false;
                }
                this.mLayoutMode = 4;
                this.mSpecificLeft = getPaddingLeft() + getHorizontalFadingEdgeLength();
                if (z && lookForSelectablePosition > this.mItemCount - getChildCount()) {
                    this.mLayoutMode = 3;
                }
                if (!z && lookForSelectablePosition < getChildCount()) {
                    this.mLayoutMode = 1;
                }
                setSelectionInt(lookForSelectablePosition);
                invokeOnItemScrollListener();
                if (!awakenScrollBars()) {
                    invalidate();
                }
                return true;
            }
            i2 = -1;
        }
        z = false;
        if (i2 >= 0) {
        }
        return false;
    }

    @ViewDebug.ExportedProperty(category = "list")
    protected boolean recycleOnMeasure() {
        return true;
    }

    public boolean removeFooterView(View view) {
        boolean z = false;
        if (this.mFooterViewInfos.size() > 0) {
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null && ((HeaderViewListAdapter) listAdapter).removeFooter(view)) {
                AbsHListView.AdapterDataSetObserver adapterDataSetObserver = this.mDataSetObserver;
                if (adapterDataSetObserver != null) {
                    adapterDataSetObserver.onChanged();
                }
                z = true;
            }
            removeFixedViewInfo(view, this.mFooterViewInfos);
        }
        return z;
    }

    public boolean removeHeaderView(View view) {
        boolean z = false;
        if (this.mHeaderViewInfos.size() > 0) {
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null && ((HeaderViewListAdapter) listAdapter).removeHeader(view)) {
                AbsHListView.AdapterDataSetObserver adapterDataSetObserver = this.mDataSetObserver;
                if (adapterDataSetObserver != null) {
                    adapterDataSetObserver.onChanged();
                }
                z = true;
            }
            removeFixedViewInfo(view, this.mHeaderViewInfos);
        }
        return z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        int i;
        int i2;
        int i3;
        int i4 = rect.left;
        rect.offset(view.getLeft(), view.getTop());
        rect.offset(-view.getScrollX(), -view.getScrollY());
        int width = getWidth();
        int scrollX = getScrollX();
        int i5 = scrollX + width;
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (showingLeftFadingEdge() && (this.mSelectedPosition > 0 || i4 > horizontalFadingEdgeLength)) {
            scrollX += horizontalFadingEdgeLength;
        }
        int right = getChildAt(getChildCount() - 1).getRight();
        if (showingRightFadingEdge() && (this.mSelectedPosition < this.mItemCount - 1 || rect.right < right - horizontalFadingEdgeLength)) {
            i5 -= horizontalFadingEdgeLength;
        }
        if (rect.right > i5 && rect.left > scrollX) {
            if (rect.width() > width) {
                i3 = rect.left - scrollX;
            } else {
                i3 = rect.right - i5;
            }
            i = Math.min(i3 + 0, right - i5);
        } else if (rect.left >= scrollX || rect.right >= i5) {
            i = 0;
        } else {
            if (rect.width() > width) {
                i2 = 0 - (i5 - rect.right);
            } else {
                i2 = 0 - (scrollX - rect.left);
            }
            i = Math.max(i2, getChildAt(0).getLeft() - scrollX);
        }
        boolean z2 = i != 0;
        if (z2) {
            scrollListItemsBy(-i);
            positionSelector(-1, view);
            this.mSelectedLeft = view.getTop();
            invalidate();
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // it.sephiroth.android.library.widget.AbsHListView
    public void resetList() {
        clearRecycledState(this.mHeaderViewInfos);
        clearRecycledState(this.mFooterViewInfos);
        super.resetList();
        this.mLayoutMode = 0;
    }

    @Override // it.sephiroth.android.library.widget.AbsHListView
    public void setCacheColorHint(int i) {
        boolean z = (i >>> 24) == 255;
        this.mIsCacheColorOpaque = z;
        if (z) {
            if (this.mDividerPaint == null) {
                this.mDividerPaint = new Paint();
            }
            this.mDividerPaint.setColor(i);
        }
        super.setCacheColorHint(i);
    }

    public void setDivider(Drawable drawable) {
        if (drawable != null) {
            this.mDividerWidth = drawable.getIntrinsicWidth();
        } else {
            this.mDividerWidth = 0;
        }
        this.mDivider = drawable;
        this.mDividerIsOpaque = drawable == null || drawable.getOpacity() == -1;
        requestLayout();
        invalidate();
    }

    public void setDividerWidth(int i) {
        this.mDividerWidth = i;
        requestLayout();
        invalidate();
    }

    public void setFooterDividersEnabled(boolean z) {
        this.mFooterDividersEnabled = z;
        invalidate();
    }

    public void setHeaderDividersEnabled(boolean z) {
        this.mHeaderDividersEnabled = z;
        invalidate();
    }

    public void setItemsCanFocus(boolean z) {
        this.mItemsCanFocus = z;
        if (z) {
            return;
        }
        setDescendantFocusability(393216);
    }

    public void setOverscrollFooter(Drawable drawable) {
        this.mOverScrollFooter = drawable;
        invalidate();
    }

    public void setOverscrollHeader(Drawable drawable) {
        this.mOverScrollHeader = drawable;
        if (getScrollX() < 0) {
            invalidate();
        }
    }

    @Override // it.sephiroth.android.library.widget.AdapterView
    public void setSelection(int i) {
        setSelectionFromLeft(i, 0);
    }

    public void setSelectionAfterHeaderView() {
        int size = this.mHeaderViewInfos.size();
        if (size > 0) {
            this.mNextSelectedPosition = 0;
        } else if (this.mAdapter != null) {
            setSelection(size);
        } else {
            this.mNextSelectedPosition = size;
            this.mLayoutMode = 2;
        }
    }

    public void setSelectionFromLeft(int i, int i2) {
        if (this.mAdapter == null) {
            return;
        }
        if (!isInTouchMode()) {
            i = lookForSelectablePosition(i, true);
            if (i >= 0) {
                setNextSelectedPositionInt(i);
            }
        } else {
            this.mResurrectToPosition = i;
        }
        if (i >= 0) {
            this.mLayoutMode = 4;
            this.mSpecificLeft = this.mListPadding.left + i2;
            if (this.mNeedSync) {
                this.mSyncPosition = i;
                this.mSyncColId = this.mAdapter.getItemId(i);
            }
            AbsHListView.PositionScroller positionScroller = this.mPositionScroller;
            if (positionScroller != null) {
                positionScroller.stop();
            }
            requestLayout();
        }
    }

    @Override // it.sephiroth.android.library.widget.AbsHListView
    public void setSelectionInt(int i) {
        setNextSelectedPositionInt(i);
        int i2 = this.mSelectedPosition;
        boolean z = true;
        if (i2 < 0 || (i != i2 - 1 && i != i2 + 1)) {
            z = false;
        }
        AbsHListView.PositionScroller positionScroller = this.mPositionScroller;
        if (positionScroller != null) {
            positionScroller.stop();
        }
        layoutChildren();
        if (z) {
            awakenScrollBars();
        }
    }

    @Override // it.sephiroth.android.library.widget.AbsHListView
    public void smoothScrollByOffset(int i) {
        super.smoothScrollByOffset(i);
    }

    @Override // it.sephiroth.android.library.widget.AbsHListView
    public void smoothScrollToPosition(int i) {
        super.smoothScrollToPosition(i);
    }

    public HListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.hlv_listViewStyle);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // it.sephiroth.android.library.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.mAdapter;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // it.sephiroth.android.library.widget.AbsHListView, it.sephiroth.android.library.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        int lookForSelectablePosition;
        AbsHListView.AdapterDataSetObserver adapterDataSetObserver;
        ListAdapter listAdapter2 = this.mAdapter;
        if (listAdapter2 != null && (adapterDataSetObserver = this.mDataSetObserver) != null) {
            listAdapter2.unregisterDataSetObserver(adapterDataSetObserver);
        }
        resetList();
        this.mRecycler.clear();
        if (this.mHeaderViewInfos.size() <= 0 && this.mFooterViewInfos.size() <= 0) {
            this.mAdapter = listAdapter;
        } else {
            this.mAdapter = new HeaderViewListAdapter(this.mHeaderViewInfos, this.mFooterViewInfos, listAdapter);
        }
        this.mOldSelectedPosition = -1;
        this.mOldSelectedColId = Long.MIN_VALUE;
        super.setAdapter(listAdapter);
        ListAdapter listAdapter3 = this.mAdapter;
        if (listAdapter3 != null) {
            this.mAreAllItemsSelectable = listAdapter3.areAllItemsEnabled();
            this.mOldItemCount = this.mItemCount;
            this.mItemCount = this.mAdapter.getCount();
            checkFocus();
            AbsHListView.AdapterDataSetObserver adapterDataSetObserver2 = new AbsHListView.AdapterDataSetObserver();
            this.mDataSetObserver = adapterDataSetObserver2;
            this.mAdapter.registerDataSetObserver(adapterDataSetObserver2);
            this.mRecycler.setViewTypeCount(this.mAdapter.getViewTypeCount());
            if (this.mStackFromRight) {
                lookForSelectablePosition = lookForSelectablePosition(this.mItemCount - 1, false);
            } else {
                lookForSelectablePosition = lookForSelectablePosition(0, true);
            }
            setSelectedPositionInt(lookForSelectablePosition);
            setNextSelectedPositionInt(lookForSelectablePosition);
            if (this.mItemCount == 0) {
                checkSelectionChanged();
            }
        } else {
            this.mAreAllItemsSelectable = true;
            checkFocus();
            checkSelectionChanged();
        }
        requestLayout();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public HListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        boolean z;
        this.mHeaderViewInfos = new ArrayList<>();
        this.mFooterViewInfos = new ArrayList<>();
        boolean z2 = true;
        this.mAreAllItemsSelectable = true;
        int i2 = 0;
        this.mItemsCanFocus = false;
        this.mTempRect = new Rect();
        CharSequence[] charSequenceArr = null;
        this.mArrowScrollFocusResult = new ArrowScrollFocusResult();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.HListView, i, 0);
        int i3 = -1;
        if (obtainStyledAttributes != null) {
            charSequenceArr = obtainStyledAttributes.getTextArray(0);
            drawable = obtainStyledAttributes.getDrawable(1);
            drawable2 = obtainStyledAttributes.getDrawable(7);
            drawable3 = obtainStyledAttributes.getDrawable(6);
            i2 = obtainStyledAttributes.getDimensionPixelSize(2, 0);
            boolean z3 = obtainStyledAttributes.getBoolean(4, true);
            boolean z4 = obtainStyledAttributes.getBoolean(3, true);
            i3 = obtainStyledAttributes.getInteger(5, -1);
            obtainStyledAttributes.recycle();
            z = z4;
            z2 = z3;
        } else {
            drawable = null;
            drawable2 = null;
            drawable3 = null;
            z = true;
        }
        if (charSequenceArr != null) {
            setAdapter((ListAdapter) new ArrayAdapter(context, android.R.layout.simple_list_item_1, charSequenceArr));
        }
        if (drawable != null) {
            setDivider(drawable);
        }
        if (drawable2 != null) {
            setOverscrollHeader(drawable2);
        }
        if (drawable3 != null) {
            setOverscrollFooter(drawable3);
        }
        if (i2 != 0) {
            setDividerWidth(i2);
        }
        this.mHeaderDividersEnabled = z2;
        this.mFooterDividersEnabled = z;
        this.mMeasureWithChild = i3;
    }

    public void addFooterView(View view) {
        addFooterView(view, null, true);
    }

    public void addHeaderView(View view) {
        addHeaderView(view, null, true);
    }
}
