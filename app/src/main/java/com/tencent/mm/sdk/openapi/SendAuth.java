package com.tencent.mm.sdk.openapi;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.Log;

/* loaded from: classes.dex */
public final class SendAuth {

    /* loaded from: classes.dex */
    public static class Req extends BaseReq {
        public String scope;
        public String state;

        public Req() {
        }

        public Req(Bundle bundle) {
            fromBundle(bundle);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.tencent.mm.sdk.openapi.BaseReq
        public final boolean checkArgs() {
            String str;
            String str2 = this.scope;
            if (str2 == null || str2.length() == 0 || this.scope.length() > 1024) {
                str = "checkArgs fail, scope is invalid";
            } else {
                String str3 = this.state;
                if (str3 == null || str3.length() <= 1024) {
                    return true;
                }
                str = "checkArgs fail, state is invalid";
            }
            Log.e("MicroMsg.SDK.SendAuth.Req", str);
            return false;
        }

        @Override // com.tencent.mm.sdk.openapi.BaseReq
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.scope = bundle.getString("_wxapi_sendauth_req_scope");
            this.state = bundle.getString("_wxapi_sendauth_req_state");
        }

        @Override // com.tencent.mm.sdk.openapi.BaseReq
        public int getType() {
            return 1;
        }

        @Override // com.tencent.mm.sdk.openapi.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_sendauth_req_scope", this.scope);
            bundle.putString("_wxapi_sendauth_req_state", this.state);
        }
    }

    /* loaded from: classes.dex */
    public static class Resp extends BaseResp {
        public int expireDate;
        public String resultUrl;
        public String state;
        public String token;
        public String userName;

        public Resp() {
        }

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.tencent.mm.sdk.openapi.BaseResp
        public final boolean checkArgs() {
            String str = this.state;
            if (str == null || str.length() <= 1024) {
                return true;
            }
            Log.e("MicroMsg.SDK.SendAuth.Resp", "checkArgs fail, state is invalid");
            return false;
        }

        @Override // com.tencent.mm.sdk.openapi.BaseResp
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.userName = bundle.getString("_wxapi_sendauth_resp_userName");
            this.token = bundle.getString("_wxapi_sendauth_resp_token");
            this.expireDate = bundle.getInt("_wxapi_sendauth_resp_expireDate", 0);
            this.state = bundle.getString("_wxapi_sendauth_resp_state");
        }

        @Override // com.tencent.mm.sdk.openapi.BaseResp
        public int getType() {
            return 1;
        }

        @Override // com.tencent.mm.sdk.openapi.BaseResp
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString("_wxapi_sendauth_resp_userName", this.userName);
            bundle.putString("_wxapi_sendauth_resp_token", this.token);
            bundle.putInt("_wxapi_sendauth_resp_expireDate", this.expireDate);
            bundle.putString("_wxapi_sendauth_resp_state", this.state);
        }
    }

    private SendAuth() {
    }
}
