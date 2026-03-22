package com.zte.iptvclient.android.mobile.k.b;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.zte.iptvclient.android.mobile.history.ui.ChildWatchHistoryView;

/* compiled from: ChildTodayWatchHistoryFragment.java */
/* loaded from: classes.dex */
public class b extends com.zte.fragmentlib.b {
    private ChildWatchHistoryView p;
    private boolean q;

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.q) {
            return;
        }
        this.p.b();
        this.q = true;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ChildWatchHistoryView childWatchHistoryView = new ChildWatchHistoryView(getContext());
        childWatchHistoryView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        childWatchHistoryView.b(true);
        childWatchHistoryView.a(false);
        childWatchHistoryView.a(1);
        this.p = childWatchHistoryView;
        return childWatchHistoryView;
    }

    @Override // com.zte.fragmentlib.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.p.a();
    }
}
