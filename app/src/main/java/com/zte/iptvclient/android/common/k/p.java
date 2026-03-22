package com.zte.iptvclient.android.common.k;

import android.text.TextUtils;
import android.widget.ImageView;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.login.SDKLoginMgr;
import com.zte.iptvclient.android.common.BaseApp;
import com.zte.servicesdk.util.PortalConst;
import java.util.Arrays;
import java.util.List;

/* compiled from: RatingHelper.java */
/* loaded from: classes.dex */
public class p {
    public static String a(String str) {
        String str2 = SDKLoginMgr.getInstance().getFrameHome() + "/images/" + str;
        LogEx.d("RatingHelper", "imageUrl = " + str2);
        return str2;
    }

    public static List<String> b() {
        String propertiesInfo = SDKLoginMgr.getInstance().getPropertiesInfo(PortalConst.STR_PARENT_CONTROL_LIMIT_LEVEL_VALUE);
        LogEx.d("RatingHelper", "Parent_Control_Limit_Level_Value: " + propertiesInfo);
        if (TextUtils.isEmpty(propertiesInfo)) {
            return null;
        }
        return Arrays.asList(propertiesInfo.split(","));
    }

    public static List<String> a() {
        String propertiesInfo = SDKLoginMgr.getInstance().getPropertiesInfo(PortalConst.STR_PARENT_CONTROL_LIMIT_LEVEL_IMG);
        LogEx.d("RatingHelper", "Parent_Control_Limit_Level_Img: " + propertiesInfo);
        if (TextUtils.isEmpty(propertiesInfo)) {
            return null;
        }
        return Arrays.asList(propertiesInfo.split(","));
    }

    public static String b(String str) {
        List<String> b2;
        List<String> a2;
        if (str == null || (b2 = b()) == null || (a2 = a()) == null) {
            return null;
        }
        int i = -1;
        for (int i2 = 0; i2 < b2.size(); i2++) {
            if (str.equals(b2.get(i2))) {
                i = i2;
            }
        }
        if (i < 0) {
            return null;
        }
        return a(a2.get(i));
    }

    public static final void a(ImageView imageView, String str) {
        com.bumptech.glide.i.b(BaseApp.e().getApplicationContext()).a(b(str)).a(imageView);
    }

    public static final String a(int i) {
        LogEx.d("RatingHelper", " [转换前] userLevel: " + i);
        if (i == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = 1 << i2;
            if ((i & i3) != 0) {
                sb.append(i3);
                sb.append(";");
            }
        }
        String substring = sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "1;2;4;8;16";
        LogEx.d("RatingHelper", " [转换后] ratingid: " + substring);
        return substring;
    }
}
