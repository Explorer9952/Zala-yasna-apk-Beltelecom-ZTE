package d.e.b.l;

import android.os.Message;
import com.zte.ucs.tvcall.ocx.register.ShareAbilityCallbackInfo;
import d.e.b.n.d;
import java.util.Locale;

/* loaded from: classes2.dex */
public class b extends d.e.b.b.b implements a {

    /* renamed from: d, reason: collision with root package name */
    private final String f8066d = b.class.getSimpleName();

    @Override // d.e.b.l.a
    public void a() {
        d.a(this.f8066d, "【与服务端断链通知】java_FireServerLinkLost : SIP service is lost!");
        Message obtain = Message.obtain();
        obtain.what = 7;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.l.a
    public void a(int i, int i2, int i3) {
        int i4;
        d.a(this.f8066d, String.format(Locale.getDefault(), "【登陆结果通知】 java_FireLogonResult lResult[%d], lReason[%d], lType[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)));
        Message obtain = Message.obtain();
        obtain.arg1 = i3;
        if (i == 1 && i2 == 200) {
            obtain.what = 1;
        } else {
            if (i != 0 || i2 != 101) {
                if (i != 0 || i2 != 403) {
                    i4 = (i == 0 && i2 == 404) ? 11 : 5;
                }
                obtain.what = i4;
            }
            obtain.what = 2;
        }
        c().sendMessage(obtain);
    }

    @Override // d.e.b.l.a
    public void a(int i, String str, String str2) {
        d.a(this.f8066d, String.format(Locale.getDefault(), "【能力查询结果通知】 java_FireIMSRCSQueryShareAbility result[%d] accontid[%s] sharedAbility[%s]", Integer.valueOf(i), str, str2));
        ShareAbilityCallbackInfo shareAbilityCallbackInfo = new ShareAbilityCallbackInfo();
        shareAbilityCallbackInfo.setResult(i);
        shareAbilityCallbackInfo.setAccontid(str);
        shareAbilityCallbackInfo.setSharedAbility(str2);
        Message obtain = Message.obtain();
        obtain.what = 4;
        obtain.obj = shareAbilityCallbackInfo;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.l.a
    public void b() {
        d.a(this.f8066d, "【登出成功通知】 java_FireLogoutServerSuccess!");
        Message obtain = Message.obtain();
        obtain.what = 3;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.l.a
    public void c(int i) {
        d.a(this.f8066d, String.format(Locale.getDefault(), "【deactivated消息通知】 java_FireNotifyReLogin lReason[%d]", Integer.valueOf(i)));
        Message obtain = Message.obtain();
        obtain.what = 10;
        obtain.arg1 = i;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.l.a
    public void d(int i) {
        d.a(this.f8066d, String.format(Locale.getDefault(), "【登陆踢出通知】 java_FireAlreadyLogout lReason[%d]", Integer.valueOf(i)));
        Message obtain = Message.obtain();
        obtain.what = 6;
        c().sendMessage(obtain);
    }

    @Override // d.e.b.l.a
    public void e(String str, int i) {
        d.a(this.f8066d, String.format(Locale.getDefault(), "【登陆SS通话完成通知】 java_FireRegisterSoftPhoneToSS lpSoftPhone[%s] lType[%d]", str, Integer.valueOf(i)));
        if (i == 2) {
            Message obtain = Message.obtain();
            obtain.what = 2;
            c().sendMessage(obtain);
        } else if (i == 3) {
            Message obtain2 = Message.obtain();
            obtain2.what = 1;
            c().sendMessage(obtain2);
        } else {
            if (i != 4) {
                d.d(this.f8066d, String.format(Locale.getDefault(), "java_FireRegisterSoftPhoneToSS[%s] report unknown lType[%d], do nothing!", str, Integer.valueOf(i)));
                return;
            }
            Message obtain3 = Message.obtain();
            obtain3.what = 2;
            c().sendMessage(obtain3);
        }
    }
}
