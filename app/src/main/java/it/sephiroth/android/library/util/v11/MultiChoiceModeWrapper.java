package it.sephiroth.android.library.util.v11;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import it.sephiroth.android.library.widget.AbsHListView;

/* loaded from: classes2.dex */
public class MultiChoiceModeWrapper implements MultiChoiceModeListener {
    private AbsHListView mView;
    private MultiChoiceModeListener mWrapped;

    public MultiChoiceModeWrapper(AbsHListView absHListView) {
        this.mView = absHListView;
    }

    public boolean hasWrappedCallback() {
        return this.mWrapped != null;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.mWrapped.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        if (!this.mWrapped.onCreateActionMode(actionMode, menu)) {
            return false;
        }
        this.mView.setLongClickable(false);
        return true;
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public void onDestroyActionMode(ActionMode actionMode) {
        this.mWrapped.onDestroyActionMode(actionMode);
        AbsHListView absHListView = this.mView;
        absHListView.mChoiceActionMode = null;
        absHListView.clearChoices();
        AbsHListView absHListView2 = this.mView;
        absHListView2.mDataChanged = true;
        absHListView2.rememberSyncState();
        this.mView.requestLayout();
        this.mView.setLongClickable(true);
    }

    @Override // it.sephiroth.android.library.util.v11.MultiChoiceModeListener
    @TargetApi(11)
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        this.mWrapped.onItemCheckedStateChanged(actionMode, i, j, z);
        if (this.mView.getCheckedItemCount() == 0) {
            actionMode.finish();
        }
    }

    @Override // android.view.ActionMode.Callback
    @TargetApi(11)
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.mWrapped.onPrepareActionMode(actionMode, menu);
    }

    public void setWrapped(MultiChoiceModeListener multiChoiceModeListener) {
        this.mWrapped = multiChoiceModeListener;
    }
}
