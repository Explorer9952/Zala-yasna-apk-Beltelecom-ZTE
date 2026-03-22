package com.EasyMovieTexture;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import com.google.android.exoplayer2.text.ttml.TtmlNode;

/* loaded from: classes.dex */
public class VRSettings extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Resources resources = getResources();
        setContentView(resources.getIdentifier("activity_with_preference_fragment", TtmlNode.TAG_LAYOUT, getPackageName()));
        getFragmentManager().beginTransaction().replace(resources.getIdentifier("fl", "id", getPackageName()), new MyFragment(this)).commit();
    }
}
