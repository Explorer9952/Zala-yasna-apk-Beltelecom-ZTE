package com.tencent.mm.sdk.openapi;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayOutputStream;

/* loaded from: classes.dex */
public final class WXMediaMessage {
    public static final String ACTION_WXAPPMESSAGE = "com.tencent.mm.sdk.openapi.Intent.ACTION_WXAPPMESSAGE";
    public String description;
    public IMediaObject mediaObject;
    public int sdkVer;
    public byte[] thumbData;
    public String title;

    /* loaded from: classes.dex */
    public static class Builder {
        public static final String KEY_IDENTIFIER = "_wxobject_identifier_";

        public static WXMediaMessage fromBundle(Bundle bundle) {
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.sdkVer = bundle.getInt("_wxobject_sdkVer");
            wXMediaMessage.title = bundle.getString("_wxobject_title");
            wXMediaMessage.description = bundle.getString("_wxobject_description");
            wXMediaMessage.thumbData = bundle.getByteArray("_wxobject_thumbdata");
            String string = bundle.getString(KEY_IDENTIFIER);
            if (string != null && string.length() > 0) {
                try {
                    IMediaObject iMediaObject = (IMediaObject) Class.forName(string).newInstance();
                    wXMediaMessage.mediaObject = iMediaObject;
                    iMediaObject.unserialize(bundle);
                    return wXMediaMessage;
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("MicroMsg.SDK.WXMediaMessage", "get media object from bundle failed: unknown ident " + string);
                }
            }
            return wXMediaMessage;
        }

        public static Bundle toBundle(WXMediaMessage wXMediaMessage) {
            Bundle bundle = new Bundle();
            bundle.putInt("_wxobject_sdkVer", wXMediaMessage.sdkVer);
            bundle.putString("_wxobject_title", wXMediaMessage.title);
            bundle.putString("_wxobject_description", wXMediaMessage.description);
            bundle.putByteArray("_wxobject_thumbdata", wXMediaMessage.thumbData);
            IMediaObject iMediaObject = wXMediaMessage.mediaObject;
            if (iMediaObject != null) {
                bundle.putString(KEY_IDENTIFIER, iMediaObject.getClass().getName());
                wXMediaMessage.mediaObject.serialize(bundle);
            }
            return bundle;
        }
    }

    /* loaded from: classes.dex */
    public interface IMediaObject {
        public static final int TYPE_APPDATA = 7;
        public static final int TYPE_EMOJI = 8;
        public static final int TYPE_FILE = 6;
        public static final int TYPE_IMAGE = 2;
        public static final int TYPE_MUSIC = 3;
        public static final int TYPE_TEXT = 1;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_URL = 5;
        public static final int TYPE_VIDEO = 4;

        boolean checkArgs();

        void serialize(Bundle bundle);

        int type();

        void unserialize(Bundle bundle);
    }

    public WXMediaMessage() {
        this(null);
    }

    public WXMediaMessage(IMediaObject iMediaObject) {
        this.mediaObject = iMediaObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean checkArgs() {
        String str;
        byte[] bArr;
        if (getType() == 8 && ((bArr = this.thumbData) == null || bArr.length == 0)) {
            str = "checkArgs fail, thumbData should not be null when send emoji";
        } else {
            byte[] bArr2 = this.thumbData;
            if (bArr2 == null || bArr2.length <= 32768) {
                String str2 = this.title;
                if (str2 == null || str2.length() <= 512) {
                    String str3 = this.description;
                    if (str3 == null || str3.length() <= 1024) {
                        IMediaObject iMediaObject = this.mediaObject;
                        if (iMediaObject != null) {
                            return iMediaObject.checkArgs();
                        }
                        str = "checkArgs fail, mediaObject is null";
                    } else {
                        str = "checkArgs fail, description is invalid";
                    }
                } else {
                    str = "checkArgs fail, title is invalid";
                }
            } else {
                str = "checkArgs fail, thumbData is invalid";
            }
        }
        Log.e("MicroMsg.SDK.WXMediaMessage", str);
        return false;
    }

    public final int getType() {
        IMediaObject iMediaObject = this.mediaObject;
        if (iMediaObject == null) {
            return 0;
        }
        return iMediaObject.type();
    }

    public final void setThumbImage(Bitmap bitmap) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
            this.thumbData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("MicroMsg.SDK.WXMediaMessage", "put thumb failed");
        }
    }
}
