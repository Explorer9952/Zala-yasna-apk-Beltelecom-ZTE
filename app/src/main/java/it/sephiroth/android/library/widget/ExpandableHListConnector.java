package it.sephiroth.android.library.widget;

import android.database.DataSetObserver;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.HeterogeneousExpandableList;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes2.dex */
class ExpandableHListConnector extends BaseAdapter implements Filterable {
    private ExpandableListAdapter mExpandableListAdapter;
    private int mTotalExpChildrenCount;
    private int mMaxExpGroupCount = Integer.MAX_VALUE;
    private final DataSetObserver mDataSetObserver = new MyDataSetObserver();
    private ArrayList<GroupMetadata> mExpGroupMetadataList = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class GroupMetadata implements Parcelable, Comparable<GroupMetadata> {
        public static final Parcelable.Creator<GroupMetadata> CREATOR = new Parcelable.Creator<GroupMetadata>() { // from class: it.sephiroth.android.library.widget.ExpandableHListConnector.GroupMetadata.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public GroupMetadata createFromParcel(Parcel parcel) {
                return GroupMetadata.obtain(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readLong());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public GroupMetadata[] newArray(int i) {
                return new GroupMetadata[i];
            }
        };
        static final int REFRESH = -1;
        int flPos;
        long gId;
        int gPos;
        int lastChildFlPos;

        private GroupMetadata() {
        }

        static GroupMetadata obtain(int i, int i2, int i3, long j) {
            GroupMetadata groupMetadata = new GroupMetadata();
            groupMetadata.flPos = i;
            groupMetadata.lastChildFlPos = i2;
            groupMetadata.gPos = i3;
            groupMetadata.gId = j;
            return groupMetadata;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof ExpandableHListConnector)) {
                return false;
            }
            return super.equals(obj);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.flPos);
            parcel.writeInt(this.lastChildFlPos);
            parcel.writeInt(this.gPos);
            parcel.writeLong(this.gId);
        }

        @Override // java.lang.Comparable
        public int compareTo(GroupMetadata groupMetadata) {
            if (groupMetadata != null) {
                return this.gPos - groupMetadata.gPos;
            }
            throw new IllegalArgumentException();
        }
    }

    /* loaded from: classes2.dex */
    protected class MyDataSetObserver extends DataSetObserver {
        protected MyDataSetObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ExpandableHListConnector.this.refreshExpGroupMetadataList(true, true);
            ExpandableHListConnector.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ExpandableHListConnector.this.refreshExpGroupMetadataList(true, true);
            ExpandableHListConnector.this.notifyDataSetInvalidated();
        }
    }

    /* loaded from: classes2.dex */
    public static class PositionMetadata {
        private static final int MAX_POOL_SIZE = 5;
        private static ArrayList<PositionMetadata> sPool = new ArrayList<>(5);
        public int groupInsertIndex;
        public GroupMetadata groupMetadata;
        public ExpandableHListPosition position;

        private PositionMetadata() {
        }

        private static PositionMetadata getRecycledOrCreate() {
            synchronized (sPool) {
                if (sPool.size() > 0) {
                    PositionMetadata remove = sPool.remove(0);
                    remove.resetState();
                    return remove;
                }
                return new PositionMetadata();
            }
        }

        static PositionMetadata obtain(int i, int i2, int i3, int i4, GroupMetadata groupMetadata, int i5) {
            PositionMetadata recycledOrCreate = getRecycledOrCreate();
            recycledOrCreate.position = ExpandableHListPosition.obtain(i2, i3, i4, i);
            recycledOrCreate.groupMetadata = groupMetadata;
            recycledOrCreate.groupInsertIndex = i5;
            return recycledOrCreate;
        }

        private void resetState() {
            ExpandableHListPosition expandableHListPosition = this.position;
            if (expandableHListPosition != null) {
                expandableHListPosition.recycle();
                this.position = null;
            }
            this.groupMetadata = null;
            this.groupInsertIndex = 0;
        }

        public boolean isExpanded() {
            return this.groupMetadata != null;
        }

        public void recycle() {
            resetState();
            synchronized (sPool) {
                if (sPool.size() < 5) {
                    sPool.add(this);
                }
            }
        }
    }

    public ExpandableHListConnector(ExpandableListAdapter expandableListAdapter) {
        setExpandableListAdapter(expandableListAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshExpGroupMetadataList(boolean z, boolean z2) {
        int childrenCount;
        ArrayList<GroupMetadata> arrayList = this.mExpGroupMetadataList;
        int size = arrayList.size();
        int i = 0;
        this.mTotalExpChildrenCount = 0;
        if (z2) {
            boolean z3 = false;
            for (int i2 = size - 1; i2 >= 0; i2--) {
                GroupMetadata groupMetadata = arrayList.get(i2);
                int findGroupPosition = findGroupPosition(groupMetadata.gId, groupMetadata.gPos);
                if (findGroupPosition != groupMetadata.gPos) {
                    if (findGroupPosition == -1) {
                        arrayList.remove(i2);
                        size--;
                    }
                    groupMetadata.gPos = findGroupPosition;
                    if (!z3) {
                        z3 = true;
                    }
                }
            }
            if (z3) {
                Collections.sort(arrayList);
            }
        }
        int i3 = 0;
        int i4 = 0;
        while (i < size) {
            GroupMetadata groupMetadata2 = arrayList.get(i);
            int i5 = groupMetadata2.lastChildFlPos;
            if (i5 != -1 && !z) {
                childrenCount = i5 - groupMetadata2.flPos;
            } else {
                childrenCount = this.mExpandableListAdapter.getChildrenCount(groupMetadata2.gPos);
            }
            this.mTotalExpChildrenCount += childrenCount;
            int i6 = groupMetadata2.gPos;
            int i7 = i3 + (i6 - i4);
            groupMetadata2.flPos = i7;
            i3 = i7 + childrenCount;
            groupMetadata2.lastChildFlPos = i3;
            i++;
            i4 = i6;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.mExpandableListAdapter.areAllItemsEnabled();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean collapseGroup(int i) {
        ExpandableHListPosition obtain = ExpandableHListPosition.obtain(2, i, -1, -1);
        PositionMetadata flattenedPos = getFlattenedPos(obtain);
        obtain.recycle();
        if (flattenedPos == null) {
            return false;
        }
        boolean collapseGroup = collapseGroup(flattenedPos);
        flattenedPos.recycle();
        return collapseGroup;
    }

    boolean expandGroup(int i) {
        ExpandableHListPosition obtain = ExpandableHListPosition.obtain(2, i, -1, -1);
        PositionMetadata flattenedPos = getFlattenedPos(obtain);
        obtain.recycle();
        if (flattenedPos == null) {
            return false;
        }
        boolean expandGroup = expandGroup(flattenedPos);
        flattenedPos.recycle();
        return expandGroup;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0062, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    int findGroupPosition(long r16, int r18) {
        /*
            r15 = this;
            r0 = r15
            android.widget.ExpandableListAdapter r1 = r0.mExpandableListAdapter
            int r1 = r1.getGroupCount()
            r2 = -1
            if (r1 != 0) goto Lb
            return r2
        Lb:
            r3 = -9223372036854775808
            int r5 = (r16 > r3 ? 1 : (r16 == r3 ? 0 : -1))
            if (r5 != 0) goto L12
            return r2
        L12:
            r3 = 0
            r4 = r18
            int r4 = java.lang.Math.max(r3, r4)
            r5 = 1
            int r1 = r1 - r5
            int r4 = java.lang.Math.min(r1, r4)
            long r6 = android.os.SystemClock.uptimeMillis()
            r8 = 100
            long r6 = r6 + r8
            android.widget.ExpandableListAdapter r8 = r15.getAdapter()
            if (r8 != 0) goto L2d
            return r2
        L2d:
            r9 = r4
            r10 = r9
        L2f:
            r11 = 0
        L30:
            long r12 = android.os.SystemClock.uptimeMillis()
            int r14 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r14 > 0) goto L62
            long r12 = r8.getGroupId(r4)
            int r14 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r14 != 0) goto L41
            return r4
        L41:
            if (r9 != r1) goto L45
            r12 = 1
            goto L46
        L45:
            r12 = 0
        L46:
            if (r10 != 0) goto L4a
            r13 = 1
            goto L4b
        L4a:
            r13 = 0
        L4b:
            if (r12 == 0) goto L50
            if (r13 == 0) goto L50
            goto L62
        L50:
            if (r13 != 0) goto L5e
            if (r11 == 0) goto L57
            if (r12 != 0) goto L57
            goto L5e
        L57:
            if (r12 == 0) goto L30
            int r10 = r10 + (-1)
            r4 = r10
            r11 = 1
            goto L30
        L5e:
            int r9 = r9 + 1
            r4 = r9
            goto L2f
        L62:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: it.sephiroth.android.library.widget.ExpandableHListConnector.findGroupPosition(long, int):int");
    }

    ExpandableListAdapter getAdapter() {
        return this.mExpandableListAdapter;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mExpandableListAdapter.getGroupCount() + this.mTotalExpChildrenCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<GroupMetadata> getExpandedGroupMetadataList() {
        return this.mExpGroupMetadataList;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        ExpandableListAdapter adapter = getAdapter();
        if (adapter instanceof Filterable) {
            return ((Filterable) adapter).getFilter();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PositionMetadata getFlattenedPos(ExpandableHListPosition expandableHListPosition) {
        ArrayList<GroupMetadata> arrayList = this.mExpGroupMetadataList;
        int size = arrayList.size();
        int i = size - 1;
        if (size == 0) {
            int i2 = expandableHListPosition.groupPos;
            return PositionMetadata.obtain(i2, expandableHListPosition.type, i2, expandableHListPosition.childPos, null, 0);
        }
        int i3 = 0;
        int i4 = 0;
        while (i4 <= i) {
            i3 = ((i - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i3);
            int i5 = expandableHListPosition.groupPos;
            int i6 = groupMetadata.gPos;
            if (i5 > i6) {
                i4 = i3 + 1;
            } else if (i5 < i6) {
                i = i3 - 1;
            } else if (i5 == i6) {
                int i7 = expandableHListPosition.type;
                if (i7 == 2) {
                    return PositionMetadata.obtain(groupMetadata.flPos, i7, i5, expandableHListPosition.childPos, groupMetadata, i3);
                }
                if (i7 != 1) {
                    return null;
                }
                int i8 = groupMetadata.flPos;
                int i9 = expandableHListPosition.childPos;
                return PositionMetadata.obtain(i8 + i9 + 1, i7, i5, i9, groupMetadata, i3);
            }
        }
        if (expandableHListPosition.type != 2) {
            return null;
        }
        if (i4 > i3) {
            GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
            int i10 = groupMetadata2.lastChildFlPos;
            int i11 = expandableHListPosition.groupPos;
            return PositionMetadata.obtain(i10 + (i11 - groupMetadata2.gPos), expandableHListPosition.type, i11, expandableHListPosition.childPos, null, i4);
        }
        if (i >= i3) {
            return null;
        }
        int i12 = 1 + i;
        GroupMetadata groupMetadata3 = arrayList.get(i12);
        int i13 = groupMetadata3.flPos;
        int i14 = groupMetadata3.gPos;
        int i15 = expandableHListPosition.groupPos;
        return PositionMetadata.obtain(i13 - (i14 - i15), expandableHListPosition.type, i15, expandableHListPosition.childPos, null, i12);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Object child;
        PositionMetadata unflattenedPos = getUnflattenedPos(i);
        ExpandableHListPosition expandableHListPosition = unflattenedPos.position;
        int i2 = expandableHListPosition.type;
        if (i2 == 2) {
            child = this.mExpandableListAdapter.getGroup(expandableHListPosition.groupPos);
        } else if (i2 == 1) {
            child = this.mExpandableListAdapter.getChild(expandableHListPosition.groupPos, expandableHListPosition.childPos);
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        unflattenedPos.recycle();
        return child;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        long combinedChildId;
        PositionMetadata unflattenedPos = getUnflattenedPos(i);
        long groupId = this.mExpandableListAdapter.getGroupId(unflattenedPos.position.groupPos);
        ExpandableHListPosition expandableHListPosition = unflattenedPos.position;
        int i2 = expandableHListPosition.type;
        if (i2 == 2) {
            combinedChildId = this.mExpandableListAdapter.getCombinedGroupId(groupId);
        } else if (i2 == 1) {
            combinedChildId = this.mExpandableListAdapter.getCombinedChildId(groupId, this.mExpandableListAdapter.getChildId(expandableHListPosition.groupPos, expandableHListPosition.childPos));
        } else {
            throw new RuntimeException("Flat list position is of unknown type");
        }
        unflattenedPos.recycle();
        return combinedChildId;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int i2;
        PositionMetadata unflattenedPos = getUnflattenedPos(i);
        ExpandableHListPosition expandableHListPosition = unflattenedPos.position;
        ExpandableListAdapter expandableListAdapter = this.mExpandableListAdapter;
        if (expandableListAdapter instanceof HeterogeneousExpandableList) {
            HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) expandableListAdapter;
            if (expandableHListPosition.type == 2) {
                i2 = heterogeneousExpandableList.getGroupType(expandableHListPosition.groupPos);
            } else {
                i2 = heterogeneousExpandableList.getChildType(expandableHListPosition.groupPos, expandableHListPosition.childPos) + heterogeneousExpandableList.getGroupTypeCount();
            }
        } else {
            i2 = expandableHListPosition.type == 2 ? 0 : 1;
        }
        unflattenedPos.recycle();
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PositionMetadata getUnflattenedPos(int i) {
        int i2;
        ArrayList<GroupMetadata> arrayList = this.mExpGroupMetadataList;
        int size = arrayList.size();
        int i3 = size - 1;
        if (size == 0) {
            return PositionMetadata.obtain(i, 2, i, -1, null, 0);
        }
        int i4 = 0;
        int i5 = i3;
        int i6 = 0;
        while (i4 <= i5) {
            int i7 = ((i5 - i4) / 2) + i4;
            GroupMetadata groupMetadata = arrayList.get(i7);
            int i8 = groupMetadata.lastChildFlPos;
            if (i > i8) {
                i4 = i7 + 1;
            } else {
                int i9 = groupMetadata.flPos;
                if (i < i9) {
                    i5 = i7 - 1;
                } else {
                    if (i == i9) {
                        return PositionMetadata.obtain(i, 2, groupMetadata.gPos, -1, groupMetadata, i7);
                    }
                    if (i <= i8) {
                        return PositionMetadata.obtain(i, 1, groupMetadata.gPos, i - (i9 + 1), groupMetadata, i7);
                    }
                }
            }
            i6 = i7;
        }
        if (i4 > i6) {
            GroupMetadata groupMetadata2 = arrayList.get(i4 - 1);
            i2 = (i - groupMetadata2.lastChildFlPos) + groupMetadata2.gPos;
        } else if (i5 < i6) {
            i4 = i5 + 1;
            GroupMetadata groupMetadata3 = arrayList.get(i4);
            i2 = groupMetadata3.gPos - (groupMetadata3.flPos - i);
        } else {
            throw new RuntimeException("Unknown state");
        }
        return PositionMetadata.obtain(i, 2, i2, -1, null, i4);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        PositionMetadata unflattenedPos = getUnflattenedPos(i);
        if (unflattenedPos.position.type == 1) {
            boolean z = unflattenedPos.groupMetadata.lastChildFlPos == i;
            ExpandableListAdapter expandableListAdapter = this.mExpandableListAdapter;
            ExpandableHListPosition expandableHListPosition = unflattenedPos.position;
            View childView = expandableListAdapter.getChildView(expandableHListPosition.groupPos, expandableHListPosition.childPos, z, view, viewGroup);
            unflattenedPos.recycle();
            return childView;
        }
        throw new RuntimeException("Flat list position is of unknown type");
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        ExpandableListAdapter expandableListAdapter = this.mExpandableListAdapter;
        if (!(expandableListAdapter instanceof HeterogeneousExpandableList)) {
            return 2;
        }
        HeterogeneousExpandableList heterogeneousExpandableList = (HeterogeneousExpandableList) expandableListAdapter;
        return heterogeneousExpandableList.getGroupTypeCount() + heterogeneousExpandableList.getChildTypeCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.mExpandableListAdapter.hasStableIds();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ExpandableListAdapter adapter = getAdapter();
        if (adapter != null) {
            return adapter.isEmpty();
        }
        return true;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        PositionMetadata unflattenedPos = getUnflattenedPos(i);
        ExpandableHListPosition expandableHListPosition = unflattenedPos.position;
        boolean isChildSelectable = expandableHListPosition.type == 1 ? this.mExpandableListAdapter.isChildSelectable(expandableHListPosition.groupPos, expandableHListPosition.childPos) : true;
        unflattenedPos.recycle();
        return isChildSelectable;
    }

    public boolean isGroupExpanded(int i) {
        for (int size = this.mExpGroupMetadataList.size() - 1; size >= 0; size--) {
            if (this.mExpGroupMetadataList.get(size).gPos == i) {
                return true;
            }
        }
        return false;
    }

    public void setExpandableListAdapter(ExpandableListAdapter expandableListAdapter) {
        ExpandableListAdapter expandableListAdapter2 = this.mExpandableListAdapter;
        if (expandableListAdapter2 != null) {
            expandableListAdapter2.unregisterDataSetObserver(this.mDataSetObserver);
        }
        this.mExpandableListAdapter = expandableListAdapter;
        expandableListAdapter.registerDataSetObserver(this.mDataSetObserver);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setExpandedGroupMetadataList(ArrayList<GroupMetadata> arrayList) {
        ExpandableListAdapter expandableListAdapter;
        if (arrayList == null || (expandableListAdapter = this.mExpandableListAdapter) == null) {
            return;
        }
        int groupCount = expandableListAdapter.getGroupCount();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).gPos >= groupCount) {
                return;
            }
        }
        this.mExpGroupMetadataList = arrayList;
        refreshExpGroupMetadataList(true, false);
    }

    public void setMaxExpGroupCount(int i) {
        this.mMaxExpGroupCount = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean collapseGroup(PositionMetadata positionMetadata) {
        GroupMetadata groupMetadata = positionMetadata.groupMetadata;
        if (groupMetadata == null) {
            return false;
        }
        this.mExpGroupMetadataList.remove(groupMetadata);
        refreshExpGroupMetadataList(false, false);
        notifyDataSetChanged();
        this.mExpandableListAdapter.onGroupCollapsed(positionMetadata.groupMetadata.gPos);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean expandGroup(PositionMetadata positionMetadata) {
        if (positionMetadata.position.groupPos >= 0) {
            if (this.mMaxExpGroupCount == 0 || positionMetadata.groupMetadata != null) {
                return false;
            }
            if (this.mExpGroupMetadataList.size() >= this.mMaxExpGroupCount) {
                GroupMetadata groupMetadata = this.mExpGroupMetadataList.get(0);
                int indexOf = this.mExpGroupMetadataList.indexOf(groupMetadata);
                collapseGroup(groupMetadata.gPos);
                int i = positionMetadata.groupInsertIndex;
                if (i > indexOf) {
                    positionMetadata.groupInsertIndex = i - 1;
                }
            }
            int i2 = positionMetadata.position.groupPos;
            GroupMetadata obtain = GroupMetadata.obtain(-1, -1, i2, this.mExpandableListAdapter.getGroupId(i2));
            this.mExpGroupMetadataList.add(positionMetadata.groupInsertIndex, obtain);
            refreshExpGroupMetadataList(false, false);
            notifyDataSetChanged();
            this.mExpandableListAdapter.onGroupExpanded(obtain.gPos);
            return true;
        }
        throw new RuntimeException("Need group");
    }
}
