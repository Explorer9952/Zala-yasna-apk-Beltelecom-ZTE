package com.tencent.mm.sdk.openapi;

import android.os.Bundle;
import com.tencent.mm.sdk.openapi.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.Log;

/* loaded from: classes.dex */
public final class GetMessageFromWX {

    /* loaded from: classes.dex */
    public static class Req extends BaseReq {
        public String username;

        public Req() {
        }

        public Req(Bundle bundle) {
            fromBundle(bundle);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.tencent.mm.sdk.openapi.BaseReq
        public final boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.sdk.openapi.BaseReq
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
        }

        @Override // com.tencent.mm.sdk.openapi.BaseReq
        public int getType() {
            return 3;
        }

        @Override // com.tencent.mm.sdk.openapi.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
        }
    }

    /* loaded from: classes.dex */
    public static class Resp extends BaseResp {
        public WXMediaMessage message;

        public Resp() {
        }

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.tencent.mm.sdk.openapi.BaseResp
        public final boolean checkArgs() {
            WXMediaMessage wXMediaMessage = this.message;
            if (wXMediaMessage != null) {
                return wXMediaMessage.checkArgs();
            }
            Log.e("MicroMsg.SDK.GetMessageFromWX.Resp", "checkArgs fail, message is null");
            return false;
        }

        @Override // com.tencent.mm.sdk.openapi.BaseResp
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.message = WXMediaMessage.Builder.fromBundle(bundle);
        }

        @Override // com.tencent.mm.sdk.openapi.BaseResp
        public int getType() {
            return 3;
        }

        @Override // com.tencent.mm.sdk.openapi.BaseResp
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putAll(WXMediaMessage.Builder.toBundle(this.message));
        }
    }

    private GetMessageFromWX() {
    }
}
