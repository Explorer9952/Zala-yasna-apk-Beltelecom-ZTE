package com.sina.weibo.sdk.api;

import android.os.Bundle;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.utils.LogUtil;

/* loaded from: classes.dex */
public final class WeiboMultiMessage {
    private static final String TAG = "WeiboMultiMessage";
    public ImageObject imageObject;
    public BaseMediaObject mediaObject;
    public TextObject textObject;

    public WeiboMultiMessage() {
    }

    public boolean checkArgs() {
        TextObject textObject = this.textObject;
        if (textObject != null && !textObject.checkArgs()) {
            LogUtil.e(TAG, "checkArgs fail, textObject is invalid");
            return false;
        }
        ImageObject imageObject = this.imageObject;
        if (imageObject != null && !imageObject.checkArgs()) {
            LogUtil.e(TAG, "checkArgs fail, imageObject is invalid");
            return false;
        }
        BaseMediaObject baseMediaObject = this.mediaObject;
        if (baseMediaObject != null && !baseMediaObject.checkArgs()) {
            LogUtil.e(TAG, "checkArgs fail, mediaObject is invalid");
            return false;
        }
        if (this.textObject != null || this.imageObject != null || this.mediaObject != null) {
            return true;
        }
        LogUtil.e(TAG, "checkArgs fail, textObject and imageObject and mediaObject is null");
        return false;
    }

    public Bundle toBundle(Bundle bundle) {
        TextObject textObject = this.textObject;
        if (textObject != null) {
            bundle.putParcelable(WBConstants.Msg.TEXT, textObject);
            bundle.putString(WBConstants.Msg.TEXT_EXTRA, this.textObject.toExtraMediaString());
        }
        ImageObject imageObject = this.imageObject;
        if (imageObject != null) {
            bundle.putParcelable(WBConstants.Msg.IMAGE, imageObject);
            bundle.putString(WBConstants.Msg.IMAGE_EXTRA, this.imageObject.toExtraMediaString());
        }
        BaseMediaObject baseMediaObject = this.mediaObject;
        if (baseMediaObject != null) {
            bundle.putParcelable(WBConstants.Msg.MEDIA, baseMediaObject);
            bundle.putString(WBConstants.Msg.MEDIA_EXTRA, this.mediaObject.toExtraMediaString());
        }
        return bundle;
    }

    public WeiboMultiMessage toObject(Bundle bundle) {
        TextObject textObject = (TextObject) bundle.getParcelable(WBConstants.Msg.TEXT);
        this.textObject = textObject;
        if (textObject != null) {
            textObject.toExtraMediaObject(bundle.getString(WBConstants.Msg.TEXT_EXTRA));
        }
        ImageObject imageObject = (ImageObject) bundle.getParcelable(WBConstants.Msg.IMAGE);
        this.imageObject = imageObject;
        if (imageObject != null) {
            imageObject.toExtraMediaObject(bundle.getString(WBConstants.Msg.IMAGE_EXTRA));
        }
        BaseMediaObject baseMediaObject = (BaseMediaObject) bundle.getParcelable(WBConstants.Msg.MEDIA);
        this.mediaObject = baseMediaObject;
        if (baseMediaObject != null) {
            baseMediaObject.toExtraMediaObject(bundle.getString(WBConstants.Msg.MEDIA_EXTRA));
        }
        return this;
    }

    public WeiboMultiMessage(Bundle bundle) {
        toBundle(bundle);
    }
}
