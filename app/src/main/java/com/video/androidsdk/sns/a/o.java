package com.video.androidsdk.sns.a;

import android.os.Bundle;
import com.tencent.mm.sdk.openapi.BaseReq;
import com.tencent.mm.sdk.openapi.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.ShowMessageFromWX;
import com.tencent.mm.sdk.openapi.WXAppExtendObject;
import com.tencent.mm.sdk.openapi.WXMediaMessage;
import com.video.androidsdk.log.LogEx;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TencentWechat.java */
/* loaded from: classes.dex */
public class o implements IWXAPIEventHandler {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ n f3860a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.f3860a = nVar;
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
        String str;
        String str2;
        String str3;
        String str4;
        str = n.g;
        LogEx.i(str, "receive tencent wechat request!");
        int type = baseReq.getType();
        if (type == 3) {
            str2 = n.g;
            LogEx.d(str2, "receive tencent wechat request!");
            return;
        }
        if (type != 4) {
            str4 = n.g;
            LogEx.d(str4, "Unknow type!");
            return;
        }
        WXMediaMessage wXMediaMessage = ((ShowMessageFromWX.Req) baseReq).message;
        WXAppExtendObject wXAppExtendObject = (WXAppExtendObject) wXMediaMessage.mediaObject;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("title: ");
        stringBuffer.append(wXMediaMessage.title);
        stringBuffer.append("\ndescription: ");
        stringBuffer.append(wXMediaMessage.description);
        stringBuffer.append("\nextInfo: ");
        stringBuffer.append(wXAppExtendObject.extInfo);
        stringBuffer.append("\nfilePath: ");
        stringBuffer.append(wXAppExtendObject.filePath);
        byte[] bArr = wXMediaMessage.thumbData;
        if (bArr != null && bArr.length > 0) {
            stringBuffer.append("\nContains thumb");
        }
        str3 = n.g;
        LogEx.d(str3, "receive tencent wechat request!" + stringBuffer.toString());
    }

    @Override // com.tencent.mm.sdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        str = n.g;
        LogEx.d(str, "Tencent wechat response!Code:" + baseResp.errCode + " Msg:" + baseResp.errStr);
        int i = baseResp.errCode;
        if (i == -4) {
            str2 = n.g;
            LogEx.i(str2, "Auth denied!");
        } else if (i == -2) {
            str4 = n.g;
            LogEx.i(str4, "User cancel!");
        } else if (i != 0) {
            str6 = n.g;
            LogEx.i(str6, "Unknow:" + baseResp.errStr);
        } else {
            str5 = n.g;
            LogEx.i(str5, "Success!");
        }
        Bundle bundle = new Bundle();
        baseResp.toBundle(bundle);
        for (String str7 : bundle.keySet()) {
            str3 = n.g;
            LogEx.d(str3, "key:" + str7 + " value:" + bundle.get(str7));
        }
    }
}
