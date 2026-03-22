package it.sephiroth.android.library.util.v11;

import android.annotation.TargetApi;
import android.view.ActionMode;

@TargetApi(11)
/* loaded from: classes2.dex */
public interface MultiChoiceModeListener extends ActionMode.Callback {
    void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z);
}
