package it.sephiroth.android.library.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObserver;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Adapter;
import com.video.androidsdk.log.LogEx;

/* loaded from: classes2.dex */
public abstract class AdapterView<T extends Adapter> extends ViewGroup {
    public static final long INVALID_COL_ID = Long.MIN_VALUE;
    public static final int INVALID_POSITION = -1;
    public static final int ITEM_VIEW_TYPE_HEADER_OR_FOOTER = -2;
    public static final int ITEM_VIEW_TYPE_IGNORE = -1;
    public static final boolean LOG_ENABLED = false;
    public static final String LOG_TAG = "AdapterView";
    static final int SYNC_FIRST_POSITION = 1;
    static final int SYNC_MAX_DURATION_MILLIS = 100;
    static final int SYNC_SELECTED_POSITION = 0;
    AccessibilityManager mAccessibilityManager;
    protected boolean mBlockLayoutRequests;
    public boolean mDataChanged;
    private boolean mDesiredFocusableInTouchModeState;
    private boolean mDesiredFocusableState;
    private View mEmptyView;

    @ViewDebug.ExportedProperty(category = "scrolling")
    protected int mFirstPosition;
    protected boolean mInLayout;

    @ViewDebug.ExportedProperty(category = "list")
    protected int mItemCount;
    private int mLayoutWidth;
    protected boolean mNeedSync;
    protected long mNextSelectedColId;

    @ViewDebug.ExportedProperty(category = "list")
    protected int mNextSelectedPosition;
    protected int mOldItemCount;
    protected long mOldSelectedColId;
    protected int mOldSelectedPosition;
    OnItemClickListener mOnItemClickListener;
    OnItemLongClickListener mOnItemLongClickListener;
    OnItemSelectedListener mOnItemSelectedListener;
    protected long mSelectedColId;

    @ViewDebug.ExportedProperty(category = "list")
    protected int mSelectedPosition;
    private AdapterView<T>.SelectionNotifier mSelectionNotifier;
    protected int mSpecificLeft;
    protected long mSyncColId;
    int mSyncMode;
    protected int mSyncPosition;
    protected long mSyncWidth;

    /* loaded from: classes2.dex */
    public static class AdapterContextMenuInfo implements ContextMenu.ContextMenuInfo {
        public int mIposition;
        public long mLid;
        public View mTtargetView;

        public AdapterContextMenuInfo(View view, int i, long j) {
            this.mTtargetView = view;
            this.mIposition = i;
            this.mLid = j;
            LogEx.d(AdapterView.LOG_TAG, "mTtargetView " + this.mTtargetView + " mIposition" + this.mIposition + " mLid " + this.mLid);
        }
    }

    /* loaded from: classes2.dex */
    class AdapterDataSetObserver extends DataSetObserver {
        private Parcelable mInstanceState = null;

        /* JADX INFO: Access modifiers changed from: package-private */
        public AdapterDataSetObserver() {
        }

        public void clearSavedState() {
            this.mInstanceState = null;
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            Parcelable parcelable;
            AdapterView adapterView = AdapterView.this;
            adapterView.mDataChanged = true;
            adapterView.mOldItemCount = adapterView.mItemCount;
            adapterView.mItemCount = adapterView.getAdapter().getCount();
            if (AdapterView.this.getAdapter().hasStableIds() && (parcelable = this.mInstanceState) != null) {
                AdapterView adapterView2 = AdapterView.this;
                if (adapterView2.mOldItemCount == 0 && adapterView2.mItemCount > 0) {
                    adapterView2.onRestoreInstanceState(parcelable);
                    this.mInstanceState = null;
                    AdapterView.this.checkFocus();
                    AdapterView.this.requestLayout();
                }
            }
            AdapterView.this.rememberSyncState();
            AdapterView.this.checkFocus();
            AdapterView.this.requestLayout();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            AdapterView adapterView = AdapterView.this;
            adapterView.mDataChanged = true;
            if (adapterView.getAdapter().hasStableIds()) {
                this.mInstanceState = AdapterView.this.onSaveInstanceState();
            }
            AdapterView adapterView2 = AdapterView.this;
            adapterView2.mOldItemCount = adapterView2.mItemCount;
            adapterView2.mItemCount = 0;
            adapterView2.mSelectedPosition = -1;
            adapterView2.mSelectedColId = Long.MIN_VALUE;
            adapterView2.mNextSelectedPosition = -1;
            adapterView2.mNextSelectedColId = Long.MIN_VALUE;
            adapterView2.mNeedSync = false;
            adapterView2.checkFocus();
            AdapterView.this.requestLayout();
        }
    }

    /* loaded from: classes2.dex */
    public interface OnItemClickListener {
        void onItemClick(AdapterView<?> adapterView, View view, int i, long j);
    }

    /* loaded from: classes2.dex */
    public interface OnItemLongClickListener {
        boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j);
    }

    /* loaded from: classes2.dex */
    public interface OnItemSelectedListener {
        void onItemSelected(AdapterView<?> adapterView, View view, int i, long j);

        void onNothingSelected(AdapterView<?> adapterView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class SelectionNotifier implements Runnable {
        private SelectionNotifier() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AdapterView adapterView = AdapterView.this;
            if (!adapterView.mDataChanged) {
                adapterView.fireOnSelected();
                AdapterView.this.performAccessibilityActionsOnSelected();
            } else if (adapterView.getAdapter() != null) {
                AdapterView.this.post(this);
            }
        }
    }

    public AdapterView(Context context) {
        super(context);
        this.mFirstPosition = 0;
        this.mSyncColId = Long.MIN_VALUE;
        this.mNeedSync = false;
        this.mInLayout = false;
        this.mNextSelectedPosition = -1;
        this.mNextSelectedColId = Long.MIN_VALUE;
        this.mSelectedPosition = -1;
        this.mSelectedColId = Long.MIN_VALUE;
        this.mOldSelectedPosition = -1;
        this.mOldSelectedColId = Long.MIN_VALUE;
        this.mBlockLayoutRequests = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireOnSelected() {
        if (this.mOnItemSelectedListener == null) {
            return;
        }
        int selectedItemPosition = getSelectedItemPosition();
        if (selectedItemPosition >= 0) {
            this.mOnItemSelectedListener.onItemSelected(this, getSelectedView(), selectedItemPosition, getAdapter().getItemId(selectedItemPosition));
        } else {
            this.mOnItemSelectedListener.onNothingSelected(this);
        }
    }

    private boolean isScrollableForAccessibility() {
        int count;
        T adapter = getAdapter();
        if (adapter == null || (count = adapter.getCount()) <= 0) {
            return false;
        }
        return getFirstVisiblePosition() > 0 || getLastVisiblePosition() < count - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void performAccessibilityActionsOnSelected() {
        if (this.mAccessibilityManager.isEnabled() && getSelectedItemPosition() >= 0) {
            sendAccessibilityEvent(4);
        }
    }

    @SuppressLint({"WrongCall"})
    private void updateEmptyStatus(boolean z) {
        if (isInFilterMode()) {
            z = false;
        }
        if (z) {
            View view = this.mEmptyView;
            if (view != null) {
                view.setVisibility(0);
                setVisibility(8);
            } else {
                setVisibility(0);
            }
            if (this.mDataChanged) {
                onLayout(false, getLeft(), getTop(), getRight(), getBottom());
                return;
            }
            return;
        }
        View view2 = this.mEmptyView;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        setVisibility(0);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public boolean canAnimate() {
        return super.canAnimate() && this.mItemCount > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkFocus() {
        T adapter = getAdapter();
        boolean z = !(adapter == null || adapter.getCount() == 0) || isInFilterMode();
        super.setFocusableInTouchMode(z && this.mDesiredFocusableInTouchModeState);
        super.setFocusable(z && this.mDesiredFocusableState);
        if (this.mEmptyView != null) {
            updateEmptyStatus(adapter == null || adapter.isEmpty());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkSelectionChanged() {
        if (this.mSelectedPosition == this.mOldSelectedPosition && this.mSelectedColId == this.mOldSelectedColId) {
            return;
        }
        selectionChanged();
        this.mOldSelectedPosition = this.mSelectedPosition;
        this.mOldSelectedColId = this.mSelectedColId;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        View selectedView = getSelectedView();
        return selectedView != null && selectedView.getVisibility() == 0 && selectedView.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0065, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int findSyncPosition() {
        /*
            r17 = this;
            r0 = r17
            int r1 = r0.mItemCount
            r2 = -1
            if (r1 != 0) goto L8
            return r2
        L8:
            long r3 = r0.mSyncColId
            int r5 = r0.mSyncPosition
            r6 = -9223372036854775808
            int r8 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r8 != 0) goto L13
            return r2
        L13:
            r6 = 0
            int r5 = java.lang.Math.max(r6, r5)
            r7 = 1
            int r1 = r1 - r7
            int r5 = java.lang.Math.min(r1, r5)
            long r8 = android.os.SystemClock.uptimeMillis()
            r10 = 100
            long r8 = r8 + r10
            android.widget.Adapter r10 = r17.getAdapter()
            if (r10 != 0) goto L2c
            return r2
        L2c:
            r11 = r5
            r12 = r11
        L2e:
            r13 = 0
        L2f:
            long r14 = android.os.SystemClock.uptimeMillis()
            int r16 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1))
            if (r16 > 0) goto L65
            long r14 = r10.getItemId(r5)
            int r16 = (r14 > r3 ? 1 : (r14 == r3 ? 0 : -1))
            if (r16 != 0) goto L40
            return r5
        L40:
            if (r11 != r1) goto L44
            r14 = 1
            goto L45
        L44:
            r14 = 0
        L45:
            if (r12 != 0) goto L49
            r15 = 1
            goto L4a
        L49:
            r15 = 0
        L4a:
            if (r14 == 0) goto L4f
            if (r15 == 0) goto L4f
            goto L65
        L4f:
            if (r15 != 0) goto L61
            if (r13 == 0) goto L56
            if (r14 != 0) goto L56
            goto L61
        L56:
            if (r14 != 0) goto L5c
            if (r13 != 0) goto L2f
            if (r15 != 0) goto L2f
        L5c:
            int r12 = r12 + (-1)
            r5 = r12
            r13 = 1
            goto L2f
        L61:
            int r11 = r11 + 1
            r5 = r11
            goto L2e
        L65:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: it.sephiroth.android.library.widget.AdapterView.findSyncPosition():int");
    }

    public abstract T getAdapter();

    @ViewDebug.CapturedViewProperty
    public int getCount() {
        return this.mItemCount;
    }

    public View getEmptyView() {
        return this.mEmptyView;
    }

    public int getFirstVisiblePosition() {
        return this.mFirstPosition;
    }

    public Object getItemAtPosition(int i) {
        T adapter = getAdapter();
        if (adapter == null || i < 0) {
            return null;
        }
        return adapter.getItem(i);
    }

    public long getItemIdAtPosition(int i) {
        T adapter = getAdapter();
        if (adapter == null || i < 0) {
            return Long.MIN_VALUE;
        }
        return adapter.getItemId(i);
    }

    public int getLastVisiblePosition() {
        return (this.mFirstPosition + getChildCount()) - 1;
    }

    public final OnItemClickListener getOnItemClickListener() {
        return this.mOnItemClickListener;
    }

    public final OnItemLongClickListener getOnItemLongClickListener() {
        return this.mOnItemLongClickListener;
    }

    public final OnItemSelectedListener getOnItemSelectedListener() {
        return this.mOnItemSelectedListener;
    }

    public int getPositionForView(View view) {
        while (true) {
            try {
                View view2 = (View) view.getParent();
                if (view2.equals(this)) {
                    break;
                }
                view = view2;
            } catch (ClassCastException unused) {
            }
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i).equals(view)) {
                return this.mFirstPosition + i;
            }
        }
        return -1;
    }

    public Object getSelectedItem() {
        T adapter = getAdapter();
        int selectedItemPosition = getSelectedItemPosition();
        if (adapter == null || adapter.getCount() <= 0 || selectedItemPosition < 0) {
            return null;
        }
        return adapter.getItem(selectedItemPosition);
    }

    @ViewDebug.CapturedViewProperty
    public long getSelectedItemId() {
        return this.mNextSelectedColId;
    }

    @ViewDebug.CapturedViewProperty
    public int getSelectedItemPosition() {
        return this.mNextSelectedPosition;
    }

    public abstract View getSelectedView();

    /* JADX WARN: Removed duplicated region for block: B:11:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void handleDataChanged() {
        /*
            r5 = this;
            int r0 = r5.mItemCount
            r1 = 1
            r2 = 0
            if (r0 <= 0) goto L40
            boolean r3 = r5.mNeedSync
            if (r3 == 0) goto L1d
            r5.mNeedSync = r2
            int r3 = r5.findSyncPosition()
            if (r3 < 0) goto L1d
            int r4 = r5.lookForSelectablePosition(r3, r1)
            if (r4 != r3) goto L1d
            r5.setNextSelectedPositionInt(r3)
            r3 = 1
            goto L1e
        L1d:
            r3 = 0
        L1e:
            if (r3 != 0) goto L3e
            int r4 = r5.getSelectedItemPosition()
            if (r4 < r0) goto L28
            int r4 = r0 + (-1)
        L28:
            if (r4 >= 0) goto L2b
            r4 = 0
        L2b:
            int r0 = r5.lookForSelectablePosition(r4, r1)
            if (r0 >= 0) goto L35
            int r0 = r5.lookForSelectablePosition(r4, r2)
        L35:
            if (r0 < 0) goto L3e
            r5.setNextSelectedPositionInt(r0)
            r5.checkSelectionChanged()
            goto L41
        L3e:
            r1 = r3
            goto L41
        L40:
            r1 = 0
        L41:
            if (r1 != 0) goto L53
            r0 = -1
            r5.mSelectedPosition = r0
            r3 = -9223372036854775808
            r5.mSelectedColId = r3
            r5.mNextSelectedPosition = r0
            r5.mNextSelectedColId = r3
            r5.mNeedSync = r2
            r5.checkSelectionChanged()
        L53:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: it.sephiroth.android.library.widget.AdapterView.handleDataChanged():void");
    }

    boolean isInFilterMode() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int lookForSelectablePosition(int i, boolean z) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.mSelectionNotifier);
    }

    @Override // android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(AdapterView.class.getName());
        accessibilityEvent.setScrollable(isScrollableForAccessibility());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityEvent.setEnabled(selectedView.isEnabled());
        }
        accessibilityEvent.setCurrentItemIndex(getSelectedItemPosition());
        accessibilityEvent.setFromIndex(getFirstVisiblePosition());
        accessibilityEvent.setToIndex(getLastVisiblePosition());
        accessibilityEvent.setItemCount(getCount());
    }

    @Override // android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(AdapterView.class.getName());
        accessibilityNodeInfo.setScrollable(isScrollableForAccessibility());
        View selectedView = getSelectedView();
        if (selectedView != null) {
            accessibilityNodeInfo.setEnabled(selectedView.isEnabled());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mLayoutWidth = getWidth();
    }

    @Override // android.view.ViewGroup
    @TargetApi(14)
    public boolean onRequestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        if (!super.onRequestSendAccessibilityEvent(view, accessibilityEvent)) {
            return false;
        }
        AccessibilityEvent obtain = AccessibilityEvent.obtain();
        onInitializeAccessibilityEvent(obtain);
        view.dispatchPopulateAccessibilityEvent(obtain);
        accessibilityEvent.appendRecord(obtain);
        return true;
    }

    public boolean performItemClick(View view, int i, long j) {
        if (this.mOnItemClickListener == null) {
            return false;
        }
        playSoundEffect(0);
        if (view != null) {
            view.sendAccessibilityEvent(1);
        }
        this.mOnItemClickListener.onItemClick(this, view, i, j);
        return true;
    }

    public void rememberSyncState() {
        if (getChildCount() > 0) {
            this.mNeedSync = true;
            this.mSyncWidth = this.mLayoutWidth;
            int i = this.mSelectedPosition;
            if (i >= 0) {
                View childAt = getChildAt(i - this.mFirstPosition);
                this.mSyncColId = this.mNextSelectedColId;
                this.mSyncPosition = this.mNextSelectedPosition;
                if (childAt != null) {
                    this.mSpecificLeft = childAt.getLeft();
                }
                this.mSyncMode = 0;
                return;
            }
            View childAt2 = getChildAt(0);
            T adapter = getAdapter();
            int i2 = this.mFirstPosition;
            if (i2 >= 0 && i2 < adapter.getCount()) {
                this.mSyncColId = adapter.getItemId(this.mFirstPosition);
            } else {
                this.mSyncColId = -1L;
            }
            this.mSyncPosition = this.mFirstPosition;
            if (childAt2 != null) {
                this.mSpecificLeft = childAt2.getLeft();
            }
            this.mSyncMode = 1;
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
    }

    void selectionChanged() {
        if (this.mOnItemSelectedListener != null || this.mAccessibilityManager.isEnabled()) {
            if (!this.mInLayout && !this.mBlockLayoutRequests) {
                fireOnSelected();
                performAccessibilityActionsOnSelected();
            } else {
                if (this.mSelectionNotifier == null) {
                    this.mSelectionNotifier = new SelectionNotifier();
                }
                post(this.mSelectionNotifier);
            }
        }
    }

    public abstract void setAdapter(T t);

    @TargetApi(16)
    public void setEmptyView(View view) {
        this.mEmptyView = view;
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 16 && view != null && view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
        T adapter = getAdapter();
        if (adapter != null && !adapter.isEmpty()) {
            z = false;
        }
        updateEmptyStatus(z);
    }

    @Override // android.view.View
    public void setFocusable(boolean z) {
        T adapter = getAdapter();
        boolean z2 = true;
        boolean z3 = adapter == null || adapter.getCount() == 0;
        this.mDesiredFocusableState = z;
        if (!z) {
            this.mDesiredFocusableInTouchModeState = false;
        }
        if (!z || (z3 && !isInFilterMode())) {
            z2 = false;
        }
        super.setFocusable(z2);
    }

    @Override // android.view.View
    public void setFocusableInTouchMode(boolean z) {
        T adapter = getAdapter();
        boolean z2 = false;
        boolean z3 = adapter == null || adapter.getCount() == 0;
        this.mDesiredFocusableInTouchModeState = z;
        if (z) {
            this.mDesiredFocusableState = true;
        }
        if (z && (!z3 || isInFilterMode())) {
            z2 = true;
        }
        super.setFocusableInTouchMode(z2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setNextSelectedPositionInt(int i) {
        this.mNextSelectedPosition = i;
        long itemIdAtPosition = getItemIdAtPosition(i);
        this.mNextSelectedColId = itemIdAtPosition;
        if (this.mNeedSync && this.mSyncMode == 0 && i >= 0) {
            this.mSyncPosition = i;
            this.mSyncColId = itemIdAtPosition;
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.mOnItemLongClickListener = onItemLongClickListener;
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.mOnItemSelectedListener = onItemSelectedListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSelectedPositionInt(int i) {
        this.mSelectedPosition = i;
        this.mSelectedColId = getItemIdAtPosition(i);
    }

    public abstract void setSelection(int i);

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
    }

    public AdapterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFirstPosition = 0;
        this.mSyncColId = Long.MIN_VALUE;
        this.mNeedSync = false;
        this.mInLayout = false;
        this.mNextSelectedPosition = -1;
        this.mNextSelectedColId = Long.MIN_VALUE;
        this.mSelectedPosition = -1;
        this.mSelectedColId = Long.MIN_VALUE;
        this.mOldSelectedPosition = -1;
        this.mOldSelectedColId = Long.MIN_VALUE;
        this.mBlockLayoutRequests = false;
    }

    @TargetApi(16)
    public AdapterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFirstPosition = 0;
        this.mSyncColId = Long.MIN_VALUE;
        this.mNeedSync = false;
        this.mInLayout = false;
        this.mNextSelectedPosition = -1;
        this.mNextSelectedColId = Long.MIN_VALUE;
        this.mSelectedPosition = -1;
        this.mSelectedColId = Long.MIN_VALUE;
        this.mOldSelectedPosition = -1;
        this.mOldSelectedColId = Long.MIN_VALUE;
        this.mBlockLayoutRequests = false;
        if (Build.VERSION.SDK_INT >= 16 && getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        if (isInEditMode()) {
            return;
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
    }
}
