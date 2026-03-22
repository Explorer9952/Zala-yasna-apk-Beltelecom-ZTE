package com.zte.iptvclient.common.uiframe;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.video.androidsdk.log.LogEx;

/* loaded from: classes2.dex */
public class BaseFragmentActivity extends FragmentActivity {

    /* renamed from: a, reason: collision with root package name */
    public static final String f7872a = BaseFragmentActivity.class.getSimpleName();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        LogEx.i(f7872a, "onCreate called.");
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        LogEx.i(f7872a, "onDestroy called.");
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        LogEx.i(f7872a, "onPause called.");
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        LogEx.i(f7872a, "onResume called.");
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        LogEx.i(f7872a, "onStart called.");
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        LogEx.i(f7872a, "onStop called.");
        super.onStop();
    }
}
