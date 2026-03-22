package it.sephiroth.android.library.widget;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ExpandableListAdapter;
import android.widget.ListAdapter;
import com.ahmobile.android.tvclient.R$styleable;
import com.video.androidsdk.log.LogEx;
import it.sephiroth.android.library.widget.AdapterView;
import it.sephiroth.android.library.widget.ExpandableHListConnector;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class ExpandableHListView extends HListView {
    public static final int CHILD_INDICATOR_INHERIT = -1;
    private static final int[] CHILD_LAST_STATE_SET;
    private static final int[] GROUP_EMPTY_STATE_SET;
    private static final int[] GROUP_EXPANDED_EMPTY_STATE_SET;
    private static final int[] GROUP_EXPANDED_STATE_SET;
    private static final int[][] GROUP_STATE_SETS;
    private static final int INDICATOR_UNDEFINED = -2;
    private static final int[] INT_EMPTY_STATE_SET;
    private static final long PACKED_POSITION_INT_MASK_CHILD = -1;
    private static final long PACKED_POSITION_INT_MASK_GROUP = 2147483647L;
    private static final long PACKED_POSITION_MASK_CHILD = 4294967295L;
    private static final long PACKED_POSITION_MASK_GROUP = 9223372032559808512L;
    private static final long PACKED_POSITION_MASK_TYPE = Long.MIN_VALUE;
    private static final long PACKED_POSITION_SHIFT_GROUP = 32;
    private static final long PACKED_POSITION_SHIFT_TYPE = 63;
    public static final int PACKED_POSITION_TYPE_CHILD = 1;
    public static final int PACKED_POSITION_TYPE_GROUP = 0;
    public static final int PACKED_POSITION_TYPE_NULL = 2;
    public static final long PACKED_POSITION_VALUE_NULL = 4294967295L;
    private Drawable mChildDivider;
    private Drawable mChildIndicator;
    private int mChildIndicatorGravity;
    private int mChildIndicatorHeight;
    private int mChildIndicatorLeft;
    private int mChildIndicatorTop;
    private int mChildIndicatorWidth;
    private ExpandableHListConnector mConnector;
    private Drawable mGroupIndicator;
    private int mGroupIndicatorHeight;
    private int mGroupIndicatorWidth;
    private int mIndicatorGravity;
    private int mIndicatorLeft;
    private final Rect mIndicatorRect;
    private int mIndicatorTop;
    private ExpandableListAdapter mListAdapter;
    private OnChildClickListener mOnChildClickListener;
    private OnGroupClickListener mOnGroupClickListener;
    private OnGroupCollapseListener mOnGroupCollapseListener;
    private OnGroupExpandListener mOnGroupExpandListener;
    private final Rect mTempRect;

    /* loaded from: classes2.dex */
    private static class ExpandableListContextMenuInfo implements ContextMenu.ContextMenuInfo {
        private long mLPackedPosition;
        private long mLid;
        private View mTargetView;

        private ExpandableListContextMenuInfo(View view, long j, long j2) {
            this.mTargetView = view;
            this.mLPackedPosition = j;
            this.mLid = j2;
            LogEx.d(AdapterView.LOG_TAG, "ExpandableListContextMenuInfo mTargetView " + this.mTargetView + "' " + this.mLPackedPosition + " mLid " + this.mLid);
        }
    }

    /* loaded from: classes2.dex */
    public interface OnChildClickListener {
        boolean onChildClick(ExpandableHListView expandableHListView, View view, int i, int i2, long j);
    }

    /* loaded from: classes2.dex */
    public interface OnGroupClickListener {
        boolean onGroupClick(ExpandableHListView expandableHListView, View view, int i, long j);
    }

    /* loaded from: classes2.dex */
    public interface OnGroupCollapseListener {
        void onGroupCollapse(int i);
    }

    /* loaded from: classes2.dex */
    public interface OnGroupExpandListener {
        void onGroupExpand(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> PARCELABLECREATOR = new Parcelable.Creator<SavedState>() { // from class: it.sephiroth.android.library.widget.ExpandableHListView.SavedState.1
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
        ArrayList<ExpandableHListConnector.GroupMetadata> expandedGroupMetadataList;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeList(this.expandedGroupMetadataList);
        }

        SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            this.expandedGroupMetadataList = arrayList;
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            ArrayList<ExpandableHListConnector.GroupMetadata> arrayList = new ArrayList<>();
            this.expandedGroupMetadataList = arrayList;
            parcel.readList(arrayList, ExpandableHListConnector.class.getClassLoader());
        }
    }

    static {
        int[] iArr = new int[0];
        INT_EMPTY_STATE_SET = iArr;
        int[] iArr2 = {R.attr.state_expanded};
        GROUP_EXPANDED_STATE_SET = iArr2;
        int[] iArr3 = {R.attr.state_empty};
        GROUP_EMPTY_STATE_SET = iArr3;
        int[] iArr4 = {R.attr.state_expanded, R.attr.state_empty};
        GROUP_EXPANDED_EMPTY_STATE_SET = iArr4;
        GROUP_STATE_SETS = new int[][]{iArr, iArr2, iArr3, iArr4};
        CHILD_LAST_STATE_SET = new int[]{R.attr.state_last};
    }

    public ExpandableHListView(Context context) {
        this(context, null);
    }

    private int getAbsoluteFlatPosition(int i) {
        return i + getHeaderViewsCount();
    }

    private long getChildOrGroupId(ExpandableHListPosition expandableHListPosition) {
        if (expandableHListPosition.type == 1) {
            return this.mListAdapter.getChildId(expandableHListPosition.groupPos, expandableHListPosition.childPos);
        }
        return this.mListAdapter.getGroupId(expandableHListPosition.groupPos);
    }

    private int getFlatPositionForConnector(int i) {
        return i - getHeaderViewsCount();
    }

    private Drawable getIndicator(ExpandableHListConnector.PositionMetadata positionMetadata) {
        Drawable drawable;
        if (positionMetadata.position.type == 2) {
            drawable = this.mGroupIndicator;
            if (drawable != null && drawable.isStateful()) {
                ExpandableHListConnector.GroupMetadata groupMetadata = positionMetadata.groupMetadata;
                drawable.setState(GROUP_STATE_SETS[(positionMetadata.isExpanded() ? 1 : 0) | (groupMetadata == null || groupMetadata.lastChildFlPos == groupMetadata.flPos ? 2 : 0)]);
            }
        } else {
            drawable = this.mChildIndicator;
            if (drawable != null && drawable.isStateful()) {
                drawable.setState(positionMetadata.position.flatListPos == positionMetadata.groupMetadata.lastChildFlPos ? CHILD_LAST_STATE_SET : INT_EMPTY_STATE_SET);
            }
        }
        return drawable;
    }

    public static int getPackedPositionChild(long j) {
        if (j != 4294967295L && (j & Long.MIN_VALUE) == Long.MIN_VALUE) {
            return (int) (j & 4294967295L);
        }
        return -1;
    }

    public static long getPackedPositionForChild(int i, int i2) {
        return (i2 & (-1)) | ((i & PACKED_POSITION_INT_MASK_GROUP) << 32) | Long.MIN_VALUE;
    }

    public static long getPackedPositionForGroup(int i) {
        return (i & PACKED_POSITION_INT_MASK_GROUP) << 32;
    }

    public static int getPackedPositionGroup(long j) {
        if (j == 4294967295L) {
            return -1;
        }
        return (int) ((j & PACKED_POSITION_MASK_GROUP) >> 32);
    }

    public static int getPackedPositionType(long j) {
        if (j == 4294967295L) {
            return 2;
        }
        return (j & Long.MIN_VALUE) == Long.MIN_VALUE ? 1 : 0;
    }

    private boolean isHeaderOrFooterPosition(int i) {
        return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
    }

    private void resolveChildIndicator() {
        Drawable drawable = this.mChildIndicator;
        if (drawable != null) {
            this.mChildIndicatorWidth = drawable.getIntrinsicWidth();
            this.mChildIndicatorHeight = this.mChildIndicator.getIntrinsicHeight();
        } else {
            this.mChildIndicatorWidth = 0;
            this.mChildIndicatorHeight = 0;
        }
    }

    private void resolveIndicator() {
        Drawable drawable = this.mGroupIndicator;
        if (drawable != null) {
            this.mGroupIndicatorWidth = drawable.getIntrinsicWidth();
            this.mGroupIndicatorHeight = this.mGroupIndicator.getIntrinsicHeight();
        } else {
            this.mGroupIndicatorWidth = 0;
            this.mGroupIndicatorHeight = 0;
        }
    }

    public boolean collapseGroup(int i) {
        boolean collapseGroup = this.mConnector.collapseGroup(i);
        OnGroupCollapseListener onGroupCollapseListener = this.mOnGroupCollapseListener;
        if (onGroupCollapseListener != null) {
            onGroupCollapseListener.onGroupCollapse(i);
        }
        return collapseGroup;
    }

    @Override // it.sephiroth.android.library.widget.AbsHListView
    ContextMenu.ContextMenuInfo createContextMenuInfo(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return new AdapterView.AdapterContextMenuInfo(view, i, j);
        }
        ExpandableHListConnector.PositionMetadata unflattenedPos = this.mConnector.getUnflattenedPos(getFlatPositionForConnector(i));
        ExpandableHListPosition expandableHListPosition = unflattenedPos.position;
        long childOrGroupId = getChildOrGroupId(expandableHListPosition);
        long packedPosition = expandableHListPosition.getPackedPosition();
        unflattenedPos.recycle();
        return new ExpandableListContextMenuInfo(view, packedPosition, childOrGroupId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // it.sephiroth.android.library.widget.HListView, it.sephiroth.android.library.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mChildIndicator == null && this.mGroupIndicator == null) {
            return;
        }
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
        int right = getRight();
        int i = -4;
        Rect rect = this.mIndicatorRect;
        int childCount = getChildCount();
        int i2 = 0;
        int i3 = this.mFirstPosition - headerViewsCount;
        while (i2 < childCount) {
            if (i3 >= 0) {
                if (i3 > footerViewsCount) {
                    return;
                }
                View childAt = getChildAt(i2);
                int left = childAt.getLeft();
                int right2 = childAt.getRight();
                if (right2 >= 0 && left <= right) {
                    ExpandableHListConnector.PositionMetadata unflattenedPos = this.mConnector.getUnflattenedPos(i3);
                    int i4 = unflattenedPos.position.type;
                    if (i4 != i) {
                        if (i4 == 1) {
                            rect.top = childAt.getTop() + this.mChildIndicatorTop;
                            rect.bottom = childAt.getBottom() + this.mChildIndicatorTop;
                        } else {
                            rect.top = childAt.getTop() + this.mIndicatorTop;
                            rect.bottom = childAt.getBottom() + this.mIndicatorTop;
                        }
                        i = unflattenedPos.position.type;
                    }
                    if (rect.top != rect.bottom) {
                        if (unflattenedPos.position.type == 1) {
                            int i5 = this.mChildIndicatorLeft;
                            rect.left = left + i5;
                            rect.right = right2 + i5;
                        } else {
                            int i6 = this.mIndicatorLeft;
                            rect.left = left + i6;
                            rect.right = right2 + i6;
                        }
                        Drawable indicator = getIndicator(unflattenedPos);
                        if (indicator != null) {
                            if (unflattenedPos.position.type == 1) {
                                Gravity.apply(this.mChildIndicatorGravity, this.mChildIndicatorWidth, this.mChildIndicatorHeight, rect, this.mTempRect);
                            } else {
                                Gravity.apply(this.mIndicatorGravity, this.mGroupIndicatorWidth, this.mGroupIndicatorHeight, rect, this.mTempRect);
                            }
                            indicator.setBounds(this.mTempRect);
                            indicator.draw(canvas);
                        }
                    }
                    unflattenedPos.recycle();
                }
            }
            i2++;
            i3++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0022, code lost:
    
        if (r1.lastChildFlPos != r1.flPos) goto L12;
     */
    @Override // it.sephiroth.android.library.widget.HListView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void drawDivider(android.graphics.Canvas r4, android.graphics.Rect r5, int r6) {
        /*
            r3 = this;
            int r0 = r3.mFirstPosition
            int r6 = r6 + r0
            if (r6 < 0) goto L35
            int r0 = r3.getFlatPositionForConnector(r6)
            it.sephiroth.android.library.widget.ExpandableHListConnector r1 = r3.mConnector
            it.sephiroth.android.library.widget.ExpandableHListConnector$PositionMetadata r0 = r1.getUnflattenedPos(r0)
            it.sephiroth.android.library.widget.ExpandableHListPosition r1 = r0.position
            int r1 = r1.type
            r2 = 1
            if (r1 == r2) goto L29
            boolean r1 = r0.isExpanded()
            if (r1 == 0) goto L25
            it.sephiroth.android.library.widget.ExpandableHListConnector$GroupMetadata r1 = r0.groupMetadata
            int r2 = r1.lastChildFlPos
            int r1 = r1.flPos
            if (r2 == r1) goto L25
            goto L29
        L25:
            r0.recycle()
            goto L35
        L29:
            android.graphics.drawable.Drawable r6 = r3.mChildDivider
            r6.setBounds(r5)
            r6.draw(r4)
            r0.recycle()
            return
        L35:
            super.drawDivider(r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: it.sephiroth.android.library.widget.ExpandableHListView.drawDivider(android.graphics.Canvas, android.graphics.Rect, int):void");
    }

    public boolean expandGroup(int i) {
        return expandGroup(i, false);
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        return this.mListAdapter;
    }

    public long getExpandableListPosition(int i) {
        if (isHeaderOrFooterPosition(i)) {
            return 4294967295L;
        }
        ExpandableHListConnector.PositionMetadata unflattenedPos = this.mConnector.getUnflattenedPos(getFlatPositionForConnector(i));
        long packedPosition = unflattenedPos.position.getPackedPosition();
        unflattenedPos.recycle();
        return packedPosition;
    }

    public int getFlatListPosition(long j) {
        ExpandableHListPosition obtainPosition = ExpandableHListPosition.obtainPosition(j);
        if (obtainPosition == null) {
            return 0;
        }
        ExpandableHListConnector.PositionMetadata flattenedPos = this.mConnector.getFlattenedPos(obtainPosition);
        obtainPosition.recycle();
        if (flattenedPos == null) {
            return 0;
        }
        int i = flattenedPos.position.flatListPos;
        flattenedPos.recycle();
        return getAbsoluteFlatPosition(i);
    }

    public long getSelectedId() {
        long selectedPosition = getSelectedPosition();
        if (selectedPosition == 4294967295L) {
            return -1L;
        }
        int packedPositionGroup = getPackedPositionGroup(selectedPosition);
        if (getPackedPositionType(selectedPosition) == 0) {
            return this.mListAdapter.getGroupId(packedPositionGroup);
        }
        return this.mListAdapter.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
    }

    public long getSelectedPosition() {
        return getExpandableListPosition(getSelectedItemPosition());
    }

    boolean handleItemClick(View view, int i, long j) {
        ExpandableHListConnector.PositionMetadata unflattenedPos = this.mConnector.getUnflattenedPos(i);
        long childOrGroupId = getChildOrGroupId(unflattenedPos.position);
        ExpandableHListPosition expandableHListPosition = unflattenedPos.position;
        boolean z = true;
        if (expandableHListPosition.type == 2) {
            OnGroupClickListener onGroupClickListener = this.mOnGroupClickListener;
            if (onGroupClickListener != null && onGroupClickListener.onGroupClick(this, view, expandableHListPosition.groupPos, childOrGroupId)) {
                unflattenedPos.recycle();
                return true;
            }
            if (unflattenedPos.isExpanded()) {
                this.mConnector.collapseGroup(unflattenedPos);
                playSoundEffect(0);
                OnGroupCollapseListener onGroupCollapseListener = this.mOnGroupCollapseListener;
                if (onGroupCollapseListener != null) {
                    onGroupCollapseListener.onGroupCollapse(unflattenedPos.position.groupPos);
                }
            } else {
                this.mConnector.expandGroup(unflattenedPos);
                playSoundEffect(0);
                OnGroupExpandListener onGroupExpandListener = this.mOnGroupExpandListener;
                if (onGroupExpandListener != null) {
                    onGroupExpandListener.onGroupExpand(unflattenedPos.position.groupPos);
                }
                ExpandableHListPosition expandableHListPosition2 = unflattenedPos.position;
                int i2 = expandableHListPosition2.groupPos;
                int headerViewsCount = expandableHListPosition2.flatListPos + getHeaderViewsCount();
                smoothScrollToPosition(this.mListAdapter.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
        } else {
            if (this.mOnChildClickListener != null) {
                playSoundEffect(0);
                OnChildClickListener onChildClickListener = this.mOnChildClickListener;
                ExpandableHListPosition expandableHListPosition3 = unflattenedPos.position;
                return onChildClickListener.onChildClick(this, view, expandableHListPosition3.groupPos, expandableHListPosition3.childPos, childOrGroupId);
            }
            z = false;
        }
        unflattenedPos.recycle();
        return z;
    }

    public boolean isGroupExpanded(int i) {
        return this.mConnector.isGroupExpanded(i);
    }

    @Override // it.sephiroth.android.library.widget.HListView, it.sephiroth.android.library.widget.AbsHListView, it.sephiroth.android.library.widget.AdapterView, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ExpandableHListView.class.getName());
    }

    @Override // it.sephiroth.android.library.widget.HListView, it.sephiroth.android.library.widget.AbsHListView, it.sephiroth.android.library.widget.AdapterView, android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ExpandableHListView.class.getName());
    }

    @Override // it.sephiroth.android.library.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ArrayList<ExpandableHListConnector.GroupMetadata> arrayList;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        ExpandableHListConnector expandableHListConnector = this.mConnector;
        if (expandableHListConnector == null || (arrayList = savedState.expandedGroupMetadataList) == null) {
            return;
        }
        expandableHListConnector.setExpandedGroupMetadataList(arrayList);
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        resolveIndicator();
        resolveChildIndicator();
    }

    @Override // it.sephiroth.android.library.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        ExpandableHListConnector expandableHListConnector = this.mConnector;
        return new SavedState(onSaveInstanceState, expandableHListConnector != null ? expandableHListConnector.getExpandedGroupMetadataList() : null);
    }

    @Override // it.sephiroth.android.library.widget.AbsHListView, it.sephiroth.android.library.widget.AdapterView
    public boolean performItemClick(View view, int i, long j) {
        if (isHeaderOrFooterPosition(i)) {
            return super.performItemClick(view, i, j);
        }
        return handleItemClick(view, getFlatPositionForConnector(i), j);
    }

    public void setChildDivider(Drawable drawable) {
        this.mChildDivider = drawable;
    }

    public void setChildIndicator(Drawable drawable) {
        this.mChildIndicator = drawable;
        resolveChildIndicator();
    }

    public void setGroupIndicator(Drawable drawable) {
        this.mGroupIndicator = drawable;
        resolveIndicator();
    }

    public void setOnChildClickListener(OnChildClickListener onChildClickListener) {
        this.mOnChildClickListener = onChildClickListener;
    }

    public void setOnGroupClickListener(OnGroupClickListener onGroupClickListener) {
        this.mOnGroupClickListener = onGroupClickListener;
    }

    public void setOnGroupCollapseListener(OnGroupCollapseListener onGroupCollapseListener) {
        this.mOnGroupCollapseListener = onGroupCollapseListener;
    }

    public void setOnGroupExpandListener(OnGroupExpandListener onGroupExpandListener) {
        this.mOnGroupExpandListener = onGroupExpandListener;
    }

    @Override // it.sephiroth.android.library.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        super.setOnItemClickListener(onItemClickListener);
    }

    public boolean setSelectedChild(int i, int i2, boolean z) {
        ExpandableHListPosition obtainChildPosition = ExpandableHListPosition.obtainChildPosition(i, i2);
        ExpandableHListConnector.PositionMetadata flattenedPos = this.mConnector.getFlattenedPos(obtainChildPosition);
        if (flattenedPos == null) {
            if (!z) {
                return false;
            }
            expandGroup(i);
            flattenedPos = this.mConnector.getFlattenedPos(obtainChildPosition);
            if (flattenedPos == null) {
                throw new IllegalStateException("Could not find child");
            }
        }
        super.setSelection(getAbsoluteFlatPosition(flattenedPos.position.flatListPos));
        obtainChildPosition.recycle();
        flattenedPos.recycle();
        return true;
    }

    public void setSelectedGroup(int i) {
        ExpandableHListPosition obtainGroupPosition = ExpandableHListPosition.obtainGroupPosition(i);
        ExpandableHListConnector.PositionMetadata flattenedPos = this.mConnector.getFlattenedPos(obtainGroupPosition);
        obtainGroupPosition.recycle();
        if (flattenedPos != null) {
            super.setSelection(getAbsoluteFlatPosition(flattenedPos.position.flatListPos));
            flattenedPos.recycle();
        }
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.zte.iptvclient.android.zala.R.attr.hlv_expandableListViewStyle);
    }

    public boolean expandGroup(int i, boolean z) {
        ExpandableHListPosition obtain = ExpandableHListPosition.obtain(2, i, -1, -1);
        ExpandableHListConnector.PositionMetadata flattenedPos = this.mConnector.getFlattenedPos(obtain);
        obtain.recycle();
        if (flattenedPos == null) {
            return false;
        }
        boolean expandGroup = this.mConnector.expandGroup(flattenedPos);
        OnGroupExpandListener onGroupExpandListener = this.mOnGroupExpandListener;
        if (onGroupExpandListener != null) {
            onGroupExpandListener.onGroupExpand(i);
        }
        if (z) {
            int headerViewsCount = flattenedPos.position.flatListPos + getHeaderViewsCount();
            smoothScrollToPosition(this.mListAdapter.getChildrenCount(i) + headerViewsCount, headerViewsCount);
        }
        flattenedPos.recycle();
        return expandGroup;
    }

    @Override // it.sephiroth.android.library.widget.HListView, it.sephiroth.android.library.widget.AdapterView
    public ListAdapter getAdapter() {
        return super.getAdapter();
    }

    @Override // it.sephiroth.android.library.widget.HListView, it.sephiroth.android.library.widget.AbsHListView, it.sephiroth.android.library.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        throw new RuntimeException("For ExpandableListView, use setAdapter(ExpandableListAdapter) instead of setAdapter(ListAdapter)");
    }

    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIndicatorRect = new Rect();
        this.mTempRect = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ExpandableHListView, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(5));
        setChildIndicator(obtainStyledAttributes.getDrawable(1));
        this.mIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(7, 0);
        this.mIndicatorTop = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        this.mIndicatorGravity = obtainStyledAttributes.getInt(6, 0);
        this.mChildIndicatorGravity = obtainStyledAttributes.getInt(2, 0);
        this.mChildIndicatorLeft = obtainStyledAttributes.getDimensionPixelSize(3, 0);
        this.mChildIndicatorTop = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.mChildDivider = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
    }

    public void setAdapter(ExpandableListAdapter expandableListAdapter) {
        this.mListAdapter = expandableListAdapter;
        if (expandableListAdapter != null) {
            this.mConnector = new ExpandableHListConnector(expandableListAdapter);
        } else {
            this.mConnector = null;
        }
        super.setAdapter((ListAdapter) this.mConnector);
    }
}
