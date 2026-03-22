package com.zte.iptvclient.android.mobile.x.b;

import com.facebook.share.internal.ShareConstants;
import com.video.androidsdk.log.LogEx;
import com.vk.api.sdk.e;
import com.vk.api.sdk.exceptions.VKApiException;
import com.vk.api.sdk.f;
import com.vk.api.sdk.j;
import java.io.IOException;
import org.json.JSONObject;

/* compiled from: VKWallPostCommandNew.java */
/* loaded from: classes2.dex */
public class b extends com.vk.api.sdk.internal.a {

    /* renamed from: a, reason: collision with root package name */
    private String f7762a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f7763b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f7764c;

    /* compiled from: VKWallPostCommandNew.java */
    /* renamed from: com.zte.iptvclient.android.mobile.x.b.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0393b implements f<Integer> {
        private C0393b(b bVar) {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vk.api.sdk.f
        public Integer a(String str) throws VKApiException {
            int i;
            try {
                i = new JSONObject(str).getJSONObject("response").getInt(ShareConstants.WEB_DIALOG_RESULT_PARAM_POST_ID);
            } catch (Exception unused) {
                i = -1;
            }
            return Integer.valueOf(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str, int i, boolean z, boolean z2) {
        this.f7762a = null;
        this.f7763b = false;
        this.f7764c = false;
        this.f7762a = str;
        this.f7763b = z;
        this.f7764c = z2;
    }

    @Override // com.vk.api.sdk.internal.a
    protected Object b(e eVar) throws InterruptedException, IOException, VKApiException {
        j.a aVar = new j.a();
        aVar.a("wall.post");
        aVar.a("friends_only", Integer.valueOf(this.f7763b ? 1 : 0));
        aVar.a("from_group", Integer.valueOf(this.f7764c ? 1 : 0));
        aVar.a("attachments", this.f7762a);
        aVar.b(eVar.a().n());
        j a2 = aVar.a();
        LogEx.d("VKWallPostCommandNew", "callBuilder = " + a2.toString());
        return eVar.b(a2, new C0393b());
    }
}
