package com.video.androidsdk.sns;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* loaded from: classes.dex */
public interface IFacebook extends ISNSWrapper {
    void onActivityResult(int i, int i2, Intent intent);

    void onCreate(Bundle bundle, Context context);

    void onDestroy();

    void onPause(Context context);

    void onResume(Context context);

    void onSaveInstanceState(Bundle bundle);
}
