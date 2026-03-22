package com.video.androidsdk.sns;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.video.androidsdk.log.LogEx;
import com.video.androidsdk.sns.bean.OAuth2Param;
import com.video.androidsdk.sns.bean.SNSMessage;

/* loaded from: classes.dex */
public class SNSHelper {
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

    /* renamed from: a, reason: collision with root package name */
    OAuth2Param f3813a;

    /* renamed from: b, reason: collision with root package name */
    ISNSWrapper f3814b;

    /* renamed from: c, reason: collision with root package name */
    SNSType f3815c;

    /* renamed from: d, reason: collision with root package name */
    int f3816d;

    /* renamed from: com.video.androidsdk.sns.SNSHelper$2, reason: invalid class name */
    /* loaded from: classes.dex */
    /* synthetic */ class AnonymousClass2 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3821a;

        static {
            int[] iArr = new int[SNSType.values().length];
            f3821a = iArr;
            try {
                iArr[SNSType.WEIBO_SINA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3821a[SNSType.WEIBO_TENCENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3821a[SNSType.WECHAT_FRIENDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3821a[SNSType.WECHAT_MOMENTS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3821a[SNSType.FACEBOOK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3821a[SNSType.SMS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3821a[SNSType.EMAIL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum SNSType {
        WEIBO_SINA,
        WEIBO_TENCENT,
        WECHAT_FRIENDS,
        WECHAT_MOMENTS,
        FACEBOOK,
        SMS,
        EMAIL
    }

    public SNSHelper(SNSType sNSType, OAuth2Param oAuth2Param) {
        switch (AnonymousClass2.f3821a[sNSType.ordinal()]) {
            case 1:
                this.f3814b = SNSFactory.createSNSObject(SNSFactory.WEIBO_SINA);
                break;
            case 2:
                this.f3814b = SNSFactory.createSNSObject(SNSFactory.WEIBO_TENCENT);
                break;
            case 3:
                ISNSWrapper createSNSObject = SNSFactory.createSNSObject(SNSFactory.WECHAT_FRIENDS);
                this.f3814b = createSNSObject;
                this.f3815c = sNSType;
                if (createSNSObject != null) {
                    this.f3816d = ((ITencentWechat) createSNSObject).getScene();
                    break;
                }
                break;
            case 4:
                ISNSWrapper createSNSObject2 = SNSFactory.createSNSObject(SNSFactory.WECHAT_MOMENTS);
                this.f3814b = createSNSObject2;
                this.f3815c = sNSType;
                if (createSNSObject2 != null) {
                    this.f3816d = ((ITencentWechat) createSNSObject2).getScene();
                    break;
                }
                break;
            case 5:
                this.f3814b = SNSFactory.createSNSObject(SNSFactory.FACEBOOK);
                break;
            case 6:
                this.f3814b = SNSFactory.createSNSObject(SNSFactory.SMS);
                break;
            case 7:
                this.f3814b = SNSFactory.createSNSObject("email");
                break;
        }
        this.f3813a = oAuth2Param;
    }

    public void authorize(Context context, ISNSAuthListener iSNSAuthListener) {
        ISNSWrapper iSNSWrapper = this.f3814b;
        if (iSNSWrapper != null) {
            iSNSWrapper.authorize(context, iSNSAuthListener);
        } else if (iSNSAuthListener != null) {
            iSNSAuthListener.onError(5, "SNS Implementation has not <init>");
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        SNSType sNSType = this.f3815c;
        if (sNSType == SNSType.WEIBO_SINA) {
            if (i == 32973) {
                ((ISinaWeibo) this.f3814b).authCallBack(i, i2, intent);
            }
        } else if (sNSType != SNSType.WEIBO_TENCENT && sNSType == SNSType.FACEBOOK) {
            ((IFacebook) this.f3814b).onActivityResult(i, i2, intent);
        }
    }

    public void onCreate(Intent intent, Context context, Bundle bundle) {
        SNSType sNSType = this.f3815c;
        if (sNSType == SNSType.WEIBO_SINA) {
            ((ISinaWeibo) this.f3814b).weiboListener(intent, context);
        } else if (sNSType == SNSType.FACEBOOK) {
            ((IFacebook) this.f3814b).onCreate(bundle, context);
        }
    }

    public void onDestroy() {
        if (this.f3815c == SNSType.FACEBOOK) {
            ((IFacebook) this.f3814b).onDestroy();
        }
    }

    public void onNewIntent(Intent intent, Context context) {
        if (this.f3815c == SNSType.WEIBO_SINA) {
            ((ISinaWeibo) this.f3814b).weiboListener(intent, context);
        }
    }

    public void onPause(Context context) {
        if (this.f3815c == SNSType.FACEBOOK) {
            ((IFacebook) this.f3814b).onPause(context);
        }
    }

    public void onResume(Context context) {
        if (this.f3815c == SNSType.FACEBOOK) {
            ((IFacebook) this.f3814b).onResume(context);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.f3815c == SNSType.FACEBOOK) {
            ((IFacebook) this.f3814b).onSaveInstanceState(bundle);
        }
    }

    public void sendMessage(final Activity activity, final SNSMessage sNSMessage, final ISNSActionListener iSNSActionListener) {
        if (this.f3814b == null) {
            if (iSNSActionListener != null) {
                iSNSActionListener.onFail(5, "SNS Implementation has not <init>");
                return;
            }
            return;
        }
        SNSType sNSType = this.f3815c;
        if (sNSType == SNSType.WECHAT_FRIENDS || sNSType == SNSType.WECHAT_MOMENTS) {
            ((ITencentWechat) this.f3814b).setScene(this.f3816d);
        }
        int sendMessage = this.f3814b.sendMessage(activity, sNSMessage, iSNSActionListener);
        LogEx.d("SNSHelp", "facebook: ret1" + sendMessage);
        if (2 != sendMessage) {
            if (11 == sendMessage) {
                this.f3814b.authorize(activity, new ISNSAuthListener() { // from class: com.video.androidsdk.sns.SNSHelper.1
                    @Override // com.video.androidsdk.sns.ISNSAuthListener
                    public void onCancel() {
                        ISNSActionListener iSNSActionListener2 = iSNSActionListener;
                        if (iSNSActionListener2 != null) {
                            iSNSActionListener2.onCancel();
                        }
                    }

                    @Override // com.video.androidsdk.sns.ISNSAuthListener
                    public void onComplete() {
                        SNSHelper.this.sendMessage(activity, sNSMessage, iSNSActionListener);
                    }

                    @Override // com.video.androidsdk.sns.ISNSAuthListener
                    public void onError(int i, String str) {
                        ISNSActionListener iSNSActionListener2 = iSNSActionListener;
                        if (iSNSActionListener2 != null) {
                            iSNSActionListener2.onFail(i, str);
                        }
                    }

                    @Override // com.video.androidsdk.sns.ISNSAuthListener
                    public void onException(Exception exc) {
                        ISNSActionListener iSNSActionListener2 = iSNSActionListener;
                        if (iSNSActionListener2 != null) {
                            iSNSActionListener2.onException(exc);
                        }
                    }
                });
                return;
            } else {
                if (sendMessage == 0 || iSNSActionListener == null) {
                    return;
                }
                iSNSActionListener.onFail(sendMessage, "Cannot send sns message!");
                return;
            }
        }
        int init = this.f3814b.init(activity, this.f3813a);
        LogEx.d("SNSHelp", "facebook: ret2" + init);
        if (init == 0) {
            sendMessage(activity, sNSMessage, iSNSActionListener);
        } else if (iSNSActionListener != null) {
            iSNSActionListener.onFail(init, "Init sns failed!");
        }
    }
}
