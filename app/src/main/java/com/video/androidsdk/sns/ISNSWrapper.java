package com.video.androidsdk.sns;

import android.content.Context;
import com.video.androidsdk.sns.bean.OAuth2Param;
import com.video.androidsdk.sns.bean.SNSMessage;

/* loaded from: classes.dex */
public interface ISNSWrapper {
    public static final int ErrCode_APIVERSIONNOTSUPPORT = 12;
    public static final int ErrCode_AUTHFAILED = 6;
    public static final int ErrCode_CONSTROCTIONFAILED = 5;
    public static final int ErrCode_CONTEXTINVALID = 10;
    public static final int ErrCode_NONETWORK = 153;
    public static final int ErrCode_NOSNSCLIENT = 13;
    public static final int ErrCode_NOTAUTH = 4;
    public static final int ErrCode_NOTINIT = 2;
    public static final int ErrCode_NOTRIGISTER = 3;
    public static final int ErrCode_OK = 0;
    public static final int ErrCode_PARAMINVALID = 1;
    public static final int ErrCode_REGISTERFAILED = 7;
    public static final int ErrCode_SENDFAILED = 8;
    public static final int ErrCode_SETLISTENERFAILED = 9;
    public static final int ErrCode_TOKENINVALID = 11;
    public static final int ErrCode_UNKNOW = 255;

    void authorize(Context context, ISNSAuthListener iSNSAuthListener);

    int init(Context context, OAuth2Param oAuth2Param);

    boolean isAuth();

    int sendMessage(Context context, SNSMessage sNSMessage, ISNSActionListener iSNSActionListener);
}
