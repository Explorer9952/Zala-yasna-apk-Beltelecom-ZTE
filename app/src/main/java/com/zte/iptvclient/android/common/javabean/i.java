package com.zte.iptvclient.android.common.javabean;

import com.video.androidsdk.sns.Constants;
import org.json.JSONObject;

/* compiled from: ReplyBean.java */
/* loaded from: classes.dex */
public class i {
    public static i a(JSONObject jSONObject) {
        i iVar = new i();
        try {
            iVar.a(jSONObject.optString("content"));
            iVar.b(jSONObject.optString("createtime"));
            iVar.c(jSONObject.optString("replyid"));
            iVar.d(jSONObject.optString(Constants.SINA_WEIBO_UID));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iVar;
    }

    public void a(String str) {
    }

    public void b(String str) {
    }

    public void c(String str) {
    }

    public void d(String str) {
    }
}
