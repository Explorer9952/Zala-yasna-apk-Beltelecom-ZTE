package com.video.androidsdk.sns;

import com.video.androidsdk.sns.a.a;
import com.video.androidsdk.sns.a.b;
import com.video.androidsdk.sns.a.g;
import com.video.androidsdk.sns.a.h;
import com.video.androidsdk.sns.a.n;

/* loaded from: classes.dex */
public class SNSFactory {
    public static final String EMAIL = "email";
    public static final String FACEBOOK = "facebook";
    public static final String SMS = "sms";
    public static final String WECHAT_FRIENDS = "wechat.friends";
    public static final String WECHAT_MOMENTS = "wechat.moments";
    public static final String WEIBO_SINA = "weibo.sina";
    public static final String WEIBO_TENCENT = "weibo.tencent";

    public static ISNSWrapper createSNSObject(String str) {
        if (str == null) {
            return null;
        }
        if (str.equalsIgnoreCase(WEIBO_SINA)) {
            return h.a();
        }
        if (str.equalsIgnoreCase(WECHAT_FRIENDS)) {
            n a2 = n.a();
            a2.setScene(0);
            return a2;
        }
        if (str.equalsIgnoreCase(WECHAT_MOMENTS)) {
            n a3 = n.a();
            a3.setScene(1);
            return a3;
        }
        if (str.equalsIgnoreCase(FACEBOOK)) {
            return b.a();
        }
        if (str.equalsIgnoreCase(SMS)) {
            return g.a();
        }
        if (str.equalsIgnoreCase("email")) {
            return a.a();
        }
        return null;
    }
}
