package com.video.androidsdk.sns.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginManager;
import com.facebook.share.ShareApi;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;
import com.video.androidsdk.common.ClientNetworkInfo;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.sns.IFacebook;
import com.video.androidsdk.sns.ISNSActionListener;
import com.video.androidsdk.sns.ISNSAuthListener;
import com.video.androidsdk.sns.bean.OAuth2Param;
import com.video.androidsdk.sns.bean.SNSMessage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: FacebookHelper.java */
/* loaded from: classes.dex */
public class b implements IFacebook {

    /* renamed from: a, reason: collision with root package name */
    static b f3825a = null;

    /* renamed from: d, reason: collision with root package name */
    private static final String f3826d = "b";

    /* renamed from: b, reason: collision with root package name */
    ISNSActionListener f3827b;

    /* renamed from: c, reason: collision with root package name */
    WeakReference<Activity> f3828c;
    private boolean g;
    private boolean h;
    private CallbackManager i;
    private ProfileTracker j;
    private ShareDialog k;
    private SNSMessage l;
    private final String e = "com.video.android.sns:PendingAction";
    private a f = a.NONE;
    private FacebookCallback<Sharer.Result> m = new c(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FacebookHelper.java */
    /* loaded from: classes.dex */
    public enum a {
        NONE,
        POST_PHOTO,
        POST_STATUS_UPDATE
    }

    public static b a() {
        if (f3825a == null) {
            f3825a = new b();
        }
        return f3825a;
    }

    private void b() {
        this.i = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(this.i, new d(this));
        ShareDialog shareDialog = new ShareDialog(this.f3828c.get());
        this.k = shareDialog;
        shareDialog.registerCallback(this.i, this.m);
        this.j = new e(this);
    }

    private void c() {
        a aVar = this.f;
        this.f = a.NONE;
        int i = f.f3836a[aVar.ordinal()];
        if (i == 1) {
            LogEx.d(f3826d, "facebook : start postPhoto");
            d();
        } else {
            if (i != 2) {
                return;
            }
            LogEx.d(f3826d, "facebook : start postStatusUpdate");
            e();
        }
    }

    private void d() {
        SNSMessage sNSMessage = this.l;
        if (sNSMessage == null) {
            return;
        }
        SharePhoto build = new SharePhoto.Builder().setBitmap(sNSMessage.getBitmap()).build();
        ArrayList arrayList = new ArrayList();
        arrayList.add(build);
        SharePhotoContent build2 = new SharePhotoContent.Builder().setPhotos(arrayList).build();
        if (ShareDialog.canShow((Class<? extends ShareContent>) SharePhotoContent.class)) {
            this.k.show(build2);
            return;
        }
        if (f()) {
            ShareApi.share(build2, this.m);
            return;
        }
        Activity activity = this.f3828c.get();
        if (activity == null) {
            LogEx.d(f3826d, "facebook ref is null");
            ISNSActionListener iSNSActionListener = this.f3827b;
            if (iSNSActionListener != null) {
                iSNSActionListener.onFail(6, "You need got publish_actions permission frist.");
                return;
            }
            return;
        }
        this.f = a.POST_PHOTO;
        LoginManager.getInstance().logInWithPublishPermissions(activity, Arrays.asList("publish_actions"));
    }

    private void e() {
        SNSMessage sNSMessage = this.l;
        if (sNSMessage == null) {
            LogEx.d(f3826d, "facebook tmpMsg is null");
            return;
        }
        String text = sNSMessage.getText();
        String title = this.l.getTitle();
        String description = this.l.getDescription();
        String picURL = this.l.getPicURL() == null ? "" : this.l.getPicURL();
        String linkURL = this.l.getLinkURL() != null ? this.l.getLinkURL() : "";
        LogEx.d(f3826d, "facebook: message: " + text + ", title: " + title + ", desc" + description + ", picLink" + picURL + ",link" + linkURL);
        Profile currentProfile = Profile.getCurrentProfile();
        ShareLinkContent build = new ShareLinkContent.Builder().setContentTitle(title).setContentDescription(description).setContentUrl(Uri.parse(linkURL)).setImageUrl(Uri.parse(picURL)).build();
        if (ShareDialog.canShow((Class<? extends ShareContent>) ShareLinkContent.class)) {
            this.k.show(build);
            return;
        }
        if (currentProfile != null && f()) {
            ShareApi.share(build, this.m);
            return;
        }
        LogEx.d(f3826d, "facebook return listener");
        Activity activity = this.f3828c.get();
        if (activity == null) {
            LogEx.d(f3826d, "facebook ref is null");
            ISNSActionListener iSNSActionListener = this.f3827b;
            if (iSNSActionListener != null) {
                iSNSActionListener.onFail(6, "You need got publish_actions permission frist.");
                return;
            }
            return;
        }
        this.f = a.POST_STATUS_UPDATE;
        LoginManager.getInstance().logInWithPublishPermissions(activity, Arrays.asList("publish_actions"));
    }

    private boolean f() {
        return AccessToken.isCurrentAccessTokenActive() && AccessToken.getCurrentAccessToken().getPermissions().contains("publish_actions");
    }

    @Override // com.video.androidsdk.sns.ISNSWrapper
    public void authorize(Context context, ISNSAuthListener iSNSAuthListener) {
    }

    @Override // com.video.androidsdk.sns.ISNSWrapper
    public int init(Context context, OAuth2Param oAuth2Param) {
        if (context == null || !(context instanceof Activity)) {
            if (context == null) {
                return 1;
            }
            LogEx.d(f3826d, "Activity: " + context.getClass().getName());
            return 1;
        }
        WeakReference<Activity> weakReference = this.f3828c;
        if (weakReference == null) {
            this.f3828c = new WeakReference<>((Activity) context);
        } else {
            Activity activity = weakReference.get();
            if (activity == null || !activity.equals(context)) {
                this.f3828c = new WeakReference<>((Activity) context);
            }
        }
        b();
        return 0;
    }

    @Override // com.video.androidsdk.sns.ISNSWrapper
    public boolean isAuth() {
        return true;
    }

    @Override // com.video.androidsdk.sns.IFacebook
    public void onActivityResult(int i, int i2, Intent intent) {
        this.i.onActivityResult(i, i2, intent);
    }

    @Override // com.video.androidsdk.sns.IFacebook
    public void onCreate(Bundle bundle, Context context) {
        if (context == null || !(context instanceof Activity)) {
            if (context != null) {
                LogEx.d(f3826d, "Activity: " + context.getClass().getName());
                return;
            }
            return;
        }
        WeakReference<Activity> weakReference = this.f3828c;
        if (weakReference == null) {
            this.f3828c = new WeakReference<>((Activity) context);
        } else {
            Activity activity = weakReference.get();
            if (activity == null || !activity.equals(context)) {
                this.f3828c = new WeakReference<>((Activity) context);
            }
        }
        if (bundle != null) {
            this.f = a.valueOf(bundle.getString("com.video.android.sns:PendingAction"));
        }
        this.g = ShareDialog.canShow((Class<? extends ShareContent>) ShareLinkContent.class);
        this.h = ShareDialog.canShow((Class<? extends ShareContent>) SharePhotoContent.class);
        b();
    }

    @Override // com.video.androidsdk.sns.IFacebook
    public void onDestroy() {
        this.j.stopTracking();
        LoginManager.getInstance().unregisterCallback(this.i);
    }

    @Override // com.video.androidsdk.sns.IFacebook
    public void onPause(Context context) {
    }

    @Override // com.video.androidsdk.sns.IFacebook
    public void onResume(Context context) {
    }

    @Override // com.video.androidsdk.sns.IFacebook
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putString("com.video.android.sns:PendingAction", this.f.name());
    }

    @Override // com.video.androidsdk.sns.ISNSWrapper
    public int sendMessage(Context context, SNSMessage sNSMessage, ISNSActionListener iSNSActionListener) {
        if (sNSMessage == null) {
            LogEx.d(f3826d, "sendMessage - msg is null.");
            return 1;
        }
        if (context != null && (context instanceof Activity)) {
            if (!ClientNetworkInfo.isNetworkAvailable((ConnectivityManager) context.getSystemService("connectivity"))) {
                LogEx.d(f3826d, "sendMessage - network invalid.");
                return 153;
            }
            WeakReference<Activity> weakReference = this.f3828c;
            if (weakReference == null) {
                LogEx.e(f3826d, "sendMessage - need reinit!");
                if (iSNSActionListener != null) {
                    iSNSActionListener.onFail(2, "Need reinit!");
                }
                return 2;
            }
            Activity activity = weakReference.get();
            if (activity != null && activity.equals(context)) {
                this.l = sNSMessage;
                this.f3827b = iSNSActionListener;
                if (sNSMessage.getBitmap() != null) {
                    this.f = a.POST_PHOTO;
                } else {
                    this.f = a.POST_STATUS_UPDATE;
                }
                LogEx.d(f3826d, "facebook: start to handlePendingAction");
                c();
                return 0;
            }
            LogEx.e(f3826d, "sendMessage - need reinit!");
            if (iSNSActionListener != null) {
                iSNSActionListener.onFail(2, "Need reinit!");
            }
            return 2;
        }
        LogEx.d(f3826d, "sendMessage - context invalid.");
        return 1;
    }
}
