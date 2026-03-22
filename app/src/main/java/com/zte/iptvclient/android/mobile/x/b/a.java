package com.zte.iptvclient.android.mobile.x.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.api.share.IWeiboShareAPI;
import com.sina.weibo.sdk.api.share.SendMultiMessageToWeiboRequest;
import com.sina.weibo.sdk.api.share.WeiboShareSDK;
import com.sina.weibo.sdk.utils.Utility;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.SendMessageToWX;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.tencent.mm.sdk.openapi.WXMediaMessage;
import com.tencent.mm.sdk.openapi.WXTextObject;
import com.tencent.mm.sdk.openapi.WXWebpageObject;
import com.tencent.mm.sdk.plugin.MMPluginProviderConstants;
import com.video.androidsdk.common.config.ConfigMgr;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.sns.SNSHelper;
import com.video.androidsdk.sns.bean.SNSMessage;
import com.vk.api.sdk.auth.VKScope;
import com.zte.fragmentlib.SupportActivity;
import com.zte.iptvclient.android.common.k.n;
import com.zte.iptvclient.android.common.k.t;
import com.zte.iptvclient.android.zala.R;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

/* compiled from: ShareManager.java */
/* loaded from: classes2.dex */
public class a {
    private static final VKScope[] k = {VKScope.WALL, VKScope.PHOTOS, VKScope.OFFLINE};

    /* renamed from: a, reason: collision with root package name */
    private SupportActivity f7747a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f7748b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f7749c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f7750d;
    private boolean e;
    private boolean f;
    private SNSHelper g;
    private IWXAPI h;
    private String i;
    private IWeiboShareAPI j;

    /* compiled from: ShareManager.java */
    /* renamed from: com.zte.iptvclient.android.mobile.x.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0392a implements t.e {
        C0392a() {
        }

        @Override // com.zte.iptvclient.android.common.k.t.e
        public void a() {
        }

        @Override // com.zte.iptvclient.android.common.k.t.e
        public void b() {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("market://details?id=com.vkontakte.android"));
            a.this.f7747a.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShareManager.java */
    /* loaded from: classes2.dex */
    public class b implements com.vk.api.sdk.b<Integer> {
        b() {
        }

        @Override // com.vk.api.sdk.b
        public void a(Integer num) {
            Log.i("ShareManager", "onVkShareComplete" + num);
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(a.this.f7747a.getResources().getString(R.string.share_success_old));
        }

        @Override // com.vk.api.sdk.b
        public void a(@NotNull Exception exc) {
            Log.d("ShareManager", "onVkShareError" + exc.getMessage());
            com.zte.iptvclient.android.mobile.download.helper.b.b.a.a().a(a.this.f7747a.getResources().getString(R.string.share_failed));
        }
    }

    /* compiled from: ShareManager.java */
    /* loaded from: classes2.dex */
    class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("market://details?id=com.sina.weibo"));
            a.this.f7747a.startActivity(intent);
        }
    }

    /* compiled from: ShareManager.java */
    /* loaded from: classes2.dex */
    class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("market://details?id=com.sina.weibo"));
            a.this.f7747a.startActivity(intent);
        }
    }

    /* compiled from: ShareManager.java */
    /* loaded from: classes2.dex */
    class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("market://details?id=com.tencent.mm"));
            a.this.f7747a.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShareManager.java */
    /* loaded from: classes2.dex */
    public class f implements DialogInterface.OnClickListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("market://details?id=com.tencent.mm"));
            a.this.f7747a.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ShareManager.java */
    /* loaded from: classes2.dex */
    public class g implements DialogInterface.OnClickListener {
        g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("market://details?id=com.tencent.mm"));
            a.this.f7747a.startActivity(intent);
        }
    }

    /* compiled from: ShareManager.java */
    /* loaded from: classes2.dex */
    class h implements t.e {
        h() {
        }

        @Override // com.zte.iptvclient.android.common.k.t.e
        public void a() {
        }

        @Override // com.zte.iptvclient.android.common.k.t.e
        public void b() {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("market://details?id=com.facebook.katana"));
            a.this.f7747a.startActivity(intent);
        }
    }

    /* compiled from: ShareManager.java */
    /* loaded from: classes2.dex */
    class i implements t.e {
        i() {
        }

        @Override // com.zte.iptvclient.android.common.k.t.e
        public void a() {
        }

        @Override // com.zte.iptvclient.android.common.k.t.e
        public void b() {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("market://details?id=com.facebook.katana"));
            a.this.f7747a.startActivity(intent);
        }
    }

    /* compiled from: ShareManager.java */
    /* loaded from: classes2.dex */
    class j implements DialogInterface.OnClickListener {
        j() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("market://details?id=com.tencent.mm"));
            a.this.f7747a.startActivity(intent);
        }
    }

    /* compiled from: ShareManager.java */
    /* loaded from: classes2.dex */
    class k implements t.e {
        k() {
        }

        @Override // com.zte.iptvclient.android.common.k.t.e
        public void a() {
        }

        @Override // com.zte.iptvclient.android.common.k.t.e
        public void b() {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("market://details?id=com.viber.voip"));
            a.this.f7747a.startActivity(intent);
        }
    }

    public a(Activity activity) {
        if (activity instanceof SupportActivity) {
            SupportActivity supportActivity = (SupportActivity) activity;
            this.f7747a = supportActivity;
            this.f7748b = n.a(supportActivity, MMPluginProviderConstants.PluginIntent.APP_PACKAGE_PATTERN);
            n.a(this.f7747a, "com.tencent.mobileqq");
            this.f7749c = n.a(this.f7747a, "com.sina.weibo");
            this.f7750d = n.a(this.f7747a, "com.facebook.katana");
            this.e = n.a(this.f7747a, "com.vkontakte.android");
            this.f = n.a(this.f7747a, "com.viber.voip");
            this.g = new SNSHelper(SNSHelper.SNSType.FACEBOOK, null);
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(activity, com.zte.iptvclient.android.common.c.d.a(), true);
            this.h = createWXAPI;
            createWXAPI.registerApp(com.zte.iptvclient.android.common.c.d.a());
            LogEx.d("ShareManager", "");
            String c2 = com.zte.iptvclient.common.uiframe.a.c("APP_Market_URL");
            this.i = c2;
            if (TextUtils.isEmpty(c2)) {
                this.i = "www.baidu.com";
            }
        }
    }

    private TextObject b(String str) {
        TextObject textObject = new TextObject();
        textObject.text = str;
        return textObject;
    }

    private WebpageObject c(String str, String str2) {
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.actionUrl = str;
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = com.zte.iptvclient.android.common.i.a.a.a(R.string.app_name);
        webpageObject.description = str2;
        Bitmap decodeResource = BitmapFactory.decodeResource(this.f7747a.getResources(), R.drawable.ic_launcher);
        if (decodeResource != null) {
            webpageObject.setThumbImage(decodeResource);
        }
        return webpageObject;
    }

    public void a(String str, Bitmap bitmap, String str2) {
        if (this.f7749c) {
            IWeiboShareAPI createWeiboAPI = WeiboShareSDK.createWeiboAPI(this.f7747a, ConfigMgr.readPropertie("WeiboShareAppKey"));
            this.j = createWeiboAPI;
            createWeiboAPI.registerApp();
            Bitmap extractThumbnail = ThumbnailUtils.extractThumbnail(Bitmap.createBitmap(bitmap), 300, 300);
            if (TextUtils.isEmpty(str2)) {
                str2 = this.i;
            }
            WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
            weiboMultiMessage.textObject = b(str);
            weiboMultiMessage.imageObject = a(extractThumbnail);
            weiboMultiMessage.mediaObject = c(str2, str);
            SendMultiMessageToWeiboRequest sendMultiMessageToWeiboRequest = new SendMultiMessageToWeiboRequest();
            sendMultiMessageToWeiboRequest.transaction = String.valueOf(System.currentTimeMillis());
            sendMultiMessageToWeiboRequest.multiMessage = weiboMultiMessage;
            this.j.sendRequest(sendMultiMessageToWeiboRequest);
            return;
        }
        new AlertDialog.Builder(this.f7747a).setMessage(R.string.download_weibo_confirm).setPositiveButton(R.string.common_ok, new c()).setNegativeButton(R.string.common_cancel, (DialogInterface.OnClickListener) null).show();
    }

    public void b(String str, String str2) {
        if (this.f7748b) {
            WXTextObject wXTextObject = new WXTextObject();
            wXTextObject.text = str;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.description = str2;
            wXMediaMessage.title = str;
            wXMediaMessage.mediaObject = wXTextObject;
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = String.valueOf(System.currentTimeMillis());
            req.message = wXMediaMessage;
            req.scene = 1;
            this.h.sendReq(req);
            return;
        }
        new AlertDialog.Builder(this.f7747a).setMessage(R.string.download_Wechat_confirm).setPositiveButton(R.string.common_ok, new g()).setNegativeButton(R.string.common_cancel, (DialogInterface.OnClickListener) null).show();
    }

    private void c(String str) {
        com.vk.api.sdk.a.a(new com.zte.iptvclient.android.mobile.x.b.b("https://tv.zala.by/iptvepg/web/share/" + str + ".html", 0, false, false), new b());
    }

    public void b(String str, String str2, Bitmap bitmap, String str3, boolean z) {
        if (this.f7748b) {
            Bitmap extractThumbnail = ThumbnailUtils.extractThumbnail(Bitmap.createBitmap(bitmap), 100, 100);
            WXWebpageObject wXWebpageObject = new WXWebpageObject();
            if (!TextUtils.isEmpty(str3)) {
                wXWebpageObject.webpageUrl = str3;
            } else {
                if (TextUtils.isEmpty(this.i)) {
                    b(str, str2);
                    return;
                }
                wXWebpageObject.webpageUrl = this.i;
            }
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
            wXMediaMessage.title = str2;
            wXMediaMessage.description = str2;
            wXMediaMessage.setThumbImage(extractThumbnail);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = String.valueOf(System.currentTimeMillis());
            req.message = wXMediaMessage;
            req.scene = 1;
            this.h.sendReq(req);
            return;
        }
        new AlertDialog.Builder(this.f7747a).setMessage(R.string.download_Wechat_confirm).setPositiveButton(R.string.common_ok, new j()).setNegativeButton(R.string.common_cancel, (DialogInterface.OnClickListener) null).show();
    }

    private ImageObject a(Bitmap bitmap) {
        ImageObject imageObject = new ImageObject();
        imageObject.setImageObject(bitmap);
        return imageObject;
    }

    public void a(String str, String str2, Bitmap bitmap) {
        if (this.f7749c) {
            IWeiboShareAPI createWeiboAPI = WeiboShareSDK.createWeiboAPI(this.f7747a, ConfigMgr.readPropertie("WeiboShareAppKey"));
            this.j = createWeiboAPI;
            createWeiboAPI.registerApp();
            Bitmap extractThumbnail = ThumbnailUtils.extractThumbnail(Bitmap.createBitmap(bitmap), 300, 300);
            if (TextUtils.isEmpty(str2)) {
                str2 = this.i;
            }
            WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
            weiboMultiMessage.toBundle(new Bundle());
            weiboMultiMessage.textObject = b(str);
            weiboMultiMessage.mediaObject = c(str2, str);
            weiboMultiMessage.imageObject = a(extractThumbnail);
            SendMultiMessageToWeiboRequest sendMultiMessageToWeiboRequest = new SendMultiMessageToWeiboRequest();
            sendMultiMessageToWeiboRequest.transaction = String.valueOf(System.currentTimeMillis());
            sendMultiMessageToWeiboRequest.multiMessage = weiboMultiMessage;
            this.j.sendRequest(sendMultiMessageToWeiboRequest);
            return;
        }
        new AlertDialog.Builder(this.f7747a).setMessage(R.string.download_weibo_confirm).setPositiveButton(R.string.common_ok, new d()).setNegativeButton(R.string.common_cancel, (DialogInterface.OnClickListener) null).show();
    }

    public void b(String str, String str2, String str3, String str4, String str5) {
        if (this.f) {
            Uri uri = null;
            try {
                String encode = URLEncoder.encode("https://tv.zala.by/iptvepg/web/share/" + str5 + ".html", "UTF-8");
                StringBuilder sb = new StringBuilder();
                sb.append("viber://forward?text=");
                sb.append(encode);
                uri = Uri.parse(sb.toString());
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            if (uri != null) {
                LogEx.d("ShareManager", "viber = " + uri.toString());
            }
            intent.setData(uri);
            this.f7747a.startActivity(intent);
            return;
        }
        t.a(this.f7747a, com.zte.iptvclient.android.common.i.a.a.a(R.string.download_Viber_confirm), new k());
    }

    public void a(String str, String str2, Bitmap bitmap, String str3, boolean z) {
        if (this.f7748b) {
            Bitmap extractThumbnail = ThumbnailUtils.extractThumbnail(Bitmap.createBitmap(bitmap), 100, 100);
            WXWebpageObject wXWebpageObject = new WXWebpageObject();
            if (!TextUtils.isEmpty(str3)) {
                wXWebpageObject.webpageUrl = str3;
            } else {
                if (TextUtils.isEmpty(this.i)) {
                    a(str, str2);
                    return;
                }
                wXWebpageObject.webpageUrl = this.i;
            }
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
            wXMediaMessage.title = str;
            wXMediaMessage.description = str2;
            wXMediaMessage.setThumbImage(extractThumbnail);
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = String.valueOf(System.currentTimeMillis());
            req.message = wXMediaMessage;
            req.scene = 0;
            this.h.sendReq(req);
            return;
        }
        new AlertDialog.Builder(this.f7747a).setMessage(R.string.download_Wechat_confirm).setPositiveButton(R.string.common_ok, new e()).setNegativeButton(R.string.common_cancel, (DialogInterface.OnClickListener) null).show();
    }

    public void a(String str, String str2) {
        if (this.f7748b) {
            WXTextObject wXTextObject = new WXTextObject();
            wXTextObject.text = str;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.description = str2;
            wXMediaMessage.mediaObject = wXTextObject;
            SendMessageToWX.Req req = new SendMessageToWX.Req();
            req.transaction = String.valueOf(System.currentTimeMillis());
            req.message = wXMediaMessage;
            req.scene = 0;
            this.h.sendReq(req);
            return;
        }
        new AlertDialog.Builder(this.f7747a).setMessage(R.string.download_Wechat_confirm).setPositiveButton(R.string.common_ok, new f()).setNegativeButton(R.string.common_cancel, (DialogInterface.OnClickListener) null).show();
    }

    public void a(String str, String str2, String str3) {
        if (this.f7750d) {
            this.g.onCreate(null, this.f7747a, null);
            SNSMessage sNSMessage = new SNSMessage();
            if (!TextUtils.isEmpty(str3)) {
                sNSMessage.setPicURL(str3);
                LogEx.d("ShareManager", "strImageURL=" + str3);
            }
            if (!TextUtils.isEmpty(this.i)) {
                sNSMessage.setLinkURL(this.i);
                LogEx.d("ShareManager", "url=" + this.i);
            }
            if (!TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(this.i)) {
                    str2 = str2 + " " + this.i;
                }
                sNSMessage.setText(str2);
                LogEx.d("ShareManager", "txt=" + str2);
            }
            if (!TextUtils.isEmpty(str)) {
                sNSMessage.setTitle(str);
                LogEx.d("ShareManager", "title=" + str);
            }
            sNSMessage.setDescription("");
            this.g.sendMessage(this.f7747a, sNSMessage, null);
            return;
        }
        t.a(this.f7747a, com.zte.iptvclient.android.common.i.a.a.a(R.string.download_Facebook_confirm), new h());
    }

    public void a(String str, String str2, String str3, String str4, String str5) {
        if (this.f7750d) {
            this.g.onCreate(null, this.f7747a, null);
            SNSMessage sNSMessage = new SNSMessage();
            sNSMessage.setLinkURL("https://tv.zala.by/iptvepg/web/share/" + str5 + ".html");
            StringBuilder sb = new StringBuilder();
            sb.append("strImageURL=");
            sb.append(str4);
            LogEx.d("ShareManager", sb.toString());
            LogEx.d("ShareManager", "LinkURL=  https://tv.zala.by/iptvepg/web/share/" + str5 + ".html");
            this.g.sendMessage(this.f7747a, sNSMessage, null);
            return;
        }
        t.a(this.f7747a, com.zte.iptvclient.android.common.i.a.a.a(R.string.download_Facebook_confirm), new i());
    }

    public void a(String str) {
        if (this.e) {
            if (com.vk.api.sdk.a.d()) {
                LogEx.d("ShareManager", "vkislogin");
                c(str);
                return;
            } else {
                com.vk.api.sdk.a.a(this.f7747a, Arrays.asList(k));
                return;
            }
        }
        t.a(this.f7747a, com.zte.iptvclient.android.common.i.a.a.a(R.string.download_VK_confirm), new C0392a());
    }
}
