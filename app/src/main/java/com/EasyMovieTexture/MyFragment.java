package com.EasyMovieTexture;

import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.view.View;

/* loaded from: classes.dex */
public class MyFragment extends PreferenceFragment {

    /* renamed from: a, reason: collision with root package name */
    private Context f1876a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MyFragment(Context context) {
        this.f1876a = context;
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getPreferenceManager().setSharedPreferencesMode(0);
        getPreferenceManager().setSharedPreferencesName(this.f1876a.getPackageName() + ".v2.playerprefs");
        addPreferencesFromResource(this.f1876a.getResources().getIdentifier("pref_my", "xml", this.f1876a.getPackageName()));
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }
}
