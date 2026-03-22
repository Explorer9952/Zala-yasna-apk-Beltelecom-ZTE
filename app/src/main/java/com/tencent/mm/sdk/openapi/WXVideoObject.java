package com.tencent.mm.sdk.openapi;

import android.os.Bundle;
import com.tencent.mm.sdk.openapi.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.Log;

/* loaded from: classes.dex */
public class WXVideoObject implements WXMediaMessage.IMediaObject {
    public String videoLowBandUrl;
    public String videoUrl;

    @Override // com.tencent.mm.sdk.openapi.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        String str;
        String str2;
        String str3 = this.videoUrl;
        if ((str3 == null || str3.length() == 0) && ((str = this.videoLowBandUrl) == null || str.length() == 0)) {
            str2 = "both arguments are null";
        } else {
            String str4 = this.videoUrl;
            if (str4 == null || str4.length() <= 10240) {
                String str5 = this.videoLowBandUrl;
                if (str5 == null || str5.length() <= 10240) {
                    return true;
                }
                str2 = "checkArgs fail, videoLowBandUrl is too long";
            } else {
                str2 = "checkArgs fail, videoUrl is too long";
            }
        }
        Log.e("MicroMsg.SDK.WXVideoObject", str2);
        return false;
    }

    @Override // com.tencent.mm.sdk.openapi.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putString("_wxvideoobject_videoUrl", this.videoUrl);
        bundle.putString("_wxvideoobject_videoLowBandUrl", this.videoLowBandUrl);
    }

    @Override // com.tencent.mm.sdk.openapi.WXMediaMessage.IMediaObject
    public int type() {
        return 4;
    }

    @Override // com.tencent.mm.sdk.openapi.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.videoUrl = bundle.getString("_wxvideoobject_videoUrl");
        this.videoLowBandUrl = bundle.getString("_wxvideoobject_videoLowBandUrl");
    }
}
